package io.bidmachine.rendering.internal.deeplinkprocessor;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.iab.utils.CommonLog;
import io.bidmachine.rendering.utils.UiUtils;
import io.bidmachine.rendering.utils.UrlHandler;
import io.bidmachine.util.Executable;
import io.bidmachine.util.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0003\u0007\u000f\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0007\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0007\u0010\u000e¨\u0006\u0011"}, d2 = {"Lio/bidmachine/rendering/internal/deeplinkprocessor/a;", "Lio/bidmachine/rendering/internal/deeplinkprocessor/b;", "<init>", "()V", "Landroid/net/Uri;", "uri", "", "a", "(Landroid/net/Uri;)Z", "Landroid/content/Context;", "context", "Lio/bidmachine/util/Executable;", "postMethod", "", "(Landroid/content/Context;Landroid/net/Uri;Lio/bidmachine/util/Executable;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class a implements io.bidmachine.rendering.internal.deeplinkprocessor.b {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\fR\u001c\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/bidmachine/rendering/internal/deeplinkprocessor/a$b;", "Lio/bidmachine/util/Executable;", "", "Landroid/net/Uri;", "baseUri", "postMethod", "<init>", "(Landroid/net/Uri;Lio/bidmachine/util/Executable;)V", "input", "", "a", "(Z)V", "Landroid/net/Uri;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lio/bidmachine/util/Executable;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class b implements Executable<Boolean> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Uri baseUri;

        /* renamed from: b, reason: from kotlin metadata */
        private final Executable<Boolean> postMethod;

        public b(Uri baseUri, Executable<Boolean> executable) {
            Intrinsics.checkNotNullParameter(baseUri, "baseUri");
            this.baseUri = baseUri;
            this.postMethod = executable;
        }

        public void a(boolean input) {
            if (input) {
                UrlHandler.track$bidmachine_android_sdk_bi_3_4_0(this.baseUri.getQueryParameter("fallbackTrackingUrl"));
            }
            UiUtils.onUiThreadWithArgSafely(Boolean.valueOf(input), this.postMethod);
        }

        @Override // io.bidmachine.util.Executable
        public /* bridge */ /* synthetic */ void execute(Boolean bool) {
            a(bool.booleanValue());
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u001c\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lio/bidmachine/rendering/internal/deeplinkprocessor/a$c;", "Lio/bidmachine/util/Executable;", "", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "baseUri", "postMethod", "<init>", "(Landroid/content/Context;Landroid/net/Uri;Lio/bidmachine/util/Executable;)V", "input", "", "a", "(Z)V", "Landroid/net/Uri;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lio/bidmachine/util/Executable;", "c", "Landroid/content/Context;", "applicationContext", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class c implements Executable<Boolean> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Uri baseUri;

        /* renamed from: b, reason: from kotlin metadata */
        private final Executable<Boolean> postMethod;

        /* renamed from: c, reason: from kotlin metadata */
        private final Context applicationContext;

        public c(Context context, Uri baseUri, Executable<Boolean> executable) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(baseUri, "baseUri");
            this.baseUri = baseUri;
            this.postMethod = executable;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            this.applicationContext = applicationContext;
        }

        public void a(boolean input) {
            if (input) {
                UrlHandler.track$bidmachine_android_sdk_bi_3_4_0(this.baseUri.getQueryParameter("primaryTrackingUrl"));
                UiUtils.onUiThreadWithArgSafely(Boolean.TRUE, this.postMethod);
                return;
            }
            String queryParameter = this.baseUri.getQueryParameter("fallbackUrl");
            if (queryParameter == null || queryParameter.length() == 0) {
                UiUtils.onUiThreadWithArgSafely(Boolean.FALSE, this.postMethod);
                return;
            }
            Uri validUri = Utils.getValidUri(queryParameter);
            if (validUri == null) {
                UiUtils.onUiThreadWithArgSafely(Boolean.FALSE, this.postMethod);
            } else {
                UrlHandler.openBrowser(this.applicationContext, validUri, new b(this.baseUri, this.postMethod));
            }
        }

        @Override // io.bidmachine.util.Executable
        public /* bridge */ /* synthetic */ void execute(Boolean bool) {
            a(bool.booleanValue());
        }
    }

    @Override // io.bidmachine.rendering.internal.deeplinkprocessor.b
    public boolean a(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Intrinsics.areEqual("bmlink", uri.getScheme());
    }

    @Override // io.bidmachine.rendering.internal.deeplinkprocessor.b
    public void a(Context context, Uri uri, Executable<Boolean> postMethod) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String queryParameter = uri.getQueryParameter("primaryUrl");
        if (TextUtils.isEmpty(queryParameter)) {
            CommonLog.e("BMDeeplinkProcessor", "processUrl (primaryUrl is null or empty)", new Object[0]);
            UiUtils.onUiThreadWithArgSafely(Boolean.FALSE, postMethod);
            return;
        }
        Uri validUri = Utils.getValidUri(queryParameter);
        if (validUri != null) {
            UrlHandler.openBrowser(context, validUri, new c(context, uri, postMethod));
        } else {
            CommonLog.e("BMDeeplinkProcessor", "processUrl (primaryUri is null)", new Object[0]);
            UiUtils.onUiThreadWithArgSafely(Boolean.FALSE, postMethod);
        }
    }
}
