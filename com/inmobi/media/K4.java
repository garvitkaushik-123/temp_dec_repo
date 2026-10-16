package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import com.google.firebase.ktx.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class K4 extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    public I4 f2335a;
    public float b;
    public boolean c;
    public String d;

    public K4(Context context) {
        super(context, null);
        this.b = 1.0f;
        this.c = true;
        this.d = BuildConfig.VERSION_NAME;
        setLayerType(1, null);
    }

    private final int getDensity() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (!(getContext() instanceof Activity)) {
            return 240;
        }
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }

    private static /* synthetic */ void getMContentMode$annotations() {
    }

    private final float getScale() {
        float density = getContext().getResources().getDisplayMetrics().densityDpi / getDensity();
        this.b = density;
        if (density < 0.1f) {
            this.b = 0.1f;
        }
        if (this.b > 5.0f) {
            this.b = 5.0f;
        }
        return this.b;
    }

    public final void a(Canvas canvas) {
        float f;
        float f2;
        float f3;
        canvas.save();
        float f4 = this.b;
        canvas.scale(f4, f4);
        float width = getWidth();
        float height = getHeight();
        float c = (this.f2335a != null ? r2.c() : 0) * this.b;
        float a2 = (this.f2335a != null ? r4.a() : 0) * this.b;
        String str = this.d;
        if (Intrinsics.areEqual(str, "aspectFill")) {
            f = Math.max(height / a2, width / c);
            float f5 = width - (c * f);
            float f6 = 2;
            float f7 = this.b * f;
            f2 = (f5 / f6) / f7;
            f3 = ((height - (a2 * f)) / f6) / f7;
            canvas.scale(f, f);
        } else if (Intrinsics.areEqual(str, "aspectFit")) {
            f = Math.min(height / a2, width / c);
            float f8 = width - (c * f);
            float f9 = 2;
            float f10 = this.b * f;
            f2 = (f8 / f9) / f10;
            f3 = ((height - (a2 * f)) / f9) / f10;
            canvas.scale(f, f);
        } else {
            f = height / a2;
            canvas.scale(width / c, f);
            f2 = 0.0f;
            f3 = 0.0f;
        }
        float[] fArr = {f2, f3, f};
        I4 i4 = this.f2335a;
        if (i4 != null) {
            i4.a(canvas, fArr[0], fArr[1]);
        }
        canvas.restore();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        I4 i4 = this.f2335a;
        if (i4 != null) {
            if (!i4.b()) {
                a(canvas);
                return;
            }
            i4.d();
            a(canvas);
            if (this.c) {
                postInvalidateOnAnimation();
            }
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.c = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        this.b = getScale();
        Drawable drawable = getDrawable();
        I4 i4 = this.f2335a;
        if (drawable != null) {
            i3 = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (i3 <= 0) {
                i3 = 1;
            }
            if (intrinsicHeight > 0) {
                r2 = intrinsicHeight;
            }
        } else if (i4 != null) {
            int c = i4.c();
            int a2 = i4.a();
            if (c <= 0) {
                c = 1;
            }
            r2 = a2 > 0 ? a2 : 1;
            i3 = c;
        } else {
            r2 = 0;
            i3 = 0;
        }
        setMeasuredDimension(View.resolveSize(Math.max(getPaddingLeft() + getPaddingRight() + i3, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(getPaddingTop() + getPaddingBottom() + r2, getSuggestedMinimumHeight()), i2));
    }

    @Override // android.view.View
    public final void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        boolean z = i == 1;
        this.c = z;
        if (z) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View changedView, int i) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, i);
        boolean z = i == 0;
        this.c = z;
        if (z) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        boolean z = i == 0;
        this.c = z;
        if (z) {
            postInvalidateOnAnimation();
        }
    }

    public final void setContentMode(String contentMode) {
        Intrinsics.checkNotNullParameter(contentMode, "contentMode");
        this.d = contentMode;
    }

    public final void setGifImpl(I4 i4) {
        this.f2335a = i4;
        if (i4 != null) {
            i4.a(this);
            i4.start();
        }
        requestLayout();
    }

    public final void setPaused(boolean z) {
        I4 i4 = this.f2335a;
        if (i4 != null) {
            i4.a(z);
        }
    }
}
