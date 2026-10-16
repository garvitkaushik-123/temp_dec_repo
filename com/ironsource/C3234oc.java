package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.oc, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3234oc extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3234oc(Exception e) {
        super("Missing Headers", e);
        Intrinsics.checkNotNullParameter(e, "e");
    }
}
