package com.bytedance.adsdk.ugeno.ui;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
class aGH {
    static final /* synthetic */ boolean Os = true;
    long[] DbA;
    private long[] MGA;
    private final com.bytedance.adsdk.ugeno.ui.eli aGH;
    int[] eli;
    private boolean[] ui;

    int DbA(long j) {
        return (int) (j >> 32);
    }

    long DbA(int i, int i2) {
        return (i & 4294967295L) | (i2 << 32);
    }

    int eli(long j) {
        return (int) j;
    }

    aGH(com.bytedance.adsdk.ugeno.ui.eli eliVar) {
        this.aGH = eliVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    int[] eli(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.aGH.getFlexItemCount();
        List<DbA> DbA2 = DbA(flexItemCount);
        DbA dbA = new DbA();
        if (view != null && (layoutParams instanceof com.bytedance.adsdk.ugeno.ui.DbA)) {
            dbA.DbA = ((com.bytedance.adsdk.ugeno.ui.DbA) layoutParams).Os();
        } else {
            dbA.DbA = 1;
        }
        if (i == -1 || i == flexItemCount) {
            dbA.eli = flexItemCount;
        } else if (i < this.aGH.getFlexItemCount()) {
            dbA.eli = i;
            while (i < flexItemCount) {
                DbA2.get(i).eli++;
                i++;
            }
        } else {
            dbA.eli = flexItemCount;
        }
        DbA2.add(dbA);
        return eli(flexItemCount + 1, DbA2, sparseIntArray);
    }

    int[] eli(SparseIntArray sparseIntArray) {
        int flexItemCount = this.aGH.getFlexItemCount();
        return eli(flexItemCount, DbA(flexItemCount), sparseIntArray);
    }

    private List<DbA> DbA(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            com.bytedance.adsdk.ugeno.ui.DbA dbA = (com.bytedance.adsdk.ugeno.ui.DbA) this.aGH.eli(i2).getLayoutParams();
            DbA dbA2 = new DbA();
            dbA2.DbA = dbA.Os();
            dbA2.eli = i2;
            arrayList.add(dbA2);
        }
        return arrayList;
    }

