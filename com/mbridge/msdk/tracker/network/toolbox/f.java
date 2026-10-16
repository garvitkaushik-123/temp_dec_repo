package com.mbridge.msdk.tracker.network.toolbox;

import com.google.common.net.HttpHeaders;
import com.ironsource.C3040d4;
import com.ironsource.Y1;
import com.mbridge.msdk.tracker.network.b;
import com.mbridge.msdk.tracker.network.c0;
import com.mbridge.msdk.tracker.network.q;
import io.ktor.client.utils.CacheControl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;

/* compiled from: HttpHeaderParser.java */
/* loaded from: classes6.dex */
public class f {
    public static b.a a(q qVar) {
        long j;
        boolean z;
        long j2;
        long j3;
        long j4;
        long j5;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = qVar.c;
        if (map == null) {
            return null;
        }
        String str = map.get(HttpHeaders.DATE);
        long b = str != null ? b(str) : 0L;
        String str2 = map.get(HttpHeaders.CACHE_CONTROL);
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z = false;
            j2 = 0;
            j3 = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals(CacheControl.NO_CACHE) || trim.equals(CacheControl.NO_STORE)) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j3 = Long.parseLong(trim.substring(23));
                } else if (trim.equals(CacheControl.MUST_REVALIDATE) || trim.equals(CacheControl.PROXY_REVALIDATE)) {
                    z = true;
                }
                i++;
            }
            j = 0;
            i = 1;
        } else {
            j = 0;
            z = false;
            j2 = 0;
            j3 = 0;
        }
        String str3 = map.get(HttpHeaders.EXPIRES);
        long b2 = str3 != null ? b(str3) : j;
        String str4 = map.get(HttpHeaders.LAST_MODIFIED);
        long b3 = str4 != null ? b(str4) : j;
        String str5 = map.get("ETag");
        if (i != 0) {
            j5 = currentTimeMillis + (j2 * 1000);
            j4 = z ? j5 : j5 + (j3 * 1000);
        } else {
            j4 = (b <= j || b2 < b) ? j : currentTimeMillis + (b2 - b);
            j5 = j4;
        }
        b.a aVar = new b.a();
        aVar.f4936a = qVar.b;
        aVar.b = str5;
        aVar.f = j5;
        aVar.e = j4;
        aVar.c = b;
        aVar.d = b3;
        aVar.g = map;
        aVar.h = qVar.d;
        return aVar;
    }

    public static long b(String str) {
        try {
            Date parse = a("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str);
            if (parse != null) {
                return parse.getTime();
            }
            return 0L;
        } catch (ParseException e) {
            if ("0".equals(str) || Y1.f.equals(str)) {
                c0.d("Unable to parse dateStr: %s, falling back to 0", str);
            } else {
                c0.a(e, "Unable to parse dateStr: %s, falling back to 0", str);
            }
            return 0L;
        }
    }

    static String a(long j) {
        return a("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j));
    }

    private static SimpleDateFormat a(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static String a(Map<String, String> map, String str) {
        String str2;
        if (map != null && (str2 = map.get("Content-Type")) != null) {
            String[] split = str2.split(";", 0);
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split(C3040d4.i.b, 0);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    public static String a(Map<String, String> map) {
        return a(map, "ISO-8859-1");
    }

    static List<com.mbridge.msdk.tracker.network.g> a(List<com.mbridge.msdk.tracker.network.g> list, b.a aVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<com.mbridge.msdk.tracker.network.g> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<com.mbridge.msdk.tracker.network.g> list2 = aVar.h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (com.mbridge.msdk.tracker.network.g gVar : aVar.h) {
                    if (!treeSet.contains(gVar.a())) {
                        arrayList.add(gVar);
                    }
                }
            }
        } else if (!aVar.g.isEmpty()) {
            for (Map.Entry<String, String> entry : aVar.g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new com.mbridge.msdk.tracker.network.g(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    static Map<String, String> a(b.a aVar) {
        if (aVar == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String str = aVar.b;
        if (str != null) {
            hashMap.put(HttpHeaders.IF_NONE_MATCH, str);
        }
        long j = aVar.d;
        if (j > 0) {
            hashMap.put(HttpHeaders.IF_MODIFIED_SINCE, a(j));
        }
        return hashMap;
    }
}
