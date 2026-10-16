package com.instagram.common.viewpoint.core;

import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.je, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2095je extends AbstractC1277Qq<PX> {
    public static String[] A05 = {"BofGdT", "Cb8B81bPHxSAbCDzy4", "tLXqRIVVg6Ax3ByQPtTHAjuCLXMkMIv2", "Awqy8gsEnlsE3SarczMGKLCzZdtyeG5w", "c95zYEegXXkMe1M4f4KrlDKZ96YYHdKl", "dzB1VPy83al1mBxHBTo", "7fXNgxpNBgLKECdM7L4CyN3WmxsqHAeT", "HUwJOtf8ZOX36MmDYBkOhN0MiSikj2Pg"};
    public static final int A06 = (int) (XX.A02 * 4.0f);
    public NM A00;
    public final List<UK> A01;
    public final int A02;
    public final C1929gi A03;
    public final AbstractC1873fo A04 = new C2097jg(this);

    public AbstractC2095je(C0x c0x, List<UK> list, C1929gi c1929gi) {
        this.A03 = c1929gi;
        this.A02 = c0x.getChildSpacing();
        this.A01 = list;
    }

    private ViewGroup.MarginLayoutParams A01(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        int i2 = this.A02;
        if (i == 0) {
            i2 *= 2;
        }
        int size = this.A01.size() - 1;
        String[] strArr = A05;
        if (strArr[3].charAt(2) == strArr[4].charAt(2)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[7] = "KlchvvVcsY9zV3e8wqzNtTZQscUuxnqD";
        strArr2[1] = "gQBYn2ao1l5plthpQQ";
        marginLayoutParams.setMargins(i2, 0, i >= size ? this.A02 * 2 : this.A02, 0);
        return marginLayoutParams;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1277Qq
    public final int A0B() {
        return this.A01.size();
    }

    public final void A0O(ImageView imageView, int i) {
        UK uk = this.A01.get(i);
        C1391Vb adCoverImage = uk.getAdCoverImage();
        if (adCoverImage != null) {
            LM A04 = new LM(imageView, this.A03).A04();
            A04.A06(new C2096jf(this, i, uk));
            A04.A07(adCoverImage.getUrl());
        }
    }

    public final void A0P(NM nm) {
        this.A00 = nm;
    }

    public void A0Q(PX px, int i) {
        px.A0p().setLayoutParams(A01(i));
    }
}
