package balcorpfw.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author balbino aylagas
 */
public class DatabaseX 
{
    //primero las variables de instancia
    private Connection connection;
    private Statement statement;
    private String connectionString;
    
    //ahora creamos el constructor vacio

    public DatabaseX() 
    {
        //primero creamos la conexion a la bd
        //este metodo no esta creado asi que lo crearemos en este 
        //momento
        setConnectionString(null);
        setConnection( createConnection() );
        //ahora que ya tenemos una conexion vamos por el statement
        setStatement( createStatement() );
    }

    public DatabaseX(String pConnectionString) 
    {
        //primero creamos la conexion a la bd
        //este metodo no esta creado asi que lo crearemos en este 
        //momento
        setConnectionString(pConnectionString);
        setConnection( createConnection() );
        //ahora que ya tenemos una conexion vamos por el statement
        setStatement( createStatement() );
    }

    
    //ahora creamos metodos get y set para cada uno
    public Connection getConnection() {
        return connection;
    }

    private void setConnection(Connection pConnection) {
        this.connection = pConnection;
    }

    public Statement getStatement() {
        return statement;
    }

    private void setStatement(Statement pStatement) {
        this.statement = pStatement;
    }

    public String getConnectionString() {
        return connectionString;
    }

    private void setConnectionString(String pConnectionString) {
        this.connectionString = pConnectionString;
    }

    private Connection createConnection() 
    {
        //debe devolver una connection object
        Connection localConnection = getConnection();
        String localConnectionString = getConnectionString();
        if(localConnection==null)
        {
            try 
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                if(localConnectionString!=null && !localConnectionString.equals(""))
                {
                    localConnection = DriverManager.getConnection(localConnectionString);
                }
                else
                {
                    localConnection = DriverManager.getConnection("jdbc:mysql://localhost/"
                        + "personalfinancedb?"
                        + "user=root&password=12345&autoReconnect=true&useSSL=false");
                }
            } 
            catch (ClassNotFoundException | SQLException ex) 
            {
                Logger.getLogger(DatabaseX.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return localConnection;
    }

    private Statement createStatement() 
    {
        //este metodo debe devolver un statement
        //y debemos conseguir la conexion
        Statement localStatement = getStatement();
        Connection localConnection = getConnection();
        if(localStatement == null)
        {
            try 
            {
                if(!localConnection.isClosed())
                {
                    localStatement = localConnection.createStatement();
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(DatabaseX.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return localStatement;
    }

    public boolean executeNonQueryBool(String pSql) 
    {
        boolean hasFailed = true;
        Statement localStatement = getStatement();
        if(localStatement!=null)
        {
            try 
            {
                hasFailed = localStatement.execute(pSql);
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(DatabaseX.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return hasFailed;
    }

    public int executeNonQueryRows(String pSql) 
    {
        int rows = 0;
        Statement localStatement = getStatement();
        if(localStatement!=null)
        {
            try 
            {
                rows = localStatement.executeUpdate(pSql);
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(DatabaseX.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return rows;        
    }

    public ResultSet executeQuery(String pSql) 
    {
        ResultSet result = null;
        Statement localStatement = getStatement();
        if(localStatement!=null)
        {
            try 
            {
                result = localStatement.executeQuery(pSql);
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(DatabaseX.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return result;         
    }
    
}
