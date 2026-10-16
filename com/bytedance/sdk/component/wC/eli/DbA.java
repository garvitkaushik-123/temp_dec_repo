package com.bytedance.sdk.component.wC.eli;

import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.Ue;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class DbA extends Ue implements Os {
    private final HandlerThread DbA;

    DbA(HandlerThread handlerThread, Ue.eli eliVar) {
        super(handlerThread.getLooper(), eliVar);
        this.DbA = handlerThread;
    }

    @Override // com.bytedance.sdk.component.wC.eli.Os
    public void eli() {
        removeCallbacksAndMessages(null);
        if (this.eli != null) {
            this.eli.clear();
            this.eli = null;
        }
    }

    public void eli(Ue.eli eliVar) {
        this.eli = new WeakReference<>(eliVar);
    }

    public void DbA() {
        HandlerThread handlerThread = this.DbA;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }
}
