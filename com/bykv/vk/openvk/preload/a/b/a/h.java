package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.p;
import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.s;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ReflectiveTypeAdapterFactory.java */
/* loaded from: classes3.dex */
public final class h implements s {

    /* renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b f869a;
    private final com.bykv.vk.openvk.preload.a.c b;
    private final com.bykv.vk.openvk.preload.a.b.c c;
    private final com.bykv.vk.openvk.preload.a.b.b.b d = com.bykv.vk.openvk.preload.a.b.b.b.a();

    public h(com.bykv.vk.openvk.preload.a.b.b bVar, com.bykv.vk.openvk.preload.a.c cVar, com.bykv.vk.openvk.preload.a.b.c cVar2) {
        this.f869a = bVar;
        this.b = cVar;
        this.c = cVar2;
    }

    private boolean a(Field field, boolean z) {
        com.bykv.vk.openvk.preload.a.b.c cVar = this.c;
        return (cVar.a(field.getType(), z) || cVar.a(field, z)) ? false : true;
    }

    private List<String> a(Field field) {
        com.bykv.vk.openvk.preload.a.a.b bVar = (com.bykv.vk.openvk.preload.a.a.b) field.getAnnotation(com.bykv.vk.openvk.preload.a.a.b.class);
        if (bVar == null) {
            return Collections.singletonList(this.b.a(field));
        }
        String a2 = bVar.a();
        String[] b2 = bVar.b();
        if (b2.length == 0) {
            return Collections.singletonList(a2);
        }
        ArrayList arrayList = new ArrayList(b2.length + 1);
        arrayList.add(a2);
        for (String str : b2) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.bykv.vk.openvk.preload.a.s
    public final <T> r<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        Class<? super T> a2 = aVar.a();
        if (Object.class.isAssignableFrom(a2)) {
            return new a(this.f869a.a(aVar), a(dVar, aVar, a2));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [int] */
    /* JADX WARN: Type inference failed for: r13v8 */
    private Map<String, b> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<?> aVar, Class<?> cls) {
        com.bykv.vk.openvk.preload.a.c.a<?> aVar2;
        Field[] fieldArr;
        int i;
        boolean z;
        int i2;
        int i3;
        final boolean z2;
        final com.bykv.vk.openvk.preload.a.d dVar2 = dVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!cls.isInterface()) {
            Type b2 = aVar.b();
            com.bykv.vk.openvk.preload.a.c.a<?> aVar3 = aVar;
            Class<?> cls2 = cls;
            while (cls2 != Object.class) {
                Field[] declaredFields = cls2.getDeclaredFields();
                int length = declaredFields.length;
                boolean z3 = false;
                int i4 = 0;
                while (i4 < length) {
                    final Field field = declaredFields[i4];
                    boolean a2 = a(field, true);
                    boolean a3 = a(field, z3);
                    if (a2 || a3) {
                        this.d.a(field);
                        Type a4 = com.bykv.vk.openvk.preload.a.b.a.a(aVar3.b(), cls2, field.getGenericType());
                        List<String> a5 = a(field);
                        int size = a5.size();
                        aVar2 = aVar3;
                        fieldArr = declaredFields;
                        b bVar = null;
                        for (?? r13 = z3; r13 < size; r13++) {
                            String str = a5.get(r13);
                            if (r13 != 0) {
                                a2 = z3;
                            }
                            List<String> list = a5;
                            final com.bykv.vk.openvk.preload.a.c.a<?> a6 = com.bykv.vk.openvk.preload.a.c.a.a(a4);
                            Class<? super Object> a7 = a6.a();
                            if ((a7 instanceof Class) && a7.isPrimitive()) {
                                i3 = size;
                                z2 = true;
                            } else {
                                i3 = size;
                                z2 = false;
                            }
                            com.bykv.vk.openvk.preload.a.a.a aVar4 = (com.bykv.vk.openvk.preload.a.a.a) field.getAnnotation(com.bykv.vk.openvk.preload.a.a.a.class);
                            int i5 = length;
                            r<?> a8 = aVar4 != null ? d.a(this.f869a, dVar2, a6, aVar4) : null;
                            int i6 = i4;
                            boolean z4 = a2;
                            final boolean z5 = a8 != null;
                            if (a8 == null) {
                                a8 = dVar2.a((com.bykv.vk.openvk.preload.a.c.a) a6);
                            }
                            int i7 = i3;
                            final r<?> rVar = a8;
                            b bVar2 = (b) linkedHashMap.put(str, new b(str, z4, a3) { // from class: com.bykv.vk.openvk.preload.a.b.a.h.1
                                @Override // com.bykv.vk.openvk.preload.a.b.a.h.b
                                final void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException, IllegalAccessException {
                                    (z5 ? rVar : new l(dVar2, rVar, a6.b())).a(cVar, field.get(obj));
                                }

                                @Override // com.bykv.vk.openvk.preload.a.b.a.h.b
                                final void a(com.bykv.vk.openvk.preload.a.d.a aVar5, Object obj) throws IOException, IllegalAccessException {
                                    Object a9 = rVar.a(aVar5);
                                    if (a9 == null && z2) {
                                        return;
                                    }
                                    field.set(obj, a9);
                                }

                                @Override // com.bykv.vk.openvk.preload.a.b.a.h.b
                                public final boolean a(Object obj) throws IOException, IllegalAccessException {
                                    return this.b && field.get(obj) != obj;
                                }
                            });
                            if (bVar == null) {
                                bVar = bVar2;
                            }
                            dVar2 = dVar;
                            a2 = z4;
                            i4 = i6;
                            a5 = list;
                            size = i7;
                            length = i5;
                            z3 = false;
                        }
                        i = length;
                        z = z3;
                        i2 = i4;
                        if (bVar != null) {
                            throw new IllegalArgumentException(b2 + " declares multiple JSON fields named " + bVar.f871a);
                        }
                    } else {
                        i = length;
                        z = z3;
                        i2 = i4;
                        aVar2 = aVar3;
                        fieldArr = declaredFields;
                    }
                    i4 = i2 + 1;
                    dVar2 = dVar;
                    aVar3 = aVar2;
                    declaredFields = fieldArr;
                    length = i;
                    z3 = z;
                }
                aVar3 = com.bykv.vk.openvk.preload.a.c.a.a(com.bykv.vk.openvk.preload.a.b.a.a(aVar3.b(), cls2, cls2.getGenericSuperclass()));
                cls2 = aVar3.a();
                dVar2 = dVar;
            }
        }
        return linkedHashMap;
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        final String f871a;
        final boolean b;
        final boolean c;

        abstract void a(com.bykv.vk.openvk.preload.a.d.a aVar, Object obj) throws IOException, IllegalAccessException;

        abstract void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException, IllegalAccessException;

        abstract boolean a(Object obj) throws IOException, IllegalAccessException;

        protected b(String str, boolean z, boolean z2) {
            this.f871a = str;
            this.b = z;
            this.c = z2;
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    public static final class a<T> extends r<T> {

        /* renamed from: a, reason: collision with root package name */
        private final com.bykv.vk.openvk.preload.a.b.h<T> f870a;
        private final Map<String, b> b;

        a(com.bykv.vk.openvk.preload.a.b.h<T> hVar, Map<String, b> map) {
            this.f870a = hVar;
            this.b = map;
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            T a2 = this.f870a.a();
            try {
                aVar.c();
                while (aVar.e()) {
                    b bVar = this.b.get(aVar.g());
                    if (bVar != null && bVar.c) {
                        bVar.a(aVar, a2);
                    }
                    aVar.n();
                }
                aVar.d();
                return a2;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new p(e2);
            }
        }

        @Override // com.bykv.vk.openvk.preload.a.r
        public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t) throws IOException {
            if (t == null) {
                cVar.h();
                return;
            }
            cVar.f();
            try {
                for (b bVar : this.b.values()) {
                    if (bVar.a(t)) {
                        cVar.a(bVar.f871a);
                        bVar.a(cVar, t);
                    }
                }
                cVar.g();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }
}
