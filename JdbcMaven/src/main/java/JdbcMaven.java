import java.sql.*;

public class JdbcMaven {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        ResultSet resultSet;
        Statement statement;
        String Query1 = "SELECT p.FIO, p.AGE from Student as s inner join Person as p on " +
                "s.ID_PERSON= p.id";
        String Query2 = "SELECT u.FIRST_NAME, u.LAST_NAME from Student as s inner join Person as p on " +
                "s.ID_PERSON= p.id inner join User as u on p.FIO = u.LAST_NAME";
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:D:/MyDB/test.db");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Query1
            );
            while (resultSet.next())
            {
                System.out.println(resultSet.getString("FIO") +" "+ resultSet.getInt("AGE"));
            }
            resultSet = statement.executeQuery(Query2);
            while (resultSet.next())
            {
                System.out.println(resultSet.getString("FIRST_NAME") +" "
                        + resultSet.getString("LAST_NAME"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                connection.close();
            }
        }

    }
}
