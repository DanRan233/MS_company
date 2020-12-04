package com.wzk.controller;

import com.wzk.entity.Department;
import com.wzk.entity.Position;
import com.wzk.entity.Result;
import com.wzk.entity.Staff;
import com.wzk.service.StaffServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: 处理部门、级别、员工的controller
 * @date 2020/11/29 11:18
 */
@RequestMapping("/staff")
@RestController
@CrossOrigin
public class InfoController {

    @Autowired //默认按类型装配bean
    private StaffServiceIF staffServiceIF;


    /**
     * description: 添加与更新员工信息接口。
     * TODO:
     * @date         2020/12/4 17:29
     * @author      DanRan233
     * @Param       [staff]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/addStaff")
    public Result addStaff(Staff staff){
        return staffServiceIF.addStaff(staff);
    }

    /**
     * description: 获取员工信息并分页显示接口。
     * TODO:
     * @date         2020/12/4 17:30
     * @author      DanRan233
     * @Param       [sName, sId, pageNum, pageSize]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getStaff")
    public Result getStaff(@RequestParam String sName, @RequestParam(defaultValue = "0") Integer sId,@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        Staff staff=new Staff();
        staff.setsId(sId);
        staff.setsName(sName);
        return staffServiceIF.getStaff(staff,pageNum,pageSize);
    }

    /**
     * description: 删除员工信息接口。
     * TODO:
     * @date         2020/12/4 17:31
     * @author      DanRan233
     * @Param       [sId]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/delStaff")
    public Result delStaff(@RequestParam Integer sId){
        return staffServiceIF.delStaff(sId);
    }

    /**
     * description: 添加部门信息。
     * TODO:
     * @date         2020/12/4 17:31
     * @author      DanRan233
     * @Param       [department]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/addDep")
    public Result addDep(Department department){
        System.out.println(department);
        return staffServiceIF.addDep(department);
    }

    /**
     * description: 添加职位信息。
     * TODO:
     * @date         2020/12/4 17:32
     * @author      DanRan233
     * @Param       [position]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/addPos")
    public Result addPos(Position position){
        System.out.println(position);
        return staffServiceIF.addPos(position);
    }

    /**
     * description: 获取部门信息。
     * TODO:
     * @date         2020/12/4 17:32
     * @author      DanRan233
     * @Param       [depId, depName]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getDep")
    public Result getDep(@RequestParam(defaultValue = "0") Integer depId,@RequestParam(defaultValue = "-1") String depName){
        Department department=new Department(depId,depName);
        return staffServiceIF.getDep(department);
    }

    /**
     * description: 删除部门信息。
     * TODO:
     * @date         2020/12/4 17:32
     * @author      DanRan233
     * @Param       [depId]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/delDep")
    public Result delDep(@RequestParam String depId){
        return staffServiceIF.delDep(depId);
    }

    /**
     * description: 获取部门信息并分页。
     * TODO:
     * @date         2020/12/4 17:33
     * @author      DanRan233
     * @Param       [depId, depName, pageNum, pageSize]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getDepPage")
    public Result getDep(@RequestParam(defaultValue = "0") Integer depId,@RequestParam(defaultValue = "-1") String depName,@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        Department department=new Department(depId,depName);
        System.out.println("************"+department);
        return staffServiceIF.getDep(department,pageNum,pageSize);
    }

    /**
     * description: 获取职位信息。
     * TODO:
     * @date         2020/12/4 17:33
     * @author      DanRan233
     * @Param       [posId, posName]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getPos")
    public Result getPos(@RequestParam(defaultValue = "0") Integer posId,@RequestParam(defaultValue = "-1") String posName){
        Position position=new Position(posId,posName);
        return staffServiceIF.getPos(position);
    }

    /**
     * description: 获取职位信息并分页。
     * TODO:
     * @date         2020/12/4 17:34
     * @author      DanRan233
     * @Param       [posId, posName, pageNum, pageSize]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getPosPage")
    public Result getPos(@RequestParam(defaultValue = "0") Integer posId,@RequestParam(defaultValue = "-1") String posName,@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        Position position=new Position(posId,posName);
        return staffServiceIF.getPos(position,pageNum,pageSize);
    }

    /**
     * description: 删除职位信息。
     * TODO:
     * @date         2020/12/4 17:35
     * @author      DanRan233
     * @Param       [posId]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/delPos")
    public Result delPos(@RequestParam String posId){
        return staffServiceIF.delPos(posId);
    }

}
