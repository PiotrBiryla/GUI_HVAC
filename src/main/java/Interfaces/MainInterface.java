package Interfaces;

import Sections.VentilationType;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainInterface {

    private static int supplySectionNumber = 1;
    private static int exhaustSectionNumber = 1;
    private static final StringBuilder SUPPLY_SYSTEM_REPORT = new StringBuilder();
    private static final StringBuilder EXHAUST_SYSTEM_REPORT = new StringBuilder();
    public static final StringBuilder SUPPLY_FIRST_SECTION = new StringBuilder("SUPPLY SYSTEM" + System.lineSeparator()
            + "sections in the direction of air movement:" + System.lineSeparator().repeat(2));
    public static final StringBuilder EXHAUST_FIRST_SECTION = new StringBuilder("EXHAUST SYSTEM" + System.lineSeparator()
            + "sections in the direction of air movement:" + System.lineSeparator().repeat(2));
    public static final StringBuilder SUPPLY_SECTIONS = new StringBuilder("ПРИТОЧНАЯ СИСТЕМА:").append(System.lineSeparator());
    public static final StringBuilder EXHAUST_SECTIONS = new StringBuilder("ВЫТЯЖНАЯ СИСТЕМА:").append(System.lineSeparator());

    private static final JTextArea supplySections = new JTextArea();
    private static final JTextArea exhaustSections = new JTextArea();
    private static final JRadioButton SupplyRB = new JRadioButton("Приточная установка");
    private static final JRadioButton ExhaustRB = new JRadioButton("Вытяжная установка");
    private static final JRadioButton SupplyExhaustRB = new JRadioButton("Приточно-вытяжная установка");

    public MainInterface() {

        JFrame mainInterface = new JFrame("Создание вентиляционной установки");
        mainInterface.setSize(1000, 700);
        mainInterface.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainInterface.setLayout(null);
        mainInterface.setVisible(true);
        mainInterface.setLocationRelativeTo(null);
        mainInterface.setResizable(false);

        JLabel SelectVentilationSystemType = new JLabel("Выберите тип создаваемой вентиляционной установки:");
        SelectVentilationSystemType.setBounds(20, 20, 760, 15);
        mainInterface.add(SelectVentilationSystemType);

        SupplyRB.setBounds(20, 50, 150, 20);
        ExhaustRB.setBounds(200, 50, 150, 20);
        SupplyExhaustRB.setBounds(370, 50, 250, 20);
        ButtonGroup ventilationTypeSelect = new ButtonGroup();
        ventilationTypeSelect.add(SupplyRB);
        ventilationTypeSelect.add(ExhaustRB);
        ventilationTypeSelect.add(SupplyExhaustRB);
        mainInterface.add(SupplyRB);
        mainInterface.add(ExhaustRB);
        mainInterface.add(SupplyExhaustRB);

        JPanel supplyPanel = new JPanel();
        supplyPanel.setLayout(null);
        supplyPanel.setBounds(20, 100, 730, 200);
        mainInterface.add(supplyPanel);

        JPanel exhaustPanel = new JPanel();
        exhaustPanel.setLayout(null);
        exhaustPanel.setBounds(20, 300, 730, 200);
        mainInterface.add(exhaustPanel);

        JLabel addSupplySection = new JLabel("ПРИТОЧНЫЙ ВОЗДУХ. Выберите секцию, которую хотите добавить");
        addSupplySection.setBounds(0, 0, 760, 15);
        supplyPanel.add(addSupplySection);

        JButton sup_FlexConnButton = new JButton("Гибкая вставка");
        sup_FlexConnButton.setBounds(0, 30, 160, 30);
        supplyPanel.add(sup_FlexConnButton);

        JButton sup_ExtDampButton = new JButton("Заслонка");
        sup_ExtDampButton.setBounds(180, 30, 160, 30);
        supplyPanel.add(sup_ExtDampButton);

        JButton sup_PanFilButton = new JButton("Панельный фильтр");
        sup_PanFilButton.setBounds(360, 30, 160, 30);
        supplyPanel.add(sup_PanFilButton);

        JButton sup_BagFilButton = new JButton("Карманный фильтр");
        sup_BagFilButton.setBounds(540, 30, 160, 30);
        supplyPanel.add(sup_BagFilButton);

        JButton sup_HeaterButton = new JButton("Секция нагрева");
        sup_HeaterButton.setBounds(0, 90, 160, 30);
        supplyPanel.add(sup_HeaterButton);


        JLabel addExhaustSection = new JLabel("ВЫТЯЖНОЙ ВОЗДУХ. Выберите секцию, которую хотите добавить");
        addExhaustSection.setBounds(0, 0, 760, 15);
        exhaustPanel.add(addExhaustSection);

        JButton ext_FlexConnButton = new JButton("Гибкая вставка");
        ext_FlexConnButton.setBounds(0, 30, 160, 30);
        exhaustPanel.add(ext_FlexConnButton);

        JButton ext_ExtDampButton = new JButton("Заслонка");
        ext_ExtDampButton.setBounds(180, 30, 160, 30);
        exhaustPanel.add(ext_ExtDampButton);

        JButton ext_PanFilButton = new JButton("Панельный фильтр");
        ext_PanFilButton.setBounds(360, 30, 160, 30);
        exhaustPanel.add(ext_PanFilButton);

        JButton ext_BagFilButton = new JButton("Карманный фильтр");
        ext_BagFilButton.setBounds(540, 30, 160, 30);
        exhaustPanel.add(ext_BagFilButton);

        JButton saveToPdf = new JButton("Сохранить в PDF");
        saveToPdf.setBounds(560, 600, 160, 30);
        mainInterface.add(saveToPdf);

        supplySections.setEditable(false);
        supplySections.setBounds(750, 20, 210, 300);
        mainInterface.add(supplySections);

        exhaustSections.setEditable(false);
        exhaustSections.setBounds(750, 340, 210, 300);
        mainInterface.add(exhaustSections);

        SupplyRB.addActionListener(new Action() {
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
                supplyPanel.setVisible(true);
                exhaustPanel.setVisible(false);
            }
        });

        ExhaustRB.addActionListener(new Action() {
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
                supplyPanel.setVisible(false);
                exhaustPanel.setVisible(true);
            }
        });

        SupplyExhaustRB.addActionListener(new Action() {
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
                supplyPanel.setVisible(true);
                exhaustPanel.setVisible(true);
            }
        });

        sup_FlexConnButton.addActionListener(new Action() {
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
                FlexibleConnectorInterface flexibleConnectorInterface =
                    new FlexibleConnectorInterface(VentilationType.SUPPLY, supplySectionNumber);
            }
        });

        sup_ExtDampButton.addActionListener(new Action() {
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
                ExternalDamperInterface externalDamperInterface =
                    new ExternalDamperInterface(VentilationType.SUPPLY, supplySectionNumber);
            }
        });

        sup_PanFilButton.addActionListener(new Action() {
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
                PanelFilterInterface panelFilterInterface =
                    new PanelFilterInterface(VentilationType.SUPPLY, supplySectionNumber);
            }
        });

        sup_BagFilButton.addActionListener(new Action() {
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
                BagFilterInterface bagFilterInterface =
                    new BagFilterInterface(VentilationType.SUPPLY, supplySectionNumber);
            }
        });

        sup_HeaterButton.addActionListener(new Action() {
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
                HeaterInterface heaterInterface = new HeaterInterface(VentilationType.SUPPLY, supplySectionNumber);
            }
        });

        ext_FlexConnButton.addActionListener(new Action() {
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
                FlexibleConnectorInterface flexibleConnectorInterface =
                    new FlexibleConnectorInterface(VentilationType.EXHAUST, exhaustSectionNumber);
            }
        });

        ext_ExtDampButton.addActionListener(new Action() {
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
                ExternalDamperInterface externalDamperInterface =
                    new ExternalDamperInterface(VentilationType.EXHAUST, exhaustSectionNumber);
            }
        });

        ext_PanFilButton.addActionListener(new Action() {
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
                PanelFilterInterface panelFilterInterface =
                    new PanelFilterInterface(VentilationType.EXHAUST, exhaustSectionNumber);
            }
        });

        ext_BagFilButton.addActionListener(new Action() {
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
                BagFilterInterface bagFilterInterface =
                    new BagFilterInterface(VentilationType.EXHAUST, exhaustSectionNumber);
            }
        });

        saveToPdf.addActionListener(new Action() {
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
                FileDialog fileDialog = new FileDialog(new Frame(), "Сохранить", FileDialog.SAVE);
                fileDialog.setVisible(true);
                String path = fileDialog.getDirectory() + fileDialog.getFile();
                File file = new File(path);
                Document document = new Document(PageSize.A4);

                Font font = new Font(Font.FontFamily.COURIER, 12);
                Font fontBold = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);

                try {
                    PdfWriter.getInstance(document, new FileOutputStream(file));
                    document.open();

                    StringBuilder report;
                    if (isSupplySelected()) {
                        Paragraph supParagraph = new Paragraph(SUPPLY_FIRST_SECTION.toString(), fontBold);
                        document.add(supParagraph);
                        report = getSupplySystemReport();
                        Paragraph mainParagraph = new Paragraph(report.toString(), font);
                        document.add(mainParagraph);
                    } else if (isExhaustSelected()) {
                        Paragraph extParagraph = new Paragraph(EXHAUST_FIRST_SECTION.toString(), fontBold);
                        document.add(extParagraph);
                        report = getExhaustSystemReport();
                        Paragraph mainParagraph = new Paragraph(report.toString(), font);
                        document.add(mainParagraph);
                    } else if (isSupplyExhaustSelected()) {
                        Paragraph supParagraph = new Paragraph(SUPPLY_FIRST_SECTION.toString(), fontBold);
                        document.add(supParagraph);
                        report = getSupplySystemReport();
                        Paragraph mainParagraph = new Paragraph(report.toString(), font);
                        document.add(mainParagraph);
                        Paragraph extParagraph = new Paragraph(EXHAUST_FIRST_SECTION.toString(), fontBold);
                        document.add(extParagraph);
                        report = getExhaustSystemReport();
                        mainParagraph = new Paragraph(report.toString(), font);
                        document.add(mainParagraph);
                    }

                    document.close();
                } catch (DocumentException | FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    public static void setSupplySectionNumber(int supplySectionNumber) {
        MainInterface.supplySectionNumber = supplySectionNumber;
    }

    public static void setExhaustSectionNumber(int exhaustSectionNumber) {
        MainInterface.exhaustSectionNumber = exhaustSectionNumber;
    }

    public static StringBuilder getSupplySystemReport() {
        return SUPPLY_SYSTEM_REPORT;
    }

    public static void appendSupplyReport(StringBuilder systemReport) {
        SUPPLY_SYSTEM_REPORT.append(systemReport);
    }

    public static StringBuilder getExhaustSystemReport() {
        return EXHAUST_SYSTEM_REPORT;
    }

    public static void appendExhaustReport(StringBuilder systemReport) {
        EXHAUST_SYSTEM_REPORT.append(systemReport);
    }

    public static void appendSupplySections(String section) {
        SUPPLY_SECTIONS.append(section);
    }

    public static void appendExhaustSections(String section) {
        EXHAUST_SECTIONS.append(section);
    }

    public static void setSupplySectionText(StringBuilder sectionText) {
        supplySections.setText(sectionText.toString());
    }

    public static void setExhaustSectionText(StringBuilder sectionText) {
        exhaustSections.setText(sectionText.toString());
    }

    public static boolean isSupplySelected() {
        return SupplyRB.isSelected();
    }

    public static boolean isExhaustSelected() {
        return ExhaustRB.isSelected();
    }

    public static boolean isSupplyExhaustSelected() {
        return SupplyExhaustRB.isSelected();
    }
}
