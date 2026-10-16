package io.voodoo.tools.thermalstate;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;

/* loaded from: classes8.dex */
public class ThermalStateService {
    private static final String TAG = "ThermalStateService";
    private PowerManager powerManager;

    public ThermalStateService(Context context) {
        initializePowerManager(context);
    }

    private void initializePowerManager(Context context) {
        try {
            if (this.powerManager == null) {
                this.powerManager = (PowerManager) context.getSystemService("power");
            }
            if (this.powerManager == null) {
                Log.e(TAG, "Could not read Power Manager: Android native function 'getSystemService' returns null");
            }
        } catch (Exception e) {
            Log.e(TAG, "initialize Power Manager error ", e);
        }
    }

    public int tryGetThermalStateValue() {
        try {
            if (this.powerManager == null) {
                return -1;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                return this.powerManager.getCurrentThermalStatus();
            }
            return -2;
        } catch (Exception unused) {
            return -1;
        }
    }
}
