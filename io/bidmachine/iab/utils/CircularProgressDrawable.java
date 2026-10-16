package io.bidmachine.iab.utils;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes7.dex */
public class CircularProgressDrawable extends Drawable implements Animatable {
    private static final Interpolator g = new LinearInterpolator();
    private static final Interpolator h = new a();
    private static final int[] i = {-16777216};

    /* renamed from: a, reason: collision with root package name */
    private final Resources f6843a;
    final d b;
    private float c;
    private Animator d;
    private float e;
    private boolean f;

    class a implements Interpolator {

        /* renamed from: a, reason: collision with root package name */
        private final float[] f6844a = {0.0f, 1.0E-4f, 2.0E-4f, 5.0E-4f, 9.0E-4f, 0.0014f, 0.002f, 0.0027f, 0.0036f, 0.0046f, 0.0058f, 0.0071f, 0.0085f, 0.0101f, 0.0118f, 0.0137f, 0.0158f, 0.018f, 0.0205f, 0.0231f, 0.0259f, 0.0289f, 0.0321f, 0.0355f, 0.0391f, 0.043f, 0.0471f, 0.0514f, 0.056f, 0.0608f, 0.066f, 0.0714f, 0.0771f, 0.083f, 0.0893f, 0.0959f, 0.1029f, 0.1101f, 0.1177f, 0.1257f, 0.1339f, 0.1426f, 0.1516f, 0.161f, 0.1707f, 0.1808f, 0.1913f, 0.2021f, 0.2133f, 0.2248f, 0.2366f, 0.2487f, 0.2611f, 0.2738f, 0.2867f, 0.2998f, 0.3131f, 0.3265f, 0.34f, 0.3536f, 0.3673f, 0.381f, 0.3946f, 0.4082f, 0.4217f, 0.4352f, 0.4485f, 0.4616f, 0.4746f, 0.4874f, 0.5f, 0.5124f, 0.5246f, 0.5365f, 0.5482f, 0.5597f, 0.571f, 0.582f, 0.5928f, 0.6033f, 0.6136f, 0.6237f, 0.6335f, 0.6431f, 0.6525f, 0.6616f, 0.6706f, 0.6793f, 0.6878f, 0.6961f, 0.7043f, 0.7122f, 0.7199f, 0.7275f, 0.7349f, 0.7421f, 0.7491f, 0.7559f, 0.7626f, 0.7692f, 0.7756f, 0.7818f, 0.7879f, 0.7938f, 0.7996f, 0.8053f, 0.8108f, 0.8162f, 0.8215f, 0.8266f, 0.8317f, 0.8366f, 0.8414f, 0.8461f, 0.8507f, 0.8551f, 0.8595f, 0.8638f, 0.8679f, 0.872f, 0.876f, 0.8798f, 0.8836f, 0.8873f, 0.8909f, 0.8945f, 0.8979f, 0.9013f, 0.9046f, 0.9078f, 0.9109f, 0.9139f, 0.9169f, 0.9198f, 0.9227f, 0.9254f, 0.9281f, 0.9307f, 0.9333f, 0.9358f, 0.9382f, 0.9406f, 0.9429f, 0.9452f, 0.9474f, 0.9495f, 0.9516f, 0.9536f, 0.9556f, 0.9575f, 0.9594f, 0.9612f, 0.9629f, 0.9646f, 0.9663f, 0.9679f, 0.9695f, 0.971f, 0.9725f, 0.9739f, 0.9753f, 0.9766f, 0.9779f, 0.9791f, 0.9803f, 0.9815f, 0.9826f, 0.9837f, 0.9848f, 0.9858f, 0.9867f, 0.9877f, 0.9885f, 0.9894f, 0.9902f, 0.991f, 0.9917f, 0.9924f, 0.9931f, 0.9937f, 0.9944f, 0.9949f, 0.9955f, 0.996f, 0.9964f, 0.9969f, 0.9973f, 0.9977f, 0.998f, 0.9984f, 0.9986f, 0.9989f, 0.9991f, 0.9993f, 0.9995f, 0.9997f, 0.9998f, 0.9999f, 0.9999f, 1.0f, 1.0f};
        private final float b = 1.0f / 200;

        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float input) {
            if (input >= 1.0f) {
                return 1.0f;
            }
            if (input <= 0.0f) {
                return 0.0f;
            }
            float[] fArr = this.f6844a;
            int min = Math.min((int) ((fArr.length - 1) * input), fArr.length - 2);
            float f = this.b;
            float f2 = (input - (min * f)) / f;
            float[] fArr2 = this.f6844a;
            float f3 = fArr2[min];
            return f3 + (f2 * (fArr2[min + 1] - f3));
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f6845a;

        b(final d val$ring) {
            this.f6845a = val$ring;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            float floatValue = ((Float) animation.getAnimatedValue()).floatValue();
            CircularProgressDrawable.this.b(floatValue, this.f6845a);
            CircularProgressDrawable.this.a(floatValue, this.f6845a, false);
            CircularProgressDrawable.this.invalidateSelf();
        }
    }

