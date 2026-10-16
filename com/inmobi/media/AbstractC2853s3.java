package com.inmobi.media;

import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.s3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2853s3 {
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, CustomTabsIntent customTabsIntent, Uri uri, InterfaceC2624e2 interfaceC2624e2, R6 r6, InterfaceC2961yb interfaceC2961yb, String api) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customTabsIntent, "customTabsIntent");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(api, "api");
        String a2 = AbstractC2934x3.a(context);
        try {
            try {
                if (a2 == null) {
                    Intrinsics.checkNotNullExpressionValue("v3", "access$getLOG_TAG$cp(...)");
                    if (interfaceC2624e2 != null) {
                        String uri2 = uri.toString();
                        Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
                        interfaceC2624e2.a(uri2, api, r6);
                        return;
                    }
                    return;
                }
                customTabsIntent.intent.setFlags(268435456);
                customTabsIntent.intent.setPackage(a2);
                customTabsIntent.launchUrl(context, uri);
                if (r6 != null) {
                    r6.g = "IN_NATIVE";
                }
                if (interfaceC2624e2 != null) {
                    interfaceC2624e2.a(F6.f, r6, (Integer) null);
                }
            } catch (Exception unused) {
                String uri3 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri3, "toString(...)");
                Intrinsics.checkNotNull(interfaceC2961yb);
                i = AbstractC2968z2.a(context, uri3, interfaceC2961yb, api);
                if (r6 != null) {
                    r6.g = "EX_NATIVE";
                }
                if (i != 0 || i == 1) {
                    if (interfaceC2624e2 == null) {
                        interfaceC2624e2.a(F6.f, r6, (Integer) null);
                    }
                } else if (interfaceC2624e2 != null) {
                    interfaceC2624e2.a(F6.g, r6, Integer.valueOf(i));
                }
            }
        } catch (Exception unused2) {
            i = 9;
            if (r6 != null) {
            }
            if (i != 0) {
            }
            if (interfaceC2624e2 == null) {
            }
        }
    }
}
