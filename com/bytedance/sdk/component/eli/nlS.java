package com.bytedance.sdk.component.eli;

import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public interface nlS {
    <T> T eli(String str, Type type);

    <T> String eli(T t);
}
