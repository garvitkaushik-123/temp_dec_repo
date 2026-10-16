package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class du extends MGA {
    private String eli;

    public du(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        if (!TextUtils.isEmpty(this.nlS.GMY()) && wCVar.QX()) {
            com.bytedance.sdk.component.adexpress.MGA.aAs aas = new com.bytedance.sdk.component.adexpress.MGA.aAs(context);
            aas.setAnimationsLoop(this.nlS.rH());
            aas.setImageLottieTosPath(this.nlS.GMY());
            aas.setLottieAppNameMaxLength(this.nlS.Ca());
            aas.setLottieAdTitleMaxLength(this.nlS.PfW());
            aas.setLottieAdDescMaxLength(this.nlS.eEH());
            aas.setData(wCVar.Xb());
            this.Dfc = aas;
        } else if (this.nlS.Dfc() > 0.0f) {
            this.Dfc = new com.bytedance.sdk.component.adexpress.MGA.gG(context);
            ((com.bytedance.sdk.component.adexpress.MGA.gG) this.Dfc).setXRound((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(context, this.nlS.Dfc()));
            ((com.bytedance.sdk.component.adexpress.MGA.gG) this.Dfc).setYRound((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(context, this.nlS.Dfc()));
        } else if (!wC() && "arrowButton".equals(wCVar.aAs().DbA())) {
            com.bytedance.sdk.component.adexpress.dynamic.animation.view.DbA dbA = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.DbA(context);
            dbA.setBrickNativeValue(this.nlS);
            this.Dfc = dbA;
        } else if (com.bytedance.sdk.component.adexpress.aGH.FC.DbA(this.nlS.du())) {
            this.Dfc = new com.bytedance.sdk.component.adexpress.MGA.NU(context);
        } else {
            this.Dfc = new ImageView(context);
        }
        this.eli = getImageKey();
        this.Dfc.setTag(Integer.valueOf(getClickArea()));
        if ("arrowButton".equals(wCVar.aAs().DbA())) {
            if (this.nlS.DbA() > 0 || this.nlS.eli() > 0) {
                this.kb = Math.min(this.kb, this.wC);
                this.wC = Math.min(this.kb, this.wC);
                this.FC = (int) (this.FC + com.bytedance.sdk.component.adexpress.aGH.kb.eli(context, this.nlS.DbA() + (this.nlS.eli() / 2) + 0.5f));
            } else {
                this.kb = Math.max(this.kb, this.wC);
                this.wC = Math.max(this.kb, this.wC);
            }
            this.nlS.eli(this.kb / 2);
        }
        addView(this.Dfc, new FrameLayout.LayoutParams(this.kb, this.wC));
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = ((ImageView) this.Dfc).getDrawable();
        if (drawable instanceof AnimatedImageDrawable) {
            ((AnimatedImageDrawable) drawable).start();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = ((ImageView) this.Dfc).getDrawable();
        if (drawable instanceof AnimatedImageDrawable) {
            ((AnimatedImageDrawable) drawable).stop();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nro
    public boolean FC() {
        int i;
        super.FC();
        if (!TextUtils.isEmpty(this.nlS.GMY())) {
            ((ImageView) this.Dfc).setScaleType(ImageView.ScaleType.CENTER_CROP);
            return true;
        }
        int i2 = 0;
        if ("arrowButton".equals(this.NU.aAs().DbA())) {
            ((ImageView) this.Dfc).setImageResource(com.bytedance.sdk.component.utils.ev.aGH(this.du, "tt_white_righterbackicon_titlebar"));
            if (((ImageView) this.Dfc).getDrawable() != null) {
                ((ImageView) this.Dfc).getDrawable().setAutoMirrored(true);
            }
            this.Dfc.setPadding(0, 0, 0, 0);
            ((ImageView) this.Dfc).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        this.Dfc.setBackgroundColor(this.nlS.KM());
        String Os = this.NU.aAs().Os();
        if (AnalyticsConstants.SOURCE_USER_TYPE.equals(Os)) {
            ((ImageView) this.Dfc).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.Dfc).setColorFilter(this.nlS.kb());
            ((ImageView) this.Dfc).setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(getContext(), "tt_user"));
            ((ImageView) this.Dfc).setPadding(this.kb / 10, this.wC / 5, this.kb / 10, 0);
        } else if (Os != null && Os.startsWith("@")) {
            try {
                ((ImageView) this.Dfc).setImageResource(Integer.parseInt(Os.substring(1)));
            } catch (Exception unused) {
            }
        }
        com.bytedance.sdk.component.ui.Dfc ui = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().ui();
        String du = this.nlS.du();
        if (!TextUtils.isEmpty(du) && !du.startsWith("http:") && !du.startsWith("https:")) {
            du = com.bytedance.sdk.component.adexpress.dynamic.ui.FC.DbA(du, (this.nn == null || this.nn.getRenderRequest() == null) ? null : this.nn.getRenderRequest().Vy());
        }
        com.bytedance.sdk.component.adexpress.eli.eli.Os Os2 = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os();
        if (Os2 != null) {
            i2 = Os2.Dfc();
            i = Os2.aqO();
        } else {
            i = 0;
        }
        com.bytedance.sdk.component.ui.aAs ui2 = ui.eli(du).eli(this.eli).eli(this.kb).DbA(this.wC).aGH(i2).ui(i);
        String nn = this.nn.getRenderRequest().nn();
        if (!TextUtils.isEmpty(nn)) {
            ui2.DbA(nn);
        }
        if (eli()) {
            ((ImageView) this.Dfc).setScaleType(ImageView.ScaleType.FIT_CENTER);
            ui2.eli(Bitmap.Config.ARGB_4444).Os(2).eli(new eli(this.du)).eli(new DbA(this.Dfc, getResources()));
        } else {
            if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                ui2.Os(1).eli((ImageView) this.Dfc);
            }
            ((ImageView) this.Dfc).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if ((this.Dfc instanceof ImageView) && "cover".equals(getImageObjectFit())) {
            ((ImageView) this.Dfc).setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        return true;
    }

    private static class eli implements com.bytedance.sdk.component.ui.wC {
        private final WeakReference<Context> eli;

        public eli(Context context) {
            this.eli = new WeakReference<>(context);
        }

        @Override // com.bytedance.sdk.component.ui.wC
        public Bitmap eli(Bitmap bitmap) {
            Context context = this.eli.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.aGH.eli.eli(context, bitmap, 25);
            }
            return null;
        }
    }

    private static class DbA implements com.bytedance.sdk.component.ui.aqO {
        private Resources DbA;
        private WeakReference<View> eli;

        @Override // com.bytedance.sdk.component.ui.aqO
        public void eli(int i, String str, Throwable th) {
        }

        public DbA(View view, Resources resources) {
            this.eli = new WeakReference<>(view);
            this.DbA = resources;
        }

        @Override // com.bytedance.sdk.component.ui.aqO
        public void eli(com.bytedance.sdk.component.ui.du duVar) {
            Object DbA;
            View view = this.eli.get();
            if (view == null || (DbA = duVar.DbA()) == null || duVar.Os() == null) {
                return;
            }
            if (DbA instanceof Bitmap) {
                view.setBackground(new BitmapDrawable(this.DbA, (Bitmap) DbA));
            } else if (DbA instanceof Drawable) {
                if (DbA instanceof AnimatedImageDrawable) {
                    ((AnimatedImageDrawable) DbA).start();
                }
                view.setBackground((Drawable) DbA);
            }
        }
    }

    private boolean eli() {
        String nlS = this.nlS.nlS();
        if (this.nlS.Xb()) {
            return true;
        }
        if (TextUtils.isEmpty(nlS)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(nlS);
            return Math.abs((((float) this.kb) / (((float) this.wC) * 1.0f)) - (((float) jSONObject.optInt("width")) / (((float) jSONObject.optInt("height")) * 1.0f))) > 0.01f;
        } catch (JSONException unused) {
            return false;
        }
    }

    private String getImageKey() {
        Map<String, String> du = this.nn.getRenderRequest().du();
        if (du == null || du.size() <= 0) {
            return null;
        }
        return du.get(this.nlS.du());
    }
}
