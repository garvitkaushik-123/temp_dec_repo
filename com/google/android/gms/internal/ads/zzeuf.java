package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeuf {
    private final Context zza;
    private final Set zzb;
    private final Executor zzc;
    private final zzfhu zzd;
    private final zzdsj zze;
    private long zzf = 0;
    private int zzg = 0;

    public zzeuf(Context context, Executor executor, Set set, zzfhu zzfhuVar, zzdsj zzdsjVar) {
        this.zza = context;
        this.zzc = executor;
        this.zzb = set;
        this.zzd = zzfhuVar;
        this.zze = zzdsjVar;
    }

    public static /* synthetic */ void zzb(zzeuf zzeufVar, long j, zzeuc zzeucVar, Bundle bundle) {
        long elapsedRealtime = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - j;
        if (((Boolean) zzbfg.zza.zze()).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zza("Signal runtime (ms) : " + zzfwg.zzc(zzeucVar.getClass().getCanonicalName()) + " = " + elapsedRealtime);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcq)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcw)).booleanValue()) {
                synchronized (zzeufVar) {
                    bundle.putLong("sig" + zzeucVar.zza(), elapsedRealtime);
                }
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzco)).booleanValue()) {
            zzdsi zza = zzeufVar.zze.zza();
            zza.zzb("action", "lat_ms");
            zza.zzb("lat_grp", "sig_lat_grp");
            zza.zzb("lat_id", String.valueOf(zzeucVar.zza()));
            zza.zzb("clat_ms", String.valueOf(elapsedRealtime));
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcp)).booleanValue()) {
                synchronized (zzeufVar) {
                    zzeufVar.zzg++;
                }
                zza.zzb("seq_num", com.google.android.gms.ads.internal.zzv.zzp().zzh().zzd());
                synchronized (zzeufVar) {
                    if (zzeufVar.zzg == zzeufVar.zzb.size() && zzeufVar.zzf != 0) {
                        zzeufVar.zzg = 0;
                        String valueOf = String.valueOf(com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - zzeufVar.zzf);
                        if (zzeucVar.zza() <= 39 || zzeucVar.zza() >= 52) {
                            zza.zzb("lat_clsg", valueOf);
                        } else {
                            zza.zzb("lat_gmssg", valueOf);
                        }
                    }
                }
            }
            zza.zzk();
        }
    }

    public final ListenableFuture zza(final Object obj, final Bundle bundle, final boolean z) {
        zzfhj zza = zzfhi.zza(this.zza, 8);
        zza.zzi();
        Set<zzeuc> set = this.zzb;
        final ArrayList arrayList = new ArrayList(set.size());
        List arrayList2 = new ArrayList();
        zzbcv zzbcvVar = zzbde.zzmg;
        if (!((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).isEmpty()) {
            arrayList2 = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).split(","));
        }
        this.zzf = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime();
        final Bundle bundle2 = new Bundle();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcq)).booleanValue() && bundle != null) {
            long currentTimeMillis = com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis();
            if (obj instanceof zzcva) {
                bundle.putLong(zzdrr.CLIENT_SIGNALS_START.zza(), currentTimeMillis);
            } else {
                bundle.putLong(zzdrr.GMS_SIGNALS_START.zza(), currentTimeMillis);
            }
        }
        for (final zzeuc zzeucVar : set) {
            if (!arrayList2.contains(String.valueOf(zzeucVar.zza()))) {
                final long elapsedRealtime = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime();
                ListenableFuture zzb = zzeucVar.zzb();
                final Bundle bundle3 = bundle2;
                zzb.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeud
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzeuf.zzb(zzeuf.this, elapsedRealtime, zzeucVar, bundle3);
                    }
                }, zzcaf.zzg);
                arrayList.add(zzb);
                bundle2 = bundle3;
            }
        }
        ListenableFuture zza2 = zzgdn.zzb(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeue
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object obj2;
                Bundle bundle4;
                Iterator it = arrayList.iterator();
                while (true) {
                    obj2 = obj;
                    if (!it.hasNext()) {
                        break;
                    }
                    zzeub zzeubVar = (zzeub) ((ListenableFuture) it.next()).get();
                    if (zzeubVar != null) {
                        boolean z2 = z;
                        zzeubVar.zzb(obj2);
                        if (z2) {
                            zzeubVar.zza(obj2);
                        }
                    }
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcq)).booleanValue() && (bundle4 = bundle) != null) {
                    Bundle bundle5 = bundle2;
                    long currentTimeMillis2 = com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis();
                    if (obj2 instanceof zzcva) {
                        bundle4.putLong(zzdrr.CLIENT_SIGNALS_END.zza(), currentTimeMillis2);
                        bundle4.putBundle("client_sig_latency_key", bundle5);
                        return obj2;
                    }
                    bundle4.putLong(zzdrr.GMS_SIGNALS_END.zza(), currentTimeMillis2);
                    bundle4.putBundle("gms_sig_latency_key", bundle5);
                }
                return obj2;
            }
        }, this.zzc);
        if (zzfhx.zza()) {
            zzfht.zza(zza2, this.zzd, zza);
        }
        return zza2;
    }
}
