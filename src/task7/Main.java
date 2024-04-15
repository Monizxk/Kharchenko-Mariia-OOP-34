package src.task7;

import src.task3.View;
import src.task4.ViewableTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Клас графічного інтерфейсу який обробляє натиснення на кнопки та генерує дані
 */
public class Main extends JFrame implements Observable {
    ArrayList<Observer> observers = new ArrayList<>();
    View view = new ViewableTable().getView();

    private JPanel Panel;
    private JTable Table;
    private JButton GenerateButton;
    private JButton SaveButton;
    private JButton RestoreButton;
    private JButton UndoButton;

    /**
     * Конструктор класу
     */
    public Main() {
        setContentPane(Panel);
        setSize(400, 500);
        setVisible(true);

        updateTable();

        GenerateButton.addActionListener(new GenerateButtonListener());
        SaveButton.addActionListener(new SaveButtonListener());
        RestoreButton.addActionListener(new RestoreButtonListener());
        UndoButton.addActionListener(new UndoButtonListener());

        addObserver(new Observer1());
        addObserver(new Observer2());
    }

    /** Оновлює спостерігача */
    public void update(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    /**  Додає спостерігача в список спостерігачів */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Оновлює дані в таблиці
     */
    public void updateTable() {
        Object[][] Result = new Object[view.getItems().size()][4];

        for (int i = 0; i < view.getItems().size(); i++) {
            Result[i][0] = Math.round(view.getItems().get(i).getVoltage());
            Result[i][1] = Math.round(view.getItems().get(i).getCurrents()[0]);
            Result[i][2] = Math.round(view.getItems().get(i).getCurrents()[1]);
            Result[i][3] = Math.round(view.getItems().get(i).getCurrents()[2]);
        }

        Table.setModel(new DefaultTableModel(
                Result, new String[]{"Voltage", "100 ом.", "200 ом.", "300 ом."}
        ));
    }

    /**
     * Обробляє натиснення на кнопку Generate
     */
    class GenerateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.viewInit();
            updateTable();
            update("generate");
        }
    }

    /**
     * Обробляє натиснення на кнопку Save
     */
    class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                view.viewSave();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            update("save");
        }
    }

    /**
     * Обробляє натиснення на кнопку Restore
     */
    class RestoreButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                view.viewRestore();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            updateTable();
            update("restore");
        }
    }

    /**
     * Обробляє натиснення на кнопку Undo
     */
    class UndoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.undo();
            updateTable();
            update("undo");
        }
    }

    /**
     * Точка входу в програму
     */
    public static void main(String[] args) {
        new Main();
    }
}
