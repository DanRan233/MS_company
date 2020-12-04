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
 * @description: TODO
 * @date 2020/11/29 11:18
 */
@RequestMapping("/staff")
@RestController
@CrossOrigin
public class StaffController {

    @Autowired
    StaffServiceIF staffServiceIF;


    @RequestMapping("/addStaff")
    public Result addStaff(Staff staff){
        System.out.println(staff);
        return staffServiceIF.addStaff(staff);
    }

    @RequestMapping("/getStaff")
    public Result getStaff(@RequestParam String sName, @RequestParam(defaultValue = "0") Integer sId,@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        System.out.println(sId);
        Staff staff=new Staff();
        staff.setsId(sId);
        staff.setsName(sName);
        System.out.println(staff);
        System.out.println(""+pageNum+pageSize);
        return staffServiceIF.getStaff(staff,pageNum,pageSize);
    }

    @RequestMapping("/delStaff")
    public Result delStaff(@RequestParam Integer sId){
        return staffServiceIF.delStaff(sId);
    }

    @RequestMapping("/addDep")
    public Result addDep(Department department){
        System.out.println(department);
        return staffServiceIF.addDep(department);
    }

    @RequestMapping("/addPos")
    public Result addPos(Position position){
        System.out.println(position);
        return staffServiceIF.addPos(position);
    }

    @RequestMapping("/getDep")
    public Result getDep(@RequestParam(defaultValue = "0") Integer depId,@RequestParam(defaultValue = "-1") String depName){
        Department department=new Department(depId,depName);
        return staffServiceIF.getDep(department);
    }

    @RequestMapping("/delDep")
    public Result delDep(@RequestParam String depId){
        return staffServiceIF.delDep(depId);
    }

    @RequestMapping("/getPos")
    public Result getPos(@RequestParam(defaultValue = "0") Integer posId,@RequestParam(defaultValue = "-1") String posName){
        Position position=new Position(posId,posName);
        return staffServiceIF.getPos(position);
    }

    @RequestMapping("/getDepPage")
    public Result getDep(@RequestParam(defaultValue = "0") Integer depId,@RequestParam(defaultValue = "-1") String depName,@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        Department department=new Department(depId,depName);
        return staffServiceIF.getDep(department,pageNum,pageSize);
    }

    @RequestMapping("/getPosPage")
    public Result getPos(@RequestParam(defaultValue = "0") Integer posId,@RequestParam(defaultValue = "-1") String posName,@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        Position position=new Position(posId,posName);
        return staffServiceIF.getPos(position,pageNum,pageSize);
    }

    @RequestMapping("/delPos")
    public Result delPos(@RequestParam String posId){
        return staffServiceIF.delPos(posId);
    }

}
