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
    static DictionaryComposer dictionaryComposer;
    //endregion

    //region construct
    public static void initialize(){
        dictionaryComposer = new DictionaryComposer();
        dictionary = new LocalDictionary();
    }
    //endregion

    public static void main(String[] args){
        initialize();

        dictionaryComposer.makeDictionary(dictionary);

        for (int i = 0; i < dictionary.getWordsList().size(); i++) {
            System.out.println("Word: " + dictionary.getWord(i).getWord());
            System.out.println("Transcription UK: " + dictionary.getWord(i).getTranscriptionUk());
            System.out.println("Transcription US: " + dictionary.getWord(i).getTranscriptionUs());
            System.out.println("Definition: " + dictionary.getWord(i).getDefinition());
        }

    }

}
