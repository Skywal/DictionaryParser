package OnlineWork.Parsing;

import Content.DictionaryItem;
import Final.Strings;
import org.jsoup.nodes.Document;

/**
 * parsing what part of the language is the word
 */
public class ParseLanguagePart extends Parser {
    //region construct
    public ParseLanguagePart(){
        super();
    }
    //endregion

    //region external
    @Override
    public void parsingMethod(Document doc, DictionaryItem item) {
        if(isExist(doc)){
            parentContainer = doc.select(Strings.SPAN_POS).first();     // get parent container

            if(isExist(parentContainer)){
                targetItemContainer = parentContainer.select(Strings.SPAN_POS).first(); //get concrete that we need
            } else
                printErrorMsg(Strings.ERROR_MISSING_PARENT_CONTAINER);
        } else
            printErrorMsg(Strings.ERROR_MISSING_DOCUMENT);
        setTextToStorage(item);
    }

    @Override
    public void setTextToStorage(DictionaryItem target) {
        if(isExist(targetItemContainer)){
            if(isExist(target)){
                target.setLanguagePart(targetItemContainer.text());
//                System.out.println(targetItemContainer.text());
            } else
                printErrorMsg(Strings.ERROR_MISSING_TARGET_ITEM_CONTAINER);
        } else {
            printErrorMsg(Strings.ERROR_MISSING_DICTIONARY_ITEM);
            handleEmptyElements(target);
        }
    }

    @Override
    public void handleEmptyElements(DictionaryItem target) {
        target.setLanguagePart("");
    }
    //endregion
}
