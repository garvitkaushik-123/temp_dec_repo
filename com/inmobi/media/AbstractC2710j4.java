package com.inmobi.media;

import android.util.Base64;
import android.util.Log;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* renamed from: com.inmobi.media.j4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2710j4 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2608a = 0;

    public static byte[] a(String str) {
        int i;
        if (str != null) {
            int length = str.length() % 4;
            i = length + ((((length ^ 4) & ((-length) | length)) >> 31) & 4);
        } else {
            i = 0;
        }
        String valueOf = String.valueOf(str != null ? StringsKt.reversed((CharSequence) str).toString() : null);
        for (int i2 = 0; i2 < i; i2++) {
            valueOf = valueOf + com.ironsource.D5.T;
        }
        byte[] bytes = valueOf.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return Base64.decode(bytes, 2);
    }

    public static String a(String data, byte[] bArr) {
        byte[] bArr2;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullExpressionValue("j4", "TAG");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
            Intrinsics.checkNotNullExpressionValue(cipher, "getInstance(...)");
            cipher.init(1, secretKeySpec);
            byte[] bytes = data.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            bArr2 = cipher.doFinal(bytes);
        } catch (Throwable th) {
            Log.d("j4", "SDK encountered unexpected error in getting encrypted AES bytes; " + th.getMessage());
            bArr2 = null;
        }
        byte[] encode = Base64.encode(bArr2, 2);
        Intrinsics.checkNotNullExpressionValue(encode, "encode(...)");
        String str = new String(encode, Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue("j4", "TAG");
        return str;
    }
}
