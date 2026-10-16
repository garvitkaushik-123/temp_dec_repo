package com.ironsource;

import com.ironsource.C3239p0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;

/* loaded from: classes6.dex */
public final class J {

    /* renamed from: a, reason: collision with root package name */
    private final int f2912a;
    private final List<H> b = new CopyOnWriteArrayList();

    public J(int i) {
        this.f2912a = i;
    }

    private final boolean b() {
        return this.f2912a == 0;
    }

    private final boolean c() {
        return this.f2912a != -1;
    }

    public final void a(H h) {
        if (b()) {
            return;
        }
        if (a()) {
            CollectionsKt.removeFirstOrNull(this.b);
        }
        if (h == null) {
            h = new H(C3239p0.a.NotPartOfWaterfall);
        }
        this.b.add(h);
    }

    public final String d() {
        List<H> list = this.b;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((H) it.next()).b().ordinal()));
        }
        return CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
    }

    private final boolean a() {
        return c() && this.b.size() >= this.f2912a;
    }
}
