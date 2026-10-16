package com.fyber.inneractive.sdk.player.ui;

import android.content.Context;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.f1;
import com.fyber.inneractive.sdk.util.t;

/* loaded from: classes4.dex */
public abstract class s extends e {
    public final int i;
    public final int j;
    public final int k;
    public ViewGroup l;
    public Button m;
    public int n;
    public int o;
    public boolean p;
    public ViewGroup q;
    public ViewGroup r;
    public final f1 s;
    public f1 t;
    public TextView u;
    public final com.fyber.inneractive.sdk.config.global.r v;
    public final String w;
    public final f1 x;

    public s(Context context, com.fyber.inneractive.sdk.config.global.r rVar, String str) {
        super(context);
        this.n = -1;
        this.o = -1;
        this.p = false;
        this.s = new f1(0, 0);
        this.x = new f1(0, 0);
        IAlog.a("%sctor called", IAlog.a(this));
        int tickFractions = getTickFractions();
        this.j = tickFractions;
        this.i = getMaxTickFactor();
        this.k = 1000 / tickFractions;
        setBackgroundColor(getResources().getColor(R.color.ia_video_background_color));
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.v = rVar;
        this.w = str;
    }

    public abstract void a(int i, int i2);

    public abstract void a(com.fyber.inneractive.sdk.flow.endcard.b bVar, b bVar2);

    public abstract void a(boolean z);

    public void a(boolean z, int i, int i2) {
        this.n = i;
        this.o = i2;
        this.p = z;
    }

    public abstract void a(boolean z, com.fyber.inneractive.sdk.ignite.m mVar);

    public abstract void a(boolean z, String str);

    public abstract void b(boolean z);

    public abstract void c(boolean z);

    public abstract void d(boolean z);

    public void destroy() {
        g();
        setVisibility(8);
        if (this.g != null) {
            this.g = null;
        }
        IAlog.a("%sdestroyed called", IAlog.a(this));
    }

    public abstract void e();

    public abstract void e(boolean z);

    public abstract void f();

    public abstract void f(boolean z);

    public abstract void g();

    public abstract void g(boolean z);

    public ViewGroup getDefaultEndCardContainer() {
        return this.q;
    }

    public abstract View getEndCardView();

    public int getMaxTickFactor() {
        return 1000;
    }

    public ViewGroup getTextureHost() {
        return this.l;
    }

    public int getTickFractions() {
        return 5;
    }

    public abstract View[] getTrackingFriendlyView();

    public abstract View[] getTrackingFriendlyViewObstructionPurposeOther();

    public int getVideoHeight() {
        return this.o;
    }

    public int getVideoWidth() {
        return this.n;
    }

    public final boolean h() {
        return this.q.getVisibility() == 0 || this.r.getChildCount() > 0;
    }

    public abstract boolean i();

    public abstract void j();

    public abstract void k();

    public abstract boolean l();

    public abstract void m();

    public abstract void n();

    public abstract void o();

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        a(this.x, size, size2);
        f1 f1Var = this.x;
        int i3 = f1Var.f1758a;
        if (i3 <= 0 || f1Var.b <= 0) {
            f1Var.f1758a = size;
            f1Var.b = size2;
        } else {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(this.x.b, 1073741824);
            i = makeMeasureSpec;
        }
        if (!this.s.equals(this.x)) {
            f1 f1Var2 = this.s;
            f1 f1Var3 = this.x;
            f1Var2.getClass();
            f1Var2.f1758a = f1Var3.f1758a;
            f1Var2.b = f1Var3.b;
            o();
        }
        super.onMeasure(i, i2);
    }

    public abstract void setAppInfoButtonRound(TextView textView);

    public abstract void setMuteButtonState(boolean z);

    public abstract void setRemainingTime(String str);

    public abstract void setSkipText(String str);

    public void a(com.fyber.inneractive.sdk.flow.endcard.d dVar, b bVar) {
        ViewGroup defaultEndCardContainer = getDefaultEndCardContainer();
        if (defaultEndCardContainer != null) {
            defaultEndCardContainer.setVisibility(0);
            n nVar = this.g;
            com.fyber.inneractive.sdk.flow.endcard.f fVar = (com.fyber.inneractive.sdk.flow.endcard.f) dVar.f();
            fVar.a(bVar, nVar);
            ViewGroup viewGroup = fVar.c;
            t.a(viewGroup);
            defaultEndCardContainer.addView(viewGroup);
            dVar.a(dVar.e, dVar.c);
        }
    }

    public final void a(View view, int i) {
        if (view != null) {
            view.setOnTouchListener(new r(new GestureDetector(view.getContext(), new q(this, view, new int[2], i))));
        }
    }
}
