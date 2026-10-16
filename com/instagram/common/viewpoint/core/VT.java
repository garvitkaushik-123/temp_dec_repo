package com.instagram.common.viewpoint.core;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: assets/audience_network/classes2.dex */
public class VT implements View.OnTouchListener {
    public final /* synthetic */ C1413Vz A00;
    public final /* synthetic */ boolean A01;
    public final /* synthetic */ boolean A02;

    public VT(C1413Vz c1413Vz, boolean z, boolean z2) {
        this.A00 = c1413Vz;
        this.A02 = z;
        this.A01 = z2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        C1929gi c1929gi;
        if (this.A02) {
            return false;
        }
        if (!this.A01) {
            return true;
        }
        c1929gi = this.A00.A04;
        if (C1379Up.A1X(c1929gi)) {
            return false;
        }
        return true;
    }
}
