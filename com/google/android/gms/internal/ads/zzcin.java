package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcin extends zzevf {
    final zzhha zza;
    final zzhha zzb;
    final zzhha zzc;
    final zzhha zzd;
    final zzhha zze;
    final zzhha zzf;
    final zzhha zzg;
    final zzhha zzh;
    final zzhha zzi;
    final zzhha zzj;
    final zzhha zzk;
    final zzhha zzl;
    final zzhha zzm;
    final zzhha zzn;
    final zzhha zzo;
    final zzhha zzp;
    final zzhha zzq;
    final zzhha zzr;
    final zzhha zzs;
    final zzhha zzt;
    final zzhha zzu;
    final zzhha zzv;
    final zzhha zzw;
    final zzhha zzx;
    private final zzewi zzy;
    private final zzcio zzz;

    zzcin(zzcio zzcioVar, zzewi zzewiVar) {
        this.zzz = zzcioVar;
        this.zzy = zzewiVar;
        this.zza = zzhgq.zzc(zzfhv.zza(zzcioVar.zzz));
        zzewk zza = zzewk.zza(zzewiVar);
        this.zzb = zza;
        zzewl zza2 = zzewl.zza(zzewiVar);
        this.zzc = zza2;
        zzewm zza3 = zzewm.zza(zzewiVar);
        this.zzd = zza3;
        zzckz zzckzVar = zzcky.zza;
        zzhha zzhhaVar = zzcioVar.zzf;
        zzhha zzhhaVar2 = zzcioVar.zzc;
        this.zze = zzeve.zza(zzckzVar, zzhhaVar, zzhhaVar2, zzffu.zza(), zza, zza2, zza3);
        this.zzf = zzevs.zza(zzcks.zza, zzffu.zza(), zzhhaVar);
        zzewj zza4 = zzewj.zza(zzewiVar);
        this.zzg = zza4;
        this.zzh = zzewa.zza(zzcku.zza, zzffu.zza(), zza4);
        this.zzi = zzewh.zza(zzckw.zza, zzhhaVar2, zzhhaVar);
        this.zzj = zzewz.zza(zzffu.zza());
        zzewo zza5 = zzewo.zza(zzewiVar);
        this.zzk = zza5;
        zzewp zza6 = zzewp.zza(zzewiVar);
        this.zzl = zza6;
        zzhha zzhhaVar3 = zzcioVar.zzal;
        this.zzm = zzewv.zza(zzhhaVar3, zza3, zzcla.zza, zzffu.zza(), zza4, zzhhaVar2, zza5, zza6);
        this.zzn = zzevo.zza(zza4, zzckq.zza, zzhhaVar3, zzhhaVar2, zzffu.zza());
        zzewn zza7 = zzewn.zza(zzewiVar);
        this.zzo = zza7;
        zzhha zzc = zzhgq.zzc(zzdrd.zza());
        this.zzp = zzc;
        zzhha zzc2 = zzhgq.zzc(zzdrb.zza());
        this.zzq = zzc2;
        zzhha zzc3 = zzhgq.zzc(zzdrf.zza());
        this.zzr = zzc3;
        zzhha zzc4 = zzhgq.zzc(zzdrh.zza());
        this.zzs = zzc4;
        zzhgu zzc5 = zzhgv.zzc(4);
        zzc5.zzb(zzfgu.GMS_SIGNALS, zzc);
        zzc5.zzb(zzfgu.BUILD_URL, zzc2);
        zzc5.zzb(zzfgu.HTTP, zzc3);
        zzc5.zzb(zzfgu.PRE_PROCESS, zzc4);
        zzhgv zzc6 = zzc5.zzc();
        this.zzt = zzc6;
        zzhha zzc7 = zzhgq.zzc(zzdri.zza(zza7, zzcioVar.zzf, zzffu.zza(), zzc6));
        this.zzu = zzc7;
        zzhhc zza8 = zzhhd.zza(0, 1);
        zza8.zza(zzc7);
        zzhhd zzc8 = zza8.zzc();
        this.zzv = zzc8;
        zzfhd zzc9 = zzfhd.zzc(zzc8);
        this.zzw = zzc9;
        this.zzx = zzhgq.zzc(zzfhc.zza(zzffu.zza(), zzcioVar.zzc, zzc9));
    }

    @Override // com.google.android.gms.internal.ads.zzevf
    public final zzeuf zza() {
        zzchh zzchhVar;
        zzcio zzcioVar = this.zzz;
        zzchhVar = zzcioVar.zzbp;
        Context zzc = zzchl.zzc(zzchhVar);
        zzhha zzhhaVar = this.zza;
        zzhha zzhhaVar2 = this.zzn;
        zzhha zzhhaVar3 = this.zzm;
        zzhha zzhhaVar4 = this.zzj;
        zzhha zzhhaVar5 = this.zzi;
        zzhha zzhhaVar6 = this.zzh;
        zzhha zzhhaVar7 = this.zzf;
        zzhha zzhhaVar8 = this.zze;
        return zzewq.zza(zzc, zzckv.zza(), zzclb.zza(), zzcioVar.zzbo.zzb(), zzc(), zzd(), zzhgq.zza(zzhhaVar8), zzhgq.zza(zzhhaVar7), zzhgq.zza(zzhhaVar6), zzhgq.zza(zzhhaVar5), zzhgq.zza(zzhhaVar4), zzhgq.zza(zzhhaVar3), zzhgq.zza(zzhhaVar2), zzffu.zzc(), (zzfhu) zzhhaVar.zzb(), (zzdsj) zzcioVar.zzl.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzevf
    public final zzeuf zzb() {
        zzchh zzchhVar;
        zzchh zzchhVar2;
        zzchh zzchhVar3;
        zzchh zzchhVar4;
        zzcio zzcioVar = this.zzz;
        zzchhVar = zzcioVar.zzbp;
        Context zzc = zzchl.zzc(zzchhVar);
        zzewi zzewiVar = this.zzy;
        zzgdy zzc2 = zzffu.zzc();
        zzevy zzevyVar = new zzevy(zzckv.zza(), zzffu.zzc(), zzewj.zzd(zzewiVar));
        zzhha zzhhaVar = zzcioVar.zzc;
        zzeso zzesoVar = new zzeso(zzevyVar, 0L, (ScheduledExecutorService) zzhhaVar.zzb());
        zzbtu zza = zzckx.zza();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) zzhhaVar.zzb();
        zzchhVar2 = zzcioVar.zzbp;
        zzeso zzesoVar2 = new zzeso(new zzewf(zza, scheduledExecutorService, zzchl.zzc(zzchhVar2)), ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzex)).longValue(), (ScheduledExecutorService) zzhhaVar.zzb());
        zzbzj zza2 = zzckz.zza();
        zzchhVar3 = zzcioVar.zzbp;
        zzeso zzesoVar3 = new zzeso(zzeve.zzc(zza2, zzchl.zzc(zzchhVar3), (ScheduledExecutorService) zzhhaVar.zzb(), zzffu.zzc(), zzewiVar.zza(), zzewl.zzd(zzewiVar), zzewm.zzd(zzewiVar)), 0L, (ScheduledExecutorService) zzhhaVar.zzb());
        zzeso zzesoVar4 = new zzeso(new zzewx(zzffu.zzc()), 0L, (ScheduledExecutorService) zzhhaVar.zzb());
        zzbbr zza3 = zzckt.zza();
        zzgdy zzc3 = zzffu.zzc();
        zzchhVar4 = zzcioVar.zzbp;
        return new zzeuf(zzc, zzc2, zzfyv.zzs(zzesoVar, zzesoVar2, zzesoVar3, zzesoVar4, new zzevq(zza3, zzc3, zzchl.zzc(zzchhVar4)), zzd(), zzc(), (zzeuc) zzcioVar.zzbo.zzb(), zzevo.zzc(zzewj.zzd(zzewiVar), zzckr.zza(), (zzbzs) zzcioVar.zzal.zzb(), (ScheduledExecutorService) zzhhaVar.zzb(), zzffu.zzc())), (zzfhu) this.zza.zzb(), (zzdsj) zzcioVar.zzl.zzb());
    }

    final zzevi zzc() {
        zzewi zzewiVar = this.zzy;
        return new zzevi(zzckz.zza(), zzffu.zzc(), zzewiVar.zzf(), zzewiVar.zzd(), zzewiVar.zza());
    }

    final zzewc zzd() {
        zzewi zzewiVar = this.zzy;
        zzbcn zza = zzcko.zza();
        zzgdy zzc = zzffu.zzc();
        List zzh = zzewiVar.zzh();
        zzhgz.zzb(zzh);
        return new zzewc(zza, zzc, zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzevf
    public final zzfha zze() {
        return (zzfha) this.zzx.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzevf
    public final zzfhu zzf() {
        return (zzfhu) this.zza.zzb();
    }
}
