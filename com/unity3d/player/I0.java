package com.unity3d.player;

/* loaded from: classes7.dex */
public final class I0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayerForActivityOrService f6477a;

    public I0(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f6477a = unityPlayerForActivityOrService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        UnityPlayerForActivityOrService unityPlayerForActivityOrService = this.f6477a;
        z = unityPlayerForActivityOrService.mMainDisplayOverride;
        if (z) {
            unityPlayerForActivityOrService.getFrameLayout().removeView(this.f6477a.getView());
        } else if (unityPlayerForActivityOrService.getView().getParent() == null) {
            this.f6477a.getFrameLayout().addView(this.f6477a.getView());
        } else {
            com.unity3d.player.a.t.Log(5, "Couldn't add view, because it's already assigned to another parent");
        }
    }
}
