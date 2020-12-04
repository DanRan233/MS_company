package com.wzk.dao;

import com.wzk.entity.Department;
import com.wzk.entity.Position;
import com.wzk.entity.Staff;

import java.util.List;
import java.util.Map;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: 获取管理信息dao层接口，与对应的映射文件绑定
 * @date 2020/11/29 10:31
 */
public interface StaffDao {

    int addStaff(Staff staff);

    int updateStaff(Staff staff);

    List<Staff> getStaff(Staff staff);

    int getStaffNum(Staff staff);

    int delStaff(Integer sId);

    List<Department> getDep(Department department);

    int addDep(Department department);

    int delDep(String depId);

    int updateDep(Department department);

    int getDepNum(Department department);

    List<Position> getPos(Position position);

    int addPos(Position position);

    int delPos(String posId);

    int updatePos(Position position);

    int getPosNum(Position position);
}
