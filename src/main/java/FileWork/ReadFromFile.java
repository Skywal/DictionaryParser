package FileWork;

import Content.LocalDictionary;

import java.io.*;

/**
 * this class reads from disc certain file string by string
 */
public class ReadFromFile {
    //region fields
    /**
     * read file into bytes
     */
    FileInputStream fileInputStream; //read file into bytes
    /**
     * read bytes and converts them to characters
     */
    InputStreamReader inputStreamReader; //read bytes and converts them to characters
    /**
     * buffer
     */
    BufferedReader bufferedReader; //buffer
    /**
     * path to file
     */
    String filePath; //path to file
    /**
     * string would read from file line by line
     */
    String line; //string would read from file line by line
    //endregion

    //region construct
    public ReadFromFile(String filePath) {
        initialize();
        defaultValue(filePath);
    }

    private void initialize(){
    }

    private void defaultValue(String filePath){
        this.filePath = filePath;
    }
    //endregion

    //region boolean
    private boolean isStringExists(String str){
        return str != null;
    }
    //endregion

    //region internal

    /**
     * Init file input stream obj with file path
     * @param filePath path to file you want to read from
     */
    private void initFileInpStream(String filePath){
        try{
            fileInputStream = new FileInputStream(filePath);
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Init input stream reader exemplar with FileInputStream obj
     * @param fileInputStream initialized obj
     */
    private void initInpStreamReader(FileInputStream fileInputStream){
        inputStreamReader = new InputStreamReader(fileInputStream);
    }

    /**
     * Init BufferedReader exemplar
     * @param inputStreamReader
     */
    private void initBufferedReader(InputStreamReader inputStreamReader){
        bufferedReader = new BufferedReader(inputStreamReader);
    }

    /**
     * Close file input stream
     */
    private void closeFileInpStream(){
        try {
            fileInputStream.close();
        }catch (IOException ioex){
            System.out.println("Problem while closing fileInputStream: " + ioex.getMessage());
        }
    }

    /**
     * close input stream reader
     */
    private void closeInpStreamReader(){
        try {
            inputStreamReader.close();
        }catch (IOException ioex){
            System.out.println("Problem while closing inputStreamReader: " + ioex.getMessage());
        }
    }

    /**
     * close buffered reader
     */
    private void closeBufferedReader(){
        try {
            bufferedReader.close();
        }catch (IOException ioex){
            System.out.println("Problem while closing bufferedReader: " + ioex.getMessage());
        }
    }

    /**
     * close all buffers
     */
    private void closeAll(){
        closeFileInpStream();
        closeInpStreamReader();
        closeBufferedReader();
    }
    //endregion

    //region external

    /**
     * Read file and return a string like in file
     * File should be in UTF-8 encoding and Windows endline style
     * @return
     */
    public void readLineByLineCommonPattern(LocalDictionary localDictionary){
        try{
            if(isStringExists(filePath)) {
                initFileInpStream(filePath);
                initInpStreamReader(fileInputStream);
                initBufferedReader(inputStreamReader);
            }

            while ((line = bufferedReader.readLine()) != null) {
                localDictionary.addNewWord(line, null, null, null);
//                System.out.println("-= " + line + " =-");
            }

        }
        catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch (IOException ioex){
            System.out.println(ioex.getMessage());
        }
        finally {
            closeAll();
        }

    }
    //endregion

}
