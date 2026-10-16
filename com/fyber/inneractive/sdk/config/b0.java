package com.fyber.inneractive.sdk.config;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InvalidAppIdException;
import com.fyber.inneractive.sdk.network.g1;
import com.fyber.inneractive.sdk.network.i1;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.FileNotFoundException;

/* loaded from: classes4.dex */
public final class b0 implements com.fyber.inneractive.sdk.network.e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAConfigManager f1071a;

    public b0(IAConfigManager iAConfigManager) {
        this.f1071a = iAConfigManager;
    }

    @Override // com.fyber.inneractive.sdk.network.e0
    public final void a(Object obj, Exception exc, boolean z) {
        int i;
        h0 h0Var = (h0) obj;
        if (h0Var != null) {
            if (z) {
                IAConfigManager iAConfigManager = this.f1071a;
                IAConfigManager iAConfigManager2 = IAConfigManager.O;
                iAConfigManager.getClass();
                iAConfigManager.e = h0Var.c;
                iAConfigManager.d = h0Var.b;
                iAConfigManager.f1068a = h0Var.d;
                iAConfigManager.b = h0Var.e;
            } else {
                IAConfigManager.P = System.currentTimeMillis();
                IAConfigManager iAConfigManager3 = this.f1071a;
                iAConfigManager3.getClass();
                IAlog.a("Got new remote configuration from server:", new Object[0]);
                iAConfigManager3.e = h0Var.c;
                iAConfigManager3.d = h0Var.b;
                iAConfigManager3.f1068a = h0Var.d;
                iAConfigManager3.b = h0Var.e;
            }
        } else if (exc instanceof com.fyber.inneractive.sdk.network.g) {
            IAConfigManager.P = System.currentTimeMillis();
        }
        if (z) {
            return;
        }
        IAConfigManager iAConfigManager4 = this.f1071a;
        IAConfigManager iAConfigManager5 = IAConfigManager.O;
        if (iAConfigManager5.e != null) {
            iAConfigManager4.a(null);
        } else {
            iAConfigManager4.getClass();
            if ((exc instanceof InvalidAppIdException) || (exc instanceof FileNotFoundException) || (!(exc instanceof i1) ? !TextUtils.isEmpty(iAConfigManager4.c.trim()) : (i = ((i1) exc).f1324a) < 400 || i >= 500)) {
                iAConfigManager4.a(new InvalidAppIdException());
            } else if (exc instanceof com.fyber.inneractive.sdk.network.b) {
                iAConfigManager4.a(exc);
            } else {
                iAConfigManager4.a(new i0());
            }
        }
        if (iAConfigManager5.e != null) {
            IAConfigManager iAConfigManager6 = this.f1071a;
            if (iAConfigManager6.C == null) {
                iAConfigManager6.C = new com.fyber.inneractive.sdk.network.t0(new e0(iAConfigManager6), iAConfigManager6.f, new com.fyber.inneractive.sdk.config.global.m());
            }
            g1 g1Var = iAConfigManager6.C.f;
            if (g1Var == g1.RUNNING || g1Var == g1.QUEUED) {
                return;
            }
            iAConfigManager5.s.b(iAConfigManager6.C);
        }
    }
}
