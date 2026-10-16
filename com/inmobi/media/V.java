package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class V {

    /* renamed from: a, reason: collision with root package name */
    public final P9 f2456a;
    public final InMobiAdRequestStatus b;

    public V(P9 mResponse) {
        Intrinsics.checkNotNullParameter(mResponse, "mResponse");
        this.f2456a = mResponse;
        I9 i9 = mResponse.d;
        if (i9 != null) {
            switch (U.f2444a[i9.f2315a.ordinal()]) {
                case 1:
                    this.b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE);
                    break;
                case 2:
                    InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_INVALID);
                    this.b = inMobiAdRequestStatus;
                    I9 i92 = mResponse.d;
                    String str = i92 != null ? i92.b : null;
                    if (str != null) {
                        inMobiAdRequestStatus.setCustomMessage(str);
                        break;
                    }
                    break;
                case 3:
                    this.b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_TIMED_OUT);
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    this.b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.SERVER_ERROR);
                    break;
                case 9:
                    this.b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.GDPR_COMPLIANCE_ENFORCED);
                    break;
                default:
                    this.b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR);
                    break;
            }
        }
    }
}
