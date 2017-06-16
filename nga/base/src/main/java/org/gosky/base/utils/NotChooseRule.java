/*
 * Copyright (C) 2014 Mobs & Geeks
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gosky.base.utils;

import com.mobsandgeeks.saripaar.AnnotationRule;

public class NotChooseRule extends AnnotationRule<NotChoose, String> {

    protected NotChooseRule(NotChoose phone) {
        super(phone);
    }

    @Override
    public boolean isValid(String data) {
        return !"请选择".equals(data) && !"".equals(data);
    }
}