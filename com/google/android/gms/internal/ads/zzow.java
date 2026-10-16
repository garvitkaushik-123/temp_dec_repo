package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzow implements zzpf {
    public static final zzfwh zza = new zzfwh() { // from class: com.google.android.gms.internal.ads.zzou
        @Override // com.google.android.gms.internal.ads.zzfwh
        public final Object zza() {
            String zzn;
            zzn = zzow.zzn();
            return zzn;
        }
    };
    private static final Random zzb = new Random();
    private final zzbk zzc;
    private final zzbj zzd;
    private final HashMap zze;
    private zzpe zzf;
    private zzbl zzg;
    private String zzh;
    private long zzi;

    public zzow() {
        throw null;
    }

    public zzow(zzfwh zzfwhVar) {
        this.zzc = new zzbk();
        this.zzd = new zzbj();
        this.zze = new HashMap();
        this.zzg = zzbl.zza;
        this.zzi = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzl() {
        zzov zzovVar = (zzov) this.zze.get(this.zzh);
        return (zzovVar == null || zzovVar.zzd == -1) ? this.zzi + 1 : zzovVar.zzd;
    }

    private final zzov zzm(int i, zzvh zzvhVar) {
        HashMap hashMap = this.zze;
        long j = Long.MAX_VALUE;
        zzov zzovVar = null;
        for (zzov zzovVar2 : hashMap.values()) {
            zzovVar2.zzg(i, zzvhVar);
            if (zzovVar2.zzj(i, zzvhVar)) {
                long j2 = zzovVar2.zzd;
                if (j2 == -1 || j2 < j) {
                    zzovVar = zzovVar2;
                    j = j2;
                } else if (j2 == j) {
                    String str = zzex.zza;
                    if (zzovVar.zze != null && zzovVar2.zze != null) {
                        zzovVar = zzovVar2;
                    }
                }
            }
        }
        if (zzovVar != null) {
            return zzovVar;
        }
        String zzn = zzn();
        zzov zzovVar3 = new zzov(this, zzn, i, zzvhVar);
        hashMap.put(zzn, zzovVar3);
        return zzovVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzn() {
        byte[] bArr = new byte[12];
        zzb.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private final void zzo(zzov zzovVar) {
        if (zzovVar.zzd != -1) {
            this.zzi = zzovVar.zzd;
        }
        this.zzh = null;
    }

    @RequiresNonNull({ServiceSpecificExtraArgs.CastExtraArgs.LISTENER})
    private final void zzp(zzmp zzmpVar) {
        if (zzmpVar.zzb.zzo()) {
            String str = this.zzh;
            if (str != null) {
                zzov zzovVar = (zzov) this.zze.get(str);
                zzovVar.getClass();
                zzo(zzovVar);
                return;
            }
            return;
        }
        zzov zzovVar2 = (zzov) this.zze.get(this.zzh);
        int i = zzmpVar.zzc;
        zzvh zzvhVar = zzmpVar.zzd;
        zzov zzm = zzm(i, zzvhVar);
        this.zzh = zzm.zzb;
        zzi(zzmpVar);
        if (zzvhVar == null || !zzvhVar.zzb()) {
            return;
        }
        if (zzovVar2 != null) {
            if (zzovVar2.zzd == zzvhVar.zzd && zzovVar2.zze != null && zzovVar2.zze.zzb == zzvhVar.zzb && zzovVar2.zze.zzc == zzvhVar.zzc) {
                return;
            }
        }
        String unused = zzm(i, new zzvh(zzvhVar.zza, zzvhVar.zzd)).zzb;
        String unused2 = zzm.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final synchronized String zze() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final synchronized String zzf(zzbl zzblVar, zzvh zzvhVar) {
        return zzm(zzblVar.zzn(zzvhVar.zza, this.zzd).zzc, zzvhVar).zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final synchronized void zzg(zzmp zzmpVar) {
        zzpe zzpeVar;
        String str = this.zzh;
        if (str != null) {
            zzov zzovVar = (zzov) this.zze.get(str);
            if (zzovVar == null) {
                throw null;
            }
            zzov zzovVar2 = zzovVar;
            zzo(zzovVar);
        }
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzov zzovVar3 = (zzov) it.next();
            it.remove();
            if (zzovVar3.zzf && (zzpeVar = this.zzf) != null) {
                zzpeVar.zzv(zzmpVar, zzovVar3.zzb, false);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final void zzh(zzpe zzpeVar) {
        this.zzf = zzpeVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        if (r2.zzc == r10.zzc) goto L18;
     */
    @Override // com.google.android.gms.internal.ads.zzpf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void zzi(zzmp zzmpVar) {
        if (this.zzf == null) {
            throw null;
        }
        zzbl zzblVar = zzmpVar.zzb;
        if (!zzblVar.zzo()) {
            zzvh zzvhVar = zzmpVar.zzd;
            if (zzvhVar != null) {
                if (zzvhVar.zzd >= zzl()) {
                    zzov zzovVar = (zzov) this.zze.get(this.zzh);
                    if (zzovVar != null) {
                        if (zzovVar.zzd == -1) {
                        }
                    }
                }
            }
            int i = zzmpVar.zzc;
            zzov zzm = zzm(i, zzvhVar);
            if (this.zzh == null) {
                this.zzh = zzm.zzb;
            }
            if (zzvhVar != null && zzvhVar.zzb()) {
                Object obj = zzvhVar.zza;
                long j = zzvhVar.zzd;
                int i2 = zzvhVar.zzb;
                zzov zzm2 = zzm(i, new zzvh(obj, j, i2));
                if (!zzm2.zzf) {
                    zzm2.zzf = true;
                    zzbj zzbjVar = this.zzd;
                    zzblVar.zzn(obj, zzbjVar);
                    zzbjVar.zzg(i2);
                    Math.max(0L, zzex.zzv(0L) + zzex.zzv(0L));
                    String unused = zzm2.zzb;
                }
            }
            if (!zzm.zzf) {
                zzm.zzf = true;
                String unused2 = zzm.zzb;
            }
            if (zzm.zzb.equals(this.zzh) && !zzm.zzg) {
                zzm.zzg = true;
                this.zzf.zzu(zzmpVar, zzm.zzb);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final synchronized void zzj(zzmp zzmpVar, int i) {
        if (this.zzf == null) {
            throw null;
        }
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzov zzovVar = (zzov) it.next();
            if (zzovVar.zzk(zzmpVar)) {
                it.remove();
                if (zzovVar.zzf) {
                    boolean equals = zzovVar.zzb.equals(this.zzh);
                    boolean z = false;
                    if (i == 0 && equals && zzovVar.zzg) {
                        z = true;
                    }
                    if (equals) {
                        zzo(zzovVar);
                    }
                    this.zzf.zzv(zzmpVar, zzovVar.zzb, z);
                }
            }
        }
        zzp(zzmpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final synchronized void zzk(zzmp zzmpVar) {
        if (this.zzf == null) {
            throw null;
        }
        zzbl zzblVar = this.zzg;
        this.zzg = zzmpVar.zzb;
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzov zzovVar = (zzov) it.next();
            if (!zzovVar.zzl(zzblVar, this.zzg) || zzovVar.zzk(zzmpVar)) {
                it.remove();
                if (zzovVar.zzf) {
                    if (zzovVar.zzb.equals(this.zzh)) {
                        zzo(zzovVar);
                    }
                    this.zzf.zzv(zzmpVar, zzovVar.zzb, false);
                }
            }
        }
        zzp(zzmpVar);
    }
}
