package algorhythm;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializedDataCntl {
    
    private SerializedDataModel theSerializedDataModel;
    private static SerializedDataCntl theSerializedDataCntl;
    private final String EXTERNAL_DATA_PATH = "algorhythm_data\\";
    private final String ALGORHYTHM_DATA_FILE_NAME = "AlgoRhythmData.ser";
    // private ExternalDataCntl theExtenalDataCntl;
    
    //Private to prevent instantiation.
    private SerializedDataCntl(){
        getSerializedDataModel();
    }
    
    //Singleton design pattern ensures there is only ever one SerializedCollectionCntl.
    public static SerializedDataCntl getSerializedDataCntl(){
        if(theSerializedDataCntl == null){
            theSerializedDataCntl = new SerializedDataCntl();
        }
        return theSerializedDataCntl;
    }
    
    // Returns the serialized data model
    // Creates test data if it is null
    public SerializedDataModel getSerializedDataModel(){
        if(theSerializedDataModel == null){
            readSerializedDataModel();
            if(theSerializedDataModel == null){
                theSerializedDataModel = new SerializedDataModel();
                writeSerializedDataModel();
                readSerializedDataModel();
            }
        }
        return theSerializedDataModel;
    }
    
    
     public void readSerializedDataModel(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        String filePath = EXTERNAL_DATA_PATH+ALGORHYTHM_DATA_FILE_NAME;
        try
            {
            fis = new FileInputStream(filePath);
            in = new ObjectInputStream(fis);
            theSerializedDataModel = (SerializedDataModel) in.readObject();
            in.close();
            }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
            //ExternalDataCntl theExternalDataCntl = new ExternalDataCntl();
            //writeSerializedDataModel();
            //readSerializedDataModel();
        }
        catch(IOException ex)
            {
            ex.printStackTrace();
            }
        catch(ClassNotFoundException ex)
            {
            ex.printStackTrace();
            }
       }

    
     public void writeSerializedDataModel(){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        String filePath = EXTERNAL_DATA_PATH+ALGORHYTHM_DATA_FILE_NAME;
        try
            {
            fos = new FileOutputStream(filePath);
            out = new ObjectOutputStream(fos);
            out.writeObject(theSerializedDataModel);
            out.close();
            }
        catch(IOException ex)
            {
            ex.printStackTrace();
            }
       }
     
    // This method will print the contents of the SerializedDataModel 
    // to ensure there is actually data there.
     public void testPrintSerializedDataModel(){

         
     }
     
    public void getExtenalDataCntl(){
        // theExtenalDataCntl = new ExternalDataCntl();
    }
    
    
    // This method creates some test data if the serialized data model is null.
    private void createTestSerializedDataModel(){
        theSerializedDataModel = new SerializedDataModel();
    }
    
}

