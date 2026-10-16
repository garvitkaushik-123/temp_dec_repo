package com.inmobi.media;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.wa, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2925wa {
    public static final boolean a(Context context, String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        if (context == null) {
            return false;
        }
        return context.checkCallingOrSelfPermission(permission) == 0;
    }
}
