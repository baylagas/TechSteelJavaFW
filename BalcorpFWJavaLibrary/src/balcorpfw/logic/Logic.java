package balcorpfw.logic;

import balcorpfw.database.DatabaseX;

/**
 *
 * @author balbino aylagas
 */
public abstract class Logic 
{
    private DatabaseX database;
    private String connectionString;

    //ahora vamos con el constructor
    public Logic() 
    {
        setConnectionString(null);
        setDatabase( createDatabase() );
    }
    
    public Logic(String pConnectionString) 
    {
        setConnectionString(pConnectionString);
        setDatabase( createDatabase() );
    }
    
    //listos metodos get y set
    public DatabaseX getDatabase() {
        return database;
    }

    private void setDatabase(DatabaseX pDatabase) {
        this.database = pDatabase;
    }

    public String getConnectionString() {
        return connectionString;
    }

    private void setConnectionString(String pConnectionString) {
        this.connectionString = pConnectionString;
    }

    private DatabaseX createDatabase() 
    {
        DatabaseX localDatabase = getDatabase();
        String localConnectionString = getConnectionString();
        if(localDatabase==null)
        {
            localDatabase = new DatabaseX(localConnectionString);
        }
        return localDatabase;
    }
    
}
