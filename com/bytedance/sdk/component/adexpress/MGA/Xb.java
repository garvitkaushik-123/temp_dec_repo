package com.bytedance.sdk.component.adexpress.MGA;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Xb extends QX {
    private TextView eli;

    public Xb(Context context, View view, int i, int i2, int i3, JSONObject jSONObject) {
        super(context, view, i, i2, i3, jSONObject);
    }

    @Override // com.bytedance.sdk.component.adexpress.MGA.QX
    protected void eli(Context context, View view) {
        addView(view);
        this.eli = (TextView) findViewById(2097610747);
    }

    @Override // com.bytedance.sdk.component.adexpress.MGA.QX
    public void setShakeText(String str) {
        if (this.eli == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            try {
                this.eli.setText(com.bytedance.sdk.component.utils.ev.DbA(this.eli.getContext(), "tt_splash_default_click_shake"));
                return;
            } catch (Exception e) {
                e.getMessage();
                return;
            }
        }
        this.eli.setText(str);
    }
}
