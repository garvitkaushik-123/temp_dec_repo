package com.bytedance.sdk.component.wC.eli;

import android.os.Handler;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.component.utils.wC;

/* loaded from: classes3.dex */
public class eli {
    private Handler DbA;
    private final aGH<DbA> eli;

    private eli() {
        this.eli = aGH.eli(2);
    }

    public static eli eli() {
        return C0153eli.eli;
    }

    /* renamed from: com.bytedance.sdk.component.wC.eli.eli$eli, reason: collision with other inner class name */
    private static class C0153eli {
        private static final eli eli = new eli();
    }

    public Handler DbA() {
        if (this.DbA == null) {
            synchronized (eli.class) {
                if (this.DbA == null) {
                    this.DbA = eli("csj_io_handler");
                }
            }
        }
        return this.DbA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(final Handler handler, final Handler handler2) {
        if (handler.getLooper().getQueue().isIdle()) {
            handler.removeCallbacksAndMessages(null);
            handler.getLooper().quit();
        } else {
            handler2.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.wC.eli.eli.1
                @Override // java.lang.Runnable
                public void run() {
                    eli.this.eli(handler, handler2);
                }
            }, 1000L);
        }
    }

    public Ue eli(Ue.eli eliVar, final String str) {
        DbA eli = this.eli.eli();
        if (eli != null) {
            eli.eli(eliVar);
            eli.post(new Runnable() { // from class: com.bytedance.sdk.component.wC.eli.eli.2
                @Override // java.lang.Runnable
                public void run() {
                    Thread.currentThread().setName(str);
                }
            });
            return eli;
        }
        return DbA(eliVar, str);
    }

    public Ue eli(String str) {
        return eli((Ue.eli) null, str);
    }

    private DbA DbA(Ue.eli eliVar, String str) {
        return new DbA(wC.eli(str), eliVar);
    }

    public boolean eli(Ue ue) {
        if (!(ue instanceof DbA)) {
            return false;
        }
        DbA dbA = (DbA) ue;
        if (this.eli.eli((aGH<DbA>) dbA)) {
            return true;
        }
        dbA.DbA();
        return true;
    }
}
