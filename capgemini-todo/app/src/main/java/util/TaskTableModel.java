package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

public class TaskTableModel extends AbstractTableModel {

    String[] columns = {"Nome", "Descrição", "Prazo", "Status", "Editar", "Excluir"};
    List<Task> tasks = new ArrayList();

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return tasks.get(rowIndex).getName();
            case 1:
                return tasks.get(rowIndex).getDescription();
            case 2:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date deadline = tasks.get(rowIndex).getDeadline();
                return dateFormat.format(deadline);
            case 3:
                return tasks.get(rowIndex).getStatus();
            case 4:
                return "";
            case 5:
                return "";
            default:
                return "Dados não encontrado";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    // Method Editable Status
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 3 ? true : false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        this.tasks.get(rowIndex).setStatus((boolean) aValue); // cast Obj -> Bool
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (tasks.isEmpty()) {
            return Object.class;
        }

        return this.getValueAt(0, columnIndex).getClass();
    }

    // Methods Getters
    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    // Methods Setters
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
