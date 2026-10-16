package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdny {
    private final zzdnl zza;
    private final com.google.android.gms.ads.internal.zza zzb;
    private final Context zzc;
    private final zzdsj zzd;
    private final Executor zze;
    private final zzavu zzf;
    private final VersionInfoParcel zzg;
    private final zzbkv zzh;
    private final zzeca zzi;
    private final zzfjy zzj;
    private final zzecl zzk;
    private final zzfda zzl;
    private ListenableFuture zzm;

    zzdny(zzdnv zzdnvVar) {
        Context context;
        Executor executor;
        zzavu zzavuVar;
        VersionInfoParcel versionInfoParcel;
        com.google.android.gms.ads.internal.zza zzaVar;
        zzeca zzecaVar;
        zzfjy zzfjyVar;
        zzdsj zzdsjVar;
        zzecl zzeclVar;
        zzfda zzfdaVar;
        context = zzdnvVar.zzb;
        this.zzc = context;
        executor = zzdnvVar.zze;
        this.zze = executor;
        zzavuVar = zzdnvVar.zzf;
        this.zzf = zzavuVar;
        versionInfoParcel = zzdnvVar.zzg;
        this.zzg = versionInfoParcel;
        zzaVar = zzdnvVar.zza;
        this.zzb = zzaVar;
        this.zza = new zzdnl();
        this.zzh = new zzbkv();
        zzecaVar = zzdnvVar.zzd;
        this.zzi = zzecaVar;
        zzfjyVar = zzdnvVar.zzh;
        this.zzj = zzfjyVar;
        zzdsjVar = zzdnvVar.zzc;
        this.zzd = zzdsjVar;
        zzeclVar = zzdnvVar.zzi;
        this.zzk = zzeclVar;
        zzfdaVar = zzdnvVar.zzj;
        this.zzl = zzfdaVar;
    }

    public static /* synthetic */ zzcfg zza(zzdny zzdnyVar, zzcfg zzcfgVar) {
        zzcfgVar.zzag("/result", zzdnyVar.zzh);
        zzcgy zzN = zzcfgVar.zzN();
        com.google.android.gms.ads.internal.zzb zzbVar = new com.google.android.gms.ads.internal.zzb(zzdnyVar.zzc, null, null);
        zzeca zzecaVar = zzdnyVar.zzi;
        zzfjy zzfjyVar = zzdnyVar.zzj;
        zzdsj zzdsjVar = zzdnyVar.zzd;
        zzdnl zzdnlVar = zzdnyVar.zza;
        zzN.zzX(null, zzdnlVar, zzdnlVar, zzdnlVar, zzdnlVar, false, null, zzbVar, null, null, zzecaVar, zzfjyVar, zzdsjVar, null, null, null, null, null, null);
        return zzcfgVar;
    }

    public final synchronized ListenableFuture zzg(final String str, final JSONObject jSONObject) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return zzgdn.zzh(null);
        }
        return zzgdn.zzn(listenableFuture, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdnm
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                ListenableFuture zzb;
                zzcfg zzcfgVar = (zzcfg) obj;
                zzb = zzdny.this.zzh.zzb(zzcfgVar, str, jSONObject);
                return zzb;
            }
        }, this.zze);
    }

    public final synchronized void zzh(zzfca zzfcaVar, zzfcd zzfcdVar, zzcmq zzcmqVar) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzgdn.zzr(listenableFuture, new zzdns(this, zzfcaVar, zzfcdVar, zzcmqVar), this.zze);
    }

    public final synchronized void zzi() {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzgdn.zzr(listenableFuture, new zzdno(this), this.zze);
        this.zzm = null;
    }

    public final synchronized void zzj(String str, Map map) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzgdn.zzr(listenableFuture, new zzdnr(this, "sendMessageToNativeJs", map), this.zze);
    }

    public final synchronized void zzk() {
        final String str = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzea);
        final Context context = this.zzc;
        final zzavu zzavuVar = this.zzf;
        final VersionInfoParcel versionInfoParcel = this.zzg;
        final com.google.android.gms.ads.internal.zza zzaVar = this.zzb;
        final zzecl zzeclVar = this.zzk;
        final zzfda zzfdaVar = this.zzl;
        final zzdsj zzdsjVar = this.zzd;
        ListenableFuture zzm = zzgdn.zzm(zzgdn.zzk(new zzgct() { // from class: com.google.android.gms.internal.ads.zzcfp
            @Override // com.google.android.gms.internal.ads.zzgct
            public final ListenableFuture zza() {
                com.google.android.gms.ads.internal.zzv.zzB();
                Context context2 = context;
                zzecl zzeclVar2 = zzeclVar;
                zzchd zza = zzchd.zza();
                zzavu zzavuVar2 = zzavuVar;
                zzfda zzfdaVar2 = zzfdaVar;
                com.google.android.gms.ads.internal.zza zzaVar2 = zzaVar;
                zzcfg zza2 = zzcft.zza(context2, zza, "", false, false, zzavuVar2, null, versionInfoParcel, null, null, zzaVar2, zzbcc.zza(), null, null, zzeclVar2, zzfdaVar2, zzdsjVar);
                final zzcaj zza3 = zzcaj.zza(zza2);
                zza2.zzN().zzC(new zzcgw() { // from class: com.google.android.gms.internal.ads.zzcfq
                    @Override // com.google.android.gms.internal.ads.zzcgw
                    public final void zza(boolean z, int i, String str2, String str3) {
                        zzcaj.this.zzb();
                    }
                });
                zza2.loadUrl(str);
                return zza3;
            }
        }, zzcaf.zzf), new zzfve() { // from class: com.google.android.gms.internal.ads.zzdnn
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                zzcfg zzcfgVar = (zzcfg) obj;
                zzdny.zza(zzdny.this, zzcfgVar);
                return zzcfgVar;
            }
        }, this.zze);
        this.zzm = zzm;
        zzcai.zza(zzm, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzl(String str, zzbkf zzbkfVar) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzgdn.zzr(listenableFuture, new zzdnp(this, str, zzbkfVar), this.zze);
    }

    public final void zzm(WeakReference weakReference, String str, zzbkf zzbkfVar) {
        zzl(str, new zzdnw(this, weakReference, str, zzbkfVar, null));
    }

    public final synchronized void zzn(String str, zzbkf zzbkfVar) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzgdn.zzr(listenableFuture, new zzdnq(this, str, zzbkfVar), this.zze);
    }
}
