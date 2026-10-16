package com.sourcepoint.cmplibrary.util;

import android.view.View;
import com.mbridge.msdk.MBridgeConstans;
import com.sourcepoint.cmplibrary.SpConsentLibImpl;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.core.web.CampaignModel;
import com.sourcepoint.cmplibrary.core.web.IConsentWebView;
import com.sourcepoint.cmplibrary.model.exposed.MessageType;
import java.util.Queue;
import kotlin.Metadata;

/* compiled from: ViewsManager.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fJ9\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bR\u00020\t2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u0010JG\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bR\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u0018\u001a\u00020\u0016H&J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001bH&J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006 "}, d2 = {"Lcom/sourcepoint/cmplibrary/util/ViewsManager;", "", "isViewInLayout", "", "()Z", "createWebView", "Lcom/sourcepoint/cmplibrary/core/Either;", "Lcom/sourcepoint/cmplibrary/core/web/IConsentWebView;", "lib", "Lcom/sourcepoint/cmplibrary/SpConsentLibImpl;", "jsReceiverDelegate", "Lcom/sourcepoint/cmplibrary/SpConsentLibImpl$JSReceiverDelegate;", "messageType", "Lcom/sourcepoint/cmplibrary/model/exposed/MessageType;", "cmpViewId", "", "(Lcom/sourcepoint/cmplibrary/SpConsentLibImpl;Lcom/sourcepoint/cmplibrary/SpConsentLibImpl$JSReceiverDelegate;Lcom/sourcepoint/cmplibrary/model/exposed/MessageType;Ljava/lang/Integer;)Lcom/sourcepoint/cmplibrary/core/Either;", "campaignQueue", "Ljava/util/Queue;", "Lcom/sourcepoint/cmplibrary/core/web/CampaignModel;", "(Lcom/sourcepoint/cmplibrary/SpConsentLibImpl;Lcom/sourcepoint/cmplibrary/SpConsentLibImpl$JSReceiverDelegate;Ljava/util/Queue;Lcom/sourcepoint/cmplibrary/model/exposed/MessageType;Ljava/lang/Integer;)Lcom/sourcepoint/cmplibrary/core/Either;", "dispose", "", "handleOnBackPress", "removeAllViews", "removeAllViewsExcept", "pView", "Landroid/view/View;", "removeView", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "showView", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ViewsManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    Either<IConsentWebView> createWebView(SpConsentLibImpl lib, SpConsentLibImpl.JSReceiverDelegate jsReceiverDelegate, MessageType messageType, Integer cmpViewId);

    Either<IConsentWebView> createWebView(SpConsentLibImpl lib, SpConsentLibImpl.JSReceiverDelegate jsReceiverDelegate, Queue<CampaignModel> campaignQueue, MessageType messageType, Integer cmpViewId);

    void dispose();

    void handleOnBackPress();

    boolean isViewInLayout();

    void removeAllViews();

    void removeAllViewsExcept(View pView);

    void removeView(View view);

    void showView(View view);

    /* compiled from: ViewsManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sourcepoint/cmplibrary/util/ViewsManager$Companion;", "", "()V", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
