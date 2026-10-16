package io.bidmachine;

import android.content.Context;
import com.explorestack.protobuf.Any;
import com.explorestack.protobuf.adcom.Context;
import io.bidmachine.analytics.BidMachineAnalytics;
import io.bidmachine.core.TimeManager;
import io.bidmachine.core.Utils;
import io.bidmachine.protobuf.RequestTokenPayload;
import io.bidmachine.protobuf.sdk.ContextualData;
import io.bidmachine.protobuf.sdk.Session;
import io.bidmachine.utils.time.DateUtils;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes7.dex */
final class SessionParams {
    SessionParams() {
    }

    void build(Context context, RequestTokenPayload.Builder requestTokenPayloadBuilder, AdsFormat adsFormat) {
        Session.Builder createSessionBuilder = createSessionBuilder(context, adsFormat != null ? adsFormat.getAdsType() : null);
        if (createSessionBuilder != null) {
            requestTokenPayloadBuilder.setSession(createSessionBuilder);
        }
    }

    void build(Context context, Context.User.Builder userContextBuilder, AdsType adsType) {
        Session.Builder createSessionBuilder = createSessionBuilder(context, adsType);
        if (createSessionBuilder != null) {
            userContextBuilder.addExtProto(Any.pack(createSessionBuilder.build()));
        }
    }

    private Session.Builder createSessionBuilder(android.content.Context context, AdsType adsType) {
        try {
            final Session.Builder sessionId = Session.newBuilder().setSessionId(SessionManager.get().getSessionId());
            Session.Context.Builder createSessionContextBuilder = createSessionContextBuilder(context, adsType);
            Objects.requireNonNull(sessionId);
            Utils.ifNotNull(createSessionContextBuilder, new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda0
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    Session.Builder.this.setContext((Session.Context.Builder) obj);
                }
            });
            return sessionId;
        } catch (Throwable unused) {
            return null;
        }
    }

    private Session.Context.Builder createSessionContextBuilder(android.content.Context context, AdsType adsType) {
        try {
            Date date = new Date(BidMachineSharedPreference.obtainFirstLaunchTimeMs(context));
            SessionManager sessionManager = SessionManager.get();
            final Session.Context.Builder retention = Session.Context.newBuilder().setSessionduration(sessionManager.getSessionDurationSec()).setLastSessionDuration(sessionManager.getLastSessionDurationSec()).setSc(SessionManager.get().getSessionCount()).setRetention(DateUtils.daysBetween(date, new Date(TimeManager.currentTimeMillis())));
            for (Map.Entry<String, Map<String, Object>> entry : BidMachineAnalytics.getImpData(getAdsTypeId(adsType)).entrySet()) {
                ContextualData.Builder createContextualDataBuilder = createContextualDataBuilder(adsType, entry.getKey(), entry.getValue());
                Objects.requireNonNull(retention);
                Utils.ifNotNull(createContextualDataBuilder, new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda9
                    @Override // io.bidmachine.Executable
                    public final void execute(Object obj) {
                        Session.Context.Builder.this.addData((ContextualData.Builder) obj);
                    }
                });
            }
            return retention;
        } catch (Throwable unused) {
            return null;
        }
    }

    private ContextualData.Builder createContextualDataBuilder(AdsType adsType, String name, Map<String, Object> impData) {
        try {
            final ContextualData.Builder mediatorName = ContextualData.newBuilder().setMediatorName(name);
            Utils.ifNotNull(adsType, new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda1
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    ContextualData.Builder.this.setPlacement(((AdsType) obj).getName());
                }
            });
            ContextualData.ImpressionData.Builder createImpressionDataBuilder = createImpressionDataBuilder(impData);
            Objects.requireNonNull(mediatorName);
            Utils.ifNotNull(createImpressionDataBuilder, new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda2
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    ContextualData.Builder.this.setData((ContextualData.ImpressionData.Builder) obj);
                }
            });
            return mediatorName;
        } catch (Throwable unused) {
            return null;
        }
    }

    private ContextualData.ImpressionData.Builder createImpressionDataBuilder(Map<String, Object> impData) {
        try {
            final ContextualData.ImpressionData.Builder newBuilder = ContextualData.ImpressionData.newBuilder();
            Integer convertToIntOrDefault = Utils.convertToIntOrDefault(impData.get("imimd"), null);
            Objects.requireNonNull(newBuilder);
            Utils.ifNotNull(convertToIntOrDefault, new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda3
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    ContextualData.ImpressionData.Builder.this.setImimd(((Integer) obj).intValue());
                }
            });
            Integer convertToIntOrDefault2 = Utils.convertToIntOrDefault(impData.get("imd"), null);
            Objects.requireNonNull(newBuilder);
            Utils.ifNotNull(convertToIntOrDefault2, new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda4
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    ContextualData.ImpressionData.Builder.this.setImd(((Integer) obj).intValue());
                }
            });
            Float convertToFloatOrDefault = Utils.convertToFloatOrDefault(impData.get("imwp"), null);
            Objects.requireNonNull(newBuilder);
            Utils.ifNotNull(convertToFloatOrDefault, new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda5
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    ContextualData.ImpressionData.Builder.this.setImwp(((Float) obj).floatValue());
                }
            });
            Float convertToFloatOrDefault2 = Utils.convertToFloatOrDefault(impData.get("wp"), null);
            Objects.requireNonNull(newBuilder);
            Utils.ifNotNull(convertToFloatOrDefault2, new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda6
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    ContextualData.ImpressionData.Builder.this.setWp(((Float) obj).floatValue());
                }
            });
            Utils.ifNotNull(impData.get("imagency"), new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda7
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    ContextualData.ImpressionData.Builder.this.setImagency(obj.toString());
                }
            });
            Utils.ifNotNull(impData.get("agency"), new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda8
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    ContextualData.ImpressionData.Builder.this.setAgency(obj.toString());
                }
            });
            return newBuilder;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: io.bidmachine.SessionParams$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$AdsType;

        static {
            int[] iArr = new int[AdsType.values().length];
            $SwitchMap$io$bidmachine$AdsType = iArr;
            try {
                iArr[AdsType.Banner.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsType[AdsType.Interstitial.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsType[AdsType.Rewarded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsType[AdsType.Native.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private int getAdsTypeId(AdsType adsType) {
        if (adsType == null) {
            return 0;
        }
        int i = AnonymousClass1.$SwitchMap$io$bidmachine$AdsType[adsType.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        return 0;
                    }
                }
            }
        }
        return i2;
    }
}
