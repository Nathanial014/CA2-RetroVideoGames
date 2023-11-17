public class Menu {
    public static void main (String[] args) {
        CuckooHash game = new CuckooHash<Game>(3, 15, k->k.getID()%15,k->(k.getID()*13)%15,k->((k.getID()*19)/2)%15);
        game.add(new Game("name2", "publisher2",  "description2", "originalDeveloper2", "gamesMachine2", 20369, "image2"));
        game.add(new Game("name1", "publisher1",  "description1", "originalDeveloper1", "gamesMachine1", 20031, "image1"));
        game.add(new Game("name7", "publisher1",  "description1", "originalDeveloper1", "gamesMachine1", 20031, "image1"));
        game.add(new Game("name7", "publisher1",  "description1", "originalDeveloper1", "gamesMachine1", 20031, "image1"));
        System.out.println(game.displayHashTables());       //Display entire table
        System.out.println(game.displayElements());         //Display just the elements in game
        System.out.println(game.search("name2"));     //search for a game called name2


        //Games machine currently needs a getID() and setID() method for the following code to work.

        /*CuckooHash gamesMachine = new CuckooHash<GamesMachine>(3, 15, k->k.getId()%10,k->(k.getId()*13)%10,k->((k.getId()*19)/2)%10);
        gamesMachine.add(new GamesMachine("machineName", "manufacturer", "description", "type", "media", 2003, 19.99, "image"));
        gamesMachine.add(new GamesMachine("machineName2", "manufacturer2", "description2", "type2", "media2", 2003, 19.99, "image2"));
        gamesMachine.add(new GamesMachine("machineName2", "manufacturer2", "description2", "type2", "media2", 2003, 19.99, "image2"));
        System.out.println(gamesMachine.displayHashTables());
        System.out.println(gamesMachine.displayElements());
        System.out.println("game.search("machineName2"));*/
    }
}