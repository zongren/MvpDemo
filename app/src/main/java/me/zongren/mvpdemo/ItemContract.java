package me.zongren.mvpdemo;

import java.util.List;

/**
 * Created by zongren on 2017/4/18.
 * All right reserved by 正奇晟业（北京）科技有限公司
 */

public interface ItemContract {
    interface View {
        void showItems(List<Item> items);
        void updateItem(Item item);
        void setPresenter(Presenter presenter);
    }

    interface Presenter{
        void loadItems();
        void clickItem(Item item);
    }
}
