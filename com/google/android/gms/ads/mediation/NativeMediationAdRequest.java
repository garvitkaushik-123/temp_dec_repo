package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAdOptions;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
@Deprecated
/* loaded from: classes4.dex */
public interface NativeMediationAdRequest extends MediationAdRequest {
    float getAdVolume();

    @Deprecated
    NativeAdOptions getNativeAdOptions();

    com.google.android.gms.ads.nativead.NativeAdOptions getNativeAdRequestOptions();

    boolean isAdMuted();

    boolean isUnifiedNativeAdRequested();

    Map zza();

    boolean zzb();
}
