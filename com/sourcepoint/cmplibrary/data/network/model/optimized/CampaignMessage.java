package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import kotlin.Metadata;
import kotlinx.serialization.json.JsonElement;

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0016"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CampaignMessage;", "", "dateCreated", "", "getDateCreated", "()Ljava/lang/String;", "expirationDate", "getExpirationDate", PglCryptUtils.KEY_MESSAGE, "Lkotlinx/serialization/json/JsonElement;", "getMessage", "()Lkotlinx/serialization/json/JsonElement;", "messageMetaData", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;", "getMessageMetaData", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;", "type", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "getType", "()Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "url", "getUrl", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CampaignMessage {
    String getDateCreated();

    String getExpirationDate();

    JsonElement getMessage();

    MessageMetaData getMessageMetaData();

    CampaignType getType();

    String getUrl();
}
