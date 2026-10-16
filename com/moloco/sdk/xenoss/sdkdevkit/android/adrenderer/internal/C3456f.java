package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import com.google.common.base.Ascii;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.f, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3456f {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f5843a;

    static {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        f5843a = charArray;
    }

    public static final String a(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        char[] cArr = new char[bArr.length * 2];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = f5843a;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }
}
