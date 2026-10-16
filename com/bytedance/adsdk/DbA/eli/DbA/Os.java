package com.bytedance.adsdk.DbA.eli.DbA;

import android.graphics.Color;
import android.graphics.Paint;
import com.bytedance.adsdk.DbA.eli.DbA.eli;

/* loaded from: classes3.dex */
public class Os implements eli.InterfaceC0115eli {
    private final eli<Integer, Integer> DbA;
    private final eli<Float, Float> MGA;
    private final eli<Float, Float> Os;
    private final eli<Float, Float> aGH;
    private final eli.InterfaceC0115eli eli;
    private boolean kb = true;
    private final eli<Float, Float> ui;

    public Os(eli.InterfaceC0115eli interfaceC0115eli, com.bytedance.adsdk.DbA.Os.Os.eli eliVar, com.bytedance.adsdk.DbA.ui.aAs aas) {
        this.eli = interfaceC0115eli;
        eli<Integer, Integer> eli = aas.eli().eli();
        this.DbA = eli;
        eli.eli(this);
        eliVar.eli(eli);
        eli<Float, Float> eli2 = aas.DbA().eli();
        this.Os = eli2;
        eli2.eli(this);
        eliVar.eli(eli2);
        eli<Float, Float> eli3 = aas.Os().eli();
        this.aGH = eli3;
        eli3.eli(this);
        eliVar.eli(eli3);
        eli<Float, Float> eli4 = aas.aGH().eli();
        this.ui = eli4;
        eli4.eli(this);
        eliVar.eli(eli4);
        eli<Float, Float> eli5 = aas.ui().eli();
        this.MGA = eli5;
        eli5.eli(this);
        eliVar.eli(eli5);
    }

    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.InterfaceC0115eli
    public void eli() {
        this.kb = true;
        this.eli.eli();
    }

    public void eli(Paint paint) {
        if (this.kb) {
            this.kb = false;
            double floatValue = this.aGH.kb().floatValue() * 0.017453292519943295d;
            float floatValue2 = this.ui.kb().floatValue();
            float sin = ((float) Math.sin(floatValue)) * floatValue2;
            float cos = ((float) Math.cos(floatValue + 3.141592653589793d)) * floatValue2;
            int intValue = this.DbA.kb().intValue();
            paint.setShadowLayer(this.MGA.kb().floatValue(), sin, cos, Color.argb(Math.round(this.Os.kb().floatValue()), Color.red(intValue), Color.green(intValue), Color.blue(intValue)));
        }
    }
}
