package com.google.android.gms.internal.ads;

import io.adn.sdk.internal.domain.constants.AnalyticsConstants;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public enum zzflo {
    HTML(AnalyticsConstants.CREATIVE_TYPE_HTML),
    NATIVE("native"),
    JAVASCRIPT("javascript");

    private final String zze;

    zzflo(String str) {
        this.zze = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.zze;
    }
}
