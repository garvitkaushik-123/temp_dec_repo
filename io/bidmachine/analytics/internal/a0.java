package io.bidmachine.analytics.internal;

import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public abstract class a0 {
    public static final Float a(Object obj) {
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (obj instanceof String) {
            return StringsKt.toFloatOrNull((String) obj);
        }
        return null;
    }
}
