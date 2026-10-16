package com.fyber.inneractive.sdk.flow;

import android.os.CountDownTimer;

/* loaded from: classes4.dex */
public final class k0 extends CountDownTimer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f1208a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(n0 n0Var, long j) {
        super(j, 1000L);
        this.f1208a = n0Var;
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        k0 k0Var = this.f1208a.v;
        if (k0Var != null) {
            k0Var.cancel();
        }
        this.f1208a.d(false);
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        int i = ((int) j) / 1000;
        com.fyber.inneractive.sdk.interfaces.e eVar = this.f1208a.k;
        if (eVar != null) {
            eVar.updateCloseCountdown(i);
        }
    }
}
