package com.fyber.inneractive.sdk.player.exoplayer2.util;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes4.dex */
public final class y implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1598a;

    public y(String str) {
        this.f1598a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f1598a);
    }
}
