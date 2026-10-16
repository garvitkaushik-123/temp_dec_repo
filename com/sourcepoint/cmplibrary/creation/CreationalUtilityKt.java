package com.sourcepoint.cmplibrary.creation;

import android.os.Build;
import com.example.cmplibrary.BuildConfig;
import com.ironsource.C3040d4;
import com.sourcepoint.cmplibrary.campaign.CampaignManager;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.exception.ClientInfo;
import com.sourcepoint.cmplibrary.exception.ErrorMessageManager;
import com.sourcepoint.cmplibrary.exception.ErrorMessageManagerKt;
import com.sourcepoint.cmplibrary.exception.Logger;
import com.sourcepoint.cmplibrary.exception.LoggerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.OkHttpClient;

/* compiled from: CreationalUtility.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\r"}, d2 = {"validPattern", "Lkotlin/text/Regex;", "getValidPattern", "()Lkotlin/text/Regex;", "createClientInfo", "Lcom/sourcepoint/cmplibrary/exception/ClientInfo;", "createLogger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "errorMessageManager", "Lcom/sourcepoint/cmplibrary/exception/ErrorMessageManager;", "campaignManager", "Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;", "client", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CreationalUtilityKt {
    private static final Regex validPattern = new Regex("^[a-zA-Z.:/0-9-]*$");

    public static final ClientInfo createClientInfo() {
        return new ClientInfo(BuildConfig.VERSION_NAME, String.valueOf(Build.VERSION.SDK_INT), C3040d4.i.d + Build.MANUFACTURER + "]-[" + Build.MODEL + "]-[" + Build.DEVICE + C3040d4.i.e);
    }

    public static final ErrorMessageManager errorMessageManager(CampaignManager campaignManager, ClientInfo client) {
        Intrinsics.checkNotNullParameter(campaignManager, "campaignManager");
        Intrinsics.checkNotNullParameter(client, "client");
        return ErrorMessageManagerKt.createErrorManager(campaignManager, client, CampaignType.GDPR);
    }

    public static final Logger createLogger(ErrorMessageManager errorMessageManager) {
        Intrinsics.checkNotNullParameter(errorMessageManager, "errorMessageManager");
        return LoggerFactory.createLogger(new OkHttpClient(), errorMessageManager, BuildConfig.LOGGER_URL);
    }

    public static final Regex getValidPattern() {
        return validPattern;
    }
}
