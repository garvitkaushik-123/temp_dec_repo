package com.sourcepoint.cmplibrary.data.network.util;

import com.sourcepoint.cmplibrary.data.network.model.optimized.CcpaCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.PvDataResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.ChoiceResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.ChoiceTypeParam;
import com.sourcepoint.cmplibrary.model.CustomConsentResp;
import kotlin.Metadata;
import okhttp3.Response;

/* compiled from: ResponseManager.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0019"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/util/ResponseManager;", "", "parseConsentStatusResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusResp;", "r", "Lokhttp3/Response;", "parseCustomConsentRes", "Lcom/sourcepoint/cmplibrary/model/CustomConsentResp;", "parseGetChoiceResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceResp;", "choice", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceTypeParam;", "parseMessagesResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesResp;", "parseMetaDataRes", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;", "parsePostCcpaChoiceResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "parsePostGdprChoiceResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "parsePostUsNatChoiceResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "parsePvDataResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp;", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ResponseManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    ConsentStatusResp parseConsentStatusResp(Response r);

    CustomConsentResp parseCustomConsentRes(Response r);

    ChoiceResp parseGetChoiceResp(Response r, ChoiceTypeParam choice);

    MessagesResp parseMessagesResp(Response r);

    MetaDataResp parseMetaDataRes(Response r);

    CcpaCS parsePostCcpaChoiceResp(Response r);

    GdprCS parsePostGdprChoiceResp(Response r);

    USNatConsentData parsePostUsNatChoiceResp(Response r);

    PvDataResp parsePvDataResp(Response r);

    /* compiled from: ResponseManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/util/ResponseManager$Companion;", "", "()V", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
