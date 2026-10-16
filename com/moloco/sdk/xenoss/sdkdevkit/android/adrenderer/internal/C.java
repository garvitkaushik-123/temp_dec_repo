package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import com.mbridge.msdk.foundation.tools.SameMD5;
import java.net.URI;
import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes6.dex */
public final class C {
    public static final String a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
        return C3456f.a(digest);
    }

    public static final String b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        URI uri = new URI(str);
        String uri2 = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), null, uri.getFragment()).toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "run(...)");
        MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
        byte[] bytes = uri2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
        return C3456f.a(digest);
    }
}
