package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfed implements zzcwb {
    private final HashSet zza = new HashSet();
    private final Context zzb;
    private final zzbzw zzc;

    public zzfed(Context context, zzbzw zzbzwVar) {
        this.zzb = context;
        this.zzc = zzbzwVar;
    }

    public final Bundle zzb() {
        return this.zzc.zzn(this.zzb, this);
    }

    public final synchronized void zzc(HashSet hashSet) {
        HashSet hashSet2 = this.zza;
        hashSet2.clear();
        hashSet2.addAll(hashSet);
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final synchronized void zzdD(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (zzeVar.zza != 3) {
            this.zzc.zzl(this.zza);
        }
    }
}
