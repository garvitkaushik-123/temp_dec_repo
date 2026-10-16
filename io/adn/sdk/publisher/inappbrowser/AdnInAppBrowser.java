package io.adn.sdk.publisher.inappbrowser;

import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* compiled from: AdnInAppBrowser.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u000bH&J\b\u0010\u0010\u001a\u00020\u000bH&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0014\u001a\u00020\u000bH&J\b\u0010\u0015\u001a\u00020\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0016"}, d2 = {"Lio/adn/sdk/publisher/inappbrowser/AdnInAppBrowser;", "", "uuid", "", "getUuid", "()Ljava/lang/String;", "url", "getUrl", "getView", "Landroid/view/View;", "load", "", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lio/adn/sdk/publisher/inappbrowser/AdnInAppBrowserListener;", "goBack", "reload", "canGoBack", "", "canGoForward", "goForward", "release", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdnInAppBrowser {
    boolean canGoBack();

    boolean canGoForward();

    String getUrl();

    String getUuid();

    View getView();

    void goBack();

    void goForward();

    void load();

    void release();

    void reload();

    void setListener(AdnInAppBrowserListener listener);
}
