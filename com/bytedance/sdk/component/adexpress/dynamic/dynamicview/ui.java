package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class ui extends FrameLayout implements IAnimation, Cp, nro {
    private static final View.OnTouchListener CMM = new View.OnTouchListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    private static final View.OnClickListener ev = new View.OnClickListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };
    private float DbA;
    protected View Dfc;
    protected int FC;
    protected float MGA;
    protected com.bytedance.sdk.component.adexpress.dynamic.aGH.wC NU;
    protected float Os;
    private float QX;
    private float Xb;
    protected int aAs;
    protected float aGH;
    protected boolean aqO;
    private com.bytedance.sdk.component.utils.Vy bf;
    protected com.bytedance.sdk.component.adexpress.dynamic.animation.eli.DbA dV;
    protected Context du;
    private float eli;
    protected int kb;
    com.bytedance.sdk.component.adexpress.dynamic.animation.view.Os nGm;
    protected com.bytedance.sdk.component.adexpress.dynamic.aGH.kb nlS;
    protected DynamicRootView nn;
    protected float ui;
    protected int wC;

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getShineValue() {
        return this.DbA;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setShineValue(float f) {
        this.DbA = f;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getRippleValue() {
        return this.eli;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setRippleValue(float f) {
        this.eli = f;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getMarqueeValue() {
        return this.QX;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setMarqueeValue(float f) {
        this.QX = f;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getStretchValue() {
        return this.Xb;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setStretchValue(float f) {
        this.Xb = f;
        this.nGm.eli(this, f);
    }

    public ui(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context);
        this.du = context;
        this.nn = dynamicRootView;
        this.NU = wCVar;
        this.Os = wCVar.MGA();
        this.aGH = wCVar.kb();
        this.ui = wCVar.wC();
        this.MGA = wCVar.FC();
        this.FC = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.Os);
        this.aAs = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.aGH);
        this.kb = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.ui);
        this.wC = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.MGA);
        com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar = new com.bytedance.sdk.component.adexpress.dynamic.aGH.kb(wCVar.aAs());
        this.nlS = kbVar;
        if (kbVar.nGm() > 0) {
            this.kb += this.nlS.nGm() * 2;
            this.wC += this.nlS.nGm() * 2;
            this.FC -= this.nlS.nGm();
            this.aAs -= this.nlS.nGm();
            List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> du = wCVar.du();
            if (du != null) {
                for (com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar2 : du) {
                    wCVar2.Os(wCVar2.MGA() + com.bytedance.sdk.component.adexpress.aGH.kb.DbA(this.du, this.nlS.nGm()));
                    wCVar2.aGH(wCVar2.kb() + com.bytedance.sdk.component.adexpress.aGH.kb.DbA(this.du, this.nlS.nGm()));
                    wCVar2.eli(com.bytedance.sdk.component.adexpress.aGH.kb.DbA(this.du, this.nlS.nGm()));
                    wCVar2.DbA(com.bytedance.sdk.component.adexpress.aGH.kb.DbA(this.du, this.nlS.nGm()));
                }
            }
        }
        this.aqO = this.nlS.nn() > 0.0d;
        this.nGm = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.Os();
    }

    public void setShouldInvisible(boolean z) {
        this.aqO = z;
    }

    public boolean getBeginInvisibleAndShow() {
        return this.aqO;
    }

    public boolean Os() {
        FC();
        MGA();
        aGH();
        return true;
    }

    public void eli(int i) {
        com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar = this.nlS;
        if (kbVar != null && kbVar.eli(i)) {
            FC();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (getChildAt(i2) instanceof ui)) {
                    ((ui) childAt).eli(i);
                }
            }
        }
    }

    protected boolean aGH() {
        View.OnTouchListener onTouchListener;
        View.OnClickListener onClickListener;
        View view = this.Dfc;
        if (view == null) {
            view = this;
        }
        if (ui()) {
            onTouchListener = (View.OnTouchListener) getDynamicClickListener();
            onClickListener = (View.OnClickListener) getDynamicClickListener();
        } else {
            onTouchListener = CMM;
            onClickListener = ev;
        }
        if (onTouchListener != null && onClickListener != null) {
            view.setOnTouchListener(onTouchListener);
            view.setOnClickListener(onClickListener);
            int eli = com.bytedance.sdk.component.adexpress.dynamic.DbA.eli.eli(this.nlS);
            if (eli == 2 || eli == 3) {
                view.setOnClickListener(ev);
            } else {
                view.setOnClickListener(onClickListener);
            }
        }
        eli(view);
        DbA(view);
        return true;
    }

    protected void eli(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.NU.wC());
            jSONObject.put("height", this.NU.FC());
            if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.eli.Xb, this.nlS.eU());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.eli.bf, this.NU.aAs().DbA());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.eli.CMM, this.NU.Os());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.eli.ev, jSONObject.toString());
                return;
            }
            view.setTag(2097610717, this.nlS.eU());
            view.setTag(2097610715, this.NU.aAs().DbA());
            view.setTag(2097610714, this.NU.Os());
            view.setTag(2097610713, jSONObject.toString());
            int eli = com.bytedance.sdk.component.adexpress.dynamic.DbA.eli.eli(this.nlS);
            if (eli == 1) {
                view.setTag(2097610707, new Pair(this.nlS.gG(), Long.valueOf(this.nlS.ujq())));
                view.setTag(2097610708, Integer.valueOf(eli));
            }
        } catch (JSONException unused) {
        }
    }

    protected void DbA(View view) {
        com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA ui;
        com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar = this.NU;
        if (wCVar == null || (ui = wCVar.aAs().ui()) == null) {
            return;
        }
        view.setTag(2097610716, Boolean.valueOf(ui.TiA()));
    }

    public boolean ui() {
        com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar = this.nlS;
        return (kbVar == null || kbVar.Ue() == 0) ? false : true;
    }

    public void MGA() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.kb, this.wC);
        layoutParams.topMargin = this.aAs;
        layoutParams.leftMargin = this.FC;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    public int getClickArea() {
        return this.nlS.Ue();
    }

    public String getImageObjectFit() {
        return this.nlS.mm();
    }

    public com.bytedance.sdk.component.adexpress.dynamic.MGA.eli getDynamicClickListener() {
        return this.nn.getDynamicClickListener();
    }

    protected Drawable getBackgroundDrawable() {
        return eli(false, "");
    }

    protected Drawable eli(boolean z, String str) {
        String[] split;
        int[] iArr;
        int KM;
        if (!TextUtils.isEmpty(this.nlS.cyF())) {
            try {
                String cyF = this.nlS.cyF();
                String substring = cyF.substring(cyF.indexOf("(") + 1, cyF.length() - 1);
                if (substring.contains("rgba") && substring.contains("%")) {
                    split = new String[]{substring.substring(0, substring.indexOf(",")).trim(), substring.substring(substring.indexOf(",") + 1, substring.indexOf("%") + 1).trim(), substring.substring(substring.indexOf("%") + 2).trim()};
                    iArr = new int[]{com.bytedance.sdk.component.adexpress.dynamic.aGH.kb.eli(split[1]), com.bytedance.sdk.component.adexpress.dynamic.aGH.kb.eli(split[2])};
                } else {
                    split = substring.split(", ");
                    iArr = new int[]{com.bytedance.sdk.component.adexpress.dynamic.aGH.kb.eli(split[1].substring(0, 7)), com.bytedance.sdk.component.adexpress.dynamic.aGH.kb.eli(split[2].substring(0, 7))};
                }
                try {
                    double parseDouble = Double.parseDouble(substring.substring(substring.indexOf("linear-gradient(") + 1, substring.indexOf("deg")));
                    if (parseDouble > 225.0d && parseDouble < 315.0d) {
                        int i = iArr[1];
                        iArr[1] = iArr[0];
                        iArr[0] = i;
                    }
                } catch (Exception unused) {
                }
                GradientDrawable eli = eli(eli(split[0]), iArr);
                eli.setShape(0);
                eli.setCornerRadius(com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.Dfc()));
                return eli;
            } catch (Exception unused2) {
                Drawable mutilBackgroundDrawable = getMutilBackgroundDrawable();
                if (mutilBackgroundDrawable != null) {
                    return mutilBackgroundDrawable;
                }
            }
        }
        GradientDrawable drawable = getDrawable();
        drawable.setShape(0);
        float eli2 = com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.Dfc());
        drawable.setCornerRadius(eli2);
        if (eli2 < 1.0f) {
            float eli3 = com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.GB());
            float eli4 = com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.oWW());
            float eli5 = com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.qj());
            float eli6 = com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.nro());
            float[] fArr = new float[8];
            if (eli3 > 0.0f) {
                fArr[0] = eli3;
                fArr[1] = eli3;
            }
            if (eli4 > 0.0f) {
                fArr[2] = eli4;
                fArr[3] = eli4;
            }
            if (eli5 > 0.0f) {
                fArr[4] = eli5;
                fArr[5] = eli5;
            }
            if (eli6 > 0.0f) {
                fArr[6] = eli6;
                fArr[7] = eli6;
            }
            drawable.setCornerRadii(fArr);
        }
        if (z) {
            KM = Color.parseColor(str);
        } else {
            KM = this.nlS.KM();
        }
        drawable.setColor(KM);
        if (this.nlS.dV() > 0.0f) {
            drawable.setStroke((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.dV()), this.nlS.aqO());
        } else if (this.nlS.nGm() > 0) {
            drawable.setStroke(this.nlS.nGm(), this.nlS.aqO());
            drawable.setAlpha(50);
            if (TextUtils.equals(this.NU.aAs().DbA(), "video-vd")) {
                setLayerType(1, null);
                return new QX((int) eli2, this.nlS.nGm());
            }
        }
        return drawable;
    }

    protected DbA eli(Bitmap bitmap) {
        return new eli(bitmap, null);
    }

    protected Drawable getMutilBackgroundDrawable() {
        try {
            return new LayerDrawable(eli(DbA(this.nlS.cyF().replaceAll("/\\*.*\\*/", ""))));
        } catch (Exception unused) {
            return null;
        }
    }

    private Drawable[] eli(List<String> list) {
        Drawable[] drawableArr = new Drawable[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.contains("linear-gradient")) {
                String[] split = str.substring(str.indexOf("(") + 1, str.length() - 1).split(", ");
                int length = split.length - 1;
                int[] iArr = new int[length];
                int i2 = 0;
                while (i2 < length) {
                    int i3 = i2 + 1;
                    iArr[i2] = com.bytedance.sdk.component.adexpress.dynamic.aGH.kb.eli(split[i3].substring(0, 7));
                    i2 = i3;
                }
                GradientDrawable eli = eli(eli(split[0]), iArr);
                eli.setShape(0);
                eli.setCornerRadius(com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.du, this.nlS.Dfc()));
                drawableArr[(list.size() - 1) - i] = eli;
            }
        }
        return drawableArr;
    }

    private List<String> DbA(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == '(') {
                i++;
                z = true;
            } else if (str.charAt(i3) == ')' && i - 1 == 0 && z) {
                int i4 = i3 + 1;
                arrayList.add(str.substring(i2, i4));
                i2 = i4;
                z = false;
            }
        }
        return arrayList;
    }

    protected GradientDrawable getDrawable() {
        return new GradientDrawable();
    }

    protected GradientDrawable eli(GradientDrawable.Orientation orientation, int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return new GradientDrawable();
        }
        if (iArr.length == 1) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(iArr[0]);
            return gradientDrawable;
        }
        return new GradientDrawable(orientation, iArr);
    }

    protected GradientDrawable.Orientation eli(String str) {
        try {
            int parseFloat = (int) Float.parseFloat(str.substring(0, str.length() - 3));
            if (parseFloat <= 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (parseFloat <= 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            if (parseFloat <= 270) {
                return GradientDrawable.Orientation.RIGHT_LEFT;
            }
            return GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.nGm.eli(canvas, this, this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.sdk.component.adexpress.dynamic.animation.view.Os os = this.nGm;
        View view = this.Dfc;
        if (view == null) {
            view = this;
        }
        os.eli(view, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        kb();
        eli();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        DbA();
        super.onDetachedFromWindow();
    }

    public void kb() {
        if (wC()) {
            return;
        }
        View view = this.Dfc;
        if (view == null) {
            view = this;
        }
        this.dV = new com.bytedance.sdk.component.adexpress.dynamic.animation.eli.DbA(view, this.NU.aAs().ui().QW());
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui.1
            @Override // java.lang.Runnable
            public void run() {
                if (ui.this.dV != null) {
                    ui.this.dV.eli();
                }
            }
        });
    }

    public void DbA() {
        com.bytedance.sdk.component.adexpress.dynamic.animation.eli.DbA dbA = this.dV;
        if (dbA != null) {
            dbA.DbA();
        }
    }

    protected boolean wC() {
        com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar = this.NU;
        return wCVar == null || wCVar.aAs() == null || this.NU.aAs().ui() == null || this.NU.aAs().ui().QW() == null;
    }

    public int getDynamicWidth() {
        return this.kb;
    }

    public int getDynamicHeight() {
        return this.wC;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA getDynamicLayoutBrickValue() {
        com.bytedance.sdk.component.adexpress.dynamic.aGH.ui aAs;
        com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar = this.NU;
        if (wCVar == null || (aAs = wCVar.aAs()) == null) {
            return null;
        }
        return aAs.ui();
    }

    private void eli() {
        if (isShown()) {
            int eli = com.bytedance.sdk.component.adexpress.dynamic.DbA.eli.eli(this.nlS);
            if (eli == 2) {
                if (this.bf == null) {
                    this.bf = new com.bytedance.sdk.component.utils.Vy(getContext().getApplicationContext(), 1);
                }
                new Object() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui.4
                };
                com.bytedance.sdk.component.adexpress.DbA.NU renderRequest = this.nn.getRenderRequest();
                if (renderRequest != null) {
                    renderRequest.Dfc();
                    renderRequest.bf();
                    renderRequest.QX();
                    return;
                }
                return;
            }
            if (eli == 3) {
                if (this.bf == null) {
                    this.bf = new com.bytedance.sdk.component.utils.Vy(getContext().getApplicationContext(), 2);
                }
                new Object() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui.5
                };
                com.bytedance.sdk.component.adexpress.DbA.NU renderRequest2 = this.nn.getRenderRequest();
                if (renderRequest2 != null) {
                    renderRequest2.dV();
                    renderRequest2.CMM();
                    renderRequest2.nGm();
                    renderRequest2.Xb();
                }
            }
        }
    }
}
