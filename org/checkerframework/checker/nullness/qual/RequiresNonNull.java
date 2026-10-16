package org.checkerframework.checker.nullness.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.PreconditionAnnotation;

/* JADX WARN: Classes with same name are omitted:
  assets/audience_network/classes.dex
 */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@PreconditionAnnotation(qualifier = NonNull.class)
@Documented
@Repeatable(List.class)
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes8.dex */
public @interface RequiresNonNull {

    /* JADX WARN: Classes with same name are omitted:
      assets/audience_network/classes.dex
     */
    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
    @PreconditionAnnotation(qualifier = NonNull.class)
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface List {
        RequiresNonNull[] value();
    }

    String[] value();
}
