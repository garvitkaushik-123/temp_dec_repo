package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdjt {
    static final ImageView.ScaleType zza = ImageView.ScaleType.CENTER_INSIDE;
    private final com.google.android.gms.ads.internal.util.zzg zzb;
    private final zzfcw zzc;
    private final zzdiy zzd;
    private final zzdit zze;
    private final zzdkh zzf;
    private final zzdkp zzg;
    private final Executor zzh;
    private final Executor zzi;
    private final zzbge zzj;
    private final zzdiq zzk;

    public zzdjt(com.google.android.gms.ads.internal.util.zzg zzgVar, zzfcw zzfcwVar, zzdiy zzdiyVar, zzdit zzditVar, zzdkh zzdkhVar, zzdkp zzdkpVar, Executor executor, Executor executor2, zzdiq zzdiqVar) {
        this.zzb = zzgVar;
        this.zzc = zzfcwVar;
        this.zzj = zzfcwVar.zzi;
        this.zzd = zzdiyVar;
        this.zze = zzditVar;
        this.zzf = zzdkhVar;
        this.zzg = zzdkpVar;
        this.zzh = executor;
        this.zzi = executor2;
        this.zzk = zzdiqVar;
    }

    public static /* synthetic */ void zza(zzdjt zzdjtVar, ViewGroup viewGroup) {
        zzdit zzditVar = zzdjtVar.zze;
        if (zzditVar.zzf() != null) {
            boolean z = viewGroup != null;
            if (zzditVar.zzc() == 2 || zzditVar.zzc() == 1) {
                zzdjtVar.zzb.zzF(zzdjtVar.zzc.zzf, String.valueOf(zzditVar.zzc()), z);
            } else if (zzditVar.zzc() == 6) {
                com.google.android.gms.ads.internal.util.zzg zzgVar = zzdjtVar.zzb;
                String str = zzdjtVar.zzc.zzf;
                zzgVar.zzF(str, "2", z);
                zzgVar.zzF(str, "1", z);
            }
        }
    }

    public static /* synthetic */ void zzb(final zzdjt zzdjtVar, zzdkr zzdkrVar) {
        ViewGroup viewGroup;
        View view;
        final ViewGroup viewGroup2;
        zzbgm zza2;
        Drawable drawable;
        zzdiy zzdiyVar = zzdjtVar.zzd;
        if (zzdiyVar.zzf() || zzdiyVar.zze()) {
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, "3011"};
            for (int i = 0; i < 2; i++) {
                View zzg = zzdkrVar.zzg(strArr[i]);
                if (zzg instanceof ViewGroup) {
                    viewGroup = (ViewGroup) zzg;
                    break;
                }
            }
        }
        viewGroup = null;
        Context context = zzdkrVar.zzf().getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        zzdit zzditVar = zzdjtVar.zze;
        if (zzditVar.zze() != null) {
            view = zzditVar.zze();
            zzbge zzbgeVar = zzdjtVar.zzj;
            if (zzbgeVar != null && viewGroup == null) {
                zzh(layoutParams, zzbgeVar.zze);
                view.setLayoutParams(layoutParams);
                viewGroup = null;
            }
        } else if (zzditVar.zzl() instanceof zzbfz) {
            zzbfz zzbfzVar = (zzbfz) zzditVar.zzl();
            if (viewGroup == null) {
                zzh(layoutParams, zzbfzVar.zzc());
                viewGroup = null;
            }
            View zzbgaVar = new zzbga(context, zzbfzVar, layoutParams);
            zzbgaVar.setContentDescription((CharSequence) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzed));
            view = zzbgaVar;
        } else {
            view = null;
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            } else {
                com.google.android.gms.ads.formats.zza zzaVar = new com.google.android.gms.ads.formats.zza(zzdkrVar.zzf().getContext());
                zzaVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                zzaVar.addView(view);
                FrameLayout zzh = zzdkrVar.zzh();
                if (zzh != null) {
                    zzh.addView(zzaVar);
                }
            }
            zzdkrVar.zzq(zzdkrVar.zzk(), view, true);
        }
        zzfyq zzfyqVar = zzdjp.zza;
        int size = zzfyqVar.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                viewGroup2 = null;
                break;
            }
            View zzg2 = zzdkrVar.zzg((String) zzfyqVar.get(i2));
            i2++;
            if (zzg2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) zzg2;
                break;
            }
        }
        zzdjtVar.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdjq
            @Override // java.lang.Runnable
            public final void run() {
                zzdjt.zza(zzdjt.this, viewGroup2);
            }
        });
        if (viewGroup2 == null) {
            return;
        }
        if (zzdjtVar.zzi(viewGroup2, true)) {
            if (zzditVar.zzs() != null) {
                zzditVar.zzs().zzar(new zzdjs(zzdkrVar, viewGroup2));
                return;
            }
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkw)).booleanValue() && zzdjtVar.zzi(viewGroup2, false)) {
            if (zzditVar.zzq() != null) {
                zzditVar.zzq().zzar(new zzdjs(zzdkrVar, viewGroup2));
                return;
            }
            return;
        }
        viewGroup2.removeAllViews();
        View zzf = zzdkrVar.zzf();
        Context context2 = zzf != null ? zzf.getContext() : null;
        if (context2 == null || (zza2 = zzdjtVar.zzk.zza()) == null) {
            return;
        }
        try {
            IObjectWrapper zzi = zza2.zzi();
            if (zzi == null || (drawable = (Drawable) ObjectWrapper.unwrap(zzi)) == null) {
                return;
            }
            ImageView imageView = new ImageView(context2);
            imageView.setImageDrawable(drawable);
            IObjectWrapper zzj = zzdkrVar.zzj();
            if (zzj == null || !((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgu)).booleanValue()) {
                imageView.setScaleType(zza);
            } else {
                imageView.setScaleType((ImageView.ScaleType) ObjectWrapper.unwrap(zzj));
            }
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            viewGroup2.addView(imageView);
        } catch (RemoteException unused) {
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not get main image drawable");
        }
    }

    private final boolean zzi(ViewGroup viewGroup, boolean z) {
        View zzf = z ? this.zze.zzf() : this.zze.zzg();
        if (zzf == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzf.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzf.getParent()).removeView(zzf);
        }
        viewGroup.addView(zzf, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzef)).booleanValue() ? new FrameLayout.LayoutParams(-1, -1, 17) : new FrameLayout.LayoutParams(-2, -2, 17));
        return true;
    }

    public final void zzc(zzdkr zzdkrVar) {
        zzdkh zzdkhVar;
        if (zzdkrVar == null || (zzdkhVar = this.zzf) == null || zzdkrVar.zzh() == null || !this.zzd.zzg()) {
            return;
        }
        try {
            zzdkrVar.zzh().addView(zzdkhVar.zza());
        } catch (zzcfs e) {
            com.google.android.gms.ads.internal.util.zze.zzb("web view can not be obtained", e);
        }
    }

    public final void zzd(zzdkr zzdkrVar) {
        if (zzdkrVar == null) {
            return;
        }
        Context context = zzdkrVar.zzf().getContext();
        if (com.google.android.gms.ads.internal.util.zzbv.zzi(context, this.zzd.zza)) {
            if (!(context instanceof Activity)) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Activity context is needed for policy validator.");
                return;
            }
            zzdkp zzdkpVar = this.zzg;
            if (zzdkpVar == null || zzdkrVar.zzh() == null) {
                return;
            }
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                windowManager.addView(zzdkpVar.zza(zzdkrVar.zzh(), windowManager), com.google.android.gms.ads.internal.util.zzbv.zzb());
            } catch (zzcfs e) {
                com.google.android.gms.ads.internal.util.zze.zzb("web view can not be obtained", e);
            }
        }
    }

    public final void zze(final zzdkr zzdkrVar) {
        this.zzh.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdjr
            @Override // java.lang.Runnable
            public final void run() {
                zzdjt.zzb(zzdjt.this, zzdkrVar);
            }
        });
    }

    public final boolean zzf(ViewGroup viewGroup) {
        return zzi(viewGroup, false);
    }

    public final boolean zzg(ViewGroup viewGroup) {
        return zzi(viewGroup, true);
    }

    private static void zzh(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }
}
