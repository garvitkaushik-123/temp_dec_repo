package com.inmobi.media;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public final class I {

    /* renamed from: a, reason: collision with root package name */
    public final GestureDetectorOnGestureListenerC2634ec f2309a;
    public final Set b;
    public final long c;
    public final Sb d;
    public final InterfaceC2971z5 e;
    public final Context f;
    public B g;
    public A4 h;
    public final ScheduledThreadPoolExecutor i;
    public final AtomicBoolean j;
    public ScheduledFuture k;
    public Df l;
    public final H m;

    public I(GestureDetectorOnGestureListenerC2634ec adView, Set set, long j, Sb listener, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f2309a = adView;
        this.b = set;
        this.c = j;
        this.d = listener;
        this.e = interfaceC2971z5;
        this.f = adView.getContext();
        this.i = (ScheduledThreadPoolExecutor) AbstractC2970z4.c.getValue();
        this.j = new AtomicBoolean(false);
        this.m = new H(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02f2 A[Catch: all -> 0x0374, TryCatch #0 {, blocks: (B:114:0x01bc, B:119:0x01c5, B:121:0x01cd, B:123:0x01d6, B:125:0x01e8, B:128:0x01f2, B:129:0x022c, B:131:0x0232, B:133:0x024d, B:136:0x0273, B:141:0x028d, B:142:0x0294, B:145:0x0369, B:148:0x02f2, B:149:0x0301, B:151:0x0307, B:153:0x035b, B:155:0x0257, B:156:0x025c, B:158:0x0262), top: B:112:0x01ba }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(I i) {
        C c;
        float f;
        float f2;
        ArrayList arrayList;
        A4 a4;
        Pair pair;
        RectF rectF;
        RectF rectF2;
        RectF rectF3;
        RectF rectF4;
        i.getClass();
        Rect rect = new Rect();
        if (i.f2309a.getRootView() != null && i.f2309a.getVisibility() == 0 && Uc.m() && i.f2309a.getGlobalVisibleRect(rect)) {
            Context context = i.f;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Intrinsics.checkNotNullParameter(context, "<this>");
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                pair = new Pair(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
            } catch (Exception unused) {
                pair = new Pair(0, 0);
            }
            int intValue = ((Number) pair.component1()).intValue();
            int intValue2 = ((Number) pair.component2()).intValue();
            Rect rect2 = new Rect();
            if (i.f2309a.getLocalVisibleRect(rect2) && !rect2.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                View rootView = i.f2309a.getRootView();
                Set set = i.b;
                if (set == null) {
                    set = SetsKt.emptySet();
                }
                if (rootView instanceof ViewGroup) {
                    ArrayList arrayList3 = new ArrayList();
                    ArrayDeque arrayDeque = new ArrayDeque();
                    arrayDeque.push(rootView);
                    boolean z = false;
                    while (!arrayDeque.isEmpty()) {
                        View view = (View) arrayDeque.pop();
                        if (view.getVisibility() == 0) {
                            if (Intrinsics.areEqual(view, i.f2309a)) {
                                z = true;
                            } else if (!set.contains(view)) {
                                Rect rect3 = new Rect();
                                if (view.getLocalVisibleRect(rect3) && !rect3.isEmpty()) {
                                    Rect rect4 = new Rect();
                                    boolean globalVisibleRect = view.getGlobalVisibleRect(rect4);
                                    if (Intrinsics.areEqual(view, i.f2309a) || (globalVisibleRect && rect4.intersect(rect))) {
                                        boolean z2 = !L3.f2348a.H() || view.getZ() >= i.f2309a.getZ();
                                        if (z && z2) {
                                            arrayList3.add(rect4);
                                        }
                                        if (view instanceof ViewGroup) {
                                            ViewGroup viewGroup = (ViewGroup) view;
                                            for (int childCount = viewGroup.getChildCount() - 1; -1 < childCount; childCount--) {
                                                arrayDeque.push(viewGroup.getChildAt(childCount));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    B b = i.g;
                    if (b != null && (rectF4 = b.b) != null) {
                        a(rect, arrayList3, rectF4);
                    }
                    B b2 = i.g;
                    if (b2 != null && (rectF3 = b2.b) != null) {
                        a(rect, arrayList3, rectF3);
                    }
                    B b3 = i.g;
                    if (b3 != null && (rectF2 = b3.c) != null) {
                        a(rect, arrayList3, rectF2);
                    }
                    B b4 = i.g;
                    if (b4 != null && (rectF = b4.d) != null) {
                        a(rect, arrayList3, rectF);
                    }
                    if (arrayList3.size() == 1) {
                        arrayList2.add(new RectF((Rect) arrayList3.get(0)));
                    } else {
                        Region region = new Region();
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            region.op((Rect) it.next(), Region.Op.UNION);
                        }
                        RegionIterator regionIterator = new RegionIterator(region);
                        Rect rect5 = new Rect();
                        while (regionIterator.next(rect5)) {
                            arrayList2.add(new RectF(rect5));
                        }
                    }
                }
                c = new C(new RectF(rect2), arrayList2, intValue, intValue2);
                synchronized (i) {
                    if (c == null) {
                        a4 = new A4(0.0f, null, null);
                    } else {
                        RectF rectF5 = c.f2248a;
                        if (rectF5.isEmpty()) {
                            a4 = new A4(0.0f, null, null);
                        } else {
                            float measuredHeight = i.f2309a.getMeasuredHeight() * i.f2309a.getMeasuredWidth();
                            if (measuredHeight <= 0.0f) {
                                a4 = new A4(0.0f, null, null);
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                i.f2309a.getLocationInWindow(new int[2]);
                                Pair pair2 = new Pair(Float.valueOf(r10[0]), Float.valueOf(r10[1]));
                                float floatValue = ((Number) pair2.component1()).floatValue();
                                float floatValue2 = ((Number) pair2.component2()).floatValue();
                                Iterator it2 = c.b.iterator();
                                while (it2.hasNext()) {
                                    RectF rectF6 = (RectF) it2.next();
                                    arrayList4.add(new RectF(rectF6.left - floatValue, rectF6.top - floatValue2, rectF6.right - floatValue, rectF6.bottom - floatValue2));
                                }
                                ArrayList arrayList5 = c.b;
                                if (arrayList5.isEmpty()) {
                                    f = 0.0f;
                                } else {
                                    Iterator it3 = arrayList5.iterator();
                                    f = 0.0f;
                                    while (it3.hasNext()) {
                                        RectF rectF7 = (RectF) it3.next();
                                        f += rectF7.height() * rectF7.width();
                                    }
                                }
                                float min = Math.min(f, measuredHeight);
                                RectF rectF8 = new RectF(rectF5);
                                float width = rectF8.width();
                                float height = rectF8.height();
                                if (width > 0.0f && height > 0.0f) {
                                    f2 = Math.max(0.0f, width * height);
                                    float a2 = B2.a(Math.min((Math.max(0.0f, f2 - min) / measuredHeight) * 100.0f, 100.0f));
                                    B4 b42 = new B4(Math.max(0.0f, B2.a(rectF5.left / U3.b())), Math.max(0.0f, B2.a(rectF5.top / U3.b())), Math.max(0, B2.b(rectF5.width() / U3.b())), Math.max(0, B2.b(rectF5.height() / U3.b())));
                                    if (arrayList4.isEmpty()) {
                                        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
                                        Iterator it4 = arrayList4.iterator();
                                        while (it4.hasNext()) {
                                            RectF rectF9 = (RectF) it4.next();
                                            arrayList6.add(new B4(Math.max(0.0f, B2.a(rectF9.left / U3.b())), Math.max(0.0f, B2.a(rectF9.top / U3.b())), Math.max(0, B2.b(rectF9.width() / U3.b())), Math.max(0, B2.b(B2.b(rectF9.height()) / U3.b()))));
                                        }
                                        arrayList = new ArrayList(CollectionsKt.sortedWith(arrayList6, new D()));
                                    } else {
                                        arrayList = null;
                                    }
                                    a4 = new A4(a2, b42, arrayList);
                                }
                                f2 = 0.0f;
                                float a22 = B2.a(Math.min((Math.max(0.0f, f2 - min) / measuredHeight) * 100.0f, 100.0f));
                                B4 b422 = new B4(Math.max(0.0f, B2.a(rectF5.left / U3.b())), Math.max(0.0f, B2.a(rectF5.top / U3.b())), Math.max(0, B2.b(rectF5.width() / U3.b())), Math.max(0, B2.b(rectF5.height() / U3.b())));
                                if (arrayList4.isEmpty()) {
                                }
                                a4 = new A4(a22, b422, arrayList);
                            }
                        }
                    }
                }
                i.a(a4);
                return;
            }
        }
        c = null;
        synchronized (i) {
        }
    }

    public final void a(A4 metrics) {
        if (Intrinsics.areEqual(metrics, this.h)) {
            return;
        }
        Sb sb = this.d;
        sb.getClass();
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = sb.f2429a;
        StringBuilder append = new StringBuilder("window.mraidview.broadcastEvent('exposureChange', ").append(metrics.f2230a).append(", ");
        B4 b4 = metrics.b;
        Object obj = "null";
        StringBuilder append2 = append.append(b4 != null ? C4.a(b4) : "null").append(", ");
        ArrayList arrayList = metrics.c;
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(C4.a((B4) it.next()));
            }
            obj = new JSONArray((Collection) arrayList2);
        }
        gestureDetectorOnGestureListenerC2634ec.c(append2.append(obj).append(");").toString());
        this.h = metrics;
    }

    public static final void a(Rect rect, ArrayList arrayList, RectF rectF) {
        if (rectF.intersect(new RectF(rect))) {
            arrayList.add(new Rect(B2.b(rectF.left), B2.b(rectF.top), B2.b(rectF.right), B2.b(rectF.bottom)));
        }
    }
}
