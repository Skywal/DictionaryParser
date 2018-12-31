package OnlineWork;

import Final.Strings;
import OnlineWork.Parsing.Parser;
import OnlineWork.Parsing.TranscriptionUk;
import OnlineWork.Parsing.TranscriptionUs;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DictionaryParser {
    //region fields
    /**
     * downloaded web-page to work with
     */
    protected Document webPage; //downloaded web-page to work with
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
        parseTranscriptionUk = new TranscriptionUk();
        parseTranscriptionUs = new TranscriptionUs();
        parseDefinition = new TranscriptionUk();
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

    public void parseWebPage(){
//        if(isNotNull(webPage)) {
//            String title = webPage.title();
//            System.out.println(title);
//        }
    }
    //endregion
}
