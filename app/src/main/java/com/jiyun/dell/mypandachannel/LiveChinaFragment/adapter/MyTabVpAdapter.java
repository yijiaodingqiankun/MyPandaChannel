package com.jiyun.dell.mypandachannel.LiveChinaFragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/12/3.
 */

public class MyTabVpAdapter extends FragmentPagerAdapter {
    private final List<Fragment> list;
    private final List<String> listTitle;

    public MyTabVpAdapter(FragmentManager fm, List<Fragment> list, List<String> listTitle) {
        super(fm);
        this.list = list;
        this.listTitle = listTitle;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listTitle.get(position);
    }
}
