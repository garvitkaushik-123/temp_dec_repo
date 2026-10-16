package com.applovin.impl.adview;

import android.content.Context;
import android.widget.VideoView;

/* loaded from: classes2.dex */
public class AppLovinVideoView extends VideoView {
    public AppLovinVideoView(Context context) {
        super(context, null, 0);
    }

    public void setVideoSize(int i, int i2) {
        getHolder().setFixedSize(i, i2);
        requestLayout();
        invalidate();
    }
}
