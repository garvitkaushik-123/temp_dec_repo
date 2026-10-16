package com.inmobi.media;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class gf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f2583a;
    public final ArrayList b;
    public final ArrayList c;
    public final WeakReference d;

    public gf(lf visibilityTracker, AtomicBoolean isPaused) {
        Intrinsics.checkNotNullParameter(visibilityTracker, "visibilityTracker");
        Intrinsics.checkNotNullParameter(isPaused, "isPaused");
        this.f2583a = isPaused;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new WeakReference(visibilityTracker);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f2583a.get()) {
            return;
        }
        lf lfVar = (lf) this.d.get();
        if (lfVar != null) {
            lfVar.m = false;
            for (Map.Entry entry : lfVar.f2635a.entrySet()) {
                View view = (View) entry.getKey();
                Cif cif = (Cif) entry.getValue();
                int i = cif.f2603a;
                View view2 = cif.c;
                Object obj = cif.d;
                byte b = lfVar.d;
                boolean z = true;
                if (b == 1) {
                    ff ffVar = lfVar.b;
                    if (ffVar.a(view2, view, i, obj) && ffVar.a(view, view, i)) {
                        this.b.add(view);
                    } else {
                        this.c.add(view);
                    }
                } else if (b == 2) {
                    ff ffVar2 = lfVar.b;
                    Intrinsics.checkNotNull(ffVar2, "null cannot be cast to non-null type com.inmobi.ads.viewability.inmobi.HtmlPollingVisibilityTracker.HtmlVisibilityChecker");
                    P4 p4 = (P4) ((W4) ffVar2);
                    boolean a2 = p4.a(view2, view, i, obj);
                    boolean a3 = p4.a(view, view, i);
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (view instanceof GestureDetectorOnGestureListenerC2634ec) {
                        Rect rect = new Rect();
                        if (view.getGlobalVisibleRect(rect)) {
                            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) view;
                            int[] iArr = new int[2];
                            gestureDetectorOnGestureListenerC2634ec.getLocationInWindow(iArr);
                            int[] viewableFrameArray = gestureDetectorOnGestureListenerC2634ec.getViewableFrameArray();
                            int i2 = iArr[0] + (viewableFrameArray != null ? viewableFrameArray[0] : 0);
                            int i3 = iArr[1] + (viewableFrameArray != null ? viewableFrameArray[1] : 0);
                            if (rect.intersect(new Rect(i2, i3, i2 + (viewableFrameArray != null ? viewableFrameArray[2] : 0), (viewableFrameArray != null ? viewableFrameArray[3] : 0) + i3))) {
                                Bitmap createBitmap = Bitmap.createBitmap(gestureDetectorOnGestureListenerC2634ec.getWidth(), gestureDetectorOnGestureListenerC2634ec.getHeight(), Bitmap.Config.ARGB_8888);
                                Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
                                Canvas canvas = new Canvas(createBitmap);
                                canvas.drawBitmap(createBitmap, 0.0f, 0.0f, new Paint());
                                gestureDetectorOnGestureListenerC2634ec.draw(canvas);
                                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, B2.b(gestureDetectorOnGestureListenerC2634ec.getWidth() / U3.b()), B2.b(gestureDetectorOnGestureListenerC2634ec.getHeight() / U3.b()), true);
                                Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(...)");
                                int[] viewableFrameArray2 = gestureDetectorOnGestureListenerC2634ec.getViewableFrameArray();
                                int min = Math.min(createScaledBitmap.getWidth(), viewableFrameArray2 != null ? viewableFrameArray2[0] : 0);
                                int min2 = Math.min(createScaledBitmap.getHeight(), viewableFrameArray2 != null ? viewableFrameArray2[1] : 0);
                                int min3 = Math.min(viewableFrameArray2 != null ? viewableFrameArray2[2] : 0, createScaledBitmap.getWidth() - min);
                                int min4 = Math.min(viewableFrameArray2 != null ? viewableFrameArray2[3] : 0, createScaledBitmap.getHeight() - min2);
                                Bitmap createBitmap2 = (min3 <= 0 || min4 <= 0) ? null : Bitmap.createBitmap(createScaledBitmap, min, min2, min3, min4);
                                if (createBitmap2 != null) {
                                    int height = createBitmap2.getHeight() * createBitmap2.getWidth();
                                    int[] iArr2 = new int[height];
                                    createBitmap2.getPixels(iArr2, 0, createBitmap2.getWidth(), 0, 0, createBitmap2.getWidth(), createBitmap2.getHeight());
                                    int i4 = 0;
                                    for (int i5 = 0; i5 < height; i5++) {
                                        int i6 = iArr2[i5];
                                        if (i6 > -16777216 && i6 < 0 && (i4 = i4 + 1) >= gestureDetectorOnGestureListenerC2634ec.getMinimumPixelsPainted()) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    z = false;
                    if (a2 && a3 && z) {
                        this.b.add(view);
                    } else {
                        this.c.add(view);
                    }
                } else {
                    ff ffVar3 = lfVar.b;
                    if (ffVar3.a(view2, view, i, obj) && ffVar3.a(view, view, i)) {
                        this.b.add(view);
                    } else {
                        this.c.add(view);
                    }
                }
            }
        }
        hf hfVar = lfVar != null ? lfVar.j : null;
        if (hfVar != null) {
            hfVar.a(this.b, this.c);
        }
        this.b.clear();
        this.c.clear();
        if (lfVar != null) {
            lfVar.d();
        }
    }
}
