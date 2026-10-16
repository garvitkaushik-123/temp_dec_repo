package com.instagram.common.viewpoint.core;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.facebook.ads.redexgen.X.es, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1815es extends ContentObserver {
    public final EF A00;

    public C1815es(Handler handler, EF ef) {
        super(handler);
        this.A00 = ef;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return false;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.A00.A0f();
    }
}
