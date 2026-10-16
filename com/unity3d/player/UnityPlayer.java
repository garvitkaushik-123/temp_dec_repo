package com.unity3d.player;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.InputEvent;
import android.view.OrientationEventListener;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.FrameLayout;
import androidx.autofill.HintConstants;
import com.ironsource.C3040d4;
import com.unity3d.player.a.AbstractC3503k;
import com.unity3d.player.a.AbstractC3510s;
import com.unity3d.player.a.C3502j;
import com.unity3d.player.a.EnumC3507o;
import java.io.UnsupportedEncodingException;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.fmod.FmodAndroidAudioManager;

/* loaded from: classes7.dex */
public abstract class UnityPlayer implements IUnityPlayerLifecycleEvents {
    private static final String ARCORE_ENABLE_METADATA_NAME = "unity.arcore-enable";
    private static final String AUTO_REPORT_FULLY_DRAWN_ENABLE_METADATA_NAME = "unity.auto-report-fully-drawn";
    private static final String AUTO_SET_GAME_STATE_ENABLE_METADATA_NAME = "unity.auto-set-game-state";
    private static final String LAUNCH_FULLSCREEN = "unity.launch-fullscreen";
    private static final String SPLASH_ENABLE_METADATA_NAME = "unity.splash-enable";
    private static final String SPLASH_MODE_METADATA_NAME = "unity.splash-mode";
    public static Activity currentActivity;
    public static Context currentContext;
    Activity mActivity;
    Context mContext;
    private EnumC3507o mContextType;
    private int mInitialScreenOrientation;
    boolean mQuitting;
    private c1 mVideoPlayerProxy;
    private ClipboardManager m_ClipboardManager;
    private FrameLayout m_FrameLayout;
    private HashMap m_PermissionRequests;
    private com.unity3d.player.a.K m_SplashScreen;
    TelephonyManager m_TelephonyManager;
    protected IUnityPlayerLifecycleEvents m_UnityPlayerLifecycleEvents;
    Window m_Window;
    private Configuration prevConfig;
    Handler mHandler = new Handler();
    private boolean mIsFullscreen = true;
    com.unity3d.player.a.S mState = new com.unity3d.player.a.S();
    private OrientationEventListener mOrientationListener = null;
    int mNaturalOrientation = -1;
    boolean m_AddPhoneCallListener = false;
    a m_PhoneCallListener = new a();
    private GoogleARCoreApi m_ARCoreApi = null;
    private C3535m0 m_FakeListener = new C3535m0();
    private Camera2Wrapper m_Camera2Wrapper = null;
    private HFPStatus m_HFPStatus = null;
    private AudioVolumeHandler m_AudioVolumeHandler = null;
    private OrientationLockListener m_OrientationLockListener = null;
    private FmodAndroidAudioManager m_FmodAndroidAudioManager = null;
    private com.unity3d.player.a.v m_NetworkConnectivity = null;
    private com.unity3d.player.a.x m_OnBackPressedDispatcher = null;
    private com.unity3d.player.a.P m_Cursor = null;
    private UnityAccessibilityDelegate m_AccessibilityDelegate = null;
    private final ConcurrentLinkedQueue m_MainThreadJobs = new ConcurrentLinkedQueue();
    private Thread m_UIThread = Thread.currentThread();

    private void developmentPlayerInitialize() {
    }

    private final native void initJni(Context context, int i, String str);

    private final native void nativeApplicationUnload();

    private final native void nativeHidePreservedContent();

    private final native boolean nativeInjectEvent(InputEvent inputEvent, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public final native boolean nativeIsAutorotationOn();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetLaunchURL(String str);

    private static native void nativeUnitySendMessage(String str, String str2, byte[] bArr);

    private final native void nativeViewPaddingChanged(int i, int i2, int i3, int i4, int i5);

    static native void permissionResponseToNative(long j, boolean z);

    abstract void cleanupResourcesForDestroy();

    public abstract SurfaceView getSurfaceView();

    public abstract View getView();

    abstract boolean handleFocus(boolean z);

    abstract void hidePreservedContent();

    public final native void nativeCrashNow();

    protected final native int nativeGetMainWindowIndex();

    protected final native void nativeMuteMasterAudio(boolean z);

    abstract void onOrientationChanged(int i, int i2);

    @Override // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerQuitted() {
    }

