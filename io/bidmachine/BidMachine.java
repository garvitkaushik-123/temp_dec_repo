package io.bidmachine;

import android.content.Context;
import io.bidmachine.AdPlacementConfig;
import io.bidmachine.AdRequest;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.List;

/* loaded from: classes7.dex */
public class BidMachine {
    public static final String NAME = "BidMachine";
    private static final String TAG = "BidMachine";
    public static final String VERSION = "3.4.0";

    public static void initialize(Context context, String sourceId) {
        initialize(context, sourceId, null);
    }

    public static void initialize(Context context, final String sourceId, InitializationCallback callback) {
        Logger.d("BidMachine", (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachine$$ExternalSyntheticLambda9
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                String format;
                format = String.format("initialize - %s", sourceId);
                return format;
            }
        });
        BidMachineImpl.get().initialize(context, sourceId, callback);
    }

    public static boolean isInitialized() {
        return BidMachineImpl.get().isInitialized();
    }

    public static void setEndpoint(final String url) {
        Logger.d("BidMachine", (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachine$$ExternalSyntheticLambda5
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                String format;
                format = String.format("setEndpoint - %s", url);
                return format;
            }
        });
        UrlProvider.setEndpoint(url);
    }

    public static void setLoggingEnabled(boolean enabled) {
        if (Debugger.isLoggingLock()) {
            Logger.d("BidMachine", "setLoggingEnabled skipped");
            return;
        }
        if (enabled) {
            Logger.setLoggingEnabled(true);
            Logger.d("BidMachine", "setLoggingEnabled - true");
        } else {
            Logger.d("BidMachine", "setLoggingEnabled - false");
            Logger.setLoggingEnabled(false);
        }
        NetworkRegistry.setLoggingEnabled(enabled);
    }

    public static void setTestMode(final boolean testMode) {
        if (Debugger.isTestModeLock()) {
            Logger.d("BidMachine", "setTestMode skipped");
        } else {
            Logger.d("BidMachine", (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachine$$ExternalSyntheticLambda3
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String format;
                    format = String.format("setTestMode - %s", Boolean.valueOf(testMode));
                    return format;
                }
            });
            BidMachineImpl.get().setTestMode(testMode);
        }
    }

    public static void setTargetingParams(TargetingParams targetingParams) {
        Logger.d("BidMachine", "setTargetingParams");
        BidMachineImpl.get().setTargetingParams(targetingParams);
    }

    public static void setConsentConfig(final boolean hasConsent, final String consentString) {
        Logger.d("BidMachine", (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachine$$ExternalSyntheticLambda4
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                String format;
                format = String.format("setConsentConfig - %s, %s", Boolean.valueOf(hasConsent), consentString);
                return format;
            }
        });
        BidMachineImpl.get().getUserRestrictionParams().setConsentConfig(hasConsent, consentString);
    }

    public static void setSubjectToGDPR(final Boolean subject) {
        Logger.d("BidMachine", (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachine$$ExternalSyntheticLambda8
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                String format;
                format = String.format("setSubjectToGDPR - %s", subject);
                return format;
            }
        });
        BidMachineImpl.get().getUserRestrictionParams().setSubjectToGDPR(subject);
    }

    public static void setCoppa(final Boolean coppa) {
        Logger.d("BidMachine", (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachine$$ExternalSyntheticLambda0
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                String format;
                format = String.format("setCoppa - %s", coppa);
                return format;
            }
        });
        BidMachineImpl.get().getUserRestrictionParams().setCoppa(coppa);
    }

    public static void setUSPrivacyString(final String usPrivacyString) {
        Logger.d("BidMachine", (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachine$$ExternalSyntheticLambda6
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                String format;
                format = String.format("setUSPrivacyString - %s", usPrivacyString);
                return format;
            }
        });
        BidMachineImpl.get().getUserRestrictionParams().setUSPrivacyString(usPrivacyString);
    }

    public static void setGPP(final String gppString, final List<Integer> gppIds) {
        Logger.d("BidMachine", (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachine$$ExternalSyntheticLambda1
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                String format;
                format = String.format("setGPP - %s, [%s]", gppString, Utils.join(gppIds));
                return format;
            }
        });
        BidMachineImpl.get().getUserRestrictionParams().setGPP(gppString, gppIds);
    }

    public static void setPublisher(Publisher publisher) {
        Logger.d("BidMachine", "setPublisher");
        BidMachineImpl.get().setPublisher(publisher);
    }

    public static void registerNetworks(NetworkConfig... networkConfigs) {
        Logger.d("BidMachine", "registerNetworks with NetworkConfig array");
        NetworkRegistry.registerNetworks(networkConfigs);
    }

    public static void registerNetworks(Context context, String jsonData) {
        Logger.d("BidMachine", "registerNetworks with JSON string");
        NetworkRegistry.registerNetworks(context, jsonData);
    }

    public static void registerNetworks(Context context, String jsonData, NetworkRegistryCallback callback) {
        Logger.d("BidMachine", "registerNetworks with JSON string");
        NetworkRegistry.registerNetworks(context, jsonData, callback);
    }

    @Deprecated
    public static String getBidToken(Context context, AdsFormat adsFormat) {
        return getBidToken(context, new AdPlacementConfig.Builder(adsFormat).build());
    }

    public static String getBidToken(Context context, AdPlacementConfig adPlacementConfig) {
        final String createBidToken = BidTokenManager.createBidToken(context.getApplicationContext(), adPlacementConfig);
        Logger.d("BidMachine", (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachine$$ExternalSyntheticLambda2
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                String format;
                format = String.format("getBidToken - %s", createBidToken);
                return format;
            }
        });
        return createBidToken;
    }

    @Deprecated
    public static void getBidToken(Context context, AdsFormat adsFormat, final BidTokenCallback callback) {
        getBidToken(context, new AdPlacementConfig.Builder(adsFormat).build(), callback);
    }

    public static void getBidToken(Context context, final AdPlacementConfig adPlacementConfig, final BidTokenCallback callback) {
        final Context applicationContext = context.getApplicationContext();
        BidTokenTaskManager.execute(new Runnable() { // from class: io.bidmachine.BidMachine$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                BidTokenCallback.this.onCollected(BidMachine.getBidToken(applicationContext, adPlacementConfig));
            }
        });
    }

    public static Object getExtrasParam(Context context, String key) {
        return ExtraParamsManager.get().getPublic(context, key);
    }

    public static void registerAdRequestListener(AdRequest.AdRequestListener<?> adRequestListener) {
        Logger.d("BidMachine", "registerAdRequestListener");
        BidMachineImpl.get().registerAdRequestListener(adRequestListener);
    }

    public static void unregisterAdRequestListener(AdRequest.AdRequestListener<?> adRequestListener) {
        Logger.d("BidMachine", "unregisterAdRequestListener");
        BidMachineImpl.get().unregisterAdRequestListener(adRequestListener);
    }
}
