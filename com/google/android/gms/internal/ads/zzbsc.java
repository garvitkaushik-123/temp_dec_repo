package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbsc extends zzbro {
    private final RtbAdapter zza;
    private MediationInterstitialAd zzb;
    private MediationRewardedAd zzc;
    private MediationAppOpenAd zzd;
    private String zze = "";

    public zzbsc(RtbAdapter rtbAdapter) {
        this.zza = rtbAdapter;
    }

    private final Bundle zzv(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        Bundle bundle;
        Bundle bundle2 = zzmVar.zzm;
        return (bundle2 == null || (bundle = bundle2.getBundle(this.zza.getClass().getName())) == null) ? new Bundle() : bundle;
    }

    private static final Bundle zzw(String str) throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Server parameters: ".concat(String.valueOf(str)));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            throw new RemoteException();
        }
    }

    private static final boolean zzx(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        if (zzmVar.zzf) {
            return true;
        }
        com.google.android.gms.ads.internal.client.zzbb.zzb();
        return com.google.android.gms.ads.internal.util.client.zzf.zzw();
    }

    private static final String zzy(String str, com.google.android.gms.ads.internal.client.zzm zzmVar) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zzmVar.zzu;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final com.google.android.gms.ads.internal.client.zzed zze() {
        MediationExtrasReceiver mediationExtrasReceiver = this.zza;
        if (mediationExtrasReceiver instanceof com.google.android.gms.ads.mediation.zza) {
            try {
                return ((com.google.android.gms.ads.mediation.zza) mediationExtrasReceiver).getVideoController();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", th);
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final zzbse zzf() throws RemoteException {
        return zzbse.zza(this.zza.getVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final zzbse zzg() throws RemoteException {
        return zzbse.zza(this.zza.getSDKVersionInfo());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, com.google.android.gms.ads.internal.client.zzr zzrVar, zzbrs zzbrsVar) throws RemoteException {
        char c;
        AdFormat adFormat;
        try {
            zzbsa zzbsaVar = new zzbsa(this, zzbrsVar);
            RtbAdapter rtbAdapter = this.zza;
            switch (str.hashCode()) {
                case -1396342996:
                    if (str.equals("banner")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1052618729:
                    if (str.equals("native")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -239580146:
                    if (str.equals("rewarded")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 604727084:
                    if (str.equals("interstitial")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1167692200:
                    if (str.equals(FirebaseAnalytics.Event.APP_OPEN)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1778294298:
                    if (str.equals("app_open_ad")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1911491517:
                    if (str.equals("rewarded_interstitial")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    adFormat = AdFormat.BANNER;
                    MediationConfiguration mediationConfiguration = new MediationConfiguration(adFormat, bundle2);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(mediationConfiguration);
                    rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.unwrap(iObjectWrapper), arrayList, bundle, com.google.android.gms.ads.zzc.zzc(zzrVar.zze, zzrVar.zzb, zzrVar.zza)), zzbsaVar);
                    return;
                case 1:
                    adFormat = AdFormat.INTERSTITIAL;
                    MediationConfiguration mediationConfiguration2 = new MediationConfiguration(adFormat, bundle2);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(mediationConfiguration2);
                    rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.unwrap(iObjectWrapper), arrayList2, bundle, com.google.android.gms.ads.zzc.zzc(zzrVar.zze, zzrVar.zzb, zzrVar.zza)), zzbsaVar);
                    return;
                case 2:
                    adFormat = AdFormat.REWARDED;
                    MediationConfiguration mediationConfiguration22 = new MediationConfiguration(adFormat, bundle2);
                    ArrayList arrayList22 = new ArrayList();
                    arrayList22.add(mediationConfiguration22);
                    rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.unwrap(iObjectWrapper), arrayList22, bundle, com.google.android.gms.ads.zzc.zzc(zzrVar.zze, zzrVar.zzb, zzrVar.zza)), zzbsaVar);
                    return;
                case 3:
                    adFormat = AdFormat.REWARDED_INTERSTITIAL;
                    MediationConfiguration mediationConfiguration222 = new MediationConfiguration(adFormat, bundle2);
                    ArrayList arrayList222 = new ArrayList();
                    arrayList222.add(mediationConfiguration222);
                    rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.unwrap(iObjectWrapper), arrayList222, bundle, com.google.android.gms.ads.zzc.zzc(zzrVar.zze, zzrVar.zzb, zzrVar.zza)), zzbsaVar);
                    return;
                case 4:
                    adFormat = AdFormat.NATIVE;
                    MediationConfiguration mediationConfiguration2222 = new MediationConfiguration(adFormat, bundle2);
                    ArrayList arrayList2222 = new ArrayList();
                    arrayList2222.add(mediationConfiguration2222);
                    rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.unwrap(iObjectWrapper), arrayList2222, bundle, com.google.android.gms.ads.zzc.zzc(zzrVar.zze, zzrVar.zzb, zzrVar.zza)), zzbsaVar);
                    return;
                case 5:
                    adFormat = AdFormat.APP_OPEN_AD;
                    MediationConfiguration mediationConfiguration22222 = new MediationConfiguration(adFormat, bundle2);
                    ArrayList arrayList22222 = new ArrayList();
                    arrayList22222.add(mediationConfiguration22222);
                    rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.unwrap(iObjectWrapper), arrayList22222, bundle, com.google.android.gms.ads.zzc.zzc(zzrVar.zze, zzrVar.zzb, zzrVar.zza)), zzbsaVar);
                    return;
                case 6:
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmm)).booleanValue()) {
                        adFormat = AdFormat.APP_OPEN_AD;
                        MediationConfiguration mediationConfiguration222222 = new MediationConfiguration(adFormat, bundle2);
                        ArrayList arrayList222222 = new ArrayList();
                        arrayList222222.add(mediationConfiguration222222);
                        rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.unwrap(iObjectWrapper), arrayList222222, bundle, com.google.android.gms.ads.zzc.zzc(zzrVar.zze, zzrVar.zzb, zzrVar.zza)), zzbsaVar);
                        return;
                    }
                default:
                    throw new IllegalArgumentException("Internal Error");
            }
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error generating signals for RTB", th);
            zzbpn.zza(iObjectWrapper, th, "adapter.collectSignals");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzi(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbra zzbraVar, zzbpw zzbpwVar) throws RemoteException {
        try {
            this.zza.loadRtbAppOpenAd(new MediationAppOpenAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzmVar), zzx(zzmVar), zzmVar.zzk, zzmVar.zzg, zzmVar.zzt, zzy(str2, zzmVar), this.zze), new zzbrz(this, zzbraVar, zzbpwVar));
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Adapter failed to render app open ad.", th);
            zzbpn.zza(iObjectWrapper, th, "adapter.loadRtbAppOpenAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzj(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrd zzbrdVar, zzbpw zzbpwVar, com.google.android.gms.ads.internal.client.zzr zzrVar) throws RemoteException {
        try {
            this.zza.loadRtbBannerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzmVar), zzx(zzmVar), zzmVar.zzk, zzmVar.zzg, zzmVar.zzt, zzy(str2, zzmVar), com.google.android.gms.ads.zzc.zzc(zzrVar.zze, zzrVar.zzb, zzrVar.zza), this.zze), new zzbru(this, zzbrdVar, zzbpwVar));
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Adapter failed to render banner ad.", th);
            zzbpn.zza(iObjectWrapper, th, "adapter.loadRtbBannerAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzk(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrd zzbrdVar, zzbpw zzbpwVar, com.google.android.gms.ads.internal.client.zzr zzrVar) throws RemoteException {
        try {
            zzbrv zzbrvVar = new zzbrv(this, zzbrdVar, zzbpwVar);
            RtbAdapter rtbAdapter = this.zza;
            zzw(str2);
            zzv(zzmVar);
            zzx(zzmVar);
            Location location = zzmVar.zzk;
            int i = zzmVar.zzg;
            int i2 = zzmVar.zzt;
            zzy(str2, zzmVar);
            com.google.android.gms.ads.zzc.zzc(zzrVar.zze, zzrVar.zzb, zzrVar.zza);
            zzbrvVar.onFailure(new AdError(7, String.valueOf(rtbAdapter.getClass().getSimpleName()).concat(" does not support interscroller ads."), MobileAds.ERROR_DOMAIN));
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Adapter failed to render interscroller ad.", th);
            zzbpn.zza(iObjectWrapper, th, "adapter.loadRtbInterscrollerAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzl(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrg zzbrgVar, zzbpw zzbpwVar) throws RemoteException {
        try {
            this.zza.loadRtbInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzmVar), zzx(zzmVar), zzmVar.zzk, zzmVar.zzg, zzmVar.zzt, zzy(str2, zzmVar), this.zze), new zzbrw(this, zzbrgVar, zzbpwVar));
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Adapter failed to render interstitial ad.", th);
            zzbpn.zza(iObjectWrapper, th, "adapter.loadRtbInterstitialAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzm(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrj zzbrjVar, zzbpw zzbpwVar) throws RemoteException {
        zzn(str, str2, zzmVar, iObjectWrapper, zzbrjVar, zzbpwVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzn(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrj zzbrjVar, zzbpw zzbpwVar, zzbge zzbgeVar) throws RemoteException {
        try {
            this.zza.loadRtbNativeAdMapper(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzmVar), zzx(zzmVar), zzmVar.zzk, zzmVar.zzg, zzmVar.zzt, zzy(str2, zzmVar), this.zze, zzbgeVar), new zzbrx(this, zzbrjVar, zzbpwVar));
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Adapter failed to render native ad.", th);
            zzbpn.zza(iObjectWrapper, th, "adapter.loadRtbNativeAdMapper");
            String message = th.getMessage();
            if (TextUtils.isEmpty(message) || !message.equals("Method is not found")) {
                throw new RemoteException();
            }
            try {
                this.zza.loadRtbNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzmVar), zzx(zzmVar), zzmVar.zzk, zzmVar.zzg, zzmVar.zzt, zzy(str2, zzmVar), this.zze, zzbgeVar), new zzbry(this, zzbrjVar, zzbpwVar));
            } catch (Throwable th2) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Adapter failed to render native ad.", th2);
                zzbpn.zza(iObjectWrapper, th2, "adapter.loadRtbNativeAd");
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzo(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrm zzbrmVar, zzbpw zzbpwVar) throws RemoteException {
        try {
            this.zza.loadRtbRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzmVar), zzx(zzmVar), zzmVar.zzk, zzmVar.zzg, zzmVar.zzt, zzy(str2, zzmVar), this.zze), new zzbsb(this, zzbrmVar, zzbpwVar));
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Adapter failed to render rewarded interstitial ad.", th);
            zzbpn.zza(iObjectWrapper, th, "adapter.loadRtbRewardedInterstitialAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzp(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrm zzbrmVar, zzbpw zzbpwVar) throws RemoteException {
        try {
            this.zza.loadRtbRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzmVar), zzx(zzmVar), zzmVar.zzk, zzmVar.zzg, zzmVar.zzt, zzy(str2, zzmVar), this.zze), new zzbsb(this, zzbrmVar, zzbpwVar));
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Adapter failed to render rewarded ad.", th);
            zzbpn.zza(iObjectWrapper, th, "adapter.loadRtbRewardedAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzq(String str) {
        this.zze = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationAppOpenAd mediationAppOpenAd = this.zzd;
        if (mediationAppOpenAd == null) {
            return false;
        }
        try {
            mediationAppOpenAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", th);
            zzbpn.zza(iObjectWrapper, th, "adapter.showRtbAppOpenAd");
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationInterstitialAd mediationInterstitialAd = this.zzb;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", th);
            zzbpn.zza(iObjectWrapper, th, "adapter.showRtbInterstitialAd");
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationRewardedAd mediationRewardedAd = this.zzc;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", th);
            zzbpn.zza(iObjectWrapper, th, "adapter.showRtbRewardedAd");
            return true;
        }
    }
}
