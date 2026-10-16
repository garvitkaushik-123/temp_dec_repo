package com.inmobi.media;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Sc extends K8 implements ViewPager.OnPageChangeListener {
    public final String b;
    public final ViewPager c;
    public final Point d;
    public final Point e;
    public boolean f;
    public D8 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Sc(Context context) {
        super(context, (byte) 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = "Sc";
        this.d = new Point();
        this.e = new Point();
        setClipChildren(false);
        setLayerType(1, null);
        ViewPager viewPager = new ViewPager(getContext());
        this.c = viewPager;
        viewPager.addOnPageChangeListener(this);
        addView(viewPager);
    }

    @Override // com.inmobi.media.K8
    public final void a(C2681h8 scrollableContainerAsset, L8 dataSource, int i, int i2, D8 d8) {
        FrameLayout.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(scrollableContainerAsset, "scrollableContainerAsset");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        C2613d8 c2613d8 = scrollableContainerAsset.B > 0 ? (C2613d8) scrollableContainerAsset.A.get(0) : null;
        if (c2613d8 != null) {
            HashMap hashMap = D9.c;
            ViewGroup.LayoutParams a2 = C2779n9.a(c2613d8, this);
            Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            layoutParams = (FrameLayout.LayoutParams) a2;
            layoutParams.setMarginStart(20);
            layoutParams.setMarginEnd(20);
            layoutParams.gravity = i2;
        } else {
            layoutParams = null;
        }
        ViewPager viewPager = this.c;
        if (viewPager != null) {
            viewPager.setLayoutParams(layoutParams);
            viewPager.setAdapter(dataSource instanceof C2827q8 ? (C2827q8) dataSource : null);
            viewPager.setOffscreenPageLimit(2);
            viewPager.setPageMargin(16);
            viewPager.setCurrentItem(i);
        }
        this.g = d8;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i) {
        this.f = i != 0;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i, float f, int i2) {
        if (this.f) {
            invalidate();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i) {
        Intrinsics.checkNotNullExpressionValue(this.b, "TAG");
        ViewPager viewPager = this.c;
        ViewGroup.LayoutParams layoutParams = viewPager != null ? viewPager.getLayoutParams() : null;
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        D8 d8 = this.g;
        if (d8 != null) {
            if (layoutParams2 != null) {
                d8.k = i;
                C2681h8 asset = d8.c.b(i);
                if (asset != null) {
                    C2923w8 c2923w8 = d8.d;
                    Intrinsics.checkNotNullParameter(asset, "asset");
                    C2939x8 c2939x8 = c2923w8.f2742a;
                    if (!c2939x8.f2752a) {
                        T7 t7 = c2939x8.b;
                        t7.getClass();
                        Intrinsics.checkNotNullParameter(asset, "asset");
                        if (!t7.n.contains(Integer.valueOf(i)) && !t7.t) {
                            t7.m();
                            if (!t7.t) {
                                t7.n.add(Integer.valueOf(i));
                                asset.y = System.currentTimeMillis();
                                if (t7.r) {
                                    HashMap a2 = t7.a(asset);
                                    InterfaceC2971z5 interfaceC2971z5 = t7.j;
                                    if (interfaceC2971z5 != null) {
                                        String TAG = t7.m;
                                        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                                        ((A5) interfaceC2971z5).a(TAG, "Page-view impression record request");
                                    }
                                    asset.a("page_view", a2, (L7) null, t7.j);
                                } else {
                                    t7.o.add(asset);
                                }
                            }
                        }
                    }
                }
                int i2 = d8.k;
                layoutParams2.gravity = i2 == 0 ? GravityCompat.START : i2 == d8.c.d() - 1 ? GravityCompat.END : 1;
            }
            ViewPager viewPager2 = this.c;
            if (viewPager2 != null) {
                viewPager2.requestLayout();
            }
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        Point point = this.d;
        point.x = i / 2;
        point.y = i2 / 2;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent ev) {
        double ceil;
        double ceil2;
        int i;
        Intrinsics.checkNotNullParameter(ev, "ev");
        int action = ev.getAction();
        if (action == 0) {
            this.e.x = (int) ev.getX();
            this.e.y = (int) ev.getY();
            int i2 = this.d.x;
            Point point = this.e;
            ev.offsetLocation(i2 - point.x, r0.y - point.y);
        } else if (action != 1) {
            int i3 = this.d.x;
            Point point2 = this.e;
            ev.offsetLocation(i3 - point2.x, r0.y - point2.y);
        } else {
            float f = this.e.x;
            float x = ev.getX();
            ViewPager viewPager = this.c;
            Intrinsics.checkNotNull(viewPager);
            int currentItem = viewPager.getCurrentItem();
            PagerAdapter adapter = this.c.getAdapter();
            Intrinsics.checkNotNull(adapter);
            int count = adapter.getCount();
            int width = this.c.getWidth();
            int width2 = getWidth();
            if (currentItem == 0 || count - 1 == currentItem) {
                int i4 = width2 - width;
                if (currentItem == 0) {
                    float f2 = i4;
                    if (f > f2 && x > f2) {
                        ceil2 = Math.ceil((x - f2) / width);
                        i = (int) ceil2;
                    }
                } else {
                    float f3 = i4;
                    if (f < f3 && x < f3) {
                        ceil = Math.ceil((f3 - x) / width);
                        ceil2 = -ceil;
                        i = (int) ceil2;
                    }
                }
                i = 0;
            } else {
                float f4 = (width2 - width) / 2;
                if (f >= f4 || x >= f4) {
                    float f5 = (width2 + width) / 2;
                    if (f > f5 && x > f5) {
                        ceil2 = Math.ceil((x - f5) / width);
                        i = (int) ceil2;
                    }
                    i = 0;
                } else {
                    ceil = Math.ceil((f4 - x) / width);
                    ceil2 = -ceil;
                    i = (int) ceil2;
                }
            }
            if (i != 0) {
                ev.setAction(3);
                ViewPager viewPager2 = this.c;
                if (viewPager2 != null) {
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + i);
                }
            }
            int i5 = this.d.x;
            Point point3 = this.e;
            ev.offsetLocation(i5 - point3.x, r0.y - point3.y);
        }
        ViewPager viewPager3 = this.c;
        if (viewPager3 != null) {
            return viewPager3.dispatchTouchEvent(ev);
        }
        return false;
    }
}
