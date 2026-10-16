package com.inmobi.media;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.z2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2968z2 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2769a = 0;

    public static boolean a(Context context, String str) {
        if (str == null) {
            return false;
        }
        if (context == null) {
            Uri parse = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(this)");
            return a(parse);
        }
        try {
            Uri parse2 = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse2, "Uri.parse(this)");
            return new Intent("android.intent.action.VIEW", parse2).resolveActivity(context.getPackageManager()) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static final String b(Context context, R7 r7, String str, String str2) {
        String str3;
        if (B2.a(str)) {
            Intrinsics.checkNotNull(str);
            return a(context, r7, str, (String) null);
        }
        try {
            Uri parse = Uri.parse(str2);
            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(this)");
            try {
                str3 = Intent.parseUri(str2, 1).getStringExtra("browser_fallback_url");
            } catch (URISyntaxException unused) {
                Intrinsics.checkNotNullExpressionValue("z2", "TAG");
                str3 = null;
            }
            if (Intrinsics.areEqual("intent", parse.getScheme()) && B2.a(str3)) {
                String decode = URLDecoder.decode(str3, "UTF-8");
                Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
                return a(context, r7, decode, (String) null);
            }
        } catch (Exception unused2) {
            Intrinsics.checkNotNullExpressionValue("z2", "TAG");
        }
        return null;
    }

    public static List b(Context context, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() == 0 || context == null) {
            return CollectionsKt.emptyList();
        }
        Intent parseUri = Intent.parseUri(url, 3);
        Intrinsics.checkNotNullExpressionValue(parseUri, "parseUri(...)");
        List<ResolveInfo> queryIntentActivityOptions = context.getPackageManager().queryIntentActivityOptions((ComponentName) null, (Intent[]) null, parseUri, 0);
        Intrinsics.checkNotNullExpressionValue(queryIntentActivityOptions, "queryIntentActivityOptions(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : queryIntentActivityOptions) {
            if (((ResolveInfo) obj).activityInfo.exported) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static int a(Context context, String url, ResolveInfo resolveInfo, InterfaceC2961yb redirectionValidator, String api) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(redirectionValidator, "redirectionValidator");
        Intrinsics.checkNotNullParameter(api, "api");
        if (context == null) {
            return 7;
        }
        if (!redirectionValidator.d()) {
            redirectionValidator.a("EX_" + api);
            return 8;
        }
        Intent parseUri = Intent.parseUri(url, 3);
        Intrinsics.checkNotNullExpressionValue(parseUri, "parseUri(...)");
        if ((resolveInfo != null ? resolveInfo.activityInfo : null) != null) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if ((activityInfo != null ? activityInfo.packageName : null) != null) {
                if ((activityInfo != null ? activityInfo.name : null) != null) {
                    parseUri.setClassName(activityInfo.packageName, activityInfo.name);
                }
            }
        }
        parseUri.setFlags(268435456);
        context.startActivity(parseUri);
        return 0;
    }

    public static int a(Context context, String url, InterfaceC2961yb redirectionValidator, String api) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(redirectionValidator, "redirectionValidator");
        Intrinsics.checkNotNullParameter(api, "api");
        if (context == null) {
            return 7;
        }
        if (!redirectionValidator.d()) {
            redirectionValidator.a("EX_" + api);
            return 8;
        }
        String str = null;
        try {
            Intent parseUri = Intent.parseUri(url, 0);
            parseUri.setFlags(268435456);
            context.startActivity(parseUri);
            return 0;
        } catch (ActivityNotFoundException e) {
            Uri parse = Uri.parse(url);
            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(this)");
            try {
                str = Intent.parseUri(url, 1).getStringExtra("browser_fallback_url");
            } catch (URISyntaxException unused) {
                Intrinsics.checkNotNullExpressionValue("z2", "TAG");
            }
            if (!Intrinsics.areEqual("intent", parse.getScheme())) {
                throw e;
            }
            if (str == null) {
                throw e;
            }
            if (str.length() != 0) {
                return a(context, str, redirectionValidator, api);
            }
            throw e;
        } catch (NullPointerException e2) {
            Uri parse2 = Uri.parse(url);
            Intrinsics.checkNotNullExpressionValue(parse2, "Uri.parse(this)");
            try {
                str = Intent.parseUri(url, 1).getStringExtra("browser_fallback_url");
            } catch (URISyntaxException unused2) {
                Intrinsics.checkNotNullExpressionValue("z2", "TAG");
            }
            if (!Intrinsics.areEqual("intent", parse2.getScheme())) {
                throw e2;
            }
            if (str == null) {
                throw e2;
            }
            if (str.length() != 0) {
                return a(context, str, redirectionValidator, api);
            }
            throw e2;
        }
    }

    public static String a(Context context, R7 redirectionValidator, String url, String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(redirectionValidator, "redirectionValidator");
        Intrinsics.checkNotNullParameter("NATIVE", "api");
        if (context == null) {
            return null;
        }
        redirectionValidator.getClass();
        try {
            Intent parseUri = Intent.parseUri(url, 0);
            if (parseUri.resolveActivity(context.getPackageManager()) != null) {
                parseUri.setFlags(268435456);
                context.startActivity(parseUri);
                return url;
            }
            Intrinsics.checkNotNullExpressionValue("z2", "TAG");
            return b(context, redirectionValidator, str, url);
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("z2", "TAG");
            return b(context, redirectionValidator, str, url);
        }
    }

    public static boolean a(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Intrinsics.areEqual("http", uri.getScheme()) || Intrinsics.areEqual("https", uri.getScheme());
    }

    public static boolean a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Uri parse = Uri.parse(url);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(this)");
        return (!a(parse) || Intrinsics.areEqual("play.google.com", parse.getHost()) || Intrinsics.areEqual("market.android.com", parse.getHost()) || Intrinsics.areEqual("market", parse.getScheme())) ? false : true;
    }
}
