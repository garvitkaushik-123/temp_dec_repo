package com.inmobi.media;

import java.lang.reflect.Field;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.p6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2809p6 {
    public static boolean a(Object obj, Object obj2) {
        if (!Intrinsics.areEqual(obj.getClass(), obj2.getClass())) {
            if (Intrinsics.areEqual(obj.getClass(), Integer.class) && Intrinsics.areEqual(obj2.getClass(), Long.class)) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) obj).intValue();
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
                return intValue == ((int) ((Long) obj2).longValue());
            }
            if (Intrinsics.areEqual(obj.getClass(), Long.class) && Intrinsics.areEqual(obj2.getClass(), Integer.class)) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                int longValue = (int) ((Long) obj).longValue();
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                return longValue == ((Integer) obj2).intValue();
            }
            if (Intrinsics.areEqual(obj.getClass(), Integer.class) && Intrinsics.areEqual(obj2.getClass(), Byte.class)) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                int intValue2 = ((Integer) obj).intValue();
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Byte");
                return intValue2 == ((Byte) obj2).byteValue();
            }
            if (!Intrinsics.areEqual(obj.getClass(), Byte.class) || !Intrinsics.areEqual(obj2.getClass(), Integer.class)) {
                return Intrinsics.areEqual(obj, obj2);
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Byte");
            byte byteValue = ((Byte) obj).byteValue();
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            return byteValue == ((Integer) obj2).intValue();
        }
        Class<?> cls = obj.getClass();
        if (Intrinsics.areEqual(cls, Integer.TYPE)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            int intValue3 = ((Integer) obj).intValue();
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            return intValue3 == ((Integer) obj2).intValue();
        }
        if (Intrinsics.areEqual(cls, Long.TYPE)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            long longValue2 = ((Long) obj).longValue();
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
            return longValue2 == ((Long) obj2).longValue();
        }
        if (Intrinsics.areEqual(cls, Boolean.TYPE)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            boolean booleanValue = ((Boolean) obj).booleanValue();
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            return booleanValue == ((Boolean) obj2).booleanValue();
        }
        if (Intrinsics.areEqual(cls, Double.TYPE)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Double");
            double doubleValue = ((Double) obj).doubleValue();
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Double");
            return doubleValue == ((Double) obj2).doubleValue();
        }
        if (Intrinsics.areEqual(cls, Byte.TYPE)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Byte");
            byte byteValue2 = ((Byte) obj).byteValue();
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Byte");
            return byteValue2 == ((Byte) obj2).byteValue();
        }
        if (!Intrinsics.areEqual(cls, Short.TYPE)) {
            return Intrinsics.areEqual(obj, obj2);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Short");
        short shortValue = ((Short) obj).shortValue();
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Short");
        return shortValue == ((Short) obj2).shortValue();
    }

    public static final boolean b(Class cls) {
        Class cls2 = Integer.TYPE;
        if (Intrinsics.areEqual(cls2, cls) || Intrinsics.areEqual(cls2, cls)) {
            return true;
        }
        Class cls3 = Boolean.TYPE;
        if (Intrinsics.areEqual(cls3, cls) || Intrinsics.areEqual(cls3, cls)) {
            return true;
        }
        Class cls4 = Double.TYPE;
        if (Intrinsics.areEqual(cls4, cls) || Intrinsics.areEqual(cls4, cls)) {
            return true;
        }
        Class cls5 = Float.TYPE;
        if (Intrinsics.areEqual(cls5, cls) || Intrinsics.areEqual(cls5, cls)) {
            return true;
        }
        Class cls6 = Long.TYPE;
        if (Intrinsics.areEqual(cls6, cls) || Intrinsics.areEqual(cls6, cls) || Intrinsics.areEqual(String.class, cls)) {
            return true;
        }
        Class cls7 = Byte.TYPE;
        if (Intrinsics.areEqual(cls7, cls) || Intrinsics.areEqual(cls7, cls)) {
            return true;
        }
        Class cls8 = Short.TYPE;
        return Intrinsics.areEqual(cls8, cls) || Intrinsics.areEqual(cls8, cls);
    }

    public static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray.length() != jSONArray2.length()) {
            return false;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                Object obj = jSONArray.get(i);
                Object obj2 = jSONArray2.get(i);
                if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
                    if (!a((JSONObject) obj, (JSONObject) obj2)) {
                        return false;
                    }
                } else if ((obj instanceof JSONArray) && (obj2 instanceof JSONArray)) {
                    if (!a((JSONArray) obj, (JSONArray) obj2)) {
                        return false;
                    }
                } else {
                    Intrinsics.checkNotNull(obj);
                    Intrinsics.checkNotNull(obj2);
                    if (!a(obj, obj2)) {
                        return false;
                    }
                }
            } catch (JSONException unused) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(JSONObject json1, JSONObject json2) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(json1, "json1");
        Intrinsics.checkNotNullParameter(json2, "json2");
        if (json1.length() != json2.length()) {
            return false;
        }
        Iterator<String> keys = json1.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                obj = json1.get(next);
                obj2 = json2.get(next);
            } catch (JSONException unused) {
            }
            if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
                if (!a((JSONObject) obj, (JSONObject) obj2)) {
                    return false;
                }
            } else if ((obj instanceof JSONArray) && (obj2 instanceof JSONArray)) {
                if (!a((JSONArray) obj, (JSONArray) obj2)) {
                    return false;
                }
            } else {
                Intrinsics.checkNotNull(obj);
                Intrinsics.checkNotNull(obj2);
                if (!a(obj, obj2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final boolean a(Class cls) {
        return Intrinsics.areEqual(Integer.class, cls) || Intrinsics.areEqual(Boolean.class, cls) || Intrinsics.areEqual(Double.class, cls) || Intrinsics.areEqual(Float.class, cls) || Intrinsics.areEqual(Long.class, cls) || Intrinsics.areEqual(String.class, cls) || Intrinsics.areEqual(Byte.class, cls) || Intrinsics.areEqual(Short.class, cls);
    }

    public static final Object a(JSONArray jSONArray, int i, Class cls) {
        Object obj;
        if (Intrinsics.areEqual(Integer.TYPE, cls)) {
            obj = Integer.valueOf(jSONArray.getInt(i));
        } else if (Intrinsics.areEqual(Double.TYPE, cls)) {
            obj = Double.valueOf(jSONArray.getDouble(i));
        } else if (Intrinsics.areEqual(Float.TYPE, cls)) {
            obj = Float.valueOf((float) jSONArray.getDouble(i));
        } else if (Intrinsics.areEqual(Long.TYPE, cls)) {
            obj = Long.valueOf(jSONArray.getLong(i));
        } else if (Intrinsics.areEqual(Byte.TYPE, cls)) {
            obj = Byte.valueOf((byte) jSONArray.getInt(i));
        } else if (Intrinsics.areEqual(Short.TYPE, cls)) {
            obj = Short.valueOf((short) jSONArray.getInt(i));
        } else {
            obj = jSONArray.get(i);
        }
        Intrinsics.checkNotNull(obj);
        return obj;
    }

    public static final Object a(JSONObject jSONObject, String str, Class cls) {
        Object obj;
        if (Intrinsics.areEqual(Integer.TYPE, cls)) {
            obj = Integer.valueOf(jSONObject.getInt(str));
        } else if (Intrinsics.areEqual(Double.TYPE, cls)) {
            obj = Double.valueOf(jSONObject.getDouble(str));
        } else if (Intrinsics.areEqual(Float.TYPE, cls)) {
            obj = Float.valueOf((float) jSONObject.getDouble(str));
        } else if (Intrinsics.areEqual(Long.TYPE, cls)) {
            obj = Long.valueOf(jSONObject.getLong(str));
        } else if (Intrinsics.areEqual(Byte.TYPE, cls)) {
            obj = Byte.valueOf((byte) jSONObject.getInt(str));
        } else if (Intrinsics.areEqual(Short.TYPE, cls)) {
            obj = Short.valueOf((short) jSONObject.getInt(str));
        } else {
            obj = jSONObject.get(str);
        }
        Intrinsics.checkNotNull(obj);
        return obj;
    }

    public static void b(Object copyFrom, Object copyTo) {
        Intrinsics.checkNotNullParameter(copyFrom, "copyFrom");
        Intrinsics.checkNotNullParameter(copyTo, "copyTo");
        Class<?> cls = copyFrom.getClass();
        if (cls.isAssignableFrom(copyTo.getClass())) {
            Object cast = cls.cast(copyTo);
            Intrinsics.checkNotNullExpressionValue(cast, "cast(...)");
            Field[] declaredFields = cls.getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
            for (Field field : declaredFields) {
                try {
                    field.setAccessible(true);
                    field.set(cast, field.get(copyFrom));
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }
}
