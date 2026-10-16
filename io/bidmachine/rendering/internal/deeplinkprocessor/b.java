package io.bidmachine.rendering.internal.deeplinkprocessor;

import android.content.Context;
import android.net.Uri;
import io.bidmachine.rendering.utils.UrlHandler;
import io.bidmachine.util.Executable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\u0005\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0005\u0010\u000eJ/\u0010\u0005\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u0005\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lio/bidmachine/rendering/internal/deeplinkprocessor/b;", "", "Landroid/net/Uri;", "uri", "", "a", "(Landroid/net/Uri;)Z", "Landroid/content/Context;", "context", "", "url", "Lio/bidmachine/util/Executable;", "postMethod", "", "(Landroid/content/Context;Ljava/lang/String;Lio/bidmachine/util/Executable;)V", "(Landroid/content/Context;Landroid/net/Uri;Lio/bidmachine/util/Executable;)V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public interface b {
    void a(Context context, Uri uri, Executable<Boolean> postMethod);

    default void a(Context context, String url, Executable<Boolean> postMethod) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        a(context, UrlHandler.parseUrl(url), postMethod);
    }

    boolean a(Uri uri);
}
