package com.instagram.common.viewpoint.core;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* renamed from: com.facebook.ads.redexgen.X.Tl, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1349Tl implements SensorEventListener {
    public C1349Tl() {
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] unused = C1351Tn.A0A = sensorEvent.values;
        C1351Tn.A06();
    }
}
