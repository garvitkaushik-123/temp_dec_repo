package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgyw {
    private static final zzgyw zzb = new zzgyw(true);
    final zzhbt zza = new zzhbo();
    private boolean zzc;
    private boolean zzd;

    private zzgyw() {
    }

    static int zza(zzhck zzhckVar, int i, Object obj) {
        int zzD = zzgym.zzD(i << 3);
        if (zzhckVar == zzhck.GROUP) {
            zzhas zzhasVar = (zzhas) obj;
            byte[] bArr = zzgzu.zzb;
            if (zzhasVar instanceof zzgxj) {
                throw null;
            }
            zzD += zzD;
        }
        return zzD + zzb(zzhckVar, obj);
    }

    static int zzb(zzhck zzhckVar, Object obj) {
        int zzd;
        int zzD;
        zzhck zzhckVar2 = zzhck.DOUBLE;
        zzhcl zzhclVar = zzhcl.INT;
        switch (zzhckVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                int i = zzgym.zzf;
                return 8;
            case FLOAT:
                ((Float) obj).floatValue();
                int i2 = zzgym.zzf;
                return 4;
            case INT64:
                return zzgym.zzE(((Long) obj).longValue());
            case UINT64:
                return zzgym.zzE(((Long) obj).longValue());
            case INT32:
                return zzgym.zzE(((Integer) obj).intValue());
            case FIXED64:
                ((Long) obj).longValue();
                int i3 = zzgym.zzf;
                return 8;
            case FIXED32:
                ((Integer) obj).intValue();
                int i4 = zzgym.zzf;
                return 4;
            case BOOL:
                ((Boolean) obj).booleanValue();
                int i5 = zzgym.zzf;
                return 1;
            case STRING:
                if (!(obj instanceof zzgxz)) {
                    return zzgym.zzC((String) obj);
                }
                int i6 = zzgym.zzf;
                zzd = ((zzgxz) obj).zzd();
                zzD = zzgym.zzD(zzd);
                break;
            case GROUP:
                return ((zzhas) obj).zzaY();
            case MESSAGE:
                if (!(obj instanceof zzhac)) {
                    return zzgym.zzz((zzhas) obj);
                }
                int i7 = zzgym.zzf;
                zzd = ((zzhac) obj).zza();
                zzD = zzgym.zzD(zzd);
                break;
            case BYTES:
                if (!(obj instanceof zzgxz)) {
                    int i8 = zzgym.zzf;
                    zzd = ((byte[]) obj).length;
                    zzD = zzgym.zzD(zzd);
                    break;
                } else {
                    int i9 = zzgym.zzf;
                    zzd = ((zzgxz) obj).zzd();
                    zzD = zzgym.zzD(zzd);
                    break;
                }
            case UINT32:
                return zzgym.zzD(((Integer) obj).intValue());
            case ENUM:
                return obj instanceof zzgzl ? zzgym.zzE(((zzgzl) obj).zza()) : zzgym.zzE(((Integer) obj).intValue());
            case SFIXED32:
                ((Integer) obj).intValue();
                int i10 = zzgym.zzf;
                return 4;
            case SFIXED64:
                ((Long) obj).longValue();
                int i11 = zzgym.zzf;
                return 8;
            case SINT32:
                int intValue = ((Integer) obj).intValue();
                return zzgym.zzD((intValue >> 31) ^ (intValue + intValue));
            case SINT64:
                long longValue = ((Long) obj).longValue();
                return zzgym.zzE((longValue >> 63) ^ (longValue + longValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return zzD + zzd;
    }

    public static int zzc(zzgyv zzgyvVar, Object obj) {
        zzhck zzb2 = zzgyvVar.zzb();
        int zza = zzgyvVar.zza();
        if (!zzgyvVar.zze()) {
            return zza(zzb2, zza, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!zzgyvVar.zzd()) {
            int i2 = 0;
            while (i < size) {
                i2 += zza(zzb2, zza, list.get(i));
                i++;
            }
            return i2;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzb(zzb2, list.get(i));
            i++;
        }
        return zzgym.zzD(zza << 3) + i3 + zzgym.zzD(i3);
    }

    public static zzgyw zze() {
        return zzb;
    }

    private static boolean zzj(Map.Entry entry) {
        zzgyv zzgyvVar = (zzgyv) entry.getKey();
        if (zzgyvVar.zzc() != zzhcl.MESSAGE) {
            return true;
        }
        if (!zzgyvVar.zze()) {
            return zzk(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!zzk(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzk(Object obj) {
        if (obj instanceof zzhat) {
            return ((zzhat) obj).zzbw();
        }
        if (obj instanceof zzhac) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzl(Map.Entry entry) {
        int i;
        int zzD;
        int zzD2;
        zzgyv zzgyvVar = (zzgyv) entry.getKey();
        Object value = entry.getValue();
        if (zzgyvVar.zzc() != zzhcl.MESSAGE || zzgyvVar.zze() || zzgyvVar.zzd()) {
            return zzc(zzgyvVar, value);
        }
        if (value instanceof zzhac) {
            int zza = ((zzgyv) entry.getKey()).zza();
            int zzD3 = zzgym.zzD(8);
            i = zzD3 + zzD3;
            zzD = zzgym.zzD(16) + zzgym.zzD(zza);
            int zzD4 = zzgym.zzD(24);
            int zza2 = ((zzhac) value).zza();
            zzD2 = zzD4 + zzgym.zzD(zza2) + zza2;
        } else {
            int zza3 = ((zzgyv) entry.getKey()).zza();
            int zzD5 = zzgym.zzD(8);
            i = zzD5 + zzD5;
            zzD = zzgym.zzD(16) + zzgym.zzD(zza3);
            zzD2 = zzgym.zzD(24) + zzgym.zzz((zzhas) value);
        }
        return i + zzD + zzD2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void zzm(zzgyv zzgyvVar, Object obj) {
        boolean z;
        zzgyvVar.zzb();
        byte[] bArr = zzgzu.zzb;
        obj.getClass();
        zzhck zzhckVar = zzhck.DOUBLE;
        zzhcl zzhclVar = zzhcl.INT;
        switch (r0.zza()) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
            case LONG:
                z = obj instanceof Long;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
            case STRING:
                z = obj instanceof String;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzgxz) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzgzl)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zzhas) || (obj instanceof zzhac)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgyvVar.zza()), zzgyvVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgyw zzgywVar = new zzgyw();
        zzhbt zzhbtVar = this.zza;
        int zzc = zzhbtVar.zzc();
        for (int i = 0; i < zzc; i++) {
            Map.Entry zzg = zzhbtVar.zzg(i);
            zzgywVar.zzh((zzgyv) ((zzhbp) zzg).zza(), zzg.getValue());
        }
        for (Map.Entry entry : zzhbtVar.zzd()) {
            zzgywVar.zzh((zzgyv) entry.getKey(), entry.getValue());
        }
        zzgywVar.zzd = this.zzd;
        return zzgywVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgyw) {
            return this.zza.equals(((zzgyw) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzd() {
        zzhbt zzhbtVar = this.zza;
        int zzc = zzhbtVar.zzc();
        int i = 0;
        for (int i2 = 0; i2 < zzc; i2++) {
            i += zzl(zzhbtVar.zzg(i2));
        }
        Iterator it = zzhbtVar.zzd().iterator();
        while (it.hasNext()) {
            i += zzl((Map.Entry) it.next());
        }
        return i;
    }

    public final Iterator zzf() {
        zzhbt zzhbtVar = this.zza;
        return zzhbtVar.isEmpty() ? Collections.emptyIterator() : this.zzd ? new zzhaa(zzhbtVar.entrySet().iterator()) : zzhbtVar.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        zzhbt zzhbtVar = this.zza;
        int zzc = zzhbtVar.zzc();
        for (int i = 0; i < zzc; i++) {
            Object value = zzhbtVar.zzg(i).getValue();
            if (value instanceof zzgzh) {
                ((zzgzh) value).zzbU();
            }
        }
        Iterator it = zzhbtVar.zzd().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzgzh) {
                ((zzgzh) value2).zzbU();
            }
        }
        zzhbtVar.zza();
        this.zzc = true;
    }

    public final void zzh(zzgyv zzgyvVar, Object obj) {
        if (!zzgyvVar.zze()) {
            zzm(zzgyvVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzm(zzgyvVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzhac) {
            this.zzd = true;
        }
        this.zza.put(zzgyvVar, obj);
    }

    public final boolean zzi() {
        zzhbt zzhbtVar = this.zza;
        int zzc = zzhbtVar.zzc();
        for (int i = 0; i < zzc; i++) {
            if (!zzj(zzhbtVar.zzg(i))) {
                return false;
            }
        }
        Iterator it = zzhbtVar.zzd().iterator();
        while (it.hasNext()) {
            if (!zzj((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzgyw(boolean z) {
        zzg();
        zzg();
    }
}
