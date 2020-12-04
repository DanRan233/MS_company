package com.wzk.service;

import com.wzk.entity.Department;
import com.wzk.entity.Position;
import com.wzk.entity.Result;
import com.wzk.entity.Staff;

import java.util.List;
import java.util.Map;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: TODO
 * @date 2020/11/29 10:50
 */
public interface StaffServiceIF {
    Result addStaff(Staff staff);

    Result getStaff(Staff staff,Integer pageNum,Integer pageSize);

    Result delStaff(Integer sId);

    Result getDep(Department deprecated);

    Result addDep(Department deprecated);

    Result getDep(Department deprecated,Integer pageNum,Integer pageSize);

    Result delDep(String depId);

    Result getPos(Position position);

    Result addPos(Position position);

    Result getPos(Position position,Integer pageNum,Integer pageSize);

    Result delPos(String posId);

}
