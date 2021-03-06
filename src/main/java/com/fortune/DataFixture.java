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

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DataFixture {

    public static Property generateDemoData() {
        Property property = new Property();
        List<Floor> floors = new ArrayList<>();

        property.setName("宝地广场");
        property.setManageArea(10000);
        property.setTotalArea(10000);
        property.setFloorCount(5);
        for (int i = 0; i < property.getFloorCount(); i++) {
            Floor floor = new Floor();
            floor.setName(i + "楼");
            floor.setArea(1000 * Math.random());
            List<Unit> units = new ArrayList<>();
            for (int j = 0; j < 10 * Math.random(); j++) {
                Unit unit = new Unit();
                unit.setName(i + "楼" + j + "单元");
                unit.setArea(100 * Math.random());
                units.add(unit);
            }
            floor.setUnits(units);
            floors.add(floor);
        }
        property.setFloors(floors);
        return property;
    }

    public static void main(String[] args) {
        System.out.println(generateDemoData());
    }

}
