/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */

package backend.data;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public final class Database 
{
    private static Database theInstance;
    public static Database instance()
    {
        if(theInstance == null)
        {
            theInstance = new Database();
        }
        return theInstance;
    }
    
    public static String PROPERTIES_FILE_NAME = "prop.properties";
    Connection cnx;
    
    public Database()
    {
        cnx = this.getConnection();
    }
    
    public Connection getConnection()
    {
        try 
        {
            Properties pro = new Properties();
            URL resourceUrl = getClass().getResource(PROPERTIES_FILE_NAME);
            File file = new File(resourceUrl.toURI());    
             pro.load(new BufferedInputStream(new FileInputStream(file)));
            
            String driver = pro.getProperty("database_driver");
            String server = pro.getProperty("database_server");
            String port = pro.getProperty("database_port");
            String user = pro.getProperty("database_user");
            String password = pro.getProperty("database_password");
            String database = pro.getProperty("database_name");
      
            String URL_conexion = "jdbc:mysql://"+server+":"+port+"/"+database+"?user="+user+"&password="+
                    password+"&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            Class.forName(driver).newInstance();
            return DriverManager.getConnection(URL_conexion);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        return null;
    }
    
    public PreparedStatement prepareStatement(String statement) throws SQLException 
    {
    return cnx.prepareStatement(statement);
    }
    public int executeUpdate(PreparedStatement statement) 
    {
        try 
        {
            statement.executeUpdate();
            return statement.getUpdateCount();
        } catch (SQLException ex)
        {
            return 0;
        }
    }
    public ResultSet executeQuery(PreparedStatement statement)
    {
        try 
        {
            return statement.executeQuery();
        }
        catch (SQLException ex)
        {
        }
        return null;
    }    
}




