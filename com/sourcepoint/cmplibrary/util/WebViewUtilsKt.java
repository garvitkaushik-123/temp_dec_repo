package com.sourcepoint.cmplibrary.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: WebViewUtils.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a7\u0010\f\u001a\u00020\r*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\r0\u0010H\u0000¨\u0006\u0013"}, d2 = {"canOpenURLIntent", "", "context", "Landroid/content/Context;", "uriIntent", "Landroid/content/Intent;", "doesLinkContainImage", "testResult", "Landroid/webkit/WebView$HitTestResult;", "getLinkUrl", "", "Landroid/webkit/WebView;", "loadLinkOnExternalBrowser", "", "url", "onNoIntentActivitiesFound", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WebViewUtilsKt {
    public static final void loadLinkOnExternalBrowser(Context context, String url, Function1<? super String, Unit> onNoIntentActivitiesFound) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(onNoIntentActivitiesFound, "onNoIntentActivitiesFound");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        intent.setFlags(268435456);
        if (canOpenURLIntent(context, intent)) {
            context.startActivity(intent);
        } else {
            onNoIntentActivitiesFound.invoke(url);
        }
    }

    public static final boolean canOpenURLIntent(Context context, Intent uriIntent) {
        boolean z;
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uriIntent, "uriIntent");
        PackageManager packageManager = context.getPackageManager();
        String scheme = uriIntent.getScheme();
        if (scheme == null || !(Intrinsics.areEqual(scheme, "http") || Intrinsics.areEqual(scheme, "https"))) {
            return false;
        }
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(uriIntent, 131072);
        Intrinsics.checkNotNull(queryIntentActivities);
        ArrayList arrayList = new ArrayList();
        for (Object obj : queryIntentActivities) {
            ActivityInfo activityInfo = ((ResolveInfo) obj).activityInfo;
            if (activityInfo == null || (str = activityInfo.packageName) == null) {
                z = false;
            } else {
                Intrinsics.checkNotNull(str);
                z = StringsKt.startsWith$default(str, "com.google.android.tv.frameworkpackagestubs", false, 2, (Object) null);
            }
            if (!z) {
                arrayList.add(obj);
            }
        }
        return !arrayList.isEmpty();
    }

    public static final String getLinkUrl(WebView webView, WebView.HitTestResult testResult) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        Intrinsics.checkNotNullParameter(testResult, "testResult");
        if (doesLinkContainImage(testResult)) {
            Message obtainMessage = new Handler().obtainMessage();
            Intrinsics.checkNotNullExpressionValue(obtainMessage, "obtainMessage(...)");
            webView.requestFocusNodeHref(obtainMessage);
            Object obj = obtainMessage.getData().get("url");
            String str = obj instanceof String ? (String) obj : null;
            return str == null ? "" : str;
        }
        String extra = testResult.getExtra();
        return extra == null ? "" : extra;
    }

    public static final boolean doesLinkContainImage(WebView.HitTestResult testResult) {
        Intrinsics.checkNotNullParameter(testResult, "testResult");
        return testResult.getType() == 8;
    }
}
