package OnlineWork;

import Content.LocalDictionary;


public class DictionaryComposer {
    //region fields
    /**
     * parser object
     */
    private DictionaryParser dictionaryParser; //parser object
    //endregion

    //region construct
    public DictionaryComposer(){

    }
    private void initialize(){
        dictionaryParser = new DictionaryParser();
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
    //endregion

    //region external

    /**
     * connect to certain URL, parse it and add to LocalDictionary object
     * @param URL path to page
     * @param resultDictionary resulting dictionary object
     */
    public void makeDictionary (String URL, LocalDictionary resultDictionary){
        if(isExist(URL) && isExist(resultDictionary)){
            dictionaryParser.connectToPage(URL);
            resultDictionary.addNewWord(dictionaryParser.parseWebPage());
        }
    }
    //endregion
}
