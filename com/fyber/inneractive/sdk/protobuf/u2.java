package com.fyber.inneractive.sdk.protobuf;

import java.util.AbstractList;
import java.util.List;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public abstract class u2 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f1702a;
    public static final o3 b;
    public static final o3 c;
    public static final o3 d;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        f1702a = cls;
        b = a(false);
        c = a(true);
        d = new o3();
    }

    public static Object a(int i, List list, Object obj, o3 o3Var) {
        return obj;
    }

    public static void a(int i, List list, c0 c0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c0Var.getClass();
            while (i2 < list.size()) {
                c0Var.f1662a.a(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        c0Var.f1662a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).getClass();
            Logger logger = b0.b;
            i3++;
        }
        c0Var.f1662a.g(i3);
        while (i2 < list.size()) {
            c0Var.f1662a.a(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public static void b(int i, List list, c0 c0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c0Var.getClass();
            while (i2 < list.size()) {
                b0 b0Var = c0Var.f1662a;
                double doubleValue = ((Double) list.get(i2)).doubleValue();
                b0Var.getClass();
                b0Var.a(i, Double.doubleToRawLongBits(doubleValue));
                i2++;
            }
            return;
        }
        c0Var.f1662a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).getClass();
            Logger logger = b0.b;
            i3 += 8;
        }
        c0Var.f1662a.g(i3);
        while (i2 < list.size()) {
            b0 b0Var2 = c0Var.f1662a;
            double doubleValue2 = ((Double) list.get(i2)).doubleValue();
            b0Var2.getClass();
            b0Var2.c(Double.doubleToRawLongBits(doubleValue2));
            i2++;
        }
    }

    public static void c(int i, List list, c0 c0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c0Var.getClass();
            while (i2 < list.size()) {
                c0Var.f1662a.b(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        c0Var.f1662a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += b0.a(((Integer) list.get(i4)).intValue());
        }
        c0Var.f1662a.g(i3);
        while (i2 < list.size()) {
            c0Var.f1662a.f(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void d(int i, List list, c0 c0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c0Var.getClass();
            while (i2 < list.size()) {
                c0Var.f1662a.a(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        c0Var.f1662a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            Logger logger = b0.b;
            i3 += 4;
        }
        c0Var.f1662a.g(i3);
        while (i2 < list.size()) {
            c0Var.f1662a.e(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void e(int i, List list, c0 c0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c0Var.getClass();
            while (i2 < list.size()) {
                c0Var.f1662a.a(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        c0Var.f1662a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            Logger logger = b0.b;
            i3 += 8;
        }
        c0Var.f1662a.g(i3);
        while (i2 < list.size()) {
            c0Var.f1662a.c(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void f(int i, List list, c0 c0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c0Var.getClass();
            while (i2 < list.size()) {
                b0 b0Var = c0Var.f1662a;
                float floatValue = ((Float) list.get(i2)).floatValue();
                b0Var.getClass();
                b0Var.a(i, Float.floatToRawIntBits(floatValue));
                i2++;
            }
            return;
        }
        c0Var.f1662a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).getClass();
            Logger logger = b0.b;
            i3 += 4;
        }
        c0Var.f1662a.g(i3);
        while (i2 < list.size()) {
            b0 b0Var2 = c0Var.f1662a;
            float floatValue2 = ((Float) list.get(i2)).floatValue();
            b0Var2.getClass();
            b0Var2.e(Float.floatToRawIntBits(floatValue2));
            i2++;
        }
    }

    public static void g(int i, List list, c0 c0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c0Var.getClass();
            while (i2 < list.size()) {
                c0Var.f1662a.b(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        c0Var.f1662a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            int intValue = ((Integer) list.get(i4)).intValue();
            i3 += intValue >= 0 ? b0.c(intValue) : 10;
        }
        c0Var.f1662a.g(i3);
        while (i2 < list.size()) {
            c0Var.f1662a.f(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void h(int i, List list, c0 c0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c0Var.getClass();
            while (i2 < list.size()) {
                c0Var.f1662a.b(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        c0Var.f1662a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += b0.a(((Long) list.get(i4)).longValue());
        }
        c0Var.f1662a.g(i3);
        while (i2 < list.size()) {
            c0Var.f1662a.d(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void i(int i, List list, c0 c0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c0Var.getClass();
            while (i2 < list.size()) {
                c0Var.f1662a.a(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        c0Var.f1662a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            Logger logger = b0.b;
            i3 += 4;
        }
        c0Var.f1662a.g(i3);
        while (i2 < list.size()) {
            c0Var.f1662a.e(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void j(int i, List list, c0 c0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c0Var.getClass();
            while (i2 < list.size()) {
                c0Var.f1662a.a(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        c0Var.f1662a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            Logger logger = b0.b;
            i3 += 8;
        }
        c0Var.f1662a.g(i3);
        while (i2 < list.size()) {
            c0Var.f1662a.c(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void k(int i, List list, c0 c0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c0Var.getClass();
            while (i2 < list.size()) {
                c0Var.f1662a.d(i, b0.d(((Integer) list.get(i2)).intValue()));
                i2++;
            }
            return;
        }
        c0Var.f1662a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += b0.c(b0.d(((Integer) list.get(i4)).intValue()));
        }
        c0Var.f1662a.g(i3);
        while (i2 < list.size()) {
            c0Var.f1662a.g(b0.d(((Integer) list.get(i2)).intValue()));
            i2++;
        }
    }

    public static void l(int i, List list, c0 c0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c0Var.getClass();
            while (i2 < list.size()) {
                c0Var.f1662a.b(i, b0.b(((Long) list.get(i2)).longValue()));
                i2++;
            }
            return;
        }
        c0Var.f1662a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += b0.a(b0.b(((Long) list.get(i4)).longValue()));
        }
        c0Var.f1662a.g(i3);
        while (i2 < list.size()) {
            c0Var.f1662a.d(b0.b(((Long) list.get(i2)).longValue()));
            i2++;
        }
    }

    public static void m(int i, List list, c0 c0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c0Var.getClass();
            while (i2 < list.size()) {
                c0Var.f1662a.d(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        c0Var.f1662a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += b0.c(((Integer) list.get(i4)).intValue());
        }
        c0Var.f1662a.g(i3);
        while (i2 < list.size()) {
            c0Var.f1662a.g(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void n(int i, List list, c0 c0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c0Var.getClass();
            while (i2 < list.size()) {
                c0Var.f1662a.b(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        c0Var.f1662a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += b0.a(((Long) list.get(i4)).longValue());
        }
        c0Var.f1662a.g(i3);
        while (i2 < list.size()) {
            c0Var.f1662a.d(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static int d(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof a1)) {
            int i2 = 0;
            while (i < size) {
                i2 += b0.c(b0.d(((Integer) list.get(i)).intValue()));
                i++;
            }
            return i2;
        }
        a1 a1Var = (a1) list;
        int i3 = 0;
        while (i < size) {
            a1Var.d(i);
            i3 += b0.c(b0.d(a1Var.b[i]));
            i++;
        }
        return i3;
    }

    public static int e(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof u1)) {
            int i2 = 0;
            while (i < size) {
                i2 += b0.a(b0.b(((Long) list.get(i)).longValue()));
                i++;
            }
            return i2;
        }
        u1 u1Var = (u1) list;
        int i3 = 0;
        while (i < size) {
            u1Var.c(i);
            i3 += b0.a(b0.b(u1Var.b[i]));
            i++;
        }
        return i3;
    }

    public static int g(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof u1)) {
            int i2 = 0;
            while (i < size) {
                i2 += b0.a(((Long) list.get(i)).longValue());
                i++;
            }
            return i2;
        }
        u1 u1Var = (u1) list;
        int i3 = 0;
        while (i < size) {
            u1Var.c(i);
            i3 += b0.a(u1Var.b[i]);
            i++;
        }
        return i3;
    }

    public static void a(int i, List list, c0 c0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0Var.getClass();
        for (int i2 = 0; i2 < list.size(); i2++) {
            c0Var.f1662a.a(i, (s) list.get(i2));
        }
    }

    public static void b(int i, List list, c0 c0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0Var.getClass();
        int i2 = 0;
        if (list instanceof q1) {
            q1 q1Var = (q1) list;
            while (i2 < list.size()) {
                Object a2 = q1Var.a(i2);
                if (a2 instanceof String) {
                    c0Var.f1662a.a((String) a2, i);
                } else {
                    c0Var.f1662a.a(i, (s) a2);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            c0Var.f1662a.a((String) list.get(i2), i);
            i2++;
        }
    }

    public static int c(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof u1)) {
            int i2 = 0;
            while (i < size) {
                i2 += b0.a(((Long) list.get(i)).longValue());
                i++;
            }
            return i2;
        }
        u1 u1Var = (u1) list;
        int i3 = 0;
        while (i < size) {
            u1Var.c(i);
            i3 += b0.a(u1Var.b[i]);
            i++;
        }
        return i3;
    }

    public static int f(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof a1)) {
            int i2 = 0;
            while (i < size) {
                i2 += b0.c(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        a1 a1Var = (a1) list;
        int i3 = 0;
        while (i < size) {
            a1Var.d(i);
            i3 += b0.c(a1Var.b[i]);
            i++;
        }
        return i3;
    }

    public static void a(int i, List list, c0 c0Var, t2 t2Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0Var.getClass();
        for (int i2 = 0; i2 < list.size(); i2++) {
            c0Var.a(i, list.get(i2), t2Var);
        }
    }

    public static int a(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof a1)) {
            int i2 = 0;
            while (i < size) {
                i2 += b0.a(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        a1 a1Var = (a1) list;
        int i3 = 0;
        while (i < size) {
            a1Var.d(i);
            i3 += b0.a(a1Var.b[i]);
            i++;
        }
        return i3;
    }

    public static void b(int i, List list, c0 c0Var, t2 t2Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c0Var.getClass();
        for (int i2 = 0; i2 < list.size(); i2++) {
            c0Var.f1662a.a(i, (d2) list.get(i2), t2Var);
        }
    }

    public static int c(int i, List list) {
        int a2;
        int a3;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int b2 = b0.b(i) * size;
        if (!(list instanceof q1)) {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof s) {
                    a2 = b0.a((s) obj);
                } else {
                    a2 = b0.a((String) obj);
                }
                b2 = a2 + b2;
                i2++;
            }
            return b2;
        }
        q1 q1Var = (q1) list;
        while (i2 < size) {
            Object a4 = q1Var.a(i2);
            if (a4 instanceof s) {
                a3 = b0.a((s) a4);
            } else {
                a3 = b0.a((String) a4);
            }
            b2 = a3 + b2;
            i2++;
        }
        return b2;
    }

    public static int b(List list) {
        int i;
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof a1)) {
            int i4 = 0;
            while (i3 < size) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (intValue >= 0) {
                    i = b0.c(intValue);
                } else {
                    Logger logger = b0.b;
                    i = 10;
                }
                i4 += i;
                i3++;
            }
            return i4;
        }
        a1 a1Var = (a1) list;
        int i5 = 0;
        while (i3 < size) {
            a1Var.d(i3);
            int i6 = a1Var.b[i3];
            if (i6 >= 0) {
                i2 = b0.c(i6);
            } else {
                Logger logger2 = b0.b;
                i2 = 10;
            }
            i5 += i2;
            i3++;
        }
        return i5;
    }

    public static int a(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (b0.b(i) + 4) * size;
    }

    public static o3 a(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (o3) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static Object a(int i, AbstractList abstractList, e1 e1Var, Object obj, o3 o3Var) {
        if (e1Var == null) {
            return obj;
        }
        int size = abstractList.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Integer num = (Integer) abstractList.get(i3);
            int intValue = num.intValue();
            if (e1Var.a(intValue) != null) {
                if (i3 != i2) {
                    abstractList.set(i2, num);
                }
                i2++;
            } else {
                obj = a(i, intValue, obj, o3Var);
            }
        }
        if (i2 != size) {
            abstractList.subList(i2, size).clear();
        }
        return obj;
    }

    public static int b(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (b0.b(i) + 8) * size;
    }

    public static Object a(int i, int i2, Object obj, o3 o3Var) {
        if (obj == null) {
            o3Var.getClass();
            obj = new n3();
        }
        o3Var.getClass();
        ((n3) obj).a(i << 3, Long.valueOf(i2));
        return obj;
    }
}
