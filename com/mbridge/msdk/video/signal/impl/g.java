package com.mbridge.msdk.video.signal.impl;

import com.mbridge.msdk.foundation.tools.p0;

/* compiled from: DefaultJSRewardVideoV1.java */
/* loaded from: classes6.dex */
public class g implements com.mbridge.msdk.video.signal.i {
    @Override // com.mbridge.msdk.video.signal.i
    public void a(String str) {
        p0.a("js", "setOrientation,landscape=" + str);
    }

    @Override // com.mbridge.msdk.video.signal.i
    public String b() {
        p0.a("js", "getEndScreenInfo");
        return "{}";
    }

    @Override // com.mbridge.msdk.video.signal.i
    public void handlerPlayableException(String str) {
        p0.a("js", "handlerPlayableException，msg=" + str);
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void notifyCloseBtn(int i) {
        p0.a("js", "notifyCloseBtn,state=" + i);
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void toggleCloseBtn(int i) {
        p0.a("js", "toggleCloseBtn,state=" + i);
    }

    @Override // com.mbridge.msdk.video.signal.i
    public void triggerCloseBtn(String str) {
        p0.a("js", "triggerCloseBtn,state=" + str);
    }
}
