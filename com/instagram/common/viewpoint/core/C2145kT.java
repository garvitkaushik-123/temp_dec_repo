package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.kT, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2145kT implements C5Y {
    public static String[] A08 = {"FmqEYLEjOBovlIuvu7xTusZ6GIuR3pge", "QeU0DUuOAkxor0HSqOzEAO6P6r4bp110", "WNDsEfwHyCZVTn6rYNycLV5FNYvDeUGR", "", "9kl6sBOZXnbWpCxdvxnR8wYz13jzyZGc", "QdIGCZBZzwjOBdbigrYBFiKU6cV", "ZYM92CzuhlmQLmzBChoRToTytAMTrYW0", "W1yocJmlBB3ILJesLtmFt5l7ilHzoTT3"};
    public int A00;
    public int A01;
    public C5V A02;
    public C5Y A04;
    public MP A05;
    public boolean A07;
    public C5Y A03 = new C2421pB();
    public MY A06 = MY.A00;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.C5Y
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C8B A5I() {
        return A01(this.A04 != null ? this.A04.A5I() : null, this.A00, this.A01);
    }

    private C8B A01(InterfaceC2425pF interfaceC2425pF, int i, int i2) {
        C2146kU c2146kU;
        MP mp = (MP) AbstractC07133y.A01(this.A05);
        if (this.A07 || interfaceC2425pF == null) {
            c2146kU = null;
        } else if (this.A02 != null) {
            C5V c5v = this.A02;
            String[] strArr = A08;
            if (strArr[6].charAt(29) == strArr[7].charAt(29)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[0] = "BsDku37cs2h0edzjFuAGMntAOCTwp5qB";
            strArr2[1] = "0s0KxP1bBIf3QxkhX8XEl0TpXhOFUtvY";
            c2146kU = c5v.A5H();
        } else {
            c2146kU = new C2147kV().A00(mp).A5H();
        }
        return new C8B(mp, interfaceC2425pF, this.A03.A5I(), c2146kU, this.A06, i, null, i2, null);
    }

    public final AbstractC06943d A02() {
        return null;
    }

    public final C2145kT A03(int i) {
        this.A00 = i;
        return this;
    }

    public final C2145kT A04(C5Y c5y) {
        this.A03 = c5y;
        return this;
    }

    public final C2145kT A05(C5Y c5y) {
        this.A04 = c5y;
        return this;
    }

    public final C2145kT A06(MP mp) {
        this.A05 = mp;
        return this;
    }

    public final C8B A07() {
        return A01(this.A04 != null ? this.A04.A5I() : null, this.A00 | 1, -1000);
    }
}
