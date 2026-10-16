package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView;
import com.google.common.base.Ascii;
import com.ironsource.C3251pc;
import io.bidmachine.media3.common.PlaybackException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Qy, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1285Qy {
    public static byte[] A06;
    public static String[] A07 = {C3251pc.e, "BOchn05cOqPQPKgaZhD7MWqYHqoCKx7o", "EPTevQXo6AzOyuxFlfcAvx5eJdnVP8", "v", "6fNY9lNhy7nUhuOGP7YDUX6WqdzgNzMN", "SLjIMlZrt8LApw5SyAUFDc4ipDag7tTu", "zXvx6U5xIRhnU3fWG5rnYTWUnq20aSrc", "c4GOdlXhzm3270NA43EFNLoVECdVoF38"};
    public InterfaceC1283Qw A04 = null;
    public ArrayList<RecyclerView.ItemAnimator.ItemAnimatorFinishedListener> A05 = new ArrayList<>();
    public long A00 = 120;
    public long A03 = 120;
    public long A02 = 250;
    public long A01 = 250;

    public static String A08(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = (byte) ((copyOfRange[i4] - i3) + PlaybackException.ERROR_CODE_END_OF_PLAYLIST);
            String[] strArr = A07;
            if (strArr[6].charAt(25) == strArr[5].charAt(25)) {
                throw new RuntimeException();
            }
            A07[2] = "awpTB9u15TkHVvPjjOCd09Fy8dol99E";
            copyOfRange[i4] = b;
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A06 = new byte[]{76, 75, Ascii.RS, 75, 70, 74, 62, 81, 70, 76, 75, 80, 35, 70, 75, 70, 80, 69, 66, 65};
    }

    public abstract void A0H();

    public abstract void A0I();

    public abstract void A0L(RK rk);

    public abstract boolean A0M();

    public abstract boolean A0N(RK rk);

    public abstract boolean A0O(RK rk, C1284Qx c1284Qx, C1284Qx c1284Qx2);

    public abstract boolean A0P(RK rk, C1284Qx c1284Qx, C1284Qx c1284Qx2);

    public abstract boolean A0Q(RK rk, C1284Qx c1284Qx, C1284Qx c1284Qx2);

    public abstract boolean A0R(RK rk, RK rk2, C1284Qx c1284Qx, C1284Qx c1284Qx2);

    static {
        A09();
    }

    public static int A06(RK rk) {
        int i;
        i = rk.A0C;
        int i2 = i & 14;
        if (rk.A0f()) {
            return 4;
        }
        int flags = i2 & 4;
        if (flags == 0) {
            int pos = rk.A0P();
            int oldPos = rk.A0M();
            if (pos != -1 && oldPos != -1 && pos != oldPos) {
                return i2 | 2048;
            }
            return i2;
        }
        return i2;
    }

    private final C1284Qx A07() {
        return new C1284Qx();
    }

    public final long A0A() {
        return this.A00;
    }

    public final long A0B() {
        return this.A01;
    }

    public final long A0C() {
        return this.A02;
    }

    public final long A0D() {
        return this.A03;
    }

    public final C1284Qx A0E(RH rh, RK rk) {
        return A07().A01(rk);
    }

    public final C1284Qx A0F(RH rh, RK rk, int i, List<Object> payloads) {
        return A07().A01(rk);
    }

    public final void A0G() {
        int count = this.A05.size();
        if (0 < count) {
            this.A05.get(0);
            throw new NullPointerException(A08(0, 20, 112));
        }
        this.A05.clear();
    }

    public final void A0J(InterfaceC1283Qw interfaceC1283Qw) {
        this.A04 = interfaceC1283Qw;
    }

    public final void A0K(RK rk) {
        if (this.A04 != null) {
            this.A04.ACv(rk);
        }
    }

    public boolean A0S(RK rk, List<Object> payloads) {
        return A0N(rk);
    }
}
