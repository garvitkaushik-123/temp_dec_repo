package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.res.Resources;

/* compiled from: BaseDomainSameTool.java */
/* loaded from: classes6.dex */
public class e {
    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            Resources resources = context.getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android")) > 0;
        } catch (Throwable th) {
            p0.b("DomainSameTool", th.getMessage(), th);
            return false;
        }
    }
}
