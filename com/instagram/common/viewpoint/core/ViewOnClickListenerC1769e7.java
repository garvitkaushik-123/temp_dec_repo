package com.instagram.common.viewpoint.core;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.e7, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1769e7 implements View.OnClickListener {
    public static String[] A01 = {"hS5f9KbstsMPLbUbPSxFVdCfAROmcRtV", "DUM08yoPCPer4HETov37xY8lXqOkWet1", "HD0hLshA4", "cNo3fMkBKvz7jHUo", "0KN3KUldF", "ICLtCAijF", "iMQeuY1uIySJVoFID8xkudblEyJz6Aif", "P1hZJiyY"};
    public final /* synthetic */ C1770e8 A00;

    public ViewOnClickListenerC1769e7(C1770e8 c1770e8) {
        this.A00 = c1770e8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AnonymousClass34 anonymousClass34;
        if (WU.A02(this)) {
            return;
        }
        try {
            anonymousClass34 = this.A00.A05;
            anonymousClass34.performClick();
        } catch (Throwable th) {
            WU.A00(th, this);
            if (A01[6].charAt(1) == 'N') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[0] = "I2wlNoUiFEETsNdyZ3cedgIbWPjbODtt";
            strArr[1] = "f6nspZJA1kETXV8rRnTaX6zeidOCX4th";
        }
    }
}
