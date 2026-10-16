package io.adn.sdk.internal.domain.repository;

import java.io.File;
import kotlin.Metadata;

/* compiled from: StorageRepository.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lio/adn/sdk/internal/domain/repository/StorageRepository;", "", "createFileFromUrl", "Ljava/io/File;", "url", "", "createTempFile", "cleanup", "", "isCachedFileAvailable", "", "ttlMillis", "", "getCachedFile", "fallbackAssetName", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface StorageRepository {
    void cleanup();

    File createFileFromUrl(String url);

    File createTempFile();

    File getCachedFile(String url, String fallbackAssetName);

    boolean isCachedFileAvailable(String url, long ttlMillis);
}
