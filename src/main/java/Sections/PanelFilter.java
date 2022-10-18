package Sections;

public class PanelFilter implements Section {

    int sectionNumber;
    String filtrationClass;
    String pressure;
    VentilationType ventilationType;

    public PanelFilter(int sectionNumber, String filtrationClass, String pressure, VentilationType ventilationType) {
        this.sectionNumber = sectionNumber;
        this.filtrationClass = filtrationClass;
        this.pressure = pressure;
        this.ventilationType = ventilationType;
    }

    @Override
    public StringBuilder sectionToString() {
        StringBuilder toString = new StringBuilder();
        toString.append(sectionNumber);
        toString.append("   Panel filter").append(System.lineSeparator());
        toString.append("    class ISO 16890").append("                        ").append("ePM10/55%").append(System.lineSeparator());
        toString.append("    class").append("                                  ").append(filtrationClass).append(System.lineSeparator());
        toString.append("    Pressure drops for fan calculation").append("     ").append(pressure).append(" Pa");
        toString.append(System.lineSeparator().repeat(2));

        return toString;
    }

    @Override
    public StringBuilder toJSON() {
        StringBuilder toJSON = new StringBuilder();
        toJSON.append("{").append(System.lineSeparator());
        toJSON.append("\"section_number\": ").append(sectionNumber).append(",").append(System.lineSeparator());
        toJSON.append("\"ventilation_type\": ").append(ventilationType).append(",").append(System.lineSeparator());
        toJSON.append("\"section_type\": ").append(this.getClass().getSimpleName()).append(",").append(System.lineSeparator());
        toJSON.append("\"section_parameters\":[").append(System.lineSeparator());
        toJSON.append("{\"filtration_class\": ").append(filtrationClass).append("},").append(System.lineSeparator());
        toJSON.append("{\"pressure\": ").append(pressure).append("}").append(System.lineSeparator());
        toJSON.append("],").append(System.lineSeparator()).append("}").append(System.lineSeparator());

        return toJSON;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }
}