    boolean DbA(SparseIntArray sparseIntArray) {
        int flexItemCount = this.aGH.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View eli2 = this.aGH.eli(i);
            if (eli2 != null && ((com.bytedance.adsdk.ugeno.ui.DbA) eli2.getLayoutParams()).Os() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    private int[] eli(int i, List<DbA> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (DbA dbA : list) {
            iArr[i2] = dbA.eli;
            sparseIntArray.append(dbA.eli, dbA.DbA);
            i2++;
        }
        return iArr;
    }

    void eli(eli eliVar, int i, int i2) {
        eli(eliVar, i, i2, Integer.MAX_VALUE, 0, -1, (List<Os>) null);
    }

    void DbA(eli eliVar, int i, int i2) {
        eli(eliVar, i2, i, Integer.MAX_VALUE, 0, -1, (List<Os>) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void eli(eli eliVar, int i, int i2, int i3, int i4, int i5, List<Os> list) {
        int i6;
        eli eliVar2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Os os;
        int i16;
        int i17;
        boolean z;
        int i18;
        boolean z2;
        int i19;
        int i20 = i;
        boolean eli2 = this.aGH.eli();
        int mode = View.MeasureSpec.getMode(i20);
        int size = View.MeasureSpec.getSize(i20);
        List<Os> arrayList = list == null ? new ArrayList() : list;
        eliVar.eli = arrayList;
        boolean z3 = i5 == -1;
        int eli3 = eli(eli2);
        int DbA2 = DbA(eli2);
        int Os2 = Os(eli2);
        int aGH = aGH(eli2);
        Os os2 = new Os();
        int i21 = i4;
        os2.Dfc = i21;
        int i22 = eli3 + DbA2;
        os2.ui = i22;
        int flexItemCount = this.aGH.getFlexItemCount();
        boolean z4 = z3;
        Os os3 = os2;
        int i23 = Integer.MIN_VALUE;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        while (true) {
            if (i21 >= flexItemCount) {
                i6 = i25;
                eliVar2 = eliVar;
                break;
            }
            View DbA3 = this.aGH.DbA(i21);
            if (DbA3 == null) {
                if (eli(i21, flexItemCount, os3)) {
                    eli(arrayList, os3, i21, i24);
                }
                i7 = i22;
            } else {
                i7 = i22;
                if (DbA3.getVisibility() == 8) {
                    os3.FC++;
                    os3.wC++;
                    if (eli(i21, flexItemCount, os3)) {
                        eli(arrayList, os3, i21, i24);
                    }
                } else {
                    if (DbA3 instanceof CompoundButton) {
                        eli((CompoundButton) DbA3);
                    }
                    com.bytedance.adsdk.ugeno.ui.DbA dbA = (com.bytedance.adsdk.ugeno.ui.DbA) DbA3.getLayoutParams();
                    int i27 = flexItemCount;
                    if (dbA.MGA() == 4) {
                        os3.nn.add(Integer.valueOf(i21));
                    }
                    int eli4 = eli(dbA, eli2);
                    if (dbA.nlS() != -1.0f && mode == 1073741824) {
                        eli4 = Math.round(size * dbA.nlS());
                    }
                    if (eli2) {
                        i9 = mode;
                        i12 = this.aGH.eli(i20, i7 + Os(dbA, true) + aGH(dbA, true), eli4);
                        i8 = size;
                        i10 = i24;
                        int DbA4 = this.aGH.DbA(i2, Os2 + aGH + ui(dbA, true) + MGA(dbA, true) + i24, DbA(dbA, true));
                        DbA3.measure(i12, DbA4);
                        eli(i21, i12, DbA4, DbA3);
                        i11 = 0;
                    } else {
                        i8 = size;
                        i9 = mode;
                        i10 = i24;
                        i11 = 0;
                        int eli5 = this.aGH.eli(i2, Os2 + aGH + ui(dbA, false) + MGA(dbA, false) + i10, DbA(dbA, false));
                        int DbA5 = this.aGH.DbA(i20, i7 + Os(dbA, false) + aGH(dbA, false), eli4);
                        DbA3.measure(eli5, DbA5);
                        eli(i21, eli5, DbA5, DbA3);
                        i12 = DbA5;
                    }
                    eli(DbA3, i21);
                    i25 = View.combineMeasuredStates(i25, DbA3.getMeasuredState());
                    int i28 = i11;
                    i13 = i21;
                    int i29 = i12;
                    Os os4 = os3;
                    int i30 = i26;
                    i14 = i7;
                    i15 = i10;
                    boolean z5 = eli2;
                    size = i8;
                    if (eli(DbA3, i9, size, os3.ui, eli(DbA3, eli2) + Os(dbA, eli2) + aGH(dbA, eli2), dbA, i13, i30, arrayList.size())) {
                        if (os4.DbA() > 0) {
                            eli(arrayList, os4, i13 > 0 ? i13 - 1 : i28, i15);
                            i19 = i15 + os4.kb;
                        } else {
                            i19 = i15;
                        }
                        if (z5) {
                            if (dbA.DbA() == -1) {
                                com.bytedance.adsdk.ugeno.ui.eli eliVar3 = this.aGH;
                                DbA3.measure(i29, eliVar3.DbA(i2, eliVar3.getPaddingTop() + this.aGH.getPaddingBottom() + dbA.nn() + dbA.aqO() + i19, dbA.DbA()));
                                eli(DbA3, i13);
                            }
                        } else if (dbA.eli() == -1) {
                            com.bytedance.adsdk.ugeno.ui.eli eliVar4 = this.aGH;
                            DbA3.measure(eliVar4.eli(i2, eliVar4.getPaddingLeft() + this.aGH.getPaddingRight() + dbA.NU() + dbA.Dfc() + i19, dbA.eli()), i29);
                            eli(DbA3, i13);
                        }
                        Os os5 = new Os();
                        os5.wC = 1;
                        os5.ui = i14;
                        os5.Dfc = i13;
                        i15 = i19;
                        i16 = i28;
                        os = os5;
                        i17 = Integer.MIN_VALUE;
                    } else {
                        os = os4;
                        os.wC++;
                        i16 = i30 + 1;
                        i17 = i23;
                    }
                    os.dV = (os.dV ? 1 : 0) | (dbA.aGH() != 0.0f ? 1 : i28);
                    os.nGm = (os.nGm ? 1 : 0) | (dbA.ui() != 0.0f ? 1 : i28);
                    int[] iArr = this.eli;
                    if (iArr != null) {
                        iArr[i13] = arrayList.size();
                    }
                    z = z5;
                    os.ui += eli(DbA3, z) + Os(dbA, z) + aGH(dbA, z);
                    os.aAs += dbA.aGH();
                    os.du += dbA.ui();
                    this.aGH.eli(DbA3, i13, i16, os);
                    int max = Math.max(i17, DbA(DbA3, z) + ui(dbA, z) + MGA(dbA, z) + this.aGH.eli(DbA3));
                    os.kb = Math.max(os.kb, max);
                    if (z) {
                        if (this.aGH.getFlexWrap() != 2) {
                            os.nlS = Math.max(os.nlS, DbA3.getBaseline() + dbA.nn());
                        } else {
                            os.nlS = Math.max(os.nlS, (DbA3.getMeasuredHeight() - DbA3.getBaseline()) + dbA.aqO());
                        }
                    }
                    i18 = i27;
                    if (eli(i13, i18, os)) {
                        eli(arrayList, os, i13, i15);
                        i15 += os.kb;
                    }
                    if (i5 != -1 && arrayList.size() > 0) {
                        if (arrayList.get(arrayList.size() - 1).aqO >= i5 && i13 >= i5 && !z4) {
                            i15 = -os.eli();
                            z2 = true;
                            if (i15 <= i3 && z2) {
                                eliVar2 = eliVar;
                                i6 = i25;
                                break;
                            }
                            i23 = max;
                            z4 = z2;
                            i26 = i16;
                            int i31 = i13 + 1;
                            eli2 = z;
                            os3 = os;
                            i22 = i14;
                            i24 = i15;
                            i20 = i;
                            flexItemCount = i18;
                            i21 = i31;
                            mode = i9;
                        }
                    }
                    z2 = z4;
                    if (i15 <= i3) {
                    }
                    i23 = max;
                    z4 = z2;
                    i26 = i16;
                    int i312 = i13 + 1;
                    eli2 = z;
                    os3 = os;
                    i22 = i14;
                    i24 = i15;
                    i20 = i;
                    flexItemCount = i18;
                    i21 = i312;
                    mode = i9;
                }
            }
            i13 = i21;
            i9 = mode;
            i18 = flexItemCount;
            i15 = i24;
            z = eli2;
            i14 = i7;
            os = os3;
            int i3122 = i13 + 1;
            eli2 = z;
            os3 = os;
            i22 = i14;
            i24 = i15;
            i20 = i;
            flexItemCount = i18;
            i21 = i3122;
            mode = i9;
        }
        eliVar2.DbA = i6;
    }

    private void eli(CompoundButton compoundButton) {
        com.bytedance.adsdk.ugeno.ui.DbA dbA = (com.bytedance.adsdk.ugeno.ui.DbA) compoundButton.getLayoutParams();
        int kb = dbA.kb();
        int wC = dbA.wC();
        Drawable eli2 = com.bytedance.adsdk.ugeno.kb.ui.eli(compoundButton);
        int minimumWidth = eli2 == null ? 0 : eli2.getMinimumWidth();
        int minimumHeight = eli2 != null ? eli2.getMinimumHeight() : 0;
        if (kb == -1) {
            kb = minimumWidth;
        }
        dbA.eli(kb);
        if (wC == -1) {
            wC = minimumHeight;
        }
        dbA.DbA(wC);
    }

    private int eli(boolean z) {
        if (z) {
            return this.aGH.getPaddingStart();
        }
        return this.aGH.getPaddingTop();
    }

    private int DbA(boolean z) {
        if (z) {
            return this.aGH.getPaddingEnd();
        }
        return this.aGH.getPaddingBottom();
    }

    private int Os(boolean z) {
        if (z) {
            return this.aGH.getPaddingTop();
        }
        return this.aGH.getPaddingStart();
    }

    private int aGH(boolean z) {
        if (z) {
            return this.aGH.getPaddingBottom();
        }
        return this.aGH.getPaddingEnd();
    }

    private int eli(View view, boolean z) {
        if (z) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private int DbA(View view, boolean z) {
        if (z) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int eli(com.bytedance.adsdk.ugeno.ui.DbA dbA, boolean z) {
        if (z) {
            return dbA.eli();
        }
        return dbA.DbA();
    }

    private int DbA(com.bytedance.adsdk.ugeno.ui.DbA dbA, boolean z) {
        if (z) {
            return dbA.DbA();
        }
        return dbA.eli();
    }

    private int Os(com.bytedance.adsdk.ugeno.ui.DbA dbA, boolean z) {
        if (z) {
            return dbA.NU();
        }
        return dbA.nn();
    }

    private int aGH(com.bytedance.adsdk.ugeno.ui.DbA dbA, boolean z) {
        if (z) {
            return dbA.Dfc();
        }
        return dbA.aqO();
    }

    private int ui(com.bytedance.adsdk.ugeno.ui.DbA dbA, boolean z) {
        if (z) {
            return dbA.nn();
        }
        return dbA.NU();
    }

    private int MGA(com.bytedance.adsdk.ugeno.ui.DbA dbA, boolean z) {
        if (z) {
            return dbA.aqO();
        }
        return dbA.Dfc();
    }

    private boolean eli(View view, int i, int i2, int i3, int i4, com.bytedance.adsdk.ugeno.ui.DbA dbA, int i5, int i6, int i7) {
        if (this.aGH.getFlexWrap() == 0) {
            return false;
        }
        if (dbA.du()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.aGH.getMaxLine();
        if (maxLine != -1 && maxLine <= i7 + 1) {
            return false;
        }
        int eli2 = this.aGH.eli(view, i5, i6);
        if (eli2 > 0) {
            i4 += eli2;
        }
        return i2 < i3 + i4;
    }

    private boolean eli(int i, int i2, Os os) {
        return i == i2 - 1 && os.DbA() != 0;
    }

    private void eli(List<Os> list, Os os, int i, int i2) {
        os.NU = i2;
        this.aGH.eli(os);
        os.aqO = i;
        list.add(os);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void eli(View view, int i) {
        boolean z;
        com.bytedance.adsdk.ugeno.ui.DbA dbA = (com.bytedance.adsdk.ugeno.ui.DbA) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z2 = true;
        if (measuredWidth < dbA.kb()) {
            measuredWidth = dbA.kb();
        } else if (measuredWidth > dbA.FC()) {
            measuredWidth = dbA.FC();
        } else {
            z = false;
            if (measuredHeight >= dbA.wC()) {
                measuredHeight = dbA.wC();
            } else if (measuredHeight > dbA.aAs()) {
                measuredHeight = dbA.aAs();
            } else {
                z2 = z;
            }
            if (z2) {
                return;
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            eli(i, makeMeasureSpec, makeMeasureSpec2, view);
            return;
        }
        z = true;
        if (measuredHeight >= dbA.wC()) {
        }
        if (z2) {
        }
    }

    void eli(int i, int i2) {
        eli(i, i2, 0);
    }

    void eli(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        int i4;
        int i5;
        Os(this.aGH.getFlexItemCount());
        if (i3 >= this.aGH.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.aGH.getFlexDirection();
        int flexDirection2 = this.aGH.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.aGH.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.aGH.getPaddingLeft();
            paddingRight = this.aGH.getPaddingRight();
        } else if (flexDirection2 == 2 || flexDirection2 == 3) {
            int mode2 = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                size = this.aGH.getLargestMainSize();
            }
            paddingLeft = this.aGH.getPaddingTop();
            paddingRight = this.aGH.getPaddingBottom();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
        }
        int i6 = paddingLeft + paddingRight;
        int i7 = size;
        int[] iArr = this.eli;
        int i8 = iArr != null ? iArr[i3] : 0;
        List<Os> flexLinesInternal = this.aGH.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        while (i8 < size2) {
            Os os = flexLinesInternal.get(i8);
            if (os.ui < i7 && os.dV) {
                i4 = i;
                i5 = i2;
                eli(i4, i5, os, i7, i6, false);
            } else {
                i4 = i;
                i5 = i2;
                if (os.ui > i7 && os.nGm) {
                    DbA(i4, i5, os, i7, i6, false);
                }
            }
            i8++;
            i = i4;
            i2 = i5;
        }
    }

    private void Os(int i) {
        boolean[] zArr = this.ui;
        if (zArr == null) {
            this.ui = new boolean[Math.max(i, 10)];
        } else if (zArr.length < i) {
            this.ui = new boolean[Math.max(zArr.length * 2, i)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void eli(int i, int i2, Os os, int i3, int i4, boolean z) {
        float f;
        float f2;
        int i5;
        int i6;
        int i7;
        double d;
        double d2;
        float f3 = 0.0f;
        if (os.aAs <= 0.0f || i3 < os.ui) {
            return;
        }
        int i8 = os.ui;
        float f4 = (i3 - os.ui) / os.aAs;
        os.ui = i4 + os.MGA;
        if (!z) {
            os.kb = Integer.MIN_VALUE;
        }
        int i9 = 0;
        float f5 = 0.0f;
        boolean z2 = false;
        int i10 = 0;
        while (i9 < os.wC) {
            int i11 = os.Dfc + i9;
            View DbA2 = this.aGH.DbA(i11);
            if (DbA2 == null || DbA2.getVisibility() == 8) {
                f = f3;
                f2 = f4;
            } else {
                com.bytedance.adsdk.ugeno.ui.DbA dbA = (com.bytedance.adsdk.ugeno.ui.DbA) DbA2.getLayoutParams();
                int flexDirection = this.aGH.getFlexDirection();
                f = f3;
                if (flexDirection == 0 || flexDirection == 1) {
                    int measuredWidth = DbA2.getMeasuredWidth();
                    long[] jArr = this.MGA;
                    f2 = f4;
                    if (jArr != null) {
                        measuredWidth = eli(jArr[i11]);
                    }
                    int measuredHeight = DbA2.getMeasuredHeight();
                    long[] jArr2 = this.MGA;
                    if (jArr2 != null) {
                        measuredHeight = DbA(jArr2[i11]);
                    }
                    if (!this.ui[i11] && dbA.aGH() > f) {
                        float aGH = measuredWidth + (f2 * dbA.aGH());
                        if (i9 == os.wC - 1) {
                            aGH += f5;
                            f5 = f;
                        }
                        int round = Math.round(aGH);
                        if (round > dbA.FC()) {
                            i6 = dbA.FC();
                            this.ui[i11] = true;
                            os.aAs -= dbA.aGH();
                            z2 = true;
                        } else {
                            f5 += aGH - round;
                            double d3 = f5;
                            if (d3 > 1.0d) {
                                i7 = round + 1;
                                d = d3 - 1.0d;
                            } else if (d3 < -1.0d) {
                                i7 = round - 1;
                                d = d3 + 1.0d;
                            } else {
                                i6 = round;
                            }
                            f5 = (float) d;
                            i6 = i7;
                        }
                        int DbA3 = DbA(i2, dbA, os.NU);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                        DbA2.measure(makeMeasureSpec, DbA3);
                        int measuredWidth2 = DbA2.getMeasuredWidth();
                        int measuredHeight2 = DbA2.getMeasuredHeight();
                        eli(i11, makeMeasureSpec, DbA3, DbA2);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int max = Math.max(i10, measuredHeight + dbA.nn() + dbA.aqO() + this.aGH.eli(DbA2));
                    os.ui += measuredWidth + dbA.NU() + dbA.Dfc();
                    i5 = max;
                } else {
                    int measuredHeight3 = DbA2.getMeasuredHeight();
                    long[] jArr3 = this.MGA;
                    if (jArr3 != null) {
                        measuredHeight3 = DbA(jArr3[i11]);
                    }
                    int measuredWidth3 = DbA2.getMeasuredWidth();
                    long[] jArr4 = this.MGA;
                    if (jArr4 != null) {
                        measuredWidth3 = eli(jArr4[i11]);
                    }
                    if (!this.ui[i11] && dbA.aGH() > f) {
                        float aGH2 = measuredHeight3 + (dbA.aGH() * f4);
                        if (i9 == os.wC - 1) {
                            aGH2 += f5;
                            f5 = f;
                        }
                        int round2 = Math.round(aGH2);
                        if (round2 > dbA.aAs()) {
                            round2 = dbA.aAs();
                            this.ui[i11] = true;
                            os.aAs -= dbA.aGH();
                            z2 = true;
                        } else {
                            f5 += aGH2 - round2;
                            double d4 = f5;
                            if (d4 > 1.0d) {
                                round2++;
                                d2 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                round2--;
                                d2 = d4 + 1.0d;
                            }
                            f5 = (float) d2;
                        }
                        int eli2 = eli(i, dbA, os.NU);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        DbA2.measure(eli2, makeMeasureSpec2);
                        int measuredWidth4 = DbA2.getMeasuredWidth();
                        int measuredHeight4 = DbA2.getMeasuredHeight();
                        eli(i11, eli2, makeMeasureSpec2, DbA2);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    i5 = Math.max(i10, measuredWidth3 + dbA.NU() + dbA.Dfc() + this.aGH.eli(DbA2));
                    os.ui += measuredHeight3 + dbA.nn() + dbA.aqO();
                    f2 = f4;
                }
                os.kb = Math.max(os.kb, i5);
                i10 = i5;
            }
            i9++;
            f4 = f2;
            f3 = f;
        }
        if (!z2 || i8 == os.ui) {
            return;
        }
        eli(i, i2, os, i3, i4, true);
    }

    private void DbA(int i, int i2, Os os, int i3, int i4, boolean z) {
        float f;
        int i5;
        int i6 = os.ui;
        float f2 = 0.0f;
        if (os.du <= 0.0f || i3 > os.ui) {
            return;
        }
        float f3 = (os.ui - i3) / os.du;
        os.ui = i4 + os.MGA;
        if (!z) {
            os.kb = Integer.MIN_VALUE;
        }
        int i7 = 0;
        float f4 = 0.0f;
        boolean z2 = false;
        int i8 = 0;
        while (i7 < os.wC) {
            int i9 = os.Dfc + i7;
            View DbA2 = this.aGH.DbA(i9);
            if (DbA2 == null || DbA2.getVisibility() == 8) {
                f = f2;
            } else {
                com.bytedance.adsdk.ugeno.ui.DbA dbA = (com.bytedance.adsdk.ugeno.ui.DbA) DbA2.getLayoutParams();
                int flexDirection = this.aGH.getFlexDirection();
                f = f2;
                if (flexDirection == 0 || flexDirection == 1) {
                    int measuredWidth = DbA2.getMeasuredWidth();
                    long[] jArr = this.MGA;
                    if (jArr != null) {
                        measuredWidth = eli(jArr[i9]);
                    }
                    int measuredHeight = DbA2.getMeasuredHeight();
                    long[] jArr2 = this.MGA;
                    if (jArr2 != null) {
                        measuredHeight = DbA(jArr2[i9]);
                    }
                    if (!this.ui[i9] && dbA.ui() > f) {
                        float ui = measuredWidth - (dbA.ui() * f3);
                        if (i7 == os.wC - 1) {
                            ui += f4;
                            f4 = f;
                        }
                        int round = Math.round(ui);
                        if (round < dbA.kb()) {
                            round = dbA.kb();
                            this.ui[i9] = true;
                            os.du -= dbA.ui();
                            z2 = true;
                        } else {
                            f4 += ui - round;
                            double d = f4;
                            if (d > 1.0d) {
                                round++;
                                f4 -= 1.0f;
                            } else if (d < -1.0d) {
                                round--;
                                f4 += 1.0f;
                            }
                        }
                        int DbA3 = DbA(i2, dbA, os.NU);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        DbA2.measure(makeMeasureSpec, DbA3);
                        int measuredWidth2 = DbA2.getMeasuredWidth();
                        int measuredHeight2 = DbA2.getMeasuredHeight();
                        eli(i9, makeMeasureSpec, DbA3, DbA2);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int max = Math.max(i8, measuredHeight + dbA.nn() + dbA.aqO() + this.aGH.eli(DbA2));
                    os.ui += measuredWidth + dbA.NU() + dbA.Dfc();
                    i5 = max;
                } else {
                    int measuredHeight3 = DbA2.getMeasuredHeight();
                    long[] jArr3 = this.MGA;
                    if (jArr3 != null) {
                        measuredHeight3 = DbA(jArr3[i9]);
                    }
                    int measuredWidth3 = DbA2.getMeasuredWidth();
                    long[] jArr4 = this.MGA;
                    if (jArr4 != null) {
                        measuredWidth3 = eli(jArr4[i9]);
                    }
                    if (!this.ui[i9] && dbA.ui() > f) {
                        float ui2 = measuredHeight3 - (dbA.ui() * f3);
                        if (i7 == os.wC - 1) {
                            ui2 += f4;
                            f4 = f;
                        }
                        int round2 = Math.round(ui2);
                        if (round2 < dbA.wC()) {
                            round2 = dbA.wC();
                            this.ui[i9] = true;
                            os.du -= dbA.ui();
                            z2 = true;
                        } else {
                            f4 += ui2 - round2;
                            double d2 = f4;
                            if (d2 > 1.0d) {
                                round2++;
                                f4 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                round2--;
                                f4 += 1.0f;
                            }
                        }
                        int eli2 = eli(i, dbA, os.NU);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        DbA2.measure(eli2, makeMeasureSpec2);
                        int measuredWidth4 = DbA2.getMeasuredWidth();
                        int measuredHeight4 = DbA2.getMeasuredHeight();
                        eli(i9, eli2, makeMeasureSpec2, DbA2);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    i5 = Math.max(i8, measuredWidth3 + dbA.NU() + dbA.Dfc() + this.aGH.eli(DbA2));
                    os.ui += measuredHeight3 + dbA.nn() + dbA.aqO();
                }
                os.kb = Math.max(os.kb, i5);
                i8 = i5;
            }
            i7++;
            f2 = f;
        }
        if (!z2 || i6 == os.ui) {
            return;
        }
        DbA(i, i2, os, i3, i4, true);
    }

    private int eli(int i, com.bytedance.adsdk.ugeno.ui.DbA dbA, int i2) {
        com.bytedance.adsdk.ugeno.ui.eli eliVar = this.aGH;
        int eli2 = eliVar.eli(i, eliVar.getPaddingLeft() + this.aGH.getPaddingRight() + dbA.NU() + dbA.Dfc() + i2, dbA.eli());
        int size = View.MeasureSpec.getSize(eli2);
        if (size > dbA.FC()) {
            return View.MeasureSpec.makeMeasureSpec(dbA.FC(), View.MeasureSpec.getMode(eli2));
        }
        return size < dbA.kb() ? View.MeasureSpec.makeMeasureSpec(dbA.kb(), View.MeasureSpec.getMode(eli2)) : eli2;
    }

    private int DbA(int i, com.bytedance.adsdk.ugeno.ui.DbA dbA, int i2) {
        com.bytedance.adsdk.ugeno.ui.eli eliVar = this.aGH;
        int DbA2 = eliVar.DbA(i, eliVar.getPaddingTop() + this.aGH.getPaddingBottom() + dbA.nn() + dbA.aqO() + i2, dbA.DbA());
        int size = View.MeasureSpec.getSize(DbA2);
        if (size > dbA.aAs()) {
            return View.MeasureSpec.makeMeasureSpec(dbA.aAs(), View.MeasureSpec.getMode(DbA2));
        }
        return size < dbA.wC() ? View.MeasureSpec.makeMeasureSpec(dbA.wC(), View.MeasureSpec.getMode(DbA2)) : DbA2;
    }

    void DbA(int i, int i2, int i3) {
        int i4;
        int i5;
        int flexDirection = this.aGH.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            i4 = mode;
            i5 = size;
        } else if (flexDirection == 2 || flexDirection == 3) {
            i4 = View.MeasureSpec.getMode(i);
            i5 = View.MeasureSpec.getSize(i);
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
        }
        List<Os> flexLinesInternal = this.aGH.getFlexLinesInternal();
        if (i4 == 1073741824) {
            int sumOfCrossSize = this.aGH.getSumOfCrossSize() + i3;
            int i6 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).kb = i5 - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.aGH.getAlignContent();
                if (alignContent == 1) {
                    int i7 = i5 - sumOfCrossSize;
                    Os os = new Os();
                    os.kb = i7;
                    flexLinesInternal.add(0, os);
                    return;
                }
                if (alignContent == 2) {
                    this.aGH.setFlexLines(eli(flexLinesInternal, i5, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize < i5) {
                        float size2 = (i5 - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                        ArrayList arrayList = new ArrayList();
                        int size3 = flexLinesInternal.size();
                        float f = 0.0f;
                        while (i6 < size3) {
                            arrayList.add(flexLinesInternal.get(i6));
                            if (i6 != flexLinesInternal.size() - 1) {
                                Os os2 = new Os();
                                if (i6 == flexLinesInternal.size() - 2) {
                                    os2.kb = Math.round(f + size2);
                                    f = 0.0f;
                                } else {
                                    os2.kb = Math.round(size2);
                                }
                                f += size2 - os2.kb;
                                if (f > 1.0f) {
                                    os2.kb++;
                                    f -= 1.0f;
                                } else if (f < -1.0f) {
                                    os2.kb--;
                                    f += 1.0f;
                                }
                                arrayList.add(os2);
                            }
                            i6++;
                        }
                        this.aGH.setFlexLines(arrayList);
                        return;
                    }
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= i5) {
                        this.aGH.setFlexLines(eli(flexLinesInternal, i5, sumOfCrossSize));
                        return;
                    }
                    int size4 = (i5 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    Os os3 = new Os();
                    os3.kb = size4;
                    for (Os os4 : flexLinesInternal) {
                        arrayList2.add(os3);
                        arrayList2.add(os4);
                        arrayList2.add(os3);
                    }
                    this.aGH.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < i5) {
                    float size5 = (i5 - sumOfCrossSize) / flexLinesInternal.size();
                    int size6 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i6 < size6) {
                        Os os5 = flexLinesInternal.get(i6);
                        float f3 = os5.kb + size5;
                        if (i6 == flexLinesInternal.size() - 1) {
                            f3 += f2;
                            f2 = 0.0f;
                        }
                        int round = Math.round(f3);
                        f2 += f3 - round;
                        if (f2 > 1.0f) {
                            round++;
                            f2 -= 1.0f;
                        } else if (f2 < -1.0f) {
                            round--;
                            f2 += 1.0f;
                        }
                        os5.kb = round;
                        i6++;
                    }
                }
            }
        }
    }

    private List<Os> eli(List<Os> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        Os os = new Os();
        os.kb = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(os);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(os);
            }
        }
        return arrayList;
    }

    void eli() {
        eli(0);
    }

    void eli(int i) {
        View DbA2;
        if (i >= this.aGH.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.aGH.getFlexDirection();
        if (this.aGH.getAlignItems() == 4) {
            int[] iArr = this.eli;
            List<Os> flexLinesInternal = this.aGH.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
                Os os = flexLinesInternal.get(i2);
                int i3 = os.wC;
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = os.Dfc + i4;
                    if (i4 < this.aGH.getFlexItemCount() && (DbA2 = this.aGH.DbA(i5)) != null && DbA2.getVisibility() != 8) {
                        com.bytedance.adsdk.ugeno.ui.DbA dbA = (com.bytedance.adsdk.ugeno.ui.DbA) DbA2.getLayoutParams();
                        if (dbA.MGA() == -1 || dbA.MGA() == 4) {
                            if (flexDirection == 0 || flexDirection == 1) {
                                eli(DbA2, os.kb, i5);
                            } else if (flexDirection == 2 || flexDirection == 3) {
                                DbA(DbA2, os.kb, i5);
                            } else {
                                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                            }
                        }
                    }
                }
            }
            return;
        }
        for (Os os2 : this.aGH.getFlexLinesInternal()) {
            for (Integer num : os2.nn) {
                View DbA3 = this.aGH.DbA(num.intValue());
                if (flexDirection == 0 || flexDirection == 1) {
                    eli(DbA3, os2.kb, num.intValue());
                } else if (flexDirection == 2 || flexDirection == 3) {
                    DbA(DbA3, os2.kb, num.intValue());
                } else {
                    throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                }
            }
        }
    }

    private void eli(View view, int i, int i2) {
        int measuredWidth;
        com.bytedance.adsdk.ugeno.ui.DbA dbA = (com.bytedance.adsdk.ugeno.ui.DbA) view.getLayoutParams();
        int min = Math.min(Math.max(((i - dbA.nn()) - dbA.aqO()) - this.aGH.eli(view), dbA.wC()), dbA.aAs());
        long[] jArr = this.MGA;
        if (jArr != null) {
            measuredWidth = eli(jArr[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        eli(i2, makeMeasureSpec, makeMeasureSpec2, view);
    }

    private void DbA(View view, int i, int i2) {
        int measuredHeight;
        com.bytedance.adsdk.ugeno.ui.DbA dbA = (com.bytedance.adsdk.ugeno.ui.DbA) view.getLayoutParams();
        int min = Math.min(Math.max(((i - dbA.NU()) - dbA.Dfc()) - this.aGH.eli(view), dbA.kb()), dbA.FC());
        long[] jArr = this.MGA;
        if (jArr != null) {
            measuredHeight = DbA(jArr[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        eli(i2, makeMeasureSpec2, makeMeasureSpec, view);
    }

    void eli(View view, Os os, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.ui.DbA dbA = (com.bytedance.adsdk.ugeno.ui.DbA) view.getLayoutParams();
        int alignItems = this.aGH.getAlignItems();
        if (dbA.MGA() != -1) {
            alignItems = dbA.MGA();
        }
        int i5 = os.kb;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.aGH.getFlexWrap() != 2) {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - dbA.aqO(), i3, i6 - dbA.aqO());
                    return;
                } else {
                    view.layout(i, (i2 - i5) + view.getMeasuredHeight() + dbA.nn(), i3, (i4 - i5) + view.getMeasuredHeight() + dbA.nn());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + dbA.nn()) - dbA.aqO()) / 2;
                if (this.aGH.getFlexWrap() != 2) {
                    int i7 = i2 + measuredHeight;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                    return;
                } else {
                    int i8 = i2 - measuredHeight;
                    view.layout(i, i8, i3, view.getMeasuredHeight() + i8);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.aGH.getFlexWrap() != 2) {
                    int max = Math.max(os.nlS - view.getBaseline(), dbA.nn());
                    view.layout(i, i2 + max, i3, i4 + max);
                    return;
                } else {
                    int max2 = Math.max((os.nlS - view.getMeasuredHeight()) + view.getBaseline(), dbA.aqO());
                    view.layout(i, i2 - max2, i3, i4 - max2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.aGH.getFlexWrap() != 2) {
            view.layout(i, i2 + dbA.nn(), i3, i4 + dbA.nn());
        } else {
            view.layout(i, i2 - dbA.aqO(), i3, i4 - dbA.aqO());
        }
    }

    void eli(View view, Os os, boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.ui.DbA dbA = (com.bytedance.adsdk.ugeno.ui.DbA) view.getLayoutParams();
        int alignItems = this.aGH.getAlignItems();
        if (dbA.MGA() != -1) {
            alignItems = dbA.MGA();
        }
        int i5 = os.kb;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z) {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - dbA.Dfc(), i2, ((i3 + i5) - view.getMeasuredWidth()) - dbA.Dfc(), i4);
                    return;
                } else {
                    view.layout((i - i5) + view.getMeasuredWidth() + dbA.NU(), i2, (i3 - i5) + view.getMeasuredWidth() + dbA.NU(), i4);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i5 - view.getMeasuredWidth()) + com.bytedance.adsdk.ugeno.kb.MGA.eli(marginLayoutParams)) - com.bytedance.adsdk.ugeno.kb.MGA.DbA(marginLayoutParams)) / 2;
                if (!z) {
                    view.layout(i + measuredWidth, i2, i3 + measuredWidth, i4);
                    return;
                } else {
                    view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (!z) {
            view.layout(i + dbA.NU(), i2, i3 + dbA.NU(), i4);
        } else {
            view.layout(i - dbA.Dfc(), i2, i3 - dbA.Dfc(), i4);
        }
    }

    private void eli(int i, int i2, int i3, View view) {
        long[] jArr = this.DbA;
        if (jArr != null) {
            jArr[i] = DbA(i2, i3);
        }
        long[] jArr2 = this.MGA;
        if (jArr2 != null) {
            jArr2[i] = DbA(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private static class DbA implements Comparable<DbA> {
        int DbA;
        int eli;

        private DbA() {
        }

        @Override // java.lang.Comparable
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public int compareTo(DbA dbA) {
            int i = this.DbA;
            int i2 = dbA.DbA;
            return i != i2 ? i - i2 : this.eli - dbA.eli;
        }

        public String toString() {
            return "Order{order=" + this.DbA + ", index=" + this.eli + AbstractJsonLexerKt.END_OBJ;
        }
    }

    static class eli {
        int DbA;
        List<Os> eli;

        eli() {
        }

        void eli() {
            this.eli = null;
            this.DbA = 0;
        }
    }
}
