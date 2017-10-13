package com.bean.libraries.enjoy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private int mTextsPosition = 0;
    private TextSwitcher mTextSwitcher;
    private Button mButton;
    int mCount = 343;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 获得TextSwitch的引用，
        mTextSwitcher = (TextSwitcher) findViewById(R.id.your_textview);

        mButton = (Button) findViewById(R.id.btn);
        //指定TextSwitcher的viewFactory
        mTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(MainActivity.this);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.END);
                FrameLayout.LayoutParams lp = new   FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,    ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.gravity = Gravity.CENTER;
                textView.setLayoutParams(lp);
                textView.setText("sdsdsd");
                return textView;
            }
        });
        // 设置切入动画效果,自定义谈入效果
        mTextSwitcher.setInAnimation(this, R.anim.slide_alpha_down_new);
        // 设置切出动画效果，自定义谈出效果
        mTextSwitcher.setOutAnimation(this, R.anim.slide_alpha_down_old);
    }
    // 点击效果
    public void onSwitchText(View v) {
        if (v.getAlpha()==0.5f) {
            v.setAlpha(1);
            --mCount;
        }else {
            v.setAlpha(0.5f);
            ++mCount;
        }
        // 设置渐变切换文字
        mTextSwitcher.setText(mCount +"");
    }
}
