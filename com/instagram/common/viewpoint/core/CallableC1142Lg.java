package com.instagram.common.viewpoint.core;

import java.io.File;
import java.util.concurrent.Callable;

/* renamed from: com.facebook.ads.redexgen.X.Lg, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class CallableC1142Lg implements Callable<Void> {
    public final File A00;
    public final /* synthetic */ AbstractC2168kr A01;

    public CallableC1142Lg(AbstractC2168kr abstractC2168kr, File file) {
        this.A01 = abstractC2168kr;
        this.A00 = file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final Void call() throws Exception {
        this.A01.A06(this.A00);
        return null;
    }
}
