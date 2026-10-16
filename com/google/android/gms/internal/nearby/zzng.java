package com.google.android.gms.internal.nearby;

import android.os.ParcelUuid;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.util.Hex;
import com.ironsource.C3040d4;
import com.ironsource.D5;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzng {
    private static final ParcelUuid zza = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    private final int zzb;
    private final List zzc;
    private final SparseArray zzd;
    private final Map zze;
    private final int zzf;
    private final String zzg;
    private final byte[] zzh;

    private zzng(List list, SparseArray sparseArray, Map map, int i, int i2, String str, byte[] bArr) {
        this.zzc = list;
        this.zzd = sparseArray;
        this.zze = map;
        this.zzg = str;
        this.zzb = i;
        this.zzf = i2;
        this.zzh = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzng zza(byte[] bArr) {
        byte[] bArr2;
        if (bArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        HashMap hashMap = new HashMap();
        int i = -1;
        int i2 = 0;
        String str = null;
        byte b = -2147483648;
        try {
            while (i2 < bArr.length) {
                try {
                    int i3 = i2 + 1;
                    int i4 = bArr[i2] & 255;
                    if (i4 == 0) {
                        bArr2 = bArr;
                        return new zzng(true == arrayList.isEmpty() ? arrayList : null, sparseArray, hashMap, i, b, str, bArr2);
                    }
                    int i5 = i4 - 1;
                    int i6 = i2 + 2;
                    int i7 = bArr[i3] & 255;
                    if (i7 == 22) {
                        hashMap.put(zzc(zzd(bArr, i6, 2)), zzd(bArr, i2 + 4, i4 - 3));
                    } else if (i7 != 255) {
                        switch (i7) {
                            case 1:
                                i = bArr[i6] & 255;
                                break;
                            case 2:
                            case 3:
                                zzb(bArr, i6, i5, 2, arrayList);
                                break;
                            case 4:
                            case 5:
                                zzb(bArr, i6, i5, 4, arrayList);
                                break;
                            case 6:
                            case 7:
                                zzb(bArr, i6, i5, 16, arrayList);
                                break;
                            case 8:
                            case 9:
                                str = new String(zzd(bArr, i6, i5));
                                break;
                            case 10:
                                b = bArr[i6];
                                break;
                        }
                    } else {
                        sparseArray.put(((bArr[i2 + 3] & 255) << 8) + (255 & bArr[i6]), zzd(bArr, i2 + 4, i4 - 3));
                    }
                    i2 = i6 + i5;
                } catch (Exception e) {
                    e = e;
                    bArr2 = bArr;
                }
            }
            return new zzng(true == arrayList.isEmpty() ? arrayList : null, sparseArray, hashMap, i, b, str, bArr2);
        } catch (Exception e2) {
            e = e2;
            Log.w("BleRecord", "Unable to parse scan record: ".concat(String.valueOf(Arrays.toString(bArr2))), e);
            return null;
        }
        bArr2 = bArr;
    }

    private static int zzb(byte[] bArr, int i, int i2, int i3, List list) {
        while (i2 > 0) {
            list.add(zzc(zzd(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    private static ParcelUuid zzc(byte[] bArr) {
        long j;
        int length = bArr.length;
        if (length != 2 && length != 4 && length != 16) {
            throw new IllegalArgumentException("uuidBytes length invalid - " + length);
        }
        if (length == 16) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
        }
        if (length == 2) {
            j = (bArr[0] & 255) + ((bArr[1] & 255) << 8);
        } else {
            j = ((bArr[3] & 255) << 24) + (bArr[0] & 255) + ((bArr[1] & 255) << 8) + ((bArr[2] & 255) << 16);
        }
        ParcelUuid parcelUuid = zza;
        return new ParcelUuid(new UUID(parcelUuid.getUuid().getMostSignificantBits() + (j << 32), parcelUuid.getUuid().getLeastSignificantBits()));
    }

    private static byte[] zzd(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzng) {
            return Arrays.equals(this.zzh, ((zzng) obj).zzh);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzh);
    }

    public final String toString() {
        String sb;
        int i = this.zzb;
        String valueOf = String.valueOf(this.zzc);
        SparseArray sparseArray = this.zzd;
        StringBuilder sb2 = new StringBuilder();
        String str = "{}";
        int i2 = 0;
        if (sparseArray.size() <= 0) {
            sb = "{}";
        } else {
            sb2.append(AbstractJsonLexerKt.BEGIN_OBJ);
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                if (i3 > 0) {
                    sb2.append(", ");
                }
                int keyAt = sparseArray.keyAt(i3);
                byte[] bArr = (byte[]) sparseArray.valueAt(i3);
                sb2.append(keyAt);
                sb2.append(D5.T);
                sb2.append(bArr == null ? null : Hex.bytesToStringUppercase(bArr));
            }
            sb2.append(AbstractJsonLexerKt.END_OBJ);
            sb = sb2.toString();
        }
        Map map = this.zze;
        StringBuilder sb3 = new StringBuilder();
        if (!map.keySet().isEmpty()) {
            sb3.append(AbstractJsonLexerKt.BEGIN_OBJ);
            for (Map.Entry entry : map.entrySet()) {
                if (i2 > 0) {
                    sb3.append(", ");
                }
                sb3.append(entry.getKey());
                sb3.append(D5.T);
                byte[] bArr2 = (byte[]) entry.getValue();
                sb3.append(bArr2 == null ? null : Hex.bytesToStringUppercase(bArr2));
                i2++;
            }
            sb3.append(AbstractJsonLexerKt.END_OBJ);
            str = sb3.toString();
        }
        return "BleRecord [mAdvertiseFlags=" + i + ", mServiceUuids=" + valueOf + ", mManufacturerSpecificData=" + sb + ", mServiceData=" + str + ", mTxPowerLevel=" + this.zzf + ", mDeviceName=" + this.zzg + C3040d4.i.e;
    }
}
