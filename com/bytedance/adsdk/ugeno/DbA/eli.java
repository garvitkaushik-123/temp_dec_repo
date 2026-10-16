package com.bytedance.adsdk.ugeno.DbA;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.kb.wC;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class eli<E extends ViewGroup> extends Os {
    protected List<Os<View>> eli;

    public eli(Context context) {
        this(context, null);
    }

    public eli(Context context, eli eliVar) {
        super(context, eliVar);
        this.eli = new ArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    public void DbA() {
        super.DbA();
    }

    public void eli(Os os) {
        if (os == null) {
            return;
        }
        this.eli.add(os);
        View du = os.du();
        if (du != null) {
            ((ViewGroup) this.ui).addView(du);
        }
    }

    public void eli(Os os, ViewGroup.LayoutParams layoutParams) {
        if (os == null) {
            return;
        }
        this.eli.add(os);
        View du = os.du();
        if (du != null) {
            ((ViewGroup) this.ui).addView(du, layoutParams);
        }
    }

    public List<Os<View>> FC() {
        return this.eli;
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    public Os eli(String str) {
        Os<View> aGH;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.du)) {
            return this;
        }
        for (Os<View> os : this.eli) {
            if (os != null && (aGH = os.aGH(str)) != null) {
                return aGH;
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    public Os DbA(String str) {
        Os<View> ui;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.nlS)) {
            return this;
        }
        for (Os<View> os : this.eli) {
            if (os != null && (ui = os.ui(str)) != null) {
                return ui;
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    protected Os Os(String str) {
        Os<View> MGA;
        if (!TextUtils.isEmpty(str) && aAs(str) != null) {
            return this;
        }
        for (Os<View> os : this.eli) {
            if (os != null && (MGA = os.MGA(str)) != null) {
                return MGA;
            }
        }
        return null;
    }

    public C0117eli aAs() {
        return new C0117eli(this);
    }

    /* renamed from: com.bytedance.adsdk.ugeno.DbA.eli$eli, reason: collision with other inner class name */
    public static class C0117eli {
        protected boolean CMM;
        protected boolean Dfc;
        protected float FC;
        protected float MGA;
        protected float NU;
        protected boolean QX;
        protected ViewGroup.LayoutParams Vy;
        protected boolean Xb;
        protected float aAs;
        protected boolean aqO;
        protected boolean bf;
        protected boolean dV;
        protected float du;
        protected boolean ev;
        protected eli gG;
        protected float kb;
        protected boolean nGm;
        protected float nlS;
        protected float nn;
        protected float ui;
        protected float wC;
        protected float eli = -2.0f;
        protected float DbA = -2.0f;
        protected float Os = 0.0f;
        protected float aGH = 0.0f;

        public C0117eli(eli eliVar) {
            this.gG = eliVar;
        }

        public void eli(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            str.hashCode();
            switch (str) {
                case "paddingLeft":
                    this.du = wC.eli(context, str2);
                    this.aqO = true;
                    break;
                case "minWidth":
                    this.Os = wC.eli(context, str2);
                    break;
                case "height":
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.DbA = -1.0f;
                        break;
                    } else if (TextUtils.equals(str2, "wrap_content")) {
                        this.DbA = -2.0f;
                        break;
                    } else {
                        this.DbA = wC.eli(context, str2);
                        break;
                    }
                case "margin":
                    this.ui = wC.eli(context, str2);
                    break;
                case "marginTop":
                    this.wC = wC.eli(context, str2);
                    this.CMM = true;
                    break;
                case "padding":
                    this.aAs = wC.eli(context, str2);
                    this.Dfc = true;
                    break;
                case "marginBottom":
                    this.FC = wC.eli(context, str2);
                    this.ev = true;
                    break;
                case "minHeight":
                    this.aGH = wC.eli(context, str2);
                    break;
                case "paddingTop":
                    this.nlS = wC.eli(context, str2);
                    this.nGm = true;
                    break;
                case "width":
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.eli = -1.0f;
                        break;
                    } else if (TextUtils.equals(str2, "wrap_content")) {
                        this.eli = -2.0f;
                        break;
                    } else {
                        this.eli = wC.eli(context, str2);
                        break;
                    }
                case "paddingBottom":
                    this.nn = wC.eli(context, str2);
                    this.QX = true;
                    break;
                case "paddingRight":
                    this.NU = wC.eli(context, str2);
                    this.dV = true;
                    break;
                case "marginRight":
                    this.kb = wC.eli(context, str2);
                    this.bf = true;
                    break;
                case "marginLeft":
                    this.MGA = wC.eli(context, str2);
                    this.Xb = true;
                    break;
            }
        }

        public String toString() {
            return "LayoutParams{mWidth=" + this.eli + ", mHeight=" + this.DbA + ", mMargin=" + this.ui + ", mMarginLeft=" + this.MGA + ", mMarginRight=" + this.kb + ", mMarginTop=" + this.wC + ", mMarginBottom=" + this.FC + ", mParams=" + this.Vy + AbstractJsonLexerKt.END_OBJ;
        }

        public ViewGroup.LayoutParams eli() {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams((int) this.eli, (int) this.DbA);
            marginLayoutParams.leftMargin = (int) (this.Xb ? this.MGA : this.ui);
            marginLayoutParams.rightMargin = (int) (this.bf ? this.kb : this.ui);
            marginLayoutParams.topMargin = (int) (this.CMM ? this.wC : this.ui);
            marginLayoutParams.bottomMargin = (int) (this.ev ? this.FC : this.ui);
            return marginLayoutParams;
        }
    }
}
