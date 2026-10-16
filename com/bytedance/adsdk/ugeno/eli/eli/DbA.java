package com.bytedance.adsdk.ugeno.eli.eli;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA extends eli {
    private Paint MGA;
    private int Os;
    private int aGH;
    private int ui;

    public DbA(com.bytedance.adsdk.ugeno.DbA.Os os, JSONObject jSONObject) {
        super(os, jSONObject);
        Paint paint = new Paint();
        this.MGA = paint;
        paint.setAntiAlias(true);
    }

    @Override // com.bytedance.adsdk.ugeno.eli.eli.eli
    public void DbA() {
        this.Os = com.bytedance.adsdk.ugeno.kb.eli.eli(this.eli.optString("backgroundColor"), -1);
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
        try {
            if (this.DbA.ikX() > 0.0f) {
                this.MGA.setColor(this.Os);
                this.MGA.setAlpha((int) ((1.0f - this.DbA.ikX()) * 255.0f));
                ((ViewGroup) this.DbA.du().getParent()).setClipChildren(true);
                canvas.drawCircle(this.aGH, this.ui, Math.min(r0, r2) * 2 * this.DbA.ikX(), this.MGA);
            }
        } catch (Throwable th) {
            Log.d("BaseEffectWrapper", "ripple animation error " + th.getMessage());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.eli.eli
    public void eli(int i, int i2) {
        this.aGH = i / 2;
        this.ui = i2 / 2;
    }

    @Override // com.bytedance.adsdk.ugeno.eli.eli.eli
    public List<PropertyValuesHolder> Os() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(aGH(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        return arrayList;
    }
}
