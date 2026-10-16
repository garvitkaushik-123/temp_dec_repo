package com.mbridge.msdk.video.module;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.video.signal.factory.b;

/* loaded from: classes6.dex */
public abstract class MBridgeNativeEndCardViewDiff extends MBridgeBaseView {
    public TextView ctaView;

    public MBridgeNativeEndCardViewDiff(Context context) {
        super(context);
    }

    public boolean checkChinaShakeState() {
        return false;
    }

    public boolean checkProgressBarIntercepted() {
        return false;
    }

    public boolean ctaViewCanGet(View view, boolean z) {
        try {
            View findViewById = view.findViewById(filterFindViewId(z, "mbridge_tv_cta"));
            if (findViewById instanceof TextView) {
                this.ctaView = (TextView) findViewById;
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return this.ctaView != null;
    }

    public abstract /* synthetic */ void preLoadData(b bVar);

    public MBridgeNativeEndCardViewDiff(Context context, AttributeSet attributeSet, boolean z, int i, boolean z2, int i2, int i3) {
        super(context, attributeSet, z, i, z2, i2, i3);
    }

    public MBridgeNativeEndCardViewDiff(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
