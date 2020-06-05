package com.example.fragment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragment.R;

public class NaviationFragment extends Fragment implements View.OnClickListener {

    //布局
    private LinearLayout SYlayout;
    private LinearLayout WDlayout;
    private LinearLayout GWlayout;
    private LinearLayout FLlayout;
    //image
    private ImageView SYimage;
    private ImageView WDimage;
    private ImageView GWimage;
    private ImageView FLimage;
    //text
    private TextView SYtext;
    private TextView WDtext;
    private TextView GWtext;
    private TextView FLtext;

    //fragment
    private Fragment homeFragment;
    private Fragment categoryFragment;
    private Fragment cartFragment;
    private Fragment personFragment;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation,container,false);
        initView(view);
        setTabSelection(R.id.sy_layout);
        return view;
    }

    //初始化控件
    public void initView(View view) {
        //初始化fragment
        cartFragment = new CartFragment();
        categoryFragment = new CategoryFragment();
        homeFragment = new HomeFragment();
        personFragment = new PersonFragment();

        //四个线性布局
        SYlayout = view.findViewById(R.id.sy_layout);
        WDlayout = view.findViewById(R.id.wd_layout);
        GWlayout = view.findViewById(R.id.gw_layout);
        FLlayout = view.findViewById(R.id.fl_layout);

        //四个image
        SYimage = view.findViewById(R.id.sy_image);
        FLimage = view.findViewById(R.id.fl_image);
        GWimage = view.findViewById(R.id.gw_image);
        WDimage = view.findViewById(R.id.wd_image);


        //四个text
        SYtext = view.findViewById(R.id.sy_text);
        FLtext = view.findViewById(R.id.fl_text);
        GWtext = view.findViewById(R.id.gw_text);
        WDtext = view.findViewById(R.id.wd_text);

        //点击事件的监听
        SYlayout.setOnClickListener(this);
        FLlayout.setOnClickListener(this);
        GWlayout.setOnClickListener(this);
        WDlayout.setOnClickListener(this);

        //默认状态
        SYimage.setImageResource(R.drawable.ic_r_sy);
        SYtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.red));

        FLimage.setImageResource(R.drawable.ic_w_fl);
        FLtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));

        GWimage.setImageResource(R.drawable.ic_w_gw);
        GWtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));

        WDimage.setImageResource(R.drawable.ic_w_wd);
        WDtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));

        //获取fragment管理类
        fragmentManager = getActivity().getSupportFragmentManager();

    }

    //清除
    private void clean() {
        SYimage.setImageResource(R.drawable.ic_w_sy);
        SYtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));

        FLimage.setImageResource(R.drawable.ic_w_fl);
        FLtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));

        GWimage.setImageResource(R.drawable.ic_w_gw);
        GWtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));

        WDimage.setImageResource(R.drawable.ic_w_wd);
        WDtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));
    }

    //选择
    public void setTabSelection(int id) {
        //清除
        clean();
        fragmentTransaction = fragmentManager.beginTransaction();

        //隐藏所有的Fragment
        switch (id) {
            case R.id.sy_layout:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content,homeFragment);
                }else {
                    fragmentTransaction.replace(R.id.content,homeFragment);
                }
                SYimage.setImageResource(R.drawable.ic_r_sy);
                SYtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.red));
                break;


            case R.id.fl_layout:
                if (categoryFragment == null){
                    categoryFragment = new CategoryFragment();
                    fragmentTransaction.replace(R.id.content,categoryFragment);
                }else {
                    fragmentTransaction.replace(R.id.content,categoryFragment);
                }
                FLimage.setImageResource(R.drawable.ic_r_fl);
                FLtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.red));
                break;

            case R.id.gw_layout:
                if (cartFragment == null){
                    cartFragment = new CartFragment();
                    fragmentTransaction.replace(R.id.content,cartFragment);
                }else {
                    fragmentTransaction.replace(R.id.content,cartFragment);
                }
                GWimage.setImageResource(R.drawable.ic_r_gw);
                GWtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.red));
                break;

            case R.id.wd_layout:
                if (personFragment == null) {
                    personFragment = new PersonFragment();
                    fragmentTransaction.replace(R.id.content,personFragment);
                }else {
                    fragmentTransaction.replace(R.id.content,personFragment);
                }
                WDimage.setImageResource(R.drawable.ic_r_wd);
                WDtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.red));
                break;
        }
        fragmentTransaction.commit();
    }


    @Override
    public void onClick(View v) {
        setTabSelection(v.getId());
    }
}
