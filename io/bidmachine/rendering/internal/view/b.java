package io.bidmachine.rendering.internal.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.view.View;
import io.bidmachine.rendering.internal.i;
import io.bidmachine.rendering.internal.n;
import io.bidmachine.rendering.model.AppearanceParams;
import io.bidmachine.rendering.model.FontStyleType;
import io.bidmachine.rendering.utils.UiUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes8.dex */
public class b extends View implements io.bidmachine.rendering.internal.e {

    /* renamed from: a, reason: collision with root package name */
    final Paint f7102a;
    final Paint b;
    final Paint c;
    private final RectF d;
    private final RectF e;
    private final c f;
    private final AtomicBoolean g;
    private d h;
    private Runnable i;
    private float j;
    private float k;
    private float l;
    private float m;
    private int n;
    private byte o;
    private boolean p;

    /* renamed from: io.bidmachine.rendering.internal.view.b$b, reason: collision with other inner class name */
    private class C0630b implements n {
        private C0630b() {
        }

        @Override // io.bidmachine.util.SafeRunnable
        public void onRun() {
            boolean z = !b.this.c() || b.this.isShown();
            if (z) {
                b.this.f.j();
            } else {
                b.this.f.i();
            }
            long b = b.this.f.b();
            long c = b.this.f.c();
            if (z) {
                b.this.a((c * 100.0f) / b, (int) Math.ceil((b - c) / 1000.0d));
            }
            if (b.this.f.e()) {
                b.this.d();
            } else {
                UiUtils.onUiThread(this, 16L);
            }
        }
    }

    public interface d {
        void a();
    }

    public b(Context context) {
        super(context);
        this.d = new RectF();
        this.e = new RectF();
        this.f = new c();
        this.g = new AtomicBoolean(false);
        this.m = 100.0f;
        this.o = (byte) -1;
        this.p = false;
        Paint paint = new Paint(1);
        this.f7102a = paint;
        paint.setColor(i.CONTROLS_BACKGROUND_COLOR);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        Paint paint2 = new Paint(1);
        this.b = paint2;
        int i = i.MAIN_ASSETS_COLOR;
        paint2.setColor(i);
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint(1);
        this.c = paint3;
        paint3.setColor(i);
        paint3.setStyle(style);
        paint3.setAntiAlias(true);
        paint3.setTextAlign(Paint.Align.CENTER);
        paint3.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        d dVar;
        if (this.g.compareAndSet(false, true) && (dVar = this.h) != null) {
            dVar.a();
        }
    }

    public boolean c() {
        return this.p;
    }

    public void e() {
        g();
        if (this.g.get()) {
            return;
        }
        this.f.h();
        C0630b c0630b = new C0630b();
        this.i = c0630b;
        UiUtils.onUiThread(c0630b, 16L);
    }

    public void f() {
        this.g.set(false);
        this.f.g();
        e();
    }

    public void g() {
        this.f.f();
        Runnable runnable = this.i;
        if (runnable == null) {
            return;
        }
        UiUtils.cancelOnUiThread(runnable);
        this.i = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() == 0 || getHeight() == 0 || this.n == 0) {
            return;
        }
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldW, int oldH) {
        super.onSizeChanged(w, h, oldW, oldH);
        a();
    }

    public void setClockwise(boolean isClockwise) {
        if (isClockwise) {
            this.o = (byte) -1;
        } else {
            this.o = (byte) 1;
        }
    }

    public void setDuration(long duration) {
        this.f.a(duration);
    }

    public void setListener(d listener) {
        this.h = listener;
    }

    public void setOnlyVisibleWork(boolean onlyVisibleWork) {
        this.p = onlyVisibleWork;
    }

    static class c {

        /* renamed from: a, reason: collision with root package name */
        private boolean f7104a = false;
        private long b = 0;
        private long c = 0;
        private long d = 0;

        c() {
        }

        public void a(long duration) {
            this.b = duration;
            g();
        }

        public long b() {
            return this.b;
        }

        public long c() {
            return this.c;
        }

        public boolean d() {
            return this.f7104a;
        }

        public boolean e() {
            return this.c >= this.b;
        }

        public void f() {
            this.f7104a = false;
        }

        public void g() {
            this.c = 0L;
            this.d = a();
        }

        public void h() {
            this.f7104a = true;
            this.d = a();
        }

        public void i() {
            this.d = a();
        }

        public void j() {
            if (d()) {
                long a2 = a();
                this.c = Math.min(this.b, this.c + (a2 - this.d));
                this.d = a2;
            }
        }

        long a() {
            return SystemClock.elapsedRealtime();
        }
    }

    private void a(Context context) {
        setLayerType(1, null);
        this.j = UiUtils.dpToPx(context, 54.0f);
        this.k = UiUtils.dpToPx(context, 54.0f);
        float dpToPx = UiUtils.dpToPx(context, 3.0f);
        this.l = dpToPx;
        this.b.setStrokeWidth(dpToPx);
        a();
    }

    public void b() {
        g();
        this.h = null;
    }

    private void b(Canvas canvas) {
        canvas.drawText(String.valueOf(this.n), this.j, this.k - ((this.c.descent() + this.c.ascent()) / 2.0f), this.c);
    }

    @Override // io.bidmachine.rendering.internal.e
    public void a(AppearanceParams appearanceParams) {
        FontStyleType fontStyleType = appearanceParams.getFontStyleType();
        if (fontStyleType != null) {
            this.c.setTypeface(Typeface.create(Typeface.DEFAULT, fontStyleType.getTypeface()));
        }
        Integer fillColor = appearanceParams.getFillColor();
        if (fillColor != null) {
            this.f7102a.setColor(fillColor.intValue());
        }
        Integer strokeWidthPx = appearanceParams.getStrokeWidthPx(getContext());
        if (strokeWidthPx != null) {
            float intValue = strokeWidthPx.intValue();
            this.l = intValue;
            this.b.setStrokeWidth(intValue);
        }
        Integer strokeColor = appearanceParams.getStrokeColor();
        if (strokeColor != null) {
            this.b.setColor(strokeColor.intValue());
        }
        a();
    }

    public void a(float percent, int remainingTimeSec) {
        if (percent >= 0.0f || percent <= 100.0f) {
            this.m = percent;
        }
        this.n = remainingTimeSec;
        postInvalidate();
    }

    void a() {
        float width = (getWidth() - r0) / 2.0f;
        float height = (getHeight() - r0) / 2.0f;
        float min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        this.d.set(width, height, width + min, min + height);
        this.j = this.d.centerX();
        this.k = this.d.centerY();
        float f = this.l / 2.0f;
        RectF rectF = this.e;
        RectF rectF2 = this.d;
        rectF.set(rectF2.left + f, rectF2.top + f, rectF2.right - f, rectF2.bottom - f);
        this.c.setTextSize(a(this.d, true));
    }

    float a(RectF rect, boolean withOutline) {
        float width = rect.width();
        if (withOutline) {
            width -= this.l * 2.0f;
        }
        return width * 0.70710677f * 0.9f;
    }

    private void a(Canvas canvas) {
        float f = this.o * (360.0f - ((this.m * 360.0f) * 0.01f));
        canvas.drawArc(this.d, 0.0f, 360.0f, false, this.f7102a);
        canvas.drawArc(this.e, 270.0f, f, false, this.b);
    }
}
