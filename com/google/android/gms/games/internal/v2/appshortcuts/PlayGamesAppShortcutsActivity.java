package com.google.android.gms.games.internal.v2.appshortcuts;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Looper;
import android.os.PersistableBundle;
import android.util.Log;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.games_v2.zzfr;
import com.google.android.gms.internal.games_v2.zzgz;
import com.google.android.gms.internal.games_v2.zzhd;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes4.dex */
public final class PlayGamesAppShortcutsActivity extends Activity {
    private Intent zza;

    @Override // android.app.Activity
    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1005000000) {
            return;
        }
        if (i2 != -1) {
            finish();
        } else {
            new zzfr(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzy
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    PlayGamesAppShortcutsActivity.this.zza();
                }
            }, 50L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0079 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0049 A[SYNTHETIC] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void onCreate(Bundle bundle) {
        Intent intent;
        super.onCreate(bundle);
        final zzr zza = zzt.zza(this, PlayGamesAppShortcutsActivity.class);
        if (zza == null) {
            finish();
            return;
        }
        String zzb = zza.zzb();
        if (zzb == null || zzb.isEmpty()) {
            List<ResolveInfo> queryIntentActivities = getPackageManager().queryIntentActivities(new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER").setPackage(getPackageName()), 795136);
            int i = zzhd.zzd;
            zzgz zzgzVar = new zzgz();
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null) {
                    int componentEnabledSetting = getPackageManager().getComponentEnabledSetting(new ComponentName(activityInfo.packageName, activityInfo.name));
                    if (componentEnabledSetting == 0) {
                        if (activityInfo.enabled) {
                            if (!resolveInfo.activityInfo.exported) {
                                zzgzVar.zzd(resolveInfo);
                            }
                        }
                    } else if (componentEnabledSetting == 1) {
                        if (!resolveInfo.activityInfo.exported) {
                        }
                    }
                }
            }
            zzhd zze = zzgzVar.zze();
            int size = zze.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    zzb = null;
                    break;
                }
                ActivityInfo activityInfo2 = ((ResolveInfo) zze.get(i2)).activityInfo;
                i2++;
                if (activityInfo2 != null) {
                    zzb = activityInfo2.name;
                    break;
                }
            }
        }
        if (zzb == null || zzb.isEmpty()) {
            intent = null;
        } else {
            String packageName = getPackageName();
            intent = new Intent().setComponent(new ComponentName(packageName, zzb)).setPackage(packageName).addFlags(335577088);
        }
        if (intent == null) {
            finish();
            return;
        }
        this.zza = intent;
        final zzq zzqVar = new zzq((Activity) this);
        Intent intent2 = getIntent();
        final zzi zziVar = new zzi(intent2.getStringExtra("com.google.android.gms.games.EXTRA_APP_SHORTCUT_ID"), (PersistableBundle) intent2.getParcelableExtra("com.google.android.gms.games.EXTRA_APP_SHORTCUT_EXTRAS"), null, true);
        zzqVar.doRead(TaskApiCall.builder().setMethodKey(6745).setFeatures(com.google.android.gms.games.zzd.zzg).setAutoResolveMissingFeatures(false).run(new RemoteCall() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzo
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                ((zzv) ((zzu) obj).getService()).zze(new zzm(zzq.this, (TaskCompletionSource) obj2), zza, zziVar);
            }
        }).build()).addOnCompleteListener(this, new OnCompleteListener() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzz
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task) {
                PlayGamesAppShortcutsActivity playGamesAppShortcutsActivity = PlayGamesAppShortcutsActivity.this;
                if (task.isSuccessful()) {
                    playGamesAppShortcutsActivity.startActivityForResult((Intent) task.getResult(), 1005000000);
                } else {
                    Log.e("PGShortcutsActivity", "Failed to access intent.", task.getException());
                    playGamesAppShortcutsActivity.finish();
                }
            }
        });
    }

    final /* synthetic */ void zza() {
        startActivityForResult(this.zza, 1005000001);
        finish();
        System.exit(0);
    }
}
