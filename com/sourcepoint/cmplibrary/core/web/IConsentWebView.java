package com.sourcepoint.cmplibrary.core.web;

import com.ironsource.C3040d4;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* compiled from: IConsentWebView.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J2\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0011"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/web/IConsentWebView;", "", "handleOnBackPress", "", "loadConsentUI", "Lcom/sourcepoint/cmplibrary/core/Either;", "", "campaignModel", "Lcom/sourcepoint/cmplibrary/core/web/CampaignModel;", "url", "Lokhttp3/HttpUrl;", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "loadConsentUIFromUrlPreloadingOption", "pmId", "", C3040d4.i.b0, "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IConsentWebView {
    void handleOnBackPress();

    Either<Boolean> loadConsentUI(CampaignModel campaignModel, HttpUrl url, CampaignType campaignType);

    Either<Boolean> loadConsentUIFromUrlPreloadingOption(HttpUrl url, CampaignType campaignType, String pmId, String consent);
}
