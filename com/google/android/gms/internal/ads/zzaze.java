package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaze implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Application.ActivityLifecycleCallbacks {
    private static final long zzc = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbz)).longValue();
    BroadcastReceiver zza;
    final WeakReference zzb;
    private final Context zzd;
    private Application zze;
    private final WindowManager zzf;
    private final PowerManager zzg;
    private final KeyguardManager zzh;
    private WeakReference zzi;
    private zzazq zzj;
    private final com.google.android.gms.ads.internal.util.zzbx zzk = new com.google.android.gms.ads.internal.util.zzbx(zzc);
    private boolean zzl = false;
    private int zzm = -1;
    private final HashSet zzn = new HashSet();
    private final DisplayMetrics zzo;
    private final Rect zzp;

    public zzaze(Context context, View view) {
        Context applicationContext = context.getApplicationContext();
        this.zzd = applicationContext;
        WindowManager windowManager = (WindowManager) applicationContext.getSystemService("window");
        this.zzf = windowManager;
        this.zzg = (PowerManager) applicationContext.getSystemService("power");
        this.zzh = (KeyguardManager) applicationContext.getSystemService("keyguard");
        if (applicationContext instanceof Application) {
            this.zze = (Application) applicationContext;
            this.zzj = new zzazq((Application) applicationContext, this);
        }
        this.zzo = context.getResources().getDisplayMetrics();
        Rect rect = new Rect();
        this.zzp = rect;
        rect.right = windowManager.getDefaultDisplay().getWidth();
        rect.bottom = windowManager.getDefaultDisplay().getHeight();
        WeakReference weakReference = this.zzb;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzm(view2);
        }
        this.zzb = new WeakReference(view);
        if (view != null) {
            if (view.isAttachedToWindow()) {
                zzl(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final int zzh(int i) {
        return (int) (i / this.zzo.density);
    }

    private final void zzi(Activity activity, int i) {
        Window window;
        WeakReference weakReference = this.zzb;
        if (weakReference == null || (window = activity.getWindow()) == null) {
            return;
        }
        View peekDecorView = window.peekDecorView();
        View view = (View) weakReference.get();
        if (view == null || peekDecorView == null || view.getRootView() != peekDecorView.getRootView()) {
            return;
        }
        this.zzm = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0147, code lost:
    
        if (r9 == 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0131, code lost:
    
        if (r9 == 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0149, code lost:
    
        r3 = 1;
        r13 = true;
        r14 = true;
        r9 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzj(int i) {
        WeakReference weakReference;
        boolean z;
        boolean z2;
        View view;
        List emptyList;
        boolean z3;
        int i2;
        boolean z4;
        if (this.zzn.isEmpty() || (weakReference = this.zzb) == null) {
            return;
        }
        View view2 = (View) weakReference.get();
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Rect rect3 = new Rect();
        Rect rect4 = new Rect();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (view2 != null) {
            z = view2.getGlobalVisibleRect(rect2);
            z2 = view2.getLocalVisibleRect(rect3);
            view2.getHitRect(rect4);
            try {
                view2.getLocationOnScreen(iArr);
                view2.getLocationInWindow(iArr2);
            } catch (Exception e) {
                int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Failure getting view location.", e);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfr)).booleanValue()) {
                rect.left = iArr2[0];
                rect.top = iArr2[1];
            } else {
                rect.left = iArr[0];
                rect.top = iArr[1];
            }
            rect.right = rect.left + view2.getWidth();
            rect.bottom = rect.top + view2.getHeight();
            view = view2;
        } else {
            z = false;
            z2 = false;
            view = null;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbC)).booleanValue() || view == null) {
            emptyList = Collections.emptyList();
        } else {
            try {
                emptyList = new ArrayList();
                ViewParent parent = view.getParent();
                while (parent instanceof View) {
                    View view3 = (View) parent;
                    Rect rect5 = new Rect();
                    if (view3.isScrollContainer() && view3.getGlobalVisibleRect(rect5)) {
                        emptyList.add(zza(rect5));
                    }
                    parent = parent.getParent();
                }
            } catch (Exception e2) {
                com.google.android.gms.ads.internal.zzv.zzp().zzw(e2, "PositionWatcher.getParentScrollViewRects");
                emptyList = Collections.emptyList();
            }
        }
        List list = emptyList;
        int windowVisibility = view != null ? view.getWindowVisibility() : 8;
        int i4 = this.zzm;
        if (i4 != -1) {
            windowVisibility = i4;
        }
        com.google.android.gms.ads.internal.zzv.zzr();
        long zzx = com.google.android.gms.ads.internal.util.zzs.zzx(view);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkY)).booleanValue()) {
            if (view2 != null) {
                PowerManager powerManager = this.zzg;
                KeyguardManager keyguardManager = this.zzh;
                com.google.android.gms.ads.internal.zzv.zzr();
                if (com.google.android.gms.ads.internal.util.zzs.zzT(view, powerManager, keyguardManager)) {
                    if (z) {
                        if (z2) {
                            if (zzx >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlb)).intValue()) {
                            }
                            z = true;
                            z2 = true;
                        }
                        z = true;
                        z3 = 0;
                        z2 = false;
                    }
                    z3 = 0;
                    z = false;
                }
            }
            z3 = 0;
        } else {
            if (view2 != null) {
                PowerManager powerManager2 = this.zzg;
                KeyguardManager keyguardManager2 = this.zzh;
                com.google.android.gms.ads.internal.zzv.zzr();
                if (com.google.android.gms.ads.internal.util.zzs.zzT(view, powerManager2, keyguardManager2)) {
                    if (z) {
                        if (z2) {
                        }
                        z = true;
                        z3 = 0;
                        z2 = false;
                    }
                    z3 = 0;
                    z = false;
                }
            }
            z3 = 0;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzld)).booleanValue()) {
            PowerManager powerManager3 = this.zzg;
            KeyguardManager keyguardManager3 = this.zzh;
            com.google.android.gms.ads.internal.zzv.zzr();
            int i5 = true != com.google.android.gms.ads.internal.util.zzs.zzT(view, powerManager3, keyguardManager3) ? 0 : 64;
            int i6 = true != z ? 0 : 8;
            int i7 = true != z2 ? 0 : 16;
            int i8 = windowVisibility == 0 ? 128 : 0;
            int i9 = zzx >= ((long) ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlb)).intValue()) ? 32 : 0;
            com.google.android.gms.ads.internal.zzv.zzr();
            com.google.android.gms.ads.internal.util.zzs.zzK(view, i9 | i8 | i5 | i6 | i7 | z3, null);
            i2 = 1;
        } else {
            i2 = 1;
        }
        if (i == i2 && !this.zzk.zzb() && z3 == this.zzl) {
            return;
        }
        if (z3 != 0 || this.zzl) {
            z4 = true;
        } else {
            z4 = true;
            if (i == 1) {
                return;
            }
        }
        boolean z5 = z3;
        zzazc zzazcVar = new zzazc(com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime(), this.zzg.isScreenOn(), (view == null || !view.isAttachedToWindow()) ? false : z4, view != null ? view.getWindowVisibility() : 8, zza(this.zzp), zza(rect), zza(rect2), z, zza(rect3), z2, zzx, zza(rect4), this.zzo.density, z5, list);
        Iterator it = this.zzn.iterator();
        while (it.hasNext()) {
            ((zzazd) it.next()).zzdr(zzazcVar);
        }
        this.zzl = z5;
    }

    private final void zzk() {
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaza
            @Override // java.lang.Runnable
            public final void run() {
                zzaze.this.zzj(3);
            }
        });
    }

    private final void zzl(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzi = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zza == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zza = new zzazb(this);
            com.google.android.gms.ads.internal.zzv.zzx().zzc(this.zzd, this.zza, intentFilter);
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzj);
            } catch (Exception e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final void zzm(View view) {
        try {
            WeakReference weakReference = this.zzi;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzi = null;
            }
        } catch (Exception e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.zza != null) {
            try {
                com.google.android.gms.ads.internal.zzv.zzx().zzd(this.zzd, this.zza);
            } catch (IllegalStateException e3) {
                int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                com.google.android.gms.ads.internal.zzv.zzp().zzw(e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zza = null;
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzj);
            } catch (Exception e5) {
                int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzj(3);
        zzk();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zzi(activity, 4);
        zzj(3);
        zzk();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzj(3);
        zzk();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zzj(3);
        zzk();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzj(2);
        zzk();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzj(1);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzm = -1;
        zzl(view);
        zzj(3);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zzm = -1;
        zzj(3);
        zzk();
        zzm(view);
    }

    final Rect zza(Rect rect) {
        return new Rect(zzh(rect.left), zzh(rect.top), zzh(rect.right), zzh(rect.bottom));
    }

    public final void zzd(zzazd zzazdVar) {
        this.zzn.add(zzazdVar);
        zzj(3);
    }

    public final void zze(zzazd zzazdVar) {
        this.zzn.remove(zzazdVar);
    }

    public final void zzf() {
        this.zzk.zza(zzc);
    }

    public final void zzg(long j) {
        this.zzk.zza(j);
    }
}
