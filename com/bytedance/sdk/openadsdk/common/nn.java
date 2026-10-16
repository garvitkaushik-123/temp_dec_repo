package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes3.dex */
public class nn extends View {
    private View DbA;
    private final eli eli;

    public interface eli {
        View eli(Context context);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public nn(Context context, eli eliVar) {
        super(context);
        this.eli = eliVar;
        eli();
    }

    private void eli() {
        setVisibility(8);
        setWillNotDraw(true);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        View view = this.DbA;
        if (view != null) {
            view.setVisibility(i);
            return;
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            DbA();
        }
    }

    private View DbA() {
        eli eliVar;
        if (this.DbA == null && (eliVar = this.eli) != null) {
            this.DbA = eliVar.eli(getContext());
            eli(this.DbA, (ViewGroup) getParent());
        }
        return this.DbA;
    }

    private void eli(View view, ViewGroup viewGroup) {
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }
}
