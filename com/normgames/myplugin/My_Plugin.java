package com.normgames.myplugin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.unity3d.player.UnityPlayer;

/* loaded from: classes6.dex */
public class My_Plugin {
    private static final String BUTTON_CALLBACK = "AndroidAlert_OnButtonClick";
    private static final String CANCEL_CALLBACK = "AndroidAlert_OnCancel";
    private static final String DISMISS_CALLBACK = "AndroidAlert_OnDismiss";
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
        activity.runOnUiThread(new Runnable() { // from class: com.normgames.myplugin.My_Plugin.1
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog unused = My_Plugin.alertDialog = My_Plugin.alertBuilder.create(activity, My_Plugin.unityGameObjectName, My_Plugin.BUTTON_CALLBACK);
                My_Plugin.alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.normgames.myplugin.My_Plugin.1.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        UnityPlayer.UnitySendMessage(My_Plugin.unityGameObjectName, My_Plugin.CANCEL_CALLBACK, "");
                    }
                });
                My_Plugin.alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.normgames.myplugin.My_Plugin.1.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        AlertBuilder unused2 = My_Plugin.alertBuilder = null;
                        AlertDialog unused3 = My_Plugin.alertDialog = null;
                        UnityPlayer.UnitySendMessage(My_Plugin.unityGameObjectName, My_Plugin.DISMISS_CALLBACK, "");
                    }
                });
                My_Plugin.alertDialog.show();
            }
        });
        return 0;
    }

    public static int dismiss() {
        if (alertBuilder == null) {
            return 2;
        }
        if (alertDialog != null) {
            UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: com.normgames.myplugin.My_Plugin.2
                @Override // java.lang.Runnable
                public void run() {
                    My_Plugin.alertDialog.dismiss();
                }
            });
            return 0;
        }
        alertBuilder = null;
        return 0;
    }
}
