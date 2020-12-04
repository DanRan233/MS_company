// 主页请求至新页面方法 index.js
function getPage(title, url) {
    if ($('#tt').tabs('exists', title)) {
        $('#tt').tabs('select', title);
    } else {
        var content = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:102%;height:125%;"></iframe>';
        $('#tt').tabs('add', {
            title: title,
            content: content,
            closable: true
        });
    }
}

// 清空模态窗口 ，多页面公用
function cleanWindow() {
    $(".tr_two input").val("");
};


