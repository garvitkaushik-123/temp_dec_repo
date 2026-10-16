package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.facebook.ads.RewardData;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.vungle.ads.internal.protos.Sdk;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.io.encoding.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class NQ implements Serializable {
    public static String A16 = null;
    public static byte[] A17 = null;
    public static final long serialVersionUID = -8352540727250859603L;
    public double A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public long A05;
    public long A06;
    public RewardData A07;
    public C1188Nb A08;
    public String A09;
    public String A0A;
    public String A0B;
    public String A0C;
    public String A0D;
    public String A0E;
    public String A0F;
    public String A0G;
    public String A0H;
    public String A0I;
    public String A0J;
    public String A0K;
    public String A0L;
    public String A0M;
    public String A0N;
    public String A0O;
    public String A0P;
    public String A0Q;
    public String A0R;
    public String A0S;
    public String A0T;
    public String A0U;
    public String A0V;
    public String A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public boolean A0a;
    public boolean A0b;
    public boolean A0c;
    public boolean A0d;
    public boolean A0e;
    public boolean A0f;
    public boolean A0g;
    public boolean A0h;
    public boolean A0i;
    public boolean A0j;
    public boolean A0k;
    public boolean A0l;
    public boolean A0m;
    public boolean A0n;
    public boolean A0o;
    public boolean A0p;
    public boolean A0q;
    public boolean A0r;
    public boolean A0s;
    public boolean A0t;
    public boolean A0u;
    public boolean A0v;
    public boolean A0w;
    public boolean A0x;
    public boolean A0y;
    public boolean A0z;
    public boolean A10;
    public boolean A11;
    public boolean A12;
    public boolean A13;
    public boolean A14;
    public final int A15;

    static {
        A05();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A17, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 40);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A17 = new byte[]{92, 115, 126, 118, 114, 63, 102, 112, 106, 109, 63, 121, 109, 122, 122, 63, 109, 122, 104, 126, 109, 123, 62, 63, 85, 106, 108, 107, 63, 118, 113, 108, 107, 126, 115, 115, 63, 58, 108, 63, 107, 112, 63, 108, 116, 118, 111, 63, 107, 119, 122, 63, 126, 123, 36, 6, Ascii.ETB, 67, Ascii.SUB, Ascii.FF, Ascii.SYN, 17, 67, 17, 6, Ascii.DC4, 2, 17, 7, 102, 65, 92, 91, 78, 67, 67, Ascii.SI, 78, 95, 95, Ascii.SI, 78, 65, 75, Ascii.SI, 92, 68, 70, 95, Ascii.SI, 91, 71, 74, Ascii.SI, 78, 75, 1, 10, 45, 48, 55, 34, 47, 47, 99, 55, 43, 38, 99, 34, 51, 51, 5, 34, 63, 56, 45, 32, 32, 108, 56, 35, 108, 63, 39, 37, 60, 108, 56, 36, 41, 108, 45, 40, 105, 84, 6, 81, 71, 82, 69, 78, 6, SignedBytes.MAX_POWER_OF_TWO, 83, 74, 74, 6, 3, 85, Ascii.VT, 85, 67, 69, 73, 72, 66, 6, 71, 66, 4, 57, 107, 60, 42, 63, 40, 35, 107, 63, 35, 46, 107, 45, 62, 39, 39, 107, 42, 47, 81, 102, 116, 98, 113, 103, 35, 100, 113, 98, 109, 119, 102, 103, 34, 91, 99, 97, 120, 40, 124, 96, 109, 40, 105, 108, 40, 106, 113, 40, 108, 103, Byte.MAX_VALUE, 102, 100, 103, 105, 108, 97, 102, 111, 40, 124, 96, 109, 40, 105, 120, 120, 40, 105, 102, 108, 40, 97, 102, 123, 124, 105, 102, 124, 100, 113, 40, 111, 109, 124, 40, 113, 103, 125, 122, 40, 122, 109, Byte.MAX_VALUE, 105, 122, 108, 41, 120, 68, 77, 66, 71, Ascii.FF, 85, 67, 89, Ascii.FF, 74, 67, 94, Ascii.FF, 69, 66, 95, 88, 77, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 69, 66, 75, Ascii.FF, 9, 95, 51, 5, 10, Ascii.DLE, 68, Ascii.DLE, Ascii.VT, 68, Ascii.ETB, Ascii.SI, Ascii.CR, Ascii.DC4, 68, Ascii.DLE, Ascii.FF, 1, 68, 5, 0, 68, 66, 68, 7, 8, 5, Ascii.CR, 9, 68, Ascii.GS, Ascii.VT, 17, Ascii.SYN, 68, 2, Ascii.SYN, 1, 1, 68, Ascii.SYN, 1, 19, 5, Ascii.SYN, 0, 91, 68, 46, 17, Ascii.ETB, Ascii.DLE, 68, Ascii.CR, 10, Ascii.ETB, Ascii.DLE, 5, 8, 8, 68, 65, Ascii.ETB, 68, 10, Ascii.VT, 19, 59, Ascii.CR, Ascii.ETB, Ascii.DLE, 66, Ascii.DLE, 7, Ascii.NAK, 3, Ascii.DLE, 6, 66, Ascii.VT, 17, 66, Ascii.DLE, 7, 3, 6, Ascii.ESC, 66, Ascii.SYN, Ascii.CR, 66, 0, 7, 66, Ascii.ETB, 17, 7, 6, 67, 40, 45, 39, 62, Ascii.SYN, 42, 40, 59, 38, 60, 58, 44, 37, Ascii.SYN, 63, 123, Ascii.SYN, 45, 44, 58, 32, 46, 39, 108, 105, 99, 122, 82, 110, 101, 108, 100, 99, 104, 105, 82, 108, 105, 126, 82, 123, 63, 82, 105, 104, 126, 100, 106, 99, 49, 52, 62, 39, Ascii.SI, 32, 60, 49, 41, 49, 50, 60, 53, Ascii.SI, 38, 98, Ascii.SI, 34, 53, 52, 53, 35, 57, 55, 62, Ascii.SI, 53, 62, 49, 50, 60, 53, 52, 41, 44, 38, 63, Ascii.ETB, Base64.padSymbol, 59, 45, Ascii.ETB, 33, 37, 41, 47, 45, Ascii.ETB, 62, 122, Ascii.ETB, 58, 45, 44, 45, 59, 33, 47, 38, 112, 117, Byte.MAX_VALUE, 102, 78, 100, 98, 116, 78, 103, 120, 117, 116, 126, 78, 103, 120, 116, 102, 78, 103, 35, 78, 99, 116, 117, 116, 98, 120, 118, Byte.MAX_VALUE, Ascii.ETB, Ascii.DC2, Ascii.CAN, 1, 41, 1, Ascii.ETB, 2, Ascii.NAK, Ascii.RS, 41, Ascii.ETB, Ascii.CAN, Ascii.DC2, 41, Ascii.DC4, 4, Ascii.EM, 1, 5, 19, 41, 0, 68, 41, Ascii.DC2, 19, 5, Ascii.US, 17, Ascii.CAN, 107, 122, 122, 85, 101, 122, 111, 100, 85, 107, 110, 85, 124, 107, 120, 99, 107, 100, 126, 89, 73, 84, 76, 72, 94, 73, 100, 75, 94, 94, 80, 100, 94, 85, 90, 89, 87, 94, 95, 107, 123, 102, 126, 122, 108, 123, 86, 121, 108, 108, 98, 86, 97, 108, 96, 110, 97, 125, 104, 106, 104, 84, 109, 98, 103, Byte.MAX_VALUE, 110, 121, 84, 104, 103, 98, 104, 96, 120, 84, 100, 101, 84, 104, Byte.MAX_VALUE, 106, 84, 110, 101, 106, 105, 103, 110, 111, 102, 100, 104, 117, 100, 108, 98, 107, 108, 97, 56, 114, 96, 103, 90, 100, 112, 113, 106, 90, 119, 96, 97, 108, 119, 96, 102, 113, 37, 100, 102, 113, 108, 106, 107, 56, 100, 107, 97, 119, 106, 108, 97, 43, 108, 107, 113, 96, 107, 113, 43, 100, 102, 113, 108, 106, 107, 43, 83, 76, SignedBytes.MAX_POWER_OF_TWO, 82, 37, 117, 100, 102, 110, 100, 98, 96, 56, 102, 106, 104, 43, 100, 107, 97, 119, 106, 108, 97, 43, 115, 96, 107, 97, 108, 107, 98, 37, 108, 107, 113, 96, 107, 113, 63, 42, 42, 117, 105, 100, 124, 43, 98, 106, 106, 98, 105, 96, 43, 102, 106, 104, 42, 118, 113, 106, 119, 96, 0, 2, 17, Ascii.FF, Ascii.SYN, Ascii.DLE, 6, Ascii.SI, Ascii.SI, 4, Ascii.CR, 5, 2, 51, Ascii.FS, Ascii.CR, Ascii.RS, Ascii.CR, 1, Ascii.US, Ascii.CAN, Ascii.ETB, Ascii.DC2, Ascii.CAN, Ascii.DLE, 36, Ascii.US, Ascii.RS, Ascii.ETB, Ascii.SUB, 2, 36, Ascii.ETB, Ascii.DC4, Ascii.FS, Ascii.FS, Ascii.DC2, Ascii.NAK, Ascii.FS, 36, Ascii.SYN, 8, 107, 100, 97, 107, 99, 87, 97, 105, 106, 87, 110, 97, 100, 124, 109, 122, 97, 102, 111, 87, 109, 102, 105, 106, 100, 109, 108, 55, 59, 57, 122, 50, 53, 55, 49, 54, 59, 59, 63, 122, 53, 48, 39, 122, Base64.padSymbol, 58, 32, 49, 38, 39, 32, Base64.padSymbol, 32, Base64.padSymbol, 53, 56, 122, 55, 56, Base64.padSymbol, 55, 63, 49, 48, 2, 19, 4, 0, Ascii.NAK, 8, Ascii.ETB, 4, 62, 0, Ascii.DC2, 62, 2, Ascii.NAK, 0, 62, 4, Ascii.SI, 0, 3, Ascii.CR, 4, 5, 50, 35, 52, 48, 37, 56, 39, 52, Ascii.SO, 48, 34, Ascii.SO, 50, 37, 48, Ascii.SO, 52, 63, 48, 51, Base64.padSymbol, 52, 53, Ascii.SO, 63, 48, 37, 56, 39, 52, Ascii.SO, 51, 48, 63, 63, 52, 35, 60, 45, 58, 59, 54, 43, 0, 51, 54, 49, 58, 0, 54, 110, 103, 49, 0, 54, 50, 62, 56, 58, 76, 91, 78, 112, 76, 67, 70, 76, 68, 112, 75, 74, 67, 78, 86, 112, 67, SignedBytes.MAX_POWER_OF_TWO, 72, 72, 70, 65, 72, 112, 66, 92, 53, 34, Base64.padSymbol, Ascii.SO, 57, 56, 53, 52, Ascii.SO, 63, 48, 39, 56, 54, 48, 37, 56, 62, 63, Ascii.SO, 52, 
        63, 48, 51, Base64.padSymbol, 52, 53, 104, Byte.MAX_VALUE, 96, 83, 100, Byte.MAX_VALUE, 83, 105, 98, 109, 110, 96, 105, 104, 63, 40, 55, 4, 51, 34, 57, 41, 50, 63, 4, 62, 53, 58, 57, 55, 62, 63, Byte.MAX_VALUE, 98, 117, 122, 118, 114, 120, 68, 104, Byte.MAX_VALUE, 112, 68, 119, 122, 98, 126, 105, 68, 115, 111, 118, 119, 68, 110, 105, 119, 83, 88, 85, 68, 79, 70, 66, 83, 82, 105, 85, 70, 91, 40, 34, 33, 47, 58, Ascii.FF, 4, 4, Ascii.FF, 7, Ascii.SO, 52, Ascii.ESC, 7, 10, Ascii.DC2, 52, 3, 4, Ascii.CAN, Ascii.US, 52, Ascii.CAN, Ascii.US, Ascii.EM, 2, 5, Ascii.FF, 123, 122, 119, 118, 76, 112, 124, 102, 125, 103, 119, 124, 100, 125, 76, 118, 125, 114, 113, Byte.MAX_VALUE, 118, 119, 78, 79, 66, 67, 121, 86, 84, 73, 65, 84, 67, 85, 85, 121, 68, 71, 84, 121, 67, 72, 71, 68, 74, 67, 66, 110, 105, 117, 114, 89, 103, 118, 118, 89, 111, 101, 105, 104, 89, 115, 116, 106, 76, 75, 87, 80, 123, 69, 84, 84, 123, 74, 69, 73, 65, 5, 2, Ascii.US, Ascii.CAN, Ascii.CR, 0, 0, 51, Ascii.CR, 2, 8, 51, Ascii.VT, 9, Ascii.CAN, 51, Ascii.RS, 9, Ascii.ESC, Ascii.CR, Ascii.RS, 8, 51, 8, 9, Ascii.US, Ascii.SI, Ascii.RS, 5, Ascii.FS, Ascii.CAN, 5, 3, 2, 104, 111, 114, 117, 96, 109, 109, 94, 96, 111, 101, 94, 102, 100, 117, 94, 115, 100, 118, 96, 115, 101, 94, 100, 111, 96, 99, 109, 100, 101, 36, 35, 57, 40, 63, 46, 40, Base64.padSymbol, 57, Ascii.DC2, 58, 40, 47, Ascii.DC2, 36, 35, 62, 57, 44, 33, 33, Ascii.DC2, 47, 56, 57, 57, 34, 35, 1, 6, Ascii.FS, Ascii.CR, Ascii.SUB, Ascii.ESC, Ascii.FS, 1, Ascii.FS, 1, 9, 4, 93, 71, 107, 85, 68, 68, 107, 91, 68, 81, 90, 107, 85, 80, Ascii.DC2, 8, 36, Ascii.CR, Ascii.DC2, Ascii.US, Ascii.RS, Ascii.DC4, 36, 8, 19, Ascii.DC4, 9, Ascii.SI, 36, Ascii.GS, Ascii.DC4, 9, Ascii.SYN, 73, 80, 124, 84, 70, 65, 124, 74, 77, 80, 87, 66, 79, 79, 124, 65, 86, 87, 87, 76, 77, 19, Ascii.DLE, Ascii.FS, Ascii.DC4, 32, 8, Ascii.RS, Ascii.VT, Ascii.FS, Ascii.ETB, 32, Ascii.RS, 17, Ascii.ESC, 32, Ascii.GS, Ascii.CR, Ascii.DLE, 8, Ascii.FF, Ascii.SUB, 32, Ascii.SUB, 17, Ascii.RS, Ascii.GS, 19, Ascii.SUB, Ascii.ESC, SignedBytes.MAX_POWER_OF_TWO, 72, 73, 68, 76, 114, 76, 94, 93, 72, 78, 89, 114, 95, 76, 89, 68, 66, 72, 71, 82, 79, 80, 67, SignedBytes.MAX_POWER_OF_TWO, 92, 81, 73, Ascii.RS, 87, 95, 95, 87, 92, 85, Ascii.RS, 83, 95, 93, 57, 59, 44, Ascii.SYN, 59, 44, 62, 40, 59, 45, Ascii.SYN, 42, Base64.padSymbol, 40, Ascii.SYN, 43, 60, Base64.padSymbol, Base64.padSymbol, 38, 39, Ascii.SYN, Base64.padSymbol, 44, 49, Base64.padSymbol, 108, 110, 121, 67, 110, 121, 107, 125, 110, 120, 67, 120, 121, 111, Byte.MAX_VALUE, 110, 117, 108, 104, 117, 115, 114, 113, 115, 100, 94, 115, 100, 118, 96, 115, 101, 94, 100, 111, 96, 99, 109, 100, 101, Base64.padSymbol, 63, 40, Ascii.DC2, 63, 40, 58, 44, 63, 41, Ascii.DC2, 57, 36, 57, 33, 40, 72, 74, 93, 103, 74, 93, 79, 89, 74, 92, 103, 79, 89, 76, 91, 80, 103, 89, 92, 103, 90, 77, 76, 76, 87, 86, 103, 76, 93, SignedBytes.MAX_POWER_OF_TWO, 76, 113, 115, 100, 103, 100, 115, 94, 114, 100, 115, 119, 100, 115, 94, 105, 110, 114, 117, 94, 96, 113, 113, 94, 104, 98, 110, 111, 95, 93, 74, 73, 74, 93, 112, 92, 74, 93, 89, 74, 93, 112, 71, SignedBytes.MAX_POWER_OF_TWO, 92, 91, 112, 78, 95, 95, 112, 65, 78, 66, 74, Ascii.SI, Ascii.RS, 34, Ascii.VT, 79, 34, Ascii.CAN, 5, Ascii.CR, Ascii.CAN, Ascii.SI, Ascii.DC4, Ascii.CAN, 19, Ascii.RS, Ascii.CAN, 34, Ascii.FS, 34, Ascii.CAN, 19, Ascii.FS, Ascii.US, 17, Ascii.CAN, Ascii.EM, 0, 17, 45, 4, SignedBytes.MAX_POWER_OF_TWO, 45, Ascii.ETB, 10, 2, Ascii.ETB, 0, Ascii.ESC, Ascii.ETB, Ascii.FS, 17, Ascii.ETB, 45, Ascii.DLE, 45, Ascii.ETB, Ascii.FS, 19, Ascii.DLE, Ascii.RS, Ascii.ETB, Ascii.SYN, 63, 46, Ascii.DC2, 59, Byte.MAX_VALUE, Ascii.DC2, 36, 35, 62, 57, 44, 33, 33, Ascii.DC2, 57, 34, Ascii.DC2, 62, 38, 36, Base64.padSymbol, 44, Base64.padSymbol, 1, 40, 108, 1, 44, 59, 41, 63, 44, 58, 1, Base64.padSymbol, 50, 63, 55, 51, 1, 58, 59, 45, Base64.padSymbol, 44, 55, 46, 42, 55, 49, 48, 1, Ascii.DLE, 44, 5, 65, 44, 4, Ascii.DC2, 7, Ascii.DLE, Ascii.ESC, 44, Ascii.NAK, 6, Ascii.US, Ascii.US, 44, Ascii.DC2, Ascii.ETB, 110, 121, 108, 112, 125, 101, 67, 107, 116, 121, 114, 67, 111, 119, 117, 108, 67, 104, 117, 113, 121, 67, 121, 100, Byte.MAX_VALUE, 121, 121, 120, 111, 67, 106, 117, 120, 121, 115, 67, 120, 105, 110, 125, 104, 117, 115, 114, 67, 121, 114, 125, 126, 112, 121, 120, 69, 82, 70, 66, 82, 68, 67, 104, 94, 83, Ascii.SO, Ascii.EM, Ascii.VT, Ascii.GS, Ascii.SO, Ascii.CAN, 35, Ascii.ESC, Ascii.SO, Ascii.GS, Ascii.DC2, 8, Ascii.EM, Ascii.CAN, 35, 8, Ascii.EM, 4, 8, 36, 51, 33, 55, 36, 50, 9, 49, 36, 55, 56, 34, 51, 50, 9, 32, 100, 9, 34, 51, 46, 34, 71, 80, 66, 84, 71, 81, 106, 92, 91, 83, 90, 106, 65, 80, 77, 65, 115, 100, 118, 96, 115, 101, 100, 101, 94, 119, 104, 101, 100, 110, 96, 103, 97, 122, 125, 116, 76, 103, 124, 76, 112, 123, 118, 112, 120, 76, 116, 124, 124, 116, Byte.MAX_VALUE, 118, 76, 99, Byte.MAX_VALUE, 114, 106, 76, 114, 102, 103, 124, 76, 97, 118, 119, 122, 97, 118, 112, 103, 77, 82, 95, 94, 84, 100, 88, 87, 82, 88, 80, 90, 89, 87, 94, 70, 89, 85, 71, 81, 82, 89, 92, 89, 68, 73, 111, 83, 88, 85, 83, 91, 111, 89, 94, 89, 68, 89, 81, 92, 111, 84, 85, 92, 81, 73, 113, 110, 98, 112, 102, 101, 110, 107, 110, 115, 126, 88, 100, 111, 98, 100, 108, 88, 110, 105, 115, 98, 117, 113, 102, 107, 44, 58, 47, 56, 51, 4, 58, 53, 63, 4, 57, 41, 52, 44, 40, 62, 4, 58, 53, 63, 41, 52, 50, 63, 4, 45, 105, 4, 46, 50, 62, 40, Base64.padSymbol, 42, 33, Ascii.SYN, 40, 39, 45, Ascii.SYN, 43, 59, 38, 62, 58, 44, Ascii.SYN, 42, 38, 60, 39, Base64.padSymbol, 45, 38, 62, 39, Ascii.SYN, 
        62, 33, 44, 39, Ascii.SYN, 32, 40, 43, Ascii.SYN, 38, 57, 44, 39};
    }

    public abstract int A0o();

    public abstract int A0p();

    public NQ() {
        String A04 = A04(0, 0, 51);
        this.A0J = A04;
        this.A02 = 200;
        this.A0H = A04;
        this.A0Q = A04;
        this.A0P = A04;
        this.A0R = A04;
        this.A0N = A04;
        this.A0M = A04;
        this.A0L = A04;
        this.A0O = A04;
        this.A0K = A04;
        this.A0T = A04;
        this.A0U = A04;
        this.A0s = false;
        this.A0X = false;
        this.A0v = false;
        this.A0n = false;
        this.A0x = false;
        this.A0j = false;
        this.A0r = false;
        this.A0g = false;
        this.A0u = false;
        this.A0I = A04;
        this.A0E = A04(1393, 15, 24);
        this.A0e = false;
        this.A0F = A04;
        this.A10 = false;
        this.A0G = A04;
        this.A11 = false;
        this.A09 = A04(1077, 5, 102);
        this.A0W = A04;
    }

    public static NQ A03(JSONObject jSONObject, C1929gi c1929gi) {
        boolean has = jSONObject.has(A04(773, 12, 68));
        boolean z = false;
        JSONArray optJSONArray = jSONObject.optJSONArray(A04(765, 8, 75));
        if (optJSONArray != null && optJSONArray.length() > 0) {
            z = true;
        }
        NQ nq = null;
        if (has) {
            try {
                nq = C2088jT.A00(jSONObject, c1929gi);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (nq == null) {
            has = false;
            nq = C08047l.A00(jSONObject, c1929gi);
        }
        nq.A1Q(has);
        nq.A0a(z);
        return nq;
    }

    private void A06(double d) {
        this.A00 = d;
    }

    private void A07(int i) {
        this.A03 = i;
    }

    private final void A08(long j) {
        this.A04 = j;
    }

    private final void A09(long j) {
        this.A05 = j;
    }

    private void A0A(String str) {
        this.A0A = str;
    }

    private void A0B(String str) {
        this.A0B = str;
    }

    private void A0C(String str) {
        this.A0S = str;
    }

    private final void A0D(String str) {
        this.A0H = str;
    }

    private final void A0E(String str) {
        this.A0K = str;
    }

    private final void A0F(String str) {
        this.A0L = str;
    }

    private final void A0G(String str) {
        this.A0M = str;
    }

    private final void A0H(String str) {
        this.A0N = str;
    }

    private final void A0I(String str) {
        this.A0O = str;
    }

    private final void A0J(String str) {
        this.A0P = str;
    }

    private final void A0K(String str) {
        this.A0Q = str;
    }

    private final void A0L(String str) {
        this.A0R = str;
    }

    private final void A0M(String str) {
        this.A0T = str;
    }

    private final void A0N(String str) {
        this.A0U = str;
    }

    private void A0O(JSONObject jSONObject) {
        this.A0J = jSONObject.toString();
    }

    private void A0P(JSONObject jSONObject) {
        if (!A1r()) {
            return;
        }
        boolean A1p = A1p();
        String A04 = A04(1648, 30, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE);
        if (A1p) {
            A0K(jSONObject.optString(A04, A04(MBSupportMuteAdType.INTERSTITIAL_VIDEO, 65, 76)));
        } else {
            A0K(jSONObject.optString(A04, A04(0, 54, 55)));
        }
        A0J(jSONObject.optString(A04(1627, 21, 101), A04(112, 22, 100)));
        A0L(jSONObject.optString(A04(1678, 19, 91), A04(134, 26, 14)));
    }

    private final void A0Q(boolean z) {
        this.A0f = z;
    }

    private final void A0R(boolean z) {
        this.A0g = z;
    }

    private final void A0S(boolean z) {
        this.A0j = z;
    }

    private final void A0T(boolean z) {
        this.A0k = z;
    }

    private final void A0U(boolean z) {
        this.A0l = z;
    }

    private final void A0V(boolean z) {
        this.A0m = z;
    }

    private final void A0W(boolean z) {
        this.A0c = z;
    }

    private final void A0X(boolean z) {
        this.A0d = z;
    }

    private final void A0Y(boolean z) {
        this.A0n = z;
    }

    private final void A0Z(boolean z) {
        this.A0o = z;
    }

    private final void A0a(boolean z) {
        this.A0h = z;
    }

    private final void A0b(boolean z) {
        this.A0r = z;
    }

    private final void A0c(boolean z) {
        this.A0z = z;
    }

    private final void A0d(boolean z) {
        this.A12 = z;
    }

    private final void A0e(boolean z) {
        this.A13 = z;
    }

    private final void A0f(boolean z) {
        this.A14 = z;
    }

    private final void A0g(boolean z) {
        this.A0t = z;
    }

    private final void A0h(boolean z) {
        this.A0u = z;
    }

    private final void A0i(boolean z) {
        this.A0v = z;
    }

    private final void A0j(boolean z) {
        this.A0x = z;
    }

    public final double A0k() {
        return this.A00;
    }

    public final int A0l() {
        return this.A01;
    }

    public final int A0m() {
        return this.A03;
    }

    public final int A0n() {
        return this.A15;
    }

    public final long A0q() {
        return this.A05;
    }

    public final long A0r() {
        return this.A06;
    }

    public final RewardData A0s() {
        return this.A07;
    }

    public final C1188Nb A0t() {
        return this.A08;
    }

    public final String A0u() {
        return A16;
    }

    public final String A0v() {
        return this.A09;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String A0w() {
        char c;
        String str = this.A0D;
        switch (str.hashCode()) {
            case -1364000502:
                if (str.equals(A04(1816, 14, 41))) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1052618729:
                if (str.equals(A04(1387, 6, 14))) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 604727084:
                if (str.equals(A04(1274, 12, 64))) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return A04(834, 37, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE);
            case 1:
                return EnumC1822ez.A04.A03();
            case 2:
                return EnumC1821ey.A03.A03();
            default:
                return A04(0, 0, 51);
        }
    }

    public final String A0x() {
        return this.A0A;
    }

    public final String A0y() {
        return this.A0B;
    }

    public final String A0z() {
        return this.A0C;
    }

    public final String A10() {
        return this.A0D;
    }

    public final String A11() {
        return this.A0F;
    }

    public final String A12() {
        return this.A0G;
    }

    public final String A13() {
        return this.A0H;
    }

    public final String A14() {
        return this.A0I;
    }

    public final String A15() {
        return this.A0K;
    }

    public final String A16() {
        return this.A0L;
    }

    public final String A17() {
        return this.A0M;
    }

    public final String A18() {
        return this.A0N;
    }

    public final String A19() {
        return this.A0O;
    }

    public final String A1A() {
        return this.A0P;
    }

    public final String A1B() {
        return this.A0Q;
    }

    public final String A1C() {
        return this.A0R;
    }

    public final String A1D() {
        return this.A0S;
    }

    public final String A1E() {
        return this.A0T;
    }

    public final String A1F() {
        return this.A0U;
    }

    public final String A1G() {
        return this.A0V;
    }

    public final JSONObject A1H() {
        try {
            return new JSONObject(this.A0J);
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public final void A1I(int i) {
        this.A02 = i;
    }

    public final void A1J(long j) {
        this.A06 = j;
    }

    public final void A1K(RewardData rewardData) {
        this.A07 = rewardData;
    }

    public final void A1L(String str) {
        A16 = str;
    }

    public final void A1M(String str) {
        this.A0C = str;
    }

    public final void A1N(String str) {
        this.A0D = str;
    }

    public final void A1O(String str) {
        this.A0V = str;
    }

    public final void A1P(JSONObject jSONObject) {
        String A04 = A04(1749, 10, 31);
        String A042 = A04(0, 0, 51);
        A0C(jSONObject.optString(A04, A042));
        A0B(jSONObject.optString(A04(1064, 13, 30)));
        A0O(jSONObject);
        A07(jSONObject.optInt(A04(1886, 31, 24), 0));
        A1I(jSONObject.optInt(A04(1917, 26, 47), 1000));
        A0A(jSONObject.optString(A04(IronSourceError.ERROR_RV_SHOW_EXCEPTION, 26, 51), A042));
        A0U(jSONObject.optBoolean(A04(871, 23, 73), false));
        A0V(jSONObject.optBoolean(A04(894, 37, Sdk.SDKError.Reason.TPAT_ERROR_VALUE), false));
        A0Q(jSONObject.optBoolean(A04(612, 32, 35), false));
        A0T(jSONObject.optBoolean(A04(807, 27, 32), false));
        A0f(jSONObject.optBoolean(A04(1697, 52, 52), false));
        A0Z(jSONObject.optBoolean(A04(1216, 30, 41), false));
        A0D(jSONObject.optString(A04(1182, 34, 68), A04(195, 65, 32)));
        A0c(jSONObject.optBoolean(A04(1456, 18, 41), false));
        A0d(jSONObject.optBoolean(A04(1575, 26, 85), false));
        A0e(jSONObject.optBoolean(A04(1601, 26, 90), false));
        A0P(jSONObject);
        A0X(jSONObject.optBoolean(A04(1127, 25, 14), false));
        A0W(jSONObject.optBoolean(A04(1105, 22, 59), false));
        A0H(jSONObject.optString(A04(1474, 16, 101), A04(54, 15, 75)));
        A0i(jSONObject.optBoolean(A04(492, 31, 57), false));
        A0Y(jSONObject.optBoolean(A04(466, 26, 96), false));
        A0j(jSONObject.optBoolean(A04(523, 31, 94), false));
        A0S(jSONObject.optBoolean(A04(407, 26, 37), false));
        A0b(jSONObject.optBoolean(A04(433, 33, 120), false));
        A0R(jSONObject.optBoolean(A04(384, 23, 97), false));
        A0h(jSONObject.optBoolean(A04(1300, 19, 83), false));
        A0g(jSONObject.optBoolean(A04(1871, 15, 19), false));
        A0F(jSONObject.optString(A04(1408, 26, 97), A04(97, 15, 107)));
        A0I(jSONObject.optString(A04(1490, 31, 16), A04(160, 20, 99)));
        A0G(jSONObject.optString(A04(1434, 22, 52), A04(69, 28, 7)));
        A0E(jSONObject.optString(A04(1759, 19, 84), A04(352, 32, 74)));
        A0M(jSONObject.optString(A04(1778, 22, 126), A04(180, 15, 43)));
        A0N(jSONObject.optString(A04(1800, 16, 29), A04(260, 27, 4)));
        this.A0a = jSONObject.optBoolean(A04(1006, 14, 36));
        this.A0b = jSONObject.optBoolean(A04(1020, 18, 115));
        this.A0Z = jSONObject.optBoolean(A04(979, 27, Sdk.SDKError.Reason.TPAT_ERROR_VALUE), true);
        this.A0p = jSONObject.optBoolean(A04(1246, 28, 101), false);
        this.A0I = jSONObject.optString(A04(1319, 21, 11), A042);
        A09(jSONObject.optLong(A04(785, 22, 83), -1L));
        A08(jSONObject.optLong(A04(953, 26, 7), -1L));
        A06(jSONObject.optDouble(A04(1369, 18, 5), 1.0d));
        this.A0W = jSONObject.optString(A04(1830, 41, 59), A04(644, Sdk.SDKError.Reason.TPAT_ERROR_VALUE, 45));
        this.A0E = jSONObject.optString(A04(1082, 23, 67), A04(1393, 15, 24));
        this.A0q = jSONObject.optBoolean(A04(1340, 29, 87), false);
        this.A0y = jSONObject.optBoolean(A04(1943, 30, 115), false);
        this.A0w = jSONObject.optBoolean(A04(1973, 40, 97), false);
        this.A0e = jSONObject.optBoolean(A04(1286, 14, 28), false);
        this.A09 = jSONObject.optString(A04(554, 19, 34), A04(1077, 5, 102));
        this.A0F = jSONObject.optString(A04(1152, 17, 46), A042);
        this.A10 = jSONObject.optBoolean(A04(1521, 27, 41), false);
        this.A0G = jSONObject.optString(A04(1169, 13, 12), A042);
        this.A11 = jSONObject.optBoolean(A04(1548, 27, 7), false);
        this.A0Y = jSONObject.optBoolean(A04(573, 20, 19), false);
        this.A01 = jSONObject.optInt(A04(593, 19, 33), 100);
        JSONObject creditLineImageI18NJson = jSONObject.optJSONObject(A04(931, 22, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE));
        if (creditLineImageI18NJson != null) {
            this.A08 = C1188Nb.A00(creditLineImageI18NJson);
        }
    }

    public final void A1Q(boolean z) {
        this.A0i = z;
    }

    public final void A1R(boolean z) {
        this.A0s = z;
    }

    public final void A1S(boolean z) {
        this.A0X = z;
    }

    public final boolean A1T() {
        return this.A0a;
    }

    public final boolean A1U() {
        return this.A0b;
    }

    public final boolean A1V() {
        return this.A0Z;
    }

    public final boolean A1W() {
        return this.A0e;
    }

    public final boolean A1X() {
        return this.A0Y;
    }

    public final boolean A1Y() {
        return this.A0f;
    }

    public final boolean A1Z() {
        return this.A0h;
    }

    public final boolean A1a() {
        return this.A0g;
    }

    public final boolean A1b() {
        return this.A0i;
    }

    public final boolean A1c() {
        return this.A0j;
    }

    public final boolean A1d() {
        return this.A0k;
    }

    public final boolean A1e() {
        return this.A0l;
    }

    public final boolean A1f() {
        return this.A0m;
    }

    public final boolean A1g() {
        return !TextUtils.isEmpty(A0x());
    }

    public final boolean A1h() {
        return this.A0c;
    }

    public final boolean A1i() {
        return this.A0d;
    }

    public final boolean A1j() {
        return this.A0n;
    }

    public final boolean A1k() {
        return this.A0o;
    }

    public final boolean A1l() {
        return this.A0p;
    }

    public final boolean A1m() {
        return this.A0q;
    }

    public final boolean A1n() {
        return this.A0r;
    }

    public final boolean A1o() {
        return this.A0z;
    }

    public final boolean A1p() {
        return this.A12;
    }

    public final boolean A1q() {
        return this.A13;
    }

    public final boolean A1r() {
        return A1o() && (A1p() || A1q());
    }

    public final boolean A1s() {
        return this.A0s;
    }

    public final boolean A1t() {
        return this.A14;
    }

    public final boolean A1u() {
        return this.A0X;
    }

    public final boolean A1v() {
        return this.A0u;
    }

    public final boolean A1w() {
        return this.A0v;
    }

    public final boolean A1x() {
        return this.A0w;
    }

    public final boolean A1y() {
        return this.A0x;
    }

    public final boolean A1z() {
        return this.A0y;
    }

    public final boolean A20() {
        return this.A10;
    }

    public final boolean A21() {
        return this.A11;
    }
}
