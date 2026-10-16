package com.bytedance.adsdk.ugeno.FC.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.adsdk.ugeno.aGH;
import com.bytedance.adsdk.ugeno.kb.wC;

/* loaded from: classes3.dex */
public class eli extends FrameLayout {
    private float DbA;
    private LinearLayout MGA;
    private double Os;
    private float aGH;
    private float eli;
    private Context kb;
    private LinearLayout ui;
    private aGH wC;

    public eli(Context context) {
        super(context);
        this.kb = context;
        this.ui = new LinearLayout(context);
        this.MGA = new LinearLayout(context);
        this.ui.setOrientation(0);
        this.ui.setGravity(GravityCompat.START);
        this.MGA.setOrientation(0);
        this.MGA.setGravity(GravityCompat.START);
    }

    public void eli(double d, int i, int i2, float f, int i3) {
        removeAllViews();
        this.ui.removeAllViews();
        this.MGA.removeAllViews();
        this.eli = (int) wC.eli(this.kb, f);
        this.DbA = (int) wC.eli(this.kb, f);
        this.Os = d;
        this.aGH = i3;
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setImageResource(com.bytedance.adsdk.ugeno.kb.aGH.DbA(this.kb, "tt_ugen_rating_star"));
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            this.MGA.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageResource(com.bytedance.adsdk.ugeno.kb.aGH.DbA(this.kb, "tt_ugen_rating_star"));
            starImageView2.setColorFilter(i2);
            this.ui.addView(starImageView2);
        }
        addView(this.ui);
        addView(this.MGA);
        requestLayout();
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.eli, (int) this.DbA);
        layoutParams.leftMargin = (int) this.aGH;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = (int) this.aGH;
        layoutParams.bottomMargin = 1;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        aGH agh = this.wC;
        if (agh != null) {
            agh.eli(i, i2);
        }
        super.onMeasure(i, i2);
        this.ui.measure(i, i2);
        double floor = Math.floor(this.Os);
        this.MGA.measure(View.MeasureSpec.makeMeasureSpec((int) (((r0 + r0 + r2) * floor) + this.aGH + ((this.Os - floor) * this.eli)), 1073741824), View.MeasureSpec.makeMeasureSpec(this.ui.getMeasuredHeight(), 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        aGH agh = this.wC;
        if (agh != null) {
            agh.eli(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aGH agh = this.wC;
        if (agh != null) {
            agh.kb();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aGH agh = this.wC;
        if (agh != null) {
            agh.wC();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        aGH agh = this.wC;
        if (agh != null) {
            agh.DbA(i, i2, i3, i4);
        }
    }

    public void eli(aGH agh) {
        this.wC = agh;
    }
}
