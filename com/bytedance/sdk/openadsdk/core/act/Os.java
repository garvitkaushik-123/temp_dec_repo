package com.bytedance.sdk.openadsdk.core.act;

import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;

/* loaded from: classes3.dex */
public class Os implements DbA {
    public static void eli(Context context, String str, CustomTabsIntent customTabsIntent, Uri uri) {
        customTabsIntent.intent.setPackage(str);
        customTabsIntent.launchUrl(context, uri);
    }

    @Override // com.bytedance.sdk.openadsdk.core.act.DbA
    public void eli(CustomTabsClient customTabsClient) {
        throw null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.act.DbA
    public void eli() {
        throw null;
    }
}
