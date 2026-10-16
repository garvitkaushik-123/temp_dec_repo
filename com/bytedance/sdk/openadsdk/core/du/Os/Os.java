package com.bytedance.sdk.openadsdk.core.du.Os;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.vungle.ads.internal.Constants;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.slf4j.Marker;

/* loaded from: classes3.dex */
public class Os {
    private static boolean aGH = false;
    private static SimpleDateFormat eli;
    private final List<String> DbA;
    private final Map<DbA, String> Os;

    public Os(List<String> list, ev evVar) {
        int cK;
        this.DbA = list;
        HashMap hashMap = new HashMap();
        this.Os = hashMap;
        hashMap.put(DbA.CACHEBUSTING, Os());
        hashMap.put(DbA.TIMESTAMP, DbA());
        hashMap.put(DbA.APPBUNDLE, dV.eli().getPackageName());
        hashMap.put(DbA.PLAYERSTATE, "");
        if (evVar != null && ((cK = evVar.cK()) == 3 || cK == 7 || cK == 8)) {
            hashMap.put(DbA.PLAYERSTATE, Constants.TEMPLATE_TYPE_FULLSCREEN);
        }
        hashMap.put(DbA.SERVERSIDE, "0");
    }

    private String DbA() {
        if (eli == null) {
            eli = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.getDefault());
        }
        String format = eli.format(new Date());
        if (!aGH) {
            return format;
        }
        int gG = dZ.gG();
        if (gG >= 0) {
            if (gG < 10) {
                return format + "+0" + gG;
            }
            return format + Marker.ANY_NON_NULL_MARKER + gG;
        }
        if (gG <= -10) {
            return format + gG;
        }
        return format + "-0" + (-gG);
    }

    public List<String> eli() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.DbA) {
            if (!TextUtils.isEmpty(str)) {
                for (DbA dbA : DbA.values()) {
                    String str2 = this.Os.get(dbA);
                    if (str2 == null) {
                        str2 = "";
                    }
                    if (dbA == DbA.__MRC_IMPRESSION_ID__) {
                        str = str.replaceAll(dbA.name(), str2);
                    } else {
                        str = str.replaceAll("\\[" + dbA.name() + "\\]", str2);
                    }
                }
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public Os eli(com.bytedance.sdk.openadsdk.core.du.eli.eli eliVar) {
        if (eliVar != null) {
            this.Os.put(DbA.ERRORCODE, eliVar.eli());
        }
        return this;
    }

    public Os eli(long j) {
        if (j >= 0) {
            String DbA = DbA(j);
            if (!TextUtils.isEmpty(DbA)) {
                this.Os.put(DbA.CONTENTPLAYHEAD, DbA);
            }
        }
        return this;
    }

    public Os eli(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Os.put(DbA.__MRC_IMPRESSION_ID__, str);
        }
        return this;
    }

    public Os DbA(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = URLEncoder.encode(str, "UTF-8");
            } catch (Throwable unused) {
            }
            this.Os.put(DbA.ASSETURI, str);
        }
        return this;
    }

    private String Os() {
        return String.format(Locale.US, "%08d", Long.valueOf(Math.round(Math.random() * 1.0E8d)));
    }

    private String DbA(long j) {
        return String.format(Locale.getDefault(), "%02d:%02d:%02d.%03d", Long.valueOf(TimeUnit.MILLISECONDS.toHours(j)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j) % TimeUnit.HOURS.toMinutes(1L)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) % TimeUnit.MINUTES.toSeconds(1L)), Long.valueOf(j % 1000));
    }
}
