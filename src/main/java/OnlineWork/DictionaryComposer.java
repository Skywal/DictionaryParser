package OnlineWork;

import Content.DictionaryItem;
import Content.LocalDictionary;
import FileWork.ReadFromFile;
import Final.Strings;

/**
 * This class composing local reading and web-page parsing parts of the program.
 * Therefore it's building final LocalDictionary object
 */
public class DictionaryComposer {
    //region fields
    /**
     * parser object
     */
    private DictionaryParser dictionaryParser; //parser object
    /**
     * intermediate object for saving words
     */
    private DictionaryItem dictionaryItem; //intermediate object for saving words
    /**
     * Read form file
     */
    private ReadFromFile readFromFile; //Read form file
    //endregion

    //region construct
    public DictionaryComposer(){
        initialize();
        defaultValue();
    }

    private void initialize(){
        dictionaryParser = new DictionaryParser();
        readFromFile = new ReadFromFile(Strings.PATH_TO_WORDS_LOCAL_SOURCE);
        initDictionaryItem();
    }
    private void initDictionaryItem(){
        dictionaryItem = new DictionaryItem();
    }
    private void defaultValue(){

    }
    //endregion

    //region boolean
    private boolean isExist(String str){
        return str != null;
    }
    private boolean isExist(LocalDictionary ld){
        return ld != null;
    }
    private boolean isExist(ReadFromFile rd){
        return rd != null;
    }
    //endregion

    //region internal
    /**
     * forming full path to needed page
     * @param ending ending of the URL
     * @return complete URL path
     */
    private String formFullURL(String ending){
        return Strings.URL_BASE_DICTIONARY + ending;
    }
    //endregion

    //region external
    /**
     * connectInsert to certain URL, parse it and add to DictionaryItem object
     * @param URL path to page
     */
    public void getWordFromWebByPattern(String URL){
        if(isExist(URL)){
            initDictionaryItem();
            dictionaryParser.connectToPage(URL);
            dictionaryItem = dictionaryParser.parseWebPage();
        }
    }

    /**
     * read words from local file
     * @param resultDictionary final dictionary object
     */
    public void makeDictionaryFromLocal(LocalDictionary resultDictionary){
        if(isExist(readFromFile) && isExist(resultDictionary))
            readFromFile.readLineByLineCommonPattern(resultDictionary);
    }

    /**
     * build dictionary with word, transcriptionUk, transcriptionUs and definition.
     * Words are getting from local file
     * @param resultDictionary
     */
    public void makeDictionary(LocalDictionary resultDictionary){
        if (isExist(resultDictionary)) {
            makeDictionaryFromLocal(resultDictionary);

            for (int i = 0; i < resultDictionary.getWordsList().size(); i++) {
                getWordFromWebByPattern( formFullURL( resultDictionary.getWord( i ).getWord() ) );
                resultDictionary.changeWordInDictionary(i, dictionaryItem);
            }
        }
    }
    //endregion

}
