package DAO;

import Content.DictionaryItem;
import Final.Strings;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;


/**
 * jdbc:mysql:...?serverTimezone=Europe/Kiev&useSSL=false&useUnicode=yes&characterEncoding=UTF-8
 */
public class DictionaryDAO {
    //region fields
    /**
     * file with database connection properties
     */
    protected Properties properties; //file with database connection properties
    /**
     * path to database
     */
    protected String urlPath; //path to database
    /**
     * login username for database
     */
    protected String username; //login username for database
    /**
     * login password for database
     */
    protected String password; //login password for database
    //endregion

    //region construct
    /**
     * build Data Access Object for dictionary
     */
    public DictionaryDAO(){
        initialize();
    }

    private void initialize(){
        properties = new Properties();
    }
    //endregion

    //region internal

    /**
     * build connection to database with local stored properties
     * @return gained Connection to database
     * @throws SQLException
     * @throws IOException
     */
    private Connection makeConnection() throws SQLException, IOException{
        loadProperties();
        readCurrentProperties(properties);
        return DriverManager.getConnection(urlPath, username, password);
    }

    /**
     * load locally stored properties
     * @throws IOException
     */
    private void loadProperties() throws IOException{
        InputStream inputStream = Files.newInputStream(Paths.get(Strings.PROPERTY_FILENAME));
        properties.load(inputStream);
    }

    /**
     * read properties to a local variables
     * @param properties object builded from local file
     */
    private void readCurrentProperties(Properties properties){
        urlPath = properties.getProperty(Strings.PROPERTY_NAME_URL);
        username = properties.getProperty(Strings.PROPERTY_NAME_USERNAME);
        password = properties.getProperty(Strings.PROPERTY_NAME_PASSWORD);
    }

    /**
     * statement for insertion into table WordList
     * @param word
     * @param transcriptionUk
     * @param transcriptionUs
     * @param definition
     * @return Sql statement in String format
     */
    private String statementInsert(String word, String transcriptionUk, String transcriptionUs, String definition){
        return "INSERT INTO WordList(Word, TranscriptionUk, TranscriptionUs, Definition) VALUES (" +
                "'" + word + "'," +
                "'" + transcriptionUk + "'," +
                "'" + transcriptionUs + "'," +
                "'" + definition +"');";
    }
    //endregion

    //region external

    /***
     * Set up connection to database and write dictionaryItem into database table WordList
     * @param dictionaryItem
     */
    public void connectInsert(DictionaryItem dictionaryItem){
        try {
            //this try catch block will close automatically
            try (Connection connection = makeConnection();
                 Statement statement = connection.createStatement()
                    ){

                statement.executeUpdate(statementInsert(
                        dictionaryItem.getWord(),
                        dictionaryItem.getTranscriptionUk(),
                        dictionaryItem.getTranscriptionUs(),
                        dictionaryItem.getDefinition()
                ));
            }

        } catch (Exception ex){
            System.out.println(Strings.ERROR_CANT_OPEN_DATABASE);
            System.out.println(ex);
        }
    }


    //endregion
}
