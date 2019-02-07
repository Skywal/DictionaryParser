import Content.LocalDictionary;
import Managers.DatabaseManager;
import Managers.DictionaryManager;

public class BotForDictionary {
    //region fields
    static LocalDictionary dictionary;
    static DictionaryManager dictionaryManager;
    static DatabaseManager dataManager;
//    static
    //endregion

    //region construct
    public static void initialize(){
        dictionaryManager = new DictionaryManager();
        dictionary = new LocalDictionary();
        dataManager = new DatabaseManager();
    }
    //endregion

    public static void main(String[] args){
        initialize();

        dictionaryManager.makeDictionary(dictionary);

        dataManager.insertInto(dictionary);

    }

}
