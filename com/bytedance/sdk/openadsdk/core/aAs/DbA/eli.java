package com.bytedance.sdk.openadsdk.core.aAs.DbA;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.ev;

/* loaded from: classes3.dex */
public class eli extends com.bytedance.adsdk.ugeno.FC.MGA.DbA {
    public eli(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.FC.MGA.DbA
    public void du(String str) {
        super.du(str);
        if (TextUtils.isEmpty(str) || TextUtils.equals("null", str)) {
            return;
        }
        try {
            ((com.bytedance.adsdk.ugeno.FC.MGA.eli) this.ui).setText("(" + String.format(ev.eli(this.DbA, "tt_comment_num"), Integer.valueOf(Integer.parseInt(str))) + ")");
        } catch (Exception unused) {
        }
    }
}
