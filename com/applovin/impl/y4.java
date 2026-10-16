package com.applovin.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import com.applovin.impl.b6;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes2.dex */
public final class y4 {
    private static com.applovin.impl.sdk.k b;
    private static SharedPreferences c;

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f804a;

    public y4(com.applovin.impl.sdk.k kVar) {
        this.f804a = com.applovin.impl.sdk.k.o().getSharedPreferences("com.applovin.sdk.preferences." + kVar.j0(), 0);
        b = kVar;
    }

    public void a(String str, Object obj, SharedPreferences.Editor editor) {
        a(str, obj, (SharedPreferences) null, editor);
    }

    public void b(x4 x4Var, Object obj) {
        b(x4Var, obj, this.f804a);
    }

    public void a(String str, Object obj, SharedPreferences sharedPreferences) {
        a(str, obj, sharedPreferences, (SharedPreferences.Editor) null);
    }

    public void b(x4 x4Var, Object obj, SharedPreferences sharedPreferences) {
        a(x4Var.a(), obj, sharedPreferences);
    }

    public static void a(String str, Object obj, SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
        boolean z = editor != null;
        if (!z) {
            editor = sharedPreferences.edit();
        }
        if (obj != null) {
            if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                editor.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Integer) {
                editor.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                editor.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                editor.putLong(str, Double.doubleToRawLongBits(((Double) obj).doubleValue()));
            } else if (obj instanceof String) {
                editor.putString(str, (String) obj);
            } else if (obj instanceof Set) {
                editor.putStringSet(str, (Set) obj);
            } else {
                com.applovin.impl.sdk.o.h("SharedPreferencesManager", "Unable to put default value of invalid type: " + obj);
                return;
            }
        } else {
            editor.remove(str);
        }
        if (z) {
            return;
        }
        a(editor);
    }

    public static void b(x4 x4Var, Object obj, Context context) {
        a(x4Var.a(), obj, a(context), (SharedPreferences.Editor) null);
    }

    public void b(x4 x4Var) {
        a(this.f804a.edit().remove(x4Var.a()));
    }

    public Object a(x4 x4Var, Object obj) {
        return a(x4Var, obj, this.f804a);
    }

    public Object a(x4 x4Var, Object obj, SharedPreferences sharedPreferences) {
        return a(x4Var.a(), obj, x4Var.b(), sharedPreferences);
    }

    public static Object a(x4 x4Var, Object obj, Context context) {
        return a(x4Var.a(), obj, x4Var.b(), a(context));
    }

    public static Object a(x4 x4Var, Object obj, SharedPreferences sharedPreferences, boolean z) {
        return a(x4Var.a(), obj, x4Var.b(), sharedPreferences, z);
    }

    public static Object a(String str, Object obj, Class cls, SharedPreferences sharedPreferences) {
        return a(str, obj, cls, sharedPreferences, true);
    }

    public static Object a(String str, Object obj, Class cls, SharedPreferences sharedPreferences, boolean z) {
        Object stringSet;
        long longValue;
        int intValue;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (!sharedPreferences.contains(str)) {
                return obj;
            }
            if (Boolean.class.equals(cls)) {
                if (obj != null) {
                    stringSet = Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
                } else {
                    stringSet = Boolean.valueOf(sharedPreferences.getBoolean(str, false));
                }
            } else if (Float.class.equals(cls)) {
                if (obj != null) {
                    stringSet = Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
                } else {
                    stringSet = Float.valueOf(sharedPreferences.getFloat(str, 0.0f));
                }
            } else if (Integer.class.equals(cls)) {
                if (obj != null) {
                    if (obj.getClass().equals(Long.class)) {
                        intValue = ((Long) obj).intValue();
                    } else {
                        intValue = ((Integer) obj).intValue();
                    }
                    stringSet = Integer.valueOf(sharedPreferences.getInt(str, intValue));
                } else {
                    stringSet = Integer.valueOf(sharedPreferences.getInt(str, 0));
                }
            } else if (Long.class.equals(cls)) {
                if (obj != null) {
                    if (obj.getClass().equals(Integer.class)) {
                        longValue = ((Integer) obj).longValue();
                    } else {
                        longValue = ((Long) obj).longValue();
                    }
                    stringSet = Long.valueOf(sharedPreferences.getLong(str, longValue));
                } else {
                    stringSet = Long.valueOf(sharedPreferences.getLong(str, 0L));
                }
            } else if (Double.class.equals(cls)) {
                if (obj != null) {
                    stringSet = Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong(str, Double.doubleToRawLongBits(((Double) obj).doubleValue()))));
                } else {
                    stringSet = Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong(str, 0L)));
                }
            } else if (String.class.equals(cls)) {
                stringSet = sharedPreferences.getString(str, (String) obj);
            } else {
                stringSet = Set.class.isAssignableFrom(cls) ? sharedPreferences.getStringSet(str, (Set) obj) : obj;
            }
            return stringSet != null ? cls.cast(stringSet) : obj;
        } catch (Throwable th) {
            if (z) {
                try {
                    com.applovin.impl.sdk.o.c("SharedPreferencesManager", "Error getting value for key: " + str, th);
                } finally {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                }
            }
            return obj;
        }
    }

    public Object a(x4 x4Var) {
        Object a2 = a(x4Var, null);
        b(x4Var);
        return a2;
    }

    public void a(SharedPreferences sharedPreferences) {
        a(sharedPreferences.edit().clear());
    }

    public static void a(final SharedPreferences.Editor editor) {
        try {
            if (k7.h()) {
                com.applovin.impl.sdk.k kVar = b;
                if (kVar != null && kVar.r0() != null) {
                    b6 r0 = b.r0();
                    com.applovin.impl.sdk.k kVar2 = b;
                    Objects.requireNonNull(editor);
                    r0.a((g5) new p6(kVar2, true, "commitSharedPreferencesChanges", new Runnable() { // from class: com.applovin.impl.y4$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            editor.commit();
                        }
                    }), b6.b.OTHER);
                    return;
                }
                editor.apply();
                return;
            }
            editor.commit();
        } catch (Throwable th) {
            com.applovin.impl.sdk.o.c("SharedPreferencesManager", "Unable to apply changes", th);
            try {
                b.E().a("SharedPreferencesManager", "persistChanges", th);
            } catch (Throwable unused) {
            }
        }
    }

    private static SharedPreferences a(Context context) {
        if (c == null) {
            c = context.getSharedPreferences("com.applovin.sdk.shared", 0);
        }
        return c;
    }
}
