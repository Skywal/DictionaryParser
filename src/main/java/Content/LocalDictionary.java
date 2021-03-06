package Content;

import java.util.ArrayList;

/**
 * This class contains whole formed dictionary and methods to interact with this dictionary
 */
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

    //region boolean
    private boolean isExist(DictionaryItem item){
        return item != null;
    }
    private boolean isBiggerOrEqual(int first, int second){
        return first >= second;
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

    /**
     * Set new value of the word in dictionary by index
     * @param index index of the word
     * @param newWord new word
     * @param newTranscUk new UK transcription
     * @param newTranscUs new US transcription
     * @param newDefinition new definition
     */
    public void changeWordInDictionary(int index, String newWord, String newTranscUk, String newTranscUs,
                                       String newDefinition){
        if (isBiggerOrEqual(index, 0)) {
            changeWord(index, newWord);
            changeTrUk(index, newTranscUk);
            changeTrUs(index, newTranscUs);
            changeDefinition(index, newDefinition);
        }
    }

    /**
     * Set new value of the word in dictionary by index
     * @param index index of the word
     * @param item word object
     */
    public void changeWordInDictionary(int index, DictionaryItem item){
        if (isExist(item))
            changeWordInDictionary(
                    index,
                    item.getWord(),
                    item.getTranscriptionUk(),
                    item.getTranscriptionUs(),
                    item.getDefinition()
            );
    }
    //endregion

    //region internal

    /**
     * change word in dictionary by index
     * @param index index of the word in dictionary
     * @param word new word
     */
    private void changeWord(int index, String word){
        getWord(index).setWord(word);
    }

    /**
     * change transcription UK in dictionary by index
     * @param index index of the word in dictionary
     * @param transcUk new UK transcription
     */
    private void changeTrUk(int index, String transcUk){
        getWord(index).setTranscriptionUk(transcUk);
    }

    /**
     * change transcription US in dictionary by index
     * @param index index of the word in dictionary
     * @param transcUs new US transcription
     */
    private void changeTrUs(int index, String transcUs){
        getWord(index).setTranscriptionUs(transcUs);
    }

    /**
     * change definition in dictionary by index
     * @param index index of the word in dictionary
     * @param definition new definition of the word
     */
    private void changeDefinition(int index, String definition){
        getWord(index).setDefinition(definition);
    }
    //endregion
}
