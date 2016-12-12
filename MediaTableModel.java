package algorhythm;

import javax.swing.table.*;
import javax.swing.event.*;
import java.util.*;

public class MediaTableModel extends AbstractTableModel{
    
    private static String[] columnNames = {"Genre", "Title", "Artist","Year"};
    private ArrayList<Media> mediaTableData;
    
    public MediaTableModel(ArrayList<Media> theMediaTableData){
        this.mediaTableData = theMediaTableData;
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return mediaTableData.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Object objectToReturn = new Object();
        switch(col){
            case 0: objectToReturn = mediaTableData.get(row).getGenre();break;
            case 1: objectToReturn = mediaTableData.get(row).getTitle();break;
            case 2: objectToReturn = mediaTableData.get(row).getArtist();break;
            case 3: objectToReturn = mediaTableData.get(row).getYear();break;
        }
        return objectToReturn;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Food that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }
    
}
