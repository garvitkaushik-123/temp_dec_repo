package com.google.android.gms.internal.games_v2;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes5.dex */
final class zzgn {
    static void zza(Object obj, Object obj2) {
        if (obj == null) {
            String valueOf = String.valueOf(obj2);
            String.valueOf(valueOf);
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(valueOf)));
        }
        if (obj2 != null) {
            return;
        }
        String obj3 = obj.toString();
        StringBuilder sb = new StringBuilder(obj3.length() + 26);
        sb.append("null value in entry: ");
        sb.append(obj3);
        sb.append("=null");
        throw new NullPointerException(sb.toString());
    }

    static int zzb(int i, String str) {
        if (i >= 0) {
            return i;
        }
        StringBuilder sb = new StringBuilder(str.length() + 29 + String.valueOf(i).length());
        sb.append(str);
        sb.append(" cannot be negative but was: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }
}
