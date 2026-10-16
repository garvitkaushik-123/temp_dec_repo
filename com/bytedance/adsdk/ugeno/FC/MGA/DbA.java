package com.bytedance.adsdk.ugeno.FC.MGA;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import com.adjust.sdk.Constants;
import com.bytedance.adsdk.ugeno.DbA.Os;
import com.bytedance.adsdk.ugeno.kb.wC;

/* loaded from: classes3.dex */
public class DbA extends Os<eli> {
    private int Bnk;
    private TextUtils.TruncateAt CH;
    private int Ib;
    private float OJ;
    private float QMZ;
    private int QW;

    @Deprecated
    private float SjY;

    @Deprecated
    private float TiA;
    private int Tju;
    private boolean XlF;
    private float an;
    private float dM;
    protected String eli;
    private float hg;
    private int kEI;
    private float lYL;
    private int nY;
    private float tpZ;
    protected int vb;

    @Deprecated
    private TextUtils.TruncateAt yw;

    public DbA(Context context) {
        super(context);
        this.vb = -16777216;
        this.hg = 12.0f;
        this.QW = Integer.MAX_VALUE;
        this.kEI = GravityCompat.START;
        this.CH = TextUtils.TruncateAt.END;
        this.QMZ = -1.0f;
        this.OJ = 400.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    /* renamed from: Os, reason: merged with bridge method [inline-methods] */
    public eli eli() {
        eli eliVar = new eli(this.DbA);
        eliVar.eli(this);
        return eliVar;
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    public void DbA() {
        super.DbA();
        if (TextUtils.equals("null", this.eli)) {
            this.eli = "";
        }
        du(this.eli);
        ((eli) this.ui).setTextSize(1, this.hg);
        ((eli) this.ui).setTextColor(this.vb);
        ((eli) this.ui).setLines(this.nY);
        ((eli) this.ui).setMaxLines(this.QW);
        ((eli) this.ui).setGravity(this.kEI);
        ((eli) this.ui).setIncludeFontPadding(false);
        eli(this.Tju);
        if (oWW()) {
            eli(this.CH);
        } else {
            eli(this.yw);
        }
        if (this.QMZ > 0.0f) {
            if (oWW()) {
                FC();
            } else {
                aGH();
            }
        }
        ((eli) this.ui).setBreakStrategy(0);
        if (oWW()) {
            if (this.XlF) {
                if (this.lYL <= 0.0f) {
                    this.lYL = 1.0E-5f;
                }
                ((eli) this.ui).setShadowLayer(this.lYL, this.dM, this.an, this.Ib);
            }
        } else {
            ((eli) this.ui).setShadowLayer(this.lYL, this.SjY, this.TiA, this.Ib);
        }
        if (this.Bnk == 1) {
            ((eli) this.ui).setTypeface(Typeface.DEFAULT, this.Bnk);
        } else {
            ((eli) this.ui).setTypeface(Typeface.create(Typeface.DEFAULT, (int) this.OJ, this.Bnk == 2));
        }
        if (wC.eli(this.DbA, this.hg) > 0.0f) {
            ((eli) this.ui).setLetterSpacing(this.tpZ / wC.eli(this.DbA, this.hg));
        }
    }

    private void aGH() {
        ((eli) this.ui).setLineSpacing(0.0f, this.QMZ);
    }

    private void FC() {
        if (this.QMZ <= 3.0f) {
            ((eli) this.ui).setLineSpacing(0.0f, this.QMZ);
            return;
        }
        int round = Math.round(wC.eli(this.DbA, (this.QMZ - (this.hg * 1.2f)) / 2.0f));
        ((eli) this.ui).setPadding(((eli) this.ui).getPaddingLeft(), ((eli) this.ui).getPaddingTop() + round, ((eli) this.ui).getPaddingRight(), ((eli) this.ui).getPaddingBottom() + round);
        ((eli) this.ui).setLineHeight(Math.round(wC.eli(this.DbA, this.QMZ)));
    }

    public void du(String str) {
        this.eli = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.equals("null", str)) {
            this.eli = "";
        }
        ((eli) this.ui).setText(this.eli);
    }

    public void eli(int i) {
        this.Tju = i;
        if (i == Integer.MAX_VALUE) {
            return;
        }
        ((eli) this.ui).setPaintFlags(i);
    }

    public void eli(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == null) {
            return;
        }
        ((eli) this.ui).setEllipsize(truncateAt);
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    public void eli(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.eli(str, str2);
        str.hashCode();
        switch (str) {
            case "shadowRadius":
            case "shadowBlur":
                this.lYL = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f);
                break;
            case "shadowColor":
                this.Ib = com.bytedance.adsdk.ugeno.kb.eli.eli(str2);
                this.XlF = true;
                break;
            case "shadowOffsetX":
                this.dM = wC.eli(this.DbA, com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f));
                break;
            case "shadowOffsetY":
                this.an = wC.eli(this.DbA, com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f));
                break;
            case "textAlign":
                this.kEI = Dfc(str2);
                break;
            case "textColor":
                this.vb = com.bytedance.adsdk.ugeno.kb.eli.eli(str2);
                break;
            case "textStyle":
                this.Bnk = nn(str2);
                break;
            case "textSize":
                this.hg = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f);
                break;
            case "textDecoration":
                this.Tju = aqO(str2);
                break;
            case "shadowDx":
                this.SjY = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f);
                break;
            case "shadowDy":
                this.TiA = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f);
                break;
            case "fontWeight":
                float eli = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, -1.0f);
                this.OJ = eli;
                if (eli < 1.0f || eli > 1000.0f) {
                    this.OJ = 400.0f;
                    break;
                }
                break;
            case "lineHeight":
                this.QMZ = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 1.0f);
                break;
            case "text":
                this.eli = str2;
                break;
            case "lines":
                this.nY = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0);
                break;
            case "ellipsis":
                this.CH = NU(str2);
                break;
            case "maxLines":
                int eli2 = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, Integer.MAX_VALUE);
                this.QW = eli2 > 0 ? eli2 : Integer.MAX_VALUE;
                break;
            case "ellipsize":
                this.yw = nlS(str2);
                break;
            case "letterSpacing":
                this.tpZ = wC.eli(this.DbA, com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f));
                break;
        }
    }

    private TextUtils.TruncateAt nlS(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                this.yw = TextUtils.TruncateAt.MIDDLE;
                break;
            case "end":
                this.yw = TextUtils.TruncateAt.END;
                break;
            case "start":
                this.yw = TextUtils.TruncateAt.START;
                break;
            default:
                this.yw = null;
                break;
        }
        return this.yw;
    }

    private TextUtils.TruncateAt NU(String str) {
        if (TextUtils.equals(str, "none")) {
            return null;
        }
        return TextUtils.TruncateAt.END;
    }

    private int nn(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == -1178781136) {
            if (str.equals("italic")) {
                c = 1;
            }
            c = 65535;
        } else if (hashCode != -1039745817) {
            if (hashCode == 3029637 && str.equals("bold")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals(Constants.NORMAL)) {
                c = 2;
            }
            c = 65535;
        }
        if (c != 0) {
            return c != 1 ? 0 : 2;
        }
        return 1;
    }

    private int Dfc(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return 17;
            case "center_vertical":
                return 16;
            case "left":
                return 3;
            case "right":
                return 5;
            case "center_horizontal":
                return 1;
            default:
                return 3;
        }
    }

    private int aqO(String str) {
        str.hashCode();
        switch (str) {
            case "underline":
                return 8;
            case "strikethrough":
                return 16;
            case "none":
            default:
                return Integer.MAX_VALUE;
        }
    }
}
