package com.inmobi.media;

import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoWcdma;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.g2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2659g2 {

    /* renamed from: a, reason: collision with root package name */
    public String f2575a;
    public int b;
    public int c;

    public C2659g2() {
    }

    public static String a(String mcc, String mnc, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(mcc, "mcc");
        Intrinsics.checkNotNullParameter(mnc, "mnc");
        return mcc + '#' + mnc + '#' + i + '#' + i2 + '#' + (i3 == -1 ? "" : Integer.valueOf(i3)) + '#' + (i4 != Integer.MAX_VALUE ? Integer.valueOf(i4) : "");
    }

    public C2659g2(CellInfo cellInfo, String mcc, String mnc, int i) {
        Intrinsics.checkNotNullParameter(mcc, "mcc");
        Intrinsics.checkNotNullParameter(mnc, "mnc");
        if (cellInfo instanceof CellInfoGsm) {
            this.c = i;
            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
            this.b = cellInfoGsm.getCellSignalStrength().getDbm();
            CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
            Intrinsics.checkNotNullExpressionValue(cellIdentity, "getCellIdentity(...)");
            this.f2575a = a(mcc, mnc, cellIdentity.getLac(), cellIdentity.getCid(), -1, Integer.MAX_VALUE);
            return;
        }
        if (!(cellInfo instanceof CellInfoCdma)) {
            if (cellInfo instanceof CellInfoWcdma) {
                this.c = i;
                CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                this.b = cellInfoWcdma.getCellSignalStrength().getDbm();
                CellIdentityWcdma cellIdentity2 = cellInfoWcdma.getCellIdentity();
                Intrinsics.checkNotNullExpressionValue(cellIdentity2, "getCellIdentity(...)");
                this.f2575a = a(mcc, mnc, cellIdentity2.getLac(), cellIdentity2.getCid(), cellIdentity2.getPsc(), Integer.MAX_VALUE);
                return;
            }
            return;
        }
        this.c = i;
        CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
        this.b = cellInfoCdma.getCellSignalStrength().getDbm();
        CellIdentityCdma cellIdentity3 = cellInfoCdma.getCellIdentity();
        Intrinsics.checkNotNullExpressionValue(cellIdentity3, "getCellIdentity(...)");
        int systemId = cellIdentity3.getSystemId();
        int networkId = cellIdentity3.getNetworkId();
        int basestationId = cellIdentity3.getBasestationId();
        Intrinsics.checkNotNullParameter(mcc, "mcc");
        this.f2575a = mcc + '#' + systemId + '#' + networkId + '#' + basestationId;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f2575a);
            int i = this.b;
            if (i != Integer.MAX_VALUE) {
                jSONObject.put("ss", i);
            }
            jSONObject.put("nt", this.c);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
