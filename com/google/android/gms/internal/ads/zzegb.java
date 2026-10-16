package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.common.util.concurrent.ListenableFuture;
import com.ironsource.C3337ue;
import com.mbridge.msdk.foundation.entity.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzegb implements zzefv {
    private final zzdhb zza;
    private final zzgdy zzb;
    private final zzdln zzc;
    private final zzfdv zzd;
    private final zzdoe zze;
    private final zzdsd zzf;
    private final VersionInfoParcel zzg;
    private final Context zzh;
    private final zzbxw zzi;

    public zzegb(zzdhb zzdhbVar, zzgdy zzgdyVar, zzdln zzdlnVar, zzfdv zzfdvVar, zzdoe zzdoeVar, zzdsd zzdsdVar, VersionInfoParcel versionInfoParcel, Context context, zzbxw zzbxwVar) {
        this.zzg = versionInfoParcel;
        this.zzh = context;
        this.zzi = zzbxwVar;
        this.zza = zzdhbVar;
        this.zzb = zzgdyVar;
        this.zzc = zzdlnVar;
        this.zzd = zzfdvVar;
        this.zze = zzdoeVar;
        this.zzf = zzdsdVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ zzdio zzc(zzegb zzegbVar, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzfcn zzfcnVar, zzfca zzfcaVar, JSONObject jSONObject, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar) {
        zzdit zzditVar = (zzdit) listenableFuture.get();
        zzdny zzdnyVar = (zzdny) listenableFuture2.get();
        zzbcv zzbcvVar = zzbde.zzct;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
            zzegbVar.zzf.zza().putLong(zzdrr.RENDERING_WEBVIEW_CREATION_END.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        zzdiu zzd = zzegbVar.zza.zzd(new zzcrq(zzfcnVar, zzfcaVar, null), new zzdjf(zzditVar), new zzdhp(jSONObject, zzdnyVar, zzbVar, zzbyaVar));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
            long currentTimeMillis = com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis();
            zzdsd zzdsdVar = zzegbVar.zzf;
            zzdsdVar.zza().putLong(zzdrr.RENDERING_AD_COMPONENT_CREATION_END.zza(), currentTimeMillis);
            zzdsdVar.zza().putLong(zzdrr.RENDERING_CONFIGURE_WEBVIEW_START.zza(), currentTimeMillis);
        }
        zzd.zzh().zzb();
        zzd.zzi().zza(zzdnyVar);
        zzd.zzg().zzc(zzditVar.zzs());
        zzd.zzl().zza(zzegbVar.zze, zzditVar.zzq());
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
            zzegbVar.zzf.zza().putLong(zzdrr.RENDERING_CONFIGURE_WEBVIEW_END.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        return zzd.zza();
    }

    public static /* synthetic */ ListenableFuture zzd(zzegb zzegbVar, zzfcn zzfcnVar, zzfca zzfcaVar, JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return zzgdn.zzg(new zzdwm(3));
        }
        int i = zzfcnVar.zza.zza.zzk;
        if (i <= 1) {
            return zzgdn.zzm(zzegbVar.zzg(zzfcnVar, zzfcaVar, jSONArray.getJSONObject(0)), new zzfve() { // from class: com.google.android.gms.internal.ads.zzega
                @Override // com.google.android.gms.internal.ads.zzfve
                public final Object apply(Object obj) {
                    return Collections.singletonList(zzgdn.zzh((zzdio) obj));
                }
            }, zzegbVar.zzb);
        }
        int length = jSONArray.length();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcu)).booleanValue()) {
            zzegbVar.zzf.zzd("nsl", String.valueOf(length));
        }
        zzegbVar.zzd.zzc(Math.min(length, i));
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < length) {
                arrayList.add(zzegbVar.zzg(zzfcnVar, zzfcaVar, jSONArray.getJSONObject(i2)));
            } else {
                arrayList.add(zzgdn.zzg(new zzdwm(3)));
            }
        }
        return zzgdn.zzh(arrayList);
    }

    public static /* synthetic */ ListenableFuture zze(final zzegb zzegbVar, zzfca zzfcaVar, final zzdny zzdnyVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcs)).booleanValue()) {
            zzegbVar.zzf.zza().putLong(zzdrr.RENDERING_NATIVE_ADS_PREPROCESS_START.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjb)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(C3337ue.n, zzfcaVar.zzs.zzc);
        jSONObject2.put("sdk_params", jSONObject);
        return zzgdn.zzn(zzdnyVar.zzg("google.afma.nativeAds.preProcessJson", jSONObject2), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzefx
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzegb.zzf(zzegb.this, zzdnyVar, (JSONObject) obj);
            }
        }, zzegbVar.zzb);
    }

    public static /* synthetic */ ListenableFuture zzf(zzegb zzegbVar, zzdny zzdnyVar, JSONObject jSONObject) {
        zzegbVar.zzd.zzb(zzgdn.zzh(zzdnyVar));
        if (!jSONObject.optBoolean("success")) {
            throw new zzbol("process json failed");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcs)).booleanValue()) {
            zzegbVar.zzf.zza().putLong(zzdrr.RENDERING_NATIVE_ADS_PREPROCESS_END.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        return zzgdn.zzh(jSONObject.getJSONObject("json").getJSONArray(b.JSON_KEY_ADS));
    }

    private final ListenableFuture zzg(final zzfcn zzfcnVar, final zzfca zzfcaVar, final JSONObject jSONObject) {
        com.google.android.gms.ads.internal.zzb zzbVar;
        zzbya zzbyaVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzct)).booleanValue()) {
            this.zzf.zza().putLong(zzdrr.RENDERING_WEBVIEW_CREATION_START.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        final ListenableFuture zza = this.zzd.zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznP)).booleanValue()) {
            Context context = this.zzh;
            zzbya zza2 = zzcvt.zza(context, this.zzg, zzfcaVar, this.zzi);
            zzbVar = new com.google.android.gms.ads.internal.zzb(context, zza2, null);
            zzbyaVar = zza2;
        } else {
            zzbVar = new com.google.android.gms.ads.internal.zzb(this.zzh, null, null);
            zzbyaVar = null;
        }
        final com.google.android.gms.ads.internal.zzb zzbVar2 = zzbVar;
        final zzbya zzbyaVar2 = zzbyaVar;
        final ListenableFuture zzd = this.zzc.zzd(zzfcnVar, zzfcaVar, jSONObject, zzbVar2, zzbyaVar2);
        return zzgdn.zzc(zza, zzd).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzefw
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzegb.zzc(zzegb.this, zzd, zza, zzfcnVar, zzfcaVar, jSONObject, zzbVar2, zzbyaVar2);
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final ListenableFuture zza(final zzfcn zzfcnVar, final zzfca zzfcaVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcs)).booleanValue()) {
            this.zzf.zza().putLong(zzdrr.RENDERING_NATIVE_ADS_NATIVE_JS_WEBVIEW_START.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        ListenableFuture zza = this.zzd.zza();
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzefy
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzegb.zze(zzegb.this, zzfcaVar, (zzdny) obj);
            }
        };
        zzgdy zzgdyVar = this.zzb;
        return zzgdn.zzn(zzgdn.zzn(zza, zzgcuVar, zzgdyVar), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzefz
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzegb.zzd(zzegb.this, zzfcnVar, zzfcaVar, (JSONArray) obj);
            }
        }, zzgdyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final boolean zzb(zzfcn zzfcnVar, zzfca zzfcaVar) {
        zzfcf zzfcfVar = zzfcaVar.zzs;
        return (zzfcfVar == null || zzfcfVar.zzc == null) ? false : true;
    }
}
