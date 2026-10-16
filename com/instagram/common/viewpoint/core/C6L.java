package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.6L, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class C6L {
    public static String[] A05 = {"kbrCq6pMhmUkuvpwyFR35DcipjG4S8CW", "oaW9l9tdb", "0TRcVMdqb51VWoFscAzJe", "b9KyZslhVmWVmt6Bq2rIk", "ASY6aJ5KLIO5E4dZs7qVgEBqztuPzXSE", "", "9Pc37QLTRQIuoUm", "qelQYpgVCE3t9Ri2JAAORJatu68jVLQj"};
    public final int A00;
    public final int A01;
    public final C2489qI A02;
    public final C2489qI A03;
    public final String A04;

    public C6L(String str, C2489qI c2489qI, C2489qI c2489qI2, int i, int i2) {
        AbstractC07133y.A07(i == 0 || i2 == 0);
        this.A04 = AbstractC07133y.A05(str);
        this.A03 = (C2489qI) AbstractC07133y.A01(c2489qI);
        this.A02 = (C2489qI) AbstractC07133y.A01(c2489qI2);
        this.A01 = i;
        this.A00 = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C6L c6l = (C6L) obj;
        if (this.A01 == c6l.A01 && this.A00 == c6l.A00 && this.A04.equals(c6l.A04)) {
            boolean equals = this.A03.equals(c6l.A03);
            String[] strArr = A05;
            if (strArr[5].length() == strArr[2].length()) {
                throw new RuntimeException();
            }
            A05[6] = "94n8VTHvI2C2zF2";
            if (equals && this.A02.equals(c6l.A02)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.A01;
        int hashCode2 = ((((17 * 31) + hashCode) * 31) + this.A00) * 31;
        int hashCode3 = this.A04.hashCode();
        int hashCode4 = (((hashCode2 + hashCode3) * 31) + this.A03.hashCode()) * 31;
        int hashCode5 = this.A02.hashCode();
        return hashCode4 + hashCode5;
    }
}
