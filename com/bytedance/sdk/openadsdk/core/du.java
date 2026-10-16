package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.bytedance.sdk.component.utils.ujq;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.google.common.net.HttpHeaders;
import com.pgl.ssdk.ces.out.PglSSConfig;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class du {
    private static final AtomicInteger eli = new AtomicInteger(0);
    private static final AtomicBoolean DbA = new AtomicBoolean(false);

    public static void eli(String str) {
        AtomicBoolean atomicBoolean = DbA;
        if (atomicBoolean.compareAndSet(false, true)) {
            if (!com.bytedance.sdk.component.utils.nGm.wC(dV.eli())) {
                atomicBoolean.set(false);
            } else {
                eli.eli();
                DbA(str);
            }
        }
    }

    public static void DbA(final String str) {
        com.bytedance.sdk.openadsdk.utils.cyF.Os(new com.bytedance.sdk.component.wC.wC("ipv6") { // from class: com.bytedance.sdk.openadsdk.core.du.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject eli2;
                final String QX = dZ.QX();
                com.bytedance.sdk.openadsdk.Dfc.Os.eli(0, QX);
                com.bytedance.sdk.openadsdk.dV.Os.eli(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.du.1.1
                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                        eliVar.DbA("ipv6");
                        return eliVar;
                    }
                });
                if (TextUtils.isEmpty(QX)) {
                    com.bytedance.sdk.openadsdk.Dfc.Os.eli(-1, QX, -1, "url is null");
                    com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("ipv6", "", -2, "url is null");
                    com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.du.1.2
                        @Override // com.bytedance.sdk.openadsdk.dV.aGH
                        public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                            com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                            eliVar.DbA("ipv6");
                            return eliVar;
                        }
                    });
                    return;
                }
                com.bytedance.sdk.component.kb.DbA.aGH DbA2 = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().DbA();
                try {
                    DbA2.DbA(QX);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("connect_type", com.bytedance.sdk.component.utils.ujq.eli(dV.eli(), 0L));
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("device_id", Long.parseLong(str));
                    }
                    jSONObject.put("header", com.bytedance.sdk.openadsdk.aGH.eli.Os.eli().DbA());
                    if (com.bytedance.sdk.openadsdk.core.settings.NU.nY().eli(PangleEncryptConstant.CryptDataScene.APP_LOG)) {
                        eli2 = PangleEncryptManager.encryptType4(jSONObject, new Vy(PangleEncryptConstant.CryptDataScene.DUAL_EVENT));
                        if (eli2 != null && eli2.optInt("cypher") == 4) {
                            gG.DbA(true);
                            DbA2.DbA("x-pgli18n", "4");
                            DbA2.DbA("Content-Type", "application/json; charset=utf-8");
                        } else {
                            gG.DbA(false);
                        }
                    } else {
                        eli2 = com.bytedance.sdk.component.utils.eli.eli(jSONObject);
                        if (du.DbA(eli2)) {
                            DbA2.DbA(HttpHeaders.CONTENT_ENCODING, "union_sdk_encode");
                        }
                    }
                    if (du.DbA(eli2)) {
                        jSONObject = eli2;
                    }
                    DbA2.DbA("Content-Type", "application/json; charset=utf-8");
                    DbA2.DbA("User-Agent", dZ.aGH());
                    DbA2.eli(jSONObject);
                    DbA2.eli(6);
                    DbA2.eli("send_i_p_v6");
                    DbA2.eli(new com.bytedance.sdk.component.kb.eli.eli() { // from class: com.bytedance.sdk.openadsdk.core.du.1.3
                        @Override // com.bytedance.sdk.component.kb.eli.eli
                        public void eli(com.bytedance.sdk.component.kb.DbA.Os os, com.bytedance.sdk.component.kb.DbA dbA) {
                            if (dbA.MGA()) {
                                du.DbA(dbA.aGH(), QX);
                                return;
                            }
                            com.bytedance.sdk.openadsdk.Dfc.Os.eli(-1, QX, dbA.eli(), dbA.DbA());
                            com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("ipv6", QX, dbA.eli(), dbA.DbA());
                            com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.du.1.3.1
                                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                    eliVar.DbA("ipv6");
                                    return eliVar;
                                }
                            });
                            du.aGH();
                        }

                        @Override // com.bytedance.sdk.component.kb.eli.eli
                        public void eli(com.bytedance.sdk.component.kb.DbA.Os os, IOException iOException) {
                            if (iOException != null) {
                                com.bytedance.sdk.openadsdk.Dfc.Os.eli(-1, QX, 1, iOException.getMessage());
                                com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("ipv6", QX, -1, iOException.getMessage());
                                com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.du.1.3.2
                                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                        eliVar.DbA("ipv6");
                                        return eliVar;
                                    }
                                });
                            }
                            du.aGH();
                        }
                    });
                } catch (Exception e) {
                    com.bytedance.sdk.openadsdk.Dfc.Os.eli(-1, QX, -2, e.getMessage());
                    com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("ipv6", QX, -3, e.getMessage());
                    com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.du.1.4
                        @Override // com.bytedance.sdk.openadsdk.dV.aGH
                        public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                            com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                            eliVar.DbA("ipv6");
                            return eliVar;
                        }
                    });
                    com.bytedance.sdk.component.utils.Xb.Os("build ipv6 request failed:" + e.getMessage(), new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c4 A[Catch: JSONException -> 0x0126, TryCatch #0 {JSONException -> 0x0126, blocks: (B:3:0x000a, B:5:0x0019, B:8:0x0029, B:10:0x0037, B:23:0x0089, B:26:0x0099, B:28:0x009f, B:30:0x00b5, B:32:0x00c4, B:34:0x00ca, B:36:0x00ef, B:38:0x005a, B:41:0x0064, B:44:0x006c, B:47:0x00fe), top: B:2:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void DbA(String str, String str2) {
        char c;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("cypher") != 4) {
                com.bytedance.sdk.openadsdk.Dfc.Os.eli(-1, str2, 1, "cypher type error");
                com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("ipv6", str2, -4, "cypher type error");
                com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.du.3
                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                        eliVar.DbA("ipv6");
                        return eliVar;
                    }
                });
                return;
            }
            Pair<Integer, String> decryptType4 = PangleEncryptManager.decryptType4(jSONObject.optString(PglCryptUtils.KEY_MESSAGE));
            if (decryptType4.second != null) {
                JSONObject jSONObject2 = new JSONObject((String) decryptType4.second);
                String optString = jSONObject2.optString("ip_type");
                int hashCode = optString.hashCode();
                if (hashCode == 3239397) {
                    if (optString.equals("ipv4")) {
                        c = 1;
                        if (c != 0) {
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                } else if (hashCode != 3239399) {
                    if (hashCode == 1959784951 && optString.equals("invalid")) {
                        c = 2;
                        if (c != 0) {
                            if (jSONObject2.has("ip")) {
                                String optString2 = jSONObject2.optString("ip");
                                com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("ttopenadsdk", PglSSConfig.CUSTOMINFO_KEY_IPV6, optString2);
                                com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("ttopenadsdk", "key_ipv4");
                                HashMap hashMap = new HashMap();
                                hashMap.put(PglSSConfig.CUSTOMINFO_KEY_IPV6, optString2);
                                com.bytedance.sdk.openadsdk.core.FC.DbA.DbA().eli(hashMap);
                                com.bytedance.sdk.openadsdk.Dfc.Os.eli(1, str2);
                                com.bytedance.sdk.openadsdk.dV.Os.DbA(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.du.5
                                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                        eliVar.DbA("ipv6");
                                        return eliVar;
                                    }
                                });
                                return;
                            }
                            com.bytedance.sdk.openadsdk.Dfc.Os.eli(-1, str2, 4, "no ip");
                            com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("ipv6", str2, -6, "no ip");
                            com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.du.6
                                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                    eliVar.DbA("ipv6");
                                    return eliVar;
                                }
                            });
                            return;
                        }
                        if (c != 1) {
                            if (c != 2) {
                                com.bytedance.sdk.openadsdk.Dfc.Os.eli(-1, str2, 3, "no ip type ");
                                com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("ipv6", str2, -7, "no ip type ");
                                com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.du.9
                                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                        eliVar.DbA("ipv6");
                                        return eliVar;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (jSONObject2.has("ip")) {
                            com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("ttopenadsdk", "key_ipv4", jSONObject2.optString("ip"));
                            com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("ttopenadsdk", PglSSConfig.CUSTOMINFO_KEY_IPV6);
                            com.bytedance.sdk.openadsdk.Dfc.Os.eli(1, str2);
                            com.bytedance.sdk.openadsdk.dV.Os.DbA(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.du.7
                                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                    eliVar.DbA("ipv6");
                                    return eliVar;
                                }
                            });
                            return;
                        }
                        com.bytedance.sdk.openadsdk.Dfc.Os.eli(-1, str2, 4, "no ip");
                        com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("ipv6", str2, -6, "no ip");
                        com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.du.8
                            @Override // com.bytedance.sdk.openadsdk.dV.aGH
                            public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                eliVar.DbA("ipv6");
                                return eliVar;
                            }
                        });
                        return;
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                } else {
                    if (optString.equals("ipv6")) {
                        c = 0;
                        if (c != 0) {
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                }
            } else {
                int intValue = ((Integer) decryptType4.first).intValue();
                com.bytedance.sdk.openadsdk.Dfc.Os.eli(-1, str2, 2, "decrypt failed ".concat(String.valueOf(intValue)));
                com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("ipv6", str2, -5, "decrypt failed ".concat(String.valueOf(intValue)));
                com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.du.4
                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                        eliVar.DbA("ipv6");
                        return eliVar;
                    }
                });
            }
        } catch (JSONException unused) {
            com.bytedance.sdk.openadsdk.Dfc.Os.eli(-1, str2, 2, "decrypt failed, wrong data ");
            com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("ipv6", str2, -8, "decrypt failed, wrong data ");
            com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.du.10
                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                    eliVar.DbA("ipv6");
                    return eliVar;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean DbA(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Os() {
        eli.set(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aGH() {
        if (eli.getAndIncrement() <= 0) {
            com.bytedance.sdk.openadsdk.utils.cyF.eli().schedule(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.du.2
                @Override // java.lang.Runnable
                public void run() {
                    du.DbA(nlS.eli(dV.eli()));
                }
            }, 10000L, TimeUnit.MILLISECONDS);
        }
    }

    private static class eli implements ujq.eli {
        private static final AtomicBoolean eli = new AtomicBoolean(false);
        private static volatile long DbA = -1;

        private eli() {
        }

        public static void eli() {
            if (eli.compareAndSet(false, true)) {
                DbA = System.currentTimeMillis();
                com.bytedance.sdk.component.utils.ujq.eli(new eli(), dV.eli());
            }
        }

        public void DbA() {
            com.bytedance.sdk.component.utils.ujq.eli(this);
        }

        @Override // com.bytedance.sdk.component.utils.ujq.eli
        public void eli(Context context, Intent intent, boolean z, int i) {
            if (System.currentTimeMillis() - DbA >= 2000 && i != 0) {
                du.Os();
                du.DbA(nlS.eli(dV.eli()));
                DbA();
            }
        }
    }
}
