package com.instagram.common.viewpoint.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.eE, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1776eE {
    public static boolean A00;
    public static byte[] A01;
    public static String[] A02 = {"LOnHKZUk03MjG3VYzMMYiec9SpPsFOh7", "Pbkw0DRwc7jrPzgwHcPKSBrc9yMoULer", "Hj", "S7", "LLbZvFImhG4qXHtXSuU8lE9QXb8BQ4aR", "3BEuw5zYnH62E4dXOlScK8tmPuoX0Dzi", "Tjz3D17CMTsDMz51rRXrrUvPJCeC", "mII8e5HllIg"};

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 60);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{81, 124, 102, 101, 121, 116, 108, 88, 112, 97, 103, 124, 118, 102, 53, 124, 102, 53, 123, 96, 121, 121, 59, Ascii.EM, 46, 56, 36, 62, 57, 40, 46, 56, 107, 34, 56, 107, 37, 62, 39, 39, 101, 37, Ascii.DC2, Ascii.US, Ascii.SUB, Ascii.ETB, Ascii.DC2, 7, Ascii.SUB, Ascii.FS, Ascii.GS, 83, Ascii.NAK, Ascii.DC2, Ascii.SUB, Ascii.US, Ascii.SYN, Ascii.ETB, 93, 107, 105, 106};
    }

    static {
        A03();
        A00 = true;
    }

    public static BitmapDrawable A00(C1929gi c1929gi, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] decode = Base64.decode(str, 0);
            Bitmap overlayBm = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            if (overlayBm != null && (!A00 || A05(c1929gi, overlayBm))) {
                BitmapDrawable overlayRepeat = new BitmapDrawable(overlayBm);
                overlayRepeat.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                Resources resources = c1929gi.getResources();
                if (resources != null) {
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    if (displayMetrics != null) {
                        overlayRepeat.setTargetDensity(displayMetrics.densityDpi);
                    } else {
                        A04(c1929gi, A02(0, 23, 41));
                    }
                } else {
                    A04(c1929gi, A02(23, 18, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE));
                }
                return overlayRepeat;
            }
            return null;
        } catch (Throwable th) {
            c1929gi.A08().ABC(A02(59, 3, 58), AbstractC1341Td.A1u, new C1342Te(th));
            return null;
        }
    }

    public static C1777eF A01(C1929gi c1929gi, String str) {
        BitmapDrawable A002;
        try {
            if (TextUtils.isEmpty(str) || (A002 = A00(c1929gi, str)) == null) {
                return null;
            }
            C1777eF c1777eF = new C1777eF(c1929gi);
            c1777eF.setBackground(A002);
            c1777eF.setClickable(false);
            c1777eF.setFocusable(false);
            return c1777eF;
        } catch (Throwable th) {
            c1929gi.A08().ABC(A02(59, 3, 58), AbstractC1341Td.A1u, new C1342Te(th));
            return null;
        }
    }

    public static void A04(C1929gi c1929gi, String str) {
        c1929gi.A08().ABC(A02(59, 3, 58), AbstractC1341Td.A1u, new C1342Te(str));
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0005 */
    /* JADX WARN: Incorrect condition in loop: B:6:0x000c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean A05(C1929gi c1929gi, Bitmap bitmap) {
        for (int i = 0; i < x; i++) {
            for (int pixel = 0; pixel < x; pixel++) {
                int x = bitmap.getPixel(i, pixel);
                if (Color.alpha(x) / 255.0f > 0.03f) {
                    A04(c1929gi, A02(41, 18, 79));
                    return false;
                }
            }
        }
        String[] strArr = A02;
        if (strArr[2].length() != strArr[3].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[0] = "LR4kTGqXNNTRbn07qZCCCo1h4xvtCqSD";
        strArr2[4] = "LZTU5gCJod3YylAEiVGeMzo2seGubyq7";
        return true;
    }
}
