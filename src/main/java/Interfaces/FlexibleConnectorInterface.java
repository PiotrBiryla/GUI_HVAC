package Interfaces;

import Sections.FlexibleConnector;
import Sections.VentilationType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class FlexibleConnectorInterface {

    private static final String SECTION_TEXT = ". Гибкая вставка" + System.lineSeparator();

    public FlexibleConnectorInterface(VentilationType ventilationType, int sectionNumber) {
        JFrame flexConnInterface = new JFrame("Добавление Гибкой вставки");
        flexConnInterface.setSize(800, 150);
        flexConnInterface.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        flexConnInterface.setLayout(null);
        flexConnInterface.setVisible(true);
        flexConnInterface.setLocationRelativeTo(null);
        flexConnInterface.setResizable(false);

        JLabel setSizeFlexConn_1 = new JLabel("Укажите размеры гибкой вставки, или оставьте поле пустым");
        setSizeFlexConn_1.setBounds(20, 20, 760, 15);
        JLabel setSizeFlexConn_2 = new JLabel("для вставки стандартного размера \"full size\"");
        setSizeFlexConn_2.setBounds(20, 35, 760, 15);
        flexConnInterface.add(setSizeFlexConn_1);
        flexConnInterface.add(setSizeFlexConn_2);

        JLabel setSizeWidth = new JLabel("Укажите ширину:");
        setSizeWidth.setBounds(20, 70, 100, 20);
        flexConnInterface.add(setSizeWidth);

        JTextField textSizeWidth = new JTextField();
        textSizeWidth.setBounds(140, 70, 50, 20);
        textSizeWidth.setText("0");
        flexConnInterface.add(textSizeWidth);

        JLabel setSizeHeight = new JLabel("Укажите высоту:");
        setSizeHeight.setBounds(320, 70, 100, 20);
        flexConnInterface.add(setSizeHeight);

        JTextField textSizeHeight = new JTextField();
        textSizeHeight.setBounds(440, 70, 50, 20);
        textSizeHeight.setText("0");
        flexConnInterface.add(textSizeHeight);

        JButton saveButton = new JButton("Добавить");
        saveButton.setBounds(650, 70, 100, 20);
        flexConnInterface.add(saveButton);

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
                String flexibleConnectorSize;
                if (textSizeWidth.getText().equals("0") || textSizeHeight.getText().equals("0")) {
                    flexibleConnectorSize = "full size";
                } else {
                    flexibleConnectorSize = textSizeWidth.getText() + " x " + textSizeHeight.getText() + "(h)";
                }

                FlexibleConnector flexibleConnector = new FlexibleConnector(sectionNumber, flexibleConnectorSize, ventilationType);

                if (ventilationType == VentilationType.SUPPLY) {
                    MainInterface.appendSupplyReport(flexibleConnector.sectionToString());
                    MainInterface.appendSupplySections(sectionNumber + SECTION_TEXT);
                    MainInterface.setSupplySectionText(MainInterface.SUPPLY_SECTIONS);
                    MainInterface.setSupplySectionNumber(sectionNumber + 1);
                } else if (ventilationType == VentilationType.EXHAUST) {
                    MainInterface.appendExhaustReport(flexibleConnector.sectionToString());
                    MainInterface.appendExhaustSections(sectionNumber + SECTION_TEXT);
                    MainInterface.setExhaustSectionText(MainInterface.EXHAUST_SECTIONS);
                    MainInterface.setExhaustSectionNumber(sectionNumber + 1);
                }

                flexConnInterface.setVisible(false);
            }
        });
    }
}
