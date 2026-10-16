package com.instagram.common.viewpoint.core;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.l4, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2180l4 implements L8 {
    public static String[] A05 = {"ueDbV1wfakHSWIQF7BEzGoLlZXsjLXAz", "DUk", "o0l", "JXBQRCbHgV51hCMTPiBs95yrGLtJ9vRB", "UUCtZFjpq77XJSMaCIYouODFHgisrwF4", "OUp13aafPcRzH6W84Z44X0AbLYnCU3jN", "RRsP4MaHzu2rfmisltpPpgYoVzHnYDNm", "WbSPhlBTq3Mh8neaDCFEdYJRI0JZWypJ"};
    public final int A00;
    public final /* synthetic */ C2179l3 A04;
    public final C07354u A03 = new C07354u(new byte[5]);
    public final SparseArray<LH> A01 = new SparseArray<>();
    public final SparseIntArray A02 = new SparseIntArray();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    @Override // com.instagram.common.viewpoint.core.L8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A5A(C07364v c07364v) {
        int i;
        List list;
        AnonymousClass53 anonymousClass53;
        int i2;
        int i3;
        SparseArray sparseArray;
        int i4;
        int i5;
        int i6;
        HA ha;
        boolean z;
        HA ha2;
        SparseBooleanArray sparseBooleanArray;
        SparseBooleanArray sparseBooleanArray2;
        LH lh;
        SparseArray sparseArray2;
        HA ha3;
        int i7;
        SparseBooleanArray sparseBooleanArray3;
        int i8;
        LE le;
        LH A5V;
        int i9;
        LH lh2;
        LE le2;
        LH lh3;
        LH lh4;
        HA ha4;
        int i10;
        int i11;
        List list2;
        List list3;
        if (c07364v.A0I() != 2) {
            return;
        }
        i = this.A04.A09;
        if (i != 1) {
            i10 = this.A04.A09;
            if (i10 != 2) {
                i11 = this.A04.A02;
                if (i11 != 1) {
                    list2 = this.A04.A0I;
                    anonymousClass53 = new AnonymousClass53(((AnonymousClass53) list2.get(0)).A02());
                    list3 = this.A04.A0I;
                    list3.add(anonymousClass53);
                    if ((c07364v.A0I() & 128) != 0) {
                        return;
                    }
                    c07364v.A0g(1);
                    int A0M = c07364v.A0M();
                    int i12 = 3;
                    c07364v.A0g(3);
                    c07364v.A0h(this.A03, 2);
                    this.A03.A09(3);
                    int i13 = 13;
                    this.A04.A01 = this.A03.A04(13);
                    c07364v.A0h(this.A03, 2);
                    int i14 = 4;
                    this.A03.A09(4);
                    c07364v.A0g(this.A03.A04(12));
                    i2 = this.A04.A09;
                    int i15 = 21;
                    if (i2 == 2) {
                        lh2 = this.A04.A05;
                        if (lh2 == null) {
                            LD ld = new LD(21, null, null, C5C.A07);
                            C2179l3 c2179l3 = this.A04;
                            le2 = this.A04.A0H;
                            c2179l3.A05 = le2.A5V(21, ld);
                            lh3 = this.A04.A05;
                            if (lh3 != null) {
                                lh4 = this.A04.A05;
                                ha4 = this.A04.A03;
                                lh4.AAA(anonymousClass53, ha4, new LG(A0M, 21, 8192));
                            }
                        }
                    }
                    this.A01.clear();
                    this.A02.clear();
                    int A07 = c07364v.A07();
                    while (A07 > 0) {
                        c07364v.A0h(this.A03, 5);
                        int A04 = this.A03.A04(8);
                        this.A03.A09(i12);
                        int A042 = this.A03.A04(i13);
                        this.A03.A09(i14);
                        int A043 = this.A03.A04(12);
                        LD A00 = A00(c07364v, A043);
                        if (A04 == 6 || A04 == 5) {
                            A04 = A00.A00;
                        }
                        A07 -= A043 + 5;
                        i7 = this.A04.A09;
                        int i16 = i7 == 2 ? A04 : A042;
                        sparseBooleanArray3 = this.A04.A0C;
                        if (!sparseBooleanArray3.get(i16)) {
                            i8 = this.A04.A09;
                            if (i8 == 2 && A04 == i15) {
                                A5V = this.A04.A05;
                            } else {
                                le = this.A04.A0H;
                                A5V = le.A5V(A04, A00);
                            }
                            i9 = this.A04.A09;
                            if (i9 == 2) {
                                SparseIntArray sparseIntArray = this.A02;
                                String[] strArr = A05;
                                if (strArr[0].charAt(21) == strArr[3].charAt(21)) {
                                    throw new RuntimeException();
                                }
                                A05[7] = "JJxGvbQzsWrYD5XHKTSp80Ux1McJryio";
                                if (A042 >= sparseIntArray.get(i16, 8192)) {
                                }
                            }
                            this.A02.put(i16, A042);
                            this.A01.put(i16, A5V);
                        }
                        i15 = 21;
                        i12 = 3;
                        i14 = 4;
                        i13 = 13;
                    }
                    int size = this.A02.size();
                    for (int i17 = 0; i17 < size; i17++) {
                        int keyAt = this.A02.keyAt(i17);
                        int valueAt = this.A02.valueAt(i17);
                        sparseBooleanArray = this.A04.A0C;
                        sparseBooleanArray.put(keyAt, true);
                        sparseBooleanArray2 = this.A04.A0D;
                        sparseBooleanArray2.put(valueAt, true);
                        LH valueAt2 = this.A01.valueAt(i17);
                        if (valueAt2 != null) {
                            lh = this.A04.A05;
                            if (valueAt2 != lh) {
                                ha3 = this.A04.A03;
                                valueAt2.AAA(anonymousClass53, ha3, new LG(A0M, keyAt, 8192));
                            }
                            sparseArray2 = this.A04.A0B;
                            sparseArray2.put(valueAt, valueAt2);
                        }
                    }
                    i3 = this.A04.A09;
                    if (i3 == 2) {
                        z = this.A04.A08;
                        if (z) {
                            return;
                        }
                        ha2 = this.A04.A03;
                        String[] strArr2 = A05;
                        if (strArr2[1].length() != strArr2[2].length()) {
                            throw new RuntimeException();
                        }
                        String[] strArr3 = A05;
                        strArr3[0] = "hBvWu7G0FYrLQDeafFD7KKlceKy2jgRX";
                        strArr3[3] = "VoSHbxg0JUdlXnrGoiizfFeUaWFRK7d9";
                        ha2.A6O();
                        this.A04.A02 = 0;
                        this.A04.A08 = true;
                        return;
                    }
                    int i18 = 0;
                    sparseArray = this.A04.A0B;
                    sparseArray.remove(this.A00);
                    C2179l3 c2179l32 = this.A04;
                    i4 = this.A04.A09;
                    if (i4 != 1) {
                        i5 = this.A04.A02;
                        i18 = i5 - 1;
                    }
                    c2179l32.A02 = i18;
                    i6 = this.A04.A02;
                    if (i6 == 0) {
                        ha = this.A04.A03;
                        ha.A6O();
                        this.A04.A08 = true;
                        return;
                    }
                    return;
                }
            }
        }
        list = this.A04.A0I;
        anonymousClass53 = (AnonymousClass53) list.get(0);
        if ((c07364v.A0I() & 128) != 0) {
        }
    }

    public C2180l4(C2179l3 c2179l3, int i) {
        this.A04 = c2179l3;
        this.A00 = i;
    }

    private LD A00(C07364v c07364v, int i) {
        int descriptorTag = c07364v.A09();
        int descriptorLength = descriptorTag + i;
        int i2 = -1;
        String str = null;
        ArrayList arrayList = null;
        while (c07364v.A09() < descriptorLength) {
            int positionOfNextDescriptor = c07364v.A0I();
            int A09 = c07364v.A09() + c07364v.A0I();
            if (A09 > descriptorLength) {
                break;
            }
            if (positionOfNextDescriptor == 5) {
                long A0Q = c07364v.A0Q();
                if (A0Q == 1094921523) {
                    i2 = 129;
                } else if (A0Q == 1161904947) {
                    i2 = 135;
                } else if (A0Q == 1094921524) {
                    i2 = 172;
                } else if (A0Q == 1212503619) {
                    i2 = 36;
                }
            } else if (positionOfNextDescriptor == 106) {
                i2 = 129;
            } else if (positionOfNextDescriptor == 122) {
                i2 = 135;
            } else {
                String[] strArr = A05;
                String str2 = strArr[1];
                String str3 = strArr[2];
                int descriptorsStartPosition = str2.length();
                if (descriptorsStartPosition != str3.length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A05;
                strArr2[0] = "GzIOqzBb8TAh93bRV2CN08O62ZCaAqRX";
                strArr2[3] = "fp9XAk3ifz38aVsym619EhTf04al4HEa";
                if (positionOfNextDescriptor == 127) {
                    int descriptorsStartPosition2 = c07364v.A0I();
                    if (descriptorsStartPosition2 == 21) {
                        i2 = 172;
                    }
                } else if (positionOfNextDescriptor == 123) {
                    i2 = 138;
                } else {
                    String[] strArr3 = A05;
                    String str4 = strArr3[1];
                    String str5 = strArr3[2];
                    int descriptorsStartPosition3 = str4.length();
                    if (descriptorsStartPosition3 != str5.length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr4 = A05;
                    strArr4[5] = "wqYpRyaK4cDMDpt9hZQKwXCqV01Ydwf6";
                    strArr4[4] = "1qKbohas3rI7JmruTyrxsTuTEMq9fdbm";
                    if (positionOfNextDescriptor == 10) {
                        String A0W = c07364v.A0W(3);
                        String[] strArr5 = A05;
                        String str6 = strArr5[1];
                        String str7 = strArr5[2];
                        int descriptorsStartPosition4 = str6.length();
                        if (descriptorsStartPosition4 != str7.length()) {
                            str = A0W.trim();
                        } else {
                            A05[6] = "aW10g0SpfKclE3j5mqsPv8AasgcB3Ji3";
                            str = A0W.trim();
                        }
                    } else if (positionOfNextDescriptor == 89) {
                        i2 = 89;
                        arrayList = new ArrayList();
                        while (c07364v.A09() < A09) {
                            String trim = c07364v.A0W(3).trim();
                            int A0I = c07364v.A0I();
                            byte[] bArr = new byte[4];
                            c07364v.A0k(bArr, 0, 4);
                            arrayList.add(new LC(trim, A0I, bArr));
                        }
                    } else if (positionOfNextDescriptor == 111) {
                        i2 = 257;
                    }
                }
            }
            c07364v.A0g(A09 - c07364v.A09());
        }
        c07364v.A0f(descriptorLength);
        return new LD(i2, str, arrayList, Arrays.copyOfRange(c07364v.A0l(), descriptorTag, descriptorLength));
    }

    @Override // com.instagram.common.viewpoint.core.L8
    public final void AAA(AnonymousClass53 anonymousClass53, HA ha, LG lg) {
    }
}
