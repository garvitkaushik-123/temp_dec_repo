package com.iab.omid.library.fyber.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes4.dex */
public class c {
    private static c c = new c();

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.fyber.adsession.a> f1961a = new ArrayList<>();
    private final ArrayList<com.iab.omid.library.fyber.adsession.a> b = new ArrayList<>();

    private c() {
    }

    public static c c() {
        return c;
    }

    public Collection<com.iab.omid.library.fyber.adsession.a> a() {
        return Collections.unmodifiableCollection(this.b);
    }

    public void a(com.iab.omid.library.fyber.adsession.a aVar) {
        this.f1961a.add(aVar);
    }

    public Collection<com.iab.omid.library.fyber.adsession.a> b() {
        return Collections.unmodifiableCollection(this.f1961a);
    }

    public void b(com.iab.omid.library.fyber.adsession.a aVar) {
        boolean d = d();
        this.f1961a.remove(aVar);
        this.b.remove(aVar);
        if (!d || d()) {
            return;
        }
        i.c().e();
    }

    public void c(com.iab.omid.library.fyber.adsession.a aVar) {
        boolean d = d();
        this.b.add(aVar);
        if (d) {
            return;
        }
        i.c().d();
    }

    public boolean d() {
        return this.b.size() > 0;
    }
}
