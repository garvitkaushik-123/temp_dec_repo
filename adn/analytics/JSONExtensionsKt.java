package adn.analytics;

import com.ironsource.C3040d4;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* compiled from: JSONExtensions.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a)\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000¢\u0006\u0002\u0010\b\u001a)\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000¢\u0006\u0002\u0010\u000b\u001a)\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"getStringOrNullWithError", "", "Lorg/json/JSONObject;", C3040d4.h.W, "errors", "", "getIntOrNullWithError", "", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/util/List;)Ljava/lang/Integer;", "getDoubleOrNullWithError", "", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/util/List;)Ljava/lang/Double;", "getLongOrNullWithError", "", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/util/List;)Ljava/lang/Long;", "adn-protos"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JSONExtensionsKt {
    public static final String getStringOrNullWithError(JSONObject jSONObject, String key, List<String> errors) {
        Object m10241constructorimpl;
        String valueOf;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(errors, "errors");
        Object opt = jSONObject.opt(key);
        if (opt == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            if (opt instanceof String) {
                valueOf = (String) opt;
            } else if (opt instanceof Number) {
                valueOf = opt.toString();
            } else {
                if (!(opt instanceof Boolean)) {
                    throw new IllegalArgumentException("Cannot convert " + Reflection.getOrCreateKotlinClass(opt.getClass()).getSimpleName() + " to String");
                }
                valueOf = String.valueOf(((Boolean) opt).booleanValue());
            }
            m10241constructorimpl = Result.m10241constructorimpl(valueOf);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10244exceptionOrNullimpl(m10241constructorimpl) != null) {
            errors.add("Proto Error: key '" + key + "' expected String, received: " + opt);
        }
        return (String) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
    }

    public static final Integer getIntOrNullWithError(JSONObject jSONObject, String key, List<String> errors) {
        Object m10241constructorimpl;
        int i;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(errors, "errors");
        Object opt = jSONObject.opt(key);
        if (opt == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            if (opt instanceof Number) {
                i = ((Number) opt).intValue();
            } else if (opt instanceof String) {
                i = Integer.parseInt((String) opt);
            } else {
                if (!(opt instanceof Boolean)) {
                    throw new IllegalArgumentException("Cannot convert " + Reflection.getOrCreateKotlinClass(opt.getClass()).getSimpleName() + " to Int");
                }
                i = ((Boolean) opt).booleanValue() ? 1 : 0;
            }
            m10241constructorimpl = Result.m10241constructorimpl(Integer.valueOf(i));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10244exceptionOrNullimpl(m10241constructorimpl) != null) {
            errors.add("Proto Error: key '" + key + "' expected Int, received: " + opt);
        }
        return (Integer) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
    }

    public static final Double getDoubleOrNullWithError(JSONObject jSONObject, String key, List<String> errors) {
        Object m10241constructorimpl;
        double parseDouble;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(errors, "errors");
        Object opt = jSONObject.opt(key);
        if (opt == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            if (opt instanceof Number) {
                parseDouble = ((Number) opt).doubleValue();
            } else {
                if (!(opt instanceof String)) {
                    throw new IllegalArgumentException("Cannot convert " + Reflection.getOrCreateKotlinClass(opt.getClass()).getSimpleName() + " to Double");
                }
                parseDouble = Double.parseDouble((String) opt);
            }
            m10241constructorimpl = Result.m10241constructorimpl(Double.valueOf(parseDouble));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10244exceptionOrNullimpl(m10241constructorimpl) != null) {
            errors.add("Proto Error: key '" + key + "' expected Double, received: " + opt);
        }
        return (Double) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
    }

    public static final Long getLongOrNullWithError(JSONObject jSONObject, String key, List<String> errors) {
        Object m10241constructorimpl;
        long parseLong;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(errors, "errors");
        Object opt = jSONObject.opt(key);
        if (opt == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            if (opt instanceof Number) {
                parseLong = ((Number) opt).longValue();
            } else {
                if (!(opt instanceof String)) {
                    throw new IllegalArgumentException("Cannot convert " + Reflection.getOrCreateKotlinClass(opt.getClass()).getSimpleName() + " to Long");
                }
                parseLong = Long.parseLong((String) opt);
            }
            m10241constructorimpl = Result.m10241constructorimpl(Long.valueOf(parseLong));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10244exceptionOrNullimpl(m10241constructorimpl) != null) {
            errors.add("Proto Error: key '" + key + "' expected Long, received: " + opt);
        }
        return (Long) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
    }
}
