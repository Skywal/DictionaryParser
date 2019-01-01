package OnlineWork.Parsing;

import Content.DictionaryItem;
import Final.Strings;
import org.jsoup.nodes.Document;

/**
 * this class defines concrete algorithm for parsing UK transcription form the web page
 */
public class ParseTranscriptionUk extends Parser{

    //region construct
    public ParseTranscriptionUk(){
        super();
    }
    //endregion

    @Override
    public void parsingMethod(Document doc, DictionaryItem item) {
        if (isExist(doc)) {
            parentContainer = doc.select(Strings.SPAN_UK).first();                  // get parent container
            targetItemContainer = parentContainer.select(Strings.SPAN_IPA).first(); // get concrete that what we need
        } else
            printErrorMsg(Strings.ERROR_MISSING_DOCUMENT);

        setTextToStorage(item);

    }

    @Override
    public void setTextToStorage(DictionaryItem target) {
        if (isExist(target) && isExist(targetItemContainer)){
            target.setTranscriptionUk(targetItemContainer.text());
        } else
            printErrorMsg(Strings.ERROR_MISSING_DICTIONARY_ITEM);
    }
}
