package io.bidmachine.util;

import android.net.Uri;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UrlUtils.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a#\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\"\u00020\u0002¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"parseUri", "Landroid/net/Uri;", "", "removeQueryParameters", "parameterNames", "", "(Landroid/net/Uri;[Ljava/lang/String;)Landroid/net/Uri;", "bidmachine-android-sdk_ca_3_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class UrlUtilsKt {
    public static final Uri parseUri(String str) {
        Uri validUri;
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Uri parse = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(this)");
            String scheme = parse.getScheme();
            if (scheme != null && scheme.length() != 0) {
                return parse;
            }
            if (!StringsKt.startsWith$default(str, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null) && (validUri = Utils.getValidUri(str)) != null) {
                String scheme2 = validUri.getScheme();
                if (scheme2 != null) {
                    Intrinsics.checkNotNullExpressionValue(scheme2, "scheme");
                    if (scheme2.length() > 0) {
                        return validUri;
                    }
                }
                String uri = validUri.toString();
                Intrinsics.checkNotNullExpressionValue(uri, "newUri.toString()");
                if (StringsKt.startsWith$default(uri, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null)) {
                    return validUri;
                }
            }
            return parse;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final Uri removeQueryParameters(Uri uri, String... parameterNames) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(parameterNames, "parameterNames");
        if (parameterNames.length == 0) {
            return uri;
        }
        Set set = ArraysKt.toSet(parameterNames);
        Uri.Builder clearQuery = uri.buildUpon().clearQuery();
        Intrinsics.checkNotNullExpressionValue(clearQuery, "buildUpon().clearQuery()");
        for (String str : uri.getQueryParameterNames()) {
            if (!set.contains(str)) {
                Iterator<String> it = uri.getQueryParameters(str).iterator();
                while (it.hasNext()) {
                    clearQuery.appendQueryParameter(str, it.next());
                }
            }
        }
        Uri build = clearQuery.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }
}
