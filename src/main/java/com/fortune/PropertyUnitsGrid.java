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

import com.fortune.entity.Floor;
import com.fortune.entity.Property;
import com.fortune.entity.Unit;
import lombok.extern.slf4j.Slf4j;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

import java.util.List;

@Slf4j
public class PropertyUnitsGrid extends Panel {
    private static final long serialVersionUID = 1L;

    public PropertyUnitsGrid(String id) {
        super(id);
        Property property = DataFixture.generateDemoData();
        add(new ListView<Floor>("floors", property.getFloors()) {
            @Override
            protected void populateItem(final ListItem<Floor> item) {
                item.add(new Label("floor_name", new PropertyModel(item.getModel(), "name")));
                item.add(new Label("floor_area", new PropertyModel(item.getModel(), "area")));
                List<Unit> units = item.getModelObject().getUnits();
                double currentFloorArea = 0;
                for (Unit unit : units) {
                    currentFloorArea += unit.getArea();
                }
                for (Unit unit : units) {
                    unit.setWidthPercent(unit.getArea() * 100 / currentFloorArea);
                }
                item.add(new ListView<Unit>("units", units) {
                    @Override
                    protected void populateItem(final ListItem<Unit> unit) {
                        unit.setRenderBodyOnly(true);
                        WebMarkupContainer unit_base = new WebMarkupContainer("unit_base");
                        unit_base.add(new AttributeModifier("style", "width:" + unit.getModelObject().getWidthPercent() + "%;"));
                        unit.add(unit_base);
                        unit_base.add(new Label("unit_name", new PropertyModel(unit.getModel(), "name")));
                        unit_base.add(new Label("unit_area", new PropertyModel(unit.getModel(), "area")));
                    }
                });
            }
        });
    }
}
