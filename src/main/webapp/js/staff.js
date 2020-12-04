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
            var th = "<tr id=\"North_tr_One\" calss=\"tr\" style='background-color:#31b0d5;'>\n" +
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
