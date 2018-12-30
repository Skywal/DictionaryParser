package OnlineWork;

import Final.Strings;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Parser {
    //region fields
    /**
     * downloaded web-page to work with
     */
    protected Document webPage;
    //endregion

    //region construct
    public Parser(){

    }
    private void initialize(){

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
        if(isNotNull(webPage)) {
            String title = webPage.title();
            System.out.println(title);
        }
    }
    //endregion
}
