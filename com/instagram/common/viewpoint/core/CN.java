package com.instagram.common.viewpoint.core;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: assets/audience_network/classes2.dex */
public class CN implements InterfaceC1881fw {
    public final /* synthetic */ C2U A00;
    public final /* synthetic */ CountDownLatch A01;
    public final /* synthetic */ AtomicReference A02;
    public final /* synthetic */ AtomicReference A03;

    public CN(C2U c2u, AtomicReference atomicReference, AtomicReference atomicReference2, CountDownLatch countDownLatch) {
        this.A00 = c2u;
        this.A03 = atomicReference;
        this.A02 = atomicReference2;
        this.A01 = countDownLatch;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1881fw
    public final void ADR(InterfaceC1879fu interfaceC1879fu) {
        C2U.A06(interfaceC1879fu.A73(), this.A03, this.A02);
        this.A01.countDown();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1881fw
    public final void ADq(Exception exc) {
        this.A02.set(exc);
        this.A01.countDown();
    }
}
