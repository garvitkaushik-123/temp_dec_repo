package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.List;
import java.util.PriorityQueue;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfz {
    private final zzfy zza;
    private final ArrayDeque zzb = new ArrayDeque();
    private final ArrayDeque zzc = new ArrayDeque();
    private final PriorityQueue zzd = new PriorityQueue();
    private int zze = -1;
    private zzfx zzf;

    public zzfz(zzfy zzfyVar) {
        this.zza = zzfyVar;
    }

    private final void zzf(int i) {
        List list;
        while (true) {
            PriorityQueue priorityQueue = this.zzd;
            if (priorityQueue.size() <= i) {
                return;
            }
            zzfx zzfxVar = (zzfx) priorityQueue.poll();
            String str = zzex.zza;
            int i2 = 0;
            while (true) {
                list = zzfxVar.zza;
                if (i2 >= list.size()) {
                    break;
                }
                this.zza.zza(zzfxVar.zzb, (zzen) list.get(i2));
                this.zzb.push((zzen) list.get(i2));
                i2++;
            }
            list.clear();
            zzfx zzfxVar2 = this.zzf;
            if (zzfxVar2 != null && zzfxVar2.zzb == zzfxVar.zzb) {
                this.zzf = null;
            }
            this.zzc.push(zzfxVar);
        }
    }

    public final int zza() {
        return this.zze;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
    
        if (r7 < r0.zzb) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzb(long j, zzen zzenVar) {
        int i = this.zze;
        if (i != 0) {
            if (i != -1) {
                PriorityQueue priorityQueue = this.zzd;
                if (priorityQueue.size() >= this.zze) {
                    zzfx zzfxVar = (zzfx) priorityQueue.peek();
                    String str = zzex.zza;
                }
            }
            ArrayDeque arrayDeque = this.zzb;
            zzen zzenVar2 = arrayDeque.isEmpty() ? new zzen() : (zzen) arrayDeque.pop();
            zzenVar2.zzI(zzenVar.zza());
            System.arraycopy(zzenVar.zzN(), zzenVar.zzc(), zzenVar2.zzN(), 0, zzenVar2.zza());
            zzfx zzfxVar2 = this.zzf;
            if (zzfxVar2 != null && j == zzfxVar2.zzb) {
                zzfxVar2.zza.add(zzenVar2);
                return;
            }
            ArrayDeque arrayDeque2 = this.zzc;
            zzfx zzfxVar3 = arrayDeque2.isEmpty() ? new zzfx() : (zzfx) arrayDeque2.pop();
            zzdd.zzd(j != -9223372036854775807L);
            List list = zzfxVar3.zza;
            zzdd.zzf(list.isEmpty());
            zzfxVar3.zzb = j;
            list.add(zzenVar2);
            this.zzd.add(zzfxVar3);
            this.zzf = zzfxVar3;
            int i2 = this.zze;
            if (i2 != -1) {
                zzf(i2);
                return;
            }
            return;
        }
        this.zza.zza(j, zzenVar);
    }

    public final void zzc() {
        this.zzd.clear();
    }

    public final void zzd() {
        zzf(0);
    }

    public final void zze(int i) {
        zzdd.zzf(i >= 0);
        this.zze = i;
        zzf(i);
    }
}
