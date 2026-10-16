package io.bidmachine.rendering.internal.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import io.bidmachine.rendering.internal.InterfaceC3590c;
import io.bidmachine.rendering.model.ElementLayoutParams;
import io.bidmachine.rendering.model.SideBindParams;
import io.bidmachine.rendering.model.SideType;
import java.util.List;

/* loaded from: classes8.dex */
public class e extends RelativeLayout {

    public static class a extends RelativeLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        private final int f7108a;
        private final int b;
        private float c;
        private float d;

        public a(int width, int height) {
            super(width, height);
            this.c = 1.0f;
            this.d = 1.0f;
            this.f7108a = width;
            this.b = height;
        }

        public void a(float heightPercent) {
            this.d = heightPercent;
        }

        public void b(float widthPercent) {
            this.c = widthPercent;
        }

        private void b(SideBindParams topSideBindParams, SideBindParams bottomSideBindParams, List<InterfaceC3590c> adFormList) {
            a(topSideBindParams, SideType.Top, 6, 3, 10, adFormList);
            a(bottomSideBindParams, SideType.Bottom, 8, 2, 12, adFormList);
        }

        public void a(Context context, ElementLayoutParams elementLayoutParams, List<InterfaceC3590c> adFormList) {
            b(elementLayoutParams.getWidthPercent());
            a(elementLayoutParams.getHeightPercent());
            setMargins(elementLayoutParams.getMarginLeftPx(context), elementLayoutParams.getMarginTopPx(context), -elementLayoutParams.getMarginRightPx(context), -elementLayoutParams.getMarginBottomPx(context));
            SideBindParams topSideBindParams = elementLayoutParams.getTopSideBindParams();
            SideBindParams bottomSideBindParams = elementLayoutParams.getBottomSideBindParams();
            if (!a(topSideBindParams, bottomSideBindParams, 15, elementLayoutParams.getWidthPx(context))) {
                b(topSideBindParams, bottomSideBindParams, adFormList);
            }
            SideBindParams leftSideBindParams = elementLayoutParams.getLeftSideBindParams();
            SideBindParams rightSideBindParams = elementLayoutParams.getRightSideBindParams();
            if (a(leftSideBindParams, rightSideBindParams, 14, elementLayoutParams.getHeightPx(context))) {
                return;
            }
            a(leftSideBindParams, rightSideBindParams, adFormList);
        }

        private boolean a(SideBindParams firstSideBindParams, SideBindParams secondSideBindParams, int centerRule, int size) {
            if (size <= 0 || firstSideBindParams == null || secondSideBindParams == null) {
                return false;
            }
            addRule(centerRule);
            return true;
        }

        private void a(SideBindParams leftSideBindParams, SideBindParams rightSideBindParams, List<InterfaceC3590c> adFormList) {
            a(leftSideBindParams, SideType.Left, 5, 1, 9, adFormList);
            a(rightSideBindParams, SideType.Right, 7, 0, 11, adFormList);
        }

        private void a(SideBindParams sideBindParams, SideType sideType, int mainRule, int elseRule, int parentRule, List<InterfaceC3590c> adFormList) {
            if (sideBindParams == null) {
                return;
            }
            View a2 = a(adFormList, sideBindParams.getTargetName());
            if (a2 != null) {
                if (sideBindParams.getTargetSideType() != sideType) {
                    mainRule = elseRule;
                }
                addRule(mainRule, a2.getId());
                return;
            }
            addRule(parentRule);
        }

        private View a(List<InterfaceC3590c> adElementList, String targetName) {
            if (TextUtils.isEmpty(targetName)) {
                return null;
            }
            for (InterfaceC3590c interfaceC3590c : adElementList) {
                if (interfaceC3590c.getAdElementParams().getName().equals(targetName)) {
                    return interfaceC3590c.j();
                }
            }
            return null;
        }
    }

    public e(Context context) {
        super(context);
    }

    void a(int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        int size = (View.MeasureSpec.getSize(parentWidthMeasureSpec) - getPaddingLeft()) - getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(parentHeightMeasureSpec) - getPaddingTop()) - getPaddingBottom();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof a) {
                a(size, size2, childAt, (a) layoutParams);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        a(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void a(int parentWidth, int parentHeight, View child, a childLayoutParams) {
        Integer a2;
        Integer a3;
        float f = childLayoutParams.c;
        if (f > 0.0f && f < 1.0f && (a3 = a(childLayoutParams.f7108a, parentWidth, child.getMeasuredWidth(), f)) != null) {
            ((RelativeLayout.LayoutParams) childLayoutParams).width = a3.intValue();
        }
        float f2 = childLayoutParams.d;
        if (f2 <= 0.0f || f2 >= 1.0f || (a2 = a(childLayoutParams.b, parentHeight, child.getMeasuredHeight(), f2)) == null) {
            return;
        }
        ((RelativeLayout.LayoutParams) childLayoutParams).height = a2.intValue();
    }

    Integer a(int initialSize, int parentMeasuredSize, int childMeasuredSize, float percent) {
        if (initialSize <= 0) {
            if (initialSize == -1) {
                initialSize = parentMeasuredSize;
            } else {
                if (initialSize != -2 || childMeasuredSize == 0) {
                    return null;
                }
                initialSize = childMeasuredSize;
            }
        }
        if (initialSize == 0) {
            return null;
        }
        return Integer.valueOf(Math.round(initialSize * percent));
    }
}
