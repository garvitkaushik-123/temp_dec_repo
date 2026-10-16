package com.inmobi.media;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.m8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2762m8 {
    public static byte a(String referencedCreativeString) {
        Intrinsics.checkNotNullParameter(referencedCreativeString, "referencedCreativeString");
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = referencedCreativeString.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int length = lowerCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) lowerCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String a2 = I7.a(length, 1, lowerCase, i);
        int hashCode = a2.hashCode();
        if (hashCode != -1412832500) {
            return hashCode != 0 ? (byte) 1 : (byte) 1;
        }
        if (a2.equals("companion")) {
            return (byte) 2;
        }
        return (byte) 0;
    }
}
