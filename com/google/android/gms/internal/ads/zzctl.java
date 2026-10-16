package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzctl implements zzcza, zzdep {
    private zzbvk zza;
    private final Context zzc;
    private final zzfhx zzd;
    private final VersionInfoParcel zze;
    private final Executor zzf;
    private boolean zzg = false;
    private boolean zzh = false;
    private final AtomicBoolean zzb = new AtomicBoolean();

    zzctl(Context context, zzfhx zzfhxVar, VersionInfoParcel versionInfoParcel, Executor executor) {
        this.zzc = context;
        this.zzd = zzfhxVar;
        this.zze = versionInfoParcel;
        this.zzf = executor;
    }

    public static /* synthetic */ void zzc(zzctl zzctlVar) {
        zzbco.zze(zzctlVar.zzc);
        zzctlVar.zzh = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0066, code lost:
    
        if (android.text.TextUtils.equals(r0, androidx.core.app.NotificationCompat.CATEGORY_SERVICE) != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzd() {
        zzbvk zzbvkVar;
        int i;
        int i2;
        zzbow zza;
        if (!this.zzb.getAndSet(true)) {
            if (!((Boolean) zzbfe.zzj.zze()).booleanValue()) {
                i = 3;
                if (!((Boolean) zzbfe.zzk.zze()).booleanValue()) {
                    if (((Boolean) zzbfe.zzi.zze()).booleanValue()) {
                        try {
                            String optString = new JSONObject(com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg().zzc()).optString("local_flag_write");
                            if (TextUtils.equals(optString, "client")) {
                            }
                        } catch (JSONException unused) {
                        }
                    }
                    i = 1;
                }
                i2 = i - 1;
                if (i2 != 1) {
                    zza = com.google.android.gms.ads.internal.zzv.zzg().zza(this.zzc, VersionInfoParcel.forPackage(), this.zzd);
                } else if (i2 == 2) {
                    zza = com.google.android.gms.ads.internal.zzv.zzg().zzb(this.zzc, VersionInfoParcel.forPackage(), this.zzd);
                }
                zzboq zzboqVar = zzbot.zza;
                this.zza = new zzbvm(this.zzc, zza.zza("google.afma.sdkConstants.getSdkConstants", zzboqVar, zzboqVar), this.zze);
                this.zzg = true;
            }
            i = 2;
            i2 = i - 1;
            if (i2 != 1) {
            }
            zzboq zzboqVar2 = zzbot.zza;
            this.zza = new zzbvm(this.zzc, zza.zza("google.afma.sdkConstants.getSdkConstants", zzboqVar2, zzboqVar2), this.zze);
            this.zzg = true;
        }
        if (this.zzg && (zzbvkVar = this.zza) != null) {
            ListenableFuture zza2 = zzbvkVar.zza();
            if (!this.zzh && ((Boolean) zzbew.zzi.zze()).booleanValue()) {
                zza2.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzctk
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzctl.zzc(zzctl.this);
                    }
                }, this.zzf);
            }
            zzcai.zza(zza2, "persistFlagsClient");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdn(zzbvq zzbvqVar) {
        zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdo(zzfcn zzfcnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdep
    public final void zze(com.google.android.gms.ads.nonagon.signalgeneration.zzbk zzbkVar) {
        zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzdep
    public final void zzf(String str) {
        zzd();
    }
}
