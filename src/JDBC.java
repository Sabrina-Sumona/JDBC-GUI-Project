import java.sql.*;

public class JDBC {
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

    public void insertStudent(int std_id, String std_name, String department, int batch) throws SQLException {
        this.connection = this.getConnection();

        this.preparedStatement = this.connection.prepareStatement(
                "INSERT INTO student_info (std_id, std_name, department, batch) VALUES (?,?,?,?)"
        );

        //        here 1st '?' will be replaced by value of index 1, then 2nd one by index 2 and so on....
        this.preparedStatement.setInt(1, std_id);
        this.preparedStatement.setString(2, std_name);
        this.preparedStatement.setString(3, department);
        this.preparedStatement.setInt(4, batch);

        int affectedRows = this.preparedStatement.executeUpdate();
        System.out.println("-----------------------------------------------");
        System.out.println(affectedRows + " student's data has inserted into students database...");

        this.connection.close();
        this.preparedStatement.close();
    }

}
