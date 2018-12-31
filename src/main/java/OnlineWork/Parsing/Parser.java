package OnlineWork.Parsing;

import Content.DictionaryItem;
import org.jsoup.nodes.Document;

public abstract class Parser {
    //region fields
    private Parser nextParser;
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
    protected boolean isExist(Parser par){
        return par != null;
    }
    protected boolean isExist(Document doc){
        return doc != null;
    }
    protected boolean isExist(DictionaryItem item){
        return  item != null;
    }
    //region external
    public void parseNode(Document doc, DictionaryItem item){
        parsingMethod(doc, item);

        if (isExist(nextParser)){
            nextParser.parseNode(doc, item);
        }
    }

    public String getClassName(){
        return this.getClass().getName();
    }

    public void printErrorMsg(String msg){
        System.out.println(getClassName() + msg);
    }

    public abstract void parsingMethod(Document doc, DictionaryItem item);
    //endregion
}
