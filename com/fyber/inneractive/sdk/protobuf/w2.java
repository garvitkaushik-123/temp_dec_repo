package com.fyber.inneractive.sdk.protobuf;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class w2 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f1706a;
    public Iterator b;
    public final /* synthetic */ e3 c;

    public w2(e3 e3Var) {
        this.c = e3Var;
        this.f1706a = e3Var.b.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.f1706a;
        if (i > 0 && i <= this.c.b.size()) {
            return true;
        }
        if (this.b == null) {
            this.b = this.c.f.entrySet().iterator();
        }
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.b == null) {
            this.b = this.c.f.entrySet().iterator();
        }
        if (this.b.hasNext()) {
            if (this.b == null) {
                this.b = this.c.f.entrySet().iterator();
            }
            return (Map.Entry) this.b.next();
        }
        List list = this.c.b;
        int i = this.f1706a - 1;
        this.f1706a = i;
        return (Map.Entry) list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
