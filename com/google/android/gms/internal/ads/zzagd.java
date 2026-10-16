package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzagd extends zzagf {
    private long zzb;
    private long[] zzc;
    private long[] zzd;

    public zzagd() {
        super(new zzadr());
        this.zzb = -9223372036854775807L;
        this.zzc = new long[0];
        this.zzd = new long[0];
    }

    private static Double zzg(zzen zzenVar) {
        return Double.valueOf(Double.longBitsToDouble(zzenVar.zzt()));
    }

    private static String zzi(zzen zzenVar) {
        int zzq = zzenVar.zzq();
        int zzc = zzenVar.zzc();
        zzenVar.zzM(zzq);
        return new String(zzenVar.zzN(), zzc, zzq);
    }

    private static HashMap zzj(zzen zzenVar) {
        int zzp = zzenVar.zzp();
        HashMap hashMap = new HashMap(zzp);
        for (int i = 0; i < zzp; i++) {
            String zzi = zzi(zzenVar);
            Object zzh = zzh(zzenVar, zzenVar.zzm());
            if (zzh != null) {
                hashMap.put(zzi, zzh);
            }
        }
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzagf
    protected final boolean zza(zzen zzenVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzagf
    protected final boolean zzb(zzen zzenVar, long j) {
        if (zzenVar.zzm() == 2 && "onMetaData".equals(zzi(zzenVar)) && zzenVar.zza() != 0 && zzenVar.zzm() == 8) {
            HashMap zzj = zzj(zzenVar);
            Object obj = zzj.get("duration");
            if (obj instanceof Double) {
                double doubleValue = ((Double) obj).doubleValue();
                if (doubleValue > 0.0d) {
                    this.zzb = (long) (doubleValue * 1000000.0d);
                }
            }
            Object obj2 = zzj.get("keyframes");
            if (obj2 instanceof Map) {
                Map map = (Map) obj2;
                Object obj3 = map.get("filepositions");
                Object obj4 = map.get("times");
                if ((obj3 instanceof List) && (obj4 instanceof List)) {
                    List list = (List) obj3;
                    List list2 = (List) obj4;
                    int size = list2.size();
                    this.zzc = new long[size];
                    this.zzd = new long[size];
                    for (int i = 0; i < size; i++) {
                        Object obj5 = list.get(i);
                        Object obj6 = list2.get(i);
                        if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                            this.zzc = new long[0];
                            this.zzd = new long[0];
                            break;
                        }
                        this.zzc[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                        this.zzd[i] = ((Double) obj5).longValue();
                    }
                }
            }
        }
        return false;
    }

    public final long zzc() {
        return this.zzb;
    }

    public final long[] zzd() {
        return this.zzd;
    }

    public final long[] zze() {
        return this.zzc;
    }

    private static Object zzh(zzen zzenVar, int i) {
        if (i == 0) {
            return zzg(zzenVar);
        }
        if (i == 1) {
            return Boolean.valueOf(zzenVar.zzm() == 1);
        }
        if (i == 2) {
            return zzi(zzenVar);
        }
        if (i != 3) {
            if (i == 8) {
                return zzj(zzenVar);
            }
            if (i != 10) {
                if (i != 11) {
                    return null;
                }
                Date date = new Date((long) zzg(zzenVar).doubleValue());
                zzenVar.zzM(2);
                return date;
            }
            int zzp = zzenVar.zzp();
            ArrayList arrayList = new ArrayList(zzp);
            for (int i2 = 0; i2 < zzp; i2++) {
                Object zzh = zzh(zzenVar, zzenVar.zzm());
                if (zzh != null) {
                    arrayList.add(zzh);
                }
            }
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        while (true) {
            String zzi = zzi(zzenVar);
            int zzm = zzenVar.zzm();
            if (zzm == 9) {
                return hashMap;
            }
            Object zzh2 = zzh(zzenVar, zzm);
            if (zzh2 != null) {
                hashMap.put(zzi, zzh2);
            }
        }
    }
}
