package io.adn.sdk.internal.thirdparty.omsdk.omid;

import android.content.Context;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import io.adn.sdk.internal.domain.repository.AdMeasurementInitializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: OmidInitializer.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lio/adn/sdk/internal/thirdparty/omsdk/omid/OmidInitializer;", "Lio/adn/sdk/internal/domain/repository/AdMeasurementInitializer;", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", MobileAdsBridgeBase.initializeMethodName, "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class OmidInitializer implements AdMeasurementInitializer {
    public static final int $stable = 8;
    private final Context appContext;

    public OmidInitializer(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
    }

    @Override // io.adn.sdk.internal.domain.repository.AdMeasurementInitializer
    public Object initialize(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new OmidInitializer$initialize$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
