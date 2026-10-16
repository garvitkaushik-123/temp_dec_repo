package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Predicate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes5.dex */
public final class zzbnl implements zzbnd, zzbnc {
    private final zzcfg zza;

    public zzbnl(Context context, VersionInfoParcel versionInfoParcel, zzavu zzavuVar, com.google.android.gms.ads.internal.zza zzaVar) throws zzcfs {
        com.google.android.gms.ads.internal.zzv.zzB();
        zzcfg zza = zzcft.zza(context, zzchd.zza(), "", false, false, null, null, versionInfoParcel, null, null, null, zzbcc.zza(), null, null, null, null, null);
        this.zza = zza;
        zza.zzF().setWillNotDraw(true);
    }

    private static final void zzs(Runnable runnable) {
        com.google.android.gms.ads.internal.client.zzbb.zzb();
        if (com.google.android.gms.ads.internal.util.client.zzf.zzz()) {
            com.google.android.gms.ads.internal.util.zze.zza("runOnUiThread > the UI thread is the main thread, the runnable will be run now");
            runnable.run();
        } else {
            com.google.android.gms.ads.internal.util.zze.zza("runOnUiThread > the UI thread is not the main thread, the runnable will be added to the message queue");
            if (com.google.android.gms.ads.internal.util.zzs.zza.post(runnable)) {
                return;
            }
            com.google.android.gms.ads.internal.util.client.zzo.zzj("runOnUiThread > the runnable could not be placed to the message queue");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbnm
    public final void zza(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("invokeJavascript on adWebView from js");
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbnh
            @Override // java.lang.Runnable
            public final void run() {
                zzbnl.this.zza.zza(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbnm
    public final /* synthetic */ void zzb(String str, String str2) {
        zzbnb.zzc(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbnd
    public final void zzc() {
        this.zza.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzbna
    public final /* synthetic */ void zzd(String str, Map map) {
        zzbnb.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzbna
    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzbnb.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbnd
    public final void zzf(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("loadHtml on adWebView from html");
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbni
            @Override // java.lang.Runnable
            public final void run() {
                zzbnl.this.zza.loadData(str, "text/html", "UTF-8");
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbnd
    public final void zzg(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("loadHtmlWrapper on adWebView from path: ".concat(String.valueOf(str)));
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbnf
            @Override // java.lang.Runnable
            public final void run() {
                zzbnl.this.zza.loadUrl(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbnd
    public final void zzh(String str) {
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascript on adWebView from path: ".concat(String.valueOf(str)));
        final String format = String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str);
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbnj
            @Override // java.lang.Runnable
            public final void run() {
                zzbnl.this.zza.loadData(format, "text/html", "UTF-8");
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbnd
    public final boolean zzi() {
        return this.zza.zzaE();
    }

    @Override // com.google.android.gms.internal.ads.zzbnd
    public final zzbok zzj() {
        return new zzbok(this);
    }

    @Override // com.google.android.gms.internal.ads.zzbnd
    public final void zzk(final zzbno zzbnoVar) {
        zzcgy zzN = this.zza.zzN();
        Objects.requireNonNull(zzbnoVar);
        zzN.zzK(new zzcgx() { // from class: com.google.android.gms.internal.ads.zzbng
            @Override // com.google.android.gms.internal.ads.zzcgx
            public final void zza() {
                long currentTimeMillis = com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis();
                zzbno zzbnoVar2 = zzbno.this;
                final long j = zzbnoVar2.zzc;
                final ArrayList arrayList = zzbnoVar2.zzb;
                arrayList.add(Long.valueOf(currentTimeMillis - j));
                com.google.android.gms.ads.internal.util.zze.zza("LoadNewJavascriptEngine(onEngLoaded) latency is " + String.valueOf(arrayList.get(0)) + " ms.");
                zzfrw zzfrwVar = com.google.android.gms.ads.internal.util.zzs.zza;
                final zzboi zzboiVar = zzbnoVar2.zza;
                final zzboh zzbohVar = zzbnoVar2.zzd;
                final zzbnd zzbndVar = zzbnoVar2.zze;
                zzfrwVar.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbnp
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzboi.zzi(zzboi.this, zzbohVar, zzbndVar, arrayList, j);
                    }
                }, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzc)).intValue());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbnm
    public final /* synthetic */ void zzp(String str, JSONObject jSONObject) {
        zzbnb.zzd(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzboj
    public final void zzq(String str, zzbkf zzbkfVar) {
        this.zza.zzag(str, new zzbnk(this, zzbkfVar));
    }

    @Override // com.google.android.gms.internal.ads.zzboj
    public final void zzr(String str, final zzbkf zzbkfVar) {
        this.zza.zzaA(str, new Predicate() { // from class: com.google.android.gms.internal.ads.zzbne
            @Override // com.google.android.gms.common.util.Predicate
            public final boolean apply(Object obj) {
                zzbkf zzbkfVar2;
                zzbkf zzbkfVar3 = (zzbkf) obj;
                if (!(zzbkfVar3 instanceof zzbnk)) {
                    return false;
                }
                zzbkf zzbkfVar4 = zzbkf.this;
                zzbkfVar2 = ((zzbnk) zzbkfVar3).zzb;
                return zzbkfVar2.equals(zzbkfVar4);
            }
        });
    }
}
