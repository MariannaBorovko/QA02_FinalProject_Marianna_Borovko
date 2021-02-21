package utils;

public class DriverManagerFactory {
    public static DriverManager getManager(DriverTypes type) {

        DriverManager driverManager;

        switch (type) {
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            case OPERA:
                driverManager = new OperaDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}
