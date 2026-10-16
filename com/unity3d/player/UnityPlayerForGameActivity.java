package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import com.unity3d.player.a.EnumC3507o;

/* loaded from: classes7.dex */
public class UnityPlayerForGameActivity extends UnityPlayer {
    Thread m_MainThread;
    private com.unity3d.player.a.C m_PersistentUnitySurface;
    SurfaceView m_SurfaceView;

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeOrientationChanged(int i, int i2);

    private final native void nativeUnityPlayerForGameActivityInitialized(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeUnityPlayerSetRunning(boolean z);

    @Override // com.unity3d.player.UnityPlayer
    protected void cleanupResourcesForDestroy() {
    }

    @Override // com.unity3d.player.UnityPlayer
    boolean handleFocus(boolean z) {
        return true;
    }

    public UnityPlayerForGameActivity(Activity activity, FrameLayout frameLayout, SurfaceView surfaceView) {
        this(activity, frameLayout, surfaceView, null, "");
    }

    public UnityPlayerForGameActivity(Activity activity, FrameLayout frameLayout, SurfaceView surfaceView, IUnityPlayerLifecycleEvents iUnityPlayerLifecycleEvents) {
        this(activity, frameLayout, surfaceView, iUnityPlayerLifecycleEvents, "");
    }

    public UnityPlayerForGameActivity(Activity activity, FrameLayout frameLayout, SurfaceView surfaceView, IUnityPlayerLifecycleEvents iUnityPlayerLifecycleEvents, String str) {
        super(activity, EnumC3507o.c, iUnityPlayerLifecycleEvents);
        this.m_SurfaceView = surfaceView;
        initialize(frameLayout, str);
        this.m_MainThread = null;
        nativeUnityPlayerForGameActivityInitialized(!com.unity3d.player.a.S.e ? 1 : 0);
        applySurfaceViewSettings(this.m_SurfaceView);
        this.m_PersistentUnitySurface = new com.unity3d.player.a.C(activity);
        this.m_SurfaceView.getHolder().addCallback(new O0(this));
    }

    public static int getUnityViewIdentifier(Context context) {
        return context.getResources().getIdentifier("unitySurfaceView", "id", context.getPackageName());
    }

    protected void setMainThread() {
        if (this.m_MainThread != null) {
            throw new RuntimeException("Main Thread was already set.");
        }
        this.m_MainThread = Thread.currentThread();
    }

    @Override // com.unity3d.player.UnityPlayer
    public boolean runningOnMainThread() {
        if (this.m_MainThread != null) {
            return Thread.currentThread() == this.m_MainThread;
        }
        throw new RuntimeException("Main Thread was not yet set.");
    }

    @Override // com.unity3d.player.UnityPlayer
    public void setMainSurfaceViewAspectRatio(float f) {
        com.unity3d.player.a.t.Log(6, "setMainSurfaceViewAspectRatio is not supported for GameActivity");
    }

    @Override // com.unity3d.player.UnityPlayer
    void onOrientationChanged(int i, int i2) {
        invokeOnMainThread((Runnable) new P0(this, i, i2));
    }

    @Override // com.unity3d.player.UnityPlayer
    void pauseUnity() {
        super.pauseUnity();
        invokeOnMainThread((Runnable) new Q0(this));
    }

    @Override // com.unity3d.player.UnityPlayer
    void resumeUnity() {
        super.resumeUnity();
        invokeOnMainThread((Runnable) new R0(this));
    }

    @Override // com.unity3d.player.UnityPlayer
    public SurfaceView getView() {
        return getSurfaceView();
    }

    @Override // com.unity3d.player.UnityPlayer
    public SurfaceView getSurfaceView() {
        return this.m_SurfaceView;
    }

    @Override // com.unity3d.player.UnityPlayer
    void hidePreservedContent() {
        runOnUiThread(new S0(this));
    }
}
