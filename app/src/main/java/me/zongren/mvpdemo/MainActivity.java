package me.zongren.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ItemPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment fragment = MainFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,fragment).commitAllowingStateLoss();
        mPresenter = new ItemPresenter(new FakeDataSource(),fragment);
    }

}
