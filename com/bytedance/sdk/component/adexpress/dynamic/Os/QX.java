package com.bytedance.sdk.component.adexpress.dynamic.Os;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.MGA.ujq;
import com.bytedance.sdk.component.utils.ev;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class QX implements kb<ujq> {
    private Context DbA;
    private com.bytedance.sdk.component.adexpress.dynamic.aGH.aAs MGA;
    private com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui Os;
    private com.bytedance.sdk.component.adexpress.dynamic.aGH.kb aGH;
    private ujq eli;
    private String ui;

    public QX(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui uiVar, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar, String str, com.bytedance.sdk.component.adexpress.dynamic.aGH.aAs aas) {
        this.DbA = context;
        this.Os = uiVar;
        this.aGH = kbVar;
        this.ui = str;
        this.MGA = aas;
        ui();
    }

    private void ui() {
        int tGZ = this.aGH.tGZ();
        final com.bytedance.sdk.component.adexpress.dynamic.MGA.eli dynamicClickListener = this.Os.getDynamicClickListener();
        try {
            new JSONObject().put("convertActionType", 2);
        } catch (Throwable unused) {
        }
        if ("18".equals(this.ui)) {
            Context context = this.DbA;
            ujq ujqVar = new ujq(context, com.bytedance.sdk.component.adexpress.Os.eli.FC(context), this.MGA);
            this.eli = ujqVar;
            if (ujqVar.getWriggleLayout() != null) {
                this.eli.getWriggleLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
            if (this.eli.getTopTextView() != null) {
                if (TextUtils.isEmpty(this.aGH.DE())) {
                    this.eli.getTopTextView().setText(ev.DbA(this.DbA, "tt_splash_wriggle_top_text_style_17"));
                } else {
                    this.eli.getTopTextView().setText(this.aGH.DE());
                }
            }
        } else {
            Context context2 = this.DbA;
            this.eli = new ujq(context2, com.bytedance.sdk.component.adexpress.Os.eli.FC(context2), this.MGA);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        this.eli.setTranslationY(-((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.DbA, tGZ)));
        this.eli.setLayoutParams(layoutParams);
        this.eli.setShakeText(this.aGH.QI());
        this.eli.setClipChildren(false);
        final View wriggleProgressIv = this.eli.getWriggleProgressIv();
        this.eli.setOnShakeViewListener(new ujq.eli() { // from class: com.bytedance.sdk.component.adexpress.dynamic.Os.QX.1
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    public void eli() {
        this.eli.eli();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    public void DbA() {
        this.eli.clearAnimation();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.kb
    /* renamed from: aGH, reason: merged with bridge method [inline-methods] */
    public ujq Os() {
        return this.eli;
    }
}
