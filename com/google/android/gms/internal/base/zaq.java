package com.google.android.gms.internal.base;

import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes5.dex */
public class zaq extends Handler {
    private final Looper zaa;

    public zaq() {
        this.zaa = Looper.getMainLooper();
    }

    public zaq(Looper looper) {
        super(looper);
        this.zaa = Looper.getMainLooper();
    }

    public zaq(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.zaa = Looper.getMainLooper();
    }
}
