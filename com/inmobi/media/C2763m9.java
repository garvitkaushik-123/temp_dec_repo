package com.inmobi.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.m9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2763m9 extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public final String f2640a;
    public C2747l9 b;
    public ImageView c;
    public ProgressBar d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2763m9(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2640a = "m9";
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        setVideoView(new C2747l9(context2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(getVideoView(), layoutParams);
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setVisibility(8);
        setPosterImage(imageView);
        addView(getPosterImage(), layoutParams);
        ProgressBar progressBar = new ProgressBar(getContext());
        progressBar.setVisibility(8);
        setProgressBar(progressBar);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(getProgressBar(), layoutParams2);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        C2631e9 c2631e9 = new C2631e9(context3, null, 0);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.addRule(13);
        getVideoView().setMediaController(c2631e9);
        addView(c2631e9, layoutParams3);
    }

    public final ImageView getPosterImage() {
        ImageView imageView = this.c;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("posterImage");
        return null;
    }

    public final ProgressBar getProgressBar() {
        ProgressBar progressBar = this.d;
        if (progressBar != null) {
            return progressBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        return null;
    }

    public final C2747l9 getVideoView() {
        C2747l9 c2747l9 = this.b;
        if (c2747l9 != null) {
            return c2747l9;
        }
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
        return null;
    }

    public final void setPosterImage(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.c = imageView;
    }

    public final void setProgressBar(ProgressBar progressBar) {
        Intrinsics.checkNotNullParameter(progressBar, "<set-?>");
        this.d = progressBar;
    }

    public final void setVideoView(C2747l9 c2747l9) {
        Intrinsics.checkNotNullParameter(c2747l9, "<set-?>");
        this.b = c2747l9;
    }

    public final void setPosterImage(Bitmap bitmap) {
        getPosterImage().setImageBitmap(bitmap);
    }
}
