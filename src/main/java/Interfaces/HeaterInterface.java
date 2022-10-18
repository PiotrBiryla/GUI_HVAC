package Interfaces;

import Sections.Heater;
import Sections.VentilationType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class HeaterInterface {

    private static final String SECTION_TEXT = ". Секция нагрева" + System.lineSeparator();

    public HeaterInterface(VentilationType ventilationType, int sectionNumber) {
        JFrame heaterInterface = new JFrame("Добавление секции нагревателя");
        heaterInterface.setSize(800, 580);
        heaterInterface.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        heaterInterface.setLayout(null);
        heaterInterface.setVisible(true);
        heaterInterface.setLocationRelativeTo(null);
        heaterInterface.setResizable(false);

        JLabel setHeaterSection = new JLabel("Укажите данные добавляемой секции нагрева");
        setHeaterSection.setBounds(20, 20, 760, 15);
        heaterInterface.add(setHeaterSection);

        JRadioButton summerRB = new JRadioButton("Летний нагрев");
        summerRB.setBounds(20, 50, 200, 20);
        JRadioButton winterRB = new JRadioButton("Зимний нагрев");
        winterRB.setBounds(260, 50, 200, 20);
        ButtonGroup summerOrWinter = new ButtonGroup();
        summerOrWinter.add(summerRB);
        summerOrWinter.add(winterRB);
        heaterInterface.add(summerRB);
        heaterInterface.add(winterRB);

        JLabel finsLabel = new JLabel("Материал пластин:");
        finsLabel.setBounds(20, 80, 220, 20);
        JLabel tubesLabel = new JLabel("Материал труб:");
        tubesLabel.setBounds(20, 110, 220, 20);
        JLabel finLabel = new JLabel("Расстояние между пластинами, мм:");
        finLabel.setBounds(20, 140, 220, 20);
        JLabel frameLabel = new JLabel("Материал рамы секции:");
        frameLabel.setBounds(20, 170, 220, 20);
        heaterInterface.add(finsLabel);
        heaterInterface.add(tubesLabel);
        heaterInterface.add(finLabel);
        heaterInterface.add(frameLabel);

        JTextField finsText = new JTextField("aluminum");
        finsText.setBounds(260, 80, 150, 20);
        JTextField tubesText = new JTextField("cooper");
        tubesText.setBounds(260, 110, 150, 20);
        JTextField finText = new JTextField("2.1");
        finText.setBounds(260, 140, 50, 20);
        JTextField frameText = new JTextField("galvanized steel");
        frameText.setBounds(260, 170, 150, 20);
        heaterInterface.add(finsText);
        heaterInterface.add(tubesText);
        heaterInterface.add(finText);
        heaterInterface.add(frameText);

        JLabel inlet = new JLabel("ВОЗДУХ НА ВХОДЕ");
        inlet.setBounds(20, 220, 220, 20);
        heaterInterface.add(inlet);

        JLabel inletParameters = new JLabel("Температура/Отн.влажность:");
        inletParameters.setBounds(20, 250, 220, 20);
        heaterInterface.add(inletParameters);

        JTextField inletTemperature = new JTextField("T_energy recovery");
        inletTemperature.setBounds(260, 250, 150, 20);
        JLabel slash_1 = new JLabel("/");
        slash_1.setBounds(417, 250, 10, 20);
        JTextField inletHumidity = new JTextField("Rh_energy recovery");
        inletHumidity.setBounds(430, 250, 150, 20);
        heaterInterface.add(inletTemperature);
        heaterInterface.add(slash_1);
        heaterInterface.add(inletHumidity);

        JLabel outlet = new JLabel("ВОЗДУХ НА ВЫХОДЕ");
        outlet.setBounds(20, 300, 220, 20);
        heaterInterface.add(outlet);

        JLabel outletParameters = new JLabel("Температура/Отн.влажность, °C/°C:");
        outletParameters.setBounds(20, 330, 220, 20);
        heaterInterface.add(outletParameters);

        JTextField outletTemperature = new JTextField("20.0");
        outletTemperature.setBounds(260, 330, 50, 20);
        JLabel slash_2 = new JLabel("/");
        slash_2.setBounds(317, 330, 10, 20);
        JTextField outletHumidity = new JTextField("1.9");
        outletHumidity.setBounds(330, 330, 50, 20);
        heaterInterface.add(outletTemperature);
        heaterInterface.add(slash_2);
        heaterInterface.add(outletHumidity);

        JLabel mediumTypeLabel = new JLabel("ДАННЫЕ ТЕПЛОНОСИТЕЛЯ");
        mediumTypeLabel.setBounds(20, 380, 220, 20);
        heaterInterface.add(mediumTypeLabel);

        JLabel waterGlycolLabel = new JLabel("Вода/Гликоль");
        waterGlycolLabel.setBounds(20, 410, 220, 20);
        heaterInterface.add(waterGlycolLabel);

        JTextField mediumText = new JTextField("Пропиленгликоль 40%");
        mediumText.setBounds(260, 410, 150, 20);
        heaterInterface.add(mediumText);

        JLabel intakeLabel = new JLabel("График теплоносителя, °C/°C:");
        intakeLabel.setBounds(20, 440, 220, 20);
        heaterInterface.add(intakeLabel);

        JTextField mediumParametersText = new JTextField("80.0/60.0");
        mediumParametersText.setBounds(260, 440, 65, 20);
        heaterInterface.add(mediumParametersText);

        JLabel pressureLabel = new JLabel("Потеря давления, кПа");
        pressureLabel.setBounds(20, 470, 220, 20);
        heaterInterface.add(pressureLabel);

        JTextField pressureText = new JTextField("25");
        pressureText.setBounds(260, 470, 50, 20);
        heaterInterface.add(pressureText);

        JButton saveButton = new JButton("Добавить");
        saveButton.setBounds(650, 470, 100, 20);
        heaterInterface.add(saveButton);

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

                String heaterType = summerRB.isSelected() ? "SUMMER" : "WINTER";
                String inletParameters = inletTemperature.getText() + "/" + inletHumidity.getText();
                String outletParameters = outletTemperature.getText() + "/" + outletHumidity.getText();

                Heater heater = new Heater(sectionNumber, heaterType, finsText.getText(), tubesText.getText(),
                        finText.getText(), frameText.getText(), inletParameters, outletParameters,
                        mediumText.getText(), mediumParametersText.getText(), pressureText.getText() , ventilationType);

                    MainInterface.appendSupplyReport(heater.sectionToString());
                    MainInterface.appendSupplySections(sectionNumber + SECTION_TEXT);
                    MainInterface.setSupplySectionText(MainInterface.SUPPLY_SECTIONS);
                    MainInterface.setSupplySectionNumber(sectionNumber + 1);

                heaterInterface.setVisible(false);
            }
        });

    }
}
