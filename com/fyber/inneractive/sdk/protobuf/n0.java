package com.fyber.inneractive.sdk.protobuf;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class n0 {
    public static final n0 d = new n0(0);

    /* renamed from: a, reason: collision with root package name */
    public final e3 f1687a;
    public boolean b;
    public boolean c;

    public n0() {
        int i = e3.h;
        this.f1687a = new v2(16);
    }

    public static boolean b(Map.Entry entry) {
        w0 w0Var = (w0) entry.getKey();
        if (w0Var.c.a() != k4.MESSAGE) {
            return true;
        }
        if (!w0Var.d) {
            Object value = entry.getValue();
            if (value instanceof d2) {
                return ((d2) value).isInitialized();
            }
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        Iterator it = ((List) entry.getValue()).iterator();
        while (it.hasNext()) {
            if (!((d2) it.next()).isInitialized()) {
                return false;
            }
        }
        return true;
    }

    public final void a(n0 n0Var) {
        for (int i = 0; i < n0Var.f1687a.b.size(); i++) {
            c((Map.Entry) n0Var.f1687a.b.get(i));
        }
        Iterator it = n0Var.f1687a.b().iterator();
        while (it.hasNext()) {
            c((Map.Entry) it.next());
        }
    }

    public final boolean c() {
        for (int i = 0; i < this.f1687a.b.size(); i++) {
            if (!b((Map.Entry) this.f1687a.b.get(i))) {
                return false;
            }
        }
        Iterator it = this.f1687a.b().iterator();
        while (it.hasNext()) {
            if (!b((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Iterator d() {
        return this.c ? new o1(this.f1687a.entrySet().iterator()) : this.f1687a.entrySet().iterator();
    }

    public final void e() {
        if (this.b) {
            return;
        }
        v2 v2Var = (v2) this.f1687a;
        if (!v2Var.d) {
            for (int i = 0; i < v2Var.b.size(); i++) {
                Map.Entry entry = (Map.Entry) v2Var.b.get(i);
                if (((w0) entry.getKey()).d) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
            for (Map.Entry entry2 : v2Var.b()) {
                if (((w0) entry2.getKey()).d) {
                    entry2.setValue(Collections.unmodifiableList((List) entry2.getValue()));
                }
            }
        }
        if (!v2Var.d) {
            v2Var.c = v2Var.c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(v2Var.c);
            v2Var.f = v2Var.f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(v2Var.f);
            v2Var.d = true;
        }
        this.b = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n0) {
            return this.f1687a.equals(((n0) obj).f1687a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1687a.hashCode();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final n0 m7076clone() {
        n0 n0Var = new n0();
        for (int i = 0; i < this.f1687a.b.size(); i++) {
            Map.Entry entry = (Map.Entry) this.f1687a.b.get(i);
            n0Var.c((w0) entry.getKey(), entry.getValue());
        }
        for (Map.Entry entry2 : this.f1687a.b()) {
            n0Var.c((w0) entry2.getKey(), entry2.getValue());
        }
        n0Var.c = this.c;
        return n0Var;
    }

    public n0(int i) {
        int i2 = e3.h;
        this.f1687a = new v2(0);
        e();
        e();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        if ((r3 instanceof com.fyber.inneractive.sdk.protobuf.d1) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:
    
        if ((r3 instanceof byte[]) == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(w0 w0Var, Object obj) {
        boolean z;
        j4 j4Var = w0Var.c;
        Charset charset = l1.f1684a;
        obj.getClass();
        switch (m0.f1686a[j4Var.a().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof s)) {
                    break;
                }
                z = true;
                break;
            case 8:
                if (!(obj instanceof Integer)) {
                    break;
                }
                z = true;
                break;
            case 9:
                z = obj instanceof d2;
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(w0Var.b), w0Var.c.a(), obj.getClass().getName()));
        }
    }

    public final int a() {
        int i = 0;
        for (int i2 = 0; i2 < this.f1687a.b.size(); i2++) {
            i += a((Map.Entry) this.f1687a.b.get(i2));
        }
        Iterator it = this.f1687a.b().iterator();
        while (it.hasNext()) {
            i += a((Map.Entry) it.next());
        }
        return i;
    }

    public final void c(Map.Entry entry) {
        w0 w0Var = (w0) entry.getKey();
        Object value = entry.getValue();
        if (w0Var.d) {
            Object obj = this.f1687a.get(w0Var);
            if (obj == null) {
                obj = new ArrayList();
            }
            for (Object obj2 : (List) value) {
                List list = (List) obj;
                if (obj2 instanceof byte[]) {
                    byte[] bArr = (byte[]) obj2;
                    byte[] bArr2 = new byte[bArr.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    obj2 = bArr2;
                }
                list.add(obj2);
            }
            this.f1687a.a(w0Var, obj);
            return;
        }
        if (w0Var.c.a() == k4.MESSAGE) {
            Object obj3 = this.f1687a.get(w0Var);
            if (obj3 == null) {
                e3 e3Var = this.f1687a;
                if (value instanceof byte[]) {
                    byte[] bArr3 = (byte[]) value;
                    byte[] bArr4 = new byte[bArr3.length];
                    System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
                    value = bArr4;
                }
                e3Var.a(w0Var, value);
                return;
            }
            t0 t0Var = (t0) ((d2) obj3).toBuilder();
            t0Var.c();
            t0.a(t0Var.b, (z0) ((d2) value));
            this.f1687a.a(w0Var, t0Var.a());
            return;
        }
        e3 e3Var2 = this.f1687a;
        if (value instanceof byte[]) {
            byte[] bArr5 = (byte[]) value;
            byte[] bArr6 = new byte[bArr5.length];
            System.arraycopy(bArr5, 0, bArr6, 0, bArr5.length);
            value = bArr6;
        }
        e3Var2.a(w0Var, value);
    }

    public static int a(Map.Entry entry) {
        w0 w0Var = (w0) entry.getKey();
        Object value = entry.getValue();
        if (w0Var.c.a() == k4.MESSAGE && !w0Var.d && !w0Var.e) {
            int i = ((w0) entry.getKey()).b;
            int c = b0.c(i) + b0.b(2) + (b0.b(1) * 2);
            int b = b0.b(3);
            int serializedSize = ((d2) value).getSerializedSize();
            return l0.a(serializedSize, serializedSize, b, c);
        }
        return b(w0Var, value);
    }

    public final int b() {
        int i = 0;
        for (int i2 = 0; i2 < this.f1687a.b.size(); i2++) {
            Map.Entry entry = (Map.Entry) this.f1687a.b.get(i2);
            i += b((w0) entry.getKey(), entry.getValue());
        }
        for (Map.Entry entry2 : this.f1687a.b()) {
            i += b((w0) entry2.getKey(), entry2.getValue());
        }
        return i;
    }

    public static int b(w0 w0Var, Object obj) {
        int b;
        int a2;
        j4 j4Var = w0Var.c;
        int i = w0Var.b;
        if (w0Var.d) {
            int i2 = 0;
            if (w0Var.e) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i2 += a(j4Var, it.next());
                }
                b = b0.b(i) + i2;
                a2 = b0.c(i2);
            } else {
                for (Object obj2 : (List) obj) {
                    int b2 = b0.b(i);
                    if (j4Var == j4.GROUP) {
                        b2 *= 2;
                    }
                    i2 += a(j4Var, obj2) + b2;
                }
                return i2;
            }
        } else {
            b = b0.b(i);
            if (j4Var == j4.GROUP) {
                b *= 2;
            }
            a2 = a(j4Var, obj);
        }
        return a2 + b;
    }

    public final void c(w0 w0Var, Object obj) {
        if (w0Var.d) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d(w0Var, it.next());
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            d(w0Var, obj);
        }
        this.f1687a.a(w0Var, obj);
    }

    public static int a(j4 j4Var, Object obj) {
        int serializedSize;
        int c;
        switch (m0.b[j4Var.ordinal()]) {
            case 1:
                ((Double) obj).getClass();
                Logger logger = b0.b;
                return 8;
            case 2:
                ((Float) obj).getClass();
                Logger logger2 = b0.b;
                return 4;
            case 3:
                return b0.a(((Long) obj).longValue());
            case 4:
                return b0.a(((Long) obj).longValue());
            case 5:
                int intValue = ((Integer) obj).intValue();
                if (intValue >= 0) {
                    return b0.c(intValue);
                }
                Logger logger3 = b0.b;
                return 10;
            case 6:
                ((Long) obj).getClass();
                Logger logger4 = b0.b;
                return 8;
            case 7:
                ((Integer) obj).getClass();
                Logger logger5 = b0.b;
                return 4;
            case 8:
                ((Boolean) obj).getClass();
                Logger logger6 = b0.b;
                return 1;
            case 9:
                Logger logger7 = b0.b;
                return ((d2) obj).getSerializedSize();
            case 10:
                Logger logger8 = b0.b;
                serializedSize = ((d2) obj).getSerializedSize();
                c = b0.c(serializedSize);
                break;
            case 11:
                if (obj instanceof s) {
                    return b0.a((s) obj);
                }
                return b0.a((String) obj);
            case 12:
                if (obj instanceof s) {
                    return b0.a((s) obj);
                }
                Logger logger9 = b0.b;
                serializedSize = ((byte[]) obj).length;
                c = b0.c(serializedSize);
                break;
            case 13:
                return b0.c(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).getClass();
                Logger logger10 = b0.b;
                return 4;
            case 15:
                ((Long) obj).getClass();
                Logger logger11 = b0.b;
                return 8;
            case 16:
                return b0.c(b0.d(((Integer) obj).intValue()));
            case 17:
                return b0.a(b0.b(((Long) obj).longValue()));
            case 18:
                if (obj instanceof d1) {
                    return b0.a(((d1) obj).a());
                }
                return b0.a(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return c + serializedSize;
    }

    public final void a(w0 w0Var, Object obj) {
        List list;
        if (w0Var.d) {
            d(w0Var, obj);
            Object obj2 = this.f1687a.get(w0Var);
            if (obj2 == null) {
                list = new ArrayList();
                this.f1687a.a(w0Var, list);
            } else {
                list = (List) obj2;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }
}
