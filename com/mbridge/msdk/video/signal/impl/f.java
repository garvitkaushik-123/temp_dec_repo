package com.mbridge.msdk.video.signal.impl;

import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.video.module.MBridgeVideoView;

/* compiled from: DefaultJSNotifyProxy.java */
/* loaded from: classes6.dex */
public class f implements com.mbridge.msdk.video.signal.g {
    @Override // com.mbridge.msdk.video.signal.g
    public void a(int i) {
        p0.a("DefaultJSNotifyProxy", "onVideoStatusNotify:" + i);
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void a(int i, String str) {
        p0.a("DefaultJSNotifyProxy", "onClick:" + i + ",pt:" + str);
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void a(MBridgeVideoView.v vVar) {
        p0.a("DefaultJSNotifyProxy", "onProgressNotify:" + vVar.toString());
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void a(Object obj) {
        p0.a("DefaultJSNotifyProxy", "onWebviewShow:" + obj);
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void a(int i, int i2, int i3, int i4) {
        p0.a("DefaultJSNotifyProxy", "showDataInfo");
    }
}
