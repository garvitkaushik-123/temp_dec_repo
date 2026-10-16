package com.bytedance.sdk.openadsdk.Xb;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.os.Vibrator;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class aAs {
    public static WeakReference<eli> eli;
    protected static final float[] DbA = new float[3];
    protected static final float[] Os = new float[3];
    protected static final float[] aGH = new float[9];
    protected static final float[] ui = new float[3];

    public static void eli(Context context, SensorEventListener sensorEventListener) {
    }

    public static void eli(eli eliVar) {
        eli = new WeakReference<>(eliVar);
    }

    public static void eli(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<eli> weakReference = eli;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th) {
            kb.eli("SensorHub", "startListenAccelerometer error", th);
        }
    }

    public static void DbA(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<eli> weakReference = eli;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th) {
            kb.eli("SensorHub", "startListenGyroscope error", th);
        }
    }

    public static void Os(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<eli> weakReference = eli;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th) {
            kb.eli("SensorHub", "startListenLinearAcceleration error", th);
        }
    }

    public static void aGH(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<eli> weakReference = eli;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th) {
            kb.eli("SensorHub", "startListenRotationVector err", th);
        }
    }

    public static void eli(Context context, long j) {
        if (context == null) {
            return;
        }
        ((Vibrator) context.getSystemService("vibrator")).vibrate(j);
    }
}
