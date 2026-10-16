package com.ironsource;

import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.a9, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C2991a9 {

    /* renamed from: a, reason: collision with root package name */
    public static final C2991a9 f3179a = new C2991a9();

    private C2991a9() {
    }

    @JvmStatic
    public static final JSONObject a() {
        new J9().b(ContextProvider.getInstance().getApplicationContext());
        JSONObject put = new JSONObject().put("data", IronSourceAES.encode(C3193m5.b().c(), new Z8().a().toString()));
        Intrinsics.checkNotNullExpressionValue(put, "InitProvider()\n        .…ATA_KEY, encryptedData) }");
        return put;
    }
}
