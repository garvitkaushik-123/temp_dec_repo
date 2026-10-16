package com.facebook.ads.internal.api;

import com.facebook.ads.AdClosedListener;

/* loaded from: classes3.dex */
public interface AdOptionsViewApi extends AdComponentViewApiProvider {
    void setIconColor(int i);

    void setIconSizeDp(int i);

    void setOnAdClosedListener(AdClosedListener adClosedListener);

    void setSingleIcon(boolean z);
}
