package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfkp {
    private final ConcurrentMap zza = new ConcurrentHashMap();
    private final ConcurrentMap zzb = new ConcurrentHashMap();
    private final zzfle zzc;
    private final zzfkl zzd;
    private final Context zze;
    private volatile ConnectivityManager zzf;
    private final Clock zzg;
    private AtomicInteger zzh;

    zzfkp(zzfle zzfleVar, zzfkl zzfklVar, Context context, Clock clock) {
        this.zzc = zzfleVar;
        this.zzd = zzfklVar;
        this.zze = context;
        this.zzg = clock;
    }

    static String zzd(String str, AdFormat adFormat) {
        return str + "#" + (adFormat == null ? "NULL" : adFormat.name());
    }

    private final synchronized zzfld zzm(String str, AdFormat adFormat) {
        return (zzfld) this.zza.get(zzd(str, adFormat));
    }

    private final synchronized Object zzn(Class cls, String str, AdFormat adFormat) {
        zzfkt zzfktVar = new zzfkt(new zzfkr(str, adFormat), null);
        zzfkl zzfklVar = this.zzd;
        Clock clock = this.zzg;
        zzfklVar.zzl(clock.currentTimeMillis(), zzfktVar, -1, -1, "1");
        zzfld zzm = zzm(str, adFormat);
        if (zzm == null) {
            return null;
        }
        try {
            String zzo = zzm.zzo();
            Object zzk = zzm.zzk();
            Object cast = zzk == null ? null : cls.cast(zzk);
            if (cast != null) {
                zzfklVar.zzm(clock.currentTimeMillis(), zzm.zze.zzd, zzm.zzd(), zzo, zzfktVar, "1");
            }
            return cast;
        } catch (ClassCastException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "PreloadAdManager.pollAd");
            com.google.android.gms.ads.internal.util.zze.zzb("Unable to cast ad to the requested type:".concat(String.valueOf(cls.getName())), e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f3, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzz)).booleanValue() != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final synchronized List zzo(List list) {
        ArrayList arrayList;
        HashSet hashSet = new HashSet();
        arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.ads.internal.client.zzfv zzfvVar = (com.google.android.gms.ads.internal.client.zzfv) it.next();
            String zzd = zzd(zzfvVar.zza, AdFormat.getAdFormat(zzfvVar.zzb));
            hashSet.add(zzd);
            ConcurrentMap concurrentMap = this.zza;
            zzfld zzfldVar = (zzfld) concurrentMap.get(zzd);
            if (zzfldVar == null) {
                ConcurrentMap concurrentMap2 = this.zzb;
                if (concurrentMap2.containsKey(zzd)) {
                    zzfld zzfldVar2 = (zzfld) concurrentMap2.get(zzd);
                    if (zzfldVar2.zze.equals(zzfvVar)) {
                        zzfldVar2.zzB(zzfvVar.zzd);
                        zzfldVar2.zzy();
                        concurrentMap.put(zzd, zzfldVar2);
                        concurrentMap2.remove(zzd);
                    } else {
                        arrayList.add(zzfvVar);
                    }
                } else {
                    arrayList.add(zzfvVar);
                }
            } else if (zzfldVar.zze.equals(zzfvVar)) {
                zzfldVar.zzB(zzfvVar.zzd);
            } else {
                this.zzb.put(zzd, zzfldVar);
                concurrentMap.remove(zzd);
                arrayList.add(zzfvVar);
            }
        }
        Iterator it2 = this.zza.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            if (!hashSet.contains((String) entry.getKey())) {
                this.zzb.put((String) entry.getKey(), (zzfld) entry.getValue());
                it2.remove();
            }
        }
        Iterator it3 = this.zzb.entrySet().iterator();
        while (it3.hasNext()) {
            zzfld zzfldVar3 = (zzfld) ((Map.Entry) it3.next()).getValue();
            zzfldVar3.zzA();
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzy)).booleanValue()) {
            }
            zzfldVar3.zzv();
            if (!zzfldVar3.zzC()) {
                it3.remove();
            }
        }
        return arrayList;
    }

    private final synchronized void zzp(String str, zzfld zzfldVar) {
        zzfldVar.zzh();
        this.zza.put(str, zzfldVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzq(boolean z) {
        if (z) {
            Iterator it = this.zza.values().iterator();
            while (it.hasNext()) {
                ((zzfld) it.next()).zzy();
            }
        } else {
            Iterator it2 = this.zza.values().iterator();
            while (it2.hasNext()) {
                ((zzfld) it2.next()).zzf.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzr(boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzw)).booleanValue()) {
            zzq(z);
        }
    }

    private final synchronized boolean zzs(String str, AdFormat adFormat) {
        boolean z;
        Clock clock = this.zzg;
        long currentTimeMillis = clock.currentTimeMillis();
        zzfld zzm = zzm(str, adFormat);
        int i = 0;
        z = zzm != null && zzm.zzC();
        Long valueOf = z ? Long.valueOf(clock.currentTimeMillis()) : null;
        zzfkt zzfktVar = new zzfkt(new zzfkr(str, adFormat), null);
        zzfkl zzfklVar = this.zzd;
        int i2 = zzm == null ? 0 : zzm.zze.zzd;
        if (zzm != null) {
            i = zzm.zzd();
        }
        zzfklVar.zzh(i2, i, currentTimeMillis, valueOf, zzm != null ? zzm.zzo() : null, zzfktVar, "1");
        return z;
    }

    public final synchronized zzbaw zza(String str) {
        return (zzbaw) zzn(zzbaw.class, str, AdFormat.APP_OPEN_AD);
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzbx zzb(String str) {
        return (com.google.android.gms.ads.internal.client.zzbx) zzn(com.google.android.gms.ads.internal.client.zzbx.class, str, AdFormat.INTERSTITIAL);
    }

    public final synchronized zzbwv zzc(String str) {
        return (zzbwv) zzn(zzbwv.class, str, AdFormat.REWARDED);
    }

    public final void zzg(zzbpq zzbpqVar) {
        this.zzc.zzc(zzbpqVar);
    }

    public final synchronized void zzh(List list, com.google.android.gms.ads.internal.client.zzce zzceVar) {
        List<com.google.android.gms.ads.internal.client.zzfv> zzo = zzo(list);
        EnumMap enumMap = new EnumMap(AdFormat.class);
        for (com.google.android.gms.ads.internal.client.zzfv zzfvVar : zzo) {
            String str = zzfvVar.zza;
            AdFormat adFormat = AdFormat.getAdFormat(zzfvVar.zzb);
            zzfld zza = this.zzc.zza(zzfvVar, zzceVar);
            if (adFormat != null && zza != null) {
                AtomicInteger atomicInteger = this.zzh;
                if (atomicInteger != null) {
                    zza.zzx(atomicInteger.get());
                }
                zzfkl zzfklVar = this.zzd;
                zza.zzz(zzfklVar);
                zzp(zzd(str, adFormat), zza);
                enumMap.put((EnumMap) adFormat, (AdFormat) Integer.valueOf(((Integer) com.google.android.gms.ads.internal.util.client.zzf.zzi(enumMap, adFormat, 0)).intValue() + 1));
                zzfklVar.zzp(zzfvVar.zzd, this.zzg.currentTimeMillis(), new zzfkt(new zzfkr(str, adFormat), null), "1");
            }
        }
        this.zzd.zzo(enumMap, this.zzg.currentTimeMillis(), "1");
    }

    public final void zzi() {
        if (this.zzf == null) {
            synchronized (this) {
                if (this.zzf == null) {
                    try {
                        this.zzf = (ConnectivityManager) this.zze.getSystemService("connectivity");
                    } catch (ClassCastException e) {
                        int i = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to get connectivity manager", e);
                    }
                }
            }
        }
        if (!PlatformVersion.isAtLeastO() || this.zzf == null) {
            this.zzh = new AtomicInteger(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzD)).intValue());
        } else {
            try {
                this.zzf.registerDefaultNetworkCallback(new zzfko(this));
            } catch (RuntimeException e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to register network callback", e2);
                this.zzh = new AtomicInteger(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzD)).intValue());
            }
        }
        com.google.android.gms.ads.internal.zzv.zzb().zzc(new zzfkn(this));
    }

    public final synchronized boolean zzj(String str) {
        return zzs(str, AdFormat.APP_OPEN_AD);
    }

    public final synchronized boolean zzk(String str) {
        return zzs(str, AdFormat.INTERSTITIAL);
    }

    public final synchronized boolean zzl(String str) {
        return zzs(str, AdFormat.REWARDED);
    }
}
