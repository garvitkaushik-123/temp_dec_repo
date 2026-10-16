package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzhav<T> implements zzhbl<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhce.zzi();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzhas zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzhbx zzm;
    private final zzgys zzn;

    private zzhav(int[] iArr, Object[] objArr, int i, int i2, zzhas zzhasVar, boolean z, int[] iArr2, int i3, int i4, zzhay zzhayVar, zzhaf zzhafVar, zzhbx zzhbxVar, zzgys zzgysVar, zzhan zzhanVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzhasVar instanceof zzgzh;
        boolean z2 = false;
        if (zzgysVar != null && (zzhasVar instanceof zzgzd)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzm = zzhbxVar;
        this.zzn = zzgysVar;
        this.zzg = zzhasVar;
    }

    private final Object zzA(Object obj, int i) {
        zzhbl zzx = zzx(i);
        int zzu = zzu(i) & 1048575;
        if (!zzN(obj, i)) {
            return zzx.zze();
        }
        Object object = zzb.getObject(obj, zzu);
        if (zzQ(object)) {
            return object;
        }
        Object zze = zzx.zze();
        if (object != null) {
            zzx.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzB(Object obj, int i, int i2) {
        zzhbl zzx = zzx(i2);
        if (!zzR(obj, i, i2)) {
            return zzx.zze();
        }
        Object object = zzb.getObject(obj, zzu(i2) & 1048575);
        if (zzQ(object)) {
            return object;
        }
        Object zze = zzx.zze();
        if (object != null) {
            zzx.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields), e);
        }
    }

    private static void zzD(Object obj) {
        if (!zzQ(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzE(Object obj, Object obj2, int i) {
        if (zzN(obj2, i)) {
            int zzu = zzu(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzu;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzhbl zzx = zzx(i);
            if (!zzN(obj, i)) {
                if (zzQ(object)) {
                    Object zze = zzx.zze();
                    zzx.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzH(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object zze2 = zzx.zze();
                zzx.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzx.zzg(object2, object);
        }
    }

    private final void zzF(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzR(obj2, i2, i)) {
            int zzu = zzu(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzu;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
            }
            zzhbl zzx = zzx(i);
            if (!zzR(obj, i2, i)) {
                if (zzQ(object)) {
                    Object zze = zzx.zze();
                    zzx.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzI(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object zze2 = zzx.zze();
                zzx.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzx.zzg(object2, object);
        }
    }

    private final void zzG(Object obj, int i, zzhbf zzhbfVar) throws IOException {
        long j = i & 1048575;
        if (zzM(i)) {
            zzhce.zzv(obj, j, zzhbfVar.zzs());
        } else if (this.zzi) {
            zzhce.zzv(obj, j, zzhbfVar.zzr());
        } else {
            zzhce.zzv(obj, j, zzhbfVar.zzp());
        }
    }

    private final void zzH(Object obj, int i) {
        int zzr = zzr(i);
        long j = 1048575 & zzr;
        if (j == 1048575) {
            return;
        }
        zzhce.zzt(obj, j, (1 << (zzr >>> 20)) | zzhce.zzd(obj, j));
    }

    private final void zzI(Object obj, int i, int i2) {
        zzhce.zzt(obj, zzr(i2) & 1048575, i);
    }

    private final void zzJ(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzu(i) & 1048575, obj2);
        zzH(obj, i);
    }

    private final void zzK(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzu(i2) & 1048575, obj2);
        zzI(obj, i, i2);
    }

    private final boolean zzL(Object obj, Object obj2, int i) {
        return zzN(obj, i) == zzN(obj2, i);
    }

    private static boolean zzM(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean zzN(Object obj, int i) {
        int zzr = zzr(i);
        long j = zzr & 1048575;
        if (j != 1048575) {
            return (zzhce.zzd(obj, j) & (1 << (zzr >>> 20))) != 0;
        }
        int zzu = zzu(i);
        long j2 = zzu & 1048575;
        switch (zzt(zzu)) {
            case 0:
                return Double.doubleToRawLongBits(zzhce.zzb(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhce.zzc(obj, j2)) != 0;
            case 2:
                return zzhce.zzf(obj, j2) != 0;
            case 3:
                return zzhce.zzf(obj, j2) != 0;
            case 4:
                return zzhce.zzd(obj, j2) != 0;
            case 5:
                return zzhce.zzf(obj, j2) != 0;
            case 6:
                return zzhce.zzd(obj, j2) != 0;
            case 7:
                return zzhce.zzz(obj, j2);
            case 8:
                Object zzh = zzhce.zzh(obj, j2);
                if (zzh instanceof String) {
                    return !((String) zzh).isEmpty();
                }
                if (zzh instanceof zzgxz) {
                    return !zzgxz.zzb.equals(zzh);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhce.zzh(obj, j2) != null;
            case 10:
                return !zzgxz.zzb.equals(zzhce.zzh(obj, j2));
            case 11:
                return zzhce.zzd(obj, j2) != 0;
            case 12:
                return zzhce.zzd(obj, j2) != 0;
            case 13:
                return zzhce.zzd(obj, j2) != 0;
            case 14:
                return zzhce.zzf(obj, j2) != 0;
            case 15:
                return zzhce.zzd(obj, j2) != 0;
            case 16:
                return zzhce.zzf(obj, j2) != 0;
            case 17:
                return zzhce.zzh(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzO(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzN(obj, i) : (i3 & i4) != 0;
    }

    private static boolean zzP(Object obj, int i, zzhbl zzhblVar) {
        return zzhblVar.zzl(zzhce.zzh(obj, i & 1048575));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzgzh) {
            return ((zzgzh) obj).zzcd();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i, int i2) {
        return zzhce.zzd(obj, (long) (zzr(i2) & 1048575)) == i;
    }

    private static boolean zzS(Object obj, long j) {
        return ((Boolean) zzhce.zzh(obj, j)).booleanValue();
    }

    private static final void zzT(int i, Object obj, zzhcm zzhcmVar) throws IOException {
        if (obj instanceof String) {
            zzhcmVar.zzG(i, (String) obj);
        } else {
            zzhcmVar.zzd(i, (zzgxz) obj);
        }
    }

    static zzhby zzd(Object obj) {
        zzgzh zzgzhVar = (zzgzh) obj;
        zzhby zzhbyVar = zzgzhVar.zzt;
        if (zzhbyVar != zzhby.zzc()) {
            return zzhbyVar;
        }
        zzhby zzf = zzhby.zzf();
        zzgzhVar.zzt = zzf;
        return zzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0270  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static zzhav zzm(Class cls, zzhap zzhapVar, zzhay zzhayVar, zzhaf zzhafVar, zzhbx zzhbxVar, zzgys zzgysVar, zzhan zzhanVar) {
        int i;
        int charAt;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int i7;
        int i8;
        char charAt2;
        int i9;
        char charAt3;
        int i10;
        char charAt4;
        int i11;
        char charAt5;
        int i12;
        char charAt6;
        int i13;
        char charAt7;
        int i14;
        char charAt8;
        int i15;
        char charAt9;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        String str;
        int objectFieldOffset;
        char c;
        int i21;
        int i22;
        int i23;
        int i24;
        Field zzC;
        char charAt10;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        Object obj;
        Field zzC2;
        Object obj2;
        Field zzC3;
        int i30;
        char charAt11;
        int i31;
        char charAt12;
        int i32;
        char charAt13;
        int i33;
        char charAt14;
        if (!(zzhapVar instanceof zzhbe)) {
            throw null;
        }
        zzhbe zzhbeVar = (zzhbe) zzhapVar;
        String zzd = zzhbeVar.zzd();
        int length = zzd.length();
        char c2 = 55296;
        if (zzd.charAt(0) >= 55296) {
            int i34 = 1;
            while (true) {
                i = i34 + 1;
                if (zzd.charAt(i34) < 55296) {
                    break;
                }
                i34 = i;
            }
        } else {
            i = 1;
        }
        int i35 = i + 1;
        int charAt15 = zzd.charAt(i);
        if (charAt15 >= 55296) {
            int i36 = charAt15 & 8191;
            int i37 = 13;
            while (true) {
                i33 = i35 + 1;
                charAt14 = zzd.charAt(i35);
                if (charAt14 < 55296) {
                    break;
                }
                i36 |= (charAt14 & 8191) << i37;
                i37 += 13;
                i35 = i33;
            }
            charAt15 = i36 | (charAt14 << i37);
            i35 = i33;
        }
        if (charAt15 == 0) {
            i3 = 0;
            i6 = 0;
            charAt = 0;
            i2 = 0;
            i4 = 0;
            i5 = 0;
            iArr = zza;
            i7 = 0;
        } else {
            int i38 = i35 + 1;
            int charAt16 = zzd.charAt(i35);
            if (charAt16 >= 55296) {
                int i39 = charAt16 & 8191;
                int i40 = 13;
                while (true) {
                    i15 = i38 + 1;
                    charAt9 = zzd.charAt(i38);
                    if (charAt9 < 55296) {
                        break;
                    }
                    i39 |= (charAt9 & 8191) << i40;
                    i40 += 13;
                    i38 = i15;
                }
                charAt16 = i39 | (charAt9 << i40);
                i38 = i15;
            }
            int i41 = i38 + 1;
            int charAt17 = zzd.charAt(i38);
            if (charAt17 >= 55296) {
                int i42 = charAt17 & 8191;
                int i43 = 13;
                while (true) {
                    i14 = i41 + 1;
                    charAt8 = zzd.charAt(i41);
                    if (charAt8 < 55296) {
                        break;
                    }
                    i42 |= (charAt8 & 8191) << i43;
                    i43 += 13;
                    i41 = i14;
                }
                charAt17 = i42 | (charAt8 << i43);
                i41 = i14;
            }
            int i44 = i41 + 1;
            int charAt18 = zzd.charAt(i41);
            if (charAt18 >= 55296) {
                int i45 = charAt18 & 8191;
                int i46 = 13;
                while (true) {
                    i13 = i44 + 1;
                    charAt7 = zzd.charAt(i44);
                    if (charAt7 < 55296) {
                        break;
                    }
                    i45 |= (charAt7 & 8191) << i46;
                    i46 += 13;
                    i44 = i13;
                }
                charAt18 = i45 | (charAt7 << i46);
                i44 = i13;
            }
            int i47 = i44 + 1;
            int charAt19 = zzd.charAt(i44);
            if (charAt19 >= 55296) {
                int i48 = charAt19 & 8191;
                int i49 = 13;
                while (true) {
                    i12 = i47 + 1;
                    charAt6 = zzd.charAt(i47);
                    if (charAt6 < 55296) {
                        break;
                    }
                    i48 |= (charAt6 & 8191) << i49;
                    i49 += 13;
                    i47 = i12;
                }
                charAt19 = i48 | (charAt6 << i49);
                i47 = i12;
            }
            int i50 = i47 + 1;
            charAt = zzd.charAt(i47);
            if (charAt >= 55296) {
                int i51 = charAt & 8191;
                int i52 = 13;
                while (true) {
                    i11 = i50 + 1;
                    charAt5 = zzd.charAt(i50);
                    if (charAt5 < 55296) {
                        break;
                    }
                    i51 |= (charAt5 & 8191) << i52;
                    i52 += 13;
                    i50 = i11;
                }
                charAt = i51 | (charAt5 << i52);
                i50 = i11;
            }
            int i53 = i50 + 1;
            int charAt20 = zzd.charAt(i50);
            if (charAt20 >= 55296) {
                int i54 = charAt20 & 8191;
                int i55 = 13;
                while (true) {
                    i10 = i53 + 1;
                    charAt4 = zzd.charAt(i53);
                    if (charAt4 < 55296) {
                        break;
                    }
                    i54 |= (charAt4 & 8191) << i55;
                    i55 += 13;
                    i53 = i10;
                }
                charAt20 = i54 | (charAt4 << i55);
                i53 = i10;
            }
            int i56 = i53 + 1;
            int charAt21 = zzd.charAt(i53);
            if (charAt21 >= 55296) {
                int i57 = charAt21 & 8191;
                int i58 = 13;
                while (true) {
                    i9 = i56 + 1;
                    charAt3 = zzd.charAt(i56);
                    if (charAt3 < 55296) {
                        break;
                    }
                    i57 |= (charAt3 & 8191) << i58;
                    i58 += 13;
                    i56 = i9;
                }
                charAt21 = i57 | (charAt3 << i58);
                i56 = i9;
            }
            int i59 = i56 + 1;
            int charAt22 = zzd.charAt(i56);
            if (charAt22 >= 55296) {
                int i60 = charAt22 & 8191;
                int i61 = 13;
                while (true) {
                    i8 = i59 + 1;
                    charAt2 = zzd.charAt(i59);
                    if (charAt2 < 55296) {
                        break;
                    }
                    i60 |= (charAt2 & 8191) << i61;
                    i61 += 13;
                    i59 = i8;
                }
                charAt22 = i60 | (charAt2 << i61);
                i59 = i8;
            }
            int i62 = charAt16 + charAt16 + charAt17;
            int[] iArr2 = new int[charAt22 + charAt20 + charAt21];
            int i63 = charAt20;
            i2 = charAt18;
            i3 = i63;
            i4 = charAt19;
            i5 = charAt22;
            i6 = i62;
            iArr = iArr2;
            i7 = charAt16;
            i35 = i59;
        }
        Unsafe unsafe = zzb;
        Object[] zze = zzhbeVar.zze();
        Class<?> cls2 = zzhbeVar.zza().getClass();
        int i64 = i5 + i3;
        int i65 = charAt + charAt;
        int[] iArr3 = new int[charAt * 3];
        Object[] objArr = new Object[i65];
        int i66 = i5;
        int i67 = i64;
        int i68 = 0;
        int i69 = 0;
        while (i35 < length) {
            int i70 = i35 + 1;
            int charAt23 = zzd.charAt(i35);
            if (charAt23 >= c2) {
                int i71 = charAt23 & 8191;
                int i72 = i70;
                int i73 = 13;
                while (true) {
                    i32 = i72 + 1;
                    charAt13 = zzd.charAt(i72);
                    if (charAt13 < c2) {
                        break;
                    }
                    i71 |= (charAt13 & 8191) << i73;
                    i73 += 13;
                    i72 = i32;
                }
                charAt23 = i71 | (charAt13 << i73);
                i16 = i32;
            } else {
                i16 = i70;
            }
            int i74 = i16 + 1;
            int charAt24 = zzd.charAt(i16);
            if (charAt24 >= c2) {
                int i75 = charAt24 & 8191;
                int i76 = i74;
                int i77 = 13;
                while (true) {
                    i31 = i76 + 1;
                    charAt12 = zzd.charAt(i76);
                    if (charAt12 < c2) {
                        break;
                    }
                    i75 |= (charAt12 & 8191) << i77;
                    i77 += 13;
                    i76 = i31;
                }
                charAt24 = i75 | (charAt12 << i77);
                i17 = i31;
            } else {
                i17 = i74;
            }
            if ((charAt24 & 1024) != 0) {
                iArr[i68] = i69;
                i68++;
            }
            int i78 = charAt24 & 255;
            zzhbe zzhbeVar2 = zzhbeVar;
            int i79 = charAt24 & 2048;
            if (i78 >= 51) {
                int i80 = i17 + 1;
                int charAt25 = zzd.charAt(i17);
                char c3 = 55296;
                if (charAt25 >= 55296) {
                    int i81 = charAt25 & 8191;
                    int i82 = i80;
                    int i83 = 13;
                    while (true) {
                        i30 = i82 + 1;
                        charAt11 = zzd.charAt(i82);
                        if (charAt11 < c3) {
                            break;
                        }
                        i81 |= (charAt11 & 8191) << i83;
                        i83 += 13;
                        i82 = i30;
                        c3 = 55296;
                    }
                    charAt25 = i81 | (charAt11 << i83);
                    i27 = i30;
                } else {
                    i27 = i80;
                }
                int i84 = i27;
                int i85 = i78 - 51;
                i18 = length;
                if (i85 == 9 || i85 == 17) {
                    i28 = i6 + 1;
                    int i86 = i69 / 3;
                    objArr[i86 + i86 + 1] = zze[i6];
                } else {
                    if (i85 == 12) {
                        if (zzhbeVar2.zzc() == 1 || i79 != 0) {
                            i28 = i6 + 1;
                            int i87 = i69 / 3;
                            objArr[i87 + i87 + 1] = zze[i6];
                        } else {
                            i29 = 0;
                            int i88 = charAt25 + charAt25;
                            obj = zze[i88];
                            int i89 = i29;
                            if (obj instanceof Field) {
                                zzC2 = (Field) obj;
                            } else {
                                zzC2 = zzC(cls2, (String) obj);
                                zze[i88] = zzC2;
                            }
                            int i90 = i7;
                            objectFieldOffset = (int) unsafe.objectFieldOffset(zzC2);
                            int i91 = i88 + 1;
                            obj2 = zze[i91];
                            i19 = i90;
                            if (obj2 instanceof Field) {
                                zzC3 = (Field) obj2;
                            } else {
                                zzC3 = zzC(cls2, (String) obj2);
                                zze[i91] = zzC3;
                            }
                            i21 = (int) unsafe.objectFieldOffset(zzC3);
                            str = zzd;
                            i23 = i89;
                            i17 = i84;
                            i22 = 0;
                            c = 55296;
                        }
                    }
                    i29 = i79;
                    int i882 = charAt25 + charAt25;
                    obj = zze[i882];
                    int i892 = i29;
                    if (obj instanceof Field) {
                    }
                    int i902 = i7;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zzC2);
                    int i912 = i882 + 1;
                    obj2 = zze[i912];
                    i19 = i902;
                    if (obj2 instanceof Field) {
                    }
                    i21 = (int) unsafe.objectFieldOffset(zzC3);
                    str = zzd;
                    i23 = i892;
                    i17 = i84;
                    i22 = 0;
                    c = 55296;
                }
                i6 = i28;
                i29 = i79;
                int i8822 = charAt25 + charAt25;
                obj = zze[i8822];
                int i8922 = i29;
                if (obj instanceof Field) {
                }
                int i9022 = i7;
                objectFieldOffset = (int) unsafe.objectFieldOffset(zzC2);
                int i9122 = i8822 + 1;
                obj2 = zze[i9122];
                i19 = i9022;
                if (obj2 instanceof Field) {
                }
                i21 = (int) unsafe.objectFieldOffset(zzC3);
                str = zzd;
                i23 = i8922;
                i17 = i84;
                i22 = 0;
                c = 55296;
            } else {
                i18 = length;
                i19 = i7;
                int i92 = i6 + 1;
                Field zzC4 = zzC(cls2, (String) zze[i6]);
                if (i78 == 9 || i78 == 17) {
                    i20 = i92;
                    int i93 = i69 / 3;
                    objArr[i93 + i93 + 1] = zzC4.getType();
                } else {
                    if (i78 == 27) {
                        i25 = i92;
                        i26 = 1;
                        i6 += 2;
                    } else if (i78 == 49) {
                        i6 += 2;
                        i25 = i92;
                        i26 = 1;
                    } else if (i78 == 12 || i78 == 30 || i78 == 44) {
                        if (zzhbeVar2.zzc() == 1 || i79 != 0) {
                            i6 += 2;
                            int i94 = i69 / 3;
                            objArr[i94 + i94 + 1] = zze[i92];
                            str = zzd;
                            objectFieldOffset = (int) unsafe.objectFieldOffset(zzC4);
                            if ((charAt24 & 4096) != 0 || i78 > 17) {
                                c = 55296;
                                i21 = 1048575;
                                i22 = 0;
                            } else {
                                int i95 = i17 + 1;
                                int charAt26 = str.charAt(i17);
                                if (charAt26 >= 55296) {
                                    int i96 = charAt26 & 8191;
                                    int i97 = 13;
                                    while (true) {
                                        i24 = i95 + 1;
                                        charAt10 = str.charAt(i95);
                                        if (charAt10 < 55296) {
                                            break;
                                        }
                                        i96 |= (charAt10 & 8191) << i97;
                                        i97 += 13;
                                        i95 = i24;
                                    }
                                    charAt26 = i96 | (charAt10 << i97);
                                } else {
                                    i24 = i95;
                                }
                                int i98 = i19 + i19 + (charAt26 / 32);
                                Object obj3 = zze[i98];
                                if (obj3 instanceof Field) {
                                    zzC = (Field) obj3;
                                } else {
                                    zzC = zzC(cls2, (String) obj3);
                                    zze[i98] = zzC;
                                }
                                int objectFieldOffset2 = (int) unsafe.objectFieldOffset(zzC);
                                i22 = charAt26 % 32;
                                i17 = i24;
                                c = 55296;
                                i21 = objectFieldOffset2;
                            }
                            if (i78 >= 18 && i78 <= 49) {
                                iArr[i67] = objectFieldOffset;
                                i67++;
                            }
                            i23 = i79;
                        } else {
                            str = zzd;
                            i6 = i92;
                            i79 = 0;
                            objectFieldOffset = (int) unsafe.objectFieldOffset(zzC4);
                            if ((charAt24 & 4096) != 0) {
                            }
                            c = 55296;
                            i21 = 1048575;
                            i22 = 0;
                            if (i78 >= 18) {
                                iArr[i67] = objectFieldOffset;
                                i67++;
                            }
                            i23 = i79;
                        }
                    } else if (i78 == 50) {
                        int i99 = i6 + 2;
                        int i100 = i66 + 1;
                        iArr[i66] = i69;
                        int i101 = i69 / 3;
                        int i102 = i101 + i101;
                        objArr[i102] = zze[i92];
                        if (i79 != 0) {
                            objArr[i102 + 1] = zze[i99];
                            i6 += 3;
                            str = zzd;
                            i66 = i100;
                            objectFieldOffset = (int) unsafe.objectFieldOffset(zzC4);
                            if ((charAt24 & 4096) != 0) {
                            }
                            c = 55296;
                            i21 = 1048575;
                            i22 = 0;
                            if (i78 >= 18) {
                            }
                            i23 = i79;
                        } else {
                            i6 = i99;
                            i66 = i100;
                            i79 = 0;
                            str = zzd;
                            objectFieldOffset = (int) unsafe.objectFieldOffset(zzC4);
                            if ((charAt24 & 4096) != 0) {
                            }
                            c = 55296;
                            i21 = 1048575;
                            i22 = 0;
                            if (i78 >= 18) {
                            }
                            i23 = i79;
                        }
                    } else {
                        i20 = i92;
                    }
                    int i103 = i69 / 3;
                    objArr[i103 + i103 + i26] = zze[i25];
                    str = zzd;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zzC4);
                    if ((charAt24 & 4096) != 0) {
                    }
                    c = 55296;
                    i21 = 1048575;
                    i22 = 0;
                    if (i78 >= 18) {
                    }
                    i23 = i79;
                }
                str = zzd;
                i6 = i20;
                objectFieldOffset = (int) unsafe.objectFieldOffset(zzC4);
                if ((charAt24 & 4096) != 0) {
                }
                c = 55296;
                i21 = 1048575;
                i22 = 0;
                if (i78 >= 18) {
                }
                i23 = i79;
            }
            int i104 = i69 + 1;
            iArr3[i69] = charAt23;
            int i105 = i69 + 2;
            iArr3[i104] = ((charAt24 & 512) != 0 ? 536870912 : 0) | ((charAt24 & 256) != 0 ? 268435456 : 0) | (i23 != 0 ? Integer.MIN_VALUE : 0) | (i78 << 20) | objectFieldOffset;
            i69 += 3;
            iArr3[i105] = (i22 << 20) | i21;
            i35 = i17;
            zzd = str;
            c2 = c;
            zzhbeVar = zzhbeVar2;
            length = i18;
            i7 = i19;
        }
        return new zzhav(iArr3, objArr, i2, i4, zzhbeVar.zza(), false, iArr, i5, i64, zzhayVar, zzhafVar, zzhbxVar, zzgysVar, zzhanVar);
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzhce.zzh(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzhce.zzh(obj, j)).floatValue();
    }

    private static int zzp(Object obj, long j) {
        return ((Integer) zzhce.zzh(obj, j)).intValue();
    }

    private final int zzq(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzs(i, 0);
    }

    private final int zzr(int i) {
        return this.zzc[i + 2];
    }

    private final int zzs(int i, int i2) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzt(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzu(int i) {
        return this.zzc[i + 1];
    }

    private static long zzv(Object obj, long j) {
        return ((Long) zzhce.zzh(obj, j)).longValue();
    }

    private final zzgzn zzw(int i) {
        int i2 = i / 3;
        return (zzgzn) this.zzd[i2 + i2 + 1];
    }

    private final zzhbl zzx(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzhbl zzhblVar = (zzhbl) objArr[i3];
        if (zzhblVar != null) {
            return zzhblVar;
        }
        zzhbl zzb2 = zzhbc.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzb2;
        return zzb2;
    }

    private final Object zzy(Object obj, int i, Object obj2, zzhbx zzhbxVar, Object obj3) {
        int i2 = this.zzc[i];
        Object zzh = zzhce.zzh(obj, zzu(i) & 1048575);
        if (zzh == null || zzw(i) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzz(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final int zza(Object obj) {
        int i;
        int zzD;
        int zzD2;
        int zzE;
        int zzD3;
        int zzD4;
        int zzD5;
        int zzd;
        int zzD6;
        int zzh;
        int zzg;
        int size;
        int zzl;
        int zzD7;
        int zzD8;
        int zzD9;
        int i2;
        int zze;
        int zzD10;
        int zzD11;
        int i3;
        int zzD12;
        int zzD13;
        int zzD14;
        int zzd2;
        int zzD15;
        zzhav<T> zzhavVar = this;
        Object obj2 = obj;
        Unsafe unsafe = zzb;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1048575;
        while (true) {
            int[] iArr = zzhavVar.zzc;
            if (i4 >= iArr.length) {
                int zza2 = i6 + ((zzgzh) obj).zzt.zza();
                if (!zzhavVar.zzh) {
                    return zza2;
                }
                zzhbt zzhbtVar = ((zzgzd) obj).zza.zza;
                int zzc = zzhbtVar.zzc();
                int i8 = 0;
                for (int i9 = 0; i9 < zzc; i9++) {
                    Map.Entry zzg2 = zzhbtVar.zzg(i9);
                    i8 += zzgyw.zzc((zzgyv) ((zzhbp) zzg2).zza(), zzg2.getValue());
                }
                for (Map.Entry entry : zzhbtVar.zzd()) {
                    i8 += zzgyw.zzc((zzgyv) entry.getKey(), entry.getValue());
                }
                return zza2 + i8;
            }
            int zzu = zzhavVar.zzu(i4);
            int zzt = zzt(zzu);
            int i10 = iArr[i4];
            int i11 = iArr[i4 + 2];
            int i12 = i11 & 1048575;
            if (zzt <= 17) {
                if (i12 != i7) {
                    i5 = i12 == 1048575 ? 0 : unsafe.getInt(obj2, i12);
                    i7 = i12;
                }
                i = 1 << (i11 >>> 20);
            } else {
                i = 0;
            }
            int i13 = zzu & 1048575;
            if (zzt >= zzgyx.DOUBLE_LIST_PACKED.zza()) {
                zzgyx.SINT64_LIST_PACKED.zza();
            }
            long j = i13;
            switch (zzt) {
                case 0:
                    if (zzhavVar.zzO(obj2, i4, i7, i5, i)) {
                        i6 += zzgym.zzD(i10 << 3) + 8;
                    }
                    i4 += 3;
                    obj2 = obj;
                case 1:
                    if (zzhavVar.zzO(obj2, i4, i7, i5, i)) {
                        zzD = zzgym.zzD(i10 << 3);
                        zzD4 = zzD + 4;
                        i6 += zzD4;
                    }
                    zzhavVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 2:
                    if (zzhavVar.zzO(obj2, i4, i7, i5, i)) {
                        long j2 = unsafe.getLong(obj2, j);
                        zzD2 = zzgym.zzD(i10 << 3);
                        zzE = zzgym.zzE(j2);
                        zzD4 = zzD2 + zzE;
                        i6 += zzD4;
                    }
                    zzhavVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 3:
                    if (zzhavVar.zzO(obj2, i4, i7, i5, i)) {
                        long j3 = unsafe.getLong(obj2, j);
                        zzD2 = zzgym.zzD(i10 << 3);
                        zzE = zzgym.zzE(j3);
                        zzD4 = zzD2 + zzE;
                        i6 += zzD4;
                    }
                    zzhavVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 4:
                    if (zzhavVar.zzO(obj2, i4, i7, i5, i)) {
                        long j4 = unsafe.getInt(obj2, j);
                        zzD2 = zzgym.zzD(i10 << 3);
                        zzE = zzgym.zzE(j4);
                        zzD4 = zzD2 + zzE;
                        i6 += zzD4;
                    }
                    zzhavVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 5:
                    if (zzhavVar.zzO(obj2, i4, i7, i5, i)) {
                        zzD3 = zzgym.zzD(i10 << 3);
                        zzD4 = zzD3 + 8;
                        i6 += zzD4;
                    }
                    zzhavVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 6:
                    if (zzhavVar.zzO(obj2, i4, i7, i5, i)) {
                        zzD = zzgym.zzD(i10 << 3);
                        zzD4 = zzD + 4;
                        i6 += zzD4;
                    }
                    zzhavVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 7:
                    if (zzhavVar.zzO(obj2, i4, i7, i5, i)) {
                        zzD4 = zzgym.zzD(i10 << 3) + 1;
                        i6 += zzD4;
                    }
                    zzhavVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 8:
                    if (zzhavVar.zzO(obj2, i4, i7, i5, i)) {
                        int i14 = i10 << 3;
                        Object object = unsafe.getObject(obj2, j);
                        if (object instanceof zzgxz) {
                            zzD5 = zzgym.zzD(i14);
                            zzd = ((zzgxz) object).zzd();
                            zzD6 = zzgym.zzD(zzd);
                            zzD4 = zzD5 + zzD6 + zzd;
                            i6 += zzD4;
                        } else {
                            zzD2 = zzgym.zzD(i14);
                            zzE = zzgym.zzC((String) object);
                            zzD4 = zzD2 + zzE;
                            i6 += zzD4;
                        }
                    }
                    zzhavVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 9:
                    if (zzhavVar.zzO(obj2, i4, i7, i5, i)) {
                        zzh = zzhbn.zzh(i10, unsafe.getObject(obj2, j), zzhavVar.zzx(i4));
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 10:
                    if (zzhavVar.zzO(obj2, i4, i7, i5, i)) {
                        zzgxz zzgxzVar = (zzgxz) unsafe.getObject(obj2, j);
                        zzD5 = zzgym.zzD(i10 << 3);
                        zzd = zzgxzVar.zzd();
                        zzD6 = zzgym.zzD(zzd);
                        zzD4 = zzD5 + zzD6 + zzd;
                        i6 += zzD4;
                    }
                    zzhavVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 11:
                    if (zzhavVar.zzO(obj2, i4, i7, i5, i)) {
                        int i15 = unsafe.getInt(obj2, j);
                        zzD2 = zzgym.zzD(i10 << 3);
                        zzE = zzgym.zzD(i15);
                        zzD4 = zzD2 + zzE;
                        i6 += zzD4;
                    }
                    zzhavVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 12:
                    if (zzhavVar.zzO(obj2, i4, i7, i5, i)) {
                        long j5 = unsafe.getInt(obj2, j);
                        zzD2 = zzgym.zzD(i10 << 3);
                        zzE = zzgym.zzE(j5);
                        zzD4 = zzD2 + zzE;
                        i6 += zzD4;
                    }
                    zzhavVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 13:
                    if (zzhavVar.zzO(obj2, i4, i7, i5, i)) {
                        zzD = zzgym.zzD(i10 << 3);
                        zzD4 = zzD + 4;
                        i6 += zzD4;
                    }
                    zzhavVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 14:
                    if (zzhavVar.zzO(obj2, i4, i7, i5, i)) {
                        zzD3 = zzgym.zzD(i10 << 3);
                        zzD4 = zzD3 + 8;
                        i6 += zzD4;
                    }
                    zzhavVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 15:
                    if (zzhavVar.zzO(obj2, i4, i7, i5, i)) {
                        int i16 = unsafe.getInt(obj2, j);
                        zzD2 = zzgym.zzD(i10 << 3);
                        zzE = zzgym.zzD((i16 >> 31) ^ (i16 + i16));
                        zzD4 = zzD2 + zzE;
                        i6 += zzD4;
                    }
                    zzhavVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 16:
                    if (zzhavVar.zzO(obj2, i4, i7, i5, i)) {
                        long j6 = unsafe.getLong(obj2, j);
                        zzD2 = zzgym.zzD(i10 << 3);
                        zzE = zzgym.zzE((j6 >> 63) ^ (j6 + j6));
                        zzD4 = zzD2 + zzE;
                        i6 += zzD4;
                    }
                    zzhavVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 17:
                    if (zzhavVar.zzO(obj2, i4, i7, i5, i)) {
                        zzh = zzgym.zzy(i10, (zzhas) unsafe.getObject(obj2, j), zzhavVar.zzx(i4));
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 18:
                    zzh = zzhbn.zzd(i10, (List) unsafe.getObject(obj2, j), false);
                    i6 += zzh;
                    i4 += 3;
                    obj2 = obj;
                case 19:
                    zzh = zzhbn.zzb(i10, (List) unsafe.getObject(obj2, j), false);
                    i6 += zzh;
                    i4 += 3;
                    obj2 = obj;
                case 20:
                    List list = (List) unsafe.getObject(obj2, j);
                    int i17 = zzhbn.zza;
                    if (list.size() != 0) {
                        zzg = zzhbn.zzg(list) + (list.size() * zzgym.zzD(i10 << 3));
                        i6 += zzg;
                        i4 += 3;
                        obj2 = obj;
                    }
                    zzg = 0;
                    i6 += zzg;
                    i4 += 3;
                    obj2 = obj;
                case 21:
                    List list2 = (List) unsafe.getObject(obj2, j);
                    int i18 = zzhbn.zza;
                    size = list2.size();
                    if (size != 0) {
                        zzl = zzhbn.zzl(list2);
                        zzD7 = zzgym.zzD(i10 << 3);
                        i2 = size * zzD7;
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    }
                    zzh = 0;
                    i6 += zzh;
                    i4 += 3;
                    obj2 = obj;
                case 22:
                    List list3 = (List) unsafe.getObject(obj2, j);
                    int i19 = zzhbn.zza;
                    size = list3.size();
                    if (size != 0) {
                        zzl = zzhbn.zzf(list3);
                        zzD7 = zzgym.zzD(i10 << 3);
                        i2 = size * zzD7;
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    }
                    zzh = 0;
                    i6 += zzh;
                    i4 += 3;
                    obj2 = obj;
                case 23:
                    zzh = zzhbn.zzd(i10, (List) unsafe.getObject(obj2, j), false);
                    i6 += zzh;
                    i4 += 3;
                    obj2 = obj;
                case 24:
                    zzh = zzhbn.zzb(i10, (List) unsafe.getObject(obj2, j), false);
                    i6 += zzh;
                    i4 += 3;
                    obj2 = obj;
                case 25:
                    List list4 = (List) unsafe.getObject(obj2, j);
                    int i20 = zzhbn.zza;
                    int size2 = list4.size();
                    if (size2 != 0) {
                        zzh = size2 * (zzgym.zzD(i10 << 3) + 1);
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    }
                    zzh = 0;
                    i6 += zzh;
                    i4 += 3;
                    obj2 = obj;
                case 26:
                    List list5 = (List) unsafe.getObject(obj2, j);
                    int i21 = zzhbn.zza;
                    int size3 = list5.size();
                    if (size3 != 0) {
                        zzg = zzgym.zzD(i10 << 3) * size3;
                        if (list5 instanceof zzhae) {
                            zzhae zzhaeVar = (zzhae) list5;
                            for (int i22 = 0; i22 < size3; i22++) {
                                Object zzc2 = zzhaeVar.zzc();
                                if (zzc2 instanceof zzgxz) {
                                    int zzd3 = ((zzgxz) zzc2).zzd();
                                    zzg += zzgym.zzD(zzd3) + zzd3;
                                } else {
                                    zzg += zzgym.zzC((String) zzc2);
                                }
                            }
                        } else {
                            for (int i23 = 0; i23 < size3; i23++) {
                                Object obj3 = list5.get(i23);
                                if (obj3 instanceof zzgxz) {
                                    int zzd4 = ((zzgxz) obj3).zzd();
                                    zzg += zzgym.zzD(zzd4) + zzd4;
                                } else {
                                    zzg += zzgym.zzC((String) obj3);
                                }
                            }
                        }
                        i6 += zzg;
                        i4 += 3;
                        obj2 = obj;
                    }
                    zzg = 0;
                    i6 += zzg;
                    i4 += 3;
                    obj2 = obj;
                case 27:
                    List list6 = (List) unsafe.getObject(obj2, j);
                    zzhbl zzx = zzhavVar.zzx(i4);
                    int i24 = zzhbn.zza;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        zzD8 = 0;
                    } else {
                        zzD8 = zzgym.zzD(i10 << 3) * size4;
                        for (int i25 = 0; i25 < size4; i25++) {
                            Object obj4 = list6.get(i25);
                            if (obj4 instanceof zzhad) {
                                int zza3 = ((zzhad) obj4).zza();
                                zzD8 += zzgym.zzD(zza3) + zza3;
                            } else {
                                zzD8 += zzgym.zzA((zzhas) obj4, zzx);
                            }
                        }
                    }
                    i6 += zzD8;
                    i4 += 3;
                    obj2 = obj;
                case 28:
                    List list7 = (List) unsafe.getObject(obj2, j);
                    int i26 = zzhbn.zza;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        zzD9 = 0;
                    } else {
                        zzD9 = size5 * zzgym.zzD(i10 << 3);
                        for (int i27 = 0; i27 < list7.size(); i27++) {
                            int zzd5 = ((zzgxz) list7.get(i27)).zzd();
                            zzD9 += zzgym.zzD(zzd5) + zzd5;
                        }
                    }
                    i6 += zzD9;
                    i4 += 3;
                    obj2 = obj;
                case 29:
                    List list8 = (List) unsafe.getObject(obj2, j);
                    int i28 = zzhbn.zza;
                    size = list8.size();
                    if (size != 0) {
                        zzl = zzhbn.zzk(list8);
                        zzD7 = zzgym.zzD(i10 << 3);
                        i2 = size * zzD7;
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    }
                    zzh = 0;
                    i6 += zzh;
                    i4 += 3;
                    obj2 = obj;
                case 30:
                    List list9 = (List) unsafe.getObject(obj2, j);
                    int i29 = zzhbn.zza;
                    size = list9.size();
                    if (size != 0) {
                        zzl = zzhbn.zza(list9);
                        zzD7 = zzgym.zzD(i10 << 3);
                        i2 = size * zzD7;
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    }
                    zzh = 0;
                    i6 += zzh;
                    i4 += 3;
                    obj2 = obj;
                case 31:
                    zzh = zzhbn.zzb(i10, (List) unsafe.getObject(obj2, j), false);
                    i6 += zzh;
                    i4 += 3;
                    obj2 = obj;
                case 32:
                    zzh = zzhbn.zzd(i10, (List) unsafe.getObject(obj2, j), false);
                    i6 += zzh;
                    i4 += 3;
                    obj2 = obj;
                case 33:
                    List list10 = (List) unsafe.getObject(obj2, j);
                    int i30 = zzhbn.zza;
                    size = list10.size();
                    if (size != 0) {
                        zzl = zzhbn.zzi(list10);
                        zzD7 = zzgym.zzD(i10 << 3);
                        i2 = size * zzD7;
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    }
                    zzh = 0;
                    i6 += zzh;
                    i4 += 3;
                    obj2 = obj;
                case 34:
                    List list11 = (List) unsafe.getObject(obj2, j);
                    int i31 = zzhbn.zza;
                    size = list11.size();
                    if (size != 0) {
                        zzl = zzhbn.zzj(list11);
                        zzD7 = zzgym.zzD(i10 << 3);
                        i2 = size * zzD7;
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    }
                    zzh = 0;
                    i6 += zzh;
                    i4 += 3;
                    obj2 = obj;
                case 35:
                    zze = zzhbn.zze((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzD10 = zzgym.zzD(i10 << 3);
                        zzD11 = zzgym.zzD(zze);
                        zzD9 = zzD10 + zzD11 + zze;
                        i6 += zzD9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 36:
                    zze = zzhbn.zzc((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzD10 = zzgym.zzD(i10 << 3);
                        zzD11 = zzgym.zzD(zze);
                        zzD9 = zzD10 + zzD11 + zze;
                        i6 += zzD9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 37:
                    zze = zzhbn.zzg((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzD10 = zzgym.zzD(i10 << 3);
                        zzD11 = zzgym.zzD(zze);
                        zzD9 = zzD10 + zzD11 + zze;
                        i6 += zzD9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 38:
                    zze = zzhbn.zzl((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzD10 = zzgym.zzD(i10 << 3);
                        zzD11 = zzgym.zzD(zze);
                        zzD9 = zzD10 + zzD11 + zze;
                        i6 += zzD9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 39:
                    zze = zzhbn.zzf((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzD10 = zzgym.zzD(i10 << 3);
                        zzD11 = zzgym.zzD(zze);
                        zzD9 = zzD10 + zzD11 + zze;
                        i6 += zzD9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 40:
                    zze = zzhbn.zze((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzD10 = zzgym.zzD(i10 << 3);
                        zzD11 = zzgym.zzD(zze);
                        zzD9 = zzD10 + zzD11 + zze;
                        i6 += zzD9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 41:
                    zze = zzhbn.zzc((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzD10 = zzgym.zzD(i10 << 3);
                        zzD11 = zzgym.zzD(zze);
                        zzD9 = zzD10 + zzD11 + zze;
                        i6 += zzD9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 42:
                    List list12 = (List) unsafe.getObject(obj2, j);
                    int i32 = zzhbn.zza;
                    zze = list12.size();
                    if (zze > 0) {
                        zzD10 = zzgym.zzD(i10 << 3);
                        zzD11 = zzgym.zzD(zze);
                        zzD9 = zzD10 + zzD11 + zze;
                        i6 += zzD9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 43:
                    zze = zzhbn.zzk((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzD10 = zzgym.zzD(i10 << 3);
                        zzD11 = zzgym.zzD(zze);
                        zzD9 = zzD10 + zzD11 + zze;
                        i6 += zzD9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 44:
                    zze = zzhbn.zza((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzD10 = zzgym.zzD(i10 << 3);
                        zzD11 = zzgym.zzD(zze);
                        zzD9 = zzD10 + zzD11 + zze;
                        i6 += zzD9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 45:
                    zze = zzhbn.zzc((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzD10 = zzgym.zzD(i10 << 3);
                        zzD11 = zzgym.zzD(zze);
                        zzD9 = zzD10 + zzD11 + zze;
                        i6 += zzD9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 46:
                    zze = zzhbn.zze((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzD10 = zzgym.zzD(i10 << 3);
                        zzD11 = zzgym.zzD(zze);
                        zzD9 = zzD10 + zzD11 + zze;
                        i6 += zzD9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 47:
                    zze = zzhbn.zzi((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzD10 = zzgym.zzD(i10 << 3);
                        zzD11 = zzgym.zzD(zze);
                        zzD9 = zzD10 + zzD11 + zze;
                        i6 += zzD9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 48:
                    zze = zzhbn.zzj((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzD10 = zzgym.zzD(i10 << 3);
                        zzD11 = zzgym.zzD(zze);
                        zzD9 = zzD10 + zzD11 + zze;
                        i6 += zzD9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 49:
                    List list13 = (List) unsafe.getObject(obj2, j);
                    zzhbl zzx2 = zzhavVar.zzx(i4);
                    int i33 = zzhbn.zza;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        i3 = 0;
                    } else {
                        i3 = 0;
                        for (int i34 = 0; i34 < size6; i34++) {
                            i3 += zzgym.zzy(i10, (zzhas) list13.get(i34), zzx2);
                        }
                    }
                    i6 += i3;
                    i4 += 3;
                    obj2 = obj;
                case 50:
                    zzham zzhamVar = (zzham) unsafe.getObject(obj2, j);
                    if (zzhamVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzhamVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry2 = (Map.Entry) it.next();
                            entry2.getKey();
                            entry2.getValue();
                            throw null;
                        }
                    }
                    i4 += 3;
                    obj2 = obj;
                case 51:
                    if (zzhavVar.zzR(obj2, i10, i4)) {
                        zzD12 = zzgym.zzD(i10 << 3);
                        zzh = zzD12 + 8;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 52:
                    if (zzhavVar.zzR(obj2, i10, i4)) {
                        zzD13 = zzgym.zzD(i10 << 3);
                        zzh = zzD13 + 4;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 53:
                    if (zzhavVar.zzR(obj2, i10, i4)) {
                        long zzv = zzv(obj2, j);
                        zzl = zzgym.zzD(i10 << 3);
                        i2 = zzgym.zzE(zzv);
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 54:
                    if (zzhavVar.zzR(obj2, i10, i4)) {
                        long zzv2 = zzv(obj2, j);
                        zzl = zzgym.zzD(i10 << 3);
                        i2 = zzgym.zzE(zzv2);
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 55:
                    if (zzhavVar.zzR(obj2, i10, i4)) {
                        long zzp = zzp(obj2, j);
                        zzl = zzgym.zzD(i10 << 3);
                        i2 = zzgym.zzE(zzp);
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 56:
                    if (zzhavVar.zzR(obj2, i10, i4)) {
                        zzD12 = zzgym.zzD(i10 << 3);
                        zzh = zzD12 + 8;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 57:
                    if (zzhavVar.zzR(obj2, i10, i4)) {
                        zzD13 = zzgym.zzD(i10 << 3);
                        zzh = zzD13 + 4;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 58:
                    if (zzhavVar.zzR(obj2, i10, i4)) {
                        zzh = zzgym.zzD(i10 << 3) + 1;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 59:
                    if (zzhavVar.zzR(obj2, i10, i4)) {
                        int i35 = i10 << 3;
                        Object object2 = unsafe.getObject(obj2, j);
                        if (object2 instanceof zzgxz) {
                            zzD14 = zzgym.zzD(i35);
                            zzd2 = ((zzgxz) object2).zzd();
                            zzD15 = zzgym.zzD(zzd2);
                            zzh = zzD14 + zzD15 + zzd2;
                            i6 += zzh;
                            i4 += 3;
                            obj2 = obj;
                        } else {
                            zzl = zzgym.zzD(i35);
                            i2 = zzgym.zzC((String) object2);
                            zzh = zzl + i2;
                            i6 += zzh;
                            i4 += 3;
                            obj2 = obj;
                        }
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 60:
                    if (zzhavVar.zzR(obj2, i10, i4)) {
                        zzh = zzhbn.zzh(i10, unsafe.getObject(obj2, j), zzhavVar.zzx(i4));
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 61:
                    if (zzhavVar.zzR(obj2, i10, i4)) {
                        zzgxz zzgxzVar2 = (zzgxz) unsafe.getObject(obj2, j);
                        zzD14 = zzgym.zzD(i10 << 3);
                        zzd2 = zzgxzVar2.zzd();
                        zzD15 = zzgym.zzD(zzd2);
                        zzh = zzD14 + zzD15 + zzd2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 62:
                    if (zzhavVar.zzR(obj2, i10, i4)) {
                        int zzp2 = zzp(obj2, j);
                        zzl = zzgym.zzD(i10 << 3);
                        i2 = zzgym.zzD(zzp2);
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 63:
                    if (zzhavVar.zzR(obj2, i10, i4)) {
                        long zzp3 = zzp(obj2, j);
                        zzl = zzgym.zzD(i10 << 3);
                        i2 = zzgym.zzE(zzp3);
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 64:
                    if (zzhavVar.zzR(obj2, i10, i4)) {
                        zzD13 = zzgym.zzD(i10 << 3);
                        zzh = zzD13 + 4;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 65:
                    if (zzhavVar.zzR(obj2, i10, i4)) {
                        zzD12 = zzgym.zzD(i10 << 3);
                        zzh = zzD12 + 8;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 66:
                    if (zzhavVar.zzR(obj2, i10, i4)) {
                        int zzp4 = zzp(obj2, j);
                        zzl = zzgym.zzD(i10 << 3);
                        i2 = zzgym.zzD((zzp4 >> 31) ^ (zzp4 + zzp4));
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 67:
                    if (zzhavVar.zzR(obj2, i10, i4)) {
                        long zzv3 = zzv(obj2, j);
                        zzl = zzgym.zzD(i10 << 3);
                        i2 = zzgym.zzE((zzv3 >> 63) ^ (zzv3 + zzv3));
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 68:
                    if (zzhavVar.zzR(obj2, i10, i4)) {
                        zzh = zzgym.zzy(i10, (zzhas) unsafe.getObject(obj2, j), zzhavVar.zzx(i4));
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                default:
                    i4 += 3;
                    obj2 = obj;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final int zzb(Object obj) {
        int i;
        long doubleToLongBits;
        int floatToIntBits;
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i3 >= iArr.length) {
                int hashCode = (i4 * 53) + ((zzgzh) obj).zzt.hashCode();
                return this.zzh ? (hashCode * 53) + ((zzgzd) obj).zza.zza.hashCode() : hashCode;
            }
            int zzu = zzu(i3);
            int i5 = 1048575 & zzu;
            int zzt = zzt(zzu);
            int i6 = iArr[i3];
            long j = i5;
            int i7 = 37;
            switch (zzt) {
                case 0:
                    i = i4 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zzhce.zzb(obj, j));
                    byte[] bArr = zzgzu.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i4 = i + floatToIntBits;
                    break;
                case 1:
                    i = i4 * 53;
                    floatToIntBits = Float.floatToIntBits(zzhce.zzc(obj, j));
                    i4 = i + floatToIntBits;
                    break;
                case 2:
                    i = i4 * 53;
                    doubleToLongBits = zzhce.zzf(obj, j);
                    byte[] bArr2 = zzgzu.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i4 = i + floatToIntBits;
                    break;
                case 3:
                    i = i4 * 53;
                    doubleToLongBits = zzhce.zzf(obj, j);
                    byte[] bArr3 = zzgzu.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i4 = i + floatToIntBits;
                    break;
                case 4:
                    i = i4 * 53;
                    floatToIntBits = zzhce.zzd(obj, j);
                    i4 = i + floatToIntBits;
                    break;
                case 5:
                    i = i4 * 53;
                    doubleToLongBits = zzhce.zzf(obj, j);
                    byte[] bArr4 = zzgzu.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i4 = i + floatToIntBits;
                    break;
                case 6:
                    i = i4 * 53;
                    floatToIntBits = zzhce.zzd(obj, j);
                    i4 = i + floatToIntBits;
                    break;
                case 7:
                    i = i4 * 53;
                    floatToIntBits = zzgzu.zza(zzhce.zzz(obj, j));
                    i4 = i + floatToIntBits;
                    break;
                case 8:
                    i = i4 * 53;
                    floatToIntBits = ((String) zzhce.zzh(obj, j)).hashCode();
                    i4 = i + floatToIntBits;
                    break;
                case 9:
                    i2 = i4 * 53;
                    Object zzh = zzhce.zzh(obj, j);
                    if (zzh != null) {
                        i7 = zzh.hashCode();
                    }
                    i4 = i2 + i7;
                    break;
                case 10:
                    i = i4 * 53;
                    floatToIntBits = zzhce.zzh(obj, j).hashCode();
                    i4 = i + floatToIntBits;
                    break;
                case 11:
                    i = i4 * 53;
                    floatToIntBits = zzhce.zzd(obj, j);
                    i4 = i + floatToIntBits;
                    break;
                case 12:
                    i = i4 * 53;
                    floatToIntBits = zzhce.zzd(obj, j);
                    i4 = i + floatToIntBits;
                    break;
                case 13:
                    i = i4 * 53;
                    floatToIntBits = zzhce.zzd(obj, j);
                    i4 = i + floatToIntBits;
                    break;
                case 14:
                    i = i4 * 53;
                    doubleToLongBits = zzhce.zzf(obj, j);
                    byte[] bArr5 = zzgzu.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i4 = i + floatToIntBits;
                    break;
                case 15:
                    i = i4 * 53;
                    floatToIntBits = zzhce.zzd(obj, j);
                    i4 = i + floatToIntBits;
                    break;
                case 16:
                    i = i4 * 53;
                    doubleToLongBits = zzhce.zzf(obj, j);
                    byte[] bArr6 = zzgzu.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i4 = i + floatToIntBits;
                    break;
                case 17:
                    i2 = i4 * 53;
                    Object zzh2 = zzhce.zzh(obj, j);
                    if (zzh2 != null) {
                        i7 = zzh2.hashCode();
                    }
                    i4 = i2 + i7;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i4 * 53;
                    floatToIntBits = zzhce.zzh(obj, j).hashCode();
                    i4 = i + floatToIntBits;
                    break;
                case 50:
                    i = i4 * 53;
                    floatToIntBits = zzhce.zzh(obj, j).hashCode();
                    i4 = i + floatToIntBits;
                    break;
                case 51:
                    if (!zzR(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzn(obj, j));
                        byte[] bArr7 = zzgzu.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 52:
                    if (!zzR(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = Float.floatToIntBits(zzo(obj, j));
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 53:
                    if (!zzR(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        doubleToLongBits = zzv(obj, j);
                        byte[] bArr8 = zzgzu.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 54:
                    if (!zzR(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        doubleToLongBits = zzv(obj, j);
                        byte[] bArr9 = zzgzu.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 55:
                    if (!zzR(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzp(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 56:
                    if (!zzR(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        doubleToLongBits = zzv(obj, j);
                        byte[] bArr10 = zzgzu.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 57:
                    if (!zzR(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzp(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 58:
                    if (!zzR(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzgzu.zza(zzS(obj, j));
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 59:
                    if (!zzR(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = ((String) zzhce.zzh(obj, j)).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 60:
                    if (!zzR(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzhce.zzh(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 61:
                    if (!zzR(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzhce.zzh(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 62:
                    if (!zzR(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzp(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 63:
                    if (!zzR(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzp(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 64:
                    if (!zzR(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzp(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 65:
                    if (!zzR(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        doubleToLongBits = zzv(obj, j);
                        byte[] bArr11 = zzgzu.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 66:
                    if (!zzR(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzp(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 67:
                    if (!zzR(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        doubleToLongBits = zzv(obj, j);
                        byte[] bArr12 = zzgzu.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 68:
                    if (!zzR(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzhce.zzh(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    }
            }
            i3 += 3;
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    final int zzc(java.lang.Object r31, byte[] r32, int r33, int r34, int r35, com.google.android.gms.internal.ads.zzgxn r36) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhav.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzgxn):int");
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final Object zze() {
        return ((zzgzh) this.zzg).zzbj();
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final void zzf(Object obj) {
        if (zzQ(obj)) {
            if (obj instanceof zzgzh) {
                zzgzh zzgzhVar = (zzgzh) obj;
                zzgzhVar.zzbT();
                zzgzhVar.zzbS();
                zzgzhVar.zzbV();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int zzu = zzu(i);
                int i2 = 1048575 & zzu;
                int zzt = zzt(zzu);
                long j = i2;
                if (zzt != 9) {
                    if (zzt != 60 && zzt != 68) {
                        switch (zzt) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                ((zzgzt) zzhce.zzh(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzham) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzR(obj, iArr[i], i)) {
                        zzx(i).zzf(zzb.getObject(obj, j));
                    }
                }
                if (zzN(obj, i)) {
                    zzx(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzm.zzi(obj);
            if (this.zzh) {
                this.zzn.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zzhbn.zzq(this.zzm, obj, obj2);
                if (this.zzh) {
                    zzhbn.zzp(this.zzn, obj, obj2);
                    return;
                }
                return;
            }
            int zzu = zzu(i);
            int i2 = 1048575 & zzu;
            int zzt = zzt(zzu);
            int i3 = iArr[i];
            long j = i2;
            switch (zzt) {
                case 0:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhce.zzr(obj, j, zzhce.zzb(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 1:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhce.zzs(obj, j, zzhce.zzc(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 2:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhce.zzu(obj, j, zzhce.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 3:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhce.zzu(obj, j, zzhce.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 4:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhce.zzt(obj, j, zzhce.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 5:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhce.zzu(obj, j, zzhce.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 6:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhce.zzt(obj, j, zzhce.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 7:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhce.zzp(obj, j, zzhce.zzz(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 8:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhce.zzv(obj, j, zzhce.zzh(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 9:
                    zzE(obj, obj2, i);
                    break;
                case 10:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhce.zzv(obj, j, zzhce.zzh(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 11:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhce.zzt(obj, j, zzhce.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 12:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhce.zzt(obj, j, zzhce.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 13:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhce.zzt(obj, j, zzhce.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 14:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhce.zzu(obj, j, zzhce.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 15:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhce.zzt(obj, j, zzhce.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 16:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhce.zzu(obj, j, zzhce.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 17:
                    zzE(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzgzt zzgztVar = (zzgzt) zzhce.zzh(obj, j);
                    zzgzt zzgztVar2 = (zzgzt) zzhce.zzh(obj2, j);
                    int size = zzgztVar.size();
                    int size2 = zzgztVar2.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzgztVar.zzc()) {
                            zzgztVar = zzgztVar.zzf(size2 + size);
                        }
                        zzgztVar.addAll(zzgztVar2);
                    }
                    if (size > 0) {
                        zzgztVar2 = zzgztVar;
                    }
                    zzhce.zzv(obj, j, zzgztVar2);
                    break;
                case 50:
                    int i4 = zzhbn.zza;
                    zzhce.zzv(obj, j, zzhan.zzb(zzhce.zzh(obj, j), zzhce.zzh(obj2, j)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzR(obj2, i3, i)) {
                        break;
                    } else {
                        zzhce.zzv(obj, j, zzhce.zzh(obj2, j));
                        zzI(obj, i3, i);
                        break;
                    }
                case 60:
                    zzF(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzR(obj2, i3, i)) {
                        break;
                    } else {
                        zzhce.zzv(obj, j, zzhce.zzh(obj2, j));
                        zzI(obj, i3, i);
                        break;
                    }
                case 68:
                    zzF(obj, obj2, i);
                    break;
            }
            i += 3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x05ff A[LOOP:1: B:38:0x05fb->B:40:0x05ff, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x060e  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x05cc A[Catch: all -> 0x05c3, TRY_ENTER, TryCatch #1 {all -> 0x05c3, blocks: (B:52:0x05ab, B:69:0x05cc, B:70:0x05d0), top: B:51:0x05ab }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x05d6 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhbl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzh(Object obj, zzhbf zzhbfVar, zzgyr zzgyrVar) throws IOException {
        Object obj2;
        Object obj3;
        zzhav<T> zzhavVar;
        Throwable th;
        int i;
        zzhbx zzhbxVar;
        Object obj4;
        Object obj5;
        Object obj6;
        zzgyrVar.getClass();
        zzD(obj);
        zzhbx zzhbxVar2 = this.zzm;
        Object obj7 = null;
        while (true) {
            try {
                int zzc = zzhbfVar.zzc();
                int zzq = zzq(zzc);
                if (zzq >= 0) {
                    obj5 = obj;
                    zzhbxVar = zzhbxVar2;
                    zzhavVar = this;
                    obj4 = obj7;
                    try {
                        int zzu = zzu(zzq);
                        try {
                        } catch (zzgzv unused) {
                            obj2 = obj5;
                        }
                        switch (zzt(zzu)) {
                            case 0:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhce.zzr(obj2, zzu & 1048575, zzhbfVar.zza());
                                zzH(obj2, zzq);
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 1:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhce.zzs(obj2, zzu & 1048575, zzhbfVar.zzb());
                                zzH(obj2, zzq);
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 2:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhce.zzu(obj2, zzu & 1048575, zzhbfVar.zzl());
                                zzH(obj2, zzq);
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 3:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhce.zzu(obj2, zzu & 1048575, zzhbfVar.zzo());
                                zzH(obj2, zzq);
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 4:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhce.zzt(obj2, zzu & 1048575, zzhbfVar.zzg());
                                zzH(obj2, zzq);
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 5:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhce.zzu(obj2, zzu & 1048575, zzhbfVar.zzk());
                                zzH(obj2, zzq);
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 6:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhce.zzt(obj2, zzu & 1048575, zzhbfVar.zzf());
                                zzH(obj2, zzq);
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 7:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhce.zzp(obj2, zzu & 1048575, zzhbfVar.zzN());
                                zzH(obj2, zzq);
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 8:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzG(obj2, zzu, zzhbfVar);
                                zzH(obj2, zzq);
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 9:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhas zzhasVar = (zzhas) zzA(obj2, zzq);
                                zzhbfVar.zzu(zzhasVar, zzx(zzq), zzgyrVar);
                                zzJ(obj2, zzq, zzhasVar);
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 10:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhce.zzv(obj2, zzu & 1048575, zzhbfVar.zzp());
                                zzH(obj2, zzq);
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 11:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhce.zzt(obj2, zzu & 1048575, zzhbfVar.zzj());
                                zzH(obj2, zzq);
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 12:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                int zze = zzhbfVar.zze();
                                zzgzn zzw = zzw(zzq);
                                if (zzw != null && !zzw.zza(zze)) {
                                    obj7 = zzhbn.zzo(obj2, zzc, zze, obj6, zzhbxVar2);
                                    obj = obj2;
                                    break;
                                }
                                zzhce.zzt(obj2, zzu & 1048575, zze);
                                zzH(obj2, zzq);
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 13:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhce.zzt(obj2, zzu & 1048575, zzhbfVar.zzh());
                                zzH(obj2, zzq);
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 14:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhce.zzu(obj2, zzu & 1048575, zzhbfVar.zzm());
                                zzH(obj2, zzq);
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 15:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhce.zzt(obj2, zzu & 1048575, zzhbfVar.zzi());
                                zzH(obj2, zzq);
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 16:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhce.zzu(obj2, zzu & 1048575, zzhbfVar.zzn());
                                zzH(obj2, zzq);
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 17:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhas zzhasVar2 = (zzhas) zzA(obj2, zzq);
                                zzhbfVar.zzt(zzhasVar2, zzx(zzq), zzgyrVar);
                                zzJ(obj2, zzq, zzhasVar2);
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 18:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzx(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 19:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzB(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 20:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzE(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 21:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzM(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 22:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzD(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 23:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzA(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 24:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzz(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 25:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzv(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 26:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                if (zzM(zzu)) {
                                    ((zzgyg) zzhbfVar).zzK(zzhaf.zza(obj2, zzu & 1048575), true);
                                } else {
                                    ((zzgyg) zzhbfVar).zzK(zzhaf.zza(obj2, zzu & 1048575), false);
                                }
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 27:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzF(zzhaf.zza(obj2, zzu & 1048575), zzx(zzq), zzgyrVar);
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 28:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzw(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 29:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzL(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 30:
                                obj3 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                try {
                                    List zza2 = zzhaf.zza(obj5, zzu & 1048575);
                                    zzhbfVar.zzy(zza2);
                                    obj7 = zzhbn.zzn(obj5, zzc, zza2, zzw(zzq), obj3, zzhbxVar2);
                                    obj2 = obj5;
                                    zzhbxVar2 = zzhbxVar2;
                                } catch (zzgzv unused2) {
                                    obj2 = obj5;
                                    obj7 = obj3;
                                    if (obj7 == null) {
                                    }
                                    if (!zzhbxVar2.zzk(obj7, zzhbfVar, 0)) {
                                    }
                                    obj = obj2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    obj2 = obj5;
                                    th = th;
                                    obj7 = obj3;
                                    i = zzhavVar.zzk;
                                    while (i < zzhavVar.zzl) {
                                    }
                                    if (obj7 != null) {
                                    }
                                }
                                obj = obj2;
                                break;
                            case 31:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzG(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 32:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzH(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 33:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzI(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 34:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzJ(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 35:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzx(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 36:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzB(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 37:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzE(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 38:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzM(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 39:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzD(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 40:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzA(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 41:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzz(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 42:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzv(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 43:
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                zzhbfVar.zzL(zzhaf.zza(obj2, zzu & 1048575));
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 44:
                                List zza3 = zzhaf.zza(obj5, zzu & 1048575);
                                zzhbfVar.zzy(zza3);
                                try {
                                    obj7 = zzhbn.zzn(obj5, zzc, zza3, zzw(zzq), obj4, zzhbxVar);
                                    obj2 = obj5;
                                    zzhbxVar2 = zzhbxVar;
                                } catch (zzgzv unused3) {
                                    obj2 = obj5;
                                    obj3 = obj4;
                                    zzhbxVar2 = zzhbxVar;
                                    obj7 = obj3;
                                    if (obj7 == null) {
                                    }
                                    if (!zzhbxVar2.zzk(obj7, zzhbfVar, 0)) {
                                    }
                                    obj = obj2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    obj2 = obj5;
                                    obj3 = obj4;
                                    zzhbxVar2 = zzhbxVar;
                                    th = th;
                                    obj7 = obj3;
                                    i = zzhavVar.zzk;
                                    while (i < zzhavVar.zzl) {
                                    }
                                    if (obj7 != null) {
                                    }
                                }
                                obj = obj2;
                                break;
                            case 45:
                                zzhbfVar.zzG(zzhaf.zza(obj5, zzu & 1048575));
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 46:
                                zzhbfVar.zzH(zzhaf.zza(obj5, zzu & 1048575));
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 47:
                                zzhbfVar.zzI(zzhaf.zza(obj5, zzu & 1048575));
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 48:
                                zzhbfVar.zzJ(zzhaf.zza(obj5, zzu & 1048575));
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 49:
                                zzhbfVar.zzC(zzhaf.zza(obj5, zzu & 1048575), zzx(zzq), zzgyrVar);
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 50:
                                Object zzz = zzz(zzq);
                                long zzu2 = zzu(zzq) & 1048575;
                                Object zzh = zzhce.zzh(obj5, zzu2);
                                if (zzh == null) {
                                    zzh = zzham.zza().zzb();
                                    zzhce.zzv(obj5, zzu2, zzh);
                                } else if (zzhan.zza(zzh)) {
                                    Object zzb2 = zzham.zza().zzb();
                                    zzhan.zzb(zzb2, zzh);
                                    zzhce.zzv(obj5, zzu2, zzb2);
                                    zzh = zzb2;
                                }
                                throw null;
                                break;
                            case 51:
                                zzhce.zzv(obj5, zzu & 1048575, Double.valueOf(zzhbfVar.zza()));
                                zzI(obj5, zzc, zzq);
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 52:
                                zzhce.zzv(obj5, zzu & 1048575, Float.valueOf(zzhbfVar.zzb()));
                                zzI(obj5, zzc, zzq);
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 53:
                                zzhce.zzv(obj5, zzu & 1048575, Long.valueOf(zzhbfVar.zzl()));
                                zzI(obj5, zzc, zzq);
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 54:
                                zzhce.zzv(obj5, zzu & 1048575, Long.valueOf(zzhbfVar.zzo()));
                                zzI(obj5, zzc, zzq);
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 55:
                                zzhce.zzv(obj5, zzu & 1048575, Integer.valueOf(zzhbfVar.zzg()));
                                zzI(obj5, zzc, zzq);
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 56:
                                zzhce.zzv(obj5, zzu & 1048575, Long.valueOf(zzhbfVar.zzk()));
                                zzI(obj5, zzc, zzq);
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 57:
                                zzhce.zzv(obj5, zzu & 1048575, Integer.valueOf(zzhbfVar.zzf()));
                                zzI(obj5, zzc, zzq);
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 58:
                                zzhce.zzv(obj5, zzu & 1048575, Boolean.valueOf(zzhbfVar.zzN()));
                                zzI(obj5, zzc, zzq);
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 59:
                                zzG(obj5, zzu, zzhbfVar);
                                zzI(obj5, zzc, zzq);
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 60:
                                zzhas zzhasVar3 = (zzhas) zzB(obj5, zzc, zzq);
                                zzhbfVar.zzu(zzhasVar3, zzx(zzq), zzgyrVar);
                                zzK(obj5, zzc, zzq, zzhasVar3);
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 61:
                                zzhce.zzv(obj5, zzu & 1048575, zzhbfVar.zzp());
                                zzI(obj5, zzc, zzq);
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 62:
                                zzhce.zzv(obj5, zzu & 1048575, Integer.valueOf(zzhbfVar.zzj()));
                                zzI(obj5, zzc, zzq);
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 63:
                                int zze2 = zzhbfVar.zze();
                                zzgzn zzw2 = zzw(zzq);
                                if (zzw2 != null && !zzw2.zza(zze2)) {
                                    obj7 = zzhbn.zzo(obj5, zzc, zze2, obj4, zzhbxVar);
                                    obj = obj5;
                                    zzhbxVar2 = zzhbxVar;
                                    break;
                                }
                                zzhce.zzv(obj5, zzu & 1048575, Integer.valueOf(zze2));
                                zzI(obj5, zzc, zzq);
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 64:
                                zzhce.zzv(obj5, zzu & 1048575, Integer.valueOf(zzhbfVar.zzh()));
                                zzI(obj5, zzc, zzq);
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 65:
                                zzhce.zzv(obj5, zzu & 1048575, Long.valueOf(zzhbfVar.zzm()));
                                zzI(obj5, zzc, zzq);
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 66:
                                zzhce.zzv(obj5, zzu & 1048575, Integer.valueOf(zzhbfVar.zzi()));
                                zzI(obj5, zzc, zzq);
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 67:
                                zzhce.zzv(obj5, zzu & 1048575, Long.valueOf(zzhbfVar.zzn()));
                                zzI(obj5, zzc, zzq);
                                obj2 = obj5;
                                obj6 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj6;
                                obj = obj2;
                                break;
                            case 68:
                                try {
                                    zzhas zzhasVar4 = (zzhas) zzB(obj5, zzc, zzq);
                                    zzhbfVar.zzt(zzhasVar4, zzx(zzq), zzgyrVar);
                                    zzK(obj5, zzc, zzq, zzhasVar4);
                                    obj2 = obj5;
                                    obj6 = obj4;
                                    zzhbxVar2 = zzhbxVar;
                                    obj7 = obj6;
                                    obj = obj2;
                                    break;
                                } catch (Throwable th4) {
                                    th = th4;
                                    th = th;
                                    obj2 = obj5;
                                    obj3 = obj4;
                                    zzhbxVar2 = zzhbxVar;
                                    obj7 = obj3;
                                    i = zzhavVar.zzk;
                                    while (i < zzhavVar.zzl) {
                                    }
                                    if (obj7 != null) {
                                    }
                                }
                                break;
                            default:
                                obj2 = obj5;
                                obj3 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                if (obj3 == null) {
                                    try {
                                        obj7 = zzhbxVar2.zza(obj2);
                                    } catch (zzgzv unused4) {
                                        obj7 = obj3;
                                        if (obj7 == null) {
                                        }
                                        if (!zzhbxVar2.zzk(obj7, zzhbfVar, 0)) {
                                        }
                                        obj = obj2;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        th = th;
                                        obj7 = obj3;
                                        i = zzhavVar.zzk;
                                        while (i < zzhavVar.zzl) {
                                        }
                                        if (obj7 != null) {
                                        }
                                    }
                                } else {
                                    obj7 = obj3;
                                }
                                try {
                                    try {
                                        if (!zzhbxVar2.zzk(obj7, zzhbfVar, 0)) {
                                            for (int i2 = zzhavVar.zzk; i2 < zzhavVar.zzl; i2++) {
                                                zzhavVar.zzy(obj2, zzhavVar.zzj[i2], obj7, zzhbxVar2, obj2);
                                            }
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        i = zzhavVar.zzk;
                                        while (i < zzhavVar.zzl) {
                                            zzhavVar.zzy(obj2, zzhavVar.zzj[i], obj7, zzhbxVar2, obj2);
                                            i++;
                                            zzhavVar = this;
                                        }
                                        if (obj7 != null) {
                                            throw th;
                                        }
                                        zzhbxVar2.zzj(obj2, obj7);
                                        throw th;
                                    }
                                } catch (zzgzv unused5) {
                                    if (obj7 == null) {
                                        obj7 = zzhbxVar2.zza(obj2);
                                    }
                                    if (!zzhbxVar2.zzk(obj7, zzhbfVar, 0)) {
                                        for (int i3 = zzhavVar.zzk; i3 < zzhavVar.zzl; i3++) {
                                            zzhavVar.zzy(obj2, zzhavVar.zzj[i3], obj7, zzhbxVar2, obj2);
                                        }
                                        if (obj7 == null) {
                                        }
                                    }
                                    obj = obj2;
                                }
                                obj = obj2;
                                break;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        obj2 = obj5;
                    }
                } else if (zzc == Integer.MAX_VALUE) {
                    int i4 = this.zzk;
                    while (i4 < this.zzl) {
                        zzy(obj, this.zzj[i4], obj7, zzhbxVar2, obj);
                        i4++;
                        zzhbxVar2 = zzhbxVar2;
                    }
                    obj2 = obj;
                    zzhbxVar2 = zzhbxVar2;
                } else {
                    zzhbxVar = zzhbxVar2;
                    obj4 = obj7;
                    try {
                        if ((!this.zzh ? null : zzgyrVar.zzc(this.zzg, zzc)) != null) {
                            throw null;
                        }
                        if (obj4 == null) {
                            try {
                                obj7 = zzhbxVar.zza(obj);
                            } catch (Throwable th8) {
                                th = th8;
                                obj2 = obj;
                                zzhavVar = this;
                                obj3 = obj4;
                                zzhbxVar2 = zzhbxVar;
                                obj7 = obj3;
                                i = zzhavVar.zzk;
                                while (i < zzhavVar.zzl) {
                                }
                                if (obj7 != null) {
                                }
                            }
                        } else {
                            obj7 = obj4;
                        }
                        try {
                            if (zzhbxVar.zzk(obj7, zzhbfVar, 0)) {
                                obj5 = obj;
                                obj = obj5;
                                zzhbxVar2 = zzhbxVar;
                            } else {
                                int i5 = this.zzk;
                                while (i5 < this.zzl) {
                                    zzhbx zzhbxVar3 = zzhbxVar;
                                    Object obj8 = obj;
                                    zzy(obj8, this.zzj[i5], obj7, zzhbxVar3, obj);
                                    zzhbxVar = zzhbxVar3;
                                    i5++;
                                    obj = obj8;
                                }
                                obj2 = obj;
                                zzhbxVar2 = zzhbxVar;
                            }
                        } catch (Throwable th9) {
                            Object obj9 = obj;
                            zzhavVar = this;
                            th = th9;
                            obj2 = obj9;
                            zzhbxVar2 = zzhbxVar;
                            i = zzhavVar.zzk;
                            while (i < zzhavVar.zzl) {
                            }
                            if (obj7 != null) {
                            }
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        obj5 = obj;
                        zzhavVar = this;
                        th = th;
                        obj2 = obj5;
                        obj3 = obj4;
                        zzhbxVar2 = zzhbxVar;
                        obj7 = obj3;
                        i = zzhavVar.zzk;
                        while (i < zzhavVar.zzl) {
                        }
                        if (obj7 != null) {
                        }
                    }
                }
            } catch (Throwable th11) {
                th = th11;
                obj2 = obj;
                obj3 = obj7;
                zzhavVar = this;
            }
        }
        if (obj7 == null) {
            zzhbxVar2.zzj(obj2, obj7);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgxn zzgxnVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzgxnVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:209:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    @Override // com.google.android.gms.internal.ads.zzhbl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzj(Object obj, zzhcm zzhcmVar) throws IOException {
        Map.Entry entry;
        Iterator it;
        int[] iArr;
        int i;
        boolean z;
        Map.Entry entry2;
        int i2;
        int i3;
        int i4;
        int i5;
        zzhav<T> zzhavVar = this;
        if (zzhavVar.zzh) {
            zzgyw zzgywVar = ((zzgzd) obj).zza;
            if (!zzgywVar.zza.isEmpty()) {
                Iterator zzf = zzgywVar.zzf();
                entry = (Map.Entry) zzf.next();
                it = zzf;
                iArr = zzhavVar.zzc;
                Unsafe unsafe = zzb;
                int i6 = 1048575;
                int i7 = 1048575;
                i = 0;
                int i8 = 0;
                while (i < iArr.length) {
                    int zzu = zzhavVar.zzu(i);
                    int zzt = zzt(zzu);
                    int i9 = iArr[i];
                    if (zzt <= 17) {
                        int i10 = iArr[i + 2];
                        z = true;
                        int i11 = i10 & i6;
                        if (i11 != i7) {
                            i8 = i11 == i6 ? 0 : unsafe.getInt(obj, i11);
                            i7 = i11;
                        }
                        int i12 = 1 << (i10 >>> 20);
                        entry2 = entry;
                        i2 = i7;
                        i3 = i8;
                        i4 = i12;
                    } else {
                        z = true;
                        entry2 = entry;
                        i2 = i7;
                        i3 = i8;
                        i4 = 0;
                    }
                    while (true) {
                        if (entry2 != null) {
                            zzgys zzgysVar = zzhavVar.zzn;
                            i5 = i6;
                            if (((zzgze) entry2.getKey()).zza <= i9) {
                                zzgysVar.zzb(zzhcmVar, entry2);
                                entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
                                i6 = i5;
                            }
                        } else {
                            i5 = i6;
                        }
                    }
                    long j = zzu & i5;
                    switch (zzt) {
                        case 0:
                            if (zzhavVar.zzO(obj, i, i2, i3, i4)) {
                                zzhcmVar.zzf(i9, zzhce.zzb(obj, j));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 1:
                            if (zzhavVar.zzO(obj, i, i2, i3, i4)) {
                                zzhcmVar.zzo(i9, zzhce.zzc(obj, j));
                            }
                            zzhavVar = this;
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 2:
                            if (zzhavVar.zzO(obj, i, i2, i3, i4)) {
                                zzhcmVar.zzt(i9, unsafe.getLong(obj, j));
                            }
                            zzhavVar = this;
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 3:
                            if (zzhavVar.zzO(obj, i, i2, i3, i4)) {
                                zzhcmVar.zzK(i9, unsafe.getLong(obj, j));
                            }
                            zzhavVar = this;
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 4:
                            if (zzhavVar.zzO(obj, i, i2, i3, i4)) {
                                zzhcmVar.zzr(i9, unsafe.getInt(obj, j));
                            }
                            zzhavVar = this;
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 5:
                            if (zzhavVar.zzO(obj, i, i2, i3, i4)) {
                                zzhcmVar.zzm(i9, unsafe.getLong(obj, j));
                            }
                            zzhavVar = this;
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 6:
                            if (zzhavVar.zzO(obj, i, i2, i3, i4)) {
                                zzhcmVar.zzk(i9, unsafe.getInt(obj, j));
                            }
                            zzhavVar = this;
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 7:
                            if (zzhavVar.zzO(obj, i, i2, i3, i4)) {
                                zzhcmVar.zzb(i9, zzhce.zzz(obj, j));
                            }
                            zzhavVar = this;
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 8:
                            if (zzhavVar.zzO(obj, i, i2, i3, i4)) {
                                zzT(i9, unsafe.getObject(obj, j), zzhcmVar);
                            }
                            zzhavVar = this;
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 9:
                            if (zzhavVar.zzO(obj, i, i2, i3, i4)) {
                                zzhcmVar.zzv(i9, unsafe.getObject(obj, j), zzhavVar.zzx(i));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 10:
                            if (zzhavVar.zzO(obj, i, i2, i3, i4)) {
                                zzhcmVar.zzd(i9, (zzgxz) unsafe.getObject(obj, j));
                            }
                            zzhavVar = this;
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 11:
                            if (zzhavVar.zzO(obj, i, i2, i3, i4)) {
                                zzhcmVar.zzI(i9, unsafe.getInt(obj, j));
                            }
                            zzhavVar = this;
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 12:
                            if (zzhavVar.zzO(obj, i, i2, i3, i4)) {
                                zzhcmVar.zzi(i9, unsafe.getInt(obj, j));
                            }
                            zzhavVar = this;
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 13:
                            if (zzhavVar.zzO(obj, i, i2, i3, i4)) {
                                zzhcmVar.zzx(i9, unsafe.getInt(obj, j));
                            }
                            zzhavVar = this;
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 14:
                            if (zzhavVar.zzO(obj, i, i2, i3, i4)) {
                                zzhcmVar.zzz(i9, unsafe.getLong(obj, j));
                            }
                            zzhavVar = this;
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 15:
                            if (zzhavVar.zzO(obj, i, i2, i3, i4)) {
                                zzhcmVar.zzB(i9, unsafe.getInt(obj, j));
                            }
                            zzhavVar = this;
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 16:
                            if (zzhavVar.zzO(obj, i, i2, i3, i4)) {
                                zzhcmVar.zzD(i9, unsafe.getLong(obj, j));
                            }
                            zzhavVar = this;
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 17:
                            if (zzhavVar.zzO(obj, i, i2, i3, i4)) {
                                zzhcmVar.zzq(i9, unsafe.getObject(obj, j), zzhavVar.zzx(i));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 18:
                            zzhbn.zzt(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 19:
                            zzhbn.zzx(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 20:
                            zzhbn.zzA(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 21:
                            zzhbn.zzI(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 22:
                            zzhbn.zzz(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 23:
                            zzhbn.zzw(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 24:
                            zzhbn.zzv(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 25:
                            zzhbn.zzr(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 26:
                            zzhbn.zzG(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 27:
                            zzhbn.zzB(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, zzhavVar.zzx(i));
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 28:
                            zzhbn.zzs(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 29:
                            zzhbn.zzH(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 30:
                            zzhbn.zzu(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 31:
                            zzhbn.zzC(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 32:
                            zzhbn.zzD(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 33:
                            zzhbn.zzE(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 34:
                            zzhbn.zzF(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 35:
                            zzhbn.zzt(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, z);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 36:
                            zzhbn.zzx(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, z);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 37:
                            zzhbn.zzA(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, z);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 38:
                            zzhbn.zzI(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, z);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 39:
                            zzhbn.zzz(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, z);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 40:
                            zzhbn.zzw(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, z);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 41:
                            zzhbn.zzv(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, z);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 42:
                            zzhbn.zzr(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, z);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 43:
                            zzhbn.zzH(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, z);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 44:
                            zzhbn.zzu(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, z);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 45:
                            zzhbn.zzC(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, z);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 46:
                            zzhbn.zzD(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, z);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 47:
                            zzhbn.zzE(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, z);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 48:
                            zzhbn.zzF(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, z);
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 49:
                            zzhbn.zzy(iArr[i], (List) unsafe.getObject(obj, j), zzhcmVar, zzhavVar.zzx(i));
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 50:
                            if (unsafe.getObject(obj, j) != null) {
                                throw null;
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 51:
                            if (zzhavVar.zzR(obj, i9, i)) {
                                zzhcmVar.zzf(i9, zzn(obj, j));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 52:
                            if (zzhavVar.zzR(obj, i9, i)) {
                                zzhcmVar.zzo(i9, zzo(obj, j));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 53:
                            if (zzhavVar.zzR(obj, i9, i)) {
                                zzhcmVar.zzt(i9, zzv(obj, j));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 54:
                            if (zzhavVar.zzR(obj, i9, i)) {
                                zzhcmVar.zzK(i9, zzv(obj, j));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 55:
                            if (zzhavVar.zzR(obj, i9, i)) {
                                zzhcmVar.zzr(i9, zzp(obj, j));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 56:
                            if (zzhavVar.zzR(obj, i9, i)) {
                                zzhcmVar.zzm(i9, zzv(obj, j));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 57:
                            if (zzhavVar.zzR(obj, i9, i)) {
                                zzhcmVar.zzk(i9, zzp(obj, j));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 58:
                            if (zzhavVar.zzR(obj, i9, i)) {
                                zzhcmVar.zzb(i9, zzS(obj, j));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 59:
                            if (zzhavVar.zzR(obj, i9, i)) {
                                zzT(i9, unsafe.getObject(obj, j), zzhcmVar);
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 60:
                            if (zzhavVar.zzR(obj, i9, i)) {
                                zzhcmVar.zzv(i9, unsafe.getObject(obj, j), zzhavVar.zzx(i));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 61:
                            if (zzhavVar.zzR(obj, i9, i)) {
                                zzhcmVar.zzd(i9, (zzgxz) unsafe.getObject(obj, j));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 62:
                            if (zzhavVar.zzR(obj, i9, i)) {
                                zzhcmVar.zzI(i9, zzp(obj, j));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 63:
                            if (zzhavVar.zzR(obj, i9, i)) {
                                zzhcmVar.zzi(i9, zzp(obj, j));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 64:
                            if (zzhavVar.zzR(obj, i9, i)) {
                                zzhcmVar.zzx(i9, zzp(obj, j));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 65:
                            if (zzhavVar.zzR(obj, i9, i)) {
                                zzhcmVar.zzz(i9, zzv(obj, j));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 66:
                            if (zzhavVar.zzR(obj, i9, i)) {
                                zzhcmVar.zzB(i9, zzp(obj, j));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 67:
                            if (zzhavVar.zzR(obj, i9, i)) {
                                zzhcmVar.zzD(i9, zzv(obj, j));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        case 68:
                            if (zzhavVar.zzR(obj, i9, i)) {
                                zzhcmVar.zzq(i9, unsafe.getObject(obj, j), zzhavVar.zzx(i));
                            }
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                        default:
                            i += 3;
                            i8 = i3;
                            i6 = i5;
                            i7 = i2;
                            entry = entry2;
                    }
                }
                while (entry != null) {
                    zzhavVar.zzn.zzb(zzhcmVar, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
                ((zzgzh) obj).zzt.zzl(zzhcmVar);
            }
        }
        entry = null;
        it = null;
        iArr = zzhavVar.zzc;
        Unsafe unsafe2 = zzb;
        int i62 = 1048575;
        int i72 = 1048575;
        i = 0;
        int i82 = 0;
        while (i < iArr.length) {
        }
        while (entry != null) {
        }
        ((zzgzh) obj).zzt.zzl(zzhcmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final boolean zzk(Object obj, Object obj2) {
        boolean zzJ;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzu = zzu(i);
            long j = zzu & 1048575;
            switch (zzt(zzu)) {
                case 0:
                    if (zzL(obj, obj2, i) && Double.doubleToLongBits(zzhce.zzb(obj, j)) == Double.doubleToLongBits(zzhce.zzb(obj2, j))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzL(obj, obj2, i) && Float.floatToIntBits(zzhce.zzc(obj, j)) == Float.floatToIntBits(zzhce.zzc(obj2, j))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzL(obj, obj2, i) && zzhce.zzf(obj, j) == zzhce.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzL(obj, obj2, i) && zzhce.zzf(obj, j) == zzhce.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzL(obj, obj2, i) && zzhce.zzd(obj, j) == zzhce.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzL(obj, obj2, i) && zzhce.zzf(obj, j) == zzhce.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzL(obj, obj2, i) && zzhce.zzd(obj, j) == zzhce.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzL(obj, obj2, i) && zzhce.zzz(obj, j) == zzhce.zzz(obj2, j)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzL(obj, obj2, i) && zzhbn.zzJ(zzhce.zzh(obj, j), zzhce.zzh(obj2, j))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzL(obj, obj2, i) && zzhbn.zzJ(zzhce.zzh(obj, j), zzhce.zzh(obj2, j))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzL(obj, obj2, i) && zzhbn.zzJ(zzhce.zzh(obj, j), zzhce.zzh(obj2, j))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzL(obj, obj2, i) && zzhce.zzd(obj, j) == zzhce.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzL(obj, obj2, i) && zzhce.zzd(obj, j) == zzhce.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzL(obj, obj2, i) && zzhce.zzd(obj, j) == zzhce.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzL(obj, obj2, i) && zzhce.zzf(obj, j) == zzhce.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzL(obj, obj2, i) && zzhce.zzd(obj, j) == zzhce.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzL(obj, obj2, i) && zzhce.zzf(obj, j) == zzhce.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzL(obj, obj2, i) && zzhbn.zzJ(zzhce.zzh(obj, j), zzhce.zzh(obj2, j))) {
                        continue;
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzJ = zzhbn.zzJ(zzhce.zzh(obj, j), zzhce.zzh(obj2, j));
                    break;
                case 50:
                    zzJ = zzhbn.zzJ(zzhce.zzh(obj, j), zzhce.zzh(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzr = zzr(i) & 1048575;
                    if (zzhce.zzd(obj, zzr) == zzhce.zzd(obj2, zzr) && zzhbn.zzJ(zzhce.zzh(obj, j), zzhce.zzh(obj2, j))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzJ) {
                return false;
            }
        }
        if (!((zzgzh) obj).zzt.equals(((zzgzh) obj2).zzt)) {
            return false;
        }
        if (this.zzh) {
            return ((zzgzd) obj).zza.equals(((zzgzd) obj2).zza);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final boolean zzl(Object obj) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i5];
            int i8 = iArr2[i7];
            int zzu = zzu(i7);
            int i9 = iArr2[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i6) {
                if (i10 != 1048575) {
                    i4 = zzb.getInt(obj, i10);
                }
                i2 = i7;
                i3 = i4;
                i = i10;
            } else {
                int i12 = i4;
                i = i6;
                i2 = i7;
                i3 = i12;
            }
            if ((268435456 & zzu) != 0 && !zzO(obj, i2, i, i3, i11)) {
                return false;
            }
            int zzt = zzt(zzu);
            if (zzt != 9 && zzt != 17) {
                if (zzt != 27) {
                    if (zzt == 60 || zzt == 68) {
                        if (zzR(obj, i8, i2) && !zzP(obj, zzu, zzx(i2))) {
                            return false;
                        }
                    } else if (zzt != 49) {
                        if (zzt == 50 && !((zzham) zzhce.zzh(obj, zzu & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zzhce.zzh(obj, zzu & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzhbl zzx = zzx(i2);
                    for (int i13 = 0; i13 < list.size(); i13++) {
                        if (!zzx.zzl(list.get(i13))) {
                            return false;
                        }
                    }
                }
            } else if (zzO(obj, i2, i, i3, i11) && !zzP(obj, zzu, zzx(i2))) {
                return false;
            }
            i5++;
            i6 = i;
            i4 = i3;
        }
        return !this.zzh || ((zzgzd) obj).zza.zzi();
    }
}
