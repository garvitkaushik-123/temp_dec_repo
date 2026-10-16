package com.bytedance.sdk.openadsdk.api.banner;

import android.content.Context;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.sdk.openadsdk.utils.Os;
import com.vungle.ads.internal.protos.Sdk;

/* loaded from: classes3.dex */
public final class PAGBannerSize {
    private int DbA;
    private int Os = 1;
    private int aGH;
    private int eli;
    public static final PAGBannerSize BANNER_W_320_H_50 = new PAGBannerSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50);
    public static final PAGBannerSize BANNER_W_300_H_250 = new PAGBannerSize(300, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    public static final PAGBannerSize BANNER_W_728_H_90 = new PAGBannerSize(728, 90);

    public PAGBannerSize(int i, int i2) {
        this.eli = i;
        this.DbA = i2;
    }

    public int getWidth() {
        return this.eli;
    }

    public int getHeight() {
        return this.DbA;
    }

    public int getType() {
        return this.Os;
    }

    public int getMaxHeight() {
        return this.aGH;
    }

    public static PAGBannerSize getCurrentOrientationAnchoredAdaptiveBannerAdSize(Context context, int i) {
        int eli = Os.eli(context, i, 0);
        if (eli == Os.eli) {
            return new PAGBannerSize(-1, -1);
        }
        PAGBannerSize pAGBannerSize = new PAGBannerSize(i, eli);
        pAGBannerSize.Os = 2;
        return pAGBannerSize;
    }

    public static PAGBannerSize getCurrentOrientationInlineAdaptiveBannerAdSize(Context context, int i) {
        int eli = Os.eli(context, 0);
        if (eli == Os.eli) {
            return new PAGBannerSize(-1, -1);
        }
        PAGBannerSize pAGBannerSize = new PAGBannerSize(i, 0);
        pAGBannerSize.aGH = eli;
        pAGBannerSize.Os = 3;
        return pAGBannerSize;
    }

    public static PAGBannerSize getInlineAdaptiveBannerAdSize(int i, int i2) {
        PAGBannerSize pAGBannerSize = new PAGBannerSize(i, 0);
        pAGBannerSize.aGH = i2;
        pAGBannerSize.Os = 3;
        return pAGBannerSize;
    }
}
