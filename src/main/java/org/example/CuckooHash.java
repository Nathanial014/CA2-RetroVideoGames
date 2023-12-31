package org.example;

import java.lang.reflect.Array;
import java.util.function.Function;

public class CuckooHash<T> {
    T[][] hashTable; //table/item
    transient Function<T,Integer>[] hashFunctions;

    public CuckooHash(int numOfTables, int numOfItems, Function<T,Integer>... fn) {
        hashTable = (T[][])new Object [numOfTables][numOfItems];
        hashFunctions=fn;
    }

    public int hashFunction(T key, int table){
        return hashFunctions[table].apply(key);
    }

    public void setHashFunctions(Function<T, Integer>... fn){
        hashFunctions=fn;
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
        for (T[] ts : hashTable)
            for (T t : ts)
                if (t != null)
                    str += "\n" + t;
        return str;
    }

    public int size() {
        int size = 0;
        for (T[] ts : hashTable)
            for (T t : ts)
                if (t != null)
                    size++;
        return size;
    }

    public T[] returnElements(Class clas){
        T[] elements = (T[]) Array.newInstance(clas, size());
        int i = 0;
            for (T[] ts : hashTable)
                for (T t : ts)
                    if (t != null) {
                        elements[i] = t;
                        i++;
                    }
        return elements;
    }

    public T search(String name){
        for (T[] ts : hashTable)
            for (T t : ts)
                if (t != null && t.toString().contains(name))
                    return t;
        return null;
    }

    public T[] searchList(Class clas, String name) {
        T[] elements = (T[]) Array.newInstance(clas, size());
        int i = 0;
        for (T[] ts : hashTable)
            for (T t : ts)
                if (t != null && t.toString().contains(name))
                    elements[i++] = t;
        return elements;
    }

//    public T hashSearch(String name){
//        for (Function<T, Integer> hashFunction : hashFunctions) {
//        int loc = hashFunction.apply(id(name));
//        }
//    }

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

    public void delete(String item) {
        delete(0, search(item));
    }

    public void delete(int table, T item){
        System.out.println("Attempting to delete item" + item + " in table " + table);
        int loc=hashFunction(item,table);
        if(hashTable[table][loc]==item){
            hashTable[table][loc]=null;
            System.out.println("Deleted item " + item + " in table " + table + " at location " + loc);
        }
        else {
            delete(table+1, item);
        }
    }
}
