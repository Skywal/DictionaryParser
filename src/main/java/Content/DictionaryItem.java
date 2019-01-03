package Content;

/**
 * This class implements an item of a dictionary with transcription and small explanation
 */
public class DictionaryItem {
    //region fields
    /**
     * standard size of StringBuffer exemplars
     */
    private int standardLength = 16; //standard size of StringBuffer exemplars
    /**
     * the word in the dictionary
     */
    private StringBuffer word; //the word in the dictionary
    /**
     * England's variant of word transcription
     */
    private StringBuffer transcriptionEn; //England's variant of word transcription
    /**
     * American's variant of word transcription
     */
    private StringBuffer transcriptionUs; //American's variant of word transcription
    /**
     * explanation of the word
     */
    private StringBuffer definition; //explanation of the word
    //endregion

    //region get/set

    public String getWord() {
        return word.toString();
    }

    public String getTranscriptionUk() {
        return transcriptionEn.toString();
    }

    public String getTranscriptionUs() {
        return transcriptionUs.toString();
    }

    public String getDefinition() {
        return definition.toString().replace("'","`");
    }

    /**
     * Change size of the buffer and set new sting
     * @param word new string
     */
    public void setWord(String word) {
        if(isExist(word)) {
            initWord(word.length()); // set new size of the buffer
            this.word.replace(0, word.length(), word);
        }
    }
    /**
     * Change size of the buffer and set new sting
     * @param transcriptionEn new string
     */
    public void setTranscriptionUk(String transcriptionEn) {
        if(isExist(transcriptionEn)) {
            initTranscriptionEn(transcriptionEn.length()); // set new size of the buffer
            this.transcriptionEn.replace(0, transcriptionEn.length(), transcriptionEn);
        }
    }
    /**
     * Change size of the buffer and set new sting
     * @param transcriptionUs string
     */
    public void setTranscriptionUs(String transcriptionUs) {
        if(isExist(transcriptionUs)) {
            initTranscriptionUs(transcriptionUs.length()); // set new size of the buffer
            this.transcriptionUs.replace(0, transcriptionUs.length(), transcriptionUs);
        }
    }
    /**
     * Change size of the buffer and set new sting
     * @param definition new string
     */
    public void setDefinition(String definition) {
        if(isExist(definition)) {
            initDefinition(definition.length()); // set new size of the buffer
            this.definition.replace(0, definition.length(), definition);
        }
    }

    //endregion

    //region construct
    public DictionaryItem(String word, String transcriptionEn, String transcriptionUs, String definition){
        initialize();
        defaultValue(word, transcriptionEn, transcriptionUs, definition);
    }

    public DictionaryItem(String word){
        this(word, null, null, null);
    }

    public DictionaryItem(){
        this(null,null,null,null);
    }

    private void initialize(){
        initWord(standardLength);
        initTranscriptionEn(standardLength);
        initTranscriptionUs(standardLength);
        initDefinition(standardLength);
    }
    private void defaultValue(String word, String transcriptionEn, String transcriptionUs, String example){
        setWord(word);
        setTranscriptionUk(transcriptionEn);
        setTranscriptionUs(transcriptionUs);
        setDefinition(example);
    }
    //endregion

    //region internal
    /**
     * initialize StringBuffer object with given length
     * @param length size of the buffer
     */
    private void initWord(int length){
        if(isPositiveOrZero(length))
            word = new StringBuffer(length);
    }
    /**
     * initialize StringBuffer object with given length
     * @param length size of the buffer
     */
    private void initTranscriptionEn(int length){
        if(isPositiveOrZero(length))
            transcriptionEn = new StringBuffer(length);
    }
    /**
     * initialize StringBuffer object with given length
     * @param length size of the buffer
     */
    private void initTranscriptionUs(int length){
        if(isPositiveOrZero(length))
            transcriptionUs = new StringBuffer(length);
    }
    /**
     * initialize StringBuffer object with given length
     * @param length size of the buffer
     */
    private void initDefinition(int length){
        if(isPositiveOrZero(length))
            definition = new StringBuffer(length);
    }
    //endregion

    //region private boolean
    private boolean isExist(String str){
        return str != null;
    }
    private boolean isPositiveOrZero(int num){
        return num >= 0;
    }
    //endregion
}
