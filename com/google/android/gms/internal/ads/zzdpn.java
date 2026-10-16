package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdpn {
    private Context zza;
    private PopupWindow zzb;

    /* JADX WARN: Removed duplicated region for block: B:18:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(Context context, View view) {
        PopupWindow popupWindow;
        if (!PlatformVersion.isAtLeastKitKat() || PlatformVersion.isAtLeastLollipop()) {
            return;
        }
        Window window = context instanceof Activity ? ((Activity) context).getWindow() : null;
        if (window != null && window.getDecorView() != null && !((Activity) context).isDestroyed()) {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.addView(view, -1, -1);
            popupWindow = new PopupWindow((View) frameLayout, 1, 1, false);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setClippingEnabled(false);
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Displaying the 1x1 popup off the screen.");
            try {
                popupWindow.showAtLocation(window.getDecorView(), 0, -1, -1);
            } catch (Exception unused) {
            }
            this.zzb = popupWindow;
            if (popupWindow == null) {
                context = null;
            }
            this.zza = context;
        }
        popupWindow = null;
        this.zzb = popupWindow;
        if (popupWindow == null) {
        }
        this.zza = context;
    }

    public final void zzb() {
        PopupWindow popupWindow;
        Context context = this.zza;
        if (context == null || this.zzb == null) {
            return;
        }
        if ((!(context instanceof Activity) || !((Activity) context).isDestroyed()) && (popupWindow = this.zzb) != null && popupWindow.isShowing()) {
            this.zzb.dismiss();
        }
        this.zza = null;
        this.zzb = null;
    }
}
