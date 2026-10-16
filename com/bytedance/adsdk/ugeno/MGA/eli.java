package com.bytedance.adsdk.ugeno.MGA;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.adjust.sdk.Constants;
import com.bytedance.adsdk.ugeno.wC.Os;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public abstract class eli<T> extends FrameLayout implements Os.aGH {
    private static final Interpolator Ue = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.MGA.eli.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private FrameLayout CMM;
    protected com.bytedance.adsdk.ugeno.wC.Os DbA;
    private boolean Dfc;
    private int FC;
    private final Runnable KM;
    private int MGA;
    private boolean NU;
    protected Context Os;
    private int QX;
    private final Runnable VM;
    private C0120eli Vy;
    private int Xb;
    private String aAs;
    private int aGH;
    private boolean aqO;
    private int bf;
    private boolean dV;
    private float du;
    protected List<T> eli;
    private com.bytedance.adsdk.ugeno.MGA.eli.eli ev;
    private com.bytedance.adsdk.ugeno.MGA.Os gG;
    private int kb;
    private int nGm;
    private boolean nlS;
    private boolean nn;
    private int ui;
    private Scroller ujq;
    private int wC;

    public abstract View aAs(int i);

    public eli(Context context) {
        super(context);
        this.eli = new CopyOnWriteArrayList();
        this.aGH = 2000;
        this.ui = 500;
        this.MGA = 500;
        this.kb = 0;
        this.wC = -1;
        this.FC = -1;
        this.aAs = Constants.NORMAL;
        this.du = 1.0f;
        this.nlS = true;
        this.NU = true;
        this.nn = true;
        this.Dfc = true;
        this.nGm = 0;
        this.QX = 0;
        this.Xb = 0;
        this.bf = 0;
        this.KM = new Runnable() { // from class: com.bytedance.adsdk.ugeno.MGA.eli.2
            @Override // java.lang.Runnable
            public void run() {
                int currentItem = eli.this.DbA.getCurrentItem() + 1;
                if (eli.this.nn) {
                    if (currentItem >= 1024) {
                        eli.this.DbA.eli(512, false);
                        return;
                    } else {
                        eli.this.DbA.eli(currentItem, true);
                        return;
                    }
                }
                com.bytedance.adsdk.ugeno.wC.DbA adapter = eli.this.DbA.getAdapter();
                if (adapter != null) {
                    if (currentItem >= adapter.eli()) {
                        eli.this.DbA.eli(0, false);
                    } else {
                        eli.this.DbA.eli(currentItem, true);
                    }
                }
            }
        };
        this.VM = new Runnable() { // from class: com.bytedance.adsdk.ugeno.MGA.eli.3
            @Override // java.lang.Runnable
            public void run() {
                if (eli.this.NU) {
                    int currentItem = eli.this.DbA.getCurrentItem() + 1;
                    if (eli.this.nn) {
                        if (currentItem >= 1024) {
                            eli.this.DbA.eli(512, false);
                        } else {
                            eli.this.DbA.eli(currentItem, true);
                        }
                        eli eliVar = eli.this;
                        eliVar.postDelayed(eliVar.VM, eli.this.aGH);
                        return;
                    }
                    com.bytedance.adsdk.ugeno.wC.DbA adapter = eli.this.DbA.getAdapter();
                    if (adapter != null) {
                        if (currentItem >= adapter.eli()) {
                            eli.this.DbA.eli(0, false);
                            eli eliVar2 = eli.this;
                            eliVar2.postDelayed(eliVar2.VM, eli.this.aGH);
                        } else {
                            eli.this.DbA.eli(currentItem, true);
                            eli eliVar3 = eli.this;
                            eliVar3.postDelayed(eliVar3.VM, eli.this.aGH);
                        }
                    }
                }
            }
        };
        this.Os = context;
        this.CMM = new FrameLayout(context);
        this.DbA = eli();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.CMM.addView(this.DbA, layoutParams);
        addView(this.CMM);
    }

    public com.bytedance.adsdk.ugeno.wC.Os eli() {
        return new Os(getContext());
    }

    public eli eli(String str) {
        if (TextUtils.equals(str, "rectangle")) {
            this.ev = new com.bytedance.adsdk.ugeno.MGA.eli.Os(this.Os);
        } else {
            this.ev = new com.bytedance.adsdk.ugeno.MGA.eli.DbA(this.Os);
        }
        addView(this.ev, new FrameLayout.LayoutParams(-2, -2));
        return this;
    }

    public eli eli(float f) {
        this.ev.setIndicatorWidth((int) f);
        return this;
    }

    public eli DbA(float f) {
        this.ev.setIndicatorHeight((int) f);
        return this;
    }

    public eli Os(float f) {
        this.ev.setIndicatorX(f);
        return this;
    }

    public eli aGH(float f) {
        this.ev.setIndicatorY(f);
        return this;
    }

    public eli DbA() {
        this.ev.eli();
        return this;
    }

    public eli DbA(String str) {
        this.ev.setIndicatorDirection(str);
        return this;
    }

    public eli eli(int i) {
        this.bf = i;
        return this;
    }

    public eli eli(boolean z) {
        this.NU = z;
        ui();
        return this;
    }

    public eli DbA(int i) {
        this.ui = i;
        return this;
    }

    public eli Os(int i) {
        this.MGA = i;
        if (this.ujq == null) {
            this.ujq = new DbA(this.Os, Ue);
        }
        this.DbA.setScroller(this.ujq);
        return this;
    }

    public eli aGH(int i) {
        this.aGH = i;
        ui();
        return this;
    }

    public eli DbA(boolean z) {
        this.Dfc = z;
        return this;
    }

    public eli Os(boolean z) {
        this.nlS = z;
        return this;
    }

    public eli ui(int i) {
        this.ev.setSelectedColor(i);
        return this;
    }

    public eli MGA(int i) {
        this.ev.setUnSelectedColor(i);
        return this;
    }

    public eli aGH(boolean z) {
        this.ev.setLoop(z);
        if (this.nn != z) {
            int eli = aGH.eli(z, this.DbA.getCurrentItem(), this.eli.size());
            this.nn = z;
            C0120eli c0120eli = this.Vy;
            if (c0120eli != null) {
                c0120eli.Os();
                this.DbA.setCurrentItem(eli);
            }
        }
        return this;
    }

    public eli ui(float f) {
        this.du = f;
        return this;
    }

    public eli Os(String str) {
        this.aAs = str;
        eli(str, this.kb, this.wC, this.FC, true);
        return this;
    }

    public eli kb(int i) {
        this.kb = i;
        eli(this.aAs, i, this.wC, this.FC, true);
        return this;
    }

    public eli<T> wC(int i) {
        this.wC = i;
        eli(this.aAs, this.kb, i, this.FC, true);
        return this;
    }

    public eli FC(int i) {
        this.FC = i;
        eli(this.aAs, this.kb, this.wC, i, true);
        return this;
    }

    public eli ui(boolean z) {
        this.aqO = z;
        return this;
    }

    public void eli(String str, int i, int i2, int i3, boolean z) {
        C0120eli c0120eli = this.Vy;
        if (c0120eli != null) {
            c0120eli.Os();
        }
        this.DbA.setPageMargin(i);
        if (i2 > 0 || i3 > 0) {
            if (this.bf == 1) {
                this.DbA.setPadding(0, i2 + i, 0, i3 + i);
            } else {
                this.DbA.setPadding(i2 + i, 0, i3 + i, 0);
            }
            this.CMM.setClipChildren(false);
            this.DbA.setClipChildren(false);
            this.DbA.setClipToPadding(false);
        }
        if (this.bf == 1) {
            com.bytedance.adsdk.ugeno.MGA.DbA.aGH agh = new com.bytedance.adsdk.ugeno.MGA.DbA.aGH();
            agh.eli(str);
            this.DbA.eli(true, (Os.ui) agh);
            this.DbA.setOverScrollMode(2);
        } else if (TextUtils.equals(str, "linear")) {
            this.DbA.eli(false, (Os.ui) new com.bytedance.adsdk.ugeno.MGA.DbA.Os());
        } else if (TextUtils.equals(str, "cube")) {
            this.DbA.eli(false, (Os.ui) new com.bytedance.adsdk.ugeno.MGA.DbA.eli());
        } else if (TextUtils.equals(str, "fade")) {
            this.DbA.eli(false, (Os.ui) new com.bytedance.adsdk.ugeno.MGA.DbA.DbA());
        } else {
            this.DbA.eli(false, (Os.ui) null);
        }
        this.DbA.setOffscreenPageLimit((int) this.du);
    }

    public void Os() {
        int i;
        eli(this.aAs, this.kb, this.wC, this.FC, true);
        if (this.Vy == null) {
            this.Vy = new C0120eli();
            this.DbA.eli((Os.aGH) this);
            this.DbA.setAdapter(this.Vy);
        }
        int i2 = this.nGm;
        if (i2 < 0 || i2 >= this.eli.size()) {
            this.nGm = 0;
        }
        if (this.nn) {
            i = this.nGm + 512;
        } else {
            i = this.nGm;
        }
        this.DbA.eli(i, true);
        if (!this.nn) {
            du(i);
        }
        if (this.NU) {
            ui();
        }
    }

    public void setTwoItems(boolean z) {
        this.dV = z;
    }

    public void aGH() {
        MGA();
        if (this.Vy != null) {
            this.DbA.DbA((Os.aGH) this);
            this.DbA.setAdapter(null);
            this.Vy = null;
            this.DbA.removeAllViews();
            this.eli.clear();
            this.ev.Os();
        }
    }

    public View eli(int i, int i2) {
        if (this.eli.size() == 0) {
            return new View(getContext());
        }
        View aAs = aAs(i2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (aAs instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (kb()) {
            aAs.setTag("two_items_tag");
        }
        if (aAs.getParent() instanceof ViewGroup) {
            ((ViewGroup) aAs.getParent()).removeView(aAs);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(aAs, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        if (kb()) {
            frameLayout.setTag(Integer.valueOf(i));
        }
        return frameLayout;
    }

    public eli<T> eli(T t) {
        if (t != null) {
            this.eli.add(t);
            if (this.nlS) {
                this.ev.DbA();
            }
        }
        C0120eli c0120eli = this.Vy;
        if (c0120eli != null) {
            c0120eli.Os();
            this.ev.eli(this.nGm, this.DbA.getCurrentItem());
        }
        return this;
    }

    @Override // com.bytedance.adsdk.ugeno.wC.Os.aGH
    public void eli(int i, float f, int i2) {
        com.bytedance.adsdk.ugeno.MGA.Os os = this.gG;
        if (os != null) {
            boolean z = this.nn;
            os.eli(z, aGH.eli(z, i, this.eli.size()), f, i2);
        }
        if (kb()) {
            eli(i, findViewWithTag(Integer.valueOf(i)));
            if (f > 0.0f) {
                int i3 = i + 1;
                eli(i3, findViewWithTag(Integer.valueOf(i3)));
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.wC.Os.aGH
    public void du(int i) {
        int i2;
        if (this.gG != null) {
            int eli = aGH.eli(this.nn, i, this.eli.size());
            i2 = i;
            this.gG.eli(this.nn, eli, i2, eli == 0, eli == this.eli.size() - 1);
        } else {
            i2 = i;
        }
        if (this.nlS) {
            this.ev.eli(i2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.wC.Os.aGH
    public void nlS(int i) {
        if (i == 1 && this.aqO) {
            MGA();
        }
        com.bytedance.adsdk.ugeno.MGA.Os os = this.gG;
        if (os != null) {
            os.eli(this.nn, i);
        }
    }

    /* renamed from: com.bytedance.adsdk.ugeno.MGA.eli$eli, reason: collision with other inner class name */
    class C0120eli extends com.bytedance.adsdk.ugeno.wC.DbA {
        @Override // com.bytedance.adsdk.ugeno.wC.DbA
        public int eli(Object obj) {
            return -2;
        }

        @Override // com.bytedance.adsdk.ugeno.wC.DbA
        public boolean eli(View view, Object obj) {
            return view == obj;
        }

        C0120eli() {
        }

        @Override // com.bytedance.adsdk.ugeno.wC.DbA
        public int eli() {
            if (eli.this.nn) {
                return 1024;
            }
            return eli.this.eli.size();
        }

        @Override // com.bytedance.adsdk.ugeno.wC.DbA
        public Object eli(ViewGroup viewGroup, int i) {
            View eli = eli.this.eli(i, aGH.eli(eli.this.nn, i, eli.this.eli.size()));
            viewGroup.addView(eli);
            return eli;
        }

        @Override // com.bytedance.adsdk.ugeno.wC.DbA
        public void eli(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // com.bytedance.adsdk.ugeno.wC.DbA
        public float eli(int i) {
            if (eli.this.du <= 0.0f) {
                return 1.0f;
            }
            return 1.0f / eli.this.du;
        }
    }

    public void ui() {
        removeCallbacks(this.VM);
        postDelayed(this.VM, this.aGH);
    }

    public void MGA() {
        removeCallbacks(this.VM);
    }

    public void NU(int i) {
        eli(this.aAs, this.kb, this.wC, this.FC, true);
        if (this.Vy == null) {
            this.Vy = new C0120eli();
            this.DbA.eli((Os.aGH) this);
            this.DbA.setAdapter(this.Vy);
        }
        if (this.nn) {
            if (i >= 1024) {
                this.DbA.eli(512, false);
                return;
            } else {
                this.DbA.eli(i, true);
                return;
            }
        }
        if (i < 0 || i >= this.eli.size()) {
            return;
        }
        this.DbA.eli(i, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.NU) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                if (!this.aqO) {
                    ui();
                }
            } else if (action == 0) {
                MGA();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCurrentItem() {
        return this.DbA.getCurrentItem();
    }

    public com.bytedance.adsdk.ugeno.wC.DbA getAdapter() {
        return this.DbA.getAdapter();
    }

    public com.bytedance.adsdk.ugeno.wC.Os getViewPager() {
        return this.DbA;
    }

    public void setOnPageChangeListener(com.bytedance.adsdk.ugeno.MGA.Os os) {
        this.gG = os;
    }

    public class Os extends com.bytedance.adsdk.ugeno.wC.Os {
        public Os(Context context) {
            super(context);
        }

        @Override // com.bytedance.adsdk.ugeno.wC.Os, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!eli.this.Dfc) {
                return false;
            }
            try {
                if (eli.this.bf == 1) {
                    boolean onInterceptTouchEvent = super.onInterceptTouchEvent(eli(motionEvent));
                    eli(motionEvent);
                    return onInterceptTouchEvent;
                }
                return super.onInterceptTouchEvent(motionEvent);
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.wC.Os, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!eli.this.Dfc) {
                return false;
            }
            try {
                if (eli.this.bf == 1) {
                    return super.onTouchEvent(eli(motionEvent));
                }
                return super.onTouchEvent(motionEvent);
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        private MotionEvent eli(MotionEvent motionEvent) {
            float width = getWidth();
            float height = getHeight();
            motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
            return motionEvent;
        }
    }

    private class DbA extends Scroller {
        public DbA(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, eli.this.MGA);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4) {
            super.startScroll(i, i2, i3, i4, eli.this.MGA);
        }
    }

    private void eli(int i, View view) {
        View findViewWithTag;
        if ((view instanceof ViewGroup) && (findViewWithTag = view.findViewWithTag("two_items_tag")) == null) {
            T t = this.eli.get(aGH.eli(true, i, this.eli.size()));
            if (t == null) {
                return;
            }
            if (t instanceof com.bytedance.adsdk.ugeno.DbA.Os) {
                findViewWithTag = ((com.bytedance.adsdk.ugeno.DbA.Os) t).du();
            } else if (t instanceof View) {
                findViewWithTag = (View) t;
            }
            if (findViewWithTag == null) {
                return;
            }
            if (findViewWithTag.getParent() instanceof ViewGroup) {
                ((ViewGroup) findViewWithTag.getParent()).removeView(findViewWithTag);
            }
            ((ViewGroup) view).addView(findViewWithTag);
        }
    }

    private boolean kb() {
        return this.eli.size() <= 2 && this.nn;
    }
}
