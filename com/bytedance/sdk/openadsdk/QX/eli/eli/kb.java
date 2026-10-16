package com.bytedance.sdk.openadsdk.QX.eli.eli;

import android.content.Context;
import com.bytedance.sdk.openadsdk.utils.dZ;

/* loaded from: classes3.dex */
public class kb {
    public static MGA eli(Context context, String str) {
        if (Os.eli()) {
            return new ui(context, str);
        }
        if (dZ.aGH(context)) {
            return new aGH(context, str);
        }
        return new eli(context, str);
    }
}
