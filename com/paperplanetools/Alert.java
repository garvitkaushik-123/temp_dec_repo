package com.paperplanetools;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.unity3d.player.UnityPlayer;

/* loaded from: classes6.dex */
public class Alert {
    private static final String BUTTON_CALLBACK = "AlertAndroid_OnButtonClick";
    private static final String CANCEL_CALLBACK = "AlertAndroid_OnCancel";
    private static final String DISMISS_CALLBACK = "AlertAndroid_OnDismiss";
    private static final int RESULT_ALREADY_EXISTS = 1;
    private static final int RESULT_ERROR = 3;
    private static final int RESULT_NOT_EXISTS = 2;
    private static final int RESULT_SUCCESS = 0;
    private static AlertBuilder alertBuilder;
    private static AlertDialog alertDialog;
    private static String unityGameObjectName;

    public static int initBuilder(String str) {
        if (alertBuilder != null) {
            return 1;
        }
        unityGameObjectName = str;
        alertBuilder = new AlertBuilder();
        return 0;
    }

    public static int setCancelable(boolean z) {
        AlertBuilder alertBuilder2 = alertBuilder;
        if (alertBuilder2 == null) {
            return 2;
        }
        alertBuilder2.cancelable = z;
        return 0;
    }

    public static int setTitle(String str) {
        AlertBuilder alertBuilder2 = alertBuilder;
        if (alertBuilder2 == null) {
            return 2;
        }
        alertBuilder2.title = str;
        return 0;
    }

    public static int setMessage(String str) {
        AlertBuilder alertBuilder2 = alertBuilder;
        if (alertBuilder2 == null) {
            return 2;
        }
        alertBuilder2.message = str;
        return 0;
    }

    public static int setButton(int i, String str) {
        AlertBuilder alertBuilder2 = alertBuilder;
        if (alertBuilder2 == null) {
            return 2;
        }
        alertBuilder2.buttons.put(Integer.valueOf(i), str);
        return 0;
    }

    public static int show() {
        if (alertBuilder == null) {
            return 2;
        }
        final Activity activity = UnityPlayer.currentActivity;
        activity.runOnUiThread(new Runnable() { // from class: com.paperplanetools.Alert.1
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog unused = Alert.alertDialog = Alert.alertBuilder.create(activity, Alert.unityGameObjectName, Alert.BUTTON_CALLBACK);
                Alert.alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.paperplanetools.Alert.1.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        UnityPlayer.UnitySendMessage(Alert.unityGameObjectName, Alert.CANCEL_CALLBACK, "");
                    }
                });
                Alert.alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.paperplanetools.Alert.1.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        AlertBuilder unused2 = Alert.alertBuilder = null;
                        AlertDialog unused3 = Alert.alertDialog = null;
                        UnityPlayer.UnitySendMessage(Alert.unityGameObjectName, Alert.DISMISS_CALLBACK, "");
                    }
                });
                Alert.alertDialog.show();
            }
        });
        return 0;
    }

    public static int dismiss() {
        if (alertBuilder == null) {
            return 2;
        }
        if (alertDialog != null) {
            UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: com.paperplanetools.Alert.2
                @Override // java.lang.Runnable
                public void run() {
                    Alert.alertDialog.dismiss();
                }
            });
            return 0;
        }
        alertBuilder = null;
        return 0;
    }
}
