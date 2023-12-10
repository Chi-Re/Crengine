package crengine.util.serialization;

import crengine.util.exception.CrengineRuntimeException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**我想...可能没有用?*/
public class ObjectMap<K, T> {
    private final Map<K,T> map;

    public ObjectMap(){
        this.map = new HashMap<>();
    }

    /**更严格的方式，会判断是否已经存在*/
    public void add(K key, T value){
        if (havaKey(key)){
            throw new CrengineRuntimeException("写入 \""+key+"\" 时发现key重复 \""+value.toString()+"\" 写入失败");
        }
        this.map.put(key, value);
    }

    /**更宽松的方式，会覆盖已经存在的值*/
    public void put(K key, T value){
        this.map.put(key, value);
    }

    public T get(K key){
        return this.map.get(key);
    }

    public Map<K,T> getMap(){
        return this.map;
    }

    public Set<K> getKeys(){
        return this.map.keySet();
    }
    public Collection<T> getValue(){
        return this.map.values();
    }

    public boolean havaKey(K key){
        return map.get(key) != null;
    }

    @Override
    public String toString(){
        return map.toString();
    }
}
