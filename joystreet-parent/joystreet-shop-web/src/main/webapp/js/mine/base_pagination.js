// 获取项目根路径
function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var fullUrl=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=fullUrl.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=fullUrl.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}

// 普通模块
var app = angular.module("joystreet",["pagination"]);