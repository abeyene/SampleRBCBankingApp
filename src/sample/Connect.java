/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sample;

/**
 *
 * @author abelbeyene
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class Connect {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static boolean authenticate(String username, String password) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://192.168.2.64:3306/sampleDatabase","abeyene","elephant");
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM sampleDatabase.table1");

            resultSet.next();
            String expected_user = resultSet.getString("username");
            String expected_password = resultSet.getString("password");
            

            return username.equals(expected_user) && password.equals(expected_password);

        } catch (Exception e) {

            throw e;
        } finally {
            close();
        }

    }


    private static void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
