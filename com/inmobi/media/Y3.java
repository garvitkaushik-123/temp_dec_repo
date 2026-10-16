package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Y3 extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public final Activity f2491a;
    public int b;
    public C2677h4 c;
    public InterfaceC2575b4 d;
    public Fe e;
    public InterfaceC2971z5 f;
    public Df g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y3(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f2491a = activity;
        this.b = -1;
    }

    public final void a(LinearLayout linearLayout, LinearLayout.LayoutParams layoutParams) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        C2950y3 c2950y3 = new C2950y3(context, (byte) 4, this.f);
        c2950y3.setId(65503);
        c2950y3.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.media.Y3$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return Y3.a(Y3.this, view, motionEvent);
            }
        });
        linearLayout.addView(c2950y3, layoutParams);
    }

    public final void b(LinearLayout linearLayout, LinearLayout.LayoutParams layoutParams) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        C2950y3 c2950y3 = new C2950y3(context, (byte) 2, this.f);
        c2950y3.setId(65516);
        c2950y3.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.media.Y3$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return Y3.b(Y3.this, view, motionEvent);
            }
        });
        linearLayout.addView(c2950y3, layoutParams);
    }

    public final void c(LinearLayout linearLayout, LinearLayout.LayoutParams layoutParams) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        C2950y3 c2950y3 = new C2950y3(context, (byte) 6, this.f);
        c2950y3.setId(1048283);
        c2950y3.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.media.Y3$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return Y3.c(Y3.this, view, motionEvent);
            }
        });
        linearLayout.addView(c2950y3, layoutParams);
    }

    public final void d(LinearLayout linearLayout, LinearLayout.LayoutParams layoutParams) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        C2950y3 c2950y3 = new C2950y3(context, (byte) 3, this.f);
        c2950y3.setId(65502);
        c2950y3.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.media.Y3$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return Y3.d(Y3.this, view, motionEvent);
            }
        });
        linearLayout.addView(c2950y3, layoutParams);
    }

    public final Fe getUserLeftApplicationListener() {
        return this.e;
    }

    public final void setEmbeddedBrowserUpdateListener(InterfaceC2575b4 browserUpdateListener) {
        Intrinsics.checkNotNullParameter(browserUpdateListener, "browserUpdateListener");
        this.d = browserUpdateListener;
    }

    public final void setLogger(InterfaceC2971z5 logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f = logger;
    }

    public final void setUserLeftApplicationListener(Fe fe) {
        this.e = fe;
    }

    public static final boolean b(Y3 this$0, View view, MotionEvent motionEvent) {
        C2592c4 c2592c4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 1) {
            view.setBackgroundColor(-7829368);
            C2677h4 c2677h4 = this$0.c;
            if (c2677h4 != null && (c2592c4 = c2677h4.h) != null) {
                C2592c4.a(c2592c4, 5, true, null, 12);
            }
            InterfaceC2575b4 interfaceC2575b4 = this$0.d;
            if (interfaceC2575b4 != null) {
                C2711j5.a(((C2694i5) interfaceC2575b4).f2596a);
            }
            return true;
        }
        if (motionEvent.getAction() == 0) {
            view.setBackgroundColor(-16711681);
        }
        return true;
    }

    public static final boolean d(Y3 this$0, View view, MotionEvent motionEvent) {
        C2592c4 c2592c4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 1) {
            view.setBackgroundColor(-7829368);
            C2677h4 c2677h4 = this$0.c;
            if (c2677h4 != null && (c2592c4 = c2677h4.h) != null) {
                C2592c4.a(c2592c4, 6, true, null, 12);
            }
            C2677h4 c2677h42 = this$0.c;
            if (c2677h42 != null) {
                c2677h42.reload();
            }
            return true;
        }
        if (motionEvent.getAction() == 0) {
            view.setBackgroundColor(-16711681);
        }
        return true;
    }

    public static final boolean c(Y3 this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C2677h4 c2677h4 = this$0.c;
        if (c2677h4 == null) {
            return true;
        }
        if (motionEvent.getAction() == 1) {
            view.setBackgroundColor(-7829368);
            if (c2677h4.canGoForward()) {
                c2677h4.goForward();
            }
            return true;
        }
        if (motionEvent.getAction() == 0) {
            view.setBackgroundColor(-16711681);
        }
        return true;
    }

    public static final boolean a(Y3 this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C2677h4 c2677h4 = this$0.c;
        if (c2677h4 == null) {
            InterfaceC2575b4 interfaceC2575b4 = this$0.d;
            if (interfaceC2575b4 != null) {
                C2711j5.a(((C2694i5) interfaceC2575b4).f2596a);
            }
            return true;
        }
        if (motionEvent.getAction() == 1) {
            view.setBackgroundColor(-7829368);
            if (c2677h4.canGoBack()) {
                c2677h4.goBack();
            } else {
                InterfaceC2575b4 interfaceC2575b42 = this$0.d;
                if (interfaceC2575b42 != null) {
                    C2711j5.a(((C2694i5) interfaceC2575b42).f2596a);
                }
            }
            return true;
        }
        if (motionEvent.getAction() == 0) {
            view.setBackgroundColor(-16711681);
        }
        return true;
    }
}
