package io.bidmachine;

import android.text.TextUtils;
import io.bidmachine.AdRequest;
import io.bidmachine.core.Logger;
import io.bidmachine.models.AuctionResult;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.lazy.LazyValue;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class BidMachineFetcher {
    public static final String AD_TYPE_DISPLAY = "display";
    public static final String AD_TYPE_NATIVE = "native";
    public static final String AD_TYPE_VIDEO = "video";
    public static final String KEY_AD_TYPE = "bm_ad_type";
    public static final String KEY_ID = "bm_id";
    public static final String KEY_NETWORK_KEY = "bm_network_key";
    public static final String KEY_PRICE = "bm_pf";
    private static final String TAG = "BidMachineFetcher";
    private static final BigDecimal PRICE_ROUNDING = new BigDecimal("0.01");
    private static final RoundingMode PRICE_ROUNDING_MODE = RoundingMode.CEILING;
    static EnumMap<AdsType, Map<String, AdRequest>> cachedRequests = new EnumMap<>(AdsType.class);

    public static Map<String, String> fetch(final AdRequest adRequest) {
        Logger.d(TAG, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachineFetcher$$ExternalSyntheticLambda0
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                String format;
                format = String.format("fetch - %s", AdRequest.this);
                return format;
            }
        });
        Map<String, String> map = toMap(adRequest);
        String str = map.get(KEY_ID);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AdsType adsType = adRequest.getAdsType();
        adRequest.addListener(new AdRequest.AdRequestListener() { // from class: io.bidmachine.BidMachineFetcher.1
            @Override // io.bidmachine.AdRequest.AdRequestListener
            public void onRequestFailed(AdRequest adRequest2, BMError bmError) {
            }

            @Override // io.bidmachine.AdRequest.AdRequestListener
            public void onRequestSuccess(AdRequest adRequest2, AuctionResult auctionResult) {
            }

            @Override // io.bidmachine.AdRequest.AdRequestListener
            public void onRequestExpired(AdRequest adRequest2) {
                BidMachineFetcher.release(adRequest2);
            }
        });
        synchronized (BidMachineFetcher.class) {
            Map<String, AdRequest> map2 = cachedRequests.get(adsType);
            if (map2 == null) {
                map2 = new HashMap<>();
                cachedRequests.put((EnumMap<AdsType, Map<String, AdRequest>>) adsType, (AdsType) map2);
            }
            map2.put(str, adRequest);
        }
        return map;
    }

    public static <T extends AdRequest> T release(T t) {
        AuctionResult auctionResult = t.getAuctionResult();
        if (auctionResult != null) {
            return (T) release(t.getAdsType(), auctionResult.getId());
        }
        return null;
    }

    public static <T extends AdRequest> T release(AdsType adsType, Map<String, String> map) {
        return (T) release(adsType, map.get(KEY_ID));
    }

    public static <T extends AdRequest> T release(AdsType adsType, final String requestId) {
        if (TextUtils.isEmpty(requestId)) {
            return null;
        }
        Logger.d(TAG, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachineFetcher$$ExternalSyntheticLambda1
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                String format;
                format = String.format("release - %s", requestId);
                return format;
            }
        });
        synchronized (BidMachineFetcher.class) {
            Map<String, AdRequest> map = cachedRequests.get(adsType);
            if (map == null) {
                return null;
            }
            try {
                return (T) map.remove(requestId);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static Map<String, String> toMap(final AdRequest adRequest) {
        Logger.d(TAG, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachineFetcher$$ExternalSyntheticLambda2
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                String format;
                format = String.format("toMap - %s", AdRequest.this);
                return format;
            }
        });
        HashMap hashMap = new HashMap();
        AuctionResult auctionResult = adRequest.getAuctionResult();
        if (auctionResult == null) {
            return hashMap;
        }
        hashMap.put(KEY_ID, auctionResult.getId());
        hashMap.put(KEY_PRICE, roundPrice(auctionResult.getPrice()));
        hashMap.put(KEY_NETWORK_KEY, auctionResult.getNetworkKey());
        String identifyAdType = identifyAdType(auctionResult.getCreativeFormat());
        if (identifyAdType != null) {
            hashMap.put(KEY_AD_TYPE, identifyAdType);
        }
        hashMap.putAll(auctionResult.getCustomParams());
        return hashMap;
    }

    /* renamed from: io.bidmachine.BidMachineFetcher$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$CreativeFormat;

        static {
            int[] iArr = new int[CreativeFormat.values().length];
            $SwitchMap$io$bidmachine$CreativeFormat = iArr;
            try {
                iArr[CreativeFormat.Banner.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$bidmachine$CreativeFormat[CreativeFormat.Video.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$bidmachine$CreativeFormat[CreativeFormat.Native.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static String identifyAdType(CreativeFormat creativeFormat) {
        if (creativeFormat == null) {
            return null;
        }
        int i = AnonymousClass2.$SwitchMap$io$bidmachine$CreativeFormat[creativeFormat.ordinal()];
        if (i == 1) {
            return "display";
        }
        if (i == 2) {
            return "video";
        }
        if (i != 3) {
            return null;
        }
        return "native";
    }

    private static String roundPrice(double price) {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(price));
        BigDecimal bigDecimal2 = PRICE_ROUNDING;
        if (bigDecimal2.signum() != 0) {
            bigDecimal = bigDecimal.divide(bigDecimal2, 0, PRICE_ROUNDING_MODE).multiply(bigDecimal2);
        }
        return bigDecimal.setScale(bigDecimal2.scale(), RoundingMode.HALF_UP).toString();
    }
}
