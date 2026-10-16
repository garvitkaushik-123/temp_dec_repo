package com.instagram.common.viewpoint.core;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.api.AudienceNetworkActivityApi;
import com.facebook.ads.internal.context.Repairable;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.Re, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1291Re implements AudienceNetworkActivityApi, Repairable {
    public static byte[] A0L;
    public static String[] A0M = {"4LY4lS0Dtnhb2OiQyA5efrKIFR", "dGupKpVCMt4qg9mKwPVhImHWchSaWcIC", "ZyPDBV2Dgn506ClNEjHAvEDIkGgGqxcu", "6d7pmCocDfQ9ggh3dWvmWW2CO", "v0AhzTtfFBaqfNNgAD9Hm9U40nGOHxVb", "UIU6rcdX7ZqD4Xq5NwRFZisMuquIGFkO", "tB8Uz7UMZA3JApFIn70Qu6pSbr2GCqXd", "GRU7Zt0cjyIBsRz9MT2AF"};
    public int A00;
    public int A02;
    public long A03;
    public long A04;
    public Intent A05;
    public RelativeLayout A06;
    public WK A07;
    public InterfaceC1471Yi A08;
    public AbstractC1492Zd A09;
    public C1777eF A0A;
    public String A0B;
    public String A0C;
    public boolean A0D;
    public final AudienceNetworkActivity A0E;
    public final AudienceNetworkActivityApi A0F;
    public final C1301Ro A0G;
    public final S1 A0H;
    public final SK A0I;
    public final C1929gi A0J;
    public final List<InterfaceC1297Rk> A0K = new ArrayList();
    public int A01 = -1;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0L, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 34);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0L = new byte[]{3, 56, 55, 52, 58, 51, 118, 34, 57, 118, 63, 56, 48, 51, 36, 118, 32, 63, 51, 33, 2, 47, 38, 51, 118, 48, 36, 57, 59, 118, 63, 56, 34, 51, 56, 34, 118, 57, 36, 118, 37, 55, 32, 51, 50, Ascii.US, 56, 37, 34, 55, 56, 53, 51, 5, 34, 55, 34, 51, 42, 37, Ascii.DC4, 42, 40, 63, 34, Base64.padSymbol, 34, 63, 50, 122, 120, 117, 117, 124, 107, 77, 96, 105, 124, 121, 118, 115, Byte.MAX_VALUE, 116, 110, 78, 117, 113, Byte.MAX_VALUE, 116, 116, 120, 122, 57, 113, 118, 116, 114, 117, 120, 120, 124, 57, 118, 115, 100, 57, 126, 121, 99, 114, 101, 100, 99, 126, 99, 126, 118, 123, 57, 115, 126, 100, 103, 123, 118, 110, 114, 115, 110, 99, 108, 102, 113, 97, 99, 114, 103, 62, 37, 60, 60, 49, 40, 59, 44, 44, 55, 58, 59, Ascii.SUB, 43, 51, 46, 45, 39, 45, 46, 49, 44, 42, 44, 63, 55, 42, 7, 5, Ascii.DC2, 19, Ascii.DC2, 17, Ascii.RS, Ascii.EM, Ascii.DC2, 19, 56, 5, Ascii.RS, Ascii.DC2, Ascii.EM, 3, Ascii.SYN, 3, Ascii.RS, Ascii.CAN, Ascii.EM, 60, Ascii.DC2, Ascii.SO, 79, 87, 85, 76, 125, 90, 72, 89, 78, 111, 89, 95, 83, 82, 88, 79, 122, 97, 81, 97, 124, 103, 107, 96, 122, 111, 122, 103, 97, 96, 112, 107, 108, 116, 112, 96, 76, 97, Ascii.SO, 17, Ascii.GS, Ascii.SI, 44, 1, 8, Ascii.GS};
    }

    static {
        A02();
    }

    public C1291Re(AudienceNetworkActivity audienceNetworkActivity, AudienceNetworkActivityApi audienceNetworkActivityApi) {
        this.A0E = audienceNetworkActivity;
        this.A0F = audienceNetworkActivityApi;
        this.A0J = C1302Rp.A02(audienceNetworkActivity);
        this.A0J.A0O(this);
        this.A0H = new S1(this.A0J, this.A0E);
        this.A0I = new SK(this.A0J, this.A0E);
        this.A0G = new C1301Ro(this, this.A0J, this.A0E);
    }

    private String A00() {
        if (this.A07 == null || this.A07.A03() == null) {
            return A01(138, 4, 114);
        }
        return this.A07.A03();
    }

    private void A03(Intent intent, Bundle bundle) {
        String A01 = A01(227, 8, 90);
        String A012 = A01(Sdk.SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE, 8, 39);
        String A013 = A01(165, 24, 85);
        if (bundle != null) {
            Bundle A03 = C1433Wu.A03(bundle, DynamicLoaderImpl.class.getClassLoader());
            this.A01 = A03.getInt(A013, -1);
            this.A0B = A03.getString(A012);
            this.A07 = (WK) A03.getSerializable(A01);
            return;
        }
        this.A01 = intent.getIntExtra(A013, -1);
        this.A0B = intent.getStringExtra(A012);
        this.A07 = (WK) intent.getSerializableExtra(A01);
        this.A02 = intent.getIntExtra(A01(189, 16, 30), 0) * 1000;
    }

    public final RelativeLayout A04() {
        return this.A06;
    }

    public final AudienceNetworkActivity A05() {
        return this.A0E;
    }

    public final C1929gi A06() {
        return this.A0J;
    }

    public final C1777eF A07() {
        return this.A0A;
    }

    public final String A08() {
        return this.A0B;
    }

    public final void A09() {
        this.A0G.A05(this.A07, this.A0B);
    }

    public final void A0A(InterfaceC1297Rk interfaceC1297Rk) {
        this.A0K.add(interfaceC1297Rk);
    }

    public final void A0B(InterfaceC1297Rk interfaceC1297Rk) {
        this.A0K.remove(interfaceC1297Rk);
    }

    public final void A0C(String str) {
        this.A0G.A09(str, this.A0B);
    }

    public final void A0D(String str, C1199Nm c1199Nm) {
        if (this.A08 == null) {
            return;
        }
        AbstractC1492Zd abstractC1492Zd = this.A09;
        if (A0M[6].charAt(30) != 'X') {
            throw new RuntimeException();
        }
        A0M[0] = "nOOhjPgmgj4ymGbfbhDfGuv2YA";
        if (abstractC1492Zd == null) {
            this.A09 = AbstractC1493Ze.A02(this.A0J, this.A0J.A0A(), str, c1199Nm, this.A08, new C1975hS(this));
            this.A09.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        YB.A0J(this.A09);
        this.A06.addView(this.A09);
        this.A09.A0N();
    }

    public final void A0E(String str, UL ul) {
        this.A0G.A08(str, ul, this.A0B);
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        X2.A00();
        if (0 != 0) {
            throw new NullPointerException(A01(142, 15, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE));
        }
        this.A0F.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void finish(int i) {
        if (i == 9 && (this.A08 instanceof C1011Ge)) {
            C1011Ge c1011Ge = (C1011Ge) this.A08;
            if (c1011Ge.A0e()) {
                if (this.A09 != null) {
                    YB.A0J(this.A09);
                }
                c1011Ge.A0d();
                return;
            }
        }
        this.A0J.A0F().A3D(String.valueOf(A05().hashCode()), i, A00());
        if (this.A0E.isFinishing()) {
            return;
        }
        this.A0G.A07(this.A07, this.A0B);
        this.A0G.A06(this.A07, this.A0B);
        AudienceNetworkActivityApi audienceNetworkActivityApi = this.A0F;
        if (A0M[3].length() != 25) {
            throw new RuntimeException();
        }
        String[] strArr = A0M;
        strArr[2] = "aKr9nEsLo3sy9RHNghfDRuWnztPSExey";
        strArr[4] = "uIkYfs9grt0Hx69LL2s0ShAsw1OMdxMD";
        audienceNetworkActivityApi.finish(i);
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onActivityResult(int i, int i2, Intent intent) {
        if (this.A08 != null && this.A08.onActivityResult(i, i2, intent)) {
            return;
        }
        M3.A07(i, i2, intent);
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onBackPressed() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.A03;
        long currentTime = currentTimeMillis - this.A04;
        this.A03 = j + currentTime;
        this.A04 = currentTimeMillis;
        if (this.A03 > this.A02) {
            boolean shouldIntercept = false;
            Iterator<InterfaceC1297Rk> it = this.A0K.iterator();
            while (it.hasNext()) {
                if (it.next().AAI()) {
                    shouldIntercept = true;
                }
            }
            if (!shouldIntercept) {
                this.A0F.onBackPressed();
            }
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onConfigurationChanged(Configuration configuration) {
        if (this.A00 != configuration.orientation) {
            HashMap hashMap = new HashMap();
            int i = configuration.orientation;
            String A01 = A01(205, 14, 44);
            if (i == 1) {
                hashMap.put(A01, A01(157, 8, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE));
            } else {
                hashMap.put(A01, A01(129, 9, 32));
            }
            VI.A02(VH.A0K, hashMap, this.A08 == null ? A01(0, 0, 15) : this.A08.getCurrentClientToken(), this.A0J.A0A());
            this.A00 = configuration.orientation;
            this.A0H.A01();
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onCreate(Bundle bundle) {
        YD.A02();
        this.A0I.A04();
        this.A05 = C1433Wu.A02(this.A0E.getIntent(), DynamicLoaderImpl.class.getClassLoader());
        C1929gi A04 = C1433Wu.A04(this.A05);
        if (A04 != null) {
            C1929gi startAdContext = this.A0J;
            startAdContext.A0M(A04);
        }
        A03(this.A05, bundle);
        C1929gi startAdContext2 = this.A0J;
        startAdContext2.A0F().A3E(String.valueOf(A05().hashCode()), A00());
        String callerType = this.A05.getStringExtra(A01(69, 10, 59));
        this.A0I.A08(this.A07, callerType == null || !(callerType.equals(AdPlacementType.INTERSTITIAL.name()) || callerType.equals(AdPlacementType.REWARDED_VIDEO.name())));
        this.A06 = new RelativeLayout(this.A0E);
        YB.A0N(this.A06, 0);
        this.A0E.setContentView(this.A06, new RelativeLayout.LayoutParams(-1, -1));
        Intent intent = this.A05;
        C1929gi startAdContext3 = this.A0J;
        VA A0A = startAdContext3.A0A();
        C1929gi startAdContext4 = this.A0J;
        this.A08 = new C1296Rj(this, intent, A0A, startAdContext4).A0M(this.A07, this.A06);
        if (this.A08 == null) {
            C1929gi startAdContext5 = this.A0J;
            startAdContext5.A08().ABC(A01(58, 11, 105), AbstractC1341Td.A0A, new C1342Te(A01(0, 58, 116)));
            A09();
            finish(7);
            return;
        }
        this.A08.AAu(this.A05, bundle, this);
        this.A0G.A09(A01(90, 39, 53), this.A0B);
        this.A04 = System.currentTimeMillis();
        this.A0A = this.A0I.A03(this.A05, this.A06);
        this.A0I.A07(this.A05, this.A07, this.A06);
        this.A00 = this.A0E.getResources().getConfiguration().orientation;
        String callerType2 = A01(79, 11, 56);
        if (bundle != null) {
            this.A0C = bundle.getString(callerType2);
        } else {
            String stringExtra = this.A05.getStringExtra(callerType2);
            if (A0M[7].length() != 21) {
                A0M[5] = "dMohbzPZPFL3lBhphwrH1b8arfl2r2Ch";
                this.A0C = stringExtra;
            } else {
                A0M[0] = "3wH6tZS0sHFmmn7H8QunQNd9ha";
                this.A0C = stringExtra;
            }
        }
        this.A0I.A06();
        if (A0M[7].length() != 21) {
            throw new RuntimeException();
        }
        A0M[1] = "aldkJ30NOVt6q0NKQGcnTd28ZfXNLwwL";
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onDestroy() {
        this.A0J.A0F().A3F(String.valueOf(A05().hashCode()), A00());
        this.A0G.A04(this.A07, this.A0B);
        if (this.A06 != null) {
            this.A06.removeAllViews();
        }
        if (this.A08 != null) {
            this.A08.onDestroy();
            this.A08 = null;
        }
        this.A0I.A05();
        AbstractC1492Zd abstractC1492Zd = this.A09;
        if (A0M[7].length() != 21) {
            throw new RuntimeException();
        }
        A0M[6] = "yBcEH8sYDqTUUkxjXqOG2DCn3q2DEyX3";
        if (abstractC1492Zd != null) {
            this.A09.A0M();
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onPause() {
        this.A0J.A0F().A3G(String.valueOf(A05().hashCode()), A00());
        this.A03 += System.currentTimeMillis() - this.A04;
        if (this.A08 != null) {
            this.A08.AFA(false);
            if (!this.A0E.isFinishing()) {
                VI.A02(VH.A0E, null, this.A08.getCurrentClientToken(), this.A0J.A0A());
                this.A0D = true;
            }
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onResume() {
        this.A0J.A0F().A3H(String.valueOf(A05().hashCode()), A00());
        this.A04 = System.currentTimeMillis();
        if (this.A08 != null) {
            InterfaceC1471Yi interfaceC1471Yi = this.A08;
            if (A0M[5].charAt(17) != 'w') {
                throw new RuntimeException();
            }
            A0M[6] = "WHwDulcP2dZca7YA0PmotSPySBaz7ZXD";
            interfaceC1471Yi.AFi(false);
            if (this.A0D) {
                VI.A02(VH.A0F, null, this.A08.getCurrentClientToken(), this.A0J.A0A());
            }
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (this.A08 != null) {
            this.A08.AIv(bundle2);
        }
        bundle2.putInt(A01(165, 24, 85), this.A01);
        bundle2.putString(A01(Sdk.SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE, 8, 39), this.A0B);
        bundle2.putString(A01(79, 11, 56), this.A0C);
        bundle2.putSerializable(A01(227, 8, 90), this.A07);
        C1433Wu.A0A(bundle, bundle2);
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onStart() {
        this.A0J.A0F().A3I(String.valueOf(A05().hashCode()), A00());
        if (this.A01 != -1) {
            YX.A02(this.A0E, this.A01, this.A0J);
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final void onStop() {
        this.A0J.A0F().A3J(String.valueOf(A05().hashCode()), A00());
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.A0F.onTouchEvent(motionEvent);
    }

    @Override // com.facebook.ads.internal.context.Repairable
    public final void repair(Throwable th) {
        A09();
        finish(5);
    }
}
