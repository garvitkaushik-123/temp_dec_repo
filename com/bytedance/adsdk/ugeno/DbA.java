package com.bytedance.adsdk.ugeno;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.aGH.MGA;
import com.bytedance.adsdk.ugeno.core.nlS;
import com.bytedance.adsdk.ugeno.kb.wC;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA extends com.bytedance.adsdk.ugeno.DbA.eli<com.bytedance.adsdk.ugeno.MGA.DbA> implements com.bytedance.adsdk.ugeno.MGA.Os {
    private boolean Bnk;
    private float CH;
    private boolean GMu;
    private int ID;
    private boolean Ib;
    private float OJ;
    private int Pf;
    private float QMZ;
    private float QW;
    private int SjY;
    private String TiA;
    private String Tju;
    private int XlF;
    private float ZLD;
    private JSONArray an;
    private boolean bU;
    private int cvo;
    private float dM;
    private boolean hg;
    private String kEI;
    private float lYL;
    private boolean lkd;
    private float nY;
    private float tpZ;
    private boolean umh;
    private int vb;
    private float yw;

    public DbA(Context context) {
        super(context);
        this.vb = 0;
        this.hg = true;
        this.Bnk = true;
        this.QW = 500.0f;
        this.nY = 2000.0f;
        this.kEI = "slide";
        this.Tju = "dot";
        this.yw = 8.0f;
        this.CH = 8.0f;
        this.QMZ = 50.0f;
        this.OJ = 90.0f;
        this.Ib = false;
        this.XlF = Color.parseColor("#666666");
        this.SjY = Color.parseColor("#ffffff");
        this.TiA = "row";
        this.dM = 1.0f;
        this.lYL = 0.0f;
        this.tpZ = 0.0f;
        this.ZLD = 0.0f;
        this.ID = 0;
        this.Pf = 0;
        this.bU = true;
        this.GMu = false;
        this.lkd = true;
        float eli = wC.eli(this.DbA, 8.0f);
        this.yw = eli;
        this.CH = eli;
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    public View eli() {
        this.ui = new com.bytedance.adsdk.ugeno.MGA.DbA(this.DbA);
        ((com.bytedance.adsdk.ugeno.MGA.DbA) this.ui).eli((aGH) this);
        return this.ui;
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.eli, com.bytedance.adsdk.ugeno.DbA.Os
    public void DbA() {
        super.DbA();
        ((com.bytedance.adsdk.ugeno.MGA.DbA) this.ui).Os((int) this.QW).ui(this.GMu).eli(this.Tju).eli(this.yw).DbA(this.CH).Os(this.QMZ).aGH(this.OJ).DbA(this.TiA).eli(this.vb).DbA().aGH(this.hg).eli(this.Bnk).DbA((int) this.QW).aGH((int) this.nY).DbA(this.bU).Os(this.Ib).MGA(this.XlF).ui(this.SjY).wC((int) this.tpZ).FC((int) this.ZLD).kb((int) this.lYL).ui(this.dM).Os(this.kEI).NU(this.Pf);
        ((com.bytedance.adsdk.ugeno.MGA.DbA) this.ui).setOnPageChangeListener(this);
        if (this.ID == 1) {
            oc();
        } else {
            mm();
        }
        ((com.bytedance.adsdk.ugeno.MGA.DbA) this.ui).Os();
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.eli
    public void eli(com.bytedance.adsdk.ugeno.DbA.Os os) {
        if (os == null) {
            return;
        }
        this.eli.add(os);
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.eli
    public void eli(com.bytedance.adsdk.ugeno.DbA.Os os, ViewGroup.LayoutParams layoutParams) {
        if (os == null) {
            return;
        }
        this.eli.add(os);
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    public void eli(String str, String str2) {
        super.eli(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        switch (str) {
            case "startIndex":
                this.Pf = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0);
                break;
            case "indicatorColor":
                this.XlF = com.bytedance.adsdk.ugeno.kb.eli.eli(str2, this.XlF);
                break;
            case "indicatorStyle":
                this.Tju = str2;
                break;
            case "indicatorWidth":
                this.yw = wC.eli(this.DbA, com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 8.0f));
                break;
            case "indicatorHeight":
                this.CH = wC.eli(this.DbA, com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 8.0f));
                break;
            case "nextMargin":
                this.ZLD = wC.eli(this.DbA, com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f));
                break;
            case "driveMode":
                this.ID = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0);
                break;
            case "effect":
                this.kEI = str2;
                break;
            case "direction":
                if (TextUtils.equals(str2, "vertical")) {
                    this.vb = 1;
                    break;
                } else {
                    this.vb = 0;
                    break;
                }
            case "disableOnInteraction":
                this.GMu = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, false);
                break;
            case "indicator":
                this.Ib = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, false);
                break;
            case "indicatorX":
                this.QMZ = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 50.0f);
                break;
            case "indicatorY":
                this.OJ = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 90.0f);
                break;
            case "previousMargin":
                this.tpZ = wC.eli(this.DbA, com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f));
                break;
            case "loop":
                this.hg = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, true);
                break;
            case "delay":
                this.nY = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 2000.0f);
                break;
            case "speed":
                this.QW = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 500.0f);
                break;
            case "indicatorDirection":
                this.TiA = str2;
                break;
            case "allowTouchMove":
                this.bU = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, true);
                break;
            case "pageCount":
                this.dM = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 1.0f);
                break;
            case "pageMargin":
                this.lYL = wC.eli(this.DbA, com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f));
                break;
            case "indicatorSelectedColor":
                this.SjY = com.bytedance.adsdk.ugeno.kb.eli.eli(str2, this.SjY);
                break;
            case "autoplay":
                this.Bnk = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, true);
                break;
            case "dataList":
                this.an = com.bytedance.adsdk.ugeno.kb.DbA.eli(str2, (JSONArray) null);
                break;
        }
    }

    private void mm() {
        if (this.eli == null || this.eli.isEmpty()) {
            return;
        }
        com.bytedance.adsdk.ugeno.DbA.Os<View> os = this.eli.get(0);
        if (this.an == null) {
            return;
        }
        for (int i = 0; i < this.an.length(); i++) {
            nlS nls = new nlS(this.DbA);
            eli(nls);
            nls.eli(this.iuv);
            try {
                JSONObject optJSONObject = this.an.optJSONObject(i);
                if (optJSONObject != null) {
                    if (optJSONObject.has("$chunk")) {
                        this.aGH.put("$item", optJSONObject.optJSONArray("$chunk"));
                    } else {
                        this.aGH.put("$item", optJSONObject);
                    }
                    ((com.bytedance.adsdk.ugeno.MGA.DbA) this.ui).eli((com.bytedance.adsdk.ugeno.MGA.DbA) nls.eli(os.GB(), this.aGH, (JSONObject) null));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void oc() {
        for (int i = 0; i < this.eli.size(); i++) {
            com.bytedance.adsdk.ugeno.DbA.Os<View> os = this.eli.get(i);
            if (os != null) {
                nlS nls = new nlS(this.DbA);
                eli(nls);
                nls.eli(this.iuv);
                ((com.bytedance.adsdk.ugeno.MGA.DbA) this.ui).eli((com.bytedance.adsdk.ugeno.MGA.DbA) nls.eli(os.GB(), this.aGH, (JSONObject) null));
            }
        }
    }

    private int rQ() {
        if (this.ID == 1) {
            if (this.eli != null) {
                return this.eli.size();
            }
            return 0;
        }
        JSONArray jSONArray = this.an;
        if (jSONArray != null) {
            return jSONArray.length();
        }
        return 0;
    }

    public void Os() {
        ((com.bytedance.adsdk.ugeno.MGA.DbA) this.ui).NU(((com.bytedance.adsdk.ugeno.MGA.DbA) this.ui).getCurrentItem() + 1);
    }

    public void aGH() {
        ((com.bytedance.adsdk.ugeno.MGA.DbA) this.ui).NU(((com.bytedance.adsdk.ugeno.MGA.DbA) this.ui).getCurrentItem() - 1);
    }

    public void eli(int i) {
        if (((com.bytedance.adsdk.ugeno.MGA.DbA) this.ui).getCurrentItem() != i) {
            ((com.bytedance.adsdk.ugeno.MGA.DbA) this.ui).NU(i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MGA.Os
    public void eli(boolean z, int i, float f, int i2) {
        Log.d("BaseSwiper", "onPageScrolled: loop=" + z + "; position=" + i + "; positionOffset=" + f + "; positionOffsetPixels=" + i2);
        eli(z, i, f);
    }

    @Override // com.bytedance.adsdk.ugeno.MGA.Os
    public void eli(boolean z, int i, int i2, boolean z2, boolean z3) {
        if (this.cvo != i) {
            kb(i);
            wC(i);
            this.cvo = i;
        }
        Log.d("BaseSwiper", "onPageSelected: loop=" + z + "; position=" + i + "; loopPosition=" + i2 + "; isFirst=" + z2 + "; isLast=" + z3);
    }

    @Override // com.bytedance.adsdk.ugeno.MGA.Os
    public void eli(boolean z, int i) {
        if (i == 0) {
            if (!z) {
                this.lkd = true;
            }
            this.umh = false;
        } else if (i == 1) {
            this.umh = true;
        }
        Log.d("BaseSwiper", "onPageScrollStateChanged: loop=" + z + "; state=" + i);
    }

    private void kb(int i) {
        if (this.qWy == null) {
            return;
        }
        if (this.cvo == 0 && i == rQ() - 1) {
            this.qWy.eli("SwiperView://reloop", 1);
            Log.d("BaseSwiper", "onPageSelected: reloop monitor FIRST_TO_LAST");
        }
        if (this.cvo == rQ() - 1 && i == 0) {
            this.qWy.eli("SwiperView://reloop", 0);
            Log.d("BaseSwiper", "onPageSelected: reloop monitor LAST_TO_FIRST");
        }
    }

    private void wC(int i) {
        if (this.qWy == null) {
            return;
        }
        this.qWy.eli("SwiperView://slide", Integer.valueOf(this.cvo), Integer.valueOf(i), Integer.valueOf(!this.umh ? 1 : 0));
    }

    private void eli(boolean z, int i, float f) {
        if (this.qWy != null && !z && i == rQ() - 1 && f == 0.0f && this.lkd) {
            this.qWy.eli("SwiperView://finish", new Object[0]);
            Log.d("BaseSwiper", "onPageScrolled: finish monitor");
            this.lkd = false;
        }
    }

    private void eli(nlS nls) {
        if (this.GMu) {
            nls.eli(new com.bytedance.adsdk.ugeno.core.ui() { // from class: com.bytedance.adsdk.ugeno.DbA.1
                @Override // com.bytedance.adsdk.ugeno.core.ui
                public void eli(com.bytedance.adsdk.ugeno.DbA.Os os, String str, List<MGA.eli> list) {
                    if ((TextUtils.equals(str, "tap") || TextUtils.equals(str, "slide") || TextUtils.equals(str, "touchStart") || TextUtils.equals(str, "touchEnd")) && DbA.this.ui != null) {
                        ((com.bytedance.adsdk.ugeno.MGA.DbA) DbA.this.ui).MGA();
                    }
                }
            });
        }
    }
}
