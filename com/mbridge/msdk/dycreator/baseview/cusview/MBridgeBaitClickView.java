package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.image.b;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import io.bidmachine.media3.common.C;

/* loaded from: classes6.dex */
public class MBridgeBaitClickView extends RelativeLayout {
    public static final int ANIMATION_TYPE_DOUBLE_CLICK = 4;
    public static final int ANIMATION_TYPE_FAST_SCALE = 1;
    public static final int ANIMATION_TYPE_ROTATE = 5;
    public static final int ANIMATION_TYPE_SLOW_SCALE = 2;
    public static final int ANIMATION_TYPE_SLOW_SCALE_WITH_PAUSE = 3;

    /* renamed from: a, reason: collision with root package name */
    private MBridgeDyImageView f4097a;
    private MBridgeDyImageView b;
    private TextView c;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;
    private Animation i;
    private Animation j;
    private Animation k;
    private Animation l;

    public MBridgeBaitClickView(Context context) {
        super(context);
        this.d = "";
        this.e = "";
        this.f = "Click now for details";
        this.g = 1;
        this.h = C.ENCODING_PCM_24BIT_BIG_ENDIAN;
    }

    private void d() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        this.i = scaleAnimation;
        scaleAnimation.setDuration(500L);
        this.i.setRepeatCount(-1);
        this.i.setRepeatMode(2);
        MBridgeDyImageView mBridgeDyImageView = this.f4097a;
        if (mBridgeDyImageView != null) {
            mBridgeDyImageView.startAnimation(this.i);
        }
    }

    private void e() {
        MBridgeDyImageView mBridgeDyImageView = this.b;
        if (mBridgeDyImageView != null) {
            mBridgeDyImageView.setVisibility(4);
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        this.i = scaleAnimation;
        scaleAnimation.setDuration(500L);
        this.i.setRepeatCount(1);
        this.i.setRepeatMode(2);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.5f, 0.0f, 1.5f, 1, 0.5f, 1, 0.5f);
        this.j = scaleAnimation2;
        scaleAnimation2.setDuration(1000L);
        this.j.setRepeatCount(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.k = alphaAnimation;
        alphaAnimation.setDuration(1000L);
        this.k.setRepeatCount(0);
        final AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(this.j);
        animationSet.addAnimation(this.k);
        this.j.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (MBridgeBaitClickView.this.b != null) {
                    MBridgeBaitClickView.this.b.setVisibility(4);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (MBridgeBaitClickView.this.b != null) {
                    MBridgeBaitClickView.this.b.setVisibility(0);
                }
            }
        });
        this.i.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                MBridgeBaitClickView.this.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MBridgeBaitClickView.this.f4097a != null) {
                            MBridgeBaitClickView.this.f4097a.startAnimation(MBridgeBaitClickView.this.i);
                        }
                    }
                }, 1000L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                MBridgeBaitClickView.this.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MBridgeBaitClickView.this.b != null) {
                            MBridgeBaitClickView.this.b.startAnimation(animationSet);
                        }
                    }
                }, 550L);
            }
        });
        MBridgeDyImageView mBridgeDyImageView2 = this.f4097a;
        if (mBridgeDyImageView2 != null) {
            mBridgeDyImageView2.startAnimation(this.i);
        }
    }

    private void getDefaultClickText() {
        try {
            this.f = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh") ? "点击查看详情" : "Click now for details";
        } catch (Throwable th) {
            p0.b("MBridgeAnimationClickView", th.getMessage());
        }
    }

    public void init(int i) {
        this.g = i;
        init();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearAnimation();
        Animation animation = this.i;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.j;
        if (animation2 != null) {
            animation2.cancel();
        }
        Animation animation3 = this.k;
        if (animation3 != null) {
            animation3.cancel();
        }
        Animation animation4 = this.l;
        if (animation4 != null) {
            animation4.cancel();
        }
    }

    public void startAnimation() {
        int i = this.g;
        if (i == 2) {
            this.b.setVisibility(4);
            d();
            return;
        }
        if (i == 3) {
            e();
            return;
        }
        if (i == 4) {
            this.b.setVisibility(4);
            a();
        } else if (i != 5) {
            b();
        } else {
            c();
        }
    }

    private void a() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.i = scaleAnimation;
        scaleAnimation.setDuration(200L);
        this.i.setRepeatCount(1);
        this.i.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                MBridgeBaitClickView.this.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MBridgeBaitClickView.this.f4097a != null) {
                            MBridgeBaitClickView.this.f4097a.startAnimation(MBridgeBaitClickView.this.i);
                        }
                    }
                }, 1000L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        MBridgeDyImageView mBridgeDyImageView = this.f4097a;
        if (mBridgeDyImageView != null) {
            mBridgeDyImageView.startAnimation(this.i);
        }
    }

    private void b() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        this.i = scaleAnimation;
        scaleAnimation.setDuration(200L);
        this.i.setRepeatCount(-1);
        this.i.setRepeatMode(2);
        MBridgeDyImageView mBridgeDyImageView = this.f4097a;
        if (mBridgeDyImageView != null) {
            mBridgeDyImageView.startAnimation(this.i);
        }
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        this.j = scaleAnimation2;
        scaleAnimation2.setDuration(400L);
        this.j.setRepeatCount(-1);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.3f);
        this.k = alphaAnimation;
        alphaAnimation.setDuration(400L);
        this.k.setRepeatCount(-1);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(this.j);
        animationSet.addAnimation(this.k);
        MBridgeDyImageView mBridgeDyImageView2 = this.b;
        if (mBridgeDyImageView2 != null) {
            mBridgeDyImageView2.startAnimation(animationSet);
        }
    }

    private void c() {
        RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 30.0f, 1, 0.5f, 1, 0.5f);
        this.l = rotateAnimation;
        rotateAnimation.setDuration(300L);
        this.l.setRepeatMode(2);
        this.l.setRepeatCount(-1);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        this.j = scaleAnimation;
        scaleAnimation.setDuration(600L);
        this.j.setRepeatCount(-1);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.k = alphaAnimation;
        alphaAnimation.setDuration(600L);
        this.k.setRepeatCount(-1);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(this.j);
        animationSet.addAnimation(this.k);
        MBridgeDyImageView mBridgeDyImageView = this.f4097a;
        if (mBridgeDyImageView != null) {
            mBridgeDyImageView.startAnimation(this.l);
        }
        MBridgeDyImageView mBridgeDyImageView2 = this.b;
        if (mBridgeDyImageView2 != null) {
            mBridgeDyImageView2.startAnimation(animationSet);
        }
    }

    public void init(int i, int i2) {
        this.h = i;
        this.g = i2;
        init();
    }

    public void init(int i, int i2, String str, String str2, String str3) {
        this.h = i;
        this.g = i2;
        this.d = str;
        this.e = str2;
        this.f = str3;
        init();
    }

    public MBridgeBaitClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = "";
        this.e = "";
        this.f = "Click now for details";
        this.g = 1;
        this.h = C.ENCODING_PCM_24BIT_BIG_ENDIAN;
    }

    public void init() {
        try {
            setBackgroundColor(this.h);
            getDefaultClickText();
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            int a2 = u0.a(getContext(), 55.0f);
            int a3 = u0.a(getContext(), 33.0f);
            this.b = new MBridgeDyImageView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
            layoutParams.setMargins(a3, a3, 0, 0);
            this.b.setLayoutParams(layoutParams);
            final int a4 = h0.a(getContext(), "mbridge_icon_click_circle", "drawable");
            if (TextUtils.isEmpty(this.e)) {
                this.b.setImageResource(a4);
            } else {
                b.a(c.m().d()).a(this.d, new com.mbridge.msdk.foundation.same.image.c() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.1
                    @Override // com.mbridge.msdk.foundation.same.image.c
                    public void onFailedLoad(String str, String str2) {
                        MBridgeBaitClickView.this.b.setImageResource(a4);
                    }

                    @Override // com.mbridge.msdk.foundation.same.image.c
                    public void onSuccessLoad(Bitmap bitmap, String str) {
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        MBridgeBaitClickView.this.b.setImageBitmap(bitmap);
                    }
                });
            }
            int a5 = u0.a(getContext(), 108.0f);
            int a6 = u0.a(getContext(), 35.0f);
            int a7 = u0.a(getContext(), 43.0f);
            this.f4097a = new MBridgeDyImageView(getContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a5, a5);
            layoutParams2.setMargins(a6, a7, 0, 0);
            this.f4097a.setLayoutParams(layoutParams2);
            final int a8 = h0.a(getContext(), "mbridge_icon_click_hand", "drawable");
            if (TextUtils.isEmpty(this.d)) {
                this.f4097a.setImageResource(a8);
            } else {
                b.a(c.m().d()).a(this.d, new com.mbridge.msdk.foundation.same.image.c() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView.2
                    @Override // com.mbridge.msdk.foundation.same.image.c
                    public void onFailedLoad(String str, String str2) {
                        MBridgeBaitClickView.this.f4097a.setImageResource(a8);
                    }

                    @Override // com.mbridge.msdk.foundation.same.image.c
                    public void onSuccessLoad(Bitmap bitmap, String str) {
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        MBridgeBaitClickView.this.f4097a.setImageBitmap(bitmap);
                    }
                });
            }
            relativeLayout.addView(this.b);
            relativeLayout.addView(this.f4097a);
            LinearLayout linearLayout = new LinearLayout(getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            linearLayout.setLayoutParams(layoutParams3);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            linearLayout.addView(relativeLayout);
            this.c = new TextView(getContext());
            this.c.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            this.c.setText(this.f);
            this.c.setTextColor(-1);
            this.c.setGravity(14);
            linearLayout.addView(this.c);
            addView(linearLayout);
        } catch (Throwable th) {
            p0.b("MBridgeAnimationClickView", th.getMessage());
        }
    }

    public MBridgeBaitClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = "";
        this.e = "";
        this.f = "Click now for details";
        this.g = 1;
        this.h = C.ENCODING_PCM_24BIT_BIG_ENDIAN;
    }

    public MBridgeBaitClickView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.d = "";
        this.e = "";
        this.f = "Click now for details";
        this.g = 1;
        this.h = C.ENCODING_PCM_24BIT_BIG_ENDIAN;
    }
}
