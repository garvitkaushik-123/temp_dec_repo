package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes6.dex */
public final class c implements j {
    public static final int b = 8;

    /* renamed from: a, reason: collision with root package name */
    public final Context f6332a;

    public c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f6332a = context;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.j
    public String a(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        InputStream open = this.f6332a.getAssets().open(fileName);
        Intrinsics.checkNotNullExpressionValue(open, "open(...)");
        Reader inputStreamReader = new InputStreamReader(open, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String readText = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            return readText;
        } finally {
        }
    }
}
