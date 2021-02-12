package utils;

public enum DriverTypes {
    CHROME("chrome"),
    FIREFOX("firefox"),
    OPERA("opera");

    private String type;

    DriverTypes(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static DriverTypes getTypeByStringValue(String value) {
        for (DriverTypes driver : values()) {
            if (driver.getType().equals(value)) {
                return driver;
            }
        }
        throw new IllegalArgumentException("No enum found with value: [" + value + "]");
    }
}
