package io.bidmachine;

import android.content.Context;
import android.media.AudioManager;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import io.bidmachine.core.Utils;
import io.bidmachine.util.DeviceUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class DeviceInfo {
    private static final String OS_NAME = "android";
    private static volatile DeviceInfo instance;
    private final HwInfoCache cache;
    private final Cpu cpu;
    private final Gpu gpu;
    private String hwv;
    private Boolean isRooted;
    public final boolean isTablet;
    public final String manufacturer;
    public final String model;
    public final String osName;
    public final String osVersion;
    public final String phoneCarrier;
    public final String phoneMCCMNC;
    public final float screenDensity;
    public final int screenDpi;
    private Long totalDiskSpaceInMB;
    private final Audio audio = new Audio();
    private final Ram ram = new Ram();

    public static DeviceInfo obtain(Context context) {
        DeviceInfo deviceInfo;
        DeviceInfo deviceInfo2 = instance;
        if (deviceInfo2 != null) {
            return deviceInfo2;
        }
        synchronized (DeviceInfo.class) {
            deviceInfo = instance;
            if (deviceInfo == null) {
                deviceInfo = new DeviceInfo(context);
                instance = deviceInfo;
            }
        }
        return deviceInfo;
    }

    private DeviceInfo(Context context) {
        HwInfoCache hwInfoCache = new HwInfoCache();
        this.cache = hwInfoCache;
        this.cpu = new Cpu(hwInfoCache);
        this.gpu = new Gpu(hwInfoCache);
        this.osName = "android";
        this.osVersion = String.valueOf(Build.VERSION.SDK_INT);
        this.manufacturer = DeviceUtils.getManufacturer();
        this.model = DeviceUtils.getModel();
        this.screenDpi = io.bidmachine.utils.DeviceUtils.getScreenDpi(context);
        this.screenDensity = DeviceUtils.getScreenDensity(context);
        this.isTablet = DeviceUtils.isTablet(context);
        this.phoneMCCMNC = DeviceUtils.getPhoneMCCMNC(context);
        this.phoneCarrier = DeviceUtils.getPhoneOperatorName(context);
    }

    boolean isDeviceRooted() {
        Boolean bool = this.isRooted;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = true;
        try {
            String[] strArr = {"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
            for (int i = 0; i < 8; i++) {
                if (new File(strArr[i]).exists()) {
                    Boolean bool2 = true;
                    this.isRooted = bool2;
                    return bool2.booleanValue();
                }
            }
        } catch (Exception unused) {
        }
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            if (new BufferedReader(new InputStreamReader(process.getInputStream())).readLine() == null) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            this.isRooted = valueOf;
            boolean booleanValue = valueOf.booleanValue();
            if (process != null) {
                process.destroy();
            }
            return booleanValue;
        } catch (Exception unused2) {
            if (process != null) {
                process.destroy();
            }
            Boolean bool3 = false;
            this.isRooted = bool3;
            return bool3.booleanValue();
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }

    String getHWV() {
        String str = this.hwv;
        if (str != null) {
            return str;
        }
        String kernelVersionThroughProcVersion = getKernelVersionThroughProcVersion();
        if (!TextUtils.isEmpty(kernelVersionThroughProcVersion)) {
            this.hwv = kernelVersionThroughProcVersion;
            return kernelVersionThroughProcVersion;
        }
        String kernelVersionThroughUName = getKernelVersionThroughUName();
        this.hwv = kernelVersionThroughUName;
        return kernelVersionThroughUName;
    }

    Long getTotalDiskSpaceInMB() {
        Long l = this.totalDiskSpaceInMB;
        if (l != null) {
            return l;
        }
        try {
            if (!Utils.isExternalMemoryAvailable()) {
                return null;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            Long valueOf = Long.valueOf((statFs.getBlockSizeLong() * statFs.getBlockCountLong()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            this.totalDiskSpaceInMB = valueOf;
            return valueOf;
        } catch (Exception unused) {
            return null;
        }
    }

    Long getAvailableDiskSpaceInMB() {
        try {
            if (!Utils.isExternalMemoryAvailable()) {
                return null;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.valueOf((statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        } catch (Exception unused) {
            return null;
        }
    }

    private String getKernelVersionThroughProcVersion() {
        RandomAccessFile randomAccessFile;
        Throwable th;
        try {
            randomAccessFile = new RandomAccessFile("/proc/version", "r");
            try {
                String readLine = randomAccessFile.readLine();
                Utils.close(randomAccessFile);
                return readLine;
            } catch (Exception unused) {
                Utils.close(randomAccessFile);
                return null;
            } catch (Throwable th2) {
                th = th2;
                Utils.close(randomAccessFile);
                throw th;
            }
        } catch (Exception unused2) {
            randomAccessFile = null;
        } catch (Throwable th3) {
            randomAccessFile = null;
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.BufferedReader, java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getKernelVersionThroughUName() {
        InputStreamReader inputStreamReader;
        ?? r3;
        Throwable th;
        Process process;
        try {
            process = Runtime.getRuntime().exec("uname -a");
            try {
                inputStreamReader = new InputStreamReader(process.getInputStream());
                try {
                    r3 = new BufferedReader(inputStreamReader);
                } catch (Exception unused) {
                    r3 = 0;
                } catch (Throwable th2) {
                    r3 = 0;
                    th = th2;
                }
            } catch (Exception unused2) {
                inputStreamReader = null;
                r3 = inputStreamReader;
                Utils.close(r3);
                Utils.close(inputStreamReader);
                if (process != null) {
                    process.destroy();
                }
                return null;
            } catch (Throwable th3) {
                r3 = 0;
                th = th3;
                inputStreamReader = null;
            }
            try {
                String readLine = r3.readLine();
                Utils.close(r3);
                Utils.close(inputStreamReader);
                if (process != null) {
                    process.destroy();
                }
                return readLine;
            } catch (Exception unused3) {
                Utils.close(r3);
                Utils.close(inputStreamReader);
                if (process != null) {
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                Utils.close(r3);
                Utils.close(inputStreamReader);
                if (process != null) {
                    process.destroy();
                }
                throw th;
            }
        } catch (Exception unused4) {
            process = null;
            inputStreamReader = null;
        } catch (Throwable th5) {
            inputStreamReader = null;
            r3 = 0;
            th = th5;
            process = null;
        }
    }

    Audio getAudio() {
        return this.audio;
    }

    Cpu getCpu() {
        return this.cpu;
    }

    Gpu getGpu() {
        return this.gpu;
    }

    Ram getRam() {
        return this.ram;
    }

    void updateHwInfo(Context context) {
        this.cpu.update(context);
        this.gpu.update(context);
        this.ram.update();
    }

    static final class Audio {
        Audio() {
        }

        Boolean isRingMuted(Context context) {
            AudioManager audioManager = getAudioManager(context);
            if (audioManager == null) {
                return null;
            }
            int ringerMode = audioManager.getRingerMode();
            boolean z = true;
            if (ringerMode != 0 && ringerMode != 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        }

        Float getVolumeLevel(Context context) {
            AudioManager audioManager = getAudioManager(context);
            if (audioManager == null) {
                return null;
            }
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3) - audioManager.getStreamMinVolume(3);
            if (streamMaxVolume == 0) {
                return Float.valueOf(0.0f);
            }
            return Float.valueOf((streamVolume - r4) / streamMaxVolume);
        }

        private AudioManager getAudioManager(Context context) {
            return (AudioManager) context.getSystemService("audio");
        }
    }

    static final class Cpu {
        public static final String KEY_NAME = "cpu_name";
        public static final String KEY_VENDOR = "cpu_vendor";
        private final HwInfoCache cache;
        private String name;
        private String vendor;

        Cpu(HwInfoCache cache) {
            this.cache = cache;
        }

        String getName() {
            return this.name;
        }

        String getVendor() {
            return this.vendor;
        }

        void update(Context context) {
            if (TextUtils.isEmpty(this.name)) {
                this.name = this.cache.read(context, KEY_NAME);
            }
            if (TextUtils.isEmpty(this.vendor)) {
                this.vendor = this.cache.read(context, KEY_VENDOR);
            }
            if (TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.vendor)) {
                extract();
                this.cache.store(context, KEY_NAME, this.name);
                this.cache.store(context, KEY_VENDOR, this.vendor);
            }
        }

        private void extract() {
            read();
            if (TextUtils.isEmpty(this.name)) {
                this.name = Build.BOARD;
            }
            if (TextUtils.isEmpty(this.vendor)) {
                this.vendor = Build.HARDWARE;
            }
        }

        private void read() {
            RandomAccessFile randomAccessFile;
            Throwable th;
            RandomAccessFile randomAccessFile2 = null;
            try {
                randomAccessFile = new RandomAccessFile("/proc/cpuinfo", "r");
                while (true) {
                    try {
                        String readLine = randomAccessFile.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (!readLine.startsWith("model name:") && !readLine.startsWith("Hardware:")) {
                            if (readLine.startsWith("vendor_id:")) {
                                this.vendor = findValue(readLine);
                            }
                            if (this.name == null && this.vendor != null) {
                                break;
                            }
                        }
                        this.name = findValue(readLine);
                        if (this.name == null) {
                        }
                    } catch (Exception unused) {
                        randomAccessFile2 = randomAccessFile;
                        Utils.close(randomAccessFile2);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.close(randomAccessFile);
                        throw th;
                    }
                }
                Utils.close(randomAccessFile);
            } catch (Exception unused2) {
            } catch (Throwable th3) {
                randomAccessFile = null;
                th = th3;
            }
        }

        private String findValue(String load) {
            Matcher matcher = Pattern.compile(":\\s*(.*)").matcher(load);
            if (matcher.find()) {
                return matcher.group(1);
            }
            return null;
        }
    }

    static final class Gpu {
        public static final String KEY_NAME = "gpu_name";
        public static final String KEY_VENDOR = "gpu_vendor";
        private final HwInfoCache cache;
        private String name;
        private String vendor;

        Gpu(HwInfoCache cache) {
            this.cache = cache;
        }

        String getName() {
            return this.name;
        }

        String getVendor() {
            return this.vendor;
        }

        void update(Context context) {
            if (TextUtils.isEmpty(this.name)) {
                this.name = this.cache.read(context, KEY_NAME);
            }
            if (TextUtils.isEmpty(this.vendor)) {
                this.vendor = this.cache.read(context, KEY_VENDOR);
            }
            if (TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.vendor)) {
                extract();
                this.cache.store(context, KEY_NAME, this.name);
                this.cache.store(context, KEY_VENDOR, this.vendor);
            }
        }

        private void extract() {
            EGLContext eGLContext;
            EGLSurface eGLSurface;
            EGLContext eGLContext2;
            EGLContext eGLContext3;
            EGLDisplay eGLDisplay = null;
            r0 = null;
            EGLContext eGLContext4 = null;
            EGLSurface eGLSurface2 = null;
            EGLDisplay eGLDisplay2 = null;
            try {
                EGLDisplay initEGLDisplay = initEGLDisplay();
                try {
                    EGLConfig chooseEGLConfig = chooseEGLConfig(initEGLDisplay);
                    if (chooseEGLConfig != null) {
                        eGLSurface = createEGLSurface(initEGLDisplay, chooseEGLConfig);
                        try {
                            eGLContext4 = createEGLContext(initEGLDisplay, chooseEGLConfig);
                            makeCurrent(initEGLDisplay, eGLSurface, eGLContext4);
                            this.name = GLES20.glGetString(7937);
                            this.vendor = GLES20.glGetString(7936);
                            eGLContext3 = eGLContext4;
                            eGLSurface2 = eGLSurface;
                        } catch (Exception unused) {
                            eGLContext2 = eGLContext4;
                            eGLDisplay2 = initEGLDisplay;
                            cleanUpEGL(eGLDisplay2, eGLSurface, eGLContext2);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            eGLContext = eGLContext4;
                            eGLDisplay = initEGLDisplay;
                            cleanUpEGL(eGLDisplay, eGLSurface, eGLContext);
                            throw th;
                        }
                    } else {
                        eGLContext3 = null;
                    }
                    cleanUpEGL(initEGLDisplay, eGLSurface2, eGLContext3);
                } catch (Exception unused2) {
                    eGLSurface = null;
                    eGLDisplay2 = initEGLDisplay;
                    eGLContext2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    eGLSurface = null;
                    eGLDisplay = initEGLDisplay;
                    eGLContext = null;
                }
            } catch (Exception unused3) {
                eGLContext2 = null;
                eGLSurface = null;
            } catch (Throwable th3) {
                th = th3;
                eGLContext = null;
                eGLSurface = null;
            }
        }

        private EGLDisplay initEGLDisplay() {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            int[] iArr = new int[2];
            EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1);
            return eglGetDisplay;
        }

        private EGLConfig chooseEGLConfig(EGLDisplay eglDisplay) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr = new int[1];
            EGL14.eglChooseConfig(eglDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr, 0);
            if (iArr[0] == 0) {
                return null;
            }
            return eGLConfigArr[0];
        }

        private EGLSurface createEGLSurface(EGLDisplay eglDisplay, EGLConfig eglConfig) {
            return EGL14.eglCreatePbufferSurface(eglDisplay, eglConfig, new int[]{12375, 64, 12374, 64, 12344}, 0);
        }

        private EGLContext createEGLContext(EGLDisplay eglDisplay, EGLConfig eglConfig) {
            return EGL14.eglCreateContext(eglDisplay, eglConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        }

        private void makeCurrent(EGLDisplay eglDisplay, EGLSurface eglSurface, EGLContext eglContext) {
            EGL14.eglMakeCurrent(eglDisplay, eglSurface, eglSurface, eglContext);
        }

        private void cleanUpEGL(EGLDisplay eglDisplay, EGLSurface eglSurface, EGLContext eglContext) {
            if (eglDisplay != null) {
                makeCurrent(eglDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                if (eglSurface != null) {
                    EGL14.eglDestroySurface(eglDisplay, eglSurface);
                }
                if (eglContext != null) {
                    EGL14.eglDestroyContext(eglDisplay, eglContext);
                }
                EGL14.eglTerminate(eglDisplay);
            }
        }
    }

    static final class Ram {
        private Long freeMem;
        private Long totalMem;

        Ram() {
        }

        Long getFreeMemBytes() {
            return this.freeMem;
        }

        Long getTotalMemBytes() {
            return this.totalMem;
        }

        void update() {
            RandomAccessFile randomAccessFile;
            Throwable th;
            RandomAccessFile randomAccessFile2 = null;
            try {
                randomAccessFile = new RandomAccessFile(AndroidDynamicDeviceInfoDataSource.DIRECTORY_MEM_INFO, "r");
                while (true) {
                    try {
                        String readLine = randomAccessFile.readLine();
                        if (readLine != null) {
                            if (readLine.startsWith("MemTotal:")) {
                                this.totalMem = parseValue(findValue(readLine));
                            } else if (readLine.startsWith("MemAvailable:")) {
                                this.freeMem = parseValue(findValue(readLine));
                            }
                            if (this.totalMem != null && this.freeMem != null) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (Exception unused) {
                        randomAccessFile2 = randomAccessFile;
                        Utils.close(randomAccessFile2);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.close(randomAccessFile);
                        throw th;
                    }
                }
                Utils.close(randomAccessFile);
            } catch (Exception unused2) {
            } catch (Throwable th3) {
                randomAccessFile = null;
                th = th3;
            }
        }

        private String findValue(String line) {
            Matcher matcher = Pattern.compile("(\\d+)").matcher(line);
            if (matcher.find()) {
                return matcher.group(1);
            }
            return null;
        }

        private Long parseValue(String value) {
            if (value == null) {
                return null;
            }
            try {
                return Long.valueOf(Long.parseLong(value) * 1024);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
    }
}
