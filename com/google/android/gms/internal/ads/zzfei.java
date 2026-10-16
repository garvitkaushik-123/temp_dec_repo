package com.google.android.gms.internal.ads;

import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfei {
    private final int zzb;
    private final int zzc;
    private final LinkedList zza = new LinkedList();
    private final zzffh zzd = new zzffh();

    public zzfei(int i, int i2) {
        this.zzb = i;
        this.zzc = i2;
    }

    private final void zzi() {
        while (true) {
            LinkedList linkedList = this.zza;
            if (linkedList.isEmpty()) {
                return;
            }
            if (com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() - ((zzfes) linkedList.getFirst()).zzd < this.zzc) {
                return;
            }
            this.zzd.zzg();
            linkedList.remove();
        }
    }

    public final int zza() {
        return this.zzd.zza();
    }

    public final int zzb() {
        zzi();
        return this.zza.size();
    }

    public final long zzc() {
        return this.zzd.zzb();
    }

    public final long zzd() {
        return this.zzd.zzc();
    }

    public final zzfes zze() {
        zzffh zzffhVar = this.zzd;
        zzffhVar.zzf();
        zzi();
        LinkedList linkedList = this.zza;
        if (linkedList.isEmpty()) {
            return null;
        }
        zzfes zzfesVar = (zzfes) linkedList.remove();
        if (zzfesVar != null) {
            zzffhVar.zzh();
        }
        return zzfesVar;
    }

    public final zzffg zzf() {
        return this.zzd.zzd();
    }

    public final String zzg() {
        return this.zzd.zze();
    }

    public final boolean zzh(zzfes zzfesVar) {
        this.zzd.zzf();
        zzi();
        LinkedList linkedList = this.zza;
        if (linkedList.size() == this.zzb) {
            return false;
        }
        linkedList.add(zzfesVar);
        return true;
    }
}
