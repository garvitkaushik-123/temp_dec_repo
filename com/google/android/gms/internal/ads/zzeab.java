package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.IOUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeab extends zzbvd {
    private final Context zza;
    private final zzgdy zzb;
    private final zzeaj zzc;
    private final zzcld zzd;
    private final ArrayDeque zze;
    private final zzfhx zzf;
    private final zzbvy zzg;

    public zzeab(Context context, zzgdy zzgdyVar, zzbvy zzbvyVar, zzcld zzcldVar, zzeaj zzeajVar, ArrayDeque arrayDeque, zzeag zzeagVar, zzfhx zzfhxVar) {
        zzbde.zza(context);
        this.zza = context;
        this.zzb = zzgdyVar;
        this.zzg = zzbvyVar;
        this.zzc = zzeajVar;
        this.zzd = zzcldVar;
        this.zze = arrayDeque;
        this.zzf = zzfhxVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InputStream zzk(zzeab zzeabVar, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzbvq zzbvqVar, zzfhj zzfhjVar) {
        String zze = ((zzbvs) listenableFuture.get()).zze();
        zzeabVar.zzo(new zzdzy((zzbvs) listenableFuture.get(), (JSONObject) listenableFuture2.get(), zzbvqVar.zzh, zze, zzfhjVar));
        return new ByteArrayInputStream(zze.getBytes(StandardCharsets.UTF_8));
    }

    private final synchronized zzdzy zzl(String str) {
        Iterator it = this.zze.iterator();
        while (it.hasNext()) {
            zzdzy zzdzyVar = (zzdzy) it.next();
            if (zzdzyVar.zzc.equals(str)) {
                it.remove();
                return zzdzyVar;
            }
        }
        return null;
    }

    private static ListenableFuture zzm(ListenableFuture listenableFuture, zzfha zzfhaVar, zzbow zzbowVar, zzfhu zzfhuVar, zzfhj zzfhjVar) {
        zzbom zza = zzbowVar.zza("AFMA_getAdDictionary", zzbot.zza, new zzboo() { // from class: com.google.android.gms.internal.ads.zzdzs
            @Override // com.google.android.gms.internal.ads.zzboo
            public final Object zza(JSONObject jSONObject) {
                return new zzbvs(jSONObject);
            }
        });
        zzfht.zzd(listenableFuture, zzfhjVar);
        zzfgg zza2 = zzfhaVar.zzb(zzfgu.BUILD_URL, listenableFuture).zzf(zza).zza();
        zzfht.zzc(zza2, zzfhuVar, zzfhjVar);
        return zza2;
    }

    private static ListenableFuture zzn(final zzbvq zzbvqVar, zzfha zzfhaVar, final zzevf zzevfVar) {
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdzm
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzevf.this.zzb().zza(com.google.android.gms.ads.internal.client.zzbb.zzb().zzn((Bundle) obj), zzbvqVar.zzm, false);
            }
        };
        return zzfhaVar.zzb(zzfgu.GMS_SIGNALS, zzgdn.zzh(zzbvqVar.zza)).zzf(zzgcuVar).zze(new zzfge() { // from class: com.google.android.gms.internal.ads.zzdzn
            @Override // com.google.android.gms.internal.ads.zzfge
            public final Object zza(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                com.google.android.gms.ads.internal.util.zze.zza("Ad request signals:");
                com.google.android.gms.ads.internal.util.zze.zza(jSONObject.toString(2));
                return jSONObject;
            }
        }).zza();
    }

    private final synchronized void zzo(zzdzy zzdzyVar) {
        zzp();
        this.zze.addLast(zzdzyVar);
    }

    private final synchronized void zzp() {
        int intValue = ((Long) zzbfl.zzb.zze()).intValue();
        while (true) {
            ArrayDeque arrayDeque = this.zze;
            if (arrayDeque.size() >= intValue) {
                arrayDeque.removeFirst();
            }
        }
    }

    private final void zzq(ListenableFuture listenableFuture, zzbvi zzbviVar, zzbvq zzbvqVar) {
        zzgdn.zzr(zzgdn.zzn(listenableFuture, new zzgcu(this) { // from class: com.google.android.gms.internal.ads.zzdzt
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                final InputStream inputStream = (InputStream) obj;
                ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
                final ParcelFileDescriptor parcelFileDescriptor2 = createPipe[1];
                zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfdw
                    @Override // java.lang.Runnable
                    public final void run() {
                        InputStream inputStream2 = inputStream;
                        try {
                            try {
                                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor2);
                                try {
                                    IOUtils.copyStream(inputStream2, autoCloseOutputStream);
                                    autoCloseOutputStream.close();
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                } finally {
                                }
                            } finally {
                            }
                        } catch (IOException unused) {
                        }
                    }
                });
                return zzgdn.zzh(parcelFileDescriptor);
            }
        }, zzcaf.zza), new zzdzx(this, zzbvqVar, zzbviVar), zzcaf.zzg);
    }

    public final ListenableFuture zzb(final zzbvq zzbvqVar, int i) {
        if (!((Boolean) zzbfl.zza.zze()).booleanValue()) {
            return zzgdn.zzg(new Exception("Split request is disabled."));
        }
        zzfeq zzfeqVar = zzbvqVar.zzi;
        if (zzfeqVar == null) {
            return zzgdn.zzg(new Exception("Pool configuration missing from request."));
        }
        if (zzfeqVar.zzc == 0 || zzfeqVar.zzd == 0) {
            return zzgdn.zzg(new Exception("Caching is disabled."));
        }
        Context context = this.zza;
        zzbow zzb = com.google.android.gms.ads.internal.zzv.zzg().zzb(context, VersionInfoParcel.forPackage(), this.zzf);
        zzevf zzq = this.zzd.zzq(zzbvqVar, i);
        zzfha zze = zzq.zze();
        final ListenableFuture zzn = zzn(zzbvqVar, zze, zzq);
        zzfhu zzf = zzq.zzf();
        final zzfhj zza = zzfhi.zza(context, 9);
        final ListenableFuture zzm = zzm(zzn, zze, zzb, zzf, zza);
        return zze.zza(zzfgu.GET_URL_AND_CACHE_KEY, zzn, zzm).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdzq
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeab.zzk(zzeab.this, zzm, zzn, zzbvqVar, zza);
            }
        }).zza();
    }

    public final ListenableFuture zzc(final zzbvq zzbvqVar, int i) {
        zzdzy zzl;
        zzfgg zza;
        zzbon zzg = com.google.android.gms.ads.internal.zzv.zzg();
        Context context = this.zza;
        zzbow zzb = zzg.zzb(context, VersionInfoParcel.forPackage(), this.zzf);
        zzevf zzq = this.zzd.zzq(zzbvqVar, i);
        zzbom zza2 = zzb.zza("google.afma.response.normalize", zzeaa.zza, zzbot.zzb);
        if (((Boolean) zzbfl.zza.zze()).booleanValue()) {
            zzl = zzl(zzbvqVar.zzh);
            if (zzl == null) {
                com.google.android.gms.ads.internal.util.zze.zza("Request contained a PoolKey but no matching parameters were found.");
            }
        } else {
            String str = zzbvqVar.zzj;
            zzl = null;
            if (str != null && !str.isEmpty()) {
                com.google.android.gms.ads.internal.util.zze.zza("Request contained a PoolKey but split request is disabled.");
            }
        }
        zzfhj zza3 = zzl == null ? zzfhi.zza(context, 9) : zzl.zzd;
        zzfhu zzf = zzq.zzf();
        zzf.zzd(zzbvqVar.zza.getStringArrayList("ad_types"));
        zzeai zzeaiVar = new zzeai(zzbvqVar.zzg, zzf, zza3);
        zzeaf zzeafVar = new zzeaf(context, zzbvqVar.zzb.afmaVersion, this.zzg, i);
        zzfha zze = zzq.zze();
        zzfhj zza4 = zzfhi.zza(context, 11);
        if (zzl == null) {
            final ListenableFuture zzn = zzn(zzbvqVar, zze, zzq);
            final ListenableFuture zzm = zzm(zzn, zze, zzb, zzf, zza3);
            zzfhj zza5 = zzfhi.zza(context, 10);
            final zzfgg zza6 = zze.zza(zzfgu.HTTP, zzm, zzn).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdzo
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Bundle bundle;
                    zzbvs zzbvsVar = (zzbvs) ListenableFuture.this.get();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcq)).booleanValue() && (bundle = zzbvqVar.zzm) != null) {
                        bundle.putLong(zzdrr.GET_AD_DICTIONARY_SDKCORE_START.zza(), zzbvsVar.zzc());
                        bundle.putLong(zzdrr.GET_AD_DICTIONARY_SDKCORE_END.zza(), zzbvsVar.zzb());
                    }
                    return new zzeah((JSONObject) zzn.get(), zzbvsVar);
                }
            }).zze(zzeaiVar).zze(new zzfhp(zza5)).zze(zzeafVar).zza();
            zzfht.zza(zza6, zzf, zza5);
            zzfht.zzd(zza6, zza4);
            zza = zze.zza(zzfgu.PRE_PROCESS, zzn, zzm, zza6).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdzp
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Bundle bundle;
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcq)).booleanValue() && (bundle = zzbvq.this.zzm) != null) {
                        bundle.putLong(zzdrr.HTTP_RESPONSE_READY.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
                    }
                    return new zzeaa((zzeae) zza6.get(), (JSONObject) zzn.get(), (zzbvs) zzm.get());
                }
            }).zzf(zza2).zza();
        } else {
            zzeah zzeahVar = new zzeah(zzl.zzb, zzl.zza);
            zzfhj zza7 = zzfhi.zza(context, 10);
            final zzfgg zza8 = zze.zzb(zzfgu.HTTP, zzgdn.zzh(zzeahVar)).zze(zzeaiVar).zze(new zzfhp(zza7)).zze(zzeafVar).zza();
            zzfht.zza(zza8, zzf, zza7);
            final ListenableFuture zzh = zzgdn.zzh(zzl);
            zzfht.zzd(zza8, zza4);
            zza = zze.zza(zzfgu.PRE_PROCESS, zza8, zzh).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdzl
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzeae zzeaeVar = (zzeae) ListenableFuture.this.get();
                    ListenableFuture listenableFuture = zzh;
                    return new zzeaa(zzeaeVar, ((zzdzy) listenableFuture.get()).zzb, ((zzdzy) listenableFuture.get()).zza);
                }
            }).zzf(zza2).zza();
        }
        zzfht.zza(zza, zzf, zza4);
        return zza;
    }

    public final ListenableFuture zzd(final zzbvq zzbvqVar, int i) {
        zzbon zzg = com.google.android.gms.ads.internal.zzv.zzg();
        Context context = this.zza;
        zzbow zzb = zzg.zzb(context, VersionInfoParcel.forPackage(), this.zzf);
        if (!((Boolean) zzbfq.zza.zze()).booleanValue()) {
            return zzgdn.zzg(new Exception("Signal collection disabled."));
        }
        zzevf zzq = this.zzd.zzq(zzbvqVar, i);
        final zzeuf zza = zzq.zza();
        zzbom zza2 = zzb.zza("google.afma.request.getSignals", zzbot.zza, zzbot.zzb);
        zzfhj zza3 = zzfhi.zza(context, 22);
        zzfha zze = zzq.zze();
        zzfgu zzfguVar = zzfgu.GET_SIGNALS;
        Bundle bundle = zzbvqVar.zza;
        zzfgg zza4 = zze.zzb(zzfguVar, zzgdn.zzh(bundle)).zze(new zzfhp(zza3)).zzf(new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdzu
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzeuf.this.zza(com.google.android.gms.ads.internal.client.zzbb.zzb().zzn((Bundle) obj), zzbvqVar.zzm, false);
            }
        }).zzb(zzfgu.JS_SIGNALS).zzf(zza2).zza();
        zzfhu zzf = zzq.zzf();
        zzf.zzd(bundle.getStringArrayList("ad_types"));
        zzf.zzf(bundle.getBundle("extras"));
        zzfht.zzb(zza4, zzf, zza3);
        if (((Boolean) zzbfe.zzf.zze()).booleanValue()) {
            zzeaj zzeajVar = this.zzc;
            Objects.requireNonNull(zzeajVar);
            zza4.addListener(new zzdzr(zzeajVar), this.zzb);
        }
        return zza4;
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zze(zzbvq zzbvqVar, zzbvi zzbviVar) {
        zzq(zzb(zzbvqVar, Binder.getCallingUid()), zzbviVar, zzbvqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zzf(zzbvq zzbvqVar, zzbvi zzbviVar) {
        Bundle bundle;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcq)).booleanValue() && (bundle = zzbvqVar.zzm) != null) {
            bundle.putLong(zzdrr.SERVICE_CONNECTED.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        zzq(zzd(zzbvqVar, Binder.getCallingUid()), zzbviVar, zzbvqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zzg(zzbvq zzbvqVar, zzbvi zzbviVar) {
        Bundle bundle;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcq)).booleanValue() && (bundle = zzbvqVar.zzm) != null) {
            bundle.putLong(zzdrr.SERVICE_CONNECTED.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        ListenableFuture zzc = zzc(zzbvqVar, Binder.getCallingUid());
        zzq(zzc, zzbviVar, zzbvqVar);
        if (((Boolean) zzbfe.zze.zze()).booleanValue()) {
            zzeaj zzeajVar = this.zzc;
            Objects.requireNonNull(zzeajVar);
            zzc.addListener(new zzdzr(zzeajVar), this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zzh(String str, zzbvi zzbviVar) {
        zzq(zzj(str), zzbviVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zzi(zzbva zzbvaVar, zzbvj zzbvjVar) {
        if (((Boolean) zzbfs.zza.zze()).booleanValue()) {
            this.zzd.zzD();
            String str = zzbvaVar.zza;
            zzgdn.zzr(zzgdn.zzh(null), new zzdzv(this, zzbvjVar, zzbvaVar), zzcaf.zzg);
        } else {
            try {
                zzbvjVar.zzf("", zzbvaVar);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.zze.zzb("Service can't call client", e);
            }
        }
    }

    public final ListenableFuture zzj(String str) {
        if (((Boolean) zzbfl.zza.zze()).booleanValue()) {
            return zzl(str) == null ? zzgdn.zzg(new Exception("URL to be removed not found for cache key: ".concat(String.valueOf(str)))) : zzgdn.zzh(new zzdzw(this));
        }
        return zzgdn.zzg(new Exception("Split request is disabled."));
    }
}
