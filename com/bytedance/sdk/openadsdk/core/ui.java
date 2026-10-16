package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.MGA;

/* loaded from: classes3.dex */
public class ui extends MGA {
    private static volatile ui eli;

    @Override // com.bytedance.sdk.openadsdk.core.MGA
    public /* bridge */ /* synthetic */ MGA.Os eli() {
        return super.eli();
    }

    public static ui eli(Context context) {
        if (eli == null) {
            synchronized (ui.class) {
                if (eli == null) {
                    eli = new ui(context);
                }
            }
        }
        return eli;
    }

    private ui(Context context) {
        super(context);
    }
}
