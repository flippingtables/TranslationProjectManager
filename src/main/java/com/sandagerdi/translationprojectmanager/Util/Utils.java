/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Util;

/**
 *
 * @author Jóannes
 */
public class Utils {

//    public void FillTable(JTable table, String Query)
//{
//    try
//    {
//        CreateConnection();
//        Statement stat = conn.createStatement();
//        ResultSet rs = stat.executeQuery(Query);
//
//        //To remove previously added rows
//        while(table.getRowCount() > 0) 
//        {
//            ((DefaultTableModel) table.getModel()).removeRow(0);
//        }
//        int columns = rs.getMetaData().getColumnCount();
//        while(rs.next())
//        {  
//            Object[] row = new Object[columns];
//            for (int i = 1; i <= columns; i++)
//            {  
//                row[i - 1] = rs.getObject(i);
//            }
//            ((DefaultTableModel) table.getModel()).insertRow(rs.getRow()-1,row);
//        }
//
//        rs.close();
//        stat.close();
//        conn.close();
//    }
//    catch(InstantiationException | IllegalAccessException | SQLException e)
//    {
//    }
//}
}
