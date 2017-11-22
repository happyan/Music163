package com.hap.music163demo;

import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hap.music163demo.adapter.HomeFragmentPageAdapter;
import com.hap.music163demo.ui.activitys.base.BaseActivity;
import com.hap.music163demo.ui.fragments.home.AndroidFragment;
import com.hap.music163demo.ui.fragments.home.HomeFragment;
import com.hap.music163demo.ui.fragments.home.WeChatFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private DrawerLayout dlLayout;

    private Toolbar toolbar;
    private RadioGroup rgHomeViewpagerContorl;
    private RadioButton rbHomePager;
    private RadioButton rbMusicPager;
    private RadioButton rbFriendPager;
    private ViewPager vpContent;
    private ActionBarDrawerToggle mDrawerToggle;

    public void assignViews() {
        dlLayout = (DrawerLayout) findViewById(R.id.dl_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        rgHomeViewpagerContorl = (RadioGroup) findViewById(R.id.rg_home_viewpager_contorl);
        rbHomePager = (RadioButton) findViewById(R.id.rb_home_pager);
        rbMusicPager = (RadioButton) findViewById(R.id.rb_music_pager);
        rbFriendPager = (RadioButton) findViewById(R.id.rb_friend_pager);
        vpContent = (ViewPager) findViewById(R.id.vp_content);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        //是否给左上角图标的左边加上一个返回的图标
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setDisplayShowTitleEnabled(false);//去除默认标题

        mDrawerToggle = new ActionBarDrawerToggle(this, dlLayout, toolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        dlLayout.addDrawerListener(mDrawerToggle);//设置点击左边按钮打开侧边栏
    }

    @Override
    public void onViewReady() {
        rgHomeViewpagerContorl.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_home_pager:
                        vpContent.setCurrentItem(0);// 设置当前页面
                        break;
                    case R.id.rb_music_pager:
                        vpContent.setCurrentItem(1);// 设置当前页面
                        break;
                    case R.id.rb_friend_pager:
                        vpContent.setCurrentItem(2);// 设置当前页面
                        break;
                }
            }
        });

        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(new AndroidFragment());
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new WeChatFragment());
        vpContent.setAdapter(new HomeFragmentPageAdapter(getSupportFragmentManager() , mFragmentList));
        vpContent.setCurrentItem(1);
        vpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rgHomeViewpagerContorl.check(R.id.rb_home_pager);
                        break;
                    case 1:
                        rgHomeViewpagerContorl.check(R.id.rb_music_pager);
                        break;
                    case 2:
                        rgHomeViewpagerContorl.check(R.id.rb_friend_pager);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public int gerLayoutId(){
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
    }

    /**
     * 按返回键不退出应用。
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (dlLayout.isDrawerOpen(GravityCompat.START)) {
                dlLayout.closeDrawer(GravityCompat.START);
            } else {
                // 不退出程序，进入后台
                moveTaskToBack(true);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
