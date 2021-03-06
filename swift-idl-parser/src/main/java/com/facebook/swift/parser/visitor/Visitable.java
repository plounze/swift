/*
 * Copyright (C) 2012 Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.facebook.swift.parser.visitor;

import java.io.IOException;
import java.util.Collection;

public interface Visitable
{
    void visit(DocumentVisitor visitor) throws IOException;

    public static final class Utils
    {
        private Utils()
        {
        }

        public static void visitAll(final DocumentVisitor visitor, final Collection<? extends Visitable> visitables) throws IOException
        {
            if (visitables != null && !visitables.isEmpty()) {
                for (Visitable visitable : visitables) {
                    if (visitor.accept(visitable)) {
                        visitable.visit(visitor);
                    }
                }
            }
        }

        public static void visit(final DocumentVisitor visitor, final Visitable visitable) throws IOException
        {
            visitor.visit(visitable);
        }
    }
}
