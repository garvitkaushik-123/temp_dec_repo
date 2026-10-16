package com.instagram.common.viewpoint.core;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.cK, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnTouchListenerC1659cK implements View.OnTouchListener {
    public static String[] A01 = {"Ag1edxGPmMygd2ZYlIUVji8noIaHMiLQ", "WBm6rd5teeEdNPvhq6Xy4yUZakZyqmkG", "ECfpblw4grbEX8THFPRM2kFRttXYDoHg", "puAZOL7My1RDIFuoQdQlIGU8uD74vctF", "rOVXccWrouvhHaM6oOMABT92DHzQ0mnK", "DC0vFQcYgsBFza3ppzX1spbq624HEpuf", "poJar2xzbFJI41pUq505BIfUZ51x22BX", "IrxdQF8UtoekkpFzNw9qcg8fTKi13Wor"};
    public final /* synthetic */ KE A00;

    public ViewOnTouchListenerC1659cK(KE ke) {
        this.A00 = ke;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        float f;
        int action = motionEvent.getActionMasked();
        switch (action) {
            case 0:
                this.A00.A00 = motionEvent.getY();
                return true;
            case 1:
                float browserFinalY = motionEvent.getY();
                f = this.A00.A00;
                if (f >= browserFinalY) {
                    return true;
                }
                KE ke = this.A00;
                String[] strArr = A01;
                String str = strArr[6];
                String str2 = strArr[2];
                int charAt = str.charAt(3);
                int action2 = str2.charAt(3);
                if (charAt != action2) {
                    A01[3] = "IGAgl0ADkCINtDuAhI065JcG0AD0YiJn";
                    ke.A0i(false);
                    return true;
                }
                throw new RuntimeException();
            default:
                return true;
        }
    }
}
