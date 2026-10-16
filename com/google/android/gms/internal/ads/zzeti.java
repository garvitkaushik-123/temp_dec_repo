package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeti implements zzeuc {
    public static final /* synthetic */ int zzb = 0;
    private static final zzetj zzc = new zzetj(new JSONArray().toString(), new Bundle());
    final String zza;
    private final zzgdy zzd;
    private final ScheduledExecutorService zze;
    private final zzeju zzf;
    private final Context zzg;
    private final zzfcw zzh;
    private final zzejq zzi;
    private final zzdpz zzj;
    private final zzdup zzk;
    private final int zzl;

    zzeti(zzgdy zzgdyVar, ScheduledExecutorService scheduledExecutorService, String str, zzeju zzejuVar, Context context, zzfcw zzfcwVar, zzejq zzejqVar, zzdpz zzdpzVar, zzdup zzdupVar, int i) {
        this.zzd = zzgdyVar;
        this.zze = scheduledExecutorService;
        this.zza = str;
        this.zzf = zzejuVar;
        this.zzg = context;
        this.zzh = zzfcwVar;
        this.zzi = zzejqVar;
        this.zzj = zzdpzVar;
        this.zzk = zzdupVar;
        this.zzl = i;
    }

    public static /* synthetic */ ListenableFuture zzc(zzeti zzetiVar) {
        zzeti zzetiVar2;
        String lowerCase = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlq)).booleanValue() ? zzetiVar.zzh.zzf.toLowerCase(Locale.ROOT) : zzetiVar.zzh.zzf;
        final Bundle zzg = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbP)).booleanValue() ? zzetiVar.zzk.zzg() : new Bundle();
        final ArrayList arrayList = new ArrayList();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbY)).booleanValue()) {
            zzetiVar2 = zzetiVar;
            zzetiVar2.zzi(arrayList, zzetiVar2.zzf.zza(zzetiVar2.zza, lowerCase));
        } else {
            zzeju zzejuVar = zzetiVar.zzf;
            for (Map.Entry entry : ((zzfyt) zzejuVar.zzb(zzetiVar.zza, lowerCase)).entrySet()) {
                String str = (String) entry.getKey();
                zzeti zzetiVar3 = zzetiVar;
                arrayList.add(zzetiVar3.zzg(str, (List) entry.getValue(), zzetiVar.zzf(str), true, true));
                zzetiVar = zzetiVar3;
            }
            zzetiVar2 = zzetiVar;
            zzetiVar2.zzi(arrayList, zzejuVar.zzc());
        }
        return zzgdn.zzb(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzetd
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                int i = zzeti.zzb;
                JSONArray jSONArray = new JSONArray();
                for (ListenableFuture listenableFuture : arrayList) {
                    if (((JSONObject) listenableFuture.get()) != null) {
                        jSONArray.put(listenableFuture.get());
                    }
                }
                if (jSONArray.length() == 0) {
                    return null;
                }
                return new zzetj(jSONArray.toString(), zzg);
            }
        }, zzetiVar2.zzd);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:0|1|(2:3|(3:5|6|(2:8|(2:10|11)(1:13))(3:14|(1:16)|(2:18|(2:20|21)(2:22|23))(2:24|25))))|26|27|6|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x002c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x002d, code lost:
    
        com.google.android.gms.ads.internal.util.zze.zzb("Couldn't create RTB adapter : ", r0);
        r2 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ ListenableFuture zzd(final zzeti zzetiVar, String str, final List list, final Bundle bundle, boolean z, boolean z2) {
        final zzbrp zzbrpVar;
        zzbrp zzb2;
        final zzcak zzcakVar = new zzcak();
        if (z2) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbQ)).booleanValue()) {
                zzejq zzejqVar = zzetiVar.zzi;
                zzejqVar.zzb(str);
                zzb2 = zzejqVar.zza(str);
                zzbrpVar = zzb2;
                if (zzbrpVar != null) {
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbG)).booleanValue()) {
                        throw null;
                    }
                    zzejx.zzb(str, zzcakVar);
                    return zzcakVar;
                }
                final zzejx zzejxVar = new zzejx(str, zzbrpVar, zzcakVar, com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime());
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbL)).booleanValue()) {
                    ScheduledExecutorService scheduledExecutorService = zzetiVar.zze;
                    Objects.requireNonNull(zzejxVar);
                    scheduledExecutorService.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeth
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzejx.this.zzc();
                        }
                    }, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbE)).longValue(), TimeUnit.MILLISECONDS);
                }
                if (!z) {
                    zzejxVar.zzd();
                    return zzcakVar;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbS)).booleanValue()) {
                    zzetiVar.zzd.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzete
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzeti.zze(zzeti.this, zzbrpVar, bundle, list, zzejxVar, zzcakVar);
                        }
                    });
                    return zzcakVar;
                }
                zzetiVar.zzh(zzbrpVar, bundle, list, zzejxVar);
                return zzcakVar;
            }
        }
        zzb2 = zzetiVar.zzj.zzb(str);
        zzbrpVar = zzb2;
        if (zzbrpVar != null) {
        }
    }

    public static /* synthetic */ void zze(zzeti zzetiVar, zzbrp zzbrpVar, Bundle bundle, List list, zzejx zzejxVar, zzcak zzcakVar) {
        try {
            zzetiVar.zzh(zzbrpVar, bundle, list, zzejxVar);
        } catch (RemoteException e) {
            zzcakVar.zzd(e);
        }
    }

    private final Bundle zzf(String str) {
        Bundle bundle = this.zzh.zzd.zzm;
        if (bundle != null) {
            return bundle.getBundle(str);
        }
        return null;
    }

    private final zzgde zzg(final String str, final List list, final Bundle bundle, final boolean z, final boolean z2) {
        zzgct zzgctVar = new zzgct() { // from class: com.google.android.gms.internal.ads.zzetf
            @Override // com.google.android.gms.internal.ads.zzgct
            public final ListenableFuture zza() {
                return zzeti.zzd(zzeti.this, str, list, bundle, z, z2);
            }
        };
        zzgdy zzgdyVar = this.zzd;
        zzgde zzw = zzgde.zzw(zzgdn.zzk(zzgctVar, zzgdyVar));
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbL)).booleanValue()) {
            zzw = (zzgde) zzgdn.zzo(zzw, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbE)).longValue(), TimeUnit.MILLISECONDS, this.zze);
        }
        return (zzgde) zzgdn.zze(zzw, Throwable.class, new zzfve() { // from class: com.google.android.gms.internal.ads.zzetg
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                int i = zzeti.zzb;
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                String str2 = str;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Error calling adapter: ".concat(String.valueOf(str2)));
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznu)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzv.zzp().zzv(th, "rtbSignal.fetchRtbJsonInfo-".concat(String.valueOf(str2)));
                    return null;
                }
                com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "rtbSignal.fetchRtbJsonInfo-".concat(String.valueOf(str2)));
                return null;
            }
        }, zzgdyVar);
    }

    private final void zzh(zzbrp zzbrpVar, Bundle bundle, List list, zzejx zzejxVar) throws RemoteException {
        zzbrpVar.zzh(ObjectWrapper.wrap(this.zzg), this.zza, bundle, (Bundle) list.get(0), this.zzh.zze, zzejxVar);
    }

    private final void zzi(List list, Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            zzejy zzejyVar = (zzejy) ((Map.Entry) it.next()).getValue();
            String str = zzejyVar.zza;
            list.add(zzg(str, Collections.singletonList(zzejyVar.zze), zzf(str), zzejyVar.zzb, zzejyVar.zzc));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 32;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        if (this.zzl == 2) {
            return zzgdn.zzh(zzc);
        }
        zzfcw zzfcwVar = this.zzh;
        if (zzfcwVar.zzr) {
            if (!Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbR)).split(",")).contains(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzc(zzfcwVar.zzd)))) {
                return zzgdn.zzh(zzc);
            }
        }
        return zzgdn.zzk(new zzgct() { // from class: com.google.android.gms.internal.ads.zzetc
            @Override // com.google.android.gms.internal.ads.zzgct
            public final ListenableFuture zza() {
                return zzeti.zzc(zzeti.this);
            }
        }, this.zzd);
    }
}
