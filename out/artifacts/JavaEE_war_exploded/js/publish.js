var publish = document.getElementById("publish");
publish.onsubmit = function () {
    //判断输入框是否为空
    var topic = document.getElementById("topic").value;
    var content = document.getElementById("content").value;
    if(topic==null||topic=="") {
        alert("主题不能为空！");
        return;
    }
    if(content==null||content=="") {
        alert("内容不能为空！");
        return;
    }
    return true;
}