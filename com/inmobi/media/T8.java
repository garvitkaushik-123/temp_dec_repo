package com.inmobi.media;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.LinearInterpolator;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class T8 extends View {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f2438a;
    public Canvas b;
    public RectF c;
    public RectF d;
    public final Rect e;
    public long f;
    public final Paint g;
    public final Paint h;
    public final Paint i;
    public final Paint j;
    public final Paint k;
    public float l;
    public long m;
    public ValueAnimator n;
    public S8 o;

    public T8(Context context) {
        super(context);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-723724);
        this.g = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setColor(-16777216);
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setAntiAlias(true);
        this.k = paint2;
        this.e = new Rect();
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setColor(-16777216);
        this.h = paint3;
        Paint paint4 = new Paint();
        paint4.setAntiAlias(true);
        paint4.setColor(0);
        paint4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.i = paint4;
        Paint paint5 = new Paint();
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setAntiAlias(true);
        paint5.setColor(-16777216);
        this.j = paint5;
    }

    public final void a() {
        S8 s8 = this.o;
        if (s8 != null) {
            C8 c8 = (C8) s8;
            C2939x8 c2939x8 = c8.f2251a.p;
            if (c2939x8 != null) {
                Q8 timerAsset = c8.b;
                Intrinsics.checkNotNullParameter(timerAsset, "timerAsset");
                if (timerAsset.j == 1) {
                    c2939x8.b.a();
                }
            }
        }
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.n = null;
    }

    public final void b() {
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.m = valueAnimator.getCurrentPlayTime();
        valueAnimator.cancel();
    }

    public final void c() {
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator == null || valueAnimator.isRunning()) {
            return;
        }
        valueAnimator.setCurrentPlayTime(this.m);
        valueAnimator.start();
    }

    public final void d() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(TimeUnit.SECONDS.toMillis(this.f));
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new R8(this));
        this.n = ofFloat;
        ofFloat.start();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Canvas canvas2;
        Canvas canvas3;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Canvas canvas4 = this.b;
        if (canvas4 != null) {
            canvas4.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int min = Math.min(width, height);
        V3 v3 = U3.f2447a;
        int b = (int) (U3.b() * ((int) (getWidth() * 7.0f * 0.007f)));
        float f = width;
        float f2 = height;
        canvas.drawCircle(f, f2, min, this.g);
        canvas.drawCircle(f, f2, min - b, this.j);
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            int currentPlayTime = (int) (this.f - (valueAnimator.getCurrentPlayTime() / 1000));
            Intrinsics.checkNotNull(valueAnimator.getAnimatedValue(), "null cannot be cast to non-null type kotlin.Float");
            if (((Float) r4).floatValue() >= 1.0d) {
                currentPlayTime = 0;
            }
            Paint paint = this.k;
            Rect rect = this.e;
            String valueOf = String.valueOf(currentPlayTime);
            paint.getTextBounds(valueOf, 0, valueOf.length(), rect);
            canvas.drawText(valueOf, getWidth() / 2, (getHeight() / 2) + (((paint.descent() - paint.ascent()) / 2) - paint.descent()), paint);
            Intrinsics.checkNotNull(valueAnimator.getAnimatedValue(), "null cannot be cast to non-null type kotlin.Float");
            if (((Float) r0).floatValue() >= 1.0d) {
                a();
            }
        }
        float f3 = this.l;
        if (f3 > 0.0f) {
            RectF rectF = this.c;
            if (rectF != null && (canvas3 = this.b) != null) {
                canvas3.drawArc(rectF, 270.0f, f3, true, this.h);
            }
            RectF rectF2 = this.d;
            if (rectF2 != null && (canvas2 = this.b) != null) {
                canvas2.drawOval(rectF2, this.i);
            }
        }
        Bitmap bitmap = this.f2438a;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i != i3 || i2 != i4) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
            createBitmap.eraseColor(0);
            this.f2438a = createBitmap;
            this.b = new Canvas(createBitmap);
        }
        super.onSizeChanged(i, i2, i3, i4);
        V3 v3 = U3.f2447a;
        float b = (int) (U3.b() * ((int) (getWidth() * 4.0f * 0.007f)));
        float b2 = (int) (U3.b() * ((int) (getWidth() * 14.0f * 0.007f)));
        float b3 = (int) (U3.b() * ((int) (getWidth() * 5.0f * 0.007f)));
        float b4 = (int) (U3.b() * ((int) (getWidth() * 1.5f * 0.007f)));
        RectF rectF = new RectF(b3, b3, getWidth() - b3, getHeight() - b3);
        this.c = rectF;
        this.d = new RectF(rectF.left + b, rectF.top + b, rectF.right - b, rectF.bottom - b);
        this.j.setStrokeWidth(b4);
        this.k.setTextSize(b2);
        invalidate();
    }

    public final void setTimerEventsListener(S8 s8) {
        this.o = s8;
    }

    public final void setTimerValue(long j) {
        this.f = j;
    }
}
