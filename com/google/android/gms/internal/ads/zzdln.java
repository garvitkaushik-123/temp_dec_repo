package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import com.ironsource.C3040d4;
import com.ironsource.C3057e4;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdln {
    private final zzgdy zza;
    private final zzdmc zzb;
    private final zzdmh zzc;
    private final zzdsd zzd;

    zzdln(zzgdy zzgdyVar, zzdmc zzdmcVar, zzdmh zzdmhVar, zzdsd zzdsdVar) {
        this.zza = zzgdyVar;
        this.zzb = zzdmcVar;
        this.zzc = zzdmhVar;
        this.zzd = zzdsdVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ zzdit zza(zzdln zzdlnVar, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ListenableFuture listenableFuture3, ListenableFuture listenableFuture4, ListenableFuture listenableFuture5, JSONObject jSONObject, ListenableFuture listenableFuture6, ListenableFuture listenableFuture7, ListenableFuture listenableFuture8, ListenableFuture listenableFuture9, ListenableFuture listenableFuture10) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcs)).booleanValue()) {
            zzdlnVar.zzd.zza().putLong(zzdrr.RENDERING_NATIVE_ASSETS_LOADING_END.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        zzdit zzditVar = (zzdit) listenableFuture.get();
        zzditVar.zzP((List) listenableFuture2.get());
        zzditVar.zzM((zzbgp) listenableFuture3.get());
        zzditVar.zzQ((zzbgp) listenableFuture4.get());
        zzditVar.zzJ((zzbgi) listenableFuture5.get());
        zzditVar.zzS(zzdmc.zzl(jSONObject));
        zzditVar.zzL(zzdmc.zzk(jSONObject));
        zzcfg zzcfgVar = (zzcfg) listenableFuture6.get();
        if (zzcfgVar != null) {
            zzditVar.zzad(zzcfgVar);
            zzditVar.zzac(zzcfgVar.zzF());
            zzditVar.zzab(zzcfgVar.zzq());
        }
        zzditVar.zzd().putAll((Bundle) listenableFuture7.get());
        zzcfg zzcfgVar2 = (zzcfg) listenableFuture8.get();
        if (zzcfgVar2 != null) {
            zzditVar.zzO(zzcfgVar2);
            zzditVar.zzae(zzcfgVar2.zzF());
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfG)).booleanValue() || zzf(jSONObject)) {
            zzcfg zzcfgVar3 = (zzcfg) listenableFuture9.get();
            if (zzcfgVar3 != null) {
                zzditVar.zzT(zzcfgVar3);
            }
        } else {
            zzditVar.zzU(listenableFuture9);
            zzditVar.zzX(new zzcak());
        }
        for (zzdmg zzdmgVar : (List) listenableFuture10.get()) {
            if (zzdmgVar.zza != 1) {
                zzditVar.zzN(zzdmgVar.zzb, zzdmgVar.zzd);
            } else {
                zzditVar.zzZ(zzdmgVar.zzb, zzdmgVar.zzc);
            }
        }
        return zzditVar;
    }

    public static /* synthetic */ zzdit zzb(zzdln zzdlnVar, zzfcn zzfcnVar, zzfca zzfcaVar, JSONObject jSONObject) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcx)).booleanValue()) {
            zzdlnVar.zzd.zza().putLong(zzdrr.NATIVE_ASSETS_LOADING_BASIC_START.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        zzdit zzditVar = new zzdit();
        zzditVar.zzaa(jSONObject.optInt("template_id", -1));
        zzditVar.zzK(jSONObject.optString("custom_template_id"));
        JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
        zzditVar.zzV(optJSONObject != null ? optJSONObject.optString("omid_partner_name") : null);
        zzfcw zzfcwVar = zzfcnVar.zza.zza;
        if (!zzfcwVar.zzg.contains(Integer.toString(zzditVar.zzc()))) {
            throw new zzehf(1, "Invalid template ID: " + zzditVar.zzc());
        }
        if (zzditVar.zzc() == 3) {
            if (zzditVar.zzA() == null) {
                throw new zzehf(1, "No custom template id for custom template ad response.");
            }
            if (!zzfcwVar.zzh.contains(zzditVar.zzA())) {
                throw new zzehf(1, "Unexpected custom template id in the response.");
            }
        }
        zzditVar.zzY(jSONObject.optDouble("rating", -1.0d));
        String optString = jSONObject.optString("headline", null);
        if (zzfcaVar.zzM) {
            com.google.android.gms.ads.internal.zzv.zzr();
            optString = com.google.android.gms.ads.internal.util.zzs.zzz() + " : " + optString;
        }
        zzditVar.zzZ("headline", optString);
        zzditVar.zzZ("body", jSONObject.optString("body", null));
        zzditVar.zzZ("call_to_action", jSONObject.optString("call_to_action", null));
        zzditVar.zzZ(C3040d4.h.U, jSONObject.optString(C3040d4.h.U, null));
        zzditVar.zzZ("price", jSONObject.optString("price", null));
        zzditVar.zzZ(C3040d4.h.F0, jSONObject.optString(C3040d4.h.F0, null));
        return zzditVar;
    }

    private final ListenableFuture zze(ListenableFuture listenableFuture, zzdrr zzdrrVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcx)).booleanValue()) {
            zzgdn.zzr(listenableFuture, new zzdlm(this, zzdrrVar), this.zza);
        }
        return listenableFuture;
    }

    private static final boolean zzf(JSONObject jSONObject) {
        return jSONObject.optInt("template_id") == 3;
    }

    public final ListenableFuture zzd(final zzfcn zzfcnVar, final zzfca zzfcaVar, final JSONObject jSONObject, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar) {
        ListenableFuture zzh;
        JSONArray optJSONArray;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcs)).booleanValue()) {
            this.zzd.zza().putLong(zzdrr.RENDERING_NATIVE_ASSETS_LOADING_START.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        final ListenableFuture zzb = this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdlk
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzdln.zzb(zzdln.this, zzfcnVar, zzfcaVar, jSONObject);
            }
        });
        zze(zzb, zzdrr.NATIVE_ASSETS_LOADING_BASIC_END);
        zzdmc zzdmcVar = this.zzb;
        final ListenableFuture zzf = zzdmcVar.zzf(jSONObject, "images", zzdrr.NATIVE_ASSETS_LOADING_IMAGE_START);
        zze(zzf, zzdrr.NATIVE_ASSETS_LOADING_IMAGE_END);
        zzfcd zzfcdVar = zzfcnVar.zzb.zzb;
        final ListenableFuture zzg = zzdmcVar.zzg(jSONObject, "images", zzfcaVar, zzfcdVar, zzbVar, zzbyaVar);
        zze(zzg, zzdrr.NATIVE_ASSETS_LOADING_IMAGE_COMPOSITION_END);
        final ListenableFuture zze = zzdmcVar.zze(jSONObject, "secondary_image", zzdrr.NATIVE_ASSETS_LOADING_LOGO_START);
        zze(zze, zzdrr.NATIVE_ASSETS_LOADING_LOGO_END);
        final ListenableFuture zze2 = zzdmcVar.zze(jSONObject, "app_icon", zzdrr.NATIVE_ASSETS_LOADING_ICON_START);
        zze(zze2, zzdrr.NATIVE_ASSETS_LOADING_ICON_END);
        final ListenableFuture zzd = zzdmcVar.zzd(jSONObject, C3057e4.c, zzdrr.NATIVE_ASSETS_LOADING_ATTRIBUTION_START);
        zze(zzd, zzdrr.NATIVE_ASSETS_LOADING_ATTRIBUTION_END);
        final ListenableFuture zzj = zzdmcVar.zzj(jSONObject, zzfcaVar, zzfcdVar, zzbVar, zzbyaVar);
        zze(zzj, zzdrr.NATIVE_ASSETS_LOADING_VIDEO_END);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznr)).booleanValue() && jSONObject.has("video")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("video");
            if (optJSONObject.has("flags") && (optJSONArray = optJSONObject.optJSONArray("flags")) != null) {
                int i = 0;
                while (true) {
                    if (i >= optJSONArray.length()) {
                        break;
                    }
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 == null || !optJSONObject2.optString(C3040d4.h.W).equals("afma_video_player_type")) {
                        i++;
                    } else {
                        try {
                            if (Integer.parseInt(optJSONObject2.optString("value")) == 3) {
                                zzh = this.zzb.zzh(zzj);
                                zze(zzh, zzdrr.NATIVE_ASSETS_LOADING_MEDIA_END);
                            }
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
            }
        }
        zzh = zzgdn.zzh(new Bundle());
        final ListenableFuture zza = this.zzc.zza(jSONObject, "custom_assets");
        zze(zza, zzdrr.NATIVE_ASSETS_LOADING_CUSTOM_END);
        final ListenableFuture zzi = this.zzb.zzi(jSONObject, zzbVar, zzbyaVar);
        zze(zzi, zzdrr.NATIVE_ASSETS_LOADING_OMID_END);
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzb);
        arrayList.add(zzf);
        arrayList.add(zzg);
        arrayList.add(zze);
        arrayList.add(zze2);
        arrayList.add(zzd);
        arrayList.add(zzj);
        arrayList.add(zzh);
        arrayList.add(zza);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfG)).booleanValue() || zzf(jSONObject)) {
            arrayList.add(zzi);
        }
        final ListenableFuture listenableFuture = zzh;
        return zzgdn.zza(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdll
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzdln.zza(zzdln.this, zzb, zzf, zze2, zze, zzd, jSONObject, zzj, listenableFuture, zzg, zzi, zza);
            }
        }, this.zza);
    }
}
