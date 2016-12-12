package algorhythm;

public class MediaCntl {
    
    private NavigationCntl theNavigationCntl = null;
    private MediaList theMediaList = null;
    private MediaListUI theMediaListUI = null;
    private MediaUI theMediaUI = null;
    private MediaTableModel theMediaTableModel= null;
    
    public MediaCntl(NavigationCntl parentNavigationCntl){
        theNavigationCntl = parentNavigationCntl;
        // theMediaList = new MediaList();
        theMediaList = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getMediaList();
        theMediaTableModel = new MediaTableModel(theMediaList.getListOfMedia());
        theMediaListUI = new MediaListUI(this);
        theMediaListUI.setVisible(true);
    }
    
    public void getMediaListUI(){
        theMediaListUI.setVisible(true);
    }
    
    public void updateMedia(int row, Media newMedia){
        theMediaUI.setVisible(false);
        theMediaList.getListOfMedia().set(row, newMedia);
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
        theMediaTableModel.fireTableDataChanged();
        theMediaListUI.setVisible(true);
    }
    
    public void saveNewMedia(Media newMedia){
        theMediaUI.setVisible(false);
        theMediaList.getListOfMedia().add(newMedia);
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
        theMediaTableModel.fireTableDataChanged();
        theMediaListUI.setVisible(true);
    }
    
    public void getMediaDetailUI(int selectedRowID, Media theSelectedMedia){
        theMediaListUI.setVisible(false);
        if(theSelectedMedia != null){
            theMediaUI = new MediaUI(this, selectedRowID, theSelectedMedia);
        }else{
            theMediaUI = new MediaUI(this, -1, null);
        }
        theMediaUI.setLocationRelativeTo(null);
        theMediaUI.setVisible(true);
    }
    
    public void getNavigationCntl(){
        theMediaListUI.setVisible(false);
        theMediaListUI.dispose();
        this.theNavigationCntl.getNavigationCntl();
    }
    
    public MediaTableModel getMediaTableModel(){
        return theMediaTableModel;
    }
    
    public MediaList getMediaList(){
        return theMediaList;
    }
    
    
    
}
