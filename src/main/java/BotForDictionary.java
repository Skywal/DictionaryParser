import Content.DictionaryItem;
import Content.LocalDictionary;
import Final.Strings;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BotForDictionary {
    static LocalDictionary dictionary;
    static DictionaryItem dictionaryItem;

    public static void main(String[] args){

    dictionary = new LocalDictionary();
    dictionaryItem = new DictionaryItem();

    try {
        dictionaryItem.setWord("chop");
        Document doc = Jsoup.connect(Strings.URL_BASE_DICTIONARY + dictionaryItem.getWord()).get();

//        Element transkription = doc.select("span.ipa").after("span.ipa").first();

        Element transkriptionUK = doc.select("span.uk").first();
        Element finalTranslUK = transkriptionUK.select("span.ipa").first();

        Element transkriptionUS = doc.select("span.us").first();
        Element finalTranslUS = transkriptionUS.select("span.ipa").first();

        Element example = doc.select("div.sense-body").first();
        Elements concreteExamples = example.select("div.def-block.pad-indent");

        dictionaryItem.setTranscriptionUk(finalTranslUK.text());
        dictionaryItem.setTranscriptionUs(finalTranslUS.text());

        StringBuilder content = new StringBuilder();
        for(Element el : concreteExamples){
            content.append(el.text() + "\n");
        }
        dictionaryItem.setDefinition(content.toString());

//        System.out.println("text is " + example.text());
//        System.out.println(concreteExample.text());
//        System.out.println(concreteExample1.text());

//        System.out.println(finalTranslUK.text());
//        System.out.println(finalTranslUS.text());

// getting sub elements from a mother container element <span class="uk">
//        Element ukFirstPart = doc.select("span.uk").first();
//        Elements ukTrFirst = ukFirstPart.select("span.ipa");
//        System.out.println("First UK part");
//        for (Element tr :ukTrFirst){
//            System.out.println(tr.text());
//        }
//
//        Element ukLastPart = doc.select("span.uk").last();
//        Elements ukTrLast = ukLastPart.select("span.ipa");
//        System.out.println("Last UK part");
//        for (Element tr :ukTrLast){
//            System.out.println(tr.text());
//        }

//        for (Element tr : transkription) {
//            System.out.println(tr.text());
//        }

//        String html = Jsoup.connect(Strings.URL_BASE_DICTIONARY+"cant").get().html();
//        System.out.println(html);
    }catch (Exception e){
        e.printStackTrace();
    }
    finally {
        dictionary.addNewWord(dictionaryItem);
        System.out.println("Word in dictionary is: " + dictionary.getWord(0).getWord());
        System.out.println("UK transcription is: " + dictionary.getWord(0).getTranscriptionEn());
        System.out.println("US transcription is: " + dictionary.getWord(0).getTranscriptionUs());
        System.out.println("Explanation is: " + dictionary.getWord(0).getDefinition());

    }
    }

}