    class c implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f6846a;

        c(final d val$ring) {
            this.f6846a = val$ring;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            CircularProgressDrawable.this.a(1.0f, this.f6846a, true);
            this.f6846a.m();
            this.f6846a.k();
            if (!CircularProgressDrawable.this.f) {
                CircularProgressDrawable.this.e += 1.0f;
            } else {
                CircularProgressDrawable.this.f = false;
                animator.cancel();
                animator.setDuration(1332L);
                animator.start();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            CircularProgressDrawable.this.e = 0.0f;
        }
    }

    static class d {
        final Paint b;
        final Paint c;
        final Paint d;
        final Paint e;
        int[] j;
        int k;
        float l;
        float m;
        float n;
        float o;
        int q;
        float f = 0.0f;
        float g = 0.0f;
        float h = 0.0f;
        float i = 5.0f;
        int p = 255;

        /* renamed from: a, reason: collision with root package name */
        final RectF f6847a = new RectF();

        d() {
            Paint paint = new Paint();
            this.b = paint;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.c = paint2;
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.d = paint3;
            paint3.setColor(0);
            Paint paint4 = new Paint();
            this.e = paint4;
            paint4.setColor(0);
        }

        void a(Paint.Cap strokeCap) {
            this.b.setStrokeCap(strokeCap);
        }

        void b(int color) {
            this.d.setColor(color);
        }

        void c(int color) {
            this.q = color;
        }

        void d(int index) {
            this.k = index;
            this.q = this.j[index];
        }

        int e() {
            return (this.k + 1) % this.j.length;
        }

        float f() {
            return this.f;
        }

        int g() {
            return this.j[this.k];
        }

        float h() {
            return this.m;
        }

        float i() {
            return this.n;
        }

        float j() {
            return this.l;
        }

        void k() {
            d(e());
        }

        void l() {
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 0.0f;
            d(0.0f);
            b(0.0f);
            c(0.0f);
        }

        void m() {
            this.l = this.f;
            this.m = this.g;
            this.n = this.h;
        }

        void a(Canvas c, Rect bounds) {
            RectF rectF = this.f6847a;
            float f = this.o;
            float f2 = (this.i / 2.0f) + f;
            if (f <= 0.0f) {
                f2 = (Math.min(bounds.width(), bounds.height()) / 2.0f) - (this.i / 2.0f);
            }
            rectF.set(bounds.centerX() - f2, bounds.centerY() - f2, bounds.centerX() + f2, bounds.centerY() + f2);
            float f3 = this.f;
            float f4 = this.h;
            float f5 = (f3 + f4) * 360.0f;
            float f6 = ((this.g + f4) * 360.0f) - f5;
            this.b.setColor(this.q);
            this.b.setAlpha(this.p);
            float f7 = this.i / 2.0f;
            rectF.inset(f7, f7);
            c.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.d);
            float f8 = -f7;
            rectF.inset(f8, f8);
            c.drawArc(rectF, f5, f6, false, this.b);
        }

        int b() {
            return this.d.getColor();
        }

        float c() {
            return this.g;
        }

        void e(float strokeWidth) {
            this.i = strokeWidth;
            this.b.setStrokeWidth(strokeWidth);
        }

        void b(float endTrim) {
            this.g = endTrim;
        }

        void c(float rotation) {
            this.h = rotation;
        }

        int d() {
            return this.j[e()];
        }

        void d(float startTrim) {
            this.f = startTrim;
        }

        void a(int[] colors) {
            this.j = colors;
            d(0);
        }

        void a(ColorFilter filter) {
            this.b.setColorFilter(filter);
        }

