package com.mbridge.msdk.newreward.function.common;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.x0;
import com.mbridge.msdk.video.bt.module.orglistener.h;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class MBridgeGlobalCommon {
    public static String SESSION_ID = "";
    public static Map<String, h> showRewardListenerMap = new HashMap();

    public static void setAlertDialogText(String str, String str2, String str3, String str4, String str5) {
        Context d = c.m().d();
        if (!TextUtils.isEmpty(str2)) {
            x0.b(d, "MBridge_ConfirmTitle" + str, str2.trim());
        }
        if (!TextUtils.isEmpty(str3)) {
            x0.b(d, "MBridge_ConfirmContent" + str, str3.trim());
        }
        if (!TextUtils.isEmpty(str5)) {
            x0.b(d, "MBridge_CancelText" + str, str5.trim());
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        x0.b(d, "MBridge_ConfirmText" + str, str4.trim());
    }
}
