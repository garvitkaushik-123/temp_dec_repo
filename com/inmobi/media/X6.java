package com.inmobi.media;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.inmobi.commons.core.configs.Config;
import com.unity3d.services.UnityAdsConstants;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
public final class X6 implements LocationListener {

    /* renamed from: a, reason: collision with root package name */
    public static final X6 f2480a = new X6();
    public static final LocationManager b;
    public static final HandlerThread c;
    public static GoogleApiClient d;
    public static final String e;
    public static boolean f;

    static {
        HandlerThread handlerThread = new HandlerThread("LThread");
        c = handlerThread;
        e = "X6";
        D4.a(handlerThread, "LThread");
        Context d2 = Uc.d();
        if (d2 != null) {
            Object systemService = d2.getSystemService(FirebaseAnalytics.Param.LOCATION);
            b = systemService instanceof LocationManager ? (LocationManager) systemService : null;
        }
    }

    public static boolean c() {
        try {
            if (AbstractC2925wa.a(Uc.d(), "android.permission.ACCESS_FINE_LOCATION")) {
                return true;
            }
            return AbstractC2925wa.a(Uc.d(), "android.permission.ACCESS_COARSE_LOCATION");
        } catch (Exception unused) {
            String TAG = e;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            return false;
        }
    }

    public static boolean e() {
        LocationManager locationManager;
        return (Uc.d() == null || (locationManager = b) == null || !locationManager.isLocationEnabled()) ? false : true;
    }

    public final void a() {
        LocationManager locationManager = b;
        if (locationManager != null) {
            Criteria criteria = new Criteria();
            criteria.setBearingAccuracy(2);
            criteria.setPowerRequirement(2);
            criteria.setCostAllowed(false);
            String bestProvider = locationManager.getBestProvider(criteria, true);
            if (bestProvider != null) {
                Intrinsics.checkNotNullExpressionValue(e, "TAG");
                locationManager.requestSingleUpdate(bestProvider, this, c.getLooper());
            } else {
                String TAG = e;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            }
        }
        Unit unit = Unit.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:28|(6:85|86|31|32|(1:36)|82)|30|31|32|(2:34|36)|82) */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
    