        void a(int alpha) {
            this.p = alpha;
        }

        int a() {
            return this.p;
        }

        void a(float centerRadius) {
            this.o = centerRadius;
        }
    }

    public CircularProgressDrawable(Context context) {
        this.f6843a = context.getResources();
        d dVar = new d();
        this.b = dVar;
        dVar.a(i);
        setStrokeWidth(2.5f);
        a();
    }

    private int a(float fraction, int startValue, int endValue) {
        return ((((startValue >> 24) & 255) + ((int) ((((endValue >> 24) & 255) - r0) * fraction))) << 24) | ((((startValue >> 16) & 255) + ((int) ((((endValue >> 16) & 255) - r1) * fraction))) << 16) | ((((startValue >> 8) & 255) + ((int) ((((endValue >> 8) & 255) - r2) * fraction))) << 8) | ((startValue & 255) + ((int) (fraction * ((endValue & 255) - r8))));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.c, bounds.exactCenterX(), bounds.exactCenterY());
        this.b.a(canvas, bounds);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.b.a();
    }

    public int getBackgroundColor() {
        return this.b.b();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float getStrokeWidth() {
        return this.b.i;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.d.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.b.a(alpha);
        invalidateSelf();
    }

    public void setBackgroundColor(int color) {
        this.b.b(color);
        invalidateSelf();
    }

    public void setCenterRadius(float centerRadius) {
        this.b.a(centerRadius);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.a(colorFilter);
        invalidateSelf();
    }

    public void setColorSchemeColors(int... colors) {
        this.b.a(colors);
        this.b.d(0);
        invalidateSelf();
    }

    public void setStrokeCap(Paint.Cap strokeCap) {
        this.b.a(strokeCap);
        invalidateSelf();
    }

    public void setStrokeWidth(float strokeWidth) {
        this.b.e(strokeWidth);
        invalidateSelf();
    }

    public void setStyle(int size) {
        if (size == 0) {
            a(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            a(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.d.cancel();
        this.b.m();
        if (this.b.c() != this.b.f()) {
            this.f = true;
            this.d.setDuration(666L);
            this.d.start();
        } else {
            this.b.d(0);
            this.b.l();
            this.d.setDuration(1332L);
            this.d.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.d.cancel();
        a(0.0f);
        this.b.d(0);
        this.b.l();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float interpolatedTime, d ring) {
        if (interpolatedTime > 0.75f) {
            ring.c(a((interpolatedTime - 0.75f) / 0.25f, ring.g(), ring.d()));
        } else {
            ring.c(ring.g());
        }
    }

    private void a(float centerRadius, float strokeWidth, float arrowWidth, float arrowHeight) {
        d dVar = this.b;
        float f = this.f6843a.getDisplayMetrics().density;
        dVar.e(strokeWidth * f);
        dVar.a(centerRadius * f);
        dVar.d(0);
    }

    private void a(float rotation) {
        this.c = rotation;
    }

    private void a(float interpolatedTime, d ring) {
        b(interpolatedTime, ring);
        float floor = (float) (Math.floor(ring.i() / 0.8f) + 1.0d);
        ring.d(ring.j() + (((ring.h() - 0.01f) - ring.j()) * interpolatedTime));
        ring.b(ring.h());
        ring.c(ring.i() + ((floor - ring.i()) * interpolatedTime));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float interpolatedTime, d ring, boolean lastFrame) {
        float interpolation;
        float f;
        if (this.f) {
            a(interpolatedTime, ring);
            return;
        }
        if (interpolatedTime != 1.0f || lastFrame) {
            float i2 = ring.i();
            if (interpolatedTime < 0.5f) {
                interpolation = ring.j();
                f = (h.getInterpolation(interpolatedTime / 0.5f) * 0.79f) + interpolation + 0.01f;
            } else {
                float j = ring.j() + 0.79f;
                interpolation = j - (((1.0f - h.getInterpolation((interpolatedTime - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f = j;
            }
            float f2 = i2 + (0.20999998f * interpolatedTime);
            float f3 = (interpolatedTime + this.e) * 216.0f;
            ring.d(interpolation);
            ring.b(f);
            ring.c(f2);
            a(f3);
        }
    }

    private void a() {
        d dVar = this.b;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b(dVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(g);
        ofFloat.addListener(new c(dVar));
        this.d = ofFloat;
    }
}
