package com.bytedance.sdk.openadsdk.component.reward.view;

import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

/* loaded from: classes3.dex */
public class eli extends SnapHelper {
    private OrientationHelper DbA;
    private RecyclerView Os;
    private OrientationHelper eli;

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        View findSnapView = findSnapView(layoutManager);
        int i3 = -1;
        if (findSnapView == null) {
            return -1;
        }
        int position = layoutManager.getPosition(findSnapView);
        if (layoutManager.canScrollVertically()) {
            i3 = i2 < 0 ? position - 1 : position + 1;
        }
        return Math.min(layoutManager.getItemCount() - 1, Math.max(i3, 0));
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        this.Os = recyclerView;
        super.attachToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1) {
            return null;
        }
        OrientationHelper eli = eli(layoutManager);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = linearLayoutManager.getChildAt(i2);
            int abs = Math.abs(eli.getDecoratedStart(childAt));
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = {0, 0};
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = eli(view, DbA(layoutManager));
            return iArr;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = eli(view, eli(layoutManager));
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new LinearSmoothScroller(this.Os.getContext()) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.eli.1
                @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
                protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                    eli eliVar = eli.this;
                    int[] calculateDistanceToFinalSnap = eliVar.calculateDistanceToFinalSnap(eliVar.Os.getLayoutManager(), view);
                    int i = calculateDistanceToFinalSnap[0];
                    int i2 = calculateDistanceToFinalSnap[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                    if (calculateTimeForDeceleration > 0) {
                        action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                protected int calculateTimeForScrolling(int i) {
                    return Math.min(100, super.calculateTimeForScrolling(i));
                }
            };
        }
        return null;
    }

    private int eli(View view, OrientationHelper orientationHelper) {
        int decoratedStart = orientationHelper.getDecoratedStart(view);
        return decoratedStart >= orientationHelper.getStartAfterPadding() / 2 ? decoratedStart - orientationHelper.getStartAfterPadding() : decoratedStart;
    }

    private OrientationHelper eli(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.eli;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.eli = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.eli;
    }

    private OrientationHelper DbA(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.DbA;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.DbA = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.DbA;
    }
}
