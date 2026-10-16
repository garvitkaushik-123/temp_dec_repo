package com.bytedance.adsdk.ugeno.eli.eli;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.kb.eli;
import com.bytedance.adsdk.ugeno.kb.wC;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH extends eli {
    private static final float Dfc;
    private static final float aqO;
    private static final float dV;
    private static final float nn;
    private float FC;
    private eli.C0126eli MGA;
    private Path NU;
    private int Os;
    private int aAs;
    private Paint aGH;
    private int du;
    private int kb;
    private float nGm;
    private boolean nlS;
    private Path ui;
    private int wC;

    static {
        float radians = (float) Math.toRadians(30.0d);
        nn = radians;
        Dfc = (float) Math.tan(radians);
        aqO = (float) Math.cos(radians);
        dV = (float) Math.sin(radians);
    }

    public aGH(com.bytedance.adsdk.ugeno.DbA.Os os, JSONObject jSONObject) {
        super(os, jSONObject);
        this.nlS = true;
        Paint paint = new Paint();
        this.aGH = paint;
        paint.setAntiAlias(true);
        this.ui = new Path();
        this.FC = this.DbA.ev();
        this.NU = new Path();
    }

    @Override // com.bytedance.adsdk.ugeno.eli.eli.eli
    public void DbA() {
        this.Os = (int) wC.eli(this.DbA.du().getContext(), this.eli.optInt("shineWidth", 30));
        String optString = this.eli.optString("backgroundColor", "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))");
        String str = TextUtils.isEmpty(optString) ? "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))" : optString;
        if (str.startsWith("linear")) {
            this.MGA = com.bytedance.adsdk.ugeno.kb.eli.DbA(str);
        } else {
            int eli = com.bytedance.adsdk.ugeno.kb.eli.eli(str);
            this.kb = eli;
            this.wC = com.bytedance.adsdk.ugeno.kb.eli.eli(eli, 32);
            this.nlS = false;
        }
        this.nGm = aqO * this.Os;
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
        LinearGradient linearGradient;
        try {
            if (this.DbA.tGZ() > 0.0f) {
                int i = this.aAs;
                float f = Dfc;
                float tGZ = (i + (i * f)) * this.DbA.tGZ();
                this.NU.reset();
                this.NU.moveTo(tGZ, 0.0f);
                int i2 = this.du;
                float f2 = tGZ - (i2 * f);
                this.NU.lineTo(f2, i2);
                this.NU.lineTo(f2 + this.Os, this.du);
                this.NU.lineTo(this.Os + tGZ, 0.0f);
                this.NU.close();
                float f3 = this.nGm;
                float f4 = aqO * f3;
                float f5 = f3 * dV;
                if (this.nlS && this.MGA != null) {
                    linearGradient = new LinearGradient(tGZ, 0.0f, tGZ + f4, f5, this.MGA.DbA, (float[]) null, Shader.TileMode.CLAMP);
                } else {
                    int i3 = this.wC;
                    linearGradient = new LinearGradient(tGZ, 0.0f, tGZ + f4, f5, new int[]{i3, this.kb, i3}, (float[]) null, Shader.TileMode.CLAMP);
                }
                this.aGH.setShader(linearGradient);
                Path path = this.ui;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                canvas.drawPath(this.NU, this.aGH);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.eli.eli
    public void eli(int i, int i2) {
        this.aAs = i;
        this.du = i2;
        try {
            RectF rectF = new RectF(0.0f, 0.0f, i, i2);
            Path path = this.ui;
            float f = this.FC;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.eli.eli
    public List<PropertyValuesHolder> Os() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(aGH(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        return arrayList;
    }
}
