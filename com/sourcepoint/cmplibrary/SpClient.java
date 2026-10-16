package com.sourcepoint.cmplibrary;

import android.view.View;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.sourcepoint.cmplibrary.core.nativemessage.MessageStructure;
import com.sourcepoint.cmplibrary.model.ConsentAction;
import com.sourcepoint.cmplibrary.model.exposed.SPConsents;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: SpClient.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\nH&J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u001c"}, d2 = {"Lcom/sourcepoint/cmplibrary/SpClient;", "", "onAction", "Lcom/sourcepoint/cmplibrary/model/ConsentAction;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", MRAIDPresenter.CONSENT_ACTION, "onConsentReady", "", C3040d4.i.b0, "Lcom/sourcepoint/cmplibrary/model/exposed/SPConsents;", "onError", "error", "", "onMessageReady", PglCryptUtils.KEY_MESSAGE, "Lorg/json/JSONObject;", "onNativeMessageReady", "Lcom/sourcepoint/cmplibrary/core/nativemessage/MessageStructure;", "messageController", "Lcom/sourcepoint/cmplibrary/NativeMessageController;", "onNoIntentActivitiesFound", "url", "", "onSpFinished", "sPConsents", "onUIFinished", "onUIReady", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface SpClient {
    ConsentAction onAction(View view, ConsentAction consentAction);

    void onConsentReady(SPConsents consent);

    void onError(Throwable error);

    @Deprecated(message = "onMessageReady callback will be removed in favor of onUIReady. Currently this callback is disabled.")
    void onMessageReady(JSONObject message);

    void onNativeMessageReady(MessageStructure message, NativeMessageController messageController);

    void onNoIntentActivitiesFound(String url);

    void onSpFinished(SPConsents sPConsents);

    void onUIFinished(View view);

    void onUIReady(View view);
}
