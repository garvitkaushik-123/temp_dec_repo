package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzesh implements zzeub {
    private final zzfcw zza;
    private final PackageInfo zzb;
    private final com.google.android.gms.ads.internal.util.zzg zzc;

    public zzesh(zzfcw zzfcwVar, PackageInfo packageInfo, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzfcwVar;
        this.zzb = packageInfo;
        this.zzc = zzgVar;
    }

    private final void zzc(Bundle bundle) {
        int i;
        zzbge zzbgeVar = this.zza.zzi;
        if (zzbgeVar == null || (i = zzbgeVar.zzi) == 0) {
            return;
        }
        bundle.putBoolean("sccg_tap", zzbgeVar.zzj);
        bundle.putInt("sccg_dir", i);
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        ArrayList arrayList = this.zza.zzg;
        zzcva zzcvaVar = (zzcva) obj;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        zzc(zzcvaVar.zzb);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00df, code lost:
    
        if (r0 == 3) goto L71;
     */
    @Override // com.google.android.gms.internal.ads.zzeub
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        JSONArray optJSONArray;
        zzfcw zzfcwVar = this.zza;
        ArrayList<String> arrayList = zzfcwVar.zzg;
        zzcva zzcvaVar = (zzcva) obj;
        if (arrayList == null) {
            return;
        }
        if (arrayList.isEmpty()) {
            zzcvaVar.zza.putInt("native_version", 0);
            return;
        }
        Bundle bundle = zzcvaVar.zza;
        bundle.putInt("native_version", 3);
        bundle.putStringArrayList("native_templates", arrayList);
        bundle.putStringArrayList("native_custom_templates", zzfcwVar.zzh);
        zzbge zzbgeVar = zzfcwVar.zzi;
        if (zzbgeVar != null) {
            int i = zzbgeVar.zza;
            String str = C3040d4.h.C;
            if (i > 3) {
                bundle.putBoolean("enable_native_media_orientation", true);
                int i2 = zzbgeVar.zzh;
                String str2 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "unknown" : "square" : C3040d4.h.D : C3040d4.h.C : "any";
                if (!"unknown".equals(str2)) {
                    bundle.putString("native_media_orientation", str2);
                }
            }
            int i3 = zzbgeVar.zzc;
            if (i3 == 0) {
                str = "any";
            } else if (i3 == 1) {
                str = C3040d4.h.D;
            } else if (i3 != 2) {
                str = "unknown";
            }
            if (!"unknown".equals(str)) {
                bundle.putString("native_image_orientation", str);
            }
            bundle.putBoolean("native_multiple_images", zzbgeVar.zzd);
            bundle.putBoolean("use_custom_mute", zzbgeVar.zzg);
            zzc(bundle);
        }
        PackageInfo packageInfo = this.zzb;
        int i4 = packageInfo != null ? packageInfo.versionCode : 0;
        com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzc;
        if (i4 > zzgVar.zza()) {
            zzgVar.zzq();
            zzgVar.zzt(i4);
        }
        JSONObject zzn = zzgVar.zzn();
        String str3 = null;
        if (zzn != null && (optJSONArray = zzn.optJSONArray(zzfcwVar.zzf)) != null) {
            str3 = optJSONArray.toString();
        }
        if (!TextUtils.isEmpty(str3)) {
            bundle.putString("native_advanced_settings", str3);
        }
        int i5 = zzfcwVar.zzk;
        if (i5 > 1) {
            bundle.putInt("max_num_ads", i5);
        }
        zzbmp zzbmpVar = zzfcwVar.zzb;
        if (zzbmpVar != null) {
            String str4 = zzbmpVar.zzc;
            if (TextUtils.isEmpty(str4)) {
                String str5 = "p";
                if (zzbmpVar.zza >= 2) {
                    int i6 = zzbmpVar.zzd;
                    if (i6 != 2) {
                    }
                    str5 = "l";
                    bundle.putString("ia_var", str5);
                } else {
                    int i7 = zzbmpVar.zzb;
                    if (i7 != 1) {
                        if (i7 != 2) {
                            com.google.android.gms.ads.internal.util.client.zzo.zzg("Instream ad video aspect ratio " + i7 + " is wrong.");
                        }
                        bundle.putString("ia_var", str5);
                    }
                    str5 = "l";
                    bundle.putString("ia_var", str5);
                }
            } else {
                bundle.putString("ad_tag", str4);
            }
            bundle.putBoolean("instr", true);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmn)).booleanValue() || zzbgeVar == null) {
            return;
        }
        com.google.android.gms.ads.internal.client.zzgc zzgcVar = zzbgeVar.zzf;
        if (zzgcVar != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("startMuted", zzgcVar.zza);
            bundle2.putBoolean("clickToExpandRequested", zzgcVar.zzc);
            bundle2.putBoolean("customControlsRequested", zzgcVar.zzb);
            bundle.putBundle("video", bundle2);
        }
        bundle.putBoolean("disable_image_loading", zzbgeVar.zzb);
        bundle.putInt("preferred_ad_choices_position", zzbgeVar.zze);
    }
}
