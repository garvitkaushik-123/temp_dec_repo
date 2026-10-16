package com.moloco.sdk.acm;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public final class d {
    public static final String a(EventTag eventTag) {
        Intrinsics.checkNotNullParameter(eventTag, "<this>");
        return eventTag.getKey() + AbstractJsonLexerKt.COLON + eventTag.getValue();
    }
}
