package com.bytedance.sdk.openadsdk.component.MGA;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes3.dex */
public class DbA implements Handler.Callback {
    private final com.bytedance.sdk.openadsdk.component.wC.eli DbA;
    private eli Os;
    private long aAs;
    private long du;
    private boolean kb;
    private boolean nlS;
    private Handler eli = new Handler(Looper.myLooper(), this);
    private int aGH = 0;
    private int ui = 5;
    private int MGA = 0;
    private final int wC = 1000;
    private int FC = 1000;

    public DbA(com.bytedance.sdk.openadsdk.component.wC.eli eliVar) {
        this.DbA = eliVar;
    }

    public void eli(int i) {
        this.aGH = i;
        int i2 = this.ui - i;
        this.DbA.DbA(i2);
        boolean z = true;
        if (i <= 0) {
            eli eliVar = this.Os;
            if (eliVar != null && !this.kb) {
                eliVar.DbA();
                this.kb = true;
            }
            i = 0;
        }
        eli eliVar2 = this.Os;
        if (eliVar2 != null) {
            int i3 = this.MGA;
            int i4 = i3 - i2;
            if (i != 0 && i2 < i3) {
                z = false;
            }
            eliVar2.eli(i4, z);
        }
    }

    public void eli(float f) {
        int i = (int) f;
        this.ui = i;
        if (i <= 0) {
            this.ui = 5;
        }
    }

    public void eli(eli eliVar) {
        this.Os = eliVar;
    }

    public int eli() {
        return this.MGA;
    }

    public void DbA(int i) {
        this.MGA = Math.min(i, this.ui);
    }

    public void DbA() {
        Handler handler = this.eli;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(100, this.ui, 0));
        }
    }

    public void Os() {
        if (this.eli != null) {
            Message obtain = Message.obtain();
            obtain.what = 100;
            obtain.arg1 = this.aGH;
            this.eli.sendMessage(obtain);
        }
    }

    public void aGH() {
        Handler handler = this.eli;
        if (handler != null) {
            handler.removeMessages(100);
        }
    }

    public void ui() {
        this.eli.removeCallbacksAndMessages(null);
        this.eli = null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 100 && this.eli != null) {
            int i = message.arg1;
            eli(i);
            if (i > 0) {
                Message obtain = Message.obtain();
                obtain.what = 100;
                obtain.arg1 = i - 1;
                this.eli.sendMessageDelayed(obtain, this.FC);
            }
        }
        return true;
    }

    public void eli(int i, float f, boolean z) {
        com.bytedance.sdk.openadsdk.component.wC.eli eliVar;
        if ((i == 1 || i == 2) && this.nlS != z) {
            this.nlS = z;
            if (i == 1 && (eliVar = this.DbA) != null) {
                eliVar.eli(z);
            }
            if (z) {
                try {
                    this.FC = (int) (1000.0f / f);
                    this.du = System.currentTimeMillis();
                    return;
                } catch (Throwable unused) {
                }
            } else {
                long currentTimeMillis = this.aAs + (System.currentTimeMillis() - this.du);
                this.aAs = currentTimeMillis;
                com.bytedance.sdk.openadsdk.component.wC.eli eliVar2 = this.DbA;
                if (eliVar2 != null) {
                    eliVar2.eli(currentTimeMillis);
                }
            }
            this.FC = 1000;
        }
    }
}
