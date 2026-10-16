package io.adn.sdk.internal.ui.common.mraid;

import io.adn.sdk.internal.ui.common.model.ClickPosition;
import io.adn.sdk.publisher.AdnClickElement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MraidControllerEvent.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0005¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidControllerEvent;", "", "<init>", "()V", "Displayed", "ClickThrough", "Dismiss", "Lio/adn/sdk/internal/ui/common/mraid/MraidControllerEvent$ClickThrough;", "Lio/adn/sdk/internal/ui/common/mraid/MraidControllerEvent$Dismiss;", "Lio/adn/sdk/internal/ui/common/mraid/MraidControllerEvent$Displayed;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public abstract class MraidControllerEvent {
    public static final int $stable = 0;

    public /* synthetic */ MraidControllerEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: MraidControllerEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidControllerEvent$Displayed;", "Lio/adn/sdk/internal/ui/common/mraid/MraidControllerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Displayed extends MraidControllerEvent {
        public static final int $stable = 0;
        public static final Displayed INSTANCE = new Displayed();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Displayed)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1355919564;
        }

        public String toString() {
            return "Displayed";
        }

        private Displayed() {
            super(null);
        }
    }

    private MraidControllerEvent() {
    }

    /* compiled from: MraidControllerEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÇ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H×\u0003J\t\u0010\u0017\u001a\u00020\u0018H×\u0001J\t\u0010\u0019\u001a\u00020\u001aH×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidControllerEvent$ClickThrough;", "Lio/adn/sdk/internal/ui/common/mraid/MraidControllerEvent;", "hasUserClicked", "", "clickElement", "Lio/adn/sdk/publisher/AdnClickElement;", "clickPosition", "Lio/adn/sdk/internal/ui/common/model/ClickPosition;", "<init>", "(ZLio/adn/sdk/publisher/AdnClickElement;Lio/adn/sdk/internal/ui/common/model/ClickPosition;)V", "getHasUserClicked", "()Z", "getClickElement", "()Lio/adn/sdk/publisher/AdnClickElement;", "getClickPosition", "()Lio/adn/sdk/internal/ui/common/model/ClickPosition;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ClickThrough extends MraidControllerEvent {
        public static final int $stable = 0;
        private final AdnClickElement clickElement;
        private final ClickPosition clickPosition;
        private final boolean hasUserClicked;

        public static /* synthetic */ ClickThrough copy$default(ClickThrough clickThrough, boolean z, AdnClickElement adnClickElement, ClickPosition clickPosition, int i, Object obj) {
            if ((i & 1) != 0) {
                z = clickThrough.hasUserClicked;
            }
            if ((i & 2) != 0) {
                adnClickElement = clickThrough.clickElement;
            }
            if ((i & 4) != 0) {
                clickPosition = clickThrough.clickPosition;
            }
            return clickThrough.copy(z, adnClickElement, clickPosition);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getHasUserClicked() {
            return this.hasUserClicked;
        }

        /* renamed from: component2, reason: from getter */
        public final AdnClickElement getClickElement() {
            return this.clickElement;
        }

        /* renamed from: component3, reason: from getter */
        public final ClickPosition getClickPosition() {
            return this.clickPosition;
        }

        public final ClickThrough copy(boolean hasUserClicked, AdnClickElement clickElement, ClickPosition clickPosition) {
            return new ClickThrough(hasUserClicked, clickElement, clickPosition);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClickThrough)) {
                return false;
            }
            ClickThrough clickThrough = (ClickThrough) other;
            return this.hasUserClicked == clickThrough.hasUserClicked && Intrinsics.areEqual(this.clickElement, clickThrough.clickElement) && Intrinsics.areEqual(this.clickPosition, clickThrough.clickPosition);
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.hasUserClicked) * 31;
            AdnClickElement adnClickElement = this.clickElement;
            int hashCode2 = (hashCode + (adnClickElement == null ? 0 : adnClickElement.hashCode())) * 31;
            ClickPosition clickPosition = this.clickPosition;
            return hashCode2 + (clickPosition != null ? clickPosition.hashCode() : 0);
        }

        public String toString() {
            return "ClickThrough(hasUserClicked=" + this.hasUserClicked + ", clickElement=" + this.clickElement + ", clickPosition=" + this.clickPosition + ')';
        }

        public final boolean getHasUserClicked() {
            return this.hasUserClicked;
        }

        public final AdnClickElement getClickElement() {
            return this.clickElement;
        }

        public final ClickPosition getClickPosition() {
            return this.clickPosition;
        }

        public ClickThrough(boolean z, AdnClickElement adnClickElement, ClickPosition clickPosition) {
            super(null);
            this.hasUserClicked = z;
            this.clickElement = adnClickElement;
            this.clickPosition = clickPosition;
        }
    }

    /* compiled from: MraidControllerEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidControllerEvent$Dismiss;", "Lio/adn/sdk/internal/ui/common/mraid/MraidControllerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Dismiss extends MraidControllerEvent {
        public static final int $stable = 0;
        public static final Dismiss INSTANCE = new Dismiss();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Dismiss)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -883595979;
        }

        public String toString() {
            return "Dismiss";
        }

        private Dismiss() {
            super(null);
        }
    }
}
