package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.pJ, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2429pJ implements C4X {
    public static final List<C2430pK> A01 = new ArrayList(50);
    public final Handler A00;

    public C2429pJ(Handler handler) {
        this.A00 = handler;
    }

    public static C2430pK A00() {
        C2430pK c2430pK;
        synchronized (A01) {
            c2430pK = A01.isEmpty() ? new C2430pK() : A01.remove(A01.size() - 1);
        }
        return c2430pK;
    }

    public static void A01(C2430pK c2430pK) {
        synchronized (A01) {
            if (A01.size() < 50) {
                A01.add(c2430pK);
            }
        }
    }

    public final boolean A03(Runnable runnable) {
        return this.A00.post(runnable);
    }

    @Override // com.instagram.common.viewpoint.core.C4X
    public final Looper A8R() {
        return this.A00.getLooper();
    }

    @Override // com.instagram.common.viewpoint.core.C4X
    public final boolean A9n(int i) {
        return this.A00.hasMessages(i);
    }

    @Override // com.instagram.common.viewpoint.core.C4X
    public final C2430pK ACg(int i) {
        return A00().A01(this.A00.obtainMessage(i), this);
    }

    @Override // com.instagram.common.viewpoint.core.C4X
    public final C2430pK ACh(int i, int i2, int i3) {
        return A00().A01(this.A00.obtainMessage(i, i2, i3), this);
    }

    @Override // com.instagram.common.viewpoint.core.C4X
    public final C2430pK ACi(int i, int i2, int i3, Object obj) {
        return A00().A01(this.A00.obtainMessage(i, i2, i3, obj), this);
    }

    @Override // com.instagram.common.viewpoint.core.C4X
    public final C2430pK ACj(int i, Object obj) {
        return A00().A01(this.A00.obtainMessage(i, obj), this);
    }

    @Override // com.instagram.common.viewpoint.core.C4X
    public final void AIT(int i) {
        this.A00.removeMessages(i);
    }

    @Override // com.instagram.common.viewpoint.core.C4X
    public final boolean AJA(int i) {
        return this.A00.sendEmptyMessage(i);
    }

    @Override // com.instagram.common.viewpoint.core.C4X
    public final boolean AJB(int i, long j) {
        return this.A00.sendEmptyMessageAtTime(i, j);
    }

    @Override // com.instagram.common.viewpoint.core.C4X
    public final boolean AJD(C4W c4w) {
        return ((C2430pK) c4w).A03(this.A00);
    }
}
