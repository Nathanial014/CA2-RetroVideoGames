import java.util.function.Function;

public class CuckooHash {
    int[][] hashTable; //table/item
    Function<Integer,Integer>[] hashFunctions;

    public CuckooHash(int numOfTables, int numOfItems, Function<Integer,Integer>... fn) {
        hashTable=new int [numOfTables][numOfItems];
        hashFunctions=fn;
    }

    public int hashFunction(int key, int table){
        return hashFunctions[table].apply(key);
    }

    public void displayHashTables(){
        for(int t=0;t<hashTable.length;t++){
            System.out.println("\nTable "+t+"\n==========");
            for(int i=0;i<hashTable[t].length;i++)
                System.out.println(i+". "+hashTable[t][i]);
        }
    }

    public void add(int item) {
        add(0,item);
    }
    public void add(int table,int item){
        System.out.println("Attempting to store item "+item+" in table "+table);
        int loc=hashFunction(item,table);
        if(hashTable[table][loc]==0) { //Free - use it!
            hashTable[table][loc]=item;
            System.out.println("Stored item "+item+" in table "+table+" at location "+loc);
        }
        else { //Not free - evict! Cuckoo!
            int outItem=hashTable[table][loc];
            hashTable[table][loc]=item;
            System.out.println("Cuckoo! Evicting item "+outItem+" from, and storing "+item+" in, table "+table+" at location "+loc);
            add((table+1)%hashTable.length,outItem);
        }
    }

    public static void main(String[] args){
        CuckooHash ch=new CuckooHash(3,10,k->k%10,k->(k*13)%10,k->((k*19)/2)%10);
        ch.add(55);
        ch.add(77);
        ch.add(88);
        ch.add(107);
        ch.add(543);
        ch.add(235);
        ch.add(890);
        ch.add(11);
        ch.add(199);
        ch.add(439);
        ch.add(5555);
        ch.add(548);
        ch.add(111);
        ch.add(34567);
        ch.add(505);


        ch.displayHashTables();
    }

}
