package com.fyber.inneractive.sdk.util;

import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes4.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue f1761a = new ConcurrentLinkedQueue();
    public final i b;

    public j(int i, i iVar) {
        for (int i2 = 0; i2 < i; i2++) {
            this.f1761a.offer(iVar.a());
        }
        this.b = iVar;
    }
}
