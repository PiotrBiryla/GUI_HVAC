package Interfaces;

import Sections.BagFilter;
import Sections.VentilationType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class BagFilterInterface {

    private static final String SECTION_TEXT = ". Карманный фильтр" + System.lineSeparator();

    public BagFilterInterface(VentilationType ventilationType, int sectionNumber) {
        JFrame bagFilterInterface = new JFrame("Добавление секции Фильтра");
        bagFilterInterface.setSize(800, 190);
        bagFilterInterface.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        bagFilterInterface.setLayout(null);
        bagFilterInterface.setVisible(true);
        bagFilterInterface.setLocationRelativeTo(null);
        bagFilterInterface.setResizable(false);

        JLabel setFilterSection_1 = new JLabel("Укажите данные добавляемой секции фильтрации");
        setFilterSection_1.setBounds(20, 20, 760, 15);
        JLabel setFilterSection_2 = new JLabel("Класс фильтрации:");
        setFilterSection_2.setBounds(20, 50, 400, 15);
        JLabel setFilterSection_3 = new JLabel("Минимальная длина фильтра:");
        setFilterSection_3.setBounds(20, 80, 400, 15);
        JLabel setFilterSection_4 = new JLabel("Потеря давления для подбора секции вентилятора:");
        setFilterSection_4.setBounds(20, 110, 400, 15);

        bagFilterInterface.add(setFilterSection_1);
        bagFilterInterface.add(setFilterSection_2);
        bagFilterInterface.add(setFilterSection_3);
        bagFilterInterface.add(setFilterSection_4);

        JTextField filtrationClass = new JTextField("M5");
        filtrationClass.setBounds(440, 50, 50, 20);
        JTextField filterLength = new JTextField("450");
        filterLength.setBounds(440, 80, 50, 20);
        JTextField pressureDrop = new JTextField("200");
        pressureDrop.setBounds(440, 110, 50, 20);

        bagFilterInterface.add(filtrationClass);
        bagFilterInterface.add(filterLength);
        bagFilterInterface.add(pressureDrop);

        JButton saveButton = new JButton("Добавить");
        saveButton.setBounds(650, 110, 100, 20);
        bagFilterInterface.add(saveButton);

        saveButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {

                BagFilter bagFilter = new BagFilter(sectionNumber, filtrationClass.getText(), filterLength.getText(),
                        pressureDrop.getText(), ventilationType);

                if (ventilationType == VentilationType.SUPPLY) {
                    MainInterface.appendSupplyReport(bagFilter.sectionToString());
                    MainInterface.appendSupplySections(sectionNumber + SECTION_TEXT);
                    MainInterface.setSupplySectionText(MainInterface.SUPPLY_SECTIONS);
                    MainInterface.setSupplySectionNumber(sectionNumber + 1);
                } else if (ventilationType == VentilationType.EXHAUST) {
                    MainInterface.appendExhaustReport(bagFilter.sectionToString());
                    MainInterface.appendExhaustSections(sectionNumber + SECTION_TEXT);
                    MainInterface.setExhaustSectionText(MainInterface.EXHAUST_SECTIONS);
                    MainInterface.setExhaustSectionNumber(sectionNumber + 1);
                }

                bagFilterInterface.setVisible(false);
            }
        });

    }
}
