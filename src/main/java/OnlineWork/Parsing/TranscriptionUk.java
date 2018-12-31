package OnlineWork.Parsing;

import Content.DictionaryItem;
import Final.Strings;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TranscriptionUk extends Parser{
    //region fields
    /**
     * transcription container element
     */
    private Element transcriptContainer; // transcription container element
    /**
     * transcription text container
     */
    private Element transcriptText; // transcription text container
    //endregion

    //region construct
    public TranscriptionUk(){
        super();
    }
    //endregion

    @Override
    public void parsingMethod(Document doc, DictionaryItem item) {
        if (isExist(doc)) {
            transcriptContainer = doc.select(Strings.SPAN_UK).first();
            transcriptText = transcriptContainer.select(Strings.SPAN_IPA).first();
        } else
            printErrorMsg(Strings.ERROR_MISSING_DOCUMENT);

        if (isExist(item)){
            item.setTranscriptionUk(transcriptText.text());
        }
        else
            printErrorMsg(Strings.ERROR_MISSING_DICTIONARY_ITEM);

    }
}
