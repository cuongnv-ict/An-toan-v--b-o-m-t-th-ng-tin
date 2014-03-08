/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguyen van cuong
 */
public class SetTable {
    public void loadData(ResultSet rs, JTable table) {
        DefaultTableModel tableModel = new DefaultTableModel();
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberColumn = metaData.getColumnCount();
            ArrayList<String> arrayColumn = new ArrayList<String>();
            for(int i = 1 ; i <= numberColumn ; i++) {
                arrayColumn.add(metaData.getColumnName(i));
            }
            tableModel.setColumnIdentifiers(arrayColumn.toArray());
            
            ArrayList<String> arrayRow = new ArrayList<String>();
            
            while(rs.next()) {
                for(int i = 1 ; i <= numberColumn ; i++) {
                    arrayRow.add(rs.getString(i));
                }
                tableModel.addRow(arrayRow.toArray());
                arrayRow.clear();
            }
            table.setModel(tableModel);
            table.setAutoCreateRowSorter(true);
        } catch (SQLException ex) {
            Logger.getLogger(SetTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
