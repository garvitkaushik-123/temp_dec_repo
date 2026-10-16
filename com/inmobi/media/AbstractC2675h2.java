package com.inmobi.media;

import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.autofill.HintConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.SignalsConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* renamed from: com.inmobi.media.h2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2675h2 {
    public static HashMap a() {
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        HashMap hashMap = new HashMap();
        Context d = Uc.d();
        if (d == null) {
            return hashMap;
        }
        String b = Uc.b();
        LinkedHashMap linkedHashMap = O2.f2380a;
        Config a2 = M2.a("signals", b, null);
        Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig");
        int cellOperatorFlag = ((SignalsConfig) a2).getIce().getCellOperatorFlag();
        boolean z = (cellOperatorFlag & 2) == 2;
        boolean z2 = (cellOperatorFlag & 1) == 1;
        Object systemService = d.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        TelephonyManager telephonyManager = (TelephonyManager) systemService;
        if (z) {
            str = null;
            i = -1;
            i2 = -1;
        } else {
            int[] a3 = a(telephonyManager.getNetworkOperator());
            i2 = a3[0];
            i = a3[1];
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (networkCountryIso != null) {
                Locale ENGLISH = Locale.ENGLISH;
                Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                str = networkCountryIso.toLowerCase(ENGLISH);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
        }
        if (z2) {
            i3 = -1;
            i4 = -1;
        } else {
            int[] a4 = a(telephonyManager.getSimOperator());
            i4 = a4[0];
            i3 = a4[1];
        }
        String sb = (i4 == -1 && i3 == -1) ? null : new StringBuilder().append(i4).append('_').append(i3).toString();
        if (sb != null) {
            hashMap.put("s-ho", sb);
        }
        String sb2 = (i2 == -1 && i == -1) ? null : new StringBuilder().append(i2).append('_').append(i).toString();
        if (sb2 != null) {
            hashMap.put("s-co", sb2);
        }
        if (str != null) {
            hashMap.put("s-iso", str);
        }
        hashMap.put("s-cn", L3.f2348a.a(d));
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0020, code lost:
    
        if (((com.inmobi.commons.core.configs.SignalsConfig) r0).getIce().isConnectedCellTowerEnabled() != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap b() {
        Context d;
        String h = Uc.f2453a.h();
        C2659g2 c2659g2 = null;
        if (h != null) {
            LinkedHashMap linkedHashMap = O2.f2380a;
            Config a2 = M2.a("signals", h, null);
            Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig");
        }
        if (d() && e() && (d = Uc.d()) != null) {
            Object systemService = d.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            int[] a3 = a(telephonyManager.getNetworkOperator());
            String mcc = String.valueOf(a3[0]);
            String valueOf = String.valueOf(a3[1]);
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            if (allCellInfo != null) {
                int size = allCellInfo.size();
                CellInfo cellInfo = null;
                for (int i = 0; i < size; i++) {
                    cellInfo = allCellInfo.get(i);
                    if (cellInfo.isRegistered()) {
                        break;
                    }
                }
                if (cellInfo != null) {
                    c2659g2 = new C2659g2(cellInfo, mcc, valueOf, Build.VERSION.SDK_INT >= 30 ? telephonyManager.getDataNetworkType() : telephonyManager.getNetworkType());
                }
            }
            CellLocation cellLocation = telephonyManager.getCellLocation();
            if (cellLocation != null && a3[0] != -1) {
                c2659g2 = new C2659g2();
                if (cellLocation instanceof CdmaCellLocation) {
                    c2659g2.b = Integer.MAX_VALUE;
                    c2659g2.c = Build.VERSION.SDK_INT >= 30 ? telephonyManager.getDataNetworkType() : telephonyManager.getNetworkType();
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                    int systemId = cdmaCellLocation.getSystemId();
                    int networkId = cdmaCellLocation.getNetworkId();
                    int baseStationId = cdmaCellLocation.getBaseStationId();
                    Intrinsics.checkNotNullParameter(mcc, "mcc");
                    c2659g2.f2575a = mcc + '#' + systemId + '#' + networkId + '#' + baseStationId;
                } else {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    c2659g2.b = Integer.MAX_VALUE;
                    c2659g2.c = Build.VERSION.SDK_INT >= 30 ? telephonyManager.getDataNetworkType() : telephonyManager.getNetworkType();
                    c2659g2.f2575a = C2659g2.a(mcc, valueOf, gsmCellLocation.getLac(), gsmCellLocation.getCid(), gsmCellLocation.getPsc(), Integer.MAX_VALUE);
                }
            }
        }
        HashMap hashMap = new HashMap();
        if (c2659g2 != null) {
            String jSONObject = c2659g2.a().toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
            hashMap.put("c-sc", jSONObject);
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
    
        if (((com.inmobi.commons.core.configs.SignalsConfig) r0).getIce().isVisibleCellTowerEnabled() != false) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap c() {
        ArrayList arrayList;
        if (Uc.q() && d() && e()) {
            String h = Uc.f2453a.h();
            if (h != null) {
                LinkedHashMap linkedHashMap = O2.f2380a;
                Config a2 = M2.a("signals", h, null);
                Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig");
            }
            Context d = Uc.d();
            if (d == null) {
                arrayList = new ArrayList();
            } else {
                Object systemService = d.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                TelephonyManager telephonyManager = (TelephonyManager) systemService;
                ArrayList arrayList2 = new ArrayList();
                int[] a3 = a(telephonyManager.getNetworkOperator());
                String valueOf = String.valueOf(a3[0]);
                String valueOf2 = String.valueOf(a3[1]);
                List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                if (allCellInfo != null) {
                    for (CellInfo cellInfo : allCellInfo) {
                        if (!cellInfo.isRegistered()) {
                            arrayList2.add(new C2659g2(cellInfo, valueOf, valueOf2, Build.VERSION.SDK_INT >= 30 ? telephonyManager.getDataNetworkType() : telephonyManager.getNetworkType()));
                        }
                    }
                }
                arrayList = arrayList2;
            }
            HashMap hashMap = new HashMap();
            if (!arrayList.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(((C2659g2) arrayList.get(arrayList.size() - 1)).a());
                String jSONArray2 = jSONArray.toString();
                Intrinsics.checkNotNullExpressionValue(jSONArray2, "toString(...)");
                hashMap.put("v-sc", jSONArray2);
            }
            return hashMap;
        }
        arrayList = new ArrayList();
        HashMap hashMap2 = new HashMap();
        if (!arrayList.isEmpty()) {
        }
        return hashMap2;
    }

    public static boolean d() {
        if (!Uc.q()) {
            return false;
        }
        boolean a2 = AbstractC2925wa.a(Uc.d(), "android.permission.READ_PHONE_STATE");
        boolean a3 = AbstractC2925wa.a(Uc.d(), "android.permission.ACCESS_FINE_LOCATION");
        int i = Build.VERSION.SDK_INT;
        if (i == 29) {
            if (!a3) {
                Intrinsics.checkNotNullExpressionValue("h2", "TAG");
            }
            return a3;
        }
        if (i >= 30) {
            if (!a3 || !a2) {
                Intrinsics.checkNotNullExpressionValue("h2", "TAG");
            }
            return a3 && a2;
        }
        boolean a4 = AbstractC2925wa.a(Uc.d(), "android.permission.ACCESS_COARSE_LOCATION");
        if (!a4 && !a3) {
            Intrinsics.checkNotNullExpressionValue("h2", "TAG");
        }
        return a4 || a3;
    }

    public static boolean e() {
        Context d = Uc.d();
        Object systemService = d != null ? d.getSystemService(FirebaseAnalytics.Param.LOCATION) : null;
        LocationManager locationManager = systemService instanceof LocationManager ? (LocationManager) systemService : null;
        return locationManager != null && locationManager.isLocationEnabled();
    }

    public static int[] a(String str) {
        int[] iArr = {-1, -1};
        if (str != null && !Intrinsics.areEqual("", str)) {
            try {
                String substring = str.substring(0, 3);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                int parseInt = Integer.parseInt(substring);
                String substring2 = str.substring(3);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                int parseInt2 = Integer.parseInt(substring2);
                iArr[0] = parseInt;
                iArr[1] = parseInt2;
            } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            }
        }
        return iArr;
    }
}
