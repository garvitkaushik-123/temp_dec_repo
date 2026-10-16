package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzur implements zzxb {
    private final zzfyq zza;
    private long zzb;

    public zzur(List list, List list2) {
        int i = zzfyq.zzd;
        zzfyn zzfynVar = new zzfyn();
        zzdd.zzd(list.size() == list2.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzfynVar.zzf(new zzuq((zzxb) list.get(i2), (List) list2.get(i2)));
        }
        this.zza = zzfynVar.zzi();
        this.zzb = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final long zzb() {
        int i = 0;
        long j = Long.MAX_VALUE;
        long j2 = Long.MAX_VALUE;
        while (true) {
            zzfyq zzfyqVar = this.zza;
            if (i >= zzfyqVar.size()) {
                break;
            }
            zzuq zzuqVar = (zzuq) zzfyqVar.get(i);
            long zzb = zzuqVar.zzb();
            if ((zzuqVar.zza().contains(1) || zzuqVar.zza().contains(2) || zzuqVar.zza().contains(4)) && zzb != Long.MIN_VALUE) {
                j = Math.min(j, zzb);
            }
            if (zzb != Long.MIN_VALUE) {
                j2 = Math.min(j2, zzb);
            }
            i++;
        }
        if (j != Long.MAX_VALUE) {
            this.zzb = j;
            return j;
        }
        if (j2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j3 = this.zzb;
        return j3 != -9223372036854775807L ? j3 : j2;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final long zzc() {
        int i = 0;
        long j = Long.MAX_VALUE;
        while (true) {
            zzfyq zzfyqVar = this.zza;
            if (i >= zzfyqVar.size()) {
                break;
            }
            long zzc = ((zzuq) zzfyqVar.get(i)).zzc();
            if (zzc != Long.MIN_VALUE) {
                j = Math.min(j, zzc);
            }
            i++;
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void zzm(long j) {
        int i = 0;
        while (true) {
            zzfyq zzfyqVar = this.zza;
            if (i >= zzfyqVar.size()) {
                return;
            }
            ((zzuq) zzfyqVar.get(i)).zzm(j);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final boolean zzo(zzla zzlaVar) {
        boolean z;
        boolean z2 = false;
        do {
            long zzc = zzc();
            if (zzc == Long.MIN_VALUE) {
                break;
            }
            int i = 0;
            z = false;
            while (true) {
                zzfyq zzfyqVar = this.zza;
                if (i >= zzfyqVar.size()) {
                    break;
                }
                long zzc2 = ((zzuq) zzfyqVar.get(i)).zzc();
                boolean z3 = zzc2 != Long.MIN_VALUE && zzc2 <= zzlaVar.zza;
                if (zzc2 == zzc || z3) {
                    z |= ((zzuq) zzfyqVar.get(i)).zzo(zzlaVar);
                }
                i++;
            }
            z2 |= z;
        } while (z);
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final boolean zzp() {
        int i = 0;
        while (true) {
            zzfyq zzfyqVar = this.zza;
            if (i >= zzfyqVar.size()) {
                return false;
            }
            if (((zzuq) zzfyqVar.get(i)).zzp()) {
                return true;
            }
            i++;
        }
    }
}
