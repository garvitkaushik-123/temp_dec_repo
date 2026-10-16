package com.fyber.inneractive.sdk.player.controller;

import android.view.TextureView;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f1363a;

    public h(i iVar) {
        this.f1363a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q qVar = this.f1363a.f1364a;
        x xVar = qVar.d;
        if (xVar != null) {
            TextureView textureView = qVar.j;
            z zVar = xVar.f1376a;
            zVar.getClass();
            IAlog.a("%s onTextureViewDestroyed", IAlog.a(zVar));
        }
    }
}
