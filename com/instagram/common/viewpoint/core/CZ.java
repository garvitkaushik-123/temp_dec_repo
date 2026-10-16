package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: assets/audience_network/classes2.dex */
public final class CZ implements InterfaceC1911gQ {
    public static boolean A03;
    public static byte[] A04;
    public static String[] A05 = {"HV3bjOQFG6hG19mK6btv5ZItymBNR4jb", "f8frJPlJVlZQfTmtqYpYtimfJzE", "snhVz6l74gACRZpxcVOl8ZhDE", "ioIXRoWDB2y5rIxXUVMK", "pJOGedThy6U23H0Dqr8MrVjxKTkAUTUw", "Z2sPBilUji", "eoagJWSpw9dhQ5uILEfDMJsGfxbL2OXR", "ioOrVGKFmPeoWtk9SUaiMK94AxkbTfSp"};
    public static final InterfaceC1909gO A06;
    public static final String A07;
    public long A00 = 0;
    public final InterfaceC1910gP A01;
    public final InterfaceC1916gV A02;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = copyOfRange[i4] - i3;
            String[] strArr = A05;
            if (strArr[2].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[6] = "SjioWZFjItKuhqld4sWZUQTfHHPQcsy5";
            strArr2[4] = "wEt2AMMlWwKWRpacJrxPlGBsPjvVn5Jo";
            copyOfRange[i4] = (byte) (i5 - 117);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        if (A05[0].charAt(9) == 'h') {
            throw new RuntimeException();
        }
        A05[7] = "NMMzHy25EZUbJzWBlBjuS5XjO6LPkHkX";
        A04 = new byte[]{-8, 33, 36, Ascii.NAK, Ascii.ESC, 32, Ascii.EM, -46, 32, Ascii.ETB, 42, 38, -46, 37, 43, 32, Ascii.NAK, -46, 19, 38, -46, -47, -27, -10, -17, -92, -27, -9, -92, -14, -13, -92, -9, -3, -14, -25, -20, -10, -13, -14, -19, -2, -27, -8, -19, -13, -14, -92, -9, -25, -20, -23, -24, -7, -16, -23, -24, -78, -92, -48, -27, -9, -8, -92, -9, -3, -14, -25, -92, -27, -8, -92, -87, -24, -78, -92, -46, -23, -4, -8, -92, -9, -3, -14, -25, -92, -27, -8, -92, -87, -24, -78, Ascii.SO, 39, 32, 32, 43, -37, 33, 42, 45, -37, -32, Ascii.US, -37, 40, 36, 39, 39, 36, 46, -23, 3, 2, -26, 9, 2, -38, -3, 2, -3, 7, -4, -7, -8};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.InterfaceC1911gQ
    public final synchronized void A6b(int i) {
        long A5m = this.A02.A5m() + (i * 1000000 * (A03 ? 1 : 1000));
        if (this.A00 == 0 || this.A00 > A5m) {
            this.A00 = A5m;
            notifyAll();
        }
    }

    static {
        A02();
        A07 = CZ.class.getSimpleName();
        A06 = new Ca();
        A03 = false;
    }

    public CZ(InterfaceC1910gP interfaceC1910gP, InterfaceC1916gV interfaceC1916gV) {
        this.A01 = interfaceC1910gP;
        this.A02 = interfaceC1916gV;
        Thread scheduler = new Thread(new RunnableC1912gR(this));
        scheduler.start();
    }

    private void A01() {
        while (true) {
            synchronized (this) {
                if (this.A00 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } else {
                    long A5m = this.A02.A5m();
                    if (A5m < this.A00) {
                        int millisToSleep = (int) ((this.A00 - A5m) / 1000000);
                        if (millisToSleep >= 1) {
                            String.format(Locale.US, A00(92, 20, 70), Integer.valueOf(millisToSleep));
                            try {
                                long current = millisToSleep;
                                this.A02.AK4(this, current);
                            } catch (InterruptedException unused2) {
                            }
                        }
                    }
                    this.A00 = 0L;
                    this.A01.AIo();
                    long A5m2 = this.A02.A5m();
                    if (0 != 0) {
                        throw new NullPointerException(A00(112, 13, 31));
                    }
                    synchronized (this) {
                        if (this.A00 < A5m2) {
                            String.format(Locale.US, A00(21, 71, 15), Long.valueOf(A5m2), Long.valueOf(this.A00));
                            this.A00 = 0L;
                        }
                    }
                }
            }
        }
    }

    public static /* synthetic */ void A03(CZ cz) {
        cz.A01();
        throw null;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1911gQ
    public final synchronized void A6c() {
        this.A00 = this.A02.A5m();
        String str = A00(0, 21, 61) + this.A00;
        notifyAll();
    }
}
