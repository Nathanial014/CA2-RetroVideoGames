package org.example;

public class Game {

    private int id, yearOfRelease;

    private String name, publisher, description, originalDeveloper, gamesMachine, coverArt;

    public int getID() {
        return id;
    }

    public void setID(String id) {
        int tempID = 0;
        for (int i = 0; i < id.length(); i++) {
            tempID += id.charAt(i);
        }
        this.id = tempID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginalDeveloper() {
        return originalDeveloper;
    }

    public void setOriginalDeveloper(String originalDeveloper) {
        this.originalDeveloper = originalDeveloper;
    }

    public String getGamesMachine() {
        return gamesMachine;
    }

    public void setGamesMachine(String gamesMachine) {
        this.gamesMachine = gamesMachine;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        try {
            this.yearOfRelease = yearOfRelease;
        }
        catch(Exception e){
            this.yearOfRelease = -1;
        }
    }

    public String getCoverArt() {
        return coverArt;
    }

    public void setCoverArt(String coverArt) {
        this.coverArt = coverArt;
    }

    public int getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(int initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Game(String name, String publisher, String description, String originalDeveloper, String gamesMachine, int yearOfRelease, String coverArt){
        setID(name);
        setName(name);
        setPublisher(publisher);
        setDescription(description);
        setOriginalDeveloper(originalDeveloper);
        setGamesMachine(gamesMachine);
        setYearOfRelease(yearOfRelease);
        setCoverArt(coverArt);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", description='" + description + '\'' +
                ", originalDeveloper='" + originalDeveloper + '\'' +
                ", gamesMachine='" + gamesMachine + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", coverArt='" + coverArt + '\'' +
                '}';
    }
}
