package com.instagram.common.viewpoint.core;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.RewardData;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.bi, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1621bi extends FrameLayout {
    public static String[] A08 = {"Q8PK8a4jCXFMgXydViX", "2t", "0mtDJDWqZSrfiocTEOLDLA", "JwyFxt7bdt7eCUIm0ln", "fPboxvDBMmOISakSS", "MBnzPw5d2FxZEvBrnzM1TlMBrMh4WSuO", "jLpHRmCuYtO7UfmYbZzhe3ed5a74x24O", "3APcS373YHqcuLzV9G"};
    public AbstractC1464Yb A00;
    public Z3 A01;
    public final AbstractC2094jd A02;
    public final C1929gi A03;
    public final InterfaceC1470Yh A04;
    public final InterfaceC1620bh A05;
    public final C0966Ek A06;
    public final List<View> A07;

    public C1621bi(C1646c7 c1646c7, AbstractC2094jd abstractC2094jd, C0966Ek c0966Ek, DZ dz, AbstractC1592bF abstractC1592bF, InterfaceC1470Yh interfaceC1470Yh, InterfaceC1620bh interfaceC1620bh) {
        this(c1646c7, abstractC2094jd, c0966Ek, interfaceC1470Yh, interfaceC1620bh, dz, abstractC1592bF);
    }

    public C1621bi(C1646c7 c1646c7, AbstractC2094jd abstractC2094jd, C0966Ek c0966Ek, InterfaceC1470Yh interfaceC1470Yh, InterfaceC1620bh interfaceC1620bh, View... viewArr) {
        this(c1646c7.A06(), c1646c7.A0B(), abstractC2094jd, c0966Ek, interfaceC1470Yh, interfaceC1620bh, viewArr);
    }

    public C1621bi(C1929gi c1929gi, AbstractC1464Yb abstractC1464Yb, AbstractC2094jd abstractC2094jd, C0966Ek c0966Ek, InterfaceC1470Yh interfaceC1470Yh, InterfaceC1620bh interfaceC1620bh, View... viewArr) {
        super(c1929gi);
        this.A07 = new ArrayList();
        this.A03 = c1929gi;
        this.A00 = abstractC1464Yb;
        this.A02 = abstractC2094jd;
        for (View view : viewArr) {
            if (view != null) {
                this.A07.add(view);
            }
        }
        this.A04 = interfaceC1470Yh;
        this.A06 = c0966Ek;
        this.A05 = interfaceC1620bh;
        A04();
    }

    private void A04() {
        String A06;
        RewardData A0s = this.A02.A0s();
        if (A0s == null) {
            A06 = this.A02.A2B().A05();
        } else {
            A06 = this.A02.A2B().A06(A0s.getCurrency(), A0s.getQuantity());
        }
        this.A01 = new Z3(this.A03, -1, -16777216, A06, null, this.A02.A2B().A04(), this.A02.A2B().A03(), YN.A01(YM.REWARD_ICON));
        this.A01.A02.setOnClickListener(new ViewOnClickListenerC1618bf(this));
        this.A01.A01.setOnClickListener(new ViewOnClickListenerC1619bg(this));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.A01, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05() {
        if (this.A06 != null) {
            this.A06.A0d(EnumC1808el.A07);
        }
        this.A05.ACt();
        if (!this.A02.A29().A0V()) {
            this.A02.A2H(this.A04);
        }
    }

    public final void A07(ViewGroup viewGroup) {
        if (this.A06 != null && !this.A06.A0o()) {
            C0966Ek c0966Ek = this.A06;
            String[] strArr = A08;
            if (strArr[0].length() == strArr[3].length()) {
                String[] strArr2 = A08;
                strArr2[4] = "1Ran1dt8ESvXQPCOL";
                strArr2[1] = BidResponsed.KEY_WN;
                c0966Ek.A0j(false, false, 11);
                YB.A0O(this.A06, 4);
            }
            throw new RuntimeException();
        }
        if (this.A00 != null) {
            YB.A0H(this.A00);
        }
        Iterator<View> it = this.A07.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            String[] strArr3 = A08;
            if (strArr3[5].charAt(31) != strArr3[6].charAt(31)) {
                break;
            }
            String[] strArr4 = A08;
            strArr4[0] = "6LHnkwVNW3v3BurcJpp";
            strArr4[3] = "pBsoAnuzgJgS4JAM4BB";
            if (hasNext) {
                View next = it.next();
                next.clearAnimation();
                YB.A0O(next, 4);
            } else {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                viewGroup.addView(this, layoutParams);
                this.A05.AEn();
                return;
            }
        }
        throw new RuntimeException();
    }
}
