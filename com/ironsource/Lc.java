package com.ironsource;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class Lc {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2943a = "com.google.market";
    public static final String b = "com.android.vending";
    public static final String c = "isInstalled";
    private static final String d = "Lc";
    private static final ArrayList<String> e = new a();

    class a extends ArrayList<String> {
        a() {
            add(Lc.f2943a);
            add("com.android.vending");
        }
    }

    class b extends JSONObject {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f2944a;

        b(boolean z) throws JSONException {
            this.f2944a = z;
            put("isInstalled", z);
        }
    }

    private enum c {
        GOOGLE_PLAY(2, new String[]{"com.android.vending"}),
        GOOGLE_MARKET(4, new String[]{Lc.f2943a}),
        SAMSUNG(5, new String[]{"com.sec.android.app.samsungapps"}),
        AMAZON(6, new String[]{"com.amazon.venezia"}),
        HUAWEI(7, new String[]{"com.huawei.appmarket"});

        private static final Map<String, c> h = new HashMap();

        /* renamed from: a, reason: collision with root package name */
        private final int f2945a;
        private final String[] b;

        static {
            for (c cVar : values()) {
                for (String str : cVar.d()) {
                    h.put(str, cVar);
                }
            }
        }

        c(int i2, String[] strArr) {
            this.f2945a = i2;
            this.b = strArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ArrayList<String> b() {
            return new ArrayList<>(h.keySet());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int c() {
            return this.f2945a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String[] d() {
            return this.b;
        }
    }

    private static JSONObject a(Context context) {
        return a(context, e);
    }

    private static ArrayList<String> b(Context context) {
        List<ApplicationInfo> H = C3334ub.U().i().H(context);
        ArrayList<String> arrayList = new ArrayList<>();
        for (ApplicationInfo applicationInfo : H) {
            if (applicationInfo != null) {
                arrayList.add(applicationInfo.packageName.toLowerCase(Locale.getDefault()));
            }
        }
        return arrayList;
    }

    public static Integer c(Context context) {
        JSONObject a2 = a(context, c.b());
        int i = 0;
        for (c cVar : c.values()) {
            String[] d2 = cVar.d();
            int length = d2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                JSONObject optJSONObject = a2.optJSONObject(d2[i2]);
                if (optJSONObject != null && optJSONObject.optBoolean("isInstalled")) {
                    i = (int) (i + Math.pow(2.0d, r5.c() - 1));
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i);
    }

    public static boolean d(Context context) {
        JSONObject a2 = a(context);
        Iterator<String> keys = a2.keys();
        while (keys.hasNext()) {
            JSONObject optJSONObject = a2.optJSONObject(keys.next());
            if (optJSONObject != null && optJSONObject.optBoolean("isInstalled")) {
                return true;
            }
        }
        return false;
    }

    private static JSONObject a(Context context, ArrayList<String> arrayList) {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList<String> b2 = b(context);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                jSONObject.put(next, a(b2.contains(next.trim().toLowerCase(Locale.getDefault()))));
            }
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            Log.d(d, "Error while extracting packages installation data");
        }
        return jSONObject;
    }

    private static JSONObject a(boolean z) throws JSONException {
        return new b(z);
    }
}
