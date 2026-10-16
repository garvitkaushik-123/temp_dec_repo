package com.bytedance.sdk.component.MGA.eli.eli.eli;

import android.content.Context;
import com.bytedance.sdk.component.MGA.eli.eli.eli.DbA;

/* loaded from: classes3.dex */
public class eli extends DbA {
    private static volatile eli eli;

    @Override // com.bytedance.sdk.component.MGA.eli.eli.eli.DbA
    public /* bridge */ /* synthetic */ DbA.C0135DbA eli() {
        return super.eli();
    }

    public static eli eli(Context context) {
        if (eli == null) {
            synchronized (eli.class) {
                if (eli == null) {
                    eli = new eli(context);
                }
            }
        }
        return eli;
    }

    private eli(Context context) {
        super(context);
    }
}
