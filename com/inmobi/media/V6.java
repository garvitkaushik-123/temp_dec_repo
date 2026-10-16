package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class V6 extends AbstractC2864se {
    public final byte[] d;
    public final InterfaceC2971z5 e;
    public final WeakReference f;
    public short g;
    public String h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V6(S0 adUnit, C2598ca oAManager, byte[] response, InterfaceC2971z5 interfaceC2971z5) {
        super(adUnit, (byte) 3);
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(oAManager, "oAManager");
        Intrinsics.checkNotNullParameter(response, "response");
        this.d = response;
        this.e = interfaceC2971z5;
        this.f = new WeakReference(oAManager);
    }

    @Override // com.inmobi.media.AbstractC2864se
    public final void a(Object obj) {
        C2947y0 c2947y0 = (C2947y0) obj;
        InterfaceC2971z5 interfaceC2971z5 = this.e;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("LoadWithResponseWorker", "onComplete");
        }
        C2598ca c2598ca = (C2598ca) this.f.get();
        if (c2598ca == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.e;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).b("LoadWithResponseWorker", "oAManager is null");
                return;
            }
            return;
        }
        if (c2947y0 != null) {
            InterfaceC2971z5 interfaceC2971z53 = this.e;
            if (interfaceC2971z53 != null) {
                ((A5) interfaceC2971z53).c("LoadWithResponseWorker", "loading response");
            }
            c2598ca.f2535a.b(c2947y0);
            return;
        }
        short s = this.g;
        if (s != 0) {
            HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to(IronSourceConstants.EVENTS_ERROR_CODE, Short.valueOf(s)));
            String str = this.h;
            if (str != null) {
                hashMapOf.put("reason", str);
            }
            c2598ca.f2535a.b((Map<String, Object>) hashMapOf);
        }
        c2598ca.f2535a.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
        InterfaceC2971z5 interfaceC2971z54 = this.e;
        if (interfaceC2971z54 != null) {
            ((A5) interfaceC2971z54).b("LoadWithResponseWorker", "adSet null. fail with error code - " + ((int) this.g));
        }
    }

    @Override // com.inmobi.media.G1
    public final void c() {
        S0 s0;
        super.c();
        InterfaceC2971z5 interfaceC2971z5 = this.e;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).b("LoadWithResponseWorker", "Encountered OOM");
        }
        C2598ca c2598ca = (C2598ca) this.f.get();
        if (c2598ca == null || (s0 = c2598ca.f2535a) == null) {
            return;
        }
        s0.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY), (short) 2146);
    }

    @Override // com.inmobi.media.G1
    public final void a() {
        InterfaceC2971z5 interfaceC2971z5 = this.e;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("LoadWithResponseWorker", "execute task start");
        }
        C2598ca c2598ca = (C2598ca) this.f.get();
        if (c2598ca == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.e;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).b("LoadWithResponseWorker", "OAManager null. failing.");
            }
            this.g = (short) 2142;
            b(null);
            return;
        }
        InterfaceC2971z5 interfaceC2971z53 = this.e;
        if (interfaceC2971z53 != null) {
            ((A5) interfaceC2971z53).a("LoadWithResponseWorker", "getting network response from byte array");
        }
        byte[] value = this.d;
        Intrinsics.checkNotNullParameter(value, "response");
        P9 mResponse = new P9();
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.length == 0) {
            mResponse.b = new byte[0];
        } else {
            byte[] bArr = new byte[value.length];
            mResponse.b = bArr;
            System.arraycopy(value, 0, bArr, 0, value.length);
        }
        Intrinsics.checkNotNullParameter(mResponse, "mResponse");
        I9 i9 = mResponse.d;
        if (i9 != null) {
            switch (U.f2444a[i9.f2315a.ordinal()]) {
                case 1:
                    new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE);
                    break;
                case 2:
                    InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_INVALID);
                    I9 i92 = mResponse.d;
                    String str = i92 != null ? i92.b : null;
                    if (str != null) {
                        inMobiAdRequestStatus.setCustomMessage(str);
                        break;
                    }
                    break;
                case 3:
                    new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_TIMED_OUT);
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.SERVER_ERROR);
                    break;
                case 9:
                    new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.GDPR_COMPLIANCE_ENFORCED);
                    break;
                default:
                    new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR);
                    break;
            }
        }
        try {
            InterfaceC2971z5 interfaceC2971z54 = this.e;
            if (interfaceC2971z54 != null) {
                ((A5) interfaceC2971z54).a("LoadWithResponseWorker", "start parsing response");
            }
            JSONObject jsonResponse = new JSONObject(mResponse.a());
            long j = jsonResponse.getLong("placementId");
            InterfaceC2971z5 interfaceC2971z55 = this.e;
            if (interfaceC2971z55 != null) {
                ((A5) interfaceC2971z55).e("placementID", String.valueOf(j));
            }
            InterfaceC2971z5 interfaceC2971z56 = this.e;
            if (interfaceC2971z56 != null) {
                ((A5) interfaceC2971z56).a("LoadWithResponseWorker", "placement id: " + j);
            }
            B0 p = c2598ca.f2535a.p();
            p.getClass();
            Intrinsics.checkNotNullParameter(jsonResponse, "jsonResponse");
            b(p.a(jsonResponse));
        } catch (K e) {
            this.g = e.b;
            InterfaceC2971z5 interfaceC2971z57 = this.e;
            if (interfaceC2971z57 != null) {
                String e2 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e2, "<get-TAG>(...)");
                ((A5) interfaceC2971z57).a(e2, "Exception while parsing OAResponse", e);
            }
            b(null);
        } catch (JSONException e3) {
            this.g = (short) 2145;
            this.h = e3.getMessage();
            InterfaceC2971z5 interfaceC2971z58 = this.e;
            if (interfaceC2971z58 != null) {
                String e4 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e4, "<get-TAG>(...)");
                ((A5) interfaceC2971z58).a(e4, "Exception while parsing OAResponse", e3);
            }
            b(null);
        }
    }
}
