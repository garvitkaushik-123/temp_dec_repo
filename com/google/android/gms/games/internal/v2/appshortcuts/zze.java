package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.Context;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.games_v2.zzfq;
import com.google.android.gms.internal.games_v2.zzgz;
import com.google.android.gms.internal.games_v2.zzhd;
import com.google.android.gms.internal.games_v2.zzio;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes4.dex */
final class zze extends zzf {
    private final Context zza;

    public zze(Context context) {
        super(null);
        this.zza = context.getApplicationContext();
    }

    static /* synthetic */ zzg zzc(zzhd zzhdVar, zzhd zzhdVar2, Task task) {
        return task.isSuccessful() ? (zzg) task.getResult() : zze(zzhdVar, zzhdVar2);
    }

    private static zzg zze(zzhd zzhdVar, zzhd zzhdVar2) {
        return new zzg(zzf(zzhdVar), zzhd.zzi(), zzf(zzhdVar2), zzhd.zzi());
    }

    private static zzhd zzf(zzhd zzhdVar) {
        int i = zzhd.zzd;
        zzgz zzgzVar = new zzgz();
        int size = zzhdVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            String zza = ((zzi) zzhdVar.get(i2)).zza();
            if (zza != null) {
                zzgzVar.zzd(zza);
            }
        }
        return zzgzVar.zze();
    }

    private static zzhd zzg(List list) {
        int i = zzhd.zzd;
        zzgz zzgzVar = new zzgz();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ShortcutInfo shortcutInfo = (ShortcutInfo) it.next();
            if (!shortcutInfo.isImmutable() && shortcutInfo.getId().startsWith("PLAY_GAMES_SERVICES_")) {
                zzgzVar.zzd(new zzi(shortcutInfo.getId(), shortcutInfo.getExtras(), Boolean.valueOf(shortcutInfo.isPinned()), Boolean.valueOf(shortcutInfo.isEnabled())));
            }
        }
        return zzgzVar.zze();
    }

    @Override // com.google.android.gms.games.internal.v2.appshortcuts.zzf
    public final void zza() {
        zzfq.zza();
        new Thread(new Runnable() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzd
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zze.this.zzb();
            }
        }, "initialize-shortcuts").start();
    }

    final /* synthetic */ void zzb() {
        Task forResult;
        Context context = this.zza;
        final ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
        if (shortcutManager == null) {
            return;
        }
        final zzr zza = zzt.zza(context, PlayGamesAppShortcutsActivity.class);
        final zzhd zzg = zzg(shortcutManager.getDynamicShortcuts());
        final zzhd zzg2 = zzg(shortcutManager.getPinnedShortcuts());
        if (zza == null || zza.zza() <= 0) {
            forResult = Tasks.forResult(zze(zzg, zzg2));
        } else {
            final zzq zzqVar = new zzq(context);
            forResult = zzqVar.doRead(TaskApiCall.builder().setMethodKey(6744).setFeatures(com.google.android.gms.games.zzd.zzg).setAutoResolveMissingFeatures(false).run(new RemoteCall() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzp
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final /* synthetic */ void accept(Object obj, Object obj2) {
                    ((zzv) ((zzu) obj).getService()).zzd(new zzl(zzq.this, (TaskCompletionSource) obj2), zza, zzg, zzg2);
                }
            }).build()).continueWith(zzio.zza(), new Continuation() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzc
                @Override // com.google.android.gms.tasks.Continuation
                public final /* synthetic */ Object then(Task task) {
                    return zze.zzc(zzhd.this, zzg2, task);
                }
            });
        }
        forResult.addOnSuccessListener(zzio.zza(), new OnSuccessListener() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzb
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final /* synthetic */ void onSuccess(Object obj) {
                zzg zzgVar = (zzg) obj;
                List<String> zza2 = zzgVar.zza();
                ShortcutManager shortcutManager2 = shortcutManager;
                if (zza2 != null && !zza2.isEmpty()) {
                    shortcutManager2.removeDynamicShortcuts(zza2);
                }
                List<ShortcutInfo> zzb = zzgVar.zzb();
                if (zzb != null && !zzb.isEmpty()) {
                    shortcutManager2.addDynamicShortcuts(zzb);
                }
                List<String> zzc = zzgVar.zzc();
                if (zzc != null && !zzc.isEmpty()) {
                    shortcutManager2.disableShortcuts(zzc);
                }
                List<String> zzd = zzgVar.zzd();
                if (zzd == null || zzd.isEmpty()) {
                    return;
                }
                shortcutManager2.enableShortcuts(zzd);
            }
        });
    }
}
