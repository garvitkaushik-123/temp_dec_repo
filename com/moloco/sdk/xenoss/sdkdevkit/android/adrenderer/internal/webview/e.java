package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview;

import android.util.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class e implements f {

    /* renamed from: a, reason: collision with root package name */
    public static final int f6334a = 0;

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.f
    public String a(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        byte[] bytes = StringsKt.trimIndent(content).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String encodeToString = Base64.encodeToString(bytes, 1);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(...)");
        return encodeToString;
    }
}
