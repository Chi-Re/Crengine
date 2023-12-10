package crengine.base;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

/**全字符按钮集*/
public enum Keyboards {
    //所有字符(我勒个去，一个一个敲累死我了)
    Q(KeyEvent.VK_Q), W(KeyEvent.VK_W),
    E(KeyEvent.VK_E), R(KeyEvent.VK_R),
    T(KeyEvent.VK_T), Y(KeyEvent.VK_Y),
    U(KeyEvent.VK_U), I(KeyEvent.VK_I),
    O(KeyEvent.VK_O), P(KeyEvent.VK_P),
    A(KeyEvent.VK_A), S(KeyEvent.VK_S),
    D(KeyEvent.VK_D), F(KeyEvent.VK_F),
    G(KeyEvent.VK_G), H(KeyEvent.VK_H),
    J(KeyEvent.VK_J), K(KeyEvent.VK_K),
    L(KeyEvent.VK_L), Z(KeyEvent.VK_Z),
    X(KeyEvent.VK_X), C(KeyEvent.VK_C),
    V(KeyEvent.VK_V), B(KeyEvent.VK_B),
    N(KeyEvent.VK_N), M(KeyEvent.VK_M),
    SHIFT(KeyEvent.VK_SHIFT),//shift
    SPACE(KeyEvent.VK_SPACE),//空格
    TAB(KeyEvent.VK_TAB),//tab
    ESC(KeyEvent.VK_ESCAPE),//esc
    ENTER(KeyEvent.VK_ENTER),//回车
    DELETE(KeyEvent.VK_BACK_SPACE),//删除
    ALT(KeyEvent.VK_ALT),//alt
    CTRL(KeyEvent.VK_CONTROL),//ctrl
    PG_UP(KeyEvent.VK_PAGE_UP),//好冷的按键 PgUp
    PG_DOWN(KeyEvent.VK_PAGE_DOWN), //PgDown
    ONE(KeyEvent.VK_1), TOW(KeyEvent.VK_2),
    THREE(KeyEvent.VK_3), FOUR(KeyEvent.VK_4),
    FIVE(KeyEvent.VK_5), SIX(KeyEvent.VK_6),
    SEVEN(KeyEvent.VK_7), EIGHT(KeyEvent.VK_8),
    NINE(KeyEvent.VK_9), ZERO(KeyEvent.VK_0),
    RIGHT_MOUSE(KeyEvent.BUTTON3_DOWN_MASK),
    LEFT_MOUSE(KeyEvent.BUTTON1_DOWN_MASK);

    private final static Set<Integer> keySet = new HashSet<>();//按键

    Keyboards(int keyValue) {
        this.keyValue = keyValue;
    }

    private final int keyValue;//键值

    /**
     * 是否使用了某键
     *
     * @return
     */
    public boolean use() {
        return keySet.contains(keyValue);
    }

    /**
     * 添加按键
     *
     * @param keyCode
     */
    public static void add(int keyCode) {
        keySet.add(keyCode);
    }

    /**
     * 移除按键
     *
     * @param keyCode
     */
    public static void remove(int keyCode) {
        keySet.remove(keyCode);
    }
}
