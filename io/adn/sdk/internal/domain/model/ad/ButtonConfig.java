package io.adn.sdk.internal.domain.model.ad;

import com.ironsource.C3040d4;
import io.adn.sdk.internal.domain.model.ui.LayoutPosition;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

/* compiled from: AdConfig.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/ButtonConfig;", "", C3040d4.h.L, "Lio/adn/sdk/internal/domain/model/ui/LayoutPosition;", "getPosition", "()Lio/adn/sdk/internal/domain/model/ui/LayoutPosition;", ContentDisposition.Parameters.Size, "", "getSize", "()I", "color", "getColor", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface ButtonConfig {
    int getColor();

    LayoutPosition getPosition();

    int getSize();
}
