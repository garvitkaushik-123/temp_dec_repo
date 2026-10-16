package com.fyber.inneractive.sdk.protobuf;

/* loaded from: classes4.dex */
public abstract class k0 {

    /* renamed from: a, reason: collision with root package name */
    public static final j0 f1681a = new j0();
    public static final j0 b;

    static {
        j0 j0Var = null;
        try {
            j0Var = (j0) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        b = j0Var;
    }
}
