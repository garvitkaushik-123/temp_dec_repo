package com.bytedance.adsdk.ugeno.kb;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class FC extends Handler {
    private final WeakReference<eli> eli;

    public interface eli {
        void eli(Message message);
    }

    public FC(Looper looper, eli eliVar) {
        super(looper);
        this.eli = new WeakReference<>(eliVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        eli eliVar = this.eli.get();
        if (eliVar == null || message == null) {
            return;
        }
        eliVar.eli(message);
    }
}
