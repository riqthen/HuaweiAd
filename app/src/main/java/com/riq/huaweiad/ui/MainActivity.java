package com.riq.huaweiad.ui;

import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.riq.huaweiad.BaseActivity;
import com.riq.huaweiad.R;
import com.riq.huaweiad.ui.a.AActivity;
import com.riq.huaweiad.ui.d.DActivity;

import butterknife.BindView;
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

    private boolean canClick = true;

    @OnClick({R.id.btn_mainA, R.id.btn_mainB, R.id.btn_mainC, R.id.btn_mainD})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_mainA:
                startActivity(new Intent(this, AActivity.class));
                break;
            case R.id.btn_mainB:
                if (canClick) {
                    beginAnim();
                    canClick = false;
                } else {
                    restore();
                    canClick = true;
                }
                break;
            case R.id.btn_mainC:
                break;
            case R.id.btn_mainD:
                startActivity(new Intent(this, DActivity.class));
                break;
        }
    }


    private void beginAnim() {
        //其他三个按钮动画
        TranslateAnimation translateAnimation1 = new TranslateAnimation(0, 0, 0, 20);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation1);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(600);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                btnMainA.setVisibility(View.GONE);
                btnMainC.setVisibility(View.GONE);
                btnMainD.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        btnMainA.startAnimation(animationSet);
        btnMainC.startAnimation(animationSet);
        btnMainD.startAnimation(animationSet);
    }

    private void restore() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 20, 0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(600);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                btnMainA.setVisibility(View.VISIBLE);
                btnMainC.setVisibility(View.VISIBLE);
                btnMainD.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                btnMainA.setVisibility(View.VISIBLE);
                btnMainC.setVisibility(View.VISIBLE);
                btnMainD.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        btnMainA.startAnimation(animationSet);
        btnMainC.startAnimation(animationSet);
        btnMainD.startAnimation(animationSet);
    }

}
