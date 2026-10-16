package com.moloco.sdk.internal.services.init;

import android.net.Uri;
import com.moloco.sdk.MetricsRequest;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.init.j;
import com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d;
import io.ktor.http.ContentType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class o implements n {
    public static final int c = 8;

    /* renamed from: a, reason: collision with root package name */
    public final String f5711a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d b;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5712a;

        static {
            int[] iArr = new int[b.values().length];
            try {
                iArr[b.f.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[b.f5690a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[b.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[b.c.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[b.d.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[b.e.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f5712a = iArr;
        }
    }

    public o(String endpoint, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d httpRequestClient) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(httpRequestClient, "httpRequestClient");
        this.f5711a = endpoint;
        this.b = httpRequestClient;
    }

    @Override // com.moloco.sdk.internal.services.init.n
    public Object a(long j, Continuation<? super Unit> continuation) {
        MolocoLogger molocoLogger;
        try {
            molocoLogger = MolocoLogger.INSTANCE;
            MolocoLogger.debug$default(molocoLogger, p.f5713a, "Reporting InitTracking success", false, 4, null);
        } catch (Exception e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, p.f5713a, "Failed to send notifySuccess post request", e, false, 8, null);
        }
        if (this.f5711a.length() == 0) {
            MolocoLogger.debug$default(molocoLogger, p.f5713a, "SDK InitTracking disabled", false, 4, null);
            return Unit.INSTANCE;
        }
        Uri build = Uri.parse(this.f5711a).buildUpon().build();
        com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d dVar = this.b;
        String uri = build.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        d.a.a(dVar, uri, a(j), ContentType.Application.INSTANCE.getProtoBuf(), null, 8, null);
        return Unit.INSTANCE;
    }

    @Override // com.moloco.sdk.internal.services.init.n
    public Object a(j jVar, long j, Continuation<? super Unit> continuation) {
        try {
            if (jVar instanceof j.a) {
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, p.f5713a, "Reporting InitTracking client failure: " + ((j.a) jVar).a(), false, 4, null);
            } else {
                if (!(jVar instanceof j.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, p.f5713a, "Reporting InitTracking server failure: " + ((j.b) jVar).a(), false, 4, null);
            }
        } catch (Exception e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, p.f5713a, "Failed to send notifyFailure post request", e, false, 8, null);
        }
        if (this.f5711a.length() == 0) {
            MolocoLogger.debug$default(MolocoLogger.INSTANCE, p.f5713a, "SDK InitTracking disabled", false, 4, null);
            return Unit.INSTANCE;
        }
        Uri build = Uri.parse(this.f5711a).buildUpon().build();
        byte[] a2 = a(jVar, j);
        com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d dVar = this.b;
        String uri = build.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        d.a.a(dVar, uri, a2, ContentType.Application.INSTANCE.getProtoBuf(), null, 8, null);
        return Unit.INSTANCE;
    }

    public final byte[] a(long j) {
        MetricsRequest.SDKInitTrackingRequest.Builder newBuilder = MetricsRequest.SDKInitTrackingRequest.newBuilder();
        newBuilder.setLatencyMs(j);
        newBuilder.setSuccess(MetricsRequest.SDKInitSuccessTrackingRequest.newBuilder().build());
        byte[] byteArray = newBuilder.build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public final byte[] a(j jVar, long j) {
        MetricsRequest.SDKInitTrackingRequest.Builder newBuilder = MetricsRequest.SDKInitTrackingRequest.newBuilder();
        MetricsRequest.SDKInitFailureTrackingRequest.Builder newBuilder2 = MetricsRequest.SDKInitFailureTrackingRequest.newBuilder();
        if (jVar instanceof j.a) {
            MetricsRequest.SDKInitFailureTrackingRequest.ClientError.Builder newBuilder3 = MetricsRequest.SDKInitFailureTrackingRequest.ClientError.newBuilder();
            newBuilder3.setClientFailureType(a(((j.a) jVar).a()));
            newBuilder2.setClientError(newBuilder3.build());
        } else if (jVar instanceof j.b) {
            MetricsRequest.SDKInitFailureTrackingRequest.ServerError.Builder newBuilder4 = MetricsRequest.SDKInitFailureTrackingRequest.ServerError.newBuilder();
            newBuilder4.setServerHttpStatus(((j.b) jVar).a());
            newBuilder2.setServerError(newBuilder4.build());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        newBuilder.setFailure(newBuilder2.build());
        newBuilder.setLatencyMs(j);
        byte[] byteArray = newBuilder.build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public final MetricsRequest.SDKInitFailureTrackingRequest.ClientError.ClientErrorTypes a(b bVar) {
        switch (a.f5712a[bVar.ordinal()]) {
            case 1:
                return MetricsRequest.SDKInitFailureTrackingRequest.ClientError.ClientErrorTypes.UNKNOWN;
            case 2:
                return MetricsRequest.SDKInitFailureTrackingRequest.ClientError.ClientErrorTypes.HTTP_REQUEST_TIMEOUT;
            case 3:
                return MetricsRequest.SDKInitFailureTrackingRequest.ClientError.ClientErrorTypes.HTTP_UKNOWN_HOST;
            case 4:
                return MetricsRequest.SDKInitFailureTrackingRequest.ClientError.ClientErrorTypes.HTTP_SOCKET;
            case 5:
                return MetricsRequest.SDKInitFailureTrackingRequest.ClientError.ClientErrorTypes.HTTP_SSL_ERROR;
            case 6:
                return MetricsRequest.SDKInitFailureTrackingRequest.ClientError.ClientErrorTypes.ANDROID_WORK_MANAGER_ISSUE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
