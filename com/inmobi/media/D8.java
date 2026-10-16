package com.inmobi.media;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.core.view.GravityCompat;
import com.inmobi.ads.viewsv2.NativeRecyclerViewAdapter;
import com.inmobi.commons.core.configs.AdConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes4.dex */
public final class D8 {

    /* renamed from: a, reason: collision with root package name */
    public final AdConfig f2262a;
    public final T7 b;
    public final C2811p8 c;
    public final C2923w8 d;
    public final C2907v8 e;
    public final InterfaceC2971z5 f;
    public final String g;
    public final Handler h;
    public final WeakReference i;
    public L8 j;
    public int k;
    public final C2572b1 l;
    public final D9 m;
    public boolean n;
    public GestureDetectorOnGestureListenerC2634ec o;
    public C2939x8 p;

    public D8(Context context, AdConfig adConfig, T7 nativeAdContainer, C2811p8 dataModel, C2923w8 viewEventListener, C2907v8 clickEventListener, C2939x8 timerFinishListener, InterfaceC2971z5 interfaceC2971z5) {
        D9 d9;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(nativeAdContainer, "nativeAdContainer");
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        Intrinsics.checkNotNullParameter(viewEventListener, "viewEventListener");
        Intrinsics.checkNotNullParameter(clickEventListener, "clickEventListener");
        Intrinsics.checkNotNullParameter(timerFinishListener, "timerFinishListener");
        this.f2262a = adConfig;
        this.b = nativeAdContainer;
        this.c = dataModel;
        this.d = viewEventListener;
        this.e = clickEventListener;
        this.f = interfaceC2971z5;
        this.g = "D8";
        this.h = new Handler(Looper.getMainLooper());
        this.i = new WeakReference(context);
        this.l = new C2572b1();
        HashMap hashMap = D9.c;
        Intrinsics.checkNotNullParameter(context, "context");
        WeakReference weakReference = D9.d;
        D9 d92 = weakReference != null ? (D9) weakReference.get() : null;
        if (d92 == null) {
            synchronized (D9.class) {
                WeakReference weakReference2 = D9.d;
                if (weakReference2 == null || (d9 = (D9) weakReference2.get()) == null) {
                    d9 = new D9(context);
                    D9.d = new WeakReference(d9);
                }
                Intrinsics.checkNotNull(d9);
            }
            d92 = d9;
        }
        this.m = d92;
        this.p = timerFinishListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0026 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ViewGroup a(ViewGroup parent, C2681h8 root) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(root, "root");
        Context context = (Context) this.i.get();
        if (context != null) {
            View a2 = this.m.a(context, root, this.f2262a);
            if (a2 instanceof ViewGroup) {
                viewGroup = (ViewGroup) a2;
                if (viewGroup != null) {
                    return viewGroup;
                }
                HashMap hashMap = D9.c;
                viewGroup.setLayoutParams(C2779n9.a(root, parent));
                return viewGroup;
            }
        }
        viewGroup = null;
        if (viewGroup != null) {
        }
    }

    public final void b(View view, final C2613d8 c2613d8) {
        if (c2613d8.f) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.inmobi.media.D8$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    D8.a(D8.this, c2613d8, view2);
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:183:0x0130, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual("UNKNOWN", r0.y) != false) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0140, code lost:
    
