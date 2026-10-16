package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.j8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C2714j8 extends ViewGroup {
    public C2714j8(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        Intrinsics.checkNotNullParameter(p, "p");
        return p instanceof C2697i8;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        Intrinsics.checkNotNullParameter(p, "p");
        return new C2697i8(p);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.inmobi.ads.viewsv2.NativeContainerLayout.LayoutParams");
                C2697i8 c2697i8 = (C2697i8) layoutParams;
                int i6 = c2697i8.f2598a;
                childAt.layout(i6, c2697i8.b, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + c2697i8.b);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        measureChildren(i, i2);
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.inmobi.ads.viewsv2.NativeContainerLayout.LayoutParams");
                C2697i8 c2697i8 = (C2697i8) layoutParams;
                int measuredWidth = childAt.getMeasuredWidth() + c2697i8.f2598a;
                int measuredHeight = childAt.getMeasuredHeight() + c2697i8.b;
                i4 = Math.max(i4, measuredWidth);
                i3 = Math.max(i3, measuredHeight);
            }
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }
}
