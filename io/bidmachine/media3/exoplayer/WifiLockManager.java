package io.bidmachine.media3.exoplayer;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.ironsource.Z3;
import io.bidmachine.media3.common.util.Clock;
import io.bidmachine.media3.common.util.HandlerWrapper;
import io.bidmachine.media3.common.util.Log;

/* loaded from: classes7.dex */
final class WifiLockManager {
    private static final String TAG = "WifiLockManager";
    private static final String WIFI_LOCK_TAG = "ExoPlayer:WifiLockManager";
    private boolean enabled;
    private boolean stayAwake;
    private final HandlerWrapper wifiLockHandler;
    private final WifiLockManagerInternal wifiLockManagerInternal;

    public WifiLockManager(Context context, Looper looper, Clock clock) {
        this.wifiLockManagerInternal = new WifiLockManagerInternal(context.getApplicationContext());
        this.wifiLockHandler = clock.createHandler(looper, null);
    }

    public void setEnabled(final boolean z) {
        if (this.enabled == z) {
            return;
        }
        this.enabled = z;
        final boolean z2 = this.stayAwake;
        this.wifiLockHandler.post(new Runnable() { // from class: io.bidmachine.media3.exoplayer.WifiLockManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                WifiLockManager.this.m9772xa2bbebf7(z, z2);
            }
        });
    }

    /* renamed from: lambda$setEnabled$0$io-bidmachine-media3-exoplayer-WifiLockManager, reason: not valid java name */
    /* synthetic */ void m9772xa2bbebf7(boolean z, boolean z2) {
        this.wifiLockManagerInternal.updateWifiLock(z, z2);
    }

    public void setStayAwake(final boolean z) {
        if (this.stayAwake == z) {
            return;
        }
        this.stayAwake = z;
        if (this.enabled) {
            this.wifiLockHandler.post(new Runnable() { // from class: io.bidmachine.media3.exoplayer.WifiLockManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    WifiLockManager.this.m9773xf76ca08b(z);
                }
            });
        }
    }

    /* renamed from: lambda$setStayAwake$1$io-bidmachine-media3-exoplayer-WifiLockManager, reason: not valid java name */
    /* synthetic */ void m9773xf76ca08b(boolean z) {
        this.wifiLockManagerInternal.updateWifiLock(true, z);
    }

    private static final class WifiLockManagerInternal {
        private final Context applicationContext;
        private WifiManager.WifiLock wifiLock;

        public WifiLockManagerInternal(Context context) {
            this.applicationContext = context;
        }

        public void updateWifiLock(boolean z, boolean z2) {
            if (z && this.wifiLock == null) {
                WifiManager wifiManager = (WifiManager) this.applicationContext.getApplicationContext().getSystemService(Z3.b);
                if (wifiManager == null) {
                    Log.w(WifiLockManager.TAG, "WifiManager is null, therefore not creating the WifiLock.");
                    return;
                } else {
                    WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(3, WifiLockManager.WIFI_LOCK_TAG);
                    this.wifiLock = createWifiLock;
                    createWifiLock.setReferenceCounted(false);
                }
            }
            WifiManager.WifiLock wifiLock = this.wifiLock;
            if (wifiLock == null) {
                return;
            }
            if (z && z2) {
                wifiLock.acquire();
            } else {
                wifiLock.release();
            }
        }
    }
}
