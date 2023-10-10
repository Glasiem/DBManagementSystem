package org.dbms.database.ui;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class MyTableModel extends DefaultTableModel {

    public MyTableModel() {
        super();
    }

    public MyTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }
    
    public void removeColumn(int column) {
        for (int i = 0; i < getRowCount(); i++) {
            Vector rowData = (Vector) dataVector.elementAt(i);
            rowData.removeElementAt(column);
        }
        
        columnIdentifiers.removeElementAt(column);
        
        fireTableStructureChanged();
    }
}