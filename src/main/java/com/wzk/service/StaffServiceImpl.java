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
 * @description: TODO
 * @date 2020/11/29 10:50
 */
@Service
public class StaffServiceImpl implements StaffServiceIF {
    @Autowired
    private StaffDao staffDao;

    @Override
    public Result addStaff(Staff staff) {
        Result result = new Result(2001, "未执行");
        if(staff.getsId()==0){
            if(staffDao.addStaff(staff)>0){
                result.setCode(2000);
                result.setMessage("执行成功");
            }
        }else {
            if(staffDao.updateStaff(staff)>0){
                result.setCode(2000);
                result.setMessage("执行成功");
            }
        }

        return result;
    }

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

    @Override
    public Result addDep(Department deprecated) {
        Result result = new Result(2001, "未执行");
        List<Department> list=staffDao.getDep(deprecated);
        if(deprecated.getDepId()==0){
            if(staffDao.addDep(deprecated)>0){
                result.setCode(2000);
                result.setMessage("执行成功");
            }
        }else {
            if(staffDao.updateDep(deprecated)>0){
                result.setCode(2000);
                result.setMessage("执行成功");
            }
        }

        return result;
    }

    @Override
    public Result getDep(Department deprecated, Integer pageNum, Integer pageSize) {
        Result result = new Result(2001, "未执行");
        PageHelper.startPage(pageNum,pageSize);
        List<Department> list=staffDao.getDep(deprecated);
        System.out.println(list);
        PageInfo page=new PageInfo(list);
        result.setCode(2000);
        result.setMessage("执行成功");
        result.setData(page);
        return result;
    }

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

    @Override
    public Result getPos(Position position) {
        Result result = new Result(2001, "未执行");
        List<Position> list=staffDao.getPos(position);
        result.setCode(2000);
        result.setMessage("执行成功");
        result.setData(list);
        return result;
    }

    @Override
    public Result addPos(Position position) {
        Result result = new Result(2001, "未执行");
        if(position.getPosId()==0){
            if(staffDao.addPos(position)>0){
                result.setCode(2000);
                result.setMessage("执行成功");
            }
        }else {
            if(staffDao.updatePos(position)>0){
                result.setCode(2000);
                result.setMessage("执行成功");
            }
        }

        return result;
    }

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
