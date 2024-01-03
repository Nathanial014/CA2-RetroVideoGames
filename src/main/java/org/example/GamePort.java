package org.example;

public class GamePort {
    private String originalGamePort, newGameMachinePortTo, portDeveloper;
    private int releaseYearOfPort;
    private String coverArt;

    private int id;

    public int getId() {
        return id;
    }

    public void setID(String id) {
        int tempID = 0;
        for (int i = 0; i < id.length(); i++) {
            tempID += id.charAt(i);
        }
        this.id = tempID;
    }

    public GamePort(String originalGamePort, String newGameMachinePortTo, String portDeveloper, String releaseYearOfPort, String coverArt) {
        setID(originalGamePort);
        setOriginalGamePort(originalGamePort);
        setNewGameMachinePortTo(newGameMachinePortTo);
        setPortDeveloper(portDeveloper);
        setReleaseYearOfPort(releaseYearOfPort);
        setCoverArt(coverArt);
    }

    public String getOriginalGamePort() {
        return originalGamePort;
    }

    public void setOriginalGamePort(String originalGamePort) {
        this.originalGamePort = originalGamePort;
    }

    public String getNewGameMachinePortTo() {
        return newGameMachinePortTo;
    }

    public void setNewGameMachinePortTo(String newGameMachinePortTo) {
        this.newGameMachinePortTo = newGameMachinePortTo;
    }

    public String getPortDeveloper() {
        return portDeveloper;
    }

    public void setPortDeveloper(String portDeveloper) {
        this.portDeveloper = portDeveloper;
    }

    public int getReleaseYearOfPort() {
        return releaseYearOfPort;
    }

    public void setReleaseYearOfPort(String releaseYearOfPort) {
        try {
            this.releaseYearOfPort = Integer.parseInt(releaseYearOfPort);
        }
        catch (NumberFormatException nfe) {
            this.releaseYearOfPort = -1;
        }
    }

    public String getCoverArt() {
        return coverArt;
    }

    public void setCoverArt(String coverArt) {
        this.coverArt = coverArt;
    }

    @Override
    public String toString() {
        return "GamePort{" +
                "originalGamePort='" + originalGamePort + '\'' +
                ", newGameMachinePortTo='" + newGameMachinePortTo + '\'' +
                ", portDeveloper='" + portDeveloper + '\'' +
                ", releaseYearOfPort=" + releaseYearOfPort +
                ", coverArt='" + coverArt + '\'' +
                ", id=" + id +
                '}';
    }
}
