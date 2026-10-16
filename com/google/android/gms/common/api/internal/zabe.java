package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes4.dex */
abstract class zabe {
    private final zabd zaa;

    protected zabe(zabd zabdVar) {
        this.zaa = zabdVar;
    }

    protected abstract void zaa();

    public final void zab(zabg zabgVar) {
        Lock lock;
        Lock lock2;
        zabd zabdVar;
        lock = zabgVar.zai;
        lock.lock();
        try {
            zabdVar = zabgVar.zan;
            if (zabdVar == this.zaa) {
                zaa();
            }
        } finally {
            lock2 = zabgVar.zai;
            lock2.unlock();
        }
    }
}
