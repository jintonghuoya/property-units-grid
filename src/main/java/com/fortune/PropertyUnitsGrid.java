/*
 *
 * ==============================================================================
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.fortune;

import lombok.extern.slf4j.Slf4j;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

@Slf4j
public class PropertyUnitsGrid extends Panel {
    private static final long serialVersionUID = 1L;


//    protected final WebMarkupContainer propertyUnitsGrid;

    public PropertyUnitsGrid(String id) {
        super(id);
//        propertyUnitsGrid = new WebMarkupContainer("PropertyUnitsGrid");
//        propertyUnitsGrid.setOutputMarkupId(true);
    }
}
