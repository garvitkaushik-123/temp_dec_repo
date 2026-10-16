package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class t0 implements c2 {

    /* renamed from: a, reason: collision with root package name */
    public final z0 f1700a;
    public z0 b;
    public boolean c = false;

    public t0(z0 z0Var) {
        this.f1700a = z0Var;
        this.b = (z0) z0Var.dynamicMethod(y0.NEW_MUTABLE_INSTANCE);
    }

    public static void a(z0 z0Var, z0 z0Var2) {
        p2 p2Var = p2.c;
        p2Var.getClass();
        p2Var.a(z0Var.getClass()).a(z0Var, z0Var2);
    }

    public final z0 b() {
        if (this.c) {
            return this.b;
        }
        this.b.makeImmutable();
        this.c = true;
        return this.b;
    }

    public final void c() {
        if (this.c) {
            z0 z0Var = (z0) this.b.dynamicMethod(y0.NEW_MUTABLE_INSTANCE);
            a(z0Var, this.b);
            this.b = z0Var;
            this.c = false;
        }
    }

    public final Object clone() {
        t0 newBuilderForType = this.f1700a.newBuilderForType();
        z0 b = b();
        newBuilderForType.c();
        a(newBuilderForType.b, b);
        return newBuilderForType;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.e2
    public final d2 getDefaultInstanceForType() {
        return this.f1700a;
    }

    public static void a(Iterable iterable, List list) {
        Charset charset = l1.f1684a;
        iterable.getClass();
        if (iterable instanceof q1) {
            List b = ((q1) iterable).b();
            q1 q1Var = (q1) list;
            int size = list.size();
            for (Object obj : b) {
                if (obj == null) {
                    String str = "Element at index " + (q1Var.size() - size) + " is null.";
                    for (int size2 = q1Var.size() - 1; size2 >= size; size2--) {
                        q1Var.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof s) {
                    q1Var.a((s) obj);
                } else {
                    q1Var.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof n2) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
        }
        int size3 = list.size();
        for (Object obj2 : iterable) {
            if (obj2 == null) {
                String str2 = "Element at index " + (list.size() - size3) + " is null.";
                for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                    list.remove(size4);
                }
                throw new NullPointerException(str2);
            }
            list.add(obj2);
        }
    }

    public final z0 a() {
        z0 b = b();
        if (b.isInitialized()) {
            return b;
        }
        throw new m3();
    }

    public final t0 a(w wVar, h0 h0Var) {
        c();
        try {
            p2 p2Var = p2.c;
            z0 z0Var = this.b;
            p2Var.getClass();
            t2 a2 = p2Var.a(z0Var.getClass());
            z0 z0Var2 = this.b;
            x xVar = wVar.d;
            if (xVar == null) {
                xVar = new x(wVar);
            }
            a2.a(z0Var2, xVar, h0Var);
            return this;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof IOException) {
                throw ((IOException) e.getCause());
            }
            throw e;
        }
    }
}
