// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.nereids.trees.expressions.visitor;

import org.apache.doris.nereids.trees.expressions.Expression;

import java.util.Map;

/**
 * replace expr nodes by substitutionMap
 */
public class ExpressionReplacer
        extends DefaultExpressionRewriter<Map<? extends Expression, ? extends Expression>> {
    public static final ExpressionReplacer INSTANCE = new ExpressionReplacer();

    @Override
    public Expression visit(Expression expr, Map<? extends Expression, ? extends Expression> substitutionMap) {
        if (substitutionMap.containsKey(expr)) {
            return substitutionMap.get(expr);
        }
        return super.visit(expr, substitutionMap);
    }
}
