package com.bytedance.adsdk.ugeno.eli.eli;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os extends eli {
    private PorterDuffXfermode FC;
    private View MGA;
    private String Os;
    private LinearGradient aAs;
    private float aGH;
    private Matrix du;
    private Paint kb;
    private float ui;
    private Paint wC;

    public Os(com.bytedance.adsdk.ugeno.DbA.Os os, JSONObject jSONObject) {
        super(os, jSONObject);
        this.MGA = this.DbA.du();
        Paint paint = new Paint();
        this.kb = paint;
        paint.setAntiAlias(true);
        this.MGA.setLayerType(2, null);
        this.FC = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.wC = new Paint();
        this.du = new Matrix();
    }

    @Override // com.bytedance.adsdk.ugeno.eli.eli.eli
    public void DbA() {
        this.Os = this.eli.optString("direction", "left");
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
        char c;
        try {
            if (this.DbA.ow() > 0.0f) {
                int ow = (int) (this.aGH * this.DbA.ow());
                int ow2 = (int) (this.ui * this.DbA.ow());
                this.kb.setXfermode(this.FC);
                String str = this.Os;
                switch (str.hashCode()) {
                    case -1383228885:
                        if (str.equals("bottom")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 115029:
                        if (str.equals("top")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3317767:
                        if (str.equals("left")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 108511772:
                        if (str.equals("right")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c == 0) {
                    float f = ow;
                    canvas.drawRect(f, 0.0f, this.aGH, this.ui, this.kb);
                    this.du.setTranslate(f, this.ui);
                    this.aAs.setLocalMatrix(this.du);
                    this.wC.setShader(this.aAs);
                    if (this.DbA.ow() <= 1.0f && this.DbA.ow() > 0.9f) {
                        this.wC.setAlpha((int) (255.0f - (this.DbA.ow() * 255.0f)));
                    }
                    canvas.drawRect(0.0f, 0.0f, f, this.ui, this.wC);
                    return;
                }
                if (c == 1) {
                    float f2 = ow;
                    canvas.drawRect(0.0f, 0.0f, this.aGH - f2, this.ui, this.kb);
                    this.du.setTranslate(this.aGH - f2, 0.0f);
                    this.aAs.setLocalMatrix(this.du);
                    this.wC.setShader(this.aAs);
                    if (this.DbA.ow() <= 1.0f && this.DbA.ow() > 0.9f) {
                        this.wC.setAlpha((int) (255.0f - (this.DbA.ow() * 255.0f)));
                    }
                    float f3 = this.aGH;
                    canvas.drawRect(f3, this.ui, f3 - f2, 0.0f, this.wC);
                    return;
                }
                if (c == 2) {
                    float f4 = ow2;
                    canvas.drawRect(0.0f, f4, this.aGH, this.ui, this.kb);
                    this.du.setTranslate(0.0f, f4);
                    this.aAs.setLocalMatrix(this.du);
                    this.wC.setShader(this.aAs);
                    if (this.DbA.ow() <= 1.0f && this.DbA.ow() > 0.9f) {
                        this.wC.setAlpha((int) (255.0f - (this.DbA.ow() * 255.0f)));
                    }
                    canvas.drawRect(0.0f, 0.0f, this.aGH, f4, this.wC);
                    return;
                }
                if (c != 3) {
                    return;
                }
                float f5 = ow2;
                canvas.drawRect(0.0f, 0.0f, this.aGH, this.ui - f5, this.kb);
                this.du.setTranslate(0.0f, this.ui - f5);
                this.aAs.setLocalMatrix(this.du);
                this.wC.setShader(this.aAs);
                if (this.DbA.ow() <= 1.0f && this.DbA.ow() > 0.9f) {
                    this.wC.setAlpha((int) (255.0f - (this.DbA.ow() * 255.0f)));
                }
                float f6 = this.aGH;
                float f7 = this.ui;
                canvas.drawRect(f6, f7, 0.0f, f7 - f5, this.wC);
                return;
            }
            this.kb.setXfermode(this.FC);
            canvas.drawRect(0.0f, 0.0f, this.aGH, this.ui, this.kb);
        } catch (Throwable th) {
            Log.e("BaseEffectWrapper", th.getMessage());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.eli.eli
    public void eli(int i, int i2) {
        this.aGH = i;
        this.ui = i2;
        String str = this.Os;
        str.hashCode();
        switch (str) {
            case "bottom":
                this.aAs = new LinearGradient(0.0f, -this.ui, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "top":
                this.aAs = new LinearGradient(0.0f, this.ui, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "left":
                this.aAs = new LinearGradient(this.aGH, 0.0f, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "right":
                this.aAs = new LinearGradient(-this.aGH, 0.0f, 0.0f, this.ui, 0, -1, Shader.TileMode.CLAMP);
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.eli.eli
    public List<PropertyValuesHolder> Os() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PropertyValuesHolder.ofFloat("rubIn", 0.0f, 1.0f));
        arrayList.add(PropertyValuesHolder.ofFloat(com.bytedance.adsdk.ugeno.eli.ui.ALPHA.DbA(), 0.0f, 1.0f));
        return arrayList;
    }
}
