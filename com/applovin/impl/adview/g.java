package com.applovin.impl.adview;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.applovin.impl.adview.e;

/* loaded from: classes2.dex */
public class g extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private e f389a;
    private int b;

    public g(e.a aVar, Activity activity) {
        super(activity);
        setBackgroundColor(0);
        e a2 = e.a(aVar, activity);
        this.f389a = a2;
        addView(a2);
    }

    public void a(e.a aVar) {
        if (aVar == null || aVar == this.f389a.getStyle()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f389a.getLayoutParams();
        removeView(this.f389a);
        e a2 = e.a(aVar, getContext());
        this.f389a = a2;
        addView(a2);
        this.f389a.setLayoutParams(layoutParams);
        this.f389a.a(this.b);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.b = i;
        int i5 = i2 + i + i3;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i5;
            layoutParams.width = i5;
        } else {
            setLayoutParams(new FrameLayout.LayoutParams(i5, i5));
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i, i4);
        layoutParams2.setMargins(i3, i3, i3, 0);
        this.f389a.setLayoutParams(layoutParams2);
        this.f389a.a(i);
    }
}
