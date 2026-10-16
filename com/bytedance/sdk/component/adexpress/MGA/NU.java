package com.bytedance.sdk.component.adexpress.MGA;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class NU extends ImageView {
    private long DbA;
    private float FC;
    private boolean MGA;
    private boolean NU;
    private int Os;
    private int aAs;
    private AnimatedImageDrawable aGH;
    private int du;
    private Movie eli;
    private float kb;
    private volatile boolean nlS;
    private boolean nn;
    private boolean ui;
    private float wC;

    public NU(Context context) {
        super(context);
        this.ui = true;
        this.MGA = false;
        this.NU = true;
        this.nn = true;
        eli();
    }

    void eli() {
        if (this.ui) {
            return;
        }
        setLayerType(1, null);
    }

    private void setDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        setImageDrawable(drawable);
        if (drawable instanceof AnimatedImageDrawable) {
            AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) drawable;
            this.aGH = animatedImageDrawable;
            if (!this.nlS) {
                animatedImageDrawable.start();
            }
            if (!this.nn) {
                animatedImageDrawable.setRepeatCount(0);
            }
        }
        DbA();
    }

    public void setRepeatConfig(boolean z) {
        this.nn = z;
        if (z) {
            return;
        }
        try {
            AnimatedImageDrawable animatedImageDrawable = this.aGH;
            if (animatedImageDrawable != null) {
                animatedImageDrawable.setRepeatCount(0);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i, i2);
        if (this.ui || (movie = this.eli) == null) {
            return;
        }
        int width = movie.width();
        int height = this.eli.height();
        float max = 1.0f / Math.max((View.MeasureSpec.getMode(i) == 0 || width <= (size2 = View.MeasureSpec.getSize(i))) ? 1.0f : width / size2, (View.MeasureSpec.getMode(i2) == 0 || height <= (size = View.MeasureSpec.getSize(i2))) ? 1.0f : height / size);
        this.FC = max;
        int i3 = (int) (width * max);
        this.aAs = i3;
        int i4 = (int) (height * max);
        this.du = i4;
        setMeasuredDimension(i3, i4);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.eli != null && !this.ui) {
            this.kb = (getWidth() - this.aAs) / 2.0f;
            this.wC = (getHeight() - this.du) / 2.0f;
        }
        this.NU = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.eli != null && !this.ui) {
            try {
                if (!this.nlS) {
                    Os();
                    eli(canvas);
                    DbA();
                    return;
                }
                eli(canvas);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        super.onDraw(canvas);
    }

    private void DbA() {
        if (this.eli == null || this.ui || !this.NU) {
            return;
        }
        postInvalidateOnAnimation();
    }

    private void Os() {
        if (this.eli == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.DbA == 0) {
            this.DbA = uptimeMillis;
        }
        int duration = this.eli.duration();
        if (duration == 0) {
            duration = 1000;
        }
        if (!this.nn && Math.abs(duration - this.Os) < 60) {
            this.Os = duration;
            this.nlS = true;
        } else {
            this.Os = (int) ((uptimeMillis - this.DbA) % duration);
        }
    }

    private void eli(Canvas canvas) {
        Movie movie = this.eli;
        if (movie == null) {
            return;
        }
        movie.setTime(this.Os);
        float f = this.FC;
        if (f == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.eli.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f, f);
            Movie movie2 = this.eli;
            float f2 = this.kb;
            float f3 = this.FC;
            movie2.draw(canvas, f2 / f3, this.wC / f3);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (this.eli != null) {
            this.NU = i == 1;
            DbA();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.eli != null) {
            this.NU = i == 0;
            DbA();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.eli != null) {
            this.NU = i == 0;
            DbA();
        }
    }
}
