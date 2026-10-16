package io.bidmachine.analytics.internal;

import io.bidmachine.analytics.internal.q0;
import io.bidmachine.protobuf.sdk.ErrorReasonAnalytics;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public abstract class r0 {

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6785a;

        static {
            int[] iArr = new int[q0.a.values().length];
            try {
                iArr[q0.a.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[q0.a.MONITOR_INVALID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[q0.a.MONITOR_NO_CONTENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[q0.a.MONITOR_BAD_CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[q0.a.READER_INVALID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[q0.a.READER_NO_CONTENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[q0.a.READER_BAD_CONTENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[q0.a.READER_NO_ACCESS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f6785a = iArr;
        }
    }

    public static final JSONObject a(q0 q0Var) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", q0Var.a());
        jSONObject.put("type", a(q0Var.c()));
        jSONObject.put("reason", q0Var.b());
        return jSONObject;
    }

    public static final q0 a(JSONObject jSONObject) {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(new q0(jSONObject.getString("name"), a(jSONObject.getInt("type")), jSONObject.optString("reason")));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = null;
        }
        return (q0) m10241constructorimpl;
    }

    private static final int a(q0.a aVar) {
        switch (a.f6785a[aVar.ordinal()]) {
            case 1:
                return 2000;
            case 2:
                return 2100;
            case 3:
                return ErrorReasonAnalytics.ERROR_REASON_ANALYTICS_MONITOR_NO_CONTENT_VALUE;
            case 4:
                return ErrorReasonAnalytics.ERROR_REASON_ANALYTICS_MONITOR_BAD_CONTENT_VALUE;
            case 5:
                return 2200;
            case 6:
                return 2201;
            case 7:
                return ErrorReasonAnalytics.ERROR_REASON_ANALYTICS_READER_BAD_CONTENT_VALUE;
            case 8:
                return 2203;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final q0.a a(int i) {
        switch (i) {
            case 2100:
                return q0.a.MONITOR_INVALID;
            case ERROR_REASON_ANALYTICS_MONITOR_NO_CONTENT_VALUE:
                return q0.a.MONITOR_NO_CONTENT;
            case ERROR_REASON_ANALYTICS_MONITOR_BAD_CONTENT_VALUE:
                return q0.a.MONITOR_BAD_CONTENT;
            default:
                switch (i) {
                    case 2200:
                        return q0.a.READER_INVALID;
                    case 2201:
                        return q0.a.READER_NO_CONTENT;
                    case ERROR_REASON_ANALYTICS_READER_BAD_CONTENT_VALUE:
                        return q0.a.READER_BAD_CONTENT;
                    case 2203:
                        return q0.a.READER_NO_ACCESS;
                    default:
                        return q0.a.UNKNOWN;
                }
        }
    }
}
