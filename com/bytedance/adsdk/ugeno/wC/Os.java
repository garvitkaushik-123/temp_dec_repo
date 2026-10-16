package com.bytedance.adsdk.ugeno.wC;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public class Os extends ViewGroup {
    private int BDs;
    private ui BH;
    private int CMM;
    private float Cp;
    private final Runnable DE;
    private MGA Dfc;
    private final Rect FC;
    private int FS;
    private int GB;
    private int GMY;
    private boolean KM;
    private Scroller NU;
    com.bytedance.adsdk.ugeno.wC.DbA Os;
    private boolean QI;
    private int QX;
    private VelocityTracker SSo;
    private boolean TfR;
    private int Ue;
    private int Uv;
    private boolean VM;
    private boolean Vy;
    private EdgeEffect WfR;
    private float Xb;
    private aGH Yw;
    private int Za;
    private int aAs;
    int aGH;
    private int aqO;
    private float bf;
    private float cyF;
    private Drawable dV;
    private int dZ;
    private Parcelable du;
    private float eU;
    private int eli;
    private int ev;
    private boolean gG;
    private ArrayList<View> gHb;
    private boolean ikX;
    private int jh;
    private final ArrayList<DbA> kb;
    private int mm;
    private int nGm;
    private ClassLoader nlS;
    private boolean nn;
    private float nro;
    private int oWW;
    private List<aGH> oc;
    private boolean ow;
    private int qj;
    private List<Object> qyC;
    private aGH rQ;
    private EdgeEffect tGZ;
    private int tLO;
    private boolean ujq;
    private final DbA wC;
    static final int[] DbA = {R.attr.layout_gravity};
    private static final Comparator<DbA> ui = new Comparator<DbA>() { // from class: com.bytedance.adsdk.ugeno.wC.Os.1
        @Override // java.util.Comparator
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public int compare(DbA dbA, DbA dbA2) {
            return dbA.DbA - dbA2.DbA;
        }
    };
    private static final Interpolator MGA = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.wC.Os.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private static final wC Mc = new wC();

    public interface aGH {
        void du(int i);

        void eli(int i, float f, int i2);

        void nlS(int i);
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface eli {
    }

    public interface ui {
        void eli(View view, float f);
    }

    static class DbA {
        int DbA;
        boolean Os;
        float aGH;
        Object eli;
        float ui;

        DbA() {
        }
    }

    public Os(Context context) {
        super(context);
        this.kb = new ArrayList<>();
        this.wC = new DbA();
        this.FC = new Rect();
        this.aAs = -1;
        this.du = null;
        this.nlS = null;
        this.Xb = -3.4028235E38f;
        this.bf = Float.MAX_VALUE;
        this.Ue = 1;
        this.dZ = -1;
        this.ow = true;
        this.TfR = false;
        this.DE = new Runnable() { // from class: com.bytedance.adsdk.ugeno.wC.Os.3
            @Override // java.lang.Runnable
            public void run() {
                Os.this.setScrollState(0);
                Os.this.Os();
            }
        };
        this.GMY = 0;
        eli();
    }

    void eli() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.NU = new Scroller(context, MGA);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.qj = viewConfiguration.getScaledPagingTouchSlop();
        this.Uv = (int) (400.0f * f);
        this.FS = viewConfiguration.getScaledMaximumFlingVelocity();
        this.tGZ = new EdgeEffect(context);
        this.WfR = new EdgeEffect(context);
        this.jh = (int) (25.0f * f);
        this.Za = (int) (2.0f * f);
        this.GB = (int) (f * 16.0f);
    }

    public void setScroller(Scroller scroller) {
        this.NU = scroller;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.DE);
        Scroller scroller = this.NU;
        if (scroller != null && !scroller.isFinished()) {
            this.NU.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    void setScrollState(int i) {
        if (this.GMY == i) {
            return;
        }
        this.GMY = i;
        if (this.BH != null) {
            DbA(i != 0);
        }
        MGA(i);
    }

    public void setAdapter(com.bytedance.adsdk.ugeno.wC.DbA dbA) {
        com.bytedance.adsdk.ugeno.wC.DbA dbA2 = this.Os;
        if (dbA2 != null) {
            dbA2.eli((DataSetObserver) null);
            for (int i = 0; i < this.kb.size(); i++) {
                DbA dbA3 = this.kb.get(i);
                this.Os.eli((ViewGroup) this, dbA3.DbA, dbA3.eli);
            }
            this.kb.clear();
            MGA();
            this.aGH = 0;
            scrollTo(0, 0);
        }
        this.Os = dbA;
        this.eli = 0;
        if (dbA != null) {
            if (this.Dfc == null) {
                this.Dfc = new MGA();
            }
            this.Os.eli((DataSetObserver) this.Dfc);
            this.ujq = false;
            boolean z = this.ow;
            this.ow = true;
            this.eli = this.Os.eli();
            int i2 = this.aAs;
            if (i2 >= 0) {
                eli(i2, false, true);
                this.aAs = -1;
                this.du = null;
                this.nlS = null;
            } else if (!z) {
                Os();
            } else {
                requestLayout();
            }
        }
        List<Object> list = this.qyC;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.qyC.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.qyC.get(i3);
        }
    }

    private void MGA() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((C0127Os) getChildAt(i).getLayoutParams()).eli) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public com.bytedance.adsdk.ugeno.wC.DbA getAdapter() {
        return this.Os;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        this.ujq = false;
        eli(i, !this.ow, false);
    }

    public void eli(int i, boolean z) {
        this.ujq = false;
        eli(i, z, false);
    }

    public int getCurrentItem() {
        return this.aGH;
    }

    void eli(int i, boolean z, boolean z2) {
        eli(i, z, z2, 0);
    }

    void eli(int i, boolean z, boolean z2, int i2) {
        com.bytedance.adsdk.ugeno.wC.DbA dbA = this.Os;
        if (dbA == null || dbA.eli() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.aGH == i && this.kb.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.Os.eli()) {
            i = this.Os.eli() - 1;
        }
        int i3 = this.Ue;
        int i4 = this.aGH;
        if (i > i4 + i3 || i < i4 - i3) {
            for (int i5 = 0; i5 < this.kb.size(); i5++) {
                this.kb.get(i5).Os = true;
            }
        }
        boolean z3 = this.aGH != i;
        if (this.ow) {
            this.aGH = i;
            if (z3) {
                ui(i);
            }
            requestLayout();
            return;
        }
        eli(i);
        eli(i, z, i2, z3);
    }

    private void eli(int i, boolean z, int i2, boolean z2) {
        DbA DbA2 = DbA(i);
        int clientWidth = DbA2 != null ? (int) (getClientWidth() * Math.max(this.Xb, Math.min(DbA2.ui, this.bf))) : 0;
        if (z) {
            eli(clientWidth, 0, i2);
            if (z2) {
                ui(i);
                return;
            }
            return;
        }
        if (z2) {
            ui(i);
        }
        eli(false);
        scrollTo(clientWidth, 0);
        aGH(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(aGH agh) {
        this.rQ = agh;
    }

    public void eli(aGH agh) {
        if (this.oc == null) {
            this.oc = new ArrayList();
        }
        this.oc.add(agh);
    }

    public void DbA(aGH agh) {
        List<aGH> list = this.oc;
        if (list != null) {
            list.remove(agh);
        }
    }

    public void eli(boolean z, ui uiVar) {
        eli(z, uiVar, 2);
    }

    public void eli(boolean z, ui uiVar, int i) {
        boolean z2 = uiVar != null;
        boolean z3 = z2 != (this.BH != null);
        this.BH = uiVar;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.tLO = z ? 2 : 1;
            this.BDs = i;
        } else {
            this.tLO = 0;
        }
        if (z3) {
            Os();
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.tLO == 2) {
            i2 = (i - 1) - i2;
        }
        return ((C0127Os) this.gHb.get(i2).getLayoutParams()).MGA;
    }

    public int getOffscreenPageLimit() {
        return this.Ue;
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.Ue) {
            this.Ue = i;
            Os();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.aqO;
        this.aqO = i;
        int width = getWidth();
        eli(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.aqO;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.dV = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.dV;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.dV;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    float eli(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    void eli(int i, int i2, int i3) {
        int scrollX;
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.NU;
        if (scroller != null && !scroller.isFinished()) {
            scrollX = this.nn ? this.NU.getCurrX() : this.NU.getStartX();
            this.NU.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i4 = scrollX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            eli(false);
            Os();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float f = clientWidth;
        float f2 = i7;
        float eli2 = f2 + (eli(Math.min(1.0f, (Math.abs(i5) * 1.0f) / f)) * f2);
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(eli2 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i5) / ((f * this.Os.eli(this.aGH)) + this.aqO)) + 1.0f) * 100.0f);
        }
        int min = Math.min(abs, 600);
        this.nn = false;
        this.NU.startScroll(i4, scrollY, i5, i6, min);
        postInvalidateOnAnimation();
    }

    DbA eli(int i, int i2) {
        DbA dbA = new DbA();
        dbA.DbA = i;
        dbA.eli = this.Os.eli((ViewGroup) this, i);
        dbA.aGH = this.Os.eli(i);
        if (i2 < 0 || i2 >= this.kb.size()) {
            this.kb.add(dbA);
            return dbA;
        }
        this.kb.add(i2, dbA);
        return dbA;
    }

    void DbA() {
        int eli2 = this.Os.eli();
        this.eli = eli2;
        boolean z = this.kb.size() < (this.Ue * 2) + 1 && this.kb.size() < eli2;
        int i = this.aGH;
        int i2 = 0;
        while (i2 < this.kb.size()) {
            DbA dbA = this.kb.get(i2);
            int eli3 = this.Os.eli(dbA.eli);
            if (eli3 != -1) {
                if (eli3 == -2) {
                    this.kb.remove(i2);
                    i2--;
                    this.Os.eli((ViewGroup) this, dbA.DbA, dbA.eli);
                    if (this.aGH == dbA.DbA) {
                        i = Math.max(0, Math.min(this.aGH, eli2 - 1));
                    }
                } else if (dbA.DbA != eli3) {
                    if (dbA.DbA == this.aGH) {
                        i = eli3;
                    }
                    dbA.DbA = eli3;
                }
                z = true;
            }
            i2++;
        }
        Collections.sort(this.kb, ui);
        if (z) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                C0127Os c0127Os = (C0127Os) getChildAt(i3).getLayoutParams();
                if (!c0127Os.eli) {
                    c0127Os.Os = 0.0f;
                }
            }
            eli(i, false, true);
            requestLayout();
        }
    }

    void Os() {
        eli(this.aGH);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        if (r8.DbA == r17.aGH) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void eli(int i) {
        DbA dbA;
        String hexString;
        DbA dbA2;
        DbA eli2;
        DbA dbA3;
        int i2 = this.aGH;
        if (i2 != i) {
            dbA = DbA(i2);
            this.aGH = i;
        } else {
            dbA = null;
        }
        if (this.Os == null) {
            kb();
            return;
        }
        if (this.ujq) {
            kb();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        int i3 = this.Ue;
        int max = Math.max(0, this.aGH - i3);
        int eli3 = this.Os.eli();
        int min = Math.min(eli3 - 1, this.aGH + i3);
        if (eli3 != this.eli) {
            try {
                hexString = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                hexString = Integer.toHexString(getId());
            }
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.eli + ", found: " + eli3 + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.Os.getClass());
        }
        int i4 = 0;
        while (true) {
            if (i4 >= this.kb.size()) {
                break;
            }
            dbA2 = this.kb.get(i4);
            if (dbA2.DbA < this.aGH) {
                i4++;
            }
        }
        dbA2 = null;
        if (dbA2 == null && eli3 > 0) {
            dbA2 = eli(this.aGH, i4);
        }
        if (dbA2 != null) {
            int i5 = i4 - 1;
            DbA dbA4 = i5 >= 0 ? this.kb.get(i5) : null;
            int clientWidth = getClientWidth();
            float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - dbA2.aGH) + (getPaddingLeft() / clientWidth);
            float f = 0.0f;
            for (int i6 = this.aGH - 1; i6 >= 0; i6--) {
                if (f >= paddingLeft && i6 < max) {
                    if (dbA4 == null) {
                        break;
                    }
                    if (i6 == dbA4.DbA && !dbA4.Os) {
                        this.kb.remove(i5);
                        this.Os.eli((ViewGroup) this, i6, dbA4.eli);
                        i5--;
                        i4--;
                        if (i5 >= 0) {
                            dbA3 = this.kb.get(i5);
                            dbA4 = dbA3;
                        }
                        dbA3 = null;
                        dbA4 = dbA3;
                    }
                } else if (dbA4 != null && i6 == dbA4.DbA) {
                    f += dbA4.aGH;
                    i5--;
                    if (i5 >= 0) {
                        dbA3 = this.kb.get(i5);
                        dbA4 = dbA3;
                    }
                    dbA3 = null;
                    dbA4 = dbA3;
                } else {
                    f += eli(i6, i5 + 1).aGH;
                    i4++;
                    if (i5 >= 0) {
                        dbA3 = this.kb.get(i5);
                        dbA4 = dbA3;
                    }
                    dbA3 = null;
                    dbA4 = dbA3;
                }
            }
            float f2 = dbA2.aGH;
            int i7 = i4 + 1;
            if (f2 < 2.0f) {
                DbA dbA5 = i7 < this.kb.size() ? this.kb.get(i7) : null;
                float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                int i8 = this.aGH;
                while (true) {
                    i8++;
                    if (i8 >= eli3) {
                        break;
                    }
                    if (f2 >= paddingRight && i8 > min) {
                        if (dbA5 == null) {
                            break;
                        }
                        if (i8 == dbA5.DbA && !dbA5.Os) {
                            this.kb.remove(i7);
                            this.Os.eli((ViewGroup) this, i8, dbA5.eli);
                            if (i7 < this.kb.size()) {
                                dbA5 = this.kb.get(i7);
                            }
                        }
                    } else if (dbA5 != null && i8 == dbA5.DbA) {
                        f2 += dbA5.aGH;
                        i7++;
                        if (i7 < this.kb.size()) {
                            dbA5 = this.kb.get(i7);
                        }
                    } else {
                        DbA eli4 = eli(i8, i7);
                        i7++;
                        f2 += eli4.aGH;
                        dbA5 = i7 < this.kb.size() ? this.kb.get(i7) : null;
                    }
                }
            }
            eli(dbA2, i4, dbA);
        }
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            C0127Os c0127Os = (C0127Os) childAt.getLayoutParams();
            c0127Os.MGA = i9;
            if (!c0127Os.eli && c0127Os.Os == 0.0f && (eli2 = eli(childAt)) != null) {
                c0127Os.Os = eli2.aGH;
                c0127Os.ui = eli2.DbA;
            }
        }
        kb();
        if (hasFocus()) {
            View findFocus = findFocus();
            DbA DbA2 = findFocus != null ? DbA(findFocus) : null;
            if (DbA2 == null || DbA2.DbA != this.aGH) {
                for (int i10 = 0; i10 < getChildCount(); i10++) {
                    View childAt2 = getChildAt(i10);
                    DbA eli5 = eli(childAt2);
                    if (eli5 != null && eli5.DbA == this.aGH && childAt2.requestFocus(2)) {
                        return;
                    }
                }
            }
        }
    }

    private void kb() {
        if (this.tLO != 0) {
            ArrayList<View> arrayList = this.gHb;
            if (arrayList == null) {
                this.gHb = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.gHb.add(getChildAt(i));
            }
            Collections.sort(this.gHb, Mc);
        }
    }

    private void eli(DbA dbA, int i, DbA dbA2) {
        DbA dbA3;
        DbA dbA4;
        int eli2 = this.Os.eli();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? this.aqO / clientWidth : 0.0f;
        if (dbA2 != null) {
            int i2 = dbA2.DbA;
            if (i2 < dbA.DbA) {
                float f2 = dbA2.ui + dbA2.aGH + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= dbA.DbA && i4 < this.kb.size()) {
                    DbA dbA5 = this.kb.get(i4);
                    while (true) {
                        dbA4 = dbA5;
                        if (i3 <= dbA4.DbA || i4 >= this.kb.size() - 1) {
                            break;
                        }
                        i4++;
                        dbA5 = this.kb.get(i4);
                    }
                    while (i3 < dbA4.DbA) {
                        f2 += this.Os.eli(i3) + f;
                        i3++;
                    }
                    dbA4.ui = f2;
                    f2 += dbA4.aGH + f;
                    i3++;
                }
            } else if (i2 > dbA.DbA) {
                int size = this.kb.size() - 1;
                float f3 = dbA2.ui;
                while (true) {
                    i2--;
                    if (i2 < dbA.DbA || size < 0) {
                        break;
                    }
                    DbA dbA6 = this.kb.get(size);
                    while (true) {
                        dbA3 = dbA6;
                        if (i2 >= dbA3.DbA || size <= 0) {
                            break;
                        }
                        size--;
                        dbA6 = this.kb.get(size);
                    }
                    while (i2 > dbA3.DbA) {
                        f3 -= this.Os.eli(i2) + f;
                        i2--;
                    }
                    f3 -= dbA3.aGH + f;
                    dbA3.ui = f3;
                }
            }
        }
        int size2 = this.kb.size();
        float f4 = dbA.ui;
        int i5 = dbA.DbA - 1;
        this.Xb = dbA.DbA == 0 ? dbA.ui : -3.4028235E38f;
        int i6 = eli2 - 1;
        this.bf = dbA.DbA == i6 ? (dbA.ui + dbA.aGH) - 1.0f : Float.MAX_VALUE;
        int i7 = i - 1;
        while (i7 >= 0) {
            DbA dbA7 = this.kb.get(i7);
            while (i5 > dbA7.DbA) {
                f4 -= this.Os.eli(i5) + f;
                i5--;
            }
            f4 -= dbA7.aGH + f;
            dbA7.ui = f4;
            if (dbA7.DbA == 0) {
                this.Xb = f4;
            }
            i7--;
            i5--;
        }
        float f5 = dbA.ui + dbA.aGH + f;
        int i8 = dbA.DbA + 1;
        int i9 = i + 1;
        while (i9 < size2) {
            DbA dbA8 = this.kb.get(i9);
            while (i8 < dbA8.DbA) {
                f5 += this.Os.eli(i8) + f;
                i8++;
            }
            if (dbA8.DbA == i6) {
                this.bf = (dbA8.aGH + f5) - 1.0f;
            }
            dbA8.ui = f5;
            f5 += dbA8.aGH + f;
            i9++;
            i8++;
        }
        this.TfR = false;
    }

    public static class kb extends com.bytedance.adsdk.ugeno.wC.eli {
        public static final Parcelable.Creator<kb> CREATOR = new Parcelable.ClassLoaderCreator<kb>() { // from class: com.bytedance.adsdk.ugeno.wC.Os.kb.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public kb createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new kb(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public kb createFromParcel(Parcel parcel) {
                return new kb(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public kb[] newArray(int i) {
                return new kb[i];
            }
        };
        int DbA;
        Parcelable Os;
        ClassLoader aGH;

        public kb(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // com.bytedance.adsdk.ugeno.wC.eli, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.DbA);
            parcel.writeParcelable(this.Os, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.DbA + "}";
        }

        kb(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.DbA = parcel.readInt();
            this.Os = parcel.readParcelable(classLoader);
            this.aGH = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        kb kbVar = new kb(super.onSaveInstanceState());
        kbVar.DbA = this.aGH;
        com.bytedance.adsdk.ugeno.wC.DbA dbA = this.Os;
        if (dbA != null) {
            kbVar.Os = dbA.DbA();
        }
        return kbVar;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof kb)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        kb kbVar = (kb) parcelable;
        super.onRestoreInstanceState(kbVar.eli());
        if (this.Os != null) {
            eli(kbVar.DbA, false, true);
            return;
        }
        this.aAs = kbVar.DbA;
        this.du = kbVar.Os;
        this.nlS = kbVar.aGH;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        C0127Os c0127Os = (C0127Os) layoutParams;
        c0127Os.eli |= Os(view);
        if (this.Vy) {
            if (c0127Os != null && c0127Os.eli) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            c0127Os.aGH = true;
            addViewInLayout(view, i, layoutParams);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private static boolean Os(View view) {
        return view.getClass().getAnnotation(eli.class) != null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.Vy) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    DbA eli(View view) {
        for (int i = 0; i < this.kb.size(); i++) {
            DbA dbA = this.kb.get(i);
            if (this.Os.eli(view, dbA.eli)) {
                return dbA;
            }
        }
        return null;
    }

    DbA DbA(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return eli(view);
            }
        }
    }

    DbA DbA(int i) {
        for (int i2 = 0; i2 < this.kb.size(); i2++) {
            DbA dbA = this.kb.get(i2);
            if (dbA.DbA == i) {
                return dbA;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ow = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        C0127Os c0127Os;
        C0127Os c0127Os2;
        int i3;
        int i4;
        int i5;
        boolean z = false;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.oWW = Math.min(measuredWidth / 10, this.GB);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            boolean z2 = true;
            int i7 = 1073741824;
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (c0127Os2 = (C0127Os) childAt.getLayoutParams()) != null && c0127Os2.eli) {
                int i8 = c0127Os2.DbA & 7;
                int i9 = c0127Os2.DbA & 112;
                boolean z3 = (i9 == 48 || i9 == 80) ? true : z;
                if (i8 != 3 && i8 != 5) {
                    z2 = z;
                }
                int i10 = Integer.MIN_VALUE;
                if (z3) {
                    i3 = Integer.MIN_VALUE;
                    i10 = 1073741824;
                } else {
                    i3 = z2 ? 1073741824 : Integer.MIN_VALUE;
                }
                if (c0127Os2.width != -2) {
                    i4 = c0127Os2.width != -1 ? c0127Os2.width : paddingLeft;
                    i10 = 1073741824;
                } else {
                    i4 = paddingLeft;
                }
                if (c0127Os2.height != -2) {
                    i5 = c0127Os2.height != -1 ? c0127Os2.height : measuredHeight;
                } else {
                    i5 = measuredHeight;
                    i7 = i3;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i10), View.MeasureSpec.makeMeasureSpec(i5, i7));
                if (z3) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z2) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i6++;
            z = false;
        }
        this.CMM = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.ev = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.Vy = true;
        Os();
        this.Vy = false;
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8 && ((c0127Os = (C0127Os) childAt2.getLayoutParams()) == null || !c0127Os.eli)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * c0127Os.Os), 1073741824), this.ev);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.aqO;
            eli(i, i3, i5, i5);
        }
    }

    private void eli(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.kb.isEmpty()) {
            if (!this.NU.isFinished()) {
                this.NU.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        DbA DbA2 = DbA(this.aGH);
        int min = (int) ((DbA2 != null ? Math.min(DbA2.ui, this.bf) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (min != getScrollX()) {
            eli(false);
            scrollTo(min, getScrollY());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0090  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        DbA eli2;
        int max;
        int i5;
        int max2;
        int i6;
        int childCount = getChildCount();
        int i7 = i3 - i;
        int i8 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                C0127Os c0127Os = (C0127Os) childAt.getLayoutParams();
                if (c0127Os.eli) {
                    int i11 = c0127Os.DbA & 7;
                    int i12 = c0127Os.DbA & 112;
                    if (i11 == 1) {
                        max = Math.max((i7 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    } else {
                        if (i11 == 3) {
                            i5 = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i11 != 5) {
                            i5 = paddingLeft;
                        } else {
                            max = (i7 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i12 != 16) {
                            max2 = Math.max((i8 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        } else {
                            if (i12 == 48) {
                                i6 = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i12 != 80) {
                                i6 = paddingTop;
                            } else {
                                max2 = (i8 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i13 = paddingLeft + scrollX;
                            childAt.layout(i13, paddingTop, childAt.getMeasuredWidth() + i13, paddingTop + childAt.getMeasuredHeight());
                            i9++;
                            paddingTop = i6;
                            paddingLeft = i5;
                        }
                        int i14 = max2;
                        i6 = paddingTop;
                        paddingTop = i14;
                        int i132 = paddingLeft + scrollX;
                        childAt.layout(i132, paddingTop, childAt.getMeasuredWidth() + i132, paddingTop + childAt.getMeasuredHeight());
                        i9++;
                        paddingTop = i6;
                        paddingLeft = i5;
                    }
                    int i15 = max;
                    i5 = paddingLeft;
                    paddingLeft = i15;
                    if (i12 != 16) {
                    }
                    int i142 = max2;
                    i6 = paddingTop;
                    paddingTop = i142;
                    int i1322 = paddingLeft + scrollX;
                    childAt.layout(i1322, paddingTop, childAt.getMeasuredWidth() + i1322, paddingTop + childAt.getMeasuredHeight());
                    i9++;
                    paddingTop = i6;
                    paddingLeft = i5;
                }
            }
        }
        int i16 = (i7 - paddingLeft) - paddingRight;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt2 = getChildAt(i17);
            if (childAt2.getVisibility() != 8) {
                C0127Os c0127Os2 = (C0127Os) childAt2.getLayoutParams();
                if (!c0127Os2.eli && (eli2 = eli(childAt2)) != null) {
                    float f = i16;
                    int i18 = ((int) (eli2.ui * f)) + paddingLeft;
                    if (c0127Os2.aGH) {
                        c0127Os2.aGH = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f * c0127Os2.Os), 1073741824), View.MeasureSpec.makeMeasureSpec((i8 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i18, paddingTop, childAt2.getMeasuredWidth() + i18, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.nGm = paddingTop;
        this.QX = i8 - paddingBottom;
        this.mm = i9;
        if (this.ow) {
            z2 = false;
            eli(this.aGH, false, 0, false);
        } else {
            z2 = false;
        }
        this.ow = z2;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.nn = true;
        if (!this.NU.isFinished() && this.NU.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.NU.getCurrX();
            int currY = this.NU.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!aGH(currX)) {
                    this.NU.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            postInvalidateOnAnimation();
            return;
        }
        eli(true);
    }

    private boolean aGH(int i) {
        if (this.kb.size() == 0) {
            if (this.ow) {
                return false;
            }
            this.QI = false;
            eli(0, 0.0f, 0);
            if (this.QI) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        DbA FC = FC();
        int clientWidth = getClientWidth();
        int i2 = this.aqO;
        int i3 = clientWidth + i2;
        float f = clientWidth;
        int i4 = FC.DbA;
        float f2 = ((i / f) - FC.ui) / (FC.aGH + (i2 / f));
        this.QI = false;
        eli(i4, f2, (int) (i3 * f2));
        if (this.QI) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void eli(int i, float f, int i2) {
        int max;
        int i3;
        int left;
        if (this.mm > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                C0127Os c0127Os = (C0127Os) childAt.getLayoutParams();
                if (c0127Os.eli) {
                    int i5 = c0127Os.DbA & 7;
                    if (i5 == 1) {
                        max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    } else {
                        if (i5 == 3) {
                            i3 = childAt.getWidth() + paddingLeft;
                        } else if (i5 != 5) {
                            i3 = paddingLeft;
                        } else {
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = i3;
                    }
                    int i6 = max;
                    i3 = paddingLeft;
                    paddingLeft = i6;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                    }
                    paddingLeft = i3;
                }
            }
        }
        DbA(i, f, i2);
        if (this.BH != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i7 = 0; i7 < childCount2; i7++) {
                View childAt2 = getChildAt(i7);
                if (!((C0127Os) childAt2.getLayoutParams()).eli) {
                    this.BH.eli(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.QI = true;
    }

    private void DbA(int i, float f, int i2) {
        aGH agh = this.rQ;
        if (agh != null) {
            agh.eli(i, f, i2);
        }
        List<aGH> list = this.oc;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                aGH agh2 = this.oc.get(i3);
                if (agh2 != null) {
                    agh2.eli(i, f, i2);
                }
            }
        }
        aGH agh3 = this.Yw;
        if (agh3 != null) {
            agh3.eli(i, f, i2);
        }
    }

    private void ui(int i) {
        aGH agh = this.rQ;
        if (agh != null) {
            agh.du(i);
        }
        List<aGH> list = this.oc;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                aGH agh2 = this.oc.get(i2);
                if (agh2 != null) {
                    agh2.du(i);
                }
            }
        }
        aGH agh3 = this.Yw;
        if (agh3 != null) {
            agh3.du(i);
        }
    }

    private void MGA(int i) {
        aGH agh = this.rQ;
        if (agh != null) {
            agh.nlS(i);
        }
        List<aGH> list = this.oc;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                aGH agh2 = this.oc.get(i2);
                if (agh2 != null) {
                    agh2.nlS(i);
                }
            }
        }
        aGH agh3 = this.Yw;
        if (agh3 != null) {
            agh3.nlS(i);
        }
    }

    private void eli(boolean z) {
        boolean z2 = this.GMY == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.NU.isFinished()) {
                this.NU.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.NU.getCurrX();
                int currY = this.NU.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        aGH(currX);
                    }
                }
            }
        }
        this.ujq = false;
        for (int i = 0; i < this.kb.size(); i++) {
            DbA dbA = this.kb.get(i);
            if (dbA.Os) {
                dbA.Os = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                postOnAnimation(this.DE);
            } else {
                this.DE.run();
            }
        }
    }

    private boolean eli(float f, float f2) {
        if (f >= this.oWW || f2 <= 0.0f) {
            return f > ((float) (getWidth() - this.oWW)) && f2 < 0.0f;
        }
        return true;
    }

    private void DbA(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.BDs : 0, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            wC();
            return false;
        }
        if (action != 0) {
            if (this.KM) {
                return true;
            }
            if (this.VM) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.cyF = x;
            this.nro = x;
            float y = motionEvent.getY();
            this.eU = y;
            this.Cp = y;
            this.dZ = motionEvent.getPointerId(0);
            this.VM = false;
            this.nn = true;
            this.NU.computeScrollOffset();
            if (this.GMY == 2 && Math.abs(this.NU.getFinalX() - this.NU.getCurrX()) > this.Za) {
                this.NU.abortAnimation();
                this.ujq = false;
                Os();
                this.KM = true;
                Os(true);
                setScrollState(1);
            } else {
                eli(false);
                this.KM = false;
            }
        } else if (action == 2) {
            int i = this.dZ;
            if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                float x2 = motionEvent.getX(findPointerIndex);
                float f = x2 - this.nro;
                float abs = Math.abs(f);
                float y2 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y2 - this.eU);
                if (f != 0.0f && !eli(this.nro, f) && eli(this, false, (int) f, (int) x2, (int) y2)) {
                    this.nro = x2;
                    this.Cp = y2;
                    this.VM = true;
                    return false;
                }
                int i2 = this.qj;
                if (abs > i2 && abs * 0.5f > abs2) {
                    this.KM = true;
                    Os(true);
                    setScrollState(1);
                    this.nro = f > 0.0f ? this.cyF + this.qj : this.cyF - this.qj;
                    this.Cp = y2;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > i2) {
                    this.VM = true;
                }
                if (this.KM && DbA(x2)) {
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            eli(motionEvent);
        }
        if (this.SSo == null) {
            this.SSo = VelocityTracker.obtain();
        }
        this.SSo.addMovement(motionEvent);
        return this.KM;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.wC.DbA dbA;
        int findPointerIndex;
        if (this.ikX) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (dbA = this.Os) == null || dbA.eli() == 0) {
            return false;
        }
        if (this.SSo == null) {
            this.SSo = VelocityTracker.obtain();
        }
        this.SSo.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.NU.abortAnimation();
            this.ujq = false;
            Os();
            float x = motionEvent.getX();
            this.cyF = x;
            this.nro = x;
            float y = motionEvent.getY();
            this.eU = y;
            this.Cp = y;
            this.dZ = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.KM) {
                    int findPointerIndex2 = motionEvent.findPointerIndex(this.dZ);
                    if (findPointerIndex2 == -1) {
                        z = wC();
                    } else {
                        float x2 = motionEvent.getX(findPointerIndex2);
                        float abs = Math.abs(x2 - this.nro);
                        float y2 = motionEvent.getY(findPointerIndex2);
                        float abs2 = Math.abs(y2 - this.Cp);
                        if (abs > this.qj && abs > abs2) {
                            this.KM = true;
                            Os(true);
                            float f = this.cyF;
                            this.nro = x2 - f > 0.0f ? f + this.qj : f - this.qj;
                            this.Cp = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.KM && (findPointerIndex = motionEvent.findPointerIndex(this.dZ)) != -1) {
                    z = DbA(motionEvent.getX(findPointerIndex));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex != -1) {
                        this.nro = motionEvent.getX(actionIndex);
                        this.dZ = motionEvent.getPointerId(actionIndex);
                    }
                } else if (action == 6) {
                    eli(motionEvent);
                    int findPointerIndex3 = motionEvent.findPointerIndex(this.dZ);
                    if (findPointerIndex3 != -1) {
                        this.nro = motionEvent.getX(findPointerIndex3);
                    }
                }
            } else if (this.KM) {
                eli(this.aGH, true, 0, false);
                z = wC();
            }
        } else if (this.KM) {
            VelocityTracker velocityTracker = this.SSo;
            velocityTracker.computeCurrentVelocity(1000, this.FS);
            int xVelocity = (int) velocityTracker.getXVelocity(this.dZ);
            this.ujq = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            DbA FC = FC();
            float f2 = clientWidth;
            int i = FC.DbA;
            float f3 = ((scrollX / f2) - FC.ui) / (FC.aGH + (this.aqO / f2));
            int findPointerIndex4 = motionEvent.findPointerIndex(this.dZ);
            if (findPointerIndex4 != -1) {
                eli(eli(i, f3, xVelocity, (int) (motionEvent.getX(findPointerIndex4) - this.cyF)), true, true, xVelocity);
                z = wC();
            }
        }
        if (z) {
            postInvalidateOnAnimation();
        }
        return true;
    }

    private boolean wC() {
        this.dZ = -1;
        aAs();
        this.tGZ.onRelease();
        this.WfR.onRelease();
        return this.tGZ.isFinished() || this.WfR.isFinished();
    }

    private void Os(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean DbA(float f) {
        boolean z;
        boolean z2;
        float f2 = this.nro - f;
        this.nro = f;
        float scrollX = getScrollX() + f2;
        float clientWidth = getClientWidth();
        float f3 = this.Xb * clientWidth;
        float f4 = this.bf * clientWidth;
        boolean z3 = false;
        DbA dbA = this.kb.get(0);
        ArrayList<DbA> arrayList = this.kb;
        DbA dbA2 = arrayList.get(arrayList.size() - 1);
        if (dbA.DbA != 0) {
            f3 = dbA.ui * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (dbA2.DbA != this.Os.eli() - 1) {
            f4 = dbA2.ui * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.tGZ.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.WfR.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.nro += scrollX - i;
        scrollTo(i, getScrollY());
        aGH(i);
        return z3;
    }

    private DbA FC() {
        int i;
        int clientWidth = getClientWidth();
        float f = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.aqO / clientWidth : 0.0f;
        int i2 = 0;
        boolean z = true;
        DbA dbA = null;
        int i3 = -1;
        float f3 = 0.0f;
        while (i2 < this.kb.size()) {
            DbA dbA2 = this.kb.get(i2);
            if (!z && dbA2.DbA != (i = i3 + 1)) {
                dbA2 = this.wC;
                dbA2.ui = f + f3 + f2;
                dbA2.DbA = i;
                dbA2.aGH = this.Os.eli(dbA2.DbA);
                i2--;
            }
            DbA dbA3 = dbA2;
            f = dbA3.ui;
            float f4 = dbA3.aGH + f + f2;
            if (!z && scrollX < f) {
                break;
            }
            if (scrollX < f4 || i2 == this.kb.size() - 1) {
                return dbA3;
            }
            int i4 = dbA3.DbA;
            float f5 = dbA3.aGH;
            i2++;
            i3 = i4;
            f3 = f5;
            dbA = dbA3;
            z = false;
        }
        return dbA;
    }

    private int eli(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.jh || Math.abs(i2) <= this.Uv) {
            i += (int) (f + (i >= this.aGH ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.kb.size() <= 0) {
            return i;
        }
        return Math.max(this.kb.get(0).DbA, Math.min(i, this.kb.get(r4.size() - 1).DbA));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        com.bytedance.adsdk.ugeno.wC.DbA dbA;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (dbA = this.Os) != null && dbA.eli() > 1)) {
            if (!this.tGZ.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.Xb * width);
                this.tGZ.setSize(height, width);
                z = this.tGZ.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.WfR.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.bf + 1.0f)) * width2);
                this.WfR.setSize(height2, width2);
                z |= this.WfR.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.tGZ.finish();
            this.WfR.finish();
        }
        if (z) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        float f2;
        int i;
        super.onDraw(canvas);
        if (this.aqO <= 0 || this.dV == null || this.kb.size() <= 0 || this.Os == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f3 = this.aqO / width;
        int i2 = 0;
        DbA dbA = this.kb.get(0);
        float f4 = dbA.ui;
        int size = this.kb.size();
        int i3 = dbA.DbA;
        int i4 = this.kb.get(size - 1).DbA;
        while (i3 < i4) {
            while (i3 > dbA.DbA && i2 < size) {
                i2++;
                dbA = this.kb.get(i2);
            }
            if (i3 == dbA.DbA) {
                f2 = (dbA.ui + dbA.aGH) * width;
                f = dbA.ui + dbA.aGH + f3;
            } else {
                float eli2 = this.Os.eli(i3);
                float f5 = (f4 + eli2) * width;
                f = f4 + eli2 + f3;
                f2 = f5;
            }
            if (this.aqO + f2 > scrollX) {
                i = scrollX;
                this.dV.setBounds(Math.round(f2), this.nGm, Math.round(this.aqO + f2), this.QX);
                this.dV.draw(canvas);
            } else {
                i = scrollX;
            }
            if (f2 > i + r2) {
                return;
            }
            i3++;
            f4 = f;
            scrollX = i;
        }
    }

    private void eli(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.dZ) {
            int i = actionIndex == 0 ? 1 : 0;
            this.nro = motionEvent.getX(i);
            this.dZ = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.SSo;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void aAs() {
        this.KM = false;
        this.VM = false;
        VelocityTracker velocityTracker = this.SSo;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.SSo = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.gG != z) {
            this.gG = z;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.Os == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) clientWidth) * this.Xb)) : i > 0 && scrollX < ((int) (((float) clientWidth) * this.bf));
    }

    protected boolean eli(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && eli(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || eli(keyEvent);
    }

    public boolean eli(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 21) {
            if (keyEvent.hasModifiers(2)) {
                return aGH();
            }
            return Os(17);
        }
        if (keyCode == 22) {
            if (keyEvent.hasModifiers(2)) {
                return ui();
            }
            return Os(66);
        }
        if (keyCode != 61) {
            return false;
        }
        if (keyEvent.hasNoModifiers()) {
            return Os(2);
        }
        if (keyEvent.hasModifiers(1)) {
            return Os(1);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b6, code lost:
    
        if (r6 != 2) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Os(int i) {
        View findNextFocus;
        boolean aGH2;
        View findFocus = findFocus();
        if (findFocus != this) {
            if (findFocus != null) {
                for (ViewParent parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        break;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(findFocus.getClass().getSimpleName());
                for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ").append(parent2.getClass().getSimpleName());
                }
                Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
            if (findNextFocus != null || findNextFocus == findFocus) {
                if (i != 17 || i == 1) {
                    aGH2 = aGH();
                } else {
                    if (i != 66) {
                    }
                    aGH2 = ui();
                }
            } else if (i == 17) {
                int i2 = eli(this.FC, findNextFocus).left;
                int i3 = eli(this.FC, findFocus).left;
                if (findFocus != null && i2 >= i3) {
                    aGH2 = aGH();
                } else {
                    aGH2 = findNextFocus.requestFocus();
                }
            } else {
                if (i == 66) {
                    int i4 = eli(this.FC, findNextFocus).left;
                    int i5 = eli(this.FC, findFocus).left;
                    if (findFocus == null || i4 > i5) {
                        aGH2 = findNextFocus.requestFocus();
                    }
                    aGH2 = ui();
                }
                aGH2 = false;
            }
            if (aGH2) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return aGH2;
        }
        findFocus = null;
        findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        if (findNextFocus != null) {
        }
        if (i != 17) {
        }
        aGH2 = aGH();
        if (aGH2) {
        }
        return aGH2;
    }

    private Rect eli(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    boolean aGH() {
        int i = this.aGH;
        if (i <= 0) {
            return false;
        }
        eli(i - 1, true);
        return true;
    }

    boolean ui() {
        com.bytedance.adsdk.ugeno.wC.DbA dbA = this.Os;
        if (dbA == null || this.aGH >= dbA.eli() - 1) {
            return false;
        }
        eli(this.aGH + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        DbA eli2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (eli2 = eli(childAt)) != null && eli2.DbA == this.aGH) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        DbA eli2;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (eli2 = eli(childAt)) != null && eli2.DbA == this.aGH) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int i4;
        DbA eli2;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = childCount;
            i2 = 0;
            i4 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
            i4 = -1;
        }
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (eli2 = eli(childAt)) != null && eli2.DbA == this.aGH && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        DbA eli2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (eli2 = eli(childAt)) != null && eli2.DbA == this.aGH && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0127Os();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0127Os) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0127Os(getContext(), attributeSet);
    }

    private class MGA extends DataSetObserver {
        MGA() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Os.this.DbA();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Os.this.DbA();
        }
    }

    /* renamed from: com.bytedance.adsdk.ugeno.wC.Os$Os, reason: collision with other inner class name */
    public static class C0127Os extends ViewGroup.LayoutParams {
        public int DbA;
        int MGA;
        float Os;
        boolean aGH;
        public boolean eli;
        int ui;

        public C0127Os() {
            super(-1, -1);
            this.Os = 0.0f;
        }

        public C0127Os(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.Os = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Os.DbA);
            this.DbA = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    static class wC implements Comparator<View> {
        wC() {
        }

        @Override // java.util.Comparator
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            C0127Os c0127Os = (C0127Os) view.getLayoutParams();
            C0127Os c0127Os2 = (C0127Os) view2.getLayoutParams();
            if (c0127Os.eli != c0127Os2.eli) {
                return c0127Os.eli ? 1 : -1;
            }
            return c0127Os.ui - c0127Os2.ui;
        }
    }
}
