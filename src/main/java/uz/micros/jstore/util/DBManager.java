package uz.micros.jstore.util;

import uz.micros.jstore.entity.blog.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by java on 04.06.14.
 */
public class DBManager {
    private static Connection connect() {
        System.out.println("JDBC");

        Connection res = null;

        try {
            //Class.forName("org.postgresql.Driver");
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            res = DriverManager.getConnection("jdbc:mysql://localhost:3306/jstore", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static List<Map<String, Object>> runQuery(String query) {
        Connection con = connect();
        List<Map<String, Object>> ls = new ArrayList<>();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            ls=parseList2(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ls;
    }

    private static List<Post> parseList(ResultSet rs) throws SQLException {
        List<Post> ls = new ArrayList<Post>();
        while (rs.next()) {
            Post p = new Post();
            p.setId(rs.getInt(1));
            p.setSubject(rs.getString(2));
            p.setDate(rs.getDate(3));
            p.setText(rs.getString(4));
            ls.add(p);
        }
        return ls;
    }

    private static List<Map<String, Object>> parseList2(ResultSet rs) throws SQLException {
        List<Map<String, Object>> res = new ArrayList<>();

        ResultSetMetaData meta = rs.getMetaData();
        int cols = meta.getColumnCount();
        while (rs.next()) {
            Map<String, Object> columns = new LinkedHashMap<>();
            for(int i=1; i<=cols; i++) {
                columns.put(meta.getColumnLabel(i), rs.getObject(i));
            }
            res.add(columns);
        }

        return res;
    }
}
