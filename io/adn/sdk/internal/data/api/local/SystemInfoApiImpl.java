package io.adn.sdk.internal.data.api.local;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import io.adn.sdk.internal.common.utils.ContextKt;
import io.adn.sdk.internal.common.utils.ConversionsKt;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import io.adn.sdk.internal.domain.model.metrics.ScreenSize;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SystemInfoApi.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u001fH\u0016J\b\u0010 \u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\rH\u0016J\b\u0010\"\u001a\u00020\rH\u0016J\b\u0010#\u001a\u00020\tH\u0016J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006("}, d2 = {"Lio/adn/sdk/internal/data/api/local/SystemInfoApiImpl;", "Lio/adn/sdk/internal/data/api/local/SystemInfoApi;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", BidTokenRepositoryKt.PPI, "", "getPpi", "()I", "osVersion", "", "getOsVersion", "()Ljava/lang/String;", N6.B, "getModel", "manufacturer", "getManufacturer", "isAirplaneModeEnabled", C3040d4.i.Y, "isBatterySaverEnabled", "isBatteryCharging", "isBluetoothEnabled", "isNightModeEnabled", "availableDiskSpaceInMB", "totalDiskSpaceInMB", "doNotDisturbStatus", "hasHeadset", "keyboardLanguages", "", "isSoundEnabled", "locale", "orientation", "isWalking", "screenSize", "Lio/adn/sdk/internal/domain/model/metrics/ScreenSize;", "bootTime", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class SystemInfoApiImpl implements SystemInfoApi {
    public static final int $stable = 8;
    private final Context context;
    private final String manufacturer;
    private final String model;
    private final String osVersion;
    private final int ppi;

    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    public int isBluetoothEnabled() {
        return 0;
    }

    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    public int isWalking() {
        return 0;
    }

    public SystemInfoApiImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.ppi = context.getResources().getDisplayMetrics().densityDpi;
        this.osVersion = String.valueOf(Build.VERSION.SDK_INT);
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        this.model = MODEL;
        this.manufacturer = Build.MANUFACTURER;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    public int getPpi() {
        return this.ppi;
    }

    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    public String getOsVersion() {
        return this.osVersion;
    }

    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    public String getModel() {
        return this.model;
    }

    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    public int isAirplaneModeEnabled() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            SystemInfoApiImpl systemInfoApiImpl = this;
            m10241constructorimpl = Result.m10241constructorimpl(Integer.valueOf(ConversionsKt.toInt(Settings.System.getInt(this.context.getContentResolver(), "airplane_mode_on", 0) != 0)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = -1;
        }
        return ((Number) m10241constructorimpl).intValue();
    }

    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    public int batteryLevel() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            SystemInfoApiImpl systemInfoApiImpl = this;
            Object systemService = this.context.getSystemService("batterymanager");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.BatteryManager");
            m10241constructorimpl = Result.m10241constructorimpl(Integer.valueOf(((BatteryManager) systemService).getIntProperty(4)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = -1;
        }
        return ((Number) m10241constructorimpl).intValue();
    }

    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    public int isBatterySaverEnabled() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            SystemInfoApiImpl systemInfoApiImpl = this;
            Object systemService = this.context.getSystemService("power");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            m10241constructorimpl = Result.m10241constructorimpl(Integer.valueOf(ConversionsKt.toInt(((PowerManager) systemService).isPowerSaveMode())));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = -1;
        }
        return ((Number) m10241constructorimpl).intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0032, code lost:
    
        if (r3.intValue() != 2) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0028, code lost:
    
        if (r3.intValue() != 1) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005e  */
    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int isBatteryCharging() {
        Object m10241constructorimpl;
        Integer valueOf;
        int i;
        try {
            Result.Companion companion = Result.INSTANCE;
            SystemInfoApiImpl systemInfoApiImpl = this;
            Intent registerReceiver = this.context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            valueOf = registerReceiver != null ? Integer.valueOf(registerReceiver.getIntExtra("plugged", -1)) : null;
            i = 1;
            if (valueOf != null) {
            }
            if (valueOf != null) {
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (valueOf != null && valueOf.intValue() == 4) {
            m10241constructorimpl = Result.m10241constructorimpl(Integer.valueOf(i));
            if (Result.m10247isFailureimpl(m10241constructorimpl)) {
                m10241constructorimpl = -1;
            }
            return ((Number) m10241constructorimpl).intValue();
        }
        i = 0;
        m10241constructorimpl = Result.m10241constructorimpl(Integer.valueOf(i));
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
        }
        return ((Number) m10241constructorimpl).intValue();
    }

    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    public int isNightModeEnabled() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            SystemInfoApiImpl systemInfoApiImpl = this;
            m10241constructorimpl = Result.m10241constructorimpl(Integer.valueOf((this.context.getResources().getConfiguration().uiMode & 48) == 32 ? 1 : 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = -1;
        }
        return ((Number) m10241constructorimpl).intValue();
    }

    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    public int availableDiskSpaceInMB() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            SystemInfoApiImpl systemInfoApiImpl = this;
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            m10241constructorimpl = Result.m10241constructorimpl(Integer.valueOf((int) ((statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong()) / 1048576)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = -1;
        }
        return ((Number) m10241constructorimpl).intValue();
    }

    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    public int totalDiskSpaceInMB() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            SystemInfoApiImpl systemInfoApiImpl = this;
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            m10241constructorimpl = Result.m10241constructorimpl(Integer.valueOf((int) ((statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 1048576)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = -1;
        }
        return ((Number) m10241constructorimpl).intValue();
    }

    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    public int doNotDisturbStatus() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            SystemInfoApiImpl systemInfoApiImpl = this;
            m10241constructorimpl = Result.m10241constructorimpl(Integer.valueOf(ConversionsKt.toInt(Settings.Global.getInt(this.context.getContentResolver(), "zen_mode") != 0)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = -1;
        }
        return ((Number) m10241constructorimpl).intValue();
    }

    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    public int hasHeadset() {
        Object m10241constructorimpl;
        AudioManager audioManager;
        boolean z;
        try {
            Result.Companion companion = Result.INSTANCE;
            SystemInfoApiImpl systemInfoApiImpl = this;
            Object systemService = this.context.getSystemService("audio");
            audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
            z = false;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (audioManager == null) {
            return 0;
        }
        AudioDeviceInfo[] devices = audioManager.getDevices(2);
        Intrinsics.checkNotNull(devices);
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            if (audioDeviceInfo.getType() != 3 && audioDeviceInfo.getType() != 4 && audioDeviceInfo.getType() != 8 && audioDeviceInfo.getType() != 7) {
            }
            z = true;
            break;
        }
        m10241constructorimpl = Result.m10241constructorimpl(Integer.valueOf(ConversionsKt.toInt(z)));
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = -1;
        }
        return ((Number) m10241constructorimpl).intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        if (r0 == null) goto L18;
     */
    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<String> keyboardLanguages() {
        Object m10241constructorimpl;
        InputMethodManager inputMethodManager;
        List emptyList;
        String locale;
        try {
            Result.Companion companion = Result.INSTANCE;
            SystemInfoApiImpl systemInfoApiImpl = this;
            Object systemService = this.context.getSystemService("input_method");
            inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (inputMethodManager == null) {
            return CollectionsKt.emptyList();
        }
        InputMethodSubtype currentInputMethodSubtype = inputMethodManager.getCurrentInputMethodSubtype();
        if (currentInputMethodSubtype != null && (locale = currentInputMethodSubtype.getLocale()) != null) {
            emptyList = locale.length() > 0 ? CollectionsKt.listOf(locale) : CollectionsKt.emptyList();
        }
        emptyList = CollectionsKt.emptyList();
        m10241constructorimpl = Result.m10241constructorimpl(emptyList);
        List emptyList2 = CollectionsKt.emptyList();
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = emptyList2;
        }
        return (List) m10241constructorimpl;
    }

    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    public int isSoundEnabled() {
        Object m10241constructorimpl;
        AudioManager audioManager;
        try {
            Result.Companion companion = Result.INSTANCE;
            SystemInfoApiImpl systemInfoApiImpl = this;
            audioManager = (AudioManager) this.context.getSystemService("audio");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (audioManager == null) {
            return 0;
        }
        m10241constructorimpl = Result.m10241constructorimpl(Integer.valueOf(ConversionsKt.toInt(audioManager.getRingerMode() == 2)));
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = -1;
        }
        return ((Number) m10241constructorimpl).intValue();
    }

    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    public String locale() {
        Object obj;
        String str;
        try {
            Result.Companion companion = Result.INSTANCE;
            SystemInfoApiImpl systemInfoApiImpl = this;
            Locale locale = this.context.getResources().getConfiguration().getLocales().get(0);
            if (locale == null || (str = locale.toString()) == null) {
                str = "";
            }
            obj = Result.m10241constructorimpl(str);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            obj = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        return (String) (Result.m10247isFailureimpl(obj) ? "" : obj);
    }

    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    public String orientation() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            SystemInfoApiImpl systemInfoApiImpl = this;
            m10241constructorimpl = Result.m10241constructorimpl(this.context.getResources().getConfiguration().orientation == 2 ? C3040d4.h.C : C3040d4.h.D);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = "";
        }
        return (String) m10241constructorimpl;
    }

    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    public ScreenSize screenSize() {
        Object m10241constructorimpl;
        Pair pair;
        try {
            Result.Companion companion = Result.INSTANCE;
            SystemInfoApiImpl systemInfoApiImpl = this;
            Object systemService = this.context.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            WindowManager windowManager = (WindowManager) systemService;
            if (Build.VERSION.SDK_INT >= 30) {
                Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
                Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
                pair = TuplesKt.to(Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height()));
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
                pair = TuplesKt.to(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
            }
            int intValue = ((Number) pair.component1()).intValue();
            int intValue2 = ((Number) pair.component2()).intValue();
            m10241constructorimpl = Result.m10241constructorimpl(new ScreenSize(intValue, intValue2, ContextKt.pixelsToDp(this.context, intValue), ContextKt.pixelsToDp(this.context, intValue2)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        ScreenSize screenSize = new ScreenSize(0, 0, 0, 0);
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = screenSize;
        }
        return (ScreenSize) m10241constructorimpl;
    }

    @Override // io.adn.sdk.internal.data.api.local.SystemInfoApi
    public long bootTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }
}
