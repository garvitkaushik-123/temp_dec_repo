package io.bidmachine.rendering.internal.deeplinkprocessor;

import android.content.Context;
import android.net.Uri;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.iab.mraid.MraidNativeFeatureUrlParser;
import io.bidmachine.iab.utils.CommonLog;
import io.bidmachine.rendering.internal.r;
import io.bidmachine.rendering.utils.UiUtils;
import io.bidmachine.util.Executable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u000b\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u000b\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lio/bidmachine/rendering/internal/deeplinkprocessor/d;", "Lio/bidmachine/rendering/internal/deeplinkprocessor/b;", "Lio/bidmachine/iab/mraid/MraidNativeFeatureUrlParser;", "mraidNativeFeatureUrlParser", "Lio/bidmachine/rendering/internal/r;", "pictureDownloader", "<init>", "(Lio/bidmachine/iab/mraid/MraidNativeFeatureUrlParser;Lio/bidmachine/rendering/internal/r;)V", "Landroid/net/Uri;", "uri", "", "a", "(Landroid/net/Uri;)Z", "Landroid/content/Context;", "context", "Lio/bidmachine/util/Executable;", "postMethod", "", "(Landroid/content/Context;Landroid/net/Uri;Lio/bidmachine/util/Executable;)V", "Lio/bidmachine/iab/mraid/MraidNativeFeatureUrlParser;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lio/bidmachine/rendering/internal/r;", "c", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class d implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final MraidNativeFeatureUrlParser mraidNativeFeatureUrlParser;

    /* renamed from: b, reason: from kotlin metadata */
    private final r pictureDownloader;

    public d(MraidNativeFeatureUrlParser mraidNativeFeatureUrlParser, r pictureDownloader) {
        Intrinsics.checkNotNullParameter(mraidNativeFeatureUrlParser, "mraidNativeFeatureUrlParser");
        Intrinsics.checkNotNullParameter(pictureDownloader, "pictureDownloader");
        this.mraidNativeFeatureUrlParser = mraidNativeFeatureUrlParser;
        this.pictureDownloader = pictureDownloader;
    }

    @Override // io.bidmachine.rendering.internal.deeplinkprocessor.b
    public boolean a(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Intrinsics.areEqual("storePicture", uri.getScheme());
    }

    @Override // io.bidmachine.rendering.internal.deeplinkprocessor.b
    public void a(Context context, Uri uri, Executable<Boolean> postMethod) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Uri parseStorePictureUri = this.mraidNativeFeatureUrlParser.parseStorePictureUri(uri);
        if (parseStorePictureUri == null) {
            CommonLog.e("MraidStorePictureDeeplinkProcessor", "processUrl (storePictureUri is null)", new Object[0]);
            UiUtils.onUiThreadWithArgSafely(Boolean.FALSE, postMethod);
        } else {
            r rVar = this.pictureDownloader;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            rVar.a(applicationContext, parseStorePictureUri, postMethod);
        }
    }
}
