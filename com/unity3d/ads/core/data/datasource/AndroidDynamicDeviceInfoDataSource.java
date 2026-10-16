package com.unity3d.ads.core.data.datasource;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.autofill.HintConstants;
import com.ironsource.C3040d4;
import com.ironsource.Z3;
import com.unity3d.services.core.device.AdvertisingId;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.device.OpenAdvertisingId;
import com.unity3d.services.core.log.DeviceLog;
import gatewayprotocol.v1.DynamicDeviceInfoKt;
import gatewayprotocol.v1.DynamicDeviceInfoOuterClass;
import gatewayprotocol.v1.NetworkCapabilityTransportsOuterClass;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: AndroidDynamicDeviceInfoDataSource.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 Y2\u00020\u0001:\u0001YB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\rH\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u001eJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\fH\u0016J\n\u0010#\u001a\u0004\u0018\u00010$H\u0002J\b\u0010%\u001a\u00020\u001eH\u0016J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0002J\u0006\u0010)\u001a\u00020'J\u0012\u0010*\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,H\u0003J\u0006\u0010-\u001a\u00020\rJ\b\u0010.\u001a\u00020\fH\u0002J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020\f00H\u0016J\u0010\u00101\u001a\u00020'2\u0006\u00102\u001a\u000203H\u0002J\u0012\u00104\u001a\u00020'2\b\u00105\u001a\u0004\u0018\u00010\fH\u0002J\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u00020\fJ\b\u00109\u001a\u00020\rH\u0002J\b\u0010:\u001a\u00020\fH\u0002J\b\u0010;\u001a\u00020\fH\u0002J\b\u0010<\u001a\u00020\u001eH\u0003J\b\u0010=\u001a\u00020\fH\u0016J\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bJ\b\u0010?\u001a\u00020\u001eH\u0016J\u0006\u0010@\u001a\u00020\u001eJ\b\u0010A\u001a\u00020\u001eH\u0002J\b\u0010B\u001a\u00020\u001eH\u0002J\u0006\u0010C\u001a\u00020\rJ\u000e\u0010D\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020\u001eJ\u0010\u0010F\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020\u001eH\u0002J\n\u0010G\u001a\u0004\u0018\u00010HH\u0002J\b\u0010I\u001a\u00020\fH\u0002J\b\u0010J\u001a\u00020'H\u0002J\u0006\u0010K\u001a\u00020'J\b\u0010L\u001a\u00020'H\u0002J\u0012\u0010M\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\b\u0010N\u001a\u00020\rH\u0016J\b\u0010O\u001a\u00020\rH\u0002J\b\u0010P\u001a\u00020\rH\u0003J\b\u0010Q\u001a\u00020\rH\u0002J\b\u0010R\u001a\u00020\rH\u0002J\b\u0010S\u001a\u00020\rH\u0002J\b\u0010T\u001a\u00020\rH\u0002J\b\u0010U\u001a\u00020\rH\u0002J\b\u0010V\u001a\u00020\rH\u0002J\b\u0010W\u001a\u00020\rH\u0002J\b\u0010X\u001a\u00020\rH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006Z"}, d2 = {"Lcom/unity3d/ads/core/data/datasource/AndroidDynamicDeviceInfoDataSource;", "Lcom/unity3d/ads/core/data/datasource/DynamicDeviceInfoDataSource;", "context", "Landroid/content/Context;", "lifecycleDataSource", "Lcom/unity3d/ads/core/data/datasource/LifecycleDataSource;", "(Landroid/content/Context;Lcom/unity3d/ads/core/data/datasource/LifecycleDataSource;)V", "getContext", "()Landroid/content/Context;", "reportedWarning", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "", "volumeSettingsChange", "Lkotlinx/coroutines/flow/Flow;", "Lcom/unity3d/ads/core/data/datasource/VolumeSettingsChange;", "getVolumeSettingsChange", "()Lkotlinx/coroutines/flow/Flow;", "adbStatus", "fetch", "Lgatewayprotocol/v1/DynamicDeviceInfoOuterClass$DynamicDeviceInfo;", "fetchAndroidDynamicDeviceInfo", "Lgatewayprotocol/v1/DynamicDeviceInfoOuterClass$DynamicDeviceInfo$Android;", "getAirplaneMode", "getAudioManager", "Landroid/media/AudioManager;", "getBatteryLevel", "", "getBatteryStatus", "", "getChargingType", "getConnectionType", "Lgatewayprotocol/v1/DynamicDeviceInfoOuterClass$ConnectionType;", "getConnectionTypeStr", "getConnectivityManager", "Landroid/net/ConnectivityManager;", "getCurrentUiTheme", "getElapsedRealtime", "", "getEventTimeStamp", "getFreeMemory", "getFreeSpace", C3040d4.h.b, "Ljava/io/File;", "getIsSdCardPresent", "getLanguage", "getLocaleList", "", "getMemoryInfo", "infoType", "Lcom/unity3d/services/core/device/Device$MemoryInfoType;", "getMemoryValueFromString", "memVal", "getNetworkCapabilityTransports", "Lgatewayprotocol/v1/NetworkCapabilityTransportsOuterClass$NetworkCapabilityTransports;", "getNetworkCountryISO", "getNetworkMetered", "getNetworkOperator", "getNetworkOperatorName", "getNetworkType", "getOrientation", "getProcessInfo", "getRingerMode", "getScreenBrightness", "getScreenHeight", "getScreenWidth", "getStayOnWhilePluggedIn", "getStreamMaxVolume", "streamType", "getStreamVolume", "getTelephonyManager", "Landroid/telephony/TelephonyManager;", "getTimeZone", "getTimeZoneOffset", "getTotalMemory", "getUptime", "getUsableSpace", "hasInternet", "hasInternetConnection", "hasInternetConnectionM", "isActiveNetworkConnected", "isAdbEnabled", "isAppActive", C3040d4.i.M, "isLimitOpenAdTrackingEnabled", "isUSBConnected", "isUsingWifi", "isWiredHeadsetOn", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidDynamicDeviceInfoDataSource implements DynamicDeviceInfoDataSource {
    public static final String DIRECTORY_MEM_INFO = "/proc/meminfo";
    public static final String DIRECTORY_MODE_READ = "r";
    public static final String DIRECTORY_PROCESS_INFO = "/proc/self/stat";
    public static final String INTENT_USB_STATE = "android.hardware.usb.action.USB_STATE";
    public static final String KEY_STAT_CONTENT = "stat";
    public static final String USB_EXTRA_CONNECTED = "connected";
    private final Context context;
    private final LifecycleDataSource lifecycleDataSource;
    private final MutableStateFlow<Map<String, Boolean>> reportedWarning;
    private final Flow<VolumeSettingsChange> volumeSettingsChange;

    /* compiled from: AndroidDynamicDeviceInfoDataSource.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Device.MemoryInfoType.values().length];
            try {
                iArr[Device.MemoryInfoType.TOTAL_MEMORY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Device.MemoryInfoType.FREE_MEMORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DynamicDeviceInfoOuterClass.ConnectionType.values().length];
            try {
                iArr2[DynamicDeviceInfoOuterClass.ConnectionType.CONNECTION_TYPE_WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[DynamicDeviceInfoOuterClass.ConnectionType.CONNECTION_TYPE_CELLULAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[DynamicDeviceInfoOuterClass.ConnectionType.CONNECTION_TYPE_UNSPECIFIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public AndroidDynamicDeviceInfoDataSource(Context context, LifecycleDataSource lifecycleDataSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleDataSource, "lifecycleDataSource");
        this.context = context;
        this.lifecycleDataSource = lifecycleDataSource;
        this.reportedWarning = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        this.volumeSettingsChange = FlowKt.callbackFlow(new AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1(this, null));
    }

    public final Context getContext() {
        return this.context;
    }

    private final DynamicDeviceInfoOuterClass.DynamicDeviceInfo.Android fetchAndroidDynamicDeviceInfo() {
        DynamicDeviceInfoKt dynamicDeviceInfoKt = DynamicDeviceInfoKt.INSTANCE;
        DynamicDeviceInfoKt.AndroidKt.Dsl.Companion companion = DynamicDeviceInfoKt.AndroidKt.Dsl.INSTANCE;
        DynamicDeviceInfoOuterClass.DynamicDeviceInfo.Android.Builder newBuilder = DynamicDeviceInfoOuterClass.DynamicDeviceInfo.Android.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        DynamicDeviceInfoKt.AndroidKt.Dsl _create = companion._create(newBuilder);
        _create.setNetworkConnected(isActiveNetworkConnected());
        _create.setNetworkType(getNetworkType());
        _create.setNetworkMetered(getNetworkMetered());
        _create.setTelephonyManagerNetworkType(getNetworkType());
        _create.setAdbEnabled(isAdbEnabled());
        _create.setUsbConnected(isUSBConnected());
        _create.setVolume(getStreamVolume(3));
        _create.setMaxVolume(getStreamMaxVolume(3));
        _create.setDeviceElapsedRealtime(getElapsedRealtime());
        _create.setDeviceUpTime(getUptime());
        _create.setAirplaneMode(getAirplaneMode());
        _create.setChargingType(getChargingType());
        _create.setStayOnWhilePluggedIn(getStayOnWhilePluggedIn());
        _create.setSdCardPresent(getIsSdCardPresent());
        _create.setNetworkCapabilityTransports(getNetworkCapabilityTransports());
        return _create._build();
    }

    private final String getLanguage() {
        String locale = Locale.getDefault().toString();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault().toString()");
        return locale;
    }

    private final String getTimeZone() {
        try {
            String displayName = TimeZone.getDefault().getDisplayName(false, 0, Locale.US);
            Intrinsics.checkNotNullExpressionValue(displayName, "{\n            TimeZone.g…ORT, Locale.US)\n        }");
            return displayName;
        } catch (AssertionError e) {
            DeviceLog.error("Could not read timeZone information: %s", e.getMessage());
            return "";
        }
    }

    private final long getTimeZoneOffset() {
        return TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000;
    }

    private final boolean isUsingWifi() {
        ConnectivityManager connectivityManager = getConnectivityManager();
        if (connectivityManager == null) {
            return false;
        }
        TelephonyManager telephonyManager = getTelephonyManager();
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && connectivityManager.getBackgroundDataSetting() && activeNetworkInfo.isConnected() && telephonyManager != null && activeNetworkInfo.getType() == 1 && activeNetworkInfo.isConnected();
    }

    private final DynamicDeviceInfoOuterClass.ConnectionType getConnectionType() {
        if (isUsingWifi()) {
            return DynamicDeviceInfoOuterClass.ConnectionType.CONNECTION_TYPE_WIFI;
        }
        if (isActiveNetworkConnected()) {
            return DynamicDeviceInfoOuterClass.ConnectionType.CONNECTION_TYPE_CELLULAR;
        }
        return DynamicDeviceInfoOuterClass.ConnectionType.CONNECTION_TYPE_UNSPECIFIED;
    }

    @Deprecated(message = "This method was deprecated in API level 30. Use getDataNetworkType()")
    private final int getNetworkType() {
        Map<String, Boolean> value;
        TelephonyManager telephonyManager = getTelephonyManager();
        if (telephonyManager != null) {
            try {
                return telephonyManager.getNetworkType();
            } catch (SecurityException unused) {
                if (!Intrinsics.areEqual((Object) this.reportedWarning.getValue().get("getNetworkType"), (Object) true)) {
                    MutableStateFlow<Map<String, Boolean>> mutableStateFlow = this.reportedWarning;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, MapsKt.plus(value, TuplesKt.to("getNetworkType", true))));
                    DeviceLog.warning("Unity Ads was not able to get current network type due to missing permission");
                }
            }
        }
        return -1;
    }

    private final boolean getNetworkMetered() {
        ConnectivityManager connectivityManager = getConnectivityManager();
        return connectivityManager != null && connectivityManager.isActiveNetworkMetered();
    }

    private final String getNetworkOperator() {
        TelephonyManager telephonyManager = getTelephonyManager();
        String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
        return networkOperator == null ? "" : networkOperator;
    }

    private final String getNetworkOperatorName() {
        TelephonyManager telephonyManager = getTelephonyManager();
        String networkOperatorName = telephonyManager != null ? telephonyManager.getNetworkOperatorName() : null;
        return networkOperatorName == null ? "" : networkOperatorName;
    }

    public final String getNetworkCountryISO() {
        TelephonyManager telephonyManager = getTelephonyManager();
        String networkCountryIso = telephonyManager != null ? telephonyManager.getNetworkCountryIso() : null;
        return networkCountryIso == null ? "" : networkCountryIso;
    }

    private final int getScreenWidth() {
        DisplayMetrics displayMetrics;
        Resources resources = this.context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return -1;
        }
        return displayMetrics.widthPixels;
    }

    private final int getScreenHeight() {
        DisplayMetrics displayMetrics;
        Resources resources = this.context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return -1;
        }
        return displayMetrics.heightPixels;
    }

    private final boolean isActiveNetworkConnected() {
        ConnectivityManager connectivityManager = getConnectivityManager();
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private final boolean isWiredHeadsetOn() {
        AudioManager audioManager = getAudioManager();
        return audioManager != null && audioManager.isWiredHeadsetOn();
    }

    @Override // com.unity3d.ads.core.data.datasource.DynamicDeviceInfoDataSource
    public int getRingerMode() {
        AudioManager audioManager = getAudioManager();
        if (audioManager != null) {
            return audioManager.getRingerMode();
        }
        return -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double getStreamVolume(int streamType) {
        return getAudioManager() != null ? r0.getStreamVolume(streamType) : -2;
    }

    public final double getStreamMaxVolume(int streamType) {
        return getAudioManager() != null ? r0.getStreamMaxVolume(streamType) : -2;
    }

    public final int getScreenBrightness() {
        return Settings.System.getInt(this.context.getContentResolver(), "screen_brightness", -1);
    }

    @Deprecated(message = "Legacy method, migrated from to .getUsableSpace()")
    private final long getFreeSpace(File file) {
        if (file == null || !file.exists()) {
            return -1L;
        }
        return MathKt.roundToInt(file.getFreeSpace() / 1024);
    }

    private final long getUsableSpace(File file) {
        if (file == null || !file.exists()) {
            return -1L;
        }
        return MathKt.roundToInt(file.getUsableSpace() / 1024);
    }

    private final double getBatteryLevel() {
        if (this.context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")) == null) {
            return -1.0d;
        }
        return r0.getIntExtra("level", 0) / r0.getIntExtra("scale", 0);
    }

    private final int getBatteryStatus() {
        Intent registerReceiver = this.context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return registerReceiver.getIntExtra("status", 0);
        }
        return -1;
    }

    public final long getTotalMemory() {
        return getMemoryInfo(Device.MemoryInfoType.TOTAL_MEMORY);
    }

    public final long getFreeMemory() {
        return getMemoryInfo(Device.MemoryInfoType.FREE_MEMORY);
    }

    private final long getMemoryInfo(Device.MemoryInfoType infoType) {
        int i = WhenMappings.$EnumSwitchMapping$0[infoType.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = -1;
            }
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(DIRECTORY_MEM_INFO, "r");
        try {
            RandomAccessFile randomAccessFile2 = randomAccessFile;
            String str = null;
            for (int i3 = 0; i3 < i2; i3++) {
                str = randomAccessFile2.readLine();
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(randomAccessFile, null);
            return getMemoryValueFromString(str);
        } finally {
        }
    }

    private final long getMemoryValueFromString(String memVal) {
        if (memVal == null) {
            return -1L;
        }
        Matcher matcher = Pattern.compile("(\\d+)").matcher(memVal);
        String str = null;
        while (matcher.find()) {
            str = matcher.group(1);
        }
        if (str != null) {
            return Long.parseLong(str);
        }
        return -1L;
    }

    private final boolean isAdbEnabled() {
        return adbStatus();
    }

    private final boolean adbStatus() {
        Boolean bool;
        try {
            boolean z = true;
            if (1 != Settings.Global.getInt(this.context.getContentResolver(), "adb_enabled", 0)) {
                z = false;
            }
            bool = Boolean.valueOf(z);
        } catch (Exception e) {
            DeviceLog.exception("Problems fetching adb enabled status", e);
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final boolean isUSBConnected() {
        Intent registerReceiver = this.context.registerReceiver(null, new IntentFilter(INTENT_USB_STATE));
        if (registerReceiver != null) {
            return registerReceiver.getBooleanExtra(USB_EXTRA_CONNECTED, false);
        }
        return false;
    }

    private final long getUptime() {
        return SystemClock.uptimeMillis();
    }

    private final long getElapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public final Map<String, String> getProcessInfo() {
        HashMap hashMap = new HashMap();
        RandomAccessFile randomAccessFile = new RandomAccessFile(DIRECTORY_PROCESS_INFO, "r");
        try {
            String statContent = randomAccessFile.readLine();
            Intrinsics.checkNotNullExpressionValue(statContent, "statContent");
            hashMap.put(KEY_STAT_CONTENT, statContent);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(randomAccessFile, null);
            return hashMap;
        } finally {
        }
    }

    private final boolean isLimitAdTrackingEnabled() {
        return AdvertisingId.getLimitedAdTracking();
    }

    private final boolean isLimitOpenAdTrackingEnabled() {
        return OpenAdvertisingId.getLimitedOpenAdTracking();
    }

    private final boolean isAppActive() {
        return this.lifecycleDataSource.appIsForeground();
    }

    private final long getEventTimeStamp() {
        return System.currentTimeMillis() / 1000;
    }

    private final TelephonyManager getTelephonyManager() {
        Object systemService = this.context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        if (systemService instanceof TelephonyManager) {
            return (TelephonyManager) systemService;
        }
        return null;
    }

    private final ConnectivityManager getConnectivityManager() {
        Object systemService = this.context.getSystemService("connectivity");
        if (systemService instanceof ConnectivityManager) {
            return (ConnectivityManager) systemService;
        }
        return null;
    }

    private final AudioManager getAudioManager() {
        Object systemService = this.context.getSystemService("audio");
        if (systemService instanceof AudioManager) {
            return (AudioManager) systemService;
        }
        return null;
    }

    @Override // com.unity3d.ads.core.data.datasource.DynamicDeviceInfoDataSource
    public boolean hasInternet() {
        return hasInternetConnectionM();
    }

    private final boolean hasInternetConnection() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = getConnectivityManager();
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }

    private final boolean hasInternetConnectionM() {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = getConnectivityManager();
        return connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16);
    }

    @Override // com.unity3d.ads.core.data.datasource.DynamicDeviceInfoDataSource
    public Flow<VolumeSettingsChange> getVolumeSettingsChange() {
        return this.volumeSettingsChange;
    }

    @Override // com.unity3d.ads.core.data.datasource.DynamicDeviceInfoDataSource
    public String getOrientation() {
        if (getScreenHeight() > getScreenWidth()) {
            return C3040d4.h.D;
        }
        return C3040d4.h.C;
    }

    @Override // com.unity3d.ads.core.data.datasource.DynamicDeviceInfoDataSource
    public String getConnectionTypeStr() {
        int i = WhenMappings.$EnumSwitchMapping$1[getConnectionType().ordinal()];
        if (i == 1) {
            return Z3.b;
        }
        if (i == 2) {
            return Z3.g;
        }
        return "none";
    }

    @Override // com.unity3d.ads.core.data.datasource.DynamicDeviceInfoDataSource
    public int getCurrentUiTheme() {
        return this.context.getResources().getConfiguration().uiMode;
    }

    @Override // com.unity3d.ads.core.data.datasource.DynamicDeviceInfoDataSource
    public List<String> getLocaleList() {
        LocaleList locales = this.context.getResources().getConfiguration().getLocales();
        Intrinsics.checkNotNullExpressionValue(locales, "context.resources.configuration.locales");
        int size = locales.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String locale = locales.get(i).toString();
            Intrinsics.checkNotNullExpressionValue(locale, "locales[it].toString()");
            arrayList.add(locale);
        }
        return arrayList;
    }

    private final boolean getAirplaneMode() {
        try {
            return Settings.Global.getInt(this.context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (Throwable th) {
            DeviceLog.error("Problems fetching airplane mode status", th.getMessage());
            return false;
        }
    }

    public final int getChargingType() {
        Intent registerReceiver = this.context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return registerReceiver.getIntExtra("plugged", -1);
        }
        return -1;
    }

    public final boolean getStayOnWhilePluggedIn() {
        try {
            return Settings.Global.getInt(this.context.getContentResolver(), "stay_on_while_plugged_in", 0) != 0;
        } catch (Throwable th) {
            DeviceLog.error("Problems fetching stay on while plugged in status", th.getMessage());
            return false;
        }
    }

    public final boolean getIsSdCardPresent() {
        return Intrinsics.areEqual(Environment.getExternalStorageState(), "mounted");
    }

    public final NetworkCapabilityTransportsOuterClass.NetworkCapabilityTransports getNetworkCapabilityTransports() {
        Network activeNetwork;
        NetworkCapabilityTransportsOuterClass.NetworkCapabilityTransports.Builder result = NetworkCapabilityTransportsOuterClass.NetworkCapabilityTransports.newBuilder();
        if (Build.VERSION.SDK_INT < 31) {
            NetworkCapabilityTransportsOuterClass.NetworkCapabilityTransports build = result.build();
            Intrinsics.checkNotNullExpressionValue(build, "result.build()");
            return build;
        }
        Object systemService = this.context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null) {
            NetworkCapabilityTransportsOuterClass.NetworkCapabilityTransports build2 = result.build();
            Intrinsics.checkNotNullExpressionValue(build2, "result.build()");
            return build2;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        if (networkCapabilities == null) {
            NetworkCapabilityTransportsOuterClass.NetworkCapabilityTransports build3 = result.build();
            Intrinsics.checkNotNullExpressionValue(build3, "result.build()");
            return build3;
        }
        boolean hasTransport = networkCapabilities.hasTransport(1);
        Intrinsics.checkNotNullExpressionValue(result, "result");
        result.setWifi(hasTransport);
        result.setCellular(networkCapabilities.hasTransport(0));
        result.setVpn(networkCapabilities.hasTransport(4));
        result.setEthernet(networkCapabilities.hasTransport(3));
        result.setWifiAware(networkCapabilities.hasTransport(5));
        result.setLowpan(networkCapabilities.hasTransport(6));
        result.setBluetooth(networkCapabilities.hasTransport(2));
        NetworkCapabilityTransportsOuterClass.NetworkCapabilityTransports build4 = result.build();
        Intrinsics.checkNotNullExpressionValue(build4, "result.build()");
        return build4;
    }

    @Override // com.unity3d.ads.core.data.datasource.DynamicDeviceInfoDataSource
    public DynamicDeviceInfoOuterClass.DynamicDeviceInfo fetch() {
        DynamicDeviceInfoKt.Dsl.Companion companion = DynamicDeviceInfoKt.Dsl.INSTANCE;
        DynamicDeviceInfoOuterClass.DynamicDeviceInfo.Builder newBuilder = DynamicDeviceInfoOuterClass.DynamicDeviceInfo.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        DynamicDeviceInfoKt.Dsl _create = companion._create(newBuilder);
        _create.setLanguage(getLanguage());
        _create.setNetworkOperator(getNetworkOperator());
        _create.setNetworkOperatorName(getNetworkOperatorName());
        _create.setFreeDiskSpace(getUsableSpace(this.context.getExternalFilesDir(null)));
        _create.setFreeRamMemory(getFreeMemory());
        _create.setWiredHeadset(isWiredHeadsetOn());
        _create.setTimeZone(getTimeZone());
        _create.setTimeZoneOffset(getTimeZoneOffset());
        _create.setLimitedTracking(isLimitAdTrackingEnabled());
        _create.setLimitedOpenAdTracking(isLimitOpenAdTrackingEnabled());
        _create.setBatteryLevel(getBatteryLevel());
        _create.setBatteryStatus(getBatteryStatus());
        _create.setConnectionType(getConnectionType());
        _create.setAndroid(fetchAndroidDynamicDeviceInfo());
        _create.setAppActive(isAppActive());
        _create.setScreenWidth(getScreenWidth());
        _create.setScreenHeight(getScreenHeight());
        return _create._build();
    }
}
