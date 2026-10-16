package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Insets;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import androidx.core.view.GravityCompat;
import com.vungle.ads.internal.protos.Sdk;

/* loaded from: classes2.dex */
public abstract class b8 {

    class a implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f409a;
        final /* synthetic */ Runnable b;

        a(View view, Runnable runnable) {
            this.f409a = view;
            this.b = runnable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Runnable runnable = this.b;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f409a.setVisibility(0);
        }
    }

    class b implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f410a;
        final /* synthetic */ Runnable b;

        b(View view, Runnable runnable) {
            this.f410a = view;
            this.b = runnable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f410a.setVisibility(4);
            Runnable runnable = this.b;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f410a.setVisibility(0);
        }
    }

    public static void a(View view, long j, Runnable runnable) {
        view.setVisibility(4);
        view.bringToFront();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new a(view, runnable));
        view.startAnimation(alphaAnimation);
    }

    public static void b(View view, long j, Runnable runnable) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new b(view, runnable));
        view.startAnimation(alphaAnimation);
    }

    public static boolean b(int i) {
        return i == 0;
    }

    public static void c(View view) {
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public static boolean a(int i, int i2) {
        return b(i) != b(i2);
    }

    public static Activity b(View view, com.applovin.impl.sdk.k kVar) {
        if (view == null) {
            return null;
        }
        for (int i = 0; i < 1000; i++) {
            try {
                Context context = view.getContext();
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } catch (Throwable th) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().a("ViewUtils", "Encountered error while retrieving activity from view", th);
                }
            }
        }
        return null;
    }

    public static String a(int i) {
        if (i == 0) {
            return "VISIBLE";
        }
        if (i == 4) {
            return "INVISIBLE";
        }
        if (i == 8) {
            return "GONE";
        }
        return String.valueOf(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0061, code lost:
    
        if ((r2 & 1) == 1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0031, code lost:
    
        if ((r2 & 16) == 16) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] a(int i, int i2, int i3) {
        if (i == 0) {
            return new int[]{i2, i3};
        }
        if ((i & Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) == 119) {
            return new int[]{13};
        }
        if ((i & 112) != 112) {
            if ((i & 48) == 48) {
                i2 = 10;
            } else if ((i & 80) == 80) {
                i2 = 12;
            }
            if ((i & 7) != 7) {
                if ((i & GravityCompat.START) == 8388611) {
                    i3 = 20;
                } else if ((i & 3) == 3) {
                    i3 = 9;
                } else if ((i & GravityCompat.END) == 8388613) {
                    i3 = 21;
                } else if ((i & 5) == 5) {
                    i3 = 11;
                }
                return new int[]{i3, i2};
            }
            i3 = 14;
            return new int[]{i3, i2};
        }
        i2 = 15;
        if ((i & 7) != 7) {
        }
        i3 = 14;
        return new int[]{i3, i2};
    }

    public static View b(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View findViewById = rootView.findViewById(R.id.content);
        return findViewById != null ? findViewById : rootView;
    }

    public static void a(View view, final com.applovin.impl.sdk.k kVar) {
        if (view == null || kVar == null || !o0.b()) {
            return;
        }
        view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.applovin.impl.b8$$ExternalSyntheticLambda0
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                WindowInsets a2;
                a2 = b8.a(com.applovin.impl.sdk.k.this, view2, windowInsets);
                return a2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ WindowInsets a(com.applovin.impl.sdk.k kVar, View view, WindowInsets windowInsets) {
        Insets insets = windowInsets.getInsets(((Integer) kVar.a(v4.s2)).intValue());
        view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return WindowInsets.CONSUMED;
    }

    public static boolean a(View view, Activity activity) {
        if (activity != null && view != null) {
            Window window = activity.getWindow();
            if (window != null) {
                return a(view, window.getDecorView());
            }
            View findViewById = activity.findViewById(R.id.content);
            if (findViewById != null) {
                return a(view, findViewById.getRootView());
            }
        }
        return false;
    }

    private static boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (a(view, viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String a(View view) {
        return view.getClass().getName() + '@' + Integer.toHexString(view.hashCode());
    }
}
