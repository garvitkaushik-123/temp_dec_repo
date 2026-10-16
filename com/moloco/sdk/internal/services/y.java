package com.moloco.sdk.internal.services;

import kotlin.Deprecated;
import kotlin.ReplaceWith;

/* loaded from: classes6.dex */
public interface y {
    Boolean a();

    x b();

    String c();

    String d();

    @Deprecated(message = "Use invoke() instead", replaceWith = @ReplaceWith(expression = "deviceInfo", imports = {}))
    x invoke();
}
