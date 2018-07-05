/*
 * Copyright (c) 2018 Abel Beyene
 * All rights reserved
 *
 * This file is part of SampleRBCBankingApp.
 *
 *  SampleRBCBankingApp is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  SampleRBCBankingApp is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Foobar.  If not, see <https://www.gnu.org/licenses/>.
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
