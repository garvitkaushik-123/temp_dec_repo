package com.inmobi.media;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.l1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2739l1 {
    public static boolean a(Context context, String url, InterfaceC2961yb redirectionValidator, String api, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(redirectionValidator, "redirectionValidator");
        Intrinsics.checkNotNullParameter(api, "api");
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("AppstoreLinkHandler", "In appStoreLinkHandled");
        }
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() != 0) {
            Uri parse = Uri.parse(url);
            if (Intrinsics.areEqual("market", parse.getScheme()) || Intrinsics.areEqual("play.google.com", parse.getHost()) || Intrinsics.areEqual("market.android.com", parse.getHost())) {
                Uri parse2 = Uri.parse(url);
                if (context != null) {
                    try {
                        context.getPackageManager().getPackageInfo("com.android.vending", 0);
                        if (!redirectionValidator.d()) {
                            redirectionValidator.a("EX_" + api);
                            return false;
                        }
                        try {
                            Intent intent = new Intent("android.intent.action.VIEW", parse2);
                            intent.setPackage("com.android.vending");
                            intent.addFlags(268435456);
                            context.startActivity(intent);
                            if (interfaceC2971z5 != null) {
                                ((A5) interfaceC2971z5).c("AppstoreLinkHandler", "Playstore link handled successfully");
                            }
                            return true;
                        } catch (Exception e) {
                            if (interfaceC2971z5 != null) {
                                ((A5) interfaceC2971z5).c("AppstoreLinkHandler", rf.a(e, new StringBuilder("Error message in processing appStoreLinkHandling: ")));
                            }
                            return false;
                        }
                    } catch (PackageManager.NameNotFoundException e2) {
                        e2.printStackTrace();
                    }
                }
                int a2 = C3.a(context, url, redirectionValidator, api, interfaceC2971z5);
                if (a2 != 0 && a2 != 1) {
                    return false;
                }
                if (interfaceC2971z5 != null) {
                    ((A5) interfaceC2971z5).c("AppstoreLinkHandler", "Playstore link handled successfully");
                }
                return true;
            }
        }
        return false;
    }
}
