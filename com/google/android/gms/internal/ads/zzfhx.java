package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfhx implements Runnable {
    public static Boolean zzb;
    private final Context zze;
    private final VersionInfoParcel zzf;
    private int zzi;
    private final zzdpw zzj;
    private final List zzk;
    private final zzcgz zzl;
    private final zzbvy zzn;
    public static final Object zza = new Object();
    private static final Object zzc = new Object();
    private static final Object zzd = new Object();
    private final zzfic zzg = zzfig.zzb();
    private String zzh = "";
    private boolean zzm = false;

    public zzfhx(Context context, VersionInfoParcel versionInfoParcel, zzdpw zzdpwVar, zzeag zzeagVar, zzbvy zzbvyVar, zzcgz zzcgzVar) {
        this.zze = context;
        this.zzf = versionInfoParcel;
        this.zzj = zzdpwVar;
        this.zzn = zzbvyVar;
        this.zzl = zzcgzVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjk)).booleanValue()) {
            this.zzk = com.google.android.gms.ads.internal.util.zzs.zzd();
        } else {
            this.zzk = zzfyq.zzn();
        }
    }

    public static boolean zza() {
        boolean booleanValue;
        synchronized (zza) {
            if (zzb == null) {
                if (((Boolean) zzbex.zzb.zze()).booleanValue()) {
                    zzb = Boolean.valueOf(Math.random() < ((Double) zzbex.zza.zze()).doubleValue());
                } else {
                    zzb = false;
                }
            }
            booleanValue = zzb.booleanValue();
        }
        return booleanValue;
    }

    public static /* synthetic */ void zzb(zzfhx zzfhxVar, zzfhn zzfhnVar) {
        synchronized (zzd) {
            if (!zzfhxVar.zzm) {
                zzfhxVar.zzm = true;
                if (zza()) {
                    try {
                        com.google.android.gms.ads.internal.zzv.zzr();
                        zzfhxVar.zzh = com.google.android.gms.ads.internal.util.zzs.zzq(zzfhxVar.zze);
                    } catch (RemoteException | RuntimeException e) {
                        com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "CuiMonitor.gettingAppIdFromManifest");
                    }
                    zzfhxVar.zzi = GoogleApiAvailabilityLight.getInstance().getApkVersion(zzfhxVar.zze);
                    int intValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjf)).intValue();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmo)).booleanValue()) {
                        long j = intValue;
                        zzcaf.zzd.scheduleWithFixedDelay(zzfhxVar, j, j, TimeUnit.MILLISECONDS);
                    } else {
                        long j2 = intValue;
                        zzcaf.zzd.scheduleAtFixedRate(zzfhxVar, j2, j2, TimeUnit.MILLISECONDS);
                    }
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjl)).booleanValue()) {
                        zzfhxVar.zzl.zzc();
                    }
                }
            }
        }
        if (zza() && zzfhnVar != null) {
            synchronized (zzc) {
                zzfic zzficVar = zzfhxVar.zzg;
                if (zzficVar.zza() >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjg)).intValue()) {
                    return;
                }
                zzfhy zza2 = zzfib.zza();
                zza2.zzw(zzfhnVar.zzm());
                zza2.zzs(zzfhnVar.zzl());
                zza2.zzh(zzfhnVar.zzb());
                zza2.zzy(3);
                zza2.zzp(zzfhxVar.zzf.afmaVersion);
                zza2.zzb(zzfhxVar.zzh);
                zza2.zzl(Build.VERSION.RELEASE);
                zza2.zzt(Build.VERSION.SDK_INT);
                zza2.zzx(zzfhnVar.zzo());
                zza2.zzk(zzfhnVar.zza());
                zza2.zzf(zzfhxVar.zzi);
                zza2.zzv(zzfhnVar.zzn());
                zza2.zzc(zzfhnVar.zze());
                zza2.zzg(zzfhnVar.zzg());
                zza2.zzi(zzfhnVar.zzh());
                zza2.zzj(zzfhxVar.zzj.zzb(zzfhnVar.zzh()));
                zza2.zzm(zzfhnVar.zzi());
                zza2.zzo(zzfhnVar.zzd());
                zza2.zzd(zzfhnVar.zzf());
                zza2.zzu(zzfhnVar.zzk());
                zza2.zzq(zzfhnVar.zzj());
                zza2.zzr(zzfhnVar.zzc());
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjk)).booleanValue()) {
                    zza2.zza(zzfhxVar.zzk);
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjl)).booleanValue()) {
                    zzcgz zzcgzVar = zzfhxVar.zzl;
                    zzhcs zza3 = zzcgzVar.zza();
                    String zzb2 = zzcgzVar.zzb();
                    if (zza3 != null) {
                        zza2.zze(zza3);
                    }
                    if (zzb2 != null) {
                        zza2.zzn(zzb2);
                    }
                }
                zzfid zza4 = zzfie.zza();
                zza4.zza(zza2);
                zzficVar.zzb(zza4);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte[] zzaV;
        if (zza()) {
            Object obj = zzc;
            synchronized (obj) {
                if (this.zzg.zza() == 0) {
                    return;
                }
                try {
                    synchronized (obj) {
                        zzfic zzficVar = this.zzg;
                        zzaV = ((zzfig) zzficVar.zzbr()).zzaV();
                        zzficVar.zzc();
                    }
                    zzead zzeadVar = new zzead((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzje), 60000, new HashMap(), zzaV, CommonGatewayClient.HEADER_PROTOBUF, false);
                    zzead zzeadVar2 = zzeadVar;
                    new zzeaf(this.zze, this.zzf.afmaVersion, this.zzn, Binder.getCallingUid()).zza(zzeadVar);
                } catch (Exception e) {
                    if ((e instanceof zzdwm) && ((zzdwm) e).zza() == 3) {
                        return;
                    }
                    com.google.android.gms.ads.internal.zzv.zzp().zzv(e, "CuiMonitor.sendCuiPing");
                }
            }
        }
    }

    public final void zzc(final zzfhn zzfhnVar) {
        zzcaf.zza.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfhw
            @Override // java.lang.Runnable
            public final void run() {
                zzfhx.zzb(zzfhx.this, zzfhnVar);
            }
        });
    }
}
