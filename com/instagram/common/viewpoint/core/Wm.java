package com.instagram.common.viewpoint.core;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.io.encoding.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network/classes2.dex */
public final class Wm implements V9 {
    public static byte[] A0D;
    public static String[] A0E = {"KlcQ4aPMCjTEuj6tlqvSPg02tmhmGUou", "NbdeitWOc1zrv1JDjauqKHmjPPhSGwGe", "R4vSD9xrU3uFkHfeeGcLq0xvgbIcHayT", "rvVAUvGslDbkwSzXQ4gHiQTP5zrG", "ljLEgEfbMYnmdR7mWy3vUvMk8HSCwfcz", "YjYM3cC5SO9DuryblpH9N9a8sNamrwLD", "dglxEHbBnsXp5lOZvNi9PFSn5QE5iyod", "nrMzKM4Ejqm74mRasA"};
    public static final String A0F;
    public int A00;
    public long A01;
    public final long A02;
    public final long A03;
    public final ConnectivityManager A04;
    public final C1925ge A06;
    public final V8 A07;
    public final InterfaceC1880fv A08;
    public volatile boolean A0C;
    public final Runnable A0A = new C1430Wr(this);
    public final Runnable A09 = new C1429Wq(this);
    public final ThreadPoolExecutor A0B = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    public final Handler A05 = new Handler(Looper.getMainLooper());

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A0E[2].charAt(25) == '3') {
                throw new RuntimeException();
            }
            String[] strArr = A0E;
            strArr[3] = "STFGVVXWKW9SjLATYObI8PiLTu9r";
            strArr[7] = "1bj9PcPMGQWJpkILDx";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 77);
            i4++;
        }
    }

    public static void A07() {
        A0D = new byte[]{106, 121, 99, 84, 88, 117, 111, 108, 125, 104, Byte.MAX_VALUE, 116, 117, 114, 123, 60, 121, 106, 121, 114, 104, 60, 52, SignedBytes.MAX_POWER_OF_TWO, 125, 102, 96, 117, 113, 108, 106, 107, 37, 114, 109, 108, 105, 96, 37, 97, 108, 118, 117, 100, 113, 102, 109, 108, 107, 98, 37, 96, 115, 96, 107, 113, 118, 43, 73, Byte.MAX_VALUE, 104, 108, Byte.MAX_VALUE, 104, 58, 106, 104, 117, 121, Byte.MAX_VALUE, 105, 105, Byte.MAX_VALUE, 126, 58, 106, 123, 104, 110, 115, 123, 118, 58, 120, 123, 110, 121, 114, 54, 58, 121, 117, 116, 110, 115, 116, 111, 115, 116, 125, 58, 110, 117, 58, 116, Byte.MAX_VALUE, 98, 110, 58, 117, 116, Byte.MAX_VALUE, 52, 89, 111, 120, 124, 111, 120, 42, 120, 111, 121, 122, 101, 100, 121, 111, 42, 99, 121, 42, 111, 103, 122, 126, 115, 36, 0, 54, 33, 37, 54, 33, 115, 33, 54, 39, 38, 33, Base64.padSymbol, 54, 55, 115, 50, 115, Base64.padSymbol, 60, Base64.padSymbol, 126, 32, 38, 48, 48, 54, 32, 32, 53, 38, 63, 115, 32, 39, 50, 39, 38, 32, 115, 48, 60, 55, 54, 115, 60, 53, 115, 70, 112, 103, 99, 112, 103, 53, 98, 116, 102, 53, 96, 123, 116, 119, 121, 112, 53, 97, 122, 53, 101, 103, 122, 118, 112, 102, 102, 53, 116, 121, 121, 53, 112, 99, 112, 123, 97, 102, 57, 53, 97, 103, 108, 124, 123, 114, 53, 116, 114, 116, 124, 123, 59, 57, 1, 3, Ascii.SUB, Ascii.SUB, 3, 4, Ascii.CR, 74, Ascii.SO, 3, Ascii.EM, Ascii.SUB, Ascii.VT, Ascii.RS, 9, 2, 74, Ascii.SO, Ascii.US, Ascii.SI, 74, Ascii.RS, 5, 74, 6, Ascii.VT, 9, 1, 74, 5, Ascii.FF, 74, 9, 5, 4, 4, Ascii.SI, 9, Ascii.RS, 3, Ascii.FS, 3, Ascii.RS, 19, 68, 74, 95, 95, 78, 70, 91, 95, 93, 81, 80, 80, 91, 93, 74, 87, 72, 87, 74, 71, 32, 37, 48, 37, 3, Ascii.DLE, 3, 8, Ascii.DC2, Ascii.NAK, 59, 42, 50, 39, 36, 42, 47};
    }

    static {
        A07();
        A0F = V9.class.getSimpleName();
    }

    public Wm(C1925ge c1925ge, V8 v8) {
        this.A07 = v8;
        this.A06 = c1925ge;
        this.A04 = (ConnectivityManager) c1925ge.getSystemService(A03(293, 12, 115));
        this.A08 = C1898gD.A01(c1925ge);
        this.A03 = AbstractC1381Ur.A0K(c1925ge);
        this.A02 = AbstractC1381Ur.A0J(c1925ge);
    }

    public static /* synthetic */ int A00(Wm wm) {
        int i = wm.A00 + 1;
        wm.A00 = i;
        return i;
    }

    private void A05() {
        this.A06.A05().AAO();
        this.A00 = 0;
        this.A01 = 0L;
        if (this.A0B.getQueue().size() == 0) {
            this.A07.ACu();
        }
    }

    private void A06() {
        if (this.A00 >= AbstractC1381Ur.A09(this.A06)) {
            A05();
            A61();
            return;
        }
        int i = this.A00;
        if (A0E[4].charAt(15) == 'm') {
            String[] strArr = A0E;
            strArr[0] = "48XWu56AgSaDG2v80CTGd4cBK4h9Z0cs";
            strArr[1] = "AYX5vj0PphgSAPbgEesjNh2Dg1h2Tuc1";
            if (i == 1) {
                this.A01 = AbstractC1381Ur.A0I(this.A06);
            } else {
                long j = this.A01 * 2;
                String[] strArr2 = A0E;
                if (strArr2[5].charAt(19) == strArr2[6].charAt(19)) {
                    String[] strArr3 = A0E;
                    strArr3[0] = "1ToF3hMm2VA6KDOeCYlfpYX9EZhWZaCs";
                    strArr3[1] = "Z30ky6DQTC9ucfzgiQKOMI68k5hVrHHu";
                    this.A01 = j;
                }
            }
            A62();
            return;
        }
        throw new RuntimeException();
    }

    private void A08(long j) {
        this.A05.postDelayed(this.A09, j);
    }

    private void A09(JSONObject jSONObject) throws JSONException {
        Map<String, String> shortEvnData = this.A06.A04().A5a();
        for (Map.Entry<String, String> entry : shortEvnData.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
    }

    public final void A0B() {
        try {
            NetworkInfo activeNetwork = this.A04.getActiveNetworkInfo();
            if (activeNetwork == null || !activeNetwork.isConnectedOrConnecting()) {
                if (this.A06.A05().AAO()) {
                    Log.e(A0F, A03(240, 46, 39));
                }
                A08(this.A02);
                return;
            }
            this.A06.A05().AAO();
            JSONObject A5L = this.A07.A5L();
            if (A5L == null) {
                this.A06.A05().AAO();
                A05();
                return;
            }
            boolean AAO = this.A06.A05().AAO();
            String A03 = A03(Sdk.SDKError.Reason.ASSET_FAILED_TO_DELETE_VALUE, 6, 43);
            if (AAO && A5L.has(A03)) {
                JSONArray jSONArray = A5L.getJSONArray(A03);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String str = A03(4, 19, 81) + i + A03(0, 3, 14) + jSONArray.get(i);
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A03(286, 7, 102), String.valueOf(this.A00));
            A09(jSONObject);
            A5L.put(A03(Sdk.SDKError.Reason.MRAID_BRIDGE_ERROR_VALUE, 4, 9), jSONObject);
            C1894g9 c1894g9 = new C1894g9();
            c1894g9.put(A03(Sdk.SDKError.Reason.JSON_PARAMS_ENCODE_ERROR_VALUE, 7, 6), A5L.toString());
            InterfaceC1879fu AGx = this.A08.AGx(this.A06.A05().A86(), c1894g9.A08());
            String A73 = AGx != null ? AGx.A73() : null;
            if (!TextUtils.isEmpty(A73) && AGx != null) {
                if (AGx.A9C() != 200) {
                    if (this.A06.A05().AAO()) {
                        String responseBody = A0F;
                        Log.e(responseBody, A03(138, 48, 30) + AGx.A9C() + A03(3, 1, 55));
                    }
                    if (AGx.A9C() == 413 && C1379Up.A2Y(this.A06)) {
                        this.A07.AFZ();
                        A05();
                        return;
                    } else {
                        if (A5L.has(A03)) {
                            this.A07.ADe(A5L.getJSONArray(A03));
                        }
                        A06();
                        return;
                    }
                }
                if (!this.A07.ADf(new JSONArray(A73))) {
                    if (this.A06.A05().AAO()) {
                        Log.w(A0F, A03(186, 54, 88));
                    }
                    A06();
                    return;
                } else {
                    if (this.A07.AAb()) {
                        if (this.A06.A05().AAO()) {
                            Log.i(A0F, A03(58, 55, 87));
                        }
                        A06();
                        return;
                    }
                    A05();
                    return;
                }
            }
            if (this.A06.A05().AAO()) {
                Log.e(A0F, A03(113, 25, 71));
            }
            if (C1379Up.A2N(this.A06) && A5L.has(A03)) {
                this.A07.ADe(A5L.getJSONArray(A03));
            }
            A06();
        } catch (Exception e) {
            C1925ge c1925ge = this.A06;
            String[] strArr = A0E;
            if (strArr[0].charAt(26) != strArr[1].charAt(26)) {
                Exception e2 = new RuntimeException();
                throw e2;
            }
            String[] strArr2 = A0E;
            strArr2[5] = "juVm3rSGrTKw83uGBob9EWWg86xlgGIp";
            strArr2[6] = "uyuZsDIDSXItwx867Sl9CxjwWd0LLO11";
            if (c1925ge.A05().AAO()) {
                Log.e(A0F, A03(23, 35, 72), e);
            }
            A06();
        }
    }

    @Override // com.instagram.common.viewpoint.core.V9
    public final void A61() {
        if (this.A0C) {
            return;
        }
        this.A0C = true;
        this.A05.removeCallbacks(this.A09);
        A08(this.A02);
    }

    @Override // com.instagram.common.viewpoint.core.V9
    public final void A62() {
        this.A0C = true;
        this.A05.removeCallbacks(this.A09);
        A08(this.A03);
    }
}
