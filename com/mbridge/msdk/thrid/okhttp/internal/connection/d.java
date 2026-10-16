package com.mbridge.msdk.thrid.okhttp.internal.connection;

import com.mbridge.msdk.thrid.okhttp.a0;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: RouteDatabase.java */
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final Set<a0> f4827a = new LinkedHashSet();

    public synchronized void a(a0 a0Var) {
        this.f4827a.remove(a0Var);
    }

    public synchronized void b(a0 a0Var) {
        this.f4827a.add(a0Var);
    }

    public synchronized boolean c(a0 a0Var) {
        return this.f4827a.contains(a0Var);
    }
}
