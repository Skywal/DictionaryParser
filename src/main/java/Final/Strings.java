package Final;

/**
 * All text constants
 */
public class Strings {
    //region URL
    /**
     * Body of URL for Longman dictionary english-english part
     */
    public final static String URL_BASE_DICTIONARY = "https://dictionary.cambridge.org/dictionary/english/";
//            "https://www.ldoceonline.com/dictionary/";
    //endregion

    //region File source
    public final static String PATH_TO_WORDS_LOCAL_SOURCE = "source/sourceWords.txt";
    //endregion

    //region Text containers names
    /**
     * container for word text
     */
    public final static String SPAN_HW = "span.hw"; //container for word text
    /**
     * parent container for UK transcription text
     */
    public final static String SPAN_UK = "span.uk"; //parent container for UK transcription text
    /**
     * parent container for US transcription text
     */
    public final static String SPAN_US = "span.us"; //parent container for US transcription text
    /**
     * transcription text container
     */
    public final static String SPAN_IPA = "span.ipa"; //transcription text container
    /**
     * parent container for definition text
     */
    public final static String DIV_SENSE_BODY = "div.sense-body"; //parent container for definition text
    /**
     * definition text container
     */
    public final static String DIV_DEF_BLOCK_PAD_INDENT = "div.def-block.pad-indent"; //definition text container
    //endregion

    //region Error messages
    public final static String ERROR_MISSING_DOCUMENT = " missing Document ";
    public final static String ERROR_MISSING_DICTIONARY_ITEM = " missing DictionaryItem ";
    public final static String ERROR_MISSING_TARGET_ITEM_CONTAINER = " missing TargetItemContainer ";
    public final static String ERROR_MISSING_PARENT_CONTAINER = " missing ParentContainer for word ";

    public final static String ERROR_CANT_OPEN_DATABASEPROPERTIES = "Can't open database.properties file";
    public final static String ERROR_CANT_OPEN_DATABASE = "Can't open database";
    //endregion

    //region Database Access Object
    public final static String PROPERTY_NAME_URL = "url";
    public final static String PROPERTY_NAME_USERNAME = "username";
    public final static String PROPERTY_NAME_PASSWORD = "password";
    public final static String PROPERTY_FILENAME =  "database.properties";
    //endregion
}
