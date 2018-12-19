
app.controller("goodsController", function ($scope, $http) {
    
    // 提交保存
    $scope.saveGoods = function () {
        $http({
            method : "post",
            url : getRootPath()+"/goods/addGoods",
            transformRequest : function(obj) {
                var str = [];
                for(var p in obj){
                    if(obj[p] != undefined){
                        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                    }
                }
                return str.join("&");
            },
            data : $scope.entity,
            headers : {
                "Content-Type" : "application/x-www-form-urlencoded;charset=UTF-8"
            }
        }).success(function (resp) {
            if(resp.error){
                alert(resp.message);
            }else{
                window.location.href = getRootPath()+"/shoplogin.html";
            }
        })
    }
});