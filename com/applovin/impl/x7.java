package com.applovin.impl;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class x7 {

    /* renamed from: a, reason: collision with root package name */
    private static final DateFormat f786a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
    private static final Random b = new Random(System.currentTimeMillis());

    public static void a(p7 p7Var, AppLovinAdLoadListener appLovinAdLoadListener, q7 q7Var, int i, com.applovin.impl.sdk.k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Unable to handle failure. No sdk specified.");
        }
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.failedToReceiveAd(i);
        }
        Set a2 = a(p7Var, kVar);
        if (CollectionUtils.isEmpty(a2)) {
            return;
        }
        a(a2, q7Var, kVar);
    }

    public static boolean b(l7 l7Var) {
        y7 B1;
        List g;
        return (l7Var == null || (B1 = l7Var.B1()) == null || (g = B1.g()) == null || g.isEmpty()) ? false : true;
    }

    public static q7 c(l7 l7Var) {
        if (b(l7Var) || a(l7Var)) {
            return null;
        }
        return q7.GENERAL_WRAPPER_ERROR;
    }

    private static String b() {
        DateFormat dateFormat = f786a;
        dateFormat.setTimeZone(TimeZone.getDefault());
        return dateFormat.format(new Date());
    }

    public static boolean a(l7 l7Var) {
        o7 s1;
        t7 e;
        if (l7Var == null || (s1 = l7Var.s1()) == null || (e = s1.e()) == null) {
            return false;
        }
        return e.c() != null || StringUtils.isValidString(e.b());
    }

    public static boolean b(m8 m8Var) {
        if (m8Var != null) {
            return m8Var.b("Wrapper") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains a wrapper response");
    }

    public static Uri a(String str, long j, Uri uri, q7 q7Var, com.applovin.impl.sdk.k kVar) {
        if (URLUtil.isValidUrl(str)) {
            try {
                String num = Integer.toString(q7Var.b());
                String replace = str.replace("[ERRORCODE]", num).replace("[REASON]", num);
                if (j >= 0) {
                    replace = replace.replace("[CONTENTPLAYHEAD]", a(j));
                }
                if (uri != null) {
                    replace = replace.replace("[ASSETURI]", uri.toString());
                }
                return Uri.parse(replace.replace("[CACHEBUSTING]", a()).replace("[TIMESTAMP]", b()));
            } catch (Throwable th) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().a("VastUtils", "Unable to replace macros in URL string " + str, th);
                }
                kVar.E().a("VastUtils", th);
                return null;
            }
        }
        kVar.O();
        if (com.applovin.impl.sdk.o.a()) {
            kVar.O().b("VastUtils", "Unable to replace macros in invalid URL string.");
        }
        return null;
    }

    private static String a(long j) {
        if (j > 0) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long hours = timeUnit.toHours(j);
            long minutes = timeUnit.toMinutes(j);
            TimeUnit timeUnit2 = TimeUnit.MINUTES;
            return String.format(Locale.US, "%02d:%02d:%02d.000", Long.valueOf(hours), Long.valueOf(minutes % timeUnit2.toSeconds(1L)), Long.valueOf(j % timeUnit2.toSeconds(1L)));
        }
        return "00:00:00.000";
    }

    private static String a() {
        return Integer.toString(b.nextInt(89999999) + 10000000);
    }

    public static void a(Set set, com.applovin.impl.sdk.k kVar) {
        a(set, -1L, (Uri) null, q7.UNSPECIFIED, kVar);
    }

    public static void a(Set set, q7 q7Var, com.applovin.impl.sdk.k kVar) {
        a(set, -1L, (Uri) null, q7Var, kVar);
    }

    public static void a(Set set, long j, Uri uri, q7 q7Var, com.applovin.impl.sdk.k kVar) {
        if (kVar != null) {
            if (set == null || set.isEmpty()) {
                return;
            }
            Iterator it = set.iterator();
            while (it.hasNext()) {
                v7 v7Var = (v7) it.next();
                long j2 = j;
                Uri uri2 = uri;
                q7 q7Var2 = q7Var;
                com.applovin.impl.sdk.k kVar2 = kVar;
                Uri a2 = a(v7Var.c(), j2, uri2, q7Var2, kVar2);
                if (a2 != null) {
                    kVar2.f0().a(com.applovin.impl.sdk.network.d.b().d(a2.toString()).a(false).b(v7Var.d()).a(), false);
                }
                j = j2;
                uri = uri2;
                q7Var = q7Var2;
                kVar = kVar2;
            }
            return;
        }
        throw new IllegalArgumentException("Unable to fire trackers. No sdk specified.");
    }

    public static void a(m8 m8Var, Map map, p7 p7Var, com.applovin.impl.sdk.k kVar) {
        List<m8> a2;
        if (kVar == null) {
            throw new IllegalArgumentException("Unable to render event trackers. No sdk specified.");
        }
        if (m8Var == null) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().b("VastUtils", "Unable to render event trackers; null node provided");
                return;
            }
            return;
        }
        if (map == null) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().b("VastUtils", "Unable to render event trackers; null event trackers provided");
                return;
            }
            return;
        }
        m8 c = m8Var.c("TrackingEvents");
        if (c == null || (a2 = c.a("Tracking")) == null) {
            return;
        }
        for (m8 m8Var2 : a2) {
            String str = (String) m8Var2.a().get("event");
            if (StringUtils.isValidString(str)) {
                v7 a3 = v7.a(m8Var2, p7Var, kVar);
                if (a3 != null) {
                    Set set = (Set) map.get(str);
                    if (set != null) {
                        set.add(a3);
                    } else {
                        HashSet hashSet = new HashSet();
                        hashSet.add(a3);
                        map.put(str, hashSet);
                    }
                }
            } else {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().b("VastUtils", "Could not find event for tracking node = " + m8Var2);
                }
            }
        }
    }

    public static void a(List list, Set set, p7 p7Var, com.applovin.impl.sdk.k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Unable to render trackers. No sdk specified.");
        }
        if (list == null) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().b("VastUtils", "Unable to render trackers; null nodes provided");
                return;
            }
            return;
        }
        if (set == null) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().b("VastUtils", "Unable to render trackers; null trackers provided");
                return;
            }
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            v7 a2 = v7.a((m8) it.next(), p7Var, kVar);
            if (a2 != null) {
                set.add(a2);
            }
        }
    }

    public static boolean a(m8 m8Var) {
        if (m8Var != null) {
            return m8Var.b("InLine") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains an inline response");
    }

    public static String a(p7 p7Var) {
        m8 b2;
        if (p7Var != null) {
            List a2 = p7Var.a();
            int size = p7Var.a().size();
            if (size <= 0 || (b2 = ((m8) a2.get(size - 1)).b("VASTAdTagURI")) == null) {
                return null;
            }
            return b2.d();
        }
        throw new IllegalArgumentException("Unable to get resolution uri string for fetching the next wrapper or inline response in the chain");
    }

    public static String a(m8 m8Var, String str, String str2) {
        m8 c = m8Var.c(str);
        if (c != null) {
            String d = c.d();
            if (StringUtils.isValidString(d)) {
                return d;
            }
        }
        return str2;
    }

    private static Set a(p7 p7Var, com.applovin.impl.sdk.k kVar) {
        List a2;
        if (p7Var == null) {
            return null;
        }
        List<m8> a3 = p7Var.a();
        HashSet hashSet = new HashSet(a3.size());
        for (m8 m8Var : a3) {
            m8 b2 = m8Var.b("Wrapper");
            if (b2 == null) {
                b2 = m8Var.b("InLine");
            }
            if (b2 != null) {
                a2 = b2.a("Error");
            } else {
                a2 = m8Var.a("Error");
            }
            hashSet = a(hashSet, a2, p7Var, kVar);
        }
        kVar.O();
        if (com.applovin.impl.sdk.o.a()) {
            kVar.O().a("VastUtils", "Retrieved " + hashSet.size() + " top level error trackers: " + hashSet);
        }
        return hashSet;
    }

    private static HashSet a(HashSet hashSet, List list, p7 p7Var, com.applovin.impl.sdk.k kVar) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                v7 a2 = v7.a((m8) it.next(), p7Var, kVar);
                if (a2 != null) {
                    hashSet.add(a2);
                }
            }
        }
        return hashSet;
    }
}
