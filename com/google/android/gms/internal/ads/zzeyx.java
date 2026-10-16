package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbcj;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeyx implements zzezr {
    private final zzezr zza;
    private final zzezr zzb;
    private final zzfff zzc;
    private final String zzd;
    private zzcve zze;
    private final Executor zzf;

    public zzeyx(zzezr zzezrVar, zzezr zzezrVar2, zzfff zzfffVar, String str, Executor executor) {
        this.zza = zzezrVar;
        this.zzb = zzezrVar2;
        this.zzc = zzfffVar;
        this.zzd = str;
        this.zzf = executor;
    }

    public static /* synthetic */ ListenableFuture zzb(final zzeyx zzeyxVar, zzezs zzezsVar, zzeyw zzeywVar, zzezq zzezqVar, zzcve zzcveVar, zzezc zzezcVar) {
        if (zzezcVar != null) {
            zzeyw zzeywVar2 = new zzeyw(zzeywVar.zza, zzeywVar.zzb, zzeywVar.zzc, zzeywVar.zzd, zzeywVar.zze, zzeywVar.zzf, zzezcVar.zza);
            zzfes zzfesVar = zzezcVar.zzc;
            if (zzfesVar != null) {
                zzeyxVar.zze = null;
                zzeyxVar.zzc.zzf(zzeywVar2);
                return zzeyxVar.zzg(zzfesVar, zzezsVar);
            }
            zzfff zzfffVar = zzeyxVar.zzc;
            ListenableFuture zza = zzfffVar.zza(zzeywVar2);
            if (zza != null) {
                zzeyxVar.zze = null;
                return zzgdn.zzn(zza, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzeyt
                    @Override // com.google.android.gms.internal.ads.zzgcu
                    public final ListenableFuture zza(Object obj) {
                        return zzeyx.zze(zzeyx.this, (zzffc) obj);
                    }
                }, zzeyxVar.zzf);
            }
            zzfffVar.zzf(zzeywVar2);
            zzezsVar = new zzezs(zzezsVar.zzb, zzezcVar.zzb);
        }
        ListenableFuture zzb = ((zzezh) zzeyxVar.zza).zzb(zzezsVar, zzezqVar, zzcveVar);
        zzeyxVar.zze = zzcveVar;
        return zzb;
    }

    public static /* synthetic */ ListenableFuture zze(zzeyx zzeyxVar, zzffc zzffcVar) {
        zzfes zzfesVar;
        zzffe zzffeVar;
        if (zzffcVar == null || (zzfesVar = zzffcVar.zza) == null || (zzffeVar = zzffcVar.zzb) == null) {
            throw new zzdwm(1, "Empty prefetch");
        }
        zzbcj.zzb.zzc zzd = zzbcj.zzb.zzd();
        zzbcj.zzb.zza.C0218zza zza = zzbcj.zzb.zza.zza();
        zza.zzf(zzbcj.zzb.zzd.IN_MEMORY);
        zza.zzh(zzbcj.zzb.zze.zzi());
        zzd.zzd(zza);
        zzfesVar.zza.zzb().zzc().zzm(zzd.zzbr());
        return zzeyxVar.zzg(zzfesVar, ((zzeyw) zzffeVar).zzb);
    }

    private final ListenableFuture zzg(zzfes zzfesVar, zzezs zzezsVar) {
        zzcve zzcveVar = zzfesVar.zza;
        this.zze = zzcveVar;
        if (zzfesVar.zzc != null) {
            if (zzcveVar.zze() != null) {
                zzfesVar.zzc.zzp().zzl(zzfesVar.zza.zze());
            }
            return zzgdn.zzh(zzfesVar.zzc);
        }
        zzcveVar.zzb().zzk(zzfesVar.zzb);
        return ((zzezh) this.zza).zzb(zzezsVar, null, zzfesVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzezr
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcve zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzezr
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzezs zzezsVar, zzezq zzezqVar, Object obj) {
        return zzf(zzezsVar, zzezqVar, null);
    }

    public final synchronized ListenableFuture zzf(final zzezs zzezsVar, final zzezq zzezqVar, zzcve zzcveVar) {
        zzcvd zza = zzezqVar.zza(zzezsVar.zzb);
        zza.zza(new zzeyy(this.zzd));
        final zzcve zzcveVar2 = (zzcve) zza.zzh();
        zzcveVar2.zzf();
        zzcveVar2.zzf();
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzcveVar2.zzf().zzd;
        if (zzmVar.zzs == null && zzmVar.zzx == null) {
            zzfcw zzf = zzcveVar2.zzf();
            com.google.android.gms.ads.internal.client.zzm zzmVar2 = zzf.zzd;
            String str = zzf.zzf;
            com.google.android.gms.ads.internal.client.zzx zzxVar = zzf.zzj;
            Executor executor = this.zzf;
            final zzeyw zzeywVar = new zzeyw(zzezqVar, zzezsVar, zzmVar2, str, executor, zzxVar, null);
            zzcve zzcveVar3 = zzcveVar2;
            return (zzgde) zzgdn.zzn(zzgde.zzw(((zzezd) this.zzb).zzb(zzezsVar, zzezqVar, zzcveVar2)), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzeyu
                @Override // com.google.android.gms.internal.ads.zzgcu
                public final ListenableFuture zza(Object obj) {
                    return zzeyx.zzb(zzeyx.this, zzezsVar, zzeywVar, zzezqVar, zzcveVar2, (zzezc) obj);
                }
            }, executor);
        }
        this.zze = zzcveVar2;
        zzcve zzcveVar4 = zzcveVar2;
        return ((zzezh) this.zza).zzb(zzezsVar, zzezqVar, zzcveVar2);
    }
}
