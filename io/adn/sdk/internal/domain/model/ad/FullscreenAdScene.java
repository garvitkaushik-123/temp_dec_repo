package io.adn.sdk.internal.domain.model.ad;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.adn.sdk.internal.common.utils.ConversionsKt;
import io.adn.sdk.internal.domain.model.ad.AdLink;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig;
import io.bidmachine.iab.vast.tags.VastTagName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullscreenAdEntity.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0004\u001c\u001d\u001e\u001fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001a\u0082\u0001\u0004 !\"#¨\u0006$"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "", FirebaseAnalytics.Param.INDEX, "", "getIndex", "()I", "id", "", "getId", "()Ljava/lang/String;", "uuid", "getUuid", "link", "Lio/adn/sdk/internal/domain/model/ad/AdLink$Fullscreen;", "getLink", "()Lio/adn/sdk/internal/domain/model/ad/AdLink$Fullscreen;", "promotedApp", "Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "getPromotedApp", "()Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "config", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig;", "getConfig", "()Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig;", "isEndCard", "", "()Z", "isLastScene", "Html", "Image", VastTagName.VIDEO, "PromotedAppCard", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$Html;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$Image;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$PromotedAppCard;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$Video;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface FullscreenAdScene {
    FullscreenAdSceneConfig getConfig();

    String getId();

    int getIndex();

    AdLink.Fullscreen getLink();

    AdPromotedApp getPromotedApp();

    String getUuid();

    boolean isEndCard();

    boolean isLastScene();

    /* compiled from: FullscreenAdEntity.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010*\u001a\u00020\u0011HÆ\u0003Jg\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÇ\u0001J\u0013\u0010,\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010.H×\u0003J\t\u0010/\u001a\u00020\u0003H×\u0001J\t\u00100\u001a\u00020\u0005H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001bR\u0014\u0010\u000b\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00061"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$Html;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", FirebaseAnalytics.Param.INDEX, "", "id", "", "uuid", "content", "Lio/adn/sdk/internal/domain/model/ad/HtmlContent;", "isEndCard", "", "isLastScene", "link", "Lio/adn/sdk/internal/domain/model/ad/AdLink$Fullscreen;", "promotedApp", "Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "config", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Html;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lio/adn/sdk/internal/domain/model/ad/HtmlContent;ZZLio/adn/sdk/internal/domain/model/ad/AdLink$Fullscreen;Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Html;)V", "getIndex", "()I", "getId", "()Ljava/lang/String;", "getUuid", "getContent", "()Lio/adn/sdk/internal/domain/model/ad/HtmlContent;", "()Z", "getLink", "()Lio/adn/sdk/internal/domain/model/ad/AdLink$Fullscreen;", "getPromotedApp", "()Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "getConfig", "()Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Html;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Html implements FullscreenAdScene {
        public static final int $stable = 8;
        private final FullscreenAdSceneConfig.Html config;
        private final HtmlContent content;
        private final String id;
        private final int index;
        private final boolean isEndCard;
        private final boolean isLastScene;
        private final AdLink.Fullscreen link;
        private final AdPromotedApp promotedApp;
        private final String uuid;

        public static /* synthetic */ Html copy$default(Html html, int i, String str, String str2, HtmlContent htmlContent, boolean z, boolean z2, AdLink.Fullscreen fullscreen, AdPromotedApp adPromotedApp, FullscreenAdSceneConfig.Html html2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = html.index;
            }
            if ((i2 & 2) != 0) {
                str = html.id;
            }
            if ((i2 & 4) != 0) {
                str2 = html.uuid;
            }
            if ((i2 & 8) != 0) {
                htmlContent = html.content;
            }
            if ((i2 & 16) != 0) {
                z = html.isEndCard;
            }
            if ((i2 & 32) != 0) {
                z2 = html.isLastScene;
            }
            if ((i2 & 64) != 0) {
                fullscreen = html.link;
            }
            if ((i2 & 128) != 0) {
                adPromotedApp = html.promotedApp;
            }
            if ((i2 & 256) != 0) {
                html2 = html.config;
            }
            AdPromotedApp adPromotedApp2 = adPromotedApp;
            FullscreenAdSceneConfig.Html html3 = html2;
            boolean z3 = z2;
            AdLink.Fullscreen fullscreen2 = fullscreen;
            boolean z4 = z;
            String str3 = str2;
            return html.copy(i, str, str3, htmlContent, z4, z3, fullscreen2, adPromotedApp2, html3);
        }

        /* renamed from: component1, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component3, reason: from getter */
        public final String getUuid() {
            return this.uuid;
        }

        /* renamed from: component4, reason: from getter */
        public final HtmlContent getContent() {
            return this.content;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsEndCard() {
            return this.isEndCard;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsLastScene() {
            return this.isLastScene;
        }

        /* renamed from: component7, reason: from getter */
        public final AdLink.Fullscreen getLink() {
            return this.link;
        }

        /* renamed from: component8, reason: from getter */
        public final AdPromotedApp getPromotedApp() {
            return this.promotedApp;
        }

        /* renamed from: component9, reason: from getter */
        public final FullscreenAdSceneConfig.Html getConfig() {
            return this.config;
        }

        public final Html copy(int index, String id, String uuid, HtmlContent content, boolean isEndCard, boolean isLastScene, AdLink.Fullscreen link, AdPromotedApp promotedApp, FullscreenAdSceneConfig.Html config) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(link, "link");
            Intrinsics.checkNotNullParameter(config, "config");
            return new Html(index, id, uuid, content, isEndCard, isLastScene, link, promotedApp, config);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Html)) {
                return false;
            }
            Html html = (Html) other;
            return this.index == html.index && Intrinsics.areEqual(this.id, html.id) && Intrinsics.areEqual(this.uuid, html.uuid) && Intrinsics.areEqual(this.content, html.content) && this.isEndCard == html.isEndCard && this.isLastScene == html.isLastScene && Intrinsics.areEqual(this.link, html.link) && Intrinsics.areEqual(this.promotedApp, html.promotedApp) && Intrinsics.areEqual(this.config, html.config);
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.index) * 31;
            String str = this.id;
            int hashCode2 = (((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.uuid.hashCode()) * 31) + this.content.hashCode()) * 31) + Boolean.hashCode(this.isEndCard)) * 31) + Boolean.hashCode(this.isLastScene)) * 31) + this.link.hashCode()) * 31;
            AdPromotedApp adPromotedApp = this.promotedApp;
            return ((hashCode2 + (adPromotedApp != null ? adPromotedApp.hashCode() : 0)) * 31) + this.config.hashCode();
        }

        public String toString() {
            return "Html(index=" + this.index + ", id=" + this.id + ", uuid=" + this.uuid + ", content=" + this.content + ", isEndCard=" + this.isEndCard + ", isLastScene=" + this.isLastScene + ", link=" + this.link + ", promotedApp=" + this.promotedApp + ", config=" + this.config + ')';
        }

        public Html(int i, String str, String uuid, HtmlContent content, boolean z, boolean z2, AdLink.Fullscreen link, AdPromotedApp adPromotedApp, FullscreenAdSceneConfig.Html config) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(link, "link");
            Intrinsics.checkNotNullParameter(config, "config");
            this.index = i;
            this.id = str;
            this.uuid = uuid;
            this.content = content;
            this.isEndCard = z;
            this.isLastScene = z2;
            this.link = link;
            this.promotedApp = adPromotedApp;
            this.config = config;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public int getIndex() {
            return this.index;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public String getId() {
            return this.id;
        }

        public /* synthetic */ Html(int i, String str, String str2, HtmlContent htmlContent, boolean z, boolean z2, AdLink.Fullscreen fullscreen, AdPromotedApp adPromotedApp, FullscreenAdSceneConfig.Html html, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, (i2 & 4) != 0 ? ConversionsKt.randomUUID() : str2, htmlContent, z, z2, fullscreen, adPromotedApp, html);
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public String getUuid() {
            return this.uuid;
        }

        public final HtmlContent getContent() {
            return this.content;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public boolean isEndCard() {
            return this.isEndCard;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public boolean isLastScene() {
            return this.isLastScene;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public AdLink.Fullscreen getLink() {
            return this.link;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public AdPromotedApp getPromotedApp() {
            return this.promotedApp;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public FullscreenAdSceneConfig.Html getConfig() {
            return this.config;
        }
    }

    /* compiled from: FullscreenAdEntity.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010'\u001a\u00020\u000fHÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003Jg\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\tHÇ\u0001J\u0013\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010,H×\u0003J\t\u0010-\u001a\u00020\u0003H×\u0001J\t\u0010.\u001a\u00020\u0005H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0019R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0010\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0019¨\u0006/"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$Image;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", FirebaseAnalytics.Param.INDEX, "", "id", "", "uuid", "url", "isLastScene", "", "link", "Lio/adn/sdk/internal/domain/model/ad/AdLink$Fullscreen;", "promotedApp", "Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "config", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Image;", "isEndCard", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLio/adn/sdk/internal/domain/model/ad/AdLink$Fullscreen;Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Image;Z)V", "getIndex", "()I", "getId", "()Ljava/lang/String;", "getUuid", "getUrl", "()Z", "getLink", "()Lio/adn/sdk/internal/domain/model/ad/AdLink$Fullscreen;", "getPromotedApp", "()Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "getConfig", "()Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Image;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Image implements FullscreenAdScene {
        public static final int $stable = 8;
        private final FullscreenAdSceneConfig.Image config;
        private final String id;
        private final int index;
        private final boolean isEndCard;
        private final boolean isLastScene;
        private final AdLink.Fullscreen link;
        private final AdPromotedApp promotedApp;
        private final String url;
        private final String uuid;

        public static /* synthetic */ Image copy$default(Image image, int i, String str, String str2, String str3, boolean z, AdLink.Fullscreen fullscreen, AdPromotedApp adPromotedApp, FullscreenAdSceneConfig.Image image2, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = image.index;
            }
            if ((i2 & 2) != 0) {
                str = image.id;
            }
            if ((i2 & 4) != 0) {
                str2 = image.uuid;
            }
            if ((i2 & 8) != 0) {
                str3 = image.url;
            }
            if ((i2 & 16) != 0) {
                z = image.isLastScene;
            }
            if ((i2 & 32) != 0) {
                fullscreen = image.link;
            }
            if ((i2 & 64) != 0) {
                adPromotedApp = image.promotedApp;
            }
            if ((i2 & 128) != 0) {
                image2 = image.config;
            }
            if ((i2 & 256) != 0) {
                z2 = image.isEndCard;
            }
            FullscreenAdSceneConfig.Image image3 = image2;
            boolean z3 = z2;
            AdLink.Fullscreen fullscreen2 = fullscreen;
            AdPromotedApp adPromotedApp2 = adPromotedApp;
            boolean z4 = z;
            String str4 = str2;
            return image.copy(i, str, str4, str3, z4, fullscreen2, adPromotedApp2, image3, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component3, reason: from getter */
        public final String getUuid() {
            return this.uuid;
        }

        /* renamed from: component4, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsLastScene() {
            return this.isLastScene;
        }

        /* renamed from: component6, reason: from getter */
        public final AdLink.Fullscreen getLink() {
            return this.link;
        }

        /* renamed from: component7, reason: from getter */
        public final AdPromotedApp getPromotedApp() {
            return this.promotedApp;
        }

        /* renamed from: component8, reason: from getter */
        public final FullscreenAdSceneConfig.Image getConfig() {
            return this.config;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getIsEndCard() {
            return this.isEndCard;
        }

        public final Image copy(int index, String id, String uuid, String url, boolean isLastScene, AdLink.Fullscreen link, AdPromotedApp promotedApp, FullscreenAdSceneConfig.Image config, boolean isEndCard) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(link, "link");
            Intrinsics.checkNotNullParameter(config, "config");
            return new Image(index, id, uuid, url, isLastScene, link, promotedApp, config, isEndCard);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Image)) {
                return false;
            }
            Image image = (Image) other;
            return this.index == image.index && Intrinsics.areEqual(this.id, image.id) && Intrinsics.areEqual(this.uuid, image.uuid) && Intrinsics.areEqual(this.url, image.url) && this.isLastScene == image.isLastScene && Intrinsics.areEqual(this.link, image.link) && Intrinsics.areEqual(this.promotedApp, image.promotedApp) && Intrinsics.areEqual(this.config, image.config) && this.isEndCard == image.isEndCard;
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.index) * 31;
            String str = this.id;
            int hashCode2 = (((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.uuid.hashCode()) * 31) + this.url.hashCode()) * 31) + Boolean.hashCode(this.isLastScene)) * 31) + this.link.hashCode()) * 31;
            AdPromotedApp adPromotedApp = this.promotedApp;
            return ((((hashCode2 + (adPromotedApp != null ? adPromotedApp.hashCode() : 0)) * 31) + this.config.hashCode()) * 31) + Boolean.hashCode(this.isEndCard);
        }

        public String toString() {
            return "Image(index=" + this.index + ", id=" + this.id + ", uuid=" + this.uuid + ", url=" + this.url + ", isLastScene=" + this.isLastScene + ", link=" + this.link + ", promotedApp=" + this.promotedApp + ", config=" + this.config + ", isEndCard=" + this.isEndCard + ')';
        }

        public Image(int i, String str, String uuid, String url, boolean z, AdLink.Fullscreen link, AdPromotedApp adPromotedApp, FullscreenAdSceneConfig.Image config, boolean z2) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(link, "link");
            Intrinsics.checkNotNullParameter(config, "config");
            this.index = i;
            this.id = str;
            this.uuid = uuid;
            this.url = url;
            this.isLastScene = z;
            this.link = link;
            this.promotedApp = adPromotedApp;
            this.config = config;
            this.isEndCard = z2;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public int getIndex() {
            return this.index;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public String getId() {
            return this.id;
        }

        public /* synthetic */ Image(int i, String str, String str2, String str3, boolean z, AdLink.Fullscreen fullscreen, AdPromotedApp adPromotedApp, FullscreenAdSceneConfig.Image image, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, (i2 & 4) != 0 ? ConversionsKt.randomUUID() : str2, str3, z, fullscreen, adPromotedApp, image, (i2 & 256) != 0 ? false : z2);
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public String getUuid() {
            return this.uuid;
        }

        public final String getUrl() {
            return this.url;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public boolean isLastScene() {
            return this.isLastScene;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public AdLink.Fullscreen getLink() {
            return this.link;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public AdPromotedApp getPromotedApp() {
            return this.promotedApp;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public FullscreenAdSceneConfig.Image getConfig() {
            return this.config;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public boolean isEndCard() {
            return this.isEndCard;
        }
    }

    /* compiled from: FullscreenAdEntity.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\fHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010-\u001a\u00020\u0010HÆ\u0003J\t\u0010.\u001a\u00020\u0012HÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003J{\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\tHÇ\u0001J\u0013\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u000103H×\u0003J\t\u00104\u001a\u00020\u0003H×\u0001J\t\u00105\u001a\u00020\u0005H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001cR\u0014\u0010\n\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001cR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010\u0013\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u001c¨\u00066"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$Video;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", FirebaseAnalytics.Param.INDEX, "", "id", "", "uuid", "url", "isMute", "", "isLastScene", "link", "Lio/adn/sdk/internal/domain/model/ad/AdLink$Fullscreen;", "promotedApp", "Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "config", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Video;", "tracking", "Lio/adn/sdk/internal/domain/model/ad/AdVideoTracking;", "isEndCard", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLio/adn/sdk/internal/domain/model/ad/AdLink$Fullscreen;Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Video;Lio/adn/sdk/internal/domain/model/ad/AdVideoTracking;Z)V", "getIndex", "()I", "getId", "()Ljava/lang/String;", "getUuid", "getUrl", "()Z", "getLink", "()Lio/adn/sdk/internal/domain/model/ad/AdLink$Fullscreen;", "getPromotedApp", "()Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "getConfig", "()Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Video;", "getTracking", "()Lio/adn/sdk/internal/domain/model/ad/AdVideoTracking;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Video implements FullscreenAdScene {
        public static final int $stable = 8;
        private final FullscreenAdSceneConfig.Video config;
        private final String id;
        private final int index;
        private final boolean isEndCard;
        private final boolean isLastScene;
        private final boolean isMute;
        private final AdLink.Fullscreen link;
        private final AdPromotedApp promotedApp;
        private final AdVideoTracking tracking;
        private final String url;
        private final String uuid;

        public static /* synthetic */ Video copy$default(Video video, int i, String str, String str2, String str3, boolean z, boolean z2, AdLink.Fullscreen fullscreen, AdPromotedApp adPromotedApp, FullscreenAdSceneConfig.Video video2, AdVideoTracking adVideoTracking, boolean z3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = video.index;
            }
            if ((i2 & 2) != 0) {
                str = video.id;
            }
            if ((i2 & 4) != 0) {
                str2 = video.uuid;
            }
            if ((i2 & 8) != 0) {
                str3 = video.url;
            }
            if ((i2 & 16) != 0) {
                z = video.isMute;
            }
            if ((i2 & 32) != 0) {
                z2 = video.isLastScene;
            }
            if ((i2 & 64) != 0) {
                fullscreen = video.link;
            }
            if ((i2 & 128) != 0) {
                adPromotedApp = video.promotedApp;
            }
            if ((i2 & 256) != 0) {
                video2 = video.config;
            }
            if ((i2 & 512) != 0) {
                adVideoTracking = video.tracking;
            }
            if ((i2 & 1024) != 0) {
                z3 = video.isEndCard;
            }
            AdVideoTracking adVideoTracking2 = adVideoTracking;
            boolean z4 = z3;
            AdPromotedApp adPromotedApp2 = adPromotedApp;
            FullscreenAdSceneConfig.Video video3 = video2;
            boolean z5 = z2;
            AdLink.Fullscreen fullscreen2 = fullscreen;
            boolean z6 = z;
            String str4 = str2;
            return video.copy(i, str, str4, str3, z6, z5, fullscreen2, adPromotedApp2, video3, adVideoTracking2, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* renamed from: component10, reason: from getter */
        public final AdVideoTracking getTracking() {
            return this.tracking;
        }

        /* renamed from: component11, reason: from getter */
        public final boolean getIsEndCard() {
            return this.isEndCard;
        }

        /* renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component3, reason: from getter */
        public final String getUuid() {
            return this.uuid;
        }

        /* renamed from: component4, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsMute() {
            return this.isMute;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsLastScene() {
            return this.isLastScene;
        }

        /* renamed from: component7, reason: from getter */
        public final AdLink.Fullscreen getLink() {
            return this.link;
        }

        /* renamed from: component8, reason: from getter */
        public final AdPromotedApp getPromotedApp() {
            return this.promotedApp;
        }

        /* renamed from: component9, reason: from getter */
        public final FullscreenAdSceneConfig.Video getConfig() {
            return this.config;
        }

        public final Video copy(int index, String id, String uuid, String url, boolean isMute, boolean isLastScene, AdLink.Fullscreen link, AdPromotedApp promotedApp, FullscreenAdSceneConfig.Video config, AdVideoTracking tracking, boolean isEndCard) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(link, "link");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(tracking, "tracking");
            return new Video(index, id, uuid, url, isMute, isLastScene, link, promotedApp, config, tracking, isEndCard);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Video)) {
                return false;
            }
            Video video = (Video) other;
            return this.index == video.index && Intrinsics.areEqual(this.id, video.id) && Intrinsics.areEqual(this.uuid, video.uuid) && Intrinsics.areEqual(this.url, video.url) && this.isMute == video.isMute && this.isLastScene == video.isLastScene && Intrinsics.areEqual(this.link, video.link) && Intrinsics.areEqual(this.promotedApp, video.promotedApp) && Intrinsics.areEqual(this.config, video.config) && Intrinsics.areEqual(this.tracking, video.tracking) && this.isEndCard == video.isEndCard;
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.index) * 31;
            String str = this.id;
            int hashCode2 = (((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.uuid.hashCode()) * 31) + this.url.hashCode()) * 31) + Boolean.hashCode(this.isMute)) * 31) + Boolean.hashCode(this.isLastScene)) * 31) + this.link.hashCode()) * 31;
            AdPromotedApp adPromotedApp = this.promotedApp;
            return ((((((hashCode2 + (adPromotedApp != null ? adPromotedApp.hashCode() : 0)) * 31) + this.config.hashCode()) * 31) + this.tracking.hashCode()) * 31) + Boolean.hashCode(this.isEndCard);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Video(index=");
            sb.append(this.index).append(", id=").append(this.id).append(", uuid=").append(this.uuid).append(", url=").append(this.url).append(", isMute=").append(this.isMute).append(", isLastScene=").append(this.isLastScene).append(", link=").append(this.link).append(", promotedApp=").append(this.promotedApp).append(", config=").append(this.config).append(", tracking=").append(this.tracking).append(", isEndCard=").append(this.isEndCard).append(')');
            return sb.toString();
        }

        public Video(int i, String str, String uuid, String url, boolean z, boolean z2, AdLink.Fullscreen link, AdPromotedApp adPromotedApp, FullscreenAdSceneConfig.Video config, AdVideoTracking tracking, boolean z3) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(link, "link");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(tracking, "tracking");
            this.index = i;
            this.id = str;
            this.uuid = uuid;
            this.url = url;
            this.isMute = z;
            this.isLastScene = z2;
            this.link = link;
            this.promotedApp = adPromotedApp;
            this.config = config;
            this.tracking = tracking;
            this.isEndCard = z3;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public int getIndex() {
            return this.index;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public String getId() {
            return this.id;
        }

        public /* synthetic */ Video(int i, String str, String str2, String str3, boolean z, boolean z2, AdLink.Fullscreen fullscreen, AdPromotedApp adPromotedApp, FullscreenAdSceneConfig.Video video, AdVideoTracking adVideoTracking, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, (i2 & 4) != 0 ? ConversionsKt.randomUUID() : str2, str3, z, z2, fullscreen, adPromotedApp, video, adVideoTracking, (i2 & 1024) != 0 ? false : z3);
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public String getUuid() {
            return this.uuid;
        }

        public final String getUrl() {
            return this.url;
        }

        public final boolean isMute() {
            return this.isMute;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public boolean isLastScene() {
            return this.isLastScene;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public AdLink.Fullscreen getLink() {
            return this.link;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public AdPromotedApp getPromotedApp() {
            return this.promotedApp;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public FullscreenAdSceneConfig.Video getConfig() {
            return this.config;
        }

        public final AdVideoTracking getTracking() {
            return this.tracking;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public boolean isEndCard() {
            return this.isEndCard;
        }
    }

    /* compiled from: FullscreenAdEntity.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003J\t\u0010$\u001a\u00020\u000eHÆ\u0003J\t\u0010%\u001a\u00020\u000eHÆ\u0003J[\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eHÇ\u0001J\u0013\u0010'\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010)H×\u0003J\t\u0010*\u001a\u00020\u0003H×\u0001J\t\u0010+\u001a\u00020\u0005H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001dR\u0014\u0010\u000f\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001d¨\u0006,"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$PromotedAppCard;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", FirebaseAnalytics.Param.INDEX, "", "id", "", "uuid", "promotedApp", "Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "link", "Lio/adn/sdk/internal/domain/model/ad/AdLink$Fullscreen;", "config", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$PromotedAppCard;", "isLastScene", "", "isEndCard", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;Lio/adn/sdk/internal/domain/model/ad/AdLink$Fullscreen;Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$PromotedAppCard;ZZ)V", "getIndex", "()I", "getId", "()Ljava/lang/String;", "getUuid", "getPromotedApp", "()Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "getLink", "()Lio/adn/sdk/internal/domain/model/ad/AdLink$Fullscreen;", "getConfig", "()Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$PromotedAppCard;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class PromotedAppCard implements FullscreenAdScene {
        public static final int $stable = 8;
        private final FullscreenAdSceneConfig.PromotedAppCard config;
        private final String id;
        private final int index;
        private final boolean isEndCard;
        private final boolean isLastScene;
        private final AdLink.Fullscreen link;
        private final AdPromotedApp promotedApp;
        private final String uuid;

        public static /* synthetic */ PromotedAppCard copy$default(PromotedAppCard promotedAppCard, int i, String str, String str2, AdPromotedApp adPromotedApp, AdLink.Fullscreen fullscreen, FullscreenAdSceneConfig.PromotedAppCard promotedAppCard2, boolean z, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = promotedAppCard.index;
            }
            if ((i2 & 2) != 0) {
                str = promotedAppCard.id;
            }
            if ((i2 & 4) != 0) {
                str2 = promotedAppCard.uuid;
            }
            if ((i2 & 8) != 0) {
                adPromotedApp = promotedAppCard.promotedApp;
            }
            if ((i2 & 16) != 0) {
                fullscreen = promotedAppCard.link;
            }
            if ((i2 & 32) != 0) {
                promotedAppCard2 = promotedAppCard.config;
            }
            if ((i2 & 64) != 0) {
                z = promotedAppCard.isLastScene;
            }
            if ((i2 & 128) != 0) {
                z2 = promotedAppCard.isEndCard;
            }
            boolean z3 = z;
            boolean z4 = z2;
            AdLink.Fullscreen fullscreen2 = fullscreen;
            FullscreenAdSceneConfig.PromotedAppCard promotedAppCard3 = promotedAppCard2;
            return promotedAppCard.copy(i, str, str2, adPromotedApp, fullscreen2, promotedAppCard3, z3, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component3, reason: from getter */
        public final String getUuid() {
            return this.uuid;
        }

        /* renamed from: component4, reason: from getter */
        public final AdPromotedApp getPromotedApp() {
            return this.promotedApp;
        }

        /* renamed from: component5, reason: from getter */
        public final AdLink.Fullscreen getLink() {
            return this.link;
        }

        /* renamed from: component6, reason: from getter */
        public final FullscreenAdSceneConfig.PromotedAppCard getConfig() {
            return this.config;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsLastScene() {
            return this.isLastScene;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getIsEndCard() {
            return this.isEndCard;
        }

        public final PromotedAppCard copy(int index, String id, String uuid, AdPromotedApp promotedApp, AdLink.Fullscreen link, FullscreenAdSceneConfig.PromotedAppCard config, boolean isLastScene, boolean isEndCard) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(promotedApp, "promotedApp");
            Intrinsics.checkNotNullParameter(link, "link");
            Intrinsics.checkNotNullParameter(config, "config");
            return new PromotedAppCard(index, id, uuid, promotedApp, link, config, isLastScene, isEndCard);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PromotedAppCard)) {
                return false;
            }
            PromotedAppCard promotedAppCard = (PromotedAppCard) other;
            return this.index == promotedAppCard.index && Intrinsics.areEqual(this.id, promotedAppCard.id) && Intrinsics.areEqual(this.uuid, promotedAppCard.uuid) && Intrinsics.areEqual(this.promotedApp, promotedAppCard.promotedApp) && Intrinsics.areEqual(this.link, promotedAppCard.link) && Intrinsics.areEqual(this.config, promotedAppCard.config) && this.isLastScene == promotedAppCard.isLastScene && this.isEndCard == promotedAppCard.isEndCard;
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.index) * 31;
            String str = this.id;
            return ((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.uuid.hashCode()) * 31) + this.promotedApp.hashCode()) * 31) + this.link.hashCode()) * 31) + this.config.hashCode()) * 31) + Boolean.hashCode(this.isLastScene)) * 31) + Boolean.hashCode(this.isEndCard);
        }

        public String toString() {
            return "PromotedAppCard(index=" + this.index + ", id=" + this.id + ", uuid=" + this.uuid + ", promotedApp=" + this.promotedApp + ", link=" + this.link + ", config=" + this.config + ", isLastScene=" + this.isLastScene + ", isEndCard=" + this.isEndCard + ')';
        }

        public PromotedAppCard(int i, String str, String uuid, AdPromotedApp promotedApp, AdLink.Fullscreen link, FullscreenAdSceneConfig.PromotedAppCard config, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(promotedApp, "promotedApp");
            Intrinsics.checkNotNullParameter(link, "link");
            Intrinsics.checkNotNullParameter(config, "config");
            this.index = i;
            this.id = str;
            this.uuid = uuid;
            this.promotedApp = promotedApp;
            this.link = link;
            this.config = config;
            this.isLastScene = z;
            this.isEndCard = z2;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public int getIndex() {
            return this.index;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public String getId() {
            return this.id;
        }

        public /* synthetic */ PromotedAppCard(int i, String str, String str2, AdPromotedApp adPromotedApp, AdLink.Fullscreen fullscreen, FullscreenAdSceneConfig.PromotedAppCard promotedAppCard, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? ConversionsKt.randomUUID() : str2, adPromotedApp, fullscreen, promotedAppCard, (i2 & 64) != 0 ? true : z, (i2 & 128) != 0 ? true : z2);
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public String getUuid() {
            return this.uuid;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public AdPromotedApp getPromotedApp() {
            return this.promotedApp;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public AdLink.Fullscreen getLink() {
            return this.link;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public FullscreenAdSceneConfig.PromotedAppCard getConfig() {
            return this.config;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public boolean isLastScene() {
            return this.isLastScene;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdScene
        public boolean isEndCard() {
            return this.isEndCard;
        }
    }
}
