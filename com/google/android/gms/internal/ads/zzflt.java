package com.google.android.gms.internal.ads;

import com.google.firebase.ktx.BuildConfig;
import com.ironsource.C3040d4;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public enum zzflt {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    UNSPECIFIED(BuildConfig.VERSION_NAME),
    LOADED(C3040d4.h.r),
    BEGIN_TO_RENDER("beginToRender"),
    ONE_PIXEL("onePixel"),
    VIEWABLE("viewable"),
    AUDIBLE("audible"),
    OTHER("other");

    private final String zzj;

    zzflt(String str) {
        this.zzj = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.zzj;
    }
}
