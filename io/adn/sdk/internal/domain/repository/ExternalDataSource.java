package io.adn.sdk.internal.domain.repository;

import com.ironsource.C3040d4;
import io.adn.sdk.internal.domain.model.config.SdkParameterKey;
import io.adn.sdk.internal.domain.model.privacy.PrivacyInfo;
import io.adn.sdk.publisher.AdnMediationType;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ExternalDataSource.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH&J\u001c\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000fH&J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0001H&J#\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0006\u0010\u0014\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u0002H\u0017H&¢\u0006\u0002\u0010\u001aJ\n\u0010(\u001a\u0004\u0018\u00010\tH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u001b\u001a\u00020\u001cX¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u00020\"X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u0018\u0010&\u001a\u00020\"X¦\u000e¢\u0006\f\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%¨\u0006)"}, d2 = {"Lio/adn/sdk/internal/domain/repository/ExternalDataSource;", "", "privacyInfo", "Lio/adn/sdk/internal/domain/model/privacy/PrivacyInfo;", "getPrivacyInfo", "()Lio/adn/sdk/internal/domain/model/privacy/PrivacyInfo;", "setPrivacyInfo", "(Lio/adn/sdk/internal/domain/model/privacy/PrivacyInfo;)V", "publisherSignalsJson", "", "getPublisherSignalsJson", "()Ljava/lang/String;", "setPublisherSignalsJson", "(Ljava/lang/String;)V", "publisherSignalsMap", "", "setPublisherSignals", "", "signals", "setSdkParameter", C3040d4.h.W, "value", "getSdkParameter", "T", "Lio/adn/sdk/internal/domain/model/config/SdkParameterKey;", "defaultValue", "(Lio/adn/sdk/internal/domain/model/config/SdkParameterKey;Ljava/lang/Object;)Ljava/lang/Object;", "mediationType", "Lio/adn/sdk/publisher/AdnMediationType;", "getMediationType", "()Lio/adn/sdk/publisher/AdnMediationType;", "setMediationType", "(Lio/adn/sdk/publisher/AdnMediationType;)V", "isTestMode", "", "()Z", "setTestMode", "(Z)V", "isAdsMuted", "setAdsMuted", "logExternalData", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface ExternalDataSource {
    AdnMediationType getMediationType();

    PrivacyInfo getPrivacyInfo();

    String getPublisherSignalsJson();

    <T> T getSdkParameter(SdkParameterKey key, T defaultValue);

    boolean isAdsMuted();

    boolean isTestMode();

    String logExternalData();

    Map<String, Object> publisherSignalsMap();

    void setAdsMuted(boolean z);

    void setMediationType(AdnMediationType adnMediationType);

    void setPrivacyInfo(PrivacyInfo privacyInfo);

    void setPublisherSignals(Map<String, ? extends Object> signals);

    void setPublisherSignalsJson(String str);

    void setSdkParameter(String key, Object value);

    void setTestMode(boolean z);
}
