package io.adn.sdk.internal.data.service;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import io.adn.sdk.internal.common.utils.ContextKt;
import io.adn.sdk.internal.common.utils.UriKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExternalLinkNavigator.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lio/adn/sdk/internal/data/service/ExternalLinkNavigatorImpl;", "Lio/adn/sdk/internal/data/service/ExternalLinkNavigator;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "open", "", "url", "", "uri", "Landroid/net/Uri;", "openDeeplink", "openIntentUri", "", "openUri", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ExternalLinkNavigatorImpl implements ExternalLinkNavigator {
    public static final int $stable = 8;
    private final Activity activity;

    public ExternalLinkNavigatorImpl(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    @Override // io.adn.sdk.internal.data.service.ExternalLinkNavigator
    public boolean open(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Uri uri = UriKt.toUri(url);
        if (uri == null) {
            return false;
        }
        return open(uri);
    }

    @Override // io.adn.sdk.internal.data.service.ExternalLinkNavigator
    public boolean open(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return ContextKt.launchCustomTab(this.activity, uri);
    }

    @Override // io.adn.sdk.internal.data.service.ExternalLinkNavigator
    public boolean openDeeplink(String url) {
        Object m10241constructorimpl;
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Result.Companion companion = Result.INSTANCE;
            ExternalLinkNavigatorImpl externalLinkNavigatorImpl = this;
            if (UriKt.isIntentUrl(url)) {
                openIntentUri(url);
            } else {
                openUri(url);
            }
            m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m10248isSuccessimpl(m10241constructorimpl);
    }

    private final void openIntentUri(String url) {
        Intent parseUri = Intent.parseUri(url, 1);
        parseUri.addFlags(268435456);
        try {
            this.activity.startActivity(parseUri);
        } catch (ActivityNotFoundException e) {
            String stringExtra = parseUri.getStringExtra("browser_fallback_url");
            if (stringExtra != null) {
                openUri(stringExtra);
                return;
            }
            throw e;
        }
    }

    private final void openUri(String url) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        intent.addFlags(268435456);
        this.activity.startActivity(intent);
    }
}
