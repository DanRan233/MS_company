package com.wzk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzk.dao.StaffDao;
import com.wzk.entity.Department;
import com.wzk.entity.Position;
import com.wzk.entity.Result;
import com.wzk.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: 管理信息service层，处理dao、controller层数据 。
 * TODO：
 * @date 2020/11/29 10:50
 */
@Service
public class StaffServiceImpl implements StaffServiceIF {
    @Autowired
    private StaffDao staffDao;

    /**
     * description: 添加或更新员工信息。
     * TODO:
     * @date         2020/12/4 18:26
     * @author      DanRan233
     * @Param       [staff]
     * @return      com.wzk.entity.Result
     */
    @Override
    public Result addStaff(Staff staff) {
        Result result = new Result(2001, "未执行");
        if(staff.getsId()==0){
            if(staffDao.getStaffNum(staff)==0&&staffDao.addStaff(staff)>0){
                result.setCode(2000);
                result.setMessage("执行成功");
            }else {
                result.setMessage("名称或编号已存在");
            }
        }else {
            if(staffDao.getStaffNum(staff)==0&&staffDao.updateStaff(staff)>0){
                result.setCode(2000);
                result.setMessage("执行成功");
            }else {
                result.setMessage("名称或编号已存在");
            }
        }

        return result;
    }

    /**
     * description: 获取员工信息并分页。
     * TODO:
     * @date         2020/12/4 18:28
     * @author      DanRan233
     * @Param       [staff, pageNum, pageSize]
     * @return      com.wzk.entity.Result
     */
    @Override
    public Result getStaff(Staff staff,Integer pageNum,Integer pageSize) {
        Result result = new Result(2001, "未执行");
        PageHelper.startPage(pageNum,pageSize);
        List<Staff> list=staffDao.getStaff(staff);
        System.out.println(list);
        PageInfo page=new PageInfo(list);
        result.setCode(2000);
        result.setMessage("执行成功");
        result.setData(page);
        return result;
    }

    /**
     * description: 删除员工信息。
     * TODO:
     * @date         2020/12/4 18:28
     * @author      DanRan233
     * @Param       [sId]
     * @return      com.wzk.entity.Result
     */
    @Override
    public Result delStaff(Integer sId) {
        Result result = new Result(2001, "未执行");
        int i = staffDao.delStaff(sId);
        if(i>0){
            result.setCode(2000);
            result.setMessage("执行成功");
        }
        return result;
    }

    /**
     * description: 获取所有部门信息。
     * TODO:
     * @date         2020/12/4 18:28
     * @author      DanRan233
     * @Param       [department]
     * @return      com.wzk.entity.Result
     */
    @Override
    public Result getDep(Department department) {
        Result result = new Result(2001, "未执行");
        System.out.println(department);
        List<Department> list=staffDao.getDep(department);
        result.setCode(2000);
        result.setMessage("执行成功");
        result.setData(list);
        return result;
    }

    /**
     * description: 添加或更新部门。
     * TODO:
     * @date         2020/12/4 18:29
     * @author      DanRan233
     * @Param       [deprecated]
     * @return      com.wzk.entity.Result
     */
    @Override
    public Result addDep(Department deprecated) {
        Result result = new Result(2001, "未执行");
        if(deprecated.getDepId()==0){
            if(staffDao.getDepNum(deprecated)==0&&staffDao.addDep(deprecated)>0){
                result.setCode(2000);
                result.setMessage("执行成功");
            }else {
                result.setMessage("名称或编号已存在");
            }
        }else {
            if(staffDao.getDepNum(deprecated)==0&&staffDao.updateDep(deprecated)>0){
                result.setCode(2000);
                result.setMessage("执行成功");
            }else {
                result.setMessage("名称或编号已存在");
            }
        }

        return result;
    }

    /**
     * description: 获取部门信息并分页
     * TODO:
     * @date         2020/12/4 18:29
     * @author      DanRan233
     * @Param       [deprecated, pageNum, pageSize]
     * @return      com.wzk.entity.Result
     */
    @Override
    public Result getDep(Department deprecated, Integer pageNum, Integer pageSize) {
        Result result = new Result(2001, "未执行");
        PageHelper.startPage(pageNum,pageSize);
        System.out.println("12334++++"+deprecated);
        List<Department> list=staffDao.getDep(deprecated);
        System.out.println(list);
        PageInfo page=new PageInfo(list);
        result.setCode(2000);
        result.setMessage("执行成功");
        result.setData(page);
        return result;
    }

    /**
     * description: 删除部门。
     * TODO:
     * @date         2020/12/4 18:30
     * @author      DanRan233
     * @Param       [depId]
     * @return      com.wzk.entity.Result
     */
    @Override
    public Result delDep(String depId) {
        Result result = new Result(2001, "未执行");
        int i = staffDao.delDep(depId);
        if(i>0){
            result.setCode(2000);
            result.setMessage("执行成功");
        }
        return result;
    }

    /**
     * description: 获取所有职位信息。
     * TODO:
     * @date         2020/12/4 18:30
     * @author      DanRan233
     * @Param       [position]
     * @return      com.wzk.entity.Result
     */
    @Override
    public Result getPos(Position position) {
        Result result = new Result(2001, "未执行");
        List<Position> list=staffDao.getPos(position);
        result.setCode(2000);
        result.setMessage("执行成功");
        result.setData(list);
        return result;
    }

    /**
     * description: 添加职位信息。
     * TODO:
     * @date         2020/12/4 18:30
     * @author      DanRan233
     * @Param       [position]
     * @return      com.wzk.entity.Result
     */
    @Override
    public Result addPos(Position position) {
        Result result = new Result(2001, "未执行");
        if(position.getPosId()==0){
            if(staffDao.getPosNum(position)==0&&staffDao.addPos(position)>0){
                result.setCode(2000);
                result.setMessage("执行成功");
            }else {
                result.setMessage("名称或编号已存在");
            }
        }else {
            if(staffDao.getPosNum(position)==0&&staffDao.updatePos(position)>0){
                result.setCode(2000);
                result.setMessage("执行成功");
            }else {
                result.setMessage("名称或编号已存在");
            }
        }

        return result;
    }

    /**
     * description: 获取职位信息并分页。
     * TODO:
     * @date         2020/12/4 18:31
     * @author      DanRan233
     * @Param       [position, pageNum, pageSize]
     * @return      com.wzk.entity.Result
     */
    @Override
    public Result getPos(Position position, Integer pageNum, Integer pageSize) {
        Result result = new Result(2001, "未执行");
        PageHelper.startPage(pageNum,pageSize);
        List<Position> list=staffDao.getPos(position);
        System.out.println(list);
        PageInfo page=new PageInfo(list);
        result.setCode(2000);
        result.setMessage("执行成功");
        result.setData(page);
        return result;
    }

    /**
     * description: 删除职位信息。
     * TODO:
     * @date         2020/12/4 18:31
     * @author      DanRan233
     * @Param       [posId]
     * @return      com.wzk.entity.Result
     */
    @Override
    public Result delPos(String posId) {
        Result result = new Result(2001, "未执行");
        int i = staffDao.delPos(posId);
        if(i>0){
            result.setCode(2000);
            result.setMessage("执行成功");
        }
        return result;
    }
}
