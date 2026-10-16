package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcke extends com.google.android.gms.ads.internal.client.zzda {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final zzdpz zzc;
    private final zzedo zzd;
    private final zzeju zze;
    private final zzdun zzf;
    private final zzbyo zzg;
    private final zzdqe zzh;
    private final zzdvi zzi;
    private final zzbfx zzj;
    private final zzfhx zzk;
    private final zzfds zzl;
    private final zzctl zzm;
    private final zzdsj zzn;
    private boolean zzo = false;
    private final Long zzp = Long.valueOf(com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime());

    zzcke(Context context, VersionInfoParcel versionInfoParcel, zzdpz zzdpzVar, zzedo zzedoVar, zzeju zzejuVar, zzdun zzdunVar, zzbyo zzbyoVar, zzdqe zzdqeVar, zzdvi zzdviVar, zzbfx zzbfxVar, zzfhx zzfhxVar, zzfds zzfdsVar, zzctl zzctlVar, zzdsj zzdsjVar) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzdpzVar;
        this.zzd = zzedoVar;
        this.zze = zzejuVar;
        this.zzf = zzdunVar;
        this.zzg = zzbyoVar;
        this.zzh = zzdqeVar;
        this.zzi = zzdviVar;
        this.zzj = zzbfxVar;
        this.zzk = zzfhxVar;
        this.zzl = zzfdsVar;
        this.zzm = zzctlVar;
        this.zzn = zzdsjVar;
    }

    public static /* synthetic */ void zzc(zzcke zzckeVar, Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map zze = com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg().zze();
        if (zze.isEmpty()) {
            return;
        }
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Could not initialize rewarded ads.", th);
                return;
            }
        }
        if (zzckeVar.zzc.zzd()) {
            HashMap hashMap = new HashMap();
            Iterator it = zze.values().iterator();
            while (it.hasNext()) {
                for (zzbpj zzbpjVar : ((zzbpk) it.next()).zza) {
                    String str = zzbpjVar.zzb;
                    for (String str2 : zzbpjVar.zza) {
                        if (!hashMap.containsKey(str2)) {
                            hashMap.put(str2, new ArrayList());
                        }
                        if (str != null) {
                            ((List) hashMap.get(str2)).add(str);
                        }
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : hashMap.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    zzedp zza = zzckeVar.zzd.zza(str3, jSONObject);
                    if (zza != null) {
                        zzfdu zzfduVar = (zzfdu) zza.zzb;
                        if (!zzfduVar.zzC() && zzfduVar.zzB()) {
                            zzfduVar.zzj(zzckeVar.zza, (zzefe) zza.zzc, (List) entry.getValue());
                            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zze("Initialized rewarded video mediation adapter " + str3);
                        }
                    }
                } catch (zzfdd e) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to initialize rewarded video mediation adapter \"" + str3 + "\"", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final synchronized float zze() {
        return com.google.android.gms.ads.internal.zzv.zzt().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final String zzf() {
        return this.zzb.afmaVersion;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final List zzg() throws RemoteException {
        return this.zzf.zzg();
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzh(String str) {
        this.zze.zzg(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzi() {
        this.zzf.zzq();
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzj(boolean z) throws RemoteException {
        try {
            Context context = this.zza;
            zzfsb.zza(context).zzc(z);
            if (z) {
                return;
            }
            try {
                if (context.getSharedPreferences("query_info_shared_prefs", 0).edit().clear().commit()) {
                } else {
                    throw new IOException("Failed to remove query_info_shared_prefs");
                }
            } catch (IOException e) {
                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "clearStorageOnGpidPubDisable_scar");
            }
        } catch (IOException e2) {
            throw new RemoteException(e2.getMessage());
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final synchronized void zzk() {
        if (this.zzo) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Mobile ads is initialized already.");
            return;
        }
        Context context = this.zza;
        zzbde.zza(context);
        com.google.android.gms.ads.internal.zzv.zzp().zzu(context, this.zzb);
        this.zzm.zzd();
        com.google.android.gms.ads.internal.zzv.zzc().zzi(context);
        this.zzo = true;
        this.zzf.zzr();
        this.zze.zzf();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeq)).booleanValue()) {
            this.zzh.zzf();
        }
        this.zzi.zzg();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjE)).booleanValue()) {
            zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjz
                @Override // java.lang.Runnable
                public final void run() {
                    zzcke.this.zzx();
                }
            });
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzls)).booleanValue()) {
            zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckc
                @Override // java.lang.Runnable
                public final void run() {
                    zzcke.this.zzj.zza(new zzbus());
                }
            });
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdl)).booleanValue()) {
            zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcka
                @Override // java.lang.Runnable
                public final void run() {
                    zzfea.zzb(zzcke.this.zza, true);
                }
            });
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeT)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeU)).booleanValue()) {
                zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckb
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.google.android.gms.ads.internal.zzv.zzf().zzd(r0.zza, zzcke.this.zzn);
                    }
                });
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003e  */
    @Override // com.google.android.gms.ads.internal.client.zzdb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzl(String str, IObjectWrapper iObjectWrapper) {
        String zzq;
        String str2;
        Runnable runnable;
        Context context = this.zza;
        zzbde.zza(context);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzev)).booleanValue()) {
            try {
                com.google.android.gms.ads.internal.zzv.zzr();
                zzq = com.google.android.gms.ads.internal.util.zzs.zzq(context);
            } catch (RemoteException | RuntimeException e) {
                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "NonagonMobileAdsSettingManager_AppId");
            }
            boolean z = true;
            str2 = true != TextUtils.isEmpty(zzq) ? str : zzq;
            if (TextUtils.isEmpty(str2)) {
                boolean booleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeo)).booleanValue();
                zzbcv zzbcvVar = zzbde.zzbe;
                boolean booleanValue2 = booleanValue | ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
                    final Runnable runnable2 = (Runnable) ObjectWrapper.unwrap(iObjectWrapper);
                    runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzckd
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzgdy zzgdyVar = zzcaf.zzf;
                            final zzcke zzckeVar = zzcke.this;
                            final Runnable runnable3 = runnable2;
                            zzgdyVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjy
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzcke.zzc(zzcke.this, runnable3);
                                }
                            });
                        }
                    };
                } else {
                    runnable = null;
                    z = booleanValue2;
                }
                Runnable runnable3 = runnable;
                if (z) {
                    com.google.android.gms.ads.internal.zzv.zza().zzc(this.zza, this.zzb, str2, runnable3, this.zzk, this.zzn, this.zzp, this.zzi.zzq());
                    return;
                }
                return;
            }
            return;
        }
        zzq = "";
        boolean z2 = true;
        if (true != TextUtils.isEmpty(zzq)) {
        }
        if (TextUtils.isEmpty(str2)) {
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzm(com.google.android.gms.ads.internal.client.zzdn zzdnVar) throws RemoteException {
        this.zzi.zzh(zzdnVar, zzdvh.API);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzn(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Context is null. Failed to open debug menu.");
        } else {
            com.google.android.gms.ads.internal.util.zzau zzauVar = new com.google.android.gms.ads.internal.util.zzau(context);
            zzauVar.zzn(str);
            zzauVar.zzo(this.zzb.afmaVersion);
            zzauVar.zzr();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzo(zzbpq zzbpqVar) throws RemoteException {
        this.zzl.zzf(zzbpqVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final synchronized void zzp(boolean z) {
        com.google.android.gms.ads.internal.zzv.zzt().zzc(z);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final synchronized void zzq(float f) {
        com.google.android.gms.ads.internal.zzv.zzt().zzd(f);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final synchronized void zzr(String str) {
        Context context = this.zza;
        zzbde.zza(context);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeo)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zza().zzc(context, this.zzb, str, null, this.zzk, null, null, this.zzi.zzq());
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzs(zzbmk zzbmkVar) throws RemoteException {
        this.zzf.zzs(zzbmkVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzt(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjQ)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zzp().zzz(str);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzu(com.google.android.gms.ads.internal.client.zzfx zzfxVar) throws RemoteException {
        this.zzg.zzn(this.zza, zzfxVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final synchronized boolean zzv() {
        return com.google.android.gms.ads.internal.zzv.zzt().zze();
    }

    final void zzx() {
        if (com.google.android.gms.ads.internal.zzv.zzp().zzi().zzM()) {
            String zzi = com.google.android.gms.ads.internal.zzv.zzp().zzi().zzi();
            if (com.google.android.gms.ads.internal.zzv.zzu().zzj(this.zza, zzi, this.zzb.afmaVersion)) {
                return;
            }
            com.google.android.gms.ads.internal.zzv.zzp().zzi().zzx(false);
            com.google.android.gms.ads.internal.zzv.zzp().zzi().zzw("");
        }
    }
}
