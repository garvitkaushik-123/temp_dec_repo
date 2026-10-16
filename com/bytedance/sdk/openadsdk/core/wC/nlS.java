package com.bytedance.sdk.openadsdk.core.wC;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.cyF;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class nlS {
    private static String DbA;
    private static String eli;

    public static void eli() {
        com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().eli(new com.bytedance.sdk.component.adexpress.eli.eli.DbA() { // from class: com.bytedance.sdk.openadsdk.core.wC.nlS.1
            @Override // com.bytedance.sdk.component.adexpress.eli.eli.DbA
            public int eli(String str, ContentValues contentValues, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.multipro.eli.eli.eli(com.bytedance.sdk.openadsdk.core.dV.eli(), str, contentValues, str2, strArr);
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.DbA
            public Cursor eli(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
                return new com.bytedance.sdk.openadsdk.multipro.aidl.Os(com.bytedance.sdk.openadsdk.multipro.eli.eli.eli(com.bytedance.sdk.openadsdk.core.dV.eli(), str, strArr, str2, strArr2, str3, str4, str5));
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.DbA
            public int eli(String str, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.multipro.eli.eli.eli(com.bytedance.sdk.openadsdk.core.dV.eli(), str, str2, strArr);
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.DbA
            public void eli(String str, ContentValues contentValues) {
                com.bytedance.sdk.openadsdk.multipro.eli.eli.eli(com.bytedance.sdk.openadsdk.core.dV.eli(), str, contentValues);
            }
        });
        com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().eli(new com.bytedance.sdk.component.adexpress.eli.eli.Os() { // from class: com.bytedance.sdk.openadsdk.core.wC.nlS.2
            @Override // com.bytedance.sdk.component.adexpress.eli.eli.Os
            public int FC() {
                return 1;
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.Os
            public int nlS() {
                return 0;
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.Os
            public int eli() {
                if (com.bytedance.sdk.openadsdk.core.dV.aGH() == null) {
                    return 0;
                }
                return com.bytedance.sdk.openadsdk.core.dV.aGH().aGH();
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.Os
            public Context DbA() {
                return com.bytedance.sdk.openadsdk.core.dV.eli();
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.Os
            public Handler Os() {
                return com.bytedance.sdk.openadsdk.core.nn.Os();
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.Os
            public void aGH() {
                int ow = com.bytedance.sdk.openadsdk.core.dV.aGH().ow();
                int TfR = com.bytedance.sdk.openadsdk.core.dV.aGH().TfR();
                if (ow == 0 && TfR == 0) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.ui.ui.eli().eli(ow);
                com.bytedance.sdk.component.adexpress.ui.ui.eli().DbA(TfR);
                int MGA = com.bytedance.sdk.openadsdk.bf.eli.MGA();
                int ui = com.bytedance.sdk.openadsdk.bf.eli.ui();
                if (MGA == 0 && ui == 0) {
                    return;
                }
                MessageQueue[] messageQueueArr = new MessageQueue[1];
                eli(com.bytedance.sdk.openadsdk.core.nn.Os().getLooper().getQueue(), ui, MGA);
            }

            /* renamed from: com.bytedance.sdk.openadsdk.core.wC.nlS$2$1, reason: invalid class name */
            class AnonymousClass1 implements Runnable {
                final /* synthetic */ int DbA;
                final /* synthetic */ int Os;
                final /* synthetic */ MessageQueue[] eli;

                AnonymousClass1(MessageQueue[] messageQueueArr, int i, int i2) {
                    this.eli = messageQueueArr;
                    this.DbA = i;
                    this.Os = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.eli[0] = Looper.myQueue();
                    eli(this.eli[0], this.DbA, this.Os);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void eli(final MessageQueue messageQueue, final int i, final int i2) {
                if (messageQueue != null) {
                    final int eli2 = com.bytedance.sdk.openadsdk.bf.eli.eli("ad_load_and_render_opt", "w_p_delay", 500);
                    Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wC.nlS.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DbA(messageQueue, i);
                            eli(messageQueue, i2);
                        }
                    };
                    if (eli2 > 0) {
                        com.bytedance.sdk.openadsdk.core.nn.Os().postDelayed(runnable, eli2);
                    } else {
                        runnable.run();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void eli(final MessageQueue messageQueue, final int i) {
                if (messageQueue == null || i <= 0) {
                    return;
                }
                messageQueue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.bytedance.sdk.openadsdk.core.wC.nlS.2.3
                    @Override // android.os.MessageQueue.IdleHandler
                    public boolean queueIdle() {
                        new com.bytedance.sdk.openadsdk.core.widget.eli.DbA(i, true, messageQueue).DbA();
                        return false;
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void DbA(final MessageQueue messageQueue, final int i) {
                if (messageQueue == null || i <= 0) {
                    return;
                }
                messageQueue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.bytedance.sdk.openadsdk.core.wC.nlS.2.4
                    @Override // android.os.MessageQueue.IdleHandler
                    public boolean queueIdle() {
                        new com.bytedance.sdk.openadsdk.core.widget.eli.DbA(i, false, messageQueue).DbA();
                        return false;
                    }
                });
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.Os
            public com.bytedance.sdk.component.adexpress.eli.Os.eli ui() {
                return com.bytedance.sdk.openadsdk.core.dV.Os().eli();
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.Os
            public com.bytedance.sdk.component.kb.DbA.eli MGA() {
                com.bytedance.sdk.component.kb.DbA.eli aGH = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().aGH();
                aGH.eli(8);
                aGH.eli("express_down");
                return aGH;
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.Os
            public com.bytedance.sdk.component.kb.DbA.DbA kb() {
                com.bytedance.sdk.component.kb.DbA.DbA Os = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().Os();
                Os.eli(8);
                Os.eli("express_get");
                return Os;
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.Os
            public String wC() {
                return com.bytedance.sdk.openadsdk.core.FC.DbA().aGH();
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.Os
            public int aAs() {
                return com.bytedance.sdk.openadsdk.core.dV.aGH().ow();
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.Os
            public int du() {
                return com.bytedance.sdk.openadsdk.core.dV.aGH().TfR();
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.Os
            public ExecutorService NU() {
                if (cyF.nlS()) {
                    return cyF.ui();
                }
                return null;
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.Os
            public ExecutorService nn() {
                if (cyF.nlS()) {
                    return cyF.aAs();
                }
                return null;
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.Os
            public int Dfc() {
                return SSo.Os(com.bytedance.sdk.openadsdk.core.dV.eli());
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.Os
            public int aqO() {
                return SSo.ui(com.bytedance.sdk.openadsdk.core.dV.eli());
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.Os
            public boolean dV() {
                return com.bytedance.sdk.openadsdk.bf.eli.eli("destroy_render_script", true);
            }

            @Override // com.bytedance.sdk.component.adexpress.eli.eli.Os
            public int nGm() {
                return com.bytedance.sdk.openadsdk.bf.eli.eli("gaussian_blur_type", 0);
            }
        });
        com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().eli(new com.bytedance.sdk.component.adexpress.eli.eli.aGH() { // from class: com.bytedance.sdk.openadsdk.core.wC.nlS.3
            @Override // com.bytedance.sdk.component.adexpress.eli.eli.aGH
            public void eli(int i) {
                com.bytedance.sdk.openadsdk.Dfc.Os.eli().eli(com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().DbA(i).MGA(com.bytedance.sdk.openadsdk.core.wC.eli(i)));
            }
        });
        com.bytedance.sdk.component.FC.eli.eli.eli().eli(new com.bytedance.sdk.component.FC.eli.DbA() { // from class: com.bytedance.sdk.openadsdk.core.wC.nlS.4
            @Override // com.bytedance.sdk.component.FC.eli.DbA
            public void eli(String str, String str2, JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.aGH.Os.Os(com.bytedance.sdk.openadsdk.utils.DbA.DbA(), str, str2, jSONObject);
            }

            @Override // com.bytedance.sdk.component.FC.eli.DbA
            public void eli(com.bytedance.sdk.component.FC.DbA.eli eliVar, String str, String str2, JSONObject jSONObject, long j) {
                com.bytedance.sdk.openadsdk.core.model.ev evVar = new com.bytedance.sdk.openadsdk.core.model.ev();
                evVar.Vy(eliVar.eli());
                evVar.ujq(eliVar.DbA());
                evVar.ev(eliVar.Os());
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, str, str2, jSONObject, j);
            }

            @Override // com.bytedance.sdk.component.FC.eli.DbA
            public void eli(com.bytedance.sdk.component.FC.DbA.eli eliVar, String str, final String str2, final JSONObject jSONObject) {
                if (eliVar != null) {
                    com.bytedance.sdk.openadsdk.core.model.ev evVar = new com.bytedance.sdk.openadsdk.core.model.ev();
                    evVar.Vy(eliVar.eli());
                    evVar.ujq(eliVar.DbA());
                    evVar.ev(eliVar.Os());
                    com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), evVar, str, str2, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.core.wC.nlS.4.1
                        @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
                        public JSONObject eli() {
                            String str3 = str2;
                            JSONObject jSONObject2 = jSONObject;
                            new Object[]{"click_interval_intercept", str3, jSONObject2};
                            return jSONObject2;
                        }
                    });
                }
            }
        });
    }

    public static String DbA() {
        String Os;
        if (eli == null) {
            eli = com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA("tt_sp", "js_render_ver", "");
        }
        com.bytedance.sdk.component.adexpress.eli.Os.eli DbA2 = com.bytedance.sdk.component.adexpress.eli.DbA.wC.DbA();
        if (DbA2 != null && (Os = DbA2.Os()) != null && !Os.equals(eli)) {
            eli = Os;
            com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_sp", "js_render_ver", Os);
        }
        return eli;
    }

    public static String Os() {
        Map<String, com.bytedance.sdk.component.adexpress.eli.Os.eli> eli2;
        com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar;
        String Os;
        if (DbA == null) {
            DbA = com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA("tt_sp", "js_render_v3_ver", "");
        }
        com.bytedance.sdk.component.adexpress.eli.Os.eli DbA2 = com.bytedance.sdk.component.adexpress.eli.DbA.wC.DbA();
        if (DbA2 != null && (eli2 = DbA2.eli()) != null && (eliVar = eli2.get("v3")) != null && (Os = eliVar.Os()) != null && !Os.equals(DbA)) {
            DbA = Os;
            com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_sp", "js_render_v3_ver", Os);
        }
        return DbA;
    }
}
