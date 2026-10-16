package io.adn.sdk.internal.ui.common.mraid;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import com.ironsource.sdk.controller.f;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import io.adn.sdk.publisher.AdnClickElement;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: MraidWebViewEvent.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u0000 \u00102\u00020\u0001:\u0007\n\u000b\f\r\u000e\u000f\u0010R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0006\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent;", "", f.b.g, "", "getCommand", "()Ljava/lang/String;", "origin", "Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin;", "getOrigin", "()Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin;", "Close", "Expand", "Open", "PlayVideo", "Resize", "SetOrientationProperties", "Companion", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$Close;", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$Expand;", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$Open;", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$PlayVideo;", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$Resize;", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$SetOrientationProperties;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface MraidWebViewEvent {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    String getCommand();

    MraidEventOrigin getOrigin();

    /* compiled from: MraidWebViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H×\u0003J\t\u0010\u0014\u001a\u00020\u0015H×\u0001J\t\u0010\u0016\u001a\u00020\tH×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u0017"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$Close;", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent;", "eventType", "Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin;", "<init>", "(Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin;)V", "getEventType", "()Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin;", f.b.g, "", "getCommand", "()Ljava/lang/String;", "origin", "getOrigin", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Close implements MraidWebViewEvent {
        public static final int $stable = 0;
        private final String command;
        private final MraidEventOrigin eventType;
        private final MraidEventOrigin origin;

        public static /* synthetic */ Close copy$default(Close close, MraidEventOrigin mraidEventOrigin, int i, Object obj) {
            if ((i & 1) != 0) {
                mraidEventOrigin = close.eventType;
            }
            return close.copy(mraidEventOrigin);
        }

        /* renamed from: component1, reason: from getter */
        public final MraidEventOrigin getEventType() {
            return this.eventType;
        }

        public final Close copy(MraidEventOrigin eventType) {
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            return new Close(eventType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Close) && this.eventType == ((Close) other).eventType;
        }

        public int hashCode() {
            return this.eventType.hashCode();
        }

        public String toString() {
            return "Close(eventType=" + this.eventType + ')';
        }

        public Close(MraidEventOrigin eventType) {
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            this.eventType = eventType;
            this.command = "close";
            this.origin = MraidEventOrigin.MRAID;
        }

        public final MraidEventOrigin getEventType() {
            return this.eventType;
        }

        @Override // io.adn.sdk.internal.ui.common.mraid.MraidWebViewEvent
        public String getCommand() {
            return this.command;
        }

        @Override // io.adn.sdk.internal.ui.common.mraid.MraidWebViewEvent
        public MraidEventOrigin getOrigin() {
            return this.origin;
        }
    }

    /* compiled from: MraidWebViewEvent.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H×\u0003J\t\u0010\u0016\u001a\u00020\u0017H×\u0001J\t\u0010\u0018\u001a\u00020\tH×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$Expand;", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", f.b.g, "", "getCommand", "()Ljava/lang/String;", "origin", "Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin;", "getOrigin", "()Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Expand implements MraidWebViewEvent {
        public static final int $stable = 8;
        private final String command = n.e;
        private final MraidEventOrigin origin = MraidEventOrigin.MRAID;
        private final Uri uri;

        public static /* synthetic */ Expand copy$default(Expand expand, Uri uri, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = expand.uri;
            }
            return expand.copy(uri);
        }

        /* renamed from: component1, reason: from getter */
        public final Uri getUri() {
            return this.uri;
        }

        public final Expand copy(Uri uri) {
            return new Expand(uri);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Expand) && Intrinsics.areEqual(this.uri, ((Expand) other).uri);
        }

        public int hashCode() {
            Uri uri = this.uri;
            if (uri == null) {
                return 0;
            }
            return uri.hashCode();
        }

        public String toString() {
            return "Expand(uri=" + this.uri + ')';
        }

        public Expand(Uri uri) {
            this.uri = uri;
        }

        public final Uri getUri() {
            return this.uri;
        }

        @Override // io.adn.sdk.internal.ui.common.mraid.MraidWebViewEvent
        public String getCommand() {
            return this.command;
        }

        @Override // io.adn.sdk.internal.ui.common.mraid.MraidWebViewEvent
        public MraidEventOrigin getOrigin() {
            return this.origin;
        }
    }

    /* compiled from: MraidWebViewEvent.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÇ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH×\u0003J\t\u0010\u001e\u001a\u00020\u001fH×\u0001J\t\u0010 \u001a\u00020\u0011H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000b¨\u0006!"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$Open;", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent;", "eventType", "Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin;", "uri", "Landroid/net/Uri;", "clickedElement", "Lio/adn/sdk/publisher/AdnClickElement;", "<init>", "(Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin;Landroid/net/Uri;Lio/adn/sdk/publisher/AdnClickElement;)V", "getEventType", "()Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin;", "getUri", "()Landroid/net/Uri;", "getClickedElement", "()Lio/adn/sdk/publisher/AdnClickElement;", f.b.g, "", "getCommand", "()Ljava/lang/String;", "origin", "getOrigin", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Open implements MraidWebViewEvent {
        public static final int $stable = 8;
        private final AdnClickElement clickedElement;
        private final String command;
        private final MraidEventOrigin eventType;
        private final MraidEventOrigin origin;
        private final Uri uri;

        public static /* synthetic */ Open copy$default(Open open, MraidEventOrigin mraidEventOrigin, Uri uri, AdnClickElement adnClickElement, int i, Object obj) {
            if ((i & 1) != 0) {
                mraidEventOrigin = open.eventType;
            }
            if ((i & 2) != 0) {
                uri = open.uri;
            }
            if ((i & 4) != 0) {
                adnClickElement = open.clickedElement;
            }
            return open.copy(mraidEventOrigin, uri, adnClickElement);
        }

        /* renamed from: component1, reason: from getter */
        public final MraidEventOrigin getEventType() {
            return this.eventType;
        }

        /* renamed from: component2, reason: from getter */
        public final Uri getUri() {
            return this.uri;
        }

        /* renamed from: component3, reason: from getter */
        public final AdnClickElement getClickedElement() {
            return this.clickedElement;
        }

        public final Open copy(MraidEventOrigin eventType, Uri uri, AdnClickElement clickedElement) {
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            return new Open(eventType, uri, clickedElement);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Open)) {
                return false;
            }
            Open open = (Open) other;
            return this.eventType == open.eventType && Intrinsics.areEqual(this.uri, open.uri) && Intrinsics.areEqual(this.clickedElement, open.clickedElement);
        }

        public int hashCode() {
            int hashCode = this.eventType.hashCode() * 31;
            Uri uri = this.uri;
            int hashCode2 = (hashCode + (uri == null ? 0 : uri.hashCode())) * 31;
            AdnClickElement adnClickElement = this.clickedElement;
            return hashCode2 + (adnClickElement != null ? adnClickElement.hashCode() : 0);
        }

        public String toString() {
            return "Open(eventType=" + this.eventType + ", uri=" + this.uri + ", clickedElement=" + this.clickedElement + ')';
        }

        public Open(MraidEventOrigin eventType, Uri uri, AdnClickElement adnClickElement) {
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            this.eventType = eventType;
            this.uri = uri;
            this.clickedElement = adnClickElement;
            this.command = "open";
            this.origin = MraidEventOrigin.MRAID;
        }

        public /* synthetic */ Open(MraidEventOrigin mraidEventOrigin, Uri uri, AdnClickElement adnClickElement, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(mraidEventOrigin, uri, (i & 4) != 0 ? null : adnClickElement);
        }

        public final MraidEventOrigin getEventType() {
            return this.eventType;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public final AdnClickElement getClickedElement() {
            return this.clickedElement;
        }

        @Override // io.adn.sdk.internal.ui.common.mraid.MraidWebViewEvent
        public String getCommand() {
            return this.command;
        }

        @Override // io.adn.sdk.internal.ui.common.mraid.MraidWebViewEvent
        public MraidEventOrigin getOrigin() {
            return this.origin;
        }
    }

    /* compiled from: MraidWebViewEvent.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H×\u0003J\t\u0010\u0016\u001a\u00020\u0017H×\u0001J\t\u0010\u0018\u001a\u00020\tH×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$PlayVideo;", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", f.b.g, "", "getCommand", "()Ljava/lang/String;", "origin", "Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin;", "getOrigin", "()Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class PlayVideo implements MraidWebViewEvent {
        public static final int $stable = 8;
        private final String command;
        private final MraidEventOrigin origin;
        private final Uri uri;

        public static /* synthetic */ PlayVideo copy$default(PlayVideo playVideo, Uri uri, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = playVideo.uri;
            }
            return playVideo.copy(uri);
        }

        /* renamed from: component1, reason: from getter */
        public final Uri getUri() {
            return this.uri;
        }

        public final PlayVideo copy(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return new PlayVideo(uri);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PlayVideo) && Intrinsics.areEqual(this.uri, ((PlayVideo) other).uri);
        }

        public int hashCode() {
            return this.uri.hashCode();
        }

        public String toString() {
            return "PlayVideo(uri=" + this.uri + ')';
        }

        public PlayVideo(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.uri = uri;
            this.command = "playVideo";
            this.origin = MraidEventOrigin.MRAID;
        }

        public final Uri getUri() {
            return this.uri;
        }

        @Override // io.adn.sdk.internal.ui.common.mraid.MraidWebViewEvent
        public String getCommand() {
            return this.command;
        }

        @Override // io.adn.sdk.internal.ui.common.mraid.MraidWebViewEvent
        public MraidEventOrigin getOrigin() {
            return this.origin;
        }
    }

    /* compiled from: MraidWebViewEvent.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J;\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÇ\u0001J\u0013\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\"H×\u0003J\t\u0010#\u001a\u00020\u0003H×\u0001J\t\u0010$\u001a\u00020\u0013H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$Resize;", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent;", "widthDp", "", "heightDp", "offsetX", "offsetY", "allowOffscreen", "", "<init>", "(IIIIZ)V", "getWidthDp", "()I", "getHeightDp", "getOffsetX", "getOffsetY", "getAllowOffscreen", "()Z", f.b.g, "", "getCommand", "()Ljava/lang/String;", "origin", "Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin;", "getOrigin", "()Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Resize implements MraidWebViewEvent {
        public static final int $stable = 0;
        private final boolean allowOffscreen;
        private final int heightDp;
        private final int offsetX;
        private final int offsetY;
        private final int widthDp;
        private final String command = n.g;
        private final MraidEventOrigin origin = MraidEventOrigin.MRAID;

        public static /* synthetic */ Resize copy$default(Resize resize, int i, int i2, int i3, int i4, boolean z, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = resize.widthDp;
            }
            if ((i5 & 2) != 0) {
                i2 = resize.heightDp;
            }
            if ((i5 & 4) != 0) {
                i3 = resize.offsetX;
            }
            if ((i5 & 8) != 0) {
                i4 = resize.offsetY;
            }
            if ((i5 & 16) != 0) {
                z = resize.allowOffscreen;
            }
            boolean z2 = z;
            int i6 = i3;
            return resize.copy(i, i2, i6, i4, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getWidthDp() {
            return this.widthDp;
        }

        /* renamed from: component2, reason: from getter */
        public final int getHeightDp() {
            return this.heightDp;
        }

        /* renamed from: component3, reason: from getter */
        public final int getOffsetX() {
            return this.offsetX;
        }

        /* renamed from: component4, reason: from getter */
        public final int getOffsetY() {
            return this.offsetY;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getAllowOffscreen() {
            return this.allowOffscreen;
        }

        public final Resize copy(int widthDp, int heightDp, int offsetX, int offsetY, boolean allowOffscreen) {
            return new Resize(widthDp, heightDp, offsetX, offsetY, allowOffscreen);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Resize)) {
                return false;
            }
            Resize resize = (Resize) other;
            return this.widthDp == resize.widthDp && this.heightDp == resize.heightDp && this.offsetX == resize.offsetX && this.offsetY == resize.offsetY && this.allowOffscreen == resize.allowOffscreen;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.widthDp) * 31) + Integer.hashCode(this.heightDp)) * 31) + Integer.hashCode(this.offsetX)) * 31) + Integer.hashCode(this.offsetY)) * 31) + Boolean.hashCode(this.allowOffscreen);
        }

        public String toString() {
            return "Resize(widthDp=" + this.widthDp + ", heightDp=" + this.heightDp + ", offsetX=" + this.offsetX + ", offsetY=" + this.offsetY + ", allowOffscreen=" + this.allowOffscreen + ')';
        }

        public Resize(int i, int i2, int i3, int i4, boolean z) {
            this.widthDp = i;
            this.heightDp = i2;
            this.offsetX = i3;
            this.offsetY = i4;
            this.allowOffscreen = z;
        }

        public final int getWidthDp() {
            return this.widthDp;
        }

        public final int getHeightDp() {
            return this.heightDp;
        }

        public final int getOffsetX() {
            return this.offsetX;
        }

        public final int getOffsetY() {
            return this.offsetY;
        }

        public final boolean getAllowOffscreen() {
            return this.allowOffscreen;
        }

        @Override // io.adn.sdk.internal.ui.common.mraid.MraidWebViewEvent
        public String getCommand() {
            return this.command;
        }

        @Override // io.adn.sdk.internal.ui.common.mraid.MraidWebViewEvent
        public MraidEventOrigin getOrigin() {
            return this.origin;
        }
    }

    /* compiled from: MraidWebViewEvent.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H×\u0003J\t\u0010\u001a\u001a\u00020\u001bH×\u0001J\t\u0010\u001c\u001a\u00020\rH×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$SetOrientationProperties;", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent;", "allowOrientationChange", "", "forceOrientation", "Lio/adn/sdk/internal/ui/common/mraid/MraidOrientation;", "<init>", "(ZLio/adn/sdk/internal/ui/common/mraid/MraidOrientation;)V", "getAllowOrientationChange", "()Z", "getForceOrientation", "()Lio/adn/sdk/internal/ui/common/mraid/MraidOrientation;", f.b.g, "", "getCommand", "()Ljava/lang/String;", "origin", "Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin;", "getOrigin", "()Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class SetOrientationProperties implements MraidWebViewEvent {
        public static final int $stable = 0;
        private final boolean allowOrientationChange;
        private final String command;
        private final MraidOrientation forceOrientation;
        private final MraidEventOrigin origin;

        public static /* synthetic */ SetOrientationProperties copy$default(SetOrientationProperties setOrientationProperties, boolean z, MraidOrientation mraidOrientation, int i, Object obj) {
            if ((i & 1) != 0) {
                z = setOrientationProperties.allowOrientationChange;
            }
            if ((i & 2) != 0) {
                mraidOrientation = setOrientationProperties.forceOrientation;
            }
            return setOrientationProperties.copy(z, mraidOrientation);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getAllowOrientationChange() {
            return this.allowOrientationChange;
        }

        /* renamed from: component2, reason: from getter */
        public final MraidOrientation getForceOrientation() {
            return this.forceOrientation;
        }

        public final SetOrientationProperties copy(boolean allowOrientationChange, MraidOrientation forceOrientation) {
            Intrinsics.checkNotNullParameter(forceOrientation, "forceOrientation");
            return new SetOrientationProperties(allowOrientationChange, forceOrientation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetOrientationProperties)) {
                return false;
            }
            SetOrientationProperties setOrientationProperties = (SetOrientationProperties) other;
            return this.allowOrientationChange == setOrientationProperties.allowOrientationChange && this.forceOrientation == setOrientationProperties.forceOrientation;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.allowOrientationChange) * 31) + this.forceOrientation.hashCode();
        }

        public String toString() {
            return "SetOrientationProperties(allowOrientationChange=" + this.allowOrientationChange + ", forceOrientation=" + this.forceOrientation + ')';
        }

        public SetOrientationProperties(boolean z, MraidOrientation forceOrientation) {
            Intrinsics.checkNotNullParameter(forceOrientation, "forceOrientation");
            this.allowOrientationChange = z;
            this.forceOrientation = forceOrientation;
            this.command = "setOrientationProperties";
            this.origin = MraidEventOrigin.MRAID;
        }

        public final boolean getAllowOrientationChange() {
            return this.allowOrientationChange;
        }

        public final MraidOrientation getForceOrientation() {
            return this.forceOrientation;
        }

        @Override // io.adn.sdk.internal.ui.common.mraid.MraidWebViewEvent
        public String getCommand() {
            return this.command;
        }

        @Override // io.adn.sdk.internal.ui.common.mraid.MraidWebViewEvent
        public MraidEventOrigin getOrigin() {
            return this.origin;
        }
    }

    /* compiled from: MraidWebViewEvent.kt */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001c\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012H\u0002J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012H\u0002J\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012H\u0002J\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012H\u0002J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0002J\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010 J\"\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001c2\b\b\u0002\u0010$\u001a\u00020\u001cH\u0002J\u001e\u0010%\u001a\u0004\u0018\u00010&2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$Companion;", "", "<init>", "()V", "CLOSE", "", "EXPAND", "OPEN", "RESIZE", "PLAY_VIDEO", "SET_ORIENTATION_PROPERTIES", Constants.MessagePayloadKeys.FROM, "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent;", "uri", "Landroid/net/Uri;", "tryCreateExpand", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$Expand;", "queryParams", "", "tryCreateOpen", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$Open;", "eventType", "Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin;", "tryCreatePlayVideo", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$PlayVideo;", "tryCreateResize", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$Resize;", "parseSize", "", "text", "parseBoolean", "", "(Ljava/lang/String;)Ljava/lang/Boolean;", "checkRange", "value", "min", "max", "tryCreateSetOrientationProperties", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$SetOrientationProperties;", "getQueryParams", "(Landroid/net/Uri;)Ljava/util/Map;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String CLOSE = "close";
        private static final String EXPAND = "expand";
        private static final String OPEN = "open";
        private static final String PLAY_VIDEO = "playVideo";
        private static final String RESIZE = "resize";
        private static final String SET_ORIENTATION_PROPERTIES = "setOrientationProperties";

        /* compiled from: MraidWebViewEvent.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[MraidEventOrigin.values().length];
                try {
                    iArr[MraidEventOrigin.EXTERNAL_REDIRECTION.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MraidEventOrigin.MRAID.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
         */
        public final MraidWebViewEvent from(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            MraidEventOrigin from = MraidEventOrigin.INSTANCE.from(uri);
            if (from == null) {
                return null;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[from.ordinal()];
            if (i == 1) {
                return new Open(from, uri, null, 4, null);
            }
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            Map<String, String> queryParams = getQueryParams(uri);
            String host = uri.getHost();
            if (host != null) {
                switch (host.hashCode()) {
                    case -1886160473:
                        if (host.equals(PLAY_VIDEO)) {
                            return tryCreatePlayVideo(queryParams);
                        }
                        break;
                    case -1289167206:
                        if (host.equals("expand")) {
                            return tryCreateExpand(queryParams);
                        }
                        break;
                    case -934437708:
                        if (host.equals("resize")) {
                            return tryCreateResize(queryParams);
                        }
                        break;
                    case 3417674:
                        if (host.equals("open")) {
                            return tryCreateOpen(from, queryParams);
                        }
                        break;
                    case 94756344:
                        if (host.equals("close")) {
                            return new Close(from);
                        }
                        break;
                    case 133423073:
                        if (host.equals("setOrientationProperties")) {
                            return tryCreateSetOrientationProperties(queryParams);
                        }
                        break;
                }
            }
            return null;
        }

        private final Expand tryCreateExpand(Map<String, String> queryParams) {
            Object m10241constructorimpl;
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion companion2 = this;
                String str = queryParams.get("url");
                m10241constructorimpl = Result.m10241constructorimpl(str != null ? Uri.parse(str) : null);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
            return new Expand((Uri) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl));
        }

        private final Open tryCreateOpen(MraidEventOrigin eventType, Map<String, String> queryParams) {
            Object m10241constructorimpl;
            Object m10241constructorimpl2;
            String queryParameter;
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion companion2 = this;
                String str = queryParams.get("url");
                m10241constructorimpl = Result.m10241constructorimpl(str != null ? Uri.parse(str) : null);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m10247isFailureimpl(m10241constructorimpl)) {
                m10241constructorimpl = null;
            }
            Uri uri = (Uri) m10241constructorimpl;
            try {
                Result.Companion companion4 = Result.INSTANCE;
                Companion companion5 = this;
                m10241constructorimpl2 = Result.m10241constructorimpl((uri == null || (queryParameter = uri.getQueryParameter("clickElement")) == null) ? null : AdnClickElement.INSTANCE.from(queryParameter));
            } catch (Throwable th2) {
                Result.Companion companion6 = Result.INSTANCE;
                m10241constructorimpl2 = Result.m10241constructorimpl(ResultKt.createFailure(th2));
            }
            return new Open(eventType, uri, (AdnClickElement) (Result.m10247isFailureimpl(m10241constructorimpl2) ? null : m10241constructorimpl2));
        }

        private final PlayVideo tryCreatePlayVideo(Map<String, String> queryParams) {
            Object m10241constructorimpl;
            String str = queryParams.get("uri");
            if (str == null) {
                return null;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion companion2 = this;
                m10241constructorimpl = Result.m10241constructorimpl(new PlayVideo(Uri.parse(str)));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
            return (PlayVideo) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
        }

        private final Resize tryCreateResize(Map<String, String> queryParams) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion companion2 = this;
                try {
                    int checkRange$default = checkRange$default(this, parseSize(queryParams.get("width")), 0, 0, 4, null);
                    int checkRange$default2 = checkRange$default(this, parseSize(queryParams.get("height")), 0, 0, 4, null);
                    int checkRange$default3 = checkRange$default(this, parseSize(queryParams.get("offsetX")), -100000, 0, 4, null);
                    int checkRange$default4 = checkRange$default(this, parseSize(queryParams.get("offsetY")), -100000, 0, 4, null);
                    Boolean parseBoolean = parseBoolean(queryParams.get("allowOffscreen"));
                    return new Resize(checkRange$default, checkRange$default2, checkRange$default3, checkRange$default4, parseBoolean != null ? parseBoolean.booleanValue() : true);
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    Result.Companion companion3 = Result.INSTANCE;
                    Result.m10241constructorimpl(ResultKt.createFailure(th2));
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        private final int parseSize(String text) {
            if (text == null) {
                throw new IllegalArgumentException("Integer parameter is null");
            }
            return Integer.parseInt(text, CharsKt.checkRadix(10));
        }

        private final Boolean parseBoolean(String text) {
            if (Intrinsics.areEqual(text, "true")) {
                return true;
            }
            return Intrinsics.areEqual(text, "false") ? false : null;
        }

        static /* synthetic */ int checkRange$default(Companion companion, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 4) != 0) {
                i3 = 100000;
            }
            return companion.checkRange(i, i2, i3);
        }

        private final int checkRange(int value, int min, int max) {
            if (value < min || value > max) {
                throw new IllegalArgumentException("Integer parameter out of range: " + value);
            }
            return value;
        }

        private final SetOrientationProperties tryCreateSetOrientationProperties(Map<String, String> queryParams) {
            Boolean booleanStrictOrNull;
            String str = queryParams.get("allowOrientationChange");
            if (str == null || (booleanStrictOrNull = StringsKt.toBooleanStrictOrNull(str)) == null) {
                return null;
            }
            boolean booleanValue = booleanStrictOrNull.booleanValue();
            MraidOrientation from = MraidOrientation.INSTANCE.from(queryParams.get("forceOrientation"));
            if (from == null) {
                return null;
            }
            return new SetOrientationProperties(booleanValue, from);
        }

        private final Map<String, String> getQueryParams(Uri uri) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : uri.getQueryParameterNames()) {
                linkedHashMap.put(str, TextUtils.join(",", uri.getQueryParameters(str)));
            }
            return linkedHashMap;
        }
    }
}
