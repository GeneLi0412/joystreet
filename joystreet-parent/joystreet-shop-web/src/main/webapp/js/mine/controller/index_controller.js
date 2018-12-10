
app.controller("indexController", function ($scope, $http, $controller) {

    $controller("baseController", {$scope : $scope});

    // 查询登录用户名
    $scope.showName = function () {
        $http({
            method : "post",
            url : getRootPath()+"/login/name",
            headers : {
                "Content-Type" : "application/x-www-form-urlencoded;charset=UTF-8"
            }
        }).success(function (resp) {
            if(resp.error){
                alert(resp.message);
            }else{
                $scope.username = resp.data;
            }
        })
    }
});
