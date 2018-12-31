package OnlineWork.Parsing;

import Content.DictionaryItem;
import Final.Strings;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TranscriptionUs extends Parser{
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
    public TranscriptionUs(){
        super();
    }
    //endregion

    @Override
    public void parsingMethod(Document doc, DictionaryItem item) {
        if (isExist(doc)) {
            transcriptContainer = doc.select(Strings.SPAN_US).first();
            transcriptText = transcriptContainer.select(Strings.SPAN_IPA).first();
        } else 
            printErrorMsg(Strings.ERROR_MISSING_DOCUMENT);

        if (isExist(item)){
            item.setTranscriptionUs(transcriptText.text());
        }
        else
            printErrorMsg(Strings.ERROR_MISSING_DICTIONARY_ITEM);

    }
}
