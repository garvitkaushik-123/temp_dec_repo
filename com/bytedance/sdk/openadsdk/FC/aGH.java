package com.bytedance.sdk.openadsdk.FC;

import android.content.Context;
import com.bytedance.sdk.component.DbA.eli.MGA;
import com.bytedance.sdk.component.DbA.eli.du;
import com.bytedance.sdk.component.DbA.eli.nlS;
import com.bytedance.sdk.component.DbA.eli.nn;
import com.bytedance.sdk.component.ui.Dfc;
import com.bytedance.sdk.component.ui.Os.ui;
import com.bytedance.sdk.component.ui.Xb;
import com.bytedance.sdk.component.ui.aAs;
import com.bytedance.sdk.component.ui.aGH.Os.ui;
import com.bytedance.sdk.component.ui.bf;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.nGm;
import com.bytedance.sdk.openadsdk.utils.Cp;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.cyF;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class aGH {
    public static aAs eli(String str) {
        return eli.DbA(str);
    }

    public static aAs eli(nGm ngm) {
        return eli.DbA(ngm);
    }

    public static InputStream eli(String str, String str2) {
        return eli.DbA(str, str2);
    }

    public static boolean eli(String str, String str2, String str3) {
        return eli.DbA(str, str2, str3);
    }

    public static Dfc eli() {
        return eli.DbA;
    }

    public static boolean DbA() {
        return eli.eli;
    }

    private static final class eli {
        private static final Dfc DbA = eli(dV.eli());
        public static boolean eli = true;
        private static int Os = 10;
        private static int aGH = 15;
        private static int ui = 30;

        public static void eli() {
            eli = com.bytedance.sdk.openadsdk.bf.eli.eli("image_config", "use_new_img", 1) == 1;
            Os = com.bytedance.sdk.openadsdk.bf.eli.eli("image_config", "bitmap_cache_count", 10);
            aGH = com.bytedance.sdk.openadsdk.bf.eli.eli("image_config", "data_cache_count", 15);
            ui = com.bytedance.sdk.openadsdk.bf.eli.eli("image_config", "disk_cache_count", 30);
        }

        private static Dfc eli(Context context) {
            eli();
            if (eli) {
                return com.bytedance.sdk.component.ui.aGH.Os.DbA.eli(context, new ui.eli().eli(new com.bytedance.sdk.component.ui.aGH.Os.eli.DbA(0, Os, aGH, ui, new File(CacheDirFactory.getImageCacheDir("image_p")))).eli(com.bytedance.sdk.openadsdk.multipro.DbA.Os()).eli(new Xb() { // from class: com.bytedance.sdk.openadsdk.FC.aGH.eli.2
                    @Override // com.bytedance.sdk.component.ui.Xb
                    public ExecutorService eli() {
                        return cyF.DbA();
                    }

                    @Override // com.bytedance.sdk.component.ui.Xb
                    public ExecutorService DbA() {
                        return cyF.Os();
                    }
                }).eli(new bf() { // from class: com.bytedance.sdk.openadsdk.FC.aGH.eli.1
                    @Override // com.bytedance.sdk.component.ui.bf
                    public void eli(int i, String str) {
                        com.bytedance.sdk.openadsdk.Dfc.Os.eli(str, true);
                    }
                }).eli(new C0157eli()).eli());
            }
            return com.bytedance.sdk.component.ui.Os.DbA.eli(context, new ui.eli().eli(new com.bytedance.sdk.component.ui.Os.eli.eli(Math.max(Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 83886080), 10485760), 41943040L, new File(CacheDirFactory.getImageCacheDir("image")))).eli(com.bytedance.sdk.openadsdk.multipro.DbA.Os()).eli(new Xb() { // from class: com.bytedance.sdk.openadsdk.FC.aGH.eli.4
                @Override // com.bytedance.sdk.component.ui.Xb
                public ExecutorService DbA() {
                    return null;
                }

                @Override // com.bytedance.sdk.component.ui.Xb
                public ExecutorService eli() {
                    return cyF.DbA();
                }
            }).eli(new bf() { // from class: com.bytedance.sdk.openadsdk.FC.aGH.eli.3
                @Override // com.bytedance.sdk.component.ui.bf
                public void eli(int i, String str) {
                    com.bytedance.sdk.openadsdk.Dfc.Os.eli(str, false);
                }
            }).eli(new C0157eli()).eli());
        }

        /* renamed from: com.bytedance.sdk.openadsdk.FC.aGH$eli$eli, reason: collision with other inner class name */
        private static class C0157eli implements com.bytedance.sdk.component.ui.aGH {
            private C0157eli() {
            }

            @Override // com.bytedance.sdk.component.ui.aGH
            /* renamed from: DbA, reason: merged with bridge method [inline-methods] */
            public com.bytedance.sdk.component.ui.DbA.Os eli(com.bytedance.sdk.component.ui.ui uiVar) {
                du MGA = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().MGA();
                nlS DbA = new nlS.eli().DbA(uiVar.eli()).eli().DbA();
                nn nnVar = null;
                com.bytedance.sdk.component.ui.DbA.aGH agh = uiVar.Os() ? new com.bytedance.sdk.component.ui.DbA.aGH() : null;
                if (agh != null) {
                    agh.eli(System.currentTimeMillis());
                }
                try {
                    nnVar = MGA.eli(DbA).DbA();
                    if (agh != null) {
                        agh.DbA(System.currentTimeMillis());
                    }
                    return new com.bytedance.sdk.component.ui.DbA.Os(nnVar.Os(), nnVar.MGA().aGH(), "", eli(uiVar, nnVar));
                } catch (Throwable th) {
                    try {
                        return eli(agh, th);
                    } finally {
                        com.bytedance.sdk.component.utils.aAs.eli(nnVar);
                    }
                }
            }

            private Map<String, String> eli(com.bytedance.sdk.component.ui.ui uiVar, nn nnVar) {
                if (!uiVar.DbA()) {
                    return null;
                }
                MGA kb = nnVar.kb();
                HashMap hashMap = new HashMap();
                int eli = kb.eli();
                for (int i = 0; i < eli; i++) {
                    String eli2 = kb.eli(i);
                    String DbA = kb.DbA(i);
                    if (eli2 != null) {
                        hashMap.put(eli2, DbA);
                    }
                }
                return hashMap;
            }

            private com.bytedance.sdk.component.ui.DbA.Os eli(com.bytedance.sdk.component.ui.DbA.aGH agh, Throwable th) {
                th.getMessage();
                if (agh != null) {
                    agh.Os(System.currentTimeMillis());
                }
                com.bytedance.sdk.component.ui.DbA.Os os = new com.bytedance.sdk.component.ui.DbA.Os(98765, th, "net failed");
                os.eli(agh);
                return os;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static aAs DbA(String str) {
            return eli(DbA.eli(str).ui(SSo.ui(dV.eli())).aGH(SSo.Os(dV.eli())));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static aAs DbA(nGm ngm) {
            return eli(DbA.eli(ngm.eli()).eli(ngm.DbA()).DbA(ngm.Os()).ui(SSo.ui(dV.eli())).aGH(SSo.Os(dV.eli())).eli(ngm.kb()));
        }

        private static aAs eli(aAs aas) {
            return Cp.eli() ? aas.eli(new ui()) : aas;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static InputStream DbA(String str, String str2) {
            return DbA.eli(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean DbA(String str, String str2, String str3) {
            return DbA.eli(str, str2, str3);
        }
    }
}
