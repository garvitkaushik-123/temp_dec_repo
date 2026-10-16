package com.bytedance.adsdk.ugeno.FC.ui;

import android.content.Context;
import android.graphics.Color;
import com.bytedance.adsdk.ugeno.DbA.Os;

/* loaded from: classes3.dex */
public class DbA extends Os<eli> {
    private float Bnk;
    private float QW;
    private int eli;
    private float hg;
    private int vb;
    private static final int nY = Color.parseColor("#FFC642");
    private static final int kEI = Color.parseColor("#e3e3e4");

    public DbA(Context context) {
        super(context);
        this.eli = nY;
        this.vb = kEI;
        this.hg = 4.0f;
        this.Bnk = 20.0f;
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
        if (oWW()) {
            ((eli) this.ui).eli(this.hg, this.eli, this.vb, this.Bnk, (int) this.QW);
        } else {
            ((eli) this.ui).eli(this.hg, this.eli, this.vb, this.Bnk, 5);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    public void eli(String str, String str2) {
        super.eli(str, str2);
        str.hashCode();
        switch (str) {
            case "highLightColor":
            case "highlightColor":
                this.eli = com.bytedance.adsdk.ugeno.kb.eli.eli(str2);
                break;
            case "lowLightColor":
            case "lowlightColor":
                this.vb = com.bytedance.adsdk.ugeno.kb.eli.eli(str2, kEI);
                break;
            case "gap":
                this.QW = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f);
                break;
            case "size":
                this.Bnk = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 20.0f);
                break;
            case "score":
                this.hg = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 4.0f);
                break;
        }
    }
}
