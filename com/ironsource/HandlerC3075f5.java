package com.ironsource;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.Logger;

/* renamed from: com.ironsource.f5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class HandlerC3075f5 extends Handler {
    private static final String b = "DownloadHandler";

    /* renamed from: a, reason: collision with root package name */
    InterfaceC3386xc f3294a;

    public HandlerC3075f5(Looper looper) {
        super(looper);
    }

    public void a(InterfaceC3386xc interfaceC3386xc) {
        if (interfaceC3386xc == null) {
            throw new IllegalArgumentException();
        }
        this.f3294a = interfaceC3386xc;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        InterfaceC3386xc interfaceC3386xc = this.f3294a;
        if (interfaceC3386xc == null) {
            Logger.i(b, "OnPreCacheCompletion listener is null, msg: " + message.toString());
            return;
        }
        try {
            int i = message.what;
            if (i == 1016) {
                interfaceC3386xc.a((C3382x8) message.obj);
            } else {
                this.f3294a.a((C3382x8) message.obj, new C3247p8(i, Tf.a(i)));
            }
        } catch (Throwable th) {
            C3260q4.d().a(th);
            Logger.i(b, "handleMessage | Got exception: " + th.getMessage());
            IronLog.INTERNAL.error(th.toString());
        }
    }

    public void a() {
        this.f3294a = null;
    }
}
