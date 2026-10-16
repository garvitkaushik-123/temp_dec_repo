package com.google.android.gms.ads.internal.util;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.SharedPreferencesUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbwa;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcex;
import com.google.android.gms.internal.ads.zzcgj;
import com.google.android.gms.internal.ads.zzchc;
import com.google.android.gms.internal.ads.zzdpm;
import com.google.android.gms.internal.ads.zzdsi;
import com.google.android.gms.internal.ads.zzdsj;
import com.google.android.gms.internal.ads.zzfca;
import com.google.android.gms.internal.ads.zzfcd;
import com.google.android.gms.internal.ads.zzfrw;
import com.google.android.gms.internal.ads.zzfva;
import com.google.android.gms.internal.ads.zzfwe;
import com.google.android.gms.internal.ads.zzfwg;
import com.google.android.gms.internal.ads.zzgdn;
import com.google.android.gms.internal.ads.zzhhh;
import com.google.common.net.HttpHeaders;
import com.google.common.util.concurrent.ListenableFuture;
import com.ironsource.C3040d4;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzs {
    public static final zzfrw zza = new zzf(Looper.getMainLooper());
    private String zzh;
    private volatile String zzi;
    private final AtomicReference zzb = new AtomicReference(null);
    private final AtomicReference zzc = new AtomicReference(null);
    private final AtomicReference zzd = new AtomicReference(new Bundle());
    private final AtomicBoolean zze = new AtomicBoolean();
    private boolean zzf = true;
    private final Object zzg = new Object();
    private boolean zzj = false;
    private boolean zzk = false;
    private final Executor zzl = Executors.newSingleThreadExecutor();

    public static final zzbr zzA(Context context) {
        try {
            Object newInstance = context.getClassLoader().loadClass("com.google.android.gms.ads.internal.util.WorkManagerUtil").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                int i = zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Instantiated WorkManagerUtil not instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
            return queryLocalInterface instanceof zzbr ? (zzbr) queryLocalInterface : new zzbp(iBinder);
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "Failed to instantiate WorkManagerUtil");
            return null;
        }
    }

    public static final boolean zzB(Context context, String str) {
        Context zza2 = zzbwa.zza(context);
        return Wrappers.packageManager(zza2).checkPermission(str, zza2.getPackageName()) == 0;
    }

    public static final boolean zzC(Context context) {
        try {
            return DeviceProperties.isBstar(context);
        } catch (NoSuchMethodError unused) {
            return false;
        }
    }

    public static final boolean zzD(String str) {
        if (!com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
            return false;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfv)).booleanValue()) {
            return false;
        }
        String str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfx);
        if (!str2.isEmpty()) {
            for (String str3 : str2.split(";")) {
                if (str3.equals(str)) {
                    return false;
                }
            }
        }
        String str4 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfw);
        if (str4.isEmpty()) {
            return true;
        }
        for (String str5 : str4.split(";")) {
            if (str5.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean zzE(Context context) {
        KeyguardManager zzZ;
        return (context == null || (zzZ = zzZ(context)) == null || !zzZ.isKeyguardLocked()) ? false : true;
    }

    public static final boolean zzF(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        } catch (Throwable th) {
            int i = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error loading class.", th);
            com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public static final boolean zzG() {
        int myUid = Process.myUid();
        return myUid == 0 || myUid == 1000;
    }

    public static final boolean zzH(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        PowerManager powerManager;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && (powerManager = (PowerManager) context.getSystemService("power")) != null) {
                        return !powerManager.isScreenOn();
                    }
                    return true;
                }
            }
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    public static final boolean zzI(Context context) {
        try {
            Bundle zzaa = zzaa(context);
            String string = zzaa.getString("com.google.android.gms.ads.INTEGRATION_MANAGER");
            if (TextUtils.isEmpty(zzab(zzaa))) {
                if (!TextUtils.isEmpty(string)) {
                    return true;
                }
            }
        } catch (RemoteException unused) {
        }
        return false;
    }

    public static final boolean zzJ(Context context) {
        Window window;
        if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null && window.getDecorView() != null) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            window.getDecorView().getGlobalVisibleRect(rect, null);
            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (rect.bottom != 0 && rect2.bottom != 0 && rect.top == rect2.top) {
                return true;
            }
        }
        return false;
    }

    public static final void zzK(View view, int i, MotionEvent motionEvent) {
        String str;
        int i2;
        int i3;
        int i4;
        String str2;
        zzfca zzD;
        zzfcd zzR;
        View view2 = view;
        int[] iArr = new int[2];
        Rect rect = new Rect();
        try {
            String packageName = view2.getContext().getPackageName();
            if (view2 instanceof zzdpm) {
                view2 = ((zzdpm) view2).getChildAt(0);
            }
            if ((view2 instanceof com.google.android.gms.ads.formats.zzj) || (view2 instanceof NativeAdView)) {
                str = "NATIVE";
                i2 = 1;
            } else {
                str = "UNKNOWN";
                i2 = 0;
            }
            if (view2.getLocalVisibleRect(rect)) {
                i4 = rect.width();
                i3 = rect.height();
            } else {
                i3 = 0;
                i4 = 0;
            }
            com.google.android.gms.ads.internal.zzv.zzr();
            long zzx = zzx(view2);
            view2.getLocationOnScreen(iArr);
            int i5 = iArr[0];
            int i6 = iArr[1];
            String str3 = "none";
            if (!(view2 instanceof zzcgj) || (zzR = ((zzcgj) view2).zzR()) == null) {
                str2 = "none";
            } else {
                str2 = zzR.zzb;
                view2.setContentDescription(str2 + ":" + view2.hashCode());
            }
            if ((view2 instanceof zzcex) && (zzD = ((zzcex) view2).zzD()) != null) {
                str = zzfca.zza(zzD.zzb);
                i2 = zzD.zze;
                str3 = zzD.zzE;
            }
            String format = String.format(Locale.US, "<Ad hashCode=%d, package=%s, adNetCls=%s, gwsQueryId=%s, format=%s, impType=%d, class=%s, x=%d, y=%d, width=%d, height=%d, vWidth=%d, vHeight=%d, alpha=%d, state=%s>", Integer.valueOf(view2.hashCode()), packageName, str3, str2, str, Integer.valueOf(i2), view2.getClass().getName(), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(view2.getWidth()), Integer.valueOf(view2.getHeight()), Integer.valueOf(i4), Integer.valueOf(i3), Long.valueOf(zzx), Integer.toString(i, 2));
            int i7 = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi(format);
        } catch (Exception e) {
            int i8 = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Failure getting view location.", e);
        }
    }

    public static final AlertDialog.Builder zzL(Context context) {
        com.google.android.gms.ads.internal.zzv.zzs();
        return new AlertDialog.Builder(context, R.style.Theme.Material.Dialog.Alert);
    }

    public static final void zzM(Context context, String str, String str2) {
        new zzbw(context, str, str2, null, null).zzb();
    }

    public static final void zzN(Context context, Throwable th) {
        if (context == null) {
            return;
        }
        try {
            if (((Boolean) zzbfn.zzb.zze()).booleanValue()) {
                CrashUtils.addDynamiteErrorToDropBox(context, th);
            }
        } catch (IllegalStateException unused) {
        }
    }

    public static final boolean zzO(zzfca zzfcaVar) {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznJ)).booleanValue() && zzfcaVar != null && zzfcaVar.zze == 4;
    }

    public static final int zzP(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String concat = "Could not parse value:".concat(e.toString());
            int i = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(concat);
            return 0;
        }
    }

    public static final Map zzQ(Uri uri) {
        String encodedQuery;
        if (uri == null) {
            return null;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzr)).booleanValue()) {
            HashMap hashMap = new HashMap();
            for (String str : uri.getQueryParameterNames()) {
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put(str, uri.getQueryParameter(str));
                }
            }
            return hashMap;
        }
        HashMap hashMap2 = new HashMap();
        if (!uri.isOpaque() && (encodedQuery = uri.getEncodedQuery()) != null) {
            int i = 0;
            while (true) {
                int indexOf = encodedQuery.indexOf(38, i);
                int length = encodedQuery.length();
                if (indexOf != -1) {
                    length = indexOf;
                }
                int indexOf2 = encodedQuery.indexOf(61, i);
                if (indexOf2 > length || indexOf2 == -1) {
                    indexOf2 = length;
                }
                hashMap2.put(Uri.decode(encodedQuery.substring(i, indexOf2)), indexOf2 == length ? "" : Uri.decode(encodedQuery.substring(indexOf2 + 1, length)));
                if (indexOf == -1) {
                    break;
                }
                i = indexOf + 1;
            }
        }
        return hashMap2;
    }

    public static final int[] zzR(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        return (window == null || (findViewById = window.findViewById(R.id.content)) == null) ? zzv() : new int[]{findViewById.getWidth(), findViewById.getHeight()};
    }

    public static final int[] zzS(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        int[] zzv = (window == null || (findViewById = window.findViewById(R.id.content)) == null) ? zzv() : new int[]{findViewById.getTop(), findViewById.getBottom()};
        return new int[]{com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(activity, zzv[0]), com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(activity, zzv[1])};
    }

    public static final boolean zzT(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z = com.google.android.gms.ads.internal.zzv.zzr().zzf || keyguardManager == null || !keyguardManager.inKeyguardRestrictedInputMode() || zzo(view);
        long zzx = zzx(view);
        if (view.getVisibility() != 0 || !view.isShown() || ((powerManager != null && !powerManager.isScreenOn()) || !z)) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzby)).booleanValue() && !view.getLocalVisibleRect(new Rect()) && !view.getGlobalVisibleRect(new Rect())) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkZ)).booleanValue()) {
            if (zzx < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlb)).intValue()) {
                return false;
            }
        }
        return true;
    }

    public static final void zzU(Context context, Intent intent) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlw)).booleanValue()) {
            zzae(context, intent);
            return;
        }
        try {
            zzae(context, intent);
        } catch (SecurityException e) {
            int i = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("", e);
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "AdUtil.startActivityWithUnknownContext");
        }
    }

    public static final void zzV(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            zzp(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String str = "Opening " + uri.toString() + " in a new browser.";
            int i = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze(str);
        } catch (ActivityNotFoundException e) {
            int i2 = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("No browser is found.", e);
        }
    }

    public static final int[] zzW(Activity activity) {
        int[] zzR = zzR(activity);
        return new int[]{com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(activity, zzR[0]), com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(activity, zzR[1])};
    }

    public static final boolean zzX(View view, Context context) {
        Context applicationContext = context.getApplicationContext();
        return zzT(view, applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null, zzZ(context));
    }

    public static final void zzY(Context context, Intent intent, zzdsj zzdsjVar, String str) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznx)).booleanValue() || !(context instanceof zzchc)) {
            zzU(context, intent);
            return;
        }
        try {
            Uri data = intent.getData();
            if (data != null && data.toString() != null) {
                if (data.toString().matches((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznz))) {
                    ((zzchc) context).zzc(intent, 236);
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzny)).booleanValue() || zzdsjVar == null) {
                        return;
                    }
                    zzdsi zza2 = zzdsjVar.zza();
                    zza2.zzb("action", "hila");
                    zza2.zzb("gqi", zzfwg.zzc(str));
                    zza2.zzi();
                    return;
                }
            }
            zzU(context, intent);
        } catch (ActivityNotFoundException e) {
            e = e;
            int i = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error occurred while starting activity for result", e);
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "AdUtil.startActivityForResult");
            zzU(context, intent);
        } catch (SecurityException e2) {
            e = e2;
            int i2 = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error occurred while starting activity for result", e);
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "AdUtil.startActivityForResult");
            zzU(context, intent);
        } catch (Exception e3) {
            int i3 = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error occurred while starting activity for result", e3);
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e3, "AdUtil.startActivityForResult");
            zzU(context, intent);
        }
    }

    private static KeyguardManager zzZ(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    public static int zza(int i) {
        if (i >= 5000) {
            return i;
        }
        if (i <= 0) {
            return 60000;
        }
        int i2 = zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("HTTP timeout too low: " + i + " milliseconds. Reverting to default timeout: 60000 milliseconds.");
        return 60000;
    }

    private static Bundle zzaa(Context context) throws RemoteException {
        try {
            return Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            zze.zzb("Error getting metadata", e);
            return null;
        }
    }

    private static String zzab(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
        return !TextUtils.isEmpty(string) ? (string.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$") || string.matches("^/\\d+~.+$")) ? string : "" : "";
    }

    private static boolean zzac(String str, AtomicReference atomicReference, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern pattern = (Pattern) atomicReference.get();
            if (pattern == null || !str2.equals(pattern.pattern())) {
                pattern = Pattern.compile(str2);
                atomicReference.set(pattern);
            }
            return pattern.matcher(str).matches();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    private static final void zzad(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private static final void zzae(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    private static final String zzaf(final Context context, String str) {
        String str2;
        String str3;
        if (str == null) {
            return zzr();
        }
        try {
            zzcg zza2 = zzcg.zza();
            if (TextUtils.isEmpty(zza2.zza)) {
                if (ClientLibraryUtils.isPackageSide()) {
                    str3 = (String) zzcd.zza(context, new Callable() { // from class: com.google.android.gms.ads.internal.util.zzce
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            Context context2 = context;
                            SharedPreferences sharedPreferences = context2.getSharedPreferences("admob_user_agent", 0);
                            String string = sharedPreferences.getString("user_agent", "");
                            if (!TextUtils.isEmpty(string)) {
                                zze.zza("User agent is already initialized on Google Play Services.");
                                return string;
                            }
                            zze.zza("User agent is not initialized on Google Play Services. Initializing.");
                            String defaultUserAgent = WebSettings.getDefaultUserAgent(context2);
                            SharedPreferencesUtils.publishWorldReadableSharedPreferences(context2, sharedPreferences.edit().putString("user_agent", defaultUserAgent), "admob_user_agent");
                            return defaultUserAgent;
                        }
                    });
                } else {
                    final Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                    str3 = (String) zzcd.zza(context, new Callable() { // from class: com.google.android.gms.ads.internal.util.zzcf
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            SharedPreferences sharedPreferences;
                            Context context2 = remoteContext;
                            Context context3 = context;
                            boolean z = false;
                            if (context2 != null) {
                                zze.zza("Attempting to read user agent from Google Play Services.");
                                sharedPreferences = context2.getSharedPreferences("admob_user_agent", 0);
                            } else {
                                zze.zza("Attempting to read user agent from local cache.");
                                sharedPreferences = context3.getSharedPreferences("admob_user_agent", 0);
                                z = true;
                            }
                            String string = sharedPreferences.getString("user_agent", "");
                            if (!TextUtils.isEmpty(string)) {
                                return string;
                            }
                            zze.zza("Reading user agent from WebSettings");
                            String defaultUserAgent = WebSettings.getDefaultUserAgent(context3);
                            if (z) {
                                sharedPreferences.edit().putString("user_agent", defaultUserAgent).apply();
                                zze.zza("Persisting user agent.");
                            }
                            return defaultUserAgent;
                        }
                    });
                }
                zza2.zza = str3;
            }
            str2 = zza2.zza;
        } catch (Exception unused) {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = WebSettings.getDefaultUserAgent(context);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = zzr();
        }
        String str4 = str2 + " (Mobile; " + str;
        try {
            if (Wrappers.packageManager(context).isCallerInstantApp()) {
                str4 = str4 + ";aia";
            }
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "AdUtil.getUserAgent");
        }
        return str4.concat(")");
    }

    public static List zzd() {
        zzbcv zzbcvVar = zzbde.zza;
        List zzb = com.google.android.gms.ads.internal.client.zzbd.zza().zzb();
        ArrayList arrayList = new ArrayList();
        Iterator it = zzb.iterator();
        while (it.hasNext()) {
            Iterator it2 = zzfwe.zzb(zzfva.zzc(AbstractJsonLexerKt.COMMA)).zzd((String) it.next()).iterator();
            while (it2.hasNext()) {
                try {
                    arrayList.add(Long.valueOf((String) it2.next()));
                } catch (NumberFormatException unused) {
                    zze.zza("Experiment ID is not a number");
                }
            }
        }
        return arrayList;
    }

    public static void zzh(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzcaf.zza.execute(runnable);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0016 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean zzo(View view) {
        Activity activity;
        View rootView = view.getRootView();
        if (rootView != null) {
            Context context = rootView.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
                if (activity != null) {
                    return false;
                }
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
                return (attributes == null || (attributes.flags & 524288) == 0) ? false : true;
            }
        }
        activity = null;
        if (activity != null) {
        }
    }

    public static final void zzp(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
        extras.putBinder(CustomTabsIntent.EXTRA_SESSION, null);
        extras.putString("com.android.browser.application_id", context.getPackageName());
        intent.putExtras(extras);
    }

    public static final String zzq(Context context) throws RemoteException {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        return zzab(zzaa(context));
    }

    static final String zzr() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        if (Build.VERSION.RELEASE != null) {
            sb.append(" ");
            sb.append(Build.VERSION.RELEASE);
        }
        sb.append("; ");
        sb.append(Locale.getDefault());
        if (Build.DEVICE != null) {
            sb.append("; ");
            sb.append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                sb.append(" Build/");
                sb.append(Build.DISPLAY);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }

    public static final String zzs() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        return str + " " + str2;
    }

    public static final Integer zzt(Context context) {
        Object systemService = context.getSystemService("display");
        if (systemService instanceof DisplayManager) {
            return Integer.valueOf(((DisplayManager) systemService).getDisplays().length);
        }
        return null;
    }

    public static final DisplayMetrics zzu(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    protected static final int[] zzv() {
        return new int[]{0, 0};
    }

    public static final Map zzw(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                HashSet hashSet = new HashSet();
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String optString = optJSONArray.optString(i);
                        if (optString != null) {
                            hashSet.add(optString);
                        }
                    }
                    hashMap.put(next, hashSet);
                }
            }
            return hashMap;
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "AdUtil.getMapOfFileNamesToKeysFromJsonString");
            return hashMap;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.view.ViewParent] */
    public static final long zzx(View view) {
        float f = Float.MAX_VALUE;
        do {
            if (!(view instanceof View)) {
                break;
            }
            View view2 = (View) view;
            f = Math.min(f, view2.getAlpha());
            view = view2.getParent();
        } while (f > 0.0f);
        return Math.round((f >= 0.0f ? f : 0.0f) * 100.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final WebResourceResponse zzy(Context context, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", com.google.android.gms.ads.internal.zzv.zzr().zzc(context, str));
            hashMap.put(HttpHeaders.CACHE_CONTROL, "max-stale=3600");
            String str3 = (String) new zzbo(context).zzb(0, str2, hashMap, null).get(60L, TimeUnit.SECONDS);
            if (str3 != null) {
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
            }
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            int i = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Could not fetch MRAID JS.", e);
        }
        return null;
    }

    public static final String zzz() {
        Resources zze = com.google.android.gms.ads.internal.zzv.zzp().zze();
        return zze != null ? zze.getString(com.google.android.gms.ads.impl.R.string.s7) : "Test Ad";
    }

    public final ListenableFuture zzb(final Uri uri) {
        return zzgdn.zzj(new Callable() { // from class: com.google.android.gms.ads.internal.util.zzn
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzfrw zzfrwVar = zzs.zza;
                com.google.android.gms.ads.internal.zzv.zzr();
                return zzs.zzQ(uri);
            }
        }, this.zzl);
    }

    public final String zzc(Context context, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlI)).booleanValue()) {
            if (this.zzi != null) {
                return this.zzi;
            }
            this.zzi = zzaf(context, str);
            return this.zzi;
        }
        synchronized (this.zzg) {
            String str2 = this.zzh;
            if (str2 != null) {
                return str2;
            }
            String zzaf = zzaf(context, str);
            this.zzh = zzaf;
            return zzaf;
        }
    }

    public final void zzg(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2, int i) {
        int zza2 = zza(i);
        int i2 = zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("HTTP timeout: " + zza2 + " milliseconds.");
        httpURLConnection.setConnectTimeout(zza2);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(zza2);
        if (TextUtils.isEmpty(httpURLConnection.getRequestProperty("User-Agent"))) {
            httpURLConnection.setRequestProperty("User-Agent", zzc(context, str));
        }
        httpURLConnection.setUseCaches(false);
    }

    public final void zzi(final Context context, final String str, String str2, Bundle bundle, boolean z) {
        com.google.android.gms.ads.internal.zzv.zzr();
        bundle.putString(C3040d4.h.G, zzs());
        zzbcv zzbcvVar = zzbde.zza;
        bundle.putString("eids", TextUtils.join(",", com.google.android.gms.ads.internal.client.zzbd.zza().zza()));
        if (bundle.isEmpty()) {
            int i = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Empty or null bundle.");
        } else {
            final String str3 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkX);
            if (!this.zze.getAndSet(true)) {
                this.zzd.set(zzad.zza(context, str3, new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.ads.internal.util.zzm
                    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str4) {
                        zzs.this.zzd.set(zzad.zzb(context, str3));
                    }
                }));
            }
            bundle.putAll((Bundle) this.zzd.get());
        }
        com.google.android.gms.ads.internal.client.zzbb.zzb();
        com.google.android.gms.ads.internal.util.client.zzf.zzB(context, str, "gmob-apps", bundle, true, new com.google.android.gms.ads.internal.util.client.zze() { // from class: com.google.android.gms.ads.internal.util.zzl
            @Override // com.google.android.gms.ads.internal.util.client.zze
            public final com.google.android.gms.ads.internal.util.client.zzt zza(String str4) {
                zzfrw zzfrwVar = zzs.zza;
                com.google.android.gms.ads.internal.zzv.zzr();
                zzs.zzM(context, str, str4);
                return com.google.android.gms.ads.internal.util.client.zzt.SUCCESS;
            }
        });
    }

    public final boolean zzj(String str) {
        return zzac(str, this.zzb, (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzau));
    }

    public final boolean zzk(String str) {
        return zzac(str, this.zzc, (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzav));
    }

    public final boolean zzl(Context context) {
        if (this.zzk) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        zzbde.zza(context);
        zzr zzrVar = null;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlv)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            context.getApplicationContext().registerReceiver(new zzp(this, zzrVar), intentFilter);
        } else {
            context.getApplicationContext().registerReceiver(new zzp(this, zzrVar), intentFilter, 4);
        }
        this.zzk = true;
        return true;
    }

    public final boolean zzm(Context context) {
        if (this.zzj) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        zzbde.zza(context);
        zzr zzrVar = null;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlv)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            context.getApplicationContext().registerReceiver(new zzq(this, zzrVar), intentFilter);
        } else {
            context.getApplicationContext().registerReceiver(new zzq(this, zzrVar), intentFilter, 4);
        }
        this.zzj = true;
        return true;
    }

    public final int zzn(Context context, Uri uri) {
        if (context == null) {
            zze.zza("Trying to open chrome custom tab on a null context");
            return 3;
        }
        if (!(context instanceof Activity)) {
            zzad(context, uri);
            return 2;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeT)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeR)).booleanValue()) {
                zzad(context, uri);
                return 9;
            }
            zzbef zzbefVar = new zzbef();
            zzbefVar.zze(new zzo(this, zzbefVar, context, uri));
            zzbefVar.zzb((Activity) context);
            return 5;
        }
        CustomTabsIntent build = new CustomTabsIntent.Builder(com.google.android.gms.ads.internal.zzv.zzf().zza()).build();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzff)).booleanValue()) {
            com.google.android.gms.ads.internal.client.zzbb.zzb();
            if (com.google.android.gms.ads.internal.util.client.zzf.zzw()) {
                return 5;
            }
        }
        build.intent.setPackage(zzhhh.zza(context));
        build.launchUrl(context, uri);
        return 5;
    }
}
