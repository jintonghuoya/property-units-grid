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
import com.fortune.entity.Unit;
import lombok.extern.slf4j.Slf4j;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

import java.util.List;

@Slf4j
public class PropertyUnitsGrid extends Panel {
    private static final long serialVersionUID = 1L;


//    protected final WebMarkupContainer propertyUnitsGrid;

    public PropertyUnitsGrid(String id) {
        super(id);
        List<Floor> floors = DataFixture.generateDemoData().getFloors();
        add(new ListView<Floor>("floors",floors) {
            @Override
            protected void populateItem(final ListItem<Floor> item) {
                setDefaultModel(new CompoundPropertyModel(item.getModel()));

                item.add(new Label("name"));
                item.add(new Label("area"));
                List<Unit> units = item.getModelObject().getUnits();
                double totalArea = 0;
                for (Unit unit : units){
                    totalArea += unit.getArea();
                }

                if (totalArea>=0) {
                    for (Unit unit : units) {
                        unit.setWidthPercent(unit.getArea() / totalArea);
                    }
                }

                add(new ListView<Unit>("units",units) {
                    @Override
                    protected void populateItem(final ListItem<Unit> listItem) {
                        setDefaultModel(new CompoundPropertyModel(listItem.getModel()));
                        listItem.add(new Label("dynamic_width"){
                            @Override
                            protected void onComponentTag(ComponentTag tag) {
                                super.onComponentTag(tag);
                                //Turn the h1 tag to a span
                                //tag.setName("span");
                                //Add formatting style
                                tag.put("style", listItem.getModelObject().getWidthPercent()+"%");
                            }
                        });
                        listItem.add(new Label("name"));
                        listItem.add(new Label("area"));
                    }
                });
            }
        });
//        propertyUnitsGrid = new WebMarkupContainer("PropertyUnitsGrid");
//        propertyUnitsGrid.setOutputMarkupId(true);
    }
}
