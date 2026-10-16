package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes5.dex */
final class zzgo<T> implements zzgv<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzho.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgl zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzhh zzl;
    private final zzev zzm;

    private zzgo(int[] iArr, Object[] objArr, int i, int i2, zzgl zzglVar, boolean z, int[] iArr2, int i3, int i4, zzgq zzgqVar, zzfy zzfyVar, zzhh zzhhVar, zzev zzevVar, zzgg zzggVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzevVar != null && (zzglVar instanceof zzff)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzhhVar;
        this.zzm = zzevVar;
        this.zzg = zzglVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int zzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgv zzv = zzv(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzM(obj2, i2, i)) {
            int zzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
            }
            zzgv zzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int zzp = zzp(i);
        long j = 1048575 & zzp;
        if (j == 1048575) {
            return;
        }
        zzho.zzq(obj, j, (1 << (zzp >>> 20)) | zzho.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzho.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int zzp = zzp(i);
        long j = zzp & 1048575;
        if (j != 1048575) {
            return (zzho.zzc(obj, j) & (1 << (zzp >>> 20))) != 0;
        }
        int zzs = zzs(i);
        long j2 = zzs & 1048575;
        switch (zzr(zzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzho.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzho.zzb(obj, j2)) != 0;
            case 2:
                return zzho.zzd(obj, j2) != 0;
            case 3:
                return zzho.zzd(obj, j2) != 0;
            case 4:
                return zzho.zzc(obj, j2) != 0;
            case 5:
                return zzho.zzd(obj, j2) != 0;
            case 6:
                return zzho.zzc(obj, j2) != 0;
            case 7:
                return zzho.zzw(obj, j2);
            case 8:
                Object zzf = zzho.zzf(obj, j2);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                }
                if (zzf instanceof zzei) {
                    return !zzei.zzb.equals(zzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzho.zzf(obj, j2) != null;
            case 10:
                return !zzei.zzb.equals(zzho.zzf(obj, j2));
            case 11:
                return zzho.zzc(obj, j2) != 0;
            case 12:
                return zzho.zzc(obj, j2) != 0;
            case 13:
                return zzho.zzc(obj, j2) != 0;
            case 14:
                return zzho.zzd(obj, j2) != 0;
            case 15:
                return zzho.zzc(obj, j2) != 0;
            case 16:
                return zzho.zzd(obj, j2) != 0;
            case 17:
                return zzho.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzI(obj, i) : (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzgv zzgvVar) {
        return zzgvVar.zzk(zzho.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzfi) {
            return ((zzfi) obj).zzz();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzho.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzho.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzhu zzhuVar) throws IOException {
        if (obj instanceof String) {
            zzhuVar.zzG(i, (String) obj);
        } else {
            zzhuVar.zzd(i, (zzei) obj);
        }
    }

    static zzhi zzd(Object obj) {
        zzfi zzfiVar = (zzfi) obj;
        zzhi zzhiVar = zzfiVar.zzc;
        if (zzhiVar != zzhi.zzc()) {
            return zzhiVar;
        }
        zzhi zzf = zzhi.zzf();
        zzfiVar.zzc = zzf;
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
    static zzgo zzl(Class cls, zzgi zzgiVar, zzgq zzgqVar, zzfy zzfyVar, zzhh zzhhVar, zzev zzevVar, zzgg zzggVar) {
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
        Field zzz;
        char charAt10;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        Object obj;
        Field zzz2;
        Object obj2;
        Field zzz3;
        int i30;
        char charAt11;
        int i31;
        char charAt12;
        int i32;
        char charAt13;
        int i33;
        char charAt14;
        if (!(zzgiVar instanceof zzgu)) {
            throw null;
        }
        zzgu zzguVar = (zzgu) zzgiVar;
        String zzd = zzguVar.zzd();
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
        Object[] zze = zzguVar.zze();
        Class<?> cls2 = zzguVar.zza().getClass();
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
            zzgu zzguVar2 = zzguVar;
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
                        if (zzguVar2.zzc() == 1 || i79 != 0) {
                            i28 = i6 + 1;
                            int i87 = i69 / 3;
                            objArr[i87 + i87 + 1] = zze[i6];
                        } else {
                            i29 = 0;
                            int i88 = charAt25 + charAt25;
                            obj = zze[i88];
                            int i89 = i29;
                            if (obj instanceof Field) {
                                zzz2 = (Field) obj;
                            } else {
                                zzz2 = zzz(cls2, (String) obj);
                                zze[i88] = zzz2;
                            }
                            int i90 = i7;
                            objectFieldOffset = (int) unsafe.objectFieldOffset(zzz2);
                            int i91 = i88 + 1;
                            obj2 = zze[i91];
                            i19 = i90;
                            if (obj2 instanceof Field) {
                                zzz3 = (Field) obj2;
                            } else {
                                zzz3 = zzz(cls2, (String) obj2);
                                zze[i91] = zzz3;
                            }
                            i21 = (int) unsafe.objectFieldOffset(zzz3);
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
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zzz2);
                    int i912 = i882 + 1;
                    obj2 = zze[i912];
                    i19 = i902;
                    if (obj2 instanceof Field) {
                    }
                    i21 = (int) unsafe.objectFieldOffset(zzz3);
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
                objectFieldOffset = (int) unsafe.objectFieldOffset(zzz2);
                int i9122 = i8822 + 1;
                obj2 = zze[i9122];
                i19 = i9022;
                if (obj2 instanceof Field) {
                }
                i21 = (int) unsafe.objectFieldOffset(zzz3);
                str = zzd;
                i23 = i8922;
                i17 = i84;
                i22 = 0;
                c = 55296;
            } else {
                i18 = length;
                i19 = i7;
                int i92 = i6 + 1;
                Field zzz4 = zzz(cls2, (String) zze[i6]);
                if (i78 == 9 || i78 == 17) {
                    i20 = i92;
                    int i93 = i69 / 3;
                    objArr[i93 + i93 + 1] = zzz4.getType();
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
                        if (zzguVar2.zzc() == 1 || i79 != 0) {
                            i6 += 2;
                            int i94 = i69 / 3;
                            objArr[i94 + i94 + 1] = zze[i92];
                            str = zzd;
                            objectFieldOffset = (int) unsafe.objectFieldOffset(zzz4);
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
                                    zzz = (Field) obj3;
                                } else {
                                    zzz = zzz(cls2, (String) obj3);
                                    zze[i98] = zzz;
                                }
                                int objectFieldOffset2 = (int) unsafe.objectFieldOffset(zzz);
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
                            objectFieldOffset = (int) unsafe.objectFieldOffset(zzz4);
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
                            objectFieldOffset = (int) unsafe.objectFieldOffset(zzz4);
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
                            objectFieldOffset = (int) unsafe.objectFieldOffset(zzz4);
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
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zzz4);
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
                objectFieldOffset = (int) unsafe.objectFieldOffset(zzz4);
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
            zzguVar = zzguVar2;
            length = i18;
            i7 = i19;
        }
        return new zzgo(iArr3, objArr, i2, i4, zzguVar.zza(), false, iArr, i5, i64, zzgqVar, zzfyVar, zzhhVar, zzevVar, zzggVar);
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzho.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzho.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzho.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
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

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzho.zzf(obj, j)).longValue();
    }

    private final zzfl zzu(int i) {
        int i2 = i / 3;
        return (zzfl) this.zzd[i2 + i2 + 1];
    }

    private final zzgv zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgv zzgvVar = (zzgv) objArr[i3];
        if (zzgvVar != null) {
            return zzgvVar;
        }
        zzgv zzb2 = zzgs.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzb2;
        return zzb2;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzgv zzv = zzv(i);
        int zzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzgv zzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzz(Class cls, String str) {
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

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final int zza(Object obj) {
        int i;
        int zzC;
        int zzC2;
        int zzD;
        int zzC3;
        int zzC4;
        int zzC5;
        int zzd;
        int zzC6;
        int zzh;
        int zzg;
        int size;
        int zzl;
        int zzC7;
        int zzC8;
        int zzC9;
        int i2;
        int zze;
        int zzC10;
        int zzC11;
        int i3;
        int zzC12;
        int zzC13;
        int zzC14;
        int zzd2;
        int zzC15;
        zzgo<T> zzgoVar = this;
        Object obj2 = obj;
        Unsafe unsafe = zzb;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1048575;
        while (true) {
            int[] iArr = zzgoVar.zzc;
            if (i4 >= iArr.length) {
                int zza2 = i6 + ((zzfi) obj).zzc.zza();
                if (!zzgoVar.zzh) {
                    return zza2;
                }
                zzhd zzhdVar = ((zzff) obj).zzb.zza;
                int zzc = zzhdVar.zzc();
                int i8 = 0;
                for (int i9 = 0; i9 < zzc; i9++) {
                    Map.Entry zzg2 = zzhdVar.zzg(i9);
                    i8 += zzez.zzc((zzey) ((zzgz) zzg2).zza(), zzg2.getValue());
                }
                for (Map.Entry entry : zzhdVar.zzd()) {
                    i8 += zzez.zzc((zzey) entry.getKey(), entry.getValue());
                }
                return zza2 + i8;
            }
            int zzs = zzgoVar.zzs(i4);
            int zzr = zzr(zzs);
            int i10 = iArr[i4];
            int i11 = iArr[i4 + 2];
            int i12 = i11 & 1048575;
            if (zzr <= 17) {
                if (i12 != i7) {
                    i5 = i12 == 1048575 ? 0 : unsafe.getInt(obj2, i12);
                    i7 = i12;
                }
                i = 1 << (i11 >>> 20);
            } else {
                i = 0;
            }
            int i13 = zzs & 1048575;
            if (zzr >= zzfa.DOUBLE_LIST_PACKED.zza()) {
                zzfa.SINT64_LIST_PACKED.zza();
            }
            long j = i13;
            switch (zzr) {
                case 0:
                    if (zzgoVar.zzJ(obj2, i4, i7, i5, i)) {
                        i6 += zzep.zzC(i10 << 3) + 8;
                    }
                    i4 += 3;
                    obj2 = obj;
                case 1:
                    if (zzgoVar.zzJ(obj2, i4, i7, i5, i)) {
                        zzC = zzep.zzC(i10 << 3);
                        zzC4 = zzC + 4;
                        i6 += zzC4;
                    }
                    zzgoVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 2:
                    if (zzgoVar.zzJ(obj2, i4, i7, i5, i)) {
                        long j2 = unsafe.getLong(obj2, j);
                        zzC2 = zzep.zzC(i10 << 3);
                        zzD = zzep.zzD(j2);
                        zzC4 = zzC2 + zzD;
                        i6 += zzC4;
                    }
                    zzgoVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 3:
                    if (zzgoVar.zzJ(obj2, i4, i7, i5, i)) {
                        long j3 = unsafe.getLong(obj2, j);
                        zzC2 = zzep.zzC(i10 << 3);
                        zzD = zzep.zzD(j3);
                        zzC4 = zzC2 + zzD;
                        i6 += zzC4;
                    }
                    zzgoVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 4:
                    if (zzgoVar.zzJ(obj2, i4, i7, i5, i)) {
                        long j4 = unsafe.getInt(obj2, j);
                        zzC2 = zzep.zzC(i10 << 3);
                        zzD = zzep.zzD(j4);
                        zzC4 = zzC2 + zzD;
                        i6 += zzC4;
                    }
                    zzgoVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 5:
                    if (zzgoVar.zzJ(obj2, i4, i7, i5, i)) {
                        zzC3 = zzep.zzC(i10 << 3);
                        zzC4 = zzC3 + 8;
                        i6 += zzC4;
                    }
                    zzgoVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 6:
                    if (zzgoVar.zzJ(obj2, i4, i7, i5, i)) {
                        zzC = zzep.zzC(i10 << 3);
                        zzC4 = zzC + 4;
                        i6 += zzC4;
                    }
                    zzgoVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 7:
                    if (zzgoVar.zzJ(obj2, i4, i7, i5, i)) {
                        zzC4 = zzep.zzC(i10 << 3) + 1;
                        i6 += zzC4;
                    }
                    zzgoVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 8:
                    if (zzgoVar.zzJ(obj2, i4, i7, i5, i)) {
                        int i14 = i10 << 3;
                        Object object = unsafe.getObject(obj2, j);
                        if (object instanceof zzei) {
                            zzC5 = zzep.zzC(i14);
                            zzd = ((zzei) object).zzd();
                            zzC6 = zzep.zzC(zzd);
                            zzC4 = zzC5 + zzC6 + zzd;
                            i6 += zzC4;
                        } else {
                            zzC2 = zzep.zzC(i14);
                            zzD = zzep.zzB((String) object);
                            zzC4 = zzC2 + zzD;
                            i6 += zzC4;
                        }
                    }
                    zzgoVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 9:
                    if (zzgoVar.zzJ(obj2, i4, i7, i5, i)) {
                        zzh = zzgx.zzh(i10, unsafe.getObject(obj2, j), zzgoVar.zzv(i4));
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 10:
                    if (zzgoVar.zzJ(obj2, i4, i7, i5, i)) {
                        zzei zzeiVar = (zzei) unsafe.getObject(obj2, j);
                        zzC5 = zzep.zzC(i10 << 3);
                        zzd = zzeiVar.zzd();
                        zzC6 = zzep.zzC(zzd);
                        zzC4 = zzC5 + zzC6 + zzd;
                        i6 += zzC4;
                    }
                    zzgoVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 11:
                    if (zzgoVar.zzJ(obj2, i4, i7, i5, i)) {
                        int i15 = unsafe.getInt(obj2, j);
                        zzC2 = zzep.zzC(i10 << 3);
                        zzD = zzep.zzC(i15);
                        zzC4 = zzC2 + zzD;
                        i6 += zzC4;
                    }
                    zzgoVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 12:
                    if (zzgoVar.zzJ(obj2, i4, i7, i5, i)) {
                        long j5 = unsafe.getInt(obj2, j);
                        zzC2 = zzep.zzC(i10 << 3);
                        zzD = zzep.zzD(j5);
                        zzC4 = zzC2 + zzD;
                        i6 += zzC4;
                    }
                    zzgoVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 13:
                    if (zzgoVar.zzJ(obj2, i4, i7, i5, i)) {
                        zzC = zzep.zzC(i10 << 3);
                        zzC4 = zzC + 4;
                        i6 += zzC4;
                    }
                    zzgoVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 14:
                    if (zzgoVar.zzJ(obj2, i4, i7, i5, i)) {
                        zzC3 = zzep.zzC(i10 << 3);
                        zzC4 = zzC3 + 8;
                        i6 += zzC4;
                    }
                    zzgoVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 15:
                    if (zzgoVar.zzJ(obj2, i4, i7, i5, i)) {
                        int i16 = unsafe.getInt(obj2, j);
                        zzC2 = zzep.zzC(i10 << 3);
                        zzD = zzep.zzC((i16 >> 31) ^ (i16 + i16));
                        zzC4 = zzC2 + zzD;
                        i6 += zzC4;
                    }
                    zzgoVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 16:
                    if (zzgoVar.zzJ(obj2, i4, i7, i5, i)) {
                        long j6 = unsafe.getLong(obj2, j);
                        zzC2 = zzep.zzC(i10 << 3);
                        zzD = zzep.zzD((j6 >> 63) ^ (j6 + j6));
                        zzC4 = zzC2 + zzD;
                        i6 += zzC4;
                    }
                    zzgoVar = this;
                    i4 += 3;
                    obj2 = obj;
                case 17:
                    if (zzgoVar.zzJ(obj2, i4, i7, i5, i)) {
                        zzh = zzep.zzy(i10, (zzgl) unsafe.getObject(obj2, j), zzgoVar.zzv(i4));
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 18:
                    zzh = zzgx.zzd(i10, (List) unsafe.getObject(obj2, j), false);
                    i6 += zzh;
                    i4 += 3;
                    obj2 = obj;
                case 19:
                    zzh = zzgx.zzb(i10, (List) unsafe.getObject(obj2, j), false);
                    i6 += zzh;
                    i4 += 3;
                    obj2 = obj;
                case 20:
                    List list = (List) unsafe.getObject(obj2, j);
                    int i17 = zzgx.zza;
                    if (list.size() != 0) {
                        zzg = zzgx.zzg(list) + (list.size() * zzep.zzC(i10 << 3));
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
                    int i18 = zzgx.zza;
                    size = list2.size();
                    if (size != 0) {
                        zzl = zzgx.zzl(list2);
                        zzC7 = zzep.zzC(i10 << 3);
                        i2 = size * zzC7;
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
                    int i19 = zzgx.zza;
                    size = list3.size();
                    if (size != 0) {
                        zzl = zzgx.zzf(list3);
                        zzC7 = zzep.zzC(i10 << 3);
                        i2 = size * zzC7;
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
                    zzh = zzgx.zzd(i10, (List) unsafe.getObject(obj2, j), false);
                    i6 += zzh;
                    i4 += 3;
                    obj2 = obj;
                case 24:
                    zzh = zzgx.zzb(i10, (List) unsafe.getObject(obj2, j), false);
                    i6 += zzh;
                    i4 += 3;
                    obj2 = obj;
                case 25:
                    List list4 = (List) unsafe.getObject(obj2, j);
                    int i20 = zzgx.zza;
                    int size2 = list4.size();
                    if (size2 != 0) {
                        zzh = size2 * (zzep.zzC(i10 << 3) + 1);
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
                    int i21 = zzgx.zza;
                    int size3 = list5.size();
                    if (size3 != 0) {
                        zzg = zzep.zzC(i10 << 3) * size3;
                        if (list5 instanceof zzfx) {
                            zzfx zzfxVar = (zzfx) list5;
                            for (int i22 = 0; i22 < size3; i22++) {
                                Object zza3 = zzfxVar.zza();
                                if (zza3 instanceof zzei) {
                                    int zzd3 = ((zzei) zza3).zzd();
                                    zzg += zzep.zzC(zzd3) + zzd3;
                                } else {
                                    zzg += zzep.zzB((String) zza3);
                                }
                            }
                        } else {
                            for (int i23 = 0; i23 < size3; i23++) {
                                Object obj3 = list5.get(i23);
                                if (obj3 instanceof zzei) {
                                    int zzd4 = ((zzei) obj3).zzd();
                                    zzg += zzep.zzC(zzd4) + zzd4;
                                } else {
                                    zzg += zzep.zzB((String) obj3);
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
                    zzgv zzv = zzgoVar.zzv(i4);
                    int i24 = zzgx.zza;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        zzC8 = 0;
                    } else {
                        zzC8 = zzep.zzC(i10 << 3) * size4;
                        for (int i25 = 0; i25 < size4; i25++) {
                            Object obj4 = list6.get(i25);
                            if (obj4 instanceof zzfw) {
                                int zza4 = ((zzfw) obj4).zza();
                                zzC8 += zzep.zzC(zza4) + zza4;
                            } else {
                                zzC8 += zzep.zzA((zzgl) obj4, zzv);
                            }
                        }
                    }
                    i6 += zzC8;
                    i4 += 3;
                    obj2 = obj;
                case 28:
                    List list7 = (List) unsafe.getObject(obj2, j);
                    int i26 = zzgx.zza;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        zzC9 = 0;
                    } else {
                        zzC9 = size5 * zzep.zzC(i10 << 3);
                        for (int i27 = 0; i27 < list7.size(); i27++) {
                            int zzd5 = ((zzei) list7.get(i27)).zzd();
                            zzC9 += zzep.zzC(zzd5) + zzd5;
                        }
                    }
                    i6 += zzC9;
                    i4 += 3;
                    obj2 = obj;
                case 29:
                    List list8 = (List) unsafe.getObject(obj2, j);
                    int i28 = zzgx.zza;
                    size = list8.size();
                    if (size != 0) {
                        zzl = zzgx.zzk(list8);
                        zzC7 = zzep.zzC(i10 << 3);
                        i2 = size * zzC7;
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
                    int i29 = zzgx.zza;
                    size = list9.size();
                    if (size != 0) {
                        zzl = zzgx.zza(list9);
                        zzC7 = zzep.zzC(i10 << 3);
                        i2 = size * zzC7;
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
                    zzh = zzgx.zzb(i10, (List) unsafe.getObject(obj2, j), false);
                    i6 += zzh;
                    i4 += 3;
                    obj2 = obj;
                case 32:
                    zzh = zzgx.zzd(i10, (List) unsafe.getObject(obj2, j), false);
                    i6 += zzh;
                    i4 += 3;
                    obj2 = obj;
                case 33:
                    List list10 = (List) unsafe.getObject(obj2, j);
                    int i30 = zzgx.zza;
                    size = list10.size();
                    if (size != 0) {
                        zzl = zzgx.zzi(list10);
                        zzC7 = zzep.zzC(i10 << 3);
                        i2 = size * zzC7;
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
                    int i31 = zzgx.zza;
                    size = list11.size();
                    if (size != 0) {
                        zzl = zzgx.zzj(list11);
                        zzC7 = zzep.zzC(i10 << 3);
                        i2 = size * zzC7;
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
                    zze = zzgx.zze((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzC10 = zzep.zzC(i10 << 3);
                        zzC11 = zzep.zzC(zze);
                        zzC9 = zzC10 + zzC11 + zze;
                        i6 += zzC9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 36:
                    zze = zzgx.zzc((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzC10 = zzep.zzC(i10 << 3);
                        zzC11 = zzep.zzC(zze);
                        zzC9 = zzC10 + zzC11 + zze;
                        i6 += zzC9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 37:
                    zze = zzgx.zzg((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzC10 = zzep.zzC(i10 << 3);
                        zzC11 = zzep.zzC(zze);
                        zzC9 = zzC10 + zzC11 + zze;
                        i6 += zzC9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 38:
                    zze = zzgx.zzl((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzC10 = zzep.zzC(i10 << 3);
                        zzC11 = zzep.zzC(zze);
                        zzC9 = zzC10 + zzC11 + zze;
                        i6 += zzC9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 39:
                    zze = zzgx.zzf((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzC10 = zzep.zzC(i10 << 3);
                        zzC11 = zzep.zzC(zze);
                        zzC9 = zzC10 + zzC11 + zze;
                        i6 += zzC9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 40:
                    zze = zzgx.zze((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzC10 = zzep.zzC(i10 << 3);
                        zzC11 = zzep.zzC(zze);
                        zzC9 = zzC10 + zzC11 + zze;
                        i6 += zzC9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 41:
                    zze = zzgx.zzc((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzC10 = zzep.zzC(i10 << 3);
                        zzC11 = zzep.zzC(zze);
                        zzC9 = zzC10 + zzC11 + zze;
                        i6 += zzC9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 42:
                    List list12 = (List) unsafe.getObject(obj2, j);
                    int i32 = zzgx.zza;
                    zze = list12.size();
                    if (zze > 0) {
                        zzC10 = zzep.zzC(i10 << 3);
                        zzC11 = zzep.zzC(zze);
                        zzC9 = zzC10 + zzC11 + zze;
                        i6 += zzC9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 43:
                    zze = zzgx.zzk((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzC10 = zzep.zzC(i10 << 3);
                        zzC11 = zzep.zzC(zze);
                        zzC9 = zzC10 + zzC11 + zze;
                        i6 += zzC9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 44:
                    zze = zzgx.zza((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzC10 = zzep.zzC(i10 << 3);
                        zzC11 = zzep.zzC(zze);
                        zzC9 = zzC10 + zzC11 + zze;
                        i6 += zzC9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 45:
                    zze = zzgx.zzc((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzC10 = zzep.zzC(i10 << 3);
                        zzC11 = zzep.zzC(zze);
                        zzC9 = zzC10 + zzC11 + zze;
                        i6 += zzC9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 46:
                    zze = zzgx.zze((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzC10 = zzep.zzC(i10 << 3);
                        zzC11 = zzep.zzC(zze);
                        zzC9 = zzC10 + zzC11 + zze;
                        i6 += zzC9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 47:
                    zze = zzgx.zzi((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzC10 = zzep.zzC(i10 << 3);
                        zzC11 = zzep.zzC(zze);
                        zzC9 = zzC10 + zzC11 + zze;
                        i6 += zzC9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 48:
                    zze = zzgx.zzj((List) unsafe.getObject(obj2, j));
                    if (zze > 0) {
                        zzC10 = zzep.zzC(i10 << 3);
                        zzC11 = zzep.zzC(zze);
                        zzC9 = zzC10 + zzC11 + zze;
                        i6 += zzC9;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 49:
                    List list13 = (List) unsafe.getObject(obj2, j);
                    zzgv zzv2 = zzgoVar.zzv(i4);
                    int i33 = zzgx.zza;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        i3 = 0;
                    } else {
                        i3 = 0;
                        for (int i34 = 0; i34 < size6; i34++) {
                            i3 += zzep.zzy(i10, (zzgl) list13.get(i34), zzv2);
                        }
                    }
                    i6 += i3;
                    i4 += 3;
                    obj2 = obj;
                case 50:
                    zzgf zzgfVar = (zzgf) unsafe.getObject(obj2, j);
                    if (zzgfVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzgfVar.entrySet().iterator();
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
                    if (zzgoVar.zzM(obj2, i10, i4)) {
                        zzC12 = zzep.zzC(i10 << 3);
                        zzh = zzC12 + 8;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 52:
                    if (zzgoVar.zzM(obj2, i10, i4)) {
                        zzC13 = zzep.zzC(i10 << 3);
                        zzh = zzC13 + 4;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 53:
                    if (zzgoVar.zzM(obj2, i10, i4)) {
                        long zzt = zzt(obj2, j);
                        zzl = zzep.zzC(i10 << 3);
                        i2 = zzep.zzD(zzt);
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 54:
                    if (zzgoVar.zzM(obj2, i10, i4)) {
                        long zzt2 = zzt(obj2, j);
                        zzl = zzep.zzC(i10 << 3);
                        i2 = zzep.zzD(zzt2);
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 55:
                    if (zzgoVar.zzM(obj2, i10, i4)) {
                        long zzo = zzo(obj2, j);
                        zzl = zzep.zzC(i10 << 3);
                        i2 = zzep.zzD(zzo);
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 56:
                    if (zzgoVar.zzM(obj2, i10, i4)) {
                        zzC12 = zzep.zzC(i10 << 3);
                        zzh = zzC12 + 8;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 57:
                    if (zzgoVar.zzM(obj2, i10, i4)) {
                        zzC13 = zzep.zzC(i10 << 3);
                        zzh = zzC13 + 4;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 58:
                    if (zzgoVar.zzM(obj2, i10, i4)) {
                        zzh = zzep.zzC(i10 << 3) + 1;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 59:
                    if (zzgoVar.zzM(obj2, i10, i4)) {
                        int i35 = i10 << 3;
                        Object object2 = unsafe.getObject(obj2, j);
                        if (object2 instanceof zzei) {
                            zzC14 = zzep.zzC(i35);
                            zzd2 = ((zzei) object2).zzd();
                            zzC15 = zzep.zzC(zzd2);
                            zzh = zzC14 + zzC15 + zzd2;
                            i6 += zzh;
                            i4 += 3;
                            obj2 = obj;
                        } else {
                            zzl = zzep.zzC(i35);
                            i2 = zzep.zzB((String) object2);
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
                    if (zzgoVar.zzM(obj2, i10, i4)) {
                        zzh = zzgx.zzh(i10, unsafe.getObject(obj2, j), zzgoVar.zzv(i4));
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 61:
                    if (zzgoVar.zzM(obj2, i10, i4)) {
                        zzei zzeiVar2 = (zzei) unsafe.getObject(obj2, j);
                        zzC14 = zzep.zzC(i10 << 3);
                        zzd2 = zzeiVar2.zzd();
                        zzC15 = zzep.zzC(zzd2);
                        zzh = zzC14 + zzC15 + zzd2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 62:
                    if (zzgoVar.zzM(obj2, i10, i4)) {
                        int zzo2 = zzo(obj2, j);
                        zzl = zzep.zzC(i10 << 3);
                        i2 = zzep.zzC(zzo2);
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 63:
                    if (zzgoVar.zzM(obj2, i10, i4)) {
                        long zzo3 = zzo(obj2, j);
                        zzl = zzep.zzC(i10 << 3);
                        i2 = zzep.zzD(zzo3);
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 64:
                    if (zzgoVar.zzM(obj2, i10, i4)) {
                        zzC13 = zzep.zzC(i10 << 3);
                        zzh = zzC13 + 4;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 65:
                    if (zzgoVar.zzM(obj2, i10, i4)) {
                        zzC12 = zzep.zzC(i10 << 3);
                        zzh = zzC12 + 8;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 66:
                    if (zzgoVar.zzM(obj2, i10, i4)) {
                        int zzo4 = zzo(obj2, j);
                        zzl = zzep.zzC(i10 << 3);
                        i2 = zzep.zzC((zzo4 >> 31) ^ (zzo4 + zzo4));
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 67:
                    if (zzgoVar.zzM(obj2, i10, i4)) {
                        long zzt3 = zzt(obj2, j);
                        zzl = zzep.zzC(i10 << 3);
                        i2 = zzep.zzD((zzt3 >> 63) ^ (zzt3 + zzt3));
                        zzh = zzl + i2;
                        i6 += zzh;
                        i4 += 3;
                        obj2 = obj;
                    } else {
                        i4 += 3;
                        obj2 = obj;
                    }
                case 68:
                    if (zzgoVar.zzM(obj2, i10, i4)) {
                        zzh = zzep.zzy(i10, (zzgl) unsafe.getObject(obj2, j), zzgoVar.zzv(i4));
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

    @Override // com.google.android.gms.internal.play_billing.zzgv
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
                int hashCode = (i4 * 53) + ((zzfi) obj).zzc.hashCode();
                return this.zzh ? (hashCode * 53) + ((zzff) obj).zzb.zza.hashCode() : hashCode;
            }
            int zzs = zzs(i3);
            int i5 = 1048575 & zzs;
            int zzr = zzr(zzs);
            int i6 = iArr[i3];
            long j = i5;
            int i7 = 37;
            switch (zzr) {
                case 0:
                    i = i4 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zzho.zza(obj, j));
                    byte[] bArr = zzfo.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i4 = i + floatToIntBits;
                    break;
                case 1:
                    i = i4 * 53;
                    floatToIntBits = Float.floatToIntBits(zzho.zzb(obj, j));
                    i4 = i + floatToIntBits;
                    break;
                case 2:
                    i = i4 * 53;
                    doubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr2 = zzfo.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i4 = i + floatToIntBits;
                    break;
                case 3:
                    i = i4 * 53;
                    doubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr3 = zzfo.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i4 = i + floatToIntBits;
                    break;
                case 4:
                    i = i4 * 53;
                    floatToIntBits = zzho.zzc(obj, j);
                    i4 = i + floatToIntBits;
                    break;
                case 5:
                    i = i4 * 53;
                    doubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr4 = zzfo.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i4 = i + floatToIntBits;
                    break;
                case 6:
                    i = i4 * 53;
                    floatToIntBits = zzho.zzc(obj, j);
                    i4 = i + floatToIntBits;
                    break;
                case 7:
                    i = i4 * 53;
                    floatToIntBits = zzfo.zza(zzho.zzw(obj, j));
                    i4 = i + floatToIntBits;
                    break;
                case 8:
                    i = i4 * 53;
                    floatToIntBits = ((String) zzho.zzf(obj, j)).hashCode();
                    i4 = i + floatToIntBits;
                    break;
                case 9:
                    i2 = i4 * 53;
                    Object zzf = zzho.zzf(obj, j);
                    if (zzf != null) {
                        i7 = zzf.hashCode();
                    }
                    i4 = i2 + i7;
                    break;
                case 10:
                    i = i4 * 53;
                    floatToIntBits = zzho.zzf(obj, j).hashCode();
                    i4 = i + floatToIntBits;
                    break;
                case 11:
                    i = i4 * 53;
                    floatToIntBits = zzho.zzc(obj, j);
                    i4 = i + floatToIntBits;
                    break;
                case 12:
                    i = i4 * 53;
                    floatToIntBits = zzho.zzc(obj, j);
                    i4 = i + floatToIntBits;
                    break;
                case 13:
                    i = i4 * 53;
                    floatToIntBits = zzho.zzc(obj, j);
                    i4 = i + floatToIntBits;
                    break;
                case 14:
                    i = i4 * 53;
                    doubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr5 = zzfo.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i4 = i + floatToIntBits;
                    break;
                case 15:
                    i = i4 * 53;
                    floatToIntBits = zzho.zzc(obj, j);
                    i4 = i + floatToIntBits;
                    break;
                case 16:
                    i = i4 * 53;
                    doubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr6 = zzfo.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i4 = i + floatToIntBits;
                    break;
                case 17:
                    i2 = i4 * 53;
                    Object zzf2 = zzho.zzf(obj, j);
                    if (zzf2 != null) {
                        i7 = zzf2.hashCode();
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
                    floatToIntBits = zzho.zzf(obj, j).hashCode();
                    i4 = i + floatToIntBits;
                    break;
                case 50:
                    i = i4 * 53;
                    floatToIntBits = zzho.zzf(obj, j).hashCode();
                    i4 = i + floatToIntBits;
                    break;
                case 51:
                    if (!zzM(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzfo.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 52:
                    if (!zzM(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 53:
                    if (!zzM(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr8 = zzfo.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 54:
                    if (!zzM(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr9 = zzfo.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 55:
                    if (!zzM(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzo(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 56:
                    if (!zzM(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr10 = zzfo.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 57:
                    if (!zzM(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzo(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 58:
                    if (!zzM(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzfo.zza(zzN(obj, j));
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 59:
                    if (!zzM(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = ((String) zzho.zzf(obj, j)).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 60:
                    if (!zzM(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzho.zzf(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 61:
                    if (!zzM(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzho.zzf(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 62:
                    if (!zzM(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzo(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 63:
                    if (!zzM(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzo(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 64:
                    if (!zzM(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzo(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 65:
                    if (!zzM(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr11 = zzfo.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 66:
                    if (!zzM(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzo(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 67:
                    if (!zzM(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr12 = zzfo.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    }
                case 68:
                    if (!zzM(obj, i6, i3)) {
                        break;
                    } else {
                        i = i4 * 53;
                        floatToIntBits = zzho.zzf(obj, j).hashCode();
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
    final int zzc(java.lang.Object r35, byte[] r36, int r37, int r38, int r39, com.google.android.gms.internal.play_billing.zzdw r40) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgo.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzdw):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final Object zze() {
        return ((zzfi) this.zzg).zzo();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzfi) {
                zzfi zzfiVar = (zzfi) obj;
                zzfiVar.zzx(Integer.MAX_VALUE);
                zzfiVar.zza = 0;
                zzfiVar.zzv();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int zzs = zzs(i);
                int i2 = 1048575 & zzs;
                int zzr = zzr(zzs);
                long j = i2;
                if (zzr != 9) {
                    if (zzr != 60 && zzr != 68) {
                        switch (zzr) {
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
                                ((zzfn) zzho.zzf(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzgf) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzM(obj, iArr[i], i)) {
                        zzv(i).zzf(zzb.getObject(obj, j));
                    }
                }
                if (zzI(obj, i)) {
                    zzv(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzl.zzb(obj);
            if (this.zzh) {
                this.zzm.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zzgx.zzp(this.zzl, obj, obj2);
                if (this.zzh) {
                    zzgx.zzo(this.zzm, obj, obj2);
                    return;
                }
                return;
            }
            int zzs = zzs(i);
            int i2 = 1048575 & zzs;
            int zzr = zzr(zzs);
            int i3 = iArr[i];
            long j = i2;
            switch (zzr) {
                case 0:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzho.zzo(obj, j, zzho.zza(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 1:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzho.zzp(obj, j, zzho.zzb(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 2:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 3:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 4:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 5:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 6:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 7:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzho.zzm(obj, j, zzho.zzw(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 8:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzho.zzs(obj, j, zzho.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzho.zzs(obj, j, zzho.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 11:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 12:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 13:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 14:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 15:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 16:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 17:
                    zzB(obj, obj2, i);
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
                    zzfn zzfnVar = (zzfn) zzho.zzf(obj, j);
                    zzfn zzfnVar2 = (zzfn) zzho.zzf(obj2, j);
                    int size = zzfnVar.size();
                    int size2 = zzfnVar2.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzfnVar.zzc()) {
                            zzfnVar = zzfnVar.zzd(size2 + size);
                        }
                        zzfnVar.addAll(zzfnVar2);
                    }
                    if (size > 0) {
                        zzfnVar2 = zzfnVar;
                    }
                    zzho.zzs(obj, j, zzfnVar2);
                    break;
                case 50:
                    int i4 = zzgx.zza;
                    zzho.zzs(obj, j, zzgg.zza(zzho.zzf(obj, j), zzho.zzf(obj2, j)));
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
                    if (!zzM(obj2, i3, i)) {
                        break;
                    } else {
                        zzho.zzs(obj, j, zzho.zzf(obj2, j));
                        zzE(obj, i3, i);
                        break;
                    }
                case 60:
                    zzC(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzM(obj2, i3, i)) {
                        break;
                    } else {
                        zzho.zzs(obj, j, zzho.zzf(obj2, j));
                        zzE(obj, i3, i);
                        break;
                    }
                case 68:
                    zzC(obj, obj2, i);
                    break;
            }
            i += 3;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzdw zzdwVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzdwVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:251:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    @Override // com.google.android.gms.internal.play_billing.zzgv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzi(Object obj, zzhu zzhuVar) throws IOException {
        Map.Entry entry;
        int[] iArr;
        int i;
        int i2;
        int i3;
        zzgo<T> zzgoVar = this;
        if (zzgoVar.zzh) {
            zzez zzezVar = ((zzff) obj).zzb;
            if (!zzezVar.zza.isEmpty()) {
                entry = (Map.Entry) zzezVar.zzf().next();
                iArr = zzgoVar.zzc;
                Unsafe unsafe = zzb;
                int i4 = 1048575;
                int i5 = 1048575;
                i = 0;
                int i6 = 0;
                while (i < iArr.length) {
                    int zzs = zzgoVar.zzs(i);
                    int zzr = zzr(zzs);
                    int i7 = iArr[i];
                    if (zzr <= 17) {
                        int i8 = iArr[i + 2];
                        int i9 = i8 & i4;
                        if (i9 != i5) {
                            i6 = i9 == i4 ? 0 : unsafe.getInt(obj, i9);
                            i5 = i9;
                        }
                        i2 = zzs;
                        i3 = 1 << (i8 >>> 20);
                    } else {
                        i2 = zzs;
                        i3 = 0;
                    }
                    if (entry != null) {
                        throw null;
                    }
                    long j = i2 & i4;
                    switch (zzr) {
                        case 0:
                            if (zzgoVar.zzJ(obj, i, i5, i6, i3)) {
                                zzhuVar.zzf(i7, zzho.zza(obj, j));
                                continue;
                            }
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 1:
                            if (zzgoVar.zzJ(obj, i, i5, i6, i3)) {
                                zzhuVar.zzo(i7, zzho.zzb(obj, j));
                            } else {
                                continue;
                            }
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 2:
                            if (zzgoVar.zzJ(obj, i, i5, i6, i3)) {
                                zzhuVar.zzt(i7, unsafe.getLong(obj, j));
                            } else {
                                continue;
                            }
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 3:
                            if (zzgoVar.zzJ(obj, i, i5, i6, i3)) {
                                zzhuVar.zzK(i7, unsafe.getLong(obj, j));
                            } else {
                                continue;
                            }
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 4:
                            if (zzgoVar.zzJ(obj, i, i5, i6, i3)) {
                                zzhuVar.zzr(i7, unsafe.getInt(obj, j));
                            } else {
                                continue;
                            }
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 5:
                            if (zzgoVar.zzJ(obj, i, i5, i6, i3)) {
                                zzhuVar.zzm(i7, unsafe.getLong(obj, j));
                            } else {
                                continue;
                            }
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 6:
                            if (zzgoVar.zzJ(obj, i, i5, i6, i3)) {
                                zzhuVar.zzk(i7, unsafe.getInt(obj, j));
                            } else {
                                continue;
                            }
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 7:
                            if (zzgoVar.zzJ(obj, i, i5, i6, i3)) {
                                zzhuVar.zzb(i7, zzho.zzw(obj, j));
                            } else {
                                continue;
                            }
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 8:
                            if (zzgoVar.zzJ(obj, i, i5, i6, i3)) {
                                zzO(i7, unsafe.getObject(obj, j), zzhuVar);
                            } else {
                                continue;
                            }
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 9:
                            if (zzgoVar.zzJ(obj, i, i5, i6, i3)) {
                                zzhuVar.zzv(i7, unsafe.getObject(obj, j), zzgoVar.zzv(i));
                            } else {
                                continue;
                            }
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 10:
                            if (zzgoVar.zzJ(obj, i, i5, i6, i3)) {
                                zzhuVar.zzd(i7, (zzei) unsafe.getObject(obj, j));
                            } else {
                                continue;
                            }
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 11:
                            if (zzgoVar.zzJ(obj, i, i5, i6, i3)) {
                                zzhuVar.zzI(i7, unsafe.getInt(obj, j));
                            } else {
                                continue;
                            }
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 12:
                            if (zzgoVar.zzJ(obj, i, i5, i6, i3)) {
                                zzhuVar.zzi(i7, unsafe.getInt(obj, j));
                            } else {
                                continue;
                            }
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 13:
                            if (zzgoVar.zzJ(obj, i, i5, i6, i3)) {
                                zzhuVar.zzx(i7, unsafe.getInt(obj, j));
                            } else {
                                continue;
                            }
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 14:
                            if (zzgoVar.zzJ(obj, i, i5, i6, i3)) {
                                zzhuVar.zzz(i7, unsafe.getLong(obj, j));
                            } else {
                                continue;
                            }
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 15:
                            if (zzgoVar.zzJ(obj, i, i5, i6, i3)) {
                                zzhuVar.zzB(i7, unsafe.getInt(obj, j));
                            } else {
                                continue;
                            }
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 16:
                            if (zzgoVar.zzJ(obj, i, i5, i6, i3)) {
                                zzhuVar.zzD(i7, unsafe.getLong(obj, j));
                            } else {
                                continue;
                            }
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 17:
                            if (zzgoVar.zzJ(obj, i, i5, i6, i3)) {
                                zzhuVar.zzq(i7, unsafe.getObject(obj, j), zzgoVar.zzv(i));
                            } else {
                                continue;
                            }
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 18:
                            zzgx.zzr(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, false);
                            continue;
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 19:
                            zzgx.zzv(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, false);
                            continue;
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 20:
                            zzgx.zzx(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, false);
                            continue;
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 21:
                            zzgx.zzD(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, false);
                            continue;
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 22:
                            zzgx.zzw(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, false);
                            continue;
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 23:
                            zzgx.zzu(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, false);
                            continue;
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 24:
                            zzgx.zzt(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, false);
                            continue;
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 25:
                            zzgx.zzq(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, false);
                            continue;
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 26:
                            int i10 = iArr[i];
                            List list = (List) unsafe.getObject(obj, j);
                            int i11 = zzgx.zza;
                            if (list != null && !list.isEmpty()) {
                                zzhuVar.zzH(i10, list);
                                break;
                            }
                            break;
                        case 27:
                            int i12 = iArr[i];
                            List list2 = (List) unsafe.getObject(obj, j);
                            zzgv zzv = zzgoVar.zzv(i);
                            int i13 = zzgx.zza;
                            if (list2 != null && !list2.isEmpty()) {
                                for (int i14 = 0; i14 < list2.size(); i14++) {
                                    ((zzeq) zzhuVar).zzv(i12, list2.get(i14), zzv);
                                }
                                break;
                            }
                            break;
                        case 28:
                            int i15 = iArr[i];
                            List list3 = (List) unsafe.getObject(obj, j);
                            int i16 = zzgx.zza;
                            if (list3 != null && !list3.isEmpty()) {
                                zzhuVar.zze(i15, list3);
                                break;
                            }
                            break;
                        case 29:
                            zzgx.zzC(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, false);
                            continue;
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 30:
                            zzgx.zzs(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, false);
                            continue;
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 31:
                            zzgx.zzy(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, false);
                            continue;
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 32:
                            zzgx.zzz(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, false);
                            continue;
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 33:
                            zzgx.zzA(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, false);
                            continue;
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 34:
                            zzgx.zzB(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, false);
                            continue;
                            i += 3;
                            i4 = 1048575;
                            zzgoVar = this;
                        case 35:
                            zzgx.zzr(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, true);
                            break;
                        case 36:
                            zzgx.zzv(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, true);
                            break;
                        case 37:
                            zzgx.zzx(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, true);
                            break;
                        case 38:
                            zzgx.zzD(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, true);
                            break;
                        case 39:
                            zzgx.zzw(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, true);
                            break;
                        case 40:
                            zzgx.zzu(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, true);
                            break;
                        case 41:
                            zzgx.zzt(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, true);
                            break;
                        case 42:
                            zzgx.zzq(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, true);
                            break;
                        case 43:
                            zzgx.zzC(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, true);
                            break;
                        case 44:
                            zzgx.zzs(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, true);
                            break;
                        case 45:
                            zzgx.zzy(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, true);
                            break;
                        case 46:
                            zzgx.zzz(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, true);
                            break;
                        case 47:
                            zzgx.zzA(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, true);
                            break;
                        case 48:
                            zzgx.zzB(iArr[i], (List) unsafe.getObject(obj, j), zzhuVar, true);
                            break;
                        case 49:
                            int i17 = iArr[i];
                            List list4 = (List) unsafe.getObject(obj, j);
                            zzgv zzv2 = zzgoVar.zzv(i);
                            int i18 = zzgx.zza;
                            if (list4 != null && !list4.isEmpty()) {
                                for (int i19 = 0; i19 < list4.size(); i19++) {
                                    ((zzeq) zzhuVar).zzq(i17, list4.get(i19), zzv2);
                                }
                                break;
                            }
                            break;
                        case 50:
                            if (unsafe.getObject(obj, j) != null) {
                                throw null;
                            }
                            break;
                        case 51:
                            if (zzgoVar.zzM(obj, i7, i)) {
                                zzhuVar.zzf(i7, zzm(obj, j));
                                break;
                            }
                            break;
                        case 52:
                            if (zzgoVar.zzM(obj, i7, i)) {
                                zzhuVar.zzo(i7, zzn(obj, j));
                                break;
                            }
                            break;
                        case 53:
                            if (zzgoVar.zzM(obj, i7, i)) {
                                zzhuVar.zzt(i7, zzt(obj, j));
                                break;
                            }
                            break;
                        case 54:
                            if (zzgoVar.zzM(obj, i7, i)) {
                                zzhuVar.zzK(i7, zzt(obj, j));
                                break;
                            }
                            break;
                        case 55:
                            if (zzgoVar.zzM(obj, i7, i)) {
                                zzhuVar.zzr(i7, zzo(obj, j));
                                break;
                            }
                            break;
                        case 56:
                            if (zzgoVar.zzM(obj, i7, i)) {
                                zzhuVar.zzm(i7, zzt(obj, j));
                                break;
                            }
                            break;
                        case 57:
                            if (zzgoVar.zzM(obj, i7, i)) {
                                zzhuVar.zzk(i7, zzo(obj, j));
                                break;
                            }
                            break;
                        case 58:
                            if (zzgoVar.zzM(obj, i7, i)) {
                                zzhuVar.zzb(i7, zzN(obj, j));
                                break;
                            }
                            break;
                        case 59:
                            if (zzgoVar.zzM(obj, i7, i)) {
                                zzO(i7, unsafe.getObject(obj, j), zzhuVar);
                                break;
                            }
                            break;
                        case 60:
                            if (zzgoVar.zzM(obj, i7, i)) {
                                zzhuVar.zzv(i7, unsafe.getObject(obj, j), zzgoVar.zzv(i));
                                break;
                            }
                            break;
                        case 61:
                            if (zzgoVar.zzM(obj, i7, i)) {
                                zzhuVar.zzd(i7, (zzei) unsafe.getObject(obj, j));
                                break;
                            }
                            break;
                        case 62:
                            if (zzgoVar.zzM(obj, i7, i)) {
                                zzhuVar.zzI(i7, zzo(obj, j));
                                break;
                            }
                            break;
                        case 63:
                            if (zzgoVar.zzM(obj, i7, i)) {
                                zzhuVar.zzi(i7, zzo(obj, j));
                                break;
                            }
                            break;
                        case 64:
                            if (zzgoVar.zzM(obj, i7, i)) {
                                zzhuVar.zzx(i7, zzo(obj, j));
                                break;
                            }
                            break;
                        case 65:
                            if (zzgoVar.zzM(obj, i7, i)) {
                                zzhuVar.zzz(i7, zzt(obj, j));
                                break;
                            }
                            break;
                        case 66:
                            if (zzgoVar.zzM(obj, i7, i)) {
                                zzhuVar.zzB(i7, zzo(obj, j));
                                break;
                            }
                            break;
                        case 67:
                            if (zzgoVar.zzM(obj, i7, i)) {
                                zzhuVar.zzD(i7, zzt(obj, j));
                                break;
                            }
                            break;
                        case 68:
                            if (zzgoVar.zzM(obj, i7, i)) {
                                zzhuVar.zzq(i7, unsafe.getObject(obj, j), zzgoVar.zzv(i));
                                break;
                            }
                            break;
                    }
                    i += 3;
                    i4 = 1048575;
                    zzgoVar = this;
                }
                if (entry != null) {
                    ((zzfi) obj).zzc.zzl(zzhuVar);
                    return;
                } else {
                    throw null;
                }
            }
        }
        entry = null;
        iArr = zzgoVar.zzc;
        Unsafe unsafe2 = zzb;
        int i42 = 1048575;
        int i52 = 1048575;
        i = 0;
        int i62 = 0;
        while (i < iArr.length) {
        }
        if (entry != null) {
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final boolean zzj(Object obj, Object obj2) {
        boolean zzE;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzs = zzs(i);
            long j = zzs & 1048575;
            switch (zzr(zzs)) {
                case 0:
                    if (zzH(obj, obj2, i) && Double.doubleToLongBits(zzho.zza(obj, j)) == Double.doubleToLongBits(zzho.zza(obj2, j))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzH(obj, obj2, i) && Float.floatToIntBits(zzho.zzb(obj, j)) == Float.floatToIntBits(zzho.zzb(obj2, j))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzH(obj, obj2, i) && zzho.zzd(obj, j) == zzho.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzH(obj, obj2, i) && zzho.zzd(obj, j) == zzho.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzH(obj, obj2, i) && zzho.zzc(obj, j) == zzho.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzH(obj, obj2, i) && zzho.zzd(obj, j) == zzho.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzH(obj, obj2, i) && zzho.zzc(obj, j) == zzho.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzH(obj, obj2, i) && zzho.zzw(obj, j) == zzho.zzw(obj2, j)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzH(obj, obj2, i) && zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzH(obj, obj2, i) && zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzH(obj, obj2, i) && zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzH(obj, obj2, i) && zzho.zzc(obj, j) == zzho.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzH(obj, obj2, i) && zzho.zzc(obj, j) == zzho.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzH(obj, obj2, i) && zzho.zzc(obj, j) == zzho.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzH(obj, obj2, i) && zzho.zzd(obj, j) == zzho.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzH(obj, obj2, i) && zzho.zzc(obj, j) == zzho.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzH(obj, obj2, i) && zzho.zzd(obj, j) == zzho.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzH(obj, obj2, i) && zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
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
                    zzE = zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j));
                    break;
                case 50:
                    zzE = zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j));
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
                    long zzp = zzp(i) & 1048575;
                    if (zzho.zzc(obj, zzp) == zzho.zzc(obj2, zzp) && zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzE) {
                return false;
            }
        }
        if (!((zzfi) obj).zzc.equals(((zzfi) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzff) obj).zzb.equals(((zzff) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i5];
            int i8 = iArr2[i7];
            int zzs = zzs(i7);
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
            if ((268435456 & zzs) != 0 && !zzJ(obj, i2, i, i3, i11)) {
                return false;
            }
            int zzr = zzr(zzs);
            if (zzr != 9 && zzr != 17) {
                if (zzr != 27) {
                    if (zzr == 60 || zzr == 68) {
                        if (zzM(obj, i8, i2) && !zzK(obj, zzs, zzv(i2))) {
                            return false;
                        }
                    } else if (zzr != 49) {
                        if (zzr == 50 && !((zzgf) zzho.zzf(obj, zzs & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zzho.zzf(obj, zzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgv zzv = zzv(i2);
                    for (int i13 = 0; i13 < list.size(); i13++) {
                        if (!zzv.zzk(list.get(i13))) {
                            return false;
                        }
                    }
                }
            } else if (zzJ(obj, i2, i, i3, i11) && !zzK(obj, zzs, zzv(i2))) {
                return false;
            }
            i5++;
            i6 = i;
            i4 = i3;
        }
        return !this.zzh || ((zzff) obj).zzb.zzi();
    }
}
