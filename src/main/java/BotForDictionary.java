import Content.DictionaryItem;
import Content.LocalDictionary;
import Final.Strings;
import OnlineWork.DictionaryComposer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BotForDictionary {
    //region fields
    static LocalDictionary dictionary;
    static DictionaryItem dictionaryItem;
    static DictionaryComposer dictionaryComposer;
    //endregion

    //region construct
    public static void initialize(){
        dictionaryComposer = new DictionaryComposer();
        dictionary = new LocalDictionary();
    }
    //endregion

    public static void main(String[] args){


    }

}
