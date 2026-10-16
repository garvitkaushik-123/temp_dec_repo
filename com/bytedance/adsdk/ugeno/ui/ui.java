package com.bytedance.adsdk.ugeno.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.kb.kb;
import com.bytedance.adsdk.ugeno.ui.aGH;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ui extends ViewGroup implements com.bytedance.adsdk.ugeno.ui.eli {
    private int DbA;
    private aGH Dfc;
    private int FC;
    private int MGA;
    private int[] NU;
    private int Os;
    private int aAs;
    private int aGH;
    private List<Os> aqO;
    private com.bytedance.adsdk.ugeno.aGH dV;
    private int du;
    private int eli;
    private Drawable kb;
    private aGH.eli nGm;
    private int nlS;
    private SparseIntArray nn;
    private int ui;
    private Drawable wC;

    @Override // com.bytedance.adsdk.ugeno.ui.eli
    public int eli(View view) {
        return 0;
    }

    public ui(Context context) {
        super(context, null);
        this.MGA = -1;
        this.Dfc = new aGH(this);
        this.aqO = new ArrayList();
        this.nGm = new aGH.eli();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.aGH agh = this.dV;
        if (agh != null) {
            int[] eli2 = agh.eli(i, i2);
            eli(eli2[0], eli2[1]);
        } else {
            eli(i, i2);
        }
        com.bytedance.adsdk.ugeno.aGH agh2 = this.dV;
        if (agh2 != null) {
            agh2.ui();
        }
    }

    private void eli(int i, int i2) {
        if (this.nn == null) {
            this.nn = new SparseIntArray(getChildCount());
        }
        if (this.Dfc.DbA(this.nn)) {
            this.NU = this.Dfc.eli(this.nn);
        }
        int i3 = this.eli;
        if (i3 == 0 || i3 == 1) {
            DbA(i, i2);
        } else {
            if (i3 == 2 || i3 == 3) {
                Os(i, i2);
                return;
            }
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.eli);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ui.eli
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.bytedance.adsdk.ugeno.ui.eli
    public View eli(int i) {
        return getChildAt(i);
    }

    public View Os(int i) {
        if (i < 0) {
            return null;
        }
        int[] iArr = this.NU;
        if (i >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }

    @Override // com.bytedance.adsdk.ugeno.ui.eli
    public View DbA(int i) {
        return Os(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.nn == null) {
            this.nn = new SparseIntArray(getChildCount());
        }
        this.NU = this.Dfc.eli(view, i, layoutParams, this.nn);
        super.addView(view, i, layoutParams);
    }

    private void DbA(int i, int i2) {
        this.aqO.clear();
        this.nGm.eli();
        this.Dfc.eli(this.nGm, i, i2);
        this.aqO = this.nGm.eli;
        this.Dfc.eli(i, i2);
        if (this.aGH == 3) {
            for (Os os : this.aqO) {
                int i3 = Integer.MIN_VALUE;
                for (int i4 = 0; i4 < os.wC; i4++) {
                    View Os = Os(os.Dfc + i4);
                    if (Os != null && Os.getVisibility() != 8) {
                        eli eliVar = (eli) Os.getLayoutParams();
                        if (this.DbA != 2) {
                            i3 = Math.max(i3, Os.getMeasuredHeight() + Math.max(os.nlS - Os.getBaseline(), eliVar.topMargin) + eliVar.bottomMargin);
                        } else {
                            i3 = Math.max(i3, Os.getMeasuredHeight() + eliVar.topMargin + Math.max((os.nlS - Os.getMeasuredHeight()) + Os.getBaseline(), eliVar.bottomMargin));
                        }
                    }
                }
                os.kb = i3;
            }
        }
        this.Dfc.DbA(i, i2, getPaddingTop() + getPaddingBottom());
        this.Dfc.eli();
        eli(this.eli, i, i2, this.nGm.DbA);
    }

    private void Os(int i, int i2) {
        this.aqO.clear();
        this.nGm.eli();
        this.Dfc.DbA(this.nGm, i, i2);
        this.aqO = this.nGm.eli;
        this.Dfc.eli(i, i2);
        this.Dfc.DbA(i, i2, getPaddingLeft() + getPaddingRight());
        this.Dfc.eli();
        eli(this.eli, i, i2, this.nGm.DbA);
    }

    private void eli(int i, int i2, int i3, int i4) {
        int sumOfCrossSize;
        int largestMainSize;
        int resolveSizeAndState;
        int resolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (i == 0 || i == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else if (i == 2 || i == 3) {
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            } else {
                size = largestMainSize;
            }
            resolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else if (mode == 0) {
            resolveSizeAndState = View.resolveSizeAndState(largestMainSize, i2, i4);
        } else if (mode == 1073741824) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            }
            resolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else {
            throw new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(mode)));
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else if (mode2 == 0) {
            resolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i3, i4);
        } else if (mode2 == 1073741824) {
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else {
            throw new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(mode2)));
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    @Override // com.bytedance.adsdk.ugeno.ui.eli
    public int getLargestMainSize() {
        Iterator<Os> it = this.aqO.iterator();
        int i = Integer.MIN_VALUE;
        while (it.hasNext()) {
            i = Math.max(i, it.next().ui);
        }
        return i;
    }

    @Override // com.bytedance.adsdk.ugeno.ui.eli
    public int getSumOfCrossSize() {
        int i;
        int i2;
        int size = this.aqO.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Os os = this.aqO.get(i4);
            if (aGH(i4)) {
                if (eli()) {
                    i2 = this.du;
                } else {
                    i2 = this.nlS;
                }
                i3 += i2;
            }
            if (MGA(i4)) {
                if (eli()) {
                    i = this.du;
                } else {
                    i = this.nlS;
                }
                i3 += i;
            }
            i3 += os.kb;
        }
        return i3;
    }

    @Override // com.bytedance.adsdk.ugeno.ui.eli
    public boolean eli() {
        int i = this.eli;
        return i == 0 || i == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        ui uiVar;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z3;
        ui uiVar2;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z4;
        com.bytedance.adsdk.ugeno.aGH agh = this.dV;
        if (agh != null) {
            agh.MGA();
        }
        int eli2 = kb.eli(this);
        int i13 = this.eli;
        if (i13 == 0) {
            if (eli2 == 1) {
                z2 = true;
                uiVar = this;
                i5 = i;
                i8 = i2;
                i7 = i4;
                i6 = i3;
            } else {
                z2 = false;
                uiVar = this;
                i5 = i;
                i6 = i3;
                i7 = i4;
                i8 = i2;
            }
            uiVar.eli(z2, i5, i8, i6, i7);
        } else if (i13 == 1) {
            if (eli2 != 1) {
                z3 = true;
                uiVar2 = this;
                i9 = i;
                i12 = i2;
                i11 = i4;
                i10 = i3;
            } else {
                z3 = false;
                uiVar2 = this;
                i9 = i;
                i10 = i3;
                i11 = i4;
                i12 = i2;
            }
            uiVar2.eli(z3, i9, i12, i10, i11);
        } else if (i13 == 2) {
            z4 = eli2 == 1;
            if (this.DbA == 2) {
                z4 = !z4;
            }
            eli(z4, false, i, i2, i3, i4);
        } else if (i13 == 3) {
            z4 = eli2 == 1;
            if (this.DbA == 2) {
                z4 = !z4;
            }
            eli(z4, true, i, i2, i3, i4);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.eli);
        }
        com.bytedance.adsdk.ugeno.aGH agh2 = this.dV;
        if (agh2 != null) {
            agh2.eli(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void eli(boolean z, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        float f2;
        float f3;
        int i6;
        boolean z2;
        int i7;
        int i8;
        int i9;
        int i10;
        View view;
        Os os;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i11 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.aqO.size();
        for (int i12 = 0; i12 < size; i12++) {
            Os os2 = this.aqO.get(i12);
            if (aGH(i12)) {
                int i13 = this.du;
                paddingBottom -= i13;
                paddingTop += i13;
            }
            int i14 = paddingBottom;
            int i15 = this.Os;
            char c = 4;
            int i16 = 2;
            boolean z3 = true;
            if (i15 == 0) {
                f = paddingLeft;
                i5 = i11 - paddingRight;
            } else if (i15 == 1) {
                f = (i11 - os2.ui) + paddingRight;
                i5 = os2.ui - paddingLeft;
            } else if (i15 == 2) {
                f = paddingLeft + ((i11 - os2.ui) / 2.0f);
                f2 = (i11 - paddingRight) - ((i11 - os2.ui) / 2.0f);
                f3 = 0.0f;
                float max = Math.max(f3, 0.0f);
                i6 = 0;
                while (i6 < os2.wC) {
                }
                paddingTop += os2.kb;
                paddingBottom = i14 - os2.kb;
            } else {
                if (i15 == 3) {
                    f = paddingLeft;
                    f3 = (i11 - os2.ui) / (os2.DbA() != 1 ? r7 - 1 : 1.0f);
                    f2 = i11 - paddingRight;
                } else if (i15 == 4) {
                    int DbA = os2.DbA();
                    float f4 = DbA != 0 ? (i11 - os2.ui) / DbA : 0.0f;
                    float f5 = f4 / 2.0f;
                    f = paddingLeft + f5;
                    float f6 = (i11 - paddingRight) - f5;
                    f3 = f4;
                    f2 = f6;
                } else if (i15 == 5) {
                    f3 = os2.DbA() != 0 ? (i11 - os2.ui) / (r3 + 1) : 0.0f;
                    f = paddingLeft + f3;
                    f2 = (i11 - paddingRight) - f3;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.Os);
                }
                float max2 = Math.max(f3, 0.0f);
                i6 = 0;
                while (i6 < os2.wC) {
                    int i17 = os2.Dfc + i6;
                    View Os = Os(i17);
                    char c2 = c;
                    if (Os != null) {
                        boolean z4 = z3;
                        if (Os.getVisibility() != 8) {
                            eli eliVar = (eli) Os.getLayoutParams();
                            float f7 = f + eliVar.leftMargin;
                            float f8 = f2 - eliVar.rightMargin;
                            if (aGH(i17, i6)) {
                                int i18 = this.nlS;
                                float f9 = i18;
                                f7 += f9;
                                f8 -= f9;
                                i10 = i18;
                            } else {
                                i10 = 0;
                            }
                            float f10 = f8;
                            int i19 = (i6 != os2.wC + (-1) || (this.aAs & 4) <= 0) ? 0 : this.nlS;
                            if (this.DbA == i16) {
                                if (z) {
                                    i7 = i16;
                                    i8 = i6;
                                    view = Os;
                                    z2 = z4;
                                    this.Dfc.eli(view, os2, Math.round(f10) - Os.getMeasuredWidth(), i14 - Os.getMeasuredHeight(), Math.round(f10), i14);
                                } else {
                                    i8 = i6;
                                    view = Os;
                                    z2 = z4;
                                    i7 = i16;
                                    this.Dfc.eli(view, os2, Math.round(f7), i14 - view.getMeasuredHeight(), Math.round(f7) + view.getMeasuredWidth(), i14);
                                }
                                i9 = i14;
                            } else {
                                i8 = i6;
                                view = Os;
                                z2 = z4;
                                i7 = i16;
                                i9 = i14;
                                if (z) {
                                    this.Dfc.eli(view, os2, Math.round(f10) - view.getMeasuredWidth(), paddingTop, Math.round(f10), paddingTop + view.getMeasuredHeight());
                                } else {
                                    int i20 = paddingTop;
                                    this.Dfc.eli(view, os2, Math.round(f7), i20, view.getMeasuredWidth() + Math.round(f7), i20 + view.getMeasuredHeight());
                                    paddingTop = i20;
                                }
                            }
                            f = f7 + view.getMeasuredWidth() + max2 + eliVar.rightMargin;
                            float measuredWidth = f10 - ((view.getMeasuredWidth() + max2) + eliVar.leftMargin);
                            if (z) {
                                os = os2;
                                os.eli(view, i19, 0, i10, 0);
                            } else {
                                os = os2;
                                os.eli(view, i10, 0, i19, 0);
                            }
                            os2 = os;
                            f2 = measuredWidth;
                            i6 = i8 + 1;
                            c = c2;
                            i16 = i7;
                            z3 = z2;
                            i14 = i9;
                        } else {
                            z2 = z4;
                        }
                    } else {
                        z2 = z3;
                    }
                    i7 = i16;
                    i8 = i6;
                    i9 = i14;
                    i6 = i8 + 1;
                    c = c2;
                    i16 = i7;
                    z3 = z2;
                    i14 = i9;
                }
                paddingTop += os2.kb;
                paddingBottom = i14 - os2.kb;
            }
            f2 = i5;
            f3 = 0.0f;
            float max22 = Math.max(f3, 0.0f);
            i6 = 0;
            while (i6 < os2.wC) {
            }
            paddingTop += os2.kb;
            paddingBottom = i14 - os2.kb;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void eli(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        float f2;
        float f3;
        int i6;
        char c;
        int i7;
        int i8;
        int i9;
        int i10;
        Os os;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i11 = i4 - i2;
        int i12 = (i3 - i) - paddingRight;
        int size = this.aqO.size();
        for (int i13 = 0; i13 < size; i13++) {
            Os os2 = this.aqO.get(i13);
            if (aGH(i13)) {
                int i14 = this.nlS;
                paddingLeft += i14;
                i12 -= i14;
            }
            int i15 = i12;
            int i16 = this.Os;
            char c2 = 4;
            int i17 = 1;
            if (i16 == 0) {
                f = paddingTop;
                i5 = i11 - paddingBottom;
            } else if (i16 == 1) {
                f = (i11 - os2.ui) + paddingBottom;
                i5 = os2.ui - paddingTop;
            } else if (i16 == 2) {
                f = paddingTop + ((i11 - os2.ui) / 2.0f);
                f2 = (i11 - paddingBottom) - ((i11 - os2.ui) / 2.0f);
                f3 = 0.0f;
                float max = Math.max(f3, 0.0f);
                i6 = 0;
                while (i6 < os2.wC) {
                }
                paddingLeft += os2.kb;
                i12 = i15 - os2.kb;
            } else {
                if (i16 == 3) {
                    f = paddingTop;
                    f3 = (i11 - os2.ui) / (os2.DbA() != 1 ? r13 - 1 : 1.0f);
                    f2 = i11 - paddingBottom;
                } else if (i16 == 4) {
                    int DbA = os2.DbA();
                    f3 = DbA != 0 ? (i11 - os2.ui) / DbA : 0.0f;
                    float f4 = f3 / 2.0f;
                    f = paddingTop + f4;
                    f2 = (i11 - paddingBottom) - f4;
                } else if (i16 == 5) {
                    f3 = os2.DbA() != 0 ? (i11 - os2.ui) / (r5 + 1) : 0.0f;
                    f = paddingTop + f3;
                    f2 = (i11 - paddingBottom) - f3;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.Os);
                }
                float max2 = Math.max(f3, 0.0f);
                i6 = 0;
                while (i6 < os2.wC) {
                    int i18 = os2.Dfc + i6;
                    int i19 = i17;
                    View Os = Os(i18);
                    if (Os != null) {
                        c = c2;
                        if (Os.getVisibility() != 8) {
                            eli eliVar = (eli) Os.getLayoutParams();
                            float f5 = f + eliVar.topMargin;
                            float f6 = f2 - eliVar.bottomMargin;
                            if (aGH(i18, i6)) {
                                i10 = this.du;
                                float f7 = i10;
                                f5 += f7;
                                f6 -= f7;
                            } else {
                                i10 = 0;
                            }
                            float f8 = f6;
                            int i20 = (i6 != os2.wC - i19 || (this.FC & 4) <= 0) ? 0 : this.du;
                            if (z) {
                                if (z2) {
                                    i8 = i19;
                                    i7 = i6;
                                    this.Dfc.eli(Os, os2, true, i15 - Os.getMeasuredWidth(), Math.round(f8) - Os.getMeasuredHeight(), i15, Math.round(f8));
                                } else {
                                    i7 = i6;
                                    i8 = i19;
                                    this.Dfc.eli(Os, os2, true, i15 - Os.getMeasuredWidth(), Math.round(f5), i15, Math.round(f5) + Os.getMeasuredHeight());
                                }
                                i9 = i15;
                            } else {
                                i7 = i6;
                                i8 = i19;
                                i9 = i15;
                                if (z2) {
                                    this.Dfc.eli(Os, os2, false, paddingLeft, Math.round(f8) - Os.getMeasuredHeight(), paddingLeft + Os.getMeasuredWidth(), Math.round(f8));
                                } else {
                                    int i21 = paddingLeft;
                                    this.Dfc.eli(Os, os2, false, i21, Math.round(f5), i21 + Os.getMeasuredWidth(), Math.round(f5) + Os.getMeasuredHeight());
                                    paddingLeft = i21;
                                }
                            }
                            f = f5 + Os.getMeasuredHeight() + max2 + eliVar.bottomMargin;
                            float measuredHeight = f8 - ((Os.getMeasuredHeight() + max2) + eliVar.topMargin);
                            if (z2) {
                                os = os2;
                                os.eli(Os, 0, i20, 0, i10);
                            } else {
                                os = os2;
                                os.eli(Os, 0, i10, 0, i20);
                            }
                            os2 = os;
                            f2 = measuredHeight;
                            i6 = i7 + 1;
                            c2 = c;
                            i17 = i8;
                            i15 = i9;
                        }
                    } else {
                        c = c2;
                    }
                    i7 = i6;
                    i8 = i19;
                    i9 = i15;
                    i6 = i7 + 1;
                    c2 = c;
                    i17 = i8;
                    i15 = i9;
                }
                paddingLeft += os2.kb;
                i12 = i15 - os2.kb;
            }
            f2 = i5;
            f3 = 0.0f;
            float max22 = Math.max(f3, 0.0f);
            i6 = 0;
            while (i6 < os2.wC) {
            }
            paddingLeft += os2.kb;
            i12 = i15 - os2.kb;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.wC == null && this.kb == null) {
            return;
        }
        if (this.FC == 0 && this.aAs == 0) {
            return;
        }
        int eli2 = kb.eli(this);
        int i = this.eli;
        if (i == 0) {
            eli(canvas, eli2 == 1, this.DbA == 2);
            return;
        }
        if (i == 1) {
            eli(canvas, eli2 != 1, this.DbA == 2);
            return;
        }
        if (i == 2) {
            boolean z = eli2 == 1;
            if (this.DbA == 2) {
                z = !z;
            }
            DbA(canvas, z, false);
            return;
        }
        if (i != 3) {
            return;
        }
        boolean z2 = eli2 == 1;
        if (this.DbA == 2) {
            z2 = !z2;
        }
        DbA(canvas, z2, true);
    }

    private void eli(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.aqO.size();
        for (int i3 = 0; i3 < size; i3++) {
            Os os = this.aqO.get(i3);
            for (int i4 = 0; i4 < os.wC; i4++) {
                int i5 = os.Dfc + i4;
                View Os = Os(i5);
                if (Os != null && Os.getVisibility() != 8) {
                    eli eliVar = (eli) Os.getLayoutParams();
                    if (aGH(i5, i4)) {
                        if (z) {
                            left = Os.getRight() + eliVar.rightMargin;
                        } else {
                            left = (Os.getLeft() - eliVar.leftMargin) - this.nlS;
                        }
                        eli(canvas, left, os.DbA, os.kb);
                    }
                    if (i4 == os.wC - 1 && (this.aAs & 4) > 0) {
                        if (z) {
                            right = (Os.getLeft() - eliVar.leftMargin) - this.nlS;
                        } else {
                            right = Os.getRight() + eliVar.rightMargin;
                        }
                        eli(canvas, right, os.DbA, os.kb);
                    }
                }
            }
            if (aGH(i3)) {
                if (z2) {
                    i2 = os.aGH;
                } else {
                    i2 = os.DbA - this.du;
                }
                DbA(canvas, paddingLeft, i2, max);
            }
            if (MGA(i3) && (this.FC & 4) > 0) {
                if (z2) {
                    i = os.DbA - this.du;
                } else {
                    i = os.aGH;
                }
                DbA(canvas, paddingLeft, i, max);
            }
        }
    }

    private void DbA(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int bottom;
        int top;
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.aqO.size();
        for (int i3 = 0; i3 < size; i3++) {
            Os os = this.aqO.get(i3);
            for (int i4 = 0; i4 < os.wC; i4++) {
                int i5 = os.Dfc + i4;
                View Os = Os(i5);
                if (Os != null && Os.getVisibility() != 8) {
                    eli eliVar = (eli) Os.getLayoutParams();
                    if (aGH(i5, i4)) {
                        if (z2) {
                            top = Os.getBottom() + eliVar.bottomMargin;
                        } else {
                            top = (Os.getTop() - eliVar.topMargin) - this.du;
                        }
                        DbA(canvas, os.eli, top, os.kb);
                    }
                    if (i4 == os.wC - 1 && (this.FC & 4) > 0) {
                        if (z2) {
                            bottom = (Os.getTop() - eliVar.topMargin) - this.du;
                        } else {
                            bottom = Os.getBottom() + eliVar.bottomMargin;
                        }
                        DbA(canvas, os.eli, bottom, os.kb);
                    }
                }
            }
            if (aGH(i3)) {
                if (z) {
                    i2 = os.Os;
                } else {
                    i2 = os.eli - this.nlS;
                }
                eli(canvas, i2, paddingTop, max);
            }
            if (MGA(i3) && (this.aAs & 4) > 0) {
                if (z) {
                    i = os.eli - this.nlS;
                } else {
                    i = os.Os;
                }
                eli(canvas, i, paddingTop, max);
            }
        }
    }

    private void eli(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.wC;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, this.nlS + i, i3 + i2);
        this.wC.draw(canvas);
    }

    private void DbA(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.kb;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, i3 + i, this.du + i2);
        this.kb.draw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof eli;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof eli) {
            return new eli((eli) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new eli((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new eli(layoutParams);
    }

    @Override // com.bytedance.adsdk.ugeno.ui.eli
    public int getFlexDirection() {
        return this.eli;
    }

    public void setFlexDirection(int i) {
        if (this.eli != i) {
            this.eli = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ui.eli
    public int getFlexWrap() {
        return this.DbA;
    }

    public void setFlexWrap(int i) {
        if (this.DbA != i) {
            this.DbA = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.Os;
    }

    public void setJustifyContent(int i) {
        if (this.Os != i) {
            this.Os = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ui.eli
    public int getAlignItems() {
        return this.aGH;
    }

    public void setAlignItems(int i) {
        if (this.aGH != i) {
            this.aGH = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ui.eli
    public int getAlignContent() {
        return this.ui;
    }

    public void setAlignContent(int i) {
        if (this.ui != i) {
            this.ui = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ui.eli
    public int getMaxLine() {
        return this.MGA;
    }

    public void setMaxLine(int i) {
        if (this.MGA != i) {
            this.MGA = i;
            requestLayout();
        }
    }

    public List<Os> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.aqO.size());
        for (Os os : this.aqO) {
            if (os.DbA() != 0) {
                arrayList.add(os);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.ui.eli
    public int eli(View view, int i, int i2) {
        int i3;
        int i4;
        if (eli()) {
            i3 = aGH(i, i2) ? this.nlS : 0;
            if ((this.aAs & 4) <= 0) {
                return i3;
            }
            i4 = this.nlS;
        } else {
            i3 = aGH(i, i2) ? this.du : 0;
            if ((this.FC & 4) <= 0) {
                return i3;
            }
            i4 = this.du;
        }
        return i3 + i4;
    }

    @Override // com.bytedance.adsdk.ugeno.ui.eli
    public void eli(Os os) {
        if (eli()) {
            if ((this.aAs & 4) > 0) {
                os.ui += this.nlS;
                os.MGA += this.nlS;
                return;
            }
            return;
        }
        if ((this.FC & 4) > 0) {
            os.ui += this.du;
            os.MGA += this.du;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ui.eli
    public int eli(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.bytedance.adsdk.ugeno.ui.eli
    public int DbA(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.bytedance.adsdk.ugeno.ui.eli
    public void eli(View view, int i, int i2, Os os) {
        if (aGH(i, i2)) {
            if (eli()) {
                os.ui += this.nlS;
                os.MGA += this.nlS;
            } else {
                os.ui += this.du;
                os.MGA += this.du;
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ui.eli
    public void setFlexLines(List<Os> list) {
        this.aqO = list;
    }

    @Override // com.bytedance.adsdk.ugeno.ui.eli
    public List<Os> getFlexLinesInternal() {
        return this.aqO;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.kb;
    }

    public Drawable getDividerDrawableVertical() {
        return this.wC;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.kb) {
            return;
        }
        this.kb = drawable;
        if (drawable != null) {
            this.du = drawable.getIntrinsicHeight();
        } else {
            this.du = 0;
        }
        DbA();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.wC) {
            return;
        }
        this.wC = drawable;
        if (drawable != null) {
            this.nlS = drawable.getIntrinsicWidth();
        } else {
            this.nlS = 0;
        }
        DbA();
        requestLayout();
    }

    public int getShowDividerVertical() {
        return this.aAs;
    }

    public int getShowDividerHorizontal() {
        return this.FC;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.aAs) {
            this.aAs = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.FC) {
            this.FC = i;
            requestLayout();
        }
    }

    private void DbA() {
        if (this.kb == null && this.wC == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean aGH(int i, int i2) {
        return ui(i, i2) ? eli() ? (this.aAs & 1) != 0 : (this.FC & 1) != 0 : eli() ? (this.aAs & 2) != 0 : (this.FC & 2) != 0;
    }

    private boolean ui(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View Os = Os(i - i3);
            if (Os != null && Os.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean aGH(int i) {
        if (i >= 0 && i < this.aqO.size()) {
            if (ui(i)) {
                return eli() ? (this.FC & 1) != 0 : (this.aAs & 1) != 0;
            }
            if (eli()) {
                return (this.FC & 2) != 0;
            }
            if ((this.aAs & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean ui(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.aqO.get(i2).DbA() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean MGA(int i) {
        if (i >= 0 && i < this.aqO.size()) {
            for (int i2 = i + 1; i2 < this.aqO.size(); i2++) {
                if (this.aqO.get(i2).DbA() > 0) {
                    return false;
                }
            }
            if (eli()) {
                return (this.FC & 4) != 0;
            }
            if ((this.aAs & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    public static class eli extends ViewGroup.MarginLayoutParams implements DbA {
        public static final Parcelable.Creator<eli> CREATOR = new Parcelable.Creator<eli>() { // from class: com.bytedance.adsdk.ugeno.ui.ui.eli.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public eli createFromParcel(Parcel parcel) {
                return new eli(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public eli[] newArray(int i) {
                return new eli[i];
            }
        };
        private float DbA;
        private int FC;
        private int MGA;
        private float Os;
        private boolean aAs;
        private int aGH;
        private int eli;
        private int kb;
        private float ui;
        private int wC;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public eli(eli eliVar) {
            super((ViewGroup.MarginLayoutParams) eliVar);
            this.eli = 1;
            this.DbA = 0.0f;
            this.Os = 0.0f;
            this.aGH = -1;
            this.ui = -1.0f;
            this.MGA = -1;
            this.kb = -1;
            this.wC = ViewCompat.MEASURED_SIZE_MASK;
            this.FC = ViewCompat.MEASURED_SIZE_MASK;
            this.eli = eliVar.eli;
            this.DbA = eliVar.DbA;
            this.Os = eliVar.Os;
            this.aGH = eliVar.aGH;
            this.ui = eliVar.ui;
            this.MGA = eliVar.MGA;
            this.kb = eliVar.kb;
            this.wC = eliVar.wC;
            this.FC = eliVar.FC;
            this.aAs = eliVar.aAs;
        }

        public eli(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.eli = 1;
            this.DbA = 0.0f;
            this.Os = 0.0f;
            this.aGH = -1;
            this.ui = -1.0f;
            this.MGA = -1;
            this.kb = -1;
            this.wC = ViewCompat.MEASURED_SIZE_MASK;
            this.FC = ViewCompat.MEASURED_SIZE_MASK;
        }

        public eli(int i, int i2) {
            super(new ViewGroup.LayoutParams(i, i2));
            this.eli = 1;
            this.DbA = 0.0f;
            this.Os = 0.0f;
            this.aGH = -1;
            this.ui = -1.0f;
            this.MGA = -1;
            this.kb = -1;
            this.wC = ViewCompat.MEASURED_SIZE_MASK;
            this.FC = ViewCompat.MEASURED_SIZE_MASK;
        }

        public eli(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.eli = 1;
            this.DbA = 0.0f;
            this.Os = 0.0f;
            this.aGH = -1;
            this.ui = -1.0f;
            this.MGA = -1;
            this.kb = -1;
            this.wC = ViewCompat.MEASURED_SIZE_MASK;
            this.FC = ViewCompat.MEASURED_SIZE_MASK;
        }

        @Override // com.bytedance.adsdk.ugeno.ui.DbA
        public int eli() {
            return this.width;
        }

        @Override // com.bytedance.adsdk.ugeno.ui.DbA
        public int DbA() {
            return this.height;
        }

        @Override // com.bytedance.adsdk.ugeno.ui.DbA
        public int Os() {
            return this.eli;
        }

        public void Os(int i) {
            this.eli = i;
        }

        @Override // com.bytedance.adsdk.ugeno.ui.DbA
        public float aGH() {
            return this.DbA;
        }

        public void eli(float f) {
            this.DbA = f;
        }

        @Override // com.bytedance.adsdk.ugeno.ui.DbA
        public float ui() {
            return this.Os;
        }

        public void DbA(float f) {
            this.Os = f;
        }

        @Override // com.bytedance.adsdk.ugeno.ui.DbA
        public int MGA() {
            return this.aGH;
        }

        public void aGH(int i) {
            this.aGH = i;
        }

        @Override // com.bytedance.adsdk.ugeno.ui.DbA
        public int kb() {
            return this.MGA;
        }

        @Override // com.bytedance.adsdk.ugeno.ui.DbA
        public void eli(int i) {
            this.MGA = i;
        }

        @Override // com.bytedance.adsdk.ugeno.ui.DbA
        public int wC() {
            return this.kb;
        }

        @Override // com.bytedance.adsdk.ugeno.ui.DbA
        public void DbA(int i) {
            this.kb = i;
        }

        @Override // com.bytedance.adsdk.ugeno.ui.DbA
        public int FC() {
            return this.wC;
        }

        @Override // com.bytedance.adsdk.ugeno.ui.DbA
        public int aAs() {
            return this.FC;
        }

        @Override // com.bytedance.adsdk.ugeno.ui.DbA
        public boolean du() {
            return this.aAs;
        }

        @Override // com.bytedance.adsdk.ugeno.ui.DbA
        public float nlS() {
            return this.ui;
        }

        public void Os(float f) {
            this.ui = f;
        }

        @Override // com.bytedance.adsdk.ugeno.ui.DbA
        public int NU() {
            return this.leftMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.ui.DbA
        public int nn() {
            return this.topMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.ui.DbA
        public int Dfc() {
            return this.rightMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.ui.DbA
        public int aqO() {
            return this.bottomMargin;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.eli);
            parcel.writeFloat(this.DbA);
            parcel.writeFloat(this.Os);
            parcel.writeInt(this.aGH);
            parcel.writeFloat(this.ui);
            parcel.writeInt(this.MGA);
            parcel.writeInt(this.kb);
            parcel.writeInt(this.wC);
            parcel.writeInt(this.FC);
            parcel.writeByte(this.aAs ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
        }

        protected eli(Parcel parcel) {
            super(0, 0);
            this.eli = 1;
            this.DbA = 0.0f;
            this.Os = 0.0f;
            this.aGH = -1;
            this.ui = -1.0f;
            this.MGA = -1;
            this.kb = -1;
            this.wC = ViewCompat.MEASURED_SIZE_MASK;
            this.FC = ViewCompat.MEASURED_SIZE_MASK;
            this.eli = parcel.readInt();
            this.DbA = parcel.readFloat();
            this.Os = parcel.readFloat();
            this.aGH = parcel.readInt();
            this.ui = parcel.readFloat();
            this.MGA = parcel.readInt();
            this.kb = parcel.readInt();
            this.wC = parcel.readInt();
            this.FC = parcel.readInt();
            this.aAs = parcel.readByte() != 0;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }
    }

    public void eli(com.bytedance.adsdk.ugeno.DbA.Os os) {
        this.dV = os;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.aGH agh = this.dV;
        if (agh != null) {
            agh.kb();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.aGH agh = this.dV;
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
        com.bytedance.adsdk.ugeno.aGH agh = this.dV;
        if (agh != null) {
            agh.DbA(i, i2, i3, i4);
        }
    }
}
