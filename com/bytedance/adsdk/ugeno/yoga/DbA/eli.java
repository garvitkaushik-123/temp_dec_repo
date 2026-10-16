package com.bytedance.adsdk.ugeno.yoga.DbA;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.DbA.eli;
import com.bytedance.adsdk.ugeno.eli;
import com.bytedance.adsdk.ugeno.kb.wC;
import com.bytedance.adsdk.ugeno.yoga.DbA.Os;
import com.bytedance.adsdk.ugeno.yoga.MGA;
import com.bytedance.adsdk.ugeno.yoga.NU;
import com.bytedance.adsdk.ugeno.yoga.aAs;
import com.bytedance.adsdk.ugeno.yoga.aGH;
import com.bytedance.adsdk.ugeno.yoga.nn;
import com.bytedance.adsdk.ugeno.yoga.ui;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class eli extends com.bytedance.adsdk.ugeno.DbA.eli<Os> {
    private MGA Bnk;
    private com.bytedance.adsdk.ugeno.yoga.eli QW;
    private nn hg;
    private aAs kEI;
    private com.bytedance.adsdk.ugeno.yoga.eli nY;
    private ui vb;

    public eli(Context context) {
        super(context);
        this.vb = ui.ROW;
        this.hg = nn.NO_WRAP;
        this.Bnk = MGA.FLEX_START;
        this.QW = com.bytedance.adsdk.ugeno.yoga.eli.STRETCH;
        this.nY = com.bytedance.adsdk.ugeno.yoga.eli.STRETCH;
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    /* renamed from: Os, reason: merged with bridge method [inline-methods] */
    public Os eli() {
        Os os = new Os(this.DbA);
        os.eli(this);
        this.kEI = os.getYogaNode();
        return os;
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    protected void KM() {
        if (this.FS) {
            com.bytedance.adsdk.ugeno.ui.eli().DbA().eli(this.FC, this.dZ, new eli.InterfaceC0124eli() { // from class: com.bytedance.adsdk.ugeno.yoga.DbA.eli.1
                @Override // com.bytedance.adsdk.ugeno.eli.InterfaceC0124eli
                public void eli(Bitmap bitmap) {
                    if (bitmap == null) {
                        if (eli.this.Hm != null) {
                            com.bytedance.adsdk.ugeno.core.MGA unused = eli.this.Hm;
                            String unused2 = eli.this.dZ;
                            return;
                        }
                        return;
                    }
                    if (eli.this.Hm != null) {
                        com.bytedance.adsdk.ugeno.core.MGA unused3 = eli.this.Hm;
                        String unused4 = eli.this.dZ;
                    }
                    final Bitmap eli = wC.eli(eli.this.DbA, bitmap, (int) eli.this.Uv);
                    if (eli != null) {
                        wC.eli(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.DbA.eli.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                eli.this.eli(new BitmapDrawable(eli));
                            }
                        });
                    }
                }
            });
            return;
        }
        com.bytedance.adsdk.ugeno.FC.aGH.eli eliVar = new com.bytedance.adsdk.ugeno.FC.aGH.eli(this.DbA);
        com.bytedance.adsdk.ugeno.ui.eli().DbA().eli(this.FC, this.dZ, eliVar, this.ui.getWidth(), this.ui.getHeight(), new eli.InterfaceC0124eli() { // from class: com.bytedance.adsdk.ugeno.yoga.DbA.eli.2
            @Override // com.bytedance.adsdk.ugeno.eli.InterfaceC0124eli
            public void eli(Bitmap bitmap) {
                if (bitmap == null) {
                    if (eli.this.Hm != null) {
                        com.bytedance.adsdk.ugeno.core.MGA unused = eli.this.Hm;
                        String unused2 = eli.this.dZ;
                        return;
                    }
                    return;
                }
                if (eli.this.Hm != null) {
                    com.bytedance.adsdk.ugeno.core.MGA unused3 = eli.this.Hm;
                    String unused4 = eli.this.dZ;
                }
            }
        });
        if (!this.jh || this.SSo == ImageView.ScaleType.FIT_XY) {
            eliVar.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            eliVar.setScaleType(this.SSo);
        }
        eliVar.setCornerRadius(this.Za);
        Os.eli eliVar2 = new Os.eli(-1, -1);
        eliVar2.MGA(NU.ABSOLUTE.eli());
        if (this.ui instanceof Os) {
            ((Os) this.ui).addView(eliVar, 0, eliVar2);
            eli(eliVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    protected void eli(Drawable drawable) {
        com.bytedance.adsdk.ugeno.FC.aGH.eli eliVar = new com.bytedance.adsdk.ugeno.FC.aGH.eli(this.DbA);
        eliVar.setImageDrawable(drawable);
        if (!this.jh || this.SSo == ImageView.ScaleType.FIT_XY) {
            eliVar.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            eliVar.setScaleType(this.SSo);
        }
        eliVar.setCornerRadius(this.Za);
        Os.eli eliVar2 = new Os.eli(-1, -1);
        eliVar2.MGA(NU.ABSOLUTE.eli());
        if (this.ui instanceof Os) {
            ((Os) this.ui).addView(eliVar, 0, eliVar2);
            eli(eliVar);
        }
    }

    private void eli(final com.bytedance.adsdk.ugeno.FC.aGH.eli eliVar) {
        this.ui.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.DbA.eli.3
            @Override // java.lang.Runnable
            public void run() {
                aAs eli;
                if (eli.this.ui == null || (eli = ((Os) eli.this.ui).eli(eliVar)) == null) {
                    return;
                }
                eli.aGH(eli.this.ui.getWidth());
                eli.MGA(eli.this.ui.getHeight());
                eliVar.setCornerRadius(eli.this.Za);
                eli.this.ui.requestLayout();
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.eli, com.bytedance.adsdk.ugeno.DbA.Os
    public void DbA() {
        super.DbA();
        this.kEI.eli(this.vb);
        this.kEI.eli(this.hg);
        this.kEI.eli(this.Bnk);
        this.kEI.eli(this.QW);
        this.kEI.Os(this.nY);
        this.kEI.eli(true);
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    protected void nn() {
        if (this.oWW) {
            this.kEI.DbA(aGH.ALL, this.ujq);
        }
        if (this.qj) {
            this.kEI.DbA(aGH.LEFT, this.Ue);
        }
        if (this.nro) {
            this.kEI.DbA(aGH.RIGHT, this.KM);
        }
        if (this.Cp) {
            this.kEI.DbA(aGH.TOP, this.VM);
        }
        if (this.cyF) {
            this.kEI.DbA(aGH.BOTTOM, this.GB);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.eli
    public void eli(com.bytedance.adsdk.ugeno.DbA.Os os) {
        super.eli(os);
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.eli
    public void eli(com.bytedance.adsdk.ugeno.DbA.Os os, ViewGroup.LayoutParams layoutParams) {
        if (os == null) {
            return;
        }
        this.eli.add(os);
        View du = os.du();
        if (du != null) {
            ((Os) this.ui).addView(du, layoutParams);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.eli
    /* renamed from: aGH, reason: merged with bridge method [inline-methods] */
    public C0129eli aAs() {
        return new C0129eli(this);
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    public void eli(String str, String str2) {
        super.eli(str, str2);
        str.hashCode();
        switch (str) {
            case "alignItems":
                this.QW = com.bytedance.adsdk.ugeno.yoga.eli.eli(str2);
                break;
            case "flexDirection":
                this.vb = ui.eli(str2);
                break;
            case "alignContent":
                this.nY = com.bytedance.adsdk.ugeno.yoga.eli.eli(str2);
                break;
            case "flexWrap":
                this.hg = nn.eli(str2);
                break;
            case "justifyContent":
                this.Bnk = MGA.eli(str2);
                break;
        }
    }

    public ui mm() {
        return this.vb;
    }

    /* renamed from: com.bytedance.adsdk.ugeno.yoga.DbA.eli$eli, reason: collision with other inner class name */
    public static class C0129eli extends eli.C0117eli {
        public int Cp;
        private boolean FS;
        public float GB;
        public float KM;
        private boolean SSo;
        public float Ue;
        private boolean Uv;
        public int VM;
        private boolean Za;
        public int cyF;
        private boolean dZ;
        public float eU;
        private boolean jh;
        public int nro;
        public int oWW;
        public int qj;
        public int ujq;

        public C0129eli(com.bytedance.adsdk.ugeno.DbA.eli eliVar) {
            super(eliVar);
            this.ujq = 1;
            this.Ue = 0.0f;
            this.KM = 1.0f;
            this.VM = com.bytedance.adsdk.ugeno.yoga.eli.AUTO.eli();
            this.GB = -1.0f;
            this.oWW = NU.RELATIVE.eli();
        }

        @Override // com.bytedance.adsdk.ugeno.DbA.eli.C0117eli
        public void eli(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.eli(context, str, str2);
            str.hashCode();
            switch (str) {
                case "flexBasis":
                    this.dZ = true;
                    float eli = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, -1.0f);
                    this.GB = eli;
                    this.GB = wC.eli(context, eli);
                    break;
                case "bottom":
                    this.Uv = true;
                    this.nro = (int) wC.eli(context, com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0));
                    break;
                case "top":
                    this.SSo = true;
                    this.qj = (int) wC.eli(context, com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0));
                    break;
                case "left":
                    this.FS = true;
                    this.Cp = (int) wC.eli(context, com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0));
                    break;
                case "order":
                    this.ujq = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 1);
                    break;
                case "ratio":
                    this.Za = true;
                    this.eU = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f);
                    break;
                case "right":
                    this.jh = true;
                    this.cyF = (int) wC.eli(context, com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0));
                    break;
                case "position":
                    this.oWW = NU.eli(str2).eli();
                    break;
                case "flexShrink":
                    this.KM = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 1.0f);
                    break;
                case "flexGrow":
                    this.Ue = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f);
                    break;
                case "alignSelf":
                    this.VM = com.bytedance.adsdk.ugeno.yoga.eli.eli(str2).eli();
                    break;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.DbA.eli.C0117eli
        /* renamed from: DbA, reason: merged with bridge method [inline-methods] */
        public Os.eli eli() {
            aGH();
            Os.eli eliVar = new Os.eli((int) this.eli, (int) this.DbA);
            eliVar.nlS((int) (this.Xb ? this.MGA : this.ui));
            eliVar.nn((int) (this.bf ? this.kb : this.ui));
            eliVar.du((int) (this.CMM ? this.wC : this.ui));
            eliVar.NU((int) (this.ev ? this.FC : this.ui));
            eliVar.eli(this.ujq);
            eliVar.ui(this.VM);
            eliVar.DbA(this.Ue);
            eliVar.Os(this.KM);
            eliVar.aqO(this.Os);
            eliVar.dV(this.aGH);
            if (this.dZ) {
                eliVar.aGH(this.GB);
            }
            eliVar.MGA(this.oWW);
            if (this.SSo) {
                eliVar.kb(this.qj);
            }
            if (this.Uv) {
                eliVar.FC(this.nro);
            }
            if (this.FS) {
                eliVar.wC(this.Cp);
            }
            if (this.jh) {
                eliVar.aAs(this.cyF);
            }
            if (this.Za && Os()) {
                float f = this.eU;
                if (f > 0.0f) {
                    eliVar.Dfc(f);
                    eliVar.Os(0.0f);
                    eliVar.DbA(0.0f);
                }
            }
            return eliVar;
        }

        public boolean Os() {
            if (this.eli == -1.0f && this.DbA == -1.0f) {
                return false;
            }
            return this.eli == -2.0f || this.DbA == -2.0f;
        }

        private void aGH() {
            if (this.gG instanceof eli) {
                if (((eli) this.gG).mm() == ui.ROW && this.gG.cyF() == -2 && this.eli == -1.0f && !this.gG.Za()) {
                    this.eli = -2.0f;
                    this.KM = 1.0f;
                    this.Ue = 1.0f;
                    this.dZ = true;
                    this.GB = -1.0f;
                }
                if (((eli) this.gG).mm() == ui.COLUMN && this.gG.eU() == -2 && this.DbA == -1.0f && !this.gG.Za()) {
                    this.DbA = -2.0f;
                    this.KM = 1.0f;
                    this.Ue = 1.0f;
                    this.dZ = true;
                    this.GB = -1.0f;
                }
            }
        }

        @Override // com.bytedance.adsdk.ugeno.DbA.eli.C0117eli
        public String toString() {
            return "LayoutParams{mOrder=" + this.ujq + ", mFlexGrow=" + this.Ue + ", mFlexShrink=" + this.KM + ", mAlignSelf=" + this.VM + ", mFlexBasis=" + this.GB + ", mPosition=" + this.oWW + ", mTop=" + this.qj + ", mBottom=" + this.nro + ", mLeft=" + this.Cp + ", mRight=" + this.cyF + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
