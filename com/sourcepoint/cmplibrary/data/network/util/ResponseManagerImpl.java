package com.sourcepoint.cmplibrary.data.network.util;

import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.model.optimized.CcpaCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.PvDataResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.ChoiceResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.ChoiceTypeParam;
import com.sourcepoint.cmplibrary.exception.ApiRequestPostfix;
import com.sourcepoint.cmplibrary.exception.InvalidRequestException;
import com.sourcepoint.cmplibrary.exception.Logger;
import com.sourcepoint.cmplibrary.exception.RequestFailedException;
import com.sourcepoint.cmplibrary.model.CustomConsentResp;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: ResponseManagerImpl.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006!"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/util/ResponseManagerImpl;", "Lcom/sourcepoint/cmplibrary/data/network/util/ResponseManager;", "jsonConverter", "Lcom/sourcepoint/cmplibrary/data/network/converter/JsonConverter;", "logger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "(Lcom/sourcepoint/cmplibrary/data/network/converter/JsonConverter;Lcom/sourcepoint/cmplibrary/exception/Logger;)V", "getJsonConverter", "()Lcom/sourcepoint/cmplibrary/data/network/converter/JsonConverter;", "getLogger", "()Lcom/sourcepoint/cmplibrary/exception/Logger;", "parseConsentStatusResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusResp;", "r", "Lokhttp3/Response;", "parseCustomConsentRes", "Lcom/sourcepoint/cmplibrary/model/CustomConsentResp;", "parseGetChoiceResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceResp;", "choice", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceTypeParam;", "parseMessagesResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesResp;", "parseMetaDataRes", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;", "parsePostCcpaChoiceResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "parsePostGdprChoiceResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "parsePostUsNatChoiceResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "parsePvDataResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ResponseManagerImpl implements ResponseManager {
    private final JsonConverter jsonConverter;
    private final Logger logger;

    public ResponseManagerImpl(JsonConverter jsonConverter, Logger logger) {
        Intrinsics.checkNotNullParameter(jsonConverter, "jsonConverter");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.jsonConverter = jsonConverter;
        this.logger = logger;
    }

    public final JsonConverter getJsonConverter() {
        return this.jsonConverter;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.ResponseManager
    public CustomConsentResp parseCustomConsentRes(Response r) {
        String str;
        InputStream byteStream;
        Intrinsics.checkNotNullParameter(r, "r");
        ResponseBody body = r.body();
        if (body == null || (byteStream = body.byteStream()) == null || (str = TextStreamsKt.readText(new InputStreamReader(byteStream, Charsets.UTF_8))) == null) {
            str = "";
        }
        String str2 = str;
        this.logger.res("CustomConsentResp", r.message(), String.valueOf(r.code()), str2);
        if (r.isSuccessful()) {
            Either<CustomConsentResp> customConsentResp = this.jsonConverter.toCustomConsentResp(str2);
            if (customConsentResp instanceof Either.Right) {
                return (CustomConsentResp) ((Either.Right) customConsentResp).getR();
            }
            if (customConsentResp instanceof Either.Left) {
                throw ((Either.Left) customConsentResp).getT();
            }
            throw new NoWhenBranchMatchedException();
        }
        throw new InvalidRequestException(null, str2, false, null, null, null, 61, null);
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.ResponseManager
    public MetaDataResp parseMetaDataRes(Response r) {
        String str;
        InputStream byteStream;
        Intrinsics.checkNotNullParameter(r, "r");
        ResponseBody body = r.body();
        if (body == null || (byteStream = body.byteStream()) == null || (str = TextStreamsKt.readText(new InputStreamReader(byteStream, Charsets.UTF_8))) == null) {
            str = "";
        }
        String str2 = str;
        int code = r.code();
        this.logger.res("MetaDataResp", r.message(), String.valueOf(code), str2);
        if (r.isSuccessful()) {
            Either<MetaDataResp> metaDataRespResp = this.jsonConverter.toMetaDataRespResp(str2);
            if (metaDataRespResp instanceof Either.Right) {
                return (MetaDataResp) ((Either.Right) metaDataRespResp).getR();
            }
            if (metaDataRespResp instanceof Either.Left) {
                throw ((Either.Left) metaDataRespResp).getT();
            }
            throw new NoWhenBranchMatchedException();
        }
        throw new RequestFailedException(null, str2, false, ApiRequestPostfix.META_DATA.getApiPostfix(), null, "_" + code, 21, null);
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.ResponseManager
    public ConsentStatusResp parseConsentStatusResp(Response r) {
        String str;
        InputStream byteStream;
        Intrinsics.checkNotNullParameter(r, "r");
        ResponseBody body = r.body();
        if (body == null || (byteStream = body.byteStream()) == null || (str = TextStreamsKt.readText(new InputStreamReader(byteStream, Charsets.UTF_8))) == null) {
            str = "";
        }
        String str2 = str;
        int code = r.code();
        this.logger.res("ConsentStatusResp", r.message(), String.valueOf(code), str2);
        if (r.isSuccessful()) {
            Either<ConsentStatusResp> consentStatusResp = this.jsonConverter.toConsentStatusResp(str2);
            if (consentStatusResp instanceof Either.Right) {
                return (ConsentStatusResp) ((Either.Right) consentStatusResp).getR();
            }
            if (consentStatusResp instanceof Either.Left) {
                throw ((Either.Left) consentStatusResp).getT();
            }
            throw new NoWhenBranchMatchedException();
        }
        throw new RequestFailedException(null, str2, false, ApiRequestPostfix.CONSENT_STATUS.getApiPostfix(), null, "_" + code, 21, null);
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.ResponseManager
    public ChoiceResp parseGetChoiceResp(Response r, ChoiceTypeParam choice) {
        String str;
        InputStream byteStream;
        Intrinsics.checkNotNullParameter(r, "r");
        Intrinsics.checkNotNullParameter(choice, "choice");
        ResponseBody body = r.body();
        if (body == null || (byteStream = body.byteStream()) == null || (str = TextStreamsKt.readText(new InputStreamReader(byteStream, Charsets.UTF_8))) == null) {
            str = "";
        }
        String str2 = str;
        int code = r.code();
        this.logger.res("ChoiceResp", r.message(), String.valueOf(code), str2);
        if (r.isSuccessful()) {
            Either<ChoiceResp> choiceResp = this.jsonConverter.toChoiceResp(str2);
            if (choiceResp instanceof Either.Right) {
                return (ChoiceResp) ((Either.Right) choiceResp).getR();
            }
            if (choiceResp instanceof Either.Left) {
                throw ((Either.Left) choiceResp).getT();
            }
            throw new NoWhenBranchMatchedException();
        }
        throw new RequestFailedException(null, str2, false, ApiRequestPostfix.GET_CHOICE.getApiPostfix(), "_" + choice.getType(), "_" + code, 5, null);
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.ResponseManager
    public GdprCS parsePostGdprChoiceResp(Response r) {
        String str;
        InputStream byteStream;
        Intrinsics.checkNotNullParameter(r, "r");
        ResponseBody body = r.body();
        if (body == null || (byteStream = body.byteStream()) == null || (str = TextStreamsKt.readText(new InputStreamReader(byteStream, Charsets.UTF_8))) == null) {
            str = "";
        }
        String str2 = str;
        int code = r.code();
        this.logger.res("PostGdprChoiceResp", r.message(), String.valueOf(code), str2);
        if (r.isSuccessful()) {
            Either<GdprCS> gdprPostChoiceResp = this.jsonConverter.toGdprPostChoiceResp(str2);
            if (gdprPostChoiceResp instanceof Either.Right) {
                return (GdprCS) ((Either.Right) gdprPostChoiceResp).getR();
            }
            if (gdprPostChoiceResp instanceof Either.Left) {
                throw ((Either.Left) gdprPostChoiceResp).getT();
            }
            throw new NoWhenBranchMatchedException();
        }
        throw new RequestFailedException(null, str2, false, ApiRequestPostfix.POST_CHOICE_GDPR.getApiPostfix(), null, "_" + code, 21, null);
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.ResponseManager
    public CcpaCS parsePostCcpaChoiceResp(Response r) {
        String str;
        InputStream byteStream;
        Intrinsics.checkNotNullParameter(r, "r");
        ResponseBody body = r.body();
        if (body == null || (byteStream = body.byteStream()) == null || (str = TextStreamsKt.readText(new InputStreamReader(byteStream, Charsets.UTF_8))) == null) {
            str = "";
        }
        String str2 = str;
        int code = r.code();
        this.logger.res("PostCcpaChoiceResp", r.message(), String.valueOf(code), str2);
        if (r.isSuccessful()) {
            Either<CcpaCS> ccpaPostChoiceResp = this.jsonConverter.toCcpaPostChoiceResp(str2);
            if (ccpaPostChoiceResp instanceof Either.Right) {
                return (CcpaCS) ((Either.Right) ccpaPostChoiceResp).getR();
            }
            if (ccpaPostChoiceResp instanceof Either.Left) {
                throw ((Either.Left) ccpaPostChoiceResp).getT();
            }
            throw new NoWhenBranchMatchedException();
        }
        throw new RequestFailedException(null, str2, false, ApiRequestPostfix.POST_CHOICE_CCPA.getApiPostfix(), null, "_" + code, 21, null);
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.ResponseManager
    public USNatConsentData parsePostUsNatChoiceResp(Response r) {
        String str;
        InputStream byteStream;
        Intrinsics.checkNotNullParameter(r, "r");
        ResponseBody body = r.body();
        if (body == null || (byteStream = body.byteStream()) == null || (str = TextStreamsKt.readText(new InputStreamReader(byteStream, Charsets.UTF_8))) == null) {
            str = "";
        }
        String str2 = str;
        int code = r.code();
        this.logger.res("PostUsNatChoiceResp", r.message(), String.valueOf(code), str2);
        if (r.isSuccessful()) {
            Either<USNatConsentData> usNatPostChoiceResp = this.jsonConverter.toUsNatPostChoiceResp(str2);
            if (usNatPostChoiceResp instanceof Either.Right) {
                return (USNatConsentData) ((Either.Right) usNatPostChoiceResp).getR();
            }
            if (usNatPostChoiceResp instanceof Either.Left) {
                throw ((Either.Left) usNatPostChoiceResp).getT();
            }
            throw new NoWhenBranchMatchedException();
        }
        throw new RequestFailedException(null, str2, false, ApiRequestPostfix.POST_CHOICE_USNAT.getApiPostfix(), null, "_" + code, 21, null);
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.ResponseManager
    public PvDataResp parsePvDataResp(Response r) {
        String str;
        Object obj;
        String str2;
        InputStream byteStream;
        Intrinsics.checkNotNullParameter(r, "r");
        ResponseBody body = r.body();
        if (body == null || (byteStream = body.byteStream()) == null || (str = TextStreamsKt.readText(new InputStreamReader(byteStream, Charsets.UTF_8))) == null) {
            str = "";
        }
        String str3 = str;
        int code = r.code();
        String message = r.message();
        if (r.isSuccessful()) {
            Either<PvDataResp> pvDataResp = this.jsonConverter.toPvDataResp(str3);
            boolean z = pvDataResp instanceof Either.Right;
            if (z) {
                String str4 = null;
                if (z) {
                    obj = ((Either.Right) pvDataResp).getR();
                } else {
                    if (!(pvDataResp instanceof Either.Left)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    obj = null;
                }
                PvDataResp pvDataResp2 = (PvDataResp) obj;
                if (pvDataResp2 != null) {
                    if (pvDataResp2.getGdpr() != null) {
                        str2 = "GDPR";
                    } else if (pvDataResp2.getCcpa() != null) {
                        str2 = "CCPA";
                    } else if (pvDataResp2.getUsnat() != null) {
                        str2 = "USNAT";
                    }
                    str4 = str2;
                }
                this.logger.res("PvDataResp - " + str4, message, String.valueOf(code), str3);
                return (PvDataResp) ((Either.Right) pvDataResp).getR();
            }
            if (!(pvDataResp instanceof Either.Left)) {
                throw new NoWhenBranchMatchedException();
            }
            this.logger.res("PvDataResp", message, String.valueOf(code), str3);
            throw ((Either.Left) pvDataResp).getT();
        }
        throw new RequestFailedException(null, str3, false, ApiRequestPostfix.PV_DATA.getApiPostfix(), null, "_" + code, 21, null);
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.ResponseManager
    public MessagesResp parseMessagesResp(Response r) {
        String str;
        InputStream byteStream;
        Intrinsics.checkNotNullParameter(r, "r");
        ResponseBody body = r.body();
        if (body == null || (byteStream = body.byteStream()) == null || (str = TextStreamsKt.readText(new InputStreamReader(byteStream, Charsets.UTF_8))) == null) {
            str = "";
        }
        String str2 = str;
        int code = r.code();
        this.logger.res("MessagesResp", r.message(), String.valueOf(code), str2);
        if (r.isSuccessful()) {
            Either<MessagesResp> messagesResp = this.jsonConverter.toMessagesResp(str2);
            if (messagesResp instanceof Either.Right) {
                return (MessagesResp) ((Either.Right) messagesResp).getR();
            }
            if (messagesResp instanceof Either.Left) {
                throw ((Either.Left) messagesResp).getT();
            }
            throw new NoWhenBranchMatchedException();
        }
        throw new RequestFailedException(null, str2, false, ApiRequestPostfix.MESSAGES.getApiPostfix(), null, "_" + code, 21, null);
    }
}
