package com.normgames.myplugin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.unity3d.player.UnityPlayer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class AlertBuilder {
    public String title = null;
    public String message = null;
    public boolean cancelable = true;
    public HashMap<Integer, String> buttons = new HashMap<>();

    public AlertDialog create(Activity activity, final String str, final String str2) {
        AlertDialog create = new AlertDialog.Builder(activity).create();
        String str3 = this.title;
        if (str3 != null) {
            create.setTitle(str3);
        }
        String str4 = this.message;
        if (str4 != null) {
            create.setMessage(str4);
        }
        create.setCancelable(this.cancelable);
        for (Map.Entry<Integer, String> entry : this.buttons.entrySet()) {
            create.setButton(entry.getKey().intValue(), entry.getValue(), new DialogInterface.OnClickListener() { // from class: com.normgames.myplugin.AlertBuilder.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    UnityPlayer.UnitySendMessage(str, str2, Integer.toString(i));
                }
            });
        }
        return create;
    }
}
