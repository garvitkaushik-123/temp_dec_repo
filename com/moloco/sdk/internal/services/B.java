package com.moloco.sdk.internal.services;

import kotlin.Deprecated;
import kotlin.ReplaceWith;

/* loaded from: classes6.dex */
public interface B {
    boolean a();

    Integer b();

    A c();

    Integer d();

    @Deprecated(message = "Use networkInfo()", replaceWith = @ReplaceWith(expression = "networkInfo()", imports = {}))
    A invoke();
}
