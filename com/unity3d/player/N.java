package com.unity3d.player;

import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.Objects;

/* loaded from: classes7.dex */
public final class N extends AccessibilityNodeProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityAccessibilityDelegate f6482a;

    public N(UnityAccessibilityDelegate unityAccessibilityDelegate) {
        this.f6482a = unityAccessibilityDelegate;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        SurfaceView surfaceView;
        boolean populateNodeInfo;
        SurfaceView surfaceView2;
        SurfaceView surfaceView3;
        int[] rootNodeIds;
        SurfaceView surfaceView4;
        if (i == -1) {
            surfaceView2 = this.f6482a.b;
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(surfaceView2);
            surfaceView3 = this.f6482a.b;
            Object parent = surfaceView3.getParent();
            if (parent instanceof View) {
                obtain.setParent((View) parent);
            }
            rootNodeIds = UnityAccessibilityDelegate.getRootNodeIds();
            if (rootNodeIds != null) {
                for (int i2 : rootNodeIds) {
                    surfaceView4 = this.f6482a.b;
                    obtain.addChild(surfaceView4, i2);
                }
            }
            return obtain;
        }
        AccessibilityNodeInfo obtain2 = AccessibilityNodeInfo.obtain();
        surfaceView = this.f6482a.b;
        populateNodeInfo = UnityAccessibilityDelegate.populateNodeInfo(obtain2, i, surfaceView);
        if (populateNodeInfo) {
            return obtain2;
        }
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i, int i2, Bundle bundle) {
        boolean isNodeSlider;
        boolean isNodeScrollable;
        UnityPlayer unityPlayer;
        UnityPlayer unityPlayer2;
        UnityPlayer unityPlayer3;
        UnityPlayer unityPlayer4;
        boolean isNodeDismissable;
        UnityPlayer unityPlayer5;
        UnityPlayer unityPlayer6;
        boolean isNodeInvokable;
        UnityPlayer unityPlayer7;
        UnityPlayer unityPlayer8;
        if (i2 == 64) {
            return this.f6482a.sendEventForVirtualViewId(i, 32768);
        }
        if (i2 == 128) {
            return this.f6482a.sendEventForVirtualViewId(i, 65536);
        }
        if (i2 == 16) {
            isNodeInvokable = UnityAccessibilityDelegate.isNodeInvokable(i);
            if (!isNodeInvokable) {
                return false;
            }
            unityPlayer7 = this.f6482a.f6494a;
            Objects.requireNonNull(unityPlayer7);
            J j = new J(this, unityPlayer7, i);
            unityPlayer8 = this.f6482a.f6494a;
            unityPlayer8.invokeOnMainThread((Runnable) j);
            return true;
        }
        if (i2 == 4096 || i2 == 8192) {
            isNodeSlider = UnityAccessibilityDelegate.isNodeSlider(i);
            if (isNodeSlider) {
                unityPlayer3 = this.f6482a.f6494a;
                Objects.requireNonNull(unityPlayer3);
                K k = new K(this, unityPlayer3, i2, i);
                unityPlayer4 = this.f6482a.f6494a;
                unityPlayer4.invokeOnMainThread((Runnable) k);
                return true;
            }
            isNodeScrollable = UnityAccessibilityDelegate.isNodeScrollable(i);
            if (isNodeScrollable) {
                unityPlayer = this.f6482a.f6494a;
                Objects.requireNonNull(unityPlayer);
                L l = new L(unityPlayer, i, i2);
                unityPlayer2 = this.f6482a.f6494a;
                unityPlayer2.invokeOnMainThread((Runnable) l);
                return true;
            }
        }
        if (i2 != 1048576) {
            return false;
        }
        isNodeDismissable = UnityAccessibilityDelegate.isNodeDismissable(i);
        if (!isNodeDismissable) {
            return false;
        }
        unityPlayer5 = this.f6482a.f6494a;
        Objects.requireNonNull(unityPlayer5);
        M m = new M(unityPlayer5, i);
        unityPlayer6 = this.f6482a.f6494a;
        unityPlayer6.invokeOnMainThread((Runnable) m);
        return true;
    }
}
