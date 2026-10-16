package io.bidmachine;

import io.bidmachine.core.Logger;
import io.bidmachine.protobuf.AdCachePlacementControl;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
class AdResponseManager {
    static final int DEF_BUSY_LIMIT = 2;
    static final int DEF_MAX_CACHE_SIZE = 8;
    private static final String TAG = "AdResponseManager";
    private static final Map<String, AdCachePlacementControl> adCachePlacementControlMap = new ConcurrentHashMap();
    private static volatile AdResponseManager instance;
    private final Object lock = new Object();
    private final List<AdResponse> adResponseList = new ArrayList();

    AdResponseManager() {
    }

    public static AdResponseManager get() {
        AdResponseManager adResponseManager;
        AdResponseManager adResponseManager2 = instance;
        if (adResponseManager2 != null) {
            return adResponseManager2;
        }
        synchronized (AdResponseManager.class) {
            adResponseManager = instance;
            if (adResponseManager == null) {
                adResponseManager = new AdResponseManager();
                instance = adResponseManager;
            }
        }
        return adResponseManager;
    }

    boolean contains(AdResponse adResponse) {
        boolean contains;
        synchronized (this.lock) {
            contains = this.adResponseList.contains(adResponse);
        }
        return contains;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x009b A[Catch: all -> 0x00ae, TryCatch #0 {, blocks: (B:8:0x0014, B:9:0x0023, B:11:0x0029, B:14:0x003a, B:30:0x0046, B:17:0x0054, B:20:0x005c, B:41:0x0062, B:44:0x006c, B:46:0x0072, B:48:0x0079, B:51:0x0087, B:54:0x008f, B:56:0x009b, B:57:0x00a5, B:59:0x00a7, B:60:0x00ac), top: B:7:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a5 A[Catch: all -> 0x00ae, DONT_GENERATE, TryCatch #0 {, blocks: (B:8:0x0014, B:9:0x0023, B:11:0x0029, B:14:0x003a, B:30:0x0046, B:17:0x0054, B:20:0x005c, B:41:0x0062, B:44:0x006c, B:46:0x0072, B:48:0x0079, B:51:0x0087, B:54:0x008f, B:56:0x009b, B:57:0x00a5, B:59:0x00a7, B:60:0x00ac), top: B:7:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void store(final AdResponse adResponse) {
        if (adResponse.canCache()) {
            Logger.d(TAG, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponseManager$$ExternalSyntheticLambda2
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String format;
                    format = String.format("store - %s", AdResponse.this);
                    return format;
                }
            });
            synchronized (this.lock) {
                AdRequestParameters adRequestParameters = adResponse.getAdRequestParameters();
                AdResponse adResponse2 = null;
                int i = 0;
                int i2 = 0;
                AdResponse adResponse3 = null;
                for (AdResponse adResponse4 : this.adResponseList) {
                    if (adRequestParameters.isParametersMatched(adResponse4.getAdRequestParameters())) {
                        i2++;
                        if (adResponse4.getStatus() == AdResponseStatus.Idle) {
                            if (adResponse3 == null || adResponse3.getPrice() > adResponse4.getPrice()) {
                                adResponse3 = adResponse4;
                            }
                        } else if (adResponse4.getStatus() == AdResponseStatus.Busy) {
                            i++;
                            if (adResponse2 == null) {
                                adResponse2 = adResponse4;
                            }
                        }
                    }
                }
                if (adResponse.getStatus() == AdResponseStatus.Busy && adResponse2 != null && i >= getBusyLimitForAdsType(adRequestParameters)) {
                    adResponse2.setStatus(AdResponseStatus.Idle);
                    if (adResponse3 != null) {
                        if (adResponse3.getPrice() > adResponse2.getPrice()) {
                        }
                    }
                    if (i2 >= getMaxCacheSizeForAdsType(adRequestParameters) && adResponse2 != null) {
                        if (adResponse.getPrice() >= adResponse2.getPrice()) {
                            return;
                        }
                        adResponse2.notifyExpired(true);
                        this.adResponseList.remove(adResponse2);
                    }
                    this.adResponseList.add(adResponse);
                }
                adResponse2 = adResponse3;
                if (i2 >= getMaxCacheSizeForAdsType(adRequestParameters)) {
                    if (adResponse.getPrice() >= adResponse2.getPrice()) {
                    }
                }
                this.adResponseList.add(adResponse);
            }
        }
    }

    AdResponse receive(AdRequestParameters adRequestParameters) {
        synchronized (this.lock) {
            int busyLimitForAdsType = getBusyLimitForAdsType(adRequestParameters);
            int i = 0;
            final AdResponse adResponse = null;
            AdResponse adResponse2 = null;
            for (AdResponse adResponse3 : this.adResponseList) {
                if (!adResponse3.wasShown() && adRequestParameters.isParametersMatched(adResponse3.getAdRequestParameters())) {
                    if (adResponse3.getStatus() == AdResponseStatus.Idle) {
                        if (adResponse == null || adResponse3.getPrice() > adResponse.getPrice()) {
                            adResponse = adResponse3;
                        }
                    } else if (adResponse3.getStatus() == AdResponseStatus.Busy) {
                        i++;
                        if (adResponse2 == null) {
                            adResponse2 = adResponse3;
                        }
                        if (i >= busyLimitForAdsType) {
                            adResponse2.expireAdRequests(null);
                            adResponse2.clearAdRequestList();
                            adResponse2.setStatus(AdResponseStatus.Idle);
                            if (adResponse == null || adResponse2.getPrice() >= adResponse.getPrice()) {
                                adResponse = adResponse2;
                            }
                        }
                    }
                }
            }
            if (adResponse == null || !adRequestParameters.isPricePassedByPriceFloor(adResponse.getPrice())) {
                return null;
            }
            adResponse.setStatus(AdResponseStatus.Busy);
            Logger.d(TAG, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponseManager$$ExternalSyntheticLambda0
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String format;
                    format = String.format("receive - %s", AdResponse.this);
                    return format;
                }
            });
            this.adResponseList.remove(adResponse);
            this.adResponseList.add(adResponse);
            return adResponse;
        }
    }

    List<AdResponse> peek(AdRequestParameters adRequestParameters) {
        synchronized (this.lock) {
            ArrayList arrayList = new ArrayList();
            for (AdResponse adResponse : this.adResponseList) {
                if (adResponse.getStatus() == AdResponseStatus.Idle && adRequestParameters.isParametersMatched(adResponse.getAdRequestParameters())) {
                    arrayList.add(adResponse);
                }
            }
            if (arrayList.isEmpty()) {
                return arrayList;
            }
            Collections.sort(arrayList, new Comparator<AdResponse>() { // from class: io.bidmachine.AdResponseManager.1
                @Override // java.util.Comparator
                public int compare(AdResponse o1, AdResponse o2) {
                    return -Double.compare(o1.getPrice(), o2.getPrice());
                }
            });
            return arrayList.subList(0, Math.min(getBusyLimitForAdsType(adRequestParameters), arrayList.size()));
        }
    }

    void remove(final AdResponse adResponse) {
        Logger.d(TAG, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdResponseManager$$ExternalSyntheticLambda1
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                String format;
                format = String.format("remove - %s", AdResponse.this);
                return format;
            }
        });
        synchronized (this.lock) {
            this.adResponseList.remove(adResponse);
        }
    }

    int getMaxCacheSizeForAdsType(AdRequestParameters adRequestParameters) {
        AdCachePlacementControl adCachePlacementControl = getAdCachePlacementControl(adRequestParameters);
        int maxCacheSize = adCachePlacementControl != null ? adCachePlacementControl.getMaxCacheSize() : 0;
        if (maxCacheSize > 0) {
            return maxCacheSize;
        }
        return 8;
    }

    int getBusyLimitForAdsType(AdRequestParameters adRequestParameters) {
        AdCachePlacementControl adCachePlacementControl = getAdCachePlacementControl(adRequestParameters);
        int maxRetainCount = adCachePlacementControl != null ? adCachePlacementControl.getMaxRetainCount() : 0;
        if (maxRetainCount > 0) {
            return maxRetainCount;
        }
        return 2;
    }

    private AdCachePlacementControl getAdCachePlacementControl(AdRequestParameters adRequestParameters) {
        return adCachePlacementControlMap.get(adRequestParameters.getAdsType().getName());
    }

    int size() {
        return this.adResponseList.size();
    }

    static void reset() {
        setAdCachePlacementControlMap(null);
    }

    static void setAdCachePlacementControlMap(Map<String, AdCachePlacementControl> adCachePlacementControlMap2) {
        Map<String, AdCachePlacementControl> map = adCachePlacementControlMap;
        map.clear();
        if (adCachePlacementControlMap2 != null) {
            map.putAll(adCachePlacementControlMap2);
        }
    }
}
