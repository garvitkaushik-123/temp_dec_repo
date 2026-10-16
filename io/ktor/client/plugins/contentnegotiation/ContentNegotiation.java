package io.ktor.client.plugins.contentnegotiation;

import com.ironsource.C3040d4;
import com.ironsource.N6;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.internal.ui.AdActivity;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.client.utils.EmptyContent;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypeMatcher;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.Url;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.serialization.Configuration;
import io.ktor.serialization.ContentConverter;
import io.ktor.serialization.ContentConverterKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;
import org.slf4j.Logger;

/* compiled from: ContentNegotiation.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0002\u001f B'\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ%\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012JC\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\f\b\u0002\u0010\u001a\u001a\u00060\u001bj\u0002`\u001cH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lio/ktor/client/plugins/contentnegotiation/ContentNegotiation;", "", "registrations", "", "Lio/ktor/client/plugins/contentnegotiation/ContentNegotiation$Config$ConverterRegistration;", "ignoredTypes", "", "Lkotlin/reflect/KClass;", "(Ljava/util/List;Ljava/util/Set;)V", "getIgnoredTypes$ktor_client_content_negotiation", "()Ljava/util/Set;", "getRegistrations$ktor_client_content_negotiation", "()Ljava/util/List;", "convertRequest", AdActivity.REQUEST_KEY_EXTRA, "Lio/ktor/client/request/HttpRequestBuilder;", "body", "convertRequest$ktor_client_content_negotiation", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertResponse", IronSourceConstants.REQUEST_URL, "Lio/ktor/http/Url;", "info", "Lio/ktor/util/reflect/TypeInfo;", "responseContentType", "Lio/ktor/http/ContentType;", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "convertResponse$ktor_client_content_negotiation", "(Lio/ktor/http/Url;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;Lio/ktor/http/ContentType;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Config", "Plugin", "ktor-client-content-negotiation"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class ContentNegotiation {

    /* renamed from: Plugin, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AttributeKey<ContentNegotiation> key = new AttributeKey<>("ContentNegotiation");
    private final Set<KClass<?>> ignoredTypes;
    private final List<Config.ConverterRegistration> registrations;

    /* JADX WARN: Multi-variable type inference failed */
    public ContentNegotiation(List<Config.ConverterRegistration> registrations, Set<? extends KClass<?>> ignoredTypes) {
        Intrinsics.checkNotNullParameter(registrations, "registrations");
        Intrinsics.checkNotNullParameter(ignoredTypes, "ignoredTypes");
        this.registrations = registrations;
        this.ignoredTypes = ignoredTypes;
    }

    public final List<Config.ConverterRegistration> getRegistrations$ktor_client_content_negotiation() {
        return this.registrations;
    }

    public final Set<KClass<?>> getIgnoredTypes$ktor_client_content_negotiation() {
        return this.ignoredTypes;
    }

    /* compiled from: ContentNegotiation.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0011\u0010\u0013\u001a\u00020\u000e\"\u0006\b\u0000\u0010\u0014\u0018\u0001H\u0086\bJ\u0012\u0010\u0013\u001a\u00020\u000e2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0005J@\u0010\u0016\u001a\u00020\u000e\"\b\b\u0000\u0010\u0014*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u0002H\u00142\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u000e0\u001b¢\u0006\u0002\b\u001cH\u0016¢\u0006\u0002\u0010\u001dJF\u0010\u0016\u001a\u00020\u000e\"\b\b\u0000\u0010\u0014*\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u0002H\u00142\u0006\u0010\u001f\u001a\u00020\u00102\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u000e0\u001b¢\u0006\u0002\b\u001c¢\u0006\u0002\u0010 J\u0011\u0010!\u001a\u00020\u000e\"\u0006\b\u0000\u0010\u0014\u0018\u0001H\u0086\bJ\u0012\u0010!\u001a\u00020\u000e2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0005R\u001e\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006#"}, d2 = {"Lio/ktor/client/plugins/contentnegotiation/ContentNegotiation$Config;", "Lio/ktor/serialization/Configuration;", "()V", "ignoredTypes", "", "Lkotlin/reflect/KClass;", "getIgnoredTypes$ktor_client_content_negotiation", "()Ljava/util/Set;", "registrations", "", "Lio/ktor/client/plugins/contentnegotiation/ContentNegotiation$Config$ConverterRegistration;", "getRegistrations$ktor_client_content_negotiation", "()Ljava/util/List;", "clearIgnoredTypes", "", "defaultMatcher", "Lio/ktor/http/ContentTypeMatcher;", "pattern", "Lio/ktor/http/ContentType;", "ignoreType", "T", "type", "register", "Lio/ktor/serialization/ContentConverter;", "contentType", "converter", "configuration", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lio/ktor/http/ContentType;Lio/ktor/serialization/ContentConverter;Lkotlin/jvm/functions/Function1;)V", "contentTypeToSend", "contentTypeMatcher", "(Lio/ktor/http/ContentType;Lio/ktor/serialization/ContentConverter;Lio/ktor/http/ContentTypeMatcher;Lkotlin/jvm/functions/Function1;)V", "removeIgnoredType", "ConverterRegistration", "ktor-client-content-negotiation"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Config implements Configuration {
        private final Set<KClass<?>> ignoredTypes = CollectionsKt.toMutableSet(SetsKt.plus((Set) DefaultIgnoredTypesJvmKt.getDefaultIgnoredTypes(), (Iterable) ContentNegotiationKt.getDefaultCommonIgnoredTypes()));
        private final List<ConverterRegistration> registrations = new ArrayList();

        /* compiled from: ContentNegotiation.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/contentnegotiation/ContentNegotiation$Config$ConverterRegistration;", "", "converter", "Lio/ktor/serialization/ContentConverter;", "contentTypeToSend", "Lio/ktor/http/ContentType;", "contentTypeMatcher", "Lio/ktor/http/ContentTypeMatcher;", "(Lio/ktor/serialization/ContentConverter;Lio/ktor/http/ContentType;Lio/ktor/http/ContentTypeMatcher;)V", "getContentTypeMatcher", "()Lio/ktor/http/ContentTypeMatcher;", "getContentTypeToSend", "()Lio/ktor/http/ContentType;", "getConverter", "()Lio/ktor/serialization/ContentConverter;", "ktor-client-content-negotiation"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class ConverterRegistration {
            private final ContentTypeMatcher contentTypeMatcher;
            private final ContentType contentTypeToSend;
            private final ContentConverter converter;

            public ConverterRegistration(ContentConverter converter, ContentType contentTypeToSend, ContentTypeMatcher contentTypeMatcher) {
                Intrinsics.checkNotNullParameter(converter, "converter");
                Intrinsics.checkNotNullParameter(contentTypeToSend, "contentTypeToSend");
                Intrinsics.checkNotNullParameter(contentTypeMatcher, "contentTypeMatcher");
                this.converter = converter;
                this.contentTypeToSend = contentTypeToSend;
                this.contentTypeMatcher = contentTypeMatcher;
            }

            public final ContentConverter getConverter() {
                return this.converter;
            }

            public final ContentType getContentTypeToSend() {
                return this.contentTypeToSend;
            }

            public final ContentTypeMatcher getContentTypeMatcher() {
                return this.contentTypeMatcher;
            }
        }

        public final Set<KClass<?>> getIgnoredTypes$ktor_client_content_negotiation() {
            return this.ignoredTypes;
        }

        public final List<ConverterRegistration> getRegistrations$ktor_client_content_negotiation() {
            return this.registrations;
        }

        @Override // io.ktor.serialization.Configuration
        public <T extends ContentConverter> void register(ContentType contentType, T converter, Function1<? super T, Unit> configuration) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            Intrinsics.checkNotNullParameter(converter, "converter");
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            register(contentType, converter, Intrinsics.areEqual(contentType, ContentType.Application.INSTANCE.getJson()) ? JsonContentTypeMatcher.INSTANCE : defaultMatcher(contentType), configuration);
        }

        public final <T extends ContentConverter> void register(ContentType contentTypeToSend, T converter, ContentTypeMatcher contentTypeMatcher, Function1<? super T, Unit> configuration) {
            Intrinsics.checkNotNullParameter(contentTypeToSend, "contentTypeToSend");
            Intrinsics.checkNotNullParameter(converter, "converter");
            Intrinsics.checkNotNullParameter(contentTypeMatcher, "contentTypeMatcher");
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            configuration.invoke(converter);
            this.registrations.add(new ConverterRegistration(converter, contentTypeToSend, contentTypeMatcher));
        }

        public final /* synthetic */ <T> void ignoreType() {
            Intrinsics.reifiedOperationMarker(4, "T");
            ignoreType(Reflection.getOrCreateKotlinClass(Object.class));
        }

        public final /* synthetic */ <T> void removeIgnoredType() {
            Intrinsics.reifiedOperationMarker(4, "T");
            removeIgnoredType(Reflection.getOrCreateKotlinClass(Object.class));
        }

        public final void removeIgnoredType(KClass<?> type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.ignoredTypes.remove(type);
        }

        public final void ignoreType(KClass<?> type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.ignoredTypes.add(type);
        }

        public final void clearIgnoredTypes() {
            this.ignoredTypes.clear();
        }

        private final ContentTypeMatcher defaultMatcher(final ContentType pattern) {
            return new ContentTypeMatcher() { // from class: io.ktor.client.plugins.contentnegotiation.ContentNegotiation$Config$defaultMatcher$1
                @Override // io.ktor.http.ContentTypeMatcher
                public boolean contains(ContentType contentType) {
                    Intrinsics.checkNotNullParameter(contentType, "contentType");
                    return contentType.match(ContentType.this);
                }
            };
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0246 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0208 -> B:10:0x020e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object convertRequest$ktor_client_content_negotiation(HttpRequestBuilder httpRequestBuilder, Object obj, Continuation<Object> continuation) {
        ContentNegotiation$convertRequest$1 contentNegotiation$convertRequest$1;
        int i;
        Logger logger;
        Object obj2;
        Iterator it;
        List list;
        ContentType contentType;
        ContentNegotiation$convertRequest$1 contentNegotiation$convertRequest$12;
        Logger logger2;
        Logger logger3;
        Logger logger4;
        Logger logger5;
        Logger logger6;
        Logger logger7;
        if (continuation instanceof ContentNegotiation$convertRequest$1) {
            contentNegotiation$convertRequest$1 = (ContentNegotiation$convertRequest$1) continuation;
            if ((contentNegotiation$convertRequest$1.label & Integer.MIN_VALUE) != 0) {
                contentNegotiation$convertRequest$1.label -= Integer.MIN_VALUE;
                Object obj3 = contentNegotiation$convertRequest$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = contentNegotiation$convertRequest$1.label;
                OutgoingContent outgoingContent = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    for (Config.ConverterRegistration converterRegistration : this.registrations) {
                        logger6 = ContentNegotiationKt.LOGGER;
                        logger6.trace("Adding Accept=" + converterRegistration.getContentTypeToSend().getContentType() + " header for " + httpRequestBuilder.getUrl());
                        UtilsKt.accept(httpRequestBuilder, converterRegistration.getContentTypeToSend());
                    }
                    if (!(obj instanceof OutgoingContent)) {
                        Set<KClass<?>> set = this.ignoredTypes;
                        if (!(set instanceof Collection) || !set.isEmpty()) {
                            Iterator<T> it2 = set.iterator();
                            while (it2.hasNext()) {
                                if (((KClass) it2.next()).isInstance(obj)) {
                                }
                            }
                        }
                        ContentType contentType2 = HttpMessagePropertiesKt.contentType(httpRequestBuilder);
                        if (contentType2 == null) {
                            logger5 = ContentNegotiationKt.LOGGER;
                            logger5.trace("Request doesn't have Content-Type header. Skipping ContentNegotiation for " + httpRequestBuilder.getUrl() + '.');
                            return null;
                        }
                        if (obj instanceof Unit) {
                            logger4 = ContentNegotiationKt.LOGGER;
                            logger4.trace("Sending empty body for " + httpRequestBuilder.getUrl());
                            httpRequestBuilder.getHeaders().remove(HttpHeaders.INSTANCE.getContentType());
                            return EmptyContent.INSTANCE;
                        }
                        List<Config.ConverterRegistration> list2 = this.registrations;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj4 : list2) {
                            if (((Config.ConverterRegistration) obj4).getContentTypeMatcher().contains(contentType2)) {
                                arrayList.add(obj4);
                            }
                        }
                        ArrayList arrayList2 = arrayList;
                        if (arrayList2.isEmpty()) {
                            arrayList2 = null;
                        }
                        if (arrayList2 == null) {
                            logger3 = ContentNegotiationKt.LOGGER;
                            logger3.trace("None of the registered converters match request Content-Type=" + contentType2 + ". Skipping ContentNegotiation for " + httpRequestBuilder.getUrl() + '.');
                            return null;
                        }
                        if (httpRequestBuilder.getBodyType() == null) {
                            logger2 = ContentNegotiationKt.LOGGER;
                            logger2.trace("Request has unknown body type. Skipping ContentNegotiation for " + httpRequestBuilder.getUrl() + '.');
                            return null;
                        }
                        httpRequestBuilder.getHeaders().remove(HttpHeaders.INSTANCE.getContentType());
                        obj2 = obj;
                        it = arrayList2.iterator();
                        list = arrayList2;
                        contentType = contentType2;
                        contentNegotiation$convertRequest$12 = contentNegotiation$convertRequest$1;
                        if (it.hasNext()) {
                        }
                        if (outgoingContent != null) {
                        }
                    }
                    logger = ContentNegotiationKt.LOGGER;
                    logger.trace("Body type " + Reflection.getOrCreateKotlinClass(obj.getClass()) + " is in ignored types. Skipping ContentNegotiation for " + httpRequestBuilder.getUrl() + '.');
                    return null;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Config.ConverterRegistration converterRegistration2 = (Config.ConverterRegistration) contentNegotiation$convertRequest$1.L$5;
                it = (Iterator) contentNegotiation$convertRequest$1.L$4;
                list = (List) contentNegotiation$convertRequest$1.L$3;
                ContentType contentType3 = (ContentType) contentNegotiation$convertRequest$1.L$2;
                Object obj5 = contentNegotiation$convertRequest$1.L$1;
                HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) contentNegotiation$convertRequest$1.L$0;
                ResultKt.throwOnFailure(obj3);
                contentNegotiation$convertRequest$12 = contentNegotiation$convertRequest$1;
                OutgoingContent outgoingContent2 = (OutgoingContent) obj3;
                if (outgoingContent2 != null) {
                    logger7 = ContentNegotiationKt.LOGGER;
                    logger7.trace("Converted request body using " + converterRegistration2.getConverter() + " for " + httpRequestBuilder2.getUrl());
                }
                if (outgoingContent2 == null) {
                    outgoingContent = outgoingContent2;
                    obj2 = obj5;
                    contentType = contentType3;
                    if (outgoingContent != null) {
                        return outgoingContent;
                    }
                    throw new ContentConverterException("Can't convert " + obj2 + " with contentType " + contentType + " using converters " + CollectionsKt.joinToString$default(list, null, null, null, 0, null, new Function1<Config.ConverterRegistration, CharSequence>() { // from class: io.ktor.client.plugins.contentnegotiation.ContentNegotiation$convertRequest$serializedContent$2
                        @Override // kotlin.jvm.functions.Function1
                        public final CharSequence invoke(ContentNegotiation.Config.ConverterRegistration it3) {
                            Intrinsics.checkNotNullParameter(it3, "it");
                            return it3.getConverter().toString();
                        }
                    }, 31, null));
                }
                obj2 = obj5;
                httpRequestBuilder = httpRequestBuilder2;
                contentType = contentType3;
                if (it.hasNext()) {
                    Config.ConverterRegistration converterRegistration3 = (Config.ConverterRegistration) it.next();
                    ContentConverter converter = converterRegistration3.getConverter();
                    Charset charset = ContentTypesKt.charset(contentType);
                    if (charset == null) {
                        charset = Charsets.UTF_8;
                    }
                    TypeInfo bodyType = httpRequestBuilder.getBodyType();
                    Intrinsics.checkNotNull(bodyType);
                    Object obj6 = !Intrinsics.areEqual(obj2, NullBody.INSTANCE) ? obj2 : null;
                    contentNegotiation$convertRequest$12.L$0 = httpRequestBuilder;
                    contentNegotiation$convertRequest$12.L$1 = obj2;
                    contentNegotiation$convertRequest$12.L$2 = contentType;
                    contentNegotiation$convertRequest$12.L$3 = list;
                    contentNegotiation$convertRequest$12.L$4 = it;
                    contentNegotiation$convertRequest$12.L$5 = converterRegistration3;
                    contentNegotiation$convertRequest$12.label = 1;
                    Object serializeNullable = converter.serializeNullable(contentType, charset, bodyType, obj6, contentNegotiation$convertRequest$12);
                    if (serializeNullable == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ContentType contentType4 = contentType;
                    obj5 = obj2;
                    obj3 = serializeNullable;
                    contentType3 = contentType4;
                    httpRequestBuilder2 = httpRequestBuilder;
                    converterRegistration2 = converterRegistration3;
                    OutgoingContent outgoingContent22 = (OutgoingContent) obj3;
                    if (outgoingContent22 != null) {
                    }
                    if (outgoingContent22 == null) {
                    }
                }
                if (outgoingContent != null) {
                }
            }
        }
        contentNegotiation$convertRequest$1 = new ContentNegotiation$convertRequest$1(this, continuation);
        Object obj32 = contentNegotiation$convertRequest$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = contentNegotiation$convertRequest$1.label;
        OutgoingContent outgoingContent3 = null;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object convertResponse$ktor_client_content_negotiation(Url url, TypeInfo typeInfo, Object obj, ContentType contentType, Charset charset, Continuation<Object> continuation) {
        ContentNegotiation$convertResponse$1 contentNegotiation$convertResponse$1;
        Object obj2;
        int i;
        Logger logger;
        Logger logger2;
        Logger logger3;
        Logger logger4;
        if (continuation instanceof ContentNegotiation$convertResponse$1) {
            contentNegotiation$convertResponse$1 = (ContentNegotiation$convertResponse$1) continuation;
            if ((contentNegotiation$convertResponse$1.label & Integer.MIN_VALUE) != 0) {
                contentNegotiation$convertResponse$1.label -= Integer.MIN_VALUE;
                obj2 = contentNegotiation$convertResponse$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = contentNegotiation$convertResponse$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    if (!(obj instanceof ByteReadChannel)) {
                        logger3 = ContentNegotiationKt.LOGGER;
                        logger3.trace("Response body is already transformed. Skipping ContentNegotiation for " + url + '.');
                        return null;
                    }
                    if (this.ignoredTypes.contains(typeInfo.getType())) {
                        logger2 = ContentNegotiationKt.LOGGER;
                        logger2.trace("Response body type " + typeInfo.getType() + " is in ignored types. Skipping ContentNegotiation for " + url + '.');
                        return null;
                    }
                    List<Config.ConverterRegistration> list = this.registrations;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj3 : list) {
                        if (((Config.ConverterRegistration) obj3).getContentTypeMatcher().contains(contentType)) {
                            arrayList.add(obj3);
                        }
                    }
                    ArrayList arrayList2 = arrayList;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList3.add(((Config.ConverterRegistration) it.next()).getConverter());
                    }
                    ArrayList arrayList4 = arrayList3;
                    if (arrayList4.isEmpty()) {
                        arrayList4 = null;
                    }
                    if (arrayList4 == null) {
                        logger = ContentNegotiationKt.LOGGER;
                        logger.trace("None of the registered converters match response with Content-Type=" + contentType + ". Skipping ContentNegotiation for " + url + '.');
                        return null;
                    }
                    contentNegotiation$convertResponse$1.L$0 = url;
                    contentNegotiation$convertResponse$1.label = 1;
                    obj2 = ContentConverterKt.deserialize(arrayList4, (ByteReadChannel) obj, typeInfo, charset, contentNegotiation$convertResponse$1);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    url = (Url) contentNegotiation$convertResponse$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                }
                if (!(obj2 instanceof ByteReadChannel)) {
                    logger4 = ContentNegotiationKt.LOGGER;
                    logger4.trace("Response body was converted to " + Reflection.getOrCreateKotlinClass(obj2.getClass()) + " for " + url + '.');
                }
                return obj2;
            }
        }
        contentNegotiation$convertResponse$1 = new ContentNegotiation$convertResponse$1(this, continuation);
        obj2 = contentNegotiation$convertResponse$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = contentNegotiation$convertResponse$1.label;
        if (i != 0) {
        }
        if (!(obj2 instanceof ByteReadChannel)) {
        }
        return obj2;
    }

    public static /* synthetic */ Object convertResponse$ktor_client_content_negotiation$default(ContentNegotiation contentNegotiation, Url url, TypeInfo typeInfo, Object obj, ContentType contentType, Charset charset, Continuation continuation, int i, Object obj2) {
        if ((i & 16) != 0) {
            charset = Charsets.UTF_8;
        }
        return contentNegotiation.convertResponse$ktor_client_content_negotiation(url, typeInfo, obj, contentType, charset, continuation);
    }

    /* compiled from: ContentNegotiation.kt */
    @KtorDsl
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J!\u0010\u000e\u001a\u00020\u00032\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0002\b\u0011H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/contentnegotiation/ContentNegotiation$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/contentnegotiation/ContentNegotiation$Config;", "Lio/ktor/client/plugins/contentnegotiation/ContentNegotiation;", "()V", C3040d4.h.W, "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "install", "", N6.L, "scope", "Lio/ktor/client/HttpClient;", "prepare", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-client-content-negotiation"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: io.ktor.client.plugins.contentnegotiation.ContentNegotiation$Plugin, reason: from kotlin metadata */
    public static final class Companion implements HttpClientPlugin<Config, ContentNegotiation> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<ContentNegotiation> getKey() {
            return ContentNegotiation.key;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public ContentNegotiation prepare(Function1<? super Config, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new ContentNegotiation(config.getRegistrations$ktor_client_content_negotiation(), config.getIgnoredTypes$ktor_client_content_negotiation());
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(ContentNegotiation plugin, HttpClient scope) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.getRequestPipeline().intercept(HttpRequestPipeline.INSTANCE.getTransform(), new ContentNegotiation$Plugin$install$1(plugin, null));
            scope.getResponsePipeline().intercept(HttpResponsePipeline.INSTANCE.getTransform(), new ContentNegotiation$Plugin$install$2(plugin, null));
        }
    }
}
