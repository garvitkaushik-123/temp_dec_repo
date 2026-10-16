package com.mbridge.msdk.click;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ironsource.D5;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.MIMManager;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.out.BaseTrackingListener;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.LoadingActivity;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: CommonClickControl.java */
/* loaded from: classes6.dex */
public class a {
    public static boolean n = false;
    public static Map<String, Long> o = new HashMap();
    public static Set<String> p = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    private String f4032a;
    private long b;
    private com.mbridge.msdk.foundation.db.g c;
    private Context d;
    private com.mbridge.msdk.click.e e;
    private final com.mbridge.msdk.foundation.same.report.h g;
    private com.mbridge.msdk.setting.g h;
    private final boolean i;
    private boolean l;
    private j m;
    private NativeListener.NativeTrackingListener f = null;
    private boolean j = false;
    private boolean k = true;

    /* compiled from: CommonClickControl.java */
    class b implements g {
        b() {
        }

        @Override // com.mbridge.msdk.click.g
        public void a(Object obj) {
        }

        @Override // com.mbridge.msdk.click.g
        public void a(Object obj, String str) {
        }

        @Override // com.mbridge.msdk.click.g
        public void b(Object obj) {
        }
    }

    /* compiled from: CommonClickControl.java */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f4034a;
        final /* synthetic */ boolean b;
        final /* synthetic */ CampaignEx c;

