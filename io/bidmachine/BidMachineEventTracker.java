package io.bidmachine;

import android.text.TextUtils;
import io.bidmachine.ApiRequest;
import io.bidmachine.core.Logger;
import io.bidmachine.core.NetworkRequest;
import io.bidmachine.tracking.EventData;
import io.bidmachine.tracking.EventTracker;
import io.bidmachine.tracking.TrackEventInfo;
import io.bidmachine.tracking.TrackingObject;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
class BidMachineEventTracker implements EventTracker {
    BidMachineEventTracker() {
    }

    @Override // io.bidmachine.tracking.EventTracker
    public void trackEvent(TrackingObject trackingObject, TrackEventType trackEventType, TrackEventInfo trackEventInfo, AdsType adsType, BMError bmError, EventData eventData) {
        if (bmError != null) {
            trackError(collectTrackingUrls(trackingObject, TrackEventType.Error), collectTrackingUrls(trackingObject, TrackEventType.TrackingError), trackEventInfo, trackEventType.getActionValue(), bmError);
        } else {
            trackEvent(collectTrackingUrls(trackingObject, trackEventType), collectTrackingUrls(trackingObject, TrackEventType.TrackingError), trackEventInfo, trackEventType, eventData);
        }
    }

    private static List<String> collectTrackingUrls(TrackingObject trackingObject, TrackEventType trackEventType) {
        List<String> trackingUrls = BidMachineImpl.get().getTrackingUrls(trackEventType);
        ArrayList arrayList = trackingUrls != null ? new ArrayList(trackingUrls) : null;
        List<String> trackingUrls2 = trackingObject.getTrackingUrls(trackEventType);
        if (trackingUrls2 != null) {
            if (arrayList == null) {
                return new ArrayList(trackingUrls2);
            }
            arrayList.addAll(trackingUrls2);
        }
        return arrayList;
    }

    private static void trackEvent(List<String> trackingUrls, final List<String> trackingErrorUrls, final TrackEventInfo trackEventInfo, final TrackEventType trackEventType, EventData eventData) {
        if (trackingUrls == null) {
            return;
        }
        Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachineEventTracker$$ExternalSyntheticLambda2
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                String format;
                format = String.format("Dispatching event to server - %s", TrackEventType.this);
                return format;
            }
        });
        Iterator<String> it = trackingUrls.iterator();
        while (it.hasNext()) {
            executeNotify(replaceMacros(it.next(), trackEventInfo, trackEventType.getActionValue(), -1, eventData), new NetworkRequest.Callback<String, BMError>() { // from class: io.bidmachine.BidMachineEventTracker.1
                @Override // io.bidmachine.core.NetworkRequest.Callback
                public void onSuccess(String result) {
                }

                @Override // io.bidmachine.core.NetworkRequest.Callback
                public void onFail(BMError result) {
                    if (result == null) {
                        result = BMError.internal("Failed to track URL");
                    }
                    BidMachineEventTracker.trackTrackingError(trackingErrorUrls, trackEventInfo, trackEventType.getActionValue(), result);
                }
            });
        }
    }

    private static void trackError(List<String> urls, final List<String> trackErrorUrls, final TrackEventInfo trackEventInfo, final int processCode, final BMError bmError) {
        if (urls != null && bmError.isTrackError()) {
            Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachineEventTracker$$ExternalSyntheticLambda1
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String format;
                    format = String.format("Dispatching error event to server - (%s-%s) - %s", Integer.valueOf(processCode), Integer.valueOf(r1.getCode()), bmError.getMessage());
                    return format;
                }
            });
            Iterator<String> it = urls.iterator();
            while (it.hasNext()) {
                executeNotify(replaceMacros(it.next(), trackEventInfo, processCode, bmError.getCode(), null), new NetworkRequest.Callback<String, BMError>() { // from class: io.bidmachine.BidMachineEventTracker.2
                    @Override // io.bidmachine.core.NetworkRequest.Callback
                    public void onSuccess(String s) {
                    }

                    @Override // io.bidmachine.core.NetworkRequest.Callback
                    public void onFail(BMError result) {
                        if (result == null) {
                            result = BMError.internal("Failed to track URL");
                        }
                        BidMachineEventTracker.trackTrackingError(trackErrorUrls, trackEventInfo, TrackEventType.Error.getActionValue(), result);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void trackTrackingError(List<String> urls, TrackEventInfo trackEventInfo, int processCode, final BMError bmError) {
        if (urls != null && bmError.isTrackError()) {
            Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachineEventTracker$$ExternalSyntheticLambda0
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String format;
                    format = String.format("Dispatching tracking fail to server - %s", BMError.this);
                    return format;
                }
            });
            Iterator<String> it = urls.iterator();
            while (it.hasNext()) {
                executeNotify(replaceMacros(it.next(), trackEventInfo, processCode, bmError.getCode(), null), null);
            }
        }
    }

    static String replaceMacros(String url, TrackEventInfo trackEventInfo, int processCode, int errorCode, EventData eventData) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        String replaceMacros = replaceMacros(replaceMacros(replaceMacros(url, Constants.URL_MACROS_BM_EVENT_CODE, Integer.valueOf(processCode)), Constants.URL_MACROS_BM_ACTION_CODE, Integer.valueOf(processCode)), Constants.URL_MACROS_BM_ERROR_REASON, Integer.valueOf(errorCode));
        if (eventData != null) {
            String networkName = eventData.getNetworkName();
            if (networkName != null) {
                replaceMacros = replaceMacros(replaceMacros, Constants.URL_MACROS_AUCTION_SEAT_ID, networkName);
            }
            Double price = eventData.getPrice();
            if (price != null) {
                replaceMacros = replaceMacros(replaceMacros, Constants.URL_MACROS_AUCTION_PRICE, price);
            }
        }
        return trackEventInfo != null ? replaceMacros(replaceMacros(replaceMacros(replaceMacros, Constants.URL_MACROS_BM_ACTION_START, Long.valueOf(trackEventInfo.getStartTimeMs())), Constants.URL_MACROS_BM_ACTION_FINISH, Long.valueOf(trackEventInfo.getFinishTimeMs())), trackEventInfo.getEventParameters()) : replaceMacros;
    }

    private static String replaceMacros(String url, Map<String, Object> eventParameters) {
        if (eventParameters != null) {
            for (Map.Entry<String, Object> entry : eventParameters.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null) {
                    url = replaceMacros(url, key, value);
                }
            }
        }
        return url;
    }

    private static String replaceMacros(String url, String macros, Object replace) {
        return url.replace("${" + macros + "}", String.valueOf(replace)).replace("%24%7B" + macros + "%7D", String.valueOf(replace));
    }

    private static void executeNotify(String url, NetworkRequest.Callback<String, BMError> callback) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        new ApiRequest.Builder().url(url).setMethod(NetworkRequest.Method.Get).setDataBinder(new ApiRequest.ApiTrackerDataBinder()).setCallback(callback).request();
    }
}
