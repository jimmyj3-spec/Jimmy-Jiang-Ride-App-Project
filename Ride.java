package labs.lab9;

public class Ride {

    private String name;

    private String pickupCity;
    private String dropCity;
    private int pickupZip;
    private int dropZip;

//    private int passengers;
    private boolean express;

    private String assignedDriver; 

    public Ride(String name,
                String pickupCity, String dropCity,
                int pickupZip, int dropZip,
                int passengers, boolean express) {

    	
        this.name = name;
        this.pickupCity = pickupCity;
        this.dropCity = dropCity;
        this.pickupZip = pickupZip;
        this.dropZip = dropZip;

//        this.passengers = passengers;
        this.express = express;

        this.assignedDriver = null;
    }

    public double calculatePrice() {
        double total = 20;
        total += Math.abs(pickupZip - dropZip);

        if (express) {
            total *= 1.1;
        }

        return total;
    }

    public String queueSummary() {
        String priceStr = String.format("$%.2f", calculatePrice());

        if (assignedDriver == null) {
            return String.format(
                "Ride for %s from %s to %s for %s requested",
                name, pickupCity, dropCity, priceStr
            );
        } else {
            return String.format(
                "Ride for %s from %s to %s for %s claimed by driver %s",
                name, pickupCity, dropCity, priceStr, assignedDriver
            );
        }
    }

    public void setAssignedDriver(String driver) {
        this.assignedDriver = driver;
    }
    
    public boolean isAssigned() {
        return assignedDriver != null;
    }
    
    public String getAssignedDriver() {
    	return assignedDriver;
    }
    
    
    
    
}
