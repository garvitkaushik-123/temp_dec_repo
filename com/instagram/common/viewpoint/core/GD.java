package com.instagram.common.viewpoint.core;

import android.content.Intent;
import android.os.Bundle;

/* loaded from: assets/audience_network/classes2.dex */
public class GD implements InterfaceC1760dy {
    public final /* synthetic */ GB A00;

    public GD(GB gb) {
        this.A00 = gb;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1760dy
    public final void AIY() {
        boolean z;
        C1201No c1201No;
        InterfaceC1470Yh interfaceC1470Yh;
        ZU zu;
        InterfaceC1470Yh interfaceC1470Yh2;
        ZU zu2;
        ZU zu3;
        C1201No c1201No2;
        AbstractC2094jd abstractC2094jd;
        InterfaceC1471Yi A05;
        Intent intent;
        InterfaceC1471Yi interfaceC1471Yi;
        Intent intent2;
        Bundle bundle;
        InterfaceC1471Yi interfaceC1471Yi2;
        this.A00.A0B();
        z = this.A00.A0E;
        if (!z || this.A00.A01 == null) {
            c1201No = this.A00.A07;
            if (c1201No == null) {
                interfaceC1470Yh = this.A00.A0C;
                zu = this.A00.A0D;
                interfaceC1470Yh.A4j(zu.A81());
                interfaceC1470Yh2 = this.A00.A0C;
                zu2 = this.A00.A0D;
                interfaceC1470Yh2.A4j(zu2.A7w());
                return;
            }
            GB gb = this.A00;
            GB gb2 = this.A00;
            zu3 = this.A00.A0D;
            c1201No2 = this.A00.A07;
            abstractC2094jd = this.A00.A05;
            A05 = gb2.A05(zu3, c1201No2, Boolean.valueOf(abstractC2094jd.A1n()));
            gb.A04 = A05;
            intent = this.A00.A02;
            if (intent != null && this.A00.A00 != null) {
                interfaceC1471Yi = this.A00.A04;
                intent2 = this.A00.A02;
                bundle = this.A00.A03;
                interfaceC1471Yi.AAu(intent2, bundle, this.A00.A00);
                return;
            }
            return;
        }
        if (this.A00.A01 instanceof MW) {
            this.A00.A04 = this.A00.A01;
            interfaceC1471Yi2 = this.A00.A04;
            ((MW) interfaceC1471Yi2).A0b();
        }
    }
}
