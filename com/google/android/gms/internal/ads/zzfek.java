package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzbcj;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfek implements zzfej {
    private final ConcurrentHashMap zza;
    private final zzfeq zzb;
    private final zzfem zzc = new zzfem();

    public zzfek(zzfeq zzfeqVar) {
        this.zza = new ConcurrentHashMap(zzfeqVar.zzd);
        this.zzb = zzfeqVar;
    }

    private final void zzf() {
        Parcelable.Creator<zzfeq> creator = zzfeq.CREATOR;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgB)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            zzfeq zzfeqVar = this.zzb;
            sb.append(zzfeqVar.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzb());
            int i = 0;
            for (Map.Entry entry : this.zza.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(((zzfet) entry.getKey()).hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < ((zzfei) entry.getValue()).zzb(); i2++) {
                    sb.append("[O]");
                }
                for (int zzb = ((zzfei) entry.getValue()).zzb(); zzb < zzfeqVar.zzd; zzb++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzfei) entry.getValue()).zzg());
                sb.append("\n");
            }
            while (i < zzfeqVar.zzc) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            String sb2 = sb.toString();
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze(sb2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfej
    public final zzfeq zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfej
    public final synchronized zzfes zzb(zzfet zzfetVar) {
        zzfes zzfesVar;
        zzfei zzfeiVar = (zzfei) this.zza.get(zzfetVar);
        if (zzfeiVar != null) {
            zzfesVar = zzfeiVar.zze();
            if (zzfesVar == null) {
                this.zzc.zze();
            }
            zzffg zzf = zzfeiVar.zzf();
            if (zzfesVar != null) {
                zzbcj.zzb.zzc zzd = zzbcj.zzb.zzd();
                zzbcj.zzb.zza.C0218zza zza = zzbcj.zzb.zza.zza();
                zza.zzf(zzbcj.zzb.zzd.IN_MEMORY);
                zzbcj.zzb.zze.zza zzb = zzbcj.zzb.zze.zzb();
                zzb.zzd(zzf.zza);
                zzb.zze(zzf.zzb);
                zza.zzg(zzb);
                zzd.zzd(zza);
                zzfesVar.zza.zzb().zzc().zzi(zzd.zzbr());
            }
            zzf();
        } else {
            this.zzc.zzf();
            zzf();
            zzfesVar = null;
        }
        return zzfesVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfej
    @Deprecated
    public final zzfet zzc(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, com.google.android.gms.ads.internal.client.zzx zzxVar) {
        zzfeq zzfeqVar = this.zzb;
        return new zzfeu(zzmVar, str, new zzbvt(zzfeqVar.zza).zza().zzj, zzfeqVar.zzf, zzxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfej
    public final synchronized boolean zzd(zzfet zzfetVar, zzfes zzfesVar) {
        boolean zzh;
        ConcurrentHashMap concurrentHashMap = this.zza;
        zzfei zzfeiVar = (zzfei) concurrentHashMap.get(zzfetVar);
        zzfesVar.zzd = com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis();
        if (zzfeiVar == null) {
            zzfeq zzfeqVar = this.zzb;
            zzfei zzfeiVar2 = new zzfei(zzfeqVar.zzd, zzfeqVar.zze * 1000);
            if (concurrentHashMap.size() == zzfeqVar.zzc) {
                int i = zzfeqVar.zzg;
                int i2 = i - 1;
                zzfet zzfetVar2 = null;
                if (i == 0) {
                    throw null;
                }
                long j = Long.MAX_VALUE;
                if (i2 == 0) {
                    for (Map.Entry entry : concurrentHashMap.entrySet()) {
                        if (((zzfei) entry.getValue()).zzc() < j) {
                            j = ((zzfei) entry.getValue()).zzc();
                            zzfetVar2 = (zzfet) entry.getKey();
                        }
                    }
                    if (zzfetVar2 != null) {
                        concurrentHashMap.remove(zzfetVar2);
                    }
                } else if (i2 == 1) {
                    for (Map.Entry entry2 : concurrentHashMap.entrySet()) {
                        if (((zzfei) entry2.getValue()).zzd() < j) {
                            j = ((zzfei) entry2.getValue()).zzd();
                            zzfetVar2 = (zzfet) entry2.getKey();
                        }
                    }
                    if (zzfetVar2 != null) {
                        concurrentHashMap.remove(zzfetVar2);
                    }
                } else if (i2 == 2) {
                    int i3 = Integer.MAX_VALUE;
                    for (Map.Entry entry3 : concurrentHashMap.entrySet()) {
                        if (((zzfei) entry3.getValue()).zza() < i3) {
                            i3 = ((zzfei) entry3.getValue()).zza();
                            zzfetVar2 = (zzfet) entry3.getKey();
                        }
                    }
                    if (zzfetVar2 != null) {
                        concurrentHashMap.remove(zzfetVar2);
                    }
                }
                this.zzc.zzg();
            }
            concurrentHashMap.put(zzfetVar, zzfeiVar2);
            this.zzc.zzd();
            zzfeiVar = zzfeiVar2;
        }
        zzh = zzfeiVar.zzh(zzfesVar);
        zzfem zzfemVar = this.zzc;
        zzfemVar.zzc();
        zzfel zza = zzfemVar.zza();
        zzffg zzf = zzfeiVar.zzf();
        if (zzfesVar != null) {
            zzbcj.zzb.zzc zzd = zzbcj.zzb.zzd();
            zzbcj.zzb.zza.C0218zza zza2 = zzbcj.zzb.zza.zza();
            zza2.zzf(zzbcj.zzb.zzd.IN_MEMORY);
            zzbcj.zzb.zzg.zza zzb = zzbcj.zzb.zzg.zzb();
            zzb.zze(zza.zza);
            zzb.zzf(zza.zzb);
            zzb.zzg(zzf.zzb);
            zza2.zzi(zzb);
            zzd.zzd(zza2);
            zzfesVar.zza.zzb().zzc().zzj(zzd.zzbr());
        }
        zzf();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzfej
    public final synchronized boolean zze(zzfet zzfetVar) {
        zzfei zzfeiVar = (zzfei) this.zza.get(zzfetVar);
        if (zzfeiVar == null) {
            return true;
        }
        return zzfeiVar.zzb() < this.zzb.zzd;
    }
}
