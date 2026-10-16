package com.mbridge.msdk.foundation.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.activity.MBCommonActivity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.out.BaseTrackingListener;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import io.ktor.util.date.GMTDateParser;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: SameSDKTool.java */
/* loaded from: classes6.dex */
public class t0 extends w {

    /* renamed from: a, reason: collision with root package name */
    public static char[] f4381a = {'a', 'n', GMTDateParser.DAY_OF_MONTH, 'r', 'o', 'i', GMTDateParser.DAY_OF_MONTH, 'c', 'o', 'n', 't', 'e', 'n', 't', 'p', GMTDateParser.MINUTES, 'g', 'e', 't', 'C', 'o', 'n', 't', 'e', 'x', 't'};
    public static boolean b = false;
    public static LinearLayout c;

    /* compiled from: SameSDKTool.java */
    public static class a {
        public static boolean a(Context context, String str, NativeListener.NativeTrackingListener nativeTrackingListener) {
            try {
                List<ResolveInfo> a2 = a(context);
                if (a2 != null && a2.size() > 0) {
                    String a3 = a(str);
                    if (TextUtils.isEmpty(a3)) {
                        return false;
                    }
                    Intent b = b(context);
                    b.setData(Uri.parse(a3));
                    b.addFlags(268435456);
                    Iterator<ResolveInfo> it = a2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (it.next().activityInfo.packageName.equals("com.android.vending")) {
                            b.setPackage("com.android.vending");
                            break;
                        }
                    }
                    context.startActivity(b);
                    t0.a(nativeTrackingListener);
                    return true;
                }
                return false;
            } catch (Throwable th) {
                p0.b("SDKUtil", Log.getStackTraceString(th));
                return false;
            }
        }

        public static Intent b(Context context) {
            return new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.package.name"));
        }

