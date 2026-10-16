package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class aqO extends View {
    private final boolean DbA;
    private float MGA;
    private int Os;
    private Drawable aGH;
    private final Path eli;
    private Drawable ui;

    public aqO(Context context) {
        this(context, false);
    }

    public aqO(Context context, boolean z) {
        super(context);
        this.eli = new Path();
        this.DbA = z;
        eli();
    }

    private void eli() {
        Context context = getContext();
        this.aGH = ev.Os(context, this.DbA ? "tt_star_thick_dark" : "tt_star_thick");
        this.ui = ev.Os(context, "tt_star");
    }

    public void eli(double d, int i) {
        int eli = (int) SSo.eli(getContext(), i, false);
        this.Os = eli;
        this.aGH.setBounds(0, 0, eli, eli);
        Drawable drawable = this.ui;
        int i2 = this.Os;
        drawable.setBounds(0, 0, i2, i2);
        this.MGA = ((float) d) / 5.0f;
        DbA();
        requestLayout();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        DbA();
    }

    private void DbA() {
        int width = getWidth();
        int height = getHeight();
        if (this.MGA <= 0.0f || width <= 0 || height <= 0) {
            return;
        }
        this.eli.reset();
        this.eli.addRect(new RectF(0.0f, 0.0f, width * this.MGA, height), Path.Direction.CCW);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.Os * 5, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Os, 1073741824));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Os <= 0) {
            return;
        }
        int save = canvas.save();
        for (int i = 0; i < 5; i++) {
            this.aGH.draw(canvas);
            canvas.translate(this.Os, 0.0f);
        }
        canvas.restoreToCount(save);
        canvas.clipPath(this.eli);
        for (int i2 = 0; i2 < 5; i2++) {
            this.ui.draw(canvas);
            canvas.translate(this.Os, 0.0f);
        }
    }
}
