package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbej {
    private final ScheduledExecutorService zza;
    private final com.google.android.gms.ads.nonagon.signalgeneration.zzo zzb;
    private final com.google.android.gms.ads.nonagon.signalgeneration.zzf zzc;
    private final zzdso zzd;
    private Runnable zze;
    private zzbeg zzf;
    private CustomTabsSession zzg;
    private String zzh;
    private long zzi = 0;
    private long zzj;
    private JSONArray zzk;
    private Context zzl;

    public zzbej(ScheduledExecutorService scheduledExecutorService, com.google.android.gms.ads.nonagon.signalgeneration.zzo zzoVar, com.google.android.gms.ads.nonagon.signalgeneration.zzf zzfVar, zzdso zzdsoVar) {
        this.zza = scheduledExecutorService;
        this.zzb = zzoVar;
        this.zzc = zzfVar;
        this.zzd = zzdsoVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzkn)).booleanValue() != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzj() {
        ScheduledExecutorService scheduledExecutorService;
        zzbeg zzbegVar = this.zzf;
        if (zzbegVar == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("PACT callback is not present, please initialize the PawCustomTabsImpl.");
            return;
        }
        if (zzbegVar.zza().booleanValue()) {
            return;
        }
        if (this.zzh != null && this.zzg != null && (scheduledExecutorService = this.zza) != null) {
            if (this.zzi == 0 || com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() > this.zzi) {
            }
            this.zzg.requestPostMessageChannel(Uri.parse(this.zzh));
            scheduledExecutorService.schedule(this.zze, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzko)).longValue(), TimeUnit.MILLISECONDS);
            return;
        }
        com.google.android.gms.ads.internal.util.zze.zza("PACT max retry connection duration timed out");
    }

    private final void zzk(JSONObject jSONObject) {
        try {
            if (this.zzk == null) {
                this.zzk = new JSONArray((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkq));
            }
            jSONObject.put("eids", this.zzk);
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error fetching the PACT active eids JSON: ", e);
        }
    }

    @Nullable
    public final CustomTabsSession zzb() {
        return this.zzg;
    }

    final JSONObject zzc(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paw_id", str);
        jSONObject.put("error", str2);
        jSONObject.put("sdk_ttl_ms", ((Boolean) zzbfj.zze.zze()).booleanValue() ? ((Long) zzbfj.zzh.zze()).longValue() : 0L);
        zzk(jSONObject);
        if (((Boolean) zzbfj.zzc.zze()).booleanValue()) {
            jSONObject.put("as", this.zzc.zza());
        }
        return jSONObject;
    }

    final JSONObject zzd(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paw_id", str);
        jSONObject.put("signal", str2);
        jSONObject.put("sdk_ttl_ms", ((Boolean) zzbfj.zze.zze()).booleanValue() ? ((Long) zzbfj.zzh.zze()).longValue() : 0L);
        zzk(jSONObject);
        if (((Boolean) zzbfj.zzc.zze()).booleanValue()) {
            jSONObject.put("as", this.zzc.zza());
        }
        return jSONObject;
    }

    final void zzf() {
        this.zzi = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() + ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkm)).intValue();
        if (this.zze == null) {
            this.zze = new Runnable() { // from class: com.google.android.gms.internal.ads.zzbeh
                @Override // java.lang.Runnable
                public final void run() {
                    zzbej.this.zzj();
                }
            };
        }
        zzj();
    }

    final void zzh(String str) {
        try {
            CustomTabsSession customTabsSession = this.zzg;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("gsppack", true);
            jSONObject.put("fpt", new Date(this.zzj).toString());
            zzk(jSONObject);
            if (((Boolean) zzbfj.zzc.zze()).booleanValue()) {
                jSONObject.put("as", this.zzc.zza());
            }
            customTabsSession.postMessage(jSONObject.toString(), null);
            zzbei zzbeiVar = new zzbei(this, str);
            if (((Boolean) zzbfj.zze.zze()).booleanValue()) {
                this.zzb.zzg(this.zzg, zzbeiVar);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("query_info_type", "requester_type_6");
            QueryInfo.generate(this.zzl, AdFormat.BANNER, new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle).build(), zzbeiVar);
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error creating JSON: ", e);
        }
    }

    public final void zzi(long j) {
        this.zzj = j;
    }

    public final void zzg(@Nonnull Context context, @Nonnull CustomTabsClient customTabsClient, @Nonnull String str, @Nullable CustomTabsCallback customTabsCallback) {
        if (context == null) {
            throw new IllegalArgumentException("App Context parameter is null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Origin parameter is empty or null");
        }
        if (customTabsClient == null) {
            throw new IllegalArgumentException("CustomTabsClient parameter is null");
        }
        this.zzl = context;
        this.zzh = str;
        zzdso zzdsoVar = this.zzd;
        zzbeg zzbegVar = new zzbeg(this, customTabsCallback, zzdsoVar);
        this.zzf = zzbegVar;
        CustomTabsSession newSession = customTabsClient.newSession(zzbegVar);
        this.zzg = newSession;
        if (newSession == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("CustomTabsClient failed to create new session.");
        }
        com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzd(zzdsoVar, null, "pact_action", new Pair("pe", "pact_init"));
    }
}
