package OnlineWork.Parsing;

import Content.DictionaryItem;
import Final.Strings;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * this class defines concrete algorithm for parsing US transcription form the web page
 */
public class ParseTranscriptionUs extends Parser{

    //region construct
    public ParseTranscriptionUs(){
        super();
    }
    //endregion

    //region external
    @Override
    public void parsingMethod(Document doc, DictionaryItem item) {
        if (isExist(doc)) {
            parentContainer = doc.select(Strings.SPAN_US).first();                  // get parent container

            if (isExist(parentContainer))
                targetItemContainer = parentContainer.select(Strings.SPAN_IPA).first(); // get concrete that what we need
            else
                printErrorMsg(Strings.ERROR_MISSING_PARENT_CONTAINER);
        } else 
            printErrorMsg(Strings.ERROR_MISSING_DOCUMENT);

        setTextToStorage(item);
    }

    @Override
    public void setTextToStorage(DictionaryItem target) {
//        if (isExist(target) && isExist(targetItemContainer)){
//            target.setTranscriptionUs(targetItemContainer.text());
//        }
//        else
//            printErrorMsg(Strings.ERROR_MISSING_DICTIONARY_ITEM);

        if (isExist(targetItemContainer)){
            if (isExist(target)) {
                target.setTranscriptionUs(targetItemContainer.text());
            } else
                printErrorMsg(Strings.ERROR_MISSING_TARGET_ITEM_CONTAINER);
        } else {
            printErrorMsg(Strings.ERROR_MISSING_DICTIONARY_ITEM);
            handleEmptyElements(target);
        }

    }

    @Override
    public void handleEmptyElements(DictionaryItem target) {
        target.setTranscriptionUs("");
    }
    //endregion
}
