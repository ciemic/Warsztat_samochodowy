package pl.coderslab.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBService {

    public static Connection connect(String database) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ;

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + database + "?useUnicode=true" +
                        "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" +
                        "&useSSL=false",
                "root",
                "coderslab");
    }


    public static int numberOfRows(ResultSet rs) throws SQLException {
        int rowCount = 0;
        if (rs.last()) {
            rowCount = rs.getRow();
            rs.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        return rowCount;

    }


    public static ResultSet executeSelectQuery(String database, String query, List<String> params) {
        ResultSet result = null;
        try (Connection conn = connect(database)) {
            PreparedStatement prep = conn.prepareStatement(query);

            int paramNumber = 1;
            for (String param : params) {
                prep.setString(paramNumber, param);
                paramNumber++;
            }

            result = prep.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public static List<Object> executeSingleSelect(String database, String query, List<String> params) {
        List<Object> objects = new ArrayList<>();
        try (Connection conn = connect(database)) {
            PreparedStatement prep = conn.prepareStatement(query);

            int paramNumber = 1;
            for (String param : params) {
                prep.setString(paramNumber, param);
                paramNumber++;
            }
            ResultSet result = prep.executeQuery();
            ResultSetMetaData rsmd = result.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            Map<String, String> column = new HashMap<>();

            while (result.first()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = result.getString(i);
                    String columnName = rsmd.getColumnName(i);
                    column.put(columnName, columnValue);
                    objects.add(column);
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return objects;
    }


    public static void executeUpdate(String database, String query, List<String> params) {
        try (Connection con = connect(database)) {
            PreparedStatement prep = con.prepareStatement(query);

            for (int i = 0; i < params.size(); i++) {
                prep.setString(i + 1, params.get(i));
            }

            prep.executeUpdate();
            System.out.println("executeUpdate wykonany");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
