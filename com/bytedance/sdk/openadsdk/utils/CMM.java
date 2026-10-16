package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsSession;
import com.bytedance.sdk.openadsdk.activity.TTBaseActivity;
import com.bytedance.sdk.openadsdk.core.act.AdActAction;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class CMM {
    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.Dfc.eli.DbA DbA(String str, int i, com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        com.bytedance.sdk.openadsdk.Dfc.eli.DbA dbA = new com.bytedance.sdk.openadsdk.Dfc.eli.DbA();
        dbA.eli(str);
        dbA.eli(evVar);
        dbA.DbA(dZ.eli(evVar));
        dbA.eli(i);
        dbA.eli(false);
        dbA.DbA(evVar.yw());
        return dbA;
    }

    public static boolean eli(Context context, String str, com.bytedance.sdk.openadsdk.core.model.ev evVar, String str2) {
        final String str3;
        final com.bytedance.sdk.openadsdk.core.model.ev evVar2;
        final String str4;
        if (context instanceof Activity) {
            if (!eli((Activity) context)) {
                context = null;
            }
        } else {
            Activity DbA = com.bytedance.sdk.openadsdk.core.Dfc.eli().ui().DbA();
            if (DbA != null && eli(DbA)) {
                context = DbA;
            }
        }
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.dV.eli();
        }
        final Context context2 = context;
        if (context2 == null) {
            return false;
        }
        final String eli = dZ.eli(evVar);
        if (!com.bytedance.sdk.component.utils.nGm.eli(str)) {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(DbA(str2, 5, evVar));
            return false;
        }
        final String DbA2 = com.bytedance.sdk.openadsdk.core.model.ev.DbA(context2, evVar);
        if (!TextUtils.isEmpty(DbA2)) {
            try {
                final CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setUrlBarHidingEnabled(false);
                builder.setShareState(2);
                str3 = str;
                evVar2 = evVar;
                str4 = str2;
                try {
                    new AdActAction(context2, evVar, str2, str).eli(new AdActAction.BindCustomTabsServiceCallback() { // from class: com.bytedance.sdk.openadsdk.utils.CMM.1
                        @Override // com.bytedance.sdk.openadsdk.core.act.AdActAction.BindCustomTabsServiceCallback
                        public void onBindSuccess(CustomTabsSession customTabsSession) {
                            if (customTabsSession != null) {
                                try {
                                    CustomTabsIntent.Builder.this.setSession(customTabsSession);
                                } catch (Throwable th) {
                                    String message = th.getMessage();
                                    com.bytedance.sdk.component.utils.Xb.Os("OpenUtils", message);
                                    com.bytedance.sdk.openadsdk.Dfc.eli.DbA DbA3 = CMM.DbA(str4, 13, evVar2);
                                    DbA3.Os(message);
                                    com.bytedance.sdk.openadsdk.aGH.Os.eli(DbA3);
                                    CMM.DbA(context2, str3, evVar2, str4, eli);
                                    return;
                                }
                            }
                            CustomTabsIntent build = CustomTabsIntent.Builder.this.build();
                            if (!(context2 instanceof Activity)) {
                                build.intent.addFlags(268435456);
                            }
                            com.bytedance.sdk.openadsdk.core.act.Os.eli(context2, DbA2, build, Uri.parse(str3));
                            Context context3 = context2;
                            if (context3 instanceof TTBaseActivity) {
                                ((TTBaseActivity) context3).Os(true);
                            }
                            com.bytedance.sdk.openadsdk.Dfc.eli.DbA DbA4 = CMM.DbA(str4, 100, evVar2);
                            DbA4.eli(true);
                            DbA4.DbA(8);
                            com.bytedance.sdk.openadsdk.aGH.Os.eli(DbA4);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.act.AdActAction.BindCustomTabsServiceCallback
                        public void onBindFail(int i, String str5) {
                            com.bytedance.sdk.openadsdk.Dfc.eli.DbA DbA3 = CMM.DbA(str4, i, evVar2);
                            DbA3.Os(str5);
                            com.bytedance.sdk.openadsdk.aGH.Os.eli(DbA3);
                            CMM.DbA(context2, str3, evVar2, str4, eli);
                        }
                    });
                    return true;
                } catch (Throwable th) {
                    th = th;
                    String message = th.getMessage();
                    com.bytedance.sdk.component.utils.Xb.Os("OpenUtils", message);
                    com.bytedance.sdk.openadsdk.Dfc.eli.DbA DbA3 = DbA(str4, 12, evVar2);
                    DbA3.Os(message);
                    com.bytedance.sdk.openadsdk.aGH.Os.eli(DbA3);
                    return DbA(context2, str3, evVar2, str4, eli);
                }
            } catch (Throwable th2) {
                th = th2;
                str3 = str;
                evVar2 = evVar;
                str4 = str2;
            }
        } else {
            return DbA(context2, str, evVar, str2, eli);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean DbA(Context context, String str, com.bytedance.sdk.openadsdk.core.model.ev evVar, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(str));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            try {
                context.startActivity(intent);
                com.bytedance.sdk.openadsdk.Dfc.eli.DbA DbA = DbA(str2, 100, evVar);
                DbA.eli(true);
                DbA.DbA(2);
                com.bytedance.sdk.openadsdk.aGH.Os.eli(DbA);
                return true;
            } catch (Throwable th) {
                String message = th.getMessage();
                com.bytedance.sdk.openadsdk.Dfc.eli.DbA DbA2 = DbA(str2, 7, evVar);
                DbA2.Os(message);
                DbA2.DbA(2);
                com.bytedance.sdk.openadsdk.aGH.Os.eli(DbA2);
                return false;
            }
        } catch (Throwable th2) {
            String message2 = th2.getMessage();
            com.bytedance.sdk.openadsdk.Dfc.eli.DbA DbA3 = DbA(str2, 6, evVar);
            DbA3.Os(message2);
            DbA3.DbA(2);
            com.bytedance.sdk.openadsdk.aGH.Os.eli(DbA3);
            return false;
        }
    }

    public static boolean DbA(Context context, String str, com.bytedance.sdk.openadsdk.core.model.ev evVar, String str2) {
        if (context instanceof Activity) {
            if (!eli((Activity) context)) {
                context = null;
            }
        } else {
            Activity DbA = com.bytedance.sdk.openadsdk.core.Dfc.eli().ui().DbA();
            if (DbA != null && eli(DbA)) {
                context = DbA;
            }
        }
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.dV.eli();
        }
        Context context2 = context;
        if (context2 == null || !eli(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        HashMap hashMap = new HashMap();
        hashMap.put("deeplink_url", str);
        hashMap.put("jsb_deeplink", 1);
        if (com.bytedance.sdk.openadsdk.QX.eli.eli.Os.eli()) {
            return com.bytedance.sdk.openadsdk.QX.eli.eli.Os.eli(context2, str, evVar, dZ.DbA(evVar), hashMap, true);
        }
        try {
            if (!(context2 instanceof Activity)) {
                intent.addFlags(268435456);
            }
            com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, str2, "open_url_app", hashMap);
            context2.startActivity(intent);
            com.bytedance.sdk.openadsdk.aGH.NU.eli().eli(hashMap).eli(evVar, str2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean eli(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static boolean eli(Activity activity) {
        return (activity == null || activity.isDestroyed() || activity.isFinishing()) ? false : true;
    }
}
