package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.foundation.same.net.MBridgeHostnameVerifier;
import com.mbridge.msdk.tracker.network.t;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: HurlStack.java */
/* loaded from: classes6.dex */
public class h extends com.mbridge.msdk.tracker.network.toolbox.a {

    /* renamed from: a, reason: collision with root package name */
    private final SSLSocketFactory f4953a;

    /* compiled from: HurlStack.java */
    static class a extends FilterInputStream {

        /* renamed from: a, reason: collision with root package name */
        private final HttpURLConnection f4954a;

        a(HttpURLConnection httpURLConnection) {
            super(h.b(httpURLConnection));
            this.f4954a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            this.f4954a.disconnect();
        }
    }

    /* compiled from: HurlStack.java */
    public interface b {
    }

    public h() {
        this(null);
    }

    private static boolean a(int i, int i2) {
        if (i != 4) {
            return ((100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    public h(b bVar) {
        this(bVar, null);
    }

    @Override // com.mbridge.msdk.tracker.network.toolbox.a
    public g a(t<?> tVar, Map<String, String> map) throws IOException {
        String a2 = tVar.g() == 0 ? d.a(tVar.t(), tVar) : tVar.t();
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(tVar.f());
        HttpsURLConnection a3 = a(new URL(a2), tVar);
        try {
            for (String str : hashMap.keySet()) {
                a3.setRequestProperty(str, (String) hashMap.get(str));
            }
            b(a3, tVar);
            int responseCode = a3.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (a(tVar.g(), responseCode)) {
                return new g(responseCode, a(a3.getHeaderFields()), a3.getContentLength(), a(tVar, a3));
            }
            g gVar = new g(responseCode, a(a3.getHeaderFields()));
            a3.disconnect();
            return gVar;
        } catch (Throwable th) {
            if (0 == 0) {
                a3.disconnect();
            }
            throw th;
        }
    }

    public h(b bVar, SSLSocketFactory sSLSocketFactory) {
        this.f4953a = sSLSocketFactory;
    }

    void b(HttpURLConnection httpURLConnection, t<?> tVar) throws IOException {
        switch (tVar.g()) {
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                a(httpURLConnection, tVar);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                a(httpURLConnection, tVar);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                a(httpURLConnection, tVar);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    static List<com.mbridge.msdk.tracker.network.g> a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.mbridge.msdk.tracker.network.g(entry.getKey(), it.next()));
                }
            }
        }
        return arrayList;
    }

    protected InputStream a(t<?> tVar, HttpURLConnection httpURLConnection) {
        return new a(httpURLConnection);
    }

    protected HttpsURLConnection a(URL url) throws IOException {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        httpsURLConnection.setHostnameVerifier(new MBridgeHostnameVerifier(url));
        httpsURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpsURLConnection;
    }

    private HttpsURLConnection a(URL url, t<?> tVar) throws IOException {
        SSLSocketFactory sSLSocketFactory;
        HttpsURLConnection a2 = a(url);
        int q = tVar.q();
        a2.setConnectTimeout(q);
        a2.setReadTimeout(q);
        a2.setUseCaches(false);
        a2.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.f4953a) != null) {
            a2.setSSLSocketFactory(sSLSocketFactory);
        }
        return a2;
    }

    private void a(HttpURLConnection httpURLConnection, t<?> tVar) throws IOException {
        byte[] b2 = tVar.b();
        if (b2 != null) {
            a(httpURLConnection, tVar, b2);
        }
    }

    private void a(HttpURLConnection httpURLConnection, t<?> tVar, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", tVar.c());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(a(tVar, httpURLConnection, bArr.length));
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    protected OutputStream a(t<?> tVar, HttpURLConnection httpURLConnection, int i) throws IOException {
        return httpURLConnection.getOutputStream();
    }
}
