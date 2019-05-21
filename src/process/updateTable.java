/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import data.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Phat Tai
 */
public class updateTable {

    public static PreparedStatement ps = null; // biến thực thi sql
    public static ResultSet rs = null; // kết quả trả về dạng 1 bảng hay 1 dòng dữ liệu
    public static Connection conn = Connect.getConnection(); // lấy từ lớp cơ bản kết nối Data

    // hàm nạp dữ liệu cho bảng
    public static void loadData(String sql, JTable tb) {
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));
            // nạp dữ liệu lên bảng mà mình truyền vào
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", 1);
        }
    }

    // hàm đổ 1 dòng dữ liệu từ bảng lên textfield
    public static ResultSet showTextField(String sql) {
        try {
            ps = conn.prepareStatement(sql);
            return ps.executeQuery();
            // trả về 1 dòng dữ liệu đọc được
        } catch (Exception e) {
            return null;
        }
    }
}
