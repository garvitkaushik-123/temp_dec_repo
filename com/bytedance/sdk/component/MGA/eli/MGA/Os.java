package com.bytedance.sdk.component.MGA.eli.MGA;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.MGA.eli.wC;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os implements DbA {
    private final ui DbA;
    private final Context eli;

    public Os(Context context, ui uiVar) {
        this.eli = context;
        this.DbA = uiVar;
    }

    public Context eli() {
        Context context = this.eli;
        return context == null ? wC.kb().MGA() : context;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.MGA.DbA
    public void eli(String str, List<String> list, boolean z, Map<String, String> map, int i, String str2) {
        com.bytedance.sdk.component.MGA.eli.ui aqO = wC.kb().aqO();
        if (aqO == null || wC.kb().MGA() == null || aqO.aGH() == null || !aqO.Os() || list == null || list.size() == 0) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            aqO.aGH().execute(new eli(new aGH(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), it.next(), z, i, str2), str, map));
        }
    }

    @Override // com.bytedance.sdk.component.MGA.eli.MGA.DbA
    public Runnable eli(final aGH agh, final String str, final Map<String, String> map) {
        if (agh == null || TextUtils.isEmpty(agh.eli())) {
            return null;
        }
        return new Runnable() { // from class: com.bytedance.sdk.component.MGA.eli.MGA.Os.1
            @Override // java.lang.Runnable
            public void run() {
                if (Os.this.DbA.eli(agh.eli()) != null) {
                    new eli(agh, str, map).run();
                }
            }
        };
    }

    @Override // com.bytedance.sdk.component.MGA.eli.MGA.DbA
    public void eli(final String str, final boolean z) {
        com.bytedance.sdk.component.MGA.eli.ui aqO = wC.kb().aqO();
        if (aqO == null || wC.kb().MGA() == null || !aqO.Os()) {
            return;
        }
        com.bytedance.sdk.component.MGA.eli.ui.ui uiVar = new com.bytedance.sdk.component.MGA.eli.ui.ui("trackFailedUrls") { // from class: com.bytedance.sdk.component.MGA.eli.MGA.Os.2
            @Override // java.lang.Runnable
            public void run() {
                Os.this.eli(Os.this.DbA.eli(), str, z);
            }
        };
        uiVar.eli(1);
        if (aqO.aGH() != null) {
            aqO.aGH().execute(uiVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(List<aGH> list, String str, boolean z) {
        String str2;
        if (list == null || list.size() == 0) {
            return;
        }
        com.bytedance.sdk.component.MGA.eli.ui aqO = wC.kb().aqO();
        for (aGH agh : list) {
            if (aqO == null || aqO.aGH() == null) {
                str2 = str;
            } else {
                agh.eli(z);
                str2 = str;
                aqO.aGH().execute(new eli(agh, str2, null));
            }
            str = str2;
        }
    }

    private class eli extends com.bytedance.sdk.component.MGA.eli.ui.ui {
        private final aGH DbA;
        private final String Os;
        private final Map<String, String> aGH;

        private eli(aGH agh, String str, Map<String, String> map) {
            super("AdsStats");
            this.DbA = agh;
            this.Os = str;
            this.aGH = map;
        }

        private String Os(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.contains("{TS}") || str.contains("__TS__")) {
                long currentTimeMillis = System.currentTimeMillis();
                str = str.replace("{TS}", String.valueOf(currentTimeMillis)).replace("__TS__", String.valueOf(currentTimeMillis));
            }
            return ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.Os)) ? str.replace("{UID}", this.Os).replace("__UID__", this.Os) : str;
        }

        boolean eli(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("http://") || str.startsWith("https://");
        }

        String DbA(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return str.replace("[ss_random]", String.valueOf(Os.Os().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
            } catch (Exception unused) {
                return str;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.MGA.eli.ui.aGH agh;
            com.bytedance.sdk.component.MGA.eli.ui aqO = wC.kb().aqO();
            if (aqO == null || wC.kb().MGA() == null || !aqO.Os() || !eli(this.DbA.DbA())) {
                return;
            }
            if (this.DbA.aGH() >= aqO.Os(this.DbA.MGA())) {
                Os.this.DbA.Os(this.DbA);
                return;
            }
            try {
                aqO.NU();
                if (this.DbA.du()) {
                    Os.this.DbA.eli(this.DbA);
                }
                if (aqO.eli(Os.this.eli())) {
                    long currentTimeMillis = System.currentTimeMillis();
                    String DbA = this.DbA.DbA();
                    if (aqO.MGA() == 0) {
                        DbA = Os(this.DbA.DbA());
                        if (this.DbA.Os()) {
                            DbA = DbA(DbA);
                        }
                    }
                    com.bytedance.sdk.component.MGA.eli.ui.Os aAs = aqO.aAs();
                    if (aAs == null) {
                        return;
                    }
                    aAs.eli("User-Agent", aqO.FC());
                    aAs.eli("csj_client_source_from", "1");
                    if (this.aGH != null) {
                        JSONObject jSONObject = new JSONObject();
                        for (Map.Entry<String, String> entry : this.aGH.entrySet()) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                        aAs.eli("csj_extra_info", jSONObject.toString());
                    }
                    aAs.eli(DbA);
                    try {
                        agh = aAs.eli();
                        try {
                            aqO.eli(agh.eli());
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        agh = null;
                    }
                    aGH agh2 = this.DbA;
                    agh2.eli(agh2.aGH() + 1);
                    if (agh != null && agh.eli()) {
                        Os.this.DbA.Os(this.DbA);
                        this.DbA.DbA();
                        aqO.eli(true, 200, System.currentTimeMillis() - currentTimeMillis, this.DbA);
                        return;
                    }
                    if (agh != null) {
                        this.DbA.DbA(agh.DbA());
                        this.DbA.Os(agh.Os());
                    }
                    if (agh != null && agh.DbA() == 8848) {
                        agh.Os();
                        Os.this.DbA.Os(this.DbA);
                    } else {
                        this.DbA.DbA();
                        if (this.DbA.aGH() >= aqO.Os(this.DbA.MGA())) {
                            Os.this.DbA.Os(this.DbA);
                            this.DbA.DbA();
                        } else {
                            Os.this.DbA.DbA(this.DbA);
                        }
                    }
                    aqO.eli(false, this.DbA.wC(), System.currentTimeMillis() - currentTimeMillis, this.DbA);
                }
            } catch (Throwable unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Random Os() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }
}