        if (((com.inmobi.commons.core.configs.SignalsConfig) r1).getIce().getLocationEnabled() != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0080, code lost:
    
        r5 = com.inmobi.media.X6.e;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "TAG");
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x016e A[Catch: all -> 0x0188, LOOP:0: B:14:0x0168->B:16:0x016e, LOOP_END, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0011, B:9:0x0142, B:11:0x014e, B:12:0x0153, B:13:0x0160, B:14:0x0168, B:16:0x016e, B:22:0x0158, B:24:0x002a, B:26:0x0030, B:28:0x0036, B:86:0x003a, B:32:0x0066, B:34:0x006a, B:36:0x0076, B:39:0x008c, B:41:0x0098, B:43:0x00a4, B:46:0x00ab, B:47:0x00ba, B:57:0x00e2, B:59:0x00f2, B:60:0x0100, B:73:0x0124, B:74:0x0133, B:84:0x0080, B:90:0x005b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0158 A[Catch: all -> 0x0188, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0011, B:9:0x0142, B:11:0x014e, B:12:0x0153, B:13:0x0160, B:14:0x0168, B:16:0x016e, B:22:0x0158, B:24:0x002a, B:26:0x0030, B:28:0x0036, B:86:0x003a, B:32:0x0066, B:34:0x006a, B:36:0x0076, B:39:0x008c, B:41:0x0098, B:43:0x00a4, B:46:0x00ab, B:47:0x00ba, B:57:0x00e2, B:59:0x00f2, B:60:0x0100, B:73:0x0124, B:74:0x0133, B:84:0x0080, B:90:0x005b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0098 A[Catch: all -> 0x0188, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0011, B:9:0x0142, B:11:0x014e, B:12:0x0153, B:13:0x0160, B:14:0x0168, B:16:0x016e, B:22:0x0158, B:24:0x002a, B:26:0x0030, B:28:0x0036, B:86:0x003a, B:32:0x0066, B:34:0x006a, B:36:0x0076, B:39:0x008c, B:41:0x0098, B:43:0x00a4, B:46:0x00ab, B:47:0x00ba, B:57:0x00e2, B:59:0x00f2, B:60:0x0100, B:73:0x0124, B:74:0x0133, B:84:0x0080, B:90:0x005b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0142 A[Catch: all -> 0x0188, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0011, B:9:0x0142, B:11:0x014e, B:12:0x0153, B:13:0x0160, B:14:0x0168, B:16:0x016e, B:22:0x0158, B:24:0x002a, B:26:0x0030, B:28:0x0036, B:86:0x003a, B:32:0x0066, B:34:0x006a, B:36:0x0076, B:39:0x008c, B:41:0x0098, B:43:0x00a4, B:46:0x00ab, B:47:0x00ba, B:57:0x00e2, B:59:0x00f2, B:60:0x0100, B:73:0x0124, B:74:0x0133, B:84:0x0080, B:90:0x005b), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized HashMap b() {
        HashMap hashMap;
        Location location;
        Location location2;
        hashMap = new HashMap();
        String h = Uc.f2453a.h();
        if (h != null) {
            LinkedHashMap linkedHashMap = O2.f2380a;
            Config a2 = M2.a("signals", h, null);
            Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig");
        }
        try {
        } catch (Exception unused) {
            location = null;
        }
        if (e() && c()) {
            if (f) {
                try {
                    Context d2 = Uc.d();
                    Intrinsics.checkNotNull(d2);
                    FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(d2);
                    Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClient, "getFusedLocationProviderClient(...)");
                    Task<Location> lastLocation = fusedLocationProviderClient.getLastLocation();
                    Intrinsics.checkNotNullExpressionValue(lastLocation, "getLastLocation(...)");
                    location = lastLocation.getResult();
                } catch (Exception unused2) {
                } catch (IncompatibleClassChangeError e2) {
                    String TAG = e;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    e2.toString();
                }
                if (b != null && AbstractC2925wa.a(Uc.d(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    location2 = a(2, 2);
                }
                location2 = null;
            }
            location = null;
            if (b != null) {
                location2 = a(2, 2);
            }
            location2 = null;
        } else {
            location = null;
            location2 = null;
        }
        if (location == null || location2 != null) {
            if (location != null) {
                String TAG2 = e;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                Objects.toString(location2);
                if (location2 != null) {
                    location2.getTime();
                }
            } else {
                if (location2 == null) {
                    String TAG3 = e;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    location.toString();
                    location.getTime();
                } else {
                    long time = location.getTime() - location2.getTime();
                    boolean z = time > UnityAdsConstants.Timeout.INIT_TIMEOUT_MS;
                    boolean z2 = time < -120000;
                    boolean z3 = time > 0;
                    if (z) {
                        String TAG4 = e;
                        Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                        location.toString();
                        location.getTime();
                    } else if (z2) {
                        String TAG5 = e;
                        Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                        location2.toString();
                        location2.getTime();
                    } else {
                        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
                        boolean z4 = accuracy > 0;
                        boolean z5 = accuracy < 0;
                        boolean z6 = accuracy > 200;
                        if (!z5 && (!z3 || (z4 && z6))) {
                            String TAG6 = e;
                            Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
                            location2.toString();
                            location2.getTime();
                        }
                        String TAG7 = e;
                        Intrinsics.checkNotNullExpressionValue(TAG7, "TAG");
                        location.toString();
                        location.getTime();
                    }
                }
                HashMap a3 = location == null ? a(location, true, AbstractC2925wa.a(Uc.d(), "android.permission.ACCESS_FINE_LOCATION") ? a(1, 3) : null) : a(AbstractC2564ab.b(), false, null);
                for (Map.Entry entry : a3.entrySet()) {
                    hashMap.put((String) entry.getKey(), entry.getValue().toString());
                }
            }
            location = location2;
            if (location == null) {
            }
            while (r1.hasNext()) {
            }
        } else {
            String TAG8 = e;
            Intrinsics.checkNotNullExpressionValue(TAG8, "TAG");
            location = null;
            if (location == null) {
            }
            while (r1.hasNext()) {
            }
        }
        return hashMap;
    }

    public final synchronized void d() {
        try {
            if (c() && e()) {
                a();
                try {
                    Reflection.getOrCreateKotlinClass(GoogleApiClient.class).getSimpleName();
                    Reflection.getOrCreateKotlinClass(FusedLocationProviderClient.class).getSimpleName();
                    Reflection.getOrCreateKotlinClass(LocationServices.class).getSimpleName();
                    a(Uc.d());
                } catch (NoClassDefFoundError unused) {
                }
            }
        } catch (Exception unused2) {
            String TAG = e;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        }
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        LocationManager locationManager;
        Intrinsics.checkNotNullParameter(location, "location");
        try {
            String TAG = e;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            location.getTime();
            location.getLatitude();
            location.getLongitude();
            location.getAccuracy();
            if (!c() || (locationManager = b) == null) {
                return;
            }
            locationManager.removeUpdates(this);
        } catch (Exception e2) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e2, "event"));
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public static void a(Context context) {
        try {
            GoogleApiClient googleApiClient = d;
            if (googleApiClient == null) {
                String TAG = e;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                Intrinsics.checkNotNull(context);
                GoogleApiClient build = new GoogleApiClient.Builder(context).addConnectionCallbacks(new W6()).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() { // from class: com.inmobi.media.X6$$ExternalSyntheticLambda0
                    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
                    public final void onConnectionFailed(ConnectionResult connectionResult) {
                        X6.a(connectionResult);
                    }
                }).addApi(LocationServices.API).build();
                d = build;
                if (build != null) {
                    build.connect();
                    return;
                }
                return;
            }
            googleApiClient.connect();
        } catch (Exception unused) {
            String TAG2 = e;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        }
    }

    public static final void a(ConnectionResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        f = false;
    }

    public static Location a(int i, int i2) {
        String bestProvider;
        Location location;
        Criteria criteria = new Criteria();
        criteria.setAccuracy(i);
        criteria.setPowerRequirement(i2);
        criteria.setCostAllowed(false);
        LocationManager locationManager = b;
        Location location2 = null;
        if (locationManager != null && (bestProvider = locationManager.getBestProvider(criteria, true)) != null) {
            try {
                location = locationManager.getLastKnownLocation(bestProvider);
            } catch (Exception unused) {
                location = null;
            }
            if (location != null || i == 1) {
                location2 = location;
            } else {
                LocationManager locationManager2 = b;
                if (locationManager2 != null) {
                    Intrinsics.checkNotNull(locationManager2);
                    List<String> providers = locationManager2.getProviders(true);
                    Intrinsics.checkNotNullExpressionValue(providers, "getProviders(...)");
                    int size = providers.size() - 1;
                    if (size >= 0) {
                        while (true) {
                            int i3 = size - 1;
                            String str = providers.get(size);
                            try {
                                LocationManager locationManager3 = b;
                                if (locationManager3 != null && locationManager3.isProviderEnabled(str)) {
                                    try {
                                        location2 = locationManager3.getLastKnownLocation(str);
                                    } catch (SecurityException unused2) {
                                    }
                                    if (location2 != null) {
                                        break;
                                    }
                                }
                            } catch (Exception unused3) {
                            }
                            if (i3 < 0) {
                                break;
                            }
                            size = i3;
                        }
                    }
                }
            }
        }
        String TAG = e;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        return location2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0080, code lost:
    
        if (((com.inmobi.commons.core.configs.SignalsConfig) r7).getIce().getLocationEnabled() != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap a(Location location, boolean z, Location location2) {
        HashMap hashMap = new HashMap();
        Context d2 = Uc.d();
        if (d2 != null) {
            if (location != null) {
                if (location.getTime() > 0) {
                    hashMap.put("u-ll-ts", Long.valueOf(location.getTime()));
                }
                hashMap.put("u-latlong-accu", new StringBuilder().append(location.getLatitude()).append(AbstractJsonLexerKt.COMMA).append(location.getLongitude()).append(AbstractJsonLexerKt.COMMA).append((int) location.getAccuracy()).toString());
                hashMap.put("sdk-collected", Integer.valueOf(z ? 1 : 0));
            }
            String h = Uc.f2453a.h();
            if (h != null) {
                LinkedHashMap linkedHashMap = O2.f2380a;
                Config a2 = M2.a("signals", h, null);
                Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig");
            }
            hashMap.put("loc-allowed", Integer.valueOf(e() ? 1 : 0));
            if (location2 != null) {
                hashMap.put("u-latlong-accu-fine", new StringBuilder().append(location2.getLatitude()).append(AbstractJsonLexerKt.COMMA).append(location2.getLongitude()).append(AbstractJsonLexerKt.COMMA).append((int) location2.getAccuracy()).toString());
                hashMap.put("u-ll-ts-fine", Long.valueOf(location2.getTime()));
            }
            if (e() && c()) {
                if (AbstractC2925wa.a(d2, "android.permission.ACCESS_COARSE_LOCATION")) {
                    hashMap.put("loc-granularity", "coarse");
                }
            } else {
                hashMap.put("loc-granularity", "none");
                return hashMap;
            }
        }
        return hashMap;
    }
}
