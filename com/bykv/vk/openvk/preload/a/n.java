package com.bykv.vk.openvk.preload.a;

import java.math.BigInteger;

/* compiled from: JsonPrimitive.java */
/* loaded from: classes3.dex */
public final class n extends i {

    /* renamed from: a, reason: collision with root package name */
    private final Object f919a;

    public n(Boolean bool) {
        this.f919a = com.bykv.vk.openvk.preload.falconx.a.a.a(bool);
    }

    public n(Number number) {
        this.f919a = com.bykv.vk.openvk.preload.falconx.a.a.a(number);
    }

    public n(String str) {
        this.f919a = com.bykv.vk.openvk.preload.falconx.a.a.a(str);
    }

    public final boolean d() {
        return this.f919a instanceof Boolean;
    }

    public final boolean e() {
        return this.f919a instanceof Number;
    }

    @Override // com.bykv.vk.openvk.preload.a.i
    public final Number a() {
        Object obj = this.f919a;
        return obj instanceof String ? new com.bykv.vk.openvk.preload.a.b.f((String) this.f919a) : (Number) obj;
    }

    public final int hashCode() {
        long doubleToLongBits;
        if (this.f919a == null) {
            return 31;
        }
        if (a(this)) {
            doubleToLongBits = a().longValue();
        } else {
            Object obj = this.f919a;
            if (obj instanceof Number) {
                doubleToLongBits = Double.doubleToLongBits(a().doubleValue());
            } else {
                return obj.hashCode();
            }
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f919a == null) {
            return nVar.f919a == null;
        }
        if (a(this) && a(nVar)) {
            return a().longValue() == nVar.a().longValue();
        }
        Object obj2 = this.f919a;
        if ((obj2 instanceof Number) && (nVar.f919a instanceof Number)) {
            double doubleValue = a().doubleValue();
            double doubleValue2 = nVar.a().doubleValue();
            return doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2));
        }
        return obj2.equals(nVar.f919a);
    }

    private static boolean a(n nVar) {
        Object obj = nVar.f919a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // com.bykv.vk.openvk.preload.a.i
    public final boolean c() {
        Object obj = this.f919a;
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return Boolean.parseBoolean(b());
    }

    @Override // com.bykv.vk.openvk.preload.a.i
    public final String b() {
        Object obj = this.f919a;
        if (obj instanceof Number) {
            return a().toString();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        }
        return (String) obj;
    }
}
