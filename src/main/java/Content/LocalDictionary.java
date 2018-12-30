package Content;

import java.util.ArrayList;

public class LocalDictionary {
    //region fields
    /**
     * full list of words from the web-dictionary
     */
    ArrayList<DictionaryItem> wordsList; //full list of words from the web-dictionary
    //endregion

    //region get/set
    public ArrayList<DictionaryItem> getWordsList() {
        return wordsList;
    }

    /**
     * return word with given index
     * @param index index of the word in array list
     * @return
     */
    public DictionaryItem getWord(int index){
        return wordsList.get(index);
    }
    //endregion

    //region construct
    public LocalDictionary(){
        initialize();
    }

    private void initialize(){
        wordsList = new ArrayList<DictionaryItem>();
    }
    //endregion

    //region public

    /**
     * create new DictionaryItem and add it into wordsList
     * @param word
     * @param transcriptionEn
     * @param transcriptionUs
     * @param example
     */
    public void addNewWord(String word, String transcriptionEn, String transcriptionUs, String example){
        wordsList.add(new DictionaryItem(
                word,
                transcriptionEn,
                transcriptionUs,
                example
        ));
    }

    /**
     * add existing dictionaryItem exemplar
     * @param dictionaryItem
     */
    public void addNewWord(DictionaryItem dictionaryItem){
        wordsList.add(dictionaryItem);
    }

    public void parseWords(){

    }
    //endregion
}
