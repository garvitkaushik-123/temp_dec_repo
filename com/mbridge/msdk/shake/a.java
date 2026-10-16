package com.mbridge.msdk.shake;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.foundation.tools.p0;
import org.json.JSONObject;

/* compiled from: NativeShakeManager.java */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private SensorManager f4713a;

    /* compiled from: NativeShakeManager.java */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        static a f4714a = new a();
    }

    public static a a() {
        return b.f4714a;
    }

    public void b(SensorEventListener sensorEventListener) {
        SensorManager sensorManager = this.f4713a;
        if (sensorManager != null) {
            try {
                sensorManager.unregisterListener(sensorEventListener);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private a() {
    }

    public void a(SensorEventListener sensorEventListener) {
        a(sensorEventListener, null, 2);
    }

    public void a(SensorEventListener sensorEventListener, Sensor sensor, int i) {
        Context d = c.m().d();
        if (d != null) {
            try {
                if (this.f4713a == null) {
                    this.f4713a = (SensorManager) d.getSystemService("sensor");
                }
                if (sensor == null) {
                    sensor = this.f4713a.getDefaultSensor(1);
                }
                this.f4713a.registerListener(sensorEventListener, sensor, i);
            } catch (Exception e) {
                e.printStackTrace();
                a(d, e.getMessage());
            }
        }
    }

    private static void a(Context context, String str) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(C3040d4.h.W, "2000106");
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V)) {
                    jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
                }
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.g)) {
                    jSONObject.put("c", com.mbridge.msdk.foundation.same.a.g);
                }
                jSONObject.put("reason", str);
                d.b().a(jSONObject);
            } catch (Throwable th) {
                p0.b("NativeShakeManager", th.getMessage());
            }
        }
    }
}
