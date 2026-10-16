package com.applovin.impl;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.applovin.impl.s4;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.y3;
import com.applovin.sdk.AppLovinErrorCodes;
import com.google.common.net.HttpHeaders;
import com.ironsource.C3337ue;
import com.vungle.ads.internal.ui.AdActivity;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class q0 {
    private static final List e = Arrays.asList("5.0/i", "4.0/ad", "1.0/mediate");

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f631a;
    private final com.applovin.impl.sdk.o b;
    private final y3 c;
    private d d;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private long f632a;
        private long b;

        public long a() {
            return this.f632a;
        }

        public long b() {
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j) {
            this.f632a = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(long j) {
            this.b = j;
        }
    }

    private class c implements Consumer {

        /* renamed from: a, reason: collision with root package name */
        private final String f633a;
        private final com.applovin.impl.sdk.network.a b;
        private final String c;
        private final Object d;
        private final boolean e;
        private final b f;
        private final e g;

        /* JADX WARN: Not initialized variable reg: 8, insn: 0x0180: MOVE (r5 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:71:0x017f */
        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(y3.d dVar) {
            MalformedURLException malformedURLException;
            int i;
            int i2;
            long e = dVar.e();
            Object obj = null;
            try {
                try {
                    i = dVar.c();
                    try {
                        if (i > 0) {
                            try {
                                if (i < 200 || i >= 400) {
                                    this.g.a(this.f633a, i, null, null);
                                    return;
                                }
                                try {
                                    b bVar = this.f;
                                    if (bVar != null) {
                                        bVar.a(e);
                                    }
                                    q0.this.a(this.c, this.f633a, i, e);
                                    byte[] d = dVar.d();
                                    if (k7.h(com.applovin.impl.sdk.k.o()) && (!this.e || s4.b(d) != s4.a.V2)) {
                                        q0.this.f631a.u().a(d != null ? new String(dVar.d(), Charset.forName("UTF-8")) : "", this.f633a, this.b.b() != null ? this.b.b().toString() : "");
                                    }
                                    if (d == null) {
                                        this.g.a(this.f633a, this.d, i);
                                        return;
                                    }
                                    String str = new String(dVar.d(), Charset.forName("UTF-8"));
                                    b bVar2 = this.f;
                                    if (bVar2 != null) {
                                        bVar2.b(d.length);
                                        if (this.b.r()) {
                                            q0.this.d = new d(this.b.f(), d.length, e);
                                        }
                                    }
                                    if (this.e) {
                                        String b = s4.b(d, q0.this.f631a.j0(), q0.this.f631a);
                                        if (b == null) {
                                            HashMap hashMap = new HashMap(2);
                                            hashMap.put(AdActivity.REQUEST_KEY_EXTRA, StringUtils.getHostAndPath(this.f633a));
                                            hashMap.put(C3337ue.n, str);
                                            q0.this.f631a.G().trackEvent("rdf", hashMap);
                                        }
                                        str = b;
                                    }
                                    try {
                                        this.g.a(this.f633a, q0.this.a(str, this.d), i);
                                        return;
                                    } catch (Throwable th) {
                                        String str2 = "Unable to parse response from " + StringUtils.getHostAndPath(this.f633a) + " because of " + th.getClass().getName() + " : " + th.getMessage();
                                        com.applovin.impl.sdk.o unused = q0.this.b;
                                        if (com.applovin.impl.sdk.o.a()) {
                                            q0.this.b.a("ConnectionManager", str2, th);
                                        }
                                        q0.this.f631a.E().a("ConnectionManager", "failedToParseResponse", th, CollectionUtils.hashMap("url", StringUtils.getHostAndPath(this.f633a)));
                                        this.g.a(this.f633a, AppLovinErrorCodes.INVALID_RESPONSE, str2, null);
                                        return;
                                    }
                                } catch (MalformedURLException e2) {
                                    e = e2;
                                }
                            } catch (MalformedURLException e3) {
                                malformedURLException = e3;
                                i = i2;
                            }
                        } else {
                            try {
                                q0.this.a(this.c, this.f633a, i, e, (Throwable) null);
                                this.g.a(this.f633a, i, null, null);
                                return;
                            } catch (MalformedURLException e4) {
                                e = e4;
                                i = i;
                            }
                        }
                    } catch (MalformedURLException e5) {
                        e = e5;
                    }
                    malformedURLException = e;
                } catch (MalformedURLException e6) {
                    malformedURLException = e6;
                    i = 0;
                }
                MalformedURLException malformedURLException2 = malformedURLException;
                if (this.d != null) {
                    q0.this.a(this.c, this.f633a, i, e, malformedURLException2);
                    this.g.a(this.f633a, -901, malformedURLException2.getMessage(), null);
                } else {
                    q0.this.a(this.c, this.f633a, i, e);
                    this.g.a(this.f633a, this.d, -901);
                }
            } catch (Throwable th2) {
                int b2 = dVar.b();
                try {
                    byte[] f = dVar.f();
                    String str3 = new String(f);
                    if (f != null) {
                        if (this.e) {
                            str3 = s4.b(f, q0.this.f631a.j0(), q0.this.f631a);
                        }
                        obj = q0.this.a(str3, this.d);
                    }
                } catch (Throwable unused2) {
                }
                q0.this.a(this.c, this.f633a, b2, e, th2);
                this.g.a(this.f633a, b2, th2.getMessage(), obj);
            }
        }

        private c(String str, com.applovin.impl.sdk.network.a aVar, String str2, Object obj, boolean z, b bVar, e eVar) {
            this.f633a = str;
            this.b = aVar;
            this.c = str2;
            this.d = obj;
            this.e = z;
            this.f = bVar;
            this.g = eVar;
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final long f634a = System.currentTimeMillis();
        private final String b;
        private final long c;
        private final long d;

        public d(String str, long j, long j2) {
            this.b = str;
            this.c = j;
            this.d = j2;
        }

        protected boolean a(Object obj) {
            return obj instanceof d;
        }

        public long b() {
            return this.c;
        }

        public long c() {
            return this.f634a;
        }

        public String d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (!dVar.a(this) || c() != dVar.c() || b() != dVar.b() || a() != dVar.a()) {
                return false;
            }
            String d = d();
            String d2 = dVar.d();
            return d != null ? d.equals(d2) : d2 == null;
        }

        public int hashCode() {
            long c = c();
            long b = b();
            int i = ((((int) (c ^ (c >>> 32))) + 59) * 59) + ((int) (b ^ (b >>> 32)));
            long a2 = a();
            String d = d();
            return (((i * 59) + ((int) ((a2 >>> 32) ^ a2))) * 59) + (d == null ? 43 : d.hashCode());
        }

        public String toString() {
            return "ConnectionManager.RequestMeasurement(timestampMillis=" + c() + ", urlHostAndPathString=" + d() + ", responseSizeBytes=" + b() + ", connectionTimeMillis=" + a() + ")";
        }

        public long a() {
            return this.d;
        }
    }

    public interface e {
        void a(String str, int i, String str2, Object obj);

        void a(String str, Object obj, int i);
    }

    public q0(com.applovin.impl.sdk.k kVar) {
        this.f631a = kVar;
        this.b = kVar.O();
        y3 y3Var = new y3(kVar);
        this.c = y3Var;
        y3Var.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0213 A[Catch: all -> 0x0143, TRY_LEAVE, TryCatch #1 {all -> 0x0143, blocks: (B:91:0x0106, B:94:0x0131, B:95:0x012d, B:38:0x016d, B:40:0x0185, B:43:0x01a6, B:46:0x01f9, B:49:0x0208, B:51:0x0213, B:52:0x01aa, B:55:0x01b2, B:61:0x01c9, B:63:0x01cf, B:64:0x01e5, B:69:0x0193, B:72:0x021c, B:58:0x01c3), top: B:90:0x0106, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.applovin.impl.sdk.network.a aVar, b bVar, e eVar) {
        String str;
        Throwable th;
        y3.c.a a2;
        y3 y3Var;
        c cVar;
        byte[] bytes;
        byte[] a3;
        if (aVar != null) {
            String f = aVar.f();
            String h = aVar.h();
            if (f == null) {
                throw new IllegalArgumentException("No endpoint specified");
            }
            if (h == null) {
                throw new IllegalArgumentException("No method specified");
            }
            if (eVar != null) {
                if (!f.toLowerCase().startsWith("http")) {
                    String str2 = "Requested postback submission to non HTTP endpoint " + f + "; skipping...";
                    com.applovin.impl.sdk.o.h("ConnectionManager", str2);
                    eVar.a(f, AppLovinErrorCodes.INVALID_URL, str2, null);
                    return;
                }
                String httpsString = StringUtils.toHttpsString(f);
                HashMap hashMap = new HashMap(2);
                boolean m = aVar.m();
                s4.a a4 = ((Boolean) this.f631a.a(v4.e5)).booleanValue() ? s4.a.a(((Integer) this.f631a.a(v4.b5)).intValue()) : aVar.e();
                long a5 = k7.a(this.f631a);
                if ((aVar.i() != null && !aVar.i().isEmpty()) || aVar.c() > 0) {
                    Map i = aVar.i();
                    Boolean bool = (Boolean) this.f631a.a(v4.g3);
                    if (i != null && aVar.c() > 0) {
                        i.put("current_retry_attempt", String.valueOf(aVar.c()));
                    }
                    if (m) {
                        String a6 = k7.a(i, bool.booleanValue());
                        String b2 = s4.b(a6, a5, a4, this.f631a.j0(), this.f631a);
                        if (StringUtils.isValidString(a6) && TextUtils.isEmpty(b2)) {
                            hashMap.put("query", a6);
                        }
                        httpsString = StringUtils.appendQueryParameter(httpsString, "p", b2);
                    } else {
                        httpsString = StringUtils.appendQueryParameters(httpsString, i, bool.booleanValue());
                    }
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    Boolean endsWith = StringUtils.endsWith(StringUtils.getHostAndPath(httpsString), e);
                    if (com.applovin.impl.sdk.o.a()) {
                        try {
                            this.b.d("ConnectionManager", "Sending " + h + " request to id=#" + httpsString.hashCode() + " \"" + (endsWith.booleanValue() ? httpsString : StringUtils.getHostAndPath(httpsString)) + "\"...");
                        } catch (Throwable th2) {
                            th = th2;
                            str = h;
                            a(str, httpsString, 0, SystemClock.elapsedRealtime() - elapsedRealtime, th);
                            eVar.a(httpsString, 0, th.getMessage(), null);
                            return;
                        }
                    }
                    a2 = new y3.c.a().a(httpsString).b(h).a(aVar.g()).a(aVar.l());
                    if (aVar.b() != null) {
                        if (m) {
                            bytes = s4.a(aVar.b().toString(), a5, a4, this.f631a.j0(), this.f631a);
                            if (bytes == null) {
                                hashMap.put("body", aVar.b().toString());
                            }
                        } else {
                            bytes = aVar.b().toString().getBytes("UTF-8");
                        }
                        byte[] bArr = bytes;
                        if ((!m || a4 != s4.a.V2) && aVar.o() && bArr != null && bArr.length > ((Integer) this.f631a.a(v4.y5)).intValue()) {
                            try {
                                a3 = k7.a(bArr);
                            } catch (Throwable th3) {
                                if (com.applovin.impl.sdk.o.a()) {
                                    this.b.a("ConnectionManager", "Failed to gzip POST body for request " + a(httpsString), th3);
                                }
                                this.f631a.E().a("ConnectionManager", "gzip", th3, CollectionUtils.hashMap("url", StringUtils.getHostAndPath(httpsString)));
                            }
                            a2.a("Content-Type", "application/json; charset=utf-8");
                            if (!aVar.o() && a3 != null) {
                                a2.a(HttpHeaders.CONTENT_ENCODING, "gzip");
                                a2.a(a3);
                            } else if (bArr != null) {
                                a2.a(bArr);
                            }
                        }
                        a3 = null;
                        a2.a("Content-Type", "application/json; charset=utf-8");
                        if (!aVar.o()) {
                        }
                        if (bArr != null) {
                        }
                    }
                    if (!hashMap.isEmpty()) {
                        hashMap.put(AdActivity.REQUEST_KEY_EXTRA, StringUtils.getHostAndPath(httpsString));
                        this.f631a.G().trackEvent("ref", hashMap);
                    }
                    y3Var = this.c;
                    String str3 = httpsString;
                    try {
                        cVar = new c(str3, aVar, h, aVar.d(), m, bVar, eVar);
                        httpsString = str3;
                        str = h;
                    } catch (Throwable th4) {
                        th = th4;
                        httpsString = str3;
                        str = h;
                        th = th;
                        a(str, httpsString, 0, SystemClock.elapsedRealtime() - elapsedRealtime, th);
                        eVar.a(httpsString, 0, th.getMessage(), null);
                        return;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    y3Var.a(a2.a(cVar).a(this.f631a.r0().d()).a());
                    return;
                } catch (Throwable th6) {
                    th = th6;
                    th = th;
                    a(str, httpsString, 0, SystemClock.elapsedRealtime() - elapsedRealtime, th);
                    eVar.a(httpsString, 0, th.getMessage(), null);
                    return;
                }
            }
            throw new IllegalArgumentException("No callback specified");
        }
        throw new IllegalArgumentException("No request specified");
    }

    public d a() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object a(String str, Object obj) {
        if (obj != null) {
            if (str != null && str.length() >= 3) {
                if (obj instanceof JSONObject) {
                    return new JSONObject(str);
                }
                if (obj instanceof m8) {
                    return n8.a(str, this.f631a);
                }
                if (!(obj instanceof String)) {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.b.b("ConnectionManager", "Failed to process response of type '" + obj.getClass().getName() + "'");
                    }
                }
            }
            return obj;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i, long j) {
        if (com.applovin.impl.sdk.o.a()) {
            this.b.d("ConnectionManager", "Successful " + str + " returned " + i + " in " + (j / 1000.0f) + " s over " + r0.g(this.f631a) + " to " + a(str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i, long j, Throwable th) {
        if (com.applovin.impl.sdk.o.a()) {
            this.b.a("ConnectionManager", "Failed " + str + " returned " + i + " in " + (j / 1000.0f) + " s over " + r0.g(this.f631a) + " to " + a(str2), th);
        }
    }

    private String a(String str) {
        return "#" + str.hashCode() + " \"" + StringUtils.getHostAndPath(str) + "\"";
    }
}
