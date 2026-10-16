package io.bidmachine.rendering.internal;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import io.bidmachine.rendering.utils.UiUtils;
import io.bidmachine.util.Executable;
import io.bidmachine.util.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ-\u0010\t\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\t\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/bidmachine/rendering/internal/r;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "", "a", "(Landroid/content/Context;Landroid/net/Uri;)J", "Lio/bidmachine/util/Executable;", "", "postMethod", "", "(Landroid/content/Context;Landroid/net/Uri;Lio/bidmachine/util/Executable;)V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class r {

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"io/bidmachine/rendering/internal/r$a", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Executable<Boolean> f7079a;

        a(Executable<Boolean> executable) {
            this.f7079a = executable;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            context.unregisterReceiver(this);
            UiUtils.onUiThreadWithArgSafely(Boolean.TRUE, this.f7079a);
        }
    }

    public final void a(Context context, Uri uri, Executable<Boolean> postMethod) {
        long j;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Context applicationContext = context.getApplicationContext();
        try {
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            j = a(applicationContext, uri);
        } catch (Exception e) {
            o.b(e);
            j = -1;
        }
        if (j == -1) {
            UiUtils.onUiThreadWithArgSafely(Boolean.FALSE, postMethod);
            return;
        }
        a aVar = new a(postMethod);
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        Utils.registerBroadcastReceiver(aVar, applicationContext, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
    }

    private final long a(Context context, Uri uri) {
        DownloadManager downloadManager = Utils.getDownloadManager(context);
        if (downloadManager != null) {
            return downloadManager.enqueue(new DownloadManager.Request(uri).setNotificationVisibility(1));
        }
        return -1L;
    }
}
