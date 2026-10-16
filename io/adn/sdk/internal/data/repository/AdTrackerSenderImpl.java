package io.adn.sdk.internal.data.repository;

import com.ironsource.C3040d4;
import com.unity3d.services.core.di.ServiceProvider;
import io.adn.sdk.internal.common.utils.DateKt;
import io.adn.sdk.internal.common.utils.StringKt;
import io.adn.sdk.internal.common.utils.UriKt;
import io.adn.sdk.internal.data.api.remote.RemoteDataSource;
import io.adn.sdk.internal.domain.repository.AdTrackerSender;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: AdTrackerSenderImpl.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J \u0010\u000f\u001a\u00020\f*\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0002J\f\u0010\u0010\u001a\u00020\f*\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/internal/data/repository/AdTrackerSenderImpl;", "Lio/adn/sdk/internal/domain/repository/AdTrackerSender;", ServiceProvider.NAMED_REMOTE, "Lio/adn/sdk/internal/data/api/remote/RemoteDataSource;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lio/adn/sdk/internal/data/api/remote/RemoteDataSource;Lkotlinx/coroutines/CoroutineScope;)V", "track", "", "urls", "", "", "macros", "", "substituteCustomMacros", "substituteBasicMacroses", "Companion", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdTrackerSenderImpl implements AdTrackerSender {
    private final RemoteDataSource remote;
    private final CoroutineScope scope;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Regex TIMESTAMP_UNIX = new Regex("\\[TIMESTAMP_UNIX]");
    private static final Regex TIMESTAMP_ISO = new Regex("\\[TIMESTAMP_ISO]");
    private static final Regex ANYMACROS = new Regex("\\[[^]]*]");

    public AdTrackerSenderImpl(RemoteDataSource remote, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(remote, "remote");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.remote = remote;
        this.scope = scope;
    }

    public /* synthetic */ AdTrackerSenderImpl(RemoteDataSource remoteDataSource, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(remoteDataSource, (i & 2) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()) : coroutineScope);
    }

    @Override // io.adn.sdk.internal.domain.repository.AdTrackerSender
    public boolean track(List<String> urls, Map<String, String> macros) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        Intrinsics.checkNotNullParameter(macros, "macros");
        if (urls.isEmpty()) {
            return false;
        }
        Iterator<T> it = urls.iterator();
        while (it.hasNext()) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AdTrackerSenderImpl$track$1$1(this, (String) it.next(), macros, null), 3, null);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String substituteBasicMacroses(String str) {
        String replaceIfNotNull = StringKt.replaceIfNotNull(str, TIMESTAMP_UNIX, String.valueOf(DateKt.unixNow()));
        Regex regex = TIMESTAMP_ISO;
        String utcNowMs = DateKt.utcNowMs();
        Intrinsics.checkNotNullExpressionValue(utcNowMs, "utcNowMs(...)");
        return ANYMACROS.replace(StringKt.replaceIfNotNull(replaceIfNotNull, regex, UriKt.urlEncode(utcNowMs)), "");
    }

    /* compiled from: AdTrackerSenderImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lio/adn/sdk/internal/data/repository/AdTrackerSenderImpl$Companion;", "", "<init>", "()V", "TIMESTAMP_UNIX", "Lkotlin/text/Regex;", "TIMESTAMP_ISO", "ANYMACROS", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String substituteCustomMacros(String str, Map<String, String> map) {
        String str2 = str;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str2 = StringsKt.replace$default(str2, C3040d4.i.d + entry.getKey() + AbstractJsonLexerKt.END_LIST, entry.getValue(), false, 4, (Object) null);
        }
        return str2;
    }
}
