package Interfaces;

import Sections.PanelFilter;
import Sections.VentilationType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class PanelFilterInterface {

    private static final String SECTION_TEXT = ". Панельный фильтр" + System.lineSeparator();

    public PanelFilterInterface(VentilationType ventilationType, int sectionNumber) {
        JFrame panelFilterInterface = new JFrame("Добавление секции Фильтра");
        panelFilterInterface.setSize(800, 160);
        panelFilterInterface.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        panelFilterInterface.setLayout(null);
        panelFilterInterface.setVisible(true);
        panelFilterInterface.setLocationRelativeTo(null);
        panelFilterInterface.setResizable(false);

        JLabel setFilterSection_1 = new JLabel("Укажите данные добавляемой секции фильтрации");
        setFilterSection_1.setBounds(20, 20, 760, 15);
        JLabel setFilterSection_2 = new JLabel("Класс фильтрации:");
        setFilterSection_2.setBounds(20, 50, 400, 15);
        JLabel setFilterSection_3 = new JLabel("Потеря давления для подбора секции вентилятора:");
        setFilterSection_3.setBounds(20, 80, 400, 15);

        panelFilterInterface.add(setFilterSection_1);
        panelFilterInterface.add(setFilterSection_2);
        panelFilterInterface.add(setFilterSection_3);

        JTextField filtrationClass = new JTextField("M5");
        filtrationClass.setBounds(440, 50, 50, 20);
        JTextField pressureDrop = new JTextField("200");
        pressureDrop.setBounds(440, 80, 50, 20);

        panelFilterInterface.add(filtrationClass);
        panelFilterInterface.add(pressureDrop);

        JButton saveButton = new JButton("Добавить");
        saveButton.setBounds(650, 80, 100, 20);
        panelFilterInterface.add(saveButton);

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

                PanelFilter panelFilter = new PanelFilter(sectionNumber, filtrationClass.getText(),
                        pressureDrop.getText(), ventilationType);

                if (ventilationType == VentilationType.SUPPLY) {
                    MainInterface.appendSupplyReport(panelFilter.sectionToString());
                    MainInterface.appendSupplySections(sectionNumber + SECTION_TEXT);
                    MainInterface.setSupplySectionText(MainInterface.SUPPLY_SECTIONS);
                    MainInterface.setSupplySectionNumber(sectionNumber + 1);
                } else if (ventilationType == VentilationType.EXHAUST) {
                    MainInterface.appendExhaustReport(panelFilter.sectionToString());
                    MainInterface.appendExhaustSections(sectionNumber + SECTION_TEXT);
                    MainInterface.setExhaustSectionText(MainInterface.EXHAUST_SECTIONS);
                    MainInterface.setExhaustSectionNumber(sectionNumber + 1);
                }

                panelFilterInterface.setVisible(false);
            }
        });

    }
}
