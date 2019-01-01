package OnlineWork;

import Content.DictionaryItem;
import OnlineWork.Parsing.Definition;
import OnlineWork.Parsing.Parser;
import OnlineWork.Parsing.TranscriptionUk;
import OnlineWork.Parsing.TranscriptionUs;
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
    //endregion

    //region construct
    public DictionaryParser(){
        initialize();
        defaultValue();
    }
    private void initialize(){
        item = new DictionaryItem();
        parseTranscriptionUk = new TranscriptionUk();
        parseTranscriptionUs = new TranscriptionUs();
        parseDefinition = new Definition();

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
        parseTranscriptionUk.setNextParser(parseTranscriptionUs);
        parseTranscriptionUs.setNextParser(parseDefinition);
    }
    //endregion

    //region public
    /**
     * connect to a certain page using URL
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
            parseTranscriptionUk.parseNode(webPage, item);
        }
        return item;
    }
    //endregion
}
