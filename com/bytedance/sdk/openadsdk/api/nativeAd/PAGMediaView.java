package com.bytedance.sdk.openadsdk.api.nativeAd;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class PAGMediaView extends FrameLayout {
    protected Integer eli;

    public void close() {
    }

    public void setVideoAdListener(PAGVideoAdListener pAGVideoAdListener) {
    }

    public PAGMediaView(Context context) {
        super(context);
    }

    public PAGMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PAGMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PAGMediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setMrcTrackerKey(Integer num) {
        this.eli = num;
    }
}
