package com.fyber.inneractive.sdk.network;

import android.content.Context;
import com.fyber.inneractive.sdk.external.InvalidAppIdException;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.FileOutputStream;
import java.util.Map;

/* loaded from: classes4.dex */
public class t0 extends s0 {
    public final Context p;
    public final com.fyber.inneractive.sdk.cache.a q;
    public d0 r;

    public t0(e0 e0Var, Context context, com.fyber.inneractive.sdk.cache.a aVar) {
        super(e0Var, f0.c.a(), null);
        this.p = context;
        this.q = aVar;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public n0 a(l lVar, Map map, int i) {
        n0 n0Var = new n0();
        try {
            String stringBuffer = com.fyber.inneractive.sdk.util.t.a(lVar.c).toString();
            n0Var.f1331a = this.q.a(stringBuffer);
            n0Var.b = stringBuffer;
            return n0Var;
        } catch (Exception e) {
            IAlog.a("failed parse cacheable network request", e, new Object[0]);
            if (e instanceof InvalidAppIdException) {
                throw e;
            }
            throw new m0(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final int e() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final String f() {
        return this.q.c();
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final a g() {
        d0 d0Var = new d0(this.p, this.q);
        this.r = d0Var;
        com.fyber.inneractive.sdk.cache.l a2 = d0Var.a();
        String str = a2.b;
        Object obj = a2.f1045a;
        this.q.c();
        return new a(obj, str);
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final l0 k() {
        return l0.GET;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final e1 m() {
        return e1.LOW;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final String p() {
        return this.q.a();
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final boolean s() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    @Override // com.fyber.inneractive.sdk.network.s0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(n0 n0Var, String str, String str2) {
        boolean z;
        d0 d0Var = this.r;
        if (d0Var != null) {
            if (d0Var.c == null) {
                d0Var.c = d0Var.f1316a.getSharedPreferences("IAConfigurationPreferences", 0);
            }
            d0Var.c.edit().putString(d0Var.b.b(), str2).apply();
            if (n0Var == null || n0Var.b.isEmpty() || str.isEmpty()) {
                return;
            }
            d0 d0Var2 = this.r;
            String str3 = n0Var.b;
            d0Var2.getClass();
            IAlog.a("caching file %s", str);
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    fileOutputStream = d0Var2.f1316a.openFileOutput(str, 0);
                    fileOutputStream.write(str3.getBytes());
                    z = true;
                    try {
                        IAlog.a("File cached successfully", new Object[0]);
                        try {
                            fileOutputStream.close();
                        } catch (Exception e) {
                            IAlog.f("Failed closing cache file: %s", e.getMessage());
                        }
                    } catch (Exception e2) {
                        e = e2;
                        IAlog.f("Failed caching file: %s", e.getMessage());
                        if (z) {
                        }
                    }
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e3) {
                            IAlog.f("Failed closing cache file: %s", e3.getMessage());
                        }
                    }
                }
            } catch (Exception e4) {
                e = e4;
                z = false;
            }
            if (z) {
                IAlog.b("Failed to cache file", new Object[0]);
            } else {
                this.q.a(n0Var.f1331a);
            }
        }
    }
}
