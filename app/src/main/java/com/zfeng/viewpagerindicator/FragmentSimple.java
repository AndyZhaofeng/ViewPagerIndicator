package com.zfeng.viewpagerindicator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zfeng on 2016/4/11.
 */
public class FragmentSimple extends Fragment
{
    private String title;
    public static final String ARGS="FragmentSimpleArgs";

    public static FragmentSimple newInstance(String title)
    {
        Bundle bundle=new Bundle();
        bundle.putString(FragmentSimple.ARGS,title);
        FragmentSimple fragmentSimple=new FragmentSimple();
        fragmentSimple.setArguments(bundle);
        return fragmentSimple;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        Bundle bundle=getArguments();
        if(bundle!=null)
        {
            title=bundle.getString(FragmentSimple.ARGS);
        }else{
            title="title";
        }

        TextView tv=new TextView(getContext());
        tv.setText(title);
        tv.setTextColor(Color.parseColor("#000000"));
        tv.setGravity(Gravity.CENTER);
        return tv;
    }
}
