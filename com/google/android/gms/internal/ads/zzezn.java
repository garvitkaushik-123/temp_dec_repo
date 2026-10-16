package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzezn {
    private final zzfej zza;
    private final zzcve zzb;
    private final Executor zzc;
    private zzezl zzd;

    public zzezn(zzfej zzfejVar, zzcve zzcveVar, Executor executor) {
        this.zza = zzfejVar;
        this.zzb = zzcveVar;
        this.zzc = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public final zzfet zze() {
        zzfcw zzf = this.zzb.zzf();
        return this.zza.zzc(zzf.zzd, zzf.zzf, zzf.zzj);
    }

    public final ListenableFuture zzc() {
        ListenableFuture listenableFuture;
        zzezl zzezlVar = this.zzd;
        if (zzezlVar != null) {
            return zzgdn.zzh(zzezlVar);
        }
        if (((Boolean) zzbfl.zza.zze()).booleanValue()) {
            zzgde zzw = zzgde.zzw(this.zzb.zzb().zzf(this.zza.zza()));
            zzezk zzezkVar = new zzezk(this);
            Executor executor = this.zzc;
            listenableFuture = (zzgde) zzgdn.zze((zzgde) zzgdn.zzm(zzw, zzezkVar, executor), zzdyx.class, new zzezj(this), executor);
        } else {
            zzezl zzezlVar2 = new zzezl(null, zze(), null);
            this.zzd = zzezlVar2;
            listenableFuture = zzgdn.zzh(zzezlVar2);
        }
        return zzgdn.zzm(listenableFuture, new zzfve() { // from class: com.google.android.gms.internal.ads.zzezi
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                return (zzezl) obj;
            }
        }, this.zzc);
    }
}
