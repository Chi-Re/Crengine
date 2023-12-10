package crengine.util.serialization;

import crengine.base.func.Boolf;

public class Structs {
    public static <T> T find(T[] array, Boolf<T> value){
        for(T t : array){
            if(value.get(t)) return t;
        }
        return null;
    }
}
