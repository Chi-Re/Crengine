package crengine.util.serialization;

import crengine.util.exception.CrengineRuntimeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 炽热S
 */
public class ObjectList<T> {
    private List<T> items = new ArrayList<>();
    private int size = 0;
    private boolean limit = false;

    public ObjectList(int size, boolean limit){
        this.size = size;
        this.limit = limit;
    }
    public ObjectList(int size){
        this(size, false);
    }
    public ObjectList(){
    }

    public List<T> items() {
        return this.items;
    }

    public int size() {
        return this.size;
    }

    public void set(List<T> items){
        this.items = items;
        this.size = items.size();
    }
    public void add(T item){
        if (this.items.size() > this.size) throw new IndexOutOfBoundsException("添加失败，limit限制已开启，列表已满");
        this.items.add(item);
        if (!limit) this.size++;
    }
    public void addAny(T[] items){
        if (limit){
            if (items.length > this.size){
                throw new IndexOutOfBoundsException("添加失败，limit限制已开启，添加的列表长度超过限制");
            }
        }
        this.items.addAll(Arrays.asList(items));
        if (!limit) this.size += items.length;
    }

    public void addFirst(T item){
        if (limit){
            if (items.size() > this.size){
                throw new IndexOutOfBoundsException("添加失败，limit限制已开启，添加的列表长度超过限制");
            }
        }
        List<T> ls = this.items;
        this.items = new ArrayList<>();
        this.items.add(item);
        this.items.addAll(ls);
        if (!limit) this.size++;
    }

    public List<T> getAny(){
        return this.items;
    }

    public T get(int index){
        if(index >= size) throw new IndexOutOfBoundsException("index can't be >= size: " + index + " >= " + size);
        return items.get(index);
    }

    public boolean contains(T item){
        if (this.size != 0){
            return this.items.contains(item);
        }
        return false;
    }

    public void remove(T item){
        if (this.contains(item)) {
            this.items.remove(item);
            this.size--;
        } else {
            throw new CrengineRuntimeException("错误！ "+item+" 由于不存在，无法remove");
        }
    }

    @Override
    public String toString(){
        return this.items.toString();
    }
}
