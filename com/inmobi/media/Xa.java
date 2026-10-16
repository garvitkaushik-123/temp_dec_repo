package com.inmobi.media;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Xa extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Xa f2483a = new Xa();

    public Xa() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Ya.f2496a.getClass();
        Context d = Uc.d();
        JSONObject jSONObject = null;
        if (d != null) {
            if (Ya.c == null) {
                Ya.c = new Sa(d, "pub_signals_store");
            }
            Sa sa = Ya.c;
            if (sa == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefDao");
                sa = null;
            }
            String a2 = sa.a("saved_signals");
            if (a2 != null) {
                jSONObject = new JSONObject(a2);
            }
        }
        return jSONObject == null ? new JSONObject() : jSONObject;
    }
}
