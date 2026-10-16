package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeai implements zzfge {
    private static final Pattern zza = Pattern.compile("([^;]+=[^;]+)(;\\s|$)", 2);
    private final String zzb;
    private final zzfhj zzc;
    private final zzfhu zzd;

    public zzeai(String str, zzfhu zzfhuVar, zzfhj zzfhjVar) {
        this.zzb = str;
        this.zzd = zzfhuVar;
        this.zzc = zzfhjVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a7, code lost:
    
        r0 = r11.zza;
     */
    @Override // com.google.android.gms.internal.ads.zzfge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ Object zza(Object obj) throws Exception {
        JSONObject jSONObject;
        zzbvs zzbvsVar;
        zzdwm zzdwmVar;
        zzbvs zzbvsVar2;
        zzbvs zzbvsVar3;
        zzbvs zzbvsVar4;
        zzbvs zzbvsVar5;
        zzbvs zzbvsVar6;
        zzbvs zzbvsVar7;
        zzbvs zzbvsVar8;
        JSONObject jSONObject2;
        String str;
        zzeah zzeahVar = (zzeah) obj;
        jSONObject = zzeahVar.zza;
        int optInt = jSONObject.optInt("http_timeout_millis", 60000);
        zzbvsVar = zzeahVar.zzb;
        String str2 = "";
        if (zzbvsVar.zza() != -2) {
            if (zzbvsVar.zza() == 1) {
                if (zzbvsVar.zzh() != null) {
                    str2 = TextUtils.join(", ", zzbvsVar.zzh());
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzg(str2);
                }
                zzdwmVar = new zzdwm(2, "Error building request URL: ".concat(String.valueOf(str2)));
            } else {
                zzdwmVar = new zzdwm(1);
            }
            zzfhu zzfhuVar = this.zzd;
            zzfhj zzfhjVar = this.zzc;
            zzfhjVar.zzh(zzdwmVar);
            zzfhjVar.zzg(false);
            zzfhuVar.zza(zzfhjVar);
            throw zzdwmVar;
        }
        HashMap hashMap = new HashMap();
        zzbvsVar2 = zzeahVar.zzb;
        if (zzbvsVar2.zzj()) {
            String str3 = this.zzb;
            if (!TextUtils.isEmpty(str3)) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbd)).booleanValue()) {
                    if (TextUtils.isEmpty(str3)) {
                        str = "";
                    } else {
                        Matcher matcher = zza.matcher(str3);
                        str = "";
                        while (matcher.find()) {
                            String group = matcher.group(1);
                            if (group != null && (group.toLowerCase(Locale.ROOT).startsWith("id=") || group.toLowerCase(Locale.ROOT).startsWith("ide="))) {
                                if (!TextUtils.isEmpty(str)) {
                                    str = str.concat("; ");
                                }
                                str = str.concat(group);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        hashMap.put(HttpHeaders.COOKIE, str);
                    }
                } else {
                    hashMap.put(HttpHeaders.COOKIE, str3);
                }
            }
        }
        zzbvsVar3 = zzeahVar.zzb;
        if (zzbvsVar3.zzk() && jSONObject2 != null) {
            JSONObject optJSONObject = jSONObject2.optJSONObject("pii");
            if (optJSONObject != null) {
                if (!TextUtils.isEmpty(optJSONObject.optString("doritos", ""))) {
                    hashMap.put("x-afma-drt-cookie", optJSONObject.optString("doritos", ""));
                }
                if (!TextUtils.isEmpty(optJSONObject.optString("doritos_v2", ""))) {
                    hashMap.put("x-afma-drt-v2-cookie", optJSONObject.optString("doritos_v2", ""));
                }
            } else {
                com.google.android.gms.ads.internal.util.zze.zza("DSID signal does not exist.");
            }
        }
        zzbvsVar4 = zzeahVar.zzb;
        if (zzbvsVar4 != null) {
            zzbvsVar7 = zzeahVar.zzb;
            if (!TextUtils.isEmpty(zzbvsVar7.zzf())) {
                zzbvsVar8 = zzeahVar.zzb;
                str2 = zzbvsVar8.zzf();
            }
        }
        zzfhu zzfhuVar2 = this.zzd;
        zzfhj zzfhjVar2 = this.zzc;
        zzfhjVar2.zzg(true);
        zzfhuVar2.zza(zzfhjVar2);
        zzbvsVar5 = zzeahVar.zzb;
        String zzg = zzbvsVar5.zzg();
        byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
        zzbvsVar6 = zzeahVar.zzb;
        return new zzead(zzg, optInt, hashMap, bytes, "", zzbvsVar6.zzk());
    }
}
