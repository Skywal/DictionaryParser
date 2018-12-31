package OnlineWork.Parsing;

import Content.DictionaryItem;
import Final.Strings;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Definition extends Parser{
    //region fields
    /**
     * container element for definition part
     */
    private Element definitionContainer; //container element for definition part
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
    public Definition(){
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
        }
    }
    private String concatenationStr(String frst, String scknd){
        return "" + frst + scknd;
    }
    //endregion

    //region external
    @Override
    public void parsingMethod(Document doc, DictionaryItem item) {
        if (isExist(doc)){
            definitionContainer = doc.select(Strings.DIV_SENSE_BODY).first();
            definitionTexts = definitionContainer.select(Strings.DIV_DEF_BLOCK_PAD_INDENT);
        }
        if (isExist(item)){
            formString(); // form resulting string
            item.setDefinition(content.toString());
        }
    }
    //endregion

}
