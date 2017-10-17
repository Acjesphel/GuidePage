package com.xls.guidepage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private GuiderView mBackgroundBanner;
    private GuiderView mForegroundBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        initView();
        setListener();
        processLogic();
    }

    private void initView() {
        setContentView(R.layout.activity_guide);
        mBackgroundBanner = (GuiderView) findViewById(R.id.banner_guide_background);
        mForegroundBanner = (GuiderView) findViewById(R.id.banner_guide_foreground);
    }

    private void setListener() {
        /**
         * 设置进入按钮和跳过按钮控件资源 id 及其点击事件
         * 如果进入按钮和跳过按钮有一个不存在的话就传 0
         * 在 BGABanner 里已经帮开发者处理了防止重复点击事件
         * 在 BGABanner 里已经帮开发者处理了「跳过按钮」和「进入按钮」的显示与隐藏
         */
        mForegroundBanner.setEnterSkipViewIdAndDelegate(R.id.btn_guide_enter, R.id.tv_guide_skip, new GuiderView.GuideDelegate() {
            @Override
            public void onClickEnterOrSkip() {
//                startActivity(new Intent(GuideActivity.this, MainActivity.class));
//                finish();
            }
        });
    }

    private void processLogic() {
        // 设置数据源
        mBackgroundBanner.setData(R.drawable.img_guide_page1,
                R.drawable.img_guide_page2,
                R.drawable.img_guide_page3,
                R.drawable.img_guide_page4,
                R.drawable.img_guide_page5);

        List<View> viewList = new ArrayList<>();
        GuiderFloatTxtView txtView = new GuiderFloatTxtView(this);
        txtView.setTitleRes(new int[]{R.string.txt_page1_h1, R.string.txt_page1_h2_1, R.string.txt_page1_h2_2});
        viewList.add(txtView.getV());
        GuiderFloatTxtView txtView1 = new GuiderFloatTxtView(this);
        txtView1.setTitleRes(new int[]{R.string.txt_page2_h1, R.string.txt_page2_h2_1, R.string.txt_page2_h2_2});
        viewList.add(txtView1.getV());
        GuiderFloatTxtView txtView2 = new GuiderFloatTxtView(this);
        txtView2.setTitleRes(new int[]{R.string.txt_page3_h1, R.string.txt_page3_h2_1, R.string.txt_page3_h2_2});
        viewList.add(txtView2.getV());
        GuiderFloatTxtView txtView3 = new GuiderFloatTxtView(this);
        txtView3.setTitleRes(new int[]{R.string.txt_page4_h1, R.string.txt_page4_h2_1, R.string.txt_page4_h2_2});
        viewList.add(txtView3.getV());
        GuiderFloatTxtView txtView4 = new GuiderFloatTxtView(this);
        txtView4.setTitleRes(new int[]{R.string.txt_page5_h1, R.string.txt_page5_h2_1});
        viewList.add(txtView4.getV());
        mForegroundBanner.setData(viewList);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // 如果开发者的引导页主题是透明的，需要在界面可见时给背景 Banner 设置一个白色背景，避免滑动过程中两个 Banner 都设置透明度后能看到 Launcher
        mBackgroundBanner.setBackgroundResource(android.R.color.white);
    }
}
