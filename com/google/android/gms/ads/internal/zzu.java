package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbk;
import com.google.android.gms.ads.internal.client.zzbn;
import com.google.android.gms.ads.internal.client.zzbw;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zzco;
import com.google.android.gms.ads.internal.client.zzcs;
import com.google.android.gms.ads.internal.client.zzcv;
import com.google.android.gms.ads.internal.client.zzdt;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.ads.internal.client.zzed;
import com.google.android.gms.ads.internal.client.zzeh;
import com.google.android.gms.ads.internal.client.zzgc;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzavu;
import com.google.android.gms.internal.ads.zzavv;
import com.google.android.gms.internal.ads.zzbaz;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbeq;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzbuc;
import com.google.android.gms.internal.ads.zzbwi;
import com.google.android.gms.internal.ads.zzcaf;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzu extends zzbw {
    private final VersionInfoParcel zza;
    private final com.google.android.gms.ads.internal.client.zzr zzb;
    private final Future zzc = zzcaf.zza.zzb(new zzq(this));
    private final Context zzd;
    private final zzs zze;
    private WebView zzf;
    private zzbk zzg;
    private zzavu zzh;
    private AsyncTask zzi;

    public zzu(Context context, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, VersionInfoParcel versionInfoParcel) {
        this.zzd = context;
        this.zza = versionInfoParcel;
        this.zzb = zzrVar;
        this.zzf = new WebView(context);
        this.zze = new zzs(context, str);
        zzX(0);
        this.zzf.setVerticalScrollBarEnabled(false);
        this.zzf.getSettings().setJavaScriptEnabled(true);
        this.zzf.setWebViewClient(new zzo(this));
        this.zzf.setOnTouchListener(new zzp(this));
    }

    static /* bridge */ /* synthetic */ String zzp(zzu zzuVar, String str) {
        if (zzuVar.zzh == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = zzuVar.zzh.zza(parse, zzuVar.zzd, null, null);
        } catch (zzavv e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Unable to process ad data", e);
        }
        return parse.toString();
    }

    static /* bridge */ /* synthetic */ void zzx(zzu zzuVar, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        zzuVar.zzd.startActivity(intent);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzA() throws RemoteException {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzB() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzC() throws RemoteException {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzD(zzbh zzbhVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzE(zzbk zzbkVar) throws RemoteException {
        this.zzg = zzbkVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzF(zzcb zzcbVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzG(com.google.android.gms.ads.internal.client.zzr zzrVar) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzH(zzco zzcoVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzI(zzbaz zzbazVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzJ(zzx zzxVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzK(zzcv zzcvVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzL(zzeh zzehVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzM(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzN(zzbtz zzbtzVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzO(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzP(zzbdz zzbdzVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzQ(zzdt zzdtVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzR(long j) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzS(zzbuc zzbucVar, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzT(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzU(zzbwi zzbwiVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzV(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzW(zzgc zzgcVar) {
        throw new IllegalStateException("Unused method");
    }

    final void zzX(int i) {
        if (this.zzf == null) {
            return;
        }
        this.zzf.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzY(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzZ() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzaa() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzab() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzac() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzad(com.google.android.gms.ads.internal.client.zzm zzmVar) throws RemoteException {
        Preconditions.checkNotNull(this.zzf, "This Search Ad has already been torn down");
        this.zze.zzf(zzmVar, this.zza);
        this.zzi = new zzr(this, null).execute(new Void[0]);
        return true;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzae(zzcs zzcsVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    final int zzb(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzbb.zzb();
            return com.google.android.gms.ads.internal.util.client.zzf.zzC(this.zzd, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final long zzc() {
        return 0L;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final Bundle zze() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzr zzh() throws RemoteException {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzbk zzj() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzco zzk() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzea zzl() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzed zzm() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final IObjectWrapper zzo() throws RemoteException {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzf);
    }

    final String zzq() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath((String) zzbeq.zzd.zze());
        zzs zzsVar = this.zze;
        builder.appendQueryParameter("query", zzsVar.zzd());
        builder.appendQueryParameter("pubId", zzsVar.zzc());
        builder.appendQueryParameter("mappver", zzsVar.zza());
        Map zze = zzsVar.zze();
        for (String str : zze.keySet()) {
            builder.appendQueryParameter(str, (String) zze.get(str));
        }
        Uri build = builder.build();
        zzavu zzavuVar = this.zzh;
        if (zzavuVar != null) {
            try {
                build = zzavuVar.zzb(build, this.zzd);
            } catch (zzavv e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Unable to process ad data", e);
            }
        }
        return zzr() + "#" + build.getEncodedQuery();
    }

    final String zzr() {
        String zzb = this.zze.zzb();
        if (true == TextUtils.isEmpty(zzb)) {
            zzb = "www.google.com";
        }
        return "https://" + zzb + ((String) zzbeq.zzd.zze());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String zzs() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String zzt() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String zzu() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzy() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzi.cancel(true);
        this.zzc.cancel(false);
        this.zzf.destroy();
        this.zzf = null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzz(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbn zzbnVar) {
    }
}
