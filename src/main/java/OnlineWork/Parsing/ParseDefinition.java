package OnlineWork.Parsing;

import Content.DictionaryItem;
import Final.Strings;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * this class defines concrete algorithm for parsing definition of the word form the web page
 */
public class ParseDefinition extends Parser{
    //region fields
    /**
     * elements which contains text
     */
    private Elements definitionTexts; //elements which contains text
    /**
     * resulting string
     */
    private StringBuilder content; //resulting string
    //endregion

    //region construct
    public ParseDefinition(){
        initialize();
    }
    private void initialize(){
        content = new StringBuilder();
    }
    //endregion

    //region boolean
    private boolean isExist(Elements elements){
        return elements != null;
    }
    //endregion

    //region internal
    /**
     * make from a lot elements with text one solid string
     */
    private void formString(){
        if(isExist(definitionTexts)){
            for(Element el : definitionTexts){
                content.append(concatenationStr(el.text(), "\n"));
            }
        } else
            printErrorMsg(Strings.ERROR_MISSING_TARGET_ITEM_CONTAINER);
    }
    private String concatenationStr(String frst, String scknd){
        return "" + frst + scknd;
    }
    //endregion

    //region external
    @Override
    public void parsingMethod(Document doc, DictionaryItem item) {
        if (isExist(doc)){
            parentContainer = doc.select(Strings.DIV_SENSE_BODY).first();               // get parent container

            if (isExist(parentContainer))
                definitionTexts = parentContainer.select(Strings.DIV_DEF_BLOCK_PAD_INDENT); // get concrete that what we need
            else
                printErrorMsg(Strings.ERROR_MISSING_PARENT_CONTAINER);
        } else
            printErrorMsg(Strings.ERROR_MISSING_DOCUMENT);

        setTextToStorage(item);
    }

    @Override
    public void setTextToStorage(DictionaryItem target) {
        if (isExist(target)){
            formString(); // form resulting string
            target.setDefinition(content.toString());
        } else {
            printErrorMsg(Strings.ERROR_MISSING_DICTIONARY_ITEM);
            handleEmptyElements(target);
        }
    }

    @Override
    public void handleEmptyElements(DictionaryItem target) {
        target.setDefinition("");
    }
    //endregion

}
