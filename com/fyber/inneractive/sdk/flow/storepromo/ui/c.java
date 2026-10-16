package com.fyber.inneractive.sdk.flow.storepromo.ui;

import android.content.Context;
import android.content.IntentFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.o;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public View f1238a;
    public ViewGroup b;
    public final Animation c;
    public final Animation d;
    public b e;
    public com.fyber.inneractive.sdk.flow.storepromo.b f;
    public final float g;
    public int h = -1;
    public final a i = new a(this);

    public c(Context context, View view, com.fyber.inneractive.sdk.flow.storepromo.b bVar) {
        float f;
        this.f1238a = view;
        this.c = AnimationUtils.loadAnimation(context, R.anim.store_promo_appear_anim);
        this.d = AnimationUtils.loadAnimation(context, R.anim.store_promo_disappear_anim);
        o oVar = IAConfigManager.O.u.b;
        oVar.getClass();
        try {
            f = Float.parseFloat(oVar.a("dtx_store_promo_height", Float.toString(0.7f)));
        } catch (Throwable unused) {
            f = 0.7f;
        }
        this.g = Math.max(f, 0.7f);
        this.f = bVar;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.dt_store_promo_layout, (ViewGroup) null);
        this.b = viewGroup;
        viewGroup.setOnClickListener(null);
        this.b.setBackgroundColor(context.getResources().getColor(R.color.dtx_store_promo_bg_fade));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        this.f1238a.setLayoutParams(layoutParams2);
        this.b.setVisibility(8);
        ViewGroup viewGroup2 = this.b;
        if (viewGroup2 != null) {
            viewGroup2.setLayoutParams(layoutParams);
            this.b.addView(this.f1238a);
        }
        if (this.e == null) {
            b bVar2 = new b(this);
            this.e = bVar2;
            com.fyber.inneractive.sdk.util.o.f1770a.registerReceiver(bVar2, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }
    }

    public final void a() {
        View view;
        int c = com.fyber.inneractive.sdk.util.o.c();
        if (c == this.h || (view = this.f1238a) == null || view.getLayoutParams() == null) {
            return;
        }
        this.h = c;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f1238a.getLayoutParams();
        layoutParams.height = c == 2 ? com.fyber.inneractive.sdk.util.o.e() : (int) (com.fyber.inneractive.sdk.util.o.d() * this.g);
        this.f1238a.setLayoutParams(layoutParams);
    }
}
