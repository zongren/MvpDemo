package me.zongren.mvpdemo;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by zongren on 2017/4/18.
 * All right reserved by 正奇晟业（北京）科技有限公司
 */

public class FakeDataSource implements DataSource {
    @Override
    public List<Item> getItems() {
        List<Item> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(new Item(i));
        }
        return list;
    }
}
