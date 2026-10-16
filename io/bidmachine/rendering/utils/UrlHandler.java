package io.bidmachine.rendering.utils;

import android.content.Context;
import android.net.Uri;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.iab.mraid.MraidNativeFeatureUrlParser;
import io.bidmachine.rendering.Rendering;
import io.bidmachine.rendering.internal.deeplinkprocessor.a;
import io.bidmachine.rendering.internal.deeplinkprocessor.b;
import io.bidmachine.rendering.internal.deeplinkprocessor.c;
import io.bidmachine.rendering.internal.deeplinkprocessor.d;
import io.bidmachine.rendering.internal.l;
import io.bidmachine.rendering.internal.r;
import io.bidmachine.rendering.utils.NetworkRequest;
import io.bidmachine.util.Executable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0007¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0007¢\u0006\u0004\b\u0012\u0010\rJ/\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0007¢\u0006\u0004\b\u0013\u0010\rJ\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001fR&\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001d0#8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b$\u0010%\u0012\u0004\b(\u0010\u0003\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lio/bidmachine/rendering/utils/UrlHandler;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "url", "Lio/bidmachine/util/Executable;", "", "postMethod", "", "openUrl", "(Landroid/content/Context;Ljava/lang/String;Lio/bidmachine/util/Executable;)V", "Landroid/net/Uri;", "uri", "openBrowser", "(Landroid/content/Context;Landroid/net/Uri;Lio/bidmachine/util/Executable;)V", "openCalendar", "storePicture", "parseUrl", "(Ljava/lang/String;)Landroid/net/Uri;", "track$bidmachine_android_sdk_bi_3_4_0", "(Ljava/lang/String;)V", "track", "Lio/bidmachine/rendering/internal/l;", "a", "Lio/bidmachine/rendering/internal/l;", "INTENT_LAUNCHER", "Lio/bidmachine/rendering/internal/deeplinkprocessor/b;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lio/bidmachine/rendering/internal/deeplinkprocessor/b;", "MRAID_CALENDAR_DEEPLINK_PROCESSOR", "c", "MRAID_STORE_PICTURE_DEEPLINK_PROCESSOR", "", "d", "Ljava/util/List;", "getSUPPORTED_DEEPLINK_PROCESSORS", "()Ljava/util/List;", "getSUPPORTED_DEEPLINK_PROCESSORS$annotations", "SUPPORTED_DEEPLINK_PROCESSORS", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class UrlHandler {
    public static final UrlHandler INSTANCE = new UrlHandler();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final l INTENT_LAUNCHER;

    /* renamed from: b, reason: from kotlin metadata */
    private static final b MRAID_CALENDAR_DEEPLINK_PROCESSOR;

    /* renamed from: c, reason: from kotlin metadata */
    private static final b MRAID_STORE_PICTURE_DEEPLINK_PROCESSOR;

    /* renamed from: d, reason: from kotlin metadata */
    private static final List<b> SUPPORTED_DEEPLINK_PROCESSORS;

    static {
        l lVar = new l();
        INTENT_LAUNCHER = lVar;
        MraidNativeFeatureUrlParser mraidNativeFeatureUrlParser = new MraidNativeFeatureUrlParser();
        r rVar = new r();
        c cVar = new c(mraidNativeFeatureUrlParser, lVar);
        MRAID_CALENDAR_DEEPLINK_PROCESSOR = cVar;
        d dVar = new d(mraidNativeFeatureUrlParser, rVar);
        MRAID_STORE_PICTURE_DEEPLINK_PROCESSOR = dVar;
        SUPPORTED_DEEPLINK_PROCESSORS = CollectionsKt.listOf((Object[]) new b[]{cVar, dVar, new a()});
    }

    private UrlHandler() {
    }

    public static /* synthetic */ void getSUPPORTED_DEEPLINK_PROCESSORS$annotations() {
    }

    @JvmStatic
    public static final void openBrowser(Context context, Uri uri, Executable<Boolean> postMethod) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        INTENT_LAUNCHER.a(context, uri, postMethod);
    }

    @JvmStatic
    public static final void openCalendar(Context context, String url, Executable<Boolean> postMethod) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        MRAID_CALENDAR_DEEPLINK_PROCESSOR.a(context, url, postMethod);
    }

    @JvmStatic
    public static final void openUrl(Context context, String url, Executable<Boolean> postMethod) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Uri parseUrl = parseUrl(url);
        for (b bVar : SUPPORTED_DEEPLINK_PROCESSORS) {
            if (bVar.a(parseUrl)) {
                bVar.a(context, parseUrl, postMethod);
                return;
            }
        }
        openBrowser(context, parseUrl, postMethod);
    }

    @JvmStatic
    public static final Uri parseUrl(String url) {
        Uri validUri;
        Intrinsics.checkNotNullParameter(url, "url");
        Uri parse = Uri.parse(url);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
        String scheme = parse.getScheme();
        if ((scheme == null || scheme.length() == 0) && !StringsKt.startsWith$default(url, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null) && (validUri = io.bidmachine.util.Utils.getValidUri(url)) != null) {
            String scheme2 = validUri.getScheme();
            if (scheme2 == null || scheme2.length() <= 0) {
                String uri = validUri.toString();
                Intrinsics.checkNotNullExpressionValue(uri, "newUri.toString()");
                if (StringsKt.startsWith$default(uri, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null)) {
                }
            }
            return validUri;
        }
        return parse;
    }

    @JvmStatic
    public static final void storePicture(Context context, String url, Executable<Boolean> postMethod) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        MRAID_STORE_PICTURE_DEEPLINK_PROCESSOR.a(context, url, postMethod);
    }

    @JvmStatic
    public static final void track$bidmachine_android_sdk_bi_3_4_0(String url) {
        String validUrl = io.bidmachine.util.Utils.getValidUrl(url);
        if (validUrl == null || validUrl.length() <= 0) {
            return;
        }
        new NetworkRequest.Builder(validUrl, NetworkRequest.Method.Get).setUserAgent(Rendering.getUserAgent()).send();
    }

    public final List<b> getSUPPORTED_DEEPLINK_PROCESSORS() {
        return SUPPORTED_DEEPLINK_PROCESSORS;
    }
}
