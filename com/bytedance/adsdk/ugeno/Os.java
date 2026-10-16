package com.bytedance.adsdk.ugeno;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.adjust.sdk.Constants;
import com.bytedance.adsdk.ugeno.core.nlS;
import com.bytedance.adsdk.ugeno.kb.wC;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes3.dex */
public class Os extends com.bytedance.adsdk.ugeno.DbA.eli<com.bytedance.adsdk.ugeno.MGA.DbA> {
    private boolean Bnk;
    private int CH;
    private com.bytedance.adsdk.ugeno.DbA.Os Ib;
    private JSONArray OJ;
    private float QMZ;
    private float QW;
    private float SjY;
    private float TiA;
    private boolean Tju;
    private float XlF;
    private boolean hg;
    private String kEI;
    private float nY;
    private String vb;
    private int yw;

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    public void eli(JSONObject jSONObject) {
    }

    public Os(Context context) {
        super(context);
        this.hg = true;
        this.Bnk = true;
        this.QW = 0.0f;
        this.nY = 2000.0f;
        this.kEI = Constants.NORMAL;
        this.Tju = true;
        this.yw = Color.parseColor("#666666");
        this.CH = Color.parseColor("#ffffff");
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    public View eli() {
        this.ui = new com.bytedance.adsdk.ugeno.MGA.DbA(this.DbA);
        ((com.bytedance.adsdk.ugeno.MGA.DbA) this.ui).eli((aGH) this);
        return this.ui;
    }

    public void eli(com.bytedance.adsdk.ugeno.MGA.Os os) {
        if (this.ui != 0) {
            ((com.bytedance.adsdk.ugeno.MGA.DbA) this.ui).setOnPageChangeListener(os);
        }
    }

    public void eli(int i) {
        if (this.ui != 0) {
            ((com.bytedance.adsdk.ugeno.MGA.DbA) this.ui).NU(i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.eli, com.bytedance.adsdk.ugeno.DbA.Os
    public void DbA() {
        super.DbA();
        JSONArray jSONArray = this.OJ;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.MGA.DbA) this.ui).kb((int) this.XlF).wC((int) this.SjY).FC((int) this.TiA).Os(this.Tju).ui(this.CH).MGA(this.yw).Os(this.kEI).aGH(this.hg).ui(this.QMZ).eli(this.Bnk).aGH((int) this.nY).Os(this.Tju);
        for (int i = 0; i < this.OJ.length(); i++) {
            nlS nls = new nlS(this.DbA);
            nls.eli(this.iuv);
            com.bytedance.adsdk.ugeno.DbA.Os<View> DbA = nls.DbA(this.Ib.GB(), null);
            nls.DbA(this.OJ.optJSONObject(i));
            ((com.bytedance.adsdk.ugeno.MGA.DbA) this.ui).eli((com.bytedance.adsdk.ugeno.MGA.DbA) DbA);
        }
        if (this.Bnk) {
            ((com.bytedance.adsdk.ugeno.MGA.DbA) this.ui).Os();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.eli
    public void eli(com.bytedance.adsdk.ugeno.DbA.Os os) {
        this.Ib = os;
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    public void eli(String str, String str2) {
        super.eli(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        switch (str) {
            case "delayStart":
                this.QW = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f);
                break;
            case "indicatorColor":
                this.yw = com.bytedance.adsdk.ugeno.kb.eli.eli(str2);
                break;
            case "nextMargin":
                this.TiA = wC.eli(this.DbA, com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f));
                break;
            case "effect":
                this.kEI = str2;
                break;
            case "direction":
                this.vb = str2;
                break;
            case "indicator":
                this.Tju = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, true);
                break;
            case "previousMargin":
                this.SjY = wC.eli(this.DbA, com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f));
                break;
            case "loop":
                this.hg = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, true);
                break;
            case "speed":
                this.nY = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 500.0f);
                break;
            case "pageCount":
                this.QMZ = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 1.0f);
                break;
            case "pageMargin":
                this.XlF = wC.eli(this.DbA, com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f));
                break;
            case "indicatorSelectedColor":
                this.CH = com.bytedance.adsdk.ugeno.kb.eli.eli(str2);
                break;
            case "autoplay":
                this.Bnk = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, true);
                break;
            case "dataList":
                this.OJ = com.bytedance.adsdk.ugeno.kb.DbA.eli(str2, (JSONArray) null);
                break;
        }
    }
}
