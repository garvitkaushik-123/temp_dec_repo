package io.adn.sdk.publisher;

import com.google.firebase.messaging.Constants;
import com.ironsource.C3040d4;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdnClickElement.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00132\u00020\u0001:\f\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u000b\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e¨\u0006\u001f"}, d2 = {"Lio/adn/sdk/publisher/AdnClickElement;", "", C3040d4.h.W, "", "<init>", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "MainMedia", "Cta", k.C, "Title", "Body", k.k, "Close", "StoreOverlay", "Privacy", "Unknown", AndroidBridgeConstants.BANNER_POSITION_CUSTOM, "Companion", "Lio/adn/sdk/publisher/AdnClickElement$Advertiser;", "Lio/adn/sdk/publisher/AdnClickElement$Body;", "Lio/adn/sdk/publisher/AdnClickElement$Close;", "Lio/adn/sdk/publisher/AdnClickElement$Cta;", "Lio/adn/sdk/publisher/AdnClickElement$Custom;", "Lio/adn/sdk/publisher/AdnClickElement$Icon;", "Lio/adn/sdk/publisher/AdnClickElement$MainMedia;", "Lio/adn/sdk/publisher/AdnClickElement$Privacy;", "Lio/adn/sdk/publisher/AdnClickElement$StoreOverlay;", "Lio/adn/sdk/publisher/AdnClickElement$Title;", "Lio/adn/sdk/publisher/AdnClickElement$Unknown;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public abstract class AdnClickElement {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String key;

    public /* synthetic */ AdnClickElement(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    /* compiled from: AdnClickElement.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/publisher/AdnClickElement$MainMedia;", "Lio/adn/sdk/publisher/AdnClickElement;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class MainMedia extends AdnClickElement {
        public static final int $stable = 0;
        public static final MainMedia INSTANCE = new MainMedia();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MainMedia)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1207285419;
        }

        public String toString() {
            return "MainMedia";
        }

        private MainMedia() {
            super("mainMedia", null);
        }
    }

    private AdnClickElement(String str) {
        this.key = str;
    }

    public final String getKey() {
        return this.key;
    }

    /* compiled from: AdnClickElement.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/publisher/AdnClickElement$Cta;", "Lio/adn/sdk/publisher/AdnClickElement;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Cta extends AdnClickElement {
        public static final int $stable = 0;
        public static final Cta INSTANCE = new Cta();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Cta)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -135081200;
        }

        public String toString() {
            return "Cta";
        }

        private Cta() {
            super("cta", null);
        }
    }

    /* compiled from: AdnClickElement.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/publisher/AdnClickElement$Icon;", "Lio/adn/sdk/publisher/AdnClickElement;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Icon extends AdnClickElement {
        public static final int $stable = 0;
        public static final Icon INSTANCE = new Icon();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Icon)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 107613049;
        }

        public String toString() {
            return k.C;
        }

        private Icon() {
            super("icon", null);
        }
    }

    /* compiled from: AdnClickElement.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/publisher/AdnClickElement$Title;", "Lio/adn/sdk/publisher/AdnClickElement;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Title extends AdnClickElement {
        public static final int $stable = 0;
        public static final Title INSTANCE = new Title();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Title)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -948620456;
        }

        public String toString() {
            return "Title";
        }

        private Title() {
            super("title", null);
        }
    }

    /* compiled from: AdnClickElement.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/publisher/AdnClickElement$Body;", "Lio/adn/sdk/publisher/AdnClickElement;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Body extends AdnClickElement {
        public static final int $stable = 0;
        public static final Body INSTANCE = new Body();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Body)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 107415714;
        }

        public String toString() {
            return "Body";
        }

        private Body() {
            super("body", null);
        }
    }

    /* compiled from: AdnClickElement.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/publisher/AdnClickElement$Advertiser;", "Lio/adn/sdk/publisher/AdnClickElement;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Advertiser extends AdnClickElement {
        public static final int $stable = 0;
        public static final Advertiser INSTANCE = new Advertiser();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Advertiser)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1435669461;
        }

        public String toString() {
            return k.k;
        }

        private Advertiser() {
            super(C3040d4.h.F0, null);
        }
    }

    /* compiled from: AdnClickElement.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/publisher/AdnClickElement$Close;", "Lio/adn/sdk/publisher/AdnClickElement;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Close extends AdnClickElement {
        public static final int $stable = 0;
        public static final Close INSTANCE = new Close();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Close)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -964235528;
        }

        public String toString() {
            return "Close";
        }

        private Close() {
            super("close", null);
        }
    }

    /* compiled from: AdnClickElement.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/publisher/AdnClickElement$StoreOverlay;", "Lio/adn/sdk/publisher/AdnClickElement;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class StoreOverlay extends AdnClickElement {
        public static final int $stable = 0;
        public static final StoreOverlay INSTANCE = new StoreOverlay();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreOverlay)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1598217425;
        }

        public String toString() {
            return "StoreOverlay";
        }

        private StoreOverlay() {
            super("storeOverlay", null);
        }
    }

    /* compiled from: AdnClickElement.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/publisher/AdnClickElement$Privacy;", "Lio/adn/sdk/publisher/AdnClickElement;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Privacy extends AdnClickElement {
        public static final int $stable = 0;
        public static final Privacy INSTANCE = new Privacy();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Privacy)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -98438008;
        }

        public String toString() {
            return "Privacy";
        }

        private Privacy() {
            super("privacy", null);
        }
    }

    /* compiled from: AdnClickElement.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/publisher/AdnClickElement$Unknown;", "Lio/adn/sdk/publisher/AdnClickElement;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Unknown extends AdnClickElement {
        public static final int $stable = 0;
        public static final Unknown INSTANCE = new Unknown();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Unknown)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -68780726;
        }

        public String toString() {
            return "Unknown";
        }

        private Unknown() {
            super("unknown", null);
        }
    }

    /* compiled from: AdnClickElement.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/adn/sdk/publisher/AdnClickElement$Custom;", "Lio/adn/sdk/publisher/AdnClickElement;", "customType", "", "<init>", "(Ljava/lang/String;)V", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Custom extends AdnClickElement {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Custom(String customType) {
            super(customType, null);
            Intrinsics.checkNotNullParameter(customType, "customType");
        }
    }

    /* compiled from: AdnClickElement.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lio/adn/sdk/publisher/AdnClickElement$Companion;", "", "<init>", "()V", Constants.MessagePayloadKeys.FROM, "Lio/adn/sdk/publisher/AdnClickElement;", "type", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AdnClickElement from(String type) {
            if (Intrinsics.areEqual(type, MainMedia.INSTANCE.getKey())) {
                return MainMedia.INSTANCE;
            }
            if (Intrinsics.areEqual(type, Cta.INSTANCE.getKey())) {
                return Cta.INSTANCE;
            }
            if (Intrinsics.areEqual(type, Icon.INSTANCE.getKey())) {
                return Icon.INSTANCE;
            }
            if (Intrinsics.areEqual(type, Title.INSTANCE.getKey())) {
                return Title.INSTANCE;
            }
            if (Intrinsics.areEqual(type, Body.INSTANCE.getKey())) {
                return Body.INSTANCE;
            }
            if (Intrinsics.areEqual(type, Advertiser.INSTANCE.getKey())) {
                return Advertiser.INSTANCE;
            }
            if (Intrinsics.areEqual(type, Close.INSTANCE.getKey())) {
                return Close.INSTANCE;
            }
            if (Intrinsics.areEqual(type, StoreOverlay.INSTANCE.getKey())) {
                return StoreOverlay.INSTANCE;
            }
            if (Intrinsics.areEqual(type, Privacy.INSTANCE.getKey())) {
                return Privacy.INSTANCE;
            }
            if (Intrinsics.areEqual(type, Unknown.INSTANCE.getKey())) {
                return Unknown.INSTANCE;
            }
            return null;
        }
    }
}
