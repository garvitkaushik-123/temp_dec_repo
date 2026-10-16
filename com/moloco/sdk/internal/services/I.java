package com.moloco.sdk.internal.services;

import kotlin.Deprecated;
import kotlin.ReplaceWith;

/* loaded from: classes6.dex */
public interface I {
    long a();

    long elapsedRealtime();

    @Deprecated(message = "Use currentTime() instead", replaceWith = @ReplaceWith(expression = "currentTime()", imports = {}))
    long invoke();
}
