package io.adn.sdk.internal.common.utils;

import android.util.Base64;
import com.google.common.base.Ascii;
import com.mbridge.msdk.foundation.tools.SameMD5;
import java.security.MessageDigest;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: Conversions.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u0019\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003*\u00020\u0005H\u0000¢\u0006\u0002\u0010\u0006\u001a\b\u0010\u0007\u001a\u00020\u0003H\u0000\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0000\u001a\f\u0010\u000b\u001a\u00020\u0003*\u00020\u0003H\u0000\u001a\f\u0010\u000e\u001a\u00020\u0003*\u00020\u000fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"SECOND_MILLIS", "", "toBase64", "", "kotlin.jvm.PlatformType", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Ljava/lang/String;", "randomUUID", "toInt", "", "", "toMD5", "HEX_ARRAY", "", "toHex", "", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ConversionsKt {
    private static final char[] HEX_ARRAY;
    public static final long SECOND_MILLIS = 1000;

    public static final int toInt(boolean z) {
        return z ? 1 : 0;
    }

    public static final String toBase64(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return Base64.encodeToString(bytes, 2);
    }

    public static final String randomUUID() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        return uuid;
    }

    public static final String toMD5(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
        return toHex(digest);
    }

    static {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        HEX_ARRAY = charArray;
    }

    public static final String toHex(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        char[] cArr = new char[bArr.length * 2];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }
}
