package util;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ButtonRenderer extends DefaultTableCellRenderer {

    // Attributes
    private String buttonType;

    // Contructor
    public ButtonRenderer(String buttonType) {
        this.setButtonType(buttonType);
    }

    // Methods Getters
    public String getButtonType() {
        return buttonType;
    }

    // Methods Setteres
    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }

    // Renderer Method
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel jLabel;

        jLabel = (JLabel) super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, column);

        // SET Properties
        jLabel.setHorizontalAlignment(CENTER);
        jLabel.setIcon(new javax.swing.ImageIcon(getClass()
                .getResource("/icons/" + buttonType + ".png")));

        return jLabel;
    }

}
