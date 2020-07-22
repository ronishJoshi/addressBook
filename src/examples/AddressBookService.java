package examples;



import examples.AddressBook;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SONY
 */
public class AddressBookService {

    List<AddressBook> addressBooks = new ArrayList<AddressBook>();

    /**
     * Adds address book to the database.
     *
     * @param addressBook
     */
    public void addAddressBook(AddressBook addressBook) {
        String qry = "INSERT INTO `address_book`(`first_name`, `last_name`, `address`, `telephone_number`, `mobile_number`, `email`) VALUES (?,?,?,?,?,?)";
        try {
            Connection con = new DBConnection().getConnection();
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, addressBook.getFirstName());
            pst.setString(2, addressBook.getLastName());
            pst.setString(3, addressBook.getAddress());
            pst.setLong(4, addressBook.getTelephoneNumber());
            pst.setLong(5, addressBook.getMobileNumber());
            pst.setString(6, addressBook.getEmail());

            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isDuplicate(Long id, AddressBook addressBook) {
        String qry = "Select count(*) from address_book where mobile_number = ? or email = ? and id <> ?";

        Connection con = DBConnection.getConnection();
        PreparedStatement pst;
        try {
          
            pst = con.prepareStatement(qry);
            pst.setLong(1, addressBook.getMobileNumber());
            pst.setString(2, addressBook.getEmail());
            pst.setLong(3, id);

            ResultSet rs = pst.executeQuery();

            List<AddressBook> addressBooks = new ArrayList<AddressBook>();

            while (rs.next()) {
                Long count = rs.getLong(1);
                
                return count >= 1;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return false;
    }
    
    public boolean isDuplicate(AddressBook addressBook) {
        String qry = "Select count(*) from address_book where mobile_number = ? or email = ?";

        Connection con = DBConnection.getConnection();
        PreparedStatement pst;
        try {
          
            pst = con.prepareStatement(qry);
            pst.setLong(1, addressBook.getMobileNumber());
            pst.setString(2, addressBook.getEmail());

            ResultSet rs = pst.executeQuery();

            List<AddressBook> addressBooks = new ArrayList<AddressBook>();

            while (rs.next()) {
                Long count = rs.getLong(1);
                
                return count >= 1;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return false;
    }
    
    /**
     * Returns all address book from the database.
     *
     * @return
     */
    public List<AddressBook> getAddressBooks(String searchText) {
        String qry = "Select * from address_book ";

        Connection con = DBConnection.getConnection();
        PreparedStatement pst;
        try {
            if(!searchText.trim().isEmpty()){
                qry += "where first_name like ? or last_name like ? or address like ? or telephone_number like ? or mobile_number like ? or email like ?";
            }
            pst = con.prepareStatement(qry);
            if(!searchText.trim().isEmpty()){
                            pst.setString(1, "%"+ searchText +"%");
                            pst.setString(2, "%"+ searchText +"%");
                            pst.setString(3, "%"+ searchText +"%");
                            pst.setString(4, "%"+ searchText +"%");
                            pst.setString(5, "%"+ searchText +"%");
                            pst.setString(6, "%"+ searchText +"%");
            }

            ResultSet rs = pst.executeQuery();

            List<AddressBook> addressBooks = new ArrayList<AddressBook>();

            while (rs.next()) {
                AddressBook addressBook = new AddressBook();
                addressBook.setId(rs.getLong("id"));
                addressBook.setFirstName(rs.getString("first_name"));
                addressBook.setLastName(rs.getString("last_name"));
                addressBook.setAddress(rs.getString("address"));
                addressBook.setTelephoneNumber(rs.getLong("telephone_number"));
                addressBook.setMobileNumber(rs.getLong("mobile_number"));
                addressBook.setEmail(rs.getString("email"));

                addressBooks.add(addressBook);
            }

            return addressBooks;

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    public void updateBook(Long id, AddressBook addressBookToUpdate) {
        String qry = "UPDATE `address_book` SET `first_name`=?,`last_name`=?,`address`=?,`telephone_number`=?,`mobile_number`=?,`email`=? WHERE `id`=?";

        try {
            Connection con = new DBConnection().getConnection();
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, addressBookToUpdate.getFirstName());
            pst.setString(2, addressBookToUpdate.getLastName());
            pst.setString(3, addressBookToUpdate.getAddress());
            pst.setLong(4, addressBookToUpdate.getTelephoneNumber());
            pst.setLong(5, addressBookToUpdate.getMobileNumber());
            pst.setString(6, addressBookToUpdate.getEmail());
            pst.setLong(7, id);

            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAddressBookById(Long id) {
        String qry = "DELETE FROM `address_book` WHERE `id` = ?";

        try {
            Connection con = new DBConnection().getConnection();
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setLong(1, id);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
