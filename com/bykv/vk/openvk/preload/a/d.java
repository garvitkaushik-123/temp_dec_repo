package com.bykv.vk.openvk.preload.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: Gson.java */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final com.bykv.vk.openvk.preload.a.c.a<?> f908a = com.bykv.vk.openvk.preload.a.c.a.a(Object.class);
    private final ThreadLocal<Map<com.bykv.vk.openvk.preload.a.c.a<?>, a<?>>> b;
    private final Map<com.bykv.vk.openvk.preload.a.c.a<?>, r<?>> c;
    private final com.bykv.vk.openvk.preload.a.b.b d;
    private final com.bykv.vk.openvk.preload.a.b.a.d e;
    private List<s> f;
    private boolean g;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d() {
        this(r1, r2, r3, true, r5, Collections.emptyList());
        com.bykv.vk.openvk.preload.a.b.c cVar = com.bykv.vk.openvk.preload.a.b.c.f894a;
        b bVar = b.f854a;
        Map emptyMap = Collections.emptyMap();
        q qVar = q.f920a;
        Collections.emptyList();
        Collections.emptyList();
    }

    d(com.bykv.vk.openvk.preload.a.b.c cVar, c cVar2, Map<Type, f<?>> map, boolean z, q qVar, List<s> list) {
        final r<Number> rVar;
        this.b = new ThreadLocal<>();
        this.c = new ConcurrentHashMap();
        com.bykv.vk.openvk.preload.a.b.b bVar = new com.bykv.vk.openvk.preload.a.b.b(map);
        this.d = bVar;
        this.g = z;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.B);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.g.f867a);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.p);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.g);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.d);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.e);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f);
        if (qVar == q.f920a) {
            rVar = com.bykv.vk.openvk.preload.a.b.a.m.k;
        } else {
            rVar = new r<Number>() { // from class: com.bykv.vk.openvk.preload.a.d.3
                @Override // com.bykv.vk.openvk.preload.a.r
                public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, Number number) throws IOException {
                    Number number2 = number;
                    if (number2 == null) {
                        cVar3.h();
                    } else {
                        cVar3.b(number2.toString());
                    }
                }

                @Override // com.bykv.vk.openvk.preload.a.r
                public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                    if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                        aVar.j();
                        return null;
                    }
                    return Long.valueOf(aVar.l());
                }
            };
        }
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Long.TYPE, Long.class, rVar));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Double.TYPE, Double.class, new r<Number>() { // from class: com.bykv.vk.openvk.preload.a.d.1
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, Number number) throws IOException {
                Number number2 = number;
                if (number2 == null) {
                    cVar3.h();
                } else {
                    d.a(number2.doubleValue());
                    cVar3.a(number2);
                }
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Double.valueOf(aVar.k());
            }
        }));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Float.TYPE, Float.class, new r<Number>() { // from class: com.bykv.vk.openvk.preload.a.d.2
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, Number number) throws IOException {
                Number number2 = number;
                if (number2 == null) {
                    cVar3.h();
                } else {
                    d.a(number2.floatValue());
                    cVar3.a(number2);
                }
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Float.valueOf((float) aVar.k());
            }
        }));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.l);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.h);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.i);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(AtomicLong.class, new r<AtomicLong>() { // from class: com.bykv.vk.openvk.preload.a.d.4
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, AtomicLong atomicLong) throws IOException {
                r.this.a(cVar3, Long.valueOf(atomicLong.get()));
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ AtomicLong a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return new AtomicLong(((Number) r.this.a(aVar)).longValue());
            }
        }.a()));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(AtomicLongArray.class, new r<AtomicLongArray>() { // from class: com.bykv.vk.openvk.preload.a.d.5
            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, AtomicLongArray atomicLongArray) throws IOException {
                AtomicLongArray atomicLongArray2 = atomicLongArray;
                cVar3.d();
                int length = atomicLongArray2.length();
                for (int i = 0; i < length; i++) {
                    r.this.a(cVar3, Long.valueOf(atomicLongArray2.get(i)));
                }
                cVar3.e();
            }

            @Override // com.bykv.vk.openvk.preload.a.r
            public final /* synthetic */ AtomicLongArray a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                ArrayList arrayList2 = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList2.add(Long.valueOf(((Number) r.this.a(aVar)).longValue()));
                }
                aVar.b();
                int size = arrayList2.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList2.get(i)).longValue());
                }
                return atomicLongArray;
            }
        }.a()));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.j);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.m);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.q);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.r);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(BigDecimal.class, com.bykv.vk.openvk.preload.a.b.a.m.n));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(BigInteger.class, com.bykv.vk.openvk.preload.a.b.a.m.o));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.s);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.t);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.v);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.w);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.z);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.u);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.b);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.c.f862a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.y);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.j.f873a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.i.f872a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.x);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.a.f856a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f876a);
        arrayList.add(new com.bykv.vk.openvk.preload.a.b.a.b(bVar));
        arrayList.add(new com.bykv.vk.openvk.preload.a.b.a.f(bVar));
        com.bykv.vk.openvk.preload.a.b.a.d dVar = new com.bykv.vk.openvk.preload.a.b.a.d(bVar);
        this.e = dVar;
        arrayList.add(dVar);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.C);
        arrayList.add(new com.bykv.vk.openvk.preload.a.b.a.h(bVar, cVar2, cVar));
        this.f = Collections.unmodifiableList(arrayList);
    }

    static void a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final <T> r<T> a(com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        boolean z;
        r<T> rVar = (r) this.c.get(aVar == null ? f908a : aVar);
        if (rVar != null) {
            return rVar;
        }
        Map<com.bykv.vk.openvk.preload.a.c.a<?>, a<?>> map = this.b.get();
        if (map == null) {
            map = new HashMap<>();
            this.b.set(map);
            z = true;
        } else {
            z = false;
        }
        a<?> aVar2 = map.get(aVar);
        if (aVar2 != null) {
            return aVar2;
        }
        try {
            a<?> aVar3 = new a<>();
            map.put(aVar, aVar3);
            Iterator<s> it = this.f.iterator();
            while (it.hasNext()) {
                r<T> a2 = it.next().a(this, aVar);
                if (a2 != null) {
                    aVar3.a((r<?>) a2);
                    this.c.put(aVar, a2);
                    return a2;
                }
            }
            throw new IllegalArgumentException("GSON (pangle-v3200) cannot handle ".concat(String.valueOf(aVar)));
        } finally {
            map.remove(aVar);
            if (z) {
                this.b.remove();
            }
        }
    }

    public final <T> r<T> a(s sVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        if (!this.f.contains(sVar)) {
            sVar = this.e;
        }
        boolean z = false;
        for (s sVar2 : this.f) {
            if (z) {
                r<T> a2 = sVar2.a(this, aVar);
                if (a2 != null) {
                    return a2;
                }
            } else if (sVar2 == sVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize ".concat(String.valueOf(aVar)));
    }

    public final <T> r<T> a(Class<T> cls) {
        return a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a((Class) cls));
    }

    public final String a(Object obj) {
        com.bykv.vk.openvk.preload.a.d.c a2;
        boolean a3;
        boolean b;
        boolean c;
        if (obj == null) {
            k kVar = k.f917a;
            StringWriter stringWriter = new StringWriter();
            try {
                a2 = a((Writer) stringWriter);
                a3 = a2.a();
                a2.a(true);
                b = a2.b();
                a2.b(this.g);
                c = a2.c();
                a2.c(false);
                try {
                    try {
                        com.bykv.vk.openvk.preload.geckox.h.a.a(kVar, a2);
                        return stringWriter.toString();
                    } finally {
                    }
                } catch (IOException e) {
                    throw new j(e);
                } catch (AssertionError e2) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e2.getMessage());
                    assertionError.initCause(e2);
                    throw assertionError;
                }
            } catch (IOException e3) {
                throw new j(e3);
            }
        }
        Class<?> cls = obj.getClass();
        StringWriter stringWriter2 = new StringWriter();
        try {
            a2 = a((Writer) stringWriter2);
            r a4 = a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a((Type) cls));
            a3 = a2.a();
            a2.a(true);
            b = a2.b();
            a2.b(this.g);
            c = a2.c();
            a2.c(false);
            try {
                try {
                    try {
                        a4.a(a2, obj);
                        return stringWriter2.toString();
                    } finally {
                    }
                } catch (AssertionError e4) {
                    AssertionError assertionError2 = new AssertionError("AssertionError (GSON pangle-v3200): " + e4.getMessage());
                    assertionError2.initCause(e4);
                    throw assertionError2;
                }
            } catch (IOException e5) {
                throw new j(e5);
            }
        } catch (IOException e6) {
            throw new j(e6);
        }
    }

    private static com.bykv.vk.openvk.preload.a.d.c a(Writer writer) throws IOException {
        com.bykv.vk.openvk.preload.a.d.c cVar = new com.bykv.vk.openvk.preload.a.d.c(writer);
        cVar.c(false);
        return cVar;
    }

    private <T> T a(com.bykv.vk.openvk.preload.a.d.a aVar, Type type) throws j, p {
        boolean p = aVar.p();
        boolean z = true;
        aVar.a(true);
        try {
            try {
                try {
                    aVar.f();
                    z = false;
                    return a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(type)).a(aVar);
                } catch (AssertionError e) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e.getMessage());
                    assertionError.initCause(e);
                    throw assertionError;
                } catch (IllegalStateException e2) {
                    throw new p(e2);
                }
            } catch (EOFException e3) {
                if (!z) {
                    throw new p(e3);
                }
                aVar.a(p);
                return null;
            } catch (IOException e4) {
                throw new p(e4);
            }
        } finally {
            aVar.a(p);
        }
    }

    /* compiled from: Gson.java */
    static class a<T> extends r<T> {

        /* renamed from: a, reason: collision with root package name */
        private r<T> f911a;

        a() {
        }

        public final void a(r<T> rVar) {
            if (this.f911a != null) {
                throw new AssertionError();
            }
            this.f911a = rVar;
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            r<T> rVar = this.f911a;
            if (rVar == null) {
                throw new IllegalStateException();
            }
            return rVar.a(aVar);
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t) throws IOException {
            r<T> rVar = this.f911a;
            if (rVar == null) {
                throw new IllegalStateException();
            }
            rVar.a(cVar, t);
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.f + ",instanceCreators:" + this.d + "}";
    }

    public final <T> T a(Reader reader, Type type) throws j, p {
        com.bykv.vk.openvk.preload.a.d.a aVar = new com.bykv.vk.openvk.preload.a.d.a(reader);
        aVar.a(false);
        T t = (T) a(aVar, type);
        if (t != null) {
            try {
                if (aVar.f() != com.bykv.vk.openvk.preload.a.d.b.END_DOCUMENT) {
                    throw new j("JSON document was not fully consumed.");
                }
            } catch (com.bykv.vk.openvk.preload.a.d.d e) {
                throw new p(e);
            } catch (IOException e2) {
                throw new j(e2);
            }
        }
        return t;
    }
}
