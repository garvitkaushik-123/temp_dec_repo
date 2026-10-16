package com.bytedance.adsdk.ugeno.eli.eli;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ui extends eli {
    private boolean FC;
    private float MGA;
    private PorterDuffXfermode NU;
    private float Os;
    private Path aAs;
    private float aGH;
    private Path du;
    private String kb;
    private Path nlS;
    private Paint ui;
    private boolean wC;

    public ui(com.bytedance.adsdk.ugeno.DbA.Os os, JSONObject jSONObject) {
        super(os, jSONObject);
        this.wC = true;
        this.FC = true;
        Paint paint = new Paint();
        this.ui = paint;
        paint.setAntiAlias(true);
        this.DbA.du().setLayerType(2, null);
        this.NU = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.aAs = new Path();
        this.du = new Path();
        this.nlS = new Path();
        this.ui.setXfermode(this.NU);
    }

    @Override // com.bytedance.adsdk.ugeno.eli.eli.eli
    public void DbA() {
        this.MGA = (float) this.eli.optDouble("start", 0.0d);
        this.kb = this.eli.optString("direction", "center");
    }

    @Override // com.bytedance.adsdk.ugeno.eli.eli.eli
    public void eli(Canvas canvas) {
        Os(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.eli.eli.eli
    public void DbA(Canvas canvas) {
        Os(canvas);
    }

    private void Os(Canvas canvas) {
        int WfR;
        int WfR2;
        if (this.DbA.WfR() > 0.0f) {
            WfR = (int) (this.Os * this.DbA.WfR());
            WfR2 = (int) (this.aGH * this.DbA.WfR());
            this.ui.setXfermode(this.NU);
            String str = this.kb;
            str.hashCode();
            switch (str) {
                case "bottom":
                    canvas.drawRect(0.0f, WfR2, this.Os, this.aGH, this.ui);
                    break;
                case "center":
                    this.aAs.reset();
                    this.du.reset();
                    this.nlS.reset();
                    this.aAs.addCircle(this.Os / 2.0f, this.aGH / 2.0f, WfR, Path.Direction.CW);
                    Path path = this.du;
                    float f = this.Os;
                    path.addRect(f / 2.0f, 0.0f, f, this.aGH, Path.Direction.CW);
                    this.du.op(this.aAs, Path.Op.DIFFERENCE);
                    this.nlS.addRect(0.0f, 0.0f, this.Os / 2.0f, this.aGH, Path.Direction.CW);
                    this.nlS.op(this.aAs, Path.Op.DIFFERENCE);
                    canvas.drawPath(this.du, this.ui);
                    canvas.drawPath(this.nlS, this.ui);
                    break;
                case "top":
                    canvas.drawRect(0.0f, 0.0f, this.Os, this.aGH - WfR2, this.ui);
                    break;
                case "left":
                    canvas.drawRect(0.0f, 0.0f, this.Os - WfR, this.aGH, this.ui);
                    break;
                case "right":
                    canvas.drawRect(WfR, 0.0f, this.Os, this.aGH, this.ui);
                    break;
            }
            return;
        }
        this.ui.setXfermode(this.NU);
        canvas.drawRect(0.0f, 0.0f, this.Os, this.aGH, this.ui);
    }

    @Override // com.bytedance.adsdk.ugeno.eli.eli.eli
    public void eli(int i, int i2) {
        if (i > 0 && this.wC) {
            this.Os = i;
            this.wC = false;
        }
        if (i2 <= 0 || !this.FC) {
            return;
        }
        this.aGH = i2;
        this.FC = false;
    }

    @Override // com.bytedance.adsdk.ugeno.eli.eli.eli
    public List<PropertyValuesHolder> Os() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(aGH(), this.MGA, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        return arrayList;
    }
}
