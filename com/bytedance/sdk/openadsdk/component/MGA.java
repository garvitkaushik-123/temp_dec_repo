package com.bytedance.sdk.openadsdk.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bykv.vk.openvk.eli.eli.eli.ui.eli;
import com.bytedance.sdk.component.ui.aAs;
import com.bytedance.sdk.component.ui.aqO;
import com.bytedance.sdk.component.ui.du;
import com.bytedance.sdk.component.ui.wC;
import com.bytedance.sdk.component.utils.nGm;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.common.eli;
import com.bytedance.sdk.openadsdk.core.CMM;
import com.bytedance.sdk.openadsdk.core.Xb;
import com.bytedance.sdk.openadsdk.core.bf;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.GB;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.model.ujq;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dV;
import com.bytedance.sdk.openadsdk.utils.eU;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MGA {
    private static String DbA = "openad_image_cache";
    private static volatile MGA Os = null;
    private static String eli = "/openad_image_cache";
    private final Context MGA;
    private final com.bytedance.sdk.openadsdk.DbA.DbA aGH;
    private final Map<String, AtomicInteger> kb = new ConcurrentHashMap();
    private final CMM<com.bytedance.sdk.openadsdk.aGH.eli> ui;

    interface DbA {
        void eli();

        void eli(int i, String str);
    }

    public interface Os {
        void eli(Object obj);
    }

    public interface eli {
        void eli();

        void eli(com.bytedance.sdk.openadsdk.nGm.eli.DbA dbA);
    }

    private MGA(Context context) {
        if (context != null) {
            this.MGA = context.getApplicationContext();
        } else {
            this.MGA = dV.eli();
        }
        this.aGH = new com.bytedance.sdk.openadsdk.DbA.DbA(10, 8, true);
        this.ui = dV.Os();
        if (com.bytedance.sdk.openadsdk.FC.aGH.DbA()) {
            eli += "_p";
            DbA += "_p";
        }
        com.bytedance.sdk.openadsdk.common.eli.eli("tt_openad_materialMeta_new", new eli.C0169eli("tt_openad_materialMeta_new") { // from class: com.bytedance.sdk.openadsdk.component.MGA.1
            @Override // com.bytedance.sdk.openadsdk.common.eli.C0169eli
            protected String eli(String str) {
                return "tt_openad_materialMeta_new";
            }

            @Override // com.bytedance.sdk.openadsdk.common.eli.C0169eli
            public String DbA(String str) {
                return com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA("tt_openad_materialMeta_new", "material".concat(String.valueOf(str)), null);
            }

            @Override // com.bytedance.sdk.openadsdk.common.eli.C0169eli
            public void eli(AdSlot adSlot, String str, String str2) {
                com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_openad_materialMeta_new", "material".concat(String.valueOf(adSlot.getCodeId())), str);
            }
        });
    }

    public static MGA eli(Context context) {
        if (Os == null) {
            synchronized (MGA.class) {
                if (Os == null) {
                    Os = new MGA(context);
                }
            }
        }
        return Os;
    }

    public static void eli(ev evVar, Os os) {
        eli(evVar, os, 0);
    }

    public static void eli(ev evVar, final Os os, final int i) {
        String aAs = evVar.nY().aAs();
        if (TextUtils.isEmpty(aAs)) {
            return;
        }
        aAs aGH = com.bytedance.sdk.openadsdk.FC.aGH.eli(aAs).eli(evVar.nY().Os()).DbA(evVar.nY().DbA()).ui(SSo.ui(dV.eli())).aGH(SSo.Os(dV.eli()));
        if (i > 0) {
            aGH.Os(2).eli(new wC() { // from class: com.bytedance.sdk.openadsdk.component.MGA.5
                @Override // com.bytedance.sdk.component.ui.wC
                public Bitmap eli(Bitmap bitmap) {
                    return com.bytedance.sdk.component.adexpress.aGH.eli.eli(dV.eli(), bitmap, i);
                }
            });
        } else {
            aGH.Os(1);
        }
        aGH.eli(new com.bytedance.sdk.openadsdk.FC.DbA(evVar, aAs, new aqO() { // from class: com.bytedance.sdk.openadsdk.component.MGA.6
            @Override // com.bytedance.sdk.component.ui.aqO
            public void eli(int i2, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.ui.aqO
            public void eli(du duVar) {
                Os os2;
                if (duVar == null || duVar.DbA() == null || duVar.Os() == null || (os2 = Os.this) == null) {
                    return;
                }
                os2.eli(duVar.DbA());
            }
        }));
    }

    public void eli(final AdSlot adSlot) {
        if (adSlot == null || !TextUtils.isEmpty(adSlot.getBidAdm())) {
            return;
        }
        AtomicInteger atomicInteger = this.kb.get(adSlot.getCodeId());
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
        }
        new Object[]{"local Requesting:", atomicInteger};
        int Os2 = atomicInteger.get() + Os(adSlot);
        if (Os2 > 0) {
            new Object[]{Integer.valueOf(Os2), ",The number of preloads exceeds the limit ", 1};
            return;
        }
        atomicInteger.incrementAndGet();
        this.kb.put(adSlot.getCodeId(), atomicInteger);
        final GB gb = new GB();
        gb.eli(eU.DbA());
        ujq ujqVar = new ujq();
        ujqVar.du = gb;
        ujqVar.aGH = 2;
        ujqVar.FC = 2;
        if (com.bytedance.sdk.openadsdk.utils.DbA.eli()) {
            this.ui.eli(adSlot, ujqVar, 3, (Xb) new bf() { // from class: com.bytedance.sdk.openadsdk.component.MGA.7
                @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
                public void eli(int i, String str) {
                    MGA.this.DbA(adSlot);
                }

                @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
                public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
                    MGA.this.eli(eliVar, os, adSlot, gb);
                }
            });
        } else {
            this.ui.eli(adSlot, ujqVar, 3, new CMM.eli() { // from class: com.bytedance.sdk.openadsdk.component.MGA.8
                @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
                public void eli(int i, String str) {
                    MGA.this.DbA(adSlot);
                }

                @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
                public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
                    MGA.this.eli(eliVar, os, adSlot, gb);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os, AdSlot adSlot, GB gb) {
        if (eliVar == null || eliVar.aGH() == null || eliVar.aGH().isEmpty()) {
            os.eli(-3);
            os.Os(2);
            com.bytedance.sdk.openadsdk.core.model.Os.eli(os);
            return;
        }
        ev evVar = eliVar.aGH().get(0);
        if (evVar != null && evVar.gG()) {
            com.bytedance.sdk.openadsdk.component.ui.eli eliVar2 = new com.bytedance.sdk.openadsdk.component.ui.eli(evVar.RTg(), evVar, eliVar);
            eli(eliVar2);
            com.bytedance.sdk.openadsdk.component.aGH.eli.eli(eliVar2.DbA(), 1, gb);
            DbA(adSlot);
            return;
        }
        if (ev.ui(evVar)) {
            eli(evVar, adSlot, gb, eliVar);
        } else {
            DbA(evVar, adSlot, gb, eliVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(AdSlot adSlot) {
        AtomicInteger atomicInteger = this.kb.get(adSlot.getCodeId());
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
        } else {
            atomicInteger.decrementAndGet();
        }
        this.kb.put(adSlot.getCodeId(), atomicInteger);
    }

    private void eli(final ev evVar, final AdSlot adSlot, final GB gb, final com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        final int RTg = evVar.RTg();
        eli(evVar, adSlot, gb, new DbA() { // from class: com.bytedance.sdk.openadsdk.component.MGA.9
            @Override // com.bytedance.sdk.openadsdk.component.MGA.DbA
            public void eli() {
                com.bytedance.sdk.openadsdk.component.ui.eli eliVar2 = new com.bytedance.sdk.openadsdk.component.ui.eli(RTg, evVar, eliVar);
                MGA.this.eli(eliVar2);
                com.bytedance.sdk.openadsdk.component.aGH.eli.eli(eliVar2.DbA(), 1, gb);
                MGA.this.DbA(adSlot);
            }

            @Override // com.bytedance.sdk.openadsdk.component.MGA.DbA
            public void eli(int i, String str) {
                MGA.this.DbA(adSlot);
            }
        });
    }

    private void DbA(final ev evVar, final AdSlot adSlot, final GB gb, final com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        final int RTg = evVar.RTg();
        eli(evVar, gb, new eli() { // from class: com.bytedance.sdk.openadsdk.component.MGA.10
            @Override // com.bytedance.sdk.openadsdk.component.MGA.eli
            public void eli(com.bytedance.sdk.openadsdk.nGm.eli.DbA dbA) {
                com.bytedance.sdk.openadsdk.component.ui.eli eliVar2 = new com.bytedance.sdk.openadsdk.component.ui.eli(RTg, evVar, eliVar);
                MGA.this.eli(eliVar2);
                com.bytedance.sdk.openadsdk.component.aGH.eli.eli(eliVar2.DbA(), 1, gb);
                MGA.this.DbA(adSlot);
            }

            @Override // com.bytedance.sdk.openadsdk.component.MGA.eli
            public void eli() {
                MGA.this.DbA(adSlot);
            }
        });
    }

    public void eli(final ev evVar, AdSlot adSlot, final GB gb, final DbA dbA) {
        final eU DbA2 = eU.DbA();
        final int RTg = evVar.RTg();
        com.bykv.vk.openvk.eli.eli.eli.Os.DbA nY = evVar.nY();
        String du = nY.du();
        String nn = nY.nn();
        if (TextUtils.isEmpty(nn)) {
            nn = com.bytedance.sdk.component.utils.ui.eli(du);
        }
        final File eli2 = com.bytedance.sdk.openadsdk.component.kb.eli.eli(nn);
        if (eli2.exists()) {
            com.bytedance.sdk.openadsdk.component.kb.eli.eli(eli2);
            eli(RTg);
            long aGH = DbA2.aGH();
            if (gb != null) {
                gb.eli(aGH);
                gb.eli(1);
            }
            dbA.eli();
            eli(evVar, (Os) null);
            return;
        }
        if (dV.aGH().Vy(String.valueOf(RTg)) && !nGm.aGH(dV.eli())) {
            dbA.eli(100, "OnlyWifi");
            return;
        }
        com.bytedance.sdk.openadsdk.core.nlS.eli.DbA eli3 = ev.eli(eli2.getParent(), evVar);
        eli3.eli("material_meta", evVar);
        eli3.eli("ad_slot", adSlot);
        com.bytedance.sdk.openadsdk.core.nlS.ui.eli.eli(eli3, new eli.InterfaceC0111eli() { // from class: com.bytedance.sdk.openadsdk.component.MGA.11
            @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
            public void DbA(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, int i) {
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
            public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, int i) {
                MGA.this.eli(RTg);
                long aGH2 = DbA2.aGH();
                com.bytedance.sdk.openadsdk.component.aGH.eli.DbA(evVar, aGH2, true);
                GB gb2 = gb;
                if (gb2 != null) {
                    gb2.eli(aGH2);
                    gb.eli(2);
                }
                dbA.eli();
                MGA.eli(evVar, (Os) null);
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
            public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, int i, String str) {
                long aGH2 = DbA2.aGH();
                com.bytedance.sdk.openadsdk.component.aGH.eli.DbA(evVar, aGH2, false);
                GB gb2 = gb;
                if (gb2 != null) {
                    gb2.eli(aGH2);
                }
                dbA.eli(i, str);
                try {
                    if (eli2.exists() && eli2.isFile()) {
                        com.bytedance.sdk.component.utils.kb.Os(eli2);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void eli(final ev evVar, final GB gb, final eli eliVar) {
        final eU DbA2 = eU.DbA();
        final int RTg = evVar.RTg();
        com.bytedance.sdk.openadsdk.core.model.nGm ngm = evVar.an().get(0);
        String kb = ngm.kb();
        String eli2 = ngm.eli();
        int DbA3 = ngm.DbA();
        int Os2 = ngm.Os();
        String eli3 = TextUtils.isEmpty(kb) ? com.bytedance.sdk.component.utils.ui.eli(eli2) : kb;
        if (TextUtils.isEmpty(eli3)) {
            if (eliVar != null) {
                eliVar.eli();
                return;
            }
            return;
        }
        File DbA4 = com.bytedance.sdk.openadsdk.component.kb.eli.DbA(eli3);
        if (eli(eli2, kb)) {
            DbA(RTg);
            long aGH = DbA2.aGH();
            if (gb != null) {
                gb.eli(aGH);
                gb.eli(1);
            }
            eliVar.eli(null);
            return;
        }
        com.bytedance.sdk.openadsdk.utils.dV.eli(new com.bytedance.sdk.openadsdk.nGm.eli(eli2, ngm.kb()), DbA3, Os2, new dV.eli() { // from class: com.bytedance.sdk.openadsdk.component.MGA.12
            @Override // com.bytedance.sdk.openadsdk.utils.dV.eli
            public void eli(com.bytedance.sdk.openadsdk.nGm.eli.DbA dbA) {
                if (dbA.ui()) {
                    MGA.this.DbA(RTg);
                    long aGH2 = DbA2.aGH();
                    com.bytedance.sdk.openadsdk.component.aGH.eli.eli(evVar, aGH2, true);
                    GB gb2 = gb;
                    if (gb2 != null) {
                        gb2.eli(aGH2);
                        gb.eli(2);
                    }
                    eliVar.eli(dbA);
                    return;
                }
                com.bytedance.sdk.openadsdk.component.aGH.eli.eli(evVar, DbA2.aGH(), false);
                eliVar.eli();
            }

            @Override // com.bytedance.sdk.openadsdk.utils.dV.eli
            public void eli() {
                com.bytedance.sdk.openadsdk.component.aGH.eli.eli(evVar, DbA2.aGH(), false);
                eliVar.eli();
            }
        }, DbA4.getParent());
    }

    public void eli(int i) {
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_openad", "video_has_cached".concat(String.valueOf(i)), Boolean.TRUE);
    }

    public void DbA(int i) {
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_openad", "image_has_cached".concat(String.valueOf(i)), Boolean.TRUE);
    }

    public void eli(final com.bytedance.sdk.openadsdk.component.ui.eli eliVar) {
        nn.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.MGA.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (eliVar.DbA() == null || ev.kb(eliVar.DbA()) || eliVar.DbA().JF()) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_openad", "material_expiration_time" + eliVar.eli(), Long.valueOf(eliVar.DbA().ILu()));
                    if (com.bytedance.sdk.openadsdk.utils.DbA.eli()) {
                        com.bytedance.sdk.openadsdk.common.eli.eli("tt_openad_materialMeta_new").eli(eliVar.DbA().XU(), eliVar.Os());
                    } else {
                        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_openad_materialMeta", "material" + eliVar.eli(), com.bytedance.sdk.component.utils.eli.eli(eliVar.DbA().iOb()).toString());
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    public String Os(int i) {
        String DbA2 = com.bytedance.sdk.openadsdk.common.eli.eli("tt_openad_materialMeta_new").DbA(String.valueOf(i));
        long eli2 = com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_openad", "material_expiration_time".concat(String.valueOf(i)), -1L);
        if (System.currentTimeMillis() / 1000 < eli2) {
            return DbA2;
        }
        if (eli2 == -1) {
            return null;
        }
        MGA(i);
        eli(DbA2);
        return null;
    }

    private void eli(final String str) {
        cyF.eli(new com.bytedance.sdk.component.wC.wC("opencache") { // from class: com.bytedance.sdk.openadsdk.component.MGA.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.model.eli DbA2;
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("cypher")) {
                        jSONObject = com.bytedance.sdk.openadsdk.core.dV.Os().eli(jSONObject);
                    }
                    if (jSONObject == null || !jSONObject.has("creatives") || (DbA2 = com.bytedance.sdk.openadsdk.core.model.eli.DbA(jSONObject)) == null || !DbA2.ui()) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.component.aGH.eli.eli(DbA2.MGA());
                } catch (Throwable unused) {
                }
            }
        });
    }

    public ev aGH(int i) {
        ev ui = ui(i);
        long eli2 = com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_openad", "material_expiration_time".concat(String.valueOf(i)), -1L);
        if (System.currentTimeMillis() / 1000 < eli2 && ui != null) {
            return ui;
        }
        if (ui == null && eli2 == -1) {
            return null;
        }
        MGA(i);
        if (ui == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.component.aGH.eli.eli(ui);
        return null;
    }

    public ev ui(int i) {
        String DbA2 = com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA("tt_openad_materialMeta", "material".concat(String.valueOf(i)), null);
        if (!TextUtils.isEmpty(DbA2)) {
            try {
                JSONObject eli2 = com.bytedance.sdk.openadsdk.core.dV.Os().eli(new JSONObject(DbA2));
                if (eli2 == null || !eli2.has("creatives")) {
                    return com.bytedance.sdk.openadsdk.core.DbA.eli(eli2);
                }
                return null;
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.Xb.Os("TTAppOpenAdCacheManager", e.getMessage());
            }
        }
        return null;
    }

    public String eli(ev evVar) {
        if (evVar != null && evVar.nY() != null && !TextUtils.isEmpty(evVar.nY().du())) {
            String du = evVar.nY().du();
            String nn = evVar.nY().nn();
            if (TextUtils.isEmpty(nn)) {
                nn = com.bytedance.sdk.component.utils.ui.eli(du);
            }
            File eli2 = com.bytedance.sdk.openadsdk.component.kb.eli.eli(nn);
            if (eli2.exists() && eli2.isFile()) {
                return eli2.getAbsolutePath();
            }
        }
        return null;
    }

    public boolean eli(String str, String str2) {
        boolean z;
        File file;
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = com.bytedance.sdk.component.utils.ui.eli(str);
            }
            File DbA2 = com.bytedance.sdk.openadsdk.component.kb.eli.DbA(str2);
            InputStream eli2 = com.bytedance.sdk.openadsdk.FC.aGH.eli(str, str2);
            if (eli2 != null) {
                try {
                    eli2.close();
                } catch (IOException e) {
                    com.bytedance.sdk.component.utils.Xb.Os("TTAppOpenAdCacheManager", e.getMessage());
                }
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (com.bytedance.sdk.openadsdk.FC.aGH.eli(str, str2, DbA2.getParent())) {
                    return true;
                }
                if (com.bytedance.sdk.openadsdk.FC.aGH.DbA()) {
                    file = new File(DbA2.getPath());
                } else {
                    file = new File(DbA2.getPath() + ".0");
                }
                if (file.exists()) {
                    return true;
                }
            }
            return z;
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAppOpenAdCacheManager", e2.getMessage());
            return false;
        }
    }

    public void MGA(int i) {
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_openad_materialMeta_new", "material".concat(String.valueOf(i)));
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_openad_materialMeta", "material".concat(String.valueOf(i)));
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_openad", "material_expiration_time".concat(String.valueOf(i)));
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_openad", "video_has_cached".concat(String.valueOf(i)));
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_openad", "image_has_cached".concat(String.valueOf(i)));
    }

    public void eli() {
        File[] listFiles;
        try {
            com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_openad_materialMeta");
            com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_openad_materialMeta_new");
            com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_openad");
        } catch (Throwable unused) {
        }
        try {
            File cacheDir = this.MGA.getCacheDir();
            if (cacheDir == null || !cacheDir.exists() || !cacheDir.isDirectory() || (listFiles = cacheDir.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.MGA.4
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file == null) {
                        return false;
                    }
                    String name = file.getName();
                    return name.contains(MGA.DbA) || name.contains("openad_video_cache");
                }
            })) == null) {
                return;
            }
            for (File file : listFiles) {
                try {
                    com.bytedance.sdk.component.utils.kb.Os(file);
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
        }
    }

    public String DbA() {
        String name = new File(CacheDirFactory.getRootDir()).getName();
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            return name + RemoteSettings.FORWARD_SLASH_STRING + DbA + RemoteSettings.FORWARD_SLASH_STRING;
        }
        return name + RemoteSettings.FORWARD_SLASH_STRING + eli + RemoteSettings.FORWARD_SLASH_STRING;
    }

    private int Os(AdSlot adSlot) {
        long eli2 = com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_openad", "material_expiration_time" + adSlot.getCodeId(), -1L);
        new Object[]{"local cache number : ", Integer.valueOf(eli2 == -1 ? 0 : 1)};
        return eli2 == -1 ? 0 : 1;
    }
}
