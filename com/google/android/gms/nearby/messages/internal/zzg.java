package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzg extends zzc {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzg(String str, String str2) {
        super(r6);
        byte[] zzd = zzd(str);
        byte[] zzd2 = zzd(str2);
        int length = zzd.length;
        Preconditions.checkArgument(length == 10, "Namespace length(" + length + " bytes) must be 10 bytes.");
        int length2 = zzd2.length;
        Preconditions.checkArgument(length2 == 6, "Instance length(" + length2 + " bytes) must be 6 bytes.");
        byte[] concatByteArrays = ArrayUtils.concatByteArrays(zzd, zzd2);
        zze(concatByteArrays);
    }

    private static byte[] zze(byte[] bArr) {
        int length = bArr.length;
        boolean z = true;
        if (length != 10 && length != 16) {
            z = false;
        }
        Preconditions.checkArgument(z, "Bytes must be a namespace (10 bytes), or a namespace plus instance (16 bytes).");
        return bArr;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzc
    public final String toString() {
        return "EddystoneUidPrefix{bytes=" + zza() + "}";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzg(byte[] bArr) {
        super(bArr);
        zze(bArr);
    }
}
