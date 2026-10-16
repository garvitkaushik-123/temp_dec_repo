package com.pgl.ssdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public abstract class m0 {

    /* renamed from: a, reason: collision with root package name */
    public static String f6401a;
    private Context c;
    private int d;
    private int e;
    private byte[] f;
    private HttpURLConnection b = null;
    private int g = -1;
    private byte[] h = null;
    private int i = 10000;
    private int j = 0;
    private int k = 2;
    private boolean l = true;
    private Runnable m = new a();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m0.this.c() || m0.this.j >= m0.this.k) {
                return;
            }
            m0.c(m0.this);
            r0.a(this);
        }
    }

    public m0(Context context) {
        this.c = context;
    }

    static /* synthetic */ int c(m0 m0Var) {
        int i = m0Var.j;
        m0Var.j = i + 1;
        return i;
    }

    abstract String a();

    abstract void a(int i, byte[] bArr);

    public static synchronized void a(String str) {
        synchronized (m0.class) {
            if (!TextUtils.isEmpty(str) && !str.equals(f6401a)) {
                f6401a = str;
            }
        }
    }

    private void b() {
        Object obj;
        if (this.b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(f6401a)) {
                jSONObject.put("ipv6", f6401a);
            }
            if (!TextUtils.isEmpty(com.pgl.ssdk.ces.b.f())) {
                jSONObject.put("gaid", com.pgl.ssdk.ces.b.f());
            }
            jSONObject.put("region", n0.a());
            Pair<Integer, String> a2 = q0.a(jSONObject.toString());
            if (a2 == null || (obj = a2.first) == null || a2.second == null) {
                return;
            }
            this.b.addRequestProperty("cypher", String.valueOf(obj));
            this.b.addRequestProperty("transfer-param", (String) a2.second);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b5, code lost:
    
        if (r0 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bf, code lost:
    
        a(r5.g, r5.h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c6, code lost:
    
        r0 = r5.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c8, code lost:
    
        if (r0 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ca, code lost:
    
        r0.disconnect();
        r5.b = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00cf, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bc, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b9, code lost:
    
        if (r0 != null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c() {
        InputStream inputStream;
        try {
            String a2 = n0.a(this.c);
            if (TextUtils.isEmpty(a2)) {
                n0.b(this.c);
                HttpURLConnection httpURLConnection = this.b;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    this.b = null;
                }
                return false;
            }
            String str = a2 + a();
            if (!str.startsWith("https://") && !str.startsWith("http://")) {
                str = "https://".concat(String.valueOf(str));
            }
            URL url = new URL(str);
            if (this.l) {
                this.b = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
            } else {
                this.b = (HttpURLConnection) url.openConnection();
            }
            this.b.setConnectTimeout(this.i);
            this.b.setReadTimeout(this.i);
            a(this.d);
            b(this.e);
            byte[] bArr = this.f;
            if (bArr != null && bArr.length > 0) {
                this.b.setDoOutput(true);
                OutputStream outputStream = this.b.getOutputStream();
                outputStream.write(this.f);
                outputStream.flush();
                outputStream.close();
            }
            this.b.connect();
            try {
                this.g = this.b.getResponseCode();
                inputStream = this.b.getInputStream();
                try {
                    this.h = a(inputStream);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                inputStream = null;
            }
        } catch (Throwable unused3) {
            HttpURLConnection httpURLConnection2 = this.b;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
                this.b = null;
            }
            n0.b(this.c);
            return false;
        }
    }

    private void a(int i) throws ProtocolException {
        this.b.setRequestMethod(i != 1 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? "GET" : "TRACE" : "HEAD" : "DELETE" : "PUT" : "POST");
    }

    private byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public void a(int i, int i2, byte[] bArr) {
        b(i, i2, bArr);
        r0.a(this.m);
    }

    private void b(int i) {
        String str = i != 1 ? i != 2 ? "" : "application/octet-stream" : "application/json; charset=utf-8";
        if (!str.isEmpty()) {
            this.b.addRequestProperty("Content-Type", str);
        }
        String b = n0.b();
        if (b != null) {
            this.b.addRequestProperty("x-pangle-target-idc", b);
        }
        b();
        try {
            String language = Locale.getDefault().getLanguage();
            if (language.equalsIgnoreCase("zh")) {
                this.b.addRequestProperty(HttpHeaders.ACCEPT_LANGUAGE, Locale.getDefault().toString() + "," + language + ";q=0.9");
            } else {
                this.b.addRequestProperty(HttpHeaders.ACCEPT_LANGUAGE, Locale.getDefault().toString() + "," + language + ";q=0.9,en-US;q=0.6,en;q=0.4");
            }
        } catch (Throwable unused) {
        }
    }

    private void b(int i, int i2, byte[] bArr) {
        this.d = i;
        this.e = i2;
        this.f = bArr;
    }
}
