package io.adn.sdk.internal.domain.repository;

import kotlin.Metadata;

/* compiled from: InstallReferrerStorage.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lio/adn/sdk/internal/domain/repository/InstallReferrerStorage;", "", "isAlreadySent", "", "markAsSent", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface InstallReferrerStorage {
    boolean isAlreadySent();

    void markAsSent();
}
