package io.adn.sdk.internal.data.repository;

import kotlin.Metadata;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: AdFileLoaderImpl.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"CLASS_NAME", "", "DOWNLOAD_TIMEOUT", "Lkotlin/time/Duration;", "J", "FILE_COMMIT_TIME_MS", "", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdFileLoaderImplKt {
    private static final String CLASS_NAME = "AdFileLoader";
    private static final long DOWNLOAD_TIMEOUT = DurationKt.toDuration(120, DurationUnit.SECONDS);
    private static final long FILE_COMMIT_TIME_MS = 100;
}
