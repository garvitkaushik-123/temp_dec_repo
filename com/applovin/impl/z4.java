package com.applovin.impl;

import android.os.SystemClock;
import com.applovin.mediation.MaxAdFormat;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class z4 {

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f815a;
    private final Map b = new HashMap();
    private final Object c = new Object();

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f816a;

        static {
            int[] iArr = new int[b.values().length];
            f816a = iArr;
            try {
                iArr[b.AD_FORMAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f816a[b.AD_UNIT_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f816a[b.ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum b {
        AD_FORMAT,
        AD_UNIT_ID,
        ALL
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private final a5 f818a;
        private final long b;
        private final long c;

        /* synthetic */ c(a5 a5Var, long j, a aVar) {
            this(a5Var, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d() {
            return SystemClock.elapsedRealtime() - this.c > this.b;
        }

        protected boolean a(Object obj) {
            return obj instanceof c;
        }

        public a5 c() {
            return this.f818a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!cVar.a((Object) this) || b() != cVar.b() || a() != cVar.a()) {
                return false;
            }
            a5 c = c();
            a5 c2 = cVar.c();
            return c != null ? c.equals(c2) : c2 == null;
        }

        public int hashCode() {
            long b = b();
            long a2 = a();
            a5 c = c();
            return ((((((int) (b ^ (b >>> 32))) + 59) * 59) + ((int) ((a2 >>> 32) ^ a2))) * 59) + (c == null ? 43 : c.hashCode());
        }

        public String toString() {
            return "SignalCacheManager.SignalWrapper(signal=" + c() + ", expirationTimeMillis=" + b() + ", cacheTimestampMillis=" + a() + ")";
        }

        private c(a5 a5Var, long j) {
            this.f818a = a5Var;
            this.b = j;
            this.c = SystemClock.elapsedRealtime();
        }

        public long b() {
            return this.b;
        }

        public long a() {
            return this.c;
        }
    }

    public z4(com.applovin.impl.sdk.k kVar) {
        this.f815a = kVar;
    }

    public void a(a5 a5Var, b5 b5Var, String str, MaxAdFormat maxAdFormat) {
        if (a5Var == null) {
            return;
        }
        long v = b5Var.v();
        if (v <= 0) {
            return;
        }
        this.f815a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f815a.O().a("SignalCacheManager", "Caching signal for: " + b5Var);
        }
        String a2 = a(b5Var, str, maxAdFormat);
        c cVar = new c(a5Var, v, null);
        synchronized (this.c) {
            this.b.put(a2, cVar);
        }
    }

    public a5 b(b5 b5Var, String str, MaxAdFormat maxAdFormat) {
        String a2 = a(b5Var, str, maxAdFormat);
        synchronized (this.c) {
            c cVar = (c) this.b.get(a2);
            if (cVar == null) {
                return null;
            }
            if (cVar.d()) {
                this.b.remove(a2);
                return null;
            }
            this.f815a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f815a.O().a("SignalCacheManager", "Returning cached signal for: " + b5Var);
            }
            return cVar.f818a;
        }
    }

    private String a(b5 b5Var, String str, MaxAdFormat maxAdFormat) {
        String c2 = b5Var.c();
        int i = a.f816a[b5Var.t().ordinal()];
        if (i != 1) {
            return i != 2 ? c2 : c2 + "_" + str;
        }
        return c2 + "_" + maxAdFormat.getLabel();
    }
}
