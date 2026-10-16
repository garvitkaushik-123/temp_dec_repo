package com.mbridge.msdk.foundation.same.directory;

import java.util.ArrayList;
import java.util.List;

/* compiled from: DirectoryContext.java */
/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected a f4269a;

    public b(String str) {
        a aVar = new a();
        aVar.a(str);
        aVar.a(c.AD_ROOT);
        List<a> b = b();
        if (b != null && b.size() > 0) {
            aVar.a(b);
        }
        this.f4269a = aVar;
    }

    protected a a(ArrayList<a> arrayList, c cVar, String str) {
        a aVar = new a();
        aVar.a(cVar);
        aVar.a(str);
        arrayList.add(aVar);
        return aVar;
    }

    protected abstract List<a> b();

    public a a() {
        return this.f4269a;
    }
}
