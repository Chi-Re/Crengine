package crengine.base.game.entity;

import crengine.base.game.WorldContent;

/**主要用来创建物品id<br>根据创建顺序<br>*注意，不要试图通过固定id查询固定物品，这可能会改变*/
public class EntityGroup<T extends WorldContent> {
    private static int lastId = 0;

    /**可能会...导致重复id*/
    public static int nextId(){
        return lastId++;
    }

    /** 确保下一个 ID 计数器高于此数字，以便将来的实体不可能使用此 ID。 */
    public static void checkNextId(int id){
        lastId = Math.max(lastId, id + 1);
    }
}
