package com.unity3d.player;

import android.content.res.Configuration;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.CaptioningManager;
import java.util.Objects;
import java.util.concurrent.Semaphore;

/* loaded from: classes7.dex */
class UnityAccessibilityDelegate extends View.AccessibilityDelegate {

    /* renamed from: a, reason: collision with root package name */
    private final UnityPlayer f6494a;
    private final SurfaceView b;
    private AccessibilityManager c;
    private P d;
    private CaptioningManager e;
    private S f;
    private int g = -1;
    private int h = -1;
    private boolean i = false;
    private float j = 1.0f;
    private final N k = new N(this);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int[] getRootNodeIds();

    /* JADX INFO: Access modifiers changed from: private */
    public static native int hitTest(float f, float f2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean isNodeDismissable(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean isNodeInvokable(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean isNodeScrollable(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean isNodeSlider(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onClosedCaptioningStatusChanged(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onFontScaleChanged(float f);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean onNodeDecremented(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean onNodeDismissed(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onNodeFocusChanged(int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean onNodeIncremented(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean onNodeInvoked(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean onNodeScrolled(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onScreenReaderStatusChanged(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean populateNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo, int i, View view);

    UnityAccessibilityDelegate(UnityPlayer unityPlayer) {
        this.f6494a = unityPlayer;
        this.b = unityPlayer.getSurfaceView();
    }

    protected static UnityAccessibilityDelegate init(UnityPlayer unityPlayer) {
        UnityAccessibilityDelegate unityAccessibilityDelegate = new UnityAccessibilityDelegate(unityPlayer);
        unityAccessibilityDelegate.c = (AccessibilityManager) unityAccessibilityDelegate.f6494a.getContext().getSystemService("accessibility");
        CaptioningManager captioningManager = (CaptioningManager) unityAccessibilityDelegate.f6494a.getContext().getSystemService("captioning");
        unityAccessibilityDelegate.e = captioningManager;
        if (unityAccessibilityDelegate.c != null || captioningManager != null) {
            Semaphore semaphore = new Semaphore(0);
            unityAccessibilityDelegate.f6494a.runOnUiThread(new E(unityAccessibilityDelegate, semaphore));
            try {
                semaphore.acquire();
            } catch (InterruptedException unused) {
            }
        }
        unityAccessibilityDelegate.j = unityAccessibilityDelegate.f6494a.getContext().getResources().getConfiguration().fontScale;
        unityAccessibilityDelegate.f6494a.setAccessibilityDelegate(unityAccessibilityDelegate);
        return unityAccessibilityDelegate;
    }

    protected void cleanup() {
        P p = this.d;
        if (p != null) {
            p.cleanup();
        }
        S s = this.f;
        if (s != null) {
            s.cleanup();
        }
        this.f6494a.setAccessibilityDelegate(null);
    }

    public final void a(Configuration configuration) {
        float f = configuration.fontScale;
        if (f != this.j) {
            this.j = f;
            UnityPlayer unityPlayer = this.f6494a;
            Objects.requireNonNull(unityPlayer);
            this.f6494a.invokeOnMainThread((Runnable) new F(unityPlayer, configuration));
        }
    }

    protected boolean sendAnnouncementForVirtualViewId(int i, String str) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
        obtain.setEnabled(true);
        obtain.setSource(this.b, i);
        obtain.getText().add(str);
        return sendAccessibilityEvent(obtain);
    }

    protected boolean sendEventForVirtualViewIdFromNative(int i, int i2) {
        this.f6494a.runOnUiThread(new G(this, i, i2));
        return true;
    }

    protected boolean sendEventForVirtualViewId(int i, int i2) {
        if (!this.c.isEnabled()) {
            return false;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        obtain.setEnabled(true);
        obtain.setSource(this.b, i);
        if (i2 == 2048) {
            obtain.setContentChangeTypes(1);
        }
        if (i2 == 32768) {
            if (this.g == i) {
                return false;
            }
            this.g = i;
            this.b.invalidate();
            UnityPlayer unityPlayer = this.f6494a;
            Objects.requireNonNull(unityPlayer);
            this.f6494a.invokeOnMainThread((Runnable) new H(unityPlayer, i));
        }
        if (i2 == 65536) {
            if (this.g == i) {
                this.g = -1;
            }
            this.b.invalidate();
            UnityPlayer unityPlayer2 = this.f6494a;
            Objects.requireNonNull(unityPlayer2);
            this.f6494a.invokeOnMainThread((Runnable) new I(unityPlayer2, i));
        }
        return sendAccessibilityEvent(obtain);
    }

    protected int getFocusedNodeId() {
        return this.g;
    }

    protected boolean sendAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ViewGroup viewGroup;
        if (accessibilityEvent == null || (viewGroup = (ViewGroup) this.b.getParent()) == null) {
            return false;
        }
        return viewGroup.requestSendAccessibilityEvent(this.b, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        return this.k;
    }

    public class a implements View.OnHoverListener {
        public a() {
        }

        @Override // android.view.View.OnHoverListener
        public final boolean onHover(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                int hitTest = UnityAccessibilityDelegate.hitTest(motionEvent.getX(), motionEvent.getY());
                UnityAccessibilityDelegate unityAccessibilityDelegate = UnityAccessibilityDelegate.this;
                int i = unityAccessibilityDelegate.h;
                if (i == hitTest) {
                    return true;
                }
                unityAccessibilityDelegate.h = hitTest;
                if (hitTest != -1) {
                    unityAccessibilityDelegate.sendEventForVirtualViewId(hitTest, 128);
                }
                if (i == -1) {
                    return true;
                }
                unityAccessibilityDelegate.sendEventForVirtualViewId(i, 256);
                return true;
            }
            if (action == 10) {
                UnityAccessibilityDelegate unityAccessibilityDelegate2 = UnityAccessibilityDelegate.this;
                int i2 = unityAccessibilityDelegate2.h;
                if (i2 == -1) {
                    return true;
                }
                unityAccessibilityDelegate2.h = -1;
                if (i2 == -1) {
                    return true;
                }
                unityAccessibilityDelegate2.sendEventForVirtualViewId(i2, 256);
                return true;
            }
            Log.i("a11y", "hover unknown" + motionEvent.toString());
            return true;
        }
    }
}
