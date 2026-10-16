package com.bytedance.sdk.openadsdk.aGH.eli;

import android.content.Context;
import com.bytedance.sdk.component.MGA.eli.eli;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.core.dV;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class aGH {
    public static AtomicInteger eli = new AtomicInteger(0);
    public static final AtomicBoolean DbA = new AtomicBoolean(false);

    public static void eli(Context context, boolean z) {
        if (DbA.compareAndSet(false, true)) {
            com.bytedance.sdk.component.MGA.eli.DbA.eli(new eli.C0134eli().eli(new aAs()).DbA(com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli.Os()).Os(com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli.ui()).eli(com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli.aGH()).eli(z).eli(new du()).eli(wC.eli).DbA(dV.aGH().nlS()).eli(dV.aGH().NU()).eli(dV.aGH().tLO()).eli(), context);
            DbA();
        }
    }

    public static void eli(com.bytedance.sdk.openadsdk.aGH.eli eliVar) {
        com.bytedance.sdk.component.MGA.eli.aGH.eli.eli eliVar2 = new com.bytedance.sdk.component.MGA.eli.aGH.eli.eli(eliVar.aGH(), eliVar);
        eliVar2.DbA(eliVar.ui() ? (byte) 1 : (byte) 2);
        eliVar2.eli((byte) 0);
        if (com.bytedance.sdk.component.MGA.eli.DbA.DbA()) {
            eli(dV.eli(), com.bytedance.sdk.openadsdk.multipro.DbA.Os());
        }
        com.bytedance.sdk.component.MGA.eli.DbA.eli(eliVar2);
    }

    public static com.bytedance.sdk.openadsdk.Dfc.Os.DbA eli() {
        return nlS.eli;
    }

    public static void eli(final List<String> list, final int i, final String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.bytedance.sdk.openadsdk.aGH.Os.eli(new com.bytedance.sdk.component.wC.wC("track") { // from class: com.bytedance.sdk.openadsdk.aGH.eli.aGH.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.sdk.component.MGA.eli.DbA.DbA()) {
                    aGH.eli(dV.eli(), com.bytedance.sdk.openadsdk.multipro.DbA.Os());
                }
                com.bytedance.sdk.component.MGA.eli.DbA.eli(com.bytedance.sdk.openadsdk.core.nlS.eli(dV.eli()), list, true, i, str);
            }
        });
    }

    public static void eli(String str) {
        eli(str, false);
    }

    public static void eli(String str, boolean z) {
        if (com.bytedance.sdk.component.MGA.eli.DbA.DbA()) {
            eli(dV.eli(), com.bytedance.sdk.openadsdk.multipro.DbA.Os());
        }
        com.bytedance.sdk.component.MGA.eli.DbA.eli(str, z);
    }

    public static void DbA() {
        com.bytedance.sdk.component.MGA.eli.DbA.Os();
    }

    public static void Os() {
        try {
            com.bytedance.sdk.component.MGA.eli.DbA.aGH();
            com.bytedance.sdk.component.MGA.eli.DbA.ui();
        } catch (Throwable th) {
            Xb.Os("AdLogSwitchUtils", th.getMessage());
        }
    }
}
