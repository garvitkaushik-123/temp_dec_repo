package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MGA extends ui {
    private static String Xb = "";
    private Runnable DbA;
    protected com.bytedance.sdk.component.adexpress.dynamic.Os.FC QX;
    private volatile boolean bf;
    private Runnable eli;

    public MGA(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        this.bf = true;
        setTag(Integer.valueOf(getClickArea()));
        String DbA2 = wCVar.aAs().DbA();
        if ("logo-union".equals(DbA2)) {
            dynamicRootView.setLogoUnionHeight(this.wC - ((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(context, this.nlS.DbA() + this.nlS.eli())));
        } else if ("scoreCountWithIcon".equals(DbA2)) {
            dynamicRootView.setScoreCountWithIcon(this.wC - ((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(context, this.nlS.DbA() + this.nlS.eli())));
        }
    }

    private String DbA(String str) {
        try {
            Map<String, String> du = this.nn.getRenderRequest().du();
            if (du != null && du.size() > 0) {
                return du.get(str);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.kb, this.wC);
    }

    public boolean FC() {
        int i;
        int i2;
        Drawable backgroundDrawable;
        JSONObject optJSONObject;
        final View view = this.Dfc == null ? this : this.Dfc;
        setContentDescription(this.NU.eli(this.nlS.Ue()));
        String rn = this.nlS.rn();
        String str = null;
        String eli2 = (TextUtils.isEmpty(rn) || this.nn == null || this.nn.getRenderRequest() == null || this.nn.getRenderRequest().Os() == null || (optJSONObject = this.nn.getRenderRequest().Os().optJSONObject("creative")) == null) ? null : eli(optJSONObject.opt(rn));
        if (TextUtils.isEmpty(eli2)) {
            eli2 = this.nlS.bf();
        }
        com.bytedance.sdk.component.adexpress.eli.eli.Os Os2 = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os();
        if (Os2 != null) {
            i = Os2.Dfc();
            i2 = Os2.aqO();
        } else {
            i = 0;
            i2 = 0;
        }
        if (this.nlS.Xb()) {
            int QX = this.nlS.QX();
            String str2 = this.nlS.DbA;
            com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().ui().eli(str2).eli(this.kb).DbA(this.wC).aGH(i).ui(i2).eli(DbA(str2)).Os(2).eli(new Os(this.du, QX)).eli(new DbA(view, this));
        } else if (!TextUtils.isEmpty(eli2)) {
            if (!eli2.startsWith("http:") && !eli2.startsWith("https:")) {
                if (this.nn != null && this.nn.getRenderRequest() != null) {
                    str = this.nn.getRenderRequest().Vy();
                }
                eli2 = com.bytedance.sdk.component.adexpress.dynamic.ui.FC.DbA(eli2, str);
            }
            com.bytedance.sdk.component.ui.aAs Os3 = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().ui().eli(eli2).eli(this.kb).DbA(this.wC).aGH(i).ui(i2).eli(DbA(eli2)).Os(1);
            eli(Os3);
            Os3.eli(new eli(view, this.nn, this.NU));
        }
        if (getBackground() == null && (backgroundDrawable = getBackgroundDrawable()) != null) {
            view.setBackground(backgroundDrawable);
        }
        if (this.nlS.VM() > 0.0d) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (MGA.this.nlS.Cp() > 0) {
                            MGA mga = MGA.this;
                            Drawable Os4 = mga.Os(mga.nn.getBgMaterialCenterCalcColor().get(Integer.valueOf(MGA.this.nlS.Cp())));
                            if (Os4 == null) {
                                MGA mga2 = MGA.this;
                                Os4 = mga2.eli(true, mga2.nn.getBgMaterialCenterCalcColor().get(Integer.valueOf(MGA.this.nlS.Cp())));
                            }
                            if (Os4 != null) {
                                view.setBackground(Os4);
                                return;
                            }
                            View view2 = view;
                            MGA mga3 = MGA.this;
                            view2.setBackground(mga3.eli(true, mga3.nn.getBgColor()));
                        }
                    } catch (Exception unused) {
                    }
                }
            }, (long) (this.nlS.VM() * 1000.0d));
        }
        if (this.Dfc != null) {
            this.Dfc.setPadding((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.Os()), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.DbA()), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.aGH()), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.eli()));
        }
        if (this.aqO || this.nlS.nn() > 0.0d) {
            setShouldInvisible(true);
            view.setVisibility(4);
            setVisibility(4);
        }
        return true;
    }

    private static class Os implements com.bytedance.sdk.component.ui.wC {
        private final int DbA;
        private final WeakReference<Context> eli;

        public Os(Context context, int i) {
            this.eli = new WeakReference<>(context);
            this.DbA = i;
        }

        @Override // com.bytedance.sdk.component.ui.wC
        public Bitmap eli(Bitmap bitmap) {
            Context context = this.eli.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.aGH.eli.eli(context, bitmap, this.DbA);
            }
            return null;
        }
    }

    private static class DbA implements com.bytedance.sdk.component.ui.aqO {
        private final WeakReference<ui> DbA;
        private final WeakReference<View> eli;

        @Override // com.bytedance.sdk.component.ui.aqO
        public void eli(int i, String str, Throwable th) {
        }

        public DbA(View view, ui uiVar) {
            this.eli = new WeakReference<>(view);
            this.DbA = new WeakReference<>(uiVar);
        }

        @Override // com.bytedance.sdk.component.ui.aqO
        public void eli(com.bytedance.sdk.component.ui.du duVar) {
            Object DbA;
            ui uiVar;
            View view = this.eli.get();
            if (view == null || (DbA = duVar.DbA()) == null || duVar.Os() == null || (uiVar = this.DbA.get()) == null || !(DbA instanceof Bitmap)) {
                return;
            }
            view.setBackground(uiVar.eli((Bitmap) DbA));
        }
    }

    private static class eli implements com.bytedance.sdk.component.ui.aqO {
        private final WeakReference<DynamicRootView> DbA;
        private final com.bytedance.sdk.component.adexpress.dynamic.aGH.wC Os;
        private final WeakReference<View> eli;

        @Override // com.bytedance.sdk.component.ui.aqO
        public void eli(int i, String str, Throwable th) {
        }

        public eli(View view, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
            this.eli = new WeakReference<>(view);
            this.DbA = new WeakReference<>(dynamicRootView);
            this.Os = wCVar;
        }

        @Override // com.bytedance.sdk.component.ui.aqO
        public void eli(com.bytedance.sdk.component.ui.du duVar) {
            Drawable drawable;
            View view = this.eli.get();
            Object DbA = duVar.DbA();
            if (DbA instanceof Bitmap) {
                drawable = new BitmapDrawable((Bitmap) DbA);
            } else if (DbA instanceof Drawable) {
                if (DbA instanceof AnimatedImageDrawable) {
                    ((AnimatedImageDrawable) DbA).start();
                }
                drawable = (Drawable) DbA;
            } else {
                drawable = null;
            }
            if (!com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                DynamicRootView dynamicRootView = this.DbA.get();
                if (dynamicRootView == null) {
                    return;
                }
                if (!"open_ad".equals(dynamicRootView.getRenderRequest().aGH()) && !"splash_ad".equals(dynamicRootView.getRenderRequest().aGH())) {
                    view.setBackground(drawable);
                    return;
                } else {
                    view.setBackground(drawable);
                    return;
                }
            }
            if (view == null) {
                return;
            }
            view.setBackground(drawable);
            com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar = this.Os;
            if (wCVar == null || wCVar.aAs() == null || 6 != this.Os.aAs().eli() || view.getBackground() == null) {
                return;
            }
            view.getBackground().setAutoMirrored(true);
        }
    }

    private String eli(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof JSONArray) {
            return eli(((JSONArray) obj).opt(0));
        }
        if (obj instanceof JSONObject) {
            return eli((Object) ((JSONObject) obj).optString("url"));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable Os(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            String str2 = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.getString(i).startsWith("#")) {
                    arrayList.add(jSONArray.getString(i));
                } else if (jSONArray.getString(i).endsWith("deg")) {
                    str2 = jSONArray.getString(i);
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = com.bytedance.sdk.component.adexpress.dynamic.aGH.kb.eli(((String) arrayList.get(i2)).substring(0, 7));
            }
            GradientDrawable eli2 = eli(eli(str2), iArr);
            eli2.setShape(0);
            eli2.setCornerRadius(com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.Dfc()));
            return eli2;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void eli(com.bytedance.sdk.component.ui.aAs aas) {
        if ("SMARTISAN".equals(Build.BRAND) && "SM901".equals(getBuildModel())) {
            aas.eli(Bitmap.Config.ARGB_8888);
        }
    }

    private static String getBuildModel() {
        try {
            Xb = com.bytedance.sdk.component.utils.gG.eli();
        } catch (Throwable unused) {
            Xb = Build.MODEL;
        }
        if (TextUtils.isEmpty(Xb)) {
            Xb = Build.MODEL;
        }
        return Xb;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        View view = this.Dfc == null ? this : this.Dfc;
        double Xb2 = this.NU.aAs().ui().Xb();
        if (Xb2 < 90.0d && Xb2 > 0.0d) {
            com.bytedance.sdk.component.utils.FC.DbA().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA.2
                @Override // java.lang.Runnable
                public void run() {
                    MGA.this.setVisibility(8);
                }
            }, (long) (Xb2 * 1000.0d));
        }
        eli(this.NU.aAs().ui().QX(), view);
        if (!TextUtils.isEmpty(this.nlS.FS())) {
            eli();
        }
        super.onAttachedToWindow();
    }

    private void eli(double d, final View view) {
        if (d > 0.0d) {
            com.bytedance.sdk.component.utils.FC.DbA().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA.3
                @Override // java.lang.Runnable
                public void run() {
                    if (MGA.this.NU.aAs().ui().QW() != null) {
                        return;
                    }
                    view.setVisibility(0);
                    MGA.this.setVisibility(0);
                }
            }, (long) (d * 1000.0d));
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            removeCallbacks(this.eli);
            removeCallbacks(this.DbA);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i) instanceof com.bytedance.sdk.component.adexpress.dynamic.Os.FC) {
                viewGroup.removeViewAt(i);
            }
        }
    }

    private void eli() {
        if (this.bf) {
            int WfR = this.nlS.WfR();
            int ow = this.nlS.ow();
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA.4
                @Override // java.lang.Runnable
                public void run() {
                    if (MGA.this.nn != null && MGA.this.nn.getRenderRequest() != null) {
                        com.bytedance.sdk.component.adexpress.DbA.NU renderRequest = MGA.this.nn.getRenderRequest();
                        com.bytedance.sdk.component.adexpress.dynamic.aGH.aAs aas = new com.bytedance.sdk.component.adexpress.dynamic.aGH.aAs();
                        aas.eli(renderRequest.Dfc());
                        aas.DbA(renderRequest.aqO());
                        aas.Os(renderRequest.dV());
                        aas.eli(renderRequest.nGm());
                        aas.DbA(renderRequest.QX());
                        aas.Os(renderRequest.Xb());
                        aas.aGH(renderRequest.bf());
                        aas.ui(renderRequest.CMM());
                        MGA mga = MGA.this;
                        Context context = MGA.this.du;
                        MGA mga2 = MGA.this;
                        mga.QX = new com.bytedance.sdk.component.adexpress.dynamic.Os.FC(context, mga2, mga2.nlS, aas, renderRequest);
                    } else {
                        MGA mga3 = MGA.this;
                        Context context2 = MGA.this.du;
                        MGA mga4 = MGA.this;
                        mga3.QX = new com.bytedance.sdk.component.adexpress.dynamic.Os.FC(context2, mga4, mga4.nlS);
                    }
                    MGA mga5 = MGA.this;
                    mga5.DbA(mga5.QX);
                    if (MGA.this.getParent() instanceof ViewGroup) {
                        ((ViewGroup) MGA.this.getParent()).setClipChildren(false);
                    }
                    MGA.this.setClipChildren(false);
                    MGA.this.QX.setTag(2);
                    MGA mga6 = MGA.this;
                    mga6.eli((ViewGroup) mga6);
                    MGA mga7 = MGA.this;
                    mga7.addView(mga7.QX, new FrameLayout.LayoutParams(-1, -1));
                    MGA.this.QX.Os();
                }
            };
            this.eli = runnable;
            postDelayed(runnable, WfR * 1000);
            if (this.nlS.TfR() || ow >= Integer.MAX_VALUE || WfR >= ow) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA.5
                @Override // java.lang.Runnable
                public void run() {
                    if (MGA.this.QX != null) {
                        MGA.this.bf = false;
                        MGA.this.QX.aGH();
                        MGA.this.QX.setVisibility(4);
                        MGA mga = MGA.this;
                        mga.removeView(mga.QX);
                    }
                }
            };
            this.DbA = runnable2;
            postDelayed(runnable2, ow * 1000);
        }
    }
}
