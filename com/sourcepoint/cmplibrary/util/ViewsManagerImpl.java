package com.sourcepoint.cmplibrary.util;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.sourcepoint.cmplibrary.SpConsentLibImpl;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.core.ExecutorManager;
import com.sourcepoint.cmplibrary.core.web.CampaignModel;
import com.sourcepoint.cmplibrary.core.web.ConsentWebView;
import com.sourcepoint.cmplibrary.core.web.IConsentWebView;
import com.sourcepoint.cmplibrary.data.network.connection.ConnectionManager;
import com.sourcepoint.cmplibrary.exception.Logger;
import com.sourcepoint.cmplibrary.exception.WebViewCreationException;
import com.sourcepoint.cmplibrary.model.exposed.MessageType;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewsManager.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ9\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001f2\u0006\u0010 \u001a\u00020!2\n\u0010\"\u001a\u00060#R\u00020!2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010'JG\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001f2\u0006\u0010 \u001a\u00020!2\n\u0010\"\u001a\u00060#R\u00020!2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010+J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020-H\u0016J\b\u0010/\u001a\u00020-H\u0016J\u0010\u00100\u001a\u00020-2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020-2\u0006\u00104\u001a\u000202H\u0016J\u0010\u00105\u001a\u00020-2\u0006\u00104\u001a\u000202H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/sourcepoint/cmplibrary/util/ViewsManagerImpl;", "Lcom/sourcepoint/cmplibrary/util/ViewsManager;", "weakReference", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "connectionManager", "Lcom/sourcepoint/cmplibrary/data/network/connection/ConnectionManager;", "messageTimeout", "", "(Ljava/lang/ref/WeakReference;Lcom/sourcepoint/cmplibrary/data/network/connection/ConnectionManager;J)V", "getConnectionManager", "()Lcom/sourcepoint/cmplibrary/data/network/connection/ConnectionManager;", "idsSet", "Ljava/util/LinkedHashSet;", "", "getIdsSet", "()Ljava/util/LinkedHashSet;", "isViewInLayout", "", "()Z", "mainView", "Landroid/view/ViewGroup;", "getMainView", "()Landroid/view/ViewGroup;", "getMessageTimeout", "()J", "getWeakReference", "()Ljava/lang/ref/WeakReference;", C3040d4.h.K, "Lcom/sourcepoint/cmplibrary/core/web/IConsentWebView;", "createWebView", "Lcom/sourcepoint/cmplibrary/core/Either;", "lib", "Lcom/sourcepoint/cmplibrary/SpConsentLibImpl;", "jsReceiverDelegate", "Lcom/sourcepoint/cmplibrary/SpConsentLibImpl$JSReceiverDelegate;", "messageType", "Lcom/sourcepoint/cmplibrary/model/exposed/MessageType;", "cmpViewId", "(Lcom/sourcepoint/cmplibrary/SpConsentLibImpl;Lcom/sourcepoint/cmplibrary/SpConsentLibImpl$JSReceiverDelegate;Lcom/sourcepoint/cmplibrary/model/exposed/MessageType;Ljava/lang/Integer;)Lcom/sourcepoint/cmplibrary/core/Either;", "campaignQueue", "Ljava/util/Queue;", "Lcom/sourcepoint/cmplibrary/core/web/CampaignModel;", "(Lcom/sourcepoint/cmplibrary/SpConsentLibImpl;Lcom/sourcepoint/cmplibrary/SpConsentLibImpl$JSReceiverDelegate;Ljava/util/Queue;Lcom/sourcepoint/cmplibrary/model/exposed/MessageType;Ljava/lang/Integer;)Lcom/sourcepoint/cmplibrary/core/Either;", "dispose", "", "handleOnBackPress", "removeAllViews", "removeAllViewsExcept", "pView", "Landroid/view/View;", "removeView", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "showView", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
final class ViewsManagerImpl implements ViewsManager {
    private final ConnectionManager connectionManager;
    private final LinkedHashSet<Integer> idsSet;
    private final long messageTimeout;
    private final WeakReference<Activity> weakReference;
    private IConsentWebView webview;

    public ViewsManagerImpl(WeakReference<Activity> weakReference, ConnectionManager connectionManager, long j) {
        Intrinsics.checkNotNullParameter(weakReference, "weakReference");
        Intrinsics.checkNotNullParameter(connectionManager, "connectionManager");
        this.weakReference = weakReference;
        this.connectionManager = connectionManager;
        this.messageTimeout = j;
        this.idsSet = new LinkedHashSet<>();
    }

