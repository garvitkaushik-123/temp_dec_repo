package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.internal.client.zzey;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.preload.PreloadCallback;
import com.google.android.gms.ads.preload.PreloadConfiguration;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbuh;
import com.google.android.gms.internal.ads.zzbza;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public class MobileAds {
    public static final String ERROR_DOMAIN = "com.google.android.gms.ads";

    private MobileAds() {
    }

    public static void disableMediationAdapterInitialization(Context context) {
        zzey.zzf().zzp(context);
    }

    public static InitializationStatus getInitializationStatus() {
        return zzey.zzf().zze();
    }

    private static String getInternalVersion() {
        return zzey.zzf().zzj();
    }

    public static RequestConfiguration getRequestConfiguration() {
        return zzey.zzf().zzc();
    }

    public static VersionInfo getVersion() {
        zzey.zzf();
        String[] split = TextUtils.split("24.5.0", "\\.");
        if (split.length != 3) {
            return new VersionInfo(0, 0, 0);
        }
        try {
            return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        } catch (NumberFormatException unused) {
            return new VersionInfo(0, 0, 0);
        }
    }

    public static void initialize(Context context) {
        zzey.zzf().zzq(context, null, null);
    }

    public static void openAdInspector(Context context, OnAdInspectorClosedListener onAdInspectorClosedListener) {
        zzey.zzf().zzr(context, onAdInspectorClosedListener);
    }

    public static void openDebugMenu(Context context, String str) {
        zzey.zzf().zzs(context, str);
    }

    public static boolean putPublisherFirstPartyIdEnabled(boolean z) {
        return zzey.zzf().zzz(z);
    }

    public static CustomTabsSession registerCustomTabsSession(Context context, CustomTabsClient customTabsClient, String str, CustomTabsCallback customTabsCallback) {
        zzey.zzf();
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbza zza = zzbuh.zza(context);
        if (zza == null) {
            zzo.zzg("Internal error, query info generator is null.");
            return null;
        }
        try {
            return (CustomTabsSession) ObjectWrapper.unwrap(zza.zze(ObjectWrapper.wrap(context), ObjectWrapper.wrap(customTabsClient), str, ObjectWrapper.wrap(customTabsCallback)));
        } catch (RemoteException | IllegalArgumentException e) {
            zzo.zzh("Unable to register custom tabs session. Error: ", e);
            return null;
        }
    }

    public static void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        zzey.zzf().zzt(cls);
    }

    public static void registerWebView(WebView webView) {
        zzey.zzf();
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (webView == null) {
            zzo.zzg("The webview to be registered cannot be null.");
            return;
        }
        zzbza zza = zzbuh.zza(webView.getContext());
        if (zza == null) {
            zzo.zzg("Internal error, query info generator is null.");
            return;
        }
        try {
            zza.zzj(ObjectWrapper.wrap(webView));
        } catch (RemoteException e) {
            zzo.zzh("", e);
        }
    }

    public static void setAppMuted(boolean z) {
        zzey.zzf().zzu(z);
    }

    public static void setAppVolume(float f) {
        zzey.zzf().zzv(f);
    }

    private static void setPlugin(String str) {
        zzey.zzf().zzw(str);
    }

    public static void setRequestConfiguration(RequestConfiguration requestConfiguration) {
        zzey.zzf().zzx(requestConfiguration);
    }

    @Deprecated
    public static void startPreload(Context context, List<PreloadConfiguration> list, PreloadCallback preloadCallback) {
        zzey.zzf().zzh(context, list, preloadCallback);
    }

    public static void initialize(Context context, OnInitializationCompleteListener onInitializationCompleteListener) {
        zzey.zzf().zzq(context, null, onInitializationCompleteListener);
    }
}
