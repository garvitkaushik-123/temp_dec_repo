package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import java.io.File;
import java.util.List;

/* loaded from: classes2.dex */
public class e0 extends c0 {
    private final String f;
    private final com.applovin.impl.sdk.ad.b g;
    private final List h;
    private final boolean i;
    private final String j;
    private final com.applovin.impl.sdk.k k;
    private final a l;

    public interface a {
        void a(Uri uri);
    }

    public e0(String str, com.applovin.impl.sdk.ad.b bVar, String str2, com.applovin.impl.sdk.k kVar, a aVar) {
        this(str, bVar, bVar.c0(), true, str2, kVar, aVar);
    }

    private void a(Uri uri) {
        a aVar;
        if (this.e.get() || (aVar = this.l) == null) {
            return;
        }
        aVar.a(uri);
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean call() {
        if (this.e.get()) {
            return Boolean.FALSE;
        }
        String a2 = this.k.H().a(a(), this.f, this.g.getCachePrefix(), this.h, this.i, this.k.H().a(this.f, this.g), this.j, e2.a((AppLovinAdImpl) this.g));
        if (TextUtils.isEmpty(a2)) {
            a((Uri) null);
            return Boolean.FALSE;
        }
        if (this.e.get()) {
            return Boolean.FALSE;
        }
        File a3 = this.k.H().a(a2, a());
        if (a3 == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to retrieve File for cached filename = " + a2);
            }
            a((Uri) null);
            return Boolean.FALSE;
        }
        if (this.e.get()) {
            return Boolean.FALSE;
        }
        Uri fromFile = Uri.fromFile(a3);
        if (fromFile == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to extract Uri from file");
            }
            a((Uri) null);
            return Boolean.FALSE;
        }
        if (this.e.get()) {
            return Boolean.FALSE;
        }
        a(fromFile);
        return Boolean.TRUE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f.equals(((e0) obj).f);
    }

    public int hashCode() {
        String str = this.f;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public e0(String str, com.applovin.impl.sdk.ad.b bVar, List list, boolean z, String str2, com.applovin.impl.sdk.k kVar, a aVar) {
        super("AsyncTaskCacheResource", kVar);
        this.f = str;
        this.g = bVar;
        this.h = list;
        this.i = z;
        this.j = str2;
        this.k = kVar;
        this.l = aVar;
    }
}
