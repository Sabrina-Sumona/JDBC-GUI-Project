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

    public String viewStudent(int std_id) throws SQLException {
        this.connection = this.getConnection();

        this.preparedStatement = this.connection.prepareStatement(
                "SELECT * FROM `student_info` WHERE std_id = ?"
        );

        this.preparedStatement.setInt(1, std_id);

        this.resultSet = this.preparedStatement.executeQuery();
        int id = 0;
        String name = null;
        int btc = 0;
        String dept = null;
        while (resultSet.next()) {
            id = Integer.parseInt(this.resultSet.getString("std_id"));
            name = this.resultSet.getString("std_name");
            btc = Integer.parseInt(this.resultSet.getString("batch"));
            dept = this.resultSet.getString("department");
        }

        String res = "";
        if(name == null){
            res = "Sorry!\nStudent has not been found.";

        } else {
            res = "Student has been found.\n\nID: " + id + "\n\nName: " + name + "\n\nBatch: " + btc + "\n\nDepartment: " + dept;
        }

        this.connection.close();
        this.preparedStatement.close();

        return res;
    }

    public void updateStudent(int std_id, String std_name, String department, int batch) throws SQLException {
        this.connection = this.getConnection();

        this.preparedStatement = this.connection.prepareStatement(
                "UPDATE `student_info` SET `std_name` = ?, `department` = ?, `batch` = ? WHERE `std_id` = ?"
        );

        this.preparedStatement.setString(1, std_name);
        this.preparedStatement.setString(2, department);
        this.preparedStatement.setInt(3, batch);
        this.preparedStatement.setInt(4, std_id);

        int affectedRows = this.preparedStatement.executeUpdate();
        System.out.println("-----------------------------------------------");
        System.out.println(affectedRows + " student's data has updated into students database...");

        this.connection.close();
        this.preparedStatement.close();
    }

    public String deleteStudent(Integer std_id) throws SQLException {
        this.connection = this.getConnection();

        this.preparedStatement = this.connection.prepareStatement(
                "    DELETE FROM `student_info` WHERE `student_info`.`std_id` = ?;"
        );

        this.preparedStatement.setInt(1, std_id);

        int affectedRows = this.preparedStatement.executeUpdate();

        String res = "";

        if(affectedRows == 0){
            res = "Sorry!\nStudent has not been found.";

        } else {
            res = "Student has been deleted SuccessFully.";
        }

        this.connection.close();
        this.preparedStatement.close();

        return res;
    }
}
