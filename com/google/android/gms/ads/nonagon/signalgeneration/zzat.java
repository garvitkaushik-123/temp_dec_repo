package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzdso;
import com.google.android.gms.internal.ads.zzgdj;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
final class zzat implements zzgdj {
    final /* synthetic */ zzau zza;

    zzat(zzau zzauVar) {
        Objects.requireNonNull(zzauVar);
        this.zza = zzauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzdso zzdsoVar;
        AtomicInteger atomicInteger;
        AtomicBoolean atomicBoolean;
        AtomicInteger atomicInteger2;
        com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "SignalGeneratorImpl.initializeWebViewForSignalCollection");
        zzau zzauVar = this.zza;
        zzdsoVar = zzauVar.zzp;
        atomicInteger = zzauVar.zzH;
        zzaa.zzd(zzdsoVar, null, "sgf", new Pair("sgf_reason", th.getMessage()), new Pair("se", "query_g"), new Pair(FirebaseAnalytics.Param.AD_FORMAT, AdFormat.BANNER.name()), new Pair("rtype", Integer.toString(6)), new Pair("scar", "true"), new Pair("sgi_rn", Integer.toString(atomicInteger.get())));
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh("Failed to initialize webview for loading SDKCore. ", th);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkf)).booleanValue()) {
            atomicBoolean = zzauVar.zzG;
            if (atomicBoolean.get()) {
                return;
            }
            atomicInteger2 = zzauVar.zzH;
            if (atomicInteger2.getAndIncrement() < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkg)).intValue()) {
                zzauVar.zzT();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdso zzdsoVar;
        AtomicInteger atomicInteger;
        AtomicBoolean atomicBoolean;
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Initialized webview successfully for SDKCore.");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkf)).booleanValue()) {
            zzau zzauVar = this.zza;
            zzdsoVar = zzauVar.zzp;
            atomicInteger = zzauVar.zzH;
            zzaa.zzd(zzdsoVar, null, "sgs", new Pair("se", "query_g"), new Pair(FirebaseAnalytics.Param.AD_FORMAT, AdFormat.BANNER.name()), new Pair("rtype", Integer.toString(6)), new Pair("scar", "true"), new Pair("sgi_rn", Integer.toString(atomicInteger.get())));
            atomicBoolean = zzauVar.zzG;
            atomicBoolean.set(true);
        }
    }
}
