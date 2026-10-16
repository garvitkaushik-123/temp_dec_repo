package com.iab.omid.library.applovin.adsession;

import com.google.firebase.ktx.BuildConfig;
import com.ironsource.C3040d4;

/* loaded from: classes4.dex */
public enum ImpressionType {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    UNSPECIFIED(BuildConfig.VERSION_NAME),
    LOADED(C3040d4.h.r),
    BEGIN_TO_RENDER("beginToRender"),
    ONE_PIXEL("onePixel"),
    VIEWABLE("viewable"),
    AUDIBLE("audible"),
    OTHER("other");

    private final String impressionType;

    ImpressionType(String str) {
        this.impressionType = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.impressionType;
    }
}
