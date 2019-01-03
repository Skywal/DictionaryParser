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
public class DictionaryDao {
    //region fields
    protected Properties properties;
    protected String urlPath;
    protected String username;
    protected String password;
    //endregion

    //region construct
    public DictionaryDao(){
        initialize();
    }

    public void initialize(){
        properties = new Properties();
    }
    //endregion

    //region internal
    private Connection getConnection() throws SQLException, IOException{
        Properties properties = new Properties();
        try(InputStream inputStream = Files.newInputStream(Paths.get(Strings.PROPERTY_FILENAME))) {
            properties.load(inputStream);

        }
        urlPath = properties.getProperty(Strings.PROPERTY_NAME_URL);
        username = properties.getProperty(Strings.PROPERTY_NAME_USERNAME);
        password = properties.getProperty(Strings.PROPERTY_NAME_PASSWORD);

        return DriverManager.getConnection(urlPath, username, password);
    }
    //endregion

    //region external
    public void connect(DictionaryItem dictionaryItem){
        try {
            //this try catch block will close automatically
            try (
                    Connection connection = getConnection();
                    Statement statement = connection.createStatement()
                    ){

                statement.executeUpdate("INSERT INTO WordList(Word, TranscriptionUk, TranscriptionUs, Definition) VALUES (" +
                        "'"+dictionaryItem.getWord()+"'," +
                        "'" + dictionaryItem.getTranscriptionUk() + "'," +
                        "'" + dictionaryItem.getTranscriptionUs() + "'," +
                        "'" + dictionaryItem.getDefinition() +"');"); // + dictionaryItem.getDefinition() +
            }

        } catch (Exception ex){
            System.out.println(Strings.ERROR_CANT_OPEN_DATABASE);
            System.out.println(ex);
        }
    }


    //endregion
}
