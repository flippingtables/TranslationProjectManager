/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.TableModels;

import com.sandagerdi.translationprojectmanager.Repository.JobTypes;
import com.sandagerdi.translationprojectmanager.Repository.Jobs;
import com.sandagerdi.translationprojectmanager.Util.Utils;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Jóannes
 */
public class SharedListSelectionHandler implements ListSelectionListener {

    JTable clientTable;
    JTextArea textAreaForOutput;
    JobsTableModel m_tableModel;

    public SharedListSelectionHandler(JTable clientTable, JTextArea textAreaForOutput, JobsTableModel tableModel) {
        this.clientTable = clientTable;
        this.textAreaForOutput = textAreaForOutput;
        this.m_tableModel = tableModel;
    }

    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel lsm = (ListSelectionModel) e.getSource();
        if (e.getValueIsAdjusting()) {
            return;
        }
        if (!lsm.isSelectionEmpty()) {
            int[] selectedRow = getSelectedRows(lsm);
            for (int i : selectedRow) {
                int convertRowToModel = clientTable.convertRowIndexToModel(i);
                textAreaForOutput.setText("Pay: " + Utils.formatDoubleToLocale(calculatePriceForJob(m_tableModel.getValueAtRow(i))));
            }
        }
    }

    private int[] getSelectedRows(ListSelectionModel selection) {
        int iMin = selection.getMinSelectionIndex();
        int iMax = selection.getMaxSelectionIndex();
        if ((iMin == -1) || (iMax == -1)) {
            return new int[0];
        }
        int[] rvTmp = new int[1 + (iMax - iMin)];
        int n = 0;
        for (int i = iMin; i <= iMax; i++) {
            if (selection.isSelectedIndex(i)) {
                rvTmp[n++] = i;
            }
        }
        int[] rv = new int[n];
        System.arraycopy(rvTmp, 0, rv, 0, n);
        return rv;
    }

    
    
    private double calculatePriceForJob(Jobs job) {

        JobTypes jobType = job.getJobType();
        double houly = jobType.getPay_hour() * job.getPay_hour();
        double newWords = jobType.getWords_new() * job.getWords_new();
        double fuzzy50 = jobType.getWords_fuzzy50() * job.getWords_fuzzy50();
        double fuzzy75 = jobType.getWords_fuzzy75() * job.getWords_fuzzy75();
        double fuzzy85 = jobType.getWords_fuzzy85() * job.getWords_fuzzy85();
        double fuzzy95 = jobType.getWords_fuzzy95() * job.getWords_fuzzy95();
        double match = jobType.getWords_match() * job.getWords_match();
        double rep = jobType.getWords_rep() * job.getWords_rep();
        double ICE = jobType.getWords_ice() * job.getWords_ice();

        
        double result = houly + newWords + fuzzy50 + fuzzy75 + fuzzy85 + fuzzy95 + match + rep + ICE;
        if (job.isRush()){
            // JobType has a % that is added to the job if it is a rushed job.
            
            result = result*((jobType.getPay_rush()/100)+1);
        }
        return result;
    }

}
