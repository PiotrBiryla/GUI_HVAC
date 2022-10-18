package Sections;

public class ExternalDamper implements Section{

    int sectionNumber;
    String actuatorStatus;
    VentilationType ventilationType;

    public ExternalDamper(int sectionNumber, String actuatorStatus, VentilationType ventilationType) {
        this.sectionNumber = sectionNumber;
        this.actuatorStatus = actuatorStatus;
        this.ventilationType = ventilationType;
    }

    @Override
    public StringBuilder sectionToString() {
        StringBuilder toString = new StringBuilder();
        toString.append(sectionNumber);
        toString.append("   External damper").append("                        ").append(actuatorStatus).append(System.lineSeparator());
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
        toJSON.append("{\"actuator_status\": ").append(actuatorStatus).append("}").append(System.lineSeparator());
        toJSON.append("],").append(System.lineSeparator()).append("}");

        return toJSON;
    }
}
