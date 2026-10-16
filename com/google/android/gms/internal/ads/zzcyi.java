package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcyi extends zzdbt implements zzcws, zzcxx {
    private final zzfca zzb;
    private final AtomicBoolean zzc;
    private final zzfcn zzd;

    public zzcyi(Set set, zzfca zzfcaVar, zzfcn zzfcnVar) {
        super(set);
        this.zzc = new AtomicBoolean();
        this.zzb = zzfcaVar;
        this.zzd = zzfcnVar;
    }

    private final void zzb() {
        final com.google.android.gms.ads.internal.client.zzt zztVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzih)).booleanValue() && this.zzc.compareAndSet(false, true) && (zztVar = this.zzb.zzae) != null && zztVar.zza == 3) {
            zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzcyg
                @Override // com.google.android.gms.internal.ads.zzdbs
                public final void zza(Object obj) {
                    ((zzcyk) obj).zzh(com.google.android.gms.ads.internal.client.zzt.this);
                }
            });
        }
    }

    public final void zza(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        if (com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzf(this.zzd) && this.zzb.zzaB) {
            zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzcyh
                @Override // com.google.android.gms.internal.ads.zzdbs
                public final void zza(Object obj) {
                    ((zzcyk) obj).zzh(com.google.android.gms.ads.internal.client.zzt.this);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxx
    public final void zzg() {
        if (this.zzb.zzb == 1) {
            zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcws
    public final void zzt() {
        int i = this.zzb.zzb;
        if (i == 2 || i == 5 || i == 4 || i == 6 || i == 7) {
            zzb();
        }
    }
}
