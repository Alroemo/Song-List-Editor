package algorhythm;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ExternalDataCntl {
    
    private final String EXTERNAL_DATA_PATH = "algorhythm_data\\";
    private final String SONG_FILE_NAME = "songlist.TSV";
    
    public ExternalDataCntl(){
        System.out.println("Test");
        if(confirmImport()){
            getSongList();
        }
    }
    
    // Imports a list of Media (Songs) from a text (.tsv) file
    // Adds these to the MediaList and saves them to disk
    public void getSongList(){
        File externalDataFile = new File(EXTERNAL_DATA_PATH+SONG_FILE_NAME);
        
        try{
            Scanner in = new Scanner(externalDataFile);
            int count = 0;
            ArrayList<Media> tempMediaList = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getMediaList().getListOfMedia();
            tempMediaList.clear();
            while(in.hasNextLine()){
                String tempStr = in.nextLine();
                //System.out.println(tempStr);
                Song tempSong = new Song(tempStr);
                tempMediaList.add(tempSong);
                System.out.println(tempSong.getTitle());
                count++;
            }
            System.out.println("Count: "+count);
            SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
            SerializedDataCntl.getSerializedDataCntl().readSerializedDataModel();
        
        }catch(FileNotFoundException fne){
        
            String message = fne.getMessage();
            System.out.println(message);
        
        }
       
    }
    
    // Puts up a Yes/No dialog and returns a boolean
    // reflecting the user's choice
    public boolean confirmImport(){
            boolean importConfirmed = false;
            String message = "Are you sure you want to import songs?";
            String title = "Import Songs";
            int result = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION){
                importConfirmed = true;
            }
            return importConfirmed;
    }
    
}

