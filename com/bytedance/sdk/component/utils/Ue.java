package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class Ue extends Handler {
    protected WeakReference<eli> eli;

    public interface eli {
        void eli(Message message);
    }

    public Ue(eli eliVar) {
        if (eliVar != null) {
            this.eli = new WeakReference<>(eliVar);
        }
    }

    public Ue(Looper looper, eli eliVar) {
        super(looper);
        if (eliVar != null) {
            this.eli = new WeakReference<>(eliVar);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        eli eliVar;
        WeakReference<eli> weakReference = this.eli;
        if (weakReference == null || (eliVar = weakReference.get()) == null || message == null) {
            return;
        }
        eliVar.eli(message);
    }
}
