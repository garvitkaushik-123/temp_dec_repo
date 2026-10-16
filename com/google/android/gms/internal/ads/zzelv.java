package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzelv implements zzelo {
    private final zzfcu zza;
    private final zzche zzb;
    private final Context zzc;
    private final zzell zzd;
    private final zzfhx zze;
    private zzcrp zzf;

    public zzelv(zzche zzcheVar, Context context, zzell zzellVar, zzfcu zzfcuVar) {
        this.zzb = zzcheVar;
        this.zzc = context;
        this.zzd = zzellVar;
        this.zza = zzfcuVar;
        this.zze = zzcheVar.zzy();
        zzfcuVar.zzw(zzellVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzelo
    public final boolean zza() {
        zzcrp zzcrpVar = this.zzf;
        return zzcrpVar != null && zzcrpVar.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzelo
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzelm zzelmVar, zzeln zzelnVar) throws RemoteException {
        com.google.android.gms.ads.internal.zzv.zzr();
        Context context = this.zzc;
        if (com.google.android.gms.ads.internal.util.zzs.zzI(context) && zzmVar.zzs == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to load the ad because app ID is missing.");
            this.zzb.zzA().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzelq
                @Override // java.lang.Runnable
                public final void run() {
                    zzelv.this.zzd.zza().zzdD(zzfdx.zzd(4, null, null));
                }
            });
            return false;
        }
        if (str == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zzA().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzelr
                @Override // java.lang.Runnable
                public final void run() {
                    zzelv.this.zzd.zza().zzdD(zzfdx.zzd(6, null, null));
                }
            });
            return false;
        }
        boolean z = zzmVar.zzf;
        zzfdt.zza(context, z);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjp)).booleanValue() && z) {
            this.zzb.zzk().zzo(true);
        }
        int i3 = ((zzelp) zzelmVar).zza;
        long currentTimeMillis = com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis();
        String zza = zzdrr.PUBLIC_API_CALL.zza();
        Long valueOf = Long.valueOf(currentTimeMillis);
        Bundle zza2 = zzdrt.zza(new Pair(zza, valueOf), new Pair(zzdrr.DYNAMITE_ENTER.zza(), valueOf));
        zzfcu zzfcuVar = this.zza;
        zzfcuVar.zzJ(zzmVar);
        zzfcuVar.zzB(zza2);
        zzfcuVar.zzD(i3);
        zzfcw zzL = zzfcuVar.zzL();
        zzfhj zzb = zzfhi.zzb(context, zzfht.zzf(zzL), 8, zzmVar);
        com.google.android.gms.ads.internal.client.zzco zzcoVar = zzL.zzn;
        if (zzcoVar != null) {
            this.zzd.zzd().zzm(zzcoVar);
        }
        zzche zzcheVar = this.zzb;
        zzdha zzg = zzcheVar.zzg();
        zzcvf zzcvfVar = new zzcvf();
        zzcvfVar.zzf(context);
        zzcvfVar.zzk(zzL);
        zzg.zzf(zzcvfVar.zzl());
        zzdbu zzdbuVar = new zzdbu();
        zzell zzellVar = this.zzd;
        zzdbuVar.zzk(zzellVar.zzd(), zzcheVar.zzA());
        zzg.zze(zzdbuVar.zzn());
        zzg.zzd(zzellVar.zzc());
        zzfhu zzfhuVar = null;
        zzg.zzc(new zzcop(null));
        zzdhb zzg2 = zzg.zzg();
        if (((Boolean) zzbex.zzc.zze()).booleanValue()) {
            zzfhuVar = zzg2.zzf();
            zzfhuVar.zzi(8);
            zzfhuVar.zzb(zzmVar.zzp);
            zzfhuVar.zzf(zzmVar.zzm);
        }
        zzfhu zzfhuVar2 = zzfhuVar;
        zzcheVar.zzx().zzc(1);
        zzgdy zzc = zzffu.zzc();
        ScheduledExecutorService zzB = zzcheVar.zzB();
        zzcse zza3 = zzg2.zza();
        zzcrp zzcrpVar = new zzcrp(zzc, zzB, zza3.zzh(zza3.zzi()));
        this.zzf = zzcrpVar;
        zzcrpVar.zze(new zzelu(this, zzelnVar, zzfhuVar2, zzb, zzg2));
        return true;
    }
}
