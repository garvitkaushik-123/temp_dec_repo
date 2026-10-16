package com.lofelt.haptics;

import android.content.Context;
import android.os.Vibrator;
import android.util.Log;

/* loaded from: classes6.dex */
public class LofeltHaptics {
    private static final String LOG_TAG = "lofelt-sdk";
    private final Context context;
    private long controllerHandle;

    private native long create(Object obj);

    private native void destroy(long j);

    static boolean deviceSupportsMinimumPlatformVersion() {
        return true;
    }

    private native float getClipDuration(long j);

    private native void load(long j, byte[] bArr);

    private native void loop(long j, boolean z);

    private native void play(long j);

    private native void seek(long j, float f);

    private native void setAmplitudeMultiplication(long j, float f);

    private native void stop(long j);

    static {
        if (deviceSupportsMinimumPlatformVersion()) {
            Log.d(LOG_TAG, "Initializing Lofelt SDK version null");
            System.loadLibrary("lofelt_sdk");
        } else {
            Log.d(LOG_TAG, "Lofelt SDK shared library was not loaded. It only can be loaded from API level 26 on");
        }
    }

    public LofeltHaptics(Context context) {
        this.controllerHandle = 0L;
        Log.d(LOG_TAG, "Creating LofeltHaptics instance");
        this.context = context;
        if (deviceMeetsMinimumRequirements()) {
            this.controllerHandle = create(new Player(context));
        }
    }

    protected void finalize() throws Throwable {
        try {
            Log.d(LOG_TAG, "Finalizing LofeltHaptics instance");
            if (deviceMeetsMinimumRequirements()) {
                destroy(this.controllerHandle);
            }
            this.controllerHandle = 0L;
        } catch (RuntimeException e) {
            Log.e(LOG_TAG, "Error finalizing LofeltHaptics: " + e);
        } finally {
            super.finalize();
        }
    }

    public long getControllerHandle() {
        return this.controllerHandle;
    }

    public boolean deviceMeetsMinimumRequirements() {
        Vibrator vibrator;
        return deviceSupportsMinimumPlatformVersion() && (vibrator = (Vibrator) this.context.getSystemService("vibrator")) != null && vibrator.hasVibrator() && vibrator.hasAmplitudeControl();
    }

    public void load(byte[] bArr) {
        if (deviceMeetsMinimumRequirements()) {
            load(this.controllerHandle, bArr);
        }
    }

    public void play() {
        if (!deviceMeetsMinimumRequirements()) {
            throw new RuntimeException("Unable to play, device doesn't meet the minimum requirements to play haptics");
        }
        play(this.controllerHandle);
    }

    public void stop() {
        if (deviceMeetsMinimumRequirements()) {
            stop(this.controllerHandle);
        }
    }

    public void seek(float f) {
        if (deviceMeetsMinimumRequirements()) {
            seek(this.controllerHandle, f);
        }
    }

    public void loop(boolean z) {
        if (deviceMeetsMinimumRequirements()) {
            loop(this.controllerHandle, z);
        }
    }

    public void setAmplitudeMultiplication(float f) {
        if (deviceMeetsMinimumRequirements()) {
            setAmplitudeMultiplication(this.controllerHandle, f);
        }
    }

    public float getClipDuration() {
        if (deviceMeetsMinimumRequirements()) {
            return getClipDuration(this.controllerHandle);
        }
        return 0.0f;
    }
}
