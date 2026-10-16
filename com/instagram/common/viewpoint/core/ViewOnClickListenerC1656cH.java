package com.instagram.common.viewpoint.core;

import android.view.View;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.cH, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1656cH implements View.OnClickListener {
    public static byte[] A02;
    public static String[] A03 = {"524C9pC8aLVKflbvvv2K7MlVaT1Y4oXj", "lRM8H52A4hKqkKdkEH8S6", "pzMD8hEzrN8WJeuHzmUfipPCg7LRhl7h", "lnDY", "95wdtjn99T2hJygpaQjrD03HNRuLahXP", "M3Z", "WkizL2fPiwDBFcFyMDRmv7nfAM7GjuvS", "zFeU71BaV6LqmyzLw1trLotvqmYyyi91"};
    public final /* synthetic */ ViewOnClickListenerC1127Kr A00;
    public final /* synthetic */ C1658cJ A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 10);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{93, 86, 92, 91, 89, 74, 92, 75};
    }

    static {
        A01();
    }

    public ViewOnClickListenerC1656cH(C1658cJ c1658cJ, ViewOnClickListenerC1127Kr viewOnClickListenerC1127Kr) {
        this.A01 = c1658cJ;
        this.A00 = viewOnClickListenerC1127Kr;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (WU.A02(this)) {
            return;
        }
        try {
            if (this.A00 != null) {
                this.A00.A0E(A00(0, 8, 50));
            }
        } catch (Throwable th) {
            WU.A00(th, this);
            if (A03[6].charAt(18) == 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[3] = "HSmZ";
            strArr[1] = "XRAr9C2gXTfshR7ejhjPx";
        }
    }
}
