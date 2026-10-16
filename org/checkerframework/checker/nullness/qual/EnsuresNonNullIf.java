package org.checkerframework.checker.nullness.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.ConditionalPostconditionAnnotation;
import org.checkerframework.framework.qual.InheritedAnnotation;

/* JADX WARN: Classes with same name are omitted:
  assets/audience_network/classes.dex
 */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@InheritedAnnotation
@ConditionalPostconditionAnnotation(qualifier = NonNull.class)
@Documented
@Repeatable(List.class)
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes8.dex */
public @interface EnsuresNonNullIf {

    /* JADX WARN: Classes with same name are omitted:
      assets/audience_network/classes.dex
     */
    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
    @InheritedAnnotation
    @ConditionalPostconditionAnnotation(qualifier = NonNull.class)
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface List {
        EnsuresNonNullIf[] value();
    }

    String[] expression();

    boolean result();
}
