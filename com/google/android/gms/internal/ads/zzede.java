package com.google.android.gms.internal.ads;

import com.google.firebase.ktx.BuildConfig;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public enum zzede {
    BEGIN_TO_RENDER("beginToRender"),
    DEFINED_BY_JAVASCRIPT("definedByJavascript"),
    ONE_PIXEL("onePixel"),
    UNSPECIFIED(BuildConfig.VERSION_NAME);

    private final String zzf;

    zzede(String str) {
        this.zzf = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.zzf;
    }
}
