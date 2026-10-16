package com.instagram.common.viewpoint.core;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.facebook.ads.internal.util.common.Preconditions;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: assets/audience_network/classes2.dex */
public class US extends AsyncTask<Void, Void, String> {
    public static byte[] A05;
    public C1375Ul A00;
    public final T8 A01;
    public final UO<String> A02;
    public final InterfaceC1366Uc<V7> A03;
    public final V7 A04;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 12);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{Ascii.DC4, 89, 110, 110, 115, 110, 60, 113, 121, 111, 111, 125, 123, 121, 60, Byte.MAX_VALUE, 125, 114, 114, 115, 104, 60, 126, 121, 60, 114, 105, 112, 112, 99, SignedBytes.MAX_POWER_OF_TWO, 72, 72, 70, 65, 72, Ascii.SI, 74, 89, 74, 65, 91, Ascii.NAK, Ascii.SI, 102, 113, 119, 123, 102, 112, 75, 112, 117, 96, 117, 118, 117, 103, 113};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.UO != com.facebook.ads.internal.eventstorage.AdEventStorageCallback<java.lang.String> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Uc != com.facebook.ads.internal.eventstorage.record.RecordDatabase<com.facebook.ads.internal.logging.AdEvent> */
    public US(V7 v7, UO<String> uo, InterfaceC1366Uc<V7> interfaceC1366Uc, T8 t8) {
        this.A04 = v7;
        this.A03 = interfaceC1366Uc;
        this.A02 = uo;
        this.A01 = t8;
    }

    private final String A01(Void... voidArr) {
        byte[] A07;
        if (WU.A02(this)) {
            return null;
        }
        String str = null;
        try {
            try {
                str = UUID.randomUUID().toString();
                this.A01.A08().AA3(this.A04.A06().toString());
            } catch (C1375Ul e) {
                this.A00 = e;
                this.A01.A08().ABC(A00(44, 15, 24), AbstractC1341Td.A2N, new C1342Te(e));
            }
            if (TextUtils.isEmpty(this.A04.A08())) {
                return null;
            }
            if (this.A01.A05().AAO()) {
                String str2 = A00(29, 15, 35) + this.A04.A06().toString() + A00(0, 1, 56) + this.A04.A09().toString();
            }
            InterfaceC1366Uc<V7> interfaceC1366Uc = this.A03;
            A07 = ZD.A07(this.A01, str, this.A04);
            interfaceC1366Uc.AKH(A07);
            return str;
        } catch (Throwable th) {
            WU.A00(th, this);
            return null;
        }
    }

    private final void A03(String str) {
        if (WU.A02(this)) {
            return;
        }
        try {
            if (this.A00 == null) {
                this.A02.A02(str);
            } else {
                this.A02.A01(0, (String) Preconditions.checkNotNull(this.A00.getMessage(), A00(1, 28, 16)));
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ String doInBackground(Void[] voidArr) {
        if (WU.A02(this)) {
            return null;
        }
        try {
            return A01(voidArr);
        } catch (Throwable th) {
            WU.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(String str) {
        if (WU.A02(this)) {
            return;
        }
        try {
            A03(str);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
