package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes5.dex */
final class zzez {
    private static final zzez zzb = new zzez(true);
    final zzhd zza = new zzgy();
    private boolean zzc;
    private boolean zzd;

    private zzez() {
    }

    static int zza(zzhs zzhsVar, int i, Object obj) {
        int zzC = zzep.zzC(i << 3);
        if (zzhsVar == zzhs.GROUP) {
            zzfo.zzd((zzgl) obj);
            zzC += zzC;
        }
        return zzC + zzb(zzhsVar, obj);
    }

    static int zzb(zzhs zzhsVar, Object obj) {
        int zzd;
        int zzC;
        zzhs zzhsVar2 = zzhs.DOUBLE;
        zzht zzhtVar = zzht.INT;
        switch (zzhsVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                int i = zzep.zzb;
                return 8;
            case FLOAT:
                ((Float) obj).floatValue();
                int i2 = zzep.zzb;
                return 4;
            case INT64:
                return zzep.zzD(((Long) obj).longValue());
            case UINT64:
                return zzep.zzD(((Long) obj).longValue());
            case INT32:
                return zzep.zzD(((Integer) obj).intValue());
            case FIXED64:
                ((Long) obj).longValue();
                int i3 = zzep.zzb;
                return 8;
            case FIXED32:
                ((Integer) obj).intValue();
                int i4 = zzep.zzb;
                return 4;
            case BOOL:
                ((Boolean) obj).booleanValue();
                int i5 = zzep.zzb;
                return 1;
            case STRING:
                if (!(obj instanceof zzei)) {
                    return zzep.zzB((String) obj);
                }
                int i6 = zzep.zzb;
                zzd = ((zzei) obj).zzd();
                zzC = zzep.zzC(zzd);
                break;
            case GROUP:
                return ((zzgl) obj).zzj();
            case MESSAGE:
                if (!(obj instanceof zzfv)) {
                    return zzep.zzz((zzgl) obj);
                }
                int i7 = zzep.zzb;
                zzd = ((zzfv) obj).zza();
                zzC = zzep.zzC(zzd);
                break;
            case BYTES:
                if (!(obj instanceof zzei)) {
                    int i8 = zzep.zzb;
                    zzd = ((byte[]) obj).length;
                    zzC = zzep.zzC(zzd);
                    break;
                } else {
                    int i9 = zzep.zzb;
                    zzd = ((zzei) obj).zzd();
                    zzC = zzep.zzC(zzd);
                    break;
                }
            case UINT32:
                return zzep.zzC(((Integer) obj).intValue());
            case ENUM:
                return obj instanceof zzfk ? zzep.zzD(((zzfk) obj).zza()) : zzep.zzD(((Integer) obj).intValue());
            case SFIXED32:
                ((Integer) obj).intValue();
                int i10 = zzep.zzb;
                return 4;
            case SFIXED64:
                ((Long) obj).longValue();
                int i11 = zzep.zzb;
                return 8;
            case SINT32:
                int intValue = ((Integer) obj).intValue();
                return zzep.zzC((intValue >> 31) ^ (intValue + intValue));
            case SINT64:
                long longValue = ((Long) obj).longValue();
                return zzep.zzD((longValue >> 63) ^ (longValue + longValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return zzC + zzd;
    }

    public static int zzc(zzey zzeyVar, Object obj) {
        zzhs zzb2 = zzeyVar.zzb();
        int zza = zzeyVar.zza();
        if (!zzeyVar.zze()) {
            return zza(zzb2, zza, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!zzeyVar.zzd()) {
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
        return zzep.zzC(zza << 3) + i3 + zzep.zzC(i3);
    }

    public static zzez zze() {
        return zzb;
    }

    private static boolean zzj(Map.Entry entry) {
        zzey zzeyVar = (zzey) entry.getKey();
        if (zzeyVar.zzc() != zzht.MESSAGE) {
            return true;
        }
        if (!zzeyVar.zze()) {
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
        if (obj instanceof zzgm) {
            return ((zzgm) obj).zzk();
        }
        if (obj instanceof zzfv) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzl(Map.Entry entry) {
        int i;
        int zzC;
        int zzC2;
        zzey zzeyVar = (zzey) entry.getKey();
        Object value = entry.getValue();
        if (zzeyVar.zzc() != zzht.MESSAGE || zzeyVar.zze() || zzeyVar.zzd()) {
            return zzc(zzeyVar, value);
        }
        if (value instanceof zzfv) {
            int zza = ((zzey) entry.getKey()).zza();
            int zzC3 = zzep.zzC(8);
            i = zzC3 + zzC3;
            zzC = zzep.zzC(16) + zzep.zzC(zza);
            int zzC4 = zzep.zzC(24);
            int zza2 = ((zzfv) value).zza();
            zzC2 = zzC4 + zzep.zzC(zza2) + zza2;
        } else {
            int zza3 = ((zzey) entry.getKey()).zza();
            int zzC5 = zzep.zzC(8);
            i = zzC5 + zzC5;
            zzC = zzep.zzC(16) + zzep.zzC(zza3);
            zzC2 = zzep.zzC(24) + zzep.zzz((zzgl) value);
        }
        return i + zzC + zzC2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void zzm(zzey zzeyVar, Object obj) {
        boolean z;
        zzeyVar.zzb();
        byte[] bArr = zzfo.zzb;
        obj.getClass();
        zzhs zzhsVar = zzhs.DOUBLE;
        zzht zzhtVar = zzht.INT;
        switch (r0.zza()) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case LONG:
                z = obj instanceof Long;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case STRING:
                z = obj instanceof String;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzei) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzfk)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zzgl) || (obj instanceof zzfv)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzez zzezVar = new zzez();
        zzhd zzhdVar = this.zza;
        int zzc = zzhdVar.zzc();
        for (int i = 0; i < zzc; i++) {
            Map.Entry zzg = zzhdVar.zzg(i);
            zzezVar.zzh((zzey) ((zzgz) zzg).zza(), zzg.getValue());
        }
        for (Map.Entry entry : zzhdVar.zzd()) {
            zzezVar.zzh((zzey) entry.getKey(), entry.getValue());
        }
        zzezVar.zzd = this.zzd;
        return zzezVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzez) {
            return this.zza.equals(((zzez) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzd() {
        zzhd zzhdVar = this.zza;
        int zzc = zzhdVar.zzc();
        int i = 0;
        for (int i2 = 0; i2 < zzc; i2++) {
            i += zzl(zzhdVar.zzg(i2));
        }
        Iterator it = zzhdVar.zzd().iterator();
        while (it.hasNext()) {
            i += zzl((Map.Entry) it.next());
        }
        return i;
    }

    public final Iterator zzf() {
        zzhd zzhdVar = this.zza;
        return zzhdVar.isEmpty() ? Collections.emptyIterator() : this.zzd ? new zzft(zzhdVar.entrySet().iterator()) : zzhdVar.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        zzhd zzhdVar = this.zza;
        int zzc = zzhdVar.zzc();
        for (int i = 0; i < zzc; i++) {
            Object value = zzhdVar.zzg(i).getValue();
            if (value instanceof zzfi) {
                ((zzfi) value).zzu();
            }
        }
        Iterator it = zzhdVar.zzd().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzfi) {
                ((zzfi) value2).zzu();
            }
        }
        zzhdVar.zza();
        this.zzc = true;
    }

    public final void zzh(zzey zzeyVar, Object obj) {
        if (!zzeyVar.zze()) {
            zzm(zzeyVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzm(zzeyVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzfv) {
            this.zzd = true;
        }
        this.zza.put(zzeyVar, obj);
    }

    public final boolean zzi() {
        zzhd zzhdVar = this.zza;
        int zzc = zzhdVar.zzc();
        for (int i = 0; i < zzc; i++) {
            if (!zzj(zzhdVar.zzg(i))) {
                return false;
            }
        }
        Iterator it = zzhdVar.zzd().iterator();
        while (it.hasNext()) {
            if (!zzj((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzez(boolean z) {
        zzg();
        zzg();
    }
}
