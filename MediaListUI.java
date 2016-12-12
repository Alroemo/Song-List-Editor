package algorhythm;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MediaListUI extends JFrame{
    
    private MediaCntl theMediaCntl = null;
    private JButton backButton;
    private JButton goButton;
    private JButton deleteButton;
    private JButton newButton;
    private JPanel buttonPanel;
    private JPanel tablePanel;
    // private MediaTableModel theMediaTableModel;
    private JTable theMediaTable;
    private JScrollPane theScrollPane;
    TableRowSorter<TableModel> mediaTableSorter;
    
    public MediaListUI(MediaCntl parentMediaCntl){
        theMediaCntl = parentMediaCntl;
        initCustomComponents();
    }
    
    public void initCustomComponents(){
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // Initialize all of the components
        backButton = new JButton("< Back");
        backButton.setPreferredSize(new Dimension(30, 20));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        
        goButton = new JButton("Edit");
        goButton.setPreferredSize(new Dimension(30, 20));
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });
        
        newButton = new JButton("New Song");
        newButton.setPreferredSize(new Dimension(30, 20));
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        
        deleteButton = new JButton("Delete");
        deleteButton.setPreferredSize(new Dimension(30, 20));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        
        buttonPanel = new JPanel(new GridLayout(1,4));
        buttonPanel.add(backButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(newButton);
        buttonPanel.add(goButton);
        
        // Build the media table panel
        theMediaTable = new JTable(this.theMediaCntl.getMediaTableModel());
        theMediaTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        theMediaTable.getColumnModel().getColumn(1).setPreferredWidth(15);
        theMediaTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        
        //Media table sorter
        mediaTableSorter = new TableRowSorter<TableModel>(this.theMediaTable.getModel());
        theMediaTable.setRowSorter(mediaTableSorter);
 
        //Put everything together
        theScrollPane = new JScrollPane(theMediaTable);
        theScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        theScrollPane.setPreferredSize(new Dimension(740,540));
        theMediaTable.setFillsViewportHeight(true);
        
        tablePanel = new JPanel();
        tablePanel.add(theScrollPane);  
        
        // Put it all together
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
    }
    
    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        int selectedModelRow = -1;
        Media selectedMedia = null;
        theMediaCntl.getMediaDetailUI(selectedModelRow, selectedMedia);
    }  
    
    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        int selectedTableRow = theMediaTable.getSelectedRow();
        int selectedModelRow = theMediaTable.convertRowIndexToModel(selectedTableRow);
        Media selectedMedia = this.theMediaCntl.getMediaList().getListOfMedia().get(selectedModelRow);
        theMediaCntl.getMediaDetailUI(selectedModelRow, selectedMedia);
        System.out.println(selectedMedia.toString());
    }  
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        theMediaCntl.getNavigationCntl();
        
    }
    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        int selectedTableRow = theMediaTable.getSelectedRow();
        int selectedModelRow = theMediaTable.convertRowIndexToModel(selectedTableRow);
        MediaListUI.this.theMediaCntl.getMediaList().getListOfMedia().remove(selectedModelRow);
        this.theMediaCntl.getMediaTableModel().fireTableDataChanged();
    }  
    
}
