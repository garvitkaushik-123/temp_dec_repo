package io.adn.sdk.internal.di.modules;

import io.adn.sdk.internal.data.api.local.ExternalDataSourceImpl;
import io.adn.sdk.internal.domain.repository.ExternalDataSource;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: DataSourceModule.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\"\u001b\u0010\u0002\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"externalData", "Lio/adn/sdk/internal/domain/repository/ExternalDataSource;", "externalDataSourceInstance", "Lio/adn/sdk/internal/data/api/local/ExternalDataSourceImpl;", "getExternalDataSourceInstance", "()Lio/adn/sdk/internal/data/api/local/ExternalDataSourceImpl;", "externalDataSourceInstance$delegate", "Lkotlin/Lazy;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DataSourceModuleKt {
    private static final Lazy externalDataSourceInstance$delegate = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.DataSourceModuleKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ExternalDataSourceImpl externalDataSourceInstance_delegate$lambda$0;
            externalDataSourceInstance_delegate$lambda$0 = DataSourceModuleKt.externalDataSourceInstance_delegate$lambda$0();
            return externalDataSourceInstance_delegate$lambda$0;
        }
    });

    public static final ExternalDataSource externalData() {
        return getExternalDataSourceInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExternalDataSourceImpl externalDataSourceInstance_delegate$lambda$0() {
        return new ExternalDataSourceImpl();
    }

    private static final ExternalDataSourceImpl getExternalDataSourceInstance() {
        return (ExternalDataSourceImpl) externalDataSourceInstance$delegate.getValue();
    }
}
