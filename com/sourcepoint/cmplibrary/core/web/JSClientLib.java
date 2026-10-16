package com.sourcepoint.cmplibrary.core.web;

import android.view.View;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.Metadata;

/* compiled from: JSClientLib.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\b`\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\bH&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\bH&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\bH&¨\u0006\u0019"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/web/JSClientLib;", "", "dismiss", "", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", "log", NotificationCompat.CATEGORY_MESSAGE, "", "tag", "onAction", "actionData", "Lcom/sourcepoint/cmplibrary/core/web/IConsentWebView;", "nextCampaign", "Lcom/sourcepoint/cmplibrary/core/web/CampaignModel;", "onConsentUIReady", "isFromPM", "", "onError", "errorMessage", "error", "", "onNoIntentActivitiesFoundFor", "url", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface JSClientLib {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void dismiss(View view);

    void log(View view, String msg);

    void log(View view, String tag, String msg);

    void onAction(View view, String actionData);

    void onAction(IConsentWebView view, String actionData, CampaignModel nextCampaign);

    void onConsentUIReady(View view, boolean isFromPM);

    void onError(View view, String errorMessage);

    void onError(View view, Throwable error);

    void onNoIntentActivitiesFoundFor(View view, String url);

    /* compiled from: JSClientLib.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/web/JSClientLib$Companion;", "", "()V", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
