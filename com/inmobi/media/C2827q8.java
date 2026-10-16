package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.q8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2827q8 extends PagerAdapter implements L8 {

    /* renamed from: a, reason: collision with root package name */
    public final C2811p8 f2682a;
    public final D8 b;
    public final String c;
    public final int d;
    public final Handler e;
    public boolean f;
    public final SparseArray g;

    public C2827q8(C2811p8 mNativeDataModel, D8 mNativeLayoutInflater) {
        Intrinsics.checkNotNullParameter(mNativeDataModel, "mNativeDataModel");
        Intrinsics.checkNotNullParameter(mNativeLayoutInflater, "mNativeLayoutInflater");
        this.f2682a = mNativeDataModel;
        this.b = mNativeLayoutInflater;
        this.c = "q8";
        this.d = 50;
        this.e = new Handler(Looper.getMainLooper());
        this.g = new SparseArray();
    }

    public static final void a(Object item, C2827q8 this$0) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (item instanceof View) {
            D8 d8 = this$0.b;
            View view = (View) item;
            d8.getClass();
            Intrinsics.checkNotNullParameter(view, "view");
            d8.m.a(view);
        }
    }

    @Override // com.inmobi.media.L8
    public final void destroy() {
        this.f = true;
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            this.e.removeCallbacks((Runnable) this.g.get(this.g.keyAt(i)));
        }
        this.g.clear();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup container, int i, final Object item) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof View) {
            container.removeView((View) item);
        }
        Runnable runnable = (Runnable) this.g.get(i);
        if (runnable != null) {
            this.e.removeCallbacks(runnable);
            String TAG = this.c;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        }
        this.e.post(new Runnable() { // from class: com.inmobi.media.q8$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2827q8.a(item, this);
            }
        });
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f2682a.d();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object item) {
        Intrinsics.checkNotNullParameter(item, "item");
        View view = item instanceof View ? (View) item : null;
        Object tag = view != null ? view.getTag() : null;
        if (tag instanceof Integer) {
            return ((Number) tag).intValue();
        }
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup container, int i) {
        View relativeLayout;
        Intrinsics.checkNotNullParameter(container, "container");
        String TAG = this.c;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        C2681h8 b = this.f2682a.b(i);
        if (b == null || (relativeLayout = a(i, container, b)) == null) {
            relativeLayout = new RelativeLayout(container.getContext());
        }
        relativeLayout.setTag(Integer.valueOf(i));
        container.addView(relativeLayout);
        return relativeLayout;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "obj");
        return Intrinsics.areEqual(view, obj);
    }

    public final ViewGroup a(final int i, final ViewGroup parent, final C2681h8 pageContainerAsset) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(pageContainerAsset, "pageContainerAsset");
        final ViewGroup a2 = this.b.a(parent, pageContainerAsset);
        if (a2 == null) {
            return a2;
        }
        int abs = Math.abs(this.b.k - i);
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.q8$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C2827q8.a(C2827q8.this, i, a2, parent, pageContainerAsset);
            }
        };
        this.g.put(i, runnable);
        this.e.postDelayed(runnable, abs * this.d);
        return a2;
    }

    public static final void a(C2827q8 this$0, int i, ViewGroup container, ViewGroup parent, C2681h8 root) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(container, "$it");
        Intrinsics.checkNotNullParameter(parent, "$parent");
        Intrinsics.checkNotNullParameter(root, "$pageContainerAsset");
        if (this$0.f) {
            return;
        }
        this$0.g.remove(i);
        D8 d8 = this$0.b;
        d8.getClass();
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(root, "root");
        d8.b(container, root);
    }
}
