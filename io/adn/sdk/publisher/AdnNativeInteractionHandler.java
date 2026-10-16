package io.adn.sdk.publisher;

import android.view.View;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdnNativeInteractionHandler.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0011R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/publisher/AdnNativeInteractionHandler;", "", "<init>", "()V", "onAdElementClick", "Lkotlin/Function1;", "Lio/adn/sdk/publisher/AdnClickElement;", "", "getOnAdElementClick$adn_sdk_release", "()Lkotlin/jvm/functions/Function1;", "setOnAdElementClick$adn_sdk_release", "(Lkotlin/jvm/functions/Function1;)V", "addClickableView", "element", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", "notifyClick", "notifyClick$adn_sdk_release", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdnNativeInteractionHandler {
    public static final int $stable = 8;
    private Function1<? super AdnClickElement, Unit> onAdElementClick;

    public final Function1<AdnClickElement, Unit> getOnAdElementClick$adn_sdk_release() {
        return this.onAdElementClick;
    }

    public final void setOnAdElementClick$adn_sdk_release(Function1<? super AdnClickElement, Unit> function1) {
        this.onAdElementClick = function1;
    }

    public final void addClickableView(final AdnClickElement element, View view) {
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOnClickListener(new View.OnClickListener() { // from class: io.adn.sdk.publisher.AdnNativeInteractionHandler$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AdnNativeInteractionHandler.this.notifyClick$adn_sdk_release(element);
            }
        });
    }

    public final void notifyClick$adn_sdk_release(AdnClickElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        Function1<? super AdnClickElement, Unit> function1 = this.onAdElementClick;
        if (function1 != null) {
            function1.invoke(element);
        }
    }
}
