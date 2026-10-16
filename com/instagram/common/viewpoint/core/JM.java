package com.instagram.common.viewpoint.core;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

@MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
/* loaded from: assets/audience_network/classes2.dex */
public abstract class JM {
    public static String[] A00 = {"FTgkNuEfB21sdffM4MB", "AHdMCcfHPrYhHZuJq7ar8kaDD0", "m1AQBHavwMcQPTMSh8yPHqRX8TIuxSKu", "w1PNvsr2QHXMQttzrVJcJFpvqWAZZ2ue", "3yahnNe", "CLySAaMkPHNUkUwJF2Q2hF0h64PJDpTx", "AMIcFao4vlNbyapwbaOz2OEX2RJAnqn2", "UMo3DITmDXTtEPejAH8oJ9deLVPgGECA"};
    public static final int[] A01 = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean A00(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (A00[1].length() == 5) {
            throw new RuntimeException();
        }
        A00[1] = "W7vtI7n9AGcg3kiZwr1R4Wd";
        if (i == 1751476579 && z) {
            return true;
        }
        int[] iArr = A01;
        if (A00[1].length() == 5) {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[6] = "p6Add4WRgBlZ7U9sigG7YhPBNKEcLx90";
        strArr[7] = "5Tff00eh7q1qfGppTlmWVovL6e7TawLb";
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean A01(InterfaceC2280ms interfaceC2280ms) throws IOException {
        return A03(interfaceC2280ms, true, false);
    }

    public static boolean A02(InterfaceC2280ms interfaceC2280ms, boolean z) throws IOException {
        return A03(interfaceC2280ms, false, z);
    }

    public static boolean A03(InterfaceC2280ms interfaceC2280ms, boolean z, boolean z2) throws IOException {
        long A8O = interfaceC2280ms.A8O();
        long inputLength = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        if (A8O != -1 && A8O <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            inputLength = A8O;
        }
        int i = (int) inputLength;
        C07364v c07364v = new C07364v(64);
        int i2 = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (i2 < i) {
            int i3 = 8;
            c07364v.A0d(8);
            if (!interfaceC2280ms.AGu(c07364v.A0l(), 0, 8, true)) {
                break;
            }
            long A0Q = c07364v.A0Q();
            int headerSize = c07364v.A0C();
            if (A0Q == 1) {
                i3 = 16;
                interfaceC2280ms.AGt(c07364v.A0l(), 8, 8);
                c07364v.A0e(16);
                A0Q = c07364v.A0P();
            } else if (A0Q == 0) {
                long A8O2 = interfaceC2280ms.A8O();
                if (A8O2 != -1) {
                    A0Q = (A8O2 - interfaceC2280ms.A8i()) + 8;
                }
            }
            if (A0Q < i3) {
                return false;
            }
            i2 += i3;
            if (headerSize == 1836019574) {
                int i4 = (int) A0Q;
                String[] strArr = A00;
                if (strArr[2].charAt(21) == strArr[5].charAt(21)) {
                    throw new RuntimeException();
                }
                A00[1] = "1NOCBl6uYr6a5zcz7K9cJi9";
                i += i4;
                if (A8O != -1 && i > A8O) {
                    i = (int) A8O;
                }
            } else {
                if (headerSize == 1836019558 || headerSize == 1836475768) {
                    z4 = true;
                    break;
                }
                if ((i2 + A0Q) - i3 >= i) {
                    break;
                }
                int atomDataSize = (int) (A0Q - i3);
                i2 += atomDataSize;
                if (headerSize == 1718909296) {
                    if (atomDataSize >= 8) {
                        c07364v.A0d(atomDataSize);
                        interfaceC2280ms.AGt(c07364v.A0l(), 0, atomDataSize);
                        int atomDataSize2 = atomDataSize / 4;
                        int brandsCount = 0;
                        while (true) {
                            if (brandsCount >= atomDataSize2) {
                                break;
                            }
                            if (brandsCount == 1) {
                                c07364v.A0g(4);
                            } else if (A00(c07364v.A0C(), z2)) {
                                z3 = true;
                                break;
                            }
                            brandsCount++;
                        }
                        if (!z3) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else if (atomDataSize != 0) {
                    interfaceC2280ms.A47(atomDataSize);
                }
            }
        }
        return z3 && z == z4;
    }
}
