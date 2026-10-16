package com.sourcepoint.cmplibrary;

import android.view.View;
import com.mbridge.msdk.MBridgeConstans;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.exposed.NativeMessageActionType;
import kotlin.Metadata;

/* compiled from: NativeMessageController.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u0010"}, d2 = {"Lcom/sourcepoint/cmplibrary/NativeMessageController;", "", "removeNativeView", "", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", "sendConsent", "action", "Lcom/sourcepoint/cmplibrary/model/exposed/NativeMessageActionType;", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "showNativeView", "showOptionNativeMessage", "pmId", "", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface NativeMessageController {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void removeNativeView(View view);

    void sendConsent(NativeMessageActionType action, CampaignType campaignType);

    void showNativeView(View view);

    void showOptionNativeMessage(CampaignType campaignType, String pmId);

    /* compiled from: NativeMessageController.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sourcepoint/cmplibrary/NativeMessageController$Companion;", "", "()V", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
