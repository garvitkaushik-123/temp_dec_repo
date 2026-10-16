package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.common.util.Clock;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzegz implements zzgdj {
    final /* synthetic */ long zza;
    final /* synthetic */ zzfcd zzb;
    final /* synthetic */ zzfca zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzfju zze;
    final /* synthetic */ zzfcn zzf;
    final /* synthetic */ zzehb zzg;

    zzegz(zzehb zzehbVar, long j, zzfcd zzfcdVar, zzfca zzfcaVar, String str, zzfju zzfjuVar, zzfcn zzfcnVar) {
        this.zza = j;
        this.zzb = zzfcdVar;
        this.zzc = zzfcaVar;
        this.zzd = str;
        this.zze = zzfjuVar;
        this.zzf = zzfcnVar;
        Objects.requireNonNull(zzehbVar);
        this.zzg = zzehbVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzgdj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(Throwable th) {
        Clock clock;
        int i;
        int i2;
        com.google.android.gms.ads.internal.client.zze zzb;
        Integer valueOf;
        boolean z;
        boolean z2;
        LinkedHashMap linkedHashMap;
        com.google.android.gms.ads.internal.client.zze zzeVar;
        zzedr zzedrVar;
        zzfjy zzfjyVar;
        zzehd zzehdVar;
        zzehb zzehbVar = this.zzg;
        clock = zzehbVar.zza;
        long elapsedRealtime = clock.elapsedRealtime() - this.zza;
        if (th instanceof TimeoutException) {
            i2 = 2;
        } else {
            if (th instanceof zzegj) {
                i = 3;
            } else if (th instanceof CancellationException) {
                i2 = 4;
            } else if (th instanceof zzfdd) {
                i2 = 5;
            } else if (th instanceof zzdwm) {
                i2 = zzfdx.zza(th).zza == 3 ? 1 : 6;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbO)).booleanValue() && (th instanceof zzedq) && (zzb = ((zzedq) th).zzb()) != null) {
                    valueOf = Integer.valueOf(zzb.zza);
                    i = i2;
                    synchronized (zzehbVar) {
                        z = zzehbVar.zze;
                        if (z) {
                            zzehdVar = zzehbVar.zzb;
                            zzehdVar.zza(this.zzb, this.zzc, i, th instanceof zzedq ? (zzedq) th : null, elapsedRealtime);
                            elapsedRealtime = elapsedRealtime;
                        }
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziK)).booleanValue()) {
                            zzfjyVar = zzehbVar.zzc;
                            zzfju zzfjuVar = this.zze;
                            zzfcn zzfcnVar = this.zzf;
                            zzfca zzfcaVar = this.zzc;
                            zzfjyVar.zze(zzfjuVar.zzd(zzfcnVar, zzfcaVar, zzfcaVar.zzn), zzfcaVar.zzax);
                        }
                        z2 = zzehbVar.zzg;
                        if (z2) {
                            return;
                        }
                        linkedHashMap = zzehbVar.zzd;
                        zzfca zzfcaVar2 = this.zzc;
                        linkedHashMap.put(zzfcaVar2, new zzeha(this.zzd, zzfcaVar2.zzaf, i, elapsedRealtime, valueOf));
                        com.google.android.gms.ads.internal.client.zze zza = zzfdx.zza(th);
                        int i3 = zza.zza;
                        if ((i3 == 3 || i3 == 0) && (zzeVar = zza.zzd) != null && !zzeVar.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                            zza = zzfdx.zza(new zzedq(13, zza.zzd));
                        }
                        zzedrVar = zzehbVar.zzf;
                        zzedrVar.zzf(zzfcaVar2, elapsedRealtime, zza);
                        return;
                    }
                }
            } else {
                i = 6;
            }
            valueOf = null;
            synchronized (zzehbVar) {
            }
        }
        i = i2;
        valueOf = null;
        synchronized (zzehbVar) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zzb(Object obj) {
        Clock clock;
        boolean z;
        long j;
        boolean z2;
        boolean zzq;
        LinkedHashMap linkedHashMap;
        zzedr zzedrVar;
        LinkedHashMap linkedHashMap2;
        zzehd zzehdVar;
        zzehb zzehbVar = this.zzg;
        clock = zzehbVar.zza;
        long elapsedRealtime = clock.elapsedRealtime() - this.zza;
        synchronized (zzehbVar) {
            z = zzehbVar.zze;
            if (z) {
                zzehdVar = zzehbVar.zzb;
                j = elapsedRealtime;
                zzehdVar.zza(this.zzb, this.zzc, 0, null, j);
            } else {
                j = elapsedRealtime;
            }
            z2 = zzehbVar.zzg;
            if (z2) {
                return;
            }
            zzfca zzfcaVar = this.zzc;
            zzq = zzehbVar.zzq(zzfcaVar);
            if (zzq) {
                linkedHashMap2 = zzehbVar.zzd;
                ((zzeha) linkedHashMap2.get(zzfcaVar)).zzd = j;
            } else {
                linkedHashMap = zzehbVar.zzd;
                long j2 = j;
                j = j2;
                linkedHashMap.put(zzfcaVar, new zzeha(this.zzd, zzfcaVar.zzaf, 0, j2, null));
            }
            zzedrVar = zzehbVar.zzf;
            zzedrVar.zzg(zzfcaVar, j, null);
        }
    }
}
