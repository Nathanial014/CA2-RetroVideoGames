public class GamePort {
    private String originalGamePort, newGameMachinePortTo, portDeveloper;
    private int releaseYearOfPort;
    private String coverArt;

    public GamePort(String originalGamePort, String newGameMachinePortTo, String portDeveloper, int releaseYearOfPort, String coverArt) {
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

    public void setReleaseYearOfPort(int releaseYearOfPort) {
        this.releaseYearOfPort = releaseYearOfPort;
    }

    public String getCoverArt() {
        return coverArt;
    }

    public void setCoverArt(String coverArt) {
        this.coverArt = coverArt;
    }
}
