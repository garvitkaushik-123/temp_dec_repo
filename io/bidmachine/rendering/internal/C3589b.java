package io.bidmachine.rendering.internal;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/content/Context;", "Ljava/lang/Class;", "clazz", "Landroid/content/Intent;", "a", "(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;", "bidmachine-android-sdk_bi_3_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.bidmachine.rendering.internal.b, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C3589b {
    public static final Intent a(Context context, Class<?> clazz) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intent intent = new Intent(context, clazz);
        intent.addFlags(268435456);
        intent.addFlags(8388608);
        return intent;
    }
}
