package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.app.ApplicationStartInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Range;
import androidx.autofill.HintConstants;
import com.applovin.impl.b6;
import com.applovin.impl.c2;
import com.applovin.impl.g5;
import com.applovin.impl.h7;
import com.applovin.impl.j7;
import com.applovin.impl.k7;
import com.applovin.impl.k8;
import com.applovin.impl.m5;
import com.applovin.impl.o0;
import com.applovin.impl.o4;
import com.applovin.impl.p0;
import com.applovin.impl.p6;
import com.applovin.impl.q0;
import com.applovin.impl.q2;
import com.applovin.impl.r0;
import com.applovin.impl.s4;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v;
import com.applovin.impl.v4;
import com.applovin.impl.x4;
import com.applovin.impl.z3;
import com.applovin.sdk.AppLovinBidTokenCollectionListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.android.gms.common.Scopes;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class l {
    private static String i;
    private static String j;
    private static final AtomicReference k = new AtomicReference();
    private static final AtomicReference l = new AtomicReference();

    /* renamed from: a, reason: collision with root package name */
    private final k f700a;
    private final o b;
    private final Context c;
    private final Map d;
    private final Map f;
    private boolean g;
    private final Object e = new Object();
    private final AtomicReference h = new AtomicReference();

    class a implements m5.a {
        a() {
        }

        @Override // com.applovin.impl.m5.a
        public void a(v.a aVar) {
            l.k.set(aVar);
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f702a;
        public final int b;

        public b(String str, int i) {
            this.f702a = str;
            this.b = i;
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f703a = -1;
        public int b = -1;
        public Boolean c = null;
    }

    protected l(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f700a = kVar;
        this.b = kVar.O();
        this.c = k.o();
        this.d = B();
        this.f = A();
    }

    private Map A() {
        PackageInfo packageInfo;
        HashMap hashMap = new HashMap();
        PackageManager packageManager = this.c.getPackageManager();
        ApplicationInfo applicationInfo = this.c.getApplicationInfo();
        long lastModified = new File(applicationInfo.sourceDir).lastModified();
        try {
            packageInfo = packageManager.getPackageInfo(this.c.getPackageName(), 0);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        String a2 = a(applicationInfo.packageName, packageManager, this.f700a);
        hashMap.put("app_name", packageManager.getApplicationLabel(applicationInfo));
        hashMap.put(BidTokenRepositoryKt.APP_VERSION, packageInfo != null ? packageInfo.versionName : "");
        hashMap.put("app_version_code", Integer.valueOf(packageInfo != null ? packageInfo.versionCode : -1));
        if (a2 == null) {
            a2 = "";
        }
        hashMap.put("installer_name", a2);
        hashMap.put("tg", j7.a(this.f700a));
        hashMap.put("debug", Boolean.valueOf(k7.c(this.f700a)));
        hashMap.put("ia", Long.valueOf(lastModified));
        hashMap.put("alts_ms", Long.valueOf(k.n()));
        hashMap.put("session_id", this.f700a.n0().getSessionId());
        hashMap.put("j8", Boolean.valueOf(k.G0()));
        hashMap.put("ps_tpg", Boolean.valueOf(o4.d(this.c)));
        hashMap.put("ps_apg", Boolean.valueOf(o4.b(this.c)));
        hashMap.put("ps_capg", Boolean.valueOf(o4.c(this.c)));
        hashMap.put("ps_aipg", Boolean.valueOf(o4.a(this.c)));
        k kVar = this.f700a;
        x4 x4Var = x4.h;
        Long l2 = (Long) kVar.a(x4Var);
        if (l2 != null) {
            hashMap.put("ia_v2", l2);
        } else {
            this.f700a.b(x4Var, Long.valueOf(lastModified));
        }
        hashMap.put(BidTokenRepositoryKt.SDK_VERSION, AppLovinSdk.VERSION);
        hashMap.put("omid_sdk_version", this.f700a.e0().c());
        CollectionUtils.putStringIfValid("ad_review_sdk_version", com.applovin.impl.j.b(), hashMap);
        hashMap.put("api_did", this.f700a.a(v4.f));
        hashMap.put("first_install_v3_ms", packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : "");
        CollectionUtils.putLongIfValid("last_launch_ms", this.f700a.M(), hashMap);
        CollectionUtils.putLongIfValid("app_launch_count", Long.valueOf(this.f700a.N()), hashMap);
        hashMap.put("target_sdk", Integer.valueOf(applicationInfo.targetSdkVersion));
        if (o0.g()) {
            hashMap.put("min_sdk", Integer.valueOf(applicationInfo.minSdkVersion));
        }
        if (this.f700a.I0()) {
            hashMap.put("unity_version", k7.a(this.f700a.o0()));
        }
        List i2 = i();
        if (!CollectionUtils.isEmpty(i2)) {
            hashMap.put("application_start_info", i2);
        }
        List g = g();
        if (!CollectionUtils.isEmpty(g)) {
            hashMap.put("application_exit_info", g);
        }
        return hashMap;
    }

    private Map B() {
        HashMap hashMap = new HashMap(35);
        hashMap.put("api_level", Integer.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("brand", Build.MANUFACTURER);
        hashMap.put("brand_name", Build.BRAND);
        hashMap.put("hardware", Build.HARDWARE);
        hashMap.put("sim", Boolean.valueOf(AppLovinSdkUtils.isEmulator()));
        hashMap.put("aida", Boolean.valueOf(v.a()));
        hashMap.put("locale", Locale.getDefault().toString());
        hashMap.put(N6.B, Build.MODEL);
        hashMap.put(N6.F, Build.VERSION.RELEASE);
        hashMap.put(N6.H, y());
        hashMap.put("revision", Build.DEVICE);
        hashMap.put("tz_offset", Double.valueOf(C()));
        hashMap.put("gy", Boolean.valueOf(s()));
        hashMap.put("country_code", m());
        hashMap.put("mcc", w());
        hashMap.put("mnc", x());
        hashMap.put(N6.P0, k());
        hashMap.put("tv", Boolean.valueOf(AppLovinSdkUtils.isTv(this.c)));
        hashMap.put("pc", Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        hashMap.put("hdr", Q());
        hashMap.put("supported_abis", M());
        DisplayMetrics displayMetrics = this.c.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            hashMap.put("adns", Float.valueOf(displayMetrics.density));
            hashMap.put("adnsd", Integer.valueOf(displayMetrics.densityDpi));
            hashMap.put("xdpi", Float.valueOf(displayMetrics.xdpi));
            hashMap.put("ydpi", Float.valueOf(displayMetrics.ydpi));
            o0.b a2 = o0.a(this.c, this.f700a);
            if (a2 != null) {
                hashMap.put("tl_cr", Integer.valueOf(a2.c()));
                hashMap.put("tr_cr", Integer.valueOf(a2.d()));
                hashMap.put("bl_cr", Integer.valueOf(a2.a()));
                hashMap.put("br_cr", Integer.valueOf(a2.b()));
            }
        }
        hashMap.put("bt_ms", Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        hashMap.put("tbalsi_ms", Long.valueOf(this.f700a.L() - k.n()));
        CollectionUtils.putBooleanIfValid("psase", Boolean.valueOf(o4.e(this.c)), hashMap);
        CollectionUtils.putStringIfValid("process_name", k7.c(this.c), hashMap);
        CollectionUtils.putBooleanIfValid("is_main_process", k7.i(this.c), hashMap);
        try {
            PackageInfo packageInfo = this.c.getPackageManager().getPackageInfo("com.android.vending", 0);
            hashMap.put("ps_version", packageInfo.versionName);
            hashMap.put("ps_version_code", Integer.valueOf(packageInfo.versionCode));
        } catch (Throwable unused) {
            hashMap.put("ps_version", "");
            hashMap.put("ps_version_code", -1);
        }
        CollectionUtils.putBooleanIfValid("play_store_disabled", h7.a(this.c), hashMap);
        a(hashMap);
        return hashMap;
    }

    private double C() {
        return Math.round((TimeZone.getDefault().getOffset(new Date().getTime()) * 10.0d) / 3600000.0d) / 10.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0208 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONArray D() {
        boolean z;
        MediaCodecInfo[] mediaCodecInfoArr;
        int i2;
        int i3;
        MediaCodecInfo[] mediaCodecInfoArr2;
        int i4;
        int i5;
        MediaCodecInfo mediaCodecInfo;
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        if (!o0.e()) {
            return new JSONArray();
        }
        ArrayList arrayList = new ArrayList();
        try {
            boolean z2 = true;
            MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
            int length = codecInfos.length;
            int i6 = 0;
            while (i6 < length) {
                MediaCodecInfo mediaCodecInfo2 = codecInfos[i6];
                if (mediaCodecInfo2.isEncoder()) {
                    z = z2;
                    mediaCodecInfoArr = codecInfos;
                    i2 = length;
                    i3 = i6;
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put("name", mediaCodecInfo2.getName());
                    if (o0.j()) {
                        hashMap.put("is_hardware_accelerated", Boolean.valueOf(mediaCodecInfo2.isHardwareAccelerated()));
                        hashMap.put("is_software_only", Boolean.valueOf(mediaCodecInfo2.isSoftwareOnly()));
                    }
                    String[] supportedTypes = mediaCodecInfo2.getSupportedTypes();
                    ArrayList arrayList2 = new ArrayList();
                    HashMap hashMap2 = new HashMap();
                    int length2 = supportedTypes.length;
                    z = z2;
                    int i7 = 0;
                    while (i7 < length2) {
                        String str = supportedTypes[i7];
                        int i8 = i7;
                        if (str.toLowerCase(Locale.ROOT).startsWith("video/")) {
                            arrayList2.add(str);
                            try {
                                capabilitiesForType = mediaCodecInfo2.getCapabilitiesForType(str);
                            } catch (Throwable th) {
                                th = th;
                                mediaCodecInfoArr2 = codecInfos;
                            }
                            if (capabilitiesForType != null && (videoCapabilities = capabilitiesForType.getVideoCapabilities()) != null) {
                                mediaCodecInfoArr2 = codecInfos;
                                try {
                                    HashMap hashMap3 = new HashMap();
                                    i4 = length;
                                    try {
                                        i5 = i6;
                                        try {
                                            hashMap3.put("max_width", videoCapabilities.getSupportedWidths().getUpper());
                                            hashMap3.put("max_height", videoCapabilities.getSupportedHeights().getUpper());
                                            Range<Integer> bitrateRange = videoCapabilities.getBitrateRange();
                                            Integer lower = bitrateRange.getLower();
                                            Integer upper = bitrateRange.getUpper();
                                            mediaCodecInfo = mediaCodecInfo2;
                                            try {
                                                Integer[] numArr = new Integer[2];
                                                numArr[0] = lower;
                                                numArr[z ? 1 : 0] = upper;
                                                hashMap3.put("bitrate_range_bps", Arrays.asList(numArr));
                                                Range<Integer> supportedFrameRates = videoCapabilities.getSupportedFrameRates();
                                                Integer lower2 = supportedFrameRates.getLower();
                                                Integer upper2 = supportedFrameRates.getUpper();
                                                Integer[] numArr2 = new Integer[2];
                                                numArr2[0] = lower2;
                                                numArr2[z ? 1 : 0] = upper2;
                                                hashMap3.put("overall_frame_rate_range", Arrays.asList(numArr2));
                                                int intValue = videoCapabilities.getSupportedWidths().getUpper().intValue();
                                                int intValue2 = videoCapabilities.getSupportedHeights().getUpper().intValue();
                                                if (videoCapabilities.isSizeSupported(intValue, intValue2)) {
                                                    try {
                                                        Range<Double> supportedFrameRatesFor = videoCapabilities.getSupportedFrameRatesFor(intValue, intValue2);
                                                        if (supportedFrameRatesFor != null) {
                                                            Double lower3 = supportedFrameRatesFor.getLower();
                                                            Double upper3 = supportedFrameRatesFor.getUpper();
                                                            Double[] dArr = new Double[2];
                                                            dArr[0] = lower3;
                                                            dArr[z ? 1 : 0] = upper3;
                                                            hashMap3.put("frame_rate_range_for_max_res", Arrays.asList(dArr));
                                                        }
                                                    } catch (Throwable th2) {
                                                        if (o.a()) {
                                                            this.b.a("DataCollector", "Could not get frame rates for max resolution for codec: " + mediaCodecInfo.getName() + ", MIME type: " + str, th2);
                                                        }
                                                    }
                                                }
                                                ArrayList arrayList3 = new ArrayList();
                                                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
                                                if (codecProfileLevelArr != null && codecProfileLevelArr.length > 0) {
                                                    int i9 = 0;
                                                    for (int length3 = codecProfileLevelArr.length; i9 < length3; length3 = length3) {
                                                        MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecProfileLevelArr[i9];
                                                        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr2 = codecProfileLevelArr;
                                                        HashMap hashMap4 = new HashMap();
                                                        hashMap4.put(Scopes.PROFILE, Integer.valueOf(codecProfileLevel.profile));
                                                        hashMap4.put("level", Integer.valueOf(codecProfileLevel.level));
                                                        arrayList3.add(hashMap4);
                                                        i9++;
                                                        codecProfileLevelArr = codecProfileLevelArr2;
                                                    }
                                                    hashMap3.put("profile_levels", arrayList3);
                                                }
                                                if (!hashMap3.isEmpty()) {
                                                    hashMap2.put(str, hashMap3);
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                if (!o.a()) {
                                                    this.b.a("DataCollector", "Failed to get capabilities for codec: " + mediaCodecInfo.getName() + ", MIME type: " + str, th);
                                                }
                                                i7 = i8 + 1;
                                                codecInfos = mediaCodecInfoArr2;
                                                length = i4;
                                                i6 = i5;
                                                mediaCodecInfo2 = mediaCodecInfo;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            mediaCodecInfo = mediaCodecInfo2;
                                            if (!o.a()) {
                                            }
                                            i7 = i8 + 1;
                                            codecInfos = mediaCodecInfoArr2;
                                            length = i4;
                                            i6 = i5;
                                            mediaCodecInfo2 = mediaCodecInfo;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        i5 = i6;
                                        mediaCodecInfo = mediaCodecInfo2;
                                        if (!o.a()) {
                                        }
                                        i7 = i8 + 1;
                                        codecInfos = mediaCodecInfoArr2;
                                        length = i4;
                                        i6 = i5;
                                        mediaCodecInfo2 = mediaCodecInfo;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    i4 = length;
                                    i5 = i6;
                                    mediaCodecInfo = mediaCodecInfo2;
                                    if (!o.a()) {
                                    }
                                    i7 = i8 + 1;
                                    codecInfos = mediaCodecInfoArr2;
                                    length = i4;
                                    i6 = i5;
                                    mediaCodecInfo2 = mediaCodecInfo;
                                }
                                i7 = i8 + 1;
                                codecInfos = mediaCodecInfoArr2;
                                length = i4;
                                i6 = i5;
                                mediaCodecInfo2 = mediaCodecInfo;
                            }
                        }
                        mediaCodecInfoArr2 = codecInfos;
                        i4 = length;
                        i5 = i6;
                        mediaCodecInfo = mediaCodecInfo2;
                        i7 = i8 + 1;
                        codecInfos = mediaCodecInfoArr2;
                        length = i4;
                        i6 = i5;
                        mediaCodecInfo2 = mediaCodecInfo;
                    }
                    mediaCodecInfoArr = codecInfos;
                    i2 = length;
                    i3 = i6;
                    if (!arrayList2.isEmpty()) {
                        hashMap.put("supported_mime_types", arrayList2);
                        if (!hashMap2.isEmpty()) {
                            hashMap.put("capabilities_by_type", hashMap2);
                        }
                        arrayList.add(hashMap);
                    }
                }
                i6 = i3 + 1;
                z2 = z;
                codecInfos = mediaCodecInfoArr;
                length = i2;
            }
            return new JSONArray((Collection) arrayList);
        } catch (Throwable th7) {
            if (o.a()) {
                this.b.a("DataCollector", "Failed to get MediaCodecList", th7);
            }
            return new JSONArray();
        }
    }

    public static String H() {
        return j;
    }

    private Map J() {
        return k7.a(a((Map) null, true, false));
    }

    private JSONArray M() {
        if (o0.e()) {
            return CollectionUtils.toJSONArray(Build.SUPPORTED_ABIS);
        }
        JSONArray jSONArray = new JSONArray();
        JsonUtils.putStringIfValid(jSONArray, Build.CPU_ABI);
        JsonUtils.putStringIfValid(jSONArray, Build.CPU_ABI2);
        return jSONArray;
    }

    private boolean N() {
        try {
            if (!b()) {
                if (!c()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean O() {
        ConnectivityManager connectivityManager;
        if (o0.g() && (connectivityManager = (ConnectivityManager) this.c.getSystemService("connectivity")) != null) {
            try {
                return connectivityManager.getRestrictBackgroundStatus() == 3;
            } catch (Throwable th) {
                this.f700a.O();
                if (o.a()) {
                    this.f700a.O().a("DataCollector", "Unable to collect constrained network info.", th);
                }
            }
        }
        return false;
    }

    private boolean P() {
        boolean z = this.c.getResources().getConfiguration().keyboard == 2;
        PackageManager packageManager = this.c.getPackageManager();
        return z && (packageManager.hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE") || packageManager.hasSystemFeature("android.hardware.type.pc"));
    }

    private Boolean Q() {
        if (o0.h()) {
            return Boolean.valueOf(this.c.getResources().getConfiguration().isScreenHdr());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S() {
        this.h.set(q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener) {
        try {
            String G = G();
            if (StringUtils.isValidString(G)) {
                this.f700a.O();
                if (o.a()) {
                    this.f700a.O().a("DataCollector", "Successfully retrieved bid token");
                }
                q2.a(appLovinBidTokenCollectionListener, G);
                return;
            }
            this.f700a.O();
            if (o.a()) {
                this.f700a.O().b("DataCollector", "Empty bid token");
            }
            q2.b(appLovinBidTokenCollectionListener, "Empty bid token");
        } catch (Throwable th) {
            if (o.a()) {
                this.b.a("DataCollector", "Failed to collect bid token", th);
            }
            this.f700a.E().a("DataCollector", "collectBidToken", th);
            q2.b(appLovinBidTokenCollectionListener, "Failed to collect bid token");
        }
    }

    private boolean c() {
        String[] strArr = {"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (int i2 = 0; i2 < 9; i2++) {
            if (new File(c(strArr[i2])).exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long d() {
        long j2;
        int b2;
        int b3;
        int b4;
        long j3;
        long j4;
        long j5;
        String emptyIfNull = StringUtils.emptyIfNull(Settings.Secure.getString(this.c.getContentResolver(), "enabled_accessibility_services"));
        long j6 = emptyIfNull.contains("AccessibilityMenuService") ? 256L : 0L;
        if (emptyIfNull.contains("SelectToSpeakService")) {
            j6 |= 512;
        }
        if (emptyIfNull.contains("SoundAmplifierService")) {
            j6 |= 2;
        }
        if (emptyIfNull.contains("SpeechToTextAccessibilityService")) {
            j6 |= 128;
        }
        if (emptyIfNull.contains("SwitchAccessService")) {
            j6 |= 4;
        }
        if ((this.c.getResources().getConfiguration().uiMode & 48) == 32) {
            j6 |= 1024;
        }
        if (a("accessibility_enabled")) {
            j6 |= 8;
        }
        if (a("touch_exploration_enabled")) {
            j6 |= 16;
        }
        if (o0.e()) {
            if (a("accessibility_display_inversion_enabled")) {
                j6 |= 32;
            }
            if (a("skip_first_use_hints")) {
                j6 |= 64;
            }
        }
        if (a("lock_screen_allow_remote_input")) {
            j6 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        if (a("enabled_accessibility_audio_description_by_default")) {
            j6 |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        if (a("accessibility_shortcut_on_lock_screen")) {
            j6 |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        if (a("wear_talkback_enabled")) {
            j6 |= 16384;
        }
        if (a("hush_gesture_used")) {
            j6 |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        if (a("high_text_contrast_enabled")) {
            j6 |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        if (a("accessibility_display_magnification_enabled")) {
            j6 |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        if (a("accessibility_display_magnification_navbar_enabled")) {
            j6 |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        }
        if (a("accessibility_captioning_enabled")) {
            j6 |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        if (a("accessibility_display_daltonizer_enabled")) {
            j6 |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        if (a("accessibility_autoclick_enabled")) {
            j6 |= 2097152;
        }
        if (a("accessibility_large_pointer_icon")) {
            j6 |= PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
        }
        if (a("reduce_bright_colors_activated")) {
            j6 |= 8388608;
        }
        if (a("reduce_bright_colors_persist_across_reboots")) {
            j6 |= 16777216;
        }
        if (a("tty_mode_enabled")) {
            j6 |= 33554432;
        }
        if (a("rtt_calling_mode")) {
            j6 |= 67108864;
        }
        if (a("accessibility_floating_menu_fade_enabled")) {
            j6 |= 134217728;
        }
        if (a("accessibility_show_window_magnification_prompt")) {
            j6 |= 268435456;
        }
        if (a("accessibility_floating_menu_migration_tooltip_prompt")) {
            j6 |= 536870912;
        }
        int b5 = b("accessibility_magnification_mode");
        if (b5 == 0) {
            j2 = 1073741824;
        } else if (b5 == 1) {
            j2 = 2147483648L;
        } else {
            if (b5 != 2) {
                if (b5 == 3) {
                    j2 = 8589934592L;
                }
                b2 = b("accessibility_button_mode");
                if (b2 == 0) {
                    j5 = b2 == 1 ? 34359738368L : 17179869184L;
                    b3 = b("accessibility_floating_menu_size");
                    if (b3 != 0) {
                        j4 = b3 == 1 ? 137438953472L : 68719476736L;
                        b4 = b("accessibility_floating_menu_icon_type");
                        if (b4 != 0) {
                            j3 = 274877906944L;
                        } else {
                            if (b4 != 1) {
                                return j6;
                            }
                            j3 = 549755813888L;
                        }
                        return j6 | j3;
                    }
                    j6 |= j4;
                    b4 = b("accessibility_floating_menu_icon_type");
                    if (b4 != 0) {
                    }
                    return j6 | j3;
                }
                j6 |= j5;
                b3 = b("accessibility_floating_menu_size");
                if (b3 != 0) {
                }
                j6 |= j4;
                b4 = b("accessibility_floating_menu_icon_type");
                if (b4 != 0) {
                }
                return j6 | j3;
            }
            j2 = 4294967296L;
        }
        j6 |= j2;
        b2 = b("accessibility_button_mode");
        if (b2 == 0) {
        }
        j6 |= j5;
        b3 = b("accessibility_floating_menu_size");
        if (b3 != 0) {
        }
        j6 |= j4;
        b4 = b("accessibility_floating_menu_icon_type");
        if (b4 != 0) {
        }
        return j6 | j3;
    }

    private List g() {
        ActivityManager activityManager;
        if (!o0.b()) {
            return null;
        }
        Integer num = (Integer) this.f700a.a(v4.x4);
        if (num.intValue() < 0 || (activityManager = (ActivityManager) this.c.getSystemService("activity")) == null) {
            return null;
        }
        List<ApplicationExitInfo> historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(((Boolean) this.f700a.a(v4.y4)).booleanValue() ? this.c.getPackageName() : null, 0, num.intValue());
        if (CollectionUtils.isEmpty(historicalProcessExitReasons)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(historicalProcessExitReasons.size());
        for (ApplicationExitInfo applicationExitInfo : historicalProcessExitReasons) {
            HashMap hashMap = new HashMap(13);
            int reason = applicationExitInfo.getReason();
            hashMap.put("reason", Integer.valueOf(reason));
            String description = applicationExitInfo.getDescription();
            CollectionUtils.putStringIfValid("description", description, hashMap);
            hashMap.put("timestamp", Long.valueOf(applicationExitInfo.getTimestamp()));
            hashMap.put("status", Integer.valueOf(applicationExitInfo.getStatus()));
            hashMap.put("importance", Integer.valueOf(applicationExitInfo.getImportance()));
            hashMap.put("pss", Long.valueOf(applicationExitInfo.getPss()));
            hashMap.put("rss", Long.valueOf(applicationExitInfo.getRss()));
            CollectionUtils.putStringIfValid("process_name", applicationExitInfo.getProcessName(), hashMap);
            hashMap.put("pid", Integer.valueOf(applicationExitInfo.getPid()));
            hashMap.put("ruid", Integer.valueOf(applicationExitInfo.getRealUid()));
            hashMap.put("puid", Integer.valueOf(applicationExitInfo.getPackageUid()));
            hashMap.put("duid", Integer.valueOf(applicationExitInfo.getDefiningUid()));
            String a2 = a(applicationExitInfo, reason);
            if (StringUtils.isValidString(a2)) {
                hashMap.put("stack_trace", a2);
                b(a2, reason, description);
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    private List i() {
        ActivityManager activityManager;
        if (!o0.c()) {
            return null;
        }
        Integer num = (Integer) this.f700a.a(v4.w4);
        if (num.intValue() < 0 || (activityManager = (ActivityManager) this.c.getSystemService("activity")) == null) {
            return null;
        }
        List<ApplicationStartInfo> historicalProcessStartReasons = activityManager.getHistoricalProcessStartReasons(num.intValue());
        if (CollectionUtils.isEmpty(historicalProcessStartReasons)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(historicalProcessStartReasons.size());
        for (ApplicationStartInfo applicationStartInfo : historicalProcessStartReasons) {
            HashMap hashMap = new HashMap(11);
            hashMap.put("reason", Integer.valueOf(applicationStartInfo.getReason()));
            hashMap.put("startup_state", Integer.valueOf(applicationStartInfo.getStartupState()));
            hashMap.put("start_type", Integer.valueOf(applicationStartInfo.getStartType()));
            hashMap.put("was_force_stopped", Boolean.valueOf(applicationStartInfo.wasForceStopped()));
            hashMap.put("startup_timestamps", applicationStartInfo.getStartupTimestamps());
            CollectionUtils.putStringIfValid("process_name", applicationStartInfo.getProcessName(), hashMap);
            hashMap.put("pid", Integer.valueOf(applicationStartInfo.getPid()));
            hashMap.put("ruid", Integer.valueOf(applicationStartInfo.getRealUid()));
            hashMap.put("puid", Integer.valueOf(applicationStartInfo.getPackageUid()));
            hashMap.put("duid", Integer.valueOf(applicationStartInfo.getDefiningUid()));
            hashMap.put("launch_mode", Integer.valueOf(applicationStartInfo.getLaunchMode()));
            hashMap.put("intent", a(applicationStartInfo.getIntent()));
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    private c j() {
        c cVar = new c();
        Intent registerReceiver = this.c.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("level", -1) : -1;
        int intExtra2 = registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : -1;
        if (intExtra <= 0 || intExtra2 <= 0) {
            cVar.b = -1;
        } else {
            cVar.b = (int) ((intExtra / intExtra2) * 100.0f);
        }
        cVar.f703a = registerReceiver != null ? registerReceiver.getIntExtra("status", -1) : -1;
        cVar.c = Boolean.valueOf(Settings.Global.getInt(this.c.getContentResolver(), "stay_on_while_plugged_in", -1) > 0);
        return cVar;
    }

    private String k() {
        TelephonyManager telephonyManager = (TelephonyManager) this.c.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        if (telephonyManager == null) {
            return "";
        }
        try {
            return telephonyManager.getNetworkOperatorName();
        } catch (Throwable th) {
            if (!o.a()) {
                return "";
            }
            this.b.a("DataCollector", "Unable to collect carrier", th);
            return "";
        }
    }

    private String m() {
        TelephonyManager telephonyManager = (TelephonyManager) this.c.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        return telephonyManager != null ? telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH) : "";
    }

    private String n() {
        ActivityInfo activityInfo;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://"));
        ResolveInfo resolveActivity = this.c.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity != null && (activityInfo = resolveActivity.activityInfo) != null) {
            j = activityInfo.packageName;
        }
        return j;
    }

    private String p() {
        if (!o0.g()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            LocaleList locales = this.c.getResources().getConfiguration().getLocales();
            for (int i2 = 0; i2 < locales.size(); i2++) {
                sb.append(locales.get(i2));
                sb.append(",");
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private Float q() {
        Float f = (Float) this.f700a.a(v4.X3);
        Float b2 = this.f700a.q().b();
        if (b2 != null) {
            return Float.valueOf(b2.floatValue() * f.floatValue());
        }
        return null;
    }

    private float r() {
        try {
            return Settings.System.getFloat(this.c.getContentResolver(), "font_scale");
        } catch (Settings.SettingNotFoundException e) {
            if (!o.a()) {
                return -1.0f;
            }
            this.b.a("DataCollector", "Error collecting font scale", e);
            return -1.0f;
        }
    }

    private boolean s() {
        SensorManager sensorManager = (SensorManager) this.c.getSystemService("sensor");
        return (sensorManager == null || sensorManager.getDefaultSensor(4) == null) ? false : true;
    }

    private Map t() {
        HashMap hashMap = new HashMap();
        CollectionUtils.putIntegerIfValid("IABTCF_gdprApplies", this.f700a.s0().g(), hashMap);
        CollectionUtils.putStringIfValid("IABTCF_TCString", this.f700a.s0().j(), hashMap);
        CollectionUtils.putStringIfValid("IABTCF_AddtlConsent", this.f700a.s0().c(), hashMap);
        return hashMap;
    }

    private Boolean u() {
        AudioManager audioManager = (AudioManager) this.c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        return Boolean.valueOf(audioManager.isMusicActive());
    }

    private Boolean v() {
        AudioManager audioManager = (AudioManager) this.c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        return Boolean.valueOf(audioManager.isSpeakerphoneOn());
    }

    private String w() {
        TelephonyManager telephonyManager = (TelephonyManager) this.c.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(0, Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            if (!o.a()) {
                return "";
            }
            this.b.a("DataCollector", "Unable to collect mobile country code", th);
            return "";
        }
    }

    private String x() {
        TelephonyManager telephonyManager = (TelephonyManager) this.c.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            if (!o.a()) {
                return "";
            }
            this.b.a("DataCollector", "Unable to collect mobile network code", th);
            return "";
        }
    }

    private String z() {
        AudioManager audioManager = (AudioManager) this.c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (o0.f()) {
            for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
                sb.append(audioDeviceInfo.getType());
                sb.append(",");
            }
        } else {
            if (audioManager.isWiredHeadsetOn()) {
                sb.append("3,");
            }
            if (audioManager.isBluetoothScoOn()) {
                sb.append("7,");
            }
            if (audioManager.isBluetoothA2dpOn()) {
                sb.append(8);
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2) && o.a()) {
            this.b.a("DataCollector", "No sound outputs detected");
        }
        return sb2;
    }

    public Map E() {
        Map map = CollectionUtils.map(this.f);
        String str = StringUtils.isValidString(i) ? i : this.c.getApplicationInfo().packageName;
        map.put("package_name", str);
        map.put("vz", StringUtils.toShortSHA1Hash(str));
        map.put("first_install", Boolean.valueOf(this.f700a.D0()));
        map.put("first_install_v2", Boolean.valueOf(!this.f700a.A0()));
        map.put("test_ads", Boolean.valueOf(this.g));
        map.put("test_mode", Integer.valueOf(this.f700a.t0().c() ? 1 : 0));
        map.put("muted", Boolean.valueOf(this.f700a.o0().isMuted()));
        if (((Boolean) this.f700a.a(v4.x3)).booleanValue()) {
            CollectionUtils.putStringIfValid("cuid", this.f700a.x0().e(), map);
        }
        if (((Boolean) this.f700a.a(v4.A3)).booleanValue()) {
            map.put("compass_random_token", this.f700a.v());
        }
        if (((Boolean) this.f700a.a(v4.C3)).booleanValue()) {
            map.put("applovin_random_token", this.f700a.i0());
        }
        if (((Boolean) this.f700a.a(v4.G3)).booleanValue()) {
            map.put("art", this.f700a.s());
        }
        map.putAll(t());
        if (this.f700a.h0() != null) {
            CollectionUtils.putJsonArrayIfValid("ps_topics", this.f700a.h0().a(), map);
        }
        CollectionUtils.putStringIfValid("template_browser_package_name", (String) this.f700a.q0().a(x4.S, null), map);
        return map;
    }

    public b F() {
        return (b) l.get();
    }

    protected String G() {
        String encodeToString = Base64.encodeToString(new JSONObject(J()).toString().getBytes(Charset.defaultCharset()), 2);
        return ((Boolean) this.f700a.a(v4.c5)).booleanValue() ? s4.b(encodeToString, k7.a(this.f700a), s4.a.a(((Integer) this.f700a.a(v4.d5)).intValue()), this.f700a.j0(), this.f700a) : encodeToString;
    }

    public String I() {
        ActivityManager activityManager = (ActivityManager) this.c.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        return activityManager.getDeviceConfigurationInfo().getGlEsVersion();
    }

    public Map K() {
        return CollectionUtils.map(this.f);
    }

    public Map L() {
        return CollectionUtils.map(this.d);
    }

    public boolean R() {
        return this.g;
    }

    public void T() {
        b6 r0 = this.f700a.r0();
        m5 m5Var = new m5(this.f700a, new a());
        b6.b bVar = b6.b.OTHER;
        r0.a((g5) m5Var, bVar);
        this.f700a.r0().a((g5) new p6(this.f700a, true, "setDeviceVolume", new Runnable() { // from class: com.applovin.impl.sdk.l$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                l.this.S();
            }
        }), bVar);
    }

    public void U() {
        synchronized (this.e) {
            a(this.d);
        }
    }

    public Map e() {
        HashMap hashMap = new HashMap();
        hashMap.put("sc", this.f700a.a(v4.l));
        hashMap.put("sc2", this.f700a.a(v4.m));
        hashMap.put("sc3", this.f700a.a(v4.n));
        hashMap.put("server_installed_at", this.f700a.a(v4.o));
        CollectionUtils.putStringIfValid("persisted_data", (String) this.f700a.a(x4.G), hashMap);
        return hashMap;
    }

    public v.a f() {
        v.a b2 = v.b(this.c);
        if (b2 == null) {
            return new v.a();
        }
        if (((Boolean) this.f700a.a(v4.v3)).booleanValue()) {
            if (b2.c() && !((Boolean) this.f700a.a(v4.u3)).booleanValue()) {
                b2.a("");
            }
            k.set(b2);
        } else {
            b2 = new v.a();
        }
        List<String> testDeviceAdvertisingIds = this.f700a.K() != null ? this.f700a.K().getTestDeviceAdvertisingIds() : null;
        if (testDeviceAdvertisingIds == null) {
            this.g = false;
            return b2;
        }
        String a2 = b2.a();
        if (StringUtils.isValidString(a2)) {
            this.g = testDeviceAdvertisingIds.contains(a2);
        }
        b F = F();
        String str = F != null ? F.f702a : null;
        if (StringUtils.isValidString(str)) {
            this.g = testDeviceAdvertisingIds.contains(str) | this.g;
        }
        return b2;
    }

    public Map l() {
        HashMap hashMap = new HashMap();
        z3 d0 = this.f700a.d0();
        Deque b2 = d0.b();
        if (!CollectionUtils.isEmpty(b2)) {
            hashMap.put("network_throughput_info", b2);
        }
        CollectionUtils.putLongIfValid("network_throughput_kbps", d0.a(), hashMap);
        q0.d a2 = this.f700a.x().a();
        if (a2 != null) {
            hashMap.put("lrm_ts_ms", String.valueOf(a2.c()));
            hashMap.put("lrm_url", a2.d());
            hashMap.put("lrm_ct_ms", String.valueOf(a2.a()));
            hashMap.put("lrm_rs", String.valueOf(a2.b()));
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    public Map o() {
        return a(false);
    }

    public String y() {
        return AppLovinSdkUtils.isFireOS(this.c) ? "fireos" : "android";
    }

    private String h() {
        int orientation = AppLovinSdkUtils.getOrientation(this.c);
        return orientation == 1 ? C3040d4.h.D : orientation == 2 ? C3040d4.h.C : "none";
    }

    protected void a(final AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener) {
        this.f700a.r0().a((g5) new p6(this.f700a, ((Boolean) this.f700a.a(v4.K3)).booleanValue(), "DataCollector", new Runnable() { // from class: com.applovin.impl.sdk.l$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                l.this.b(appLovinBidTokenCollectionListener);
            }
        }), b6.b.CORE);
    }

    public Map a(Map map, boolean z, boolean z2) {
        HashMap hashMap = new HashMap(64);
        Map a2 = a(z);
        Map E = E();
        Map l2 = l();
        Map l0 = this.f700a.l0();
        if (z2) {
            hashMap.put("device_info", a2);
            hashMap.put("app_info", E);
            if (l2 != null) {
                hashMap.put("connection_info", l2);
            }
            if (map != null) {
                hashMap.put("ad_info", map);
            }
            if (!CollectionUtils.isEmpty(l0)) {
                hashMap.put("segments", l0);
            }
        } else {
            hashMap.putAll(a2);
            hashMap.putAll(E);
            if (l2 != null) {
                hashMap.putAll(l2);
            }
            if (map != null) {
                hashMap.putAll(map);
            }
            if (!CollectionUtils.isEmpty(l0)) {
                hashMap.putAll(l0);
            }
        }
        hashMap.put("accept", "custom_size,launch_app,video");
        hashMap.put("format", "json");
        CollectionUtils.putStringIfValid("mediation_provider", this.f700a.V(), hashMap);
        CollectionUtils.putStringIfValid("mediation_provider_v2", this.f700a.D(), hashMap);
        CollectionUtils.putStringIfValid("plugin_version", (String) this.f700a.a(v4.I3), hashMap);
        CollectionUtils.putLongIfValid("tssf_ms", Long.valueOf(this.f700a.u0()), hashMap);
        if (!((Boolean) this.f700a.a(v4.a5)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f700a.j0());
        }
        CollectionUtils.putStringIfValid("connectEventKey", this.f700a.r(), hashMap);
        hashMap.putAll(e());
        hashMap.put("rid", UUID.randomUUID().toString());
        return hashMap;
    }

    private void b(final String str, final int i2, final String str2) {
        this.f700a.r0().a((g5) new p6(this.f700a, "reportAppExitInfoStackTrace", new Runnable() { // from class: com.applovin.impl.sdk.l$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                l.this.a(str, i2, str2);
            }
        }), b6.b.OTHER);
    }

    private String c(String str) {
        int length = str.length();
        int[] iArr = {11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = str.charAt(i2);
            for (int i3 = 9; i3 >= 0; i3--) {
                cArr[i2] = (char) (cArr[i2] ^ iArr[i3]);
            }
        }
        return new String(cArr);
    }

    private int b(String str) {
        try {
            return Settings.Secure.getInt(this.c.getContentResolver(), str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private boolean b() {
        String str = Build.TAGS;
        return str != null && str.contains(c("lz}$blpz"));
    }

    public Map a(boolean z) {
        Map map;
        synchronized (this.e) {
            map = CollectionUtils.map(this.d);
        }
        return a(map, z);
    }

    private void a(Map map) {
        JSONArray D;
        if (((Boolean) this.f700a.a(v4.R3)).booleanValue() && !map.containsKey("af")) {
            map.put("af", Long.valueOf(d()));
        }
        if (((Boolean) this.f700a.a(v4.S3)).booleanValue() && !map.containsKey("font")) {
            map.put("font", Float.valueOf(r()));
        }
        if (((Boolean) this.f700a.a(v4.Z3)).booleanValue() && k7.d(this.f700a)) {
            k8.a(this.f700a);
        }
        if (((Boolean) this.f700a.a(v4.k4)).booleanValue()) {
            k8.b(this.f700a);
        }
        if (((Boolean) this.f700a.a(v4.Y3)).booleanValue() && !map.containsKey("sua")) {
            map.put("sua", System.getProperty("http.agent"));
        }
        if (((Boolean) this.f700a.a(v4.U3)).booleanValue() && !map.containsKey("network_restricted")) {
            map.put("network_restricted", Boolean.valueOf(O()));
        }
        map.put("is_pc", Boolean.valueOf(P()));
        if (((Boolean) this.f700a.a(v4.m4)).booleanValue()) {
            CollectionUtils.putStringIfValid("oglv", I(), map);
        }
        if (((Boolean) this.f700a.a(v4.y6)).booleanValue()) {
            CollectionUtils.putStringIfValid("dbpn", n(), map);
        }
        if (!((Boolean) this.f700a.a(v4.z6)).booleanValue() || map.containsKey("video_decoders") || (D = D()) == null || D.length() <= 0) {
            return;
        }
        map.put("video_decoders", D);
    }

    private Map a(Map map, boolean z) {
        v.a f;
        PowerManager powerManager;
        Map map2 = CollectionUtils.map(map);
        Point b2 = o0.b(this.c);
        map2.put("dx", Integer.valueOf(b2.x));
        map2.put("dy", Integer.valueOf(b2.y));
        if (this.c.getResources().getDisplayMetrics() != null) {
            map2.put("screen_size_in", Double.valueOf(Math.sqrt(Math.pow(b2.x, 2.0d) + Math.pow(b2.y, 2.0d)) / r4.xdpi));
        }
        map2.put("is_tablet", Boolean.valueOf(AppLovinSdkUtils.isTablet(this.c)));
        if (((Boolean) this.f700a.a(v4.B4)).booleanValue()) {
            String b3 = k7.b(this.c);
            Map a2 = o0.a(b3);
            if (a2 != null) {
                map2.put("display_cutout_insets", a2);
            }
            Map c2 = o0.c(b3);
            if (c2 != null) {
                map2.put("status_bar_insets", c2);
            }
            Map b4 = o0.b(b3);
            if (b4 != null) {
                map2.put("nav_bar_insets", b4);
            }
        }
        if (z) {
            f = (v.a) k.get();
            if (f != null) {
                T();
            } else if (k7.h()) {
                f = new v.a();
                map2.put("inc", Boolean.TRUE);
            } else {
                f = f();
            }
        } else {
            f = f();
        }
        String a3 = f.a();
        if (StringUtils.isValidString(a3)) {
            map2.put("idfa", a3);
        }
        map2.put("dnt", Boolean.valueOf(f.c()));
        map2.put("dnt_code", f.b().b());
        b bVar = (b) l.get();
        if (((Boolean) this.f700a.a(v4.w3)).booleanValue() && bVar != null) {
            map2.put("idfv", bVar.f702a);
            map2.put("idfv_scope", Integer.valueOf(bVar.b));
        }
        Boolean b5 = p0.b().b(this.c);
        if (b5 != null) {
            map2.put("huc", b5);
        }
        Boolean b6 = p0.c().b(this.c);
        if (b6 != null) {
            map2.put("aru", b6);
        }
        Boolean b7 = p0.a().b(this.c);
        if (b7 != null) {
            map2.put("dns", b7);
        }
        if (((Boolean) this.f700a.a(v4.L3)).booleanValue()) {
            c j2 = j();
            CollectionUtils.putIntegerIfValid("act", Integer.valueOf(j2.f703a), map2);
            CollectionUtils.putIntegerIfValid("acm", Integer.valueOf(j2.b), map2);
            CollectionUtils.putBooleanIfValid("sowpie", j2.c, map2);
        }
        if (((Boolean) this.f700a.a(v4.T3)).booleanValue()) {
            map2.put("mtl", Integer.valueOf(this.f700a.n0().getLastTrimMemoryLevel()));
        }
        if (((Boolean) this.f700a.a(v4.W3)).booleanValue()) {
            map2.put("adr", Boolean.valueOf(N()));
        }
        Float q = z ? (Float) this.h.get() : q();
        if (q != null) {
            map2.put("volume", q);
        }
        CollectionUtils.putBooleanIfValid("ma", u(), map2);
        CollectionUtils.putBooleanIfValid("spo", v(), map2);
        CollectionUtils.putBooleanIfValid("aif", Boolean.valueOf(!this.f700a.n0().isApplicationPaused()), map2);
        CollectionUtils.putLongIfValid("af_ts_ms", Long.valueOf(this.f700a.n0().getAppEnteredForegroundTimeMillis()), map2);
        CollectionUtils.putLongIfValid("ab_ts_ms", Long.valueOf(this.f700a.n0().getAppEnteredBackgroundTimeMillis()), map2);
        try {
            map2.put("sb", Integer.valueOf((int) ((Settings.System.getInt(this.c.getContentResolver(), "screen_brightness") / 255.0f) * 100.0f)));
        } catch (Settings.SettingNotFoundException e) {
            if (o.a()) {
                this.b.a("DataCollector", "Unable to collect screen brightness", e);
            }
        }
        if (((Boolean) this.f700a.a(v4.Z3)).booleanValue() && k7.d(this.f700a)) {
            k8.a(this.f700a);
            String a4 = k8.a();
            if (StringUtils.isValidString(a4)) {
                map2.put(N6.d0, a4);
            }
        }
        if (((Boolean) this.f700a.a(v4.k4)).booleanValue()) {
            k8.b(this.f700a);
            CollectionUtils.putIntegerIfValid("wvvc", Integer.valueOf(k8.d()), map2);
            CollectionUtils.putStringIfValid("wvv", k8.c(), map2);
            CollectionUtils.putStringIfValid("wvpn", k8.b(), map2);
        }
        if (((Boolean) this.f700a.a(v4.N3)).booleanValue()) {
            try {
                map2.put(N6.T0, Long.valueOf(Environment.getDataDirectory().getFreeSpace()));
                map2.put("tds", Long.valueOf(Environment.getDataDirectory().getTotalSpace()));
            } catch (Throwable th) {
                map2.put(N6.T0, -1);
                map2.put("tds", -1);
                if (o.a()) {
                    this.b.a("DataCollector", "Unable to collect total & free space.", th);
                }
            }
        }
        if (((Boolean) this.f700a.a(v4.O3)).booleanValue()) {
            ActivityManager.MemoryInfo a5 = k7.a((ActivityManager) this.c.getSystemService("activity"));
            if (a5 != null) {
                map2.put("fm", Long.valueOf(a5.availMem));
                map2.put("tm", Long.valueOf(a5.totalMem));
                map2.put("lmt", Long.valueOf(a5.threshold));
                map2.put("lm", Boolean.valueOf(a5.lowMemory));
            } else {
                map2.put("fm", -1);
                map2.put("tm", -1);
                map2.put("lmt", -1);
            }
        }
        if (((Boolean) this.f700a.a(v4.P3)).booleanValue() && o0.a("android.permission.READ_PHONE_STATE", this.c) && o0.g()) {
            map2.put("rat", Integer.valueOf(((TelephonyManager) this.c.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getDataNetworkType()));
        }
        if (((Boolean) this.f700a.a(v4.M3)).booleanValue()) {
            String z2 = z();
            if (!TextUtils.isEmpty(z2)) {
                map2.put("so", z2);
            }
        }
        map2.put("device_orientation", k7.b(this.c));
        map2.put("orientation_lock", h());
        if (((Boolean) this.f700a.a(v4.Q3)).booleanValue()) {
            map2.put("vs", Boolean.valueOf(k7.j()));
        }
        if (o0.e() && (powerManager = (PowerManager) this.c.getSystemService("power")) != null) {
            map2.put(N6.Y0, Integer.valueOf(powerManager.isPowerSaveMode() ? 1 : 0));
        }
        if (((Boolean) this.f700a.a(v4.b4)).booleanValue() && this.f700a.m0() != null) {
            map2.put("da", Float.valueOf(this.f700a.m0().a()));
        }
        if (((Boolean) this.f700a.a(v4.c4)).booleanValue() && this.f700a.m0() != null) {
            map2.put("dm", Float.valueOf(this.f700a.m0().b()));
        }
        map2.put("mute_switch", Integer.valueOf(this.f700a.q().c()));
        map2.put("network", r0.g(this.f700a));
        String p = p();
        if (StringUtils.isValidString(p)) {
            map2.put("kb", p);
        }
        ArrayService p2 = this.f700a.p();
        if (p2.isAppHubInstalled()) {
            if (p2.getIsDirectDownloadEnabled() != null) {
                map2.put("ah_dd_enabled", p2.getIsDirectDownloadEnabled());
            }
            map2.put("ah_sdk_version_code", Long.valueOf(p2.getAppHubVersionCode()));
            map2.put("ah_random_user_token", StringUtils.emptyIfNull(p2.getRandomUserToken()));
            map2.put("ah_sdk_package_name", StringUtils.emptyIfNull(p2.getAppHubPackageName()));
        }
        return map2;
    }

    private Map a(Intent intent) {
        if (intent == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(5);
        hashMap.put("action", StringUtils.emptyIfNull(intent.getAction()));
        hashMap.put("data", StringUtils.emptyIfNull(intent.getDataString()));
        hashMap.put("flags", Integer.valueOf(intent.getFlags()));
        ComponentName component = intent.getComponent();
        hashMap.put("component", component != null ? component.flattenToString() : "");
        Set<String> categories = intent.getCategories();
        hashMap.put("categories", categories != null ? new ArrayList(categories) : Collections.emptyList());
        return hashMap;
    }

    private String a(ApplicationExitInfo applicationExitInfo, int i2) {
        InputStream inputStream;
        String readLine;
        if (this.f700a.c(v4.A4).contains(Integer.toString(i2))) {
            return null;
        }
        Integer num = (Integer) this.f700a.a(v4.z4);
        if (num.intValue() <= 0) {
            return null;
        }
        try {
            inputStream = applicationExitInfo.getTraceInputStream();
        } catch (Throwable th) {
            this.f700a.O();
            if (o.a()) {
                this.f700a.O().a("DataCollector", "Failed to obtain trace input stream from application exit info", th);
            }
            this.f700a.E().b("DataCollector", "getTraceInputStream", th);
            inputStream = null;
        }
        if (inputStream == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            for (int i3 = 0; i3 < num.intValue() && (readLine = bufferedReader.readLine()) != null; i3++) {
                try {
                    sb.append(readLine).append('\n');
                } finally {
                }
            }
            bufferedReader.close();
        } catch (Throwable th2) {
            this.f700a.O();
            if (o.a()) {
                this.f700a.O().a("DataCollector", "Failed to read stack trace from input stream", th2);
            }
            this.f700a.E().b("DataCollector", "readStackTraceFromInputStream", th2);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, int i2, String str2) {
        HashMap<String, String> hashMap = CollectionUtils.hashMap("details", str);
        CollectionUtils.putIntegerIfValid(AndroidBridgeConstants.ERROR_CODE, Integer.valueOf(i2), hashMap);
        CollectionUtils.putStringIfValid("error_message", str2, hashMap);
        this.f700a.E().d(c2.s0, hashMap);
    }

    public static void a(v.a aVar) {
        k.set(aVar);
    }

    public static void a(b bVar) {
        l.set(bVar);
    }

    public static void a(String str, k kVar) {
        String a2 = a(k.o().getApplicationInfo().packageName, k.o().getPackageManager(), kVar);
        List c2 = kVar.c(v4.K6);
        if (!StringUtils.isValidString(a2) || c2.contains(a2)) {
            i = str;
        }
    }

    private boolean a(String str) {
        return b(str) == 1;
    }

    private static String a(String str, PackageManager packageManager, k kVar) {
        try {
            if (((Boolean) kVar.a(v4.u4)).booleanValue() && o0.b()) {
                return packageManager.getInstallSourceInfo(str).getInstallingPackageName();
            }
            return packageManager.getInstallerPackageName(str);
        } catch (Throwable th) {
            kVar.E().a("DataCollector", "getInstallerName", th);
            return null;
        }
    }
}
