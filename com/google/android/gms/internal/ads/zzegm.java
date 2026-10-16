package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzegm {
    private final zzgeh zzc;
    private zzehc zzf;
    private final String zzh;
    private final int zzi;
    private final zzehb zzj;
    private zzfca zzk;
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final List zzd = new ArrayList();
    private final Set zze = new HashSet();
    private int zzg = Integer.MAX_VALUE;
    private boolean zzl = false;

    zzegm(zzfcn zzfcnVar, zzehb zzehbVar, zzgeh zzgehVar) {
        this.zzi = zzfcnVar.zzb.zzb.zzr;
        this.zzj = zzehbVar;
        this.zzc = zzgehVar;
        this.zzh = zzehi.zzc(zzfcnVar);
        List list = zzfcnVar.zzb.zza;
        for (int i = 0; i < list.size(); i++) {
            this.zza.put((zzfca) list.get(i), Integer.valueOf(i));
        }
        this.zzb.addAll(list);
    }

    private final synchronized void zze() {
        this.zzj.zzi(this.zzk);
        zzehc zzehcVar = this.zzf;
        if (zzehcVar != null) {
            this.zzc.zzc(zzehcVar);
        } else {
            this.zzc.zzd(new zzehf(3, this.zzh));
        }
    }

    private final synchronized boolean zzf(boolean z) {
        for (zzfca zzfcaVar : this.zzb) {
            Integer num = (Integer) this.zza.get(zzfcaVar);
            Integer valueOf = Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE);
            if (z || !this.zze.contains(zzfcaVar.zzat)) {
                if (valueOf.intValue() < this.zzg) {
                    return true;
                }
                if (valueOf.intValue() > this.zzg) {
                    break;
                }
            }
        }
        return false;
    }

    private final synchronized boolean zzg() {
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) this.zza.get((zzfca) it.next());
            if (Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE).intValue() < this.zzg) {
                return true;
            }
        }
        return false;
    }

    private final synchronized boolean zzh() {
        if (!zzf(true)) {
            if (!zzg()) {
                return false;
            }
        }
        return true;
    }

    private final synchronized boolean zzi() {
        if (this.zzl) {
            return false;
        }
        List list = this.zzb;
        if (!list.isEmpty() && ((zzfca) list.get(0)).zzav && !this.zzd.isEmpty()) {
            return false;
        }
        if (!zzd()) {
            List list2 = this.zzd;
            if (list2.size() < this.zzi) {
                if (zzf(false)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        if (r2.zzav == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        r6.zzl = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        r4.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        r6.zzd.add(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        return (com.google.android.gms.internal.ads.zzfca) r1.remove(r0);
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final synchronized zzfca zza() {
        if (zzi()) {
            int i = 0;
            while (true) {
                List list = this.zzb;
                if (i >= list.size()) {
                    break;
                }
                zzfca zzfcaVar = (zzfca) list.get(i);
                String str = zzfcaVar.zzat;
                Set set = this.zze;
                if (!set.contains(str)) {
                    break;
                }
                i++;
            }
        }
        return null;
    }

    final synchronized void zzb(Throwable th, zzfca zzfcaVar) {
        this.zzl = false;
        this.zzd.remove(zzfcaVar);
        this.zze.remove(zzfcaVar.zzat);
        if (zzd() || zzh()) {
            return;
        }
        zze();
    }

    final synchronized void zzc(zzehc zzehcVar, zzfca zzfcaVar) {
        this.zzl = false;
        this.zzd.remove(zzfcaVar);
        if (zzd()) {
            zzehcVar.zzr();
            return;
        }
        Integer num = (Integer) this.zza.get(zzfcaVar);
        Integer valueOf = Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE);
        if (valueOf.intValue() > this.zzg) {
            this.zzj.zzm(zzfcaVar);
            return;
        }
        if (this.zzf != null) {
            this.zzj.zzm(this.zzk);
        }
        this.zzg = valueOf.intValue();
        this.zzf = zzehcVar;
        this.zzk = zzfcaVar;
        if (zzh()) {
            return;
        }
        zze();
    }

    final synchronized boolean zzd() {
        return this.zzc.isDone();
    }
}
