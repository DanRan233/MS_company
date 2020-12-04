var dep = {};
var pos = {};
$(function () {
    $.ajax({
        url: "/staff/getDep",
        type: "post",
        dataType: "json",
        success: function (msg) {
            $.each(msg.data, function (key, ob) {
                dep[ob.depId] = ob.depName;
            });
        }
    });

    $.ajax({
        url: "/staff/getPos",
        type: "post",
        dataType: "json",
        success: function (msg) {
            $.each(msg.data, function (key, ob) {
                pos[ob.posId] = ob.posName;

            });
        }
    });
    queryPage_staff(1);
});

//staffInfo.js 查询员工信息
function queryPage_staff(page) {
    // alert(name+":参数:");
    if (name == 2) {
        name = $("#TextOne").val()
    } else {
        name = "-1"
    }
    $.ajax({
        url: "/staff/getStaff",
        type: "post",
        data: {
            "sName": name,
            "pageNum": page,
            "pageSize": 5
        },
        dataType: "json",
        success: function (msg) {

            $("#TableOne").empty();
            var th = "<tr id=\"North_tr_One\" calss=\"tr\" style='background-color:#969696;'>\n" +
                "            <th class=\"th\">编号</th>\n" +
                "            <th class=\"th\">名称</th>\n" +
                "            <th class=\"th\">年龄</th>\n" +
                "            <th class=\"th\">地址</th>\n" +
                "            <th class=\"th\">电话</th>\n" +
                "            <th class=\"th\">部门</th>\n" +
                "            <th class=\"th\">职位</th>\n" +
                "            <th class=\"th\">薪资</th>\n" +
                "            <th class=\"th\">修改</th>\n" +
                "            <th class=\"th\">删除</th>\n" +
                "        </tr>"
            $("#TableOne").append(th)
            $.each(msg.data.list, function (key, obj) {
                // alert(obj.Staff_Pic);
                var tr = "<tr>";
                tr += " <td class=\"td\">" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.sNo + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.sName + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.age + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.address + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.tel + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    dep[obj.depId] + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    pos[obj.posId] + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span style=\"text-align: center;display:block;\">" +
                    obj.salary + "</span> </td>";

                tr += "\<td class=\"td\" id=\"td_Nine\">" +
                    "<span id=\"Update\" name=\"Update\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"修改\" id=" + obj.sId +
                    " class=\"easyui-linkbutton update getDepPos\" /></span></td>";
                tr += "\<td class=\"td\" id=\"td_Ten\">" +
                    "<span id=\"Delete\" name=\"Delate\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"删除\" id=" + obj.sId + " class=\"delete\"/></span></td>";
                tr += "</tr>";
                $("#TableOne").append(tr);

                $("#total").text(msg.data.total); //总条数
                $("#li_One input").attr("data", 1); //首页
                $("#li_Two input").attr("data", msg.data.prePage); //上一页
                $("#li_Three input").val(msg.data.pageNum); //当前页
                $("#li_Four input").attr("data", msg.data.nextPage); //下一页
                $("#li_Five input").attr("data", msg.data.pages); //尾页
            });

        }
    });
}

// 更改页面
function updatePage(obj) {
    var page = $(obj).attr("data"); //取出data属性值
    queryPage_staff(page, 1);
}

//查询机构信息
$(document).on("click", ".update", function () {
    var sId = this.id;
    $('#w').window('open');
    $.ajax({
        url: "/staff/getStaff",
        type: "post",
        data: {
            "sName": "-1",
            "sId": sId,
            "pageNum": 1,
            "pageSize": 5
        },
        dataType: "json",
        success: function (msg) {
            $("#sId").val(msg.data.list[0].sId);
            $("#sNo").val(msg.data.list[0].sNo);
            $("#sName").val(msg.data.list[0].sName);
            $("#age").val(msg.data.list[0].age);
            $("#address").val(msg.data.list[0].address);
            $("#depId").val(msg.data.list[0].depId);
            $("#posId").val(msg.data.list[0].posId);
            $("#birthday").val(msg.data.list[0].birthday);
            $("#tel").val(msg.data.list[0].tel);
            $("#salary").val(msg.data.list[0].salary);
        }
    });
});

$(document).on("click", ".getDepPos", function () {
    $("#sId").val(0);
});

