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
    public final static String ERROR_MISSING_DOCUMENT = " missing Document";
    public final static String ERROR_MISSING_DICTIONARY_ITEM = " missing DictionaryItem";
    //endregion
}
