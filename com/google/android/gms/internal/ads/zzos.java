package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzos {
    private final zzbj zza;
    private zzfyq zzb = zzfyq.zzn();
    private zzfyt zzc = zzfyt.zzd();
    private zzvh zzd;
    private zzvh zze;
    private zzvh zzf;

    public zzos(zzbj zzbjVar) {
        this.zza = zzbjVar;
    }

    private static zzvh zzj(zzbh zzbhVar, zzfyq zzfyqVar, zzvh zzvhVar, zzbj zzbjVar) {
        zzbl zzo = zzbhVar.zzo();
        int zzf = zzbhVar.zzf();
        Object zzf2 = zzo.zzo() ? null : zzo.zzf(zzf);
        int i = -1;
        if (!zzbhVar.zzx() && !zzo.zzo()) {
            i = zzo.zzd(zzf, zzbjVar, false).zzc(zzex.zzs(zzbhVar.zzl()));
        }
        int i2 = i;
        for (int i3 = 0; i3 < zzfyqVar.size(); i3++) {
            zzvh zzvhVar2 = (zzvh) zzfyqVar.get(i3);
            if (zzm(zzvhVar2, zzf2, zzbhVar.zzx(), zzbhVar.zzc(), zzbhVar.zzd(), i2)) {
                return zzvhVar2;
            }
        }
        if (zzfyqVar.isEmpty() && zzvhVar != null && zzm(zzvhVar, zzf2, zzbhVar.zzx(), zzbhVar.zzc(), zzbhVar.zzd(), i2)) {
            return zzvhVar;
        }
        return null;
    }

    private final void zzk(zzfys zzfysVar, zzvh zzvhVar, zzbl zzblVar) {
        if (zzvhVar == null) {
            return;
        }
        if (zzblVar.zza(zzvhVar.zza) != -1) {
            zzfysVar.zza(zzvhVar, zzblVar);
            return;
        }
        zzbl zzblVar2 = (zzbl) this.zzc.get(zzvhVar);
        if (zzblVar2 != null) {
            zzfysVar.zza(zzvhVar, zzblVar2);
        }
    }

    private final void zzl(zzbl zzblVar) {
        zzfys zzfysVar = new zzfys();
        if (this.zzb.isEmpty()) {
            zzk(zzfysVar, this.zze, zzblVar);
            if (!Objects.equals(this.zzf, this.zze)) {
                zzk(zzfysVar, this.zzf, zzblVar);
            }
            if (!Objects.equals(this.zzd, this.zze) && !Objects.equals(this.zzd, this.zzf)) {
                zzk(zzfysVar, this.zzd, zzblVar);
            }
        } else {
            for (int i = 0; i < this.zzb.size(); i++) {
                zzk(zzfysVar, (zzvh) this.zzb.get(i), zzblVar);
            }
            if (!this.zzb.contains(this.zzd)) {
                zzk(zzfysVar, this.zzd, zzblVar);
            }
        }
        this.zzc = zzfysVar.zzc();
    }

    private static boolean zzm(zzvh zzvhVar, Object obj, boolean z, int i, int i2, int i3) {
        if (zzvhVar.zza.equals(obj)) {
            return z ? zzvhVar.zzb == i && zzvhVar.zzc == i2 : zzvhVar.zzb == -1 && zzvhVar.zze == i3;
        }
        return false;
    }

    public final zzbl zza(zzvh zzvhVar) {
        return (zzbl) this.zzc.get(zzvhVar);
    }

    public final zzvh zzb() {
        return this.zzd;
    }

    public final zzvh zzc() {
        Object next;
        Object obj;
        if (this.zzb.isEmpty()) {
            return null;
        }
        zzfyq zzfyqVar = this.zzb;
        if (zzfyqVar instanceof List) {
            zzfyq zzfyqVar2 = zzfyqVar;
            if (zzfyqVar2.isEmpty()) {
                throw new NoSuchElementException();
            }
            obj = zzfyqVar2.get(zzfyqVar2.size() - 1);
        } else {
            Iterator<E> it = zzfyqVar.iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            obj = next;
        }
        return (zzvh) obj;
    }

    public final zzvh zzd() {
        return this.zze;
    }

    public final zzvh zze() {
        return this.zzf;
    }

    public final void zzg(zzbh zzbhVar) {
        this.zzd = zzj(zzbhVar, this.zzb, this.zze, this.zza);
    }

    public final void zzh(List list, zzvh zzvhVar, zzbh zzbhVar) {
        this.zzb = zzfyq.zzl(list);
        if (!list.isEmpty()) {
            this.zze = (zzvh) list.get(0);
            zzvhVar.getClass();
            this.zzf = zzvhVar;
        }
        if (this.zzd == null) {
            this.zzd = zzj(zzbhVar, this.zzb, this.zze, this.zza);
        }
        zzl(zzbhVar.zzo());
    }

    public final void zzi(zzbh zzbhVar) {
        this.zzd = zzj(zzbhVar, this.zzb, this.zze, this.zza);
        zzl(zzbhVar.zzo());
    }
}