$(document).on("click", ".getDepPos", function () {
    $.ajax({
        url: "/staff/getDep",
        type: "post",
        dataType: "json",
        success: function (msg) {
            document.getElementById("depId").options.length = 0;
            $.each(msg.data, function (key, obj) {
                var opt = "<option selected=\"selected\" value='" +
                    obj.depId + "' >" +
                    obj.depName + "</option>";
                $("#depId").append(opt);
            });
        }
    });
    $.ajax({
        url: "/staff/getPos",
        type: "post",
        dataType: "json",
        success: function (msg) {
            document.getElementById("posId").options.length = 0;
            $.each(msg.data, function (key, obj) {
                var opt = "<option selected=\"selected\" value='" +
                    obj.posId + "' >" +
                    obj.posName + "</option>";
                $("#posId").append(opt);
            });
        }
    });
});

//更新机构信息
function Update(i) {
    var k=-1
    k=getAge($("#birthday").val());
    if (k != -1&&$("#age").val()!=""&&$("#sNo").val()!=""&&$("#sName").val()!=""
        &&$("#address").val()!=""&&$("#tel").val()!=""&&$("#tel").val("#salary")!="") {
        $("#age").val(getAge($("#birthday").val()));
        var sId = $("#sId").val();
        var sNo = $("#sNo").val();
        var sName = $("#sName").val();
        var age = $("#age").val();
        var address = $("#address").val();
        var birthday = $("#birthday").val();
        var tel = $("#tel").val();
        var depId = $("#depId").val();
        var posId = $("#posId").val();
        var salary = $("#salary").val();
        $.ajax({
            url: "/staff/addStaff",
            type: "post",
            data: {
                "sId": sId,
                "sNo": sNo,
                "sName": sName,
                "age": age,
                "address": address,
                "birthday": birthday,
                "tel": tel,
                "depId": depId,
                "posId": posId,
                "salary": salary
            },
            dataType: "json",
            success: function (msg) {
                alert(msg.message);
                queryPage_staff(1); //刷新当前页面
                $('#w').window('close');
                //updatePage(last);//添加刷新指向尾页
            }
        });
    } else {
        alert("请正确填写信息");
    }
};

//删除机构信息
$(document).on("click", ".delete", function () {
    var sId = this.id;
    if (confirm("您确定要删除此信息吗？")) {
        $.ajax({
            url: "/staff/delStaff",
            type: "post",
            data: {
                "sId": sId
            },
            dataType: "json",
            success: function (msg) {
                alert(msg.message);
                queryPage_staff(1); //刷新当前页面
            }
        });
    } else {
        return false;
    }
});

//选中日期出发事件

//获取年龄
function getAge(str) {
    var r = str.match(/^(\d{1,4})(-)(\d{1,2})\2(\d{1,2})/);
    console.log(r);
    if (r == null) return -1;

    var d = new Date(r[1], r[3] - 1, r[4]);

    var returnStr = -1;

    if (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[3] && d.getDate() == r[4]) {

        var date = new Date();
        var yearNow = date.getFullYear();
        var monthNow = date.getMonth() + 1;
        var dayNow = date.getDate();

        var largeMonths = [1, 3, 5, 7, 8, 10, 12], //大月， 用于计算天，只在年月都为零时，天数有效
            lastMonth = monthNow - 1 > 0 ? monthNow - 1 : 12, // 上一个月的月份
            isLeapYear = false, // 是否是闰年
            daysOFMonth = 0; // 当前日期的上一个月多少天

        if ((yearNow % 4 === 0 && yearNow % 100 !== 0) || yearNow % 400 === 0) { // 是否闰年， 用于计算天，只在年月都为零时，天数有效
            isLeapYear = true;
        }

        if (largeMonths.indexOf(lastMonth) > -1) {
            daysOFMonth = 31;
        } else if (lastMonth === 2) {
            if (isLeapYear) {
                daysOFMonth = 29;
            } else {
                daysOFMonth = 28;
            }
        } else {
            daysOFMonth = 30;
        }

        var Y = yearNow - parseInt(r[1]);
        var M = monthNow - parseInt(r[3]);
        var D = dayNow - parseInt(r[4]);
        if (D < 0) {
            D = D + daysOFMonth; //借一个月
            M--;
        }
        if (M < 0) { // 借一年 12个月
            Y--;
            M = M + 12; //
        }

        if (Y < 0) {
            returnStr = -1;

        } else if (Y === 0) {
            returnStr = 0;
        } else {
            returnStr = Y;
        }

    }

    return returnStr;
}
