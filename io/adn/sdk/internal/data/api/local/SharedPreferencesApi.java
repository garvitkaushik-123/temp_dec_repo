package io.adn.sdk.internal.data.api.local;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharedPreferencesApi.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/data/api/local/SharedPreferencesApi;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "sharedPreferences$delegate", "Lkotlin/Lazy;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class SharedPreferencesApi {
    public static final int $stable = 8;
    private final Context context;

    /* renamed from: sharedPreferences$delegate, reason: from kotlin metadata */
    private final Lazy sharedPreferences;

    public SharedPreferencesApi(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.sharedPreferences = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.data.api.local.SharedPreferencesApi$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SharedPreferences sharedPreferences_delegate$lambda$0;
                sharedPreferences_delegate$lambda$0 = SharedPreferencesApi.sharedPreferences_delegate$lambda$0(SharedPreferencesApi.this);
                return sharedPreferences_delegate$lambda$0;
            }
        });
    }

    public final SharedPreferences getSharedPreferences() {
        Object value = this.sharedPreferences.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (SharedPreferences) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedPreferences sharedPreferences_delegate$lambda$0(SharedPreferencesApi sharedPreferencesApi) {
        return sharedPreferencesApi.context.getSharedPreferences("ADN_SDK_PREFERENCES", 0);
    }
}
