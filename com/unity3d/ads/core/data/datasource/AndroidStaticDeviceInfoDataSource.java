package com.unity3d.ads.core.data.datasource;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.SystemClock;
import android.os.ext.SdkExtensions;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import androidx.autofill.HintConstants;
import com.ironsource.C3040d4;
import com.unity3d.ads.core.data.model.StorageType;
import com.unity3d.ads.datastore.ByteStringStoreOuterClass;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.device.AdvertisingId;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.device.OpenAdvertisingId;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.preferences.AndroidPreferences;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import com.unity3d.services.core.properties.SdkProperties;
import gatewayprotocol.v1.StaticDeviceInfoKt;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.security.auth.x500.X500Principal;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: AndroidStaticDeviceInfoDataSource.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 m2\u00020\u0001:\u0001mB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001f\u0010\u0015\u001a\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0017H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\u0006\u0010\u001c\u001a\u00020\u000eJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u000eH\u0002J\u0013\u0010#\u001a\u0004\u0018\u00010\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0006\u0010%\u001a\u00020\u000eJ\u0006\u0010&\u001a\u00020\u000eJ\u0006\u0010'\u001a\u00020\u000eJ\b\u0010(\u001a\u0004\u0018\u00010\u000eJ\b\u0010)\u001a\u0004\u0018\u00010\u000eJ\b\u0010*\u001a\u00020!H\u0002J\b\u0010+\u001a\u00020\u000eH\u0002J\b\u0010,\u001a\u00020\u000eH\u0003J\u0006\u0010-\u001a\u00020\u000eJ\u0006\u0010.\u001a\u00020\u000eJ\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020\u001eH\u0002J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020\u000eH\u0002J\u0013\u00107\u001a\u0004\u0018\u00010\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010$J\b\u00108\u001a\u00020\u000eH\u0002J\u0006\u00109\u001a\u00020\u000eJ\u0006\u0010:\u001a\u00020\u000eJ\u0011\u0010;\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010$J\b\u0010<\u001a\u00020\u000eH\u0003J\b\u0010=\u001a\u00020\u000eH\u0016J\u0010\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020@H\u0002J\u0012\u0010A\u001a\u00020!2\b\u0010B\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010C\u001a\u00020\u000eH\u0016J\u000e\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000e0EH\u0003J\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0017H\u0002J\b\u0010G\u001a\u00020\u000eH\u0002J\b\u0010H\u001a\u00020\u000eH\u0016J\b\u0010I\u001a\u00020\u001eH\u0002J\b\u0010J\u001a\u00020\u000eH\u0002J\u0006\u0010K\u001a\u00020\u000eJ\b\u0010L\u001a\u00020\u001eH\u0002J\b\u0010M\u001a\u00020\u001eH\u0002J\b\u0010N\u001a\u00020\u001eH\u0002J\b\u0010O\u001a\u00020\u001eH\u0002J\f\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u0017J\b\u0010R\u001a\u00020\u000eH\u0002J\u001e\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00172\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0017H\u0002J\f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0017J\b\u0010U\u001a\u00020!H\u0016J\u0006\u0010V\u001a\u00020!J\u0010\u0010W\u001a\u00020!2\b\u0010X\u001a\u0004\u0018\u000103J\b\u0010Y\u001a\u00020\u001eH\u0002J\b\u0010Z\u001a\u00020\u000eH\u0002J\b\u0010[\u001a\u00020\u000eH\u0002J\u0006\u0010\\\u001a\u00020]J\u0006\u0010^\u001a\u00020]J\b\u0010_\u001a\u00020]H\u0002J\u001a\u0010`\u001a\u00020]2\u0006\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010d\u001a\u00020]2\u0006\u0010a\u001a\u00020bH\u0003J\u0006\u0010e\u001a\u00020]J\b\u0010f\u001a\u00020]H\u0002J\u001a\u0010g\u001a\u00020]2\u0006\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010h\u001a\u00020]2\u0006\u0010a\u001a\u00020bH\u0003J\b\u0010i\u001a\u00020]H\u0002J\u0010\u0010j\u001a\u00020]2\u0006\u0010k\u001a\u00020\u000eH\u0002J\u0018\u0010l\u001a\b\u0012\u0004\u0012\u00020b0\u00172\b\u0010c\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006n"}, d2 = {"Lcom/unity3d/ads/core/data/datasource/AndroidStaticDeviceInfoDataSource;", "Lcom/unity3d/ads/core/data/datasource/StaticDeviceInfoDataSource;", "context", "Landroid/content/Context;", "glInfoStore", "Lcom/unity3d/ads/core/data/datasource/ByteStringDataSource;", "analyticsDataSource", "Lcom/unity3d/ads/core/data/datasource/AnalyticsDataSource;", "storeDataSource", "Lcom/unity3d/ads/core/data/datasource/StoreDataSource;", "(Landroid/content/Context;Lcom/unity3d/ads/core/data/datasource/ByteStringDataSource;Lcom/unity3d/ads/core/data/datasource/AnalyticsDataSource;Lcom/unity3d/ads/core/data/datasource/StoreDataSource;)V", "DEBUG_CERT", "Ljavax/security/auth/x500/X500Principal;", "analyticsUserId", "", "getAnalyticsUserId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "staticDeviceInfo", "Lgatewayprotocol/v1/StaticDeviceInfoOuterClass$StaticDeviceInfo;", "fetch", "additionalStores", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAndroidStaticDeviceInfo", "Lgatewayprotocol/v1/StaticDeviceInfoOuterClass$StaticDeviceInfo$Android;", "fetchCached", "getAdvertisingTrackingId", "getApiLevel", "", "getAppName", "getAppStartTime", "", "getAppVersion", "getAuid", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBoard", "getBootloader", "getBrand", "getBuildId", "getBuildVersionIncremental", "getCPUCount", "getCPUModel", "getCertificateFingerprint", "getDevice", "getDisplay", "getDisplayMetricDensity", "", "getExtensionVersion", "getFileForStorageType", "Ljava/io/File;", "storageType", "Lcom/unity3d/ads/core/data/model/StorageType;", "getFingerprint", "getGPUModel", "getGameId", "getHardware", "getHost", "getIdfi", "getInstallerPackageName", "getManufacturer", "getMemoryInfo", "infoType", "Lcom/unity3d/services/core/device/Device$MemoryInfoType;", "getMemoryValueFromString", "memVal", "getModel", "getNewAbiList", "Ljava/util/ArrayList;", "getOldAbiList", "getOpenAdvertisingTrackingId", "getOsVersion", "getPhoneType", "getPlatform", "getProduct", "getScreenDensity", "getScreenHeight", "getScreenLayout", "getScreenWidth", "getSensorList", "Landroid/hardware/Sensor;", "getSimOperator", "getStores", "getSupportedAbis", "getSystemBootTime", "getTotalMemory", "getTotalSpace", C3040d4.h.b, "getVersionCode", "getVersionName", "getWebViewUserAgent", "hasX264Decoder", "", "hasX265Decoder", "isAppDebuggable", "isHardwareAccelerated", "codecInfo", "Landroid/media/MediaCodecInfo;", "mimeType", "isHardwareAcceleratedV29", "isLimitOpenAdTrackingEnabled", "isRooted", "isSoftwareOnly", "isSoftwareOnlyV29", "isTestMode", "searchPathForBinary", "binary", "selectAllDecodeCodecs", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidStaticDeviceInfoDataSource implements StaticDeviceInfoDataSource {
    public static final String ALGORITHM_SHA1 = "SHA-1";
    public static final String APP_VERSION_FAKE = "FakeVersionName";
    public static final String BINARY_SU = "su";
    public static final String CERTIFICATE_TYPE_X509 = "X.509";
    public static final String ENVIRONMENT_VARIABLE_PATH = "PATH";
    public static final String PLATFORM_ANDROID = "android";
    public static final String STORE_GOOGLE = "google";
    private final X500Principal DEBUG_CERT;
    private final AnalyticsDataSource analyticsDataSource;
    private final Context context;
    private final ByteStringDataSource glInfoStore;
    private StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo;
    private final StoreDataSource storeDataSource;

    /* compiled from: AndroidStaticDeviceInfoDataSource.kt */
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
            int[] iArr2 = new int[StorageType.values().length];
            try {
                iArr2[StorageType.INTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[StorageType.EXTERNAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private final int getVersionCode() {
        return 41601;
    }

    public AndroidStaticDeviceInfoDataSource(Context context, ByteStringDataSource glInfoStore, AnalyticsDataSource analyticsDataSource, StoreDataSource storeDataSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(glInfoStore, "glInfoStore");
        Intrinsics.checkNotNullParameter(analyticsDataSource, "analyticsDataSource");
        Intrinsics.checkNotNullParameter(storeDataSource, "storeDataSource");
        this.context = context;
        this.glInfoStore = glInfoStore;
        this.analyticsDataSource = analyticsDataSource;
        this.storeDataSource = storeDataSource;
        this.DEBUG_CERT = new X500Principal("CN=Android Debug,O=Android,C=US");
        StaticDeviceInfoKt.Dsl.Companion companion = StaticDeviceInfoKt.Dsl.INSTANCE;
        StaticDeviceInfoOuterClass.StaticDeviceInfo.Builder newBuilder = StaticDeviceInfoOuterClass.StaticDeviceInfo.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        StaticDeviceInfoKt.Dsl _create = companion._create(newBuilder);
        _create.setBundleId(getAppName());
        _create.setBundleVersion(getAppVersion());
        _create.setAppDebuggable(isAppDebuggable());
        _create.setRooted(isRooted());
        _create.setOsVersion(getOsVersion());
        _create.setDeviceMake(getManufacturer());
        _create.setDeviceModel(getModel());
        _create.setWebviewUa(getWebViewUserAgent());
        _create.setScreenDensity(getScreenDensity());
        _create.setScreenWidth(getScreenWidth());
        _create.setScreenHeight(getScreenHeight());
        _create.setScreenSize(getScreenLayout());
        _create.addAllStores(_create.getStores(), getStores$default(this, null, 1, null));
        _create.setTotalDiskSpace(getTotalSpace(getFileForStorageType(StorageType.EXTERNAL)));
        _create.setTotalRamMemory(getTotalMemory());
        _create.setCpuModel(getCPUModel());
        _create.setCpuCount(getCPUCount());
        _create.setAndroid(fetchAndroidStaticDeviceInfo());
        _create.setMadeWithUnity(MadeWithUnityDetector.isMadeWithUnity());
        this.staticDeviceInfo = _create._build();
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.unity3d.ads.core.data.datasource.StaticDeviceInfoDataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetch(List<String> list, Continuation<? super StaticDeviceInfoOuterClass.StaticDeviceInfo> continuation) {
        AndroidStaticDeviceInfoDataSource$fetch$1 androidStaticDeviceInfoDataSource$fetch$1;
        int i;
        AndroidStaticDeviceInfoDataSource androidStaticDeviceInfoDataSource;
        String str;
        if (continuation instanceof AndroidStaticDeviceInfoDataSource$fetch$1) {
            androidStaticDeviceInfoDataSource$fetch$1 = (AndroidStaticDeviceInfoDataSource$fetch$1) continuation;
            if ((androidStaticDeviceInfoDataSource$fetch$1.label & Integer.MIN_VALUE) != 0) {
                androidStaticDeviceInfoDataSource$fetch$1.label -= Integer.MIN_VALUE;
                Object obj = androidStaticDeviceInfoDataSource$fetch$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidStaticDeviceInfoDataSource$fetch$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String gpuModel = this.staticDeviceInfo.getGpuModel();
                    if (gpuModel != null && gpuModel.length() != 0) {
                        return this.staticDeviceInfo;
                    }
                    androidStaticDeviceInfoDataSource$fetch$1.L$0 = this;
                    androidStaticDeviceInfoDataSource$fetch$1.L$1 = list;
                    androidStaticDeviceInfoDataSource$fetch$1.label = 1;
                    obj = getGPUModel(androidStaticDeviceInfoDataSource$fetch$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    androidStaticDeviceInfoDataSource = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list = (List) androidStaticDeviceInfoDataSource$fetch$1.L$1;
                    androidStaticDeviceInfoDataSource = (AndroidStaticDeviceInfoDataSource) androidStaticDeviceInfoDataSource$fetch$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                String str2 = (String) obj;
                str = str2;
                if (str != null || str.length() == 0) {
                    return androidStaticDeviceInfoDataSource.staticDeviceInfo;
                }
                StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo = androidStaticDeviceInfoDataSource.staticDeviceInfo;
                StaticDeviceInfoKt.Dsl.Companion companion = StaticDeviceInfoKt.Dsl.INSTANCE;
                StaticDeviceInfoOuterClass.StaticDeviceInfo.Builder builder = staticDeviceInfo.toBuilder();
                Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
                StaticDeviceInfoKt.Dsl _create = companion._create(builder);
                _create.setGpuModel(str2);
                _create.clearStores(_create.getStores());
                _create.addAllStores(_create.getStores(), androidStaticDeviceInfoDataSource.getStores(list));
                StaticDeviceInfoOuterClass.StaticDeviceInfo _build = _create._build();
                androidStaticDeviceInfoDataSource.staticDeviceInfo = _build;
                return _build;
            }
        }
        androidStaticDeviceInfoDataSource$fetch$1 = new AndroidStaticDeviceInfoDataSource$fetch$1(this, continuation);
        Object obj2 = androidStaticDeviceInfoDataSource$fetch$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidStaticDeviceInfoDataSource$fetch$1.label;
        if (i != 0) {
        }
        String str22 = (String) obj2;
        str = str22;
        if (str != null) {
        }
        return androidStaticDeviceInfoDataSource.staticDeviceInfo;
    }

    @Override // com.unity3d.ads.core.data.datasource.StaticDeviceInfoDataSource
    /* renamed from: fetchCached, reason: from getter */
    public StaticDeviceInfoOuterClass.StaticDeviceInfo getStaticDeviceInfo() {
        return this.staticDeviceInfo;
    }

    private final StaticDeviceInfoOuterClass.StaticDeviceInfo.Android fetchAndroidStaticDeviceInfo() {
        StaticDeviceInfoKt staticDeviceInfoKt = StaticDeviceInfoKt.INSTANCE;
        StaticDeviceInfoKt.AndroidKt.Dsl.Companion companion = StaticDeviceInfoKt.AndroidKt.Dsl.INSTANCE;
        StaticDeviceInfoOuterClass.StaticDeviceInfo.Android.Builder newBuilder = StaticDeviceInfoOuterClass.StaticDeviceInfo.Android.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        StaticDeviceInfoKt.AndroidKt.Dsl _create = companion._create(newBuilder);
        _create.setApiLevel(getApiLevel());
        _create.setVersionCode(getVersionCode());
        _create.setAndroidFingerprint(getFingerprint());
        _create.setAppInstaller(getInstallerPackageName());
        _create.setApkDeveloperSigningCertificateHash(getCertificateFingerprint());
        _create.setBuildBoard(getBoard());
        _create.setBuildBrand(getBrand());
        _create.setBuildDevice(getDevice());
        _create.setBuildDisplay(getDisplay());
        _create.setBuildFingerprint(getFingerprint());
        _create.setBuildHardware(getHardware());
        _create.setBuildHost(getHost());
        _create.setBuildBootloader(getBootloader());
        _create.setBuildProduct(getProduct());
        _create.setExtensionVersion(getExtensionVersion());
        String buildId = getBuildId();
        if (buildId != null) {
            _create.setBuildId(buildId);
        }
        _create.setPhoneType(getPhoneType());
        _create.setSimOperator(getSimOperator());
        return _create._build();
    }

    private final int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    @Override // com.unity3d.ads.core.data.datasource.StaticDeviceInfoDataSource
    public String getOsVersion() {
        String str = Build.VERSION.RELEASE;
        return str == null ? "" : str;
    }

    @Override // com.unity3d.ads.core.data.datasource.StaticDeviceInfoDataSource
    public String getManufacturer() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str;
    }

    @Override // com.unity3d.ads.core.data.datasource.StaticDeviceInfoDataSource
    public String getModel() {
        String str = Build.MODEL;
        return str == null ? "" : str;
    }

    private final int getScreenLayout() {
        return this.context.getResources().getConfiguration().screenLayout;
    }

    public final String getAdvertisingTrackingId() {
        String advertisingTrackingId = AdvertisingId.getAdvertisingTrackingId();
        return advertisingTrackingId == null ? "" : advertisingTrackingId;
    }

    private final String getOpenAdvertisingTrackingId() {
        String openAdvertisingTrackingId = OpenAdvertisingId.getOpenAdvertisingTrackingId();
        return openAdvertisingTrackingId == null ? "" : openAdvertisingTrackingId;
    }

    public final boolean isLimitOpenAdTrackingEnabled() {
        return OpenAdvertisingId.getLimitedOpenAdTracking();
    }

    @Override // com.unity3d.ads.core.data.datasource.StaticDeviceInfoDataSource
    public Object getIdfi(Continuation<? super String> continuation) {
        String string = AndroidPreferences.getString("unityads-installinfo", UnityAdsConstants.Preferences.PREF_KEY_IDFI);
        if (string == null) {
            string = null;
        }
        if (string != null) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        AndroidPreferences.setString("unityads-installinfo", UnityAdsConstants.Preferences.PREF_KEY_IDFI, uuid);
        return uuid;
    }

    @Override // com.unity3d.ads.core.data.datasource.StaticDeviceInfoDataSource
    public String getAnalyticsUserId() {
        return this.analyticsDataSource.getUserId();
    }

    @Override // com.unity3d.ads.core.data.datasource.StaticDeviceInfoDataSource
    public long getSystemBootTime() {
        return (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000;
    }

    @Override // com.unity3d.ads.core.data.datasource.StaticDeviceInfoDataSource
    public Object getAuid(Continuation<? super String> continuation) {
        String string = AndroidPreferences.getString("supersonic_shared_preferen", "auid");
        if (string == null) {
            return null;
        }
        return string;
    }

    private final float getDisplayMetricDensity() {
        DisplayMetrics displayMetrics;
        Resources resources = this.context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return 0.0f;
        }
        return displayMetrics.density;
    }

    private final int getScreenDensity() {
        DisplayMetrics displayMetrics;
        Resources resources = this.context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return -1;
        }
        return displayMetrics.densityDpi;
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

    private final boolean isRooted() {
        try {
            return searchPathForBinary("su");
        } catch (Exception e) {
            DeviceLog.exception("Rooted check failed", e);
            return false;
        }
    }

    private final boolean searchPathForBinary(String binary) {
        List emptyList;
        String[] strArr;
        File[] listFiles;
        String str = System.getenv(ENVIRONMENT_VARIABLE_PATH);
        if (str != null) {
            List<String> split = new Regex(":").split(str, 0);
            if (split != null) {
                if (!split.isEmpty()) {
                    ListIterator<String> listIterator = split.listIterator(split.size());
                    while (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() != 0) {
                            emptyList = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                }
                emptyList = CollectionsKt.emptyList();
                if (emptyList != null && (strArr = (String[]) emptyList.toArray(new String[0])) != null) {
                    for (String str2 : strArr) {
                        File file = new File(str2);
                        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                            for (File file2 : listFiles) {
                                if (Intrinsics.areEqual(file2.getName(), binary)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Deprecated(message = "This constant was deprecated in API level 28. Use GET_SIGNING_CERTIFICATES instead")
    private final String getCertificateFingerprint() {
        try {
            Signature[] signatureArr = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 64).signatures;
            if (signatureArr != null) {
                if (!(signatureArr.length == 0)) {
                    Certificate generateCertificate = CertificateFactory.getInstance(CERTIFICATE_TYPE_X509).generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()));
                    Intrinsics.checkNotNull(generateCertificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    String hexString = Utilities.toHexString(MessageDigest.getInstance(ALGORITHM_SHA1).digest(((X509Certificate) generateCertificate).getEncoded()));
                    Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(publicKey)");
                    return hexString;
                }
                return "";
            }
            return "";
        } catch (Exception e) {
            DeviceLog.exception("Exception when signing certificate fingerprint", e);
            return "";
        }
    }

    public final String getBoard() {
        String str = Build.BOARD;
        return str == null ? "" : str;
    }

    public final String getBootloader() {
        String str = Build.BOOTLOADER;
        return str == null ? "" : str;
    }

    public final String getBrand() {
        String str = Build.BRAND;
        return str == null ? "" : str;
    }

    public final String getDisplay() {
        String str = Build.DISPLAY;
        return str == null ? "" : str;
    }

    public final String getDevice() {
        String str = Build.DEVICE;
        return str == null ? "" : str;
    }

    public final String getHardware() {
        String str = Build.HARDWARE;
        return str == null ? "" : str;
    }

    public final String getHost() {
        String str = Build.HOST;
        return str == null ? "" : str;
    }

    public final String getProduct() {
        String str = Build.PRODUCT;
        return str == null ? "" : str;
    }

    private final String getFingerprint() {
        String str = Build.FINGERPRINT;
        return str == null ? "" : str;
    }

    @Deprecated(message = "This method was deprecated in API level 30. use getInstallSourceInfo")
    private final String getInstallerPackageName() {
        String installerPackageName = this.context.getPackageManager().getInstallerPackageName(this.context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }

    public final List<String> getSupportedAbis() {
        if (getApiLevel() < 21) {
            return getOldAbiList();
        }
        return getNewAbiList();
    }

    public final List<Sensor> getSensorList() {
        Object systemService = this.context.getSystemService("sensor");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        List<Sensor> sensorList = ((SensorManager) systemService).getSensorList(-1);
        Intrinsics.checkNotNullExpressionValue(sensorList, "sensorManager.getSensorList(Sensor.TYPE_ALL)");
        return sensorList;
    }

    private final String getCPUModel() {
        if (Build.VERSION.SDK_INT >= 31) {
            String str = Build.SOC_MODEL;
            Intrinsics.checkNotNullExpressionValue(str, "{\n            Build.SOC_MODEL\n        }");
            return str;
        }
        try {
            return (String) CollectionsKt.last(FilesKt.readLines$default(new File("/proc/cpuinfo"), null, 1, null));
        } catch (FileNotFoundException e) {
            DeviceLog.exception("Error reading CPU model", e);
            return "";
        }
    }

    private final long getCPUCount() {
        return Runtime.getRuntime().availableProcessors();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getGPUModel(Continuation<? super String> continuation) {
        AndroidStaticDeviceInfoDataSource$getGPUModel$1 androidStaticDeviceInfoDataSource$getGPUModel$1;
        int i;
        if (continuation instanceof AndroidStaticDeviceInfoDataSource$getGPUModel$1) {
            androidStaticDeviceInfoDataSource$getGPUModel$1 = (AndroidStaticDeviceInfoDataSource$getGPUModel$1) continuation;
            if ((androidStaticDeviceInfoDataSource$getGPUModel$1.label & Integer.MIN_VALUE) != 0) {
                androidStaticDeviceInfoDataSource$getGPUModel$1.label -= Integer.MIN_VALUE;
                Object obj = androidStaticDeviceInfoDataSource$getGPUModel$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidStaticDeviceInfoDataSource$getGPUModel$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ByteStringDataSource byteStringDataSource = this.glInfoStore;
                    androidStaticDeviceInfoDataSource$getGPUModel$1.label = 1;
                    obj = byteStringDataSource.get(androidStaticDeviceInfoDataSource$getGPUModel$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((ByteStringStoreOuterClass.ByteStringStore) obj).getData().toString(Charsets.UTF_8);
            }
        }
        androidStaticDeviceInfoDataSource$getGPUModel$1 = new AndroidStaticDeviceInfoDataSource$getGPUModel$1(this, continuation);
        Object obj2 = androidStaticDeviceInfoDataSource$getGPUModel$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidStaticDeviceInfoDataSource$getGPUModel$1.label;
        if (i != 0) {
        }
        return ((ByteStringStoreOuterClass.ByteStringStore) obj2).getData().toString(Charsets.UTF_8);
    }

    public final String getBuildId() {
        return Build.ID;
    }

    public final String getBuildVersionIncremental() {
        return Build.VERSION.INCREMENTAL;
    }

    private final List<String> getOldAbiList() {
        ArrayList arrayList = new ArrayList();
        String CPU_ABI = Build.CPU_ABI;
        Intrinsics.checkNotNullExpressionValue(CPU_ABI, "CPU_ABI");
        arrayList.add(CPU_ABI);
        String CPU_ABI2 = Build.CPU_ABI2;
        Intrinsics.checkNotNullExpressionValue(CPU_ABI2, "CPU_ABI2");
        arrayList.add(CPU_ABI2);
        return arrayList;
    }

    private final ArrayList<String> getNewAbiList() {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] SUPPORTED_ABIS = Build.SUPPORTED_ABIS;
        Intrinsics.checkNotNullExpressionValue(SUPPORTED_ABIS, "SUPPORTED_ABIS");
        arrayList.addAll(CollectionsKt.listOf(Arrays.copyOf(SUPPORTED_ABIS, SUPPORTED_ABIS.length)));
        return arrayList;
    }

    private final String getWebViewUserAgent() {
        try {
            String defaultUserAgent = WebSettings.getDefaultUserAgent(this.context);
            Intrinsics.checkNotNullExpressionValue(defaultUserAgent, "{\n        WebSettings.ge…tUserAgent(context)\n    }");
            return defaultUserAgent;
        } catch (Exception e) {
            DeviceLog.exception("Exception getting webview user agent", e);
            return "";
        }
    }

    private final List<String> getStores(List<String> additionalStores) {
        return this.storeDataSource.fetchStores(additionalStores);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List getStores$default(AndroidStaticDeviceInfoDataSource androidStaticDeviceInfoDataSource, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        return androidStaticDeviceInfoDataSource.getStores(list);
    }

    private final long getAppStartTime() {
        return SdkProperties.getInitializationTimeEpoch();
    }

    private final String getVersionName() {
        return "4.16.1";
    }

    private final boolean isTestMode() {
        return SdkProperties.isTestMode();
    }

    private final String getPlatform() {
        return "android";
    }

    private final String getGameId() {
        String gameId = ClientProperties.getGameId();
        return gameId == null ? "" : gameId;
    }

    public final long getTotalMemory() {
        return getMemoryInfo(Device.MemoryInfoType.TOTAL_MEMORY);
    }

    private final long getMemoryInfo(Device.MemoryInfoType infoType) {
        String str;
        FileNotFoundException e;
        RandomAccessFile randomAccessFile;
        Throwable th;
        int i = WhenMappings.$EnumSwitchMapping$0[infoType.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
        }
        try {
            try {
                randomAccessFile = new RandomAccessFile(AndroidDynamicDeviceInfoDataSource.DIRECTORY_MEM_INFO, "r");
            } catch (FileNotFoundException e2) {
                e = e2;
                DeviceLog.exception("Error reading memory info", e);
                return getMemoryValueFromString(str);
            }
        } catch (FileNotFoundException e3) {
            str = null;
            e = e3;
            DeviceLog.exception("Error reading memory info", e);
            return getMemoryValueFromString(str);
        }
        try {
            RandomAccessFile randomAccessFile2 = randomAccessFile;
            str = null;
            for (int i3 = 0; i3 < i2; i3++) {
                try {
                    str = randomAccessFile2.readLine();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        CloseableKt.closeFinally(randomAccessFile, th);
                        throw th3;
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(randomAccessFile, null);
            return getMemoryValueFromString(str);
        } catch (Throwable th4) {
            str = null;
            th = th4;
        }
    }

    private final long getMemoryValueFromString(String memVal) {
        if (memVal == null) {
            return 0L;
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

    public final long getTotalSpace(File file) {
        if (file == null || !file.exists()) {
            return -1L;
        }
        return MathKt.roundToInt(file.getTotalSpace() / 1024);
    }

    private final File getFileForStorageType(StorageType storageType) {
        int i = WhenMappings.$EnumSwitchMapping$1[storageType.ordinal()];
        if (i == 1) {
            return this.context.getCacheDir();
        }
        if (i == 2) {
            return this.context.getExternalCacheDir();
        }
        DeviceLog.error("Unhandled storagetype: " + storageType);
        return null;
    }

    @Override // com.unity3d.ads.core.data.datasource.StaticDeviceInfoDataSource
    public String getAppName() {
        String packageName = this.context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return packageName;
    }

    private final String getAppVersion() {
        String str;
        String packageName = this.context.getPackageName();
        PackageManager packageManager = this.context.getPackageManager();
        try {
            if (packageManager.getPackageInfo(packageName, 0).versionName == null) {
                str = APP_VERSION_FAKE;
            } else {
                str = packageManager.getPackageInfo(packageName, 0).versionName;
            }
            Intrinsics.checkNotNullExpressionValue(str, "{\n            if (pm.get…e\n            }\n        }");
            return str;
        } catch (PackageManager.NameNotFoundException e) {
            DeviceLog.exception("Error getting package info", e);
            return "";
        }
    }

    private final boolean isAppDebuggable() {
        boolean z;
        PackageManager packageManager = this.context.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "context.packageManager");
        String packageName = this.context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        boolean z2 = true;
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "pm.getApplicationInfo(pkgName, 0)");
            applicationInfo.flags &= 2;
            if (applicationInfo.flags != 0) {
                z = true;
                z2 = false;
            } else {
                z2 = false;
                z = false;
            }
        } catch (PackageManager.NameNotFoundException e) {
            DeviceLog.exception("Could not find name", e);
            z = false;
        }
        if (z2) {
            try {
                Signature[] signatures = packageManager.getPackageInfo(packageName, 64).signatures;
                Intrinsics.checkNotNullExpressionValue(signatures, "signatures");
                for (Signature signature : signatures) {
                    Certificate generateCertificate = CertificateFactory.getInstance(CERTIFICATE_TYPE_X509).generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
                    Intrinsics.checkNotNull(generateCertificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    z = Intrinsics.areEqual(((X509Certificate) generateCertificate).getSubjectX500Principal(), this.DEBUG_CERT);
                    if (z) {
                        break;
                    }
                }
            } catch (PackageManager.NameNotFoundException e2) {
                DeviceLog.exception("Could not find name", e2);
            } catch (CertificateException e3) {
                DeviceLog.exception("Certificate exception", e3);
            }
        }
        return z;
    }

    private final int getExtensionVersion() {
        if (Build.VERSION.SDK_INT >= 30) {
            return SdkExtensions.getExtensionVersion(30);
        }
        return -1;
    }

    public final boolean hasX264Decoder() {
        return !selectAllDecodeCodecs("video/avc").isEmpty();
    }

    public final boolean hasX265Decoder() {
        return !selectAllDecodeCodecs("video/hevc").isEmpty();
    }

    private final List<MediaCodecInfo> selectAllDecodeCodecs(String mimeType) {
        ArrayList arrayList = new ArrayList();
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfo = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfo.isEncoder()) {
                for (String str : codecInfo.getSupportedTypes()) {
                    if (StringsKt.equals(str, mimeType, true)) {
                        Intrinsics.checkNotNullExpressionValue(codecInfo, "codecInfo");
                        if (isHardwareAccelerated(codecInfo, mimeType)) {
                            arrayList.add(codecInfo);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private final boolean isHardwareAccelerated(MediaCodecInfo codecInfo, String mimeType) {
        if (getApiLevel() >= 29) {
            return isHardwareAcceleratedV29(codecInfo);
        }
        return !isSoftwareOnly(codecInfo, mimeType);
    }

    private final boolean isHardwareAcceleratedV29(MediaCodecInfo codecInfo) {
        return codecInfo.isHardwareAccelerated();
    }

    private final boolean isSoftwareOnly(MediaCodecInfo codecInfo, String mimeType) {
        if (getApiLevel() >= 29) {
            return isSoftwareOnlyV29(codecInfo);
        }
        String name = codecInfo.getName();
        Intrinsics.checkNotNullExpressionValue(name, "codecInfo.name");
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = name.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (StringsKt.startsWith$default(lowerCase, "arc.", false, 2, (Object) null)) {
            return false;
        }
        if (StringsKt.startsWith$default(lowerCase, "omx.google.", false, 2, (Object) null) || StringsKt.startsWith$default(lowerCase, "omx.ffmpeg.", false, 2, (Object) null)) {
            return true;
        }
        if ((StringsKt.startsWith$default(lowerCase, "omx.sec.", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) ".sw.", false, 2, (Object) null)) || Intrinsics.areEqual(lowerCase, "omx.qcom.video.decoder.hevcswvdec") || StringsKt.startsWith$default(lowerCase, "c2.android.", false, 2, (Object) null) || StringsKt.startsWith$default(lowerCase, "c2.google.", false, 2, (Object) null)) {
            return true;
        }
        return (StringsKt.startsWith$default(lowerCase, "omx.", false, 2, (Object) null) || StringsKt.startsWith$default(lowerCase, "c2.", false, 2, (Object) null)) ? false : true;
    }

    private final boolean isSoftwareOnlyV29(MediaCodecInfo codecInfo) {
        return codecInfo.isSoftwareOnly();
    }

    private final int getPhoneType() {
        Object systemService = this.context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        return ((TelephonyManager) systemService).getPhoneType();
    }

    private final String getSimOperator() {
        Object systemService = this.context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String simOperator = ((TelephonyManager) systemService).getSimOperator();
        Intrinsics.checkNotNullExpressionValue(simOperator, "telephonyManager.simOperator");
        return simOperator;
    }
}
