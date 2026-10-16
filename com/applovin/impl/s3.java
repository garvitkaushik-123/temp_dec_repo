package com.applovin.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class s3 {

    /* renamed from: a, reason: collision with root package name */
    private final List f648a = Collections.synchronizedList(new ArrayList());

    public interface a {
        void a(v2 v2Var);
    }

    public void a(a aVar) {
        this.f648a.add(aVar);
    }

    public void b(a aVar) {
        this.f648a.remove(aVar);
    }

    public void a(v2 v2Var) {
        Iterator it = new ArrayList(this.f648a).iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(v2Var);
        }
    }
}
