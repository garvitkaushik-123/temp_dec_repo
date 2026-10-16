package com.inmobi.media;

import androidx.core.app.NotificationCompat;
import com.google.common.net.HttpHeaders;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class H9 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2306a = 0;

    static {
        Intrinsics.checkNotNullExpressionValue("H9", "getSimpleName(...)");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x01ab, code lost:
    
        if (kotlin.collections.CollectionsKt.contains(r0, r1 != null ? r1.f2315a : null) != false) goto L86;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0114 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0141  */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C2962yc a(C2895uc request, Function2 function2) {
        HttpURLConnection httpURLConnection;
        C2962yc c2962yc;
        boolean z;
        C2962yc response;
        boolean z2;
        EnumC2790o4 a2;
        Integer num;
        Integer num2;
        I9 i9;
        C2879tc c2879tc;
        Intrinsics.checkNotNullParameter(request, "request");
        String msg = "REQUEST START, Attempt:" + (request.m + 1) + ", Time:" + System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(request, "<this>");
        Intrinsics.checkNotNullParameter(msg, "msg");
        request.toString();
        boolean z3 = T9.f2439a;
        EnumC2790o4 a3 = T9.a(false);
        ?? r5 = 0;
        try {
            if (a3 != null) {
                response = new C2962yc();
                response.f2765a = new I9(a3, "Network not reachable currently. Please try again.");
            } else {
                try {
                    httpURLConnection = a(request, J9.a(request.f2723a, request.d));
                } catch (OutOfMemoryError e) {
                    e = e;
                    httpURLConnection = null;
                } catch (Error e2) {
                    e = e2;
                    httpURLConnection = null;
                } catch (MalformedURLException e3) {
                    e = e3;
                    httpURLConnection = null;
                } catch (SocketTimeoutException e4) {
                    e = e4;
                    httpURLConnection = null;
                } catch (IOException e5) {
                    e = e5;
                    httpURLConnection = null;
                } catch (Exception e6) {
                    e = e6;
                    httpURLConnection = null;
                } catch (Throwable th) {
                    th = th;
                    boolean z4 = T9.f2439a;
                    T9.a((HttpURLConnection) r5);
                    throw th;
                }
                try {
                    httpURLConnection.setInstanceFollowRedirects(request.g);
                    if (request.b == EnumC2846rc.b) {
                        a(request.e, httpURLConnection, J9.a(request));
                    }
                    response = a(request, httpURLConnection);
                    T9.a(httpURLConnection);
                    z2 = false;
                } catch (Exception e7) {
                    e = e7;
                    c2962yc = new C2962yc();
                    c2962yc.f2765a = new I9(EnumC2790o4.e, e.getLocalizedMessage());
                    boolean z5 = T9.f2439a;
                    T9.a(httpURLConnection);
                    z = false;
                    response = c2962yc;
                    z2 = z;
                    if (z2) {
                    }
                    Intrinsics.checkNotNullParameter(request, "<this>");
                    Intrinsics.checkNotNullParameter("RESPONSE RECEIVED", NotificationCompat.CATEGORY_MESSAGE);
                    Intrinsics.checkNotNullParameter(response, "response");
                    request.toString();
                    response.toString();
                    num = response.d;
                    if (num != null) {
                    }
                    num2 = response.d;
                    if (num2 != null) {
                    }
                    IntRange intRange = new IntRange(500, CommonGatewayClient.CODE_599);
                    if (num2 != null) {
                    }
                    i9 = response.f2765a;
                    if ((i9 != null ? i9.f2315a : null) != EnumC2790o4.A) {
                    }
                    int i = request.m;
                    c2879tc = request.h;
                    if (c2879tc != null) {
                        if (function2 != null) {
                        }
                        request.m++;
                        response.f2765a = new I9(EnumC2790o4.m, "Retry Attempted");
                    }
                    return response;
                } catch (OutOfMemoryError e8) {
                    e = e8;
                    c2962yc = new C2962yc();
                    c2962yc.f2765a = new I9(EnumC2790o4.g, e.getLocalizedMessage());
                    boolean z52 = T9.f2439a;
                    T9.a(httpURLConnection);
                    z = false;
                    response = c2962yc;
                    z2 = z;
                    if (z2) {
                    }
                    Intrinsics.checkNotNullParameter(request, "<this>");
                    Intrinsics.checkNotNullParameter("RESPONSE RECEIVED", NotificationCompat.CATEGORY_MESSAGE);
                    Intrinsics.checkNotNullParameter(response, "response");
                    request.toString();
                    response.toString();
                    num = response.d;
                    if (num != null) {
                    }
                    num2 = response.d;
                    if (num2 != null) {
                    }
                    IntRange intRange2 = new IntRange(500, CommonGatewayClient.CODE_599);
                    if (num2 != null) {
                    }
                    i9 = response.f2765a;
                    if ((i9 != null ? i9.f2315a : null) != EnumC2790o4.A) {
                    }
                    int i2 = request.m;
                    c2879tc = request.h;
                    if (c2879tc != null) {
                    }
                    return response;
                } catch (MalformedURLException e9) {
                    e = e9;
                    c2962yc = new C2962yc();
                    c2962yc.f2765a = new I9(EnumC2790o4.u, e.getLocalizedMessage());
                    boolean z522 = T9.f2439a;
                    T9.a(httpURLConnection);
                    z = false;
                    response = c2962yc;
                    z2 = z;
                    if (z2) {
                    }
                    Intrinsics.checkNotNullParameter(request, "<this>");
                    Intrinsics.checkNotNullParameter("RESPONSE RECEIVED", NotificationCompat.CATEGORY_MESSAGE);
                    Intrinsics.checkNotNullParameter(response, "response");
                    request.toString();
                    response.toString();
                    num = response.d;
                    if (num != null) {
                    }
                    num2 = response.d;
                    if (num2 != null) {
                    }
                    IntRange intRange22 = new IntRange(500, CommonGatewayClient.CODE_599);
                    if (num2 != null) {
                    }
                    i9 = response.f2765a;
                    if ((i9 != null ? i9.f2315a : null) != EnumC2790o4.A) {
                    }
                    int i22 = request.m;
                    c2879tc = request.h;
                    if (c2879tc != null) {
                    }
                    return response;
                } catch (SocketTimeoutException e10) {
                    e = e10;
                    c2962yc = new C2962yc();
                    c2962yc.f2765a = new I9(EnumC2790o4.A, e.getLocalizedMessage());
                    boolean z5222 = T9.f2439a;
                    T9.a(httpURLConnection);
                    z = false;
                    response = c2962yc;
                    z2 = z;
                    if (z2) {
                    }
                    Intrinsics.checkNotNullParameter(request, "<this>");
                    Intrinsics.checkNotNullParameter("RESPONSE RECEIVED", NotificationCompat.CATEGORY_MESSAGE);
                    Intrinsics.checkNotNullParameter(response, "response");
                    request.toString();
                    response.toString();
                    num = response.d;
                    if (num != null) {
                    }
                    num2 = response.d;
                    if (num2 != null) {
                    }
                    IntRange intRange222 = new IntRange(500, CommonGatewayClient.CODE_599);
                    if (num2 != null) {
                    }
                    i9 = response.f2765a;
                    if ((i9 != null ? i9.f2315a : null) != EnumC2790o4.A) {
                    }
                    int i222 = request.m;
                    c2879tc = request.h;
                    if (c2879tc != null) {
                    }
                    return response;
                } catch (IOException e11) {
                    e = e11;
                    c2962yc = new C2962yc();
                    c2962yc.f2765a = new I9(EnumC2790o4.f, e.getLocalizedMessage());
                    boolean z6 = T9.f2439a;
                    T9.a(httpURLConnection);
                    z = true;
                    response = c2962yc;
                    z2 = z;
                    if (z2) {
                    }
                    Intrinsics.checkNotNullParameter(request, "<this>");
                    Intrinsics.checkNotNullParameter("RESPONSE RECEIVED", NotificationCompat.CATEGORY_MESSAGE);
                    Intrinsics.checkNotNullParameter(response, "response");
                    request.toString();
                    response.toString();
                    num = response.d;
                    if (num != null) {
                    }
                    num2 = response.d;
                    if (num2 != null) {
                    }
                    IntRange intRange2222 = new IntRange(500, CommonGatewayClient.CODE_599);
                    if (num2 != null) {
                    }
                    i9 = response.f2765a;
                    if ((i9 != null ? i9.f2315a : null) != EnumC2790o4.A) {
                    }
                    int i2222 = request.m;
                    c2879tc = request.h;
                    if (c2879tc != null) {
                    }
                    return response;
                } catch (Error e12) {
                    e = e12;
                    c2962yc = new C2962yc();
                    c2962yc.f2765a = new I9(EnumC2790o4.e, e.getLocalizedMessage());
                    boolean z52222 = T9.f2439a;
                    T9.a(httpURLConnection);
                    z = false;
                    response = c2962yc;
                    z2 = z;
                    if (z2) {
                    }
                    Intrinsics.checkNotNullParameter(request, "<this>");
                    Intrinsics.checkNotNullParameter("RESPONSE RECEIVED", NotificationCompat.CATEGORY_MESSAGE);
                    Intrinsics.checkNotNullParameter(response, "response");
                    request.toString();
                    response.toString();
                    num = response.d;
                    if (num != null) {
                    }
                    num2 = response.d;
                    if (num2 != null) {
                    }
                    IntRange intRange22222 = new IntRange(500, CommonGatewayClient.CODE_599);
                    if (num2 != null) {
                    }
                    i9 = response.f2765a;
                    if ((i9 != null ? i9.f2315a : null) != EnumC2790o4.A) {
                    }
                    int i22222 = request.m;
                    c2879tc = request.h;
                    if (c2879tc != null) {
                    }
                    return response;
                }
                if (z2) {
                    try {
                        boolean z7 = T9.f2439a;
                        if (T9.f2439a && (a2 = T9.a(true)) != null) {
                            response.f2765a = new I9(a2, "Network request failed because of internet. Please try again");
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            Intrinsics.checkNotNullParameter(request, "<this>");
            Intrinsics.checkNotNullParameter("RESPONSE RECEIVED", NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(response, "response");
            request.toString();
            response.toString();
            num = response.d;
            if (num != null || num.intValue() != 200) {
                num2 = response.d;
                if ((num2 != null || num2.intValue() != 401) && (num2 == null || num2.intValue() != 403)) {
                    IntRange intRange222222 = new IntRange(500, CommonGatewayClient.CODE_599);
                    if (num2 != null || !intRange222222.contains(num2.intValue())) {
                        i9 = response.f2765a;
                        if ((i9 != null ? i9.f2315a : null) != EnumC2790o4.A) {
                            List listOf = CollectionsKt.listOf((Object[]) new EnumC2790o4[]{EnumC2790o4.f, EnumC2790o4.y, EnumC2790o4.z, EnumC2790o4.w});
                            I9 i92 = response.f2765a;
                        }
                    }
                }
                int i222222 = request.m;
                c2879tc = request.h;
                if (c2879tc != null && i222222 < c2879tc.f2713a) {
                    if (function2 != null) {
                        function2.invoke(request, Long.valueOf((long) (Math.pow(1.0d, i222222) * c2879tc.b)));
                    }
                    request.m++;
                    response.f2765a = new I9(EnumC2790o4.m, "Retry Attempted");
                }
            }
            return response;
        } catch (Throwable th2) {
            th = th2;
            r5 = a3;
        }
    }

    public static HttpURLConnection a(C2895uc c2895uc, String str) {
        URLConnection openConnection = new URL(str).openConnection();
        Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setConnectTimeout(c2895uc.i);
        httpURLConnection.setReadTimeout(c2895uc.j);
        httpURLConnection.setUseCaches(false);
        HashMap hashMap = c2895uc.c;
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        httpURLConnection.setRequestMethod(c2895uc.b.name());
        if (EnumC2846rc.f2696a != c2895uc.b) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
        }
        return httpURLConnection;
    }

    public static void a(String str, HttpURLConnection httpURLConnection, boolean z) {
        OutputStream bufferedOutputStream;
        OutputStream outputStream = null;
        try {
            if (z) {
                bufferedOutputStream = new GZIPOutputStream(httpURLConnection.getOutputStream(), 4096);
            } else {
                bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            }
            outputStream = bufferedOutputStream;
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
            outputStream.flush();
        } finally {
            T9.a(outputStream);
        }
    }

    public static C2962yc a(C2895uc c2895uc, HttpURLConnection httpURLConnection) {
        EnumC2790o4 enumC2790o4;
        String str;
        JSONObject jSONObject;
        C2962yc c2962yc = new C2962yc();
        int responseCode = httpURLConnection.getResponseCode();
        c2962yc.d = Integer.valueOf(responseCode);
        c2962yc.b = httpURLConnection.getHeaderFields();
        c2962yc.e = httpURLConnection.getContentLength();
        if (!c2895uc.k) {
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
                a(c2962yc, inputStream);
                return c2962yc;
            }
            EnumC2790o4.b.getClass();
            if (400 <= responseCode && 500 > responseCode) {
                enumC2790o4 = EnumC2790o4.i;
            } else if (200 < responseCode && 300 > responseCode) {
                enumC2790o4 = EnumC2790o4.k;
            } else {
                enumC2790o4 = (EnumC2790o4) EnumC2790o4.c.get(responseCode);
                if (enumC2790o4 == null) {
                    enumC2790o4 = EnumC2790o4.e;
                }
            }
            if (enumC2790o4 == EnumC2790o4.i) {
                InputStream errorStream = httpURLConnection.getErrorStream();
                Intrinsics.checkNotNullExpressionValue(errorStream, "getErrorStream(...)");
                a(c2962yc, errorStream);
                try {
                    jSONObject = new JSONObject(J9.a(c2962yc.c));
                } catch (JSONException unused) {
                }
                if (jSONObject.has("errorMessage")) {
                    str = jSONObject.getString("errorMessage");
                    c2962yc.f2765a = new I9(enumC2790o4, str);
                }
                str = null;
                c2962yc.f2765a = new I9(enumC2790o4, str);
            } else {
                c2962yc.f2765a = new I9(enumC2790o4, "HTTP:" + responseCode);
                return c2962yc;
            }
        }
        return c2962yc;
    }

    public static void a(C2962yc c2962yc, InputStream inputStream) {
        boolean z = T9.f2439a;
        byte[] a2 = T9.a(inputStream);
        T9.a((Closeable) inputStream);
        if (a2 != null) {
            if (!(a2.length == 0)) {
                Intrinsics.checkNotNullParameter(c2962yc, "<this>");
                Map map = c2962yc.b;
                List list = map != null ? (List) map.get(HttpHeaders.CONTENT_ENCODING) : null;
                if (Intrinsics.areEqual(list != null ? (String) list.get(0) : null, "gzip") && (a2 = T9.a(a2)) == null) {
                    c2962yc.f2765a = new I9(EnumC2790o4.h, "Failed to uncompress gzip response");
                }
                if (a2 != null) {
                    c2962yc.c = a2;
                }
            }
        }
    }
}
