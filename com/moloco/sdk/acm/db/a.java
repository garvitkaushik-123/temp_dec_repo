package com.moloco.sdk.acm.db;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class a {
    public final String a(c eventType) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        return eventType.name();
    }

    public final List<String> b(String tagsString) {
        Intrinsics.checkNotNullParameter(tagsString, "tagsString");
        return tagsString.length() == 0 ? CollectionsKt.emptyList() : StringsKt.split$default((CharSequence) tagsString, new String[]{","}, false, 0, 6, (Object) null);
    }

    public final c a(String eventType) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        return c.valueOf(eventType);
    }

    public final String a(List<String> tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        return CollectionsKt.joinToString$default(tags, ",", null, null, 0, null, null, 62, null);
    }
}
