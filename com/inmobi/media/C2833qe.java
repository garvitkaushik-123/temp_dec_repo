package com.inmobi.media;

import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.qe, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2833qe {

    /* renamed from: a, reason: collision with root package name */
    public final byte f2687a;
    public HashMap b = new LinkedHashMap();

    public C2833qe(byte b) {
        this.f2687a = b;
    }

    public final Object a(String key, Class classType) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(classType, "classType");
        Object obj = this.b.get(key);
        if (classType.isInstance(obj)) {
            return classType.cast(obj);
        }
        return null;
    }
}
