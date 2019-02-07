package OnlineWork;

import Content.DictionaryItem;
import OnlineWork.Parsing.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * this class subscriber of the Parser and define parsing methods
 */
public class DictionaryParser {
    //region fields
    /**
     * downloaded web-page to work with
     */
    protected Document webPage; //downloaded web-page to work with
    /**
     * parsed information
     */
    protected DictionaryItem item; // parsed information
    private Parser parseWord;
    /**
     * parse method for getting UK transcription
     */
    private Parser parseTranscriptionUk; //parse method for getting UK transcription
    /**
     * parse method for getting US transcription
     */
    private Parser parseTranscriptionUs; //parse method for getting US transcription
    /**
     * parse method for getting definition
     */
    private Parser parseDefinition; //parse method for getting definition

    private Parser parseLanguagePart;
    //endregion

    //region construct
    public DictionaryParser(){
        initialize();
        defaultValue();
    }
    private void initialize(){
        item = new DictionaryItem();
        parseWord = new ParseWord();
        parseTranscriptionUk = new ParseTranscriptionUk();
        parseTranscriptionUs = new ParseTranscriptionUs();
        parseDefinition = new ParseDefinition();

        parseLanguagePart = new ParseLanguagePart();

        setChain();
    }
    private void defaultValue(){
        webPage = null;
    }
    //endregion

    //region boolean
    private boolean isNotNull(Document doc){
        return doc != null;
    }
    //endregion

    //region internal
    /**
     * set up chain of parsing
     */
    private void setChain(){

        parseWord.setNextParser(parseTranscriptionUk);
        parseTranscriptionUk.setNextParser(parseTranscriptionUs);
        parseTranscriptionUs.setNextParser(parseDefinition);
        parseDefinition.setNextParser(parseLanguagePart);
    }
    //endregion

    //region public
    /**
     * connectInsert to a certain page using URL
     * @param url path to web site
     */
    public void connectToPage(String url){
        try {
            webPage = Jsoup.connect(url).get();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Pass through all chain of parsers
     * @return
     */
    public DictionaryItem parseWebPage(){
        if(isNotNull(webPage)) {
            parseWord.parseNode(webPage, item);
        }
        return item;
    }
    //endregion
}
