import java.awt.font.ShapeGraphicAttribute;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String username = "root";
        String password = "root";

        /*
        String port = "3306";
        String ip = "localhost";
        String database = "hr";
        */

        String url = "jdbc:mysql://localhost:3306/hr";
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();

            String sql = "select * from employees";

            statement.executeQuery(sql);

            ResultSet rs = statement.executeQuery(sql);

            rs.next();
            int emp_id= rs.getInt(1);
            int emp_id_otraforma = rs.getInt("employee_id");

            String jobId = rs.getString("job_id");

            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            String fullData = firstName + " " + lastName + " | " + emp_id + " | " + jobId;
            System.out.println(fullData);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}