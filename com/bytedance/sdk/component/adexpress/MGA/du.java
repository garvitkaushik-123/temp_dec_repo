package com.bytedance.sdk.component.adexpress.MGA;

import android.content.Context;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class du extends FrameLayout {
    private final ImageView DbA;
    private final nlS Os;
    private final RotateAnimation aGH;
    private final TextView eli;

    public du(Context context) {
        super(context);
        addView(com.bytedance.sdk.component.adexpress.Os.eli.aGH(context));
        this.eli = (TextView) findViewById(2097610742);
        this.DbA = (ImageView) findViewById(2097610745);
        this.Os = (nlS) findViewById(2097610744);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 30.0f, 1, 0.65f, 1, 0.9f);
        this.aGH = rotateAnimation;
        rotateAnimation.setDuration(300L);
        rotateAnimation.setRepeatMode(2);
        rotateAnimation.setRepeatCount(1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Slide or click to jump to the details page or third-party application";
        }
        TextView textView = this.eli;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void eli() {
        postDelayed(getHaloAnimation(), 300L);
    }

    public void DbA() {
        this.aGH.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable getHaloAnimation() {
        return new Runnable() { // from class: com.bytedance.sdk.component.adexpress.MGA.du.1
            @Override // java.lang.Runnable
            public void run() {
                du.this.DbA.startAnimation(du.this.aGH);
                du.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.MGA.du.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        du.this.Os.eli(4);
                    }
                }, 100L);
                du.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.MGA.du.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        du.this.Os.eli(4);
                    }
                }, 300L);
                du duVar = du.this;
                duVar.postDelayed(duVar.getHaloAnimation(), 1200L);
            }
        };
    }
}
