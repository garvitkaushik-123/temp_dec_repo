package com.mbridge.msdk.mbsignalcommon.mapping;

/* compiled from: Mapping.java */
/* loaded from: classes6.dex */
public class a extends Throwable {

    /* renamed from: a, reason: collision with root package name */
    private Class<?> f4556a;
    private String b;

    public a(String str) {
        super(str);
    }

    public void a(Class<?> cls) {
        this.f4556a = cls;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getCause() != null ? getClass().getName() + ": " + getCause() : super.toString();
    }

    public a(Exception exc) {
        super(exc);
    }

    public void a(String str) {
        this.b = str;
    }
}