    @Override // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerUnloaded() {
    }

    public abstract boolean runningOnMainThread();

    public abstract void setMainSurfaceViewAspectRatio(float f);

    public static void UnitySendMessage(String str, String str2, String str3) {
        byte[] bytes;
        if (!com.unity3d.player.a.S.e) {
            com.unity3d.player.a.t.Log(5, "Native libraries not loaded - dropping message for " + str + "." + str2);
            return;
        }
        if (str3 == null) {
            bytes = null;
        } else {
            try {
                bytes = str3.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return;
            }
        }
        nativeUnitySendMessage(str, str2, bytes);
    }

    private static void unloadNative() {
        if (com.unity3d.player.a.S.e) {
            if (NativeLoader.unload()) {
                com.unity3d.player.a.S.e = false;
                return;
            }
            throw new UnsatisfiedLinkError("Unable to unload libraries from libmain.so");
        }
    }

    public boolean injectEvent(InputEvent inputEvent, int i) {
        if (com.unity3d.player.a.S.e) {
            return nativeInjectEvent(inputEvent, i);
        }
        return false;
    }

    public void invokeOnMainThread(Runnable runnable) {
        if (com.unity3d.player.a.S.e) {
            if (runningOnUIThread() || !runningOnMainThread()) {
                this.m_MainThreadJobs.add(runnable);
            } else {
                runnable.run();
            }
        }
    }

    boolean isNativeInitialized() {
        return com.unity3d.player.a.S.e && this.mState.d;
    }

    private boolean supportsWindowInsetController() {
        return PlatformSupport.RED_VELVET_CAKE_SUPPORT;
    }

    public class a extends PhoneStateListener {

        /* renamed from: a, reason: collision with root package name */
        public int f6496a = 0;

        public a() {
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCallStateChanged(int i, String str) {
            this.f6496a = i;
            UnityPlayer.this.nativeMuteMasterAudio(i == 1);
        }
    }

    public abstract class b implements Runnable {
        public abstract void a();

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (UnityPlayer.this.isFinishing()) {
                return;
            }
            a();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    Activity getActivity() {
        return this.mActivity;
    }

    EnumC3507o getContextType() {
        return this.mContextType;
    }

    protected UnityPlayer(Context context, EnumC3507o enumC3507o, IUnityPlayerLifecycleEvents iUnityPlayerLifecycleEvents) {
        String substring;
        this.mInitialScreenOrientation = -1;
        this.m_UnityPlayerLifecycleEvents = null;
        this.mContext = context;
        this.mContextType = enumC3507o;
        this.m_UnityPlayerLifecycleEvents = iUnityPlayerLifecycleEvents == null ? this : iUnityPlayerLifecycleEvents;
        String unityNativeLibraryPath = getUnityNativeLibraryPath(context);
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof com.unity3d.player.a.Q) {
            com.unity3d.player.a.Q q = (com.unity3d.player.a.Q) defaultUncaughtExceptionHandler;
            int i = -1;
            int i2 = -1;
            while (true) {
                int indexOf = unityNativeLibraryPath.indexOf(47, i + 1);
                if (indexOf == -1) {
                    break;
                }
                i2 = i;
                i = indexOf;
            }
            if (i2 < 0) {
                substring = "Unknown";
            } else {
                substring = unityNativeLibraryPath.substring(i2 + 1);
            }
            q.b = substring;
        }
        currentContext = context;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.mActivity = activity;
            currentActivity = activity;
            this.mInitialScreenOrientation = activity.getRequestedOrientation();
        }
    }

    protected void initialize(FrameLayout frameLayout) {
        initialize(frameLayout, "");
    }

    protected void initialize(FrameLayout frameLayout, String str) {
        if (frameLayout != null) {
            this.m_FrameLayout = frameLayout;
            EarlyEnableFullScreenIfEnabled();
        }
        Configuration configuration = this.mContext.getResources().getConfiguration();
        this.prevConfig = configuration;
        this.mNaturalOrientation = getNaturalOrientation(configuration.orientation);
        if (this.mActivity != null && getSplashEnabled()) {
            com.unity3d.player.a.K k = new com.unity3d.player.a.K(this.mContext, AbstractC3503k.b(3)[getSplashMode()]);
            this.m_SplashScreen = k;
            this.m_FrameLayout.addView(k);
            this.m_FrameLayout.bringChildToFront(this.m_SplashScreen);
        }
        preloadJavaPlugins();
        String loadNative = loadNative(getUnityNativeLibraryPath(this.mContext));
        if (!com.unity3d.player.a.S.e) {
            com.unity3d.player.a.t.Log(6, "Your hardware does not support this application.");
            AlertDialog create = new AlertDialog.Builder(this.mContext).setTitle("Failure to initialize!").setPositiveButton("OK", new DialogInterfaceOnClickListenerC3517d0(this)).setMessage("Your hardware does not support this application.\n\n" + loadNative + "\n\n Press OK to quit.").create();
            create.setCancelable(false);
            create.show();
            return;
        }
        initJni(this.mContext, this.mContextType.f6533a, str);
        this.mState.d = true;
        this.mQuitting = false;
        developmentPlayerInitialize();
        hideStatusBar();
        this.m_TelephonyManager = (TelephonyManager) this.mContext.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        this.m_ClipboardManager = (ClipboardManager) this.mContext.getSystemService("clipboard");
        this.m_Camera2Wrapper = new Camera2Wrapper(this.mContext);
        this.m_HFPStatus = new HFPStatus(this.mContext);
        this.m_Cursor = new com.unity3d.player.a.P(this);
        FmodAndroidAudioManager fmodAndroidAudioManager = FmodAndroidAudioManager.getInstance();
        this.m_FmodAndroidAudioManager = fmodAndroidAudioManager;
        fmodAndroidAudioManager.setActivity(this.mActivity);
        this.m_OnBackPressedDispatcher = C3542q.a(getContext(), 1, new RunnableC3519e0(this));
        Activity activity = this.mActivity;
        if (activity != null) {
            this.m_Window = activity.getWindow();
        }
    }

    private int getNaturalOrientation(int i) {
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        if ((rotation == 0 || rotation == 2) && i == 2) {
            return 0;
        }
        return ((rotation == 1 || rotation == 3) && i == 1) ? 0 : 1;
    }

    protected void toggleGyroscopeSensor(boolean z) {
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        if (z) {
            sensorManager.registerListener(this.m_FakeListener, defaultSensor, 1);
        } else {
            sensorManager.unregisterListener(this.m_FakeListener);
        }
    }

    private String GetGlViewContentDescription(Context context) {
        return context.getResources().getString(context.getResources().getIdentifier("game_view_content_description", "string", context.getPackageName()));
    }

    void disableStaticSplashScreen() {
        if (getFrameLayout() == null) {
            return;
        }
        runOnUiThread(new RunnableC3521f0(this));
    }

    private void EarlyEnableFullScreenIfEnabled() {
        Activity activity = this.mActivity;
        if (activity != null && activity.getWindow() != null && (getLaunchFullscreen() || this.mActivity.getIntent().getBooleanExtra("android.intent.extra.VR_LAUNCH", false))) {
            applyWindowUIChanges(true);
        }
        DisplayCutoutSupport.setLayoutCutoutMode(this.mActivity);
    }

    private boolean isWindowTranslucent() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return false;
        }
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{R.attr.windowIsTranslucent});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    protected void applySurfaceViewSettings(SurfaceView surfaceView) {
        if (isWindowTranslucent()) {
            surfaceView.getHolder().setFormat(-3);
            surfaceView.setZOrderOnTop(true);
        } else {
            surfaceView.getHolder().setFormat(-1);
        }
    }

    void finish() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.mActivity.finish();
    }

    void runOnAnonymousThread(Runnable runnable) {
        new Thread(runnable).start();
    }

    void runOnUiThread(Runnable runnable) {
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.runOnUiThread(runnable);
        } else if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.mHandler.post(runnable);
        } else {
            runnable.run();
        }
    }

    void postOnUiThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void newIntent(Intent intent) {
        setLaunchURL(intent.getData());
    }

    public void destroy() {
        Camera2Wrapper camera2Wrapper = this.m_Camera2Wrapper;
        if (camera2Wrapper != null) {
            camera2Wrapper.closeCamera2();
            this.m_Camera2Wrapper = null;
        }
        HFPStatus hFPStatus = this.m_HFPStatus;
        if (hFPStatus != null) {
            hFPStatus.b();
            this.m_HFPStatus = null;
        }
        FmodAndroidAudioManager fmodAndroidAudioManager = this.m_FmodAndroidAudioManager;
        if (fmodAndroidAudioManager != null) {
            fmodAndroidAudioManager.setActivity(null);
        }
        com.unity3d.player.a.v vVar = this.m_NetworkConnectivity;
        if (vVar != null) {
            vVar.a();
            this.m_NetworkConnectivity = null;
        }
        com.unity3d.player.a.x xVar = this.m_OnBackPressedDispatcher;
        if (xVar != null) {
            xVar.unregisterOnBackPressedCallback();
            this.m_OnBackPressedDispatcher = null;
        }
        this.mQuitting = true;
        if (!this.mState.c) {
            setupUnityToBePaused();
        }
        cleanupResourcesForDestroy();
        unloadNative();
    }

    protected void kill() {
        com.unity3d.player.a.t.Log(4, "Quitting process");
        Process.killProcess(Process.myPid());
    }

    public void onStop() {
        if (MultiWindowSupport.isInMultiWindowMode(this.mActivity)) {
            setupUnityToBePaused();
        }
    }

    public void onStart() {
        if (MultiWindowSupport.isInMultiWindowMode(this.mActivity)) {
            setupUnityToBeResumed();
        }
    }

    public void onPause() {
        MultiWindowSupport.saveMultiWindowMode(this.mActivity);
        if (MultiWindowSupport.isInMultiWindowMode(this.mActivity)) {
            return;
        }
        setupUnityToBePaused();
    }

    public void onResume() {
        if (!MultiWindowSupport.isInMultiWindowMode(this.mActivity) || MultiWindowSupport.isMultiWindowModeChangedToTrue(this.mActivity)) {
            setupUnityToBeResumed();
        }
    }

    public void pause() {
        setupUnityToBePaused();
    }

    protected void setupUnityToBePaused() {
        GoogleARCoreApi googleARCoreApi = this.m_ARCoreApi;
        if (googleARCoreApi != null) {
            googleARCoreApi.pauseARCore();
        }
        c1 c1Var = this.mVideoPlayerProxy;
        if (c1Var != null) {
            c1Var.e.lock();
            VideoPlayer videoPlayer = c1Var.f;
            if (videoPlayer != null) {
                if (c1Var.g == 0) {
                    videoPlayer.cancelOnPrepare();
                } else if (c1Var.i) {
                    boolean isPaused = videoPlayer.isPaused();
                    c1Var.h = isPaused;
                    if (!isPaused) {
                        c1Var.f.pause();
                    }
                }
            }
            c1Var.e.unlock();
        }
        AudioVolumeHandler audioVolumeHandler = this.m_AudioVolumeHandler;
        if (audioVolumeHandler != null) {
            C3502j c3502j = audioVolumeHandler.f6463a;
            if (c3502j.c != null) {
                c3502j.f6530a.getContentResolver().unregisterContentObserver(c3502j.c);
                c3502j.c = null;
            }
            audioVolumeHandler.f6463a = null;
            this.m_AudioVolumeHandler = null;
        }
        OrientationLockListener orientationLockListener = this.m_OrientationLockListener;
        if (orientationLockListener != null) {
            com.unity3d.player.a.M m = orientationLockListener.f6485a;
            if (m.b != null) {
                m.f6519a.getContentResolver().unregisterContentObserver(m.b);
                m.b = null;
            }
            orientationLockListener.f6485a = null;
            this.m_OrientationLockListener = null;
        }
        com.unity3d.player.a.x xVar = this.m_OnBackPressedDispatcher;
        if (xVar != null) {
            xVar.c = xVar.f6539a != null;
            xVar.unregisterOnBackPressedCallback();
        }
        if (canPauseUnity()) {
            pauseUnity();
        }
    }

    protected boolean canPauseUnity() {
        com.unity3d.player.a.S s = this.mState;
        return s.b || !s.c;
    }

    void pauseUnity() {
        com.unity3d.player.a.S s = this.mState;
        s.b = false;
        s.c = true;
    }

    protected boolean canResumeUnity() {
        Activity activity = this.mActivity;
        boolean isInMultiWindowMode = activity != null ? MultiWindowSupport.isInMultiWindowMode(activity) : false;
        com.unity3d.player.a.S s = this.mState;
        if (!com.unity3d.player.a.S.e) {
            s.getClass();
        } else if ((isInMultiWindowMode || s.f6524a) && !s.c && !s.b) {
            return true;
        }
        return false;
    }

    void resumeUnity() {
        this.mState.b = true;
    }

    public void resume() {
        setupUnityToBeResumed();
    }

    protected void setupUnityToBeResumed() {
        GoogleARCoreApi googleARCoreApi = this.m_ARCoreApi;
        if (googleARCoreApi != null) {
            googleARCoreApi.resumeARCore();
        }
        this.mState.c = false;
        c1 c1Var = this.mVideoPlayerProxy;
        if (c1Var != null) {
            c1Var.e.lock();
            VideoPlayer videoPlayer = c1Var.f;
            if (videoPlayer != null && c1Var.i && !c1Var.h) {
                videoPlayer.start();
            }
            c1Var.e.unlock();
        }
        if (canResumeUnity()) {
            resumeUnity();
        }
        if (this.m_AudioVolumeHandler == null) {
            this.m_AudioVolumeHandler = new AudioVolumeHandler(this.mContext);
        }
        if (this.m_OrientationLockListener == null && com.unity3d.player.a.S.e) {
            this.m_OrientationLockListener = new OrientationLockListener(this.mContext);
        }
        com.unity3d.player.a.x xVar = this.m_OnBackPressedDispatcher;
        if (xVar == null || !xVar.c) {
            return;
        }
        xVar.registerOnBackPressedCallback();
    }

    void shutdown() {
        this.mState.d = false;
    }

    public void unload() {
        nativeApplicationUnload();
    }

    protected boolean skipPermissionsDialog() {
        Activity activity = this.mActivity;
        if (activity != null) {
            return UnityPermissions.skipPermissionsDialog(activity);
        }
        return false;
    }

    private void requestUserAuthorization(String str, long j) {
        Activity activity;
        if (str == null || str.isEmpty() || (activity = this.mActivity) == null) {
            return;
        }
        UnityPermissions.requestUserPermissions(activity, new String[]{str}, j != 0 ? new C3539o0(j, this) : null);
    }

    public synchronized void addPermissionRequest(PermissionRequest permissionRequest) {
        Integer valueOf;
        if (this.m_PermissionRequests == null) {
            this.m_PermissionRequests = new HashMap();
        }
        int i = 1;
        while (true) {
            valueOf = Integer.valueOf(i);
            if (!this.m_PermissionRequests.containsKey(valueOf)) {
                break;
            } else {
                i++;
            }
        }
        this.m_PermissionRequests.put(valueOf, permissionRequest);
        if (this.m_PermissionRequests.size() == 1) {
            requestPermissionsFromActivity(permissionRequest.getPermissionNames(), i);
        }
    }

    public void requestPermissionsFromActivity(String[] strArr, int i) {
        this.mActivity.requestPermissions(strArr, i);
    }

    public synchronized void triggerNextPermissionRequest() {
        Iterator it;
        HashMap hashMap = this.m_PermissionRequests;
        if (hashMap == null || (it = hashMap.entrySet().iterator()) == null || !it.hasNext()) {
            return;
        }
        Map.Entry entry = (Map.Entry) it.next();
        requestPermissionsFromActivity(((PermissionRequest) entry.getValue()).getPermissionNames(), ((Integer) entry.getKey()).intValue());
    }

    public synchronized void permissionResponse(Activity activity, int i, String[] strArr, int[] iArr) {
        int i2;
        if (this.m_PermissionRequests != null) {
            Integer valueOf = Integer.valueOf(i);
            PermissionRequest permissionRequest = (PermissionRequest) this.m_PermissionRequests.get(valueOf);
            if (permissionRequest != null) {
                this.m_PermissionRequests.remove(valueOf);
                String[] permissionNames = permissionRequest.getPermissionNames();
                int[] iArr2 = new int[permissionNames.length];
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    String str = strArr[i3];
                    int i4 = 0;
                    while (true) {
                        if (i4 >= permissionNames.length) {
                            i4 = -1;
                            break;
                        } else if (str.equals(permissionNames[i4])) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (i4 < 0) {
                        com.unity3d.player.a.t.Log(6, "Permission not found in request: " + str);
                    } else {
                        if (iArr[i3] == 0) {
                            i2 = 1;
                        } else {
                            if (Build.VERSION.SDK_INT < 30 && !UnityPermissions.shouldShowRequestPermissionRationale(activity, str)) {
                                i2 = 3;
                            }
                            i2 = 2;
                        }
                        iArr2[i4] = i2;
                    }
                }
                invokeOnMainThread(new RunnableC3523g0(permissionRequest, permissionNames, iArr2));
                triggerNextPermissionRequest();
            }
        }
    }

    protected int getNetworkConnectivity() {
        com.unity3d.player.a.v vVar = this.m_NetworkConnectivity;
        if (vVar != null) {
            return vVar.b;
        }
        com.unity3d.player.a.v vVar2 = new com.unity3d.player.a.v(this.mContext);
        this.m_NetworkConnectivity = vVar2;
        return vVar2.b;
    }

    protected void setAccessibilityDelegate(UnityAccessibilityDelegate unityAccessibilityDelegate) {
        this.m_AccessibilityDelegate = unityAccessibilityDelegate;
    }

    public void configurationChanged(Configuration configuration) {
        int diff = this.prevConfig.diff(configuration);
        if ((diff & 256) != 0 || (diff & 1024) != 0 || (diff & 2048) != 0 || (diff & 128) != 0) {
            nativeHidePreservedContent();
        }
        this.prevConfig = new Configuration(configuration);
        c1 c1Var = this.mVideoPlayerProxy;
        if (c1Var != null) {
            c1Var.e.lock();
            VideoPlayer videoPlayer = c1Var.f;
            if (videoPlayer != null) {
                videoPlayer.updateVideoLayout();
            }
            c1Var.e.unlock();
        }
        UnityAccessibilityDelegate unityAccessibilityDelegate = this.m_AccessibilityDelegate;
        if (unityAccessibilityDelegate != null) {
            unityAccessibilityDelegate.a(configuration);
        }
    }

    public void windowFocusChanged(boolean z) {
        saveFocusState(z);
        if (handleFocus(z) && canResumeUnity()) {
            resumeUnity();
        }
    }

    protected void saveFocusState(boolean z) {
        this.mState.f6524a = z;
    }

    protected boolean loadLibrary(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (Exception | UnsatisfiedLinkError unused) {
            return false;
        }
    }

    protected void addPhoneCallListener() {
        this.m_AddPhoneCallListener = true;
        this.m_TelephonyManager.listen(this.m_PhoneCallListener, 32);
    }

    static {
        com.unity3d.player.a.Q q = new com.unity3d.player.a.Q();
        synchronized (q) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler == q) {
                return;
            }
            q.f6523a = defaultUncaughtExceptionHandler;
            q.b = "Unknown";
            Thread.setDefaultUncaughtExceptionHandler(q);
        }
    }

    private static String logLoadLibMainError(String str, String str2) {
        String str3 = "Failed to load 'libmain.so'\n\n" + str2;
        com.unity3d.player.a.t.Log(6, str3);
        return str3;
    }

    private static void preloadJavaPlugins() {
        try {
            Class.forName("com.unity3d.JavaPluginPreloader");
        } catch (ClassNotFoundException unused) {
        } catch (LinkageError e) {
            com.unity3d.player.a.t.Log(6, "Java class preloading failed: " + e.getMessage());
        }
    }

    private static String loadNative(String str) {
        String str2 = str + "/libmain.so";
        try {
            try {
                try {
                    System.load(str2);
                } catch (SecurityException e) {
                    return logLoadLibMainError(str2, e.toString());
                }
            } catch (UnsatisfiedLinkError e2) {
                return logLoadLibMainError(str2, e2.toString());
            }
        } catch (UnsatisfiedLinkError unused) {
            System.loadLibrary(C3040d4.h.Z);
        }
        if (NativeLoader.load(str)) {
            com.unity3d.player.a.S.e = true;
            return "";
        }
        com.unity3d.player.a.t.Log(6, "NativeLoader.load failure, Unity libraries were not loaded.");
        return "NativeLoader.load failure, Unity libraries were not loaded.";
    }

    private static String getUnityNativeLibraryPath(Context context) {
        return context.getApplicationInfo().nativeLibraryDir;
    }

    protected void setClipboardText(String str) {
        this.m_ClipboardManager.setPrimaryClip(ClipData.newPlainText("Text", str));
    }

    protected String getClipboardText() {
        ClipData primaryClip = this.m_ClipboardManager.getPrimaryClip();
        return primaryClip != null ? primaryClip.getItemAt(0).coerceToText(this.mContext).toString() : "";
    }

    protected String getLaunchURL() {
        Uri data;
        Activity activity = this.mActivity;
        if (activity == null || (data = activity.getIntent().getData()) == null) {
            return null;
        }
        return data.toString();
    }

    void setLaunchURL(Uri uri) {
        invokeOnMainThread(new RunnableC3525h0(uri != null ? uri.toString() : null));
    }

    protected boolean initializeGoogleAr() {
        if (this.m_ARCoreApi != null || this.mActivity == null || !getARCoreEnabled()) {
            return false;
        }
        GoogleARCoreApi googleARCoreApi = new GoogleARCoreApi();
        this.m_ARCoreApi = googleARCoreApi;
        googleARCoreApi.initializeARCore(this.mActivity);
        if (this.mState.c) {
            return false;
        }
        this.m_ARCoreApi.resumeARCore();
        return false;
    }

    protected boolean showVideoPlayer(String str, int i, int i2, int i3, boolean z, int i4, int i5) {
        if (this.mVideoPlayerProxy == null) {
            this.mVideoPlayerProxy = new c1(this);
        }
        c1 c1Var = this.mVideoPlayerProxy;
        Context context = this.mContext;
        C3527i0 c3527i0 = new C3527i0(this);
        c1Var.e.lock();
        c1Var.c = c3527i0;
        c1Var.b = context;
        c1Var.d.drainPermits();
        c1Var.g = 2;
        c1Var.runOnUiThread(new Y0(c1Var, str, i, i2, i3, z, i4, i5));
        boolean z2 = false;
        try {
            c1Var.e.unlock();
            c1Var.d.acquire();
            c1Var.e.lock();
            if (c1Var.g != 2) {
                z2 = true;
            }
        } catch (InterruptedException unused) {
        }
        c1Var.runOnUiThread(new Z0(c1Var));
        if (z2 && c1Var.g != 3) {
            c1Var.runOnUiThread(new a1(c1Var));
        } else {
            c1Var.runOnUiThread(new b1(c1Var));
        }
        c1Var.e.unlock();
        if (z2) {
            runOnUiThread(new RunnableC3529j0(this));
        }
        return z2;
    }

    protected boolean isUaaLUseCase() {
        String callingPackage;
        Activity activity = this.mActivity;
        return (activity == null || (callingPackage = activity.getCallingPackage()) == null || !callingPackage.equals(this.mContext.getPackageName())) ? false : true;
    }

    protected int getUaaLLaunchProcessType() {
        String processName = getProcessName();
        return (processName == null || processName.equals(this.mContext.getPackageName())) ? 0 : 1;
    }

    private String getProcessName() {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    ApplicationInfo getApplicationInfo() {
        return this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128);
    }

    private ActivityInfo getActivityInfo() {
        return this.mActivity.getPackageManager().getActivityInfo(this.mActivity.getComponentName(), 128);
    }

    boolean getSplashEnabled() {
        try {
            return getApplicationInfo().metaData.getBoolean(SPLASH_ENABLE_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean getARCoreEnabled() {
        try {
            return getApplicationInfo().metaData.getBoolean(ARCORE_ENABLE_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean getLaunchFullscreen() {
        try {
            return getApplicationInfo().metaData.getBoolean(LAUNCH_FULLSCREEN);
        } catch (Exception unused) {
            return false;
        }
    }

    protected int getSplashMode() {
        try {
            return getApplicationInfo().metaData.getInt(SPLASH_MODE_METADATA_NAME);
        } catch (Exception unused) {
            return 0;
        }
    }

    boolean getAutoSetGameStateEnabled() {
        try {
            return getApplicationInfo().metaData.getBoolean(AUTO_SET_GAME_STATE_ENABLE_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    boolean shouldSetGameState() {
        return (!PlatformSupport.TIRAMISU_SUPPORT || this.mActivity == null || isUaaLUseCase() || !getAutoSetGameStateEnabled() || UnityGameManager.getGameManager(currentContext) == null) ? false : true;
    }

    boolean getAutoReportFullyDrawnEnabled() {
        try {
            return getApplicationInfo().metaData.getBoolean(AUTO_REPORT_FULLY_DRAWN_ENABLE_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    boolean shouldReportFullyDrawn() {
        if (this.mActivity == null) {
            return false;
        }
        return getAutoReportFullyDrawnEnabled();
    }

    void reportFullyDrawn() {
        this.mActivity.reportFullyDrawn();
    }

    protected void disableLogger() {
        com.unity3d.player.a.t.f6535a = true;
    }

    protected boolean isFinishing() {
        if (this.mQuitting) {
            return true;
        }
        Activity activity = this.mActivity;
        if (activity != null) {
            this.mQuitting = activity.isFinishing();
        }
        return this.mQuitting;
    }

    private void hideStatusBar() {
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.getWindow().setFlags(1024, 1024);
        }
    }

    public boolean injectEvent(InputEvent inputEvent) {
        return injectEvent(inputEvent, 0);
    }

    private void swapViews(View view, View view2) {
        boolean z;
        ViewParent parent;
        if (this.mState.c) {
            z = false;
        } else {
            setupUnityToBePaused();
            z = true;
        }
        FrameLayout frameLayout = getFrameLayout();
        if (frameLayout != null) {
            if (view != null && (parent = view.getParent()) != frameLayout) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                frameLayout.addView(view);
                frameLayout.bringChildToFront(view);
                view.setVisibility(0);
            }
            if (view2 != null && view2.getParent() == frameLayout) {
                view2.setVisibility(8);
                frameLayout.removeView(view2);
            }
        }
        if (z) {
            setupUnityToBeResumed();
        }
    }

    public boolean addViewToPlayer(View view, boolean z) {
        FrameLayout frameLayout = getFrameLayout();
        boolean z2 = false;
        if (frameLayout == null) {
            return false;
        }
        View view2 = getView();
        swapViews(view, z ? view2 : null);
        boolean z3 = view.getParent() == frameLayout;
        boolean z4 = z && view2.getParent() == null;
        boolean z5 = view2.getParent() == frameLayout;
        if (z3 && (z4 || z5)) {
            z2 = true;
        }
        if (!z2) {
            if (!z3) {
                com.unity3d.player.a.t.Log(6, "addViewToPlayer: Failure adding view to hierarchy");
            }
            if (!z4 && !z5) {
                com.unity3d.player.a.t.Log(6, "addViewToPlayer: Failure removing old view from hierarchy");
            }
        }
        return z2;
    }

    public void removeViewFromPlayer(View view) {
        FrameLayout frameLayout = getFrameLayout();
        if (frameLayout == null) {
            return;
        }
        View view2 = getView();
        swapViews(view2, view);
        boolean z = view.getParent() == null;
        boolean z2 = view2.getParent() == frameLayout;
        if (z && z2) {
            return;
        }
        if (!z) {
            com.unity3d.player.a.t.Log(6, "removeViewFromPlayer: Failure removing view from hierarchy");
        }
        if (z2) {
            return;
        }
        com.unity3d.player.a.t.Log(6, "removeViewFromPlayer: Failure adding old view to hierarchy");
    }

    public void reportError(String str, String str2) {
        com.unity3d.player.a.t.Log(6, str + ": " + str2);
    }

    public String getNetworkProxySettings(String str) {
        String str2;
        String str3;
        if (str.startsWith("http:")) {
            str2 = "http.proxyHost";
            str3 = "http.proxyPort";
        } else {
            if (str.startsWith("https:")) {
                str2 = "https.proxyHost";
                str3 = "https.proxyPort";
            }
            return null;
        }
        String property = System.getProperties().getProperty(str2);
        if (property != null && !"".equals(property)) {
            StringBuilder sb = new StringBuilder(property);
            String property2 = System.getProperties().getProperty(str3);
            if (property2 != null && !"".equals(property2)) {
                sb.append(":").append(property2);
            }
            String property3 = System.getProperties().getProperty("http.nonProxyHosts");
            if (property3 != null && !"".equals(property3)) {
                sb.append('\n').append(property3);
            }
            return sb.toString();
        }
        return null;
    }

    public boolean startOrientationListener(int i) {
        if (this.mOrientationListener != null) {
            com.unity3d.player.a.t.Log(5, "Orientation Listener already started.");
            return false;
        }
        C3531k0 c3531k0 = new C3531k0(this, this.mContext, i);
        this.mOrientationListener = c3531k0;
        if (c3531k0.canDetectOrientation()) {
            this.mOrientationListener.enable();
            return true;
        }
        com.unity3d.player.a.t.Log(5, "Orientation Listener cannot detect orientation.");
        return false;
    }

    public boolean stopOrientationListener() {
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener == null) {
            com.unity3d.player.a.t.Log(5, "Orientation Listener was not started.");
            return false;
        }
        orientationEventListener.disable();
        this.mOrientationListener = null;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeOnMainThread(b bVar) {
        if (isFinishing()) {
            return;
        }
        invokeOnMainThread((Runnable) bVar);
    }

    protected void executeMainThreadJobs() {
        while (true) {
            Runnable runnable = (Runnable) this.m_MainThreadJobs.poll();
            if (runnable == null) {
                return;
            } else {
                runnable.run();
            }
        }
    }

    protected String getKeyboardLayout() {
        InputMethodSubtype currentInputMethodSubtype = ((InputMethodManager) this.mContext.getSystemService("input_method")).getCurrentInputMethodSubtype();
        if (currentInputMethodSubtype == null) {
            return null;
        }
        String a2 = AbstractC3510s.a(currentInputMethodSubtype);
        if (a2 != null && !a2.equals("")) {
            return a2;
        }
        return currentInputMethodSubtype.getMode() + " " + currentInputMethodSubtype.getExtraValue();
    }

    private boolean runningOnUIThread() {
        return Thread.currentThread() == this.m_UIThread;
    }

    public FrameLayout getFrameLayout() {
        return this.m_FrameLayout;
    }

    String getState() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mState.toString() + "\n");
        sb.append(String.format("m_AudioVolumeHandler = %b", this.m_AudioVolumeHandler).concat("\n"));
        sb.append(String.format("m_OrientationLockListener = %b", this.m_OrientationLockListener).concat("\n"));
        return sb.toString();
    }

    private void requestPointerCapture() {
        com.unity3d.player.a.P p = this.m_Cursor;
        p.getClass();
        if (PlatformSupport.OREO_SUPPORT) {
            p.f6522a.runOnUiThread(new com.unity3d.player.a.N(p));
        }
    }

    private void releasePointerCapture() {
        com.unity3d.player.a.P p = this.m_Cursor;
        p.getClass();
        if (PlatformSupport.OREO_SUPPORT) {
            p.f6522a.runOnUiThread(new com.unity3d.player.a.O(p));
        }
    }

    private void setBackButtonLeavesApp(boolean z) {
        com.unity3d.player.a.x xVar = this.m_OnBackPressedDispatcher;
        if (xVar != null) {
            if (!z) {
                xVar.registerOnBackPressedCallback();
            } else {
                xVar.unregisterOnBackPressedCallback();
            }
        }
    }

    private void setScreenBrightness(float f) {
        float max = Math.max(0.04f, f);
        if (this.m_Window == null || getScreenBrightness() == max) {
            return;
        }
        runOnUiThread(new RunnableC3533l0(this, max));
    }

    private float getScreenBrightness() {
        Window window = this.m_Window;
        if (window == null) {
            return 1.0f;
        }
        float f = window.getAttributes().screenBrightness;
        if (f >= 0.0f) {
            return f;
        }
        int i = Settings.System.getInt(getContext().getContentResolver(), "screen_brightness", 255);
        return PlatformSupport.PIE_SUPPORT ? (float) Math.max(0.0d, Math.min(1.0d, ((Math.log(i) * 19.811d) - 9.411d) / 100.0d)) : i / 255.0f;
    }

    private void pauseJavaAndCallUnloadCallback() {
        runOnUiThread(new Y(this));
    }

    View getViewForPadding() {
        return getFrameLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchFrameLayoutPadding() {
        View viewForPadding = getViewForPadding();
        if (!com.unity3d.player.a.S.e || viewForPadding == null) {
            return;
        }
        nativeViewPaddingChanged(0, viewForPadding.getPaddingLeft(), viewForPadding.getPaddingTop(), viewForPadding.getPaddingRight(), viewForPadding.getPaddingBottom());
    }

    private void applyWindowUIChanges(boolean z) {
        Activity activity = this.mActivity;
        if (activity == null || activity.getWindow() == null) {
            return;
        }
        runOnUiThread(new Z(this, z));
    }

    private void applyWindowInsets() {
        Activity activity = this.mActivity;
        if (activity == null || activity.getWindow() == null) {
            return;
        }
        runOnUiThread(new RunnableC3511a0(this));
    }

    private void startActivityIndicator(int i) {
        postOnUiThread(new RunnableC3513b0(this, i));
    }

    private void stopActivityIndicator() {
        postOnUiThread(new RunnableC3515c0());
    }
}
