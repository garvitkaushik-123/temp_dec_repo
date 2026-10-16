package com.bytedance.adsdk.ugeno.ui;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.DbA.eli;
import com.bytedance.adsdk.ugeno.ui.ui;

/* loaded from: classes3.dex */
public class MGA extends com.bytedance.adsdk.ugeno.DbA.eli<ui> {
    private int Bnk;
    private int QW;
    private int hg;
    private int nY;
    private int vb;

    public MGA(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    /* renamed from: Os, reason: merged with bridge method [inline-methods] */
    public ui eli() {
        ui uiVar = new ui(this.DbA);
        uiVar.eli(this);
        return uiVar;
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.eli, com.bytedance.adsdk.ugeno.DbA.Os
    public void DbA() {
        super.DbA();
        ((ui) this.ui).setFlexDirection(this.vb);
        ((ui) this.ui).setFlexWrap(this.hg);
        ((ui) this.ui).setJustifyContent(this.Bnk);
        ((ui) this.ui).setAlignItems(this.QW);
        ((ui) this.ui).setAlignContent(this.nY);
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.eli
    public eli.C0117eli aAs() {
        return new eli(this);
    }

    public static class eli extends eli.C0117eli {
        public int Cp;
        public float GB;
        public float KM;
        public float Ue;
        public int VM;
        public int nro;
        public int oWW;
        public int qj;
        public int ujq;

        public eli(com.bytedance.adsdk.ugeno.DbA.eli eliVar) {
            super(eliVar);
            this.ujq = 1;
            this.Ue = 0.0f;
            this.KM = 0.0f;
            this.VM = -1;
            this.GB = -1.0f;
            this.oWW = -1;
            this.qj = -1;
            this.nro = ViewCompat.MEASURED_SIZE_MASK;
            this.Cp = ViewCompat.MEASURED_SIZE_MASK;
        }

        @Override // com.bytedance.adsdk.ugeno.DbA.eli.C0117eli
        public void eli(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.eli(context, str, str2);
            str.hashCode();
            switch (str) {
                case "flexBasisPercent":
                    this.GB = aGH(str2);
                    break;
                case "order":
                    this.ujq = eli(str2);
                    break;
                case "flexShrink":
                    this.KM = Os(str2);
                    break;
                case "flexGrow":
                    this.Ue = DbA(str2);
                    break;
                case "alignSelf":
                    this.VM = ui(str2);
                    break;
            }
        }

        private int eli(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return 1;
            }
        }

        private float DbA(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return 0.0f;
            }
        }

        private float Os(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return 0.0f;
            }
        }

        private float aGH(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return -1.0f;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private int ui(String str) {
            boolean z;
            str.hashCode();
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        z = false;
                        break;
                    }
                    z = -1;
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        z = true;
                        break;
                    }
                    z = -1;
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        z = 2;
                        break;
                    }
                    z = -1;
                    break;
                case 1384876188:
                    if (str.equals("flex_start")) {
                        z = 3;
                        break;
                    }
                    z = -1;
                    break;
                case 1744442261:
                    if (str.equals("flex_end")) {
                        z = 4;
                        break;
                    }
                    z = -1;
                    break;
                default:
                    z = -1;
                    break;
            }
            switch (z) {
                case false:
                    return 4;
                case true:
                    return 3;
                case true:
                    return 2;
                case true:
                    return 0;
                case true:
                    return 1;
                default:
                    return -1;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.DbA.eli.C0117eli
        /* renamed from: DbA, reason: merged with bridge method [inline-methods] */
        public ui.eli eli() {
            ui.eli eliVar = new ui.eli((int) this.eli, (int) this.DbA);
            eliVar.leftMargin = (int) this.MGA;
            eliVar.rightMargin = (int) this.kb;
            eliVar.topMargin = (int) this.wC;
            eliVar.bottomMargin = (int) this.FC;
            eliVar.Os(this.ujq);
            eliVar.aGH(this.VM);
            eliVar.eli(this.Ue);
            eliVar.DbA(this.KM);
            eliVar.Os(this.GB);
            return eliVar;
        }

        @Override // com.bytedance.adsdk.ugeno.DbA.eli.C0117eli
        public String toString() {
            return "LayoutParams{mWidth=" + this.eli + ", mHeight=" + this.DbA + ", mMargin=" + this.ui + ", mMarginLeft=" + this.MGA + ", mMarginRight=" + this.kb + ", mMarginTop=" + this.wC + ", mMarginBottom=" + this.FC + ", mParams=" + this.Vy + ", mOrder=" + this.ujq + ", mFlexGrow=" + this.Ue + ", mFlexShrink=" + this.KM + ", mAlignSelf=" + this.VM + ", mFlexBasisPercent=" + this.GB + ", mMinWidth=" + this.oWW + ", mMinHeight=" + this.qj + ", mMaxWidth=" + this.nro + ", mMaxHeight=" + this.Cp + "} " + super.toString();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    public void eli(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.eli(str, str2);
        str.hashCode();
        switch (str) {
            case "alignItems":
                this.QW = nn(str2);
                break;
            case "flexDirection":
                this.vb = du(str2);
                break;
            case "alignContent":
                this.nY = Dfc(str2);
                break;
            case "flexWrap":
                this.hg = nlS(str2);
                break;
            case "justifyContent":
                this.Bnk = NU(str2);
                break;
        }
    }

    int du(String str) {
        str.hashCode();
        switch (str) {
            case "column_reverse":
                return 3;
            case "column":
                return 2;
            case "row_reverse":
                return 1;
            default:
                return 0;
        }
    }

    private int nlS(String str) {
        str.hashCode();
        return !str.equals("wrap") ? 0 : 1;
    }

    private int NU(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return 2;
            case "space_around":
                return 4;
            case "space_between":
                return 3;
            case "flex_end":
                return 1;
            default:
                return 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int nn(String str) {
        char c;
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1720785339:
                if (str.equals("baseline")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1364013995:
                if (str.equals("center")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1384876188:
                if (str.equals("flex_start")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1744442261:
                if (str.equals("flex_end")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            return 0;
        }
        if (c == 1) {
            return 1;
        }
        if (c != 2) {
            return c != 3 ? 4 : 3;
        }
        return 2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int Dfc(String str) {
        char c;
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1364013995:
                if (str.equals("center")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -932331738:
                if (str.equals("space_around")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1384876188:
                if (str.equals("flex_start")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1682480591:
                if (str.equals("space_between")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1744442261:
                if (str.equals("flex_end")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            return 0;
        }
        if (c == 1) {
            return 1;
        }
        if (c == 2) {
            return 2;
        }
        if (c != 3) {
            return c != 4 ? 5 : 3;
        }
        return 4;
    }
}
