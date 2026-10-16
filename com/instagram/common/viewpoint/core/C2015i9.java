package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.i9, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2015i9 implements InterfaceC1233Ou {
    private C1234Ov A00(InterfaceC1232Ot interfaceC1232Ot) {
        return (C1234Ov) interfaceC1232Ot.A7E();
    }

    public final void A01(InterfaceC1232Ot interfaceC1232Ot) {
        if (!interfaceC1232Ot.A9R()) {
            interfaceC1232Ot.AJl(0, 0, 0, 0);
            return;
        }
        float A8S = A8S(interfaceC1232Ot);
        float A8r = A8r(interfaceC1232Ot);
        float elevation = AbstractC1236Ox.A00(A8S, A8r, interfaceC1232Ot.A8q());
        int vPadding = (int) Math.ceil(elevation);
        float elevation2 = AbstractC1236Ox.A01(A8S, A8r, interfaceC1232Ot.A8q());
        int ceil = (int) Math.ceil(elevation2);
        interfaceC1232Ot.AJl(vPadding, ceil, vPadding, ceil);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1233Ou
    public final ColorStateList A71(InterfaceC1232Ot interfaceC1232Ot) {
        return A00(interfaceC1232Ot).A05();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1233Ou
    public final float A7v(InterfaceC1232Ot interfaceC1232Ot) {
        return interfaceC1232Ot.A7F().getElevation();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1233Ou
    public final float A8S(InterfaceC1232Ot interfaceC1232Ot) {
        return A00(interfaceC1232Ot).A03();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1233Ou
    public final float A8X(InterfaceC1232Ot interfaceC1232Ot) {
        return A8r(interfaceC1232Ot) * 2.0f;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1233Ou
    public final float A8Y(InterfaceC1232Ot interfaceC1232Ot) {
        return A8r(interfaceC1232Ot) * 2.0f;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1233Ou
    public final float A8r(InterfaceC1232Ot interfaceC1232Ot) {
        return A00(interfaceC1232Ot).A04();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1233Ou
    public final void AAE() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1233Ou
    public final void AAG(InterfaceC1232Ot interfaceC1232Ot, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        C1234Ov background = new C1234Ov(colorStateList, f);
        interfaceC1232Ot.AJK(background);
        View view = interfaceC1232Ot.A7F();
        view.setClipToOutline(true);
        view.setElevation(f2);
        AJX(interfaceC1232Ot, f3);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1233Ou
    public final void ADP(InterfaceC1232Ot interfaceC1232Ot) {
        AJX(interfaceC1232Ot, A8S(interfaceC1232Ot));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1233Ou
    public final void AFT(InterfaceC1232Ot interfaceC1232Ot) {
        AJX(interfaceC1232Ot, A8S(interfaceC1232Ot));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1233Ou
    public final void AJJ(InterfaceC1232Ot interfaceC1232Ot, ColorStateList colorStateList) {
        A00(interfaceC1232Ot).A08(colorStateList);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1233Ou
    public final void AJP(InterfaceC1232Ot interfaceC1232Ot, float f) {
        interfaceC1232Ot.A7F().setElevation(f);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1233Ou
    public final void AJX(InterfaceC1232Ot interfaceC1232Ot, float f) {
        A00(interfaceC1232Ot).A07(f, interfaceC1232Ot.A9R(), interfaceC1232Ot.A8q());
        A01(interfaceC1232Ot);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1233Ou
    public final void AJj(InterfaceC1232Ot interfaceC1232Ot, float f) {
        A00(interfaceC1232Ot).A06(f);
    }
}
