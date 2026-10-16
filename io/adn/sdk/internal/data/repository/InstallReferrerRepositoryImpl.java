package io.adn.sdk.internal.data.repository;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import io.adn.sdk.internal.data.mapper.InstallReferrerMapperKt;
import io.adn.sdk.internal.domain.model.ad.AttributionSource;
import io.adn.sdk.internal.domain.repository.InstallReferrerRepository;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: InstallReferrerRepositoryImpl.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lio/adn/sdk/internal/data/repository/InstallReferrerRepositoryImpl;", "Lio/adn/sdk/internal/domain/repository/InstallReferrerRepository;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getInstallReferrer", "Lio/adn/sdk/internal/domain/model/ad/AttributionSource;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class InstallReferrerRepositoryImpl implements InstallReferrerRepository {
    public static final int $stable = 8;
    private final Context context;

    public InstallReferrerRepositoryImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // io.adn.sdk.internal.domain.repository.InstallReferrerRepository
    public Object getInstallReferrer(Continuation<? super AttributionSource> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final InstallReferrerClient build = InstallReferrerClient.newBuilder(this.context).build();
        build.startConnection(new InstallReferrerStateListener() { // from class: io.adn.sdk.internal.data.repository.InstallReferrerRepositoryImpl$getInstallReferrer$2$1
            @Override // com.android.installreferrer.api.InstallReferrerStateListener
            public void onInstallReferrerSetupFinished(int responseCode) {
                if (responseCode == 0) {
                    ReferrerDetails installReferrer = InstallReferrerClient.this.getInstallReferrer();
                    CancellableContinuation<AttributionSource> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    Intrinsics.checkNotNull(installReferrer);
                    cancellableContinuation.resumeWith(Result.m10241constructorimpl(InstallReferrerMapperKt.mapToInstallReferrerAttributionSource(installReferrer)));
                    InstallReferrerClient.this.endConnection();
                    return;
                }
                InstallReferrerClient.this.endConnection();
                CancellableContinuation<AttributionSource> cancellableContinuation2 = cancellableContinuationImpl2;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m10241constructorimpl(AttributionSource.Unknown.INSTANCE));
            }

            @Override // com.android.installreferrer.api.InstallReferrerStateListener
            public void onInstallReferrerServiceDisconnected() {
                if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<AttributionSource> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m10241constructorimpl(AttributionSource.Unknown.INSTANCE));
                }
            }
        });
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: io.adn.sdk.internal.data.repository.InstallReferrerRepositoryImpl$getInstallReferrer$2$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                InstallReferrerClient.this.endConnection();
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
