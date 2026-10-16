package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcmp implements zzgdj {
    final /* synthetic */ zzfjy zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ com.google.android.gms.ads.internal.util.client.zzv zzc;
    final /* synthetic */ zzcmq zzd;

    zzcmp(zzcmq zzcmqVar, zzfjy zzfjyVar, String str, com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        this.zza = zzfjyVar;
        this.zzb = str;
        this.zzc = zzvVar;
        Objects.requireNonNull(zzcmqVar);
        this.zzd = zzcmqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(final Throwable th) {
        zzgdy zzgdyVar;
        zzgdyVar = this.zzd.zzg;
        final zzfjy zzfjyVar = this.zza;
        final String str = this.zzb;
        final com.google.android.gms.ads.internal.util.client.zzv zzvVar = this.zzc;
        zzgdyVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcmn
            @Override // java.lang.Runnable
            public final void run() {
                Context context;
                Context context2;
                boolean booleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkL)).booleanValue();
                zzcmp zzcmpVar = zzcmp.this;
                Throwable th2 = th;
                if (booleanValue) {
                    zzcmq zzcmqVar = zzcmpVar.zzd;
                    context2 = zzcmqVar.zzc;
                    zzcmqVar.zzb = zzbun.zzc(context2);
                    zzcmqVar.zzb.zzh(th2, "AttributionReporting.registerSourceAndPingClickUrl");
                } else {
                    zzcmq zzcmqVar2 = zzcmpVar.zzd;
                    context = zzcmqVar2.zzc;
                    zzcmqVar2.zza = zzbun.zza(context);
                    zzcmqVar2.zza.zzh(th2, "AttributionReportingSampled.registerSourceAndPingClickUrl");
                }
                com.google.android.gms.ads.internal.util.client.zzv zzvVar2 = zzvVar;
                zzfjyVar.zzd(str, zzvVar2, null, null);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzgdy zzgdyVar;
        final zzfjy zzfjyVar = this.zza;
        final String str = (String) obj;
        zzgdyVar = this.zzd.zzg;
        final com.google.android.gms.ads.internal.util.client.zzv zzvVar = this.zzc;
        zzgdyVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcmo
            @Override // java.lang.Runnable
            public final void run() {
                zzfjy.this.zzd(str, zzvVar, null, null);
            }
        });
    }
}
