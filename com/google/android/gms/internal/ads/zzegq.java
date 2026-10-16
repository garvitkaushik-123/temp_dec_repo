package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzegq implements zzedm {
    private static Bundle zzd(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final ListenableFuture zza(zzfcn zzfcnVar, zzfca zzfcaVar) {
        JSONObject jSONObject = zzfcaVar.zzv;
        String optString = jSONObject.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzfcw zzfcwVar = zzfcnVar.zza.zza;
        zzfcu zzfcuVar = new zzfcu();
        zzfcuVar.zzr(zzfcwVar);
        zzfcuVar.zzu(optString);
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzfcwVar.zzd;
        Bundle zzd = zzd(zzmVar.zzm);
        Bundle zzd2 = zzd(zzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        zzd2.putInt("gw", 1);
        String optString2 = jSONObject.optString("mad_hac", null);
        if (optString2 != null) {
            zzd2.putString("mad_hac", optString2);
        }
        String optString3 = jSONObject.optString("adJson", null);
        if (optString3 != null) {
            zzd2.putString("_ad", optString3);
        }
        zzd2.putBoolean("_noRefresh", true);
        JSONObject jSONObject2 = zzfcaVar.zzD;
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = jSONObject2.optString(next, null);
            if (next != null) {
                zzd2.putString(next, optString4);
            }
        }
        zzd.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzd2);
        zzfcuVar.zzJ(new com.google.android.gms.ads.internal.client.zzm(zzmVar.zza, zzmVar.zzb, zzd2, zzmVar.zzd, zzmVar.zze, zzmVar.zzf, zzmVar.zzg, zzmVar.zzh, zzmVar.zzi, zzmVar.zzj, zzmVar.zzk, zzmVar.zzl, zzd, zzmVar.zzn, zzmVar.zzo, zzmVar.zzp, zzmVar.zzq, zzmVar.zzr, zzmVar.zzs, zzmVar.zzt, zzmVar.zzu, zzmVar.zzv, zzmVar.zzw, zzmVar.zzx, zzmVar.zzy, zzmVar.zzz, zzmVar.zzA));
        zzfcw zzL = zzfcuVar.zzL();
        Bundle bundle = new Bundle();
        zzfcd zzfcdVar = zzfcnVar.zzb.zzb;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList<>(zzfcdVar.zza));
        bundle2.putInt("refresh_interval", zzfcdVar.zzc);
        bundle2.putString("gws_query_id", zzfcdVar.zzb);
        bundle.putBundle("parent_common_config", bundle2);
        String str = zzfcwVar.zzf;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str);
        bundle3.putString("allocation_id", zzfcaVar.zzw);
        bundle3.putString("ad_source_name", zzfcaVar.zzF);
        bundle3.putStringArrayList("click_urls", new ArrayList<>(zzfcaVar.zzc));
        bundle3.putStringArrayList("imp_urls", new ArrayList<>(zzfcaVar.zzd));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList<>(zzfcaVar.zzp));
        bundle3.putStringArrayList("fill_urls", new ArrayList<>(zzfcaVar.zzm));
        bundle3.putStringArrayList("video_start_urls", new ArrayList<>(zzfcaVar.zzg));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList<>(zzfcaVar.zzh));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList<>(zzfcaVar.zzi));
        bundle3.putString("transaction_id", zzfcaVar.zzj);
        bundle3.putString("valid_from_timestamp", zzfcaVar.zzk);
        bundle3.putBoolean("is_closable_area_disabled", zzfcaVar.zzP);
        bundle3.putString("recursive_server_response_data", zzfcaVar.zzao);
        bundle3.putBoolean("is_analytics_logging_enabled", zzfcaVar.zzW);
        zzbwo zzbwoVar = zzfcaVar.zzl;
        if (zzbwoVar != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzbwoVar.zzb);
            bundle4.putString("rb_type", zzbwoVar.zza);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return zzc(zzL, bundle, zzfcaVar, zzfcnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final boolean zzb(zzfcn zzfcnVar, zzfca zzfcaVar) {
        return !TextUtils.isEmpty(zzfcaVar.zzv.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    protected abstract ListenableFuture zzc(zzfcw zzfcwVar, Bundle bundle, zzfca zzfcaVar, zzfcn zzfcnVar);
}
