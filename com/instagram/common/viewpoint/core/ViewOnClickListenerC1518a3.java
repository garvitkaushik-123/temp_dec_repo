package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

/* renamed from: com.facebook.ads.redexgen.X.a3, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1518a3 implements View.OnClickListener {
    public static String[] A01 = {"iZ6FuTOx6FAqmbj1AunCGkamUaDVg3eR", "OTd3wYZwyAdhrzzq5DVZ5RSyL", "m80G0T4tMZ36JM3eeYxY4WN8siPrP01X", "yhwtzpQCbgij9W", "85UkrcR6qg1oy5EdfurKWfofR8ayIayx", "yKANEKxGU", "haLFOFZH1x7UhbGKUD1GobiUu6Nm2S9C", "YnroWKjcyqExTOiVG"};
    public final /* synthetic */ C1519a4 A00;

    public ViewOnClickListenerC1518a3(C1519a4 c1519a4) {
        this.A00 = c1519a4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageView imageView;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        if (WU.A02(this)) {
            return;
        }
        try {
            imageView = this.A00.A02;
            if (imageView.getVisibility() == 8) {
                this.A00.A07(0);
                handler2 = this.A00.A00;
                runnable2 = this.A00.A08;
                handler2.postDelayed(runnable2, 1500L);
                return;
            }
            this.A00.A06();
            handler = this.A00.A00;
            runnable = this.A00.A08;
            handler.removeCallbacks(runnable);
            this.A00.A07(8);
        } catch (Throwable th) {
            String[] strArr = A01;
            if (strArr[5].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[2] = "BS56tA9mEf46ZLpm0pjL0lsj0NMRakTT";
            strArr2[4] = "RRhRbLQv2JGaZTWGxiXTzimfELVMOsxN";
            WU.A00(th, this);
        }
    }
}
