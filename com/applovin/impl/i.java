package com.applovin.impl;

import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;

/* loaded from: classes2.dex */
public enum i {
    PUBLISHER_INITIATED("publisher_initiated"),
    SEQUENTIAL_OR_PRECACHE("sequential_or_precache"),
    REFRESH(ToolBar.REFRESH),
    EXPONENTIAL_RETRY("exponential_retry"),
    EXPIRED("expired"),
    NATIVE_AD_PLACER("native_ad_placer");


    /* renamed from: a, reason: collision with root package name */
    private final String f480a;

    i(String str) {
        this.f480a = str;
    }

    public String b() {
        return this.f480a;
    }
}
