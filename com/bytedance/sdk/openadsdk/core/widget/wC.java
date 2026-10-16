package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class wC extends View {
    private static final int[] eli = {Color.parseColor("#1AFFFFFF"), Color.parseColor("#4DFFFFFF"), Color.parseColor("#99FFFFFF")};
    private final RectF DbA;
    private int FC;
    private final Paint MGA;
    private final RectF Os;
    private final ArrayList<eli> aGH;
    private int kb;
    private final Paint ui;
    private int wC;

    public wC(Context context) {
        super(context);
        this.DbA = new RectF();
        this.Os = new RectF();
        this.aGH = new ArrayList<>();
        this.MGA = new Paint();
        Paint paint = new Paint();
        this.ui = paint;
        paint.setColor(Color.parseColor("#D9D9D9"));
    }

    public void setProgress(int i) {
        int i2 = this.wC;
        if (i2 == i) {
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        if (i2 == i) {
            return;
        }
        this.wC = i;
        eli();
    }

    private void eli() {
        if (this.kb <= 0) {
            return;
        }
        int width = (int) (((this.wC * 1.0f) / 100.0f) * getWidth());
        this.Os.right = Math.max(this.FC, width);
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = i2 / 2;
        this.kb = i5;
        this.FC = i5 * 5;
        float f = i;
        float f2 = i2;
        this.DbA.set(0.0f, 0.0f, f, f2);
        this.Os.set(0.0f, 0.0f, 0.0f, f2);
        this.MGA.setShader(new LinearGradient(0.0f, 0.0f, f, f2, new int[]{Color.parseColor("#90C0FF"), Color.parseColor("#196BE4")}, (float[]) null, Shader.TileMode.CLAMP));
        this.aGH.clear();
        float f3 = this.kb / 4.0f;
        for (int i6 : eli) {
            Paint paint = new Paint();
            paint.setColor(i6);
            this.aGH.add(new eli(paint, this.kb / 2.0f, f3, f2 / 2.0f));
            f3 += (this.kb / 2.0f) * 3.0f;
        }
        eli();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.DbA;
        int i = this.kb;
        canvas.drawRoundRect(rectF, i, i, this.ui);
        RectF rectF2 = this.Os;
        int i2 = this.kb;
        canvas.drawRoundRect(rectF2, i2, i2, this.MGA);
        int save = canvas.save();
        canvas.translate(this.Os.right - this.FC, 0.0f);
        Iterator<eli> it = this.aGH.iterator();
        while (it.hasNext()) {
            eli next = it.next();
            canvas.drawCircle(next.Os, next.aGH, next.DbA, next.eli);
        }
        canvas.restoreToCount(save);
    }

    private static final class eli {
        public float DbA;
        float Os;
        float aGH;
        public Paint eli;

        public eli(Paint paint, float f, float f2, float f3) {
            this.eli = paint;
            this.DbA = f;
            this.Os = f2;
            this.aGH = f3;
        }
    }
}
