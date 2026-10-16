package com.inmobi.media;

import java.util.Iterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ke, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2736ke extends Lambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public static final C2736ke f2625a = new C2736ke();

    public C2736ke() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        JSONObject param = (JSONObject) obj;
        int intValue = ((Number) obj2).intValue();
        Intrinsics.checkNotNullParameter(param, "param");
        Iterator<String> keys = param.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
        boolean z = true;
        while (keys.hasNext()) {
            if (param.getInt(keys.next()) < intValue) {
                z = false;
            }
        }
        return Boolean.valueOf(z);
    }
}
