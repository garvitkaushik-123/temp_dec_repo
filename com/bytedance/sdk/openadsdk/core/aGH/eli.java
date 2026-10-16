package com.bytedance.sdk.openadsdk.core.aGH;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.kb;
import com.bytedance.sdk.component.utils.ui;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.Dfc.eli.aGH;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS.Os.Os;
import com.bytedance.sdk.openadsdk.multipro.DbA;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    private final List<String> eli = new CopyOnWriteArrayList();
    private final Os DbA = new Os(5, 5, true);
    private final ConcurrentHashMap<String, Long> Os = new ConcurrentHashMap<>();

    /* renamed from: com.bytedance.sdk.openadsdk.core.aGH.eli$eli, reason: collision with other inner class name */
    private static class C0184eli {
        private static final eli eli = new eli();
    }

    public static eli eli() {
        return C0184eli.eli;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        List<ev> aGH = eliVar.aGH();
        if (aGH == null || aGH.size() == 0) {
            return;
        }
        for (int i = 0; i < aGH.size(); i++) {
            ev evVar = aGH.get(i);
            if (evVar != null) {
                eli(evVar);
            }
        }
    }

    public InputStream eli(String str) {
        File DbA = DbA(str);
        if (DbA == null || !eli(DbA)) {
            return null;
        }
        try {
            return new FileInputStream(DbA);
        } catch (Exception e) {
            Xb.Os("MusicCacheManager", e.getMessage());
            return null;
        }
    }

    private void eli(ev evVar) {
        ev.eli RY;
        String FC;
        if (evVar == null || (RY = evVar.RY()) == null || (FC = RY.FC()) == null || !FC.contains("music_url")) {
            return;
        }
        Os();
        String DbA = RY.DbA();
        if (TextUtils.isEmpty(DbA)) {
            try {
                new JSONObject().put("result", 0);
            } catch (JSONException e) {
                Xb.Os("MusicCacheManager", e.getMessage());
            }
            eli(0, -1L, 10001, "music url string is null");
            return;
        }
        File DbA2 = DbA(DbA);
        if (DbA2 == null) {
            return;
        }
        new Object[]{"music cache file is:", DbA2.getPath()};
        if (eli(DbA2)) {
            new Object[]{"has music cache:", Boolean.TRUE};
            eli(2, -1L, -1, null);
        } else {
            new Object[]{"has music cache:", Boolean.FALSE};
            eli(evVar, DbA, DbA2);
        }
    }

    public File DbA(String str) {
        String str2;
        String eli = ui.eli(str);
        if (eli == null) {
            return null;
        }
        String name = new File(CacheDirFactory.getRootDir()).getName();
        if (DbA.Os()) {
            str2 = name + "/music/";
        } else {
            str2 = name + "//music/";
        }
        new Object[]{"cachePath is:", str2, ", musicCacheName is:", eli};
        return kb.eli(dV.eli(), DbA.Os(), str2, eli);
    }

    private boolean eli(File file) {
        return file.exists() && file.length() != 0;
    }

    private void eli(ev evVar, String str, File file) {
        if (Os(str)) {
            this.Os.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
            com.bytedance.sdk.component.kb.DbA.eli aGH = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().aGH();
            aGH.DbA(str);
            aGH.eli(file.getParent(), file.getName());
            aGH.Os(str);
            this.eli.add(str);
            aGH.eli(new com.bytedance.sdk.component.kb.eli.eli() { // from class: com.bytedance.sdk.openadsdk.core.aGH.eli.1
                @Override // com.bytedance.sdk.component.kb.eli.eli
                public void eli(com.bytedance.sdk.component.kb.DbA.Os os, com.bytedance.sdk.component.kb.DbA dbA) {
                    new Object[]{"get response header:", dbA.Os()};
                    new Object[]{"download music response, response is:", Integer.valueOf(dbA.eli())};
                    String Os = os.Os();
                    Long l = (Long) eli.this.Os.get(Os);
                    if (dbA.MGA() && dbA.ui() != null && dbA.ui().exists()) {
                        new Object[]{"download music success, ", "file is:", dbA.ui()};
                        if (l != null) {
                            eli.this.Os.remove(Os);
                            eli.this.eli(1, SystemClock.elapsedRealtime() - l.longValue(), -1, null);
                        }
                        try {
                            kb.DbA(dbA.ui());
                        } catch (IOException e) {
                            Xb.Os("MusicCacheManager", e.getMessage());
                        }
                    }
                    if (dbA.MGA() || l == null) {
                        return;
                    }
                    eli.this.eli(0, SystemClock.elapsedRealtime() - l.longValue(), -2, "http response status code isn't 200");
                }

                @Override // com.bytedance.sdk.component.kb.eli.eli
                public void eli(com.bytedance.sdk.component.kb.DbA.Os os, IOException iOException) {
                    Long l = (Long) eli.this.Os.get(os.Os());
                    if (l != null) {
                        eli.this.eli(0, SystemClock.elapsedRealtime() - l.longValue(), -2, "http response status code isn't 200");
                    }
                }
            });
        }
    }

    private boolean Os(String str) {
        return !this.eli.contains(str);
    }

    public void DbA() {
        File eli = eli(dV.eli(), DbA.Os());
        new Object[]{"trimMusicFileCache, dir is ", eli.getAbsolutePath()};
        try {
            this.DbA.eli(eli);
        } catch (IOException e) {
            Xb.eli("MusicCacheManager", "trimFileCache fail", e);
        }
    }

    private File eli(Context context, boolean z) {
        String str;
        String name = new File(CacheDirFactory.getRootDir()).getName();
        if (DbA.Os()) {
            str = name + "/music";
        } else {
            str = name + "//music";
        }
        new Object[]{"cachePath is:", str};
        return kb.eli(context, z, str);
    }

    public void Os() {
        com.bytedance.sdk.openadsdk.Dfc.Os.eli("music_preload_start", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.core.aGH.eli.2
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                aGH eli = aGH.DbA().eli("music_preload_start");
                new Object[]{"report music_preload_start", eli.eli()};
                return eli;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(final int i, final long j, final int i2, final String str) {
        com.bytedance.sdk.openadsdk.Dfc.Os.eli("music_preload_finish", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.core.aGH.eli.3
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", i);
                long j2 = j;
                if (j2 != -1) {
                    jSONObject.put("load_duration", j2);
                }
                aGH DbA = aGH.DbA().eli("music_preload_finish").DbA(jSONObject.toString());
                if (!TextUtils.isEmpty(str)) {
                    DbA.DbA(i2);
                    DbA.MGA(str);
                }
                new Object[]{"report music_preload_finish", DbA.eli()};
                return DbA;
            }
        });
    }

    public void eli(final boolean z) {
        com.bytedance.sdk.openadsdk.Dfc.Os.eli("music_cache", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.core.aGH.eli.4
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", z);
                aGH DbA = aGH.DbA().eli("music_cache").DbA(jSONObject.toString());
                new Object[]{"report music_cache", DbA.eli()};
                return DbA;
            }
        });
    }
}
