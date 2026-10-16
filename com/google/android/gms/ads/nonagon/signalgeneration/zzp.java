package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzdso;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzp extends QueryInfoGenerationCallback {
    private final zzo zza;
    private final zzdso zzb;
    private final boolean zzc;
    private final int zzd;
    private final long zze = com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis();
    private final Boolean zzf;

    public zzp(zzo zzoVar, boolean z, int i, Boolean bool, zzdso zzdsoVar) {
        this.zza = zzoVar;
        this.zzc = z;
        this.zzd = i;
        this.zzf = bool;
        this.zzb = zzdsoVar;
    }

    private static long zza() {
        return com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() + ((Long) zzbfj.zzh.zze()).longValue();
    }

    private final long zzb() {
        return com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() - this.zze;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        Pair[] pairArr = new Pair[9];
        pairArr[0] = new Pair("sgf_reason", str);
        pairArr[1] = new Pair("se", "query_g");
        pairArr[2] = new Pair(FirebaseAnalytics.Param.AD_FORMAT, AdFormat.BANNER.name());
        pairArr[3] = new Pair("rtype", Integer.toString(6));
        pairArr[4] = new Pair("scar", "true");
        pairArr[5] = new Pair("lat_ms", Long.toString(zzb()));
        int i = this.zzd;
        pairArr[6] = new Pair("sgpc_rn", Integer.toString(i));
        pairArr[7] = new Pair("sgpc_lsu", String.valueOf(this.zzf));
        boolean z = this.zzc;
        pairArr[8] = new Pair("tpc", true != z ? "0" : "1");
        zzaa.zzd(this.zzb, null, "sgpcf", pairArr);
        this.zza.zzf(z, new zzq(null, str, zza(), i));
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        Pair[] pairArr = new Pair[8];
        pairArr[0] = new Pair("se", "query_g");
        pairArr[1] = new Pair(FirebaseAnalytics.Param.AD_FORMAT, AdFormat.BANNER.name());
        pairArr[2] = new Pair("rtype", Integer.toString(6));
        pairArr[3] = new Pair("scar", "true");
        pairArr[4] = new Pair("lat_ms", Long.toString(zzb()));
        int i = this.zzd;
        pairArr[5] = new Pair("sgpc_rn", Integer.toString(i));
        pairArr[6] = new Pair("sgpc_lsu", String.valueOf(this.zzf));
        boolean z = this.zzc;
        pairArr[7] = new Pair("tpc", true != z ? "0" : "1");
        zzaa.zzd(this.zzb, null, "sgpcs", pairArr);
        this.zza.zzf(z, new zzq(queryInfo, "", zza(), i));
    }
}
