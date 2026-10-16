package com.inmobi.media;

import android.R;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.e9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2631e9 extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final String f2561a;
    public C2562a9 b;
    public final HandlerC2614d9 c;
    public C2747l9 d;
    public boolean e;
    public final C2950y3 f;
    public final C2950y3 g;
    public final ProgressBar h;
    public final RelativeLayout i;
    public boolean j;
    public final float k;
    public final View.OnClickListener l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2631e9(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2561a = "e9";
        this.k = U3.d().c;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.i = relativeLayout;
        this.f = new C2950y3(context, (byte) 9, null);
        this.g = new C2950y3(context, (byte) 10, null);
        ProgressBar progressBar = new ProgressBar(context, null, R.attr.progressBarStyleHorizontal);
        this.h = progressBar;
        progressBar.setScaleY(0.8f);
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setPadding(0, 0, 0, 0);
        a();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12, -1);
        float f = U3.d().c;
        layoutParams.setMargins(0, (int) ((-6) * f), 0, (int) ((-8) * f));
        Drawable progressDrawable = progressBar.getProgressDrawable();
        LayerDrawable layerDrawable = progressDrawable instanceof LayerDrawable ? (LayerDrawable) progressDrawable : null;
        if (layerDrawable != null) {
            Drawable drawable = layerDrawable.getDrawable(0);
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
            drawable.setColorFilter(new PorterDuffColorFilter(-1, mode));
            layerDrawable.getDrawable(2).setColorFilter(new PorterDuffColorFilter(-327674, mode));
        }
        relativeLayout.addView(progressBar, layoutParams);
        this.c = new HandlerC2614d9(this);
        this.l = new View.OnClickListener() { // from class: com.inmobi.media.e9$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2631e9.a(C2631e9.this, view);
            }
        };
    }

    public final void a() {
        int i = (int) (30 * this.k);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(12, -1);
        this.i.addView(this.f, layoutParams);
        this.f.setOnClickListener(this.l);
    }

    public final void b() {
        int i = (int) (30 * this.k);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(12, -1);
        this.i.addView(this.g, layoutParams);
        this.g.setOnClickListener(this.l);
    }

    public final void c() {
        if (this.e) {
            try {
                HandlerC2614d9 handlerC2614d9 = this.c;
                if (handlerC2614d9 != null) {
                    handlerC2614d9.removeMessages(2);
                }
                setVisibility(8);
            } catch (IllegalArgumentException e) {
                String TAG = this.f2561a;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                S5 s5 = S5.f2425a;
                C2640f2 event = new C2640f2(e);
                Intrinsics.checkNotNullParameter(event, "event");
                S5.d.a(event);
            }
            this.e = false;
        }
    }

    public final void d() {
        if (!this.e) {
            C2747l9 c2747l9 = this.d;
            if (c2747l9 != null) {
                int currentPosition = c2747l9.getCurrentPosition();
                int duration = c2747l9.getDuration();
                if (duration != 0) {
                    this.h.setProgress((currentPosition * 100) / duration);
                }
            }
            this.e = true;
            C2747l9 c2747l92 = this.d;
            Object tag = c2747l92 != null ? c2747l92.getTag() : null;
            C2597c9 c2597c9 = tag instanceof C2597c9 ? (C2597c9) tag : null;
            if (c2597c9 != null) {
                this.f.setVisibility(c2597c9.A ? 0 : 4);
                this.h.setVisibility(c2597c9.C ? 0 : 4);
            }
            setVisibility(0);
        }
        HandlerC2614d9 handlerC2614d9 = this.c;
        if (handlerC2614d9 != null) {
            handlerC2614d9.sendEmptyMessage(2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent event) {
        C2747l9 c2747l9;
        C2747l9 c2747l92;
        Intrinsics.checkNotNullParameter(event, "event");
        int keyCode = event.getKeyCode();
        boolean z = event.getRepeatCount() == 0 && event.getAction() == 0;
        if (keyCode != 24 && keyCode != 25 && keyCode != 27) {
            if (keyCode != 62 && keyCode != 79) {
                if (keyCode != 164) {
                    if (keyCode != 85) {
                        if (keyCode != 86) {
                            if (keyCode == 126) {
                                if (z && (c2747l92 = this.d) != null && !c2747l92.isPlaying()) {
                                    C2747l9 c2747l93 = this.d;
                                    if (c2747l93 != null) {
                                        c2747l93.start();
                                    }
                                    d();
                                }
                                return true;
                            }
                            if (keyCode != 127) {
                                d();
                                return super.dispatchKeyEvent(event);
                            }
                        }
                        if (z && (c2747l9 = this.d) != null && c2747l9.isPlaying()) {
                            C2747l9 c2747l94 = this.d;
                            if (c2747l94 != null) {
                                c2747l94.pause();
                            }
                            d();
                        }
                        return true;
                    }
                }
            }
            if (z) {
                C2747l9 c2747l95 = this.d;
                if (c2747l95 != null) {
                    if (c2747l95.isPlaying()) {
                        c2747l95.pause();
                    } else {
                        c2747l95.start();
                    }
                }
                d();
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    public final Map<View, FriendlyObstructionPurpose> getFriendlyViews() {
        ProgressBar progressBar = this.h;
        FriendlyObstructionPurpose friendlyObstructionPurpose = FriendlyObstructionPurpose.VIDEO_CONTROLS;
        return MapsKt.hashMapOf(TuplesKt.to(progressBar, friendlyObstructionPurpose), TuplesKt.to(this.f, friendlyObstructionPurpose), TuplesKt.to(this.g, friendlyObstructionPurpose));
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onInitializeAccessibilityEvent(event);
        event.setClassName(C2631e9.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(C2631e9.class.getName());
    }

    @Override // android.view.View
    public final boolean onTrackballEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        C2747l9 c2747l9 = this.d;
        if (c2747l9 == null || !c2747l9.a()) {
            return false;
        }
        if (this.e) {
            c();
            return false;
        }
        d();
        return false;
    }

    public final void setMediaPlayer(C2747l9 videoView) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        this.d = videoView;
        Object tag = videoView != null ? videoView.getTag() : null;
        C2597c9 c2597c9 = tag instanceof C2597c9 ? (C2597c9) tag : null;
        if (c2597c9 == null || !c2597c9.A || c2597c9.c()) {
            return;
        }
        this.j = true;
        this.i.removeView(this.g);
        this.i.removeView(this.f);
        b();
    }

    public final void setVideoAd(C2562a9 c2562a9) {
        this.b = c2562a9;
    }

    public static final void a(C2631e9 this$0, View view) {
        C2562a9 c2562a9;
        C2562a9 c2562a92;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C2747l9 c2747l9 = this$0.d;
        if (c2747l9 != null) {
            Object tag = c2747l9.getTag();
            C2597c9 c2597c9 = tag instanceof C2597c9 ? (C2597c9) tag : null;
            if (this$0.j) {
                C2747l9 c2747l92 = this$0.d;
                if (c2747l92 != null) {
                    c2747l92.k();
                }
                this$0.j = false;
                this$0.i.removeView(this$0.g);
                this$0.i.removeView(this$0.f);
                this$0.a();
                if (c2597c9 == null || (c2562a92 = this$0.b) == null) {
                    return;
                }
                try {
                    c2562a92.i(c2597c9);
                    c2597c9.z = true;
                    return;
                } catch (Exception e) {
                    String TAG = this$0.f2561a;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    S5 s5 = S5.f2425a;
                    S5.d.a(AbstractC2920w5.a(e, "event"));
                    return;
                }
            }
            C2747l9 c2747l93 = this$0.d;
            if (c2747l93 != null) {
                c2747l93.c();
            }
            this$0.j = true;
            this$0.i.removeView(this$0.f);
            this$0.i.removeView(this$0.g);
            this$0.b();
            if (c2597c9 == null || (c2562a9 = this$0.b) == null) {
                return;
            }
            try {
                c2562a9.e(c2597c9);
                c2597c9.z = false;
            } catch (Exception e2) {
                String TAG2 = this$0.f2561a;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                S5 s52 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e2, "event"));
            }
        }
    }
}
