package com.sourcepoint.cmplibrary.util;

import android.content.Context;
import com.ironsource.V5;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: IOUtils.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0000¨\u0006\u0007"}, d2 = {"file2List", "", "", "file2String", "readFromAsset", "Landroid/content/Context;", V5.c.b, "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IOUtilsKt {
    public static final String file2String(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(str);
        Intrinsics.checkNotNullExpressionValue(resourceAsStream, "getResourceAsStream(...)");
        Reader inputStreamReader = new InputStreamReader(resourceAsStream, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String readText = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            return readText;
        } finally {
        }
    }

    public static final List<String> file2List(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(str);
        Intrinsics.checkNotNullExpressionValue(resourceAsStream, "getResourceAsStream(...)");
        Reader inputStreamReader = new InputStreamReader(resourceAsStream, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            List<String> readLines = TextStreamsKt.readLines(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            return readLines;
        } finally {
        }
    }

    public static final String readFromAsset(Context context, String fileName) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        InputStream open = context.getAssets().open(fileName);
        Intrinsics.checkNotNullExpressionValue(open, "open(...)");
        return TextStreamsKt.readText(new InputStreamReader(open, Charsets.UTF_8));
    }
}
