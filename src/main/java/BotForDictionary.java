import Content.LocalDictionary;
import DAO.DictionaryDao;
import OnlineWork.DictionaryComposer;

public class BotForDictionary {
    //region fields
    static LocalDictionary dictionary;
    static DictionaryComposer dictionaryComposer;
    static DictionaryDao dictionaryDao;
    //endregion

    //region construct
    public static void initialize(){
        dictionaryComposer = new DictionaryComposer();
        dictionary = new LocalDictionary();
        dictionaryDao = new DictionaryDao();
    }
    //endregion

    public static void main(String[] args){
        initialize();

        dictionaryComposer.makeDictionary(dictionary);

        for (int i = 0; i < dictionary.getWordsList().size(); i++) {
            dictionaryDao.connect(dictionary.getWord(i));
//            System.out.println("ParseWord: " + dictionary.getWord(i).getWord());
//            System.out.println("Transcription UK: " + dictionary.getWord(i).getTranscriptionUk());
//            System.out.println("Transcription US: " + dictionary.getWord(i).getTranscriptionUs());
//            System.out.println("ParseDefinition: " + dictionary.getWord(i).getDefinition());
        }

    }

}
