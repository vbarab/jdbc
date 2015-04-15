import java.sql.*;

public class Runner {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/test","sa","");
/*        Statement statement = connection.createStatement();
        boolean execute = statement.execute("CREATE TABLE CUSTOMER (ID BIGINT PRIMARY KEY  AUTO_INCREMENT, NAME VARCHAR (127))");
        System.out.println("execut = " + execute);
        statement.close();*/
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO CUSTOMER VALUES (DEFAULT ,?)");
        preparedStatement.setString(1 , "name2");
        int i = preparedStatement.executeUpdate();
        System.out.println("i = " + i);
        connection.close();

    }
}
