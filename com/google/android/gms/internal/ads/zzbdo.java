package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbdo extends zzbdp {
    zzbdo() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        if (r0 != r6.length()) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final String zzb(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            int i = 0;
            int i2 = 0;
            while (i2 < str.length() && str.charAt(i2) == ',') {
                i2++;
            }
            while (length > 0) {
                int i3 = length - 1;
                if (str.charAt(i3) != ',') {
                    break;
                }
                length = i3;
            }
            if (length < i2) {
                return null;
            }
            if (i2 != 0) {
                i = i2;
            }
            return str.substring(i, length);
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzbdp
    public final String zza(String str, String str2) {
        String zzb = zzb(str);
        String zzb2 = zzb(str2);
        if (TextUtils.isEmpty(zzb)) {
            return zzb2;
        }
        if (TextUtils.isEmpty(zzb2)) {
            return zzb;
        }
        return zzb + "," + zzb2;
    }
}
