package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzavu;
import com.google.android.gms.internal.ads.zzavv;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzdso;
import com.google.android.gms.internal.ads.zzfda;
import com.google.android.gms.internal.ads.zzfjy;
import com.google.android.gms.internal.ads.zzgdy;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class TaggingLibraryJsInterface {
    private final Context zza;
    private final WebView zzb;
    private final zzavu zzc;
    private final zzfda zzd;
    private final int zze;
    private final zzdso zzf;
    private final boolean zzg;
    private final zzgdy zzh = zzcaf.zzf;
    private final zzfjy zzi;
    private final zzo zzj;
    private final zzf zzk;
    private final zzj zzl;

    TaggingLibraryJsInterface(WebView webView, zzavu zzavuVar, zzdso zzdsoVar, zzfjy zzfjyVar, zzfda zzfdaVar, zzo zzoVar, zzf zzfVar, zzj zzjVar) {
        this.zzb = webView;
        Context context = webView.getContext();
        this.zza = context;
        this.zzc = zzavuVar;
        this.zzf = zzdsoVar;
        zzbde.zza(context);
        this.zze = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjZ)).intValue();
        this.zzg = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzka)).booleanValue();
        this.zzi = zzfjyVar;
        this.zzd = zzfdaVar;
        this.zzj = zzoVar;
        this.zzk = zzfVar;
        this.zzl = zzjVar;
    }

    public static /* synthetic */ void zze(TaggingLibraryJsInterface taggingLibraryJsInterface, String str) {
        zzfda zzfdaVar;
        Uri parse = Uri.parse(str);
        try {
            parse = (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmu)).booleanValue() || (zzfdaVar = taggingLibraryJsInterface.zzd) == null) ? taggingLibraryJsInterface.zzc.zza(parse, taggingLibraryJsInterface.zza, taggingLibraryJsInterface.zzb, null) : zzfdaVar.zza(parse, taggingLibraryJsInterface.zza, taggingLibraryJsInterface.zzb, null);
        } catch (zzavv e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to append the click signal to URL: ", e);
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "TaggingLibraryJsInterface.recordClick");
        }
        taggingLibraryJsInterface.zzi.zzd(parse.toString(), null, null, null);
    }

    public static /* synthetic */ void zzf(TaggingLibraryJsInterface taggingLibraryJsInterface, Bundle bundle, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        com.google.android.gms.ads.internal.util.zzaa zzs = com.google.android.gms.ads.internal.zzv.zzs();
        Context context = taggingLibraryJsInterface.zza;
        CookieManager zza = zzs.zza(context);
        bundle.putBoolean("accept_3p_cookie", zza != null ? zza.acceptThirdPartyCookies(taggingLibraryJsInterface.zzb) : false);
        QueryInfo.generate(context, AdFormat.BANNER, new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle).build(), queryInfoGenerationCallback);
    }

    @JavascriptInterface
    public String getClickSignals(String str) {
        try {
            long currentTimeMillis = com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis();
            String zzd = this.zzc.zzc().zzd(this.zza, str, this.zzb);
            if (this.zzg) {
                zzaa.zzd(this.zzf, null, "csg", new Pair("clat", String.valueOf(com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() - currentTimeMillis)));
            }
            return zzd;
        } catch (RuntimeException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Exception getting click signals. ", e);
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "TaggingLibraryJsInterface.getClickSignals");
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JavascriptInterface
    public String getClickSignalsWithTimeout(final String str, int i) {
        if (i <= 0) {
            String str2 = "Invalid timeout for getting click signals. Timeout=" + i;
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg(str2);
            return "";
        }
        try {
            return (String) zzcaf.zza.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbq
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return TaggingLibraryJsInterface.this.getClickSignals(str);
                }
            }).get(Math.min(i, this.zze), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Exception getting click signals with timeout. ", e);
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "TaggingLibraryJsInterface.getClickSignalsWithTimeout");
            return e instanceof TimeoutException ? "17" : "";
        }
    }

    @JavascriptInterface
    public String getQueryInfo() {
        com.google.android.gms.ads.internal.zzv.zzr();
        String uuid = UUID.randomUUID().toString();
        final Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        final zzbu zzbuVar = new zzbu(this, uuid);
        if (((Boolean) zzbfj.zze.zze()).booleanValue()) {
            this.zzj.zzg(this.zzb, zzbuVar);
            return uuid;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkc)).booleanValue()) {
            this.zzh.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbr
                @Override // java.lang.Runnable
                public final void run() {
                    TaggingLibraryJsInterface.zzf(TaggingLibraryJsInterface.this, bundle, zzbuVar);
                }
            });
            return uuid;
        }
        QueryInfo.generate(this.zza, AdFormat.BANNER, new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle).build(), zzbuVar);
        return uuid;
    }

    @JavascriptInterface
    public String getViewSignals() {
        try {
            long currentTimeMillis = com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis();
            String zzh = this.zzc.zzc().zzh(this.zza, this.zzb, null);
            if (this.zzg) {
                zzaa.zzd(this.zzf, null, "vsg", new Pair("vlat", String.valueOf(com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() - currentTimeMillis)));
            }
            return zzh;
        } catch (RuntimeException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Exception getting view signals. ", e);
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "TaggingLibraryJsInterface.getViewSignals");
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JavascriptInterface
    public String getViewSignalsWithTimeout(int i) {
        if (i <= 0) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Invalid timeout for getting view signals. Timeout=" + i);
            return "";
        }
        try {
            return (String) zzcaf.zza.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbo
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return TaggingLibraryJsInterface.this.getViewSignals();
                }
            }).get(Math.min(i, this.zze), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Exception getting view signals with timeout. ", e);
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "TaggingLibraryJsInterface.getViewSignalsWithTimeout");
            return e instanceof TimeoutException ? "17" : "";
        }
    }

    @JavascriptInterface
    public void recordClick(final String str) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzke)).booleanValue() || TextUtils.isEmpty(str)) {
            return;
        }
        zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbp
            @Override // java.lang.Runnable
            public final void run() {
                TaggingLibraryJsInterface.zze(TaggingLibraryJsInterface.this, str);
            }
        });
    }

    @JavascriptInterface
    public void reportTouchEvent(String str) {
        int i;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i2 = jSONObject.getInt(VastAttributes.HORIZONTAL_POSITION);
            int i3 = jSONObject.getInt(VastAttributes.VERTICAL_POSITION);
            int i4 = jSONObject.getInt("duration_ms");
            float f = (float) jSONObject.getDouble("force");
            int i5 = jSONObject.getInt("type");
            if (i5 != 0) {
                i = 1;
                if (i5 != 1) {
                    i = 2;
                    if (i5 != 2) {
                        i = 3;
                        if (i5 != 3) {
                            i = -1;
                        }
                    }
                }
            } else {
                i = 0;
            }
            try {
                this.zzc.zzd(MotionEvent.obtain(0L, i4, i, i2, i3, f, 1.0f, 0, 1.0f, 1.0f, 0, 0));
            } catch (RuntimeException e) {
                e = e;
                int i6 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Failed to parse the touch string. ", e);
                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "TaggingLibraryJsInterface.reportTouchEvent");
            } catch (JSONException e2) {
                e = e2;
                int i62 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Failed to parse the touch string. ", e);
                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "TaggingLibraryJsInterface.reportTouchEvent");
            }
        } catch (RuntimeException | JSONException e3) {
            e = e3;
        }
    }
}
