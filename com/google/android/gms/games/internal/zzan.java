package com.google.android.gms.games.internal;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.games_v2.zzfn;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes4.dex */
public final class zzan implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, zzc {
    private final zzah zza;
    private final com.google.android.gms.internal.games_v2.zzae zzb;
    private WeakReference zzc;
    private boolean zzd = false;

    private zzan(zzah zzahVar, int i) {
        this.zza = zzahVar;
        this.zzb = new com.google.android.gms.internal.games_v2.zzae(i, null);
    }

    public static zzan zzb(zzah zzahVar, int i) {
        return new zzan(zzahVar, i);
    }

    private final void zzh(View view) {
        Display display;
        int i = -1;
        if (PlatformVersion.isAtLeastJellyBeanMR1() && (display = view.getDisplay()) != null) {
            i = display.getDisplayId();
        }
        IBinder windowToken = view.getWindowToken();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int width = view.getWidth();
        int height = view.getHeight();
        com.google.android.gms.internal.games_v2.zzae zzaeVar = this.zzb;
        zzaeVar.zzc = i;
        zzaeVar.zza = windowToken;
        int i2 = iArr[0];
        zzaeVar.zzd = i2;
        int i3 = iArr[1];
        zzaeVar.zze = i3;
        zzaeVar.zzf = i2 + width;
        zzaeVar.zzg = i3 + height;
        if (this.zzd) {
            zzg();
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View view;
        WeakReference weakReference = this.zzc;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        zzh(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        zzh(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zza.zzQ();
        view.removeOnAttachStateChangeListener(this);
    }

    @Override // com.google.android.gms.games.internal.zzc
    public final void zza(Activity activity) {
        View view;
        try {
            view = activity.findViewById(R.id.content);
        } catch (IllegalStateException unused) {
            view = null;
        }
        if (view == null && (view = activity.getWindow().getDecorView()) == null) {
            String valueOf = String.valueOf(activity);
            String.valueOf(valueOf);
            zzfn.zze("PopupManager", "Failed to bind to: ".concat(String.valueOf(valueOf)));
        } else {
            String valueOf2 = String.valueOf(activity);
            String.valueOf(valueOf2);
            zzfn.zzc("PopupManager", "Binding to: ".concat(String.valueOf(valueOf2)));
            zzf(view);
        }
    }

    public final Bundle zzc() {
        return this.zzb.zza();
    }

    public final IBinder zzd() {
        return this.zzb.zza;
    }

    public final com.google.android.gms.internal.games_v2.zzae zze() {
        return this.zzb;
    }

    public final void zzf(View view) {
        zzah zzahVar = this.zza;
        zzahVar.zzQ();
        WeakReference weakReference = this.zzc;
        if (weakReference != null) {
            View view2 = (View) weakReference.get();
            Context context = zzahVar.getContext();
            if (view2 == null && (context instanceof Activity)) {
                view2 = ((Activity) context).getWindow().getDecorView();
            }
            if (view2 != null) {
                view2.removeOnAttachStateChangeListener(this);
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                if (PlatformVersion.isAtLeastJellyBean()) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
            }
        }
        this.zzc = null;
        Context context2 = zzahVar.getContext();
        if (view == null && (context2 instanceof Activity)) {
            Activity activity = (Activity) context2;
            try {
                view = activity.findViewById(R.id.content);
            } catch (IllegalStateException unused) {
            }
            if (view == null) {
                view = activity.getWindow().getDecorView();
            }
            zzfn.zze("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
        }
        if (view == null) {
            zzfn.zzg("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
            return;
        }
        zzh(view);
        this.zzc = new WeakReference(view);
        view.addOnAttachStateChangeListener(this);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public final void zzg() {
        boolean z;
        com.google.android.gms.internal.games_v2.zzae zzaeVar = this.zzb;
        IBinder iBinder = zzaeVar.zza;
        if (iBinder != null) {
            this.zza.zzP(iBinder, zzaeVar.zza());
            z = false;
        } else {
            z = true;
        }
        this.zzd = z;
    }
}
