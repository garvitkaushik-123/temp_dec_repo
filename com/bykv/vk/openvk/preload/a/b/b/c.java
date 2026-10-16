package com.bykv.vk.openvk.preload.a.b.b;

import com.bykv.vk.openvk.preload.a.j;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* compiled from: UnsafeReflectionAccessor.java */
/* loaded from: classes3.dex */
final class c extends b {

    /* renamed from: a, reason: collision with root package name */
    private static Class f893a;
    private final Object b = b();
    private final Field c = c();

    c() {
    }

    @Override // com.bykv.vk.openvk.preload.a.b.b.b
    public final void a(AccessibleObject accessibleObject) {
        if (b(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e) {
            throw new j("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
        }
    }

    private boolean b(AccessibleObject accessibleObject) {
        if (this.b != null && this.c != null) {
            try {
                f893a.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.b, accessibleObject, Long.valueOf(((Long) f893a.getMethod("objectFieldOffset", Field.class).invoke(this.b, this.c)).longValue()), Boolean.TRUE);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static Object b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f893a = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Field c() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }
}