        if (r11.e == null) goto L175;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03b8 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015d  */
    /* JADX WARN: Type inference failed for: r12v33 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9, types: [int] */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ViewGroup b(ViewGroup viewGroup, C2681h8 c2681h8) {
        View view;
        String str;
        Object obj;
        int i;
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec;
        boolean z;
        S7 s7;
        T7 t7;
        InterfaceC2971z5 interfaceC2971z5;
        RelativeLayout.LayoutParams layoutParams;
        double a2;
        double a3;
        int i2;
        K8 k8;
        int i3;
        b((View) viewGroup, (C2613d8) c2681h8);
        boolean z2 = false;
        int i4 = 0;
        while (i4 < c2681h8.B) {
            try {
                int i5 = i4 + 1;
                C2613d8 c2613d8 = (C2613d8) c2681h8.A.get(i4);
                Intrinsics.checkNotNull(c2613d8);
                r2 = null;
                L8 nativeRecyclerViewAdapter = null;
                if (Intrinsics.areEqual("CONTAINER", c2613d8.c)) {
                    if (StringsKt.equals(c2613d8.b, "card_scrollable", true)) {
                        Context context = (Context) this.i.get();
                        View a4 = context != null ? this.m.a(context, c2613d8, this.f2262a) : null;
                        if (a4 instanceof K8) {
                            K8 k82 = (K8) a4;
                            byte type = k82.getType();
                            C2811p8 dataModel = this.c;
                            Intrinsics.checkNotNullParameter(dataModel, "dataModel");
                            Intrinsics.checkNotNullParameter(this, "inflater");
                            if (type == 0) {
                                nativeRecyclerViewAdapter = new C2827q8(dataModel, this);
                            } else if (type == 1) {
                                try {
                                    nativeRecyclerViewAdapter = new NativeRecyclerViewAdapter(dataModel, this);
                                } catch (NoClassDefFoundError e) {
                                    AbstractC2680h7.a((byte) 1, "InMobi", "Error rendering ad! RecyclerView not found. Please check if the recyclerview support library was included");
                                    S5 s5 = S5.f2425a;
                                    C2640f2 event = new C2640f2(e);
                                    Intrinsics.checkNotNullParameter(event, "event");
                                    S5.d.a(event);
                                }
                            }
                            this.j = nativeRecyclerViewAdapter;
                            if (nativeRecyclerViewAdapter != null) {
                                Intrinsics.checkNotNull(c2613d8, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeContainerAsset");
                                L8 l8 = nativeRecyclerViewAdapter;
                                C2681h8 c2681h82 = (C2681h8) c2613d8;
                                int i6 = this.k;
                                if (i6 == 0) {
                                    i3 = GravityCompat.START;
                                } else if (i6 == this.c.d() - 1) {
                                    i3 = GravityCompat.END;
                                } else {
                                    i2 = 1;
                                    k8 = k82;
                                    k8.a(c2681h82, l8, i6, i2, this);
                                    HashMap hashMap = D9.c;
                                    k8.setLayoutParams(C2779n9.a(c2613d8, viewGroup));
                                    a(a4, c2613d8);
                                    viewGroup.addView(a4);
                                }
                                k8 = k82;
                                i2 = i3;
                                k8.a(c2681h82, l8, i6, i2, this);
                                HashMap hashMap2 = D9.c;
                                k8.setLayoutParams(C2779n9.a(c2613d8, viewGroup));
                                a(a4, c2613d8);
                                viewGroup.addView(a4);
                            }
                        }
                    } else {
                        Context context2 = (Context) this.i.get();
                        View a5 = context2 != null ? this.m.a(context2, c2613d8, this.f2262a) : null;
                        if (a5 instanceof ViewGroup) {
                            Intrinsics.checkNotNull(c2613d8, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeContainerAsset");
                            ViewGroup b = b((ViewGroup) a5, (C2681h8) c2613d8);
                            HashMap hashMap3 = D9.c;
                            b.setLayoutParams(C2779n9.a(c2613d8, viewGroup));
                            a(b, c2613d8);
                            viewGroup.addView(b);
                        }
                    }
                } else if (Intrinsics.areEqual("WEBVIEW", c2613d8.c)) {
                    Intrinsics.checkNotNull(c2613d8, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeWebViewAsset");
                    F9 f9 = (F9) c2613d8;
                    if (f9.z && (view = this.o) != null) {
                        ViewParent parent = view.getParent();
                        ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(view);
                        }
                        this.o = null;
                        if (view == null) {
                            Context context3 = (Context) this.i.get();
                            view = context3 != null ? this.m.a(context3, c2613d8, this.f2262a) : null;
                        }
                        if (view != null) {
                            final WeakReference weakReference = new WeakReference(view);
                            if (c2613d8.n != -1) {
                                view.setVisibility(4);
                                this.h.postDelayed(new Runnable() { // from class: com.inmobi.media.D8$$ExternalSyntheticLambda1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        D8.b(weakReference);
                                    }
                                }, c2613d8.n * 1000);
                            } else if (c2613d8.o != -1) {
                                this.h.postDelayed(new Runnable() { // from class: com.inmobi.media.D8$$ExternalSyntheticLambda2
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        D8.a(weakReference);
                                    }
                                }, c2613d8.o * 1000);
                            }
                            HashMap hashMap4 = D9.c;
                            view.setLayoutParams(C2779n9.a(c2613d8, viewGroup));
                            a(view, c2613d8);
                            viewGroup.addView(view);
                            if (Intrinsics.areEqual("VIDEO", c2613d8.c)) {
                                Intrinsics.checkNotNull(c2613d8, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeVideoAsset");
                                C2597c9 c2597c9 = (C2597c9) c2613d8;
                                C2747l9 videoView = ((C2763m9) view).getVideoView();
                                C2681h8 c2681h83 = c2597c9.r;
                                if (!(c2681h83 instanceof C2681h8)) {
                                    c2681h83 = null;
                                }
                                long currentTimeMillis = System.currentTimeMillis();
                                if (c2681h83 != null) {
                                    long j = c2681h83.y;
                                    if (0 == j) {
                                        j = currentTimeMillis;
                                    }
                                    c2681h83.y = j;
                                }
                                videoView.setClickable(z2);
                                videoView.setId(Integer.MAX_VALUE);
                                videoView.a(c2597c9);
                                C2613d8 c2613d82 = c2597c9.w;
                                if (c2613d82 instanceof C2597c9) {
                                    c2597c9.a((C2597c9) c2613d82);
                                }
                                videoView.setQuartileCompletedListener(new C2974z8(this, c2597c9));
                                videoView.setPlaybackEventListener(new A8(this, c2597c9));
                                videoView.setMediaErrorListener(new B8(this, c2597c9));
                                T7 t72 = this.b;
                                if (!t72.t && (t72 instanceof C2562a9)) {
                                    try {
                                        ((C2562a9) t72).b(c2597c9, videoView);
                                    } catch (Exception e2) {
                                        InterfaceC2971z5 interfaceC2971z52 = this.f;
                                        if (interfaceC2971z52 != null) {
                                            String str2 = this.g;
                                            str = "TAG";
                                            ((A5) interfaceC2971z52).b(str2, rf.a(e2, H6.a(str2, str, "SDK encountered unexpected error in handling the onVideoViewCreated event; ")));
                                        }
                                    }
                                }
                                str = "TAG";
                            } else {
                                str = "TAG";
                            }
                            b(view, c2613d8);
                            if (Intrinsics.areEqual("TIMER", c2613d8.c)) {
                                view.setTag("timerView");
                                if ((c2613d8 instanceof Q8) && (view instanceof T8)) {
                                    ((T8) view).setTimerEventsListener(new C8(this, (Q8) c2613d8));
                                }
                            }
                            if (Intrinsics.areEqual("VIDEO", c2613d8.c)) {
                                C2763m9 c2763m9 = view instanceof C2763m9 ? (C2763m9) view : null;
                                if (c2763m9 != null) {
                                    Object tag = c2763m9.getVideoView().getTag();
                                    C2597c9 c2597c92 = tag instanceof C2597c9 ? (C2597c9) tag : null;
                                    if (c2597c92 != null) {
                                        try {
                                            Ve d = c2597c92.d();
                                            String b2 = d != null ? ((Ue) d).b() : null;
                                            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                                            mediaMetadataRetriever.setDataSource(b2);
                                            String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                                            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                                            ?? parseInt = extractMetadata != null ? Integer.parseInt(extractMetadata) : z2;
                                            ?? parseInt2 = extractMetadata2 != null ? Integer.parseInt(extractMetadata2) : z2;
                                            mediaMetadataRetriever.release();
                                            Point point = c2597c92.d.f2560a;
                                            HashMap hashMap5 = D9.c;
                                            i = i5;
                                            try {
                                                obj = "WEBVIEW";
                                                double d2 = (double) parseInt;
                                                double d3 = (double) parseInt2;
                                                if (C2779n9.a(point.x) / C2779n9.a(point.y) > d2 / d3) {
                                                    try {
                                                        a2 = ((C2779n9.a(point.y) * 1.0d) / d3) * d2;
                                                        a3 = C2779n9.a(point.y);
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        Intrinsics.checkNotNullExpressionValue(c2763m9.f2640a, str);
                                                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                                                        S5 s52 = S5.f2425a;
                                                        S5.d.a(AbstractC2920w5.a(e, "event"));
                                                        layoutParams = layoutParams2;
                                                        layoutParams.addRule(13);
                                                        c2763m9.getVideoView().setLayoutParams(layoutParams);
                                                        if (!Intrinsics.areEqual(obj, c2613d8.c)) {
                                                        }
                                                        i4 = i;
                                                        z2 = false;
                                                    }
                                                } else {
                                                    a2 = C2779n9.a(point.x);
                                                    a3 = ((C2779n9.a(point.x) * 1.0d) / d2) * d3;
                                                }
                                                layoutParams = new RelativeLayout.LayoutParams((int) a2, (int) a3);
                                            } catch (Exception e4) {
                                                e = e4;
                                                obj = "WEBVIEW";
                                            }
                                        } catch (Exception e5) {
                                            e = e5;
                                            obj = "WEBVIEW";
                                            i = i5;
                                        }
                                        layoutParams.addRule(13);
                                        c2763m9.getVideoView().setLayoutParams(layoutParams);
                                        if (!Intrinsics.areEqual(obj, c2613d8.c) && (view instanceof GestureDetectorOnGestureListenerC2634ec)) {
                                            gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) view;
                                            z = c2613d8 instanceof F9;
                                            if (z) {
                                                gestureDetectorOnGestureListenerC2634ec.setScrollable(((F9) c2613d8).x);
                                            }
                                            gestureDetectorOnGestureListenerC2634ec.setReferenceContainer(this.b.v);
                                            T7 t73 = this.b;
                                            s7 = t73.L;
                                            if (s7 == null) {
                                                s7 = new S7(t73);
                                                t73.L = s7;
                                            }
                                            gestureDetectorOnGestureListenerC2634ec.setRenderViewEventListener(s7);
                                            gestureDetectorOnGestureListenerC2634ec.setPlacementId(this.b.e);
                                            gestureDetectorOnGestureListenerC2634ec.setAllowAutoRedirection(this.b.f);
                                            gestureDetectorOnGestureListenerC2634ec.setCreativeId(this.b.getCreativeId());
                                            gestureDetectorOnGestureListenerC2634ec.setImpressionId(this.b.getImpressionId());
                                            if (z && ((F9) c2613d8).z) {
                                                t7 = this.b;
                                                interfaceC2971z5 = t7.j;
                                                if (interfaceC2971z5 != null) {
                                                    String str3 = t7.m;
                                                    Intrinsics.checkNotNullExpressionValue(str3, str);
                                                    ((A5) interfaceC2971z5).c(str3, "setHTMLTrackedView");
                                                }
                                                if (t7.K == 0 && t7.I == null && t7.H == null) {
                                                    t7.I = gestureDetectorOnGestureListenerC2634ec;
                                                }
                                            }
                                        }
                                        i4 = i;
                                        z2 = false;
                                    }
                                }
                            }
                            obj = "WEBVIEW";
                            i = i5;
                            if (!Intrinsics.areEqual(obj, c2613d8.c)) {
                                gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) view;
                                z = c2613d8 instanceof F9;
                                if (z) {
                                }
                                gestureDetectorOnGestureListenerC2634ec.setReferenceContainer(this.b.v);
                                T7 t732 = this.b;
                                s7 = t732.L;
                                if (s7 == null) {
                                }
                                gestureDetectorOnGestureListenerC2634ec.setRenderViewEventListener(s7);
                                gestureDetectorOnGestureListenerC2634ec.setPlacementId(this.b.e);
                                gestureDetectorOnGestureListenerC2634ec.setAllowAutoRedirection(this.b.f);
                                gestureDetectorOnGestureListenerC2634ec.setCreativeId(this.b.getCreativeId());
                                gestureDetectorOnGestureListenerC2634ec.setImpressionId(this.b.getImpressionId());
                                if (z) {
                                    t7 = this.b;
                                    interfaceC2971z5 = t7.j;
                                    if (interfaceC2971z5 != null) {
                                    }
                                    if (t7.K == 0) {
                                        t7.I = gestureDetectorOnGestureListenerC2634ec;
                                    }
                                }
                            }
                            i4 = i;
                            z2 = false;
                        }
                    }
                } else {
                    if (Intrinsics.areEqual("IMAGE", c2613d8.c)) {
                    }
                    view = null;
                    if (view == null) {
                    }
                    if (view != null) {
                    }
                }
                i = i5;
                i4 = i;
                z2 = false;
            } catch (IndexOutOfBoundsException e6) {
                throw new NoSuchElementException(e6.getMessage());
            }
        }
        return viewGroup;
    }

    public final J8 a(J8 j8, final ViewGroup parent, GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.o = gestureDetectorOnGestureListenerC2634ec;
        final J8 a2 = a(j8, parent);
        this.h.post(new Runnable() { // from class: com.inmobi.media.D8$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                D8.a(D8.this, a2, parent);
            }
        });
        return a2;
    }

    public static final void a(D8 this$0, J8 container, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(parent, "$parent");
        if (this$0.n) {
            return;
        }
        C2681h8 root = this$0.c.e;
        if (container == null || root == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(root, "root");
        this$0.b((ViewGroup) container, root);
    }

    public final J8 a(J8 j8, ViewGroup viewGroup) {
        J8 viewGroup2;
        C2681h8 c2681h8 = this.c.e;
        if (j8 == null) {
            Context context = (Context) this.i.get();
            if (context != null && c2681h8 != null) {
                View a2 = this.m.a(context, c2681h8, this.f2262a);
                if (a2 instanceof J8) {
                    viewGroup2 = (J8) a2;
                }
            }
            viewGroup2 = null;
        } else {
            viewGroup2 = j8;
        }
        if (viewGroup2 != null && j8 != null) {
            ViewParent parent = viewGroup2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(viewGroup2);
            }
            D9 d9 = this.m;
            d9.getClass();
            Intrinsics.checkNotNullParameter(viewGroup2, "viewGroup");
            int childCount = viewGroup2.getChildCount();
            while (true) {
                childCount--;
                if (-1 >= childCount) {
                    break;
                }
                View childAt = viewGroup2.getChildAt(childCount);
                viewGroup2.removeViewAt(childCount);
                Intrinsics.checkNotNull(childAt);
                d9.a(childAt);
            }
            if (c2681h8 != null) {
                HashMap hashMap = D9.c;
                C2779n9.a(viewGroup2, c2681h8.d);
            }
        }
        if (c2681h8 != null) {
            D9 d92 = this.m;
            int i = c2681h8.d.f2560a.x;
            d92.getClass();
            D9.g = i;
        }
        if (viewGroup2 != null && c2681h8 != null) {
            HashMap hashMap2 = D9.c;
            viewGroup2.setLayoutParams(C2779n9.a(c2681h8, viewGroup));
        }
        return viewGroup2;
    }

    public static final void b(WeakReference childViewRef) {
        Intrinsics.checkNotNullParameter(childViewRef, "$childViewRef");
        View view = (View) childViewRef.get();
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public final void a(View view, C2613d8 nativeAsset) {
        C2572b1 c2572b1 = this.l;
        c2572b1.getClass();
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(nativeAsset, "nativeAsset");
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        try {
            HashMap hashMap = D9.c;
            float a2 = C2779n9.a(nativeAsset.d.c.x);
            float a3 = C2779n9.a(nativeAsset.d.d.x);
            if (a2 != a3) {
                arrayList.add(C2572b1.a(C2572b1.a(view, a2, a3), nativeAsset));
            }
            float a4 = C2779n9.a(nativeAsset.d.c.y);
            float a5 = C2779n9.a(nativeAsset.d.d.y);
            if (a4 != a5) {
                arrayList.add(C2572b1.a(C2572b1.b(view, a4, a5), nativeAsset));
            }
            float a6 = C2779n9.a(nativeAsset.d.f2560a.x);
            float a7 = C2779n9.a(nativeAsset.d.b.x);
            if (a6 != a7) {
                view.setPivotX(0.0f);
                view.setPivotY(0.0f);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", a7 / a6);
                Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(...)");
                arrayList.add(C2572b1.a(ofFloat, nativeAsset));
            }
            float a8 = C2779n9.a(nativeAsset.d.f2560a.y);
            float a9 = C2779n9.a(nativeAsset.d.b.y);
            if (a8 != a9) {
                view.setPivotX(0.0f);
                view.setPivotY(0.0f);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", a9 / a8);
                Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(...)");
                arrayList.add(C2572b1.a(ofFloat2, nativeAsset));
            }
        } catch (Exception unused) {
            String TAG = c2572b1.f2523a;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        Intrinsics.checkNotNullParameter("creativeView", "eventType");
        Iterator it = nativeAsset.s.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (Intrinsics.areEqual("creativeView", ((U8) it.next()).b)) {
                break;
            }
        }
        if (arrayList != null || z) {
            view.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC2958y8(this, arrayList, nativeAsset));
        }
    }

    public static final void a(WeakReference childViewRef) {
        Intrinsics.checkNotNullParameter(childViewRef, "$childViewRef");
        View view = (View) childViewRef.get();
        if (view != null) {
            view.setVisibility(4);
        }
    }

    public static final void a(D8 this$0, C2613d8 asset, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(asset, "$asset");
        C2907v8 c2907v8 = this$0.e;
        Intrinsics.checkNotNull(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(asset, "asset");
        C2939x8 c2939x8 = c2907v8.f2733a;
        if (c2939x8.f2752a) {
            return;
        }
        c2939x8.b.a(view, asset);
        c2907v8.f2733a.b.a(asset, false);
    }
}
