package com.riq.huaweiad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_mainA)
    TextView btnMainA;
    @BindView(R.id.btn_mainB)
    TextView btnMainB;
    @BindView(R.id.btn_mainC)
    TextView btnMainC;
    @BindView(R.id.btn_mainD)
    TextView btnMainD;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        ivBack.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_mainA, R.id.btn_mainB, R.id.btn_mainC, R.id.btn_mainD})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_mainA:
                startActivity(new Intent(this, AActivity.class));
                break;
            case R.id.btn_mainB:
                break;
            case R.id.btn_mainC:
                break;
            case R.id.btn_mainD:
                break;
        }
    }
}
