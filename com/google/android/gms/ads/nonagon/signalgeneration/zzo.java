package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzdso;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzo {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private final Context zzc;
    private final zzdso zzd;
    private final ExecutorService zze;

    zzo(Context context, zzdso zzdsoVar, ExecutorService executorService) {
        this.zzc = context;
        this.zzd = zzdsoVar;
        this.zze = executorService;
    }

    public static /* synthetic */ Object zza(zzo zzoVar, AdRequest adRequest, zzp zzpVar) {
        QueryInfo.generate(zzoVar.zzc, AdFormat.BANNER, adRequest, zzpVar);
        return true;
    }

    public static /* synthetic */ void zzb(zzo zzoVar, Object obj, Pair pair) {
        boolean z = false;
        if (obj instanceof WebView) {
            CookieManager zza = com.google.android.gms.ads.internal.zzv.zzs().zza(zzoVar.zzc);
            if (zza != null) {
                z = zza.acceptThirdPartyCookies((WebView) obj);
            }
        }
        Map map = zzoVar.zza;
        Boolean valueOf = Boolean.valueOf(z);
        zzq zzqVar = (zzq) map.get(valueOf);
        if (zzqVar != null && !zzqVar.zze()) {
            zzoVar.zzi(zzqVar, pair, true);
            return;
        }
        Map map2 = zzoVar.zzb;
        List list = (List) map2.get(valueOf);
        if (list == null) {
            list = new ArrayList();
            map2.put(valueOf, list);
        }
        list.add(pair);
    }

    private final void zzh(final boolean z) {
        Map map = this.zzb;
        Boolean valueOf = Boolean.valueOf(z);
        if (map.containsKey(valueOf)) {
            return;
        }
        map.put(valueOf, new ArrayList());
        this.zze.submit(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzm
            @Override // java.lang.Runnable
            public final void run() {
                zzo.this.zzj(z, false);
            }
        });
    }

    private final void zzi(zzq zzqVar, Pair pair, boolean z) {
        zzqVar.zzd();
        QueryInfo zzb = zzqVar.zzb();
        if (zzb != null) {
            ((QueryInfoGenerationCallback) pair.first).onSuccess(zzb);
        } else {
            ((QueryInfoGenerationCallback) pair.first).onFailure(zzqVar.zzc());
        }
        zzdso zzdsoVar = this.zzd;
        Pair[] pairArr = new Pair[7];
        pairArr[0] = new Pair("se", "query_g");
        pairArr[1] = new Pair(FirebaseAnalytics.Param.AD_FORMAT, AdFormat.BANNER.name());
        pairArr[2] = new Pair("rtype", Integer.toString(6));
        pairArr[3] = new Pair("scar", "true");
        pairArr[4] = new Pair("lat_ms", Long.toString(com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() - ((Long) pair.second).longValue()));
        pairArr[5] = new Pair("sgpc_h", Boolean.toString(z));
        pairArr[6] = new Pair("sgpc_rs", Boolean.toString(zzqVar.zzb() != null));
        zzaa.zzd(zzdsoVar, null, "sgpcr", pairArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzj(boolean z, boolean z2) {
        Throwable th;
        try {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("query_info_type", "requester_type_6");
                bundle.putBoolean("accept_3p_cookie", z);
                Map map = this.zza;
                Boolean valueOf = Boolean.valueOf(z);
                zzq zzqVar = (zzq) map.get(valueOf);
                int i = 0;
                if (z2 && zzqVar != null) {
                    try {
                        i = zzqVar.zza() + 1;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                zzq zzqVar2 = (zzq) map.get(valueOf);
                final zzp zzpVar = new zzp(this, z, i, zzqVar2 == null ? null : Boolean.valueOf(zzqVar2.zzf()), this.zzd);
                final AdRequest build = new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle).build();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlz)).booleanValue()) {
                    this.zze.submit(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzn
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return zzo.zza(zzo.this, build, zzpVar);
                        }
                    });
                } else {
                    QueryInfo.generate(this.zzc, AdFormat.BANNER, build, zzpVar);
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final synchronized void zze() {
        zzh(true);
        zzh(false);
    }

    final synchronized void zzf(final boolean z, zzq zzqVar) {
        Map map = this.zza;
        Boolean valueOf = Boolean.valueOf(z);
        zzq zzqVar2 = (zzq) map.get(valueOf);
        if (zzqVar2 == null || zzqVar2.zze() || zzqVar2.zzb() == null || zzqVar.zzb() != null) {
            map.put(valueOf, zzqVar);
        }
        long longValue = (zzqVar.zzb() != null ? (Long) zzbfj.zzf.zze() : (Long) zzbfj.zzg.zze()).longValue();
        final boolean z2 = zzqVar.zzb() == null;
        zzcaf.zzd.schedule(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzl
            @Override // java.lang.Runnable
            public final void run() {
                zzo.this.zzj(z, z2);
            }
        }, longValue, TimeUnit.SECONDS);
        Map map2 = this.zzb;
        List list = (List) map2.get(valueOf);
        map2.put(valueOf, new ArrayList());
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzi(zzqVar, (Pair) it.next(), false);
            }
        }
    }

    public final synchronized void zzg(final Object obj, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        final Pair pair = new Pair(queryInfoGenerationCallback, Long.valueOf(com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis()));
        zzcaf.zzf.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzk
            @Override // java.lang.Runnable
            public final void run() {
                zzo.zzb(zzo.this, obj, pair);
            }
        });
    }
}
