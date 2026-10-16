package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
final class zzc extends zzb {
    private final Context zza;

    zzc(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        boolean z;
        try {
            z = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.zza);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            int i = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Fail to get isAdIdFakeForDebugLogging", e);
            z = false;
        }
        com.google.android.gms.ads.internal.util.client.zzl.zzj(z);
        int i2 = zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Update ad debug logging enablement as " + z);
    }
}
