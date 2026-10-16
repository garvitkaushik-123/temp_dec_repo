package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.internal.ads.zzbge;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public class MediationNativeAdConfiguration extends MediationAdConfiguration {
    private final zzbge zza;

    public MediationNativeAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z, Location location, int i, int i2, String str2, String str3, zzbge zzbgeVar) {
        super(context, str, bundle, bundle2, z, location, i, i2, str2, str3);
        this.zza = zzbgeVar;
    }

    public NativeAdOptions getNativeAdOptions() {
        return zzbge.zza(this.zza);
    }
}
