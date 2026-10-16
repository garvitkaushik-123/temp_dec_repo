package com.mbridge.msdk.video.module.listener.impl;

import com.mbridge.msdk.foundation.tools.p0;

/* compiled from: DefaultOnNotifyListener.java */
/* loaded from: classes6.dex */
public class f implements com.mbridge.msdk.video.module.listener.a {
    @Override // com.mbridge.msdk.video.module.listener.a
    public void a(int i, Object obj) {
        p0.b("NotifyListener", "onNotify,type=" + i + ",pt=" + obj);
    }
}
