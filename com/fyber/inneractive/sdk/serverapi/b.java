package com.fyber.inneractive.sdk.serverapi;

import android.app.NotificationManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.ext.SdkExtensions;
import android.provider.Settings;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.l0;
import com.fyber.inneractive.sdk.config.q0;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.t0;
import com.fyber.inneractive.sdk.config.x0;
import com.fyber.inneractive.sdk.util.o;
import com.ironsource.C3251pc;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1730a = new a();
    public static final List b = Arrays.asList("POWER_SAVE_MODE_OPEN", "SmartModeStatus");

    public static String a(float f) {
        return f < 5.0f ? "1" : f <= 9.0f ? "2" : f <= 24.0f ? "3" : f <= 39.0f ? "4" : f <= 54.0f ? CampaignEx.CLICKMODE_ON : f <= 69.0f ? "6" : f <= 84.0f ? C3251pc.e : f <= 100.0f ? "8" : "";
    }

    public static String b() {
        try {
            if (o.f1770a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")) == null) {
                return "";
            }
            return a((r1.getIntExtra("level", -1) * 100) / r1.getIntExtra("scale", -1));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static Long c() {
        long j;
        x0 x0Var = IAConfigManager.O.x;
        x0Var.getClass();
        try {
            String str = "";
            String str2 = (String) x0Var.c.get("SESSION_STAMP");
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            j = Long.parseLong(str);
        } catch (Exception unused) {
            j = 0;
        }
        return Long.valueOf(TimeUnit.SECONDS.convert(SystemClock.elapsedRealtime() - j, TimeUnit.MILLISECONDS));
    }

    public static String d() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public static Long e() {
        try {
            return Long.valueOf(TimeUnit.MINUTES.convert(Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()), TimeUnit.MILLISECONDS));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean f() {
        try {
            return Boolean.valueOf(Settings.System.getInt(o.f1770a.getContentResolver(), "airplane_mode_on", 0) != 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean g() {
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        boolean z2 = i >= 34 && o.a("android.permission.BLUETOOTH_CONNECT");
        if (i < 34 && o.a("android.permission.BLUETOOTH")) {
            z = true;
        }
        if (!z2 && !z) {
            return null;
        }
        try {
            BluetoothAdapter adapter = ((BluetoothManager) o.f1770a.getSystemService("bluetooth")).getAdapter();
            if (adapter.getProfileConnectionState(1) != 2 && adapter.getProfileConnectionState(2) != 2) {
                return null;
            }
            return Boolean.TRUE;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean h() {
        return Boolean.valueOf((o.f1770a.getResources().getConfiguration().uiMode & 48) == 32);
    }

    public static Boolean i() {
        int intExtra;
        try {
            Intent registerReceiver = o.f1770a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            boolean z = false;
            if (registerReceiver != null && ((intExtra = registerReceiver.getIntExtra("plugged", -1)) == 1 || intExtra == 2 || intExtra == 4)) {
                z = true;
            }
            return Boolean.valueOf(z);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean j() {
        try {
            AudioManager audioManager = (AudioManager) o.f1770a.getSystemService("audio");
            if (audioManager != null) {
                return Boolean.valueOf(audioManager.getStreamVolume(3) == 0);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean k() {
        try {
            int ringerMode = ((AudioManager) o.f1770a.getSystemService("audio")).getRingerMode();
            boolean z = true;
            if (ringerMode != 0 && ringerMode != 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean l() {
        try {
            int currentInterruptionFilter = ((NotificationManager) o.f1770a.getSystemService("notification")).getCurrentInterruptionFilter();
            return Boolean.valueOf(currentInterruptionFilter >= 2 && currentInterruptionFilter <= 4);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean m() {
        try {
            boolean z = false;
            for (AudioDeviceInfo audioDeviceInfo : ((AudioManager) o.f1770a.getSystemService("audio")).getDevices(2)) {
                if (audioDeviceInfo.getType() == 22 || audioDeviceInfo.getType() == 11 || audioDeviceInfo.getType() == 12 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 3) {
                    z = true;
                }
            }
            return Boolean.valueOf(z);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean n() {
        Integer num;
        try {
            String upperCase = Build.MANUFACTURER.toUpperCase(Locale.getDefault());
            if (TextUtils.isEmpty(upperCase) || !f1730a.containsKey(upperCase)) {
                return Boolean.valueOf(((PowerManager) o.f1770a.getSystemService("power")).isPowerSaveMode());
            }
            try {
                Iterator it = b.iterator();
                while (it.hasNext()) {
                    int i = Settings.System.getInt(o.f1770a.getContentResolver(), (String) it.next(), -1);
                    if (i != -1 && (num = (Integer) f1730a.get(upperCase)) != null) {
                        return Boolean.valueOf(num.intValue() == i);
                    }
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static UnitDisplayType a(String str) {
        r0 r0Var;
        UnitDisplayType unitDisplayType = UnitDisplayType.INTERSTITIAL;
        IAConfigManager iAConfigManager = IAConfigManager.O;
        HashMap hashMap = iAConfigManager.f1068a;
        q0 q0Var = (hashMap == null || !hashMap.containsKey(str)) ? null : (q0) iAConfigManager.f1068a.get(str);
        if (q0Var != null && q0Var.f1113a.size() > 0 && (r0Var = (r0) q0Var.f1113a.get(0)) != null) {
            t0 t0Var = r0Var.f;
            l0 l0Var = r0Var.c;
            if (t0Var != null) {
                return t0Var.j;
            }
            if (l0Var != null) {
                return l0Var.b;
            }
        }
        return unitDisplayType;
    }

    public static Integer a() {
        Integer valueOf = Build.VERSION.SDK_INT >= 30 ? Integer.valueOf(SdkExtensions.getExtensionVersion(1000000)) : null;
        if (valueOf == null || valueOf.intValue() == 0) {
            return null;
        }
        return valueOf;
    }
}
