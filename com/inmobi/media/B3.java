package com.inmobi.media;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class B3 extends lf {
    public final InterfaceC2971z5 n;
    public final String o;
    public final ViewTreeObserver.OnPreDrawListener p;
    public final WeakReference q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B3(ff visibilityChecker, Activity activity, InterfaceC2971z5 interfaceC2971z5) {
        super(visibilityChecker, (byte) 1, interfaceC2971z5);
        Intrinsics.checkNotNullParameter(visibilityChecker, "visibilityChecker");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.n = interfaceC2971z5;
        this.o = "B3";
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        this.q = new WeakReference(decorView);
        ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.inmobi.media.B3$$ExternalSyntheticLambda0
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public final boolean onPreDraw() {
                    return B3.a(B3.this);
                }
            };
            this.p = onPreDrawListener;
            viewTreeObserver.addOnPreDrawListener(onPreDrawListener);
        } else if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("B3", "TAG");
            ((A5) interfaceC2971z5).b("B3", "Visibility Tracker was unable to track views because the  root view tree observer was not alive");
        }
    }

    public static final boolean a(B3 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
        return true;
    }

    @Override // com.inmobi.media.lf
    public final void b() {
        InterfaceC2971z5 interfaceC2971z5 = this.n;
        if (interfaceC2971z5 != null) {
            String TAG = this.o;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "unregisterPreDrawListener");
        }
        View view = (View) this.q.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.p);
            }
        }
        super.b();
    }

    @Override // com.inmobi.media.lf
    public final int c() {
        return 100;
    }

    @Override // com.inmobi.media.lf
    public final void d() {
    }

    @Override // com.inmobi.media.lf
    public final void e() {
        InterfaceC2971z5 interfaceC2971z5 = this.n;
        if (interfaceC2971z5 != null) {
            String TAG = this.o;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
        }
        if (this.i.get()) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.n;
        if (interfaceC2971z52 != null) {
            String TAG2 = this.o;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z52).c(TAG2, "unregisterPreDrawListener");
        }
        View view = (View) this.q.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.p);
            }
        }
        super.e();
    }

    @Override // com.inmobi.media.lf
    public final void f() {
        InterfaceC2971z5 interfaceC2971z5 = this.n;
        if (interfaceC2971z5 != null) {
            String TAG = this.o;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, CampaignEx.JSON_NATIVE_VIDEO_RESUME);
        }
        if (this.i.get()) {
            View view = (View) this.q.get();
            if (view != null) {
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnPreDrawListener(this.p);
                } else {
                    InterfaceC2971z5 interfaceC2971z52 = this.n;
                    if (interfaceC2971z52 != null) {
                        String TAG2 = this.o;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        ((A5) interfaceC2971z52).b(TAG2, "Visibility Tracker was unable to track views because the root view tree observer was not alive");
                    }
                }
            }
            super.f();
        }
    }
}
