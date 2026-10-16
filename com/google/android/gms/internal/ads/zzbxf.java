package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbxf implements RewardItem {
    private final zzbws zza;

    public zzbxf(zzbws zzbwsVar) {
        this.zza = zzbwsVar;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public final int getAmount() {
        zzbws zzbwsVar = this.zza;
        if (zzbwsVar != null) {
            try {
                return zzbwsVar.zze();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Could not forward getAmount to RewardItem", e);
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public final String getType() {
        zzbws zzbwsVar = this.zza;
        if (zzbwsVar != null) {
            try {
                return zzbwsVar.zzf();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Could not forward getType to RewardItem", e);
            }
        }
        return null;
    }
}
