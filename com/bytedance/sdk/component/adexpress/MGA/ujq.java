package com.bytedance.sdk.component.adexpress.MGA;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class ujq extends LinearLayout {
    private com.bytedance.sdk.component.utils.Vy DbA;
    private com.bytedance.adsdk.DbA.MGA MGA;
    private TextView Os;
    private eli aGH;
    private TextView eli;
    private com.bytedance.sdk.component.adexpress.dynamic.aGH.aAs kb;
    private LinearLayout ui;

    public interface eli {
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
    }

    public ujq(Context context, View view, com.bytedance.sdk.component.adexpress.dynamic.aGH.aAs aas) {
        super(context);
        this.kb = aas;
        eli(context, view);
    }

    private void eli(Context context, View view) {
        setClipChildren(false);
        addView(view);
        this.ui = (LinearLayout) findViewById(2097610722);
        this.eli = (TextView) findViewById(2097610719);
        this.Os = (TextView) findViewById(2097610718);
        com.bytedance.adsdk.DbA.MGA mga = (com.bytedance.adsdk.DbA.MGA) findViewById(2097610706);
        this.MGA = mga;
        mga.setAnimation("lottie_json/twist_multi_angle.json");
        this.MGA.setImageAssetsFolder("images/");
        this.MGA.eli(true);
    }

    public void setShakeText(String str) {
        this.Os.setText(str);
    }

    public LinearLayout getWriggleLayout() {
        return this.ui;
    }

    public View getWriggleProgressIv() {
        return this.MGA;
    }

    public TextView getTopTextView() {
        return this.eli;
    }

    public void setOnShakeViewListener(eli eliVar) {
        this.aGH = eliVar;
    }

    public void eli() {
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.MGA.ujq.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ujq.this.MGA.eli();
                } catch (Throwable unused) {
                }
            }
        }, 500L);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.DbA == null) {
                this.DbA = new com.bytedance.sdk.component.utils.Vy(getContext().getApplicationContext(), 2);
            }
            new Object() { // from class: com.bytedance.sdk.component.adexpress.MGA.ujq.2
            };
            com.bytedance.sdk.component.adexpress.dynamic.aGH.aAs aas = this.kb;
            if (aas != null) {
                aas.Os();
                this.kb.ui();
                this.kb.MGA();
                this.kb.wC();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            com.bytedance.adsdk.DbA.MGA mga = this.MGA;
            if (mga != null) {
                mga.ui();
            }
        } catch (Exception unused) {
        }
    }
}
