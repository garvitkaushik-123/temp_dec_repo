package com.fyber.inneractive.sdk.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class r1 extends t1 {
    public static final Class c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    @Override // com.fyber.inneractive.sdk.protobuf.t1
    public final void a(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) x3.e(obj, j);
        if (list instanceof q1) {
            unmodifiableList = ((q1) list).a();
        } else {
            if (c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof n2) && (list instanceof k1)) {
                c cVar = (c) ((k1) list);
                if (cVar.f1661a) {
                    cVar.f1661a = false;
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        x3.a(j, obj, unmodifiableList);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t1
    public final List b(Object obj, long j) {
        return a(obj, j, 10);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t1
    public final void a(long j, Object obj, Object obj2) {
        List list = (List) x3.e(obj2, j);
        List a2 = a(obj, j, list.size());
        int size = a2.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            a2.addAll(list);
        }
        if (size > 0) {
            list = a2;
        }
        x3.a(j, obj, list);
    }

    public static List a(Object obj, long j, int i) {
        List arrayList;
        List list = (List) x3.e(obj, j);
        if (list.isEmpty()) {
            if (list instanceof q1) {
                arrayList = new p1(i);
            } else if ((list instanceof n2) && (list instanceof k1)) {
                arrayList = ((k1) list).b(i);
            } else {
                arrayList = new ArrayList(i);
            }
            x3.a(j, obj, arrayList);
            return arrayList;
        }
        if (c.isAssignableFrom(list.getClass())) {
            ArrayList arrayList2 = new ArrayList(list.size() + i);
            arrayList2.addAll(list);
            x3.a(j, obj, arrayList2);
            return arrayList2;
        }
        if (list instanceof r3) {
            p1 p1Var = new p1(list.size() + i);
            p1Var.addAll((r3) list);
            x3.a(j, obj, p1Var);
            return p1Var;
        }
        if ((list instanceof n2) && (list instanceof k1)) {
            k1 k1Var = (k1) list;
            if (!((c) k1Var).f1661a) {
                k1 b = k1Var.b(list.size() + i);
                x3.a(j, obj, b);
                return b;
            }
        }
        return list;
    }
}
