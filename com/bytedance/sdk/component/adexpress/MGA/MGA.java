package com.bytedance.sdk.component.adexpress.MGA;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MGA extends CMM {
    private Xb eli;

    public MGA(Context context, int i, int i2, int i3, JSONObject jSONObject) {
        super(context);
        eli(context, i, i2, i3, jSONObject);
    }

    private void eli(Context context, int i, int i2, int i3, JSONObject jSONObject) {
        Xb xb = new Xb(context, com.bytedance.sdk.component.adexpress.Os.eli.Os(context), i, i2, i3, jSONObject);
        this.eli = xb;
        addView(xb);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.eli.setLayoutParams(layoutParams);
    }

    public Xb getShakeView() {
        return this.eli;
    }

    public void setShakeText(String str) {
        if (this.eli == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.eli.setShakeText("");
        } else {
            this.eli.setShakeText(str);
        }
    }
}
