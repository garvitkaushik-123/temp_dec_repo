package com.google.android.gms.internal.common;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* loaded from: classes5.dex */
public final class zzt {
    static final CharSequence zza(Object obj, String str) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
