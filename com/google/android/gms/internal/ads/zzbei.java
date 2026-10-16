package com.google.android.gms.internal.ads;

import androidx.browser.customtabs.CustomTabsSession;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import java.util.Objects;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbei extends QueryInfoGenerationCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbej zzb;

    zzbei(zzbej zzbejVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzbejVar);
        this.zzb = zzbejVar;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        CustomTabsSession customTabsSession;
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to generate query info for Custom Tab error: ".concat(String.valueOf(str)));
        try {
            zzbej zzbejVar = this.zzb;
            customTabsSession = zzbejVar.zzg;
            customTabsSession.postMessage(zzbejVar.zzc(this.zza, str).toString(), null);
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error creating PACT Error Response JSON: ", e);
        }
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        CustomTabsSession customTabsSession;
        String query = queryInfo.getQuery();
        try {
            zzbej zzbejVar = this.zzb;
            customTabsSession = zzbejVar.zzg;
            customTabsSession.postMessage(zzbejVar.zzd(this.zza, query).toString(), null);
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error creating PACT Signal Response JSON: ", e);
        }
    }
}
