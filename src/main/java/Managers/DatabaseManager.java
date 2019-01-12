package Managers;

import Content.DictionaryItem;
import Content.LocalDictionary;
import DAO.DictionaryDAO;

/**
 * work with DictionaryDAO
 */
public class DatabaseManager {
    //region fields
    /**
     * Obj to work with database
     */
    private DictionaryDAO dictionaryDao; //Obj to work with database
    //endregion

    //region construct

    /**
     * to work with database
     */
    public DatabaseManager(){
        initialize();
    }

    private void initialize(){
        dictionaryDao = new DictionaryDAO();
    }
    //endregion

    //region public
    /**
     * insert into database one item
     * @param item desired database entry
     */
    public void insertInto(DictionaryItem item){
        dictionaryDao.connectInsert(item);
    }

    /**
     * insert into database each object in dictionary list
     * @param dictionary formed dictionary
     */
    public void insertInto(LocalDictionary dictionary){
        for (DictionaryItem dict : dictionary.getWordsList()) {
            insertInto(dict);
        }
    }
    //endregion
}
