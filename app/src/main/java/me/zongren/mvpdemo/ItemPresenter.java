package me.zongren.mvpdemo;

import android.view.View;

/**
 * Created by zongren on 2017/4/18.
 * All right reserved by 正奇晟业（北京）科技有限公司
 */

public class ItemPresenter implements ItemContract.Presenter {
    private DataSource mDataSource;
    private ItemContract.View mView;

    public ItemPresenter(DataSource dataSource, ItemContract.View view) {
        this.mDataSource = dataSource;
        this.mView = view;
        this.mView.setPresenter(this);
    }

    @Override
    public void loadItems() {
        if(mDataSource==null){
            return;
        }
        if(mView == null){
            return;
        }
        mView.showItems(mDataSource.getItems());
    }

    @Override
    public void clickItem(Item item) {
        item.index++;
        mView.updateItem(item);
    }
}
