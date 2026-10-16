package com.instagram.common.viewpoint.core;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* renamed from: com.facebook.ads.redexgen.X.mM, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2259mM implements InterfaceC1070Il {
    public static byte[] A07;
    public static String[] A08 = {"eVwUBMvHO9uBMhknAGNfZP2yr814WJyE", "k5ILRUABeDXqCwWpN", "hJjZHs3Q8zIp76bYyURn3XwI", "BeESTKEHKjvJbhVudlSNXwxkHuAjvLDZ", "rbeMFWTNNauR3FTC2xnHN2ozIe2oUtV0", "bbPaxRhv7ZvGWrZH", "Yl9CHZRrzKaSrdtxcFsBA9EFbwcoGK5g", "dqSnihCeyqEvBM16"};
    public int A00;
    public int A01;
    public long A02;
    public InterfaceC1069Ik A03;
    public final byte[] A06 = new byte[8];
    public final ArrayDeque<C1067Ii> A05 = new ArrayDeque<>();
    public final C1075Iq A04 = new C1075Iq();

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 15);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A07 = new byte[]{98, -121, -113, 122, -123, -126, 125, 57, 126, -123, 126, -122, 126, -121, -115, 57, -115, -110, -119, 126, 57, 91, Byte.MIN_VALUE, -120, 115, 126, 123, 118, 50, 120, 126, -127, 115, -122, 50, -123, 123, -116, 119, 76, 50, -78, -41, -33, -54, -43, -46, -51, -119, -46, -41, -35, -50, -48, -50, -37, -119, -36, -46, -29, -50, -93, -119, -61, -28, -30, -39, -34, -41, -112, -43, -36, -43, -35, -43, -34, -28, -112, -29, -39, -22, -43, -86, -112};
        if (A08[6].charAt(2) != '9') {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[0] = "OJtOaz7eyeuGy8JHYC7MsYj9KI0teM8x";
        strArr[4] = "Pthq8qREsbuOKTWUYG3bxj4Nb5ptFAt8";
    }

    static {
        A05();
    }

    private double A00(InterfaceC2280ms interfaceC2280ms, int i) throws IOException {
        long A02 = A02(interfaceC2280ms, i);
        if (i == 4) {
            return Float.intBitsToFloat((int) A02);
        }
        return Double.longBitsToDouble(A02);
    }

    @RequiresNonNull({"processor"})
    private long A01(InterfaceC2280ms interfaceC2280ms) throws IOException {
        interfaceC2280ms.AIl();
        while (true) {
            interfaceC2280ms.AGt(this.A06, 0, 4);
            int A00 = C1075Iq.A00(this.A06[0]);
            if (A00 != -1 && A00 <= 4) {
                int A01 = (int) C1075Iq.A01(this.A06, A00, false);
                if (this.A03.AAW(A01)) {
                    interfaceC2280ms.AK3(A00);
                    return A01;
                }
            }
            interfaceC2280ms.AK3(1);
        }
    }

    private long A02(InterfaceC2280ms interfaceC2280ms, int i) throws IOException {
        interfaceC2280ms.readFully(this.A06, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long value = this.A06[i2] & 255;
            j = (j << 8) | value;
        }
        return j;
    }

    public static String A04(InterfaceC2280ms interfaceC2280ms, int i) throws IOException {
        if (i == 0) {
            return A03(0, 0, 32);
        }
        byte[] bArr = new byte[i];
        interfaceC2280ms.readFully(bArr, 0, i);
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        return new String(bArr, 0, i);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1070Il
    public final void AAD(InterfaceC1069Ik interfaceC1069Ik) {
        this.A03 = interfaceC1069Ik;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x011d, code lost:
    
        if (r0 <= 2147483647L) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x011f, code lost:
    
        r12.A03.AKK(r12.A00, A04(r13, (int) r12.A02));
        r12.A01 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x012f, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x015b, code lost:
    
        throw com.instagram.common.viewpoint.core.C3K.A01(A03(63, 21, 97) + r12.A02, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0137, code lost:
    
        if (r0 <= 2147483647L) goto L44;
     */
    @Override // com.instagram.common.viewpoint.core.InterfaceC1070Il
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean AHO(InterfaceC2280ms interfaceC2280ms) throws IOException {
        long j;
        int i;
        AbstractC07133y.A02(this.A03);
        while (true) {
            C1067Ii head = this.A05.peek();
            if (head != null) {
                long A8n = interfaceC2280ms.A8n();
                j = head.A01;
                if (A8n >= j) {
                    InterfaceC1069Ik interfaceC1069Ik = this.A03;
                    i = this.A05.pop().A00;
                    interfaceC1069Ik.A6N(i);
                    return true;
                }
            }
            if (this.A01 == 0) {
                long A05 = this.A04.A05(interfaceC2280ms, true, false, 4);
                if (A05 == -2) {
                    A05 = A01(interfaceC2280ms);
                }
                if (A05 == -1) {
                    return false;
                }
                this.A00 = (int) A05;
                this.A01 = 1;
            }
            if (this.A01 == 1) {
                this.A02 = this.A04.A05(interfaceC2280ms, false, true, 8);
                this.A01 = 2;
            }
            int A7u = this.A03.A7u(this.A00);
            switch (A7u) {
                case 0:
                    interfaceC2280ms.AK3((int) this.A02);
                    this.A01 = 0;
                case 1:
                    long A8n2 = interfaceC2280ms.A8n();
                    this.A05.push(new C1067Ii(this.A00, A8n2 + this.A02));
                    InterfaceC1069Ik interfaceC1069Ik2 = this.A03;
                    int i2 = this.A00;
                    long elementContentPosition = this.A02;
                    interfaceC1069Ik2.AK9(i2, A8n2, elementContentPosition);
                    this.A01 = 0;
                    return true;
                case 2:
                    if (this.A02 <= 8) {
                        this.A03.AAH(this.A00, A02(interfaceC2280ms, (int) this.A02));
                        this.A01 = 0;
                        return true;
                    }
                    throw C3K.A01(A03(41, 22, 90) + this.A02, null);
                case 3:
                    long j2 = this.A02;
                    if (A08[3].charAt(30) == 'v') {
                        A08[3] = "KnGHYIorNoG22Tvn2zIFMGSlF3FZ2Zej";
                        break;
                    } else {
                        A08[2] = "fCyqjQ49ueazrn4tXgyzoG1n";
                        break;
                    }
                case 4:
                    this.A03.A4i(this.A00, (int) this.A02, interfaceC2280ms);
                    this.A01 = 0;
                    return true;
                case 5:
                    long j3 = this.A02;
                    if (A08[6].charAt(2) != '9') {
                        throw new RuntimeException();
                    }
                    A08[2] = "D1RmFcc9PuCELhM1k2KVAJs3";
                    if (j3 == 4 || this.A02 == 8) {
                        this.A03.A6a(this.A00, A00(interfaceC2280ms, (int) this.A02));
                        this.A01 = 0;
                        return true;
                    }
                    throw C3K.A01(A03(21, 20, 3) + this.A02, null);
                default:
                    throw C3K.A01(A03(0, 21, 10) + A7u, null);
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1070Il
    public final void reset() {
        this.A01 = 0;
        this.A05.clear();
        this.A04.A06();
    }
}
