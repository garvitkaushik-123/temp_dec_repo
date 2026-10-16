package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.webkit.internal.AssetHelper;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzdve;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzgdy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzau {
    private final Context zza;
    private final zzdvi zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private int zzg;
    private int zzh;
    private PointF zzi;
    private PointF zzj;
    private Handler zzk;
    private Runnable zzl;

    public zzau(Context context) {
        this.zzg = 0;
        this.zzl = new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzaf
            @Override // java.lang.Runnable
            public final void run() {
                zzau.zzi(zzau.this);
            }
        };
        this.zza = context;
        this.zzh = ViewConfiguration.get(context).getScaledTouchSlop();
        com.google.android.gms.ads.internal.zzv.zzv().zzb();
        this.zzk = com.google.android.gms.ads.internal.zzv.zzv().zza();
        this.zzb = com.google.android.gms.ads.internal.zzv.zzu().zza();
    }

    public static /* synthetic */ void zza(zzau zzauVar) {
        zzay zzu = com.google.android.gms.ads.internal.zzv.zzu();
        String str = zzauVar.zzd;
        String str2 = zzauVar.zze;
        String str3 = zzauVar.zzf;
        boolean zzm = zzu.zzm();
        Context context = zzauVar.zza;
        zzu.zzh(zzu.zzj(context, str, str2));
        if (!zzu.zzm()) {
            zzu.zzd(context, str, str2);
            return;
        }
        if (!zzm && !TextUtils.isEmpty(str3)) {
            zzu.zze(context, str2, str3, str);
        }
        int i = zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Device is linked for debug signals.");
        zzu.zzi(context, "The device is successfully linked for troubleshooting.", false, true);
    }

    public static /* synthetic */ void zzc(final zzau zzauVar, int i, int i2, int i3, int i4, int i5, DialogInterface dialogInterface, int i6) {
        if (i6 != i) {
            if (i6 == i2) {
                int i7 = zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Debug mode [Creative Preview] selected.");
                zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzag
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzau.zzj(zzau.this);
                    }
                });
                return;
            }
            if (i6 == i3) {
                int i8 = zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Debug mode [Troubleshooting] selected.");
                zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzat
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzau.zza(zzau.this);
                    }
                });
                return;
            }
            if (i6 == i4) {
                zzdvi zzdviVar = zzauVar.zzb;
                final zzgdy zzgdyVar = zzcaf.zzf;
                zzgdy zzgdyVar2 = zzcaf.zza;
                if (zzdviVar.zzq()) {
                    zzgdyVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzar
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.google.android.gms.ads.internal.zzv.zzu().zzc(zzau.this.zza);
                        }
                    });
                    return;
                } else {
                    zzgdyVar2.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzas
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzau.zzl(zzau.this, zzgdyVar);
                        }
                    });
                    return;
                }
            }
            if (i6 == i5) {
                zzdvi zzdviVar2 = zzauVar.zzb;
                final zzgdy zzgdyVar3 = zzcaf.zzf;
                zzgdy zzgdyVar4 = zzcaf.zza;
                if (zzdviVar2.zzq()) {
                    zzgdyVar3.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzae
                        @Override // java.lang.Runnable
                        public final void run() {
                            r0.zzs(zzau.this.zza);
                        }
                    });
                    return;
                } else {
                    zzgdyVar4.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzal
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzau.zzd(zzau.this, zzgdyVar3);
                        }
                    });
                    return;
                }
            }
            return;
        }
        Context context = zzauVar.zza;
        if (!(context instanceof Activity)) {
            int i9 = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Can not create dialog without Activity Context");
            return;
        }
        String str = zzauVar.zzc;
        final String str2 = "No debug information";
        if (!TextUtils.isEmpty(str)) {
            Uri build = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
            StringBuilder sb = new StringBuilder();
            com.google.android.gms.ads.internal.zzv.zzr();
            Map zzQ = zzs.zzQ(build);
            for (String str3 : zzQ.keySet()) {
                sb.append(str3);
                sb.append(" = ");
                sb.append((String) zzQ.get(str3));
                sb.append("\n\n");
            }
            String trim = sb.toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                str2 = trim;
            }
        }
        com.google.android.gms.ads.internal.zzv.zzr();
        AlertDialog.Builder zzL = zzs.zzL(context);
        zzL.setMessage(str2);
        zzL.setTitle("Ad Information");
        zzL.setPositiveButton("Share", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzah
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface2, int i10) {
                zzau.zzg(zzau.this, str2, dialogInterface2, i10);
            }
        });
        zzL.setNegativeButton("Close", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzai
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface2, int i10) {
            }
        });
        zzL.create().show();
    }

    public static /* synthetic */ void zzd(final zzau zzauVar, zzgdy zzgdyVar) {
        zzay zzu = com.google.android.gms.ads.internal.zzv.zzu();
        Context context = zzauVar.zza;
        if (zzu.zzj(context, zzauVar.zzd, zzauVar.zze)) {
            zzgdyVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzak
                @Override // java.lang.Runnable
                public final void run() {
                    r0.zzs(zzau.this.zza);
                }
            });
        } else {
            com.google.android.gms.ads.internal.zzv.zzu().zzd(context, zzauVar.zzd, zzauVar.zze);
        }
    }

    public static /* synthetic */ void zzf(zzau zzauVar, AtomicInteger atomicInteger, int i, int i2, int i3, DialogInterface dialogInterface, int i4) {
        if (atomicInteger.get() != i) {
            if (atomicInteger.get() == i2) {
                zzauVar.zzb.zzm(zzdve.SHAKE);
            } else if (atomicInteger.get() == i3) {
                zzauVar.zzb.zzm(zzdve.FLICK);
            } else {
                zzauVar.zzb.zzm(zzdve.NONE);
            }
        }
        zzauVar.zzr();
    }

    public static /* synthetic */ void zzg(zzau zzauVar, String str, DialogInterface dialogInterface, int i) {
        com.google.android.gms.ads.internal.zzv.zzr();
        zzs.zzU(zzauVar.zza, Intent.createChooser(new Intent("android.intent.action.SEND").setType(AssetHelper.DEFAULT_MIME_TYPE).putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    public static /* synthetic */ void zzi(zzau zzauVar) {
        zzauVar.zzg = 4;
        zzauVar.zzr();
    }

    public static /* synthetic */ void zzj(zzau zzauVar) {
        zzay zzu = com.google.android.gms.ads.internal.zzv.zzu();
        Context context = zzauVar.zza;
        String str = zzauVar.zzd;
        String str2 = zzauVar.zze;
        if (!zzu.zzk(context, str, str2)) {
            zzu.zzi(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
            return;
        }
        if ("2".equals(zzu.zza)) {
            int i = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Creative is not pushed for this device.");
            zzu.zzi(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(zzu.zza)) {
            int i2 = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("The app is not linked for creative preview.");
            zzu.zzd(context, str, str2);
        } else if ("0".equals(zzu.zza)) {
            int i3 = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Device is linked for in app preview.");
            zzu.zzi(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public static /* synthetic */ void zzl(final zzau zzauVar, zzgdy zzgdyVar) {
        zzay zzu = com.google.android.gms.ads.internal.zzv.zzu();
        Context context = zzauVar.zza;
        if (zzu.zzj(context, zzauVar.zzd, zzauVar.zze)) {
            zzgdyVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzaj
                @Override // java.lang.Runnable
                public final void run() {
                    com.google.android.gms.ads.internal.zzv.zzu().zzc(zzau.this.zza);
                }
            });
        } else {
            com.google.android.gms.ads.internal.zzv.zzu().zzd(context, zzauVar.zzd, zzauVar.zze);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(Context context) {
        ArrayList arrayList = new ArrayList();
        int zzu = zzu(arrayList, "None", true);
        final int zzu2 = zzu(arrayList, "Shake", true);
        final int zzu3 = zzu(arrayList, "Flick", true);
        int ordinal = this.zzb.zza().ordinal();
        final int i = ordinal != 1 ? ordinal != 2 ? zzu : zzu3 : zzu2;
        com.google.android.gms.ads.internal.zzv.zzr();
        AlertDialog.Builder zzL = zzs.zzL(context);
        final AtomicInteger atomicInteger = new AtomicInteger(i);
        zzL.setTitle("Setup gesture");
        zzL.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), i, new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzan
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                atomicInteger.set(i2);
            }
        });
        zzL.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzao
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                zzau.this.zzr();
            }
        });
        zzL.setPositiveButton("Save", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzap
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                zzau.zzf(zzau.this, atomicInteger, i, zzu2, zzu3, dialogInterface, i2);
            }
        });
        zzL.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.ads.internal.util.zzaq
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                zzau.this.zzr();
            }
        });
        zzL.create().show();
    }

    private final boolean zzt(float f, float f2, float f3, float f4) {
        return Math.abs(this.zzi.x - f) < ((float) this.zzh) && Math.abs(this.zzi.y - f2) < ((float) this.zzh) && Math.abs(this.zzj.x - f3) < ((float) this.zzh) && Math.abs(this.zzj.y - f4) < ((float) this.zzh);
    }

    private static final int zzu(List list, String str, boolean z) {
        if (!z) {
            return -1;
        }
        list.add(str);
        return list.size() - 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.zzc);
        sb.append(",DebugSignal: ");
        sb.append(this.zzf);
        sb.append(",AFMA Version: ");
        sb.append(this.zze);
        sb.append(",Ad Unit ID: ");
        sb.append(this.zzd);
        sb.append("}");
        return sb.toString();
    }

    public final void zzm(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.zzg = 0;
            this.zzi = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i = this.zzg;
        if (i == -1) {
            return;
        }
        if (i == 0) {
            if (actionMasked == 5) {
                this.zzg = 5;
                this.zzj = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                this.zzk.postDelayed(this.zzl, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfg)).longValue());
                return;
            }
            return;
        }
        if (i == 5) {
            if (pointerCount == 2) {
                if (actionMasked != 2) {
                    return;
                }
                boolean z = false;
                for (int i2 = 0; i2 < historySize; i2++) {
                    z |= !zzt(motionEvent.getHistoricalX(0, i2), motionEvent.getHistoricalY(0, i2), motionEvent.getHistoricalX(1, i2), motionEvent.getHistoricalY(1, i2));
                }
                if (zzt(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1)) && !z) {
                    return;
                }
            }
            this.zzg = -1;
            this.zzk.removeCallbacks(this.zzl);
        }
    }

    public final void zzn(String str) {
        this.zzd = str;
    }

    public final void zzo(String str) {
        this.zze = str;
    }

    public final void zzp(String str) {
        this.zzc = str;
    }

    public final void zzq(String str) {
        this.zzf = str;
    }

    public final void zzr() {
        try {
            Context context = this.zza;
            if (!(context instanceof Activity)) {
                int i = zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Can not create dialog without Activity Context");
                return;
            }
            String str = "Creative preview (enabled)";
            if (true == TextUtils.isEmpty(com.google.android.gms.ads.internal.zzv.zzu().zzb())) {
                str = "Creative preview";
            }
            String str2 = true != com.google.android.gms.ads.internal.zzv.zzu().zzm() ? "Troubleshooting" : "Troubleshooting (enabled)";
            ArrayList arrayList = new ArrayList();
            final int zzu = zzu(arrayList, "Ad information", true);
            final int zzu2 = zzu(arrayList, str, true);
            final int zzu3 = zzu(arrayList, str2, true);
            boolean booleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjE)).booleanValue();
            final int zzu4 = zzu(arrayList, "Open ad inspector", booleanValue);
            final int zzu5 = zzu(arrayList, "Ad inspector settings", booleanValue);
            com.google.android.gms.ads.internal.zzv.zzr();
            AlertDialog.Builder zzL = zzs.zzL(context);
            zzL.setTitle("Select a debug mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzam
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    zzau.zzc(zzau.this, zzu, zzu2, zzu3, zzu4, zzu5, dialogInterface, i2);
                }
            });
            zzL.create().show();
        } catch (WindowManager.BadTokenException e) {
            zze.zzb("", e);
        }
    }

    public zzau(Context context, String str) {
        this(context);
        this.zzc = str;
    }
}
