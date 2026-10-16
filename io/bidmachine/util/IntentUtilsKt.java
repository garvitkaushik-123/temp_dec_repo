package io.bidmachine.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import io.bidmachine.util.network.NetworkUtils;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: IntentUtils.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\u0012\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a$\u0010\u000f\u001a\u00020\t*\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0012\u001a$\u0010\u0013\u001a\u00020\t*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0012H\u0000\u001a\u0014\u0010\u0014\u001a\u00020\t*\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u001a$\u0010\u0015\u001a\u00020\t*\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0012\u001a\n\u0010\u0016\u001a\u00020\f*\u00020\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"CUSTOM_PARAM_RAW_URL", "", "CUSTOM_PARAM_REMOVE_CUSTOM_PARAMS", "KEY_CUSTOM_PARAMS", "extractBmCustomParams", "", "urlString", "removeBmCustomParams", "findAndSetIntentComponent", "", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "findComponentName", "Landroid/content/ComponentName;", "findEndpointAndOpenUrl", "url", "postMethod", "Lio/bidmachine/util/Executable;", "openRawUrl", "openUrl", "openUrlWithPostback", "toIntent", "Landroid/net/Uri;", "bidmachine-android-sdk_ca_3_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class IntentUtilsKt {
    private static final String CUSTOM_PARAM_RAW_URL = "lraw";
    private static final String CUSTOM_PARAM_REMOVE_CUSTOM_PARAMS = "rcp";
    private static final String KEY_CUSTOM_PARAMS = "bmcp";

    public static final boolean findEndpointAndOpenUrl(Context context, String str, final Executable<Boolean> executable) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            if (executable != null) {
                executable.execute(false);
            }
            return false;
        }
        final Context applicationContext = context.getApplicationContext();
        final String validUrl = Utils.getValidUrl(str);
        String str3 = validUrl;
        if (str3 == null || str3.length() == 0) {
            if (executable != null) {
                executable.execute(false);
            }
            return false;
        }
        Set<String> extractBmCustomParams = extractBmCustomParams(validUrl);
        if (extractBmCustomParams.contains(CUSTOM_PARAM_RAW_URL)) {
            if (extractBmCustomParams.contains(CUSTOM_PARAM_REMOVE_CUSTOM_PARAMS)) {
                str = removeBmCustomParams(str);
            }
            return openRawUrl(context, str, executable);
        }
        if (Utils.isHttpUrl(validUrl)) {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: io.bidmachine.util.IntentUtilsKt$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    IntentUtilsKt.findEndpointAndOpenUrl$lambda$0(applicationContext, validUrl, executable);
                }
            });
            return true;
        }
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        return openUrlWithPostback(applicationContext, validUrl, executable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void findEndpointAndOpenUrl$lambda$0(Context applicationContext, String str, Executable executable) {
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        openUrlWithPostback(applicationContext, NetworkUtils.findEndpoint$default(str, 0, 2, null), executable);
    }

    public static final boolean openUrl(Context context, String str) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(context, "<this>");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return false;
        }
        try {
            Intent urlToIntent = IntentUtils.urlToIntent(str);
            if (!IntentUtils.findAndSetIntentComponent(context, urlToIntent)) {
                String decodedUrl = URLDecoder.decode(str, Charsets.UTF_8.name());
                Intrinsics.checkNotNullExpressionValue(decodedUrl, "decodedUrl");
                urlToIntent = IntentUtils.urlToIntent(decodedUrl);
                IntentUtils.findAndSetIntentComponent(context, urlToIntent);
            }
            context.startActivity(urlToIntent);
            bool = true;
        } catch (Throwable unused) {
            bool = null;
        }
        return Intrinsics.areEqual((Object) bool, (Object) true);
    }

    public static final boolean openUrlWithPostback(Context context, String str, final Executable<Boolean> executable) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        final boolean openUrl = openUrl(context, str);
        UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.util.IntentUtilsKt$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                IntentUtilsKt.openUrlWithPostback$lambda$3$lambda$2(Executable.this, openUrl);
            }
        });
        return openUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openUrlWithPostback$lambda$3$lambda$2(Executable executable, boolean z) {
        if (executable != null) {
            executable.execute(Boolean.valueOf(z));
        }
    }

    public static final Intent toIntent(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setFlags(268435456);
        return intent;
    }

    public static final boolean findAndSetIntentComponent(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ComponentName findComponentName = findComponentName(context, intent);
        if (findComponentName == null) {
            return false;
        }
        intent.setComponent(findComponentName);
        return true;
    }

    public static final ComponentName findComponentName(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "packageManager.queryIntentActivities(intent, 0)");
        if (queryIntentActivities.isEmpty()) {
            return null;
        }
        ComponentName findStoreComponentName = IntentUtils.findStoreComponentName(queryIntentActivities);
        return findStoreComponentName == null ? new ComponentName(queryIntentActivities.get(0).activityInfo.packageName, queryIntentActivities.get(0).activityInfo.name) : findStoreComponentName;
    }

    public static final boolean openRawUrl(Context context, String urlString, Executable<Boolean> executable) {
        Object m10241constructorimpl;
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Uri parseUri = UrlUtilsKt.parseUri(urlString);
        if (parseUri == null) {
            if (executable != null) {
                executable.execute(false);
            }
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            context.startActivity(toIntent(parseUri));
            if (executable != null) {
                executable.execute(true);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            m10241constructorimpl = Result.m10241constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10244exceptionOrNullimpl(m10241constructorimpl) != null && executable != null) {
            executable.execute(false);
        }
        return Result.m10248isSuccessimpl(m10241constructorimpl);
    }

    public static final Set<String> extractBmCustomParams(String urlString) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Uri parseUri = UrlUtilsKt.parseUri(urlString);
        if (parseUri == null) {
            return SetsKt.emptySet();
        }
        String queryParameter = parseUri.getQueryParameter(KEY_CUSTOM_PARAMS);
        if (queryParameter == null) {
            queryParameter = "";
        }
        List split$default = StringsKt.split$default((CharSequence) queryParameter, new String[]{"_"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public static final String removeBmCustomParams(String urlString) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Uri parseUri = UrlUtilsKt.parseUri(urlString);
        if (parseUri == null) {
            return urlString;
        }
        String uri = UrlUtilsKt.removeQueryParameters(parseUri, KEY_CUSTOM_PARAMS).toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uri.removeQueryParameter…CUSTOM_PARAMS).toString()");
        return uri;
    }
}
