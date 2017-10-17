package com.xls.guidepage;

import android.content.Context;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Sharon on 2017/10/16.
 */

public class GuiderFloatTxtView extends RelativeLayout {

    private int[] titleRes;
    private String[] titleStrs;

    TextView h1;
    TextView h2_1;
    TextView h2_2;

    private View v;

    public GuiderFloatTxtView(Context context) {
        super(context);
        initView();
    }

    public GuiderFloatTxtView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public GuiderFloatTxtView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        v = LayoutInflater.from(getContext()).inflate(R.layout.txt_guide_page, null,false);
        h1 = (TextView) v.findViewById(R.id.txt_title_h1);
        h2_1 = (TextView) v.findViewById(R.id.txt_title_h2_1);
        h2_2 = (TextView) v.findViewById(R.id.txt_title_h2_2);
    }

    public void setTitleRes(int[] titleRes) {
        this.titleRes = titleRes;
        if (titleRes != null) {
            h1.setText(titleRes[0]);
            h2_1.setText(titleRes[1]);
            if (titleRes.length > 2)
                h2_2.setText(titleRes[2]);
        }
    }

    public void setTitleStrs(String[] titleStrs) {
        this.titleStrs = titleStrs;
        if (titleStrs != null) {
            h1.setText(titleStrs[0]);
            h2_1.setText(titleStrs[1]);
            if (titleRes.length > 2)
                h2_2.setText(titleStrs[2]);
        }
    }

    public View getV() {
        return v;
    }
}
