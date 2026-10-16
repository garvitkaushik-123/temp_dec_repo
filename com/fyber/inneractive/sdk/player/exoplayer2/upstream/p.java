package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.net.HttpHeaders;
import com.ironsource.C3040d4;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class p implements h {
    public static final Pattern o = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    public static final AtomicReference p = new AtomicReference();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1575a;
    public final int b;
    public final int c;
    public final String d;
    public final w e;
    public final w f;
    public final m g;
    public HttpURLConnection h;
    public InputStream i;
    public boolean j;
    public long k;
    public long l;
    public long m;
    public long n;

    public p(String str, m mVar, int i, int i2, boolean z, w wVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.d = str;
        this.g = mVar;
        this.f = new w();
        this.b = i;
        this.c = i2;
        this.f1575a = z;
        this.e = wVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final Uri a() {
        HttpURLConnection httpURLConnection = this.h;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final HttpURLConnection b(k kVar) {
        URL url = new URL(kVar.f1570a.toString());
        long j = kVar.c;
        long j2 = kVar.d;
        int i = 0;
        boolean z = (kVar.f & 1) == 1;
        if (!this.f1575a) {
            return a(url, null, j, j2, z, true);
        }
        while (true) {
            int i2 = i + 1;
            if (i > 20) {
                throw new NoRouteToHostException(com.fyber.inneractive.sdk.player.exoplayer2.m.a("Too many redirects: ", i2));
            }
            boolean z2 = z;
            long j3 = j2;
            long j4 = j;
            HttpURLConnection a2 = a(url, null, j4, j3, z2, false);
            j = j4;
            j2 = j3;
            z = z2;
            int responseCode = a2.getResponseCode();
            if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308) {
                return a2;
            }
            String headerField = a2.getHeaderField("Location");
            a2.disconnect();
            if (headerField == null) {
                throw new ProtocolException("Null location redirect");
            }
            URL url2 = new URL(url, headerField);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new ProtocolException("Unsupported protocol redirect: " + protocol);
            }
            i = i2;
            url = url2;
        }
    }

    public final void c() {
        if (this.m == this.k) {
            return;
        }
        byte[] bArr = (byte[]) p.getAndSet(null);
        if (bArr == null) {
            bArr = new byte[4096];
        }
        while (true) {
            long j = this.m;
            long j2 = this.k;
            if (j == j2) {
                p.set(bArr);
                return;
            }
            int read = this.i.read(bArr, 0, (int) Math.min(j2 - j, bArr.length));
            if (Thread.interrupted()) {
                throw new InterruptedIOException();
            }
            if (read == -1) {
                throw new EOFException();
            }
            long j3 = read;
            this.m += j3;
            m mVar = this.g;
            if (mVar != null) {
                synchronized (mVar) {
                    mVar.d += j3;
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final void close() {
        try {
            if (this.i != null) {
                HttpURLConnection httpURLConnection = this.h;
                long j = this.l;
                if (j != -1) {
                    j -= this.n;
                }
                a(httpURLConnection, j);
                try {
                    this.i.close();
                } catch (IOException e) {
                    throw new u(e);
                }
            }
        } finally {
            this.i = null;
            b();
            if (this.j) {
                this.j = false;
                m mVar = this.g;
                if (mVar != null) {
                    mVar.a();
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final int read(byte[] bArr, int i, int i2) {
        try {
            c();
            return a(bArr, i, i2);
        } catch (IOException e) {
            throw new u(e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        if (r2 != 0) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ef  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long a(k kVar) {
        long j;
        long parseLong;
        String headerField;
        this.n = 0L;
        this.m = 0L;
        try {
            HttpURLConnection b = b(kVar);
            this.h = b;
            try {
                int responseCode = b.getResponseCode();
                if (responseCode < 200 || responseCode > 299) {
                    this.h.getHeaderFields();
                    b();
                    v vVar = new v(responseCode);
                    if (responseCode != 416) {
                        throw vVar;
                    }
                    vVar.initCause(new i());
                    throw vVar;
                }
                this.h.getContentType();
                if (responseCode == 200) {
                    j = kVar.c;
                }
                j = 0;
                this.k = j;
                if ((kVar.f & 1) == 1) {
                    this.l = kVar.d;
                } else {
                    long j2 = kVar.d;
                    if (j2 != -1) {
                        this.l = j2;
                    } else {
                        HttpURLConnection httpURLConnection = this.h;
                        String headerField2 = httpURLConnection.getHeaderField(HttpHeaders.CONTENT_LENGTH);
                        if (!TextUtils.isEmpty(headerField2)) {
                            try {
                                parseLong = Long.parseLong(headerField2);
                            } catch (NumberFormatException unused) {
                                Log.e("DefaultHttpDataSource", "Unexpected Content-Length [" + headerField2 + C3040d4.i.e);
                            }
                            headerField = httpURLConnection.getHeaderField(HttpHeaders.CONTENT_RANGE);
                            if (!TextUtils.isEmpty(headerField)) {
                                Matcher matcher = o.matcher(headerField);
                                if (matcher.find()) {
                                    try {
                                        long parseLong2 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                                        if (parseLong < 0) {
                                            parseLong = parseLong2;
                                        } else if (parseLong != parseLong2) {
                                            Log.w("DefaultHttpDataSource", "Inconsistent headers [" + headerField2 + "] [" + headerField + C3040d4.i.e);
                                            parseLong = Math.max(parseLong, parseLong2);
                                        }
                                    } catch (NumberFormatException unused2) {
                                        Log.e("DefaultHttpDataSource", "Unexpected Content-Range [" + headerField + C3040d4.i.e);
                                    }
                                }
                            }
                            this.l = parseLong != -1 ? parseLong - this.k : -1L;
                        }
                        parseLong = -1;
                        headerField = httpURLConnection.getHeaderField(HttpHeaders.CONTENT_RANGE);
                        if (!TextUtils.isEmpty(headerField)) {
                        }
                        this.l = parseLong != -1 ? parseLong - this.k : -1L;
                    }
                }
                try {
                    this.i = this.h.getInputStream();
                    this.j = true;
                    m mVar = this.g;
                    if (mVar != null) {
                        synchronized (mVar) {
                            if (mVar.b == 0) {
                                mVar.c = SystemClock.elapsedRealtime();
                            }
                            mVar.b++;
                        }
                    }
                    return this.l;
                } catch (IOException e) {
                    b();
                    throw new u(e);
                }
            } catch (IOException e2) {
                b();
                throw new u("Unable to connect to " + kVar.f1570a.toString(), e2);
            }
        } catch (IOException e3) {
            throw new u("Unable to connect to " + kVar.f1570a.toString(), e3);
        }
    }

    public final HttpURLConnection a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) {
        Map map;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.b);
        httpURLConnection.setReadTimeout(this.c);
        w wVar = this.e;
        if (wVar != null) {
            synchronized (wVar) {
                if (wVar.b == null) {
                    wVar.b = Collections.unmodifiableMap(new HashMap(wVar.f1579a));
                }
                map = wVar.b;
            }
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        for (Map.Entry entry2 : this.f.a().entrySet()) {
            httpURLConnection.setRequestProperty((String) entry2.getKey(), (String) entry2.getValue());
        }
        if (j != 0 || j2 != -1) {
            String str = "bytes=" + j + "-";
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.d);
        if (!z) {
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length == 0) {
                httpURLConnection.connect();
                return httpURLConnection;
            }
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
            return httpURLConnection;
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    public final int a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.l;
        if (j != -1) {
            long j2 = j - this.n;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        int read = this.i.read(bArr, i, i2);
        if (read == -1) {
            if (this.l == -1) {
                return -1;
            }
            throw new EOFException();
        }
        long j3 = read;
        this.n += j3;
        m mVar = this.g;
        if (mVar == null) {
            return read;
        }
        synchronized (mVar) {
            mVar.d += j3;
        }
        return read;
    }

    public static void a(HttpURLConnection httpURLConnection, long j) {
        int i = com.fyber.inneractive.sdk.player.exoplayer2.util.z.f1599a;
        if (i == 19 || i == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", null);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, null);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void b() {
        HttpURLConnection httpURLConnection = this.h;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.h = null;
        }
    }
}
