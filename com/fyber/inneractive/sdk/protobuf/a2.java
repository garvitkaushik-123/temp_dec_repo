package com.fyber.inneractive.sdk.protobuf;

/* loaded from: classes4.dex */
public abstract class a2 {

    /* renamed from: a, reason: collision with root package name */
    public static final z1 f1657a;
    public static final z1 b;

    static {
        z1 z1Var = null;
        try {
            z1Var = (z1) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f1657a = z1Var;
        b = new z1();
    }
}
