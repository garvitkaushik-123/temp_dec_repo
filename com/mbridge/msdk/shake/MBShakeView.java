package com.mbridge.msdk.shake;

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

/* loaded from: classes6.dex */
public class MBShakeView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private Animation f4712a;
    private ImageView b;

    public MBShakeView(Context context) {
        super(context);
    }

    private String a(String str) {
        return TextUtils.isEmpty(str) ? getContext().getResources().getConfiguration().locale.getLanguage().contains("zh") ? "浏览第三方应用" : "Redirect to third party application" : str;
    }

    private void setBgDrawable(View view) {
        int parseColor = Color.parseColor("#80000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(parseColor);
        gradientDrawable.setCornerRadius(200);
        view.setBackground(gradientDrawable);
    }

    public void initView(String str) {
        initView(str, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    public MBShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void initView(String str, boolean z) {
        setOrientation(1);
        setGravity(1);
        View imageView = new ImageView(getContext());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(u0.a(getContext(), z ? 60.0f : 80.0f), u0.a(getContext(), z ? 60.0f : 80.0f)));
        setBgDrawable(imageView);
        this.b = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(u0.a(getContext(), z ? 20.0f : 40.0f), u0.a(getContext(), z ? 20.0f : 40.0f));
        layoutParams.gravity = 17;
        this.b.setLayoutParams(layoutParams);
        this.b.setImageResource(getResources().getIdentifier("mbridge_cm_btn_shake", "drawable", c.m().h()));
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        frameLayout.addView(imageView);
        frameLayout.addView(this.b);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = u0.a(getContext(), 10.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        if (getContext().getResources().getConfiguration().locale.getLanguage().contains("zh")) {
            textView.setText("摇动手机 或 点击图标");
        } else {
            textView.setText("Shake your phone");
        }
        textView.setTextSize(z ? 16.0f : 20.0f);
        textView.setTextColor(-1);
        textView.setShadowLayer(8.0f, 3.0f, 3.0f, -16777216);
        String a2 = a(str);
        TextView textView2 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = u0.a(getContext(), 5.0f);
        textView2.setLayoutParams(layoutParams3);
        textView2.setGravity(17);
        textView2.setText(a2);
        textView2.setTextSize(z ? 12.0f : 16.0f);
        textView2.setTextColor(-1);
        textView2.setShadowLayer(8.0f, 3.0f, 3.0f, -16777216);
        addView(frameLayout);
        addView(textView);
        addView(textView2);
    }

    public MBShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MBShakeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    private void a() {
        RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 10.0f, 1, 0.5f, 1, 0.5f);
        this.f4712a = rotateAnimation;
        rotateAnimation.setDuration(100L);
        this.f4712a.setRepeatMode(2);
        this.f4712a.setRepeatCount(-1);
        this.b.startAnimation(this.f4712a);
    }
}
