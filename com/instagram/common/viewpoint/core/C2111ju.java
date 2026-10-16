package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.io.encoding.Base64;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.ju, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2111ju implements InterfaceC1184Mw, N1 {
    public static byte[] A0C;
    public static String[] A0D = {"axrzCdv0FVVdCRJ2G5bzsKW6gzdnjkd", "bTiRlDodVRVUvI5asAv5OrmPjdR2kQoL", "0F0kzsbgf", "9OhtkIX5JTQzZAf31yyS0L6RFdCICf7G", "a5UohLNEI7iVSyxaj4LiJgBVL6R7sy1L", "7foeJoxu0TAivWs2uWCvQbVxkZa0ERHH", "EHJaWrfXkxbvFmDXjSXoaOL8kiGJisUm", "EwwWMCMqNj"};
    public static final String A0E;
    public int A00;
    public C2099ji A01;
    public NG A02;
    public NH A03;
    public InterfaceC1390Va A04;
    public List<UK> A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public final C1929gi A0A;
    public final String A0B;

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 27);
            if (A0D[0].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[4] = "ypXQoKhxcHRWJrqojmqi5sMtZ7xfThaX";
            strArr[6] = "2LOy6kLjroQDrfbojOuFHdbjLd88ORkx";
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0C = new byte[]{55, Ascii.DC2, Ascii.ETB, 6, 2, 19, 4, 86, Ascii.ETB, Ascii.SUB, 4, 19, Ascii.ETB, Ascii.DC2, Ascii.SI, 86, Ascii.SUB, Ascii.EM, Ascii.ETB, Ascii.DC2, 19, Ascii.DC2, 86, Ascii.DC2, Ascii.ETB, 2, Ascii.ETB, 2, 45, 40, 34, 42, 97, 41, 32, 49, 49, 36, 47, 36, 37, 97, 46, 47, 97, 45, 46, 34, 42, 50, 34, 51, 36, 36, 47, 97, 32, 37, 87, 120, 125, 119, Byte.MAX_VALUE, 52, 120, 123, 115, 115, 113, 112, 119, 117, 120, 120, 113, 102, SignedBytes.MAX_POWER_OF_TWO, 109, 100, 113, 46, 44, 63, 41, 46, 35, 57, 85, 87, 68, 82, 95, 88, 82, 114, 101, 58, 53, 32, Base64.padSymbol, 34, 49, Ascii.FF, 17, Ascii.RS, Ascii.SI, Ascii.FF, Ascii.ETB, Ascii.DLE, Ascii.VT, 100, Byte.MAX_VALUE, 120, 96, 100, 116, 88, 117, 33, 62, 50, 32};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A06(Map<String, String> map, Map<String, String> map2) {
        try {
            new Handler().postDelayed(new C2112jv(this, map2, A03(map)), this.A01.A09() * 1000);
        } catch (Exception unused) {
        }
    }

    static {
        A04();
        A0E = C2111ju.class.getSimpleName();
    }

    public C2111ju(C1929gi c1929gi) {
        this(c1929gi, new C2099ji());
    }

    public C2111ju(C1929gi c1929gi, C2099ji c2099ji) {
        this.A0B = UUID.randomUUID().toString();
        this.A00 = 200;
        this.A01 = c2099ji;
        this.A0A = c1929gi;
    }

    private Map<String, String> A03(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        String A02 = A02(Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 4, 76);
        if (map.containsKey(A02)) {
            hashMap.put(A02, map.get(A02));
        }
        String A022 = A02(102, 8, 100);
        if (map.containsKey(A022)) {
            hashMap.put(A022, map.get(A022));
        }
        return hashMap;
    }

    private void A05(C2099ji c2099ji) {
        if (!this.A06) {
            this.A01 = c2099ji;
            List<C2099ji> A0f = this.A01.A0f();
            if (A0f != null && A0f.size() > 0) {
                int size = A0f.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    C2111ju adapter = new C2111ju(this.A0A);
                    adapter.A05(A0f.get(i));
                    arrayList.add(new UK(this.A0A, adapter, (C1361Tx) null, this.A04));
                }
                this.A05 = arrayList;
            }
            this.A06 = true;
            this.A07 = A07();
            return;
        }
        throw new IllegalStateException(A02(0, 27, 109));
    }

    private boolean A07() {
        return (!(this.A01.A0j() || TextUtils.isEmpty(this.A01.A0Y())) || (!TextUtils.isEmpty(this.A01.A0V()) && this.A01.A0j())) && (this.A01.A0I() != null || this.A01.A0j()) && (this.A01.A0H() != null || A8k() == AdPlacementType.NATIVE_BANNER);
    }

    public final int A08() {
        return this.A01.A02();
    }

    public final int A09() {
        return this.A01.A05();
    }

    public final int A0A() {
        int A08 = this.A01.A08();
        if (A08 < 0 || A08 > 100) {
            return 0;
        }
        return A08;
    }

    public final int A0B() {
        return this.A00;
    }

    public final int A0C() {
        return this.A01.A0B();
    }

    public final int A0D() {
        return this.A01.A0C();
    }

    public final C2099ji A0E() {
        return this.A01;
    }

    public final NG A0F() {
        return this.A02;
    }

    public final String A0G() {
        return this.A01.A0b();
    }

    public final List<UK> A0H() {
        if (!A0R()) {
            return null;
        }
        return this.A05;
    }

    public final void A0I() {
        if (!this.A09) {
            String A0c = A0E().A0c();
            if (A0c != null) {
                VA A0A = this.A0A.A0A();
                String[] strArr = A0D;
                if (strArr[1].charAt(25) != strArr[3].charAt(25)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0D;
                strArr2[4] = "MHNGbcOaMZIG61BxjY7eI95TuiNlx0Gr";
                strArr2[6] = "kvjKrlZQ6RBIZv1Jj5ESJw4vFB55PB3z";
                A0A.AGz(A0c);
            }
            this.A09 = true;
        }
    }

    public final void A0J() {
        if (this.A05 != null && !this.A05.isEmpty()) {
            Iterator<UK> it = this.A05.iterator();
            while (it.hasNext()) {
                it.next().unregisterView();
            }
        }
    }

    public final void A0K(NG ng) {
        this.A02 = ng;
    }

    public final void A0L(C1929gi c1929gi, NG ng, VA va, O8 o8, InterfaceC1390Va interfaceC1390Va) {
        int i;
        this.A02 = ng;
        this.A04 = interfaceC1390Va;
        JSONObject A03 = o8.A03();
        C1361Tx A01 = o8.A01();
        if (A01 != null) {
            i = A01.A06();
        } else {
            i = 200;
        }
        this.A00 = i;
        A05(NI.A00(c1929gi, A03, AbstractC1440Xd.A02(A03, A02(94, 2, 10))));
        if (AbstractC1185Mx.A06(c1929gi, this, va)) {
            c1929gi.A0F().A52();
            ng.AEz(this, C1401Vm.A00(AdErrorType.NO_FILL));
        } else {
            if (ng != null) {
                ng.AEw(this);
            }
            this.A03 = new NH(c1929gi, this.A0B, this, ng);
            this.A03.A02();
        }
    }

    public final void A0M(Map<String, String> extraData) {
        C1193Ng c1193Ng;
        if (!A0R()) {
            return;
        }
        boolean shouldBlockLockscreenClicks = C1379Up.A26(this.A0A);
        if (shouldBlockLockscreenClicks) {
            boolean shouldBlockLockscreenClicks2 = YC.A03(extraData);
            if (shouldBlockLockscreenClicks2) {
                Log.e(A0E, A02(27, 31, 90));
                return;
            }
        }
        HashMap hashMap = new HashMap();
        if (extraData != null) {
            hashMap.putAll(extraData);
        }
        boolean shouldBlockLockscreenClicks3 = this.A01.A0j();
        if (shouldBlockLockscreenClicks3) {
            hashMap.put(A02(87, 7, 45), String.valueOf(A0E().A04()));
            hashMap.put(A02(80, 7, 86), String.valueOf(A0E().A03()));
        }
        hashMap.put(A02(70, 10, 15), AdPlacementType.NATIVE.name());
        hashMap.put(A02(110, 8, 10), this.A0B);
        C1929gi c1929gi = this.A0A;
        VA A0A = this.A0A.A0A();
        String A7O = this.A01.A7O();
        Uri A0E2 = this.A01.A0E();
        if (this.A01.A0F() != null) {
            c1193Ng = this.A01.A0F().A2A();
        } else {
            c1193Ng = null;
        }
        AbstractC1181Mt A00 = C1182Mu.A00(c1929gi, A0A, A7O, A0E2, hashMap, c1193Ng);
        EnumC1178Mq enumC1178Mq = EnumC1178Mq.A09;
        if (A00 != null) {
            enumC1178Mq = A00.A0G(null);
        }
        if (enumC1178Mq != EnumC1178Mq.A06) {
            XI.A04(this.A0A, A02(58, 12, 15));
            if (this.A02 != null) {
                this.A02.AEv(this);
            }
        }
    }

    public final void A0N(Map<String, String> extraData) {
        this.A0A.A0A().AB6(this.A01.A7O(), extraData);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0103, code lost:
    
        if (r4 != false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A0O(Map<String, String> map) {
        if (A0R() && !this.A08) {
            if (this.A02 != null) {
                NG ng = this.A02;
                if (A0D[7].length() == 10) {
                    A0D[2] = "N1HzTzVNk";
                    ng.AEx(this);
                }
                throw new RuntimeException();
            }
            HashMap hashMap = new HashMap();
            if (map != null) {
                hashMap.putAll(map);
            }
            if (this.A01.A0j()) {
                hashMap.put(A02(87, 7, 45), String.valueOf(A0E().A04()));
                hashMap.put(A02(80, 7, 86), String.valueOf(A0E().A03()));
            }
            if (!TextUtils.isEmpty(A7O())) {
                if (!this.A01.A0j()) {
                    this.A0A.A0F().A3L();
                    String A0a = this.A01.A0a();
                    String[] strArr = A0D;
                    if (strArr[1].charAt(25) == strArr[3].charAt(25)) {
                        String[] strArr2 = A0D;
                        strArr2[1] = "Q8Us8dZOubCsANiQB8YQBmsKLdjgWIPJ";
                        strArr2[3] = "Pg8pQUM49Vm5a0t7ebabBeivyd2Kgjff";
                        AbstractC1213Oa.A02(A0a, AbstractC1449Xm.A00(A02(96, 6, 79)));
                    }
                    throw new RuntimeException();
                }
                this.A0A.A0A().ABJ(A7O(), hashMap);
                C1425Wl.A00(this.A0A).A0E(AdPlacementType.NATIVE.toString(), A7O());
            }
            if (!A0T()) {
                boolean A0U = A0U();
                if (A0D[2].length() == 9) {
                    A0D[2] = "BGAjHSzJz";
                }
                throw new RuntimeException();
            }
            A06(map, hashMap);
            this.A08 = true;
        }
    }

    public final boolean A0P() {
        return true;
    }

    public final boolean A0Q() {
        return A0R() && this.A01.A0E() != null;
    }

    public final boolean A0R() {
        return this.A06 && this.A07;
    }

    public final boolean A0S() {
        return this.A01.A0i();
    }

    public final boolean A0T() {
        return C1379Up.A1b(this.A0A) && A0R() && this.A01.A0k();
    }

    public final boolean A0U() {
        return C1379Up.A1b(this.A0A) && A0R() && this.A01.A0l();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1184Mw
    public final String A7O() {
        return this.A01.A7O();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1184Mw
    public final Collection<String> A7p() {
        return A0E().A7p();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1184Mw
    public final EnumC1183Mv A8K() {
        return A0E().A8K();
    }

    public AdPlacementType A8k() {
        return AdPlacementType.NATIVE;
    }

    @Override // com.instagram.common.viewpoint.core.N1
    public final boolean AKL() {
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.N1
    public final void onDestroy() {
        if (this.A03 != null) {
            NH nh = this.A03;
            String[] strArr = A0D;
            if (strArr[4].charAt(16) != strArr[6].charAt(16)) {
                throw new RuntimeException();
            }
            A0D[7] = "xLZjaQWgus";
            nh.A03();
        }
    }
}
