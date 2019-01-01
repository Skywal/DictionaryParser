package OnlineWork.Parsing;

import Content.DictionaryItem;
import Final.Strings;
import org.jsoup.nodes.Document;

public class ParseWord extends Parser {
    //region construct
    public ParseWord(){

    }
    //endregion

    @Override
    public void parsingMethod(Document doc, DictionaryItem item) {
        if (isExist(doc)) {
            targetItemContainer = doc.select(Strings.SPAN_HW).first(); // get concrete that what we need
        } else
            printErrorMsg(Strings.ERROR_MISSING_DOCUMENT);

        setTextToStorage(item);
    }

    @Override
    public void setTextToStorage(DictionaryItem target) {
        if (isExist(target)){
            target.setWord(targetItemContainer.text());
//            System.out.println("-== " + targetItemContainer.text() + " ==-");
        } else
            printErrorMsg(Strings.ERROR_MISSING_DICTIONARY_ITEM);
    }
}
