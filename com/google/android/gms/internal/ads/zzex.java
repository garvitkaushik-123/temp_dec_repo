package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.AudioFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.explorestack.protobuf.openrtb.LossReason;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.common.base.Ascii;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.media3.common.C;
import io.bidmachine.media3.exoplayer.upstream.CmcdConfiguration;
import io.bidmachine.media3.extractor.ts.TsExtractor;
import io.bidmachine.rendering.model.EventTaskParams;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzex {
    private static HashMap zzd;
    public static final String zza = Build.DEVICE + ", " + Build.MODEL + ", " + Build.MANUFACTURER + ", " + Build.VERSION.SDK_INT;
    public static final byte[] zzb = new byte[0];
    private static final Pattern zzc = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
    private static final String[] zze = {"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR, "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", ScarConstants.IN_SIGNAL_KEY, "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", CmcdConfiguration.KEY_BUFFER_STARVATION, "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
    private static final String[] zzf = {"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
    private static final int[] zzg = {0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
    private static final int[] zzh = {0, 4129, 8258, 12387, 16516, 20645, 24774, 28903, 33032, 37161, 41290, 45419, 49548, 53677, 57806, 61935};
    private static final int[] zzi = {0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, 126, Sdk.SDKError.Reason.TPAT_ERROR_VALUE, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, Sdk.SDKError.Reason.AD_RESPONSE_INVALID_TEMPLATE_TYPE_VALUE, Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, Sdk.SDKError.Reason.INVALID_GZIP_BID_PAYLOAD_VALUE, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, TsExtractor.TS_STREAM_TYPE_DTS_UHD, 130, Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 168, 175, 166, 161, 180, 179, 186, 189, 199, 192, 201, 206, Sdk.SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE, Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, Sdk.SDKError.Reason.INVALID_ADUNIT_BID_PAYLOAD_VALUE, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, 142, 135, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, Sdk.SDKError.Reason.BIDPAYLOAD_TEMPLATE_TYPE_MISMATCH_ERROR_VALUE, 235, 236, 193, 198, 207, 200, Sdk.SDKError.Reason.AD_LOAD_FAIL_RETRY_AFTER_VALUE, Sdk.SDKError.Reason.MRAID_JS_DOES_NOT_EXIST_VALUE, LossReason.LOSS_REASON_CREATIVE_FILTERED_ANIMATION_TOO_LONG_VALUE, 212, 105, 110, 103, 96, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, 114, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, ModuleDescriptor.MODULE_VERSION, Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, Sdk.SDKError.Reason.INVALID_WATERFALL_PLACEMENT_ID_VALUE, Sdk.SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE, 208, Sdk.SDKError.Reason.AD_RESPONSE_EMPTY_VALUE, 194, 197, 204, 203, 230, Sdk.SDKError.Reason.BIDPAYLOAD_PLACEMENT_ID_MISMATCH_ERROR_VALUE, 232, 239, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 253, 244, 243};

    public static zzz zzA(int i, int i2, int i3) {
        zzx zzxVar = new zzx();
        zzxVar.zzah("audio/raw");
        zzxVar.zzD(i2);
        zzxVar.zzai(i3);
        zzxVar.zzab(i);
        return zzxVar.zzan();
    }

    public static String zzB(byte[] bArr) {
        return new String(bArr, StandardCharsets.UTF_8);
    }

    public static String zzC(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, StandardCharsets.UTF_8);
    }

    public static String zzD(int i) {
        switch (i) {
            case -2:
                return "none";
            case -1:
                return "unknown";
            case 0:
                return EventTaskParams.STATE_GROUP_DEFAULT;
            case 1:
                return "audio";
            case 2:
                return "video";
            case 3:
                return "text";
            case 4:
                return "image";
            case 5:
                return "metadata";
            default:
                return "camera motion";
        }
    }

    public static String zzE(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !replace.equals("und")) {
            str = replace;
        }
        String zza2 = zzfuv.zza(str);
        int i = 0;
        String str2 = zza2.split("-", 2)[0];
        if (zzd == null) {
            zzd = zzU();
        }
        String str3 = (String) zzd.get(str2);
        if (str3 != null) {
            zza2 = str3.concat(String.valueOf(zza2.substring(str2.length())));
            str2 = str3;
        }
        if ("no".equals(str2) || "i".equals(str2) || "zh".equals(str2)) {
            while (true) {
                String[] strArr = zzf;
                int length = strArr.length;
                if (i >= 18) {
                    break;
                }
                if (zza2.startsWith(strArr[i])) {
                    return String.valueOf(strArr[i + 1]).concat(String.valueOf(zza2.substring(strArr[i].length())));
                }
                i += 2;
            }
        }
        return zza2;
    }

    public static ExecutorService zzF(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.google.android.gms.internal.ads.zzev
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                String str2 = zzex.zza;
                return new Thread(runnable, str);
            }
        });
    }

    public static boolean zzH(SparseArray sparseArray, int i) {
        return sparseArray.indexOfKey(i) >= 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0045, code lost:
    
        r4.zzK(r3);
        r1 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean zzI(zzen zzenVar, zzen zzenVar2, Inflater inflater) {
        boolean z = false;
        if (zzenVar.zza() == 0) {
            return false;
        }
        if (zzenVar2.zzb() < zzenVar.zza()) {
            int zza2 = zzenVar.zza();
            zzenVar2.zzF(zza2 + zza2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(zzenVar.zzN(), zzenVar.zzc(), zzenVar.zza());
        int i = 0;
        while (true) {
            try {
                i += inflater.inflate(zzenVar2.zzN(), i, zzenVar2.zzb() - i);
                if (!inflater.finished()) {
                    if (inflater.needsDictionary() || inflater.needsInput()) {
                        break;
                    }
                    if (i == zzenVar2.zzb()) {
                        int zzb2 = zzenVar2.zzb();
                        zzenVar2.zzF(zzb2 + zzb2);
                    }
                } else {
                    break;
                }
            } catch (DataFormatException unused) {
            } catch (Throwable th) {
                inflater.reset();
                throw th;
            }
        }
        inflater.reset();
        return z;
    }

    public static boolean zzJ(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }

    public static boolean zzK(int i) {
        return i == 3 || i == 2 || i == 268435456 || i == 21 || i == 1342177280 || i == 22 || i == 1610612736 || i == 4;
    }

    public static boolean zzL(Context context) {
        if (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) {
            return true;
        }
        if (Build.VERSION.SDK_INT == 30 && (zzfuv.zzc(Build.MODEL, "moto g(20)") || zzfuv.zzc(Build.MODEL, "rmx3231"))) {
            return true;
        }
        return Build.VERSION.SDK_INT == 34 && zzfuv.zzc(Build.MODEL, "sm-x200");
    }

    public static boolean zzM(int i) {
        return i == 10 || i == 13;
    }

    public static boolean zzN(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static boolean zzO(zzen zzenVar, zzen zzenVar2, Inflater inflater) {
        return zzenVar.zza() > 0 && zzenVar.zzf() == 120 && zzI(zzenVar, zzenVar2, inflater);
    }

    public static boolean zzP(Handler handler, Runnable runnable) {
        Looper looper = handler.getLooper();
        if (!looper.getThread().isAlive()) {
            return false;
        }
        if (looper != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static Object[] zzQ(Object[] objArr, int i) {
        zzdd.zzd(i <= objArr.length);
        return Arrays.copyOf(objArr, i);
    }

    private static int zzR(int i, int i2) {
        return (char) (zzh[i ^ (i2 >> 12)] ^ ((char) (i2 << 4)));
    }

    private static long zzS(long j, long j2, long j3, RoundingMode roundingMode) {
        long zzd2 = zzgbo.zzd(j, j2);
        if (zzd2 != Long.MAX_VALUE && zzd2 != Long.MIN_VALUE) {
            return zzgbo.zzb(zzd2, j3, roundingMode);
        }
        long zzc2 = zzgbo.zzc(Math.abs(j2), Math.abs(j3));
        long zzb2 = zzgbo.zzb(j2, zzc2, RoundingMode.UNNECESSARY);
        long zzb3 = zzgbo.zzb(j3, zzc2, RoundingMode.UNNECESSARY);
        long zzc3 = zzgbo.zzc(Math.abs(j), Math.abs(zzb3));
        long zzb4 = zzgbo.zzb(j, zzc3, RoundingMode.UNNECESSARY);
        long zzb5 = zzgbo.zzb(zzb3, zzc3, RoundingMode.UNNECESSARY);
        long zzd3 = zzgbo.zzd(zzb4, zzb2);
        if (zzd3 != Long.MAX_VALUE && zzd3 != Long.MIN_VALUE) {
            return zzgbo.zzb(zzd3, zzb5, roundingMode);
        }
        double d = zzb4 * (zzb2 / zzb5);
        if (d > 9.223372036854776E18d) {
            return Long.MAX_VALUE;
        }
        if (d < -9.223372036854776E18d) {
            return Long.MIN_VALUE;
        }
        return zzgbj.zzb(d, roundingMode);
    }

    private static String zzT(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e) {
            zzea.zzd("Util", "Failed to read system property ".concat(str), e);
            return null;
        }
    }

    private static HashMap zzU() {
        String[] iSOLanguages = Locale.getISOLanguages();
        int length = iSOLanguages.length;
        int length2 = zze.length;
        HashMap hashMap = new HashMap(length + 88);
        int i = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    hashMap.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = zze;
            int length3 = strArr.length;
            if (i >= 88) {
                return hashMap;
            }
            hashMap.put(strArr[i], strArr[i + 1]);
            i += 2;
        }
    }

    public static int zza(long[] jArr, long j, boolean z, boolean z2) {
        int i;
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            return ~binarySearch;
        }
        while (true) {
            i = binarySearch + 1;
            if (i >= jArr.length || jArr[i] != j) {
                break;
            }
            binarySearch = i;
        }
        return !z ? i : binarySearch;
    }

    public static int zzb(zzeb zzebVar, long j, boolean z, boolean z2) {
        int zza2 = zzebVar.zza() - 1;
        int i = 0;
        while (i <= zza2) {
            int i2 = (i + zza2) >>> 1;
            if (zzebVar.zzb(i2) < j) {
                i = i2 + 1;
            } else {
                zza2 = i2 - 1;
            }
        }
        int i3 = zza2 + 1;
        if (i3 < zzebVar.zza() && zzebVar.zzb(i3) == j) {
            return i3;
        }
        if (zza2 == -1) {
            return 0;
        }
        return zza2;
    }

    public static int zzc(int[] iArr, int i, boolean z, boolean z2) {
        int i2;
        int i3;
        int binarySearch = Arrays.binarySearch(iArr, i);
        if (binarySearch < 0) {
            i3 = -(binarySearch + 2);
        } else {
            while (true) {
                i2 = binarySearch - 1;
                if (i2 < 0 || iArr[i2] != i) {
                    break;
                }
                binarySearch = i2;
            }
            i3 = z ? binarySearch : i2;
        }
        return z2 ? Math.max(0, i3) : i3;
    }

    public static int zzd(long[] jArr, long j, boolean z, boolean z2) {
        int i;
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            i = -(binarySearch + 2);
        } else {
            while (true) {
                int i2 = binarySearch - 1;
                if (i2 < 0 || jArr[i2] != j) {
                    break;
                }
                binarySearch = i2;
            }
            i = binarySearch;
        }
        return z2 ? Math.max(0, i) : i;
    }

    public static int zze(byte[] bArr, int i, int i2, int i3) {
        int i4 = 65535;
        for (int i5 = 0; i5 < i2; i5++) {
            byte b = bArr[i5];
            i4 = zzR(b & Ascii.SI, zzR((b & 255) >> 4, i4));
        }
        return i4;
    }

    public static int zzf(byte[] bArr, int i, int i2, int i3) {
        while (i < i2) {
            i3 = zzg[(i3 >>> 24) ^ (bArr[i] & 255)] ^ (i3 << 8);
            i++;
        }
        return i3;
    }

    public static int zzg(byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        while (i < i2) {
            i4 = zzi[i4 ^ (bArr[i] & 255)];
            i++;
        }
        return i4;
    }

    public static int zzh(int i) {
        if (i == 20) {
            return 30;
        }
        if (i == 22) {
            return 31;
        }
        if (i == 30) {
            return 34;
        }
        switch (i) {
            case 2:
            case 3:
                return 3;
            case 4:
            case 5:
            case 6:
                return 21;
            case 7:
            case 8:
                return 23;
            case 9:
            case 10:
            case 11:
            case 12:
                return 28;
            default:
                switch (i) {
                    case 14:
                        return 25;
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        return 28;
                    default:
                        return Integer.MAX_VALUE;
                }
        }
    }

    public static int zzi(int i) {
        int i2;
        int i3 = 6396;
        if (i == 10) {
            i2 = 737532;
        } else {
            if (i == 12) {
                return 743676;
            }
            if (i != 24) {
                switch (i) {
                    case 1:
                        return 4;
                    case 2:
                        return 12;
                    case 3:
                        return 28;
                    case 4:
                        return 204;
                    case 5:
                        return Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE;
                    case 6:
                        return 252;
                    case 7:
                        return 1276;
                    case 8:
                        return 6396;
                    default:
                        return 0;
                }
            }
            i2 = 67108860;
            i3 = 0;
        }
        return Build.VERSION.SDK_INT >= 32 ? i2 : i3;
    }

    public static int zzj(ByteBuffer byteBuffer, int i) {
        int i2 = byteBuffer.getInt(i);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i2 : Integer.reverseBytes(i2);
    }

    public static int zzk(int i) {
        if (i != 2) {
            if (i == 3) {
                return 1;
            }
            if (i != 4) {
                if (i != 21) {
                    if (i != 22) {
                        if (i != 268435456) {
                            if (i != 1342177280) {
                                if (i != 1610612736) {
                                    throw new IllegalArgumentException();
                                }
                            }
                        }
                    }
                }
                return 3;
            }
            return 4;
        }
        return 2;
    }

    public static int zzl(int i) {
        if (i == 2 || i == 4) {
            return 6005;
        }
        if (i == 10) {
            return 6004;
        }
        if (i == 7) {
            return 6005;
        }
        if (i == 8) {
            return 6003;
        }
        switch (i) {
            case 15:
                return 6003;
            case 16:
            case 18:
                return 6005;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return 6002;
                    default:
                        return 6006;
                }
        }
    }

    public static int zzm(String str) {
        String[] split;
        int length;
        if (str == null || (length = (split = str.split("_", -1)).length) < 2) {
            return 0;
        }
        String str2 = split[length - 1];
        boolean z = length >= 3 && "neg".equals(split[length + (-2)]);
        try {
            if (str2 == null) {
                throw null;
            }
            String str3 = str2;
            int parseInt = Integer.parseInt(str2);
            return z ? -parseInt : parseInt;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int zzo(Uri uri) {
        char c;
        String scheme = uri.getScheme();
        if (scheme != null && (zzfuv.zzc("rtsp", scheme) || zzfuv.zzc("rtspt", scheme))) {
            return 3;
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return 4;
        }
        int lastIndexOf = lastPathSegment.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String zza2 = zzfuv.zza(lastPathSegment.substring(lastIndexOf + 1));
            switch (zza2.hashCode()) {
                case 104579:
                    if (zza2.equals("ism")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 108321:
                    if (zza2.equals("mpd")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3242057:
                    if (zza2.equals("isml")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3299913:
                    if (zza2.equals("m3u8")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            int i = c != 0 ? c != 1 ? (c == 2 || c == 3) ? 1 : 4 : 2 : 0;
            if (i != 4) {
                return i;
            }
        }
        Pattern pattern = zzc;
        String path = uri.getPath();
        path.getClass();
        Matcher matcher = pattern.matcher(path);
        if (!matcher.matches()) {
            return 4;
        }
        String group = matcher.group(2);
        if (group != null) {
            if (group.contains("format=mpd-time-csf")) {
                return 0;
            }
            if (group.contains("format=m3u8-aapl")) {
                return 2;
            }
        }
        return 1;
    }

    public static long zzp(long j, int i) {
        return zzu(j, i, 1000000L, RoundingMode.UP);
    }

    public static long zzq(long j, float f) {
        return f == 1.0f ? j : Math.round(j * f);
    }

    public static long zzr(long j, float f) {
        return f == 1.0f ? j : Math.round(j / f);
    }

    public static long zzs(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000;
    }

    public static long zzt(long j, int i) {
        return zzu(j, 1000000L, i, RoundingMode.DOWN);
    }

    public static long zzu(long j, long j2, long j3, RoundingMode roundingMode) {
        if (j == 0 || j2 == 0) {
            return 0L;
        }
        return (j3 < j2 || j3 % j2 != 0) ? (j3 >= j2 || j2 % j3 != 0) ? (j3 < j || j3 % j != 0) ? (j3 >= j || j % j3 != 0) ? zzS(j, j2, j3, roundingMode) : zzgbo.zzd(j2, zzgbo.zzb(j, j3, RoundingMode.UNNECESSARY)) : zzgbo.zzb(j2, zzgbo.zzb(j3, j, RoundingMode.UNNECESSARY), roundingMode) : zzgbo.zzd(j, zzgbo.zzb(j2, j3, RoundingMode.UNNECESSARY)) : zzgbo.zzb(j, zzgbo.zzb(j3, j2, RoundingMode.UNNECESSARY), roundingMode);
    }

    public static long zzv(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000;
    }

    public static Point zzw(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        Display display = displayManager != null ? displayManager.getDisplay(0) : null;
        if (display == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            windowManager.getClass();
            display = windowManager.getDefaultDisplay();
        }
        if (display.getDisplayId() == 0 && zzN(context)) {
            String zzT = zzT("vendor.display-size");
            if (!TextUtils.isEmpty(zzT)) {
                try {
                    String[] split = zzT.trim().split(VastAttributes.HORIZONTAL_POSITION, -1);
                    if (split.length == 2) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new Point(parseInt, parseInt2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                zzea.zzc("Util", "Invalid display size: ".concat(String.valueOf(zzT)));
            }
            if ("Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
        return point;
    }

    public static AudioFormat zzx(int i, int i2, int i3) {
        return new AudioFormat.Builder().setSampleRate(i).setChannelMask(i2).setEncoding(i3).build();
    }

    public static Handler zzy(Handler.Callback callback) {
        Looper myLooper = Looper.myLooper();
        zzdd.zzb(myLooper);
        return new Handler(myLooper, null);
    }

    public static Looper zzz() {
        Looper myLooper = Looper.myLooper();
        return myLooper != null ? myLooper : Looper.getMainLooper();
    }

    public static int zzn(int i, ByteOrder byteOrder) {
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return byteOrder.equals(ByteOrder.LITTLE_ENDIAN) ? 2 : 268435456;
        }
        if (i == 24) {
            if (byteOrder.equals(ByteOrder.LITTLE_ENDIAN)) {
                return 21;
            }
            return C.ENCODING_PCM_24BIT_BIG_ENDIAN;
        }
        if (i != 32) {
            return 0;
        }
        if (byteOrder.equals(ByteOrder.LITTLE_ENDIAN)) {
            return 22;
        }
        return C.ENCODING_PCM_32BIT_BIG_ENDIAN;
    }

    public static void zzG(long[] jArr, long j, long j2) {
        long j3;
        RoundingMode roundingMode = RoundingMode.DOWN;
        int i = 0;
        if (j2 >= 1000000 && j2 % 1000000 == 0) {
            long zzb2 = zzgbo.zzb(j2, 1000000L, RoundingMode.UNNECESSARY);
            while (i < jArr.length) {
                jArr[i] = zzgbo.zzb(jArr[i], zzb2, roundingMode);
                i++;
            }
            return;
        }
        if (j2 < 1000000 && 1000000 % j2 == 0) {
            long zzb3 = zzgbo.zzb(1000000L, j2, RoundingMode.UNNECESSARY);
            while (i < jArr.length) {
                jArr[i] = zzgbo.zzd(jArr[i], zzb3);
                i++;
            }
            return;
        }
        int i2 = 0;
        while (i2 < jArr.length) {
            long j4 = jArr[i2];
            if (j4 != 0) {
                if (j2 >= j4 && j2 % j4 == 0) {
                    jArr[i2] = zzgbo.zzb(1000000L, zzgbo.zzb(j2, j4, RoundingMode.UNNECESSARY), roundingMode);
                } else if (j2 >= j4 || j4 % j2 != 0) {
                    j3 = j2;
                    jArr[i2] = zzS(j4, 1000000L, j3, roundingMode);
                    i2++;
                    j2 = j3;
                } else {
                    jArr[i2] = zzgbo.zzd(1000000L, zzgbo.zzb(j4, j2, RoundingMode.UNNECESSARY));
                }
            }
            j3 = j2;
            i2++;
            j2 = j3;
        }
    }
}
