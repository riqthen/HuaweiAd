package com.riq.huaweiad;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 锐 on 2017/6/18.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @BindView(R.id.iv_back)
    public ImageView ivBack;
    @BindView(R.id.iv_drawer)
    ImageView ivDrawer;
    @BindView(R.id.ly_main)
    DrawerLayout lyMain;
    @BindView(R.id.iv_close)
    ImageView ivClose;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        ButterKnife.bind(this);
        lyMain.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        initView();

    }

    protected abstract int getLayoutRes();

    protected abstract void initView();

    @OnClick({R.id.iv_back, R.id.iv_drawer, R.id.iv_close})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_drawer:
                lyMain.openDrawer(Gravity.END);
                break;
            case R.id.iv_close:
                lyMain.closeDrawer(Gravity.END);
                break;
        }
    }

}