        public static boolean c(String str) {
            Uri parse;
            try {
                if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || TextUtils.isEmpty(parse.getHost())) {
                    return false;
                }
                if (parse.getHost().equals("play.google.com")) {
                    return true;
                }
                return parse.getHost().equals("market.android.com");
            } catch (Throwable th) {
                p0.b("SDKUtil", Log.getStackTraceString(th));
            }
            return false;
        }

        public static boolean d(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return Uri.parse(str).getScheme().equals("market");
            } catch (Throwable th) {
                p0.b("SDKUtil", Log.getStackTraceString(th));
                return false;
            }
        }

        public static boolean b(String str) {
            return d(str) || c(str);
        }

        public static List<ResolveInfo> a(Context context) {
            try {
                return context.getPackageManager().queryIntentActivities(b(context), 0);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static String a(String str) {
            if (d(str)) {
                return str;
            }
            if (!c(str)) {
                return null;
            }
            return "market://" + str.substring(str.indexOf("details?id="));
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(com.mbridge.msdk.foundation.same.directory.e.a(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_IMG), b(str)).getAbsolutePath();
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : str.lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING) == -1 ? str.hashCode() + "" : (str.hashCode() + str.substring(str.lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING) + 1).hashCode()) + "";
    }

    public static void a(Context context, String str, NativeListener.NativeTrackingListener nativeTrackingListener) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            boolean z = queryIntentActivities.size() > 0;
            if (!str.startsWith("market://")) {
                if (str.startsWith("https://play.google.com/")) {
                    a(context, "market://details?id=" + str.replace("https://play.google.com/store/apps/details?id=", ""), nativeTrackingListener);
                }
            } else {
                if (!z) {
                    a(context, "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", ""), (BaseTrackingListener) nativeTrackingListener);
                    return;
                }
                Iterator<ResolveInfo> it = queryIntentActivities.iterator();
                while (it.hasNext()) {
                    if (it.next().activityInfo.packageName.equals("com.android.vending")) {
                        intent.setClassName("com.android.vending", "com.android.vending.AssetBrowserActivity");
                        break;
                    }
                }
                try {
                    context.startActivity(intent);
                    a(nativeTrackingListener);
                } catch (Exception unused) {
                    a(context, "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", ""), (BaseTrackingListener) nativeTrackingListener);
                }
            }
        } catch (Exception e) {
            p0.b("SDKUtil", e.getMessage());
        }
    }

    public static void b(Campaign campaign, ViewGroup viewGroup) {
        a(campaign, viewGroup, 0, 0);
    }

    public static void a(Campaign campaign, ViewGroup viewGroup) {
        if (campaign != null) {
            CampaignEx campaignEx = (CampaignEx) campaign;
            if (campaignEx.getLinkType() == 8 && campaignEx.getAabEntity() != null && campaignEx.getAabEntity().getHlp() == 1) {
                if (viewGroup == null) {
                    p0.d("SDKUtil", "hide linkType==8 loading view failed. viewGroup is null");
                    return;
                }
                try {
                    LinearLayout linearLayout = c;
                    if (linearLayout == null) {
                        return;
                    }
                    viewGroup.removeView(linearLayout);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(Context context, String str, BaseTrackingListener baseTrackingListener) {
        a(context, str, baseTrackingListener, (CampaignEx) null, new ArrayList());
    }

    public static void a(Context context, String str, CampaignEx campaignEx, NativeListener.NativeTrackingListener nativeTrackingListener, List<String> list) {
        Intent intent;
        if (context == null) {
            return;
        }
        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        if (list != null) {
            list.add("web_view");
        }
        if (b) {
            a(context, str, nativeTrackingListener, campaignEx, list);
            return;
        }
        try {
            int i = MBCommonActivity.e;
            intent = new Intent(context, (Class<?>) MBCommonActivity.class);
        } catch (Exception unused) {
            eVar.a("result", 2);
            a(context, str, nativeTrackingListener, campaignEx, list);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (a.d(str)) {
            str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
        }
        intent.putExtra("url", str);
        p0.c("url", "webview url = " + str);
        intent.setFlags(268435456);
        intent.putExtra("mvcommon", campaignEx);
        context.startActivity(intent);
        eVar.a("result", 1);
        eVar.a("type", 9);
        if (list != null) {
            eVar.a("click_path", list.toString());
        }
        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000150", campaignEx, eVar);
    }

    public static void a(Context context, String str, BaseTrackingListener baseTrackingListener, CampaignEx campaignEx, List<String> list) {
        if (str == null || context == null) {
            return;
        }
        if (list != null) {
            list.add("browser");
        }
        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        try {
            if (a.d(str)) {
                str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setComponent(null);
            intent.setSelector(null);
            intent.addFlags(268435456);
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveActivity != null) {
                ActivityInfo activityInfo = resolveActivity.activityInfo;
                intent.setClassName(activityInfo.packageName, activityInfo.name);
            }
            context.startActivity(intent);
            a(baseTrackingListener);
            eVar.a("result", 1);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent2.addFlags(268468224);
                context.startActivity(intent2);
                a(baseTrackingListener);
                eVar.a("result", 1);
            } catch (Exception e2) {
                e2.printStackTrace();
                eVar.a("result", 2);
            }
        }
        try {
            eVar.a("type", 5);
            if (list != null) {
                eVar.a("click_path", list.toString());
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000150", campaignEx, eVar);
        } catch (Exception unused) {
        }
    }

    public static void a(BaseTrackingListener baseTrackingListener) {
        if (baseTrackingListener instanceof NativeListener.TrackingExListener) {
            ((NativeListener.TrackingExListener) baseTrackingListener).onLeaveApp();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, String str, CampaignEx campaignEx, com.mbridge.msdk.click.a aVar, BaseTrackingListener baseTrackingListener, List<String> list) {
        CampaignEx campaignEx2;
        BrowserView browserView;
        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        eVar.a("type", 9);
        try {
            browserView = new BrowserView(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx);
            browserView.setLayoutParams(new LinearLayout.LayoutParams(l0.n(context), l0.m(context)));
            campaignEx2 = campaignEx;
        } catch (Exception e) {
            e = e;
            campaignEx2 = campaignEx;
        }
        try {
            browserView.setListener(new com.mbridge.msdk.foundation.webview.a(context, campaignEx2, aVar, browserView, baseTrackingListener));
            browserView.loadUrl(str);
            eVar.a("result", "1");
        } catch (Exception e2) {
            e = e2;
            p0.b("SDKUtil", e.getMessage());
            eVar.a("result", "2");
            if (list != null) {
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000150", campaignEx2, eVar);
        }
        if (list != null) {
            eVar.a("click_path", list.toString());
        }
        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000150", campaignEx2, eVar);
    }

    public static void a(Campaign campaign, ViewGroup viewGroup, int i, int i2) {
        if (campaign != null) {
            CampaignEx campaignEx = (CampaignEx) campaign;
            if (campaignEx.getLinkType() == 8 && campaignEx.getAabEntity() != null && campaignEx.getAabEntity().getHlp() == 1) {
                if (viewGroup == null) {
                    p0.d("SDKUtil", "show linkType==8 loading view failed. viewGroup is null");
                    return;
                }
                try {
                    if (c == null) {
                        Context d = com.mbridge.msdk.foundation.controller.c.m().d();
                        if (d instanceof Activity) {
                            c = (LinearLayout) LayoutInflater.from(d.getApplicationContext()).inflate(h0.a(d.getApplicationContext(), "mbridge_cm_loading_layout", "layout"), (ViewGroup) null);
                        } else {
                            c = (LinearLayout) LayoutInflater.from(d).inflate(h0.a(d, "mbridge_cm_loading_layout", "layout"), (ViewGroup) null);
                        }
                    }
                    int min = Math.min(viewGroup.getWidth(), viewGroup.getHeight());
                    int min2 = Math.min(Math.max(min / 4, 70), min);
                    if (viewGroup instanceof FrameLayout) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(min2, min2);
                        layoutParams.gravity = 17;
                        e1.a(c);
                        viewGroup.addView(c, layoutParams);
                        return;
                    }
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(min2, min2);
                    if (i2 == 0 && i == 0) {
                        layoutParams2.addRule(13);
                    } else {
                        layoutParams2.leftMargin = i2;
                        layoutParams2.topMargin = i;
                    }
                    e1.a(c);
                    viewGroup.addView(c, layoutParams2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
