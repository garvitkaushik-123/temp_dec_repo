package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbct extends zzbcv {
    zzbct(int i, String str, String str2, String str3) {
        super(1, str, str2, str3, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbcv
    public final /* bridge */ /* synthetic */ Object zza(JSONObject jSONObject) {
        return jSONObject.optString(zzm(), (String) zzl());
    }

    @Override // com.google.android.gms.internal.ads.zzbcv
    public final /* bridge */ /* synthetic */ Object zzb(Bundle bundle) {
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(zzm())) ? bundle.getString("com.google.android.gms.ads.flag.".concat(zzm())) : (String) zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzbcv
    public final /* bridge */ /* synthetic */ Object zzc(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(zzm(), (String) zzl());
    }

    @Override // com.google.android.gms.internal.ads.zzbcv
    public final /* bridge */ /* synthetic */ void zzd(SharedPreferences.Editor editor, Object obj) {
        editor.putString(zzm(), (String) obj);
    }
}
