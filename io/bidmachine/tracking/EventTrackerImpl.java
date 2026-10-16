package io.bidmachine.tracking;

import android.text.TextUtils;
import com.explorestack.protobuf.StringValue;
import com.explorestack.protobuf.Struct;
import io.bidmachine.AdsType;
import io.bidmachine.ApiRequest;
import io.bidmachine.TrackEventType;
import io.bidmachine.core.Logger;
import io.bidmachine.core.NetworkRequest;
import io.bidmachine.protobuf.AdExtension;
import io.bidmachine.protobuf.analytics.events.SDKEvent;
import io.bidmachine.protobuf.sdk.Error;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.ProtoUtils;
import io.bidmachine.utils.lazy.LazyValue;

/* loaded from: classes8.dex */
public class EventTrackerImpl implements EventTracker {
    private AdExtension.EventConfiguration defaultEventConfiguration;

    public EventTrackerImpl() {
        this(null);
    }

    public EventTrackerImpl(AdExtension.EventConfiguration defaultEventConfiguration) {
        setDefaultEventConfiguration(defaultEventConfiguration);
    }

    public void setDefaultEventConfiguration(AdExtension.EventConfiguration defaultEventConfiguration) {
        if (defaultEventConfiguration != null && defaultEventConfiguration.equals(AdExtension.EventConfiguration.getDefaultInstance())) {
            defaultEventConfiguration = null;
        }
        this.defaultEventConfiguration = defaultEventConfiguration;
    }

    @Override // io.bidmachine.tracking.EventTracker
    public void trackEvent(TrackingObject trackingObject, TrackEventType trackEventType, TrackEventInfo trackEventInfo, AdsType adsType, BMError bmError, EventData eventData) {
        long currentTimeMillis;
        long j;
        String str;
        Double d;
        Struct struct;
        if (bmError == null || bmError.isTrackError()) {
            if (trackEventInfo != null) {
                currentTimeMillis = trackEventInfo.getStartTimeMs();
                j = trackEventInfo.getFinishTimeMs();
            } else {
                currentTimeMillis = System.currentTimeMillis();
                j = currentTimeMillis;
            }
            if (eventData != null) {
                str = eventData.getNetworkName();
                d = eventData.getPrice();
                struct = eventData.getCustomParams();
            } else {
                str = null;
                d = null;
                struct = null;
            }
            int actionValue = trackEventType.getActionValue();
            if (trySendEvent(trackingObject.getEventConfiguration(), actionValue, currentTimeMillis, j, adsType, str, d, struct, bmError)) {
                return;
            }
            trySendEvent(this.defaultEventConfiguration, actionValue, currentTimeMillis, j, adsType, str, d, struct, bmError);
        }
    }

    private static boolean trySendEvent(AdExtension.EventConfiguration eventConfiguration, final int action, long startTimeMs, long finishTimeMs, AdsType adsType, String networkName, Double price, Struct customParams, final BMError bmError) {
        if (eventConfiguration != null) {
            try {
                if (eventConfiguration.getActionsList().contains(Integer.valueOf(action))) {
                    String url = eventConfiguration.getUrl();
                    if (TextUtils.isEmpty(url)) {
                        return false;
                    }
                    if (bmError == null) {
                        Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.tracking.EventTrackerImpl$$ExternalSyntheticLambda0
                            @Override // io.bidmachine.utils.lazy.LazyValue
                            public final Object get() {
                                String format;
                                format = String.format("Sending event to server - %s", Integer.valueOf(action));
                                return format;
                            }
                        });
                    } else {
                        Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.tracking.EventTrackerImpl$$ExternalSyntheticLambda1
                            @Override // io.bidmachine.utils.lazy.LazyValue
                            public final Object get() {
                                String format;
                                format = String.format("Sending error event to server - %s, error - %s", Integer.valueOf(action), bmError);
                                return format;
                            }
                        });
                    }
                    SDKEvent.Builder finishTime = SDKEvent.newBuilder().setAction(action).setContext(eventConfiguration.getContext()).setStartTime(ProtoUtils.msToProtobufTimestamp(startTimeMs)).setFinishTime(ProtoUtils.msToProtobufTimestamp(finishTimeMs));
                    if (adsType != null) {
                        finishTime.setAdType(StringValue.newBuilder().setValue(adsType.getName()).build());
                    }
                    if (!TextUtils.isEmpty(networkName)) {
                        finishTime.setNetwork(StringValue.newBuilder().setValue(networkName).build());
                    }
                    if (price != null) {
                        finishTime.setPrice(price.doubleValue());
                    }
                    if (customParams != null) {
                        finishTime.setCustomParams(customParams);
                    }
                    if (bmError != null) {
                        Error.Builder error = Error.newBuilder().setError(toErrorData(bmError));
                        BMError errorExtension = bmError.getErrorExtension();
                        if (errorExtension != null) {
                            error.setReason(toErrorData(errorExtension));
                        }
                        finishTime.setError(error);
                    }
                    new ApiRequest.Builder().url(url).setMethod(NetworkRequest.Method.Post).setDataBinder(new ApiRequest.ApiEventDataBinder()).setRequestData(finishTime.build()).request();
                    return true;
                }
            } catch (Throwable th) {
                Logger.w(th);
            }
        }
        return false;
    }

    private static Error.Data toErrorData(BMError bmError) {
        return Error.Data.newBuilder().setCode(bmError.getCode()).setDescription(bmError.getMessage()).build();
    }
}
