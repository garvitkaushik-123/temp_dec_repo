package com.unity3d.player.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;

/* loaded from: classes7.dex */
public final class K extends View {

    /* renamed from: a, reason: collision with root package name */
    public final int f6517a;
    public final int b;
    public final int c;
    public Bitmap d;
    public Bitmap e;

    public K(Context context, int i) {
        super(context);
        this.c = -16777216;
        this.f6517a = i;
        int identifier = getResources().getIdentifier("unity_static_splash", "drawable", getContext().getPackageName());
        this.b = identifier;
        if (identifier != 0) {
            forceLayout();
        }
        int identifier2 = getResources().getIdentifier("staticSplashScreenBackgroundColor", "color", getContext().getPackageName());
        if (identifier2 != 0) {
            this.c = getResources().getColor(identifier2, getContext().getTheme());
        }
        setBackgroundColor(this.c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0069, code lost:
    
        if (r12 < r10) goto L31;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.b == 0) {
            return;
        }
        if (this.d == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            this.d = BitmapFactory.decodeResource(getResources(), this.b, options);
        }
        int width = this.d.getWidth();
        int height = this.d.getHeight();
        int width2 = getWidth();
        int height2 = getHeight();
        if (width2 == 0 || height2 == 0) {
            return;
        }
        float f = width / height;
        float f2 = width2;
        float f3 = height2;
        boolean z2 = f2 / f3 <= f;
        int a2 = AbstractC3503k.a(this.f6517a);
        if (a2 != 0) {
            if (a2 == 1 || a2 == 2) {
                if ((this.f6517a == 3) ^ z2) {
                    height = (int) (f2 / f);
                    width = width2;
                }
                width = (int) (f3 * f);
                height = height2;
            }
        } else if (width2 < width) {
            height = (int) (f2 / f);
            width = width2;
        }
        Bitmap bitmap = this.e;
        if (bitmap != null) {
            if (bitmap.getWidth() == width && this.e.getHeight() == height) {
                return;
            }
            Bitmap bitmap2 = this.e;
            if (bitmap2 != this.d) {
                bitmap2.recycle();
                this.e = null;
            }
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(this.d, width, height, true);
        this.e = createScaledBitmap;
        createScaledBitmap.setDensity(getResources().getDisplayMetrics().densityDpi);
        ColorDrawable colorDrawable = new ColorDrawable(this.c);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), this.e);
        bitmapDrawable.setGravity(17);
        setBackground(new LayerDrawable(new Drawable[]{colorDrawable, bitmapDrawable}));
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.d;
        if (bitmap != null) {
            bitmap.recycle();
            this.d = null;
        }
        Bitmap bitmap2 = this.e;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.e = null;
        }
    }
}
