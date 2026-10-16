package io.voodoo.appupdate;

import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.player.UnityPlayer;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class AppUpdatePlugin {
    static void getAppUpdateInfo(final AppUpdateCallback appUpdateCallback) {
        try {
            Task appUpdateInfo = AppUpdateManagerFactory.create(UnityPlayer.currentActivity.getApplicationContext()).getAppUpdateInfo();
            appUpdateInfo.addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>() { // from class: io.voodoo.appupdate.AppUpdatePlugin.1
                public void onSuccess(AppUpdateInfo appUpdateInfo2) {
                    AppUpdateCallback appUpdateCallback2 = AppUpdateCallback.this;
                    if (appUpdateCallback2 != null) {
                        appUpdateCallback2.onSuccess(AppUpdatePlugin.resultToJson(appUpdateInfo2));
                    }
                }
            });
            appUpdateInfo.addOnFailureListener(new OnFailureListener() { // from class: io.voodoo.appupdate.AppUpdatePlugin.2
                public void onFailure(Exception exc) {
                    AppUpdateCallback appUpdateCallback2 = AppUpdateCallback.this;
                    if (appUpdateCallback2 != null) {
                        appUpdateCallback2.onFailure(exc.getMessage());
                    }
                }
            });
        } catch (Exception e) {
            if (appUpdateCallback != null) {
                appUpdateCallback.onFailure(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String resultToJson(AppUpdateInfo appUpdateInfo) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.accumulate("availableVersionCode", Integer.valueOf(appUpdateInfo.availableVersionCode()));
            jSONObject.accumulate(HandleInvocationsFromAdViewer.KEY_PACKAGE_NAME, appUpdateInfo.packageName());
            jSONObject.accumulate("updateAvailability", Integer.valueOf(appUpdateInfo.updateAvailability()));
            jSONObject.accumulate("updatePriority", Integer.valueOf(appUpdateInfo.updatePriority()));
            jSONObject.accumulate("isUpdateTypeAllowed", Boolean.valueOf(appUpdateInfo.isUpdateTypeAllowed(1)));
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
