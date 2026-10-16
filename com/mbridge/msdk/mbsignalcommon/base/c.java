package com.mbridge.msdk.mbsignalcommon.base;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: IntentFilter.java */
/* loaded from: classes6.dex */
public class c implements a {
    @Override // com.mbridge.msdk.mbsignalcommon.base.a
    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String scheme = Uri.parse(str).getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equals("intent")) {
            return false;
        }
        return com.mbridge.msdk.click.c.d(com.mbridge.msdk.foundation.controller.c.m().d(), str);
    }
}
