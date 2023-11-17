import java.util.function.Function;

public class CuckooHash<T> {
    T[][] hashTable; //table/item
    Function<T,Integer>[] hashFunctions;

    public CuckooHash(int numOfTables, int numOfItems, Function<T,Integer>... fn) {
        hashTable = (T[][])new Object [numOfTables][numOfItems];
        hashFunctions=fn;
    }

    public int hashFunction(T key, int table){
        return hashFunctions[table].apply(key);
    }

    public String displayHashTables(){
        String str = "";
        for(int t=0;t<hashTable.length;t++){
            str += "\nTable "+t+"\n==========";
            for(int i=0;i<hashTable[t].length;i++)
                str += "\n"+i+". "+hashTable[t][i];
        }
        return str;
    }

    public String displayElements(){
        String str = "";
        for(int t=0;t<hashTable.length;t++)
            for(int i=0;i<hashTable[t].length;i++)
                if(hashTable[t][i]!=null)
                    str += "\n"+hashTable[t][i];
        return str;
    }

    public void add(T item) {
        add(0,item);
    }

    public void add(int table,T item){
        System.out.println("Attempting to store item "+item+" in table "+table);
        int loc=hashFunction(item,table);
        if(hashTable[table][loc]==null) { //Free - use it!
            hashTable[table][loc]=item;
            System.out.println("Stored item "+item+" in table "+table+" at location "+loc);
        }
        else { //Not free - evict! Cuckoo!
            T outItem=hashTable[table][loc];
            hashTable[table][loc]=item;
            System.out.println("Cuckoo! Evicting item "+outItem+" from, and storing "+item+" in, table "+table+" at location "+loc);
            add((table+1)%hashTable.length,outItem);
        }
    }
}
