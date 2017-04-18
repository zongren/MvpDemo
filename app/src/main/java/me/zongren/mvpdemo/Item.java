package me.zongren.mvpdemo;

/**
 * Created by zongren on 2017/4/18.
 * All right reserved by 正奇晟业（北京）科技有限公司
 */

public class Item {
    public int index;

    public Item(int i) {
        this.index = i;
    }

    @Override
    public String toString() {
        return "Item{" +
                "index=" + index +
                '}';
    }
}