    public final WeakReference<Activity> getWeakReference() {
        return this.weakReference;
    }

    public final ConnectionManager getConnectionManager() {
        return this.connectionManager;
    }

    public final long getMessageTimeout() {
        return this.messageTimeout;
    }

    public final LinkedHashSet<Integer> getIdsSet() {
        return this.idsSet;
    }

    public final ViewGroup getMainView() {
        Activity activity = this.weakReference.get();
        if (activity != null) {
            return (ViewGroup) activity.findViewById(R.id.content);
        }
        return null;
    }

    @Override // com.sourcepoint.cmplibrary.util.ViewsManager
    public void removeView(final View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.idsSet.remove(Integer.valueOf(view.getId()));
        final ViewGroup mainView = getMainView();
        if (mainView != null) {
            mainView.post(new Runnable() { // from class: com.sourcepoint.cmplibrary.util.ViewsManagerImpl$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    ViewsManagerImpl.removeView$lambda$1$lambda$0(mainView, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeView$lambda$1$lambda$0(ViewGroup this_run, View view) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(view, "$view");
        this_run.removeView(view);
    }

    @Override // com.sourcepoint.cmplibrary.util.ViewsManager
    public void showView(final View view) {
        final ViewGroup mainView;
        Intrinsics.checkNotNullParameter(view, "view");
        this.idsSet.add(Integer.valueOf(view.getId()));
        if (view.getParent() == null && (mainView = getMainView()) != null) {
            mainView.post(new Runnable() { // from class: com.sourcepoint.cmplibrary.util.ViewsManagerImpl$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ViewsManagerImpl.showView$lambda$3$lambda$2(view, mainView);
                }
            });
        }
        removeAllViewsExcept(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showView$lambda$3$lambda$2(View view, ViewGroup it) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(it, "$it");
        view.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        view.getLayoutParams().height = -1;
        view.getLayoutParams().width = -1;
        view.bringToFront();
        view.requestLayout();
        it.addView(view);
    }

    @Override // com.sourcepoint.cmplibrary.util.ViewsManager
    public void removeAllViews() {
        final View findViewById;
        Iterator it = CollectionsKt.toMutableList((Collection) this.idsSet).iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            ViewGroup mainView = getMainView();
            if (mainView != null && (findViewById = mainView.findViewById(intValue)) != null) {
                Intrinsics.checkNotNull(findViewById);
                final ViewGroup mainView2 = getMainView();
                if (mainView2 != null) {
                    mainView2.post(new Runnable() { // from class: com.sourcepoint.cmplibrary.util.ViewsManagerImpl$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ViewsManagerImpl.removeAllViews$lambda$7$lambda$6$lambda$5$lambda$4(mainView2, findViewById);
                        }
                    });
                }
            }
        }
        this.webview = null;
        this.idsSet.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeAllViews$lambda$7$lambda$6$lambda$5$lambda$4(ViewGroup this_run, View view) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(view, "$view");
        this_run.removeView(view);
    }

    @Override // com.sourcepoint.cmplibrary.util.ViewsManager
    public void removeAllViewsExcept(View pView) {
        final View findViewById;
        final ViewGroup mainView;
        Intrinsics.checkNotNullParameter(pView, "pView");
        List mutableList = CollectionsKt.toMutableList((Collection) this.idsSet);
        IConsentWebView iConsentWebView = this.webview;
        if (iConsentWebView != null && (iConsentWebView instanceof ConsentWebView) && !Intrinsics.areEqual(pView, iConsentWebView)) {
            IConsentWebView iConsentWebView2 = this.webview;
            Intrinsics.checkNotNull(iConsentWebView2, "null cannot be cast to non-null type com.sourcepoint.cmplibrary.core.web.ConsentWebView");
            removeView((ConsentWebView) iConsentWebView2);
            this.webview = null;
        }
        Iterator it = mutableList.iterator();
        while (it.hasNext()) {
            final int intValue = ((Number) it.next()).intValue();
            ViewGroup mainView2 = getMainView();
            if (mainView2 != null && (findViewById = mainView2.findViewById(intValue)) != null) {
                Intrinsics.checkNotNull(findViewById);
                if (!Intrinsics.areEqual(pView, findViewById) && (mainView = getMainView()) != null) {
                    mainView.post(new Runnable() { // from class: com.sourcepoint.cmplibrary.util.ViewsManagerImpl$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ViewsManagerImpl.removeAllViewsExcept$lambda$11$lambda$10$lambda$9$lambda$8(mainView, findViewById, this, intValue);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeAllViewsExcept$lambda$11$lambda$10$lambda$9$lambda$8(ViewGroup this_run, View view, ViewsManagerImpl this$0, int i) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this_run.removeView(view);
        this$0.idsSet.remove(Integer.valueOf(i));
    }

    @Override // com.sourcepoint.cmplibrary.util.ViewsManager
    public Either<IConsentWebView> createWebView(final SpConsentLibImpl lib, final SpConsentLibImpl.JSReceiverDelegate jsReceiverDelegate, final MessageType messageType, final Integer cmpViewId) {
        Either<IConsentWebView> check;
        Intrinsics.checkNotNullParameter(lib, "lib");
        Intrinsics.checkNotNullParameter(jsReceiverDelegate, "jsReceiverDelegate");
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        final Activity activity = this.weakReference.get();
        return (activity == null || (check = FunctionalUtilsKt.check(new Function0<ConsentWebView>() { // from class: com.sourcepoint.cmplibrary.util.ViewsManagerImpl$createWebView$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConsentWebView invoke() {
                ConnectionManager connectionManager = ViewsManagerImpl.this.getConnectionManager();
                Logger pLogger = lib.getPLogger();
                ExecutorManager executor = lib.getExecutor();
                long messageTimeout = ViewsManagerImpl.this.getMessageTimeout();
                Activity it = activity;
                Intrinsics.checkNotNullExpressionValue(it, "$it");
                ConsentWebView consentWebView = new ConsentWebView(it, jsReceiverDelegate, pLogger, messageTimeout, connectionManager, executor, null, messageType, cmpViewId, 64, null);
                ViewsManagerImpl.this.webview = consentWebView;
                return consentWebView;
            }
        })) == null) ? new Either.Left(new WebViewCreationException(null, "The activity reference in the ViewManager is null!!!", false, 5, null)) : check;
    }

    @Override // com.sourcepoint.cmplibrary.util.ViewsManager
    public Either<IConsentWebView> createWebView(final SpConsentLibImpl lib, final SpConsentLibImpl.JSReceiverDelegate jsReceiverDelegate, final Queue<CampaignModel> campaignQueue, final MessageType messageType, final Integer cmpViewId) {
        Either<IConsentWebView> check;
        Intrinsics.checkNotNullParameter(lib, "lib");
        Intrinsics.checkNotNullParameter(jsReceiverDelegate, "jsReceiverDelegate");
        Intrinsics.checkNotNullParameter(campaignQueue, "campaignQueue");
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        final Activity activity = this.weakReference.get();
        return (activity == null || (check = FunctionalUtilsKt.check(new Function0<ConsentWebView>() { // from class: com.sourcepoint.cmplibrary.util.ViewsManagerImpl$createWebView$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConsentWebView invoke() {
                ConnectionManager connectionManager = ViewsManagerImpl.this.getConnectionManager();
                Logger pLogger = lib.getPLogger();
                ExecutorManager executor = lib.getExecutor();
                long messageTimeout = ViewsManagerImpl.this.getMessageTimeout();
                Activity it = activity;
                Intrinsics.checkNotNullExpressionValue(it, "$it");
                ConsentWebView consentWebView = new ConsentWebView(it, jsReceiverDelegate, pLogger, messageTimeout, connectionManager, executor, campaignQueue, messageType, cmpViewId);
                ViewsManagerImpl.this.webview = consentWebView;
                return consentWebView;
            }
        })) == null) ? new Either.Left(new WebViewCreationException(null, "The activity reference in the ViewManager is null!!!", false, 5, null)) : check;
    }

    @Override // com.sourcepoint.cmplibrary.util.ViewsManager
    public void dispose() {
        this.webview = null;
        this.weakReference.clear();
    }

    @Override // com.sourcepoint.cmplibrary.util.ViewsManager
    public void handleOnBackPress() {
        IConsentWebView iConsentWebView = this.webview;
        if (iConsentWebView != null) {
            iConsentWebView.handleOnBackPress();
        }
    }

    @Override // com.sourcepoint.cmplibrary.util.ViewsManager
    public boolean isViewInLayout() {
        return !this.idsSet.isEmpty();
    }
}
