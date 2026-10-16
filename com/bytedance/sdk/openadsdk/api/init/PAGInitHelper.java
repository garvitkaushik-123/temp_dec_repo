package com.bytedance.sdk.openadsdk.api.init;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.eli.DbA.DbA;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.aGH.eli.aGH;
import com.bytedance.sdk.openadsdk.api.init.PAGConfig;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.bytedance.sdk.openadsdk.common.ui;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.FC.Os;
import com.bytedance.sdk.openadsdk.core.act.eli;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.nlS;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.gG;
import com.bytedance.sdk.openadsdk.utils.qj;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class PAGInitHelper {
    public static final List<PAGSdk.PAGInitCallback> CALLBACK_LIST = new ArrayList();
    public static float animationScale = 1.0f;

    public static void maybeAsyncInitTask(Context context) {
        eli.eli(context);
        qj.eli();
        SSo.eli(context);
        eli();
        dV.ui();
        String eli = nlS.eli(context);
        Os.DbA(eli);
        aGH.eli(eli, true);
        DbA.eli();
        com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().DbA();
        initAnimationScale(context);
    }

    public static void initAnimationScale(Context context) {
        try {
            float f = Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
            animationScale = f;
            if (f <= 0.0f) {
                animationScale = 1.0f;
            }
        } catch (Throwable unused) {
            animationScale = 1.0f;
        }
    }

    private static void eli() {
        com.bytedance.sdk.openadsdk.core.Os.eli().eli("uuid", gG.eli());
    }

    public static void initMemoryData() {
        dV.aGH();
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("ttopenadsdk", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("sp_global_file", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("sp_global_privacy", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("sp_global_app_id", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("sp_global_icon_id", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tpl_fetch_model", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_sp", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_sdk_event_net_ad", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_sdk_event_net_state", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_sdk_event_net_trail", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_sdk_event_db_ad", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_sdk_event_db_state", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("tt_sdk_event_db_trail", "a", 0);
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("pag_sp_bad_par", "did");
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("pag_sp_bad_par", "gaid");
    }

    public static void initAPM() {
        if (ui.eli()) {
            return;
        }
        try {
            String aGH = FC.DbA().aGH();
            if (TextUtils.isEmpty(aGH)) {
                return;
            }
            ApmHelper.initApm(dV.eli(), new PAGConfig.Builder().appId(aGH).build());
        } catch (Exception unused) {
        }
    }
}
