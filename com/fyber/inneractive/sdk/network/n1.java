package com.fyber.inneractive.sdk.network;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.FilterInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: classes4.dex */
public final class n1 extends i implements h {

    /* renamed from: a, reason: collision with root package name */
    public final OkHttpClient f1332a = new OkHttpClient().newBuilder().build();

    public static HashMap b(Response response) {
        HashMap hashMap = new HashMap();
        if (response != null) {
            Headers headers = response.headers();
            for (int i = 0; i < headers.size(); i++) {
                String name = headers.name(i);
                hashMap.put(name, Collections.singletonList(headers.get(name)));
            }
        }
        return hashMap;
    }

    @Override // com.fyber.inneractive.sdk.network.h
    public final l a(s0 s0Var, String str, String str2) {
        IAlog.a("%s okhttp network stack is in use", "OkHttpExecutorImpl");
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(s0Var.p());
            Pair a2 = a(s0Var.p(), s0Var, arrayList, str, str2);
            Object obj = a2.second;
            String message = obj != null ? ((Response) obj).message() : "";
            FilterInputStream a3 = a((Response) a2.second);
            Object obj2 = a2.second;
            int code = obj2 == null ? -1 : ((Response) obj2).code();
            HashMap b = b((Response) a2.second);
            Response response = (Response) a2.second;
            m1 m1Var = new m1(i.a(a3, code, message, b, response != null ? response.headers().get(HttpHeaders.LAST_MODIFIED) : null), (Response) a2.second);
            Iterator it = ((List) a2.first).iterator();
            while (it.hasNext()) {
                m1Var.f.add((String) it.next());
            }
            return m1Var;
        } catch (b e) {
            IAlog.b("%s cannot connect exception: %s", "OkHttpExecutorImpl", e.getMessage());
            throw e;
        } catch (Exception e2) {
            IAlog.b("%s exception: %s", "OkHttpExecutorImpl", e2.getMessage());
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00d9, code lost:
    
        if (r9.code() != 308) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00be, code lost:
    
        if (r9.code() >= 304) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair a(String str, s0 s0Var, ArrayList arrayList, String str2, String str3) {
        Throwable th;
        Exception exc;
        s0 s0Var2;
        j1 n = s0Var.n();
        Request.Builder builder = new Request.Builder();
        ?? r4 = "gzip";
        a(builder, HttpHeaders.ACCEPT_ENCODING, "gzip");
        a(builder, "User-Agent", str2);
        a(builder, HttpHeaders.IF_MODIFIED_SINCE, str3);
        Map j = s0Var.j();
        if (j != null) {
            r4 = j.keySet().iterator();
            while (r4.hasNext()) {
                String str4 = (String) r4.next();
                a(builder, str4, (String) j.get(str4));
            }
        }
        builder.url(str);
        if (s0Var.k() == l0.POST || s0Var.k() == l0.PUT) {
            byte[] d = s0Var.d();
            if (d != null) {
                builder.post(RequestBody.create(d, MediaType.parse(s0Var.l())));
            } else {
                throw new Exception("Could not create ok http request. post payload is null");
            }
        }
        Request build = builder.build();
        boolean z = !(s0Var instanceof f1);
        OkHttpClient.Builder followSslRedirects = this.f1332a.newBuilder().followRedirects(z).followSslRedirects(z);
        long j2 = n.f1325a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient build2 = followSslRedirects.connectTimeout(j2, timeUnit).readTimeout(n.b, timeUnit).build();
        s0Var.c(System.currentTimeMillis());
        IAlog.a("OkHttpExecutorImpl: start connection timestamp: %s", s0Var.g);
        try {
            try {
                Response execute = build2.newCall(build).execute();
                try {
                    if (s0Var instanceof f1) {
                        if (execute.code() > 300) {
                            try {
                            } catch (Exception e) {
                                exc = e;
                                throw new b(exc);
                            } catch (Throwable th2) {
                                th = th2;
                                s0Var2 = s0Var;
                                s0Var2.a(System.currentTimeMillis());
                                IAlog.a("OkHttpExecutorImpl: end connection timestamp: %s", s0Var2.g);
                                throw th;
                            }
                        }
                        if (execute.code() != 307) {
                        }
                        String header = execute.header("Location", "");
                        if (header != null) {
                            if (!header.startsWith("http") && !header.contains("://") && arrayList.size() > 0) {
                                Uri parse = Uri.parse((String) arrayList.get(arrayList.size() - 1));
                                header = String.format(header.startsWith(RemoteSettings.FORWARD_SLASH_STRING) ? "%s://%s%s" : "%s://%s/%s", parse.getScheme(), parse.getHost(), header);
                            }
                            String str5 = header;
                            arrayList.add(str5);
                            if (arrayList.size() <= 5) {
                                Pair a2 = a(str5, s0Var, arrayList, str2, str3);
                                s0Var.a(System.currentTimeMillis());
                                IAlog.a("OkHttpExecutorImpl: end connection timestamp: %s", s0Var.g);
                                return a2;
                            }
                            throw new b("Url chain too big for us");
                        }
                    }
                    Pair pair = new Pair(arrayList, execute);
                    s0Var.a(System.currentTimeMillis());
                    IAlog.a("OkHttpExecutorImpl: end connection timestamp: %s", s0Var.g);
                    return pair;
                } catch (Exception e2) {
                    e = e2;
                    exc = e;
                    throw new b(exc);
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                s0Var2 = r4;
                s0Var2.a(System.currentTimeMillis());
                IAlog.a("OkHttpExecutorImpl: end connection timestamp: %s", s0Var2.g);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
        } catch (Throwable th4) {
            th = th4;
            r4 = s0Var;
            th = th;
            s0Var2 = r4;
            s0Var2.a(System.currentTimeMillis());
            IAlog.a("OkHttpExecutorImpl: end connection timestamp: %s", s0Var2.g);
            throw th;
        }
    }

    public static FilterInputStream a(Response response) {
        if (response == null) {
            return null;
        }
        try {
            if (response.body() == null) {
                return null;
            }
            return i.a(response.body().byteStream(), TextUtils.equals("gzip", response.headers().get("content-encoding")));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Request.Builder builder, String str, String str2) {
        IAlog.d("%s %s : %s", "REQUEST_HEADER", str, str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.addHeader(str, str2);
    }
}
