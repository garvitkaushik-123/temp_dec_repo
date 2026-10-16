package io.bidmachine.util.network;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkUtils.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\f\u0010\t\u001a\u0004\u0018\u00010\u0007*\u00020\b¨\u0006\n"}, d2 = {"disconnectSafely", "", "Ljava/net/HttpURLConnection;", "isHttp", "", "Ljava/net/URL;", "readBytes", "", "Ljava/net/URLConnection;", "readBytesSafely", "bidmachine-android-sdk_ca_3_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class NetworkUtilsKt {
    public static final void disconnectSafely(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            httpURLConnection.disconnect();
            Unit unit = Unit.INSTANCE;
        } catch (Throwable unused) {
        }
    }

    public static final byte[] readBytes(URLConnection uRLConnection) {
        Intrinsics.checkNotNullParameter(uRLConnection, "<this>");
        InputStream inputStream = uRLConnection.getInputStream();
        try {
            InputStream it = inputStream;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            byte[] readBytes = ByteStreamsKt.readBytes(it);
            CloseableKt.closeFinally(inputStream, null);
            return readBytes;
        } finally {
        }
    }

    public static final byte[] readBytesSafely(URLConnection uRLConnection) {
        Intrinsics.checkNotNullParameter(uRLConnection, "<this>");
        try {
            return readBytes(uRLConnection);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final boolean isHttp(URL url) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        return Intrinsics.areEqual("http", url.getProtocol()) || Intrinsics.areEqual("https", url.getProtocol());
    }
}
