package com.unity3d.player;

/* renamed from: com.unity3d.player.g0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class RunnableC3523g0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PermissionRequest f6556a;
    public final /* synthetic */ String[] b;
    public final /* synthetic */ int[] c;

    public RunnableC3523g0(PermissionRequest permissionRequest, String[] strArr, int[] iArr) {
        this.f6556a = permissionRequest;
        this.b = strArr;
        this.c = iArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6556a.permissionResponse(this.b, this.c);
    }
}
