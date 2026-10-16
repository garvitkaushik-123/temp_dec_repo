package com.fyber.inneractive.sdk.network;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class k extends i implements h {
    @Override // com.fyber.inneractive.sdk.network.h
    public final l a(s0 s0Var, String str, String str2) {
        l a2;
        IAlog.a("%s hurl network stack is in use", "HttpExecutorImpl");
        URL url = new URL(s0Var.p());
        ArrayList arrayList = new ArrayList();
        arrayList.add(s0Var.p());
        Pair a3 = a(s0Var, arrayList, url, str, str2);
        HttpURLConnection httpURLConnection = (HttpURLConnection) a3.second;
        List list = (List) a3.first;
        if (httpURLConnection == null) {
            try {
                if (list.size() <= 0) {
                    throw new o1();
                }
            } catch (SocketTimeoutException e) {
                throw new r1(e);
            } catch (IOException e2) {
                IAlog.a("failed reading network response", e2, new Object[0]);
                throw new o1(e2);
            }
        }
        FilterInputStream filterInputStream = null;
        if (httpURLConnection == null) {
            a2 = i.a(null, 200, "", null, null);
        } else {
            try {
                filterInputStream = i.a(httpURLConnection.getInputStream(), TextUtils.equals("gzip", httpURLConnection.getContentEncoding()));
            } catch (Exception unused) {
            }
            a2 = i.a(filterInputStream, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), httpURLConnection.getHeaderFields(), httpURLConnection.getHeaderField(HttpHeaders.LAST_MODIFIED));
        }
        j jVar = new j(httpURLConnection, a2.f1328a, (FilterInputStream) a2.c, a2.d, a2.e);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jVar.f.add((String) it.next());
        }
        return jVar;
    }

    public static Pair a(s0 s0Var, ArrayList arrayList, URL url, String str, String str2) {
        String headerField;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            s0Var.getClass();
            if (s0Var instanceof f1) {
                httpURLConnection.setInstanceFollowRedirects(false);
            }
            j1 n = s0Var.n();
            httpURLConnection.setConnectTimeout(n.f1325a);
            httpURLConnection.setReadTimeout(n.b);
            a(httpURLConnection, "User-Agent", str);
            a(httpURLConnection, HttpHeaders.IF_MODIFIED_SINCE, str2);
            a(httpURLConnection, HttpHeaders.ACCEPT_ENCODING, "gzip");
            com.fyber.inneractive.sdk.config.s sVar = IAConfigManager.O.u;
            if (sVar != null && sVar.b.a("add_accept", 1, 0) == 1) {
                a(httpURLConnection, HttpHeaders.ACCEPT, "*/*");
            }
            Map j = s0Var.j();
            if (j != null) {
                for (String str3 : j.keySet()) {
                    a(httpURLConnection, str3, (String) j.get(str3));
                }
            }
            s0Var.c(System.currentTimeMillis());
            if (s0Var.k() != l0.POST && s0Var.k() != l0.PUT) {
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                s0Var.a(System.currentTimeMillis());
                IAlog.a("%s (%s) response code - %d", s0Var.toString(), url, Integer.valueOf(responseCode));
                if (!(s0Var instanceof f1) && (((responseCode > 300 && responseCode < 304) || responseCode == 307 || responseCode == 308) && (headerField = httpURLConnection.getHeaderField("Location")) != null)) {
                    if (!headerField.startsWith("http") && !headerField.contains("://") && arrayList.size() > 0) {
                        Uri parse = Uri.parse((String) arrayList.get(arrayList.size() - 1));
                        headerField = String.format(headerField.startsWith(RemoteSettings.FORWARD_SLASH_STRING) ? "%s://%s%s" : "%s://%s/%s", parse.getScheme(), parse.getHost(), headerField);
                    }
                    arrayList.add(headerField);
                    if (arrayList.size() <= 20) {
                        if (headerField.startsWith("http")) {
                            return a(s0Var, arrayList, new URL(headerField), str, str2);
                        }
                        return Pair.create(arrayList, null);
                    }
                    throw new b("Url chain too big for us");
                }
                return new Pair(arrayList, httpURLConnection);
            }
            a(httpURLConnection, s0Var);
            int responseCode2 = httpURLConnection.getResponseCode();
            s0Var.a(System.currentTimeMillis());
            IAlog.a("%s (%s) response code - %d", s0Var.toString(), url, Integer.valueOf(responseCode2));
            if (!(s0Var instanceof f1)) {
            }
            return new Pair(arrayList, httpURLConnection);
        } catch (Exception e) {
            s0Var.a(System.currentTimeMillis());
            IAlog.a("failed executing network request", e, new Object[0]);
            throw new b(e);
        }
    }

    public static void a(HttpURLConnection httpURLConnection, s0 s0Var) {
        httpURLConnection.setRequestMethod(s0Var.k().key);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        byte[] d = s0Var.d();
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, "" + (d != null ? d.length : 0));
        httpURLConnection.setRequestProperty("Content-Type", s0Var.l());
        httpURLConnection.connect();
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(d);
        try {
            outputStream.close();
        } catch (Throwable unused) {
        }
    }

    public static void a(HttpURLConnection httpURLConnection, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        IAlog.d("%s %s : %s", "REQUEST_HEADER", str, str2);
        httpURLConnection.addRequestProperty(str, str2);
    }
}
