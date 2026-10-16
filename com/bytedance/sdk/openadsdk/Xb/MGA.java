package com.bytedance.sdk.openadsdk.Xb;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MGA {
    private WeakReference<wC> DbA;
    private Context eli;
    private Map<String, eli> Os = new HashMap();
    private SensorEventListener aGH = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            wC aGH;
            if (sensorEvent.sensor.getType() != 1 || (aGH = MGA.this.aGH()) == null) {
                return;
            }
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(VastAttributes.HORIZONTAL_POSITION, f);
                jSONObject.put(VastAttributes.VERTICAL_POSITION, f2);
                jSONObject.put("z", f3);
                aGH.eli("accelerometer_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener ui = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.12
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            wC aGH;
            if (sensorEvent.sensor.getType() != 4 || (aGH = MGA.this.aGH()) == null) {
                return;
            }
            float degrees = (float) Math.toDegrees(sensorEvent.values[0]);
            float degrees2 = (float) Math.toDegrees(sensorEvent.values[1]);
            float degrees3 = (float) Math.toDegrees(sensorEvent.values[2]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(VastAttributes.HORIZONTAL_POSITION, degrees);
                jSONObject.put(VastAttributes.VERTICAL_POSITION, degrees2);
                jSONObject.put("z", degrees3);
                aGH.eli("gyro_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener MGA = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.23
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            wC aGH;
            if (sensorEvent.sensor.getType() != 10 || (aGH = MGA.this.aGH()) == null) {
                return;
            }
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(VastAttributes.HORIZONTAL_POSITION, f);
                jSONObject.put(VastAttributes.VERTICAL_POSITION, f2);
                jSONObject.put("z", f3);
                aGH.eli("accelerometer_grativityless_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener kb = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.34
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                System.arraycopy(sensorEvent.values, 0, aAs.DbA, 0, aAs.DbA.length);
            } else if (sensorEvent.sensor.getType() == 2) {
                System.arraycopy(sensorEvent.values, 0, aAs.Os, 0, aAs.Os.length);
            }
            SensorManager.getRotationMatrix(aAs.aGH, null, aAs.DbA, aAs.Os);
            SensorManager.getOrientation(aAs.aGH, aAs.ui);
            wC aGH = MGA.this.aGH();
            if (aGH == null) {
                return;
            }
            float f = aAs.ui[0];
            float f2 = aAs.ui[1];
            float f3 = aAs.ui[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("alpha", f);
                jSONObject.put("beta", f2);
                jSONObject.put("gamma", f3);
                aGH.eli("rotation_vector_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };

    interface eli {
        JSONObject eli(JSONObject jSONObject) throws Throwable;
    }

    public MGA(wC wCVar) {
        this.eli = wCVar.eli();
        this.DbA = new WeakReference<>(wCVar);
        Os();
    }

    public Set<String> eli() {
        return this.Os.keySet();
    }

    private void Os() {
        this.Os.put("adInfo", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.45
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                if (aGH != null) {
                    JSONObject QX = aGH.QX();
                    if (QX != null) {
                        QX.put("code", 1);
                        return QX;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", -1);
                return jSONObject3;
            }
        });
        this.Os.put("appInfo", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.56
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.6.0");
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = MGA.this.eli().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put("supportList", jSONArray);
                wC aGH = MGA.this.aGH();
                if (aGH != null) {
                    jSONObject2.put("deviceId", aGH.kb());
                    jSONObject2.put("netType", aGH.aqO());
                    jSONObject2.put("innerAppName", aGH.aGH());
                    jSONObject2.put("appName", aGH.ui());
                    jSONObject2.put(C3040d4.i.W, aGH.MGA());
                    Map<String, String> DbA = aGH.DbA();
                    for (String str : DbA.keySet()) {
                        jSONObject2.put(str, DbA.get(str));
                    }
                }
                return jSONObject2;
            }
        });
        this.Os.put("playableSDKInfo", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.62
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.6.0");
                jSONObject2.put(N6.F, "android");
                return jSONObject2;
            }
        });
        this.Os.put("subscribe_app_ad", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.63
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.Xb.eli ui = MGA.this.ui();
                JSONObject jSONObject2 = new JSONObject();
                if (ui == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("download_app_ad", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.64
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.Xb.eli ui = MGA.this.ui();
                JSONObject jSONObject2 = new JSONObject();
                if (ui == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put(C3040d4.h.o, new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.2
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                if (aGH == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("viewStatus", aGH.FC());
                return jSONObject3;
            }
        });
        this.Os.put("getVolume", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.3
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                if (aGH == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("endcard_mute", aGH.wC());
                return jSONObject3;
            }
        });
        this.Os.put("getScreenSize", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.4
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                if (aGH == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject nGm = aGH.nGm();
                nGm.put("code", 1);
                return nGm;
            }
        });
        this.Os.put("start_accelerometer_observer", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.5
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i = 2;
                if (jSONObject != null) {
                    try {
                        i = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        kb.eli("PlayableJsBridge", "invoke start_accelerometer_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                aAs.eli(MGA.this.eli, MGA.this.aGH, i);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("close_accelerometer_observer", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.6
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    aAs.eli(MGA.this.eli, MGA.this.aGH);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    kb.eli("PlayableJsBridge", "invoke close_accelerometer_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.Os.put("start_gyro_observer", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.7
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i = 2;
                if (jSONObject != null) {
                    try {
                        i = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        kb.eli("PlayableJsBridge", "invoke start_gyro_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                aAs.DbA(MGA.this.eli, MGA.this.ui, i);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("close_gyro_observer", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.8
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    aAs.eli(MGA.this.eli, MGA.this.ui);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    kb.eli("PlayableJsBridge", "invoke close_gyro_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.Os.put("start_accelerometer_grativityless_observer", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.9
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i = 2;
                if (jSONObject != null) {
                    try {
                        i = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        kb.eli("PlayableJsBridge", "invoke start_accelerometer_grativityless_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                aAs.Os(MGA.this.eli, MGA.this.MGA, i);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("close_accelerometer_grativityless_observer", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.10
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    aAs.eli(MGA.this.eli, MGA.this.MGA);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    kb.eli("PlayableJsBridge", "invoke close_accelerometer_grativityless_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.Os.put("start_rotation_vector_observer", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.11
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i = 2;
                if (jSONObject != null) {
                    try {
                        i = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        kb.eli("PlayableJsBridge", "invoke start_rotation_vector_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                aAs.aGH(MGA.this.eli, MGA.this.kb, i);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("close_rotation_vector_observer", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.13
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    aAs.eli(MGA.this.eli, MGA.this.kb);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    kb.eli("PlayableJsBridge", "invoke close_rotation_vector_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.Os.put("device_shake", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.14
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    aAs.eli(MGA.this.eli, 300L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    kb.eli("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.Os.put("device_shake_short", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.15
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    aAs.eli(MGA.this.eli, 150L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    kb.eli("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.Os.put("playable_style", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.16
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH != null) {
                    JSONObject Os = aGH.Os();
                    Os.put("code", 1);
                    return Os;
                }
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
        });
        this.Os.put("sendReward", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.17
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH != null) {
                    aGH.bf();
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                }
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
        });
        this.Os.put("playableInteractionTriggered", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.18
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH != null) {
                    aGH.CMM();
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                }
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
        });
        this.Os.put("webview_time_track", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.19
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                return new JSONObject();
            }
        });
        this.Os.put("playable_event", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.20
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null || jSONObject == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                aGH.DbA(jSONObject.optString("event", null), jSONObject.optJSONObject("params"));
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("reportAd", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.21
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("close", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.22
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("openAdLandPageLinks", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.24
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("get_viewport", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.25
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject Xb = aGH.Xb();
                Xb.put("code", 1);
                return Xb;
            }
        });
        this.Os.put("jssdk_load_finish", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.26
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                aGH.oWW();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_material_render_result", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.27
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                aGH.FC(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("detect_change_playable_click", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.28
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject aAs = aGH.aAs();
                aAs.put("code", 1);
                return aAs;
            }
        });
        this.Os.put("check_camera_permission", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.29
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject NU = aGH.NU();
                NU.put("code", 1);
                return NU;
            }
        });
        this.Os.put("check_external_storage", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.30
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject nn = aGH.nn();
                if (nn.isNull("result")) {
                    nn.put("code", -1);
                    return nn;
                }
                nn.put("code", 1);
                return nn;
            }
        });
        this.Os.put("playable_open_camera", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.31
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_pick_photo", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.32
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_download_media_in_photos", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.33
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                aGH.eli(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_preventTouchEvent", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.35
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                aGH.DbA(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_settings_info", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.36
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject Dfc = aGH.Dfc();
                Dfc.put("code", 1);
                return Dfc;
            }
        });
        this.Os.put("playable_load_main_scene", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.37
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                aGH.ev();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_enter_section", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.38
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                aGH.aGH(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_end", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.39
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                aGH.Vy();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_finish_play_playable", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.40
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                aGH.gG();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_transfrom_module_show", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.41
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                aGH.ujq();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_transfrom_module_change_color", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.42
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                aGH.Ue();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_set_scroll_rect", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.43
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_click_area", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.44
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                aGH.ui(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_real_play_start", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.46
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_material_first_frame_show", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.47
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                aGH.KM();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_stuck_check_pong", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.48
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                aGH.VM();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_material_adnormal_mask", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.49
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                aGH.MGA(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_long_press_panel", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.50
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_alpha_player_play", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.51
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_transfrom_module_highlight", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.52
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_send_click_event", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.53
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_query_media_permission_declare", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.54
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject kb = aGH.kb(jSONObject);
                kb.put("code", 1);
                return kb;
            }
        });
        this.Os.put("playable_query_media_permission_enable", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.55
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                wC aGH = MGA.this.aGH();
                JSONObject jSONObject2 = new JSONObject();
                if (aGH == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject wC = aGH.wC(jSONObject);
                wC.put("code", 1);
                return wC;
            }
        });
        this.Os.put("playable_apply_media_permission", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.57
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.Xb.eli ui = MGA.this.ui();
                JSONObject jSONObject2 = new JSONObject();
                if (ui == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_start_kws", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.58
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.Xb.eli ui = MGA.this.ui();
                JSONObject jSONObject2 = new JSONObject();
                if (ui == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_close_kws", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.59
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.Xb.eli ui = MGA.this.ui();
                JSONObject jSONObject2 = new JSONObject();
                if (ui == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_video_preload_task_add", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.60
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.Xb.eli ui = MGA.this.ui();
                JSONObject jSONObject2 = new JSONObject();
                if (ui == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.Os.put("playable_video_preload_task_cancel", new eli() { // from class: com.bytedance.sdk.openadsdk.Xb.MGA.61
            @Override // com.bytedance.sdk.openadsdk.Xb.MGA.eli
            public JSONObject eli(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.Xb.eli ui = MGA.this.ui();
                JSONObject jSONObject2 = new JSONObject();
                if (ui == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public wC aGH() {
        WeakReference<wC> weakReference = this.DbA;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.Xb.eli ui() {
        wC aGH = aGH();
        if (aGH == null) {
            return null;
        }
        return aGH.dV();
    }

    public JSONObject eli(String str, JSONObject jSONObject) {
        try {
            eli eliVar = this.Os.get(str);
            if (eliVar == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
            return eliVar.eli(jSONObject);
        } catch (Throwable th) {
            kb.eli("PlayableJsBridge", "invoke error", th);
            return null;
        }
    }

    public void DbA() {
        aAs.eli(this.eli, this.aGH);
        aAs.eli(this.eli, this.ui);
        aAs.eli(this.eli, this.MGA);
        aAs.eli(this.eli, this.kb);
    }
}
