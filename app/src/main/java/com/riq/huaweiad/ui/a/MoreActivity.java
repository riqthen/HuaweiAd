package com.riq.huaweiad.ui.a;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.view.ViewPager;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.riq.huaweiad.BaseActivity;
import com.riq.huaweiad.R;
import com.riq.huaweiad.utils.Lcat;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MoreActivity extends BaseActivity {

    @BindView(R.id.sv_more)
    SurfaceView svMore;
    @BindView(R.id.banner_more)
    Banner bannerMore;
    @BindView(R.id.btn_more_back)
    ImageView btnMoreBack;
    @BindView(R.id.ly_more_photo)
    RelativeLayout lyMorePhoto;
    @BindView(R.id.ly_more_points)
    LinearLayout lyMorePoints;
    @BindView(R.id.tv_more_huawei)
    TextView tvMoreHuawei;
    @BindView(R.id.tv_more_others)
    TextView tvMoreOthers;

    private MediaPlayer mp;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_more;
    }

    @Override
    protected void initView() {
        initMedia();
        initBanner();
    }

    private void initMedia() {
        mp = MediaPlayer.create(this, R.raw.meipai);
        svMore.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mp.setDisplay(holder);
                mp.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                mp.stop();
                mp.release();
                mp = null;
            }
        });

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                svMore.setVisibility(View.GONE);
                lyMorePhoto.setVisibility(View.VISIBLE);
            }
        });
    }

    private void initBanner() {
        bannerMore.setBannerStyle(BannerConfig.NOT_INDICATOR);
        bannerMore.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(MoreActivity.this).load(path).into(imageView);
            }
        });
        bannerMore.isAutoPlay(false);
        List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.image_comare1);
        images.add(R.mipmap.bg_a2);
        images.add(R.mipmap.image_comare1);
        images.add(R.mipmap.bg_a4);
        bannerMore.setImages(images);
        bannerMore.setOnPageChangeListener(onPageChangeListener);
        bannerMore.start();
        lyMorePoints.getChildAt(0).setSelected(true);

    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            Lcat.print(position);
            switch (position) {
                case 1:
                    lyMorePoints.getChildAt(0).setSelected(true);
                    lyMorePoints.getChildAt(1).setSelected(false);
                    lyMorePoints.getChildAt(2).setSelected(false);
                    lyMorePoints.getChildAt(3).setSelected(false);
                    tvMoreHuawei.setText("HUAWEI| nova2");
                    tvMoreOthers.setText("其他手机");
                    break;
                case 5:
                    lyMorePoints.getChildAt(0).setSelected(true);
                    lyMorePoints.getChildAt(1).setSelected(false);
                    lyMorePoints.getChildAt(2).setSelected(false);
                    lyMorePoints.getChildAt(3).setSelected(false);
                    tvMoreHuawei.setText("HUAWEI| nova2");
                    tvMoreOthers.setText("其他手机");
                    break;
                case 2:
                    lyMorePoints.getChildAt(0).setSelected(false);
                    lyMorePoints.getChildAt(1).setSelected(true);
                    lyMorePoints.getChildAt(2).setSelected(false);
                    lyMorePoints.getChildAt(3).setSelected(false);
                    tvMoreHuawei.setText("HUAWEI| nova2");
                    tvMoreOthers.setText("其他手机");
                    break;
                case 3:
                    lyMorePoints.getChildAt(0).setSelected(false);
                    lyMorePoints.getChildAt(1).setSelected(false);
                    lyMorePoints.getChildAt(2).setSelected(true);
                    lyMorePoints.getChildAt(3).setSelected(false);
                    tvMoreHuawei.setText("nova2美颜效果");
                    tvMoreOthers.setText("nova2普通效果");
                    break;
                case 4:
                    lyMorePoints.getChildAt(0).setSelected(false);
                    lyMorePoints.getChildAt(1).setSelected(false);
                    lyMorePoints.getChildAt(2).setSelected(false);
                    lyMorePoints.getChildAt(3).setSelected(true);
                    tvMoreHuawei.setText("nova2暗光补光效果");
                    tvMoreOthers.setText("其他手机");
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @OnClick(R.id.btn_more_back)
    public void onViewClicked() {
        finish();
    }
}
