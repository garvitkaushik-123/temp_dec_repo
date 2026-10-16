package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzche implements zzcld {

    @Nullable
    private static zzche zza;

    private static synchronized zzche zzE(Context context, @Nullable zzbpq zzbpqVar, int i, boolean z, int i2, zzcik zzcikVar) {
        synchronized (zzche.class) {
            zzche zzcheVar = zza;
            if (zzcheVar != null) {
                return zzcheVar;
            }
            long currentTimeMillis = com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis();
            zzbde.zza(context);
            if (((Boolean) zzbew.zze.zze()).booleanValue()) {
                zzbco.zzd(context);
            }
            zzfds zzd = zzfds.zzd(context);
            VersionInfoParcel zzc = zzd.zzc(ModuleDescriptor.MODULE_VERSION, false, i2);
            zzd.zzf(zzbpqVar);
            zzciz zzcizVar = new zzciz(null);
            zzchf zzchfVar = new zzchf();
            zzchfVar.zzf(zzc);
            zzchfVar.zze(context);
            zzchfVar.zzd(currentTimeMillis);
            zzcizVar.zzb(new zzchh(zzchfVar, null));
            zzcizVar.zzc(new zzcjt(zzcikVar));
            zzche zza2 = zzcizVar.zza();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznS)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zzq().zzb(zzffu.zzc(), zza2.zzi());
                com.google.android.gms.ads.internal.zzv.zzq().zzc();
            }
            com.google.android.gms.ads.internal.zzv.zzp().zzu(context, zzc);
            com.google.android.gms.ads.internal.zzv.zzc().zzi(context);
            com.google.android.gms.ads.internal.zzv.zzr().zzm(context);
            com.google.android.gms.ads.internal.zzv.zzr().zzl(context);
            com.google.android.gms.ads.internal.util.zzd.zza(context);
            com.google.android.gms.ads.internal.zzv.zzb().zzd(context);
            com.google.android.gms.ads.internal.zzv.zzx().zzb(context);
            ((com.google.android.gms.ads.internal.util.zzcb) ((zzcio) zza2).zzak.zzb()).zzc();
            zzbyp.zzb(context);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgv)).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaM)).booleanValue()) {
                    new zzebn(context, zzc, new zzbcc(new zzbci(context)), new zzeas(new zzeao(context), (zzgdy) ((zzcio) zza2).zzd.zzb())).zzb(com.google.android.gms.ads.internal.zzv.zzp().zzi().zzN());
                }
            }
            zza = zza2;
            return zza2;
        }
    }

    public static zzche zza(Context context, @Nullable zzbpq zzbpqVar, int i) {
        return zzE(context, zzbpqVar, ModuleDescriptor.MODULE_VERSION, false, i, new zzcik());
    }

    public abstract Executor zzA();

    public abstract ScheduledExecutorService zzB();

    public abstract zzbzh zzC();

    @Override // com.google.android.gms.internal.ads.zzcld
    public final zzbzh zzD() {
        return zzC();
    }

    public abstract zzcke zzb();

    public abstract zzcof zzc();

    public abstract zzcpw zzd();

    public abstract zzcyv zze();

    public abstract zzdge zzf();

    public abstract zzdha zzg();

    public abstract zzdor zzh();

    public abstract zzdsj zzi();

    public abstract zzdtt zzj();

    public abstract zzdvi zzk();

    public abstract zzdwf zzl();

    public abstract zzecl zzm();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzv zzn();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzab zzo();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzau zzp();

    @Override // com.google.android.gms.internal.ads.zzcld
    public final zzevf zzq(zzbvq zzbvqVar, int i) {
        return zzr(new zzewi(zzbvqVar, i));
    }

    protected abstract zzevf zzr(zzewi zzewiVar);

    public abstract zzexa zzs();

    public abstract zzeyo zzt();

    public abstract zzfaf zzu();

    public abstract zzfbt zzv();

    public abstract zzfdl zzw();

    public abstract zzfdv zzx();

    public abstract zzfhx zzy();

    public abstract zzfkj zzz();
}
