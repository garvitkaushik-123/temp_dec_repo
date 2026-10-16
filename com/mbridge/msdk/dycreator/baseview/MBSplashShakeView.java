package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.u0;
import io.adn.sdk.internal.domain.constants.LayoutConfigDefaults;

/* loaded from: classes6.dex */
public class MBSplashShakeView extends MBLinearLayout {
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private ImageView l;
    private Animation m;

    public MBSplashShakeView(Context context) {
        super(context);
        this.f = "浏览第三方应用";
        this.g = "View";
        this.h = "打开第三方应用";
        this.i = "Open";
        this.j = "下载第三方应用";
        this.k = LayoutConfigDefaults.CTA_TEXT;
    }

    private String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            str.hashCode();
            switch (str) {
                case "Install":
                case "Open":
                case "View":
                case "下载第三方应用":
                case "打开第三方应用":
                case "浏览第三方应用":
                    return str;
            }
        }
        return getContext().getResources().getConfiguration().locale.getLanguage().contains("zh") ? "浏览第三方应用" : "View";
    }

    private void setBgDrawable(View view) {
        int parseColor = Color.parseColor("#60000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(parseColor);
        gradientDrawable.setCornerRadius(200);
        view.setBackground(gradientDrawable);
    }

    public void initView(String str) {
        setOrientation(1);
        setGravity(1);
        View imageView = new ImageView(getContext());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(u0.a(getContext(), 80.0f), u0.a(getContext(), 80.0f)));
        setBgDrawable(imageView);
        this.l = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(u0.a(getContext(), 40.0f), u0.a(getContext(), 40.0f));
        layoutParams.gravity = 17;
        this.l.setLayoutParams(layoutParams);
        this.l.setImageResource(getResources().getIdentifier("mbridge_cm_btn_shake", "drawable", c.m().h()));
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        frameLayout.addView(imageView);
        frameLayout.addView(this.l);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = u0.a(getContext(), 10.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        textView.setText("Shake your phone");
        textView.setTextSize(16.0f);
        textView.setTextColor(-1);
        String a2 = a(str);
        TextView textView2 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = u0.a(getContext(), 5.0f);
        textView2.setLayoutParams(layoutParams3);
        textView2.setGravity(17);
        textView2.setText(a2);
        textView2.setTextSize(12.0f);
        textView2.setTextColor(-1);
        addView(frameLayout);
        addView(textView);
        addView(textView2);
    }

    @Override // com.mbridge.msdk.dycreator.baseview.MBLinearLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.l != null) {
            a();
        }
    }

    public MBSplashShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = "浏览第三方应用";
        this.g = "View";
        this.h = "打开第三方应用";
        this.i = "Open";
        this.j = "下载第三方应用";
        this.k = LayoutConfigDefaults.CTA_TEXT;
    }

    public MBSplashShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = "浏览第三方应用";
        this.g = "View";
        this.h = "打开第三方应用";
        this.i = "Open";
        this.j = "下载第三方应用";
        this.k = LayoutConfigDefaults.CTA_TEXT;
    }

    private void a() {
        RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 10.0f, 1, 0.5f, 1, 0.5f);
        this.m = rotateAnimation;
        rotateAnimation.setDuration(100L);
        this.m.setRepeatMode(2);
        this.m.setRepeatCount(-1);
        this.l.startAnimation(this.m);
    }
}
