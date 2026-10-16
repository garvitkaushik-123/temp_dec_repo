package com.bykv.vk.openvk.preload.a.b;

import com.bykv.vk.openvk.preload.a.j;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* compiled from: ConstructorConstructor.java */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Type, com.bykv.vk.openvk.preload.a.f<?>> f886a;
    private final com.bykv.vk.openvk.preload.a.b.b.b b = com.bykv.vk.openvk.preload.a.b.b.b.a();

    public b(Map<Type, com.bykv.vk.openvk.preload.a.f<?>> map) {
        this.f886a = map;
    }

    public final <T> h<T> a(com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        h<T> hVar;
        final Type b = aVar.b();
        final Class<? super T> a2 = aVar.a();
        final com.bykv.vk.openvk.preload.a.f<?> fVar = this.f886a.get(b);
        if (fVar != null) {
            return new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.1
                @Override // com.bykv.vk.openvk.preload.a.b.h
                public final T a() {
                    return (T) com.bykv.vk.openvk.preload.a.f.this.a();
                }
            };
        }
        final com.bykv.vk.openvk.preload.a.f<?> fVar2 = this.f886a.get(a2);
        if (fVar2 != null) {
            return new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.7
                @Override // com.bykv.vk.openvk.preload.a.b.h
                public final T a() {
                    return (T) com.bykv.vk.openvk.preload.a.f.this.a();
                }
            };
        }
        h<T> a3 = a(a2);
        if (a3 != null) {
            return a3;
        }
        if (Collection.class.isAssignableFrom(a2)) {
            if (SortedSet.class.isAssignableFrom(a2)) {
                hVar = new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.9
                    @Override // com.bykv.vk.openvk.preload.a.b.h
                    public final T a() {
                        return (T) new TreeSet();
                    }
                };
            } else if (EnumSet.class.isAssignableFrom(a2)) {
                hVar = new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.10
                    @Override // com.bykv.vk.openvk.preload.a.b.h
                    public final T a() {
                        Type type = b;
                        if (type instanceof ParameterizedType) {
                            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                            if (type2 instanceof Class) {
                                return (T) EnumSet.noneOf((Class) type2);
                            }
                            throw new j("Invalid EnumSet type: " + b.toString());
                        }
                        throw new j("Invalid EnumSet type: " + b.toString());
                    }
                };
            } else if (Set.class.isAssignableFrom(a2)) {
                hVar = new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.11
                    @Override // com.bykv.vk.openvk.preload.a.b.h
                    public final T a() {
                        return (T) new LinkedHashSet();
                    }
                };
            } else if (Queue.class.isAssignableFrom(a2)) {
                hVar = new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.12
                    @Override // com.bykv.vk.openvk.preload.a.b.h
                    public final T a() {
                        return (T) new ArrayDeque();
                    }
                };
            } else {
                hVar = new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.13
                    @Override // com.bykv.vk.openvk.preload.a.b.h
                    public final T a() {
                        return (T) new ArrayList();
                    }
                };
            }
        } else if (!Map.class.isAssignableFrom(a2)) {
            hVar = null;
        } else if (ConcurrentNavigableMap.class.isAssignableFrom(a2)) {
            hVar = new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.14
                @Override // com.bykv.vk.openvk.preload.a.b.h
                public final T a() {
                    return (T) new ConcurrentSkipListMap();
                }
            };
        } else if (ConcurrentMap.class.isAssignableFrom(a2)) {
            hVar = new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.2
                @Override // com.bykv.vk.openvk.preload.a.b.h
                public final T a() {
                    return (T) new ConcurrentHashMap();
                }
            };
        } else if (SortedMap.class.isAssignableFrom(a2)) {
            hVar = new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.3
                @Override // com.bykv.vk.openvk.preload.a.b.h
                public final T a() {
                    return (T) new TreeMap();
                }
            };
        } else if ((b instanceof ParameterizedType) && !String.class.isAssignableFrom(com.bykv.vk.openvk.preload.a.c.a.a(((ParameterizedType) b).getActualTypeArguments()[0]).a())) {
            hVar = new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.4
                @Override // com.bykv.vk.openvk.preload.a.b.h
                public final T a() {
                    return (T) new LinkedHashMap();
                }
            };
        } else {
            hVar = new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.5
                @Override // com.bykv.vk.openvk.preload.a.b.h
                public final T a() {
                    return (T) new g();
                }
            };
        }
        return hVar != null ? hVar : new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.6

            /* renamed from: a, reason: collision with root package name */
            private final i f889a = i.a();

            @Override // com.bykv.vk.openvk.preload.a.b.h
            public final T a() {
                try {
                    return (T) this.f889a.a(a2);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + b + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e);
                }
            }
        };
    }

    private <T> h<T> a(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.b.a(declaredConstructor);
            }
            return new h<T>() { // from class: com.bykv.vk.openvk.preload.a.b.b.8
                @Override // com.bykv.vk.openvk.preload.a.b.h
                public final T a() {
                    try {
                        return (T) declaredConstructor.newInstance(null);
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    } catch (InstantiationException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2);
                    } catch (InvocationTargetException e3) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final String toString() {
        return this.f886a.toString();
    }
}
