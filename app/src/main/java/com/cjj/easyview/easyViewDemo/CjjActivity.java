package com.cjj.easyview.easyViewDemo;

import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.cjj.easyview.adapter.DrawerAdapter;
import com.cjj.easyview.adapter.HomeViewpagerFragmentAdapter;
import com.cjj.easyview.constants.Constants;
import com.cjj.easyview.custom.PagerSlidingTabStrip;


/**
 * @author cjj
 * 父类activity
 */
public class CjjActivity extends ActionBarActivity implements View.OnClickListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private HomeViewpagerFragmentAdapter mAdapter;
    private PagerSlidingTabStrip slidingTabLayout;
    private RecyclerView recyclerView;
    private Button btn_qq_login;
    private Button btn_wb_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }



    private void initView() {
        btn_qq_login = (Button) this.findViewById(R.id.btn_login_qq);
        btn_wb_login = (Button) this.findViewById(R.id.btn_login_weibo);
        btn_qq_login.setOnClickListener(this);
        btn_wb_login.setOnClickListener(this);
        mDrawerLayout = (DrawerLayout) this.findViewById(R.id.drawerlayout);
        initpager();
        initToolbar();
        initDrawer();
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name,R.string.app_name2);
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
    }

    private void initDrawer() {
        recyclerView = (RecyclerView) this.findViewById(R.id.recyclever_drawer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new DrawerAdapter(this,Constants.TITLES_DRAWER));
    }

    private void initpager() {
        viewPager = (ViewPager) this.findViewById(R.id.viewpager);
        mAdapter = new HomeViewpagerFragmentAdapter(getSupportFragmentManager(), Constants.TITLES);
        slidingTabLayout = (PagerSlidingTabStrip) this.findViewById(R.id.slidingtab_layout);
        viewPager.setAdapter(mAdapter);
        slidingTabLayout.setViewPager(viewPager);
        slidingTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position)
                {
                    case Constants.REXUE:
                        toolbar.setBackgroundColor(getResources().getColor(R.color.toolbar_rexue));
                        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.toolbar_rexue));
                        break;
                    case Constants.XINFAN:
                        toolbar.setBackgroundColor(getResources().getColor(R.color.toolbar_xinfan));
                        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.toolbar_xinfan));
                        break;
                    case Constants.RICHANG:
                        toolbar.setBackgroundColor(getResources().getColor(R.color.toolbar_richang));
                        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.toolbar_richang));
                        break;
                    case Constants.HUAIJIU:
                        toolbar.setBackgroundColor(getResources().getColor(R.color.toolbar_huaijiu));
                        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.toolbar_huaijiu));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        setTabsValue();
    }

    /**
     * 对PagerSlidingTabStrip的各项属性进行赋值。
     */
    private void setTabsValue() {
        // 设置Tab是自动填充满屏幕的
        slidingTabLayout.setShouldExpand(true);
        // 设置Tab的分割线是透明的
        slidingTabLayout.setDividerColor(Color.TRANSPARENT);
        // 设置Tab底部线的高度
        slidingTabLayout.setUnderlineHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics()));
        // 设置Tab Indicator的高度
        slidingTabLayout.setIndicatorHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics()));
        // 设置Tab标题文字的大小
        slidingTabLayout.setTextSize((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
        // 设置Tab Indicator的颜色
        slidingTabLayout.setIndicatorColor(Color.parseColor("#ffffff"));
        // 设置选中Tab文字的颜色 (这是我自定义的一个方法)
        slidingTabLayout.setSelectedTextColor(Color.parseColor("#ffffff"));
        // 取消点击Tab时的背景色
//        slidingTabLayout.setTabBackground(0);
    }


    private void initToolbar() {
        toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_ab_drawer);
        toolbar.setTitle("EasyView");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_login_qq:
                break;
            case R.id.btn_login_weibo:
                break;
        }
    }


}
