package com.fyber.inneractive.sdk.web;

import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class b1 {
    public static final byte[] b = new byte[0];
    public static final b1 c = new b1();

    /* renamed from: a, reason: collision with root package name */
    public final z0 f1791a = new z0();

    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c1 a(HttpURLConnection httpURLConnection, ByteBuffer byteBuffer) {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        String contentType;
        String str;
        String str2;
        Map<String, List<String>> headerFields;
        String responseMessage;
        httpURLConnection.connect();
        for (int i = 0; i < 20; i++) {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 300 || responseCode >= 400) {
                try {
                    inputStream = httpURLConnection.getInputStream();
                } catch (Throwable unused) {
                    inputStream = null;
                }
                try {
                    byte[] array = byteBuffer.array();
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = inputStream.read(array);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(array, 0, read);
                        } catch (Throwable unused2) {
                        }
                    }
                } catch (Throwable unused3) {
                    byteArrayOutputStream = null;
                    com.fyber.inneractive.sdk.util.t.b(inputStream);
                    httpURLConnection.disconnect();
                    contentType = httpURLConnection.getContentType();
                    if (TextUtils.isEmpty(contentType)) {
                    }
                    HashMap hashMap = new HashMap();
                    headerFields = httpURLConnection.getHeaderFields();
                    if (headerFields != null) {
                    }
                    responseMessage = httpURLConnection.getResponseMessage();
                    if (TextUtils.isEmpty(responseMessage)) {
                    }
                }
                com.fyber.inneractive.sdk.util.t.b(inputStream);
                httpURLConnection.disconnect();
                contentType = httpURLConnection.getContentType();
                if (TextUtils.isEmpty(contentType)) {
                    String[] split = contentType.split(";");
                    str = split.length > 0 ? split[0].trim() : "";
                    str2 = split.length > 1 ? split[1].trim() : "";
                } else {
                    str = "";
                    str2 = str;
                }
                HashMap hashMap2 = new HashMap();
                headerFields = httpURLConnection.getHeaderFields();
                if (headerFields != null) {
                    for (String str3 : headerFields.keySet()) {
                        List<String> list = headerFields.get(str3);
                        if (list != null && list.size() > 0) {
                            hashMap2.put(str3, list.get(0));
                        }
                    }
                }
                responseMessage = httpURLConnection.getResponseMessage();
                if (TextUtils.isEmpty(responseMessage)) {
                    return new c1(byteArrayOutputStream == null ? b : byteArrayOutputStream.toByteArray(), hashMap2, str, str2, responseCode, responseMessage);
                }
                return null;
            }
            String headerField = httpURLConnection.getHeaderField("Location");
            if (TextUtils.isEmpty(headerField)) {
                return null;
            }
            httpURLConnection.disconnect();
            httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
            httpURLConnection.connect();
        }
        return null;
    }

    public static void a(WebResourceRequest webResourceRequest, HttpURLConnection httpURLConnection) {
        if (webResourceRequest.getRequestHeaders() == null || webResourceRequest.getRequestHeaders().size() <= 0) {
            return;
        }
        for (String str : webResourceRequest.getRequestHeaders().keySet()) {
            if (str != null && webResourceRequest.getRequestHeaders().get(str) != null) {
                httpURLConnection.setRequestProperty(str, webResourceRequest.getRequestHeaders().get(str));
            }
        }
    }
}
