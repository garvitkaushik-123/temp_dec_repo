package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfxz extends AbstractMap implements Serializable {
    private static final Object zzd = new Object();
    transient int[] zza;
    transient Object[] zzb;
    transient Object[] zzc;
    private transient Object zze;
    private transient int zzf;
    private transient int zzg;
    private transient Set zzh;
    private transient Set zzi;
    private transient Collection zzj;

    zzfxz() {
        zzp(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int[] zzA() {
        return (int[]) Objects.requireNonNull(this.zza);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object[] zzB() {
        return (Object[]) Objects.requireNonNull(this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object[] zzC() {
        return (Object[]) Objects.requireNonNull(this.zzc);
    }

    static /* synthetic */ Object zzg(zzfxz zzfxzVar, int i) {
        return zzfxzVar.zzB()[i];
    }

    static /* synthetic */ Object zzj(zzfxz zzfxzVar, int i) {
        return zzfxzVar.zzC()[i];
    }

    static /* synthetic */ void zzn(zzfxz zzfxzVar, int i, Object obj) {
        zzfxzVar.zzC()[i] = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzv() {
        return (1 << (this.zzf & 31)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzw(Object obj) {
        if (zzr()) {
            return -1;
        }
        int zzb = zzfyi.zzb(obj);
        int zzv = zzv();
        int zzc = zzfya.zzc(Objects.requireNonNull(this.zze), zzb & zzv);
        if (zzc != 0) {
            int i = ~zzv;
            int i2 = zzb & i;
            do {
                int i3 = zzc - 1;
                int i4 = zzA()[i3];
                if ((i4 & i) == i2 && zzfvm.zza(obj, zzB()[i3])) {
                    return i3;
                }
                zzc = i4 & zzv;
            } while (zzc != 0);
        }
        return -1;
    }

    private final int zzx(int i, int i2, int i3, int i4) {
        int i5 = i2 - 1;
        Object zzd2 = zzfya.zzd(i2);
        if (i4 != 0) {
            zzfya.zze(zzd2, i3 & i5, i4 + 1);
        }
        Object requireNonNull = Objects.requireNonNull(this.zze);
        int[] zzA = zzA();
        for (int i6 = 0; i6 <= i; i6++) {
            int zzc = zzfya.zzc(requireNonNull, i6);
            while (zzc != 0) {
                int i7 = zzc - 1;
                int i8 = zzA[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int zzc2 = zzfya.zzc(zzd2, i10);
                zzfya.zze(zzd2, i10, zzc);
                zzA[i7] = ((~i5) & i9) | (zzc2 & i5);
                zzc = i8 & i;
            }
        }
        this.zze = zzd2;
        zzz(i5);
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzy(Object obj) {
        int zzv;
        int zzb;
        if (zzr() || (zzb = zzfya.zzb(obj, null, (zzv = zzv()), Objects.requireNonNull(this.zze), zzA(), zzB(), null)) == -1) {
            return zzd;
        }
        Object obj2 = zzC()[zzb];
        zzq(zzb, zzv);
        this.zzg--;
        zzo();
        return obj2;
    }

    private final void zzz(int i) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i)) & 31) | (this.zzf & (-32));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (zzr()) {
            return;
        }
        zzo();
        Map zzl = zzl();
        if (zzl != null) {
            this.zzf = zzgbt.zzc(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
            zzl.clear();
            this.zze = null;
            this.zzg = 0;
            return;
        }
        Arrays.fill(zzB(), 0, this.zzg, (Object) null);
        Arrays.fill(zzC(), 0, this.zzg, (Object) null);
        Object requireNonNull = Objects.requireNonNull(this.zze);
        if (requireNonNull instanceof byte[]) {
            Arrays.fill((byte[]) requireNonNull, (byte) 0);
        } else if (requireNonNull instanceof short[]) {
            Arrays.fill((short[]) requireNonNull, (short) 0);
        } else {
            Arrays.fill((int[]) requireNonNull, 0);
        }
        Arrays.fill(zzA(), 0, this.zzg, 0);
        this.zzg = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map zzl = zzl();
        return zzl != null ? zzl.containsKey(obj) : zzw(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.containsValue(obj);
        }
        for (int i = 0; i < this.zzg; i++) {
            if (zzfvm.zza(obj, zzC()[i])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.zzi;
        if (set != null) {
            return set;
        }
        zzfxt zzfxtVar = new zzfxt(this);
        this.zzi = zzfxtVar;
        return zzfxtVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.get(obj);
        }
        int zzw = zzw(obj);
        if (zzw == -1) {
            return null;
        }
        return zzC()[zzw];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.zzh;
        if (set != null) {
            return set;
        }
        zzfxv zzfxvVar = new zzfxv(this);
        this.zzh = zzfxvVar;
        return zzfxvVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int i;
        if (zzr()) {
            zzfvp.zzm(zzr(), "Arrays already allocated");
            int i2 = this.zzf;
            int max = Math.max(i2 + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            if (max > highestOneBit && (highestOneBit = highestOneBit + highestOneBit) <= 0) {
                highestOneBit = 1073741824;
            }
            int max2 = Math.max(4, highestOneBit);
            this.zze = zzfya.zzd(max2);
            zzz(max2 - 1);
            this.zza = new int[i2];
            this.zzb = new Object[i2];
            this.zzc = new Object[i2];
        }
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.put(obj, obj2);
        }
        int[] zzA = zzA();
        Object[] zzB = zzB();
        Object[] zzC = zzC();
        int i3 = this.zzg;
        int i4 = i3 + 1;
        int zzb = zzfyi.zzb(obj);
        int zzv = zzv();
        int i5 = zzb & zzv;
        int zzc = zzfya.zzc(Objects.requireNonNull(this.zze), i5);
        if (zzc == 0) {
            if (i4 > zzv) {
                zzv = zzx(zzv, zzfya.zza(zzv), zzb, i3);
            } else {
                zzfya.zze(Objects.requireNonNull(this.zze), i5, i4);
            }
            i = 1;
        } else {
            int i6 = ~zzv;
            int i7 = zzb & i6;
            int i8 = 0;
            while (true) {
                int i9 = zzc - 1;
                int i10 = zzA[i9];
                i = 1;
                int i11 = i10 & i6;
                if (i11 == i7 && zzfvm.zza(obj, zzB[i9])) {
                    Object obj3 = zzC[i9];
                    zzC[i9] = obj2;
                    return obj3;
                }
                int i12 = i10 & zzv;
                i8++;
                if (i12 != 0) {
                    zzc = i12;
                } else {
                    if (i8 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzv() + 1, 1.0f);
                        int zze = zze();
                        while (zze >= 0) {
                            linkedHashMap.put(zzB()[zze], zzC()[zze]);
                            zze = zzf(zze);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzo();
                        return linkedHashMap.put(obj, obj2);
                    }
                    if (i4 > zzv) {
                        zzv = zzx(zzv, zzfya.zza(zzv), zzb, i3);
                    } else {
                        zzA[i9] = (i4 & zzv) | i11;
                    }
                }
            }
        }
        int length = zzA().length;
        if (i4 > length) {
            int i13 = i;
            int min = Math.min(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (Math.max(i13, length >>> 1) + length) | i13);
            if (min != length) {
                this.zza = Arrays.copyOf(zzA(), min);
                this.zzb = Arrays.copyOf(zzB(), min);
                this.zzc = Arrays.copyOf(zzC(), min);
            }
        }
        zzA()[i3] = (~zzv) & zzb;
        zzB()[i3] = obj;
        zzC()[i3] = obj2;
        this.zzg = i4;
        zzo();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.remove(obj);
        }
        Object zzy = zzy(obj);
        if (zzy == zzd) {
            return null;
        }
        return zzy;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map zzl = zzl();
        return zzl != null ? zzl.size() : this.zzg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzfxx zzfxxVar = new zzfxx(this);
        this.zzj = zzfxxVar;
        return zzfxxVar;
    }

    final int zze() {
        return isEmpty() ? -1 : 0;
    }

    final int zzf(int i) {
        int i2 = i + 1;
        if (i2 < this.zzg) {
            return i2;
        }
        return -1;
    }

    final Map zzl() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    final void zzo() {
        this.zzf += 32;
    }

    final void zzp(int i) {
        this.zzf = zzgbt.zzc(i, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    final void zzq(int i, int i2) {
        Object requireNonNull = Objects.requireNonNull(this.zze);
        int[] zzA = zzA();
        Object[] zzB = zzB();
        Object[] zzC = zzC();
        int size = size();
        int i3 = size - 1;
        if (i >= i3) {
            zzB[i] = null;
            zzC[i] = null;
            zzA[i] = 0;
            return;
        }
        int i4 = i + 1;
        Object obj = zzB[i3];
        zzB[i] = obj;
        zzC[i] = zzC[i3];
        zzB[i3] = null;
        zzC[i3] = null;
        zzA[i] = zzA[i3];
        zzA[i3] = 0;
        int zzb = zzfyi.zzb(obj) & i2;
        int zzc = zzfya.zzc(requireNonNull, zzb);
        if (zzc == size) {
            zzfya.zze(requireNonNull, zzb, i4);
            return;
        }
        while (true) {
            int i5 = zzc - 1;
            int i6 = zzA[i5];
            int i7 = i6 & i2;
            if (i7 == size) {
                zzA[i5] = (i6 & (~i2)) | (i2 & i4);
                return;
            }
            zzc = i7;
        }
    }

    final boolean zzr() {
        return this.zze == null;
    }

    zzfxz(int i) {
        zzp(8);
    }
}
