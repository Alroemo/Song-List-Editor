package algorhythm;

import java.util.ArrayList;
import java.io.Serializable;

public class MediaList implements Serializable{
    
    private ArrayList<Media> theListOfMedia = null;
    
    public MediaList(){
        if(theListOfMedia == null){
            buildTestMediaList();
        }
    }
    
    public ArrayList<Media> getListOfMedia(){
        if(theListOfMedia == null){
            buildTestMediaList();
        }
        return theListOfMedia;
    }
    
    public void sortMediaByYear(){
        int compareMediaYear = 0;
        int currentMediaYear = 0;
        ArrayList<Media> sortedListOfMedia = null;
        for(int i = 0; i < theListOfMedia.size(); i++){
            currentMediaYear = Integer.parseInt(theListOfMedia.get(i).getYear());
            if(currentMediaYear > compareMediaYear)
            {
                sortedListOfMedia.add(theListOfMedia.get(i));
                compareMediaYear = currentMediaYear;
            }
        }
    }
    
    public void buildTestMediaList(){
        theListOfMedia = new ArrayList<Media>();
        for(int i = 0; i < 100; i++){
            Song tempSong = new Song(("Title"+i), i, ("Artist") + i);
            theListOfMedia.add(tempSong);
        }
    }
    
}
