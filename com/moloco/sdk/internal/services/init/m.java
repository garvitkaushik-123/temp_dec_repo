package com.moloco.sdk.internal.services.init;

import com.moloco.sdk.Init;
import com.moloco.sdk.internal.services.init.j;
import com.moloco.sdk.internal.v;
import io.ktor.http.HttpStatusCode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5710a = "InitService";

    public static final boolean a(v.a<Init.SDKInitResponse, j> aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (aVar.a() instanceof j.b) {
            return a(((j.b) aVar.a()).a());
        }
        return true;
    }

    public static final boolean a(int i) {
        HttpStatusCode.Companion companion = HttpStatusCode.INSTANCE;
        return i == companion.getTooManyRequests().getValue() || i == companion.getRequestTimeout().getValue() || i < 400 || i >= 500;
    }
}
