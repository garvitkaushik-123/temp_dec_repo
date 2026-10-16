package io.adn.unityplugin.internal.listeners;

import android.util.Log;
import io.adn.sdk.publisher.AdnInitializationCallback;
import io.adn.sdk.publisher.AdnInitializationStatus;
import io.adn.unityplugin.publisher.AdnUnityCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: InitializationCallback.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lio/adn/unityplugin/internal/listeners/InitializationCallback;", "Lio/adn/sdk/publisher/AdnInitializationCallback;", "unityCallback", "Lio/adn/unityplugin/publisher/AdnUnityCallback;", "<init>", "(Lio/adn/unityplugin/publisher/AdnUnityCallback;)V", "onCompletion", "", "status", "Lio/adn/sdk/publisher/AdnInitializationStatus;", "forwardUnityEvent", "isSuccess", "", "buildSdkInitializedArgs", "Lorg/json/JSONObject;", "adn-unityplugin_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class InitializationCallback implements AdnInitializationCallback {
    private final AdnUnityCallback unityCallback;

    /* compiled from: InitializationCallback.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdnInitializationStatus.values().length];
            try {
                iArr[AdnInitializationStatus.INITIALIZED_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AdnInitializationStatus.INITIALIZED_FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public InitializationCallback(AdnUnityCallback adnUnityCallback) {
        this.unityCallback = adnUnityCallback;
    }

    @Override // io.adn.sdk.publisher.AdnInitializationCallback
    public void onCompletion(AdnInitializationStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        if (i == 1) {
            forwardUnityEvent(true);
        } else {
            if (i != 2) {
                return;
            }
            forwardUnityEvent(false);
        }
    }

    private final void forwardUnityEvent(boolean isSuccess) {
        Object m10241constructorimpl;
        Unit unit;
        try {
            Result.Companion companion = Result.INSTANCE;
            InitializationCallback initializationCallback = this;
            AdnUnityCallback adnUnityCallback = this.unityCallback;
            if (adnUnityCallback != null) {
                String jSONObject = buildSdkInitializedArgs(isSuccess).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
                adnUnityCallback.onEvent(jSONObject);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            m10241constructorimpl = Result.m10241constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl != null) {
            Log.e("AdnSdk", "[AdnUnityPlugin] ERROR: Failed to forward unity event OnSdkInitializedEvent - " + m10244exceptionOrNullimpl.getMessage());
        }
    }

    private final JSONObject buildSdkInitializedArgs(boolean isSuccess) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", "OnSdkInitializedEvent");
        jSONObject.put("isSuccessfullyInitialized", isSuccess);
        return jSONObject;
    }
}
