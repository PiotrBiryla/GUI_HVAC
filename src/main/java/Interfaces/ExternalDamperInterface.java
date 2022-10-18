package Interfaces;

import Sections.ExternalDamper;
import Sections.VentilationType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class ExternalDamperInterface {

    private static final String SECTION_TEXT = ". Заслонка" + System.lineSeparator();

    public ExternalDamperInterface(VentilationType ventilationType, int sectionNumber) {
        JFrame extDampInterface = new JFrame("Добавление заслонки");
        extDampInterface.setSize(800, 130);
        extDampInterface.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        extDampInterface.setLayout(null);
        extDampInterface.setVisible(true);
        extDampInterface.setLocationRelativeTo(null);
        extDampInterface.setResizable(false);

        JLabel setActuatorStatus = new JLabel("Укажите требуется ли привод к заслонке");
        setActuatorStatus.setBounds(20, 20, 760, 15);
        extDampInterface.add(setActuatorStatus);

        JRadioButton noActuator = new JRadioButton("без привода");
        noActuator.setSelected(true);
        noActuator.setBounds(20, 50, 100, 20);
        extDampInterface.add(noActuator);

        JRadioButton withActuator = new JRadioButton("с приводом");
        withActuator.setBounds(150, 50, 100, 20);
        extDampInterface.add(withActuator);

        ButtonGroup actuatorStatusGroup = new ButtonGroup();
        actuatorStatusGroup.add(noActuator);
        actuatorStatusGroup.add(withActuator);

        JButton saveButton = new JButton("Добавить");
        saveButton.setBounds(650, 50, 100, 20);
        extDampInterface.add(saveButton);

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
                String actuatorStatus = "";
                if (noActuator.isSelected()) {
                    actuatorStatus = "without actuator";
                } else if (withActuator.isSelected()) {
                    actuatorStatus = "with actuator";
                }

                ExternalDamper externalDamper = new ExternalDamper(sectionNumber, actuatorStatus, ventilationType);

                if (ventilationType == VentilationType.SUPPLY) {
                    MainInterface.appendSupplyReport(externalDamper.sectionToString());
                    MainInterface.appendSupplySections(sectionNumber + SECTION_TEXT);
                    MainInterface.setSupplySectionText(MainInterface.SUPPLY_SECTIONS);
                    MainInterface.setSupplySectionNumber(sectionNumber + 1);
                } else if (ventilationType == VentilationType.EXHAUST) {
                    MainInterface.appendExhaustReport(externalDamper.sectionToString());
                    MainInterface.appendExhaustSections(sectionNumber + SECTION_TEXT);
                    MainInterface.setExhaustSectionText(MainInterface.EXHAUST_SECTIONS);
                    MainInterface.setExhaustSectionNumber(sectionNumber + 1);
                }

                extDampInterface.setVisible(false);
            }
        });
    }
}
