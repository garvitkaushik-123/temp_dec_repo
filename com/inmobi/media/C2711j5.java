package com.inmobi.media;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.inmobi.ads.rendering.InMobiAdActivity;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.j5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2711j5 implements InterfaceC2860sa {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f2609a;
    public InterfaceC2930x b;
    public P c;
    public RelativeLayout d;
    public Y3 e;
    public EnumC2813pa f;
    public float g;
    public InterfaceC2971z5 h;
    public final C2694i5 i;
    public final C2678h5 j;

    public C2711j5(InMobiAdActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f2609a = new WeakReference(activity);
        this.f = AbstractC2829qa.a(U3.g());
        this.g = 1.0f;
        this.i = new C2694i5(this);
        this.j = new C2678h5(this);
    }

    public final void a(Intent intent, SparseArray adContainers) {
        Y3 y3;
        Window window;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(adContainers, "adContainers");
        if (!intent.hasExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX")) {
            b();
            return;
        }
        InterfaceC2930x interfaceC2930x = (InterfaceC2930x) adContainers.get(intent.getIntExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX", -1));
        if (interfaceC2930x == null) {
            b();
            return;
        }
        int intExtra = intent.getIntExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_TYPE", 0);
        if (intExtra == 0) {
            InterfaceC2914w fullScreenEventsListener = interfaceC2930x.getFullScreenEventsListener();
            if (fullScreenEventsListener != null) {
                fullScreenEventsListener.a();
            }
            b();
            return;
        }
        if (intent.getBooleanExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", false) && (this.f2609a.get() instanceof InMobiAdActivity)) {
            Object obj = this.f2609a.get();
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.inmobi.ads.rendering.InMobiAdActivity");
            if (!((InMobiAdActivity) obj).g) {
                Object obj2 = this.f2609a.get();
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.inmobi.ads.rendering.InMobiAdActivity");
                ((InMobiAdActivity) obj2).g = true;
                if (!(interfaceC2930x instanceof GestureDetectorOnGestureListenerC2634ec) ? false : ((GestureDetectorOnGestureListenerC2634ec) interfaceC2930x).S0) {
                    InterfaceC2971z5 interfaceC2971z5 = this.h;
                    if (interfaceC2971z5 != null) {
                        ((A5) interfaceC2971z5).a("InMobiActivityViewHandler", "showInImmersiveMode");
                    }
                    Object obj3 = this.f2609a.get();
                    InMobiAdActivity inMobiAdActivity = obj3 instanceof InMobiAdActivity ? (InMobiAdActivity) obj3 : null;
                    if (inMobiAdActivity != null && (window = inMobiAdActivity.getWindow()) != null) {
                        L3 l3 = L3.f2348a;
                        if (l3.z()) {
                            WindowManager.LayoutParams attributes = window.getAttributes();
                            attributes.layoutInDisplayCutoutMode = 3;
                            window.setAttributes(attributes);
                            WindowCompat.setDecorFitsSystemWindows(window, false);
                        } else if (l3.x()) {
                            WindowManager.LayoutParams attributes2 = window.getAttributes();
                            attributes2.layoutInDisplayCutoutMode = 1;
                            window.setAttributes(attributes2);
                            WindowCompat.setDecorFitsSystemWindows(window, false);
                        }
                        if (l3.z()) {
                            WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(window, window.getDecorView());
                            if (insetsController != null) {
                                insetsController.setSystemBarsBehavior(2);
                            }
                            if (insetsController != null) {
                                insetsController.hide(WindowInsetsCompat.Type.systemBars());
                            }
                            if (insetsController != null) {
                                insetsController.hide(WindowInsetsCompat.Type.displayCutout());
                            }
                        } else if (l3.F()) {
                            window.getDecorView().setSystemUiVisibility(5638);
                        }
                    }
                } else {
                    Activity activity = (Activity) this.f2609a.get();
                    if (activity != null) {
                        Intrinsics.checkNotNullParameter(activity, "<this>");
                        try {
                            activity.requestWindowFeature(1);
                            activity.getWindow().setFlags(1024, 1024);
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        if ((200 == intExtra && !Intrinsics.areEqual(AnalyticsConstants.CREATIVE_TYPE_HTML, interfaceC2930x.getMarkupType())) || ((202 == intExtra && !Intrinsics.areEqual("htmlUrl", interfaceC2930x.getMarkupType())) || (201 == intExtra && !Intrinsics.areEqual("inmobiJson", interfaceC2930x.getMarkupType())))) {
            InterfaceC2914w fullScreenEventsListener2 = interfaceC2930x.getFullScreenEventsListener();
            if (fullScreenEventsListener2 != null) {
                fullScreenEventsListener2.a();
            }
            b();
            return;
        }
        try {
            this.b = interfaceC2930x;
            interfaceC2930x.setFullScreenActivityContext((Activity) this.f2609a.get());
            a();
            Activity activity2 = (Activity) this.f2609a.get();
            if (activity2 != null) {
                RelativeLayout relativeLayout = new RelativeLayout(activity2);
                relativeLayout.setId(65534);
                this.d = relativeLayout;
            }
            a(interfaceC2930x);
            P p = this.c;
            if (p != null) {
                p.f();
            }
            Activity activity3 = (Activity) this.f2609a.get();
            if (activity3 != null) {
                FrameLayout frameLayout = (FrameLayout) activity3.findViewById(R.id.content);
                RelativeLayout relativeLayout2 = frameLayout != null ? (RelativeLayout) frameLayout.findViewById(65519) : null;
                RelativeLayout relativeLayout3 = this.d;
                if (relativeLayout3 != null && relativeLayout2 != null) {
                    RelativeLayout relativeLayout4 = (RelativeLayout) relativeLayout2.findViewById(65534);
                    if (relativeLayout4 != null) {
                        relativeLayout2.removeView(relativeLayout4);
                    }
                    relativeLayout2.addView(relativeLayout3);
                    P p2 = this.c;
                    if (p2 != null) {
                        p2.e();
                    }
                }
            }
            if (interfaceC2930x instanceof GestureDetectorOnGestureListenerC2634ec) {
                ((GestureDetectorOnGestureListenerC2634ec) interfaceC2930x).setEmbeddedBrowserJsCallbacks(this.j);
            }
            if ((interfaceC2930x instanceof GestureDetectorOnGestureListenerC2634ec) && (y3 = this.e) != null) {
                y3.setUserLeftApplicationListener(((GestureDetectorOnGestureListenerC2634ec) interfaceC2930x).getListener());
            }
        } catch (Exception e) {
            interfaceC2930x.setFullScreenActivityContext(null);
            InterfaceC2914w fullScreenEventsListener3 = interfaceC2930x.getFullScreenEventsListener();
            if (fullScreenEventsListener3 != null) {
                fullScreenEventsListener3.a();
            }
            b();
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }

    public final void b() {
        Activity activity = (Activity) this.f2609a.get();
        if (activity instanceof InMobiAdActivity) {
            ((InMobiAdActivity) activity).finish();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        if (com.inmobi.media.B2.a(r0) == true) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c() {
        V3 d;
        if (this.e == null) {
            return;
        }
        InterfaceC2930x interfaceC2930x = this.b;
        if (interfaceC2930x != null) {
            if (!(!(interfaceC2930x instanceof GestureDetectorOnGestureListenerC2634ec) ? false : ((GestureDetectorOnGestureListenerC2634ec) interfaceC2930x).S0)) {
                Activity activity = (Activity) this.f2609a.get();
                if (activity != null) {
                    Intrinsics.checkNotNull(activity);
                }
            }
            d = U3.h();
            float f = d.f2459a;
            float f2 = d.c;
            float f3 = f * f2;
            float f4 = d.b * f2;
            if (AbstractC2829qa.b(this.f)) {
                a(-1, MathKt.roundToInt((1 - this.g) * f4));
                return;
            } else {
                a(MathKt.roundToInt((1 - this.g) * f3), -1);
                return;
            }
        }
        d = U3.d();
        float f5 = d.f2459a;
        float f22 = d.c;
        float f32 = f5 * f22;
        float f42 = d.b * f22;
        if (AbstractC2829qa.b(this.f)) {
        }
    }

    public final void d() {
        try {
            final Y3 y3 = this.e;
            if (y3 != null) {
                ViewParent parent = y3.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(y3);
                }
                ViewParent parent2 = y3.getParent();
                ViewGroup viewGroup2 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
                if (viewGroup2 != null) {
                    viewGroup2.post(new Runnable() { // from class: com.inmobi.media.j5$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            C2711j5.a(Y3.this);
                        }
                    });
                }
            }
            Y3 y32 = this.e;
            if (y32 != null) {
                C2677h4 c2677h4 = y32.c;
                if (c2677h4 != null) {
                    c2677h4.destroy();
                }
                y32.c = null;
                y32.d = null;
                y32.e = null;
                Df df = y32.g;
                if (df != null) {
                    df.a();
                }
                y32.removeAllViews();
            }
            this.e = null;
            GestureDetectorOnGestureListenerC2634ec.Y0.getClass();
            a(Gb.a("IN_CUSTOM_EXPAND", "onClose"));
        } catch (Exception unused) {
        }
    }

    public final void a() {
        Activity activity = (Activity) this.f2609a.get();
        if (activity == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.content);
        if ((frameLayout != null ? (RelativeLayout) frameLayout.findViewById(65519) : null) != null) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(activity);
        relativeLayout.setId(65519);
        relativeLayout.setBackgroundColor(0);
        frameLayout.removeAllViews();
        frameLayout.addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        r1 = new com.inmobi.media.V4(r4.f2609a, r5, r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(InterfaceC2930x interfaceC2930x) {
        RelativeLayout relativeLayout;
        if (((Activity) this.f2609a.get()) == null || (relativeLayout = this.d) == null) {
            return;
        }
        String markupType = interfaceC2930x.getMarkupType();
        int hashCode = markupType.hashCode();
        if (hashCode == -1084172778) {
            if (markupType.equals("inmobiJson")) {
                P c2972z6 = new C2972z6(this.f2609a, interfaceC2930x, relativeLayout);
                this.c = c2972z6;
                c2972z6.a(this.f);
                c2972z6.c = this.g;
                c2972z6.d = interfaceC2930x instanceof GestureDetectorOnGestureListenerC2634ec ? false : ((GestureDetectorOnGestureListenerC2634ec) interfaceC2930x).S0;
            }
            throw new IllegalArgumentException("InMobiActivityViewHandler: Unknown Markup type");
        }
        if (hashCode != 3213227) {
            throw new IllegalArgumentException("InMobiActivityViewHandler: Unknown Markup type");
        }
        throw new IllegalArgumentException("InMobiActivityViewHandler: Unknown Markup type");
        this.c = c2972z6;
        c2972z6.a(this.f);
        c2972z6.c = this.g;
        c2972z6.d = interfaceC2930x instanceof GestureDetectorOnGestureListenerC2634ec ? false : ((GestureDetectorOnGestureListenerC2634ec) interfaceC2930x).S0;
    }

    public final void a(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        InterfaceC2930x interfaceC2930x = this.b;
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = interfaceC2930x instanceof GestureDetectorOnGestureListenerC2634ec ? (GestureDetectorOnGestureListenerC2634ec) interfaceC2930x : null;
        if (gestureDetectorOnGestureListenerC2634ec != null) {
            gestureDetectorOnGestureListenerC2634ec.a(jsonObject);
        }
    }

    @Override // com.inmobi.media.InterfaceC2860sa
    public final void a(EnumC2813pa orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (((Activity) this.f2609a.get()) == null) {
            return;
        }
        P p = this.c;
        if (p != null) {
            p.a(orientation);
        }
        EnumC2813pa enumC2813pa = this.f;
        if (enumC2813pa != orientation && AbstractC2829qa.b(enumC2813pa) != AbstractC2829qa.b(orientation)) {
            Objects.toString(orientation);
            this.f = orientation;
            P p2 = this.c;
            if (p2 != null) {
                p2.e();
            }
            c();
            return;
        }
        Objects.toString(orientation);
        this.f = orientation;
    }

    public static final void a(C2711j5 c2711j5) {
        c2711j5.g = 1.0f;
        P p = c2711j5.c;
        if (p != null) {
            p.c = 1.0f;
            p.e();
        }
        Y3 y3 = c2711j5.e;
        if (y3 != null) {
            y3.setLayoutParams(new RelativeLayout.LayoutParams(0, 0));
        }
        c2711j5.d();
    }

    public static final void a(Y3 this_run) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        this_run.getParent().requestLayout();
    }

    public final void a(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams;
        Activity activity = (Activity) this.f2609a.get();
        if (activity == null) {
            return;
        }
        AbstractC2829qa.b(this.f);
        if (AbstractC2829qa.b(this.f)) {
            layoutParams = new RelativeLayout.LayoutParams(i, i2);
            layoutParams.addRule(11);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(i, i2);
            layoutParams.addRule(12);
        }
        RelativeLayout relativeLayout = (RelativeLayout) ((FrameLayout) activity.findViewById(R.id.content)).findViewById(65519);
        Intrinsics.checkNotNull(relativeLayout);
        if (((RelativeLayout) relativeLayout.findViewById(65518)) != null) {
            Y3 y3 = this.e;
            if (y3 == null) {
                return;
            }
            y3.setLayoutParams(layoutParams);
            return;
        }
        Y3 y32 = this.e;
        if (y32 != null) {
            relativeLayout.addView(y32, layoutParams);
        }
    }
}
