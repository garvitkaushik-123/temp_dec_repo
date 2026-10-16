package com.moloco.sdk.internal.services.usertracker;

import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a implements e {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5722a = 0;

    @Override // com.moloco.sdk.internal.services.usertracker.e
    public String a() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        return uuid;
    }
}
