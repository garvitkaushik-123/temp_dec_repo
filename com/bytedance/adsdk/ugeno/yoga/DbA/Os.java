package com.bytedance.adsdk.ugeno.yoga.DbA;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.aGH;
import com.bytedance.adsdk.ugeno.eli.kb;
import com.bytedance.adsdk.ugeno.eli.wC;
import com.bytedance.adsdk.ugeno.yoga.FC;
import com.bytedance.adsdk.ugeno.yoga.MGA;
import com.bytedance.adsdk.ugeno.yoga.NU;
import com.bytedance.adsdk.ugeno.yoga.aAs;
import com.bytedance.adsdk.ugeno.yoga.du;
import com.bytedance.adsdk.ugeno.yoga.nn;
import com.bytedance.adsdk.ugeno.yoga.ui;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class Os extends ViewGroup implements com.bytedance.adsdk.ugeno.DbA.DbA, kb {
    private final aAs DbA;
    private aGH Os;
    private wC aGH;
    private final Map<View, aAs> eli;

    public Os(Context context) {
        this(context, null, 0);
    }

    public Os(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGH = new wC(this);
        aAs eli2 = du.eli();
        this.DbA = eli2;
        this.eli = new HashMap();
        eli2.eli(this);
        eli2.eli((com.bytedance.adsdk.ugeno.yoga.kb) new DbA());
        eli((eli) generateDefaultLayoutParams(), eli2, this);
    }

    public aAs getYogaNode() {
        return this.DbA;
    }

    public aAs eli(View view) {
        return this.eli.get(view);
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.DbA
    public void eli(int i) {
        aAs aas = this.DbA;
        if (aas != null) {
            eli(aas, i);
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.DbA
    public void DbA(int i) {
        aAs aas = this.DbA;
        if (aas != null) {
            DbA(aas, i);
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.DbA
    public void eli(View view, int i) {
        aAs eli2;
        if (view == null || (eli2 = eli(view)) == null) {
            return;
        }
        eli(eli2, i);
        view.requestLayout();
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.DbA
    public void DbA(View view, int i) {
        aAs eli2;
        if (view == null || (eli2 = eli(view)) == null) {
            return;
        }
        DbA(eli2, i);
        view.requestLayout();
    }

    private void eli(aAs aas, int i) {
        if (i == -1) {
            aas.ui(100.0f);
        } else if (i == -2) {
            aas.aGH();
        } else {
            aas.aGH(i);
        }
    }

    private void DbA(aAs aas, int i) {
        if (i == -1) {
            aas.kb(100.0f);
        } else if (i == -2) {
            aas.ui();
        } else {
            aas.MGA(i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.DbA
    public void Os(View view, int i) {
        aGH(view, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        aAs eli2;
        this.DbA.eli((com.bytedance.adsdk.ugeno.yoga.kb) null);
        if (view instanceof com.bytedance.adsdk.ugeno.yoga.DbA.DbA) {
            throw null;
        }
        super.addView(view, i, layoutParams);
        if (this.eli.containsKey(view)) {
            return;
        }
        if (view instanceof Os) {
            eli2 = ((Os) view).getYogaNode();
        } else {
            if (this.eli.containsKey(view)) {
                eli2 = this.eli.get(view);
            } else {
                eli2 = du.eli();
            }
            eli2.eli(view);
            eli2.eli((com.bytedance.adsdk.ugeno.yoga.kb) new DbA());
        }
        eli((eli) view.getLayoutParams(), eli2, view);
        this.eli.put(view, eli2);
        if (view.getVisibility() == 8) {
            view.setTag(151060224, Integer.valueOf(this.DbA.eli()));
        } else {
            aAs aas = this.DbA;
            aas.eli(eli2, aas.eli());
        }
    }

    public void aGH(View view, int i) {
        int eli2;
        view.setVisibility(i);
        try {
            aAs aas = this.eli.get(view);
            Object tag = view.getTag(151060224);
            if (i != 0) {
                if (i != 8 || (eli2 = this.DbA.eli(aas)) == -1) {
                    return;
                }
                this.DbA.DbA(eli2);
                view.setTag(151060224, Integer.valueOf(eli2));
                eli(this.DbA);
                return;
            }
            if (tag == null || this.DbA.eli(aas) != -1) {
                return;
            }
            int intValue = ((Integer) tag).intValue();
            if (intValue < this.DbA.eli()) {
                this.DbA.eli(this.eli.get(view), intValue);
            } else {
                this.DbA.eli(this.eli.get(view), this.DbA.eli());
            }
            eli(this.DbA);
        } catch (Throwable unused) {
        }
    }

    private void eli(aAs aas) {
        if (aas.DbA() != null) {
            eli(aas.DbA());
        } else {
            aas.eli(Float.NaN, Float.NaN);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        eli(view, false);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        eli(getChildAt(i), false);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        eli(view, true);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            eli(getChildAt(i3), false);
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            eli(getChildAt(i3), true);
        }
        super.removeViewsInLayout(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            eli(getChildAt(i), false);
        }
        super.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            eli(getChildAt(i), true);
        }
        super.removeAllViewsInLayout();
    }

    private void eli(View view, boolean z) {
        aAs aas = this.eli.get(view);
        if (aas == null) {
            return;
        }
        aAs DbA2 = aas.DbA();
        int i = 0;
        while (true) {
            if (i >= DbA2.eli()) {
                break;
            }
            if (DbA2.eli(i).equals(aas)) {
                DbA2.DbA(i);
                break;
            }
            i++;
        }
        aas.eli((Object) null);
        this.eli.remove(view);
        if (z) {
            this.DbA.eli(Float.NaN, Float.NaN);
        }
    }

    private void eli(aAs aas, float f, float f2) {
        View view = (View) aas.aAs();
        if (view != null && view != this) {
            if (view.getVisibility() == 8) {
                return;
            }
            int round = Math.round(aas.MGA() + f);
            int round2 = Math.round(aas.kb() + f2);
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(aas.wC()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(aas.FC()), 1073741824));
            view.layout(round, round2, view.getMeasuredWidth() + round, view.getMeasuredHeight() + round2);
        }
        int eli2 = aas.eli();
        for (int i = 0; i < eli2; i++) {
            if (equals(view)) {
                eli(aas.eli(i), f, f2);
            } else if (!(view instanceof Os)) {
                eli(aas.eli(i), aas.MGA() + f, aas.kb() + f2);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aGH agh = this.Os;
        if (agh != null) {
            agh.eli(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        aGH agh = this.Os;
        if (agh != null) {
            agh.DbA(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        aGH agh = this.Os;
        if (agh != null) {
            agh.MGA();
        }
        if (!(getParent() instanceof Os)) {
            eli(View.MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824));
        }
        eli(this.DbA, 0.0f, 0.0f);
        aGH agh2 = this.Os;
        if (agh2 != null) {
            agh2.eli(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (!(getParent() instanceof Os)) {
            eli(i, i2);
        }
        aGH agh = this.Os;
        if (agh != null) {
            int[] eli2 = agh.eli(i, i2);
            setMeasuredDimension(eli2[0], eli2[1]);
        } else {
            setMeasuredDimension(Math.round(this.DbA.wC()), Math.round(this.DbA.FC()));
        }
        aGH agh2 = this.Os;
        if (agh2 != null) {
            agh2.ui();
        }
    }

    private void eli(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == 1073741824) {
            this.DbA.MGA(size2);
        }
        if (mode == 1073741824) {
            this.DbA.aGH(size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.DbA.du(size2);
        }
        if (mode == Integer.MIN_VALUE) {
            this.DbA.aAs(size);
        }
        this.DbA.eli(Float.NaN, Float.NaN);
    }

    protected static void eli(eli eliVar, aAs aas, View view) {
        if (view.getResources().getConfiguration().getLayoutDirection() == 1) {
            aas.eli(com.bytedance.adsdk.ugeno.yoga.Os.RTL);
        }
        Drawable background = view.getBackground();
        if (background != null) {
            if (background.getPadding(new Rect())) {
                aas.DbA(com.bytedance.adsdk.ugeno.yoga.aGH.LEFT, r0.left);
                aas.DbA(com.bytedance.adsdk.ugeno.yoga.aGH.TOP, r0.top);
                aas.DbA(com.bytedance.adsdk.ugeno.yoga.aGH.RIGHT, r0.right);
                aas.DbA(com.bytedance.adsdk.ugeno.yoga.aGH.BOTTOM, r0.bottom);
            }
        }
        for (int i = 0; i < eliVar.eli.size(); i++) {
            int keyAt = eliVar.eli.keyAt(i);
            float floatValue = eliVar.eli.valueAt(i).floatValue();
            if (keyAt == 4) {
                aas.Os(com.bytedance.adsdk.ugeno.yoga.eli.eli(Math.round(floatValue)));
            } else if (keyAt == 0) {
                aas.eli(com.bytedance.adsdk.ugeno.yoga.eli.eli(Math.round(floatValue)));
            } else if (keyAt == 9) {
                aas.DbA(com.bytedance.adsdk.ugeno.yoga.eli.eli(Math.round(floatValue)));
            } else if (keyAt == 25) {
                aas.nlS(floatValue);
            } else if (keyAt == 8) {
                if (floatValue < 0.0f) {
                    aas.Os();
                } else {
                    aas.Os(floatValue);
                }
            } else if (keyAt == 1) {
                aas.eli(ui.eli(Math.round(floatValue)));
            } else if (keyAt == 6) {
                aas.eli(floatValue);
            } else if (keyAt == 7) {
                aas.DbA(floatValue);
            } else if (keyAt == 16) {
                if (floatValue == -1.0f) {
                    aas.kb(100.0f);
                } else if (floatValue == -2.0f) {
                    aas.ui();
                } else {
                    aas.MGA(floatValue);
                }
            } else if (keyAt == 18) {
                aas.eli(com.bytedance.adsdk.ugeno.yoga.aGH.LEFT, floatValue);
            } else if (keyAt == 3) {
                aas.eli(MGA.eli(Math.round(floatValue)));
            } else if (keyAt == 17) {
                aas.eli(com.bytedance.adsdk.ugeno.yoga.aGH.TOP, floatValue);
            } else if (keyAt == 20) {
                aas.eli(com.bytedance.adsdk.ugeno.yoga.aGH.RIGHT, floatValue);
            } else if (keyAt == 19) {
                aas.eli(com.bytedance.adsdk.ugeno.yoga.aGH.BOTTOM, floatValue);
            } else if (keyAt == 28) {
                aas.FC(floatValue);
            } else if (keyAt == 27) {
                aas.wC(floatValue);
            } else if (keyAt == 22) {
                aas.DbA(com.bytedance.adsdk.ugeno.yoga.aGH.LEFT, floatValue);
            } else if (keyAt == 21) {
                aas.DbA(com.bytedance.adsdk.ugeno.yoga.aGH.TOP, floatValue);
            } else if (keyAt == 24) {
                aas.DbA(com.bytedance.adsdk.ugeno.yoga.aGH.RIGHT, floatValue);
            } else if (keyAt == 23) {
                aas.DbA(com.bytedance.adsdk.ugeno.yoga.aGH.BOTTOM, floatValue);
            } else if (keyAt == 11) {
                aas.Os(com.bytedance.adsdk.ugeno.yoga.aGH.LEFT, floatValue);
            } else if (keyAt == 10) {
                aas.Os(com.bytedance.adsdk.ugeno.yoga.aGH.TOP, floatValue);
            } else if (keyAt == 13) {
                aas.Os(com.bytedance.adsdk.ugeno.yoga.aGH.RIGHT, floatValue);
            } else if (keyAt == 12) {
                aas.Os(com.bytedance.adsdk.ugeno.yoga.aGH.BOTTOM, floatValue);
            } else if (keyAt == 14) {
                aas.eli(NU.eli(Math.round(floatValue)));
            } else if (keyAt == 15) {
                if (floatValue == -1.0f) {
                    aas.ui(100.0f);
                } else if (floatValue == -2.0f) {
                    aas.aGH();
                } else {
                    aas.aGH(floatValue);
                }
            } else if (keyAt == 2) {
                aas.eli(nn.eli(Math.round(floatValue)));
            }
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new eli(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new eli(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof eli;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aGH agh = this.Os;
        if (agh != null) {
            agh.kb();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aGH agh = this.Os;
        if (agh != null) {
            agh.wC();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        aGH agh = this.Os;
        if (agh != null) {
            agh.DbA(i, i2, i3, i4);
        }
    }

    public void eli(com.bytedance.adsdk.ugeno.DbA.Os os) {
        this.Os = os;
    }

    public void setBorderRadius(float f) {
        this.aGH.eli(f);
    }

    public float getBorderRadius() {
        return this.aGH.eli();
    }

    public void setRipple(float f) {
        wC wCVar = this.aGH;
        if (wCVar != null) {
            wCVar.DbA(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.kb
    public float getRipple() {
        return this.aGH.getRipple();
    }

    public void setShine(float f) {
        wC wCVar = this.aGH;
        if (wCVar != null) {
            wCVar.Os(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.kb
    public float getShine() {
        return this.aGH.getShine();
    }

    public void setStretch(float f) {
        wC wCVar = this.aGH;
        if (wCVar != null) {
            wCVar.aGH(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.kb
    public float getStretch() {
        return this.aGH.getStretch();
    }

    public void setRubIn(float f) {
        wC wCVar = this.aGH;
        if (wCVar != null) {
            wCVar.ui(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.kb
    public float getRubIn() {
        return this.aGH.getRubIn();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.aGH.eli(i);
    }

    public static class eli extends ViewGroup.LayoutParams {
        SparseArray<String> DbA;
        private float Dfc;
        private float FC;
        private float MGA;
        private float NU;
        private float Os;
        private float QX;
        private float aAs;
        private float aGH;
        private float aqO;
        private float dV;
        private float du;
        SparseArray<Float> eli;
        private float kb;
        private float nGm;
        private float nlS;
        private float nn;
        private float ui;
        private float wC;

        public eli(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof eli) {
                eli eliVar = (eli) layoutParams;
                this.eli = eliVar.eli.clone();
                this.DbA = eliVar.DbA.clone();
                return;
            }
            this.eli = new SparseArray<>();
            this.DbA = new SparseArray<>();
            if (layoutParams.width >= 0) {
                this.eli.put(15, Float.valueOf(this.width));
            }
            if (layoutParams.height >= 0) {
                this.eli.put(16, Float.valueOf(this.height));
            }
        }

        public eli(int i, int i2) {
            super(i, i2);
            this.eli = new SparseArray<>();
            this.DbA = new SparseArray<>();
            if (i == -2 || i == -1 || i >= 0) {
                this.eli.put(15, Float.valueOf(i));
            }
            if (i2 == -2 || i2 == -1 || i2 >= 0) {
                this.eli.put(16, Float.valueOf(i2));
            }
        }

        public void eli(float f) {
            this.kb = f;
            this.eli.put(5, Float.valueOf(f));
        }

        public void DbA(float f) {
            this.wC = f;
            this.eli.put(6, Float.valueOf(f));
        }

        public void Os(float f) {
            this.FC = f;
            this.eli.put(7, Float.valueOf(f));
        }

        public void aGH(float f) {
            this.aAs = f;
            this.eli.put(8, Float.valueOf(f));
        }

        public void ui(float f) {
            this.du = f;
            this.eli.put(9, Float.valueOf(f));
        }

        public void MGA(float f) {
            this.nlS = f;
            this.eli.put(14, Float.valueOf(f));
        }

        public void kb(float f) {
            this.NU = f;
            this.eli.put(10, Float.valueOf(f));
        }

        public void wC(float f) {
            this.nn = f;
            this.eli.put(11, Float.valueOf(f));
        }

        public void FC(float f) {
            this.Dfc = f;
            this.eli.put(12, Float.valueOf(f));
        }

        public void aAs(float f) {
            this.aqO = f;
            this.eli.put(13, Float.valueOf(f));
        }

        public void du(float f) {
            this.Os = f;
            this.eli.put(17, Float.valueOf(f));
        }

        public void nlS(float f) {
            this.aGH = f;
            this.eli.put(18, Float.valueOf(f));
        }

        public void NU(float f) {
            this.ui = f;
            this.eli.put(19, Float.valueOf(f));
        }

        public void nn(float f) {
            this.MGA = f;
            this.eli.put(20, Float.valueOf(f));
        }

        public void Dfc(float f) {
            this.dV = f;
            this.eli.put(25, Float.valueOf(f));
        }

        public void aqO(float f) {
            this.nGm = f;
            this.eli.put(27, Float.valueOf(f));
        }

        public void dV(float f) {
            this.QX = f;
            this.eli.put(28, Float.valueOf(f));
        }
    }

    public static class DbA implements com.bytedance.adsdk.ugeno.yoga.kb {
        @Override // com.bytedance.adsdk.ugeno.yoga.kb
        public long eli(aAs aas, float f, com.bytedance.adsdk.ugeno.yoga.wC wCVar, float f2, com.bytedance.adsdk.ugeno.yoga.wC wCVar2) {
            View view = (View) aas.aAs();
            if (view == null || (view instanceof Os)) {
                return FC.eli(0, 0);
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((int) f, eli(wCVar)), View.MeasureSpec.makeMeasureSpec((int) f2, eli(wCVar2)));
            return FC.eli(view.getMeasuredWidth(), view.getMeasuredHeight());
        }

        private int eli(com.bytedance.adsdk.ugeno.yoga.wC wCVar) {
            if (wCVar == com.bytedance.adsdk.ugeno.yoga.wC.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            return wCVar == com.bytedance.adsdk.ugeno.yoga.wC.EXACTLY ? 1073741824 : 0;
        }
    }
}
