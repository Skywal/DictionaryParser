package OnlineWork.Parsing;

import Content.DictionaryItem;
import Final.Strings;
import org.jsoup.nodes.Document;

public class ParseWord extends Parser {
    //region construct
    public ParseWord(){

    }
    //endregion

    //region external
    @Override
    public void parsingMethod(Document doc, DictionaryItem item) {
        if (isExist(doc)) {
            targetItemContainer = doc.select(Strings.H2_HEADWORD).first(); // get concrete that what we need
        } else
            printErrorMsg(Strings.ERROR_MISSING_DOCUMENT);

        setTextToStorage(item);
    }

    @Override
    public void setTextToStorage(DictionaryItem target) {
        if (isExist(targetItemContainer)){
            if (isExist(target)) {
                target.setWord(targetItemContainer.text());
            } else
                printErrorMsg(Strings.ERROR_MISSING_TARGET_ITEM_CONTAINER);
        } else {
            printErrorMsg(Strings.ERROR_MISSING_DICTIONARY_ITEM);
            handleEmptyElements(target);
        }
    }

    @Override
    public void handleEmptyElements(DictionaryItem target) {
        target.setWord("");
    }
    //endregion
}
