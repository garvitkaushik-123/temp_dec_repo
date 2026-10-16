package com.bytedance.sdk.component.adexpress.MGA;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class kb extends CMM {
    private View DbA;
    private AnimatorSet Os;
    private TextView eli;

    @Override // com.bytedance.sdk.component.adexpress.MGA.CMM
    protected void eli(Context context) {
    }

    public kb(Context context) {
        super(context);
        this.Os = new AnimatorSet();
        DbA(context);
    }

    private void DbA(Context context) {
        View eli = com.bytedance.sdk.component.adexpress.Os.eli.eli(context);
        this.DbA = eli;
        addView(eli);
        setClipChildren(false);
        this.eli = (TextView) findViewById(2097610748);
    }

    public void setButtonText(String str) {
        if (this.eli == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.eli.setText(str);
    }

    private void aGH() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.DbA, "translationY", 0.0f, com.bytedance.sdk.component.adexpress.aGH.kb.eli(getContext(), -3.0f));
        ofFloat.setInterpolator(new CycleInterpolator(1.0f));
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.DbA, "alpha", 1.0f, 0.8f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setInterpolator(new CycleInterpolator(1.0f));
        ofFloat2.setRepeatCount(-1);
        this.Os.playTogether(ofFloat, ofFloat2);
        this.Os.setDuration(1000L);
        this.Os.start();
    }

    @Override // com.bytedance.sdk.component.adexpress.MGA.CMM
    public void eli() {
        aGH();
    }

    @Override // com.bytedance.sdk.component.adexpress.MGA.CMM
    public void DbA() {
        this.Os.cancel();
    }
}
