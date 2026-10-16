package io.bidmachine;

import android.content.Context;
import com.explorestack.protobuf.Struct;
import io.bidmachine.analytics.AnalyticsConfig;
import io.bidmachine.analytics.BidMachineAnalytics;
import io.bidmachine.analytics.MonitorConfig;
import io.bidmachine.analytics.ReaderConfig;
import io.bidmachine.protobuf.InitResponse;
import io.bidmachine.protobuf.sdk.Configuration;
import io.bidmachine.protobuf.sdk.Monitor;
import io.bidmachine.protobuf.sdk.Reader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
class BidMachineAnalyticsInitializer {
    BidMachineAnalyticsInitializer() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void initialize(Context context) {
        try {
            BidMachineAnalytics.initialize(context);
        } catch (Throwable unused) {
        }
    }

    void configure(Context context, String currentSessionId, InitResponse initResponse, String initResponseSessionId) {
        try {
            if (initResponse.hasSdkAnalyticConfigV2()) {
                Configuration sdkAnalyticConfigV2 = initResponse.getSdkAnalyticConfigV2();
                List<MonitorConfig> mapMonitorConfigList = mapMonitorConfigList(sdkAnalyticConfigV2.getMonitorsList());
                List<ReaderConfig> mapReaderConfigList = mapReaderConfigList(sdkAnalyticConfigV2.getReadersList());
                Struct struct = initResponse.getExtras().getPrivate();
                String value = sdkAnalyticConfigV2.getBpk().getValue();
                BidMachineAnalytics.configure(context, new AnalyticsConfig(initResponseSessionId, mapMonitorConfigList, mapReaderConfigList, value, struct));
                if (currentSessionId.equals(initResponseSessionId)) {
                    return;
                }
                BidMachineAnalytics.configure(context, new AnalyticsConfig(currentSessionId, mapMonitorConfigList, mapReaderConfigList, value, struct));
            }
        } catch (Throwable unused) {
        }
    }

    private List<MonitorConfig> mapMonitorConfigList(List<Monitor.Configuration> protobufMonitorConfigList) {
        ArrayList arrayList = new ArrayList();
        for (Monitor.Configuration configuration : protobufMonitorConfigList) {
            arrayList.add(new MonitorConfig(configuration.getName().getValue(), configuration.getUrl().getValue(), configuration.getBatchSize().getValue(), configuration.getInterval().getValue(), configuration.hasShouldReport() ? configuration.getShouldReport().getValue() : false));
        }
        return arrayList;
    }

    private List<ReaderConfig> mapReaderConfigList(List<Reader.Configuration> protobufReaderConfigList) {
        ArrayList arrayList = new ArrayList();
        for (Reader.Configuration configuration : protobufReaderConfigList) {
            arrayList.add(new ReaderConfig(configuration.getName().getValue(), configuration.getUrl().getValue(), configuration.getUpdateInterval().getValue(), configuration.hasUniqueOnly() ? configuration.getUniqueOnly().getValue() : true, mapReaderRuleList(configuration.getRulesList())));
        }
        return arrayList;
    }

    private List<ReaderConfig.Rule> mapReaderRuleList(List<Reader.Rule> protobufRuleList) {
        ArrayList arrayList = new ArrayList();
        for (Reader.Rule rule : protobufRuleList) {
            if (rule.hasGeneralRule()) {
                Reader.Rule.GeneralRule generalRule = rule.getGeneralRule();
                arrayList.add(new ReaderConfig.Rule(generalRule.getTag().getValue(), generalRule.getPath().getValue()));
            }
        }
        return arrayList;
    }
}
