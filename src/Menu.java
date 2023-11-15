public class Menu {

    public static void main (String[] args) {
        CuckooHash game = new CuckooHash(3, 100);
        game.add("name", "publisher",  "description", "originalDeveloper", "gamesMachine", 2003, "image");
        game[1] = new Game("name1", "publisher1",  "description1", "originalDeveloper1", "gamesMachine1", 20031, "image1");
        for (Game value : game) {
            System.out.println(value);
        }
    }
}