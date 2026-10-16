package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class gG extends MGA {
    public gG(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        this.wC += 6;
        if (this.nlS.dZ()) {
            this.Dfc = new com.bytedance.sdk.component.adexpress.MGA.eli(context, this.nlS.kb(), this.nlS.ui(), 1, this.nlS.wC());
            ((com.bytedance.sdk.component.adexpress.MGA.eli) this.Dfc).setMaxLines(1);
        } else {
            this.Dfc = new TextView(context);
            ((TextView) this.Dfc).setIncludeFontPadding(false);
        }
        this.Dfc.setTag(Integer.valueOf(getClickArea()));
        addView(this.Dfc, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nro
    public boolean FC() {
        int i;
        double d;
        super.FC();
        if (TextUtils.isEmpty(getText())) {
            this.Dfc.setVisibility(4);
            return true;
        }
        if (this.nlS.dZ()) {
            du();
            return true;
        }
        ((TextView) this.Dfc).setText(this.nlS.MGA());
        ((TextView) this.Dfc).setTextDirection(5);
        this.Dfc.setTextAlignment(this.nlS.wC());
        ((TextView) this.Dfc).setTextColor(this.nlS.kb());
        ((TextView) this.Dfc).setTextSize(this.nlS.ui());
        if (!this.nlS.CMM()) {
            ((TextView) this.Dfc).setMaxLines(1);
            ((TextView) this.Dfc).setGravity(17);
            ((TextView) this.Dfc).setEllipsize(TextUtils.TruncateAt.END);
        } else {
            int ev = this.nlS.ev();
            if (ev > 0) {
                ((TextView) this.Dfc).setLines(ev);
                ((TextView) this.Dfc).setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        if (this.NU != null && this.NU.aAs() != null) {
            if (com.bytedance.sdk.component.adexpress.aGH.DbA() && eli() && (TextUtils.equals(this.NU.aAs().DbA(), "text_star") || TextUtils.equals(this.NU.aAs().DbA(), "score-count") || TextUtils.equals(this.NU.aAs().DbA(), "score-count-type-1") || TextUtils.equals(this.NU.aAs().DbA(), "score-count-type-2"))) {
                setVisibility(8);
                return true;
            }
            if (TextUtils.equals(this.NU.aAs().DbA(), "score-count") || TextUtils.equals(this.NU.aAs().DbA(), "score-count-type-2")) {
                try {
                    try {
                        i = Integer.parseInt(getText());
                    } catch (Exception unused) {
                    }
                } catch (NumberFormatException unused2) {
                    i = -1;
                }
                if (i < 0) {
                    if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                        setVisibility(8);
                        return true;
                    }
                    this.Dfc.setVisibility(0);
                }
                if (TextUtils.equals(this.NU.aAs().DbA(), "score-count-type-2")) {
                    ((TextView) this.Dfc).setText(String.format(new DecimalFormat("(###,###,###)").format(i), Integer.valueOf(i)));
                    ((TextView) this.Dfc).setGravity(17);
                    return true;
                }
                eli((TextView) this.Dfc, i, getContext(), "tt_comment_num");
            } else if (TextUtils.equals(this.NU.aAs().DbA(), "text_star")) {
                try {
                    d = Double.parseDouble(getText());
                } catch (Exception unused3) {
                    d = -1.0d;
                }
                if (d < 0.0d || d > 5.0d) {
                    if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                        setVisibility(8);
                        return true;
                    }
                    this.Dfc.setVisibility(0);
                }
                ((TextView) this.Dfc).setIncludeFontPadding(false);
                ((TextView) this.Dfc).setText(String.format("%.1f", Double.valueOf(d)));
            } else if (TextUtils.equals("privacy-detail", this.NU.aAs().DbA())) {
                ((TextView) this.Dfc).setText("Permission list | Privacy policy");
            } else if (TextUtils.equals(this.NU.aAs().DbA(), "development-name")) {
                ((TextView) this.Dfc).setText(com.bytedance.sdk.component.utils.ev.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), "tt_text_privacy_development") + getText());
            } else if (TextUtils.equals(this.NU.aAs().DbA(), "app-version")) {
                ((TextView) this.Dfc).setText(com.bytedance.sdk.component.utils.ev.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), "tt_text_privacy_app_version") + getText());
            } else {
                ((TextView) this.Dfc).setText(getText());
            }
            this.Dfc.setTextAlignment(this.nlS.wC());
            ((TextView) this.Dfc).setGravity(this.nlS.FC());
            if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                aAs();
            }
        }
        return true;
    }

    private boolean eli() {
        return (this.nn == null || this.nn.getRenderRequest() == null || this.nn.getRenderRequest().aAs() == 4) ? false : true;
    }

    private void aAs() {
        int eli;
        if (TextUtils.equals(this.NU.aAs().DbA(), "source") || TextUtils.equals(this.NU.aAs().DbA(), "title") || TextUtils.equals(this.NU.aAs().DbA(), "text_star")) {
            int[] DbA = com.bytedance.sdk.component.adexpress.dynamic.ui.du.DbA(this.nlS.MGA(), this.nlS.ui(), true);
            int eli2 = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(getContext(), this.nlS.DbA());
            int eli3 = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(getContext(), this.nlS.Os());
            int eli4 = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(getContext(), this.nlS.aGH());
            int eli5 = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(getContext(), this.nlS.eli());
            int min = Math.min(eli2, eli5);
            if (TextUtils.equals(this.NU.aAs().DbA(), "source") && (eli = ((this.wC - ((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(getContext(), this.nlS.ui()))) - eli2) - eli5) > 1 && eli <= min * 2) {
                int i = eli / 2;
                this.Dfc.setPadding(eli3, eli2 - i, eli4, eli5 - (eli - i));
                return;
            }
            int i2 = (((DbA[1] + eli2) + eli5) - this.wC) - 2;
            if (i2 <= 1) {
                return;
            }
            if (i2 <= min * 2) {
                int i3 = i2 / 2;
                this.Dfc.setPadding(eli3, eli2 - i3, eli4, eli5 - (i2 - i3));
            } else if (i2 > eli2 + eli5) {
                final int i4 = (i2 - eli2) - eli5;
                this.Dfc.setPadding(eli3, 0, eli4, 0);
                if (i4 <= ((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(getContext(), 1.0f)) + 1) {
                    ((TextView) this.Dfc).setTextSize(this.nlS.ui() - 1.0f);
                } else if (i4 <= (((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(getContext(), 1.0f)) + 1) * 2) {
                    ((TextView) this.Dfc).setTextSize(this.nlS.ui() - 2.0f);
                } else {
                    post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.gG.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ViewGroup.LayoutParams layoutParams = gG.this.Dfc.getLayoutParams();
                                layoutParams.height = gG.this.wC + i4;
                                gG.this.Dfc.setLayoutParams(layoutParams);
                                gG.this.Dfc.setTranslationY(-i4);
                                ViewGroup viewGroup = (ViewGroup) gG.this.Dfc.getParent();
                                ViewGroup viewGroup2 = viewGroup;
                                viewGroup.setClipChildren(false);
                                ViewGroup viewGroup3 = (ViewGroup) gG.this.Dfc.getParent().getParent();
                                ViewGroup viewGroup4 = viewGroup3;
                                viewGroup3.setClipChildren(false);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } else if (eli2 > eli5) {
                this.Dfc.setPadding(eli3, eli2 - (i2 - min), eli4, eli5 - min);
            } else {
                this.Dfc.setPadding(eli3, eli2 - min, eli4, eli5 - (i2 - min));
            }
        }
        if (TextUtils.equals(this.NU.aAs().DbA(), "fillButton")) {
            this.Dfc.setTextAlignment(2);
            ((TextView) this.Dfc).setGravity(17);
        }
    }

    public String getText() {
        String MGA = this.nlS.MGA();
        if (TextUtils.isEmpty(MGA)) {
            if (!com.bytedance.sdk.component.adexpress.aGH.DbA() && TextUtils.equals(this.NU.aAs().DbA(), "text_star")) {
                MGA = CampaignEx.CLICKMODE_ON;
            }
            if (!com.bytedance.sdk.component.adexpress.aGH.DbA() && TextUtils.equals(this.NU.aAs().DbA(), "score-count")) {
                MGA = "6870";
            }
        }
        return (TextUtils.equals(this.NU.aAs().DbA(), "title") || TextUtils.equals(this.NU.aAs().DbA(), "subtitle")) ? MGA.replace("\n", "") : MGA;
    }

    public void eli(TextView textView, int i, Context context, String str) {
        textView.setText("(" + String.format(com.bytedance.sdk.component.utils.ev.eli(context, str), Integer.valueOf(i)) + ")");
        if (i == -1) {
            textView.setVisibility(8);
        }
    }

    private void du() {
        if (this.Dfc instanceof com.bytedance.sdk.component.adexpress.MGA.eli) {
            String text = getText();
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(text);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
            } catch (JSONException unused) {
                arrayList.add(text);
            }
            ((com.bytedance.sdk.component.adexpress.MGA.eli) this.Dfc).setMaxLines(1);
            ((com.bytedance.sdk.component.adexpress.MGA.eli) this.Dfc).setTextColor(this.nlS.kb());
            ((com.bytedance.sdk.component.adexpress.MGA.eli) this.Dfc).setTextSize(this.nlS.ui());
            ((com.bytedance.sdk.component.adexpress.MGA.eli) this.Dfc).setAnimationText(arrayList);
            ((com.bytedance.sdk.component.adexpress.MGA.eli) this.Dfc).setAnimationType(this.nlS.Uv());
            ((com.bytedance.sdk.component.adexpress.MGA.eli) this.Dfc).setAnimationDuration(this.nlS.SSo() * 1000);
            ((com.bytedance.sdk.component.adexpress.MGA.eli) this.Dfc).eli();
        }
    }
}
