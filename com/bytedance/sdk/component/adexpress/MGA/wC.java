package com.bytedance.sdk.component.adexpress.MGA;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class wC extends CMM {
    private ImageView DbA;
    private AnimatorSet MGA;
    private ImageView Os;
    private ImageView aGH;
    private TextView eli;
    private int ui;

    @Override // com.bytedance.sdk.component.adexpress.MGA.CMM
    protected void eli(Context context) {
    }

    public wC(Context context) {
        super(context);
        this.MGA = new AnimatorSet();
        DbA(context);
    }

    private void DbA(Context context) {
        addView(com.bytedance.sdk.component.adexpress.Os.eli.DbA(context));
        this.DbA = (ImageView) findViewById(2097610751);
        this.Os = (ImageView) findViewById(2097610750);
        this.aGH = (ImageView) findViewById(2097610749);
        this.eli = (TextView) findViewById(2097610748);
    }

    public void setButtonText(String str) {
        if (this.eli == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.eli.setText(str);
    }

    private void aGH() {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "alphaColor", 0, 60);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(2000L);
        ofInt.setRepeatCount(-1);
        ofInt.start();
    }

    public float getAlphaColor() {
        return this.ui;
    }

    public void setAlphaColor(int i) {
        if (i < 0 || i > 60) {
            return;
        }
        int i2 = i + 195;
        this.aGH.setColorFilter(Color.rgb(i2, i2, i2), PorterDuff.Mode.SRC_IN);
        int i3 = ((i + 20) % 60) + 195;
        this.Os.setColorFilter(Color.rgb(i3, i3, i3), PorterDuff.Mode.SRC_IN);
        int i4 = ((i + 40) % 60) + 195;
        this.DbA.setColorFilter(Color.rgb(i4, i4, i4), PorterDuff.Mode.SRC_IN);
    }

    @Override // com.bytedance.sdk.component.adexpress.MGA.CMM
    public void eli() {
        aGH();
    }

    @Override // com.bytedance.sdk.component.adexpress.MGA.CMM
    public void DbA() {
        this.MGA.cancel();
    }
}
