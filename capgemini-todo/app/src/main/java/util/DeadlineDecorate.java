package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import model.Task;

public class DeadlineDecorate extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel jLabel;
        jLabel = (JLabel) super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, column);

        jLabel.setHorizontalAlignment(CENTER);

        TaskTableModel taskModel = (TaskTableModel) table.getModel();
        Task task = taskModel.getTasks().get(row);

        if (task.getStatus()) {
            jLabel.setBackground(Color.GREEN);
        } else {
            if (task.getDeadline().after(new Date())) {
                jLabel.setBackground(Color.GREEN);
            } else {
                jLabel.setBackground(Color.RED);
            }
        }

        return jLabel;

    }
}

/*
        if (task.getDeadline().after(new Date())) {
            jLabel.setBackground(Color.GREEN);
        } else {
            jLabel.setBackground(Color.RED);
        }  
 */
