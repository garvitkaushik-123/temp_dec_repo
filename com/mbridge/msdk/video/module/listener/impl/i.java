package com.mbridge.msdk.video.module.listener.impl;

/* compiled from: ProxyOnNotifyListener.java */
/* loaded from: classes6.dex */
public class i extends f {

    /* renamed from: a, reason: collision with root package name */
    protected com.mbridge.msdk.video.module.listener.a f5151a;

    public i(com.mbridge.msdk.video.module.listener.a aVar) {
        this.f5151a = aVar;
    }

    @Override // com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
    public void a(int i, Object obj) {
        super.a(i, obj);
        com.mbridge.msdk.video.module.listener.a aVar = this.f5151a;
        if (aVar != null) {
            aVar.a(i, obj);
        }
    }
}
