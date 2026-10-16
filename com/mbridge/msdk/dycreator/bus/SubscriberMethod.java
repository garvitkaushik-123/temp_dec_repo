package com.mbridge.msdk.dycreator.bus;

import java.lang.reflect.Method;

/* loaded from: classes6.dex */
final class SubscriberMethod {

    /* renamed from: a, reason: collision with root package name */
    final Method f4163a;
    final ThreadMode b;
    final Class<?> c;
    String d;

    SubscriberMethod(Method method, ThreadMode threadMode, Class<?> cls) {
        this.f4163a = method;
        this.b = threadMode;
        this.c = cls;
    }

    private synchronized void a() {
        if (this.d == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f4163a.getDeclaringClass().getName());
            sb.append('#').append(this.f4163a.getName());
            sb.append('(').append(this.c.getName());
            this.d = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SubscriberMethod)) {
            return false;
        }
        a();
        return this.d.equals(((SubscriberMethod) obj).d);
    }

    public int hashCode() {
        return this.f4163a.hashCode();
    }
}
