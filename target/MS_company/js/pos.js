$(function () {
    QueryPosition(1);
});

function QueryPosition(page) {
    if (name == 2) {
        name = $("#TextOne").val()
    } else {
        name = "-1"
    }
    $.ajax({
        url: "/staff/getPosPage",
        type: "post",
        data: {
            "posName": name,
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
                    obj.posNo + "</span> </td>";
                tr += " <td class=\"td\" >" +
                    "<span id=\"Staff_No\" name=\"Staff_No\"style=\"text-align: center;display:block;\">" +
                    obj.posName + "</span> </td>";
                tr += "\<td class=\"td\" id=\"td_Nine\">" +
                    "<span id=\"Update\" name=\"Update\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"修改\" id=" + obj.posId + " class=\"easyui-linkbutton update\" /></span></td>";
                tr += "\<td class=\"td\" id=\"td_Ten\">" +
                    "<span id=\"Delete\" name=\"Delate\"style =\"text-align: center;display:block;\">" +
                    "<input type=\"button\"value =\"删除\" id=" + obj.posId  + " class=\"delete\"/></span></td>";
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
    QueryPosition(page);
}

//查询部门信息
$(document).on("click", ".update", function () {
    var poscId = this.id;
    $("#posId").val(poscId);
    $('#w').window('open');
    $.ajax({
        url: "/staff/getPos",
        type: "post",
        data: {
            "posId": poscId,
            "posName":"-1"
        },
        dataType: "json",
        success: function (msg) {
            $("#posId").val(msg.data[0].posId);
            $("#posNo").val(msg.data[0].posNo);
            $("#posName").val(msg.data[0].posName);
        }
    });
});

$(document).on("click", ".setPosId", function () {
    $("#posId").val(0);
});

function Update() {
    var posdId = $("#posId").val();
    var possNo = $("#posNo").val();
    var possName = $("#posName").val();
    $.ajax({
        url: "/staff/addPos",
        type: "post",
        data: {
            "posId":posdId,
            "posNo": possNo,
            "posName": possName
        },
        dataType: "json",
        success: function (msg) {
            alert(msg.message);
            QueryPosition(1); //刷新当前页面
            $('#w').window('close');
            //changePage(last);//添加刷新指向尾页
        }
    });
};

//删除机构信息
$(document).on("click", ".delete", function () {
    var posId = this.id;
    if (confirm("您确定要删除此信息吗？")) {
        $.ajax({
            url: "/staff/delPos",
            type: "post",
            data: {
                "posId": posId
            },
            dataType: "json",
            success: function (msg) {
                alert(msg.message);
                QueryPosition(1); //刷新当前页面
            }
        });
    } else {
        return false;
    }
});