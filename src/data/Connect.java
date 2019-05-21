    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Phat Tai
 */
public class Connect {

    public static Connection getConnection() {
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyQuanCafeFinal;user=sa;password=123";
            Connection conn = DriverManager.getConnection(dbURL);
            return conn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Kết nối cơ sở dữ liệu thất bại", "Thông báo", 2);
            exit(0);
            return null;
        }
    }
}
