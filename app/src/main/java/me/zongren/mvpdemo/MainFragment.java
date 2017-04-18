package me.zongren.mvpdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zongren on 2017/4/18.
 * All right reserved by 正奇晟业（北京）科技有限公司
 */

public class MainFragment extends Fragment implements ItemContract.View{
    private ListView mListView;
    private List<Item> mList;
    private ArrayAdapter<Item> mAdapter;
    private ItemContract.Presenter mPresenter;

    public static MainFragment newInstance(){
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mList = new ArrayList<>();
        mAdapter = new ArrayAdapter<>(getContext(),R.layout.item,R.id.textView,mList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        mListView = (ListView)view.findViewById(R.id.listView);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPresenter.clickItem(mList.get(position));
            }
        });
        mListView.setAdapter(mAdapter);
        mPresenter.loadItems();
        return view;
    }

    @Override
    public void showItems(List<Item> items) {
        mList.clear();
        mList.addAll(items);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateItem(Item item) {
        if(mList.contains(item)){
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void setPresenter(ItemContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
