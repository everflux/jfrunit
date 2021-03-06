/**
 *  Copyright 2020 The JfrUnit authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package dev.morling.jfrunit;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * Enables a specific JFR event type, e.g. "jdk.GarbageCollection" for a recording.
 *
 * @author Gunnar Morling
 */
@Repeatable(value = EnableEvent.List.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableEvent {

    /**
     * An alias for name().
     */
    String value() default "";

//    String name() default "";

    StacktracePolicy stackTrace() default StacktracePolicy.DEFAULT;

    int threshold() default -1;

    public enum StacktracePolicy {
        DEFAULT, INCLUDED, EXCLUDED;
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface List {
        EnableEvent[] value();
    }
}
