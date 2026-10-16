package com.bytedance.sdk.component.ui.aGH.Os;

import com.bytedance.sdk.component.ui.QX;
import com.bytedance.sdk.component.ui.aqO;
import com.bytedance.sdk.component.ui.du;
import com.ironsource.C3040d4;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class eli<T> {
    private QX DbA;
    private Os eli;

    public eli(Os os, QX qx) {
        this.eli = os;
        this.DbA = qx;
    }

    public void eli(du<T> duVar) {
        try {
            QX qx = this.DbA;
            if (qx != null) {
                qx.eli("success", this.eli);
            }
            String Xb = this.eli.Xb();
            Map<String, List<Os>> FC = this.eli.dV().FC();
            List<Os> list = FC.get(Xb);
            if (list == null) {
                aqO wC = this.eli.wC();
                if (wC != null) {
                    new StringBuilder("not repeat request listener is ").append(wC);
                    this.eli.aAs();
                    wC.eli(duVar);
                }
            } else {
                synchronized (list) {
                    list.size();
                    for (Os os : list) {
                        aqO wC2 = os.wC();
                        if (wC2 != null) {
                            new StringBuilder("repeat request listener is ").append(wC2).append(" key is ");
                            os.aAs();
                            wC2.eli(duVar);
                        }
                    }
                    list.clear();
                    FC.remove(Xb);
                }
            }
            QX qx2 = this.DbA;
            if (qx2 != null) {
                qx2.DbA("success", this.eli);
            }
        } catch (Throwable unused) {
        }
    }

    public void eli(int i, String str, Throwable th) {
        try {
            QX qx = this.DbA;
            if (qx != null) {
                qx.eli(C3040d4.h.t, this.eli);
            }
            String Xb = this.eli.Xb();
            Map<String, List<Os>> FC = this.eli.dV().FC();
            List<Os> list = FC.get(Xb);
            if (list == null) {
                aqO wC = this.eli.wC();
                if (wC != null) {
                    wC.eli(i, str, th);
                }
            } else {
                synchronized (list) {
                    Iterator<Os> it = list.iterator();
                    while (it.hasNext()) {
                        aqO wC2 = it.next().wC();
                        if (wC2 != null) {
                            new StringBuilder("repeat request listener is ").append(wC2);
                            wC2.eli(i, str, th);
                        }
                    }
                    list.clear();
                    FC.remove(Xb);
                }
            }
            QX qx2 = this.DbA;
            if (qx2 != null) {
                qx2.DbA(C3040d4.h.t, this.eli);
            }
        } catch (Throwable unused) {
        }
    }
}
