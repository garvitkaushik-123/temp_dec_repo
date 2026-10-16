package com.mbridge.msdk.click;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.widget.Toast;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.activity.MBCommonActivity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.e0;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.setting.b;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: CommonClickUtil.java */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    static Handler f4037a = new a(Looper.getMainLooper());

    /* compiled from: CommonClickUtil.java */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            String str2;
            String str3;
            super.handleMessage(message);
            try {
                if (message.what == 1000) {
                    int i = message.arg1;
                    int i2 = message.arg2;
                    Bundle data = message.getData();
                    if (data != null) {
                        String string = data.getString("rid");
                        String string2 = data.getString("rid_n");
                        str3 = data.getString("cid");
                        str = string;
                        str2 = string2;
                    } else {
                        str = "";
                        str2 = str;
                        str3 = str2;
                    }
                    new com.mbridge.msdk.foundation.same.report.h(com.mbridge.msdk.foundation.controller.c.m().d()).a(i, i2, str, str2, str3);
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* compiled from: CommonClickUtil.java */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4038a;
        final /* synthetic */ String b;

        b(Context context, String str) {
            this.f4038a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = e0.class.getMethod("mia", Context.class, String.class);
                Context context = this.f4038a;
                if (context != null) {
                    method.invoke(null, context, this.b);
                } else {
                    p0.b("CommonClickUtil", "Context is null");
                }
            } catch (Throwable th) {
                p0.b("CommonClickUtil", th.getMessage());
            }
        }
    }

    public static boolean a(CampaignEx campaignEx) {
        return d.a(campaignEx);
    }

    public static void b(Context context, String str) {
        Intent launchIntentForPackage;
        List<ResolveInfo> queryIntentActivities;
        ResolveInfo next;
        try {
            if (TextUtils.isEmpty(str) || !a(context, str) || (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str)) == null || (queryIntentActivities = context.getPackageManager().queryIntentActivities(launchIntentForPackage, 0)) == null || queryIntentActivities.size() <= 0 || (next = queryIntentActivities.iterator().next()) == null) {
                return;
            }
            ActivityInfo activityInfo = next.activityInfo;
            ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            if (com.mbridge.msdk.util.b.a()) {
                Toast.makeText(context, "The app connot start up", 0).show();
            }
            e.printStackTrace();
        }
    }

    public static void c(Context context, String str) {
        if (str == null || context == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveActivity != null) {
                ActivityInfo activityInfo = resolveActivity.activityInfo;
                intent.setClassName(activityInfo.packageName, activityInfo.name);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent2.addFlags(268435456);
                context.startActivity(intent2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean d(Context context, String str) {
        Intent intent;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            if (parse.getScheme().equals("intent")) {
                intent = Intent.parseUri(str, 1);
            } else if (parse.getScheme().equals("android-app")) {
                intent = Intent.parseUri(str, 2);
            } else {
                intent = new Intent("android.intent.action.VIEW", parse);
                intent.setData(parse);
            }
            if (intent == null) {
                return false;
            }
            intent.setComponent(null);
            intent.setSelector(null);
            if (a(context, intent)) {
                return true;
            }
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            p0.b("CommonClickUtil", th.getMessage(), th);
            return false;
        }
    }

    public static void e(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            int i = MBCommonActivity.e;
            Intent intent = new Intent(context, (Class<?>) MBCommonActivity.class);
            intent.putExtra("url", str);
            if (!(context instanceof ContextThemeWrapper)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        } catch (ClassNotFoundException e) {
            p0.b("CommonClickUtil", e.getMessage());
        } catch (Throwable th) {
            p0.b("CommonClickUtil", th.getMessage());
        }
    }

    public static String a(String str, String str2, String str3) {
        Map<String, b.a> l;
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String host = Uri.parse(str).getHost();
            com.mbridge.msdk.setting.g d = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d == null || (l = d.l()) == null || TextUtils.isEmpty(host)) {
                return str;
            }
            Iterator<Map.Entry<String, b.a>> it = l.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (!TextUtils.isEmpty(key) && host.contains(key)) {
                    b.a aVar = l.get(key);
                    return aVar != null ? a(a(a(a(str, aVar.a(), String.valueOf(l0.m(com.mbridge.msdk.foundation.controller.c.m().d()))), aVar.b(), String.valueOf(l0.n(com.mbridge.msdk.foundation.controller.c.m().d()))), aVar.c(), str2), aVar.d(), str3) : str;
                }
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private static String a(String str, List<String> list, String str2) {
        if (list != null) {
            for (String str3 : list) {
                if (!TextUtils.isEmpty(str3)) {
                    str = str.replaceAll(str3, str2);
                }
            }
        }
        return str;
    }

    public static boolean a(Context context, String str) {
        if (str != null && !"".equals(str)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 8192);
                if (packageInfo != null) {
                    return str.equals(packageInfo.packageName);
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean a(Context context, Intent intent) {
        try {
        } catch (Throwable th) {
            p0.b("CommonClickUtil", th.getMessage(), th);
        }
        if (context instanceof Activity) {
            context.startActivity(intent);
            return true;
        }
        if (com.mbridge.msdk.foundation.controller.c.m().f() != null) {
            Context f = com.mbridge.msdk.foundation.controller.c.m().f();
            if (!(f instanceof Activity)) {
                return false;
            }
            f.startActivity(intent);
            return true;
        }
        return false;
    }

    public static void a(Context context, int i, String str) {
        if (i == 0) {
            return;
        }
        try {
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new b(context, str));
        } catch (Throwable th) {
            p0.b("CommonClickUtil", th.getMessage());
        }
    }
}
