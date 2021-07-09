import java.sql.*;

public class JDBC2 {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private final String url = "jdbc:mysql://localhost:3306/students";
    private final String username = "sabrina_sumona";
    private final String password = "sns963147";

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void insertBook(int book_id, String book_name, String author, int price) throws SQLException {
        this.connection = this.getConnection();

        this.preparedStatement = this.connection.prepareStatement(
                "INSERT INTO book_info (book_id, book_name, author, price) VALUES (?,?,?,?)"
        );

        this.preparedStatement.setInt(1, book_id);
        this.preparedStatement.setString(2, book_name);
        this.preparedStatement.setString(3, author);
        this.preparedStatement.setInt(4, price);

        int affectedRows = this.preparedStatement.executeUpdate();
        System.out.println("-----------------------------------------------");
        System.out.println(affectedRows + " book's data has inserted into students database...");

        this.connection.close();
        this.preparedStatement.close();
    }

    public String viewBook(int book_id) throws SQLException {
        this.connection = this.getConnection();

        this.preparedStatement = this.connection.prepareStatement(
                "SELECT * FROM `book_info` WHERE book_id = ?"
        );

        this.preparedStatement.setInt(1, book_id);

        this.resultSet = this.preparedStatement.executeQuery();
        int id = 0;
        String name = null;
        int price = 0;
        String author = null;
        while (resultSet.next()) {
            id = Integer.parseInt(this.resultSet.getString("book_id"));
            name = this.resultSet.getString("book_name");
            price = Integer.parseInt(this.resultSet.getString("price"));
            author = this.resultSet.getString("author");
        }

        String res = "";
        if(name == null){
            res = "Sorry!\nBook has not been found.";

        } else {
            res = "Book has been found.\n\nID: " + id + "\n\nName: " + name + "\n\nPrice: " + price + "\n\nAuthor: " + author;
        }

        this.connection.close();
        this.preparedStatement.close();

        return res;
    }

    public void updateBook(int book_id, String book_name, String author, int price) throws SQLException {
        this.connection = this.getConnection();

        this.preparedStatement = this.connection.prepareStatement(
                "UPDATE `book_info` SET `book_name` = ?, `author` = ?, `price` = ? WHERE `book_id` = ?"
        );

        this.preparedStatement.setString(1, book_name);
        this.preparedStatement.setString(2, author);
        this.preparedStatement.setInt(3, price);
        this.preparedStatement.setInt(4, book_id);

        int affectedRows = this.preparedStatement.executeUpdate();
        System.out.println("-----------------------------------------------");
        System.out.println(affectedRows + " book's data has updated into students database...");

        this.connection.close();
        this.preparedStatement.close();
    }

    public String deleteBook(Integer book_id) throws SQLException {
        this.connection = this.getConnection();

        this.preparedStatement = this.connection.prepareStatement(
                "    DELETE FROM `book_info` WHERE `book_info`.`book_id` = ?;"
        );

        this.preparedStatement.setInt(1, book_id);

        int affectedRows = this.preparedStatement.executeUpdate();

        String res = "";

        if(affectedRows == 0){
            res = "Sorry!\nBook has not been found.";

        } else {
            res = "Book has been deleted SuccessFully.";
        }

        this.connection.close();
        this.preparedStatement.close();

        return res;
    }
}