        c(boolean z, boolean z2, CampaignEx campaignEx) {
            this.f4034a = z;
            this.b = z2;
            this.c = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4034a && !a.n && !a.this.l && MBridgeConstans.NATIVE_SHOW_LOADINGPAGER && !this.b) {
                a.this.d(this.c);
            }
            if (this.f4034a || a.this.f == null || a.n || a.this.l || !MBridgeConstans.NATIVE_SHOW_LOADINGPAGER) {
                return;
            }
            a.this.f.onShowLoading(this.c);
        }
    }

    /* compiled from: CommonClickControl.java */
    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f4036a;
        final /* synthetic */ Campaign b;

        e(boolean z, Campaign campaign) {
            this.f4036a = z;
            this.b = campaign;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4036a && !a.n && MBridgeConstans.NATIVE_SHOW_LOADINGPAGER) {
                a.this.a();
            }
            if (a.this.f == null || a.n || !MBridgeConstans.NATIVE_SHOW_LOADINGPAGER) {
                return;
            }
            a.this.f.onDismissLoading(this.b);
        }
    }

    public a(Context context, String str) {
        this.c = null;
        this.d = null;
        com.mbridge.msdk.setting.g d2 = com.mbridge.msdk.setting.h.b().d(str);
        this.h = d2;
        if (d2 == null) {
            this.h = com.mbridge.msdk.setting.h.b().a();
        }
        this.i = this.h.J0();
        Context applicationContext = context.getApplicationContext();
        this.d = applicationContext;
        this.f4032a = str;
        if (this.c == null) {
            this.c = com.mbridge.msdk.foundation.db.g.a(applicationContext);
        }
        this.g = new com.mbridge.msdk.foundation.same.report.h(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CampaignEx campaignEx) {
        try {
            Intent intent = new Intent(this.d, (Class<?>) LoadingActivity.class);
            intent.setFlags(268435456);
            intent.putExtra(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            this.d.startActivity(intent);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CommonClickControl", "Exception", e2);
            }
        }
    }

    public void c() {
        try {
            this.f = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return;
        }
        try {
            String currentLocalRid = campaignEx.getCurrentLocalRid();
            if (campaignEx.getLocalAllowTrackClick() == 0) {
                try {
                    com.mbridge.msdk.foundation.same.report.metrics.c b2 = com.mbridge.msdk.foundation.same.report.metrics.d.b().b(currentLocalRid);
                    if (b2 != null) {
                        b2.a(b2.o() + "m_check_local_c");
                    }
                } catch (Exception unused) {
                    p0.b("CommonClickControl", "sendClickStateToAnl error");
                }
            }
            com.mbridge.msdk.foundation.same.report.metrics.c b3 = com.mbridge.msdk.foundation.same.report.metrics.d.b().b(currentLocalRid);
            b3.a(campaignEx);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_check_local_c", b3);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CommonClickControl", th.getMessage(), th);
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, boolean z, boolean z2) {
        if (context == null) {
            return;
        }
        new com.mbridge.msdk.click.e(context.getApplicationContext()).a(str, campaignEx, null, str2, z, z2, com.mbridge.msdk.click.retry.a.l);
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, boolean z, boolean z2, int i) {
        if (context == null) {
            return;
        }
        int i2 = TextUtils.isEmpty(str2) ? -1 : str2.startsWith("tcp") ? 1 : 0;
        a(i, campaignEx, i2);
        new com.mbridge.msdk.click.e(context.getApplicationContext()).a(str, campaignEx, new C0321a(i2, str2, i, campaignEx), str2, z, z2, i);
    }

    private static void a(int i, CampaignEx campaignEx, int i2) {
        if (campaignEx != null) {
            try {
                String b2 = b(i);
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("net_ty", Integer.valueOf(i2));
                eVar.a("result", 3);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a(b2, campaignEx, eVar);
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i) {
        if (i == 1) {
            return "2000136";
        }
        if (i == 2) {
            return "2000137";
        }
        if (i == 3) {
            return "2000139";
        }
        if (i == 4) {
            return "2000138";
        }
        return "";
    }

    public boolean b(CampaignEx campaignEx) {
        Long l;
        if (campaignEx == null) {
            return true;
        }
        try {
            if (2 != campaignEx.getLinkType() && 3 != campaignEx.getLinkType()) {
                return true;
            }
            String id = campaignEx.getId();
            Map<String, Long> map = o;
            if (map == null) {
                return true;
            }
            if (map.containsKey(id) && (l = o.get(id)) != null) {
                if (l.longValue() > System.currentTimeMillis() || p.contains(campaignEx.getId())) {
                    return false;
                }
            }
            o.put(campaignEx.getId(), Long.valueOf(System.currentTimeMillis() + (campaignEx.getClickTimeOutInterval() * 1000)));
            return true;
        } catch (Exception e2) {
            if (!MBridgeConstans.DEBUG) {
                return true;
            }
            e2.printStackTrace();
            return true;
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String[] strArr, boolean z, boolean z2) {
        if (context == null || campaignEx == null || TextUtils.isEmpty(str) || strArr == null) {
            return;
        }
        com.mbridge.msdk.click.e eVar = new com.mbridge.msdk.click.e(context.getApplicationContext());
        for (String str2 : strArr) {
            eVar.a(str, campaignEx, new b(), str2, z, z2, com.mbridge.msdk.click.retry.a.l);
        }
    }

    /* compiled from: CommonClickControl.java */
    /* renamed from: com.mbridge.msdk.click.a$a, reason: collision with other inner class name */
    class C0321a implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4033a;
        final /* synthetic */ String b;
        final /* synthetic */ int c;
        final /* synthetic */ CampaignEx d;

        C0321a(int i, String str, int i2, CampaignEx campaignEx) {
            this.f4033a = i;
            this.b = str;
            this.c = i2;
            this.d = campaignEx;
        }

        @Override // com.mbridge.msdk.click.g
        public void a(Object obj) {
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("result", 2);
                eVar.a("net_ty", String.valueOf(this.f4033a));
                if (obj != null && (obj instanceof JumpLoaderResult)) {
                    JumpLoaderResult jumpLoaderResult = (JumpLoaderResult) obj;
                    String str = jumpLoaderResult.getStatusCode() + "";
                    eVar.a("status_code", str);
                    if (str.startsWith("2")) {
                        eVar.a("result", 1);
                    } else {
                        String exceptionMsg = jumpLoaderResult.getExceptionMsg();
                        if (TextUtils.isEmpty(exceptionMsg)) {
                            exceptionMsg = "UNKNOWN EXCEPTION and Status Code is : " + str;
                        }
                        eVar.a("failingURL", b1.d(this.b));
                        eVar.a("reason", exceptionMsg);
                    }
                }
                String b = a.b(this.c);
                if (this.d != null) {
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a(b, this.d, eVar);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("CommonClickControl", e.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.click.g
        public void b(Object obj) {
        }

        @Override // com.mbridge.msdk.click.g
        public void a(Object obj, String str) {
            try {
                String b = a.b(this.c);
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("result", 2);
                if (obj instanceof JumpLoaderResult) {
                    JumpLoaderResult jumpLoaderResult = (JumpLoaderResult) obj;
                    String exceptionMsg = jumpLoaderResult.getExceptionMsg();
                    if (!TextUtils.isEmpty(exceptionMsg)) {
                        str = exceptionMsg;
                    }
                    eVar.a("reason", str);
                    eVar.a("status_code", Integer.valueOf(jumpLoaderResult.getStatusCode()));
                }
                eVar.a("code", "");
                eVar.a("failingURL", b1.d(this.b));
                eVar.a("net_ty", String.valueOf(this.f4033a));
                if (this.d != null) {
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a(b, this.d, eVar);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("CommonClickControl", e.getMessage());
                }
            }
        }
    }

    public void a(String str) {
        this.f4032a = str;
    }

    public void a(NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.f = nativeTrackingListener;
    }

    public void a(j jVar) {
        this.m = jVar;
    }

    public void a(boolean z) {
        this.k = z;
    }

    public void a(CampaignEx campaignEx, NativeListener.NativeAdListener nativeAdListener) {
        if (nativeAdListener != null && campaignEx != null) {
            nativeAdListener.onAdClick(campaignEx);
        }
        a(campaignEx);
    }

    private int b() {
        try {
            com.mbridge.msdk.setting.g gVar = this.h;
            if (gVar != null) {
                return gVar.V();
            }
            return 1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x02b4 A[Catch: all -> 0x03a8, TryCatch #1 {all -> 0x03a8, blocks: (B:4:0x000a, B:9:0x0012, B:11:0x0038, B:13:0x003e, B:14:0x0041, B:15:0x0049, B:18:0x0063, B:20:0x007b, B:22:0x007f, B:23:0x0086, B:25:0x00a5, B:26:0x00ac, B:28:0x00b0, B:29:0x00c8, B:31:0x00d1, B:33:0x00d5, B:34:0x00dc, B:36:0x00ec, B:40:0x00f6, B:42:0x00fc, B:44:0x0102, B:46:0x010e, B:48:0x0112, B:49:0x0119, B:51:0x011d, B:53:0x0127, B:56:0x012e, B:58:0x0132, B:59:0x0139, B:61:0x0158, B:64:0x0161, B:65:0x0173, B:67:0x0179, B:69:0x017d, B:70:0x0184, B:72:0x018e, B:74:0x0194, B:76:0x019a, B:78:0x01a4, B:79:0x01ac, B:81:0x01b0, B:82:0x01b7, B:84:0x01c1, B:86:0x01c7, B:87:0x01ce, B:89:0x01d4, B:91:0x01e0, B:93:0x01ef, B:94:0x01f8, B:96:0x01fc, B:97:0x0203, B:99:0x0209, B:100:0x0212, B:102:0x0216, B:105:0x020f, B:106:0x0223, B:109:0x0233, B:116:0x024a, B:118:0x0254, B:120:0x025c, B:122:0x0264, B:124:0x026d, B:125:0x0274, B:127:0x0282, B:129:0x0289, B:130:0x0290, B:132:0x0294, B:134:0x02a9, B:139:0x02b4, B:141:0x02bc, B:142:0x02bf, B:144:0x02c5, B:146:0x02c9, B:147:0x02cc, B:150:0x02d2, B:152:0x02d8, B:154:0x02e2, B:156:0x02e6, B:158:0x02ea, B:159:0x02ed, B:164:0x030d, B:174:0x02ff, B:176:0x030a, B:178:0x0313, B:180:0x0321, B:185:0x0329, B:186:0x0331, B:187:0x0338, B:189:0x033c, B:190:0x033f, B:193:0x0345, B:195:0x034b, B:197:0x0351, B:201:0x0358, B:203:0x0363, B:205:0x036c, B:207:0x0370, B:209:0x0378, B:210:0x037b, B:212:0x0381, B:214:0x0385, B:215:0x0388, B:217:0x038c, B:219:0x0390, B:220:0x0393, B:222:0x03a0, B:224:0x03a4), top: B:3:0x000a, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0343  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(CampaignEx campaignEx) {
        boolean z;
        String clickURL;
        a aVar = this;
        if (campaignEx == null) {
            return;
        }
        try {
            if (!b(campaignEx)) {
                return;
            }
            c(campaignEx);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000149", campaignEx);
            String noticeUrl = campaignEx.getNoticeUrl();
            com.mbridge.msdk.foundation.db.d a2 = com.mbridge.msdk.foundation.db.d.a(aVar.c);
            a2.a();
            JumpLoaderResult b2 = a2.b(campaignEx.getId(), aVar.f4032a);
            if (b2 != null) {
                if (b2.getNoticeurl() != null) {
                    b2.setNoticeurl(null);
                }
                campaignEx.setJumpResult(b2);
                com.mbridge.msdk.click.b.a(a2, campaignEx, aVar.f4032a);
            }
            ArrayList arrayList = new ArrayList();
            AppletsModel appletsModel = AppletModelManager.getInstance().get(campaignEx);
            if (u0.b(campaignEx)) {
                MIMManager.b().a(campaignEx);
                arrayList.add(CampaignEx.JSON_KEY_DEEP_LINK_URL);
                if (com.mbridge.msdk.click.c.d(aVar.d, campaignEx.getDeepLinkURL())) {
                    NativeListener.NativeTrackingListener nativeTrackingListener = aVar.f;
                    if (nativeTrackingListener != null) {
                        nativeTrackingListener.onStartRedirection(campaignEx, campaignEx.getClickURL());
                    }
                    com.mbridge.msdk.click.b.a(aVar.d, aVar.f4032a, campaignEx, noticeUrl + "&opdptype=1", -1);
                    com.mbridge.msdk.click.b.a(campaignEx);
                    NativeListener.NativeTrackingListener nativeTrackingListener2 = aVar.f;
                    if (nativeTrackingListener2 != null) {
                        nativeTrackingListener2.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                    }
                    aVar.a(campaignEx, 3, 1, arrayList);
                    return;
                }
                noticeUrl = noticeUrl + "&opdptype=0";
                MIMManager.b().b(campaignEx);
            }
            String str = noticeUrl;
            if (campaignEx.getLinkType() == 12) {
                NativeListener.NativeTrackingListener nativeTrackingListener3 = aVar.f;
                if (nativeTrackingListener3 != null) {
                    nativeTrackingListener3.onStartRedirection(campaignEx, campaignEx.getClickURL());
                }
                com.mbridge.msdk.click.b.a(aVar.d, aVar.f4032a, campaignEx, str, -1);
                aVar.a(aVar.d, campaignEx, arrayList);
                NativeListener.NativeTrackingListener nativeTrackingListener4 = aVar.f;
                if (nativeTrackingListener4 != null) {
                    nativeTrackingListener4.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                    return;
                }
                return;
            }
            if (appletsModel != null && appletsModel.isSupportWxScheme()) {
                if (appletsModel.isRequestSuccess()) {
                    if (com.mbridge.msdk.click.c.d(aVar.d, appletsModel.getDeepLink())) {
                        NativeListener.NativeTrackingListener nativeTrackingListener5 = aVar.f;
                        if (nativeTrackingListener5 != null) {
                            nativeTrackingListener5.onStartRedirection(campaignEx, campaignEx.getClickURL());
                        }
                        if (aVar.d != null) {
                            Intent intent = new Intent();
                            intent.setAction("mb_dp_close_broadcast_receiver");
                            try {
                                aVar.d.sendBroadcast(intent);
                            } catch (Exception e2) {
                                if (MBridgeConstans.DEBUG) {
                                    p0.b("CommonClickControl", e2.getMessage());
                                }
                            }
                        }
                        com.mbridge.msdk.click.b.a(aVar.d, aVar.f4032a, campaignEx, str + "&opdptype=1", -1);
                        com.mbridge.msdk.click.b.a(campaignEx);
                        NativeListener.NativeTrackingListener nativeTrackingListener6 = aVar.f;
                        if (nativeTrackingListener6 != null) {
                            nativeTrackingListener6.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                            return;
                        }
                        return;
                    }
                    str = str + "&opdptype=0";
                } else {
                    if (appletsModel.isRequesting()) {
                        NativeListener.NativeTrackingListener nativeTrackingListener7 = aVar.f;
                        if (nativeTrackingListener7 != null) {
                            nativeTrackingListener7.onStartRedirection(campaignEx, campaignEx.getClickURL());
                        }
                        appletsModel.setAppletSchemeCallBack(aVar.a(aVar.f, campaignEx, appletsModel, aVar));
                        return;
                    }
                    if (appletsModel.can(1)) {
                        if (appletsModel.isRequestTimesMaxPerDay()) {
                            if (!TextUtils.isEmpty(appletsModel.getReBuildClickUrl())) {
                                campaignEx.setClickURL(appletsModel.getReBuildClickUrl());
                            }
                        } else {
                            NativeListener.NativeTrackingListener nativeTrackingListener8 = aVar.f;
                            if (nativeTrackingListener8 != null) {
                                nativeTrackingListener8.onStartRedirection(campaignEx, campaignEx.getClickURL());
                            }
                            appletsModel.requestWxAppletsScheme(1, aVar.a(aVar.f, campaignEx, appletsModel, aVar));
                            return;
                        }
                    }
                }
            }
            if (com.mbridge.msdk.util.b.b()) {
                com.mbridge.msdk.click.b.a(aVar.d, aVar.f4032a, campaignEx, str, -1);
            }
            if (!campaignEx.getUserActivation() && com.mbridge.msdk.click.c.a(aVar.d, campaignEx.getPackageName())) {
                com.mbridge.msdk.click.c.b(aVar.d, campaignEx.getPackageName());
                if (com.mbridge.msdk.util.b.a()) {
                    com.mbridge.msdk.click.b.a(aVar.d, aVar.f4032a, campaignEx, str, com.mbridge.msdk.foundation.same.a.N);
                }
                NativeListener.NativeTrackingListener nativeTrackingListener9 = aVar.f;
                if (nativeTrackingListener9 != null) {
                    nativeTrackingListener9.onStartRedirection(campaignEx, campaignEx.getClickURL());
                }
                if (com.mbridge.msdk.util.b.a()) {
                    aVar.a(campaignEx, true, Boolean.TRUE, (List<String>) arrayList);
                } else {
                    aVar.a(campaignEx, true, (Boolean) null, (List<String>) arrayList);
                }
                NativeListener.NativeTrackingListener nativeTrackingListener10 = aVar.f;
                if (nativeTrackingListener10 != null) {
                    nativeTrackingListener10.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                    t0.a(aVar.f);
                    return;
                }
                return;
            }
            int linkType = campaignEx.getLinkType();
            int b3 = aVar.b();
            if (com.mbridge.msdk.util.b.a() && linkType != 3) {
                com.mbridge.msdk.click.b.a(aVar.d, aVar.f4032a, campaignEx, str, -1);
            }
            if (linkType != 8 && linkType != 9 && linkType != 4) {
                z = false;
                clickURL = campaignEx.getClickURL();
                if (TextUtils.isEmpty(clickURL) && (clickURL.startsWith("market://") || clickURL.startsWith("https://play.google.com/"))) {
                    arrayList.add("google_play");
                    NativeListener.NativeTrackingListener nativeTrackingListener11 = aVar.f;
                    if (nativeTrackingListener11 != null) {
                        nativeTrackingListener11.onStartRedirection(campaignEx, campaignEx.getClickURL());
                    }
                    if (t0.a.a(aVar.d, campaignEx.getClickURL(), aVar.f)) {
                        aVar.a(b2, campaignEx, false);
                        NativeListener.NativeTrackingListener nativeTrackingListener12 = aVar.f;
                        if (nativeTrackingListener12 != null) {
                            nativeTrackingListener12.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        }
                        aVar.a(campaignEx, 1, 1, arrayList);
                        return;
                    }
                    aVar.a(b3, campaignEx.getClickURL(), campaignEx, aVar.f, arrayList);
                    aVar.a(b2, campaignEx, false);
                    NativeListener.NativeTrackingListener nativeTrackingListener13 = aVar.f;
                    if (nativeTrackingListener13 != null) {
                        nativeTrackingListener13.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        return;
                    }
                    return;
                }
                if (z) {
                    if (linkType == 2) {
                        if (com.mbridge.msdk.util.b.a()) {
                            aVar.a(campaignEx, false, Boolean.TRUE, (List<String>) arrayList);
                            return;
                        } else {
                            aVar.a(campaignEx, false, (Boolean) null, (List<String>) arrayList);
                            return;
                        }
                    }
                    if (linkType == 3) {
                        arrayList.add("apk");
                        if (com.mbridge.msdk.util.b.a()) {
                            aVar.a(campaignEx, false, Boolean.TRUE, (List<String>) arrayList);
                            aVar.a(campaignEx, 2, 1, arrayList);
                            return;
                        } else {
                            aVar.a(campaignEx, false, (Boolean) null, (List<String>) arrayList);
                            return;
                        }
                    }
                    String clickURL2 = campaignEx.getClickURL();
                    NativeListener.NativeTrackingListener nativeTrackingListener14 = aVar.f;
                    if (nativeTrackingListener14 != null) {
                        nativeTrackingListener14.onStartRedirection(campaignEx, clickURL2);
                    }
                    if (TextUtils.isEmpty(clickURL2)) {
                        NativeListener.NativeTrackingListener nativeTrackingListener15 = aVar.f;
                        if (nativeTrackingListener15 != null) {
                            nativeTrackingListener15.onRedirectionFailed(campaignEx, clickURL2);
                        }
                        aVar.a(b2, campaignEx, true);
                        return;
                    }
                    NativeListener.NativeTrackingListener nativeTrackingListener16 = aVar.f;
                    if (nativeTrackingListener16 != null) {
                        nativeTrackingListener16.onFinishRedirection(campaignEx, clickURL2);
                    }
                    t0.a(aVar.d, clickURL2, aVar.f, campaignEx, arrayList);
                    if (com.mbridge.msdk.util.b.a()) {
                        aVar.a(b2, campaignEx, false);
                        return;
                    } else {
                        aVar.a(b2, campaignEx, true);
                        return;
                    }
                }
                String clickURL3 = campaignEx.getClickURL();
                NativeListener.NativeTrackingListener nativeTrackingListener17 = aVar.f;
                if (nativeTrackingListener17 != null) {
                    nativeTrackingListener17.onStartRedirection(campaignEx, clickURL3);
                }
                if (TextUtils.isEmpty(clickURL3)) {
                    NativeListener.NativeTrackingListener nativeTrackingListener18 = aVar.f;
                    if (nativeTrackingListener18 != null) {
                        nativeTrackingListener18.onRedirectionFailed(campaignEx, clickURL3);
                    }
                    aVar.a(b2, campaignEx, true);
                    return;
                }
                if (linkType == 8) {
                    if (campaignEx.getAabEntity() != null && campaignEx.getAabEntity().getHlp() == 1) {
                        BaseTrackingListener baseTrackingListener = aVar.f;
                        if (baseTrackingListener == null && (baseTrackingListener = aVar.m) != null) {
                            baseTrackingListener.onStartRedirection(campaignEx, clickURL3);
                        }
                        try {
                            t0.a(aVar.d, clickURL3, campaignEx, aVar, baseTrackingListener, arrayList);
                            aVar = aVar;
                        } catch (Throwable th) {
                            th = th;
                            if (MBridgeConstans.DEBUG) {
                            }
                        }
                    } else {
                        t0.a(aVar.d, clickURL3, campaignEx, aVar.f, arrayList);
                        NativeListener.NativeTrackingListener nativeTrackingListener19 = aVar.f;
                        if (nativeTrackingListener19 != null) {
                            nativeTrackingListener19.onFinishRedirection(campaignEx, clickURL3);
                        }
                    }
                    aVar.a(b2, campaignEx, false);
                    return;
                }
                if (linkType == 9) {
                    t0.a(aVar.d, clickURL3, aVar.f, campaignEx, arrayList);
                    aVar.a(b2, campaignEx, false);
                    NativeListener.NativeTrackingListener nativeTrackingListener20 = aVar.f;
                    if (nativeTrackingListener20 != null) {
                        nativeTrackingListener20.onFinishRedirection(campaignEx, clickURL3);
                        return;
                    }
                    return;
                }
                if (linkType == 4) {
                    if (b3 == 2) {
                        t0.a(aVar.d, clickURL3, campaignEx, aVar.f, arrayList);
                    } else {
                        t0.a(aVar.d, clickURL3, aVar.f, campaignEx, arrayList);
                    }
                }
                NativeListener.NativeTrackingListener nativeTrackingListener21 = aVar.f;
                if (nativeTrackingListener21 != null) {
                    nativeTrackingListener21.onFinishRedirection(campaignEx, clickURL3);
                }
                aVar.a(b2, campaignEx, false);
                return;
            }
            z = true;
            clickURL = campaignEx.getClickURL();
            if (TextUtils.isEmpty(clickURL)) {
            }
            if (z) {
            }
        } catch (Throwable th2) {
            th = th2;
            if (MBridgeConstans.DEBUG) {
                return;
            }
            p0.b("CommonClickControl", th.getMessage(), th);
        }
    }

    /* compiled from: CommonClickControl.java */
    class d implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4035a;
        final /* synthetic */ boolean b;
        final /* synthetic */ Boolean c;
        final /* synthetic */ List d;
        final /* synthetic */ boolean e;

        d(CampaignEx campaignEx, boolean z, Boolean bool, List list, boolean z2) {
            this.f4035a = campaignEx;
            this.b = z;
            this.c = bool;
            this.d = list;
            this.e = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0081 A[Catch: all -> 0x00a8, TryCatch #1 {all -> 0x00a8, blocks: (B:7:0x0062, B:9:0x0070, B:10:0x007d, B:12:0x0081, B:14:0x008b, B:15:0x0093), top: B:6:0x0062 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0070 A[Catch: all -> 0x00a8, TryCatch #1 {all -> 0x00a8, blocks: (B:7:0x0062, B:9:0x0070, B:10:0x007d, B:12:0x0081, B:14:0x008b, B:15:0x0093), top: B:6:0x0062 }] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v16 */
        @Override // com.mbridge.msdk.click.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(Object obj) {
            Throwable th;
            CampaignEx campaignEx;
            ?? r0;
            Set<String> set = a.p;
            if (set != null) {
                set.remove(this.f4035a.getId());
            }
            JumpLoaderResult jumpLoaderResult = null;
            if (obj != null) {
                try {
                    if (obj instanceof JumpLoaderResult) {
                        JumpLoaderResult jumpLoaderResult2 = (JumpLoaderResult) obj;
                        try {
                            this.f4035a.setJumpResult(jumpLoaderResult2);
                            a aVar = a.this;
                            aVar.a(this.f4035a, jumpLoaderResult2, this.b, aVar.j, this.c, (List<String>) this.d);
                            if (jumpLoaderResult2.isjumpDone()) {
                                com.mbridge.msdk.click.b.a(com.mbridge.msdk.foundation.db.d.a(a.this.c), this.f4035a, a.this.f4032a);
                            }
                            a.this.a(this.e, this.f4035a);
                            jumpLoaderResult = jumpLoaderResult2;
                        } catch (Throwable th2) {
                            th = th2;
                            jumpLoaderResult = jumpLoaderResult2;
                            p0.b("CommonClickControl", th.getMessage());
                            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                            eVar.a("result", "1");
                            if (jumpLoaderResult != null) {
                            }
                            campaignEx = this.f4035a;
                            if (campaignEx != null) {
                            }
                            r0 = -1;
                            eVar.a("net_ty", Integer.valueOf((int) r0));
                            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000138", this.f4035a, eVar);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar2 = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar2.a("result", "1");
                if (jumpLoaderResult != null) {
                    eVar2.a("status_code", Integer.valueOf(jumpLoaderResult.getStatusCode()));
                }
                campaignEx = this.f4035a;
                if (campaignEx != null) {
                    String clickURL = campaignEx.getClickURL();
                    if (!TextUtils.isEmpty(clickURL)) {
                        r0 = clickURL.startsWith("tcp");
                        eVar2.a("net_ty", Integer.valueOf((int) r0));
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000138", this.f4035a, eVar2);
                    }
                }
                r0 = -1;
                eVar2.a("net_ty", Integer.valueOf((int) r0));
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000138", this.f4035a, eVar2);
            } catch (Throwable th4) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("CommonClickControl", th4.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.click.g
        public void b(Object obj) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0051 A[Catch: all -> 0x0093, TryCatch #0 {all -> 0x0093, blocks: (B:11:0x004d, B:13:0x0051, B:15:0x005b, B:16:0x0063, B:18:0x007a, B:19:0x0087), top: B:10:0x004d }] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x007a A[Catch: all -> 0x0093, TryCatch #0 {all -> 0x0093, blocks: (B:11:0x004d, B:13:0x0051, B:15:0x005b, B:16:0x0063, B:18:0x007a, B:19:0x0087), top: B:10:0x004d }] */
        /* JADX WARN: Type inference failed for: r6v10, types: [int] */
        /* JADX WARN: Type inference failed for: r6v21 */
        /* JADX WARN: Type inference failed for: r6v9 */
        @Override // com.mbridge.msdk.click.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(Object obj, String str) {
            CampaignEx campaignEx;
            ?? r6;
            Set<String> set = a.p;
            if (set != null) {
                set.remove(this.f4035a.getId());
            }
            JumpLoaderResult jumpLoaderResult = null;
            if (obj != null) {
                try {
                    if (obj instanceof JumpLoaderResult) {
                        JumpLoaderResult jumpLoaderResult2 = (JumpLoaderResult) obj;
                        try {
                            a.this.a((JumpLoaderResult) obj, this.f4035a, true);
                            jumpLoaderResult = jumpLoaderResult2;
                        } catch (Throwable th) {
                            th = th;
                            jumpLoaderResult = jumpLoaderResult2;
                            p0.b("CommonClickControl", th.getMessage());
                            campaignEx = this.f4035a;
                            if (campaignEx != null) {
                            }
                            r6 = -1;
                            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                            eVar.a("result", "2");
                            eVar.a("net_ty", Integer.valueOf((int) r6));
                            if (jumpLoaderResult != null) {
                            }
                            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000138", this.f4035a, eVar);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (a.this.f != null) {
                a.this.f.onRedirectionFailed(this.f4035a, str);
            }
            a.this.a(this.e, this.f4035a);
            try {
                campaignEx = this.f4035a;
                if (campaignEx != null) {
                    String clickURL = campaignEx.getClickURL();
                    if (!TextUtils.isEmpty(clickURL)) {
                        r6 = clickURL.startsWith("tcp");
                        com.mbridge.msdk.foundation.same.report.metrics.e eVar2 = new com.mbridge.msdk.foundation.same.report.metrics.e();
                        eVar2.a("result", "2");
                        eVar2.a("net_ty", Integer.valueOf((int) r6));
                        if (jumpLoaderResult != null) {
                            eVar2.a("status_code", Integer.valueOf(jumpLoaderResult.getStatusCode()));
                        }
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000138", this.f4035a, eVar2);
                    }
                }
                r6 = -1;
                com.mbridge.msdk.foundation.same.report.metrics.e eVar22 = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar22.a("result", "2");
                eVar22.a("net_ty", Integer.valueOf((int) r6));
                if (jumpLoaderResult != null) {
                }
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000138", this.f4035a, eVar22);
            } catch (Throwable th3) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("CommonClickControl", th3.getMessage());
                }
            }
        }
    }

    private AppletSchemeCallBack a(NativeListener.NativeTrackingListener nativeTrackingListener, CampaignEx campaignEx, AppletsModel appletsModel, a aVar) {
        return new h(nativeTrackingListener, campaignEx, appletsModel, aVar);
    }

    private void a(Context context, CampaignEx campaignEx, List<String> list) {
        if (context == null) {
            com.mbridge.msdk.foundation.same.report.j.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx, 2, "context is null", this.f4032a);
            return;
        }
        boolean z = l0.D() == 1;
        boolean z2 = l0.D(context) == 1;
        if (z && z2) {
            String ghId = campaignEx.getGhId();
            String ghPath = campaignEx.getGhPath();
            String bindId = campaignEx.getBindId();
            String i = com.mbridge.msdk.foundation.controller.c.m().i();
            if (!TextUtils.isEmpty(ghId)) {
                try {
                    if (!TextUtils.isEmpty(i)) {
                        bindId = i;
                    }
                    Object d2 = l0.d(bindId);
                    Class<?> cls = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
                    Object newInstance = cls.newInstance();
                    cls.getField("userName").set(newInstance, ghId);
                    cls.getField("path").set(newInstance, ghPath);
                    cls.getField("miniprogramType").set(newInstance, cls.getField("MINIPTOGRAM_TYPE_RELEASE").get(null));
                    Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("sendReq", Class.forName("com.tencent.mm.opensdk.modelbase.BaseReq")).invoke(d2, newInstance);
                    com.mbridge.msdk.foundation.same.report.j.a(context, campaignEx, 1, "", this.f4032a);
                    return;
                } catch (Throwable th) {
                    com.mbridge.msdk.foundation.same.report.j.a(context, campaignEx, 2, th.getMessage(), this.f4032a);
                    a(campaignEx, list);
                    return;
                }
            }
            a(campaignEx, list);
            com.mbridge.msdk.foundation.same.report.j.a(context, campaignEx, 2, "ghid is empty", this.f4032a);
            return;
        }
        com.mbridge.msdk.foundation.same.report.j.a(context, campaignEx, 2, "integrated:" + z + "-hasWx:" + z2, this.f4032a);
        a(campaignEx, list);
    }

    private void a(CampaignEx campaignEx, List<String> list) {
        if (b() == 2) {
            t0.a(this.d, campaignEx.getClickURL(), campaignEx, this.f, list);
        } else {
            t0.a(this.d, campaignEx.getClickURL(), this.f, campaignEx, list);
        }
    }

    private void a(CampaignEx campaignEx, boolean z, Boolean bool, List<String> list) {
        boolean z2;
        boolean z3;
        try {
            this.b = System.currentTimeMillis();
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f;
            if (nativeTrackingListener == null || z) {
                z2 = true;
            } else {
                nativeTrackingListener.onStartRedirection(campaignEx, campaignEx.getClickURL());
                z2 = !this.f.onInterceptDefaultLoadingDialog();
            }
            this.l = false;
            boolean z4 = true;
            if (campaignEx.getJumpResult() != null) {
                if (!z) {
                    a(campaignEx, campaignEx.getJumpResult(), true, this.j, bool, list);
                }
                this.l = true;
                this.j = false;
                z4 = false;
            }
            if (!com.mbridge.msdk.foundation.db.d.a(this.c).c(campaignEx.getId(), this.f4032a) || campaignEx.getJumpResult() == null) {
                com.mbridge.msdk.foundation.db.d a2 = com.mbridge.msdk.foundation.db.d.a(this.c);
                a2.a();
                JumpLoaderResult b2 = a2.b(campaignEx.getId(), this.f4032a);
                if (b2 != null && !z) {
                    campaignEx.setJumpResult(b2);
                    if (z4) {
                        a(campaignEx, b2, z4, this.j, bool, list);
                        this.l = true;
                        this.j = false;
                        z3 = false;
                    }
                    z3 = z4;
                } else {
                    if (campaignEx.getClick_mode().equals("6") && !campaignEx.getPackageName().isEmpty() && campaignEx.getLinkType() == 2 && !z) {
                        boolean a3 = t0.a.a(this.d, "market://details?id=" + campaignEx.getPackageName(), this.f);
                        if (list != null) {
                            list.add("google_play");
                        }
                        if (a3) {
                            a(campaignEx, 1, 1, list);
                        }
                        NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f;
                        if (nativeTrackingListener2 != null && z4) {
                            nativeTrackingListener2.onDismissLoading(campaignEx);
                            this.f.onFinishRedirection(campaignEx, null);
                        }
                        this.l = true;
                        z4 = false;
                    }
                    if (z) {
                        this.l = true;
                        this.j = false;
                        z3 = false;
                    }
                    z3 = z4;
                }
                new Handler(Looper.getMainLooper()).post(new c(z2, z, campaignEx));
                com.mbridge.msdk.click.e eVar = this.e;
                if (eVar != null) {
                    eVar.a();
                }
                Set<String> set = p;
                if (set != null && set.contains(campaignEx.getId())) {
                    NativeListener.NativeTrackingListener nativeTrackingListener3 = this.f;
                    if (nativeTrackingListener3 != null) {
                        nativeTrackingListener3.onDismissLoading(campaignEx);
                        this.f.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        return;
                    }
                    return;
                }
                Set<String> set2 = p;
                if (set2 != null) {
                    set2.add(campaignEx.getId());
                }
                com.mbridge.msdk.click.e eVar2 = new com.mbridge.msdk.click.e(this.d);
                this.e = eVar2;
                eVar2.a(this.f4032a, campaignEx, new d(campaignEx, z3, bool, list, z2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, Campaign campaign) {
        new Handler(Looper.getMainLooper()).post(new e(z, campaign));
    }

    public void a(JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, int i, boolean z) {
        if (campaignEx == null || jumpLoaderResult == null) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis() - this.b;
            com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e();
            int s = l0.s(this.d);
            eVar.e(s);
            eVar.h(l0.a(this.d, s));
            eVar.i(campaignEx.getRequestId());
            eVar.j(campaignEx.getRequestIdNotice());
            eVar.a(i);
            eVar.c(currentTimeMillis + "");
            eVar.a(campaignEx.getId());
            eVar.f(jumpLoaderResult.getType());
            if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                eVar.g(URLEncoder.encode(jumpLoaderResult.getUrl(), D5.N));
            }
            eVar.b((this.b / 1000) + "");
            eVar.c(Integer.parseInt(campaignEx.getLandingType()));
            eVar.d(campaignEx.getLinkType());
            eVar.k(this.f4032a);
            eVar.f(jumpLoaderResult.getType());
            if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                eVar.g(URLEncoder.encode(jumpLoaderResult.getUrl(), D5.N));
            }
            if (this.i) {
                eVar.b(jumpLoaderResult.getStatusCode());
                if (!TextUtils.isEmpty(jumpLoaderResult.getHeader())) {
                    eVar.f(URLEncoder.encode(jumpLoaderResult.getHeader(), D5.N));
                }
                if (!TextUtils.isEmpty(jumpLoaderResult.getContent())) {
                    eVar.d(URLEncoder.encode(jumpLoaderResult.getContent(), "UTF-8"));
                }
                if (!TextUtils.isEmpty(jumpLoaderResult.getExceptionMsg())) {
                    eVar.e(URLEncoder.encode(jumpLoaderResult.getExceptionMsg(), D5.N));
                }
            }
            if (z) {
                this.g.a("click_jump_error", eVar, this.f4032a);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(eVar);
            ArrayList<JSONObject> a2 = com.mbridge.msdk.foundation.entity.e.a(arrayList);
            if (a2 == null || a2.isEmpty()) {
                return;
            }
            Iterator<JSONObject> it = a2.iterator();
            while (it.hasNext()) {
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a(it.next());
            }
        } catch (Throwable th) {
            p0.b("CommonClickControl", th.getMessage());
        }
    }

    public void a(Campaign campaign, String str) {
        try {
            if (!TextUtils.isEmpty(str) && campaign != null) {
                CampaignEx campaignEx = campaign instanceof CampaignEx ? (CampaignEx) campaign : null;
                if (!str.startsWith("market://") && !str.startsWith("https://play.google.com/")) {
                    com.mbridge.msdk.click.b.a(str, this.d, this.f4032a, campaignEx, this.f);
                    return;
                }
                if (t0.a.a(this.d, str, this.f) || campaignEx == null) {
                    return;
                }
                if (!TextUtils.isEmpty(campaignEx.getPackageName())) {
                    t0.a.a(this.d, "market://details?id=" + campaignEx.getPackageName(), this.f);
                } else if (b() == 2) {
                    t0.a(this.d, campaignEx.getClickURL(), campaignEx, this.f, new ArrayList());
                } else {
                    t0.a(this.d, campaignEx.getClickURL(), this.f, campaignEx, new ArrayList());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, boolean z) {
        a(jumpLoaderResult, campaignEx, 1, z);
    }

    private void a(int i, String str, CampaignEx campaignEx, NativeListener.NativeTrackingListener nativeTrackingListener, List<String> list) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (i == 2) {
                t0.a(this.d, str, campaignEx, nativeTrackingListener, list);
            } else {
                t0.a(this.d, str, nativeTrackingListener, campaignEx, list);
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CommonClickControl", th.getMessage(), th);
            }
        }
    }

    private boolean a(CampaignEx campaignEx, JumpLoaderResult jumpLoaderResult, boolean z, int i, List<String> list) {
        boolean z2 = true;
        boolean z3 = false;
        if (z) {
            try {
                int parseInt = Integer.parseInt(campaignEx.getLandingType());
                if (parseInt == 1) {
                    t0.a(this.d, jumpLoaderResult.getUrl(), this.f, campaignEx, list);
                } else if (parseInt == 2) {
                    t0.a(this.d, jumpLoaderResult.getUrl(), campaignEx, this.f, list);
                } else if (campaignEx.getPackageName() != null) {
                    if (t0.a.a(this.d, "market://details?id=" + campaignEx.getPackageName(), this.f)) {
                        if (list != null) {
                            try {
                                list.add("google_play");
                            } catch (Throwable th) {
                                th = th;
                                if (MBridgeConstans.DEBUG) {
                                    p0.b("CommonClickControl", th.getMessage(), th);
                                }
                                return z2;
                            }
                        }
                        a(campaignEx, 1, 1, list);
                    } else {
                        a(i, jumpLoaderResult.getUrl(), campaignEx, this.f, list);
                    }
                } else {
                    a(i, jumpLoaderResult.getUrl(), campaignEx, this.f, list);
                }
                z3 = true;
            } catch (Throwable th2) {
                th = th2;
                z2 = false;
            }
        }
        if (z3) {
            a(jumpLoaderResult, campaignEx, true);
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f;
            if (nativeTrackingListener != null) {
                nativeTrackingListener.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                return z3;
            }
        } else {
            a(jumpLoaderResult, campaignEx, true);
            NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f;
            if (nativeTrackingListener2 != null && z) {
                nativeTrackingListener2.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
            }
        }
        return z3;
    }

    private boolean a(CampaignEx campaignEx, JumpLoaderResult jumpLoaderResult, boolean z, List<String> list) {
        boolean z2 = false;
        if (z) {
            try {
                if (com.mbridge.msdk.util.b.a()) {
                    com.mbridge.msdk.click.b.a(this.d, this.f4032a, campaignEx, campaignEx.getNoticeUrl(), com.mbridge.msdk.foundation.same.a.M);
                }
                t0.a(this.d, campaignEx.getClickURL(), this.f, campaignEx, list);
                z2 = true;
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("CommonClickControl", th.getMessage(), th);
                }
                return false;
            }
        }
        a(jumpLoaderResult, campaignEx, true);
        if (z2) {
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f;
            if (nativeTrackingListener != null) {
                nativeTrackingListener.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                return z2;
            }
        } else {
            if (com.mbridge.msdk.util.b.a()) {
                a(jumpLoaderResult, campaignEx, true);
            }
            NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f;
            if (nativeTrackingListener2 != null) {
                nativeTrackingListener2.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
            }
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0173, code lost:
    
        a(r11, r10, true);
        r10 = r9.f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0178, code lost:
    
        if (r10 == null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x017a, code lost:
    
        r10.onRedirectionFailed(null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x017e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(CampaignEx campaignEx, JumpLoaderResult jumpLoaderResult, boolean z, boolean z2, Boolean bool, List<String> list) {
        try {
            if (this.k) {
                com.mbridge.msdk.click.b.a();
                if (campaignEx != null && jumpLoaderResult != null) {
                    int b2 = b();
                    int code = jumpLoaderResult.getCode();
                    if (bool != null && !bool.booleanValue()) {
                        com.mbridge.msdk.click.b.a(jumpLoaderResult, this.d, this.f4032a, campaignEx, Boolean.FALSE, this.f, list);
                        return;
                    }
                    if (TextUtils.isEmpty(jumpLoaderResult.getUrl()) && z) {
                        int linkType = campaignEx.getLinkType();
                        if (linkType == 2) {
                            a(campaignEx, jumpLoaderResult, z, b(), list);
                            return;
                        }
                        if (linkType == 3) {
                            a(campaignEx, jumpLoaderResult, z, list);
                            return;
                        }
                        t0.a(this.d, campaignEx.getClickURL(), this.f, campaignEx, list);
                        a(jumpLoaderResult, campaignEx, true);
                        NativeListener.NativeTrackingListener nativeTrackingListener = this.f;
                        if (nativeTrackingListener != null) {
                            nativeTrackingListener.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                            return;
                        }
                        return;
                    }
                    if (code == 1) {
                        if (!TextUtils.isEmpty(campaignEx.getPackageName()) && !TextUtils.isEmpty(jumpLoaderResult.getUrl()) && jumpLoaderResult.getUrl().contains(campaignEx.getPackageName()) && z) {
                            if (!t0.a.a(this.d, jumpLoaderResult.getUrl(), this.f)) {
                                a(b2, jumpLoaderResult.getUrl(), campaignEx, this.f, list);
                            }
                        } else if (z && (TextUtils.isEmpty(campaignEx.getPackageName()) || !t0.a.a(this.d, "market://details?id=" + campaignEx.getPackageName(), this.f))) {
                            a(b2, jumpLoaderResult.getUrl(), campaignEx, this.f, list);
                        }
                        NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f;
                        if (nativeTrackingListener2 != null && z) {
                            nativeTrackingListener2.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                        }
                    } else if (code == 3) {
                        if (z) {
                            com.mbridge.msdk.click.b.a(this.d, campaignEx, this.f4032a, jumpLoaderResult, bool, this.f, list);
                        }
                        NativeListener.NativeTrackingListener nativeTrackingListener3 = this.f;
                        if (nativeTrackingListener3 != null && z) {
                            nativeTrackingListener3.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                        }
                    } else if (z) {
                        if (3 == campaignEx.getLinkType()) {
                            a(campaignEx, jumpLoaderResult, z, list);
                            return;
                        } else {
                            if (2 == campaignEx.getLinkType()) {
                                a(campaignEx, jumpLoaderResult, z, b(), list);
                                return;
                            }
                            t0.a(this.d, jumpLoaderResult.getUrl(), this.f, campaignEx, list);
                            NativeListener.NativeTrackingListener nativeTrackingListener4 = this.f;
                            if (nativeTrackingListener4 != null) {
                                nativeTrackingListener4.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                            }
                        }
                    }
                    if (a(campaignEx.getLinkType(), jumpLoaderResult.getUrl())) {
                        a(jumpLoaderResult, campaignEx, false);
                    } else {
                        a(jumpLoaderResult, campaignEx, true);
                    }
                    NativeListener.NativeTrackingListener nativeTrackingListener5 = this.f;
                    if (nativeTrackingListener5 == null || z || !z2) {
                        return;
                    }
                    nativeTrackingListener5.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean a(int i, String str) {
        try {
            return i == 2 ? t0.a.b(str) : !TextUtils.isEmpty(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            Intent intent = new Intent();
            intent.setAction("ExitApp");
            this.d.sendBroadcast(intent);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CommonClickControl", "Exception", e2);
            }
        }
    }

    private void a(CampaignEx campaignEx, int i, int i2, List<String> list) {
        try {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("type", Integer.valueOf(i));
            eVar.a("result", Integer.valueOf(i2));
            if (list != null) {
                eVar.a("click_path", list.toString());
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000150", campaignEx, eVar);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CommonClickControl", e2.getMessage());
            }
        }
    }
}
