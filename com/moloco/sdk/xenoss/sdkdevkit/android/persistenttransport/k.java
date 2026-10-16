package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import androidx.work.Data;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class k {
    public static final Data a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Pair[] pairArr = {TuplesKt.to("url", str)};
            Data.Builder builder = new Data.Builder();
            Pair pair = pairArr[0];
            builder.put((String) pair.getFirst(), pair.getSecond());
            Data build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "dataBuilder.build()");
            return build;
        } catch (Exception e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, j.d, e.getMessage() + ". Url: " + str, null, false, 12, null);
            return null;
        }
    }
}
