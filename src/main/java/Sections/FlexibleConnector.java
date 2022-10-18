package Sections;

public class FlexibleConnector implements Section {

    int sectionNumber;
    String size;
    VentilationType ventilationType;

    public FlexibleConnector(int sectionNumber, String size, VentilationType ventilationType) {
        this.sectionNumber = sectionNumber;
        this.size = size;
        this.ventilationType = ventilationType;
    }

    @Override
    public StringBuilder sectionToString() {
        StringBuilder toString = new StringBuilder();
        toString.append(sectionNumber);
        toString.append("   Duct connector flexible").append("                ").append("(").append(size).append(")").append(System.lineSeparator());
        toString.append(System.lineSeparator());
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
        toJSON.append("{\"size\": ").append(size).append("}").append(System.lineSeparator());
        toJSON.append("],").append(System.lineSeparator()).append("}");

        return toJSON;
    }
}
