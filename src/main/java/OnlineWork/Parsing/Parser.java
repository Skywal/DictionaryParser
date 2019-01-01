package OnlineWork.Parsing;

import Content.DictionaryItem;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * this class defines chain of parsing algorithms
 * we don't need parser for word because we are reading it from local file
 */
public abstract class Parser {
    //region fields
    /**
     * next concrete parser in chain of parsing
     */
    private Parser nextParser; //next concrete parser in chain of parsing
    /**
     * parent web container of the targetItemContainer
     */
    protected Element parentContainer; //parent web container of the targetItemContainer
    /**
     * target container with text
     */
    protected Element targetItemContainer; //target container with text
    /**
     * title of the page which generate error
     */
    private String title;
    //endregion

    //region get/set
    public void setNextParser(Parser nextParser){
        this.nextParser = nextParser;
    }
    //endregion

    //region construct
    public Parser() {

    }
    //endregion

    //region boolean
    protected boolean isExist(Parser par){
        return par != null;
    }
    protected boolean isExist(Document doc){
        return doc != null;
    }
    protected boolean isExist(DictionaryItem item){
        return  item != null;
    }
    protected boolean isExist(Element el){
        return el != null;
    }
    //endregion

    //region internal
    private void getTittleOfThePage(Document document){
        title = document.title();
    }
    //endregion

    //region external
    /**
     * make one parsing type, like get  UK transcription or get definition of the word
     * @param doc downloaded HTML
     * @param item result of parsing
     */
    public void parseNode(Document doc, DictionaryItem item){
        getTittleOfThePage(doc); // for errors messaging

        parsingMethod(doc, item);

        if (isExist(nextParser)){
            nextParser.parseNode(doc, item);
        }
    }

    /**
     * concrete parsing algorithm
     * @param doc downloaded HTML
     * @param item result of parsing
     */
    public abstract void parsingMethod(Document doc, DictionaryItem item);

    /**
     * setting result of parsing to storage object
     * @param target storage object
     */
    public abstract void setTextToStorage(DictionaryItem target);

    /**
     * technical method to print class name for error message
     * @return class name
     */
    public String getClassName(){
        return this.getClass().getName();
    }
    /**
     * technical method to print error message
     * @param msg error message
     */
    public void printErrorMsg(String msg){
        System.out.println( getClassName() + msg + title);
    }

    //endregion
}
