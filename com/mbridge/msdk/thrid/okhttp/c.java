package com.mbridge.msdk.thrid.okhttp;

import com.google.common.net.HttpHeaders;
import io.ktor.client.utils.CacheControl;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: CacheControl.java */
/* loaded from: classes6.dex */
public final class c {
    public static final c n = new a().b().a();
    public static final c o = new a().c().a(Integer.MAX_VALUE, TimeUnit.SECONDS).a();

    /* renamed from: a, reason: collision with root package name */
    private final boolean f4809a;
    private final boolean b;
    private final int c;
    private final int d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final int h;
    private final int i;
    private final boolean j;
    private final boolean k;
    private final boolean l;

    @Nullable
    String m;

    private c(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.f4809a = z;
        this.b = z2;
        this.c = i;
        this.d = i2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
        this.h = i3;
        this.i = i4;
        this.j = z6;
        this.k = z7;
        this.l = z8;
        this.m = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c a(p pVar) {
        int i;
        int i2;
        String str;
        p pVar2 = pVar;
        int b = pVar2.b();
        int i3 = 0;
        boolean z = true;
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i4 = -1;
        int i5 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i6 = -1;
        int i7 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (i3 < b) {
            String a2 = pVar2.a(i3);
            String b2 = pVar2.b(i3);
            if (a2.equalsIgnoreCase(HttpHeaders.CACHE_CONTROL)) {
                if (str2 == null) {
                    str2 = b2;
                    for (i = 0; i < b2.length(); i = i2) {
                        int a3 = com.mbridge.msdk.thrid.okhttp.internal.http.e.a(b2, i, "=,;");
                        String trim = b2.substring(i, a3).trim();
                        if (a3 == b2.length() || b2.charAt(a3) == ',' || b2.charAt(a3) == ';') {
                            i2 = a3 + 1;
                            str = null;
                        } else {
                            int b3 = com.mbridge.msdk.thrid.okhttp.internal.http.e.b(b2, a3 + 1);
                            if (b3 >= b2.length() || b2.charAt(b3) != '\"') {
                                i2 = com.mbridge.msdk.thrid.okhttp.internal.http.e.a(b2, b3, ",;");
                                str = b2.substring(b3, i2).trim();
                            } else {
                                int i8 = b3 + 1;
                                int a4 = com.mbridge.msdk.thrid.okhttp.internal.http.e.a(b2, i8, "\"");
                                str = b2.substring(i8, a4);
                                i2 = a4 + 1;
                            }
                        }
                        if (CacheControl.NO_CACHE.equalsIgnoreCase(trim)) {
                            z2 = true;
                        } else if (CacheControl.NO_STORE.equalsIgnoreCase(trim)) {
                            z3 = true;
                        } else {
                            if (CacheControl.MAX_AGE.equalsIgnoreCase(trim)) {
                                i4 = com.mbridge.msdk.thrid.okhttp.internal.http.e.a(str, -1);
                            } else if (CacheControl.S_MAX_AGE.equalsIgnoreCase(trim)) {
                                i5 = com.mbridge.msdk.thrid.okhttp.internal.http.e.a(str, -1);
                            } else if (CacheControl.PRIVATE.equalsIgnoreCase(trim)) {
                                z4 = true;
                            } else if (CacheControl.PUBLIC.equalsIgnoreCase(trim)) {
                                z5 = true;
                            } else if (CacheControl.MUST_REVALIDATE.equalsIgnoreCase(trim)) {
                                z6 = true;
                            } else if (CacheControl.MAX_STALE.equalsIgnoreCase(trim)) {
                                i6 = com.mbridge.msdk.thrid.okhttp.internal.http.e.a(str, Integer.MAX_VALUE);
                            } else if (CacheControl.MIN_FRESH.equalsIgnoreCase(trim)) {
                                i7 = com.mbridge.msdk.thrid.okhttp.internal.http.e.a(str, -1);
                            } else if (CacheControl.ONLY_IF_CACHED.equalsIgnoreCase(trim)) {
                                z7 = true;
                            } else if (CacheControl.NO_TRANSFORM.equalsIgnoreCase(trim)) {
                                z8 = true;
                            } else if ("immutable".equalsIgnoreCase(trim)) {
                                z9 = true;
                            }
                        }
                    }
                    i3++;
                    pVar2 = pVar;
                }
            } else if (!a2.equalsIgnoreCase(HttpHeaders.PRAGMA)) {
                i3++;
                pVar2 = pVar;
            }
            z = false;
            while (i < b2.length()) {
            }
            i3++;
            pVar2 = pVar;
        }
        return new c(z2, z3, i4, i5, z4, z5, z6, i6, i7, z7, z8, z9, !z ? null : str2);
    }

    public boolean b() {
        return this.e;
    }

    public boolean c() {
        return this.f;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.h;
    }

    public int f() {
        return this.i;
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.f4809a;
    }

    public boolean i() {
        return this.b;
    }

    public boolean j() {
        return this.j;
    }

    public String toString() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        String a2 = a();
        this.m = a2;
        return a2;
    }

    /* compiled from: CacheControl.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f4810a;
        boolean b;
        int c = -1;
        int d = -1;
        int e = -1;
        boolean f;
        boolean g;
        boolean h;

        public a a(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: " + i);
            }
            long seconds = timeUnit.toSeconds(i);
            this.d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        public a b() {
            this.f4810a = true;
            return this;
        }

        public a c() {
            this.f = true;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    c(a aVar) {
        this.f4809a = aVar.f4810a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = -1;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = aVar.d;
        this.i = aVar.e;
        this.j = aVar.f;
        this.k = aVar.g;
        this.l = aVar.h;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f4809a) {
            sb.append("no-cache, ");
        }
        if (this.b) {
            sb.append("no-store, ");
        }
        if (this.c != -1) {
            sb.append("max-age=").append(this.c).append(", ");
        }
        if (this.d != -1) {
            sb.append("s-maxage=").append(this.d).append(", ");
        }
        if (this.e) {
            sb.append("private, ");
        }
        if (this.f) {
            sb.append("public, ");
        }
        if (this.g) {
            sb.append("must-revalidate, ");
        }
        if (this.h != -1) {
            sb.append("max-stale=").append(this.h).append(", ");
        }
        if (this.i != -1) {
            sb.append("min-fresh=").append(this.i).append(", ");
        }
        if (this.j) {
            sb.append("only-if-cached, ");
        }
        if (this.k) {
            sb.append("no-transform, ");
        }
        if (this.l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
