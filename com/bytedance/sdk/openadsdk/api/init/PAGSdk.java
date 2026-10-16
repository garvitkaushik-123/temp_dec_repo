package com.bytedance.sdk.openadsdk.api.init;

import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutManager;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebView;
import com.bytedance.adsdk.ugeno.kb.aGH;
import com.bytedance.sdk.component.FC.MGA;
import com.bytedance.sdk.component.FC.ui;
import com.bytedance.sdk.component.eli;
import com.bytedance.sdk.component.utils.DbA;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.component.utils.wC;
import com.bytedance.sdk.component.wC.aAs;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.InitConfig;
import com.bytedance.sdk.openadsdk.Vy.DbA.kb;
import com.bytedance.sdk.openadsdk.api.bidding.PAGBiddingRequest;
import com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory;
import com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory;
import com.bytedance.sdk.openadsdk.api.factory.SDKTypeConfig;
import com.bytedance.sdk.openadsdk.core.Dfc;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.GB;
import com.bytedance.sdk.openadsdk.core.NU;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.core.wC.nlS;
import com.bytedance.sdk.openadsdk.ev.eli;
import com.bytedance.sdk.openadsdk.multipro.Os;
import com.bytedance.sdk.openadsdk.multipro.aidl.DbA;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.aqO;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.bytedance.sdk.openadsdk.utils.nGm;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.ironsource.C3040d4;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PAGSdk {
    public static final int INIT_LOCAL_FAIL_CODE = 4000;
    private static long eli;

    public interface PAGInitCallback {
        void fail(int i, String str);

        void success();
    }

    static {
        try {
            eli.eli(new eli.InterfaceC0144eli() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.1
                @Override // com.bytedance.sdk.component.eli.InterfaceC0144eli
                public ExecutorService getExecutorService() {
                    return cyF.ui();
                }

                @Override // com.bytedance.sdk.component.eli.InterfaceC0144eli
                public HandlerThread getSafeHandlerThread(String str, int i) {
                    return wC.eli(str, i);
                }
            });
            cyF.eli(new com.bytedance.sdk.component.wC.wC("tt_init_memory_data") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().eli(false);
                    PAGInitHelper.initAPM();
                    PAGInitHelper.initMemoryData();
                }
            });
            nn.eli(System.currentTimeMillis());
            nn.DbA();
            MGA.setWebViewProvider(new MGA.Os() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.3
                @Override // com.bytedance.sdk.component.FC.MGA.Os
                public WebView createWebView(Context context, AttributeSet attributeSet, int i) {
                    if (!(context instanceof MutableContextWrapper)) {
                        context = context.getApplicationContext();
                    }
                    try {
                        return i == 0 ? new ui(context, attributeSet) : new ui(context, attributeSet, i);
                    } catch (Exception unused) {
                        return i == 0 ? new ui(context, attributeSet) : new ui(context, attributeSet, i);
                    }
                }
            });
        } catch (Throwable th) {
            Log.i("TTAD.PAGSdk", th.getMessage());
        }
        eli = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DbA(final Context context, final InitConfig initConfig, PAGInitCallback pAGInitCallback) {
        Context applicationContext;
        eli = SystemClock.elapsedRealtime();
        dV.DbA(context);
        if (pAGInitCallback != null) {
            synchronized (PAGInitHelper.CALLBACK_LIST) {
                if (!PAGInitHelper.CALLBACK_LIST.contains(pAGInitCallback)) {
                    PAGInitHelper.CALLBACK_LIST.add(pAGInitCallback);
                    if (nn.aGH() == 3) {
                        return;
                    }
                }
            }
        }
        if (com.bytedance.sdk.openadsdk.common.ui.eli()) {
            DbA(-1, "DisableSDK is called, interrupt initialization");
            return;
        }
        if (isInitSuccess()) {
            aGH();
            Os(initConfig);
            return;
        }
        if (initConfig == null) {
            DbA(4000, "PAGConfig is null, please check.");
            return;
        }
        nn.eli(3);
        int pa = initConfig.getPA();
        if (pa < -1 || pa > 1) {
            DbA(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED, com.bytedance.sdk.openadsdk.core.wC.eli(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED));
            return;
        }
        if (context == null) {
            DbA(4000, "Context is null, please check. ");
            return;
        }
        if (!(context instanceof Application) && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        aGH(context, initConfig);
        ApmHelper.initApm(context, initConfig);
        try {
            FC.eli(new NU() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.4
                public void success() {
                    PAGSdk.aGH();
                }

                @Override // com.bytedance.sdk.openadsdk.core.NU
                public void fail(int i, String str) {
                    PAGSdk.DbA(i, str);
                }
            });
            try {
                ev.eli(dV.eli(), "tt_ad_logo_txt");
                if (ev.aGH(context, "tt_ad_logo") == 0) {
                    eli(initConfig, pAGInitCallback);
                    return;
                }
                if (isInitSuccess()) {
                    if (pAGInitCallback != null) {
                        aGH();
                        return;
                    }
                    return;
                }
                final com.bytedance.sdk.openadsdk.ui.eli eliVar = new com.bytedance.sdk.openadsdk.ui.eli();
                SDKTypeConfig.setSdkTypeFactory(new ISDKTypeFactory() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.5
                    @Override // com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory
                    public IADTypeLoaderFactory createADTypeLoaderFactory(String str) {
                        return com.bytedance.sdk.openadsdk.ui.eli.this;
                    }
                });
                if (!initConfig.isSupportMultiProcess()) {
                    DbA(context, initConfig);
                } else {
                    com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli().eli(new DbA() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.6
                        @Override // com.bytedance.sdk.openadsdk.multipro.aidl.DbA
                        public void onServiceConnected() {
                            nn.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    PAGSdk.DbA(context, initConfig);
                                }
                            });
                        }
                    });
                    com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli().Os();
                }
            } catch (Throwable unused) {
                eli(initConfig, pAGInitCallback);
            }
        } catch (Throwable unused2) {
            DbA(4000, "Internal Error, setting exception. ");
        }
    }

    private static void eli(InitConfig initConfig, PAGInitCallback pAGInitCallback) {
        nn.eli(2);
        if (pAGInitCallback != null) {
            if (initConfig instanceof PAGConfig) {
                DbA(4000, "resources not found, if you use aab please call PAGConfig.setPackageName");
            } else {
                DbA(4000, "resources not found, if you use aab please call TTAdConfig.setPackageName");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DbA(Context context, InitConfig initConfig) {
        long j;
        try {
        } catch (Throwable th) {
            th.getMessage();
            Xb.Os("TTAD.PAGSdk", th.getMessage());
            long elapsedRealtime = SystemClock.elapsedRealtime() - eli;
            DbA(4000, th.getMessage());
            j = elapsedRealtime;
        }
        if (isInitSuccess()) {
            aGH();
            return;
        }
        ui(context, initConfig);
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - eli;
        aGH();
        MGA(context, initConfig);
        j = elapsedRealtime2;
        long elapsedRealtime3 = SystemClock.elapsedRealtime() - eli;
        eli(context, isInitSuccess(), initConfig, elapsedRealtime3, j);
        new Object[]{"init exec init sdk sdkInitTime=", Long.valueOf(j), " duration=", Long.valueOf(elapsedRealtime3)};
    }

    private static void Os(Context context, InitConfig initConfig) {
        nn.eli = true;
        GB.eli().eli(initConfig.getAppId()).DbA(initConfig.getGdpr()).ui(initConfig.getPA()).aGH(initConfig.getAppIconId()).eli(initConfig.getTitleBarTheme()).Os(initConfig.getAdxId());
        FC.ev();
        if (initConfig instanceof PAGConfig) {
            GB.eli().Os(((PAGConfig) initConfig).getDebugLog() ? 1 : 0);
        }
        try {
            if (DbA(initConfig)) {
                GB.eli().eli();
                nGm.eli();
            }
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.component.utils.FC.eli();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean DbA(InitConfig initConfig) {
        return ((PAGConfig) initConfig).getDebugLog();
    }

    private static void aGH(Context context, InitConfig initConfig) {
        if (!TextUtils.isEmpty(initConfig.getPackageName())) {
            ev.eli(initConfig.getPackageName());
            aGH.eli(initConfig.getPackageName());
        } else {
            ev.eli((String) null);
            aGH.eli((String) null);
        }
        dV.DbA(context);
        if (initConfig.isSupportMultiProcess()) {
            com.bytedance.sdk.openadsdk.multipro.DbA.eli();
        } else {
            com.bytedance.sdk.openadsdk.multipro.DbA.DbA();
        }
        nlS.eli();
        com.bytedance.sdk.openadsdk.core.aAs.DbA.eli(context);
    }

    private static void ui(Context context, InitConfig initConfig) {
        if (com.bytedance.sdk.openadsdk.core.settings.FC.eli()) {
            com.bytedance.sdk.component.wC.MGA.Os(-1);
            com.bytedance.sdk.component.wC.MGA.eli(new aAs() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.7
                @Override // com.bytedance.sdk.component.wC.aAs
                public com.bytedance.sdk.component.wC.FC createThreadFactory(int i, String str) {
                    return new com.bytedance.sdk.component.wC.FC(i, str) { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.7.1
                        @Override // com.bytedance.sdk.component.wC.FC, java.util.concurrent.ThreadFactory
                        public Thread newThread(Runnable runnable) {
                            if (com.bytedance.sdk.component.wC.FC.sCrashHappened) {
                                return null;
                            }
                            int BH = com.bytedance.sdk.openadsdk.core.settings.NU.nY().BH();
                            if (BH >= -524288 && BH < 0) {
                                Thread thread = new Thread(this.eli, runnable, this.DbA, BH);
                                if (thread.isDaemon()) {
                                    thread.setDaemon(false);
                                }
                                if (this.Os > 10 || this.Os <= 0) {
                                    this.Os = 5;
                                }
                                thread.setPriority(this.Os);
                                return thread;
                            }
                            return super.newThread(runnable);
                        }
                    };
                }
            });
            Os.eli(context);
            com.bytedance.sdk.openadsdk.kb.DbA.Os();
            nn.DbA.set(true);
            try {
                com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().eli(new com.bytedance.sdk.openadsdk.FC.eli());
            } catch (Exception e) {
                Xb.Os("TTAD.PAGSdk", e.getMessage());
            }
            Os(initConfig);
            Os(context, initConfig);
            com.bykv.vk.openvk.eli.eli.eli.Os.eli(context, null);
            com.bykv.vk.openvk.eli.eli.eli.Os.eli(2);
            com.bykv.vk.openvk.eli.eli.eli.Os.eli(initConfig.isSupportMultiProcess());
            com.bykv.vk.openvk.eli.eli.eli.Os.eli(com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().MGA());
        }
    }

    private static void MGA(final Context context, final InitConfig initConfig) {
        SystemClock.elapsedRealtime();
        cyF.eli(new com.bytedance.sdk.component.wC.wC("init_sync") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.8
            @Override // java.lang.Runnable
            public void run() {
                nn.eli(initConfig.getData());
                com.bytedance.sdk.openadsdk.bf.eli.eli(context, initConfig.getAppId());
                com.bytedance.sdk.openadsdk.bf.eli.eli();
                com.bytedance.sdk.openadsdk.dV.Os.eli();
                com.bytedance.sdk.openadsdk.dV.Os.DbA();
                new aqO();
                com.bytedance.sdk.component.adexpress.eli.DbA.MGA.eli(com.bytedance.sdk.openadsdk.utils.Xb.eli() * 10);
                com.bytedance.sdk.openadsdk.aGH.eli.aGH.eli(context, initConfig.isSupportMultiProcess());
                Dfc.eli().DbA();
                com.bytedance.sdk.openadsdk.core.FC.Os.eli();
                com.bytedance.sdk.openadsdk.ev.eli.eli(new eli.InterfaceC0208eli() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.8.1
                    public void onGdprChanged(int i) {
                        PAGConfig.setGDPRConsent(i);
                    }
                });
                com.bytedance.sdk.openadsdk.core.settings.NU.aGH = com.bytedance.sdk.openadsdk.core.settings.NU.Os(context);
                kb.DbA();
                com.bykv.vk.openvk.eli.eli.DbA.eli.eli(dV.aGH().oc());
                com.bykv.vk.openvk.eli.eli.DbA.eli.eli(CacheDirFactory.getICacheDir(0));
                com.bytedance.sdk.openadsdk.core.settings.MGA aGH = dV.aGH();
                if (!aGH.ikX()) {
                    synchronized (aGH) {
                        if (!aGH.ikX()) {
                            aGH.DbA();
                            aGH.ujq();
                        }
                    }
                }
                DeviceUtils.du();
                PAGInitHelper.maybeAsyncInitTask(context);
                PAGSdk.getBiddingToken();
                com.bytedance.sdk.component.wC.MGA.eli(true);
                com.bytedance.sdk.component.wC.MGA.eli(new com.bytedance.sdk.openadsdk.Dfc.DbA.eli());
                DeviceUtils.eli(context);
                DeviceUtils.du(context);
                DeviceUtils.nlS(context);
                com.bytedance.sdk.openadsdk.Dfc.eli.eli();
                com.bytedance.sdk.openadsdk.core.settings.aGH.eli();
                com.bytedance.sdk.openadsdk.Dfc.Os.aGH();
                dZ.FC(context);
                com.bytedance.sdk.openadsdk.aGH.Os.eli();
                PAGSdk.Os();
                com.bytedance.sdk.openadsdk.core.FC.Os.DbA();
                com.bytedance.sdk.openadsdk.core.aGH.eli.eli().DbA();
                com.bytedance.sdk.component.wC.Os.Os.eli(nn.DbA());
                com.bytedance.sdk.component.utils.DbA.eli(new DbA.eli() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.8.2
                    @Override // com.bytedance.sdk.component.utils.DbA.eli
                    public boolean isEnableAsyncStartActivity() {
                        return com.bytedance.sdk.openadsdk.bf.eli.eli("start_activity_async", 0) == 1;
                    }

                    @Override // com.bytedance.sdk.component.utils.DbA.eli
                    public boolean isStartActivityBySubThread() {
                        return com.bytedance.sdk.openadsdk.bf.eli.eli("start_act_asy", 0) == 1;
                    }

                    @Override // com.bytedance.sdk.component.utils.DbA.eli
                    public ExecutorService getAsyncStartActivityThreadPool() {
                        return cyF.FC();
                    }
                });
                dZ.Os();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Os() {
        ShortcutManager shortcutManager;
        try {
            Context eli2 = dV.eli();
            if (eli2 == null || (shortcutManager = (ShortcutManager) eli2.getSystemService(ShortcutManager.class)) == null) {
                return;
            }
            FC.DbA().eli(shortcutManager.isRequestPinShortcutSupported());
        } catch (Throwable unused) {
        }
    }

    private static void Os(InitConfig initConfig) {
        if (initConfig == null) {
            return;
        }
        if (!TextUtils.isEmpty(initConfig.getData())) {
            FC.DbA().Os(initConfig.getData());
        }
        FC.DbA().Os(DbA(initConfig));
    }

    private static void eli(final Context context, final boolean z, final InitConfig initConfig, final long j, final long j2) {
        com.bytedance.sdk.openadsdk.Dfc.Os.eli();
        com.bytedance.sdk.openadsdk.Dfc.Os.eli("pangle_sdk_init", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.9
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    boolean Os = FC.DbA().Os();
                    jSONObject.put("duration", j);
                    jSONObject.put("sdk_init_time", j2);
                    jSONObject.put("is_async", true);
                    jSONObject.put("is_multi_process", initConfig.isSupportMultiProcess());
                    jSONObject.put("is_debug", PAGSdk.DbA(initConfig));
                    jSONObject.put("is_use_texture_view", initConfig.isUseTextureView());
                    jSONObject.put("is_activate_init", Os);
                    jSONObject.put("minSdkVersion", dZ.kb(context));
                    jSONObject.put("targetSdkVersion", dZ.MGA(context));
                    jSONObject.put("apm_is_init", ApmHelper.isIsInit());
                    jSONObject.put("is_success", z);
                    FC.DbA().DbA(false);
                } catch (Exception e) {
                    Xb.eli("TTAD.PAGSdk", "run: ", e);
                }
                return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("pangle_sdk_init").DbA(jSONObject.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aGH() {
        nn.eli(1);
        try {
            synchronized (PAGInitHelper.CALLBACK_LIST) {
                Iterator<PAGInitCallback> it = PAGInitHelper.CALLBACK_LIST.iterator();
                while (it.hasNext()) {
                    PAGInitCallback next = it.next();
                    if (next != null) {
                        it.remove();
                        next.success();
                    }
                }
            }
            com.bytedance.sdk.openadsdk.dV.Os.DbA(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.10
                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                    eliVar.DbA(C3040d4.a.f);
                    return eliVar;
                }
            });
        } catch (Throwable th) {
            Xb.Os(th.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DbA(int i, String str) {
        nn.eli(2);
        try {
            synchronized (PAGInitHelper.CALLBACK_LIST) {
                Iterator<PAGInitCallback> it = PAGInitHelper.CALLBACK_LIST.iterator();
                while (it.hasNext()) {
                    PAGInitCallback next = it.next();
                    if (next != null) {
                        it.remove();
                        next.fail(i, str);
                    }
                }
                com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.11
                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                        eliVar.DbA(C3040d4.a.f);
                        return eliVar;
                    }
                });
            }
        } catch (Throwable th) {
            Xb.Os(th.getMessage(), new Object[0]);
        }
    }

    public static void init(final Context context, final PAGConfig pAGConfig, final PAGInitCallback pAGInitCallback) {
        nn.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.12
            @Override // java.lang.Runnable
            public void run() {
                PAGSdk.DbA(context, pAGConfig, pAGInitCallback);
            }
        });
        nn.wC();
    }

    public static boolean isInitSuccess() {
        return nn.aGH() == 1;
    }

    public static String getSDKVersion() {
        if (GB.eli() != null) {
            return GB.eli().Os();
        }
        return "";
    }

    public static void getBiddingToken(final Context context, final PAGBiddingRequest pAGBiddingRequest, final BiddingTokenCallback biddingTokenCallback) {
        if (biddingTokenCallback == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.common.ui.eli()) {
            biddingTokenCallback.onBiddingTokenCollected(null);
        } else {
            cyF.ui(new com.bytedance.sdk.component.wC.wC("getBiddingToken") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.13
                @Override // java.lang.Runnable
                public void run() {
                    dV.DbA(context);
                    biddingTokenCallback.onBiddingTokenCollected(PAGSdk.DbA(pAGBiddingRequest));
                    com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().eli(false);
                }
            });
        }
    }

    public static void getBiddingToken(final BiddingTokenCallback biddingTokenCallback) {
        if (biddingTokenCallback == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.common.ui.eli()) {
            biddingTokenCallback.onBiddingTokenCollected(null);
        } else {
            cyF.ui(new com.bytedance.sdk.component.wC.wC("getBiddingToken") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.14
                @Override // java.lang.Runnable
                public void run() {
                    biddingTokenCallback.onBiddingTokenCollected(PAGSdk.getBiddingToken());
                    com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().eli(false);
                }
            });
        }
    }

    public static void getBiddingToken(final String str, final BiddingTokenCallback biddingTokenCallback) {
        if (biddingTokenCallback == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.common.ui.eli()) {
            biddingTokenCallback.onBiddingTokenCollected(null);
        } else {
            cyF.ui(new com.bytedance.sdk.component.wC.wC("getBiddingToken") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.15
                @Override // java.lang.Runnable
                public void run() {
                    biddingTokenCallback.onBiddingTokenCollected(PAGSdk.getBiddingToken(str));
                    com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().eli(false);
                }
            });
        }
    }

    public static String getBiddingToken(Context context) {
        if (com.bytedance.sdk.openadsdk.common.ui.eli()) {
            return null;
        }
        dV.DbA(context);
        return getBiddingToken();
    }

    public static String getBiddingToken(Context context, String str) {
        if (com.bytedance.sdk.openadsdk.common.ui.eli()) {
            return null;
        }
        dV.DbA(context);
        return getBiddingToken(str);
    }

    public static String getBiddingToken(String str) {
        if (com.bytedance.sdk.openadsdk.common.ui.eli()) {
            return null;
        }
        if (dV.eli() == null || GB.eli() == null) {
            return "";
        }
        PAGBiddingRequest pAGBiddingRequest = new PAGBiddingRequest();
        pAGBiddingRequest.setSlotId(str);
        return GB.eli().eli(pAGBiddingRequest);
    }

    public static String getBiddingToken() {
        if (com.bytedance.sdk.openadsdk.common.ui.eli()) {
            return null;
        }
        return (dV.eli() == null || GB.eli() == null) ? "" : GB.eli().eli((PAGBiddingRequest) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String DbA(PAGBiddingRequest pAGBiddingRequest) {
        if (com.bytedance.sdk.openadsdk.common.ui.eli()) {
            return null;
        }
        return (dV.eli() == null || GB.eli() == null) ? "" : GB.eli().eli(pAGBiddingRequest);
    }

    public static boolean onlyVerityPlayable(String str, int i, String str2, String str3, String str4) {
        if (GB.eli() != null) {
            return GB.eli().eli(str, i, str2, str3, str4);
        }
        return false;
    }

    public static String getApplicationName(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static void closeMultiWebViewFileLock() {
        Os.eli();
    }

    public static void addPAGInitCallback(PAGInitCallback pAGInitCallback) {
        if (pAGInitCallback != null && nn.aGH() == 0) {
            PAGInitHelper.CALLBACK_LIST.add(pAGInitCallback);
        }
    }

    public static void setAabPackageName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ev.eli(str);
        aGH.eli(str);
    }

    public static void setAdRevenue(JSONObject jSONObject) {
        if (jSONObject != null && dV.aGH().aqO() && isInitSuccess()) {
            com.bytedance.sdk.openadsdk.Dfc.Os.eli().eli(jSONObject);
        }
    }

    private static void setSdkDisable(boolean z) {
        com.bytedance.sdk.openadsdk.common.ui.eli(z);
    }
}
