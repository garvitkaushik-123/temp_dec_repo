package io.adn.sdk.internal.domain.usecase;

import io.adn.sdk.internal.domain.repository.AdMeasurementInitializer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: InitializeAdMeasurementUseCase.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0011H\u0086\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/internal/domain/usecase/InitializeAdMeasurementUseCase;", "", "adMeasurementInitializer", "Lio/adn/sdk/internal/domain/repository/AdMeasurementInitializer;", "fetchOmSdkJsUseCase", "Lio/adn/sdk/internal/domain/usecase/FetchOmSdkJsUseCase;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lio/adn/sdk/internal/domain/repository/AdMeasurementInitializer;Lio/adn/sdk/internal/domain/usecase/FetchOmSdkJsUseCase;Lkotlinx/coroutines/CoroutineScope;)V", "getAdMeasurementInitializer", "()Lio/adn/sdk/internal/domain/repository/AdMeasurementInitializer;", "getFetchOmSdkJsUseCase", "()Lio/adn/sdk/internal/domain/usecase/FetchOmSdkJsUseCase;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "invoke", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class InitializeAdMeasurementUseCase {
    public static final int $stable = 8;
    private final AdMeasurementInitializer adMeasurementInitializer;
    private final FetchOmSdkJsUseCase fetchOmSdkJsUseCase;
    private final CoroutineScope scope;

    public InitializeAdMeasurementUseCase(AdMeasurementInitializer adMeasurementInitializer, FetchOmSdkJsUseCase fetchOmSdkJsUseCase, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(adMeasurementInitializer, "adMeasurementInitializer");
        Intrinsics.checkNotNullParameter(fetchOmSdkJsUseCase, "fetchOmSdkJsUseCase");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.adMeasurementInitializer = adMeasurementInitializer;
        this.fetchOmSdkJsUseCase = fetchOmSdkJsUseCase;
        this.scope = scope;
    }

    public final AdMeasurementInitializer getAdMeasurementInitializer() {
        return this.adMeasurementInitializer;
    }

    public final FetchOmSdkJsUseCase getFetchOmSdkJsUseCase() {
        return this.fetchOmSdkJsUseCase;
    }

    public /* synthetic */ InitializeAdMeasurementUseCase(AdMeasurementInitializer adMeasurementInitializer, FetchOmSdkJsUseCase fetchOmSdkJsUseCase, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(adMeasurementInitializer, fetchOmSdkJsUseCase, (i & 4) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()) : coroutineScope);
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final void invoke() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new InitializeAdMeasurementUseCase$invoke$1(this, null), 3, null);
    }
}
