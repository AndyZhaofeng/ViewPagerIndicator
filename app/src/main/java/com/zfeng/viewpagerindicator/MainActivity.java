package com.zfeng.viewpagerindicator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.zfeng.widget.ViewPagerIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private ViewPagerIndicator indicator;
    private ViewPager viewPager;

    private List<String> mTitles= Arrays.asList("tab1","tab2","tab3","tab4","tab5","tab6","tab7","tab8","tab9");
    private List<FragmentSimple> mFragments=new ArrayList<>();
    private FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        initDatas();
        indicator.setVisibleTabs(4);
        indicator.addTabs(mTitles);
        viewPager.setAdapter(fragmentPagerAdapter);
        indicator.setViewPager(viewPager);
        indicator.setViewPagerListener(new ViewPagerIndicator.ViewPagerListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void initView()
    {
        indicator=(ViewPagerIndicator)findViewById(R.id.indicator);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
    }
    private void initDatas()
    {
        for(String str:mTitles)
        {
            FragmentSimple fragmentSimple=FragmentSimple.newInstance(str);
            mFragments.add(fragmentSimple);
        }
        fragmentPagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };
    }
}
