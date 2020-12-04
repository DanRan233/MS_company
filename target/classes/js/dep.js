$(function () {
    QueryDepartment(1, 1);
});

function QueryDepartment(page) {
    name = $("#TextOne").val()
    $.ajax({
        url: "/staff/getDepPage",
        type: "post",
        data: {
            "depName": name,
            "pageNum": page,
            "pageSize": 5
        },
        dataType: "json",
        success: function (msg) {

            $("#TableOne").empty();
            var th = "<tr id=\"North_tr_One\" calss=\"tr\" style='background-color:#969696;'>\n" +
                "            <th id=\"North_th-Two\" class=\"th\">编号</th>\n" +
                "            <th id=\"North_th-Three\" class=\"th\">全称</th>\n" +
                "            <th id=\"North_th-Nine\" class=\"th\">修改</th>\n" +
                "            <th id=\"North_th-Ten\" class=\"th\">删除</th>\n" +
                "        </tr>"
            $("#TableOne").append(th)
            $.each(msg.data.list, function (key, obj) {
                var tr = "<tr>";
                tr += " <td class=\"td\">" +
                    "<span id=\"Staff_Code\" name=\"Staff_Code\"style=\"text-align: center;display:block;\">" +
                    obj.depNo + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span id=\"Staff_No\" name=\"Staff_No\"style=\"text-align: center;display:block;\">" +
                    obj.depName + "</span> </td>";
                tr += "\<td class=\"td\" id=\"td_Nine\">" +
                    "<span id=\"Update\" name=\"Update\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"修改\" id=" + obj.depId + " class=\"easyui-linkbutton update\" /></span></td>";
                tr += "\<td class=\"td\" id=\"td_Ten\">" +
                    "<span id=\"Delete\" name=\"Delate\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"删除\" id=" + obj.depId + " class=\"delete\"/></span></td>";
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

//改变页面
function changePage(obj) {
    var page = $(obj).attr("data"); //取出data属性值
    QueryDepartment(page);
}

//查询部门信息
$(document).on("click", ".update", function () {
    var depcId = this.id;
    $("#depId").val(depcId);
    $('#w').window('open');
    $.ajax({
        url: "/staff/getDep",
        type: "post",
        data: {
            "depId": depcId,
            "depName": "-1"
        },
        dataType: "json",
        success: function (msg) {
            $("#depId").val(msg.data[0].depId);
            $("#depNo").val(msg.data[0].depNo);
            $("#depName").val(msg.data[0].depName);
        }
    });
});

$(document).on("click", ".setDepId", function () {
    $("#depId").val(0);
});

function Update() {
    var depdId = $("#depId").val();
    var depNo = $("#depNo").val();
    var depName = $("#depName").val();
    $.ajax({
        url: "/staff/addDep",
        type: "post",
        data: {
            "depId": depdId,
            "depNo": depNo,
            "depName": depName
        },
        dataType: "json",
        success: function (msg) {
            alert(msg.message);
            QueryDepartment(1); //刷新当前页面
            $('#w').window('close');
            //changePage(last);//添加刷新指向尾页
        }
    });
};

//删除机构信息
$(document).on("click", ".delete", function () {
    var depId = this.id;
    if (confirm("您确定要删除此信息吗？")) {
        $.ajax({
            url: "/staff/delDep",
            type: "post",
            data: {
                "depId": depId
            },
            dataType: "json",
            success: function (msg) {
                alert(msg.message);
                QueryDepartment(1); //刷新当前页面
            }
        });
    } else {
        return false;
    }
});