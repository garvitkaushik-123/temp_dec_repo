package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.webkit.WebView;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzfyv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzf {
    private final Context zza;
    private final ApplicationInfo zzb;
    private final List zzc;
    private final VersionInfoParcel zzd;
    private final JSONObject zze = new JSONObject();
    private final AtomicBoolean zzf = new AtomicBoolean(false);

    zzf(Context context, zzbcn zzbcnVar, List list, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = context.getApplicationInfo();
        this.zzc = list;
        this.zzd = versionInfoParcel;
    }

    public final JSONObject zza() {
        if (!this.zzf.get()) {
            zzb(null);
        }
        return this.zze;
    }

    public final void zzb(WebView webView) {
        if (this.zzf.getAndSet(true)) {
            return;
        }
        PackageInfo packageInfo = null;
        try {
            ApplicationInfo applicationInfo = this.zzb;
            if (applicationInfo != null) {
                packageInfo = Wrappers.packageManager(this.zza).getPackageInfo(applicationInfo.packageName, 0);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfo != null) {
            try {
                JSONObject jSONObject = this.zze;
                jSONObject.put("vc", packageInfo.versionCode);
                jSONObject.put("vnm", packageInfo.versionName);
            } catch (JSONException e) {
                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "PawAppSignalGenerator.initialize");
            }
        }
        ApplicationInfo applicationInfo2 = this.zzb;
        if (applicationInfo2 != null) {
            this.zze.put("pn", applicationInfo2.packageName);
        }
        JSONObject jSONObject2 = this.zze;
        List list = this.zzc;
        ArrayList arrayList = new ArrayList();
        for (String str : ((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkk)).split(",", -1)) {
            if (list.contains(str)) {
                arrayList.add(str);
            }
        }
        jSONObject2.put("eid", arrayList);
        jSONObject2.put("js", this.zzd.afmaVersion);
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject2.get(next);
            if (obj != null) {
                jSONObject2.put(next, Base64.encodeToString(obj.toString().getBytes(), 2));
            }
        }
        if (((Boolean) zzbfj.zzb.zze()).booleanValue() && WebViewFeature.isFeatureSupported(WebViewFeature.DOCUMENT_START_SCRIPT) && webView != null) {
            WebViewCompat.addDocumentStartJavaScript(webView, String.format(Locale.getDefault(), (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkj), zza()), zzfyv.zzo("*"));
        }
    }
}
