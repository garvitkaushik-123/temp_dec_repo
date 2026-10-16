package com.instagram.common.viewpoint.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* loaded from: assets/audience_network/classes2.dex */
public final class NL extends BroadcastReceiver {
    public static byte[] A03;
    public static String[] A04 = {"Zajbq5JOCnWrQ3Qr", "TCN1z34NH4GHaAlQvwLAm", "H6zcI", "fG9vyRzubE117ecaxLAWdwziYhb1qpFD", "HGvL5kVmbL0dgsivMgEslo9gYSg3Drcz", "onuj3", "bRQo93cAMXtZyJucWKt", "haBpxRpvqIWUs6HGbuX"};
    public Context A00;
    public C07846r A01;
    public boolean A02 = false;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 51);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{53, Ascii.CAN, Ascii.DC4, Ascii.SYN, 85, Ascii.GS, Ascii.SUB, Ascii.CAN, Ascii.RS, Ascii.EM, Ascii.DC4, Ascii.DC4, Ascii.DLE, 85, Ascii.SUB, Ascii.US, 8, 85, Ascii.DC2, Ascii.NAK, Ascii.SI, Ascii.RS, 9, 8, Ascii.SI, Ascii.DC2, Ascii.SI, Ascii.DC2, Ascii.SUB, Ascii.ETB, 85, Ascii.US, Ascii.DC2, 8, Ascii.VT, Ascii.ETB, Ascii.SUB, 2, Ascii.RS, Ascii.US, 55, 59, 57, 122, 50, 53, 55, 49, 54, 59, 59, 63, 122, 53, 48, 39, 122, Base64.padSymbol, 58, 32, 49, 38, 39, 32, Base64.padSymbol, 32, Base64.padSymbol, 53, 56, 122, 48, Base64.padSymbol, 39, 36, 56, 53, 45, 49, 48, 110, 81, 66, 81, 90, SignedBytes.MAX_POWER_OF_TWO, 73, 92, 75, 95, 86, 75, 84, 122, 77, 88, 122, 85, 80, 90, 82, 71, 82, 69, 81, 88, 69, 90, 116, 67, 86, 116, 91, 94, 84, 92, Ascii.CR, 90, 69, 72, 73, 67, 101, 66, 88, 73, 94, 95, 88, 69, 88, 77, SignedBytes.MAX_POWER_OF_TWO, 105, 90, 73, 66, 88, 105, 118, 123, 122, 112, 86, 113, 107, 122, 109, 108, 107, 118, 107, 126, 115, 90, 105, 122, 113, 107, 37};
    }

    static {
        A01();
    }

    public NL(C07846r c07846r, Context context) {
        this.A01 = c07846r;
        this.A00 = context;
    }

    public final void A02() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(A00(40, 40, 103) + this.A01.getUniqueId());
        intentFilter.addAction(A00(Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, 22, 44) + this.A01.getUniqueId());
        intentFilter.addAction(A00(100, 16, 4) + this.A01.getUniqueId());
        P2.A00(this.A00).A06(this, intentFilter);
    }

    public final void A03() {
        try {
            P2.A00(this.A00).A05(this);
        } catch (Exception unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String action2 = A00(0, 1, 60);
        String[] split = action.split(action2);
        if (split.length != 2) {
            return;
        }
        String str = split[1];
        String action3 = this.A01.getUniqueId();
        if (!str.equals(action3)) {
            return;
        }
        String str2 = split[0];
        String[] strArr = A04;
        String str3 = strArr[6];
        String action4 = strArr[7];
        if (str3.length() == action4.length()) {
            String[] strArr2 = A04;
            strArr2[1] = "cVmv3UmH0jQ76579UnKAx";
            strArr2[0] = "Daa9OCgAFjmRw5DI";
            String action5 = A00(1, 39, 72);
            if (str2.equals(action5)) {
                if (this.A01.getListener() != null) {
                    this.A01.getListener().ADn();
                    this.A01.getListener().AGe();
                    return;
                }
                return;
            }
            String str4 = split[0];
            String action6 = A00(116, 21, 31);
            if (str4.equals(action6)) {
                String action7 = A00(80, 5, 7);
                Serializable serializableExtra = intent.getSerializableExtra(action7);
                if (serializableExtra instanceof C0954Dy) {
                    if (this.A01.getListener() != null) {
                        this.A01.getListener().ADt();
                        this.A01.getListener().AGe();
                    }
                    if (this.A02) {
                        this.A01.A0a(1);
                    } else {
                        this.A01.A0a(((C0954Dy) serializableExtra).A01());
                    }
                    this.A01.setVisibility(0);
                    this.A01.A0e(EnumC1816et.A04, 1);
                    return;
                }
                if (serializableExtra instanceof E6) {
                    if (this.A01.getListener() == null) {
                        return;
                    }
                    C07846r c07846r = this.A01;
                    String[] strArr3 = A04;
                    String str5 = strArr3[6];
                    String action8 = strArr3[7];
                    if (str5.length() == action8.length()) {
                        String[] strArr4 = A04;
                        strArr4[3] = "8JMcdO2ddwvsOz1l0eACjHxgYswUY7yr";
                        strArr4[4] = "ZybcsncwY6JEIQQDyQcFnHvjYhNwtivs";
                        c07846r.getListener().AE1();
                        return;
                    }
                } else {
                    if (serializableExtra instanceof E5) {
                        if (this.A01.getListener() == null) {
                            return;
                        }
                        this.A01.getListener().AE3();
                        return;
                    }
                    if (serializableExtra instanceof C4K) {
                        if (this.A01.getListener() != null) {
                            this.A01.getListener().ADQ();
                        }
                        this.A02 = true;
                        return;
                    }
                    if (serializableExtra instanceof E3) {
                        if (this.A01.getListener() != null) {
                            this.A01.getListener().AFC();
                        }
                        this.A02 = false;
                        return;
                    }
                    boolean z = serializableExtra instanceof C4B;
                    String[] strArr5 = A04;
                    String str6 = strArr5[5];
                    String action9 = strArr5[2];
                    if (str6.length() == action9.length()) {
                        String[] strArr6 = A04;
                        strArr6[5] = "0aNC0";
                        strArr6[2] = "prrJE";
                        if (!z || this.A01.getListener() == null) {
                            return;
                        }
                        this.A01.getListener().onPause();
                        return;
                    }
                }
            } else {
                String str7 = split[0];
                String[] strArr7 = A04;
                String str8 = strArr7[1];
                String action10 = strArr7[0];
                if (str8.length() != action10.length()) {
                    String[] strArr8 = A04;
                    strArr8[6] = "hQHl7K2LkQxZ3MVJZ2W";
                    strArr8[7] = "MyC8C5hgly0WituHMEy";
                    String action11 = A00(85, 15, 10);
                    if (!str7.equals(action11)) {
                        return;
                    }
                } else {
                    String[] strArr9 = A04;
                    strArr9[3] = "OiP3hK9qgel9CjGx7GeTViZjY0DdeBQ1";
                    strArr9[4] = "Kg9TdH9JmWDwVESkwLvI07zIYN1y95Tk";
                    String action12 = A00(70, 4, 4);
                    if (!str7.equals(action12)) {
                        return;
                    }
                }
                this.A01.A0r();
                return;
            }
        }
        throw new RuntimeException();
    }
}
