package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.Iterator;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes5.dex */
public final class zzbac extends Thread {
    private boolean zza;
    private boolean zzb;
    private final Object zzc;
    private final zzazt zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final String zzm;
    private final boolean zzn;
    private final boolean zzo;

    public zzbac() {
        zzazt zzaztVar = new zzazt();
        this.zza = false;
        this.zzb = false;
        this.zzd = zzaztVar;
        this.zzc = new Object();
        this.zzf = ((Long) zzbev.zzd.zze()).intValue();
        this.zzg = ((Long) zzbev.zza.zze()).intValue();
        this.zzh = ((Long) zzbev.zze.zze()).intValue();
        this.zzi = ((Long) zzbev.zzc.zze()).intValue();
        this.zzj = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzak)).intValue();
        this.zzk = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzal)).intValue();
        this.zzl = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzam)).intValue();
        this.zze = ((Long) zzbev.zzf.zze()).intValue();
        this.zzm = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzao);
        this.zzn = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzap)).booleanValue();
        this.zzo = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaq)).booleanValue();
        ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzar)).booleanValue();
        setName("ContentFetchTask");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0042, code lost:
    
        if (r3.importance != 100) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0048, code lost:
    
        if (r2.inKeyguardRestrictedInputMode() != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004a, code lost:
    
        r0 = (android.os.PowerManager) r0.getSystemService("power");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0052, code lost:
    
        if (r0 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0058, code lost:
    
        if (r0.isScreenOn() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x005a, code lost:
    
        r0 = com.google.android.gms.ads.internal.zzv.zzb().zza();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0062, code lost:
    
        if (r0 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0064, code lost:
    
        r1 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zze("ContentFetchThread: no activity. Sleeping.");
        zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x006f, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0074, code lost:
    
        if (r0.getWindow() == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x007e, code lost:
    
        if (r0.getWindow().getDecorView() == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0080, code lost:
    
        r1 = r0.getWindow().getDecorView().findViewById(android.R.id.content);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0090, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0091, code lost:
    
        com.google.android.gms.ads.internal.zzv.zzp().zzw(r0, "ContentFetchTask.extractContent");
        r2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Failed getting root view of activity. Content not extracted.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00db, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00dc, code lost:
    
        r1 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh("Error in ContentFetchTask", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c9, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ca, code lost:
    
        r1 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh("Error in ContentFetchTask", r0);
        com.google.android.gms.ads.internal.zzv.zzp().zzw(r0, "ContentFetchTask.run");
     */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00e6 A[EXC_TOP_SPLITTER, LOOP:1: B:9:0x00e6->B:16:0x00e6, LOOP_START, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Object obj;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        View view;
        while (true) {
            try {
                Context zzb = com.google.android.gms.ads.internal.zzv.zzb().zzb();
                if (zzb != null) {
                    ActivityManager activityManager = (ActivityManager) zzb.getSystemService("activity");
                    KeyguardManager keyguardManager = (KeyguardManager) zzb.getSystemService("keyguard");
                    if (activityManager != null && keyguardManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ActivityManager.RunningAppProcessInfo next = it.next();
                            if (Process.myPid() == next.pid) {
                                break;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "ContentFetchTask.isInForeground");
            }
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("ContentFetchTask: sleeping");
            zze();
            Thread.sleep(this.zze * 1000);
            obj = this.zzc;
            synchronized (obj) {
                while (this.zzb) {
                    try {
                        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zze("ContentFetchTask: waiting");
                        obj.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
        if (view != null) {
            view.post(new zzazy(this, view));
        }
        Thread.sleep(this.zze * 1000);
        obj = this.zzc;
        synchronized (obj) {
        }
    }

    final zzbab zza(View view, zzazs zzazsVar) {
        if (view == null) {
            return new zzbab(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzbab(this, 0, 0);
            }
            zzazsVar.zzh(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
            return new zzbab(this, 1, 0);
        }
        if ((view instanceof WebView) && !(view instanceof zzcfg)) {
            WebView webView = (WebView) view;
            if (!PlatformVersion.isAtLeastKitKat()) {
                return new zzbab(this, 0, 0);
            }
            zzazsVar.zzf();
            webView.post(new zzbaa(this, zzazsVar, webView, globalVisibleRect));
            return new zzbab(this, 0, 1);
        }
        if (!(view instanceof ViewGroup)) {
            return new zzbab(this, 0, 0);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            zzbab zza = zza(viewGroup.getChildAt(i3), zzazsVar);
            i += zza.zza;
            i2 += zza.zzb;
        }
        return new zzbab(this, i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0069, code lost:
    
        if (r10 == 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzb(View view) {
        try {
            zzazs zzazsVar = new zzazs(this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzo);
            Context zzb = com.google.android.gms.ads.internal.zzv.zzb().zzb();
            if (zzb != null) {
                String str = this.zzm;
                if (!TextUtils.isEmpty(str)) {
                    String str2 = (String) view.getTag(zzb.getResources().getIdentifier((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzan), "id", zzb.getPackageName()));
                    if (str2 != null && str2.equals(str)) {
                        return;
                    }
                }
            }
            zzbab zza = zza(view, zzazsVar);
            zzazsVar.zzj();
            if (zza.zza == 0 && zza.zzb == 0) {
                return;
            }
            int i = zza.zzb;
            if (i == 0) {
                if (zzazsVar.zzb() == 0) {
                    return;
                }
            }
            if (this.zzd.zzc(zzazsVar)) {
                return;
            }
            this.zzd.zza(zzazsVar);
        } catch (Exception e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Exception in fetchContentOnUIThread", e);
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "ContentFetchTask.fetchContent");
        }
    }

    final void zzc(zzazs zzazsVar, WebView webView, String str, boolean z) {
        zzazs zzazsVar2;
        zzazsVar.zze();
        try {
            if (TextUtils.isEmpty(str)) {
                zzazsVar2 = zzazsVar;
            } else {
                String optString = new JSONObject(str).optString("text");
                if (this.zzn || TextUtils.isEmpty(webView.getTitle())) {
                    zzazsVar2 = zzazsVar;
                    zzazsVar2.zzi(optString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    zzazsVar.zzi(webView.getTitle() + "\n" + optString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                    zzazsVar2 = zzazsVar;
                }
            }
            if (zzazsVar2.zzl()) {
                this.zzd.zzb(zzazsVar2);
            }
        } catch (JSONException unused) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Json string may be malformed.");
        } catch (Throwable th) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to get webview content.", th);
            com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final void zzd() {
        synchronized (this.zzc) {
            if (this.zza) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Content hash thread already started, quitting...");
            } else {
                this.zza = true;
                start();
            }
        }
    }

    public final void zze() {
        synchronized (this.zzc) {
            this.zzb = true;
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("ContentFetchThread: paused, pause = true");
        }
    }
}
