package com.bytedance.sdk.openadsdk.dV;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.wC;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.nn;
import com.ironsource.mediationsdk.metadata.a;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os {
    private static Boolean DbA;
    private static volatile HandlerThread Os = wC.eli("pag__bus_monitor", 0);
    private static volatile Handler aGH;
    private static volatile eli eli;

    public static eli eli() {
        if (eli == null) {
            synchronized (Os.class) {
                if (eli == null) {
                    eli = eli.eli(new DbA() { // from class: com.bytedance.sdk.openadsdk.dV.Os.1
                        @Override // com.bytedance.sdk.openadsdk.dV.DbA
                        public Context getContext() {
                            return dV.eli();
                        }

                        @Override // com.bytedance.sdk.openadsdk.dV.DbA
                        public Handler getHandler() {
                            return Os.ui();
                        }

                        @Override // com.bytedance.sdk.openadsdk.dV.DbA
                        public int getUploadIntervalTime() {
                            int eli2 = com.bytedance.sdk.openadsdk.bf.eli.eli("bus_monitor_config", "interval", 43200000);
                            if (eli2 < 3600000) {
                                return 86400000;
                            }
                            return eli2;
                        }

                        @Override // com.bytedance.sdk.openadsdk.dV.DbA
                        public boolean isMonitorOpen() {
                            if (Os.DbA != null) {
                                return Os.DbA.booleanValue();
                            }
                            Boolean unused = Os.DbA = Boolean.valueOf(com.bytedance.sdk.openadsdk.bf.eli.eli("bus_monitor_config", a.j, 0) == 1);
                            return Os.DbA.booleanValue();
                        }

                        @Override // com.bytedance.sdk.openadsdk.dV.DbA
                        public void onMonitorUpload(List<com.bytedance.sdk.openadsdk.dV.DbA.eli> list) {
                            if (list == null || list.isEmpty()) {
                                return;
                            }
                            for (final com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar : list) {
                                com.bytedance.sdk.openadsdk.Dfc.Os.eli();
                                com.bytedance.sdk.openadsdk.Dfc.Os.eli("bus_monitor", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.dV.Os.1.1
                                    @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
                                    public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            jSONObject.put(BidTokenRepositoryKt.SDK_VERSION, eliVar.DbA());
                                            jSONObject.put("scene", eliVar.Os());
                                            jSONObject.put("start_count", eliVar.aGH());
                                            jSONObject.put("success_count", eliVar.ui());
                                            jSONObject.put("fail_count", eliVar.MGA());
                                            jSONObject.put("rit", eliVar.kb());
                                            jSONObject.put("tag", eliVar.wC());
                                            jSONObject.put("label", eliVar.FC());
                                            jSONObject.put("mediation", eliVar.du());
                                            jSONObject.put("is_init", eliVar.nlS());
                                            jSONObject.put("extra", eliVar.NU());
                                            String jSONObject2 = jSONObject.toString();
                                            new Object[]{"logStr = ", jSONObject2};
                                            return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("bus_monitor").DbA(jSONObject2);
                                        } catch (Exception e) {
                                            Xb.eli("BusMonitorUtils", "onMonitorUpload: ", e);
                                            return null;
                                        }
                                    }
                                });
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.dV.DbA
                        public int getOnceLogCount() {
                            int eli2 = com.bytedance.sdk.openadsdk.bf.eli.eli("bus_monitor_config", "once_count", 10);
                            if (eli2 > 100 || eli2 < 5) {
                                return 10;
                            }
                            return eli2;
                        }

                        @Override // com.bytedance.sdk.openadsdk.dV.DbA
                        public int getOnceLogInterval() {
                            int eli2 = com.bytedance.sdk.openadsdk.bf.eli.eli("bus_monitor_config", "once_interval", 10000);
                            if (eli2 < 10000) {
                                return 10000;
                            }
                            return eli2;
                        }

                        @Override // com.bytedance.sdk.openadsdk.dV.DbA
                        public HandlerThread getSafeHandlerThread(String str, int i) {
                            return wC.eli(str, i);
                        }
                    });
                }
            }
        }
        return eli;
    }

    public static void eli(aGH agh) {
        eli().eli(new ui(agh, 1, 0, 0));
    }

    public static void DbA(aGH agh) {
        eli().eli(new ui(agh, 0, 1, 0));
    }

    public static void Os(aGH agh) {
        eli().eli(new ui(agh, 0, 0, 1));
    }

    public static void DbA() {
        eli().eli(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Handler ui() {
        if (Os == null || !Os.isAlive()) {
            synchronized (nn.class) {
                if (Os == null || !Os.isAlive()) {
                    Os = wC.eli("csj_init_handle", -1);
                    aGH = new Handler(Os.getLooper());
                }
            }
        } else if (aGH == null) {
            synchronized (nn.class) {
                if (aGH == null) {
                    aGH = new Handler(Os.getLooper());
                }
            }
        }
        return aGH;
    }
}
