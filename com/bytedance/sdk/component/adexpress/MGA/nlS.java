package com.bytedance.sdk.component.adexpress.MGA;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class nlS extends View {
    Rect DbA;
    private final List<eli> Dfc;
    private int[] FC;
    private int MGA;
    private PorterDuff.Mode NU;
    private int Os;
    private Bitmap aAs;
    private int aGH;
    private Paint du;
    Rect eli;
    private int kb;
    private Xfermode nlS;
    private LinearGradient nn;
    private int ui;
    private int wC;

    public nlS(Context context) {
        super(context);
        this.NU = PorterDuff.Mode.DST_IN;
        this.Dfc = new ArrayList();
        eli();
    }

    private void eli() {
        this.Os = com.bytedance.sdk.component.utils.ev.aGH(getContext(), "tt_splash_unlock_image_arrow");
        this.aGH = Color.parseColor("#00ffffff");
        this.ui = Color.parseColor("#ffffffff");
        int parseColor = Color.parseColor("#00ffffff");
        this.MGA = parseColor;
        this.kb = 10;
        this.wC = 40;
        this.FC = new int[]{this.aGH, this.ui, parseColor};
        setLayerType(1, null);
        this.du = new Paint(1);
        this.aAs = BitmapFactory.decodeResource(getResources(), this.Os);
        this.nlS = new PorterDuffXfermode(this.NU);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.aAs, this.eli, this.DbA, this.du);
        canvas.save();
        Iterator<eli> it = this.Dfc.iterator();
        while (it.hasNext()) {
            eli next = it.next();
            this.nn = new LinearGradient(next.DbA, 0.0f, next.DbA + this.wC, this.kb, this.FC, (float[]) null, Shader.TileMode.CLAMP);
            this.du.setColor(-1);
            this.du.setShader(this.nn);
            Canvas canvas2 = canvas;
            canvas2.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.du);
            this.du.setShader(null);
            next.eli();
            if (next.DbA > getWidth()) {
                it.remove();
            }
            canvas = canvas2;
        }
        Canvas canvas3 = canvas;
        this.du.setXfermode(this.nlS);
        canvas3.drawBitmap(this.aAs, this.eli, this.DbA, this.du);
        this.du.setXfermode(null);
        canvas3.restore();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aAs == null) {
            return;
        }
        this.eli = new Rect(0, 0, this.aAs.getWidth(), this.aAs.getHeight());
        this.DbA = new Rect(0, 0, getWidth(), getHeight());
    }

    public void eli(int i) {
        this.Dfc.add(new eli(i));
        postInvalidate();
    }

    public static class eli {
        private int DbA = 0;
        private final int eli;

        public eli(int i) {
            this.eli = i;
        }

        public void eli() {
            this.DbA += this.eli;
        }
    }
}
