package Sections;

public class Heater implements Section {

    int sectionNumber;
    String heaterType;
    String finsMaterial;
    String tubesMaterial;
    String finSpacing;
    String frameMaterial;
    String inletParameters;
    String outletParameters;
    String mediumType;
    String mediumTemperatures;
    String pressureDrop;
    VentilationType ventilationType;

    public Heater(int sectionNumber, String heaterType, String finsMaterial, String tubesMaterial, String finSpacing,
                  String frameMaterial, String inletParameters, String outletParameters, String mediumType,
                  String mediumTemperatures, String pressureDrop, VentilationType ventilationType) {
        this.sectionNumber = sectionNumber;
        this.heaterType = heaterType;
        this.finsMaterial = finsMaterial;
        this.tubesMaterial = tubesMaterial;
        this.finSpacing = finSpacing;
        this.frameMaterial = frameMaterial;
        this.inletParameters = inletParameters;
        this.outletParameters = outletParameters;
        this.mediumType = mediumType;
        this.mediumTemperatures = mediumTemperatures;
        this.pressureDrop = pressureDrop;
        this.ventilationType = ventilationType;
    }

    @Override
    public StringBuilder sectionToString() {
        StringBuilder toString = new StringBuilder();
        toString.append(sectionNumber);
        toString.append("   Heater ").append(heaterType).append(System.lineSeparator());
        toString.append("    Fins:").append("                                  ").append(finsMaterial).append(System.lineSeparator());
        toString.append("    Tubes:").append("                                 ").append(tubesMaterial).append(System.lineSeparator());
        toString.append("    Fin spacing:").append("                           ").append(finSpacing).append(" mm").append(System.lineSeparator());
        toString.append("    Frame:").append("                                 ").append(frameMaterial).append(System.lineSeparator().repeat(2));
        toString.append("    inlet").append(System.lineSeparator());
        toString.append("    temperature/rel. humidity").append("    °C/%      ").append(inletParameters).append(System.lineSeparator());
        toString.append("    outlet").append(System.lineSeparator());
        toString.append("    temperature/rel. humidity").append("    °C/%      ").append(outletParameters).append(System.lineSeparator());
        toString.append("    medium type").append(System.lineSeparator());
        toString.append("    water/glycol:").append("                          ").append(mediumType).append(System.lineSeparator());
        toString.append("    intake/discharge").append("             °C/°C     ").append(mediumTemperatures).append(System.lineSeparator());
        toString.append("    pressure drop").append("                kPa       <").append(pressureDrop).append(System.lineSeparator());
        toString.append(System.lineSeparator());

        return toString;
    }

    @Override
    public StringBuilder toJSON() {
        return null;
    }
}
