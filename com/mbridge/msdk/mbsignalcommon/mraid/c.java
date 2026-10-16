package com.mbridge.msdk.mbsignalcommon.mraid;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.j0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: MraidUriUtil.java */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, String> f4560a = new ConcurrentHashMap<>();
    private static ArrayList<String> b = new ArrayList<>();

    public static com.mbridge.msdk.mbsignalcommon.windvane.a a(WindVaneWebView windVaneWebView, String str) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.contains("mraid")) {
            return null;
        }
        com.mbridge.msdk.mbsignalcommon.windvane.a aVar = new com.mbridge.msdk.mbsignalcommon.windvane.a();
        aVar.d = j0.a("n+ztLkxpVTzBLkxgHN==");
        aVar.e = parse.getHost();
        if (b.size() == 0) {
            a();
        }
        if (!b.contains(aVar.e) && windVaneWebView != null) {
            a(windVaneWebView.getCampaignId(), aVar.e);
            a.a().b(windVaneWebView, aVar.e);
            a.a().a(windVaneWebView, aVar.e, "Specified command is not implemented");
            return null;
        }
        Set<String> a2 = a(parse);
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str2 : a2) {
                jSONObject.put(str2, parse.getQueryParameter(str2));
            }
            aVar.f = jSONObject.toString();
            return aVar;
        } catch (Exception e) {
            e.printStackTrace();
            return aVar;
        }
    }

    public static String b(String str) {
        if (f4560a.containsKey(str)) {
            return f4560a.get(str);
        }
        return null;
    }

    private static Set<String> a(Uri uri) {
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
            i = indexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    private static void a() {
        for (Method method : b.class.getDeclaredMethods()) {
            b.add(method.getName());
        }
    }

    private static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (f4560a.containsKey(str)) {
            String str3 = f4560a.get(str);
            if (TextUtils.isEmpty(str2) || str3.contains(str2)) {
                return;
            }
            if (str3.length() > 0) {
                str3 = str3.concat(",");
            }
            f4560a.put(str, str3.concat(str2));
            return;
        }
        f4560a.put(str, str2);
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f4560a.remove(str);
    }
}
