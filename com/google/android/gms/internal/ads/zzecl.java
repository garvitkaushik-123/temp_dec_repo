package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.NotificationHandlerActivity;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzecl extends zzbti {
    final Map zza = new HashMap();
    private final Context zzb;
    private final zzdsj zzc;
    private final com.google.android.gms.ads.internal.util.client.zzu zzd;
    private final zzeca zze;
    private String zzf;
    private String zzg;

    public zzecl(Context context, zzeca zzecaVar, com.google.android.gms.ads.internal.util.client.zzu zzuVar, zzdsj zzdsjVar) {
        this.zzb = context;
        this.zzc = zzdsjVar;
        this.zzd = zzuVar;
        this.zze = zzecaVar;
    }

    public static /* synthetic */ void zzc(zzecl zzeclVar, com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i) {
        zzeclVar.zze.zzc(zzeclVar.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzeclVar.zzw(zzeclVar.zzf, "rtsdc", hashMap);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    public static /* synthetic */ void zzd(zzecl zzeclVar, com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface) {
        zzeclVar.zze.zzc(zzeclVar.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzeclVar.zzw(zzeclVar.zzf, "rtsdc", hashMap);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    public static /* synthetic */ void zzk(zzecl zzeclVar, Activity activity, com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "confirm");
        zzeclVar.zzw(zzeclVar.zzf, "rtsdc", hashMap);
        activity.startActivity(com.google.android.gms.ads.internal.zzv.zzs().zzf(activity));
        zzeclVar.zzx();
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    public static /* synthetic */ void zzl(zzecl zzeclVar, com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i) {
        zzeclVar.zze.zzc(zzeclVar.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzeclVar.zzw(zzeclVar.zzf, "dialog_click", hashMap);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    public static /* synthetic */ void zzm(zzecl zzeclVar, Activity activity, com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "confirm");
        zzeclVar.zzw(zzeclVar.zzf, "dialog_click", hashMap);
        zzeclVar.zzy(activity, zzmVar);
    }

    public static /* synthetic */ void zzn(zzecl zzeclVar, com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface) {
        zzeclVar.zze.zzc(zzeclVar.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzeclVar.zzw(zzeclVar.zzf, "dialog_click", hashMap);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    public static void zzo(Context context, zzdsj zzdsjVar, zzeca zzecaVar, String str, String str2) {
        zzp(context, zzdsjVar, zzecaVar, str, str2, new HashMap());
    }

    public static void zzp(Context context, zzdsj zzdsjVar, zzeca zzecaVar, String str, String str2, Map map) {
        String str3;
        String str4 = true != com.google.android.gms.ads.internal.zzv.zzp().zzA(context) ? "offline" : CustomTabsCallback.ONLINE_EXTRAS_KEY;
        if (zzdsjVar != null) {
            zzdsi zza = zzdsjVar.zza();
            zza.zzb("gqi", str);
            zza.zzb("action", str2);
            zza.zzb("device_connectivity", str4);
            zza.zzb("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis()));
            for (Map.Entry entry : map.entrySet()) {
                zza.zzb((String) entry.getKey(), (String) entry.getValue());
            }
            str3 = zza.zze();
        } else {
            str3 = "";
        }
        zzecaVar.zzd(new zzecc(com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis(), str, str3, 2));
    }

    public static final PendingIntent zzr(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putExtra("offline_notification_action", str);
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str3);
        if (Build.VERSION.SDK_INT >= 29 && str.equals("offline_notification_clicked")) {
            intent.setClassName(context, NotificationHandlerActivity.CLASS_NAME);
            return zzfsk.zza(context, 0, intent, 201326592);
        }
        intent.setClassName(context, AdService.CLASS_NAME);
        ClipData clipData = zzfsk.zza;
        return zzfsk.zzb(context, 0, intent, 1140850688, 0);
    }

    private final AlertDialog zzs(Activity activity, final com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        com.google.android.gms.ads.internal.zzv.zzr();
        AlertDialog.Builder onCancelListener = com.google.android.gms.ads.internal.util.zzs.zzL(activity).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzecd
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                com.google.android.gms.ads.internal.overlay.zzm zzmVar2 = com.google.android.gms.ads.internal.overlay.zzm.this;
                if (zzmVar2 != null) {
                    zzmVar2.zzb();
                }
            }
        });
        XmlResourceParser zzt = zzt(R.layout.offline_ads_dialog);
        if (zzt == null) {
            onCancelListener.setMessage(zzv(R.string.offline_dialog_text, "Thanks for your interest.\nWe will share more once you're back online."));
            return onCancelListener.create();
        }
        try {
            View inflate = activity.getLayoutInflater().inflate(zzt, (ViewGroup) null);
            onCancelListener.setView(inflate);
            String zzu = zzu();
            if (!TextUtils.isEmpty(zzu)) {
                TextView textView = (TextView) inflate.findViewById(R.id.offline_dialog_advertiser_name);
                textView.setVisibility(0);
                textView.setText(zzu);
            }
            zzebs zzebsVar = (zzebs) this.zza.get(this.zzf);
            Drawable zza = zzebsVar != null ? zzebsVar.zza() : null;
            if (zza != null) {
                ((ImageView) inflate.findViewById(R.id.offline_dialog_image)).setImageDrawable(zza);
            }
            AlertDialog create = onCancelListener.create();
            create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            return create;
        } catch (Resources.NotFoundException unused) {
            onCancelListener.setMessage(zzv(R.string.offline_dialog_text, "Thanks for your interest.\nWe will share more once you're back online."));
            return onCancelListener.create();
        }
    }

    private static XmlResourceParser zzt(int i) {
        Resources zze = com.google.android.gms.ads.internal.zzv.zzp().zze();
        if (zze == null) {
            return null;
        }
        try {
            return zze.getLayout(i);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    private final String zzu() {
        zzebs zzebsVar = (zzebs) this.zza.get(this.zzf);
        return zzebsVar == null ? "" : zzebsVar.zzb();
    }

    private static String zzv(int i, String str) {
        Resources zze = com.google.android.gms.ads.internal.zzv.zzp().zze();
        if (zze != null) {
            try {
                return zze.getString(i);
            } catch (Resources.NotFoundException unused) {
            }
        }
        return str;
    }

    private final void zzw(String str, String str2, Map map) {
        zzp(this.zzb, this.zzc, this.zze, str, str2, map);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzx() {
        boolean z;
        boolean z2;
        try {
            com.google.android.gms.ads.internal.zzv.zzr();
            Context context = this.zzb;
            com.google.android.gms.ads.internal.util.zzbr zzA = com.google.android.gms.ads.internal.util.zzs.zzA(context);
            IObjectWrapper wrap = ObjectWrapper.wrap(context);
            String str = this.zzg;
            String str2 = this.zzf;
            zzebs zzebsVar = (zzebs) this.zza.get(str2);
            z = zzA.zzg(wrap, new com.google.android.gms.ads.internal.offline.buffering.zza(str, str2, zzebsVar == null ? "" : zzebsVar.zzc()));
            if (z) {
                z2 = true;
            } else {
                try {
                    z2 = zzA.zzf(ObjectWrapper.wrap(context), this.zzg, this.zzf);
                } catch (RemoteException e) {
                    e = e;
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("Failed to schedule offline notification poster.", e);
                    z2 = z;
                    if (z2) {
                    }
                }
            }
        } catch (RemoteException e2) {
            e = e2;
            z = false;
        }
        if (z2) {
            this.zze.zzc(this.zzf);
            zzw(this.zzf, "offline_notification_worker_not_scheduled", zzfyt.zzd());
        }
    }

    private final void zzy(final Activity activity, final com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        com.google.android.gms.ads.internal.zzv.zzr();
        if (NotificationManagerCompat.from(activity).areNotificationsEnabled()) {
            zzx();
            zzz(activity, zzmVar);
        } else {
            if (Build.VERSION.SDK_INT >= 33) {
                activity.requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 12345);
                zzw(this.zzf, "asnpdi", zzfyt.zzd());
                return;
            }
            com.google.android.gms.ads.internal.zzv.zzr();
            AlertDialog.Builder zzL = com.google.android.gms.ads.internal.util.zzs.zzL(activity);
            zzL.setTitle(zzv(R.string.notifications_permission_title, "Allow app to send you notifications?")).setPositiveButton(zzv(R.string.notifications_permission_confirm, HttpHeaders.ALLOW), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzece
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    zzecl.zzk(zzecl.this, activity, zzmVar, dialogInterface, i);
                }
            }).setNegativeButton(zzv(R.string.notifications_permission_decline, "Don't allow"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzecf
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    zzecl.zzc(zzecl.this, zzmVar, dialogInterface, i);
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzecg
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    zzecl.zzd(zzecl.this, zzmVar, dialogInterface);
                }
            });
            zzL.create().show();
            zzw(this.zzf, "rtsdi", zzfyt.zzd());
        }
    }

    private final void zzz(Activity activity, com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        AlertDialog zzs = zzs(activity, zzmVar);
        zzs.show();
        Timer timer = new Timer();
        timer.schedule(new zzeck(this, zzs, timer, zzmVar), 3000L);
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zze(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra != null) {
            if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
                String stringExtra2 = intent.getStringExtra("gws_query_id");
                String stringExtra3 = intent.getStringExtra("uri");
                Context context = this.zzb;
                boolean zzA = com.google.android.gms.ads.internal.zzv.zzp().zzA(context);
                HashMap hashMap = new HashMap();
                if (stringExtra.equals("offline_notification_clicked")) {
                    hashMap.put("offline_notification_action", "offline_notification_clicked");
                    r9 = true == zzA ? (char) 1 : (char) 2;
                    hashMap.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                    hashMap.put("olaih", String.valueOf(stringExtra3.startsWith("http")));
                    try {
                        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                        if (launchIntentForPackage == null) {
                            launchIntentForPackage = new Intent("android.intent.action.VIEW");
                            launchIntentForPackage.setData(Uri.parse(stringExtra3));
                        }
                        launchIntentForPackage.addFlags(268435456);
                        context.startActivity(launchIntentForPackage);
                        hashMap.put("olaa", "olas");
                    } catch (ActivityNotFoundException unused) {
                        hashMap.put("olaa", "olaf");
                    }
                } else {
                    hashMap.put("offline_notification_action", "offline_notification_dismissed");
                }
                zzw(stringExtra2, "offline_notification_action", hashMap);
                try {
                    SQLiteDatabase writableDatabase = this.zze.getWritableDatabase();
                    if (r9 == 1) {
                        this.zze.zzg(writableDatabase, this.zzd, stringExtra2);
                    } else {
                        zzeca.zzi(writableDatabase, stringExtra2);
                    }
                } catch (SQLiteException e) {
                    String concat = "Failed to get writable offline buffering database: ".concat(e.toString());
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzg(concat);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zzf(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals("android.permission.POST_NOTIFICATIONS")) {
                zzecn zzecnVar = (zzecn) ObjectWrapper.unwrap(iObjectWrapper);
                Activity zza = zzecnVar.zza();
                com.google.android.gms.ads.internal.overlay.zzm zzb = zzecnVar.zzb();
                HashMap hashMap = new HashMap();
                if (iArr[i] == 0) {
                    hashMap.put("dialog_action", "confirm");
                    zzx();
                    zzz(zza, zzb);
                } else {
                    hashMap.put("dialog_action", "dismiss");
                    if (zzb != null) {
                        zzb.zzb();
                    }
                }
                zzw(this.zzf, "asnpdc", hashMap);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zzg(IObjectWrapper iObjectWrapper) {
        zzecn zzecnVar = (zzecn) ObjectWrapper.unwrap(iObjectWrapper);
        final Activity zza = zzecnVar.zza();
        final com.google.android.gms.ads.internal.overlay.zzm zzb = zzecnVar.zzb();
        this.zzf = zzecnVar.zzc();
        this.zzg = zzecnVar.zzd();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziQ)).booleanValue()) {
            zzy(zza, zzb);
            return;
        }
        zzw(this.zzf, "dialog_impression", zzfyt.zzd());
        com.google.android.gms.ads.internal.zzv.zzr();
        AlertDialog.Builder zzL = com.google.android.gms.ads.internal.util.zzs.zzL(zza);
        zzL.setTitle(zzv(R.string.offline_opt_in_title, "Open ad when you're back online.")).setMessage(zzv(R.string.offline_opt_in_message, "We'll send you a notification with a link to the advertiser site.")).setPositiveButton(zzv(R.string.offline_opt_in_confirm, "OK"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzech
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                zzecl.zzm(zzecl.this, zza, zzb, dialogInterface, i);
            }
        }).setNegativeButton(zzv(R.string.offline_opt_in_decline, "No thanks"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzeci
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                zzecl.zzl(zzecl.this, zzb, dialogInterface, i);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzecj
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                zzecl.zzn(zzecl.this, zzb, dialogInterface);
            }
        });
        zzL.create().show();
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zzh() {
        final com.google.android.gms.ads.internal.util.client.zzu zzuVar = this.zzd;
        this.zze.zze(new zzfge() { // from class: com.google.android.gms.internal.ads.zzebt
            @Override // com.google.android.gms.internal.ads.zzfge
            public final Object zza(Object obj) {
                zzeca.zzb(com.google.android.gms.ads.internal.util.client.zzu.this, (SQLiteDatabase) obj);
                return null;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zzi(IObjectWrapper iObjectWrapper, String str, String str2) {
        zzj(iObjectWrapper, new com.google.android.gms.ads.internal.offline.buffering.zza(str, str2, ""));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|1|(1:3)(1:28)|4|(9:8|9|(2:21|22)|11|12|13|14|15|16)|27|(0)|11|12|13|14|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00da, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00db, code lost:
    
        r9.put("notification_not_shown_reason", r8.getMessage());
        r8 = "offline_notification_failed";
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzbtj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.offline.buffering.zza zzaVar) {
        Bitmap bitmap;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        String str = zzaVar.zza;
        String str2 = zzaVar.zzb;
        String str3 = zzaVar.zzc;
        String zzu = zzu();
        com.google.android.gms.ads.internal.zzv.zzs().zzh(context, "offline_notification_channel", "AdMob Offline Notifications");
        PendingIntent zzr = zzr(context, "offline_notification_clicked", str2, str);
        PendingIntent zzr2 = zzr(context, "offline_notification_dismissed", str2, str);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "offline_notification_channel");
        if (TextUtils.isEmpty(zzu)) {
            builder.setContentTitle(zzv(R.string.offline_notification_title, "You are back online! Let's pick up where we left off"));
        } else {
            builder.setContentTitle(String.format(zzv(R.string.offline_notification_title_with_advertiser, "You are back online! Continue learning about %s"), zzu));
        }
        builder.setAutoCancel(true).setDeleteIntent(zzr2).setContentIntent(zzr).setSmallIcon(context.getApplicationInfo().icon).setPriority(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziR)).intValue());
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziT)).booleanValue() && !str3.isEmpty()) {
            try {
                bitmap = BitmapFactory.decodeStream(new URL(str3).openConnection().getInputStream());
            } catch (IOException unused) {
            }
            if (bitmap != null) {
                try {
                    builder.setLargeIcon(bitmap).setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon((Bitmap) null));
                } catch (Resources.NotFoundException unused2) {
                }
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            HashMap hashMap = new HashMap();
            notificationManager.notify(str2, 54321, builder.build());
            String str4 = "offline_notification_impression";
            zzw(str2, str4, hashMap);
        }
        bitmap = null;
        if (bitmap != null) {
        }
        NotificationManager notificationManager2 = (NotificationManager) context.getSystemService("notification");
        HashMap hashMap2 = new HashMap();
        notificationManager2.notify(str2, 54321, builder.build());
        String str42 = "offline_notification_impression";
        zzw(str2, str42, hashMap2);
    }

    public final void zzq(String str, zzdit zzditVar) {
        String zzx = zzditVar.zzx();
        String zzB = zzditVar.zzB();
        String str2 = "";
        if (TextUtils.isEmpty(zzx)) {
            zzx = zzB != null ? zzB : "";
        }
        zzbgp zzm = zzditVar.zzm();
        if (zzm != null) {
            try {
                str2 = zzm.zze().toString();
            } catch (RemoteException unused) {
            }
        }
        zzbgp zzn = zzditVar.zzn();
        Drawable drawable = null;
        if (zzn != null) {
            try {
                IObjectWrapper zzf = zzn.zzf();
                if (zzf != null) {
                    drawable = (Drawable) ObjectWrapper.unwrap(zzf);
                }
            } catch (RemoteException unused2) {
            }
        }
        this.zza.put(str, new zzebo(zzx, str2, drawable));
    }
}
