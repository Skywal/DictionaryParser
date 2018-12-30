import FileWork.ReadFromFile;
import Final.Strings;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BotForDictionary {

    public static void main(String[] args){

    try {
        Document doc = Jsoup.connect(Strings.URL_BASE_DICTIONARY + "helicopter").get();

//        Element transkription = doc.select("span.ipa").after("span.ipa").first();

        Element transkriptionUK = doc.select("span.uk").first();
        Element transkriptionUS = doc.select("span.us").first();
        System.out.println(transkriptionUK.text());
        System.out.println(transkriptionUS.text());

        Element ukFirstPart = doc.select("span.uk").first();
        Elements ukTrFirst = ukFirstPart.select("span.ipa");
        System.out.println("First UK part");
        for (Element tr :ukTrFirst){
            System.out.println(tr.text());
        }


        Element ukLastPart = doc.select("span.uk").last();
        Elements ukTrLast = ukLastPart.select("span.ipa");
        System.out.println("Last UK part");
        for (Element tr :ukTrLast){
            System.out.println(tr.text());
        }

//        for (Element tr : transkription) {
//            System.out.println(tr.text());
//        }

//        String html = Jsoup.connect(Strings.URL_BASE_DICTIONARY+"cant").get().html();
//        System.out.println(html);
    }catch (Exception e){
    }

    }

}
