package com.riq.huaweiad.ui.d;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.TextView;

import com.riq.huaweiad.BaseActivity;
import com.riq.huaweiad.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class DActivity extends BaseActivity {

    @BindView(R.id.vp_d)
    ViewPager vpD;
    @BindView(R.id.tv_page)
    TextView tvPage;
    private List<Fragment> fragments;


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_d;
    }

    @Override
    protected void initView() {
        int currPage = Integer.MAX_VALUE / 2 - (Integer.MAX_VALUE / 2) % 5;
        fragments = new ArrayList<>();
        fragments.add(new FragmentA());
        fragments.add(new FragmentB());
        fragments.add(new FragmentC());
        fragments.add(new FragmentD());
        fragments.add(new FragmentE());
        FragmentManager fm = getSupportFragmentManager();
        vpD.setAdapter(new MyAdapter(fm));
        vpD.setCurrentItem(currPage);
        vpD.addOnPageChangeListener(onPageChangeListener);
    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    private class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //处理position。让数组下标落在[0,fragmentList.size)中，防止越界
            position = position % 5;
            return super.instantiateItem(container, position);
        }
    }


}
