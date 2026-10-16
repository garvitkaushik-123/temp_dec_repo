package com.mbridge.msdk.thrid.okhttp.internal.cache;

import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.internal.http.d;
import com.mbridge.msdk.thrid.okhttp.internal.http.e;
import com.mbridge.msdk.thrid.okhttp.p;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.y;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: CacheStrategy.java */
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final w f4823a;

    @Nullable
    public final y b;

    b(w wVar, y yVar) {
        this.f4823a = wVar;
        this.b = yVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.h().b() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(y yVar, w wVar) {
        int k = yVar.k();
        if (k != 200 && k != 410 && k != 414 && k != 501 && k != 203 && k != 204) {
            if (k != 307) {
                if (k != 308 && k != 404 && k != 405) {
                    switch (k) {
                        case 300:
                        case MRAID_ERROR_VALUE:
                            break;
                        case INVALID_IFA_STATUS_VALUE:
                            break;
                        default:
                            return false;
                    }
                }
            }
            if (yVar.b(HttpHeaders.EXPIRES) == null) {
                if (yVar.h().d() == -1) {
                    if (!yVar.h().c()) {
                    }
                }
            }
        }
        return (yVar.h().i() || wVar.b().i()) ? false : true;
    }

    /* compiled from: CacheStrategy.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final long f4824a;
        final w b;
        final y c;
        private Date d;
        private String e;
        private Date f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l;

        public a(long j, w wVar, y yVar) {
            this.l = -1;
            this.f4824a = j;
            this.b = wVar;
            this.c = yVar;
            if (yVar != null) {
                this.i = yVar.s();
                this.j = yVar.q();
                p m = yVar.m();
                int b = m.b();
                for (int i = 0; i < b; i++) {
                    String a2 = m.a(i);
                    String b2 = m.b(i);
                    if (HttpHeaders.DATE.equalsIgnoreCase(a2)) {
                        this.d = d.a(b2);
                        this.e = b2;
                    } else if (HttpHeaders.EXPIRES.equalsIgnoreCase(a2)) {
                        this.h = d.a(b2);
                    } else if (HttpHeaders.LAST_MODIFIED.equalsIgnoreCase(a2)) {
                        this.f = d.a(b2);
                        this.g = b2;
                    } else if ("ETag".equalsIgnoreCase(a2)) {
                        this.k = b2;
                    } else if (HttpHeaders.AGE.equalsIgnoreCase(a2)) {
                        this.l = e.a(b2, -1);
                    }
                }
            }
        }

        private long a() {
            Date date = this.d;
            long max = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
            int i = this.l;
            if (i != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.j;
            return max + (j - this.i) + (this.f4824a - j);
        }

        private long b() {
            if (this.c.h().d() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.d());
            }
            if (this.h != null) {
                Date date = this.d;
                long time = this.h.getTime() - (date != null ? date.getTime() : this.j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f != null && this.c.r().g().k() == null) {
                Date date2 = this.d;
                long time2 = (date2 != null ? date2.getTime() : this.i) - this.f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0L;
        }

        private b d() {
            String str;
            if (this.c == null) {
                return new b(this.b, null);
            }
            if (this.b.d() && this.c.l() == null) {
                return new b(this.b, null);
            }
            if (!b.a(this.c, this.b)) {
                return new b(this.b, null);
            }
            com.mbridge.msdk.thrid.okhttp.c b = this.b.b();
            if (b.h() || a(this.b)) {
                return new b(this.b, null);
            }
            com.mbridge.msdk.thrid.okhttp.c h = this.c.h();
            long a2 = a();
            long b2 = b();
            if (b.d() != -1) {
                b2 = Math.min(b2, TimeUnit.SECONDS.toMillis(b.d()));
            }
            long j = 0;
            long millis = b.f() != -1 ? TimeUnit.SECONDS.toMillis(b.f()) : 0L;
            if (!h.g() && b.e() != -1) {
                j = TimeUnit.SECONDS.toMillis(b.e());
            }
            if (!h.h()) {
                long j2 = millis + a2;
                if (j2 < j + b2) {
                    y.a o = this.c.o();
                    if (j2 >= b2) {
                        o.a(HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (a2 > 86400000 && e()) {
                        o.a(HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new b(null, o.a());
                }
            }
            String str2 = this.k;
            if (str2 != null) {
                str = HttpHeaders.IF_NONE_MATCH;
            } else {
                if (this.f != null) {
                    str2 = this.g;
                } else {
                    if (this.d == null) {
                        return new b(this.b, null);
                    }
                    str2 = this.e;
                }
                str = HttpHeaders.IF_MODIFIED_SINCE;
            }
            p.a a3 = this.b.c().a();
            com.mbridge.msdk.thrid.okhttp.internal.a.f4819a.a(a3, str, str2);
            return new b(this.b.f().a(a3.a()).a(), this.c);
        }

        private boolean e() {
            return this.c.h().d() == -1 && this.h == null;
        }

        public b c() {
            b d = d();
            return (d.f4823a == null || !this.b.b().j()) ? d : new b(null, null);
        }

        private static boolean a(w wVar) {
            return (wVar.a(HttpHeaders.IF_MODIFIED_SINCE) == null && wVar.a(HttpHeaders.IF_NONE_MATCH) == null) ? false : true;
        }
    }
}
