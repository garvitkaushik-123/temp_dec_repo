package net.kibotu.audiolistener;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.player.UnityPlayer;
import java.lang.reflect.Field;
import org.fmod.FMODAudioDevice;

/* loaded from: classes8.dex */
public class OnAudioFocusChangeListenerService extends Service implements AudioManager.OnAudioFocusChangeListener {
    public static boolean DEBUG = false;
    private static final String TAG = "OnAudioFocusChangeListenerService";
    private static AudioManager audioManager;
    private static OnAudioFocusChangeListenerService instance;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        instance = this;
        Log("Starting OnAudioFocusChangeListener as background service.");
        AudioManager audioManager2 = (AudioManager) getApplicationContext().getSystemService("audio");
        audioManager = audioManager2;
        audioManager2.requestAudioFocus(instance, 3, 1);
    }

    @Override // android.app.Service
    public void onDestroy() {
        audioManager.abandonAudioFocus(this);
    }

    public static void RegisterUnityAndroidCallbackListener() {
        Log("RegisterUnityAndroidCallbackListener");
        UnityPlayer.currentActivity.startService(new Intent(UnityPlayer.currentActivity, (Class<?>) OnAudioFocusChangeListenerService.class));
    }

    public static int UnregisterUnityAndroidCallbackListener() {
        Log("UnregisterUnityAndroidCallbackListener");
        int abandonAudioFocus = audioManager.abandonAudioFocus(instance);
        UnityPlayer.currentActivity.stopService(new Intent(UnityPlayer.currentActivity, (Class<?>) OnAudioFocusChangeListenerService.class));
        return abandonAudioFocus;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        if (DEBUG) {
            if (i == -2) {
                Log("Audio Focus AUDIOFOCUS_LOSS_TRANSIENT");
            } else if (i == -1) {
                Log("Audio Focus AUDIOFOCUS_LOSS");
            } else if (i == 1) {
                Log("Audio Focus AUDIOFOCUS_GAIN");
            } else {
                Log("Audio Focus " + i);
            }
        }
        try {
            UnityPlayer.UnitySendMessage("AndroidMusicHandler", "OnChangedState", String.valueOf(i));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isMusicActive() {
        return isMusicActive(150L);
    }

    public static boolean isMusicActive(long j) {
        stopFMOD();
        try {
            Log("sleep because fmod is running: " + getFmodAudioDevice().isRunning());
            Thread.currentThread();
            Thread.sleep(j);
            Log(CampaignEx.JSON_NATIVE_VIDEO_RESUME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log("stopped fmod running=" + getFmodAudioDevice().isRunning());
        boolean isMusicActive = ((AudioManager) UnityPlayer.currentActivity.getSystemService("audio")).isMusicActive();
        Log("isMusicActive: " + isMusicActive);
        Log("start fmod");
        getFmodAudioDevice().start();
        Log("started fmod");
        return isMusicActive;
    }

    public static void startFMOD() {
        FMODAudioDevice fmodAudioDevice = getFmodAudioDevice();
        if (fmodAudioDevice == null) {
            Log("startFMOD: fmod == null");
        } else {
            fmodAudioDevice.start();
            Log("Started FMOD. " + fmodAudioDevice.isRunning());
        }
    }

    public static void stopFMOD() {
        FMODAudioDevice fmodAudioDevice = getFmodAudioDevice();
        if (fmodAudioDevice == null) {
            Log("stopFMOD: fmod == null");
        } else {
            fmodAudioDevice.stop();
            Log("Stopped FMOD. " + fmodAudioDevice.isRunning());
        }
    }

    private static FMODAudioDevice getFmodAudioDevice() {
        if (ManualUnityActivity.unityPlayer == null) {
            Log("ManualUnityActivity.unityPlayer == null");
            return null;
        }
        try {
            Field declaredField = UnityPlayer.class.getDeclaredField("r");
            declaredField.setAccessible(true);
            return (FMODAudioDevice) declaredField.get(ManualUnityActivity.unityPlayer);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void Log(String str) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", NotificationCompat.CATEGORY_MESSAGE, "net/kibotu/audiolistener/OnAudioFocusChangeListenerService", "Log"));
        }
        if (DEBUG) {
            Log.v(TAG, str);
        }
    }
}
