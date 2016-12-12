package algorhythm;

import java.io.Serializable;

public abstract class Media implements Serializable, Comparable{
    
    private String title = "";
    private int lengthInSeconds = 0;
    private String artist = "";
    private String genre = "";
    private String year = "";
    
    
    public Media(){
        System.out.println("Called: Media()");
    }
    
    public Media(String importMediaString){
        String delimiter = "\\t";
        String[] tempMediaArray = importMediaString.split(delimiter);
        this.genre = tempMediaArray[0];
        this.title = tempMediaArray[1];
        this.artist = tempMediaArray[2];
        this.year = tempMediaArray[3];
    }
    
    public Media(String newTitle, int newLengthInSeconds, String newArtist){
        // System.out.println("Called: Media(String title, long lengthInSeconds)");
        this.title = newTitle;
        this.lengthInSeconds = newLengthInSeconds;
        this.artist = newArtist;
    }
    
    public Media(String newGenre, String newTitle, String newArtist, String newYear){
        this.title = newTitle;
        this.artist = newArtist;
        this.genre = newGenre;
        this.year = newYear;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public int getLength(){
        return this.lengthInSeconds;
    }
    
    public String getArtist(){
        return this.artist;
    }
    
     public String toString(){
        String mediaString = this.title+ " "+ this.lengthInSeconds+" "+this.artist;
        return mediaString;
  }

    public String getGenre(){
        return genre;
    }
    public String getYear(){
        return year;
    }


    
}
