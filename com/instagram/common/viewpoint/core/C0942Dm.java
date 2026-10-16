package com.instagram.common.viewpoint.core;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Dm, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C0942Dm implements InterfaceC1817eu {
    public static String[] A0E = {"2ZSu0wXuDbQnaud22BC", "QCmSLF", "fQxhtf", "E3sU0uCnWEnB3ZcSzOkvj4xNFgaNSXPe", "Ye0yKWwaCEsRuR61siA7kBVWrkv2bkox", "1q930HE08Ni0sTckStF", "wfAs2pJjw0biCEJKLi3nGPcNksloIp8Y", "ZBBhRoR6L"};
    public C0966Ek A01;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public final E4 A09 = new E4() { // from class: com.facebook.ads.redexgen.X.42
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.instagram.common.viewpoint.core.UN
        /* renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(C4B c4b) {
            Handler handler;
            boolean A0G;
            handler = C0942Dm.this.A07;
            handler.removeCallbacksAndMessages(null);
            A0G = C0942Dm.this.A0G(EnumC1842fJ.A04);
            if (A0G) {
                C0942Dm.this.A03();
                C0942Dm.this.A06(true, false);
            }
            C0942Dm.this.A05 = true;
        }
    };
    public final EA A08 = new EA() { // from class: com.facebook.ads.redexgen.X.41
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.instagram.common.viewpoint.core.UN
        /* renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(C4K c4k) {
            boolean z;
            C0942Dm.this.A02 = true;
            z = C0942Dm.this.A03;
            if (z) {
                return;
            }
            C0942Dm.this.A03();
            C0942Dm.this.A06(false, false);
            C0942Dm.this.A05 = true;
        }
    };
    public final E2 A0A = new C07123x(this);
    public final AbstractC0955Dz A0B = new AbstractC0955Dz() { // from class: com.facebook.ads.redexgen.X.3w
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.instagram.common.viewpoint.core.UN
        /* renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(C4A c4a) {
            boolean z;
            boolean A0G;
            z = C0942Dm.this.A04;
            if (z) {
                return;
            }
            A0G = C0942Dm.this.A0G(EnumC1842fJ.A04);
            if (!A0G) {
                return;
            }
            C0942Dm.this.A03();
            C0942Dm.this.A06(true, false);
        }
    };
    public final AbstractC0949Dt A0C = new C07103v(this);
    public final Handler A07 = new Handler();
    public final List<InterfaceC1843fK> A0D = new ArrayList();
    public int A00 = 2000;
    public boolean A02 = false;

    public C0942Dm(boolean z, boolean z2) {
        this.A04 = z;
        this.A03 = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03() {
        this.A07.removeCallbacksAndMessages(null);
        Iterator<InterfaceC1843fK> it = this.A0D.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            if (A0E[7].length() != 9) {
                throw new RuntimeException();
            }
            String[] strArr = A0E;
            strArr[6] = "Y40dGjVL9Zscw9FMyiKWKh6z3JvZ0T5u";
            strArr[4] = "hO4VpYUkDoigTR3nwiJ8PFOPPoG0N1QG";
            if (hasNext) {
                it.next().cancel();
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06(boolean z, boolean z2) {
        Iterator<InterfaceC1843fK> it = this.A0D.iterator();
        while (it.hasNext()) {
            it.next().A4A(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0G(EnumC1842fJ enumC1842fJ) {
        Iterator<InterfaceC1843fK> it = this.A0D.iterator();
        while (it.hasNext()) {
            if (it.next().A9B() != enumC1842fJ) {
                return false;
            }
        }
        return true;
    }

    public final void A0H() {
        this.A0D.clear();
    }

    public final void A0I() {
        if (this.A04) {
            this.A07.removeCallbacksAndMessages(null);
            this.A04 = false;
        }
    }

    public final void A0J() {
        this.A06 = true;
        this.A05 = true;
        A06(false, false);
    }

    public final void A0K(int i) {
        this.A00 = i;
    }

    public final void A0L(InterfaceC1843fK interfaceC1843fK) {
        this.A0D.add(interfaceC1843fK);
    }

    public final boolean A0M() {
        return this.A04;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1817eu
    public final void AAv(C0966Ek c0966Ek) {
        this.A01 = c0966Ek;
        c0966Ek.getEventBus().A03(this.A09, this.A0C, this.A0A, this.A0B, this.A08);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1817eu
    public final void AKV(C0966Ek c0966Ek) {
        A03();
        c0966Ek.getEventBus().A04(this.A08, this.A0C, this.A0A, this.A0B, this.A09);
        this.A01 = null;
    }
}
