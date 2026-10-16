package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.telephony.TelephonyManager;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import androidx.autofill.HintConstants;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcj;
import com.google.android.gms.internal.ads.zzcfg;
import com.google.android.gms.internal.ads.zzcfo;
import com.google.android.gms.internal.ads.zzecl;
import java.io.InputStream;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public class zzaa {
    /* synthetic */ zzaa(zzz zzzVar) {
    }

    public CookieManager zza(Context context) {
        throw null;
    }

    public WebResourceResponse zzb(String str, String str2, int i, String str3, Map map, InputStream inputStream) {
        throw null;
    }

    public zzcfo zzc(zzcfg zzcfgVar, zzbcc zzbccVar, boolean z, zzecl zzeclVar) {
        throw null;
    }

    public boolean zzd(Activity activity, Configuration configuration) {
        return false;
    }

    public Intent zzf(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("app_package", activity.getPackageName());
        intent.putExtra("app_uid", activity.getApplicationInfo().uid);
        return intent;
    }

    public zzbcj.zzq zzg(Context context, TelephonyManager telephonyManager) {
        return zzbcj.zzq.ENUM_UNKNOWN;
    }

    public void zzh(Context context, String str, String str2) {
    }

    public boolean zzi(Context context, String str) {
        return false;
    }

    public int zzj(AudioManager audioManager) {
        return 0;
    }

    public void zzl(Activity activity) {
    }

    public int zzm(Context context) {
        return ((TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getNetworkType();
    }
}
