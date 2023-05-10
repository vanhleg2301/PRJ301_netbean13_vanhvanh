/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Category;
import model.Product;
import model.User;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

//    private List<Account> accounts;
//    public List<Account> getAccounts() {
//        return accounts;
//    }
    public boolean existed(String email) {
        String sql = "select * from FinalProject.dbo.[Account] where [Email]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    //register
    public boolean register(Account a) {
        String sql = "insert into FinalProject.dbo.[Account](AccountID,Email,[Password],CustomerID,EmployeeID,[Role]) values(?,?,?,?,?,2)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getUserID());
            st.setString(2, a.getEmail());
            st.setString(3, a.getPassword());
            st.setString(4, a.getCustomerID());
            st.setString(5, a.getEmployeeID());
            st.setInt(6, a.getRole());
            st.executeUpdate();       
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
//    public static void main(String[] args) {
//        DAO dao = new DAO();
//        Account a1 = new Account("cust5@gmail.com", "123", "2002", "2023", 2);
//        dao.register(a1);
//        System.out.println(a1);
//    }

    //login
    public Account check(String email, String password) {
        String sql = "select * from FinalProject.dbo.Account where Email=? and Password=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Account(rs.getString("AccountID"),
                        rs.getString("Email"),
                        rs.getString("Password"),
                        rs.getInt("Role"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

//    public static void main(String[] args) {
//        DAO a1 = new DAO();
//        Account a2 = a1.check("cust1@gmail.com", "123");
//        System.out.println(a2);
//    }
    // change password
    public boolean change(Account a) {
        String sql = "Update FinalProject.dbo.[Account] set [Password]=? where [Email]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getPassword());
            st.setString(2, a.getEmail());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    // get profile
    public Account getProfile() {
        String sql = "SELECT [Email],[CustomerID],[EmployeeID] FROM FinalProject.dbo.[Account] where [Email] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(2, "Email");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Account(rs.getString(2), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
//    public static void main(String[] args) {
//        DAO p1 = new DAO();
//        Account p2 = p1.getProfile();
//        System.out.println(p2);
//    }

    //get all products
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from FinalProject.dbo.[Product]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //get feature products
    public List<Product> getFeatureProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "select Top 4 * from FinalProject.dbo.[Product]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //get lastest products
    public List<Product> getLastestProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "select Top 4 * from FinalProject.dbo.[Product] Order By CategoryID desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //get all categories
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from FinalProject.dbo.[Category]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt("cID"),
                        rs.getString("cName")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Category getCategoryByID(int id) {
        String sql = "select * from FinalProject.dbo.[Product] where [CateID] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return (new Category(rs.getInt("cID"),
                        rs.getString("cName")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //get product detail
    public Product getProductDetail(int id) {
        String sql = "select * from FinalProject.dbo.[Product] where [CateID] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product c = new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //get related product
    public List<Product> getRelatedProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from FinalProject.dbo.[Product] where [CategoryID] = '1' "
                + "or [CategoryID] = '2' "
                + "or [CategoryID] = '3' "
                + "or [CategoryID] = '4'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //get all product by cid
    public List<Product> getAllProductByCateID(String cid) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from FinalProject.dbo.[Product] where [CateID] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // search by name
    public List<Product> searchByTitle(String name) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from FinalProject.dbo.[Product] where [CategoryName] like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + name + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    //search by price
    public List<Product> searchByPrice(int fPrice, int tPrice) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from FinalProject.dbo.[Product] where Price between ? and ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, fPrice);
            st.setInt(2, tPrice);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    // sort by price ASC
    public List<Product> SortByPriceAsc() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from FinalProject.dbo.[Product] Order By Price ASC";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // sort by price DESC
    public List<Product> SortByPriceDesc() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from FinalProject.dbo.[Product] Order By Price DESC";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // sort by price ASC oder by cid
    public List<Product> SortByPriceAsc(int cateID) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from FinalProject.dbo.[Product] where CateID = ? Order By Price ASC";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cateID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // sort by price DESC order by cid
    public List<Product> SortByPriceDes(int cateID) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from FinalProject.dbo.[Product] where CateID = ? Order By Price DESC";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cateID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // sort by name A - Z
    public List<Product> SortByNameAsc() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from FinalProject.dbo.[Product] Order By [CategoryName] ASC";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // sort by name Z - A
    public List<Product> SortByNameDesc() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from FinalProject.dbo.[Product] Order By [CategoryName] DESC";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // get list of product order by ID desc
    public List<Product> getAllProductByDescId() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from FinalProject.dbo.[Product] Order By [CategoryID] Desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //add product 
    public void addProduct(double price, String name,String description, String image, int cateID, int sellID) {
        String sql = "insert into FinalProject.dbo.[Product]([Price],CategoryName,Description,[Picture],CateID, SellID) values(?,?,?,?,?,?) ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDouble(1, price);
            st.setString(2, name);
            st.setString(3, description);
            st.setString(4, image);
            st.setInt(5, cateID);
            st.setInt(6, sellID);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
//    public static void main(String[] args) {
//        DAO dao = new DAO();
//        dao.addProduct(120000, "LG", "Nice", "images/product-10.jpg", 9, 1);
//    }

    // delete product
    public void delete(int id) {
        String sql = "delete from Product where [CateID] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // update product
    public void updateProduct(Product a) {
        String sql = "update FinalProject.dbo.[Product] SET [Price] = ?, [CategoryName] = ?, [Description] = ?, [Picture] = ?, [SellID] = ? WHERE CateID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDouble(1, a.getPrice());
            st.setString(2, a.getName());
            st.setString(3, a.getDescription());
            st.setString(4, a.getImage());
            st.setInt(5, a.getCateID());
            st.setInt(6, a.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
        public static void main(String[] args) {
        DAO dao = new DAO();
        dao.updateProduct(new Product(7, 8050000, "LG", "VIP", "images/product-7.jpg", 1));
    }


    // split page
    public int getNumberPage() {
        String sql = "select count(*) from FinalProject.dbo.[Product]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = 0;
                countPage = total / 12;
                if (total % 12 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public List<Product> getPaging(int index) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from FinalProject.dbo.[Product] order by [CategoryID]\n"
                + "OFFSET ? ROWS \n"
                + "FETCH FIRST 12 ROWS ONLY";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, (index - 1) * 12);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
            return list;
        } catch (SQLException e) {
        }
        return null;
    }

//    public static void main(String[] args) {
//        DAO dao = new DAO();
//        List<Product> listp = dao.getAllProduct();
//        System.out.println(listp.get(0).getCateID());
//    }
}
