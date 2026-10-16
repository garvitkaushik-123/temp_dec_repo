package com.bykv.vk.openvk.preload.a.b;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

/* compiled from: $Gson$Types.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    static final Type[] f855a = new Type[0];

    private static GenericArrayType f(Type type) {
        return new C0112a(type);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.bykv.vk.openvk.preload.a.b.a$a] */
    public static Type a(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                cls = new C0112a(a((Type) cls.getComponentType()));
            }
            return cls;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new C0112a(((GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    public static Class<?> b(Type type) {
        while (!(type instanceof Class)) {
            if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                com.bykv.vk.openvk.preload.falconx.a.a.a(rawType instanceof Class);
                return (Class) rawType;
            }
            if (type instanceof GenericArrayType) {
                return Array.newInstance(b(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
            }
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                type = ((WildcardType) type).getUpperBounds()[0];
            } else {
                throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
            }
        }
        return (Class) type;
    }

    public static boolean a(Type type, Type type2) {
        while (type != type2) {
            if (type instanceof Class) {
                return type.equals(type2);
            }
            if (type instanceof ParameterizedType) {
                if (!(type2 instanceof ParameterizedType)) {
                    return false;
                }
                ParameterizedType parameterizedType = (ParameterizedType) type;
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Type ownerType = parameterizedType.getOwnerType();
                Type ownerType2 = parameterizedType2.getOwnerType();
                return (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
            }
            if (type instanceof GenericArrayType) {
                if (!(type2 instanceof GenericArrayType)) {
                    return false;
                }
                type = ((GenericArrayType) type).getGenericComponentType();
                type2 = ((GenericArrayType) type2).getGenericComponentType();
            } else {
                if (type instanceof WildcardType) {
                    if (!(type2 instanceof WildcardType)) {
                        return false;
                    }
                    WildcardType wildcardType = (WildcardType) type;
                    WildcardType wildcardType2 = (WildcardType) type2;
                    return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
                }
                if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
                    return false;
                }
                TypeVariable typeVariable = (TypeVariable) type;
                TypeVariable typeVariable2 = (TypeVariable) type2;
                return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
            }
        }
        return true;
    }

    static int a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static String c(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    private static Type a(Type type, Class<?> cls, Class<?> cls2) {
        Class<?> superclass;
        Type genericSuperclass;
        while (cls2 != cls) {
            if (cls2.isInterface()) {
                Class<?>[] interfaces = cls.getInterfaces();
                int length = interfaces.length;
                for (int i = 0; i < length; i++) {
                    Class<?> cls3 = interfaces[i];
                    if (cls3 == cls2) {
                        return cls.getGenericInterfaces()[i];
                    }
                    if (cls2.isAssignableFrom(cls3)) {
                        genericSuperclass = cls.getGenericInterfaces()[i];
                        superclass = interfaces[i];
                        break;
                    }
                }
            }
            if (!cls.isInterface()) {
                while (cls != Object.class) {
                    superclass = cls.getSuperclass();
                    if (superclass == cls2) {
                        return cls.getGenericSuperclass();
                    }
                    if (cls2.isAssignableFrom(superclass)) {
                        genericSuperclass = cls.getGenericSuperclass();
                        Type type2 = genericSuperclass;
                        cls = superclass;
                        type = type2;
                    } else {
                        cls = superclass;
                    }
                }
            }
            return cls2;
        }
        return type;
    }

    private static Type b(Type type, Class<?> cls, Class<?> cls2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        com.bykv.vk.openvk.preload.falconx.a.a.a(cls2.isAssignableFrom(cls));
        return a(type, cls, a(type, cls, cls2));
    }

    public static Type d(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return ((Class) type).getComponentType();
    }

    public static Type a(Type type, Class<?> cls) {
        Type b2 = b(type, cls, Collection.class);
        if (b2 instanceof WildcardType) {
            b2 = ((WildcardType) b2).getUpperBounds()[0];
        }
        if (b2 instanceof ParameterizedType) {
            return ((ParameterizedType) b2).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    public static Type[] b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type b2 = b(type, cls, Map.class);
        if (b2 instanceof ParameterizedType) {
            return ((ParameterizedType) b2).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    public static Type a(Type type, Class<?> cls, Type type2) {
        return a(type, cls, type2, new HashSet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r10v15, types: [java.lang.reflect.Type[]] */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.lang.reflect.Type] */
    private static Type a(Type type, Class<?> cls, Type type2, Collection<TypeVariable> collection) {
        Type a2;
        Type[] typeArr;
        Type[] typeArr2;
        TypeVariable typeVariable;
        do {
            int i = 0;
            if (type2 instanceof TypeVariable) {
                typeVariable = type2;
                if (!collection.contains(typeVariable)) {
                    collection.add(typeVariable);
                    GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
                    Class cls2 = genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
                    if (cls2 != null) {
                        Type a3 = a(type, cls, (Class<?>) cls2);
                        if (a3 instanceof ParameterizedType) {
                            TypeVariable[] typeParameters = cls2.getTypeParameters();
                            int length = typeParameters.length;
                            while (i < length) {
                                if (typeVariable.equals(typeParameters[i])) {
                                    type2 = ((ParameterizedType) a3).getActualTypeArguments()[i];
                                } else {
                                    i++;
                                }
                            }
                            throw new NoSuchElementException();
                        }
                    }
                    type2 = typeVariable;
                }
            } else {
                if (type2 instanceof Class) {
                    Class cls3 = type2;
                    if (cls3.isArray()) {
                        Class<?> componentType = cls3.getComponentType();
                        Type a4 = a(type, cls, componentType, collection);
                        return componentType == a4 ? cls3 : f(a4);
                    }
                }
                if (type2 instanceof GenericArrayType) {
                    GenericArrayType genericArrayType = (GenericArrayType) type2;
                    Type genericComponentType = genericArrayType.getGenericComponentType();
                    Type a5 = a(type, cls, genericComponentType, collection);
                    return genericComponentType == a5 ? genericArrayType : f(a5);
                }
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type2;
                    Type ownerType = parameterizedType.getOwnerType();
                    Type a6 = a(type, cls, ownerType, collection);
                    boolean z = a6 != ownerType;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    int length2 = actualTypeArguments.length;
                    while (i < length2) {
                        Type a7 = a(type, cls, actualTypeArguments[i], collection);
                        if (a7 != actualTypeArguments[i]) {
                            if (!z) {
                                actualTypeArguments = (Type[]) actualTypeArguments.clone();
                                z = true;
                            }
                            actualTypeArguments[i] = a7;
                        }
                        i++;
                    }
                    return z ? new b(a6, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
                }
                if (type2 instanceof WildcardType) {
                    type2 = (WildcardType) type2;
                    Type[] lowerBounds = type2.getLowerBounds();
                    Type[] upperBounds = type2.getUpperBounds();
                    if (lowerBounds.length == 1) {
                        Type a8 = a(type, cls, lowerBounds[0], collection);
                        if (a8 != lowerBounds[0]) {
                            if (a8 instanceof WildcardType) {
                                typeArr2 = ((WildcardType) a8).getLowerBounds();
                            } else {
                                typeArr2 = new Type[]{a8};
                            }
                            return new c(new Type[]{Object.class}, typeArr2);
                        }
                    } else if (upperBounds.length == 1 && (a2 = a(type, cls, upperBounds[0], collection)) != upperBounds[0]) {
                        if (a2 instanceof WildcardType) {
                            typeArr = ((WildcardType) a2).getUpperBounds();
                        } else {
                            typeArr = new Type[]{a2};
                        }
                        return new c(typeArr, f855a);
                    }
                }
            }
            return type2;
        } while (type2 != typeVariable);
        return type2;
    }

    static void e(Type type) {
        com.bykv.vk.openvk.preload.falconx.a.a.a(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }

    /* compiled from: $Gson$Types.java */
    static final class b implements Serializable, ParameterizedType {

        /* renamed from: a, reason: collision with root package name */
        private final Type f860a;
        private final Type b;
        private final Type[] c;

        public b(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z = true;
                boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z2) {
                    z = false;
                }
                com.bykv.vk.openvk.preload.falconx.a.a.a(z);
            }
            this.f860a = type == null ? null : a.a(type);
            this.b = a.a(type2);
            Type[] typeArr2 = (Type[]) typeArr.clone();
            this.c = typeArr2;
            int length = typeArr2.length;
            for (int i = 0; i < length; i++) {
                com.bykv.vk.openvk.preload.falconx.a.a.a(this.c[i]);
                a.e(this.c[i]);
                Type[] typeArr3 = this.c;
                typeArr3[i] = a.a(typeArr3[i]);
            }
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type[] getActualTypeArguments() {
            return (Type[]) this.c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getRawType() {
            return this.b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getOwnerType() {
            return this.f860a;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && a.a(this, (ParameterizedType) obj);
        }

        public final int hashCode() {
            return (Arrays.hashCode(this.c) ^ this.b.hashCode()) ^ a.a((Object) this.f860a);
        }

        public final String toString() {
            int length = this.c.length;
            if (length == 0) {
                return a.c(this.b);
            }
            StringBuilder sb = new StringBuilder((length + 1) * 30);
            sb.append(a.c(this.b)).append("<").append(a.c(this.c[0]));
            for (int i = 1; i < length; i++) {
                sb.append(", ").append(a.c(this.c[i]));
            }
            return sb.append(">").toString();
        }
    }

    /* compiled from: $Gson$Types.java */
    /* renamed from: com.bykv.vk.openvk.preload.a.b.a$a, reason: collision with other inner class name */
    static final class C0112a implements Serializable, GenericArrayType {

        /* renamed from: a, reason: collision with root package name */
        private final Type f857a;

        public C0112a(Type type) {
            this.f857a = a.a(type);
        }

        @Override // java.lang.reflect.GenericArrayType
        public final Type getGenericComponentType() {
            return this.f857a;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && a.a(this, (GenericArrayType) obj);
        }

        public final int hashCode() {
            return this.f857a.hashCode();
        }

        public final String toString() {
            return a.c(this.f857a) + "[]";
        }
    }

    /* compiled from: $Gson$Types.java */
    static final class c implements Serializable, WildcardType {

        /* renamed from: a, reason: collision with root package name */
        private final Type f863a;
        private final Type b;

        public c(Type[] typeArr, Type[] typeArr2) {
            com.bykv.vk.openvk.preload.falconx.a.a.a(typeArr2.length <= 1);
            com.bykv.vk.openvk.preload.falconx.a.a.a(typeArr.length == 1);
            if (typeArr2.length == 1) {
                com.bykv.vk.openvk.preload.falconx.a.a.a(typeArr2[0]);
                a.e(typeArr2[0]);
                com.bykv.vk.openvk.preload.falconx.a.a.a(typeArr[0] == Object.class);
                this.b = a.a(typeArr2[0]);
                this.f863a = Object.class;
                return;
            }
            com.bykv.vk.openvk.preload.falconx.a.a.a(typeArr[0]);
            a.e(typeArr[0]);
            this.b = null;
            this.f863a = a.a(typeArr[0]);
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getUpperBounds() {
            return new Type[]{this.f863a};
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getLowerBounds() {
            Type type = this.b;
            return type != null ? new Type[]{type} : a.f855a;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof WildcardType) && a.a(this, (WildcardType) obj);
        }

        public final int hashCode() {
            Type type = this.b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f863a.hashCode() + 31);
        }

        public final String toString() {
            if (this.b != null) {
                return "? super " + a.c(this.b);
            }
            if (this.f863a == Object.class) {
                return "?";
            }
            return "? extends " + a.c(this.f863a);
        }
    }
}
