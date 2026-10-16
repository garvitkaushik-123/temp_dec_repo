package com.bytedance.sdk.component.adexpress.aGH;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class DbA {
    public static boolean eli(Context context) {
        return context != null && TextUtils.getLayoutDirectionFromLocale(context.getResources().getConfiguration().locale) == 1 && (context.getApplicationInfo().flags & 4194304) == 4194304;
    }
}
