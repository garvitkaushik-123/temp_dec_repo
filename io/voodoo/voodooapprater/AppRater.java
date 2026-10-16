package io.voodoo.voodooapprater;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import com.unity3d.player.UnityPlayer;

/* loaded from: classes8.dex */
public class AppRater {
    private static String TAG = "VoodooAppRater";

    public static void Show(Context context, Activity activity, String str, String str2, String str3, String str4) {
        String packageName = context.getPackageName();
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.VoodooRatingDialog);
        builder.setTitle(str);
        builder.setCancelable(false);
        try {
            builder.setIcon(context.getPackageManager().getApplicationIcon(packageName));
        } catch (Exception unused) {
        }
        View inflate = activity.getLayoutInflater().inflate(R.layout.rating_bar_layout, (ViewGroup) null);
        builder.setView(inflate);
        final RatingBar ratingBar = (RatingBar) inflate.findViewById(R.id.rating);
        ((TextView) inflate.findViewById(R.id.message)).setText(str2);
        builder.setPositiveButton(str3, new DialogInterface.OnClickListener() { // from class: io.voodoo.voodooapprater.AppRater.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                UnityPlayer.UnitySendMessage("VoodooAppRater", "OnPositiveButtonClick", "" + Math.round(ratingBar.getRating()));
            }
        });
        builder.setNeutralButton(str4, new DialogInterface.OnClickListener() { // from class: io.voodoo.voodooapprater.AppRater.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                UnityPlayer.UnitySendMessage("VoodooAppRater", "OnNeutralButtonClick", "");
            }
        });
        final AlertDialog create = builder.create();
        create.show();
        create.getButton(-1).setEnabled(false);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: io.voodoo.voodooapprater.AppRater.3
            @Override // android.widget.RatingBar.OnRatingBarChangeListener
            public void onRatingChanged(RatingBar ratingBar2, float f, boolean z) {
                if (f >= 1.0f) {
                    create.getButton(-1).setEnabled(true);
                } else {
                    create.getButton(-1).setEnabled(false);
                }
            }
        });
    }
}
