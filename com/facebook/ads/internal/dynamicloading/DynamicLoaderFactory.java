package com.facebook.ads.internal.dynamicloading;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.BuildConfig;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.facebook.ads.internal.util.common.ANActivityLifecycleCallbacksListener;
import com.facebook.ads.internal.util.common.Preconditions;
import dalvik.system.DexClassLoader;
import dalvik.system.InMemoryDexClassLoader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public class DynamicLoaderFactory {
    private static final String AUDIENCE_NETWORK_CODE_PATH = "audience_network";
    public static final String AUDIENCE_NETWORK_DEX_FOLDER_NAME = "audience_network";
    private static final String CODE_CACHE_DIR = "code_cache";
    static final String DEX_LOADING_ERROR_MESSAGE = "Can't load Audience Network Dex. Please, check that audience_network folder is inside of assets folder.";
    private static final int DEX_LOAD_RETRY_COUNT = 3;
    private static final int DEX_LOAD_RETRY_DELAY_MS = 200;
    private static final String DYNAMIC_LOADING_BUILD_TYPE = "releaseDL";
    private static final String OPTIMIZED_DEX_PATH = "optimized";
    private static boolean sFallbackMode;
    public static final boolean LOAD_FROM_ASSETS = "releaseDL".equals(BuildConfig.BUILD_TYPE);
    public static final AtomicReference<DynamicLoader> sDynamicLoader = new AtomicReference<>();
    private static final AtomicBoolean sInitializing = new AtomicBoolean();

    public interface RemoteClassLoaderFactory {
        ClassLoader create(Context context);
    }

    public static synchronized DynamicLoader makeLoaderUnsafe() {
        synchronized (DynamicLoaderFactory.class) {
            AtomicReference<DynamicLoader> atomicReference = sDynamicLoader;
            if (atomicReference.get() == null) {
                Context applicationContextViaReflection = getApplicationContextViaReflection();
                if (applicationContextViaReflection != null) {
                    return makeLoader(applicationContextViaReflection, true);
                }
                throw new RuntimeException("You must call AudienceNetworkAds.buildInitSettings(Context).initialize() before you can use Audience Network SDK.");
            }
            return atomicReference.get();
        }
    }

    public static void initialize(final Context context, final MultithreadedBundleWrapper multithreadedBundleWrapper, final AudienceNetworkAds.InitListener initListener, final boolean z) {
        if (z || !sInitializing.getAndSet(true)) {
            new Thread(new Runnable() { // from class: com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.1
                @Override // java.lang.Runnable
                public void run() {
                    Throwable th;
                    DynamicLoader dynamicLoader;
                    ANActivityLifecycleCallbacksListener.registerActivityCallbacks(context);
                    synchronized (DynamicLoaderFactory.class) {
                        DynamicLoader dynamicLoader2 = null;
                        th = null;
                        int i = 0;
                        while (i < 3) {
                            try {
                                dynamicLoader2 = DynamicLoaderFactory.doMakeLoader(context, false);
                                break;
                            } finally {
                            }
                        }
                        dynamicLoader = dynamicLoader2;
                    }
                    DynamicLoaderFactory.doCallInitialize(context, dynamicLoader, th, z, multithreadedBundleWrapper, initListener);
                    DynamicLoaderFactory.sInitializing.set(false);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doCallInitialize(Context context, DynamicLoader dynamicLoader, final Throwable th, boolean z, MultithreadedBundleWrapper multithreadedBundleWrapper, final AudienceNetworkAds.InitListener initListener) {
        if (th != null) {
            if (initListener != null) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AudienceNetworkAds.InitListener.this.onInitialized(DynamicLoaderFactory.createErrorInitResult(th));
                    }
                }, 100L);
                return;
            } else {
                Log.e(AudienceNetworkAds.TAG, DEX_LOADING_ERROR_MESSAGE, th);
                return;
            }
        }
        if (dynamicLoader != null) {
            if (z) {
                dynamicLoader.createAudienceNetworkAdsApi().onContentProviderCreated(context);
            } else {
                dynamicLoader.createAudienceNetworkAdsApi().initialize(context, multithreadedBundleWrapper, initListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AudienceNetworkAds.InitResult createErrorInitResult(final Throwable th) {
        return new AudienceNetworkAds.InitResult() { // from class: com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.3
            @Override // com.facebook.ads.AudienceNetworkAds.InitResult
            public boolean isSuccess() {
                return false;
            }

            @Override // com.facebook.ads.AudienceNetworkAds.InitResult
            public String getMessage() {
                return DynamicLoaderFactory.createErrorMessage(th);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String createErrorMessage(Throwable th) {
        return "Can't load Audience Network Dex. Please, check that audience_network folder is inside of assets folder.\n" + stackTraceToString(th);
    }

    public static synchronized DynamicLoader makeLoader(Context context) {
        DynamicLoader makeLoader;
        synchronized (DynamicLoaderFactory.class) {
            makeLoader = makeLoader(context, true);
        }
        return makeLoader;
    }

    public static synchronized DynamicLoader makeLoader(Context context, boolean z) {
        DynamicLoader doMakeLoader;
        synchronized (DynamicLoaderFactory.class) {
            Preconditions.checkNotNull(context, "Context can not be null.");
            try {
                doMakeLoader = doMakeLoader(context, z);
            } catch (Throwable th) {
                Log.e(AudienceNetworkAds.TAG, DEX_LOADING_ERROR_MESSAGE, th);
                DexLoadErrorReporter.reportDexLoadingIssue(context, createErrorMessage(th), 0.1d);
                DynamicLoader makeFallbackLoader = DynamicLoaderFallback.makeFallbackLoader();
                sDynamicLoader.set(makeFallbackLoader);
                sFallbackMode = true;
                return makeFallbackLoader;
            }
        }
        return doMakeLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DynamicLoader doMakeLoader(Context context, boolean z) throws Exception {
        AtomicReference<DynamicLoader> atomicReference = sDynamicLoader;
        DynamicLoader dynamicLoader = atomicReference.get();
        if (dynamicLoader == null) {
            if (!LOAD_FROM_ASSETS) {
                dynamicLoader = (DynamicLoader) Class.forName("com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl").newInstance();
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                dynamicLoader = (DynamicLoader) makeAdsSdkClassLoader(context.getApplicationContext()).loadClass("com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl").newInstance();
                Log.d(AudienceNetworkAds.TAG, "SDK dex loading time: " + (System.currentTimeMillis() - currentTimeMillis));
            }
            if (z) {
                dynamicLoader.maybeInitInternally(context);
            }
            atomicReference.set(dynamicLoader);
        }
        return dynamicLoader;
    }

    public static synchronized void setFallbackMode(boolean z) {
        synchronized (DynamicLoaderFactory.class) {
            if (z) {
                sDynamicLoader.set(DynamicLoaderFallback.makeFallbackLoader());
                sFallbackMode = true;
            } else {
                sDynamicLoader.set(null);
                sFallbackMode = false;
            }
        }
    }

    public static synchronized boolean isFallbackMode() {
        boolean z;
        synchronized (DynamicLoaderFactory.class) {
            z = sFallbackMode;
        }
        return z;
    }

    public static DynamicLoader getDynamicLoader() {
        return sDynamicLoader.get();
    }

    private static DexClassLoader makeLegacyAdsSdkClassLoader(Context context) throws Exception {
        String path = context.getFilesDir().getPath();
        String[] list = context.getAssets().list("audience_network");
        if (list == null || list.length == 0) {
            Log.e(AudienceNetworkAds.TAG, "Failed to find assets in audience_network");
            throw new RuntimeException("Failed to find assets in audience_network");
        }
        String[] strArr = new String[list.length];
        for (int i = 0; i < list.length; i++) {
            String str = list[i];
            strArr[i] = path + File.separator + str;
            InputStream open = context.getAssets().open("audience_network" + File.separator + str);
            FileOutputStream fileOutputStream = new FileOutputStream(strArr[i]);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                }
            }
            open.close();
            fileOutputStream.flush();
            fileOutputStream.close();
        }
        return new DexClassLoader(String.join(File.pathSeparator, strArr), context.getDir(OPTIMIZED_DEX_PATH, 0).getPath(), null, DynamicLoaderFactory.class.getClassLoader());
    }

    private static ClassLoader makeAdsSdkClassLoader(Context context) throws Exception {
        if (Build.VERSION.SDK_INT >= 30) {
            return createInMemoryClassLoader(context);
        }
        return makeLegacyAdsSdkClassLoader(context);
    }

    private static ClassLoader createInMemoryClassLoader(Context context) throws IOException {
        try {
            ClassLoader create = ((RemoteClassLoaderFactory) context.getClassLoader().loadClass("com.facebook.ads.internal.dynamicloading.RemoteClassLoaderFactoryImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0])).create(context);
            if (create != null) {
                return create;
            }
        } catch (Exception unused) {
            FlashPreferences.getSharedPreferences(context).edit().clear().apply();
        }
        String[] list = context.getAssets().list("audience_network");
        if (list == null || list.length == 0) {
            Log.e(AudienceNetworkAds.TAG, "Failed to find assets in audience_network");
            throw new RuntimeException("Failed to find assets in audience_network");
        }
        ByteBuffer[] byteBufferArr = new ByteBuffer[list.length];
        for (int i = 0; i < list.length; i++) {
            InputStream open = context.getAssets().open("audience_network" + File.separator + list[i]);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            }
            open.close();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            byteBufferArr[i] = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
        }
        return new InMemoryDexClassLoader(byteBufferArr, DynamicLoaderFactory.class.getClassLoader());
    }

    private static Context getApplicationContextViaReflection() {
        try {
            return (Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
        } catch (Throwable th) {
            Log.e(AudienceNetworkAds.TAG, "Failed to fetch Context from  ActivityThread. Audience Network SDK won't work unless you call AudienceNetworkAds.buildInitSettings().withListener(InitListener).initialize().", th);
            return null;
        }
    }

    private static File getCodeCacheDir(Context context, File file) throws IOException {
        return context.getCodeCacheDir();
    }

    private static File getCacheCodeDirLegacy(Context context, File file) throws IOException {
        File file2 = new File(file, CODE_CACHE_DIR);
        try {
            mkdirChecked(file2);
            return file2;
        } catch (IOException unused) {
            File dir = context.getDir(CODE_CACHE_DIR, 0);
            mkdirChecked(dir);
            return dir;
        }
    }

    private static File getSecondaryDir(File file) throws IOException {
        File file2 = new File(file, "audience_network");
        mkdirChecked(file2);
        return file2;
    }

    private static void mkdirChecked(File file) throws IOException {
        String str;
        file.mkdir();
        if (file.isDirectory()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            str = "Failed to create dir " + file.getPath() + ". Parent file is null.";
        } else {
            str = "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite();
        }
        Log.e(AudienceNetworkAds.TAG, str);
        throw new IOException("Failed to create directory " + file.getPath() + ", detailed message: " + str);
    }

    private static String stackTraceToString(Throwable th) {
        return Log.getStackTraceString(th);
    }
}
