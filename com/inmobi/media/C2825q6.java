package com.inmobi.media;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.q6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2825q6 {
    public static boolean b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f2681a = new HashMap();

    @JvmStatic
    public static final boolean a(JSONObject jSONObject, JSONObject jSONObject2) {
        return C2809p6.a(jSONObject, jSONObject2);
    }

    public static final /* synthetic */ String b() {
        return "q6";
    }

    @JvmStatic
    public static final void a(Object obj, Object obj2) {
        C2809p6.b(obj, obj2);
    }

    @JvmStatic
    public static final void b(boolean z) {
        b = z;
    }

    public final C2825q6 a(Ec key, Dc types) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(types, "types");
        this.f2681a.put(key, types);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x021d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0215 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JSONObject a(Object obj, Class cls) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        try {
            Class superclass = cls.getSuperclass();
            if (superclass == null || Intrinsics.areEqual(Object.class, superclass)) {
                jSONObject = null;
            } else {
                Class superclass2 = cls.getSuperclass();
                superclass2.getClass();
                Intrinsics.checkNotNull(superclass2);
                jSONObject = a(obj, superclass2);
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            Field[] declaredFields = cls.getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
            for (Field field : declaredFields) {
                field.setAccessible(true);
                if (field.get(obj) == null) {
                    field.getName();
                } else {
                    Class<?> type = field.getType();
                    if (!Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(Z4.class)) {
                        Intrinsics.checkNotNull(type);
                        if (Modifier.isStatic(cls.getModifiers()) || !Intrinsics.areEqual(cls.getEnclosingClass(), type)) {
                            String name = field.getName();
                            Class cls2 = Integer.TYPE;
                            if (!Intrinsics.areEqual(cls2, type) && !Intrinsics.areEqual(cls2, type) && !Intrinsics.areEqual(Integer.class, type)) {
                                Class cls3 = Boolean.TYPE;
                                if (!Intrinsics.areEqual(cls3, type) && !Intrinsics.areEqual(cls3, type) && !Intrinsics.areEqual(Boolean.class, type)) {
                                    Class cls4 = Double.TYPE;
                                    if (!Intrinsics.areEqual(cls4, type) && !Intrinsics.areEqual(cls4, type) && !Intrinsics.areEqual(Double.class, type)) {
                                        Class cls5 = Float.TYPE;
                                        if (!Intrinsics.areEqual(cls5, type) && !Intrinsics.areEqual(cls5, type) && !Intrinsics.areEqual(Float.class, type)) {
                                            Class cls6 = Long.TYPE;
                                            if (!Intrinsics.areEqual(cls6, type) && !Intrinsics.areEqual(cls6, type) && !Intrinsics.areEqual(Long.class, type)) {
                                                Class cls7 = Byte.TYPE;
                                                if (!Intrinsics.areEqual(cls7, type) && !Intrinsics.areEqual(cls7, type) && !Intrinsics.areEqual(Byte.class, type)) {
                                                    if (!Intrinsics.areEqual(String.class, type) && !Intrinsics.areEqual(JSONObject.class, type) && !Intrinsics.areEqual(JSONArray.class, type)) {
                                                        Class cls8 = Short.TYPE;
                                                        if (!Intrinsics.areEqual(cls8, type) && !Intrinsics.areEqual(cls8, type) && !Intrinsics.areEqual(Short.class, type)) {
                                                            if (Map.class.isAssignableFrom(type)) {
                                                                HashMap hashMap = this.f2681a;
                                                                Intrinsics.checkNotNull(name);
                                                                Dc dc = (Dc) hashMap.get(new Ec(name, cls));
                                                                if (dc instanceof C2826q7) {
                                                                    JSONObject jSONObject3 = new JSONObject();
                                                                    Object obj2 = field.get(obj);
                                                                    if (obj2 != null) {
                                                                        Map map = (Map) obj2;
                                                                        C2826q7 c2826q7 = (C2826q7) dc;
                                                                        for (Object obj3 : map.keySet()) {
                                                                            c2826q7.getClass();
                                                                            Intrinsics.checkNotNullParameter(map, "map");
                                                                            Object obj4 = map.get(obj3);
                                                                            if (obj4 != null) {
                                                                                if (!C2809p6.b(obj4.getClass()) && !C2809p6.a(obj4.getClass())) {
                                                                                    obj4 = a(obj4, (Class) obj4.getClass());
                                                                                }
                                                                                jSONObject3.put(obj3.toString(), obj4);
                                                                            }
                                                                        }
                                                                    }
                                                                    jSONObject.put(name, jSONObject3);
                                                                } else {
                                                                    type.getClass();
                                                                }
                                                            } else if (List.class.isAssignableFrom(type)) {
                                                                HashMap hashMap2 = this.f2681a;
                                                                Intrinsics.checkNotNull(name);
                                                                Object obj5 = hashMap2.get(new Ec(name, cls));
                                                                Intrinsics.checkNotNull(obj5);
                                                                if (((Dc) obj5) instanceof U6) {
                                                                    JSONArray jSONArray = new JSONArray();
                                                                    Object obj6 = field.get(obj);
                                                                    if (obj6 != null) {
                                                                        for (Object obj7 : (List) obj6) {
                                                                            if (obj7 != null) {
                                                                                if (!C2809p6.b(obj7.getClass()) && !C2809p6.a(obj7.getClass())) {
                                                                                    jSONObject2 = a(obj7, (Class) obj7.getClass());
                                                                                    if (jSONObject2 != null) {
                                                                                        obj7.getClass().toString();
                                                                                    } else {
                                                                                        jSONArray.put(jSONObject2);
                                                                                    }
                                                                                }
                                                                                jSONObject2 = obj7;
                                                                                if (jSONObject2 != null) {
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    jSONObject.put(name, jSONArray);
                                                                } else {
                                                                    type.getClass();
                                                                }
                                                            } else {
                                                                Object obj8 = field.get(obj);
                                                                if (obj8 != null) {
                                                                    jSONObject.put(name, a(obj8, (Class) obj8.getClass()));
                                                                } else {
                                                                    type.getClass();
                                                                }
                                                            }
                                                        }
                                                        Object obj9 = field.get(obj);
                                                        Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type kotlin.Short");
                                                        jSONObject.put(name, (Short) obj9);
                                                    }
                                                    jSONObject.put(name, field.get(obj));
                                                }
                                                Object obj10 = field.get(obj);
                                                Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type kotlin.Byte");
                                                jSONObject.put(name, (Byte) obj10);
                                            }
                                            Object obj11 = field.get(obj);
                                            Intrinsics.checkNotNull(obj11, "null cannot be cast to non-null type kotlin.Long");
                                            jSONObject.put(name, ((Long) obj11).longValue());
                                        }
                                        Object obj12 = field.get(obj);
                                        Intrinsics.checkNotNull(obj12, "null cannot be cast to non-null type kotlin.Float");
                                        jSONObject.put(name, (Float) obj12);
                                    }
                                    Object obj13 = field.get(obj);
                                    Intrinsics.checkNotNull(obj13, "null cannot be cast to non-null type kotlin.Double");
                                    jSONObject.put(name, ((Double) obj13).doubleValue());
                                }
                                Object obj14 = field.get(obj);
                                Intrinsics.checkNotNull(obj14, "null cannot be cast to non-null type kotlin.Boolean");
                                jSONObject.put(name, ((Boolean) obj14).booleanValue());
                            }
                            Object obj15 = field.get(obj);
                            Intrinsics.checkNotNull(obj15, "null cannot be cast to non-null type kotlin.Int");
                            jSONObject.put(name, ((Integer) obj15).intValue());
                        }
                    }
                }
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public final JSONObject a(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return a(obj, (Class) obj.getClass());
    }

    public final Object a(JSONObject jsonObject, Class<Object> type) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(type, "type");
        return type.cast(a(jsonObject, type, null, null));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:35|(7:42|(8:49|(7:56|(8:63|(2:70|(1:72)(8:73|(2:80|(3:82|(1:84)|85)(2:86|(1:88)(6:89|90|(3:128|129|(2:131|(4:133|(4:136|(2:138|139)(2:141|(2:143|144)(2:145|146))|140|134)|147|148)(3:149|150|16))(1:151))(2:92|(2:94|(4:98|(4:100|(1:102)(2:109|(1:111)(1:112))|(2:104|105)(2:107|108)|106)|113|114))(2:117|(6:119|120|121|122|123|16)))|115|116|16)))|155|156|157|158|(2:160|161)(2:162|163)|16))|167|168|169|170|(2:172|173)(2:174|175)|16)|179|180|181|(2:183|184)(2:185|186)|16)|190|191|192|193|(2:195|196)(2:197|198)|16)|202|203|204|(2:206|207)(2:208|209)|16)|213|214|215|216|217|218|(2:220|221)(2:222|223)|16) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:28|(10:35|(7:42|(8:49|(7:56|(8:63|(2:70|(1:72)(8:73|(2:80|(3:82|(1:84)|85)(2:86|(1:88)(6:89|90|(3:128|129|(2:131|(4:133|(4:136|(2:138|139)(2:141|(2:143|144)(2:145|146))|140|134)|147|148)(3:149|150|16))(1:151))(2:92|(2:94|(4:98|(4:100|(1:102)(2:109|(1:111)(1:112))|(2:104|105)(2:107|108)|106)|113|114))(2:117|(6:119|120|121|122|123|16)))|115|116|16)))|155|156|157|158|(2:160|161)(2:162|163)|16))|167|168|169|170|(2:172|173)(2:174|175)|16)|179|180|181|(2:183|184)(2:185|186)|16)|190|191|192|193|(2:195|196)(2:197|198)|16)|202|203|204|(2:206|207)(2:208|209)|16)|213|214|215|216|217|218|(2:220|221)(2:222|223)|16)|232|233|234|(2:236|237)(2:238|239)|16) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:42|(8:49|(7:56|(8:63|(2:70|(1:72)(8:73|(2:80|(3:82|(1:84)|85)(2:86|(1:88)(6:89|90|(3:128|129|(2:131|(4:133|(4:136|(2:138|139)(2:141|(2:143|144)(2:145|146))|140|134)|147|148)(3:149|150|16))(1:151))(2:92|(2:94|(4:98|(4:100|(1:102)(2:109|(1:111)(1:112))|(2:104|105)(2:107|108)|106)|113|114))(2:117|(6:119|120|121|122|123|16)))|115|116|16)))|155|156|157|158|(2:160|161)(2:162|163)|16))|167|168|169|170|(2:172|173)(2:174|175)|16)|179|180|181|(2:183|184)(2:185|186)|16)|190|191|192|193|(2:195|196)(2:197|198)|16)|202|203|204|(2:206|207)(2:208|209)|16) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:56|(8:63|(2:70|(1:72)(8:73|(2:80|(3:82|(1:84)|85)(2:86|(1:88)(6:89|90|(3:128|129|(2:131|(4:133|(4:136|(2:138|139)(2:141|(2:143|144)(2:145|146))|140|134)|147|148)(3:149|150|16))(1:151))(2:92|(2:94|(4:98|(4:100|(1:102)(2:109|(1:111)(1:112))|(2:104|105)(2:107|108)|106)|113|114))(2:117|(6:119|120|121|122|123|16)))|115|116|16)))|155|156|157|158|(2:160|161)(2:162|163)|16))|167|168|169|170|(2:172|173)(2:174|175)|16)|179|180|181|(2:183|184)(2:185|186)|16) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:49|(7:56|(8:63|(2:70|(1:72)(8:73|(2:80|(3:82|(1:84)|85)(2:86|(1:88)(6:89|90|(3:128|129|(2:131|(4:133|(4:136|(2:138|139)(2:141|(2:143|144)(2:145|146))|140|134)|147|148)(3:149|150|16))(1:151))(2:92|(2:94|(4:98|(4:100|(1:102)(2:109|(1:111)(1:112))|(2:104|105)(2:107|108)|106)|113|114))(2:117|(6:119|120|121|122|123|16)))|115|116|16)))|155|156|157|158|(2:160|161)(2:162|163)|16))|167|168|169|170|(2:172|173)(2:174|175)|16)|179|180|181|(2:183|184)(2:185|186)|16)|190|191|192|193|(2:195|196)(2:197|198)|16) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:63|(2:70|(1:72)(8:73|(2:80|(3:82|(1:84)|85)(2:86|(1:88)(6:89|90|(3:128|129|(2:131|(4:133|(4:136|(2:138|139)(2:141|(2:143|144)(2:145|146))|140|134)|147|148)(3:149|150|16))(1:151))(2:92|(2:94|(4:98|(4:100|(1:102)(2:109|(1:111)(1:112))|(2:104|105)(2:107|108)|106)|113|114))(2:117|(6:119|120|121|122|123|16)))|115|116|16)))|155|156|157|158|(2:160|161)(2:162|163)|16))|167|168|169|170|(2:172|173)(2:174|175)|16) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:73|(2:80|(3:82|(1:84)|85)(2:86|(1:88)(6:89|90|(3:128|129|(2:131|(4:133|(4:136|(2:138|139)(2:141|(2:143|144)(2:145|146))|140|134)|147|148)(3:149|150|16))(1:151))(2:92|(2:94|(4:98|(4:100|(1:102)(2:109|(1:111)(1:112))|(2:104|105)(2:107|108)|106)|113|114))(2:117|(6:119|120|121|122|123|16)))|115|116|16)))|155|156|157|158|(2:160|161)(2:162|163)|16) */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0376, code lost:
    
        r10.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x03a4, code lost:
    
        r10.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x03d1, code lost:
    
        r10.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x03ff, code lost:
    
        r10.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x042c, code lost:
    
        r10.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x045d, code lost:
    
        r10.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0444, code lost:
    
        if (r19.getInt(r3) != 0) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0446, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0448, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0487, code lost:
    
        r10.getName();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(JSONObject jSONObject, Class cls, Object obj, Object obj2) {
        Object obj3;
        Object newInstance;
        Object obj4;
        Field[] fieldArr;
        JSONArray optJSONArray;
        Object obj5 = null;
        try {
            cls.getClass();
            cls.toString();
            Objects.toString(obj);
            boolean z = true;
            if (obj2 == null) {
                try {
                    Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
                    Intrinsics.checkNotNull(declaredConstructors);
                    if (declaredConstructors.length == 0) {
                        newInstance = cls.newInstance();
                    } else {
                        Constructor<?> constructor = declaredConstructors[0];
                        constructor.setAccessible(true);
                        int length = constructor.getParameterTypes().length;
                        if (length == 0) {
                            newInstance = constructor.newInstance(null);
                        } else {
                            Object[] objArr = new Object[length];
                            Class<?>[] parameterTypes = constructor.getParameterTypes();
                            Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
                            int length2 = parameterTypes.length;
                            int i = 0;
                            int i2 = 0;
                            while (i < length2) {
                                Class<?> cls2 = parameterTypes[i];
                                int i3 = i2 + 1;
                                Intrinsics.checkNotNull(cls2);
                                if (!Intrinsics.areEqual(Integer.TYPE, cls2) && !Intrinsics.areEqual(Long.TYPE, cls2)) {
                                    if (Intrinsics.areEqual(Boolean.TYPE, cls2)) {
                                        obj4 = Boolean.FALSE;
                                    } else {
                                        if (!Intrinsics.areEqual(Double.TYPE, cls2) && !Intrinsics.areEqual(Float.TYPE, cls2)) {
                                            obj4 = null;
                                        }
                                        obj4 = Double.valueOf(0.0d);
                                    }
                                    objArr[i2] = obj4;
                                    i++;
                                    i2 = i3;
                                }
                                obj4 = 0;
                                objArr[i2] = obj4;
                                i++;
                                i2 = i3;
                            }
                            newInstance = constructor.newInstance(Arrays.copyOf(objArr, length));
                        }
                    }
                } catch (Exception unused) {
                    cls.toString();
                    return null;
                }
            } else {
                newInstance = obj2;
            }
            if (cls.getSuperclass() != null) {
                Class superclass = cls.getSuperclass();
                superclass.getClass();
                Intrinsics.checkNotNull(superclass);
                newInstance = a(jSONObject, superclass, obj, newInstance);
            }
            Field[] declaredFields = cls.getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
            int length3 = declaredFields.length;
            int i4 = 0;
            while (i4 < length3) {
                Field field = declaredFields[i4];
                field.setAccessible(z);
                String name = field.getName();
                if (!Intrinsics.areEqual(name, "shadow$_klass_") && !Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(Z4.class)) {
                    if (jSONObject.has(name) && !jSONObject.isNull(name)) {
                        Class<?> type = field.getType();
                        Class<?> cls3 = Integer.TYPE;
                        if (!Intrinsics.areEqual(cls3, type) && !Intrinsics.areEqual(cls3, type) && !Intrinsics.areEqual(Integer.class, type)) {
                            Class cls4 = Boolean.TYPE;
                            if (!Intrinsics.areEqual(cls4, type) && !Intrinsics.areEqual(cls4, type) && !Intrinsics.areEqual(Boolean.class, type)) {
                                Class<?> cls5 = Double.TYPE;
                                if (!Intrinsics.areEqual(cls5, type) && !Intrinsics.areEqual(cls5, type) && !Intrinsics.areEqual(Double.class, type)) {
                                    Class<?> cls6 = Float.TYPE;
                                    if (!Intrinsics.areEqual(cls6, type) && !Intrinsics.areEqual(cls6, type) && !Intrinsics.areEqual(Float.class, type)) {
                                        Class<?> cls7 = Long.TYPE;
                                        if (!Intrinsics.areEqual(cls7, type) && !Intrinsics.areEqual(cls7, type) && !Intrinsics.areEqual(Long.class, type)) {
                                            Class<?> cls8 = Byte.TYPE;
                                            if (!Intrinsics.areEqual(cls8, type) && !Intrinsics.areEqual(cls8, type) && !Intrinsics.areEqual(Byte.class, type)) {
                                                if (Intrinsics.areEqual(String.class, type)) {
                                                    field.set(newInstance, jSONObject.getString(name));
                                                } else {
                                                    Class<?> cls9 = Short.TYPE;
                                                    if (!Intrinsics.areEqual(cls9, type) && !Intrinsics.areEqual(cls9, type) && !Intrinsics.areEqual(Short.class, type)) {
                                                        if (Intrinsics.areEqual(JSONObject.class, type)) {
                                                            Intrinsics.checkNotNull(field);
                                                            JSONObject jSONObject2 = jSONObject.getJSONObject(field.getName());
                                                            JSONObject jSONObject3 = new JSONObject();
                                                            Intrinsics.checkNotNullParameter(field, "<this>");
                                                            if (jSONObject2 == null) {
                                                                jSONObject2 = jSONObject3;
                                                            }
                                                            field.set(newInstance, jSONObject2);
                                                        } else if (Intrinsics.areEqual(JSONArray.class, type)) {
                                                            field.set(newInstance, jSONObject.getJSONArray(name));
                                                        } else {
                                                            if (Map.class.isAssignableFrom(type)) {
                                                                try {
                                                                    HashMap hashMap = this.f2681a;
                                                                    Intrinsics.checkNotNull(name);
                                                                    Dc dc = (Dc) hashMap.get(new Ec(name, cls));
                                                                    if (dc instanceof C2826q7) {
                                                                        JSONObject optJSONObject = jSONObject.optJSONObject(name);
                                                                        C2826q7 c2826q7 = (C2826q7) dc;
                                                                        if (optJSONObject != null) {
                                                                            optJSONObject.toString();
                                                                            Map map = (Map) ((C2826q7) dc).a().construct();
                                                                            Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.Any, kotlin.Any?>");
                                                                            Map map2 = TypeIntrinsics.asMutableMap(map);
                                                                            Iterator<String> keys = optJSONObject.keys();
                                                                            while (keys.hasNext()) {
                                                                                String next = keys.next();
                                                                                Intrinsics.checkNotNull(next);
                                                                                Dc dc2 = dc;
                                                                                Object a2 = C2809p6.a(optJSONObject, next, ((C2826q7) dc2).b);
                                                                                Field[] fieldArr2 = declaredFields;
                                                                                if (C2809p6.b(((C2826q7) dc2).b)) {
                                                                                    a2 = ((C2826q7) dc2).b.cast(a2);
                                                                                } else if (!C2809p6.a(((C2826q7) dc2).b)) {
                                                                                    JSONObject jSONObject4 = optJSONObject.getJSONObject(next);
                                                                                    Intrinsics.checkNotNullExpressionValue(jSONObject4, "getJSONObject(...)");
                                                                                    Class<Object> cls10 = c2826q7.b;
                                                                                    Intrinsics.checkNotNull(cls10, "null cannot be cast to non-null type java.lang.Class<T of com.inmobi.commons.utils.json.JSONConverter>");
                                                                                    a2 = a(jSONObject4, cls10);
                                                                                }
                                                                                c2826q7.getClass();
                                                                                Intrinsics.checkNotNullParameter(map2, "map");
                                                                                map2.put(next, a2);
                                                                                dc = dc2;
                                                                                declaredFields = fieldArr2;
                                                                            }
                                                                            fieldArr = declaredFields;
                                                                            field.set(newInstance, map2);
                                                                        } else {
                                                                            fieldArr = declaredFields;
                                                                            obj3 = obj5;
                                                                            i4++;
                                                                            declaredFields = fieldArr;
                                                                            obj5 = obj3;
                                                                            z = true;
                                                                        }
                                                                    } else {
                                                                        fieldArr = declaredFields;
                                                                        type.getClass();
                                                                    }
                                                                } catch (Exception e) {
                                                                    e = e;
                                                                    obj3 = null;
                                                                    Log.getStackTraceString(e);
                                                                    return obj3;
                                                                }
                                                            } else {
                                                                fieldArr = declaredFields;
                                                                if (List.class.isAssignableFrom(type)) {
                                                                    HashMap hashMap2 = this.f2681a;
                                                                    Intrinsics.checkNotNull(name);
                                                                    Dc dc3 = (Dc) hashMap2.get(new Ec(name, cls));
                                                                    if ((dc3 instanceof U6) && (optJSONArray = jSONObject.optJSONArray(name)) != null) {
                                                                        List<Object> b2 = ((U6) dc3).b();
                                                                        Intrinsics.checkNotNull(b2, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any?>");
                                                                        List asMutableList = TypeIntrinsics.asMutableList(b2);
                                                                        int length4 = optJSONArray.length();
                                                                        for (int i5 = 0; i5 < length4; i5++) {
                                                                            Object a3 = C2809p6.a(optJSONArray, i5, ((U6) dc3).c());
                                                                            if (C2809p6.b(a3.getClass())) {
                                                                                a3 = ((U6) dc3).c().cast(a3);
                                                                            } else if (!C2809p6.a(a3.getClass())) {
                                                                                JSONObject jSONObject5 = optJSONArray.getJSONObject(i5);
                                                                                Intrinsics.checkNotNullExpressionValue(jSONObject5, "getJSONObject(...)");
                                                                                Class<Object> c = ((U6) dc3).c();
                                                                                Intrinsics.checkNotNull(c, "null cannot be cast to non-null type java.lang.Class<T of com.inmobi.commons.utils.json.JSONConverter>");
                                                                                a3 = a(jSONObject5, c);
                                                                            }
                                                                            if (a3 != null) {
                                                                                asMutableList.add(a3);
                                                                            }
                                                                        }
                                                                        field.set(newInstance, asMutableList);
                                                                    }
                                                                } else {
                                                                    JSONObject optJSONObject2 = jSONObject.optJSONObject(name);
                                                                    if (optJSONObject2 != null) {
                                                                        Objects.toString(newInstance);
                                                                        Intrinsics.checkNotNull(type);
                                                                        obj3 = null;
                                                                        try {
                                                                            field.set(newInstance, a(optJSONObject2, type, newInstance, null));
                                                                            i4++;
                                                                            declaredFields = fieldArr;
                                                                            obj5 = obj3;
                                                                            z = true;
                                                                        } catch (Exception e2) {
                                                                            e = e2;
                                                                            Log.getStackTraceString(e);
                                                                            return obj3;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            obj3 = null;
                                                            i4++;
                                                            declaredFields = fieldArr;
                                                            obj5 = obj3;
                                                            z = true;
                                                        }
                                                    }
                                                    obj3 = obj5;
                                                    fieldArr = declaredFields;
                                                    Intrinsics.checkNotNull(field);
                                                    short s = (short) jSONObject.getInt(field.getName());
                                                    if (field.getType() == cls9) {
                                                        field.getName();
                                                        field.setShort(newInstance, s);
                                                    } else {
                                                        field.getName();
                                                        field.set(newInstance, Short.valueOf(s));
                                                    }
                                                    i4++;
                                                    declaredFields = fieldArr;
                                                    obj5 = obj3;
                                                    z = true;
                                                }
                                            }
                                            obj3 = obj5;
                                            fieldArr = declaredFields;
                                            Intrinsics.checkNotNull(field);
                                            byte b3 = (byte) jSONObject.getInt(field.getName());
                                            if (field.getType() == cls8) {
                                                field.getName();
                                                field.setByte(newInstance, b3);
                                            } else {
                                                field.getName();
                                                field.set(newInstance, Byte.valueOf(b3));
                                            }
                                            i4++;
                                            declaredFields = fieldArr;
                                            obj5 = obj3;
                                            z = true;
                                        }
                                        obj3 = obj5;
                                        fieldArr = declaredFields;
                                        Intrinsics.checkNotNull(field);
                                        long j = jSONObject.getLong(field.getName());
                                        if (field.getType() == cls7) {
                                            field.getName();
                                            field.setLong(newInstance, j);
                                        } else {
                                            field.getName();
                                            field.set(newInstance, Long.valueOf(j));
                                        }
                                        i4++;
                                        declaredFields = fieldArr;
                                        obj5 = obj3;
                                        z = true;
                                    }
                                    obj3 = obj5;
                                    fieldArr = declaredFields;
                                    Intrinsics.checkNotNull(field);
                                    float f = (float) jSONObject.getDouble(field.getName());
                                    if (field.getType() == cls6) {
                                        field.getName();
                                        field.setFloat(newInstance, f);
                                    } else {
                                        field.getName();
                                        field.set(newInstance, Float.valueOf(f));
                                    }
                                    i4++;
                                    declaredFields = fieldArr;
                                    obj5 = obj3;
                                    z = true;
                                }
                                obj3 = obj5;
                                fieldArr = declaredFields;
                                Intrinsics.checkNotNull(field);
                                double d = jSONObject.getDouble(field.getName());
                                if (field.getType() == cls5) {
                                    field.getName();
                                    field.setDouble(newInstance, d);
                                } else {
                                    field.getName();
                                    field.set(newInstance, Double.valueOf(d));
                                }
                                i4++;
                                declaredFields = fieldArr;
                                obj5 = obj3;
                                z = true;
                            }
                            obj3 = obj5;
                            fieldArr = declaredFields;
                            Intrinsics.checkNotNull(field);
                            String name2 = field.getName();
                            boolean z2 = jSONObject.getBoolean(name2);
                            Boolean valueOf = Boolean.valueOf(z2);
                            if (field.getType() == Boolean.TYPE) {
                                field.setBoolean(newInstance, z2);
                            } else {
                                field.set(newInstance, valueOf);
                            }
                            i4++;
                            declaredFields = fieldArr;
                            obj5 = obj3;
                            z = true;
                        }
                        obj3 = obj5;
                        fieldArr = declaredFields;
                        Intrinsics.checkNotNull(field);
                        int i6 = jSONObject.getInt(field.getName());
                        if (field.getType() == cls3) {
                            field.getName();
                            field.setInt(newInstance, i6);
                        } else {
                            field.getName();
                            field.set(newInstance, Integer.valueOf(i6));
                        }
                        i4++;
                        declaredFields = fieldArr;
                        obj5 = obj3;
                        z = true;
                    }
                    obj3 = obj5;
                    fieldArr = declaredFields;
                    if (field.isAnnotationPresent(U9.class)) {
                        throw new JSONException("NonNullable field " + name + " is not present or null in the JSONObject");
                    }
                    i4++;
                    declaredFields = fieldArr;
                    obj5 = obj3;
                    z = true;
                }
                obj3 = obj5;
                fieldArr = declaredFields;
                i4++;
                declaredFields = fieldArr;
                obj5 = obj3;
                z = true;
            }
            return newInstance;
        } catch (Exception e3) {
            e = e3;
            obj3 = null;
            Log.getStackTraceString(e);
            return obj3;
        }
    }
}
