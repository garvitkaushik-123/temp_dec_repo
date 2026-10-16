package com.ironsource;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public class W5 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, InterfaceC3386xc> f3106a;

    public W5(Looper looper) {
        super(looper);
        this.f3106a = new ConcurrentHashMap<>();
    }

    private boolean a(int i) {
        return i == 1016 || i == 1015;
    }

    void a(String str, InterfaceC3386xc interfaceC3386xc) {
        if (str == null || interfaceC3386xc == null) {
            return;
        }
        this.f3106a.put(str, interfaceC3386xc);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            C3382x8 c3382x8 = (C3382x8) message.obj;
            String path = c3382x8.getPath();
            InterfaceC3386xc interfaceC3386xc = this.f3106a.get(path);
            if (interfaceC3386xc == null) {
                return;
            }
            if (a(message.what)) {
                interfaceC3386xc.a(c3382x8);
            } else {
                int i = message.what;
                interfaceC3386xc.a(c3382x8, new C3247p8(i, Tf.a(i)));
            }
            this.f3106a.remove(path);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }
}
