package com.bytedance.sdk.component.adexpress.MGA;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;

/* loaded from: classes3.dex */
public class Vy extends FrameLayout {
    private static final int FC = (com.bytedance.sdk.component.adexpress.dynamic.ui.du.DbA("", 0.0f, true)[1] / 2) + 1;
    private static final int aAs = (com.bytedance.sdk.component.adexpress.dynamic.ui.du.DbA("", 0.0f, true)[1] / 2) + 3;
    LinearLayout DbA;
    private Drawable MGA;
    private float Os;
    private float aGH;
    LinearLayout eli;
    private double kb;
    private Drawable ui;
    private float wC;

    public Vy(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eli = new LinearLayout(getContext());
        this.DbA = new LinearLayout(getContext());
        this.eli.setOrientation(0);
        this.eli.setGravity(GravityCompat.START);
        this.DbA.setOrientation(0);
        this.DbA.setGravity(GravityCompat.START);
        this.ui = com.bytedance.sdk.component.utils.ev.Os(context, "tt_star_thick");
        this.MGA = com.bytedance.sdk.component.utils.ev.Os(context, "tt_star");
    }

    public Drawable getStarEmptyDrawable() {
        return this.ui;
    }

    public Drawable getStarFillDrawable() {
        return this.MGA;
    }

    public void eli(double d, int i, int i2, int i3) {
        float f = i2;
        this.Os = (int) com.bytedance.sdk.component.adexpress.aGH.kb.Os(getContext(), f);
        this.aGH = (int) com.bytedance.sdk.component.adexpress.aGH.kb.Os(getContext(), f);
        this.kb = d;
        this.wC = i3;
        removeAllViews();
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.DbA.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.eli.addView(starImageView2);
        }
        addView(this.eli);
        addView(this.DbA);
        requestLayout();
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.Os, (int) this.aGH));
        imageView.setPadding(1, FC, 1, aAs);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.eli.measure(i, i2);
        double d = this.kb;
        float f = this.Os;
        this.DbA.measure(View.MeasureSpec.makeMeasureSpec((int) ((((int) d) * f) + 1.0f + ((f - 2.0f) * (d - ((int) d)))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.eli.getMeasuredHeight(), 1073741824));
        if (this.wC > 0.0f) {
            this.eli.setPadding(0, ((int) (r7.getMeasuredHeight() - this.wC)) / 2, 0, 0);
            this.DbA.setPadding(0, ((int) (this.eli.getMeasuredHeight() - this.wC)) / 2, 0, 0);
        }
    }
}
