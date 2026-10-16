package io.bidmachine.banner;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.vungle.ads.internal.protos.Sdk;

/* loaded from: classes7.dex */
public enum BannerSize {
    Size_320x50(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50),
    Size_300x250(300, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION),
    Size_728x90(728, 90);

    public final int height;
    public final int width;

    BannerSize(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
