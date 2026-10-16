package io.bidmachine.rendering.internal;

import android.content.Context;
import io.bidmachine.rendering.model.Background;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/bidmachine/rendering/model/Background;", "Landroid/content/Context;", "context", "Lio/bidmachine/rendering/internal/repository/a;", "repository", "Lio/bidmachine/rendering/internal/z;", "a", "(Lio/bidmachine/rendering/model/Background;Landroid/content/Context;Lio/bidmachine/rendering/internal/repository/a;)Lio/bidmachine/rendering/internal/z;", "bidmachine-android-sdk_bi_3_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class A {
    public static final z a(Background background, Context context, io.bidmachine.rendering.internal.repository.a repository) {
        Intrinsics.checkNotNullParameter(background, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new z(context, repository, background);
    }
}
