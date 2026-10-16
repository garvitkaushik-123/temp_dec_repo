package com.instagram.common.viewpoint.core;

import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: assets/audience_network/classes2.dex */
public class U9 implements Callable<Boolean> {
    public final /* synthetic */ C1426Wn A00;
    public final /* synthetic */ String A01;

    public U9(C1426Wn c1426Wn, String str) {
        this.A00 = c1426Wn;
        this.A01 = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final Boolean call() throws Exception {
        Map map;
        Map map2;
        this.A00.A05();
        map = UB.A04;
        synchronized (map) {
            map2 = UB.A04;
            map2.put(this.A01, 2);
        }
        return true;
    }
}
