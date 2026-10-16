package com.inmobi.unifiedId;

import android.content.Context;
import com.adjust.sdk.Constants;
import com.inmobi.ads.exceptions.SdkNotInitializedException;
import com.inmobi.commons.core.configs.SignalsConfig;
import com.inmobi.media.AbstractC2564ab;
import com.inmobi.media.AbstractC2808p5;
import com.inmobi.media.AbstractC2945xe;
import com.inmobi.media.AbstractC2980ze;
import com.inmobi.media.B6;
import com.inmobi.media.C2881te;
import com.inmobi.media.C6;
import com.inmobi.media.L4;
import com.inmobi.media.O2;
import com.inmobi.media.Pd;
import com.inmobi.media.Q5;
import com.inmobi.media.Td;
import com.inmobi.media.Uc;
import com.ironsource.C3040d4;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/inmobi/unifiedId/InMobiUnifiedIdService;", "", "Lcom/inmobi/unifiedId/InMobiUserDataModel;", "inMobiUserDataModel", "", Constants.PUSH, "(Lcom/inmobi/unifiedId/InMobiUserDataModel;)V", "Lcom/inmobi/unifiedId/InMobiUnifiedIdInterface;", "inMobiUnifiedIdInterface", "fetchUnifiedIds", "(Lcom/inmobi/unifiedId/InMobiUnifiedIdInterface;)V", "fetchUnifiedIdsInternal$media_release", "fetchUnifiedIdsInternal", "reset", "()V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPushCalled", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isPushCalled$annotations", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InMobiUnifiedIdService {
    public static final InMobiUnifiedIdService INSTANCE = new InMobiUnifiedIdService();

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f2779a = new AtomicBoolean();

    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(InMobiUnifiedIdInterface inMobiUnifiedIdInterface) {
        Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
        JSONObject ufids = Q5.b();
        if (ufids != null) {
            try {
                JSONArray jSONArray = ufids.has("ufids") ? ufids.getJSONArray("ufids") : null;
                if (jSONArray != null && jSONArray.length() != 0 && ufids != null) {
                    Intrinsics.checkNotNullParameter(ufids, "ufids");
                    boolean z = true;
                    try {
                        if (ufids.has("ufids")) {
                            JSONArray jSONArray2 = ufids.getJSONArray("ufids");
                            int length = jSONArray2.length();
                            boolean z2 = true;
                            for (int i = 0; i < length; i++) {
                                try {
                                    z2 &= System.currentTimeMillis() <= jSONArray2.getJSONObject(i).getLong("expiry");
                                } catch (JSONException unused) {
                                    z = z2;
                                    Objects.toString(ufids);
                                    if (!z) {
                                    }
                                    if (inMobiUnifiedIdInterface == null) {
                                    }
                                }
                            }
                            z = z2;
                        }
                    } catch (JSONException unused2) {
                    }
                    if (!z) {
                        JSONObject jSONObject = AbstractC2945xe.f2756a;
                        if (inMobiUnifiedIdInterface != null) {
                            AbstractC2945xe.b.add(inMobiUnifiedIdInterface);
                        }
                        if (AbstractC2945xe.b()) {
                            Objects.toString(inMobiUnifiedIdInterface);
                            return;
                        } else {
                            AbstractC2945xe.d();
                            return;
                        }
                    }
                }
            } catch (JSONException unused3) {
            }
        }
        if (inMobiUnifiedIdInterface == null) {
            if (ufids != null) {
                try {
                    JSONArray jSONArray3 = ufids.has("ufids") ? ufids.getJSONArray("ufids") : null;
                    if (jSONArray3 != null && jSONArray3.length() != 0) {
                        AbstractC2980ze.a(inMobiUnifiedIdInterface, ufids, null);
                        return;
                    }
                } catch (JSONException unused4) {
                }
            }
            if (!f2779a.get()) {
                AbstractC2980ze.a(inMobiUnifiedIdInterface, null, new Error(InMobiUnifiedIdInterface.PUSH_NEEDS_TO_BE_CALLED_FIRST));
                return;
            }
            AbstractC2945xe.b.add(inMobiUnifiedIdInterface);
            if (AbstractC2945xe.b()) {
                Objects.toString(inMobiUnifiedIdInterface);
            } else {
                AbstractC2945xe.d();
            }
        }
    }

    public static final void b(InMobiUnifiedIdInterface inMobiUnifiedIdInterface) {
        fetchUnifiedIdsInternal$media_release(inMobiUnifiedIdInterface);
    }

    @JvmStatic
    public static final void fetchUnifiedIds(final InMobiUnifiedIdInterface inMobiUnifiedIdInterface) {
        Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
        if (Uc.q()) {
            Uc.a(new Runnable() { // from class: com.inmobi.unifiedId.InMobiUnifiedIdService$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    InMobiUnifiedIdService.b(InMobiUnifiedIdInterface.this);
                }
            });
        } else {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            throw new SdkNotInitializedException("InMobiUnifiedIdService");
        }
    }

    @JvmStatic
    public static final void fetchUnifiedIdsInternal$media_release(InMobiUnifiedIdInterface inMobiUnifiedIdInterface) {
        boolean booleanValue;
        Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
        HashMap hashMap = new HashMap();
        Pd pd = Pd.f2401a;
        Pd.b("FetchApiInvoked", hashMap, Td.f2443a);
        LinkedHashMap linkedHashMap = O2.f2380a;
        boolean enabled = ((SignalsConfig) AbstractC2808p5.a("signals", "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig", null)).getUnifiedIdServiceConfig().getEnabled();
        if (!enabled) {
            reset();
        }
        if (!enabled) {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            AbstractC2980ze.a(inMobiUnifiedIdInterface, null, new Error(InMobiUnifiedIdInterface.UNIFIED_SERVICE_IS_NOT_ENABLED));
            return;
        }
        Boolean c = C2881te.f2715a.c();
        boolean booleanValue2 = c != null ? c.booleanValue() : true;
        if (booleanValue2) {
            reset();
        }
        if (booleanValue2) {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            AbstractC2980ze.a(inMobiUnifiedIdInterface, null, new Error(InMobiUnifiedIdInterface.USER_HAS_OPTED_OUT));
            return;
        }
        Boolean bool = AbstractC2564ab.b;
        if (bool != null) {
            booleanValue = bool.booleanValue();
        } else {
            Context d = Uc.d();
            if (d != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6 a2 = B6.a(d, "user_info_store");
                Intrinsics.checkNotNullParameter("user_age_restricted", C3040d4.h.W);
                AbstractC2564ab.b = Boolean.valueOf(a2.f2249a.getBoolean("user_age_restricted", false));
            }
            Boolean bool2 = AbstractC2564ab.b;
            booleanValue = bool2 != null ? bool2.booleanValue() : false;
        }
        if (booleanValue) {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            AbstractC2980ze.a(inMobiUnifiedIdInterface, null, new Error(InMobiUnifiedIdInterface.USER_HAS_AGE_RESTRICTION));
            return;
        }
        synchronized (AbstractC2945xe.class) {
            if (AbstractC2945xe.b()) {
                if (inMobiUnifiedIdInterface != null) {
                    AbstractC2945xe.b.add(inMobiUnifiedIdInterface);
                }
                if (AbstractC2945xe.b()) {
                    Objects.toString(inMobiUnifiedIdInterface);
                } else {
                    AbstractC2945xe.d();
                }
            } else {
                a(inMobiUnifiedIdInterface);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void isPushCalled$annotations() {
    }

    @JvmStatic
    public static final void push(final InMobiUserDataModel inMobiUserDataModel) {
        Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
        Objects.toString(inMobiUserDataModel);
        if (Uc.q()) {
            Uc.a(new Runnable() { // from class: com.inmobi.unifiedId.InMobiUnifiedIdService$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    InMobiUnifiedIdService.a(InMobiUserDataModel.this);
                }
            });
        } else {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            throw new SdkNotInitializedException("InMobiUnifiedIdService");
        }
    }

    @JvmStatic
    public static final void reset() {
        Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
        if (Uc.q()) {
            Uc.a(new Runnable() { // from class: com.inmobi.unifiedId.InMobiUnifiedIdService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    InMobiUnifiedIdService.a();
                }
            });
        } else {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            throw new SdkNotInitializedException("InMobiUnifiedIdService");
        }
    }

    public final AtomicBoolean isPushCalled() {
        return f2779a;
    }

    public static final void a(InMobiUserDataModel inMobiUserDataModel) {
        boolean booleanValue;
        InMobiUserDataModel inMobiUserDataModel2;
        Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
        Objects.toString(inMobiUserDataModel);
        LinkedHashMap linkedHashMap = O2.f2380a;
        boolean enabled = ((SignalsConfig) AbstractC2808p5.a("signals", "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig", null)).getUnifiedIdServiceConfig().getEnabled();
        if (!enabled) {
            reset();
        }
        if (!enabled) {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            return;
        }
        Boolean c = C2881te.f2715a.c();
        boolean booleanValue2 = c != null ? c.booleanValue() : true;
        if (booleanValue2) {
            reset();
        }
        if (booleanValue2) {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            return;
        }
        Boolean bool = AbstractC2564ab.b;
        boolean z = false;
        if (bool != null) {
            booleanValue = bool.booleanValue();
        } else {
            Context d = Uc.d();
            if (d != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6 a2 = B6.a(d, "user_info_store");
                Intrinsics.checkNotNullParameter("user_age_restricted", C3040d4.h.W);
                AbstractC2564ab.b = Boolean.valueOf(a2.f2249a.getBoolean("user_age_restricted", false));
            }
            Boolean bool2 = AbstractC2564ab.b;
            booleanValue = bool2 != null ? bool2.booleanValue() : false;
        }
        if (booleanValue) {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            return;
        }
        InMobiUserDataModel inMobiUserDataModel3 = L4.f2349a;
        if (inMobiUserDataModel == null && L4.f2349a == null) {
            z = true;
        } else if (inMobiUserDataModel != null && (inMobiUserDataModel2 = L4.f2349a) != null) {
            z = Intrinsics.areEqual(inMobiUserDataModel, inMobiUserDataModel2);
        }
        if (z && f2779a.get()) {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            return;
        }
        synchronized (L4.class) {
            Objects.toString(L4.f2349a);
            Objects.toString(inMobiUserDataModel);
            L4.f2349a = inMobiUserDataModel;
        }
        f2779a.set(true);
        AbstractC2945xe.c();
    }

    public static final void a() {
        Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
        f2779a.set(false);
        synchronized (L4.class) {
            Objects.toString(L4.f2349a);
            L4.f2349a = null;
        }
        AbstractC2945xe.e();
        Q5.b(null);
        Q5.a(null);
        Q5.d = false;
        Q5.c = false;
    }
}
