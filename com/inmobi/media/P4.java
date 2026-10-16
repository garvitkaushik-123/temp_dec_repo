package com.inmobi.media;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class P4 implements W4 {

    /* renamed from: a, reason: collision with root package name */
    public long f2394a;

    @Override // com.inmobi.media.ff
    public final boolean a(View view, View view2, int i, Object obj) {
        if (view2 != null && view2.getVisibility() == 0) {
            if ((view != null ? view.getParent() : null) != null && view2.isShown()) {
                GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = view2 instanceof GestureDetectorOnGestureListenerC2634ec ? (GestureDetectorOnGestureListenerC2634ec) view2 : null;
                if (gestureDetectorOnGestureListenerC2634ec == null) {
                    return false;
                }
                if (gestureDetectorOnGestureListenerC2634ec.getPlacementType() != 1 && (gestureDetectorOnGestureListenerC2634ec.getHeight() <= 0 || gestureDetectorOnGestureListenerC2634ec.getWidth() <= 0)) {
                    return false;
                }
                if (!gestureDetectorOnGestureListenerC2634ec.getGlobalVisibleRect(new Rect())) {
                    return false;
                }
                this.f2394a = r8.height() * r8.width();
                if (gestureDetectorOnGestureListenerC2634ec.getPlacementType() == 1) {
                    gestureDetectorOnGestureListenerC2634ec.setConfiguredArea(gestureDetectorOnGestureListenerC2634ec.getHeight() * gestureDetectorOnGestureListenerC2634ec.getWidth());
                }
                if (gestureDetectorOnGestureListenerC2634ec.getArea() > 0) {
                    if (100 * this.f2394a >= gestureDetectorOnGestureListenerC2634ec.getConfiguredArea() * i) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ea, code lost:
    
        if (((android.graphics.drawable.ColorDrawable) r4).getColor() == 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f5, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x010c, code lost:
    
        if (((android.graphics.drawable.ColorDrawable) r9).getColor() == 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0117, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x011b, code lost:
    
        if (r9 != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0115, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0113, code lost:
    
        if (r9.getForeground() == null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f3, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f1, code lost:
    
        if (r9.getBackground() == null) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0123 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0126 A[SYNTHETIC] */
    @Override // com.inmobi.media.ff
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(View rootView, View adView, int i) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(adView, "adView");
        ViewParent parent = rootView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        boolean z3 = viewGroup == null || a(viewGroup, adView, i);
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int indexOfChild = viewGroup.indexOfChild(rootView) + 1; indexOfChild < childCount; indexOfChild++) {
                View childAt = viewGroup.getChildAt(indexOfChild);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                if (childAt.getVisibility() == 0) {
                    if (adView instanceof GestureDetectorOnGestureListenerC2634ec) {
                        if (!(childAt instanceof C2922w7)) {
                            if (!(childAt instanceof C2750lc)) {
                                Map<View, FriendlyObstructionPurpose> friendlyViews = ((GestureDetectorOnGestureListenerC2634ec) adView).getFriendlyViews();
                                if (!(friendlyViews != null ? friendlyViews.containsKey(childAt) : false)) {
                                    Rect rect = new Rect();
                                    adView.getGlobalVisibleRect(rect);
                                    Rect rect2 = new Rect();
                                    childAt.getGlobalVisibleRect(rect2);
                                    Rect rect3 = new Rect();
                                    boolean intersect = rect3.setIntersect(rect, rect2);
                                    Intrinsics.checkNotNullParameter(rect, "<this>");
                                    int i2 = (rect.bottom - rect.top) * (rect.right - rect.left);
                                    Intrinsics.checkNotNullParameter(rect3, "<this>");
                                    int i3 = i2 - ((rect3.bottom - rect3.top) * (rect3.right - rect3.left));
                                    float configuredArea = (i / 100) * r10.getConfiguredArea();
                                    if (intersect && i3 < configuredArea) {
                                        if (childAt.getAlpha() > 0.3f) {
                                            if (!(childAt instanceof ImageView) || ((ImageView) childAt).getDrawable() == null) {
                                                if (childAt.getBackground() instanceof ColorDrawable) {
                                                    Drawable background = childAt.getBackground();
                                                    Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
                                                }
                                                if (childAt.getForeground() instanceof ColorDrawable) {
                                                    Drawable foreground = childAt.getForeground();
                                                    Intrinsics.checkNotNull(foreground, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
                                                }
                                                if (z2) {
                                                }
                                            }
                                            z = false;
                                            if (z) {
                                                return false;
                                            }
                                        }
                                        z = true;
                                        if (z) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return z3;
    }
}
