package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.80, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass80 implements InterfaceC2125k8 {
    public static byte[] A09;
    public static String[] A0A = {"0TFgGHCmbDEnT", "P3BoNX3HbYs3p91Xznd9cH02Ego1LEzw", "OWrFl7C0gkEmqIZvATANnxtRvMpHSetZ", "XjLJU23F7IQ7TgYJbWjoa78", "8eUGin29aZrVydG4hLQZ04ng176drDiv", "tE42BGb8ExLW22Y3fw0IicKZ4ID1w2IZ", "N0c3cK9W7W98ikBdYu66t8J", "EarR2SOYmotvRVJvY11PbnGgxllwGrNq"};
    public N9 A01;
    public NA A02;
    public C2101jk A03;
    public C2099ji A04;
    public AnonymousClass76 A05;
    public Z1 A06;
    public Z2 A07;
    public final String A08 = UUID.randomUUID().toString();
    public long A00 = -1;

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 16);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A09 = new byte[]{-81, -64, -11, -19, -20, -15, -3, -11, -25, -6, -19, -21, -4, -23, -10, -17, -12, -19};
    }

    static {
        A04();
    }

    private void A05(AnonymousClass76 anonymousClass76, C2099ji c2099ji, C1335Sx c1335Sx, N9 n9, Z2 z2) {
        String A7O = c2099ji.A7O();
        if (!TextUtils.isEmpty(A7O)) {
            c1335Sx.A0e(new VI(A7O, anonymousClass76.A0A()));
        }
        C1391Vb A0I = c2099ji.A0I();
        String[] strArr = A0A;
        String clientToken = strArr[3];
        if (clientToken.length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0A;
        strArr2[3] = "l0iKT0z7S0YTo68xxrsf1qJ";
        strArr2[6] = "FTb7Q8n5ne47CtPUjUxYv1n";
        if (A0I != null) {
            C1333Sv c1333Sv = new C1333Sv(c2099ji.A0I().getUrl(), c2099ji.A0I().getHeight(), c2099ji.A0I().getWidth(), c2099ji.A0b(), A03(2, 16, 120));
            c1333Sv.A01 = new T3(false, -1, -1);
            c1335Sx.A0W();
            c1335Sx.A0c(c1333Sv);
        }
        if (c2099ji.A0H() != null) {
            c1335Sx.A0c(new C1333Sv(c2099ji.A0H().getUrl(), c2099ji.A0H().getHeight(), c2099ji.A0H().getWidth(), c2099ji.A0b(), A03(2, 16, 120)));
        }
        String A0e = c2099ji.A0e();
        if (A0e != null && !TextUtils.isEmpty(A0e)) {
            c1335Sx.A0b(new C1331St(A0e, c2099ji.A0b(), A03(2, 16, 120), c2099ji.A0D()));
        }
        AbstractC2094jd A0F = c2099ji.A0F();
        String A03 = A03(2, 16, 120);
        if (A0F != null) {
            O0.A00(c2099ji.A0F(), c1335Sx, A03);
        }
        C2113jw c2113jw = new C2113jw(this, z2, n9, anonymousClass76);
        String clientToken2 = c2099ji.A0b();
        c1335Sx.A0X(c2113jw, new C1328Sq(clientToken2, A03));
    }

    @Override // com.instagram.common.viewpoint.core.N1
    public final String A7O() {
        if (this.A04 == null) {
            return null;
        }
        return this.A04.A7O();
    }

    @Override // com.instagram.common.viewpoint.core.N1
    public final AdPlacementType A8k() {
        return AdPlacementType.MEDIUM_RECTANGLE;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2125k8
    public final void AAt(AnonymousClass76 anonymousClass76, VA va, EnumC1403Vp enumC1403Vp, N9 n9, JSONObject jSONObject, C1361Tx c1361Tx) {
        anonymousClass76.A0F().A4N();
        this.A05 = anonymousClass76;
        this.A01 = n9;
        C1335Sx c1335Sx = new C1335Sx(anonymousClass76);
        this.A00 = System.currentTimeMillis();
        C2099ji A00 = NI.A00(anonymousClass76, jSONObject, AbstractC1440Xd.A02(jSONObject, A03(0, 2, 60)));
        this.A04 = A00;
        if (!AbstractC1185Mx.A06(anonymousClass76, A00, va)) {
            Z1 adViewListener = new C2115jy(this, anonymousClass76);
            this.A06 = adViewListener;
            Z2 z2 = new Z2(anonymousClass76, va, c1335Sx, new WeakReference(adViewListener), c1361Tx.A04(), c1361Tx.A07(), c1361Tx.A08(), c1361Tx.A09(), A00, this.A08);
            this.A07 = z2;
            this.A03 = new C2101jk(anonymousClass76, new C2114jx(this, anonymousClass76, n9), z2.getViewabilityChecker(), va, A00);
            A05(anonymousClass76, A00, c1335Sx, n9, z2);
            this.A02 = new NA(anonymousClass76, this.A08, this, n9);
            this.A02.A02();
            return;
        }
        anonymousClass76.A0F().A52();
        n9.AEN(this, C1401Vm.A00(AdErrorType.NO_FILL));
    }

    @Override // com.instagram.common.viewpoint.core.N1
    public final boolean AKL() {
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.N1
    public final void onDestroy() {
        if (this.A05 != null) {
            InterfaceC2156kf A0F = this.A05.A0F();
            String[] strArr = A0A;
            if (strArr[1].charAt(24) == strArr[4].charAt(24)) {
                throw new RuntimeException();
            }
            A0A[7] = "tMGyCfr9ucO4oWdztKDfdPlDfRrhkMp8";
            A0F.A4L(this.A07 != null);
        }
        if (this.A07 != null) {
            this.A07.A0I();
            this.A07 = null;
            this.A06 = null;
        }
        NA na = this.A02;
        if (A0A[0].length() == 16) {
            throw new RuntimeException();
        }
        A0A[7] = "5ZoCIskAsYlLTmabnaeKVzywNB4LbbVC";
        if (na != null) {
            this.A02.A03();
        }
    }
}
