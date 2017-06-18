package com.riq.huaweiad;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.riq.huaweiad.utils.Lcat;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class AActivity extends BaseActivity {
    private static final int TO_OPEN_CAMERA = 600;

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.btn_mainA_a)
    TextView btnMainAA;
    @BindView(R.id.btn_mainA_b)
    TextView btnMainAB;
    @BindView(R.id.ly_points)
    LinearLayout lyPoints;
    @BindView(R.id.point1)
    View point1;
    @BindView(R.id.point2)
    View point2;
    @BindView(R.id.point3)
    View point3;
    @BindView(R.id.point4)
    View point4;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_a;
    }

//    private int currPosition;

    @Override
    protected void initView() {
        lyPoints.getChildAt(0).setSelected(true);
        banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(AActivity.this).load(path).into(imageView);
            }
        });
        List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.ic_launcher);
        images.add(R.mipmap.ic_launcher_round);
        images.add(R.mipmap.ic_launcher);
        images.add(R.mipmap.ic_launcher_round);
        banner.setImages(images);
        banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                // TODO: 2017/6/19 position:1,2,3,4,5 从1开始，且比实际多一个 --->
                Lcat.print(position);
//                if (position != 1) {
//                    lyPoints.getChildAt(currPosition).setSelected(true);
////                Lcat.print(currPosition);
//                    lyPoints.getChildAt(position - 1).setSelected(false);
//                    currPosition = position - 1;
//                }
                switch (position) {
//                    case 1:
//                        lyPoints.getChildAt(0).setSelected(true);
//                        lyPoints.getChildAt(1).setSelected(false);
//                        lyPoints.getChildAt(2).setSelected(false);
//                        lyPoints.getChildAt(3).setSelected(false);
//                        break;
                    case 2:
                        lyPoints.getChildAt(0).setSelected(true);
                        lyPoints.getChildAt(1).setSelected(false);
                        lyPoints.getChildAt(2).setSelected(false);
                        lyPoints.getChildAt(3).setSelected(false);
                        break;
                    case 3:
                        lyPoints.getChildAt(0).setSelected(false);
                        lyPoints.getChildAt(1).setSelected(true);
                        lyPoints.getChildAt(2).setSelected(false);
                        lyPoints.getChildAt(3).setSelected(false);
                        break;
                    case 4:
                        lyPoints.getChildAt(0).setSelected(false);
                        lyPoints.getChildAt(1).setSelected(false);
                        lyPoints.getChildAt(2).setSelected(true);
                        lyPoints.getChildAt(3).setSelected(false);
                        break;
                    case 5:
                        lyPoints.getChildAt(0).setSelected(false);
                        lyPoints.getChildAt(1).setSelected(false);
                        lyPoints.getChildAt(2).setSelected(false);
                        lyPoints.getChildAt(3).setSelected(true);
                        break;
                    default:
                        break;

                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        banner.start();

    }


    @OnClick({R.id.btn_mainA_a, R.id.btn_mainA_b})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_mainA_a:
//                MPermissions.requestPermissions(AActivity.this, TO_OPEN_CAMERA, Manifest.permission.CAMERA);
                break;
            case R.id.btn_mainA_b:
                break;
        }
    }


//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }
//
//    @PermissionGrant(TO_OPEN_CAMERA)
//    public void requestSdcardSuccess() {
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivity(intent);
//    }
//
//    @PermissionDenied(TO_OPEN_CAMERA)
//    public void requestSdcardFailed() {
//        Toast.makeText(this, "请打开摄像机权限!", Toast.LENGTH_SHORT).show();
//    }


}
