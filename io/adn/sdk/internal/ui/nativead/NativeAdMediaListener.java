package io.adn.sdk.internal.ui.nativead;

import com.ironsource.C3061e8;
import io.adn.sdk.internal.domain.model.ui.RenderingState;
import kotlin.Metadata;

/* compiled from: NativeMediaViewModel.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lio/adn/sdk/internal/ui/nativead/NativeAdMediaListener;", "", "onMediaDisplayed", "", "onMediaVisibilityChange", C3061e8.k, "", "renderingState", "Lio/adn/sdk/internal/domain/model/ui/RenderingState;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface NativeAdMediaListener {
    void onMediaDisplayed();

    void onMediaVisibilityChange(boolean isVisible, RenderingState renderingState);
}
