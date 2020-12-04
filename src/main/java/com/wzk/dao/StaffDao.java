package com.wzk.dao;

import com.wzk.entity.Department;
import com.wzk.entity.Position;
import com.wzk.entity.Staff;

import java.util.List;
import java.util.Map;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: TODO
 * @date 2020/11/29 10:31
 */
public interface StaffDao {
    int addStaff(Staff staff);

    int updateStaff(Staff staff);

    List<Staff> getStaff(Staff staff);

    int delStaff(Integer sId);

    List<Department> getDep(Department department);

    int addDep(Department department);

    int delDep(String depId);

    int updateDep(Department department);

    int getDepNum(String depId);

    List<Position> getPos(Position position);

    int addPos(Position position);

    int delPos(String posId);

    int updatePos(Position position);

    int getPosNum(String posId);
}
