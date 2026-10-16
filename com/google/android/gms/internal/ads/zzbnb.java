package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final /* synthetic */ class zzbnb {
    public static void zza(zzbnc zzbncVar, String str, Map map) {
        try {
            zzbncVar.zze(str, com.google.android.gms.ads.internal.client.zzbb.zzb().zzo(map));
        } catch (JSONException unused) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not convert parameters to JSON.");
        }
    }

    public static void zzb(zzbnc zzbncVar, String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(jSONObject2);
        sb.append(");");
        String sb2 = sb.toString();
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Dispatching AFMA event: ".concat(sb2));
        zzbncVar.zza(sb.toString());
    }

    public static void zzc(zzbnc zzbncVar, String str, String str2) {
        zzbncVar.zza(str + "(" + str2 + ");");
    }

    public static void zzd(zzbnc zzbncVar, String str, JSONObject jSONObject) {
        zzbncVar.zzb(str, jSONObject.toString());
    }
}
