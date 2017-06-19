package com.riq.huaweiad.ui.a;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

public class AActivity extends BaseActivity {

    @BindView(R.id.a_banner)
    Banner banner;
    @BindView(R.id.btn_mainA_cam)
    TextView btnMainAA;
    @BindView(R.id.btn_mainA_more)
    TextView btnMainAB;
    @BindView(R.id.ly_a_points)
    LinearLayout lyPoints;


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
        images.add(R.mipmap.bg_a1);
        images.add(R.mipmap.bg_a2);
        images.add(R.mipmap.bg_a3);
        images.add(R.mipmap.bg_a4);
        images.add(R.mipmap.bg_a5);
        images.add(R.mipmap.bg);
        banner.setImages(images);
        banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                // TODO: 2017/6/19 position:1,2,3,4,5,6,7 从1开始，且比实际多一个 --->
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
                    case 1:
                        lyPoints.getChildAt(0).setSelected(true);
                        lyPoints.getChildAt(1).setSelected(false);
                        lyPoints.getChildAt(2).setSelected(false);
                        lyPoints.getChildAt(3).setSelected(false);
                        lyPoints.getChildAt(4).setSelected(false);
                        lyPoints.getChildAt(5).setSelected(false);
                        break;
                    case 7:
                        lyPoints.getChildAt(0).setSelected(true);
                        lyPoints.getChildAt(1).setSelected(false);
                        lyPoints.getChildAt(2).setSelected(false);
                        lyPoints.getChildAt(3).setSelected(false);
                        lyPoints.getChildAt(4).setSelected(false);
                        lyPoints.getChildAt(5).setSelected(false);
                        break;
                    case 2:
                        lyPoints.getChildAt(0).setSelected(false);
                        lyPoints.getChildAt(1).setSelected(true);
                        lyPoints.getChildAt(2).setSelected(false);
                        lyPoints.getChildAt(3).setSelected(false);
                        lyPoints.getChildAt(4).setSelected(false);
                        lyPoints.getChildAt(5).setSelected(false);
                        break;
                    case 3:
                        lyPoints.getChildAt(0).setSelected(false);
                        lyPoints.getChildAt(1).setSelected(false);
                        lyPoints.getChildAt(2).setSelected(true);
                        lyPoints.getChildAt(3).setSelected(false);
                        lyPoints.getChildAt(4).setSelected(false);
                        lyPoints.getChildAt(5).setSelected(false);
                        break;
                    case 4:
                        lyPoints.getChildAt(0).setSelected(false);
                        lyPoints.getChildAt(1).setSelected(false);
                        lyPoints.getChildAt(2).setSelected(false);
                        lyPoints.getChildAt(3).setSelected(true);
                        lyPoints.getChildAt(4).setSelected(false);
                        lyPoints.getChildAt(5).setSelected(false);
                        break;
                    case 5:
                        lyPoints.getChildAt(0).setSelected(false);
                        lyPoints.getChildAt(1).setSelected(false);
                        lyPoints.getChildAt(2).setSelected(false);
                        lyPoints.getChildAt(3).setSelected(false);
                        lyPoints.getChildAt(4).setSelected(true);
                        lyPoints.getChildAt(5).setSelected(false);
                        break;
                    case 6:
                        lyPoints.getChildAt(0).setSelected(false);
                        lyPoints.getChildAt(1).setSelected(false);
                        lyPoints.getChildAt(2).setSelected(false);
                        lyPoints.getChildAt(3).setSelected(false);
                        lyPoints.getChildAt(4).setSelected(false);
                        lyPoints.getChildAt(5).setSelected(true);
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


    @OnClick({R.id.btn_mainA_cam, R.id.btn_mainA_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_mainA_cam:
                requestCameraPermission();
                launchCamera();
                break;
            case R.id.btn_mainA_more:
                startActivity(new Intent(AActivity.this, MoreActivity.class));
                finish();
                break;
        }
    }

    //----启动相机
    private static final int PERMISSIONS_REQUEST_CODE = 75;
    private static final int TO_OPEN_CAMERA = 600;

    private String[] permissions = {Manifest.permission.CAMERA
            , Manifest.permission.ACCESS_COARSE_LOCATION
            , Manifest.permission.ACCESS_FINE_LOCATION};


    private void requestCameraPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, PERMISSIONS_REQUEST_CODE);
            return;
        }
        launchCamera();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (PERMISSIONS_REQUEST_CODE == requestCode) {
            //循环遍历已经申请到的权限
            for (int index = 0; index < permissions.length; index++) {
                switch (permissions[index]) {
                    case Manifest.permission.CAMERA:
                        //用户授权
                        if (PackageManager.PERMISSION_GRANTED == grantResults[index]) {
                            launchCamera();
                        } else if (PackageManager.PERMISSION_DENIED == grantResults[index]) {
                            Toast.makeText(this, "没有拍照权限，请授权！", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "没有拍照权限，请授权", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
            }
        }
    }

    private void launchCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, TO_OPEN_CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}
