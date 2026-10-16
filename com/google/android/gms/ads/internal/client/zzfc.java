package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.internal.ads.zzbwv;
import com.google.android.gms.internal.ads.zzbxe;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzfc extends com.google.android.gms.ads.preload.zzb {
    public zzfc(Context context) {
        super(context, AdFormat.REWARDED);
    }

    public final RewardedAd zza(String str) {
        zzbwv zzbwvVar;
        try {
            zzbwvVar = this.zza.zzl(str);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            zzbwvVar = null;
        }
        if (zzbwvVar == null) {
            return null;
        }
        return new zzbxe(zzc(), zzbwvVar);
    }
}
