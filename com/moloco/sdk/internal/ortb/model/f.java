package com.moloco.sdk.internal.ortb.model;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class f {
    public static final String a(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        String e = cVar.e().e();
        return e == null ? "UNKNOWN_MTID" : e;
    }
}
