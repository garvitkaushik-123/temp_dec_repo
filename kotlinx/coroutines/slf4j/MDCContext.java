package kotlinx.coroutines.slf4j;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.ThreadContextElement;
import org.slf4j.MDC;

/* compiled from: MDCContext.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0002`\u00020\u00012\u00020\u0005:\u0001\u0015B#\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0002`\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0002`\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fJ/\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0002`\u0002H\u0016¢\u0006\u0002\u0010\u0013J'\u0010\u0014\u001a\u00020\u00112\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0002`\u0002H\u0002¢\u0006\u0002\u0010\bR%\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0002`\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/slf4j/MDCContext;", "Lkotlinx/coroutines/ThreadContextElement;", "Lkotlinx/coroutines/slf4j/MDCContextMap;", "", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "contextMap", "<init>", "(Ljava/util/Map;)V", "getContextMap", "()Ljava/util/Map;", "Ljava/util/Map;", "updateThreadContext", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)Ljava/util/Map;", "restoreThreadContext", "", "oldState", "(Lkotlin/coroutines/CoroutineContext;Ljava/util/Map;)V", "setCurrent", "Key", "kotlinx-coroutines-slf4j"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MDCContext extends AbstractCoroutineContextElement implements ThreadContextElement<Map<String, ? extends String>> {

    /* renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<String, String> contextMap;

    /* JADX WARN: Multi-variable type inference failed */
    public MDCContext() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public /* bridge */ /* synthetic */ void restoreThreadContext(CoroutineContext coroutineContext, Map<String, ? extends String> map) {
        restoreThreadContext2(coroutineContext, (Map<String, String>) map);
    }

    public final Map<String, String> getContextMap() {
        return this.contextMap;
    }

    public /* synthetic */ MDCContext(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MDC.getCopyOfContextMap() : map);
    }

    public MDCContext(Map<String, String> map) {
        super(INSTANCE);
        this.contextMap = map;
    }

    /* compiled from: MDCContext.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/slf4j/MDCContext$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/slf4j/MDCContext;", "<init>", "()V", "kotlinx-coroutines-slf4j"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.slf4j.MDCContext$Key, reason: from kotlin metadata */
    public static final class Companion implements CoroutineContext.Key<MDCContext> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public Map<String, ? extends String> updateThreadContext(CoroutineContext context) {
        Map<String, String> copyOfContextMap = MDC.getCopyOfContextMap();
        setCurrent(this.contextMap);
        return copyOfContextMap;
    }

    /* renamed from: restoreThreadContext, reason: avoid collision after fix types in other method */
    public void restoreThreadContext2(CoroutineContext context, Map<String, String> oldState) {
        setCurrent(oldState);
    }

    private final void setCurrent(Map<String, String> contextMap) {
        if (contextMap == null) {
            MDC.clear();
        } else {
            MDC.setContextMap(contextMap);
        }
    }
}
