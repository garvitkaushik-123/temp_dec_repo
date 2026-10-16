package com.bytedance.sdk.component.DbA.eli.DbA;

import java.util.Arrays;

/* loaded from: classes3.dex */
final class kb extends aGH {
    final transient byte[][] kb;
    final transient int[] wC;

    kb(eli eliVar, int i) {
        super(null);
        FC.eli(eliVar.DbA, 0L, i);
        ui uiVar = eliVar.eli;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (uiVar.Os == uiVar.DbA) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += uiVar.Os - uiVar.DbA;
            i4++;
            uiVar = uiVar.MGA;
        }
        this.kb = new byte[i4][];
        this.wC = new int[i4 * 2];
        ui uiVar2 = eliVar.eli;
        int i5 = 0;
        while (i2 < i) {
            this.kb[i5] = uiVar2.eli;
            i2 += uiVar2.Os - uiVar2.DbA;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.wC;
            iArr[i5] = i2;
            iArr[this.kb.length + i5] = uiVar2.DbA;
            uiVar2.aGH = true;
            i5++;
            uiVar2 = uiVar2.MGA;
        }
    }

    @Override // com.bytedance.sdk.component.DbA.eli.DbA.aGH
    public String eli() {
        return ui().eli();
    }

    @Override // com.bytedance.sdk.component.DbA.eli.DbA.aGH
    public String DbA() {
        return ui().DbA();
    }

    @Override // com.bytedance.sdk.component.DbA.eli.DbA.aGH
    public aGH eli(int i, int i2) {
        return ui().eli(i, i2);
    }

    @Override // com.bytedance.sdk.component.DbA.eli.DbA.aGH
    public byte eli(int i) {
        FC.eli(this.wC[this.kb.length - 1], i, 1L);
        int DbA = DbA(i);
        int i2 = DbA == 0 ? 0 : this.wC[DbA - 1];
        int[] iArr = this.wC;
        byte[][] bArr = this.kb;
        return bArr[DbA][(i - i2) + iArr[bArr.length + DbA]];
    }

    private int DbA(int i) {
        int binarySearch = Arrays.binarySearch(this.wC, 0, this.kb.length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.DbA.aGH
    public int Os() {
        return this.wC[this.kb.length - 1];
    }

    @Override // com.bytedance.sdk.component.DbA.eli.DbA.aGH
    public byte[] aGH() {
        int[] iArr = this.wC;
        byte[][] bArr = this.kb;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.wC;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.kb[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.DbA.aGH
    public boolean eli(int i, aGH agh, int i2, int i3) {
        if (i < 0 || i > Os() - i3) {
            return false;
        }
        int DbA = DbA(i);
        while (i3 > 0) {
            int i4 = DbA == 0 ? 0 : this.wC[DbA - 1];
            int min = Math.min(i3, ((this.wC[DbA] - i4) + i4) - i);
            int[] iArr = this.wC;
            byte[][] bArr = this.kb;
            if (!agh.eli(i2, bArr[DbA], (i - i4) + iArr[bArr.length + DbA], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            DbA++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.DbA.aGH
    public boolean eli(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > Os() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int DbA = DbA(i);
        while (i3 > 0) {
            int i4 = DbA == 0 ? 0 : this.wC[DbA - 1];
            int min = Math.min(i3, ((this.wC[DbA] - i4) + i4) - i);
            int[] iArr = this.wC;
            byte[][] bArr2 = this.kb;
            if (!FC.eli(bArr2[DbA], (i - i4) + iArr[bArr2.length + DbA], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            DbA++;
        }
        return true;
    }

    private aGH ui() {
        return new aGH(aGH());
    }

    @Override // com.bytedance.sdk.component.DbA.eli.DbA.aGH
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof aGH) {
            aGH agh = (aGH) obj;
            if (agh.Os() == Os() && eli(0, agh, 0, Os())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.DbA.aGH
    public int hashCode() {
        int i = this.ui;
        if (i != 0) {
            return i;
        }
        int length = this.kb.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.kb[i2];
            int[] iArr = this.wC;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.ui = i3;
        return i3;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.DbA.aGH
    public String toString() {
        return ui().toString();
    }
}
