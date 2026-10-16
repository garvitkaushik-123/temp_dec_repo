package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbvm extends zzbvk {
    private final Object zza = new Object();
    private final Context zzb;
    private SharedPreferences zzc;
    private final zzbom zzd;
    private final VersionInfoParcel zze;

    public zzbvm(Context context, zzbom zzbomVar, VersionInfoParcel versionInfoParcel) {
        this.zzb = context.getApplicationContext();
        this.zze = versionInfoParcel;
        this.zzd = zzbomVar;
    }

    public static /* synthetic */ Void zzb(zzbvm zzbvmVar, JSONObject jSONObject) {
        zzbcv zzbcvVar = zzbde.zza;
        com.google.android.gms.ads.internal.client.zzbd.zzb();
        SharedPreferences zza = zzbcx.zza(zzbvmVar.zzb);
        if (zza == null) {
            return null;
        }
        SharedPreferences.Editor edit = zza.edit();
        Objects.requireNonNull(com.google.android.gms.ads.internal.client.zzbd.zza());
        int i = zzbeu.zza;
        com.google.android.gms.ads.internal.client.zzbd.zza().zzf(edit, 1, jSONObject);
        com.google.android.gms.ads.internal.client.zzbd.zzb();
        edit.commit();
        SharedPreferences sharedPreferences = zzbvmVar.zzc;
        if (sharedPreferences == null) {
            return null;
        }
        sharedPreferences.edit().putLong("js_last_update", com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis()).apply();
        return null;
    }

    public static JSONObject zzc(Context context, VersionInfoParcel versionInfoParcel) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (((Boolean) zzbfe.zzb.zze()).booleanValue()) {
                jSONObject.put("package_name", context.getPackageName());
            }
            jSONObject.put("js", versionInfoParcel.afmaVersion);
            jSONObject.put("mf", zzbfe.zzc.zze());
            jSONObject.put("cl", "785558560");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzbvk
    public final ListenableFuture zza() {
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = this.zzb.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        SharedPreferences sharedPreferences = this.zzc;
        if (com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() - (sharedPreferences != null ? sharedPreferences.getLong("js_last_update", 0L) : 0L) < ((Long) zzbfe.zzd.zze()).longValue()) {
            return zzgdn.zzh(null);
        }
        return zzgdn.zzm(this.zzd.zzb(zzc(this.zzb, this.zze)), new zzfve() { // from class: com.google.android.gms.internal.ads.zzbvl
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                zzbvm.zzb(zzbvm.this, (JSONObject) obj);
                return null;
            }
        }, zzcaf.zzg);
    }
}
