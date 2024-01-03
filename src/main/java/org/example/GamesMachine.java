package org.example;

public class GamesMachine {
    private String machineName, manufacturer, description, type, media;
    private int initialLaunchYear;
    private double initialPrice;
    private String image;
    private int id;

    /* private void addGamesMachine(GamesMachine gamesMachine){
        gamesMachine.add(gamesMachine);
    } */

    public int getId() {
        return id;
    }

    public void setId(String id) {
        int tempID = 0;
        for (int i = 0; i < id.length(); i++) {
            tempID += id.charAt(i);
        }
        this.id = tempID;
    }

    public GamesMachine(String machineName, String manufacturer, String description, String type, String media, String initialLaunchYear, String initialPrice, String image) {
        setId(machineName);
        setMachineName(machineName);
        setManufacturer(manufacturer);
        setDescription(description);
        setType(type);
        setMedia(media);
        setInitialLaunchYear(initialLaunchYear);
        setInitialPrice(initialPrice);
        setImage(image);
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public int getInitialLaunchYear() {
        return initialLaunchYear;
    }

    public void setInitialLaunchYear(String initialLaunchYear) {
        try {
            this.initialLaunchYear = Integer.parseInt(initialLaunchYear);
        }
        catch (NumberFormatException nfe) {
            this.initialLaunchYear = -1;
        }
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(String initialPrice) {
        try {
            this.initialPrice = Double.parseDouble(initialPrice);
        }
        catch (NumberFormatException nfe){
            this.initialPrice = -1.0;
        }
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "GamesMachine{" +
                "machineName='" + machineName + '\n' +
                ", manufacturer='" + manufacturer + '\n' +
                ", description='" + description + '\n' +
                ", type='" + type + '\n' +
                ", media='" + media + '\n' +
                ", initalLaunchYear=" + initialLaunchYear +
                ", initialPrice=" + initialPrice +
                ", image='" + image + '\n' +
                '}';
    }

    public static void main(String[] args) {
        // Example usage
        GamesMachine gameConsole = new GamesMachine("ConsoleX", "TechCo", "Description of ConsoleX",
                "Gaming Console", "Digital", "2022", "399.99", "https://example.com/consolex.jpg");

        // Accessing fields using getters
        System.out.println("Machine Name: " + gameConsole.getMachineName());
        System.out.println("Manufacturer: " + gameConsole.getManufacturer());
        System.out.println("Description: " + gameConsole.getDescription());
        System.out.println("Type: " + gameConsole.getType());
        System.out.println("Media: " + gameConsole.getMedia());
        System.out.println("Initial Launch Year: " + gameConsole.getInitialLaunchYear());
        System.out.println("Initial Price: $" + gameConsole.getInitialPrice());
        System.out.println("Image URL: " + gameConsole.getImage());
    }
}
