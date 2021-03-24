package connection;

import exception.EDBException;

import java.sql.*;

/**
 * Created by Suriyanarayanan K
 * on 08/03/21 11:20 AM.
 */
public class EDBConnectionEstablisher {

    String url="jdbc:edb://ec2-65-0-74-114.ap-south-1.compute.amazonaws.com:5444/sales";
    String user="enterprisedb";
    String password="Secret@123";

    public Connection createConnection() throws EDBException {
        Connection connection=null;
        try {
            Class.forName("com.edb.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Class Not Found : " + e.getMessage());
        }
        try {
            connection=DriverManager.getConnection(url , user , password);

        } catch (SQLException exception) {
            throw new EDBException(exception.getMessage());
        }
        return connection;
    }

    public ResultSet executeSql(String sqlQuery,Connection connection) throws EDBException {
        ResultSet resultSet=null;
        try {
            Statement statement=connection.createStatement();
            resultSet= statement.executeQuery(sqlQuery);
        } catch (SQLException exception) {
            throw  new EDBException(exception.getMessage());
        }
        return resultSet;
    }
}
